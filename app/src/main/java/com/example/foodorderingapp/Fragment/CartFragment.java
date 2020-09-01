package com.example.foodorderingapp.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class CartFragment extends Fragment {

    TextView txtname,txtprice;
    Button btndelete;
    List<Cart> lstcart;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        txtname =  v.findViewById(R.id.txtfood);
        txtprice = v.findViewById(R.id.txtprice);
        btndelete = v.findViewById(R.id.btndelete);


        loadorder();

        return  v;


    }

    private void loadorder() {
        OrderApi orderApi = Url.getInstance().create(OrderApi.class);
        Call<Cart> cartCall = orderApi.getusercart(Url.token);

           cartCall.enqueue(new Callback<Cart>() {
               @Override
               public void onResponse(Call<Cart> call, Response<Cart> response) {
                   if(!response.isSuccessful()){
                       Toast.makeText(getContext(), "error" + response.code(), Toast.LENGTH_LONG).show();
                       return;
                   }


                   CartAdapater cartAdapater = new CartAdapater(getContext(), lstcart);
                  recyclerView.setAdapter(cartAdapater);
                  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
               }

               @Override
               public void onFailure(Call<Cart> call, Throwable t) {

               }
           });

        }

}
