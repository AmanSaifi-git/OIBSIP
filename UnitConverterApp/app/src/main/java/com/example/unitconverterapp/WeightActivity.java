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

public class WeightActivity extends AppCompatActivity {
    EditText value;
    Spinner spinner;
    TextView kg,g,pound,mg,microG,stone, ounce;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        getSupportActionBar().hide();
        value = findViewById(R.id.valueW);
        spinner = findViewById(R.id.spinnerW);
        kg = findViewById(R.id.kg);
        g = findViewById(R.id.g);
        pound = findViewById(R.id.pound);
        mg = findViewById(R.id.mg);
        microG = findViewById(R.id.microG);
        stone = findViewById(R.id.stone);
        ounce = findViewById(R.id.ounce);
        String[] arr = {"kg","g","pound","mg","microG","stone","ounce"};
        spinner.setAdapter(new ArrayAdapter<>(WeightActivity.this, android.R.layout.simple_list_item_1,arr));
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
                case "kg" :
                    setKg(in);
                    break;
                case "g":
                    setKg(in/1000);
                    break;
                case "pound":
                    setKg(in/2.20);
                    break;
                case "mg":
                    setKg(in/1000000);
                    break;
                case "microG":
                    setKg(in/1000000000);
                    break;
                case "stone":

                    setKg(in/0.157);
                    break;
                case "ounce":
                    setKg(in/35.27);
                    break;

            }

        }
    }
    public void setKg(double in_km){
        kg.setText(String.valueOf(in_km));
        g.setText(String.valueOf(in_km * 1000));
        pound.setText(String.valueOf(in_km * 2.20));
        mg.setText(String.valueOf(in_km * 1000000));
        microG.setText(String.valueOf(in_km * 1000000000));
        stone.setText(String.valueOf(in_km * 0.157));
        ounce.setText(String.valueOf(in_km * 35.27));


    }
}