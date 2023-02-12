package com.quizpro.quizpro.repositorios;

import com.quizpro.quizpro.entities.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestion extends CrudRepository<Questions,Long>{

}
