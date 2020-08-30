 package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.Interface.OrderApi;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;
import static com.example.foodorderingapp.Activity.DashboardActivity.globaluser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class OrderActivity extends AppCompatActivity {

    ImageView selectitem_image;
    TextView txtdesc,no_of_item,totalprice;
    Button btnincrement,btndecrement,btnaddcart;
     public static float price =120;

    public static int counter = 1;
    public static int c2 = 1;

     public String foodid  = "";
    public  String foodname = "";

    public String userid = globaluser.getId();



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Now");

        Bundle bundle = getIntent().getExtras();
         foodid = bundle.getString("foodid");
         foodname = bundle.getString("foodname");


           //Toast.makeText(OrderActivity.this,"fid"+foodid,Toast.LENGTH_LONG).show();









        selectitem_image = findViewById(R.id.selfoodimg);
        txtdesc = findViewById(R.id.description);
        no_of_item = findViewById(R.id.no_of_items);
        totalprice = findViewById(R.id.totatcost);
        btnincrement = findViewById(R.id.increment);
        btndecrement = findViewById(R.id.decrement);
        btnaddcart = findViewById(R.id.cartbutton);

        btnincrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(OrderActivity.this,"Cliked",Toast.LENGTH_SHORT).show();

                if(counter > 0 )
                {
                    counter++;

                    price = price * counter;

                    Toast.makeText(OrderActivity.this,"Price:"+price,Toast.LENGTH_SHORT).show();

                    String count = Integer.toString(counter);

                    no_of_item.setText(count);

                    String totalcost = Float.toString(price);
                    totalprice.setText(totalcost);

                }




            }
        });

        btndecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter > 1)
                {
                    counter--;
                    price = price  - (price * counter);

                    String c1 = Integer.toString(counter);
                    no_of_item.setText(c1);

                    String costreduce = Float.toString(price);
                    totalprice.setText(costreduce);

                }



            }
        });

        btnaddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtocart();
            }
        });
    }



    private void addtocart() {
         Toast.makeText(OrderActivity.this,"fid"+foodid,Toast.LENGTH_LONG).show();


        String totprice = totalprice.getText().toString();
        String quanity = no_of_item.getText().toString();
        String fn = foodid;
        String fid = globaluser.getId();

        Cart cart = new Cart(userid,foodid,quanity,totprice);

        OrderApi orderApi = Url.getInstance().create(OrderApi.class);
        Call<Cart> cartCall = orderApi.addcart(Url.token,cart);


        cartCall.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {

                if(!response.isSuccessful())
                {
                    Toast.makeText(OrderActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(OrderActivity.this,"Order Succesfully",Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<Cart> call, Throwable t) {


            }
        });





    }
}
