package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myquiz.SplashActivity.catList;
import static com.example.myquiz.SplashActivity.selectd_cat_index;

public class ScoreActivity extends AppCompatActivity {

    private TextView score;
    private Button done;
    String categoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = findViewById(R.id.sa_score);
        done  = findViewById(R.id.sa_done);

        categoryName = catList.get(selectd_cat_index).getName();

        String score_str = getIntent().getStringExtra("SCORE");
        score.setText(score_str);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ScoreActivity.this, "Categoty: "+categoryName+"\n Score: "+score_str, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();

            }
        });

    }
}