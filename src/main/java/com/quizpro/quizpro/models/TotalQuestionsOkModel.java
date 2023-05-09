package com.quizpro.quizpro.models;

public class TotalQuestionsOkModel {

    private long numCorrect;
    private long numTotal;

    public TotalQuestionsOkModel() {
    }

    public TotalQuestionsOkModel(long numCorrect, long numTotal) {
        this.numCorrect = numCorrect;
        this.numTotal = numTotal;
    }

    public long getNumCorrect() {
        return numCorrect;
    }

    public void setNumCorrect(int numCorrect) {
        this.numCorrect = numCorrect;
    }

    public long getNumTotal() {
        return numTotal;
    }

    public void setNumTotal(int numTotal) {
        this.numTotal = numTotal;
    }

    @Override
    public String toString() {
        return "TotalQuestionsOkModel{" +
                "numCorrect=" + numCorrect +
                ", numTotal=" + numTotal +
                '}';
    }
}
