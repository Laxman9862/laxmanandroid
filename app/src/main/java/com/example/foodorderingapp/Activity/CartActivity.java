package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {


            RecyclerView recyclerView;

    public static List<Cart> cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);





        recyclerView = findViewById(R.id.recycler_vieworder);






        vieworderfood();
    }

    private void vieworderfood() {

            }



    }



