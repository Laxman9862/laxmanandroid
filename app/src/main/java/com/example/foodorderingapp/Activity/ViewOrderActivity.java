package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.CartAdapater;
import com.example.foodorderingapp.Interface.OrderApi;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewOrderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView txtfood, txtprice;
    Button btndelete;

    List<Cart> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        recyclerView = findViewById(R.id.recycler_vieworder);
        txtfood = findViewById(R.id.restfoodname);
        txtprice = findViewById(R.id.restfoodprice);
        btndelete = findViewById(R.id.btndelete);






        vieworderfood();
    }

    private void vieworderfood() {
        OrderApi orderApi = Url.getInstance().create(OrderApi.class);
        Call<Cart> list = orderApi.getusercart(Url.token);

        list.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ViewOrderActivity.this, "error" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }


               String food = response.body().getFood();
                String price = response.body().getTotalprice();

                txtfood.setText(food);
                txtprice.setText(price);

            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });

    }

}

