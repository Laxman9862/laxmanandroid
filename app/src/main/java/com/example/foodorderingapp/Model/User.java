package com.example.foodorderingapp.Model;

public class User {
    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public User(String _id) {
        this._id = _id;
    }

    private String _id;
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String profileimage;



    public User(String name, String phone, String email, String username, String password,String profileimage) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileimage = profileimage;
    }

    public User(String name, String phone, String email, String username, String password) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;

    }



    

    public User(String username,String password)
    {
        this.username = username;
        this.password = password;
    }

    public User(String name, String phone,String email)
    {
        this.name = name;
        this.phone = phone;
        this.email = email;

    }
    public String getProfileimage() {
        return profileimage;
    }

    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
