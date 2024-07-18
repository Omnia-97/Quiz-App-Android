package com.example.quizappandroid.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quizappandroid.model.QuestionList;
import com.example.quizappandroid.retrofit.QuestionsApi;
import com.example.quizappandroid.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {
    private QuestionsApi questionsApi;

    public QuizRepository() {
        this.questionsApi = new RetrofitInstance()
                .getRetrofitInstance()
                .create(QuestionsApi.class);
    }
    public LiveData<QuestionList> getQuestionsFromApi(){
        MutableLiveData<QuestionList> data = new MutableLiveData<>();
        Call<QuestionList> response = questionsApi.getQuestions();
        response.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                QuestionList list = response.body();
                data.setValue(list);
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable throwable) {

            }

        });
        return data;
    }
}
