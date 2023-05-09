package com.quizpro.quizpro.repositorios;

import com.quizpro.quizpro.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends CrudRepository<Users,Long> {

    Users findByDni(String dni);
}
