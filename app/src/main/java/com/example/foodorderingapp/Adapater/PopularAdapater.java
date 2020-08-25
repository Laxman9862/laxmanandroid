package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.ExploreFood;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;

import java.util.List;

public class PopularAdapater extends RecyclerView.Adapter<PopularAdapater.PopularViewHolder> {

    Context mcontext;
    List<ExploreFood> lstpop;

    public PopularAdapater(Context mcontext,List<ExploreFood> lstpop){
        this.mcontext=mcontext;
        this.lstpop=lstpop;
    }


    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.popular,parent,false);
        return new PopularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

       ExploreFood res = lstpop.get(position);
        holder.imgpop.setImageResource(res.getImage());
        //holder.txtpop.setText(res.getName());

    }

    @Override
    public int getItemCount() {
        return lstpop .size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder{

        ImageView imgpop;
        //TextView txtpop;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imgpop =itemView.findViewById(R.id.popular_img);
            //txtpop = itemView.findViewById(R.id.popular_name);
        }
    }

}
