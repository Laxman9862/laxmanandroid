package com.example.foodorderingapp.Fragment;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.Activity.ResActivity;
import com.example.foodorderingapp.Activity.ViewResturantActitvity;
import com.example.foodorderingapp.Adapater.ExplorefoodAdapater;
import com.example.foodorderingapp.Adapater.HotDealsAdapater;
import com.example.foodorderingapp.Adapater.NewRestaurantAdapter;
import com.example.foodorderingapp.Adapater.PopularAdapater;
import com.example.foodorderingapp.Interface.FoodApi;
import com.example.foodorderingapp.Interface.RestuarantApi;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.SENSOR_SERVICE;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstdeals;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstexfood;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstpop;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstres;

public class HomeFragment extends Fragment implements SensorEventListener {

    private RecyclerView recyclerView,rv,recyclerView_res,rv_popular;

    private TextView txtviewresturant;

    private ImageView cartimage;

    SensorManager sensorManager;

    Sensor sensor;

     private Button resbutton;

   // private Button btnviewresturant;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        resbutton =  v.findViewById(R.id.allresturants);

        resbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResActivity.class);
                startActivity(intent);
            }
        });







       // recyclerView = v.findViewById(R.id.popular_recyclerview);
        rv = v.findViewById(R.id.popular_recyclerview_hotdeals);
        recyclerView_res = v.findViewById(R.id.recycler_restuarant);
        rv_popular = v.findViewById(R.id.recycler_populattoday);
        //cartimage = v.findViewById(R.id.cartlist);

        getCategory();








        PopularAdapater popularAdapater = new PopularAdapater(getContext(),lstpop);
        rv_popular.setAdapter(popularAdapater);
        rv_popular.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));





        getRestuarant();








        return  v;


    }






    private void getCategory(){

        FoodApi foodApi = Url.getInstance().create(FoodApi.class);
        Call<List<Food>> foodCall = foodApi.getfood();

          foodCall.enqueue(new Callback<List<Food>>() {
              @Override
              public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                  if(!response.isSuccessful()){
                      Toast.makeText(getContext(),"Error"+response.code(),Toast.LENGTH_SHORT).show();
                  }
                  lstdeals = response.body();

                  HotDealsAdapater hotDealsAdapater = new HotDealsAdapater(getContext(),lstdeals);
                  rv.setAdapter(hotDealsAdapater);
                  rv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

              }

              @Override
              public void onFailure(Call<List<Food>> call, Throwable t) {

                  Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();

              }
          });
    }

    private void getRestuarant()
    {
        RestuarantApi restuarantApi = Url.getInstance().create(RestuarantApi.class);
        Call<List<Restuarant>> restuarantCall = restuarantApi.getrest(Url.token);


        restuarantCall.enqueue(new Callback<List<Restuarant>>() {
            @Override
            public void onResponse(Call<List<Restuarant>> call, Response<List<Restuarant>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(),"Error"+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                lstres = response.body();



                NewRestaurantAdapter restaurantAdapter = new NewRestaurantAdapter(getContext(),lstres);
                recyclerView_res.setAdapter(restaurantAdapter);
                recyclerView_res.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));




            }

            @Override
            public void onFailure(Call<List<Restuarant>> call, Throwable t) {
                Toast.makeText(getContext(),"Error" + t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
