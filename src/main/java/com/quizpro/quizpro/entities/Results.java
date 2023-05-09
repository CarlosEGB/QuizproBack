package com.quizpro.quizpro.entities;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Questions question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answers optionAnswer;

    public Results() {
    }

    public Results(long id, Users user, Questions question, Answers optionAnswer) {
        this.id = id;
        this.user = user;
        this.question = question;
        this.optionAnswer = optionAnswer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Answers getOptionAnswer() {
        return optionAnswer;
    }

    public void setOptionAnswer(Answers optionAnswer) {
        this.optionAnswer = optionAnswer;
    }

    @Override
    public String toString() {
        return "Results{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                ", optionAnswer=" + optionAnswer +
                '}';
    }
}
