package com.example.foodorderingapp;

import com.example.foodorderingapp.BLL.FoodBLL;
import com.example.foodorderingapp.BLL.LoginBLL;
import com.example.foodorderingapp.BLL.SignupBLL;
import com.example.foodorderingapp.BLL.UPdateBLL;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test

    public void testlogin(){
        LoginBLL loginBLL = new LoginBLL();
        boolean result = loginBLL.login("ashish","ashish");
         assertEquals(true,result);
    }
    @Test
    public  void testsignup(){
        SignupBLL  signupBLL = new SignupBLL();
        boolean result = signupBLL.login("Subash","subash","subashthapa901@gmail.com","98677890088","Subash Thapa","subash.jpeg");
        assertEquals(true,result);
    }
    @Test
    public void testorder(){
        FoodBLL foodBLL = new FoodBLL();
        boolean result = foodBLL.food("09354647889","Burger","12","12000");
        assertEquals(true,result);

    }
    @Test
    public void testupdate(){
       UPdateBLL uPdateBLL = new UPdateBLL();
        boolean result = uPdateBLL.update("uttam","uttam@gmail.com","987567e5r789");
        assertEquals(true,result);

    }

}