package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RestuarantApi {

    @GET("resturants ")
    Call<List<Restuarant>> getrest (@Header("Authorization")String token);





}
