package com.quizpro.quizpro.repositorios;

import com.quizpro.quizpro.entities.Results;
import com.quizpro.quizpro.models.TotalQuestionsOkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IResults extends JpaRepository<Results, Long> {

    @Query("SELECT new com.quizpro.quizpro.models.TotalQuestionsOkModel(COALESCE(SUM(CASE WHEN a.isCorrect = true THEN 1 ELSE 0 END),0), COUNT(r.question.id)) " +
            "FROM Results r INNER JOIN r.optionAnswer a " +
            "WHERE r.user.id = :userId AND r.question.id = :questionId")
    TotalQuestionsOkModel totalAnswersForQuestionAndUser(@Param("userId") Long userId,
                                                         @Param("questionId") Long questionId);
}
