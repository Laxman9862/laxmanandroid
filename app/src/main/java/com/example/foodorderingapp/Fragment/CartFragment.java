package com.example.foodorderingapp.Fragment;

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

import com.example.foodorderingapp.Adapater.OrderAdapater;
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

               }




}
