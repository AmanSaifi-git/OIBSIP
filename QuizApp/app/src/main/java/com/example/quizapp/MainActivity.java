package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView question, quesNum;
    Button option1, option2, option3, option4;
    ArrayList<structure> structureList;
    Random random;
    int answer = 0, quesAtempt = 0,currPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.idTVQuestions);
        quesNum = findViewById(R.id.idTVQuestionsAttempted);
        option1 = findViewById(R.id.idBtnOption1);
        option2 = findViewById(R.id.idBtnOption2);
        option3 = findViewById(R.id.idBtnOption3);
        option4 = findViewById(R.id.idBtnOption4);
        structureList = new ArrayList<>();
        random = new Random();
        quesFun(structureList);
        currPos = random.nextInt(structureList.size());
        setData(currPos);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(structureList.get(currPos).getAnswer().trim().toLowerCase().equals(option1.getText().toString().trim().toLowerCase())){
                    answer++;
                }
                quesAtempt++;
                currPos = random.nextInt(structureList.size());
                setData(currPos);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(structureList.get(currPos).getAnswer().trim().toLowerCase().equals(option2.getText().toString().trim().toLowerCase())){
                    answer++;
                }
                quesAtempt++;
                currPos = random.nextInt(structureList.size());
                setData(currPos);

            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(structureList.get(currPos).getAnswer().trim().toLowerCase().equals(option3.getText().toString().trim().toLowerCase())){
                    answer++;
                }
                quesAtempt++;
                currPos = random.nextInt(structureList.size());
                setData(currPos);
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(structureList.get(currPos).getAnswer().trim().toLowerCase().equals(option4.getText().toString().trim().toLowerCase())){
                    answer++;
                }
                quesAtempt++;
                currPos = random.nextInt(structureList.size());
                setData(currPos);
            }
        });

    }
    void showCustomDialog(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button resetButton = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n"+ answer +"/10");
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currPos = random.nextInt(structureList.size());
                setData(currPos);
                quesAtempt = 0;
                answer =0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    void setData(int currPos){
        quesNum.setText("Question Attempted : "+ quesAtempt +"/10");
        if(quesAtempt == 10){
            showCustomDialog();
        }else{
            question.setText(structureList.get(currPos).getQuestion());
            option1.setText(structureList.get(currPos).getOption1());
            option2.setText(structureList.get(currPos).getOption2());
            option3.setText(structureList.get(currPos).getOption3());
            option4.setText(structureList.get(currPos).getOption4());

        }


    }
    void quesFun(ArrayList<structure> list){
        list.add(new structure("Who is the Father of our Nation?","Mahatma Gandhi","Jawaharlal Nehru ","Dr. B. R. Ambedkar","CV Raman","Mahatma Gandhi"));
        list.add(new structure("Who was the first President of India?","Mahatma Gandhi","Jawahar Lal Nehru","Dr. B. R. Ambedkar","Dr. Rajendra Prasad","Dr. Rajendra Prasad"));
        list.add(new structure("Who is known as Father of Indian Constitution?","Mahatma Gandhi","Jawahar Lal Nehru","Dr. B. R. Ambedkar","CV Raman","Dr. B. R. Ambedkar"));
        list.add(new structure("Who was the first Prime Minister of India?","Mahatma Gandhi","Jawaharlal Nehru","Dr. B. R. Ambedkar","CV Raman","Jawaharlal Nehru "));
        list.add(new structure("Who invented Computer?","Charles Babbage","Robert Spenser","Tony Stark","Bill gates","Charles Babbage"));
        list.add(new structure("India lies in which continent?","Asia","Europe","Africa","Antarctica","Asia"));
        list.add(new structure("Which country are the Giza Pyramids in?","America","Turkey","Egypt","Saudi Arabia","Egypt"));
        list.add(new structure("What city is the statue of liberty in?","New York","Manhattan","California","San Francisco","New York"));
        list.add(new structure("Which animal has hump on its back?","Tiger","Lion","Jaguar","Camel","Camel"));
        list.add(new structure("Smallest state of India is?","Delhi","Goa","Chennai","Bengaluru","Goa"));

    }
}