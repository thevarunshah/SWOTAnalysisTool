package com.thevarunshah.swotanalysistool;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.example.swotanalysistool.R;
import com.thevarunshah.swotanalysistool.backend.Database;
import com.thevarunshah.swotanalysistool.backend.SWOTObject;


public class HomeScreen extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_screen);
        
        FileInputStream fis = null;
		ObjectInputStream ois = null;
        try {
			fis = openFileInput("swot_backup.ser");
			ois = new ObjectInputStream(fis);
			Database.setId(ois.readInt());
			Database.setSWOTs((HashMap<Integer, SWOTObject>)ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				if(ois != null) ois.close();
				if(fis != null) fis.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
        
        Button new_swot = (Button) findViewById(R.id.new_swot);
        new_swot.setOnClickListener(this);
        Button saved_swot = (Button) findViewById(R.id.saved_swot);
        saved_swot.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v){
    	
    	switch(v.getId()){
    		case R.id.new_swot:{
    			Database.setId(Database.getId()+1);
    			SWOTObject so = new SWOTObject(Database.getId());
    			Database.getSWOTs().put(so.getId(), so);
    			Bundle extra = new Bundle();
    			extra.putInt("objectId", so.getId());
    			Intent i = new Intent(HomeScreen.this, SWOTScreen.class);
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
