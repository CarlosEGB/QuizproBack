package com.quizpro.quizpro.services;

import com.quizpro.quizpro.entities.Users;
import com.quizpro.quizpro.repositorios.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUser iUser;

    public Users authenticate(String users, String passwordActual) {
        Users userExpected = iUser.findByUser(users);
        if (userExpected != null && verifyPassword(passwordActual, userExpected.getPassword())) {
            return userExpected;
        }
        return null;
    }

    public List<Users> getListUsers() {
        return (List<Users>) iUser.findAll();
    }

    private boolean verifyPassword(String actual, String expected) {
        return actual.equals(expected);
    }


}
