package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myquiz.model.RetrofitScorecard;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitScoreDataActivity extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_score_data);

        tvData = findViewById(R.id.tv_data);

        fetchData();
    }
    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetroInterface.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroInterface api = retrofit.create(RetroInterface.class);

        Call<List<RetrofitScorecard>> call = api.getScoreCardData();

        call.enqueue(new Callback<List<RetrofitScorecard>>() {
            @Override
            public void onResponse(Call<List<RetrofitScorecard>> call, Response<List<RetrofitScorecard>> response) {

                List<RetrofitScorecard> scorecardList = response.body();
                String resultStr="";

                if (scorecardList != null){
                    for (int i = 0; i< scorecardList.size() ; i++ ){
                        resultStr+=
                                "categories: "+ scorecardList.get(i).getCategories()
                                              +"\nScore: "+ scorecardList.get(i).getScore()+"\n\n";
                    }
                    tvData.setText(resultStr);
                } else {
                    Toast.makeText(getBaseContext(), "No score data available", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<RetrofitScorecard>> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Exception: "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

