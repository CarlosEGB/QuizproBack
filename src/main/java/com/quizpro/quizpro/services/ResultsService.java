package com.quizpro.quizpro.services;

import com.quizpro.quizpro.entities.Results;
import com.quizpro.quizpro.models.TotalQuestionsOkModel;
import com.quizpro.quizpro.repositorios.IResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsService {

    @Autowired
    private IResults iResults;

    public Results getResultQuestion(long id) {
        return iResults.findById(id).get();
    }

    public Results saveResultQuestion(Results result) {
        return iResults.save(result);
    }

    public TotalQuestionsOkModel getTotalQuestionsOk(Long userId, Long questionId) {
        return iResults.totalAnswersForQuestionAndUser(userId, questionId);
    }
}
