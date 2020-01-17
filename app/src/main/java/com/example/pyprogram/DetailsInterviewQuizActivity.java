package com.example.pyprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsInterviewQuizActivity extends AppCompatActivity {

    TextView quizTitle,quizAnswer,quizExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_interview_quiz);

        quizTitle = findViewById(R.id.txt_quiz_Title);
        quizAnswer = findViewById(R.id.txt_quiz_Answer);
        quizExample = findViewById(R.id.txt_quiz_Example);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null){
            quizTitle.setText(mBundle.getString("QuizTitle"));
            quizAnswer.setText(mBundle.getString("QuizAnswer"));
            quizExample.setText(mBundle.getString("QuizExample"));
        }
    }


}
