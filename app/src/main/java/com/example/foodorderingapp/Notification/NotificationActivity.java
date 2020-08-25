package com.example.foodorderingapp.Notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foodorderingapp.Activity.LoginActivity;
import com.example.foodorderingapp.R;

public class NotificationActivity extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;




    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        CheckNetwork();
    }

    private void CheckNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager)

                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo network = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


        if (wifi.isConnected()) {

            Toast.makeText(this, "Wifi is available ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(NotificationActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        } else if (network.isConnected()) {

            Intent intent = new Intent(NotificationActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Internet is available ", Toast.LENGTH_LONG).show();
            finish();


        } else {
            Toast.makeText(this, "Internet is not available ", Toast.LENGTH_LONG).show();


        }
    }
}


