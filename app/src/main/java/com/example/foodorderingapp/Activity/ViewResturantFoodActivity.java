package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.RestaurantFoodAdapter;
import com.example.foodorderingapp.Interface.FoodApi;
import com.example.foodorderingapp.Interface.RestuarantApi;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewResturantFoodActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Food> lstresfood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_fooddetails);


       rv = findViewById(R.id.food_recyclerview);

        ActionBar name = getSupportActionBar();

        Bundle bundle = getIntent().getExtras();

        String resname = bundle.getString("resname");

        if(bundle!=null){

            name.setTitle(resname);
        }




      //foodlist = new ArrayList<>();


        getResfood();

    }

    private void getResfood() {










       FoodApi foodApi = Url.getInstance().create(FoodApi.class);
       Call<List<Food>> foodcall = foodApi.getfood();


       foodcall.enqueue(new Callback<List<Food>>() {
           @Override
           public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
               if (!response.isSuccessful()) {
                   Toast.makeText(ViewResturantFoodActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                   return;
               }
               lstresfood = response.body();

               RestaurantFoodAdapter foodAdapter = new RestaurantFoodAdapter(ViewResturantFoodActivity.this, lstresfood);
               rv.setAdapter(foodAdapter);
               rv.setLayoutManager(new LinearLayoutManager(ViewResturantFoodActivity.this));
           }

           @Override
           public void onFailure(Call<List<Food>> call, Throwable t) {

           }
       });



    }
}












