package com.bao.insulincalculator;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsPage extends Activity {

	EditText BeforeBreakfastET;
	EditText BeforeLunchET;
	EditText BeforeDinnerET;
	EditText TargetBloodET;
	EditText BasalInsulinET;
	
	
	private double dblBeforeBreakfast;
	private double dblBeforeLunch;
	private double dblBeforeDinner;
	private double dblTargetBlood;
	private double dblBasalInsulin;
	
	Button UserEnter;
	Spinner SensitivitySpinner;
	
	private double dblSensitivity;
	private double dblSensitivity1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings_page);
		
		BeforeBreakfastET = (EditText) findViewById(R.id.BeforeBreakfastEditText);
		BeforeLunchET = (EditText) findViewById(R.id.BeforeLunchEditText);
		BeforeDinnerET = (EditText) findViewById(R.id.BeforeDinnerEditText);
		TargetBloodET = (EditText) findViewById(R.id.SugarTargetEditText);
		BasalInsulinET = (EditText) findViewById(R.id.BasalInsulinEditText);
		
		SensitivitySpinner = (Spinner) findViewById(R.id.SensitivitySpinner);
		
		UserEnter = (Button) findViewById(R.id.UserEnter);
		
		List<String> SensitivityArray = new ArrayList<String>();
		SensitivityArray.add("Very Low");
		SensitivityArray.add("Low");
		SensitivityArray.add("Moderate");
		SensitivityArray.add("High");
		SensitivityArray.add("Very High");
		
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SensitivityArray);

		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		SensitivitySpinner.setAdapter(dataAdapter2);
		
		SensitivitySpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (arg2 == 0){
					dblSensitivity1 = 100;
				}
				if (arg2 == 1){
					dblSensitivity1 = 75;
				}
				if (arg2 == 2){
					dblSensitivity1 = 50;
				}
				if (arg2 == 3){
					dblSensitivity1 = 25;
				}
				if (arg2 == 4){
					dblSensitivity1 = 10;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		UserEnter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(SettingsPage.this, UserDataEntry.class);

				
				dblBeforeBreakfast= Double.parseDouble(BeforeBreakfastET.getText().toString());
				dblBeforeLunch = Double.parseDouble(BeforeLunchET.getText().toString());
				dblBeforeDinner = Double.parseDouble(BeforeDinnerET.getText().toString());
				dblTargetBlood = Double.parseDouble(TargetBloodET.getText().toString());
				dblBasalInsulin = Double.parseDouble(BasalInsulinET.getText().toString());
				
				
				Bundle b = new Bundle();
				
				b.putDouble("name", dblBeforeBreakfast);
				b.putDouble("name1", dblBeforeLunch);
				b.putDouble("name2", dblBeforeDinner);
				b.putDouble("name3", dblTargetBlood);
				b.putDouble("name4", dblBasalInsulin);
				b.putDouble("name5", dblSensitivity1);

				
				myIntent.putExtra("Bundle", b);
				
				SettingsPage.this.startActivity(myIntent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings_page, menu);
		return true;
	}

}
