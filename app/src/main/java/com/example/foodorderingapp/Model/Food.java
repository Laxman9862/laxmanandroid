package com.example.foodorderingapp.Model;

public class Food {
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    private String _id;
    private String foodname;
    private String foodimage;
    private String price;

    public Food(String _id,String foodname, String foodimage, String price) {
        this._id = _id;
        this.foodname = foodname;
        this.foodimage = foodimage;
        this.price = price;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(String foodimage) {
        this.foodimage = foodimage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

