package com.example.foodorderingapp.Model;

public class Cart {

    private String user;
    private String food;
    private int quanity;



    public Cart(String user, String food, int quanity) {
        this.user = user;
        this.food = food;
        this.quanity = quanity;




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

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }





    }

