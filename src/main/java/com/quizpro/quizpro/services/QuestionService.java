package com.quizpro.quizpro.services;

import com.quizpro.quizpro.entities.Answers;
import com.quizpro.quizpro.entities.Questions;
import com.quizpro.quizpro.repositorios.IAnswer;
import com.quizpro.quizpro.repositorios.IQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private IQuestion iQuestion;

    @Autowired
    private IAnswer iAnswer;

    public Questions getQuestion(long id) {
        return iQuestion.findById(id).get();
    }

    public List<Questions> getAllQuestions() {
        return (List<Questions>) iQuestion.findAll();
    }

    public Questions addQuestion(Questions question) {
        Questions savedQuestion = iQuestion.save(question);

        for (Answers answer : question.getAnswers()) {
            answer.setQuestion(savedQuestion);
            iAnswer.save(answer);
        }

        return iQuestion.findById(savedQuestion.getId()).get();
    }

    public Questions updateQuestion(Questions question) {
        Questions updateQuestion = iQuestion.save(question);

        for (Answers answer : question.getAnswers()) {
            answer.setQuestion(updateQuestion);
            iAnswer.save(answer);
        }

        return iQuestion.findById(updateQuestion.getId()).get();
    }

    public void deleteQuestion(long id) {
        Optional<Questions> question = iQuestion.findById(id);
        question.ifPresent(questions -> iAnswer.deleteAll(questions.getAnswers()));
        iQuestion.deleteById(id);
    }
}
