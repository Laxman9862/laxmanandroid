package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.AllResturantAdapter;
import com.example.foodorderingapp.Interface.RestuarantApi;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewResturantActitvity extends AppCompatActivity {

    RecyclerView recyclerView;
    public SensorManager sensorManager;

    public static List<Restuarant> listres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_resturant_actitvity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Resturant");


        recyclerView = findViewById(R.id.recycler_viewallresturant);



        getRest();
        lightsensor();


    }

    private void lightsensor() {
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor sensor= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        SensorEventListener sensorEventListener= new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if( event.sensor.getType() == Sensor.TYPE_LIGHT) {
                    Toast.makeText(getApplicationContext(), "On SensorChanged" + event.values[0], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    private void getRest(){
        RestuarantApi restuarantApi = Url.getInstance().create(RestuarantApi.class);
        Call<List<Restuarant>> restuarantCall = restuarantApi.getrest(Url.token);


        restuarantCall.enqueue(new Callback<List<Restuarant>>() {
            @Override
            public void onResponse(Call<List<Restuarant>> call, Response<List<Restuarant>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ViewResturantActitvity.this,"Error"+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                listres = response.body();


                AllResturantAdapter restuarantAdapater = new AllResturantAdapter(ViewResturantActitvity.this, listres);
                recyclerView.setAdapter(restuarantAdapater);
                recyclerView.setLayoutManager(new LinearLayoutManager(ViewResturantActitvity.this));
            }
            @Override
            public void onFailure(Call<List<Restuarant>> call, Throwable t) {

                Toast.makeText(ViewResturantActitvity.this, "Error" + t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}
