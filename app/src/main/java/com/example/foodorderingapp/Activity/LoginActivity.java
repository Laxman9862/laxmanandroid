package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.foodorderingapp.Fragment.HomeFragment;
import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.ServerResponse.UserResponse;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.IOException;
import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements SensorEventListener {




   public EditText etusername,etpassword;
    public  Button btnlogin;
    private TextView txtreg;
    private CheckBox chk;
    private SensorManager sensorManager;
    Vibrator vibrator;
    Sensor accelermoter;

    SharedPreferences sharedPreferences,token;

    String name,Username,Password;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getSupportActionBar().hide();

        etusername = findViewById(R.id.lusername);
        etpassword = findViewById(R.id.lpassword);
        btnlogin = findViewById(R.id.login);
        chk = findViewById(R.id.chkrememberme);


        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        accelermoter = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(LoginActivity.this,accelermoter,SensorManager.SENSOR_DELAY_NORMAL);









        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etusername.getText().toString().matches("")){
                    etusername.setError("Enter Your Username");
                    getCurrentFocus();
                    return;
                }
                if(etpassword.getText().toString().matches("")){
                    etpassword.setError("Enter Your Password");
                    getCurrentFocus();
                    return;
                }
                login();
            }
        });


        txtreg = findViewById(R.id.tvSignUp);

        txtreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });







    }


    public void login()
    {
        String uname = etusername.getText().toString();
        String pwd = etpassword.getText().toString();


        User user = new User(uname,pwd);

        UserApi  userApi = Url.getInstance().create(UserApi.class);
        Call<UserResponse> userloginresponse = userApi.login(user);

        userloginresponse.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Username or password not match",Toast.LENGTH_SHORT).show();
                    Vibrator vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
                    vibrator.vibrate(2000);



                }else{
                    Toast.makeText(LoginActivity.this,"Login success!",Toast.LENGTH_SHORT).show();
                    sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username",etusername.getText().toString());
                    editor.putString("token", response.body().getToken());



                    Url.token += response.body().getToken();


                    openDashBoard();







                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void openDashBoard(){
        Intent i = new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(i);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        Toast.makeText(LoginActivity.this,"onSensorChange: x:" +  event.values[0] + "Y" +event.values[1] + "Z" +event.values[2],Toast.LENGTH_LONG);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {



    }
}