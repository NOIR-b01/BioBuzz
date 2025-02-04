package com.example.biologyquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.biologyquizapplication.model.Question;
import com.example.biologyquizapplication.model.QuestionDataAccess;
import com.example.biologyquizapplication.model.UserAnswersModule;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * MainActivity handles the core gameplay logic of the quiz.
 * - Displays questions and answer options
 * - Tracks the user's score, streak, and answered questions
 * - Transitions to EndGameActivity when the quiz is completed
 */
public class MainActivity extends AppCompatActivity {

    private final int MAX_QUESTIONS = 10; // Maximum number of questions in the quiz

    // UI elements
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewPercent;
    private TextView textViewStreak;
    private AppCompatButton buttonAnswer0;
    private AppCompatButton buttonAnswer1;
    private AppCompatButton buttonAnswer2;
    private AppCompatButton buttonAnswer3;
    private AppCompatButton buttonNext;

    private QuestionDataAccess questionDataAccess; // Handles retrieving quiz questions

    private boolean canAdvance = false; // Controls whether the user can proceed to the next question
    private int SCORE = 0; // Tracks the user's total score
    private int CURRENT_STREAK = 0; // Number of consecutive correct answers
    private int QUESTIONS_ANSWERED_CORRECTLY = 0; // Correct answers count
    private int QUESTIONS_ANSWERED_TOTAL = 0; // Total answered questions count

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews(); // Initialize UI elements
        questionDataAccess = new QuestionDataAccess(); // Initialize question data source

        // Set up click listener for the "Next" button to load a new question
        buttonNext.setOnClickListener(e -> {
            if (canAdvance)
                setNewQuestion();
        });

        startGame(); // Begin the quiz
    }

    /**
     * Finds and initializes UI elements by their ID.
     */
    private void findViews() {
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewPercent = findViewById(R.id.textViewPercentage);
        textViewStreak = findViewById(R.id.textViewStreak);
        textViewScore = findViewById(R.id.textViewScore);
        buttonAnswer0 = findViewById(R.id.buttonAnswer1);
        buttonAnswer1 = findViewById(R.id.buttonAnswer2);
        buttonAnswer2 = findViewById(R.id.buttonAnswer3);
        buttonAnswer3 = findViewById(R.id.buttonAnswer4);
        buttonNext = findViewById(R.id.buttonNext);
    }

    /**
     * Starts a new game by resetting all relevant variables and loading the first question.
     */
    private void startGame() {
        SCORE = 0;
        CURRENT_STREAK = 0;
        QUESTIONS_ANSWERED_CORRECTLY = 0;
        QUESTIONS_ANSWERED_TOTAL = 0;
        updateTopBar();
        setNewQuestion();
    }

    /**
     * Loads a new question and updates the UI accordingly.
     */
    private void setNewQuestion() {
        // Check if the quiz has reached the maximum number of questions
        if (QUESTIONS_ANSWERED_TOTAL >= MAX_QUESTIONS) {
            endGame();
            return;
        }
        canAdvance = false;

        // Retrieve a random question
        Question question = questionDataAccess.getRandomQuestion();
        if (question == null) {
            endGame();
            return;
        }

        // Get question text and answer options
        String questionString = question.getQuestion();
        String[] questionAnswers = question.getAnswers();
        AtomicInteger atomicCorrectAnswer = new AtomicInteger(question.getRightAnswer());

        textViewQuestion.setText(questionString);

        // Array of answer buttons
        AppCompatButton[] answerButtons = {buttonAnswer0, buttonAnswer1, buttonAnswer2, buttonAnswer3};

        // Set answer texts and reset button styles
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i].setText(questionAnswers[i]);
            answerButtons[i].setBackgroundResource(R.drawable.answer_button);
            answerButtons[i].setTextColor(answerButtons[i].getContext().getColor(R.color.my_white));
        }

        // Set click listeners for each answer button
        for (int i = 0; i < answerButtons.length; i++) {
            int answerIndex = i;
            int finalI = i;
            answerButtons[i].setOnClickListener(e -> {
                int correctAnswer = atomicCorrectAnswer.get();
                if (correctAnswer == answerIndex)
                    answeredCorrect(answerButtons[finalI], question);
                else
                    answeredWrong(answerButtons[finalI], answerButtons[correctAnswer], question);
                QUESTIONS_ANSWERED_TOTAL++;
                canAdvance = true;
                updateTopBar();
            });
        }
    }

    /**
     * Updates the top UI bar with the current score, progress, and streak.
     */
    private void updateTopBar() {
        String scoreText = "Score: " + SCORE;
        textViewScore.setText(scoreText);
        String percentText = QUESTIONS_ANSWERED_CORRECTLY + " / " + MAX_QUESTIONS;
        textViewPercent.setText(percentText);
        String streakText = "Streak: " + CURRENT_STREAK;
        textViewStreak.setText(streakText);
    }

    /**
     * Handles the case when the user selects an incorrect answer.
     * Highlights the incorrect and correct answers.
     * @param thisButton The button that the user selected.
     * @param correctButton The button with the correct answer.
     * @param question The question object.
     */
    private void answeredWrong(AppCompatButton thisButton, AppCompatButton correctButton, Question question) {
        UserAnswersModule.wrongQuestions.add(question);
        thisButton.setBackgroundResource(R.drawable.answer_button_wrong);
        thisButton.setTextColor(thisButton.getContext().getColor(R.color.red));
        correctButton.setBackgroundResource(R.drawable.answer_button_correct);
        correctButton.setTextColor(correctButton.getContext().getColor(R.color.aqua));
        CURRENT_STREAK = 0; // Reset streak on a wrong answer
    }

    /**
     * Handles the case when the user selects the correct answer.
     * Highlights the correct answer and updates the score.
     * @param thisButton The button that the user selected.
     * @param question The question object.
     */
    private void answeredCorrect(AppCompatButton thisButton, Question question) {
        UserAnswersModule.correctQuestions.add(question);
        thisButton.setBackgroundResource(R.drawable.answer_button_correct);
        thisButton.setTextColor(thisButton.getContext().getColor(R.color.aqua));

        CURRENT_STREAK++; // Increase streak
        QUESTIONS_ANSWERED_CORRECTLY++; // Increment correct answer count

        // Assign 10 points for each correct answer
        SCORE += 10;
    }

    /**
     * Ends the quiz and navigates to EndGameActivity to display results.
     */
    private void endGame() {
        Intent intent = new Intent(MainActivity.this, EndGameActivity.class);
        UserAnswersModule.score = SCORE;
        startGame(); // Reset the game state before transitioning
        startActivity(intent);
    }
}
