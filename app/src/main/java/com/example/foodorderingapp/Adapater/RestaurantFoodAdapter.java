package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class RestaurantFoodAdapter extends  RecyclerView.Adapter<RestaurantFoodAdapter.RestaurantFoodViewHolder> {

    Context mcontext;
    List<Food> lstres;

    public RestaurantFoodAdapter(Context  mcontext, List<Food> lstres){

        this.mcontext= mcontext;
        this.lstres = lstres;
    }



    @NonNull
    @Override
    public RestaurantFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mcontext).inflate(R.layout.resturantfood,parent,false);
        return new RestaurantFoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantFoodViewHolder holder, int position) {

        final Food res = lstres.get(position);
         String imagepath = Url.BASE_URL + "uploads/" + lstres.get(position).getFoodimage();
        StrictModeClass.StrictMode();
        try {
          URL url = new URL(imagepath);
           holder.restfoodimg.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
           holder.txtrestfoodname.setText(res.getFoodname());
           holder.txtrestfoodprice.setText(res.getPrice());

        } catch (Exception e) {

            e.printStackTrace();
        }



        holder.txtrestfoodname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }



    @Override
    public int getItemCount() {
         return lstres.size();
    }

    public class RestaurantFoodViewHolder extends RecyclerView.ViewHolder {

        ImageView restfoodimg;
        TextView txtrestfoodname,txtrestfoodprice;
        public RestaurantFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            restfoodimg = itemView.findViewById(R.id.restfoodimage);
            txtrestfoodname = itemView.findViewById(R.id.restfoodname);
            txtrestfoodprice = itemView.findViewById(R.id.restfoodprice);
        }
    }
}
