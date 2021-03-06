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

import com.example.foodorderingapp.Model.Food;
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
        View v = LayoutInflater.from(mcontext).inflate(R.layout.explorefood,parent,false);
        return new FoodViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewholder holder, int position) {
        Food food = lstfood.get(position);
        holder.txtrest_name.setText("KFC");




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
           // foodimg = itemView.findViewById(R.id.food_img);
           // txtrest_name = itemView.findViewById(R.id.rest_name);
           // txtrest_address = itemView.findViewById(R.id.rest_address);
           // txtrest_info = itemView.findViewById(R.id.rest_info);
            //txtrest_status = itemView.findViewById(R.id.rest_status);
        }
    }

}
