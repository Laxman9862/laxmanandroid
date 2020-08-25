package com.example.foodorderingapp.Activity;

import androidx.test.rule.ActivityTestRule;

import com.example.foodorderingapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class OrderActivityTest {
    @Rule
    public ActivityTestRule<OrderActivity> testRule = new ActivityTestRule<>(OrderActivity.class);

    OrderActivity OrderActivity = null;
    @Before
    public void setUp() throws Exception {
        OrderActivity = testRule.getActivity();
    }



    @Test
    public void TestOrder(){
        onView(withId(R.id.foodprice))
                .perform(typeText("1200"))
                .perform(closeSoftKeyboard());



        onView(withId(R.id.cartbutton))
                .perform(click());
    }
}