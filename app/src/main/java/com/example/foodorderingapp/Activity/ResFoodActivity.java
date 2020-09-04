package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodorderingapp.R;

import static com.example.foodorderingapp.Activity.DashboardActivity.globaluser;

public class ResFoodActivity extends AppCompatActivity {

    ImageView selectitem_image;
    TextView foodname,no_of_item,totalprice;
    Button btnincrement,btndecrement,btnaddcart;
    public static float price =120;

    public static int counter = 1;
    public static int c2 = 1;



    public String userid = globaluser.getId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Now");


    }
}
