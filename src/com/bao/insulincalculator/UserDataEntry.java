package com.bao.insulincalculator;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UserDataEntry extends Activity {

	private double BFT;
	private double BL;
	private double BD;
	private double TG;
	private double BSI;
	
	private double dblCurrentSugar;
	
	private double dblTotalDose;
	
	Button Calculate;
	
	private double intMeal;
	private double intAmount;
	private double intSensitivity1;
	
	TextView InsulinNeeded;
	EditText CurrentSugarET;
	
	Spinner MealNowSpinner1;
	Spinner HowMuchSpinner1;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_data_entry);
		
		CurrentSugarET = (EditText) findViewById(R.id.CurrentSugarEditText);
		InsulinNeeded = (TextView) findViewById(R.id.InsulinNeededTextView);
		
		MealNowSpinner1 = (Spinner) findViewById(R.id.MealNowSpinner);
		HowMuchSpinner1 = (Spinner) findViewById(R.id.HowMuchSpinner);
		
		Calculate = (Button) findViewById(R.id.CalculateButton);
		
		
		
		BFT = getIntent().getBundleExtra("Bundle").getDouble("name");
		BL = getIntent().getBundleExtra("Bundle").getDouble("name1");
		BD = getIntent().getBundleExtra("Bundle").getDouble("name2");
		TG = getIntent().getBundleExtra("Bundle").getDouble("name3");
		BSI = getIntent().getBundleExtra("Bundle").getDouble("name4");
		intSensitivity1 = getIntent().getBundleExtra("Bundle").getDouble("name5");
		
		List<String> WhatMealNowArray = new ArrayList<String>();
		WhatMealNowArray.add("Breakfast");
		WhatMealNowArray.add("Lunch");
		WhatMealNowArray.add("Dinner");
		WhatMealNowArray.add("Bedtime");
		
		List<String> HowMuchArray = new ArrayList<String>();
		HowMuchArray.add("Full Meal");
		HowMuchArray.add("3/4 full");
		HowMuchArray.add("1/2 full");
		HowMuchArray.add("1/4 full");
		HowMuchArray.add("None");
	
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, WhatMealNowArray);

		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		MealNowSpinner1.setAdapter(dataAdapter);
		MealNowSpinner1.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (arg2 == 0){
					intMeal = 1;
				};
				
				if (arg2 == 1){
					intMeal = 2;
				};
				if (arg2 == 2){
					intMeal = 3;
				};
				if (arg2 == 3){
					intMeal = 4;
				};
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, HowMuchArray);
		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		HowMuchSpinner1.setAdapter(dataAdapter1);
		HowMuchSpinner1.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (arg2 == 0){
					intAmount = 1;
				}
				if (arg2 == 1){
					intAmount = 0.75;
				}
				if (arg2 == 2){
					intAmount = 0.5;
				}
				if (arg2 == 3){
					intAmount = 0.25;
				}
				if (arg2 == 4){
					intAmount = 1;
				}
			}
		
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
			
		});
		
		
		
		
		
		Calculate.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dblCurrentSugar = Double.parseDouble(CurrentSugarET.getText().toString());
				
				if (intMeal == 1){
					dblTotalDose = (BFT * intAmount) + ((dblCurrentSugar - TG) / intSensitivity1);
				}
				
				InsulinNeeded.setText(Double.toString(dblTotalDose));
				
				
			}
			
		});
		
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_data_entry, menu);
		return true;
	}

}
