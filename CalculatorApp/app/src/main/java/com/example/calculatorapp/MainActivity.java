package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MaterialButton clear, openBrack, closeBrack, divide, multiply, add, subtract, equals, button0,button1, button2,
            button3,button4,button5,button6,button7,button8,button9, allClear, decimal;
    TextView result, solTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_tv);

        solTextView = findViewById(R.id.solution_tv);
        
        helperFun(clear,R.id.button_clear);
        helperFun(openBrack,R.id.button_open_brackets);
        helperFun(closeBrack,R.id.buttons_close_bracket);
        helperFun(divide,R.id.button_divide);
        helperFun(multiply,R.id.button_multiply);
        helperFun(add,R.id.button_add);
        helperFun(subtract,R.id.button_subtract);
        helperFun(equals,R.id.button_equal);
        helperFun(button0,R.id.button_0);
        helperFun(button1,R.id.button_1);
        helperFun(button2,R.id.button_2);
        helperFun(button3,R.id.buttons_3);
        helperFun(button4,R.id.button_4);
        helperFun(button5,R.id.button_5);
        helperFun(button6,R.id.buttons_6);
        helperFun(button7,R.id.button_7);
        helperFun(button8,R.id.button_8);
        helperFun(button9,R.id.buttons_9);
        helperFun(allClear,R.id.button_ac);
        helperFun(decimal,R.id.buttons_dot);



    }
    void helperFun(MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String solution = solTextView.getText().toString();
        if(buttonText.equals("AC")){
            solTextView.setText("");
            result.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            solTextView.setText(result.getText());
            return;
        }
        if (buttonText.equals("C")){
            solution = solution.substring(0,solution.length()-1);
        }else{
            solution = solution+buttonText;
        }
        solTextView.setText(solution);
        String finalResult =getResult(solution);
        if(!finalResult.equals("Err")){
            result.setText(finalResult);
        }

    }
    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }

}