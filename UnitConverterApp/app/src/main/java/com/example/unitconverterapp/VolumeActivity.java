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

public class VolumeActivity extends AppCompatActivity {
    EditText value;
    Spinner spinner;
    TextView l,gallon,quart,pint,cup,ml, cubicMetre;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        value = findViewById(R.id.valueV);
        spinner = findViewById(R.id.spinnerV);
        l = findViewById(R.id.l);
        gallon = findViewById(R.id.gallon);
        quart = findViewById(R.id.quart);
        pint = findViewById(R.id.pint);
        cup = findViewById(R.id.cup);
        ml = findViewById(R.id.ml);
        cubicMetre = findViewById(R.id.cubicMetre);
        String[] arr = {"Litre","gallon","quart","pint","cup","ml","cubicMetre"};
        spinner.setAdapter(new ArrayAdapter<>(VolumeActivity.this, android.R.layout.simple_list_item_1,arr));
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
                case "Litre" :
                    setL(in);
                    break;
                case "gallon":
                    setL(in/0.264);
                    break;
                case "quart":
                    setL(in/1.056);
                    break;
                case "pint":
                    setL(in/2.11);
                    break;
                case "cup":
                    setL(in/4.167);
                    break;
                case "ml":

                    setL(in/1000);
                    break;
                case "cubicMetre":
                    setL(in/0.001);
                    break;

            }

        }
    }
    public void setL(double in_km){
        l.setText(String.valueOf(in_km));
        gallon.setText(String.valueOf(in_km * 0.264));
        quart.setText(String.valueOf(in_km * 1.056));
        pint.setText(String.valueOf(in_km * 2.11));
        cup.setText(String.valueOf(in_km * 4.167));
        ml.setText(String.valueOf(in_km * 1000));
        cubicMetre.setText(String.valueOf(in_km * 0.001));


    }
}