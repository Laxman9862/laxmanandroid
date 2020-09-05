package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.R;

import java.util.List;

public class CartAdapater extends RecyclerView.Adapter<CartAdapater.FoodViewholder> {

    Context mcontext;
    List<Cart> lstcart;


    public CartAdapater(Context mcontext, List<Cart> lstcart)
    {
        this.mcontext=mcontext;
        this.lstcart=lstcart;
    }



    @NonNull
    @Override
    public FoodViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.activity_view_order,parent,false);
        return new FoodViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewholder holder, int position) {
        Cart cart = lstcart.get(position);
        //holder.txtfoodname.setText(cart.getFood().f);




    }

    @Override
    public int getItemCount() {
        return lstcart.size();
    }

    public class FoodViewholder extends RecyclerView.ViewHolder {

        ImageView foodimg;
        TextView txtfoodname,txtprice;

        public FoodViewholder(@NonNull View itemView) {
            super(itemView);
            foodimg = itemView.findViewById(R.id.restfoodimage);
            txtfoodname = itemView.findViewById(R.id.restfoodname);
            txtprice = itemView.findViewById(R.id.restfoodprice);
           // txtrest_name = itemView.findViewById(R.id.rest_name);
           // txtrest_address = itemView.findViewById(R.id.rest_address);
           // txtrest_info = itemView.findViewById(R.id.rest_info);
            //txtrest_status = itemView.findViewById(R.id.rest_status);
        }
    }

}
