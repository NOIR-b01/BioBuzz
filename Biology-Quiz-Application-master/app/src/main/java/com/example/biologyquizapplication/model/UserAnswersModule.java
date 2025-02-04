package com.example.biologyquizapplication.model;

import java.util.ArrayList;

// This class keeps track of user answers, including correct and incorrect responses
public class UserAnswersModule {
    // Stores questions that have already been used
    public static ArrayList<Question> usedQuestions = new ArrayList<>();

    // Stores questions answered correctly by the user
    public static ArrayList<Question> correctQuestions = new ArrayList<>();

    // Stores questions answered incorrectly by the user
    public static ArrayList<Question> wrongQuestions = new ArrayList<>();

    // Keeps track of the user's score
    public static int score = 0;
}
