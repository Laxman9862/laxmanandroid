package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface FoodApi {

    @GET("foods")
    Call<List<Food>> getcategory (@Header("Authorization")String token);
}
