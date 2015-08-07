package com.thevarunshah.swotanalysistool;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.swotanalysistool.R;
import com.thevarunshah.swotanalysistool.backend.Database;
import com.thevarunshah.swotanalysistool.backend.SWOTObject;

public class NewSWOTScreen extends FragmentActivity{

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        int swotId = getIntent().getBundleExtra("bundle").getInt("objectId");
        SWOTObject so = Database.getSWOTs().get(swotId);
        
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
