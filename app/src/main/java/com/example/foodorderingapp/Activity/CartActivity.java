package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingapp.Adapater.CartAdapater;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    RecyclerView rv;
    public static List<Cart> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);
         rv = findViewById(R.id.recycler_vieworder);

         getcart();
    }

    private void getcart() {

        CartAdapater cartAdapater =  new CartAdapater(CartActivity.this, cart);
        rv.setAdapter(cartAdapater);
        rv.setLayoutManager(new LinearLayoutManager(CartActivity.this));

    }
}
