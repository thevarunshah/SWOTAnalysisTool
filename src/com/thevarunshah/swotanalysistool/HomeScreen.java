package com.thevarunshah.swotanalysistool;

import com.example.swotanalysistool.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class HomeScreen extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_screen);
        
        Button new_swot = (Button) findViewById(R.id.new_swot);
        new_swot.setOnClickListener(this);
        Button saved_swot = (Button) findViewById(R.id.saved_swot);
        saved_swot.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v){
    	
    	switch(v.getId()){
    		case R.id.new_swot:{
    			//do something
    			break;
    		}
    		case R.id.saved_swot:{
    			//do something
    			break;
    		}
    	}
    }
}