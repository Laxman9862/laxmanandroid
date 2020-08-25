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
import com.example.foodorderingapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExplorefoodAdapater extends RecyclerView.Adapter<ExplorefoodAdapater.ExplorefoodAdapaterViewHolder> {

    Context mcontext;
    List<ExploreFood> lstexfood;

    public ExplorefoodAdapater(Context mcontext,List<ExploreFood> lstexfood){
        this.mcontext=mcontext;
        this.lstexfood=lstexfood;
    }

    @NonNull
    @Override
    public ExplorefoodAdapaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mcontext).inflate(R.layout.explorefood,parent,false);
       return new ExplorefoodAdapaterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExplorefoodAdapaterViewHolder holder, int position) {

        ExploreFood ep = lstexfood.get(position);
        holder.imgfood.setImageResource(ep.getImage());
        holder.name.setText(ep.getName());


    }

    @Override
    public int getItemCount() {
        return lstexfood.size();
    }

    public  class ExplorefoodAdapaterViewHolder  extends RecyclerView.ViewHolder{
         public ImageView imgfood;
         public TextView name;

        public ExplorefoodAdapaterViewHolder(@NonNull View itemView) {
            super(itemView);
            imgfood = itemView.findViewById(R.id.pop_img);
            name = itemView.findViewById(R.id.pop_name);

        }
    }
}
