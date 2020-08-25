package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Activity.FooddetailsActivity;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;

import java.util.List;

public class FoodAdapater extends RecyclerView.Adapter<FoodAdapater.FoodViewholder> {

    Context mcontext;
    List<Food> lstfood;


    public FoodAdapater(Context mcontext, List<Food> lstfood)
    {
        this.mcontext=mcontext;
        this.lstfood=lstfood;
    }



    @NonNull
    @Override
    public FoodViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.foodavailable,parent,false);
        return new FoodViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewholder holder, int position) {
        Food food = lstfood.get(position);
        holder.txtrest_name.setText("KFC");



        holder.txtrest_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, FooddetailsActivity.class);
                v.getContext().startActivity(new Intent(v.getContext(), FooddetailsActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstfood.size();
    }

    public class FoodViewholder extends RecyclerView.ViewHolder {

        ImageView foodimg;
        TextView txtrest_name,txtrest_address,txtrest_info,txtrest_status;

        public FoodViewholder(@NonNull View itemView) {
            super(itemView);
            foodimg = itemView.findViewById(R.id.food_img);
            txtrest_name = itemView.findViewById(R.id.rest_name);
            txtrest_address = itemView.findViewById(R.id.rest_address);
            txtrest_info = itemView.findViewById(R.id.rest_info);
            txtrest_status = itemView.findViewById(R.id.rest_status);
        }
    }

}
