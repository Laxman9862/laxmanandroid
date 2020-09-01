package com.example.foodorderingapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Restuarant {
    private String _id;
    private String resturant_name;
    private String resturant_address;
    private String res_image;
    @SerializedName("fooddetails")
    @Expose
    private Food fooddetails;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getResturant_name() {
        return resturant_name;
    }

    public void setResturant_name(String resturant_name) {
        this.resturant_name = resturant_name;
    }

    public String getResturant_address() {
        return resturant_address;
    }

    public void setResturant_address(String resturant_address) {
        this.resturant_address = resturant_address;
    }

    public String getRes_image() {
        return res_image;
    }

    public void setRes_image(String res_image) {
        this.res_image = res_image;
    }

    public Food getFooddetails() {
        return fooddetails;
    }

    public void setFooddetails(Food fooddetails) {
        this.fooddetails = fooddetails;
    }

    public Restuarant(String _id, String resturant_name, String resturant_address, String res_image, Food fooddetails) {
        this._id = _id;
        this.resturant_name = resturant_name;
        this.resturant_address = resturant_address;
        this.res_image = res_image;
        this.fooddetails = fooddetails;
    }
}
