package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingapp.Adapater.RestaurantFoodAdapter;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;

import java.util.ArrayList;
import java.util.List;

public class FooddetailsActivity extends AppCompatActivity {


    RecyclerView recyclerView;

   List<Food> lstfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetails);
        recyclerView = findViewById(R.id.food_recyclerview);


        lstfood = new ArrayList<>();




        RestaurantFoodAdapter resfoodadapter = new RestaurantFoodAdapter(FooddetailsActivity.this,lstfood);
        recyclerView.setAdapter(resfoodadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }
}
