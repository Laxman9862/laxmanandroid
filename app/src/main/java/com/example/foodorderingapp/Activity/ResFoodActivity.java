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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.foodorderingapp.Activity.DashboardActivity.globaluser;

public class ResFoodActivity extends AppCompatActivity {

    ImageView selectitem_image;
    TextView foodname,no_of_item,totalprice, fdprice;
    Button btnincrement,btndecrement,btnaddcart;
    public static float price =120;

    public static int counter = 1;
    public static int c2 = 1;



    public String foodid  = "";
    public  String fname = "";
    public  String fprice = "";
    public  String fimage = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Now");

        Bundle bundle =  getIntent().getExtras();
        foodid = bundle.getString("foodid");
          fname = bundle.getString("foodname");
         fprice = bundle.getString("price");
         fimage = bundle.getString("image");

         totalprice = findViewById(R.id.totatcost);
         no_of_item = findViewById(R.id.items);
         fdprice = findViewById(R.id.price);
         foodname = findViewById(R.id.foodname);
         selectitem_image = findViewById(R.id.restfoodimage);
          btnincrement = findViewById(R.id.increment);
          btndecrement = findViewById(R.id.decrement);
          btnaddcart = findViewById(R.id.cartbutton);

          /* Adding valaue */

        foodname.setText(fname);
        fdprice.setText(fprice);
         //Picasso.get().load(fname).into(selectitem_image);


          btnincrement.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 if(counter > 0){
                     counter++;
                     price = price * counter;
                     String c1 = Integer.toString(counter);
                     no_of_item.setText(c1);
                     String tc = Float.toString(price);
                     totalprice.setText(tc);
                 }
              }
          });

          btndecrement.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(counter > 1){
                      counter--;
                      price = price * counter;
                      String c2 = Integer.toString(counter);
                      no_of_item.setText(c2);
                      String tr = Float.toString(price);
                      totalprice.setText(tr);
                  }
              }


          });

          btnaddcart.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  order();
              }
          });




    }

    private void order() {

        String fid = foodid;
        String uid = globaluser.getId();
        //Toast.makeText(ResFoodActivity.this, "id" + fid, Toast.LENGTH_SHORT).show();
        int qty = Integer.valueOf(no_of_item.getText().toString());


        Cart cart = new Cart( uid, fid, qty);

        OrderApi cartapi = Url.getInstance().create(OrderApi.class);
        Call<Cart> cartCall = cartapi.addcart(Url.token, cart);

        cartCall.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(ResFoodActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(ResFoodActivity.this,"Order Succesfully",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });

    }
}
