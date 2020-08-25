package com.example.foodorderingapp.Model;

public class Cart {

    private String user;
    private String food;
    private String quanity;

    private String totalprice;

    public Cart(String user, String food, String quanity, String totalprice) {
        this.user = user;
        this.food = food;
        this.quanity = quanity;
        this.totalprice = totalprice;




    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getQuanity() {
        return quanity;
    }

    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }


    public String getTotalprice() {
        return totalprice;
    }


    }

