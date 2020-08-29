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

import com.example.foodorderingapp.Activity.ViewResturantFoodActivity;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AvailableResturantAdapter extends RecyclerView.Adapter<AvailableResturantAdapter.AvailableResturantViewHolder> {
    Context mcontext;
    List<Restuarant> lstres;

    public AvailableResturantAdapter(Context mcontext,List<Restuarant> lstres){
        this.mcontext= mcontext;
        this.lstres= lstres;
    }


    @NonNull
    @Override
    public AvailableResturantAdapter.AvailableResturantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.resturant,parent,false);
        return new AvailableResturantAdapter.AvailableResturantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableResturantViewHolder holder, int position) {
        Restuarant res = lstres.get(position);

        String imagepath = Url.BASE_URL +"uploads/" + lstres.get(position).getRes_image();
        String re8sname = lstres.get(position).getResturant_name();
        StrictModeClass.StrictMode();


        try {
            URL url=new URL(imagepath);
            holder.resimage.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));


        } catch (Exception e) {

        }

        holder.txtname.setText(re8sname);
        holder.txtname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(mcontext, ViewResturantFoodActivity.class);
                mcontext.startActivity(i);
            }
        });

    }



    @Override
    public int getItemCount() {
        return lstres.size();
    }

    public class AvailableResturantViewHolder extends RecyclerView.ViewHolder{
        ImageView resimage;
        TextView txtname,txtaddress,txtinfo,txtstatus;

        public AvailableResturantViewHolder(@NonNull View itemView) {
            super(itemView);
;

        }
    }
}
