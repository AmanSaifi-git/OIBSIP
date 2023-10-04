package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity {
    EditText value;
    Spinner spinner;
    TextView C,F,K;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        getSupportActionBar().hide();
        value = findViewById(R.id.valueT);
        spinner = findViewById(R.id.spinnerT);
        C = findViewById(R.id.Celsius);
        F = findViewById(R.id.fahrenheit);
        K = findViewById(R.id.kelvin);
        String[] arr = {"Celsius","Fahrenheit","Kelvin"};
        spinner.setAdapter(new ArrayAdapter<>(TempActivity.this, android.R.layout.simple_list_item_1,arr));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                update();

            }
        });
    }
    public  void update(){
        if(!value.getText().toString().equals("") && !spinner.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble(value.getText().toString());
            switch (spinner.getSelectedItem().toString()){
                case "Celsius" :
                    setT(in);
                    break;
                case "Fahrenheit":
                    double f = (in - 32) * 5/9;
                    setT(f);
                    break;
                case "Kelvin":
                    double k = in - 273.15;
                    setT(k);
                    break;

            }

        }
    }
    public void setT(double in_km){
        C.setText(String.valueOf(in_km));
        F.setText(String.valueOf((in_km * 9/5) + 32 ));
        K.setText(String.valueOf(in_km + 273.15 ));



    }
}