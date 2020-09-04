package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.RestaurantFoodAdapter;
import com.example.foodorderingapp.Interface.CartApi;
import com.example.foodorderingapp.Interface.FoodApi;
import com.example.foodorderingapp.Interface.RestuarantApi;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.Model.User;
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

import static com.example.foodorderingapp.Activity.DashboardActivity.globaluser;

public class ViewResturantFoodActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Food> lstresfood;
    TextView txtfoodname, txtprice;
    Button add;
    ImageView foodimage;
     String foodid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetails);


        rv = findViewById(R.id.food_recyclerview);
        ActionBar name = getSupportActionBar();

        getResfood();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("foodid"));



        addtocart();



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

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            foodid = intent.getStringExtra("foodid");
            //Toast.makeText(ViewResturantFoodActivity.this, "id:" + id, Toast.LENGTH_LONG).show();
        }
    };
    private void addtocart() {


        String uid = globaluser.getId();
        int quanity = 1;

        Cart cart =  new Cart(uid, foodid, quanity);
        CartApi cartApi = Url.getInstance().create(CartApi.class);
        Call<Cart> cartCall =  cartApi.addcart(Url.token, cart);

        cartCall.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ViewResturantFoodActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(ViewResturantFoodActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Toast.makeText(ViewResturantFoodActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }




}













