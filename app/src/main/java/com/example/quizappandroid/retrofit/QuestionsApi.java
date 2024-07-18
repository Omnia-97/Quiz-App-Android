package com.example.quizappandroid.retrofit;

import com.example.quizappandroid.model.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionsApi {
    @GET("myquizapi.php")  // end point
    Call<QuestionList> getQuestions();
}
