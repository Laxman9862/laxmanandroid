package com.example.foodorderingapp.BLL;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Adapater.HotDealsAdapater;
import com.example.foodorderingapp.Interface.FoodApi;
import com.example.foodorderingapp.Interface.OrderApi;
import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.ServerResponse.UserResponse;
import com.example.foodorderingapp.URL.Url;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.foodorderingapp.Activity.DashboardActivity.lstdeals;

public class FoodBLL {
    boolean isSuccess = false;

    public boolean food(String user, String fod, String quanity, String totprice) {

        Cart cart = new Cart(user, fod, quanity, totprice);

        OrderApi orderApi = Url.getInstance().create(OrderApi.class);
        Call<Cart> usersCall = orderApi.addcart(Url.token, cart);

        try {
            Response<Cart> signupResponse = usersCall.execute();
            if (signupResponse.isSuccessful() &&
                    signupResponse.body().equals("Order Successfully")) {


                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;


    }
}





