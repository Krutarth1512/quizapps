package com.example.myquiz.model;

import com.google.gson.annotations.SerializedName;

public class RetrofitScorecard {
    @SerializedName("categories")
    private String categories;

    @SerializedName("score")
    private int score;



    public RetrofitScorecard() {
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int sets) {
        this.score = score;
    }


    public RetrofitScorecard(String categories, int score) {
        this.categories = categories;
        this.score = score;

    }
}
