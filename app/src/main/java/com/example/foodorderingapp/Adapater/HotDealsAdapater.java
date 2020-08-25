package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.HotDeals;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class HotDealsAdapater extends  RecyclerView.Adapter<HotDealsAdapater.PopularCategoryViewHolder> {

    Context mContext;
    List<Food> lstpopcategory;

    public HotDealsAdapater(Context mContext, List<Food>lstpopcategory)
    {
        this.mContext = mContext;
        this.lstpopcategory = lstpopcategory;
    }



    @NonNull
    @Override
    public PopularCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hot_deals,parent,false);
        return new PopularCategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularCategoryViewHolder holder, int position) {
        Food food = lstpopcategory.get(position);

        String imagepath = Url.BASE_URL+ "uploads/" + lstpopcategory.get(position).getFoodimage();
        StrictModeClass.StrictMode();
        try {
            URL url=new URL(imagepath);
            holder.image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }


    }



    @Override
    public int getItemCount() {
        return lstpopcategory.size();
    }

    public class PopularCategoryViewHolder extends RecyclerView.ViewHolder
    {
       ImageView image;


        public PopularCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.hot_dealsimg);

        }
    }

}
