package com.example.coursework2.service;

import com.example.coursework2.exception.NotEnoughtQuestionsException;
import com.example.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = questionService.getAll();
        if(amount <=0 || amount > questions.size()) {
            throw new NotEnoughtQuestionsException();
        }
        Set<Question> result = new HashSet<>(amount);
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
