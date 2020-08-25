package com.example.foodorderingapp.Activity;

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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewResturantFoodActivity extends AppCompatActivity {

    RecyclerView rv;
    public static List<Food> lstresfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_resturant_food);


        rv = findViewById(R.id.recycler_resturantfood);


 lstresfood = new ArrayList<>();


        getResfood();

    }

    private void getResfood() {


        Bundle bundle = getIntent().getExtras();
        String resid = bundle.getString("id");
        Toast.makeText(this, "id:" + resid, Toast.LENGTH_SHORT).show();


        FoodApi restuarantApi = Url.getInstance().create(FoodApi.class);
       Call<List<Food>> resfoodcall = restuarantApi.getcategory(Url.token);



       resfoodcall.enqueue(new Callback<List<Food>>() {
           @Override
           public void onResponse(Call <List<Food>> call, Response<List<Food>>response) {
               if (!response.isSuccessful()) {
                   Toast.makeText(ViewResturantFoodActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                   return;
               }
               lstresfood = response.body();

               RestaurantFoodAdapter foodAdapter = new RestaurantFoodAdapter(ViewResturantFoodActivity.this,lstresfood);
               rv.setAdapter(foodAdapter);
               rv.setLayoutManager(new LinearLayoutManager(ViewResturantFoodActivity.this));


           }

           @Override
           public void onFailure(Call<List<Food>> call, Throwable t) {

           }
       });
    }
}












