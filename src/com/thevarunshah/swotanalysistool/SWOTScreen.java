package com.thevarunshah.swotanalysistool;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thevarunshah.swotanalysistool.backend.Database;
import com.thevarunshah.swotanalysistool.backend.SWOTObject;

public class SWOTScreen extends FragmentActivity implements OnClickListener{

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        int swotId = getIntent().getBundleExtra("bundle").getInt("objectId");
        SWOTObject so = Database.getSWOTs().get(swotId);
        Database.setCurrentSWOT(so);
        
        setUpView();
        setUpFragment();
        
        Button save = (Button) findViewById(R.id.swot_save);
        save.setOnClickListener(this);
        EditText title = (EditText) findViewById(R.id.swot_title);
        title.setText(so.getName());
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
    
    @Override
    public void onClick(View v){
    	
    	switch(v.getId()){
    		case R.id.swot_save:{
    			String title = ((EditText) findViewById(R.id.swot_title)).getText().toString();
    			Database.getCurrentSWOT().setName(title);
    			Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
    		}
    	}
    }
    
    @Override
    public void onPause(){
    	super.onPause();
    	
    	FileOutputStream fos = null;
		ObjectOutputStream oos = null;
    	try {
			fos = openFileOutput("swot_backup.ser", MODE_PRIVATE);
			oos = new ObjectOutputStream(fos);
			oos.writeInt(Database.getId());
			oos.writeObject(Database.getSWOTs());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				oos.close();
				fos.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
    }
}
