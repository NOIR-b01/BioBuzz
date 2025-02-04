package com.example.biologyquizapplication.model;

// This class represents a single question in the quiz.
public class Question {
    private String question; // The question text
    private String[] answers; // An array of possible answers
    private int rightAnswer; // The index of the correct answer in the answers array

    // Constructor to initialize a question with its text, answer choices, and correct answer index
    public Question(String question, String[] answers, int rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    // Getter method to retrieve the question text
    public String getQuestion() {
        return question;
    }

    // Setter method to update the question text
    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter method to retrieve the list of answer choices
    public String[] getAnswers() {
        return answers;
    }

    // Setter method to update the list of answer choices
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    // Getter method to retrieve the index of the correct answer
    public int getRightAnswer() {
        return rightAnswer;
    }

    // Setter method to update the index of the correct answer
    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
