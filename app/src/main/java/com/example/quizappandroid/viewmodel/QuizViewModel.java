package com.example.quizappandroid.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizappandroid.model.QuestionList;
import com.example.quizappandroid.repository.QuizRepository;

public class QuizViewModel extends ViewModel {
    QuizRepository quizRepository = new QuizRepository();
    LiveData<QuestionList> questionListLiveData ;

    public QuizViewModel() {
    questionListLiveData = quizRepository.getQuestionsFromApi();
    }

    public LiveData<QuestionList> getQuestionListLiveData() {
        return questionListLiveData;
    }
}
