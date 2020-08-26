package com.example.foodorderingapp.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {



    //public static final String BASE_URL= "http://192.168.137.19:3002/";
    //public static final String BASE_URL = "http://192.168.43.228:3002/";
    //public static final String BASE_URL ="http://172.26.8.61:3002/";
    //public static final String BASE_URL ="http://10.0.2.2:3002/";
    //public static final String BASE_URL ="http://172.26.1.91:3002/";

    public static final String BASE_URL ="http://192.168.1.135:3002/";
    //public static final String BASE_URL ="http://192.168.0.122:3002/";

   // For project
    //public static final String BASE_URL ="http://localhost:3002/";



    //Testing

    //public static  final String BASE_URL="http://localhost:3002/";
    public static String token = "Bearer ";
    public static String imagePath = BASE_URL + "uploads/";


    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
