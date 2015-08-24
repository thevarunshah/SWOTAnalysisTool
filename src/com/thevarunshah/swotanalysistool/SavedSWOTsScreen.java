package com.thevarunshah.swotanalysistool;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
		Collections.sort(swotList);
		final ArrayAdapter<SWOTObject> adapter = new ArrayAdapter<SWOTObject>(this, android.R.layout.simple_list_item_1, android.R.id.text1, swotList);
		swotLV.setAdapter(adapter);

		swotLV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				SWOTObject so = (SWOTObject) swotLV.getItemAtPosition(position);
				
				Bundle extra = new Bundle();
				extra.putInt("objectId", so.getId());
				Intent i = new Intent(SavedSWOTsScreen.this, SWOTScreen.class);
				i.putExtra("bundle", extra);
				startActivity(i);
			}

		});

		swotLV.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

				final SWOTObject so = (SWOTObject) adapter.getItem(position);

				new AlertDialog.Builder(adapter.getContext())
				.setIconAttribute(android.R.attr.alertDialogIcon)
				.setTitle("Confirm Delete")
				.setMessage("Are you sure you want to delete this SWOT?")
				.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {

						int id = so.getId();
						adapter.remove(so);
						adapter.notifyDataSetChanged();

						Database.getSWOTs().remove(id);
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
				})
				.setNegativeButton("No", null)
				.show();

				return true;
			}
		});
	}
}
