package com.example.foodorderingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restuarant {


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

//    public Food getFooditem() {
//        return fooditem;
//    }
//
//    public void setFooditem(Food fooditem) {
//        this.fooditem = fooditem;


    private String _id;
    private String resturant_name;
    private String resturant_address;
    private String res_image;

    //private  Food fooditem;





    public Restuarant(String _id, String resturant_name, String resturant_address, String res_image) {
        this._id = _id;
        this.resturant_name = resturant_name;
        this.resturant_address = resturant_address;
        this.res_image = res_image;
        //this.fooditem = fooditem;
    }
    public Restuarant( String resturant_name,String res_image) {

        this.resturant_name = resturant_name;
        this.res_image = res_image;

    }
}
