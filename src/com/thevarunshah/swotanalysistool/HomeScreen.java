package com.thevarunshah.swotanalysistool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.example.swotanalysistool.R;
import com.thevarunshah.swotanalysistool.backend.SWOTObject;
import com.thevarunshah.swotanalysistool.backend.Database;


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
    			SWOTObject so = new SWOTObject(Database.getId());
    			Database.getSWOTs().put(so.getId(), so);
    			Bundle extra = new Bundle();
    			extra.putInt("objectId", so.getId());
    			Intent i = new Intent(HomeScreen.this, NewSWOTScreen.class);
    			i.putExtra("bundle", extra);
				startActivity(i);
    			break;
    		}
    		case R.id.saved_swot:{
    			Intent i = new Intent(HomeScreen.this, SavedSWOTsScreen.class);
    			startActivity(i);
    			break;
    		}
    	}
    }
}
