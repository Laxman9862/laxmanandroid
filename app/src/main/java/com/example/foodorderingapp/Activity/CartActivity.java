package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.CartAdapater;
import com.example.foodorderingapp.Interface.CartApi;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.foodorderingapp.Activity.DashboardActivity.globaluser;

public class CartActivity extends AppCompatActivity {

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

        CartApi cartApi = Url.getInstance().create(CartApi.class);
        Call<List<Cart>> foodcall = cartApi.usercart(Url.token);

        foodcall.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(CartActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                cart = response.body();
                CartAdapater cartAdapater =  new CartAdapater(CartActivity.this, cart);
                rv.setAdapter(cartAdapater);
                rv.setLayoutManager(new LinearLayoutManager(CartActivity.this));
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {

            }
        });




    }

    private  void addtocart(){

        String foodid = id;
        String userid = globaluser.getId();
        int qty = 1;

        Cart cart = new Cart(foodid, userid, qty);
        CartApi cartApi = Url.getInstance().create(CartApi.class);
        Call<Cart> cartCall = cartApi.addcart(Url.token,cart);

        cartCall.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(CartActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(CartActivity.this,"  Add to Cart  Succesfully",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });











    }
}
