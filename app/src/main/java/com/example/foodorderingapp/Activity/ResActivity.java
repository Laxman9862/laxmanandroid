package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.AvailableResturantAdapter;
import com.example.foodorderingapp.Interface.RestuarantApi;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.foodorderingapp.Activity.DashboardActivity.lstres;

public class ResActivity extends AppCompatActivity {

     private  List<Restuarant> restuarantListList = new ArrayList<>();
    RecyclerView recyclerView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturantall);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Resturant");
        recyclerView = findViewById(R.id.recyclerallres);

        RestuarantApi restuarantApi = Url.getInstance().create(RestuarantApi.class);
        Call<List<Restuarant>> restuarantCall = restuarantApi.getrest(Url.token);


        restuarantCall.enqueue(new Callback<List<Restuarant>>() {


            @Override

            public void onResponse(Call<List<Restuarant>> call, Response<List<Restuarant>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ResActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                restuarantListList = response.body();
                AvailableResturantAdapter availableResturantAdapter = new AvailableResturantAdapter(ResActivity.this, restuarantListList);
                recyclerView.setAdapter(availableResturantAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ResActivity.this));


            }

            @Override
            public void onFailure(Call<List<Restuarant>> call, Throwable t) {


            }
        });

    }
}






