package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LengthActivity extends AppCompatActivity {
    EditText value;
    Spinner spinner;
    TextView km,m,cm,mm,microM,nanoM,mile,yard,foot,inches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        getSupportActionBar().hide();
        value = findViewById(R.id.value);
        spinner = findViewById(R.id.spinner);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        microM = findViewById(R.id.microM);
        nanoM = findViewById(R.id.nanoM);
        yard = findViewById(R.id.yard);
        mile = findViewById(R.id.mile);
        foot = findViewById(R.id.foot);
        inches = findViewById(R.id.inches);
        String[] arr = {"km","m","cm","mm","microM","nanoM","yard","mile","foot","inches"};
        spinner.setAdapter(new ArrayAdapter<>(LengthActivity.this, android.R.layout.simple_list_item_1,arr));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();

            }
        });
    }

    public  void update(){
        if(!value.getText().toString().equals("") && !spinner.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble(value.getText().toString());
            switch (spinner.getSelectedItem().toString()){
                case "km" :
                    setKm(in);
                    break;
                case "m":
                    setKm(in/1000);
                    break;
                case "cm":
                    setKm(in/100000);
                    break;
                case "mm":
                    setKm(in/1000000);
                    break;
                case "microM":
                    setKm(in/1000000000);
                    break;
                case "nanoM":
                    double d = 1000000 * 1000000;
                    setKm(in/d);
                    break;
                case "mile":
                    setKm(in*1.609);
                    break;
                case "yard":
                    setKm(in/1094);
                    break;
                case "foot":
                    setKm(in/3281);
                    break;
                case "inches":
                    setKm(in/39370);
                    break;
            }

        }
    }
    public void setKm(double in_km){
        km.setText(String.valueOf(in_km));
        m.setText(String.valueOf(in_km * 1000));
        cm.setText(String.valueOf(in_km * 100000));
        mm.setText(String.valueOf(in_km * 1000000));
        microM.setText(String.valueOf(in_km * 1000000000));
        nanoM.setText(String.valueOf(in_km * 1000000 * 1000000));
        mile.setText(String.valueOf(in_km/1.609));
        yard.setText(String.valueOf(in_km * 1094));
        foot.setText(String.valueOf(in_km * 3281));
        inches.setText(String.valueOf(in_km *39370 ));

    }
}