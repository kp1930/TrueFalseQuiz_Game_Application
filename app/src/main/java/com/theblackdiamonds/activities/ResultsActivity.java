package com.theblackdiamonds.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.theblackdiamonds.R;
import com.theblackdiamonds.models.QuizBook;

public class ResultsActivity extends AppCompatActivity {

    TextView mGrade, mFinalScore;
    Button mRetryButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mGrade = findViewById(R.id.grade);
        mFinalScore = findViewById(R.id.outOf);
        mRetryButton = findViewById(R.id.retry);

        Bundle bundle = getIntent().getExtras();
        int score = 0;
        if (bundle != null) {
            score = bundle.getInt("finalScore");
        }

        mFinalScore.setText("You scored " + score + " out of " + QuizBook.questions.length);

        if (score == 9) {
            mGrade.setText("Outstanding");
        } else if (score == 8) {
            mGrade.setText("Good Work");
        } else if (score == 7) {
            mGrade.setText("Good Effort");
        } else {
            mGrade.setText("Go over your notes");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizActivity.class));
                ResultsActivity.this.finish();
            }
        });

    }
}