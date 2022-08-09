package com.example.coursework2.service;

import com.example.coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
