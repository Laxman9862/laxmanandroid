package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface CartApi {

    @GET("cart")
    Call<List<Cart>> usercart (@Header("Authorization")String token);
    @POST("cart")
    Call<Cart> addcart (@Header("Authorization")String token, @Body Cart cart);
}
