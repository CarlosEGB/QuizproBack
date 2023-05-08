package com.quizpro.quizpro.services;

import com.quizpro.quizpro.entities.Users;
import com.quizpro.quizpro.repositorios.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUser iUser;

    public Users getUser(String id){
        return iUser.findByDni(id);
    }

}
