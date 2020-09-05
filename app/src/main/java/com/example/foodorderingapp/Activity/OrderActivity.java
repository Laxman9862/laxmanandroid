package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.OrderAdapater;
import com.example.foodorderingapp.Interface.OrderApi;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {

    RecyclerView rv;
    public static List<Cart> cart;



    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);
         rv = findViewById(R.id.recycler_vieworder);


        Bundle bundle = getIntent().getExtras();
         //String foodid = bundle.getString("foodid");



        if(bundle != null) {
         id = bundle.getString("foodid");
        }








         getcart();




    }

    private void getcart() {

        OrderApi orderApi = Url.getInstance().create(OrderApi.class);
        Call<List<Cart>> foodcall = orderApi.usercart(Url.token);

        foodcall.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(OrderActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                cart = response.body();
                OrderAdapater orderAdapater =  new OrderAdapater(OrderActivity.this, cart);
                rv.setAdapter(orderAdapater);
                rv.setLayoutManager(new LinearLayoutManager(OrderActivity.this));
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {

            }
        });




    }

    private  void addtocart(){













    }
}
