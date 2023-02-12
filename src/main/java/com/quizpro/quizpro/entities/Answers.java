package com.quizpro.quizpro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String answer;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "question_id")
    private Questions question;

    public Answers() {
    }

    public Answers(long id, String answer, boolean isCorrect, Questions question) {
        this.id = id;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                ", question=" + question +
                '}';
    }
}
