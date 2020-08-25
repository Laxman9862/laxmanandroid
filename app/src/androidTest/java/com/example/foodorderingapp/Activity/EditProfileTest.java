package com.example.foodorderingapp.Activity;

import androidx.test.rule.ActivityTestRule;

import com.example.foodorderingapp.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class EditProfileTest {

    @Rule
    public ActivityTestRule<RegisterActivity> testRule = new ActivityTestRule<>(RegisterActivity.class);

    RegisterActivity registerActivity = null;

    @Before
    public void setUp() throws Exception {
        registerActivity =  testRule.getActivity();
    }
    @Test
    public void ComponentsTest(){
        assertNotNull(registerActivity.etname);
        assertNotNull(registerActivity.etemail);
        assertNotNull(registerActivity.etphone);
        assertNotNull(registerActivity.etusername);
        assertNotNull(registerActivity.etpassword);
        assertNotNull(registerActivity.imagepath);
    }

    @Test
    public void RegisterUItest(){



        onView(withId(R.id.name))
                .perform(typeText("Uttam Tamang"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.email))
                .perform(typeText("uttamtamang123@gmail.com"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.phone))
                .perform(typeText("986078946709"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.username))
                .perform(typeText("uttam"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.password))
                .perform(typeText("uttam"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.cpassword))
                .perform(typeText("uttam"))
                .perform(closeSoftKeyboard());






        onView(withId(R.id.updateuser))
                .perform(click());
    }



}