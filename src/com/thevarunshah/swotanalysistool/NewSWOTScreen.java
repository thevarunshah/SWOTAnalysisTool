package com.thevarunshah.swotanalysistool;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.swotanalysistool.R;

public class NewSWOTScreen extends FragmentActivity{

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpView();
        setUpFragment();
    }
    void setUpView(){
         setContentView(R.layout.swot_screen);
    }
    void setUpFragment(){
         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
         SlidingFragment fragment = new SlidingFragment();
         transaction.replace(R.id.swot_screen_fragment, fragment);
         transaction.commit();
    }
}
