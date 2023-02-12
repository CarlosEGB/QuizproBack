package com.quizpro.quizpro.repositorios;

import com.quizpro.quizpro.entities.Answers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswer extends CrudRepository<Answers,Long> {

}
