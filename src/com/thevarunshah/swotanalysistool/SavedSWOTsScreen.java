package com.thevarunshah.swotanalysistool;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.swotanalysistool.R;
import com.thevarunshah.swotanalysistool.backend.Database;
import com.thevarunshah.swotanalysistool.backend.SWOTObject;

public class SavedSWOTsScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.saved_swots);
	}
	
	@Override
	protected void onResume(){
		
		super.onResume();

		final ListView swotLV = (ListView) findViewById(R.id.swots_list);
		final ArrayList<SWOTObject> swotList = new ArrayList<SWOTObject>();
		for(SWOTObject so : Database.getSWOTs().values()){
			swotList.add(so);
		}
		ArrayAdapter<SWOTObject> adapter = new ArrayAdapter<SWOTObject>(this, android.R.layout.simple_list_item_1, android.R.id.text1, swotList);
		swotLV.setAdapter(adapter);

		swotLV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				SWOTObject so = (SWOTObject) swotLV.getItemAtPosition(position);

				Database.getSWOTs().put(so.getId(), so);
    			Bundle extra = new Bundle();
    			extra.putInt("objectId", so.getId());
    			Intent i = new Intent(SavedSWOTsScreen.this, SWOTScreen.class);
    			i.putExtra("bundle", extra);
				startActivity(i);
			}

		}); 
	}
}
