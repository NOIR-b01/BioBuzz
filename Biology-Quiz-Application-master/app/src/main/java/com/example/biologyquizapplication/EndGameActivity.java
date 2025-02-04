package com.example.biologyquizapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.biologyquizapplication.model.Question;
import com.example.biologyquizapplication.model.UserAnswersModule;

import java.util.ArrayList;

/**
 * EndGameActivity is the final screen of the quiz application.
 * It displays the user's score and a summary of the answered questions.
 * Users can also start a new game from this screen.
 */
public class EndGameActivity extends AppCompatActivity {

    // Container to hold the list of answered questions
    private LinearLayoutCompat container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game); // Set the layout for the end game screen

        // Reference to the TextView that displays the user's final score
        TextView textViewEndGameScore = findViewById(R.id.textViewEndGameScore);

        // Reference to the container where questions will be displayed
        container = findViewById(R.id.linearLayoutContainer);

        // Reference to the button that starts a new game
        AppCompatButton buttonNewGame = findViewById(R.id.buttonStartNewGame);

        // Retrieve the list of questions that the user answered during the quiz
        ArrayList<Question> questions = UserAnswersModule.usedQuestions;

        // Loop through the answered questions and add them to the screen
        for (Question q : questions) {
            addCard(q);
        }

        // Display the final score with "PT" appended (e.g., "10PT")
        String scoreText = UserAnswersModule.score + "PT";
        textViewEndGameScore.setText(scoreText);

        // Set a click listener on the "Start New Game" button to restart the quiz
        buttonNewGame.setOnClickListener(e -> {
            Intent intent = new Intent(EndGameActivity.this, MainActivity.class);
            startActivity(intent); // Navigate back to the main activity (quiz start screen)
        });
    }

    /**
     * Adds a question card to the container, displaying the question and correct answer.
     * @param question The Question object to display.
     */
    private void addCard(Question question) {
        // Get the question text and correct answer
        String questionText = question.getQuestion();
        String correctAnswer = question.getAnswers()[question.getRightAnswer()];

        // Inflate a new question overview layout
        @SuppressLint("InflateParams")
        View view = getLayoutInflater().inflate(R.layout.question_overview, null);

        // Find the TextViews inside the inflated layout
        TextView textViewQuestion = view.findViewById(R.id.textViewEndGameQuestion);
        TextView textViewAnswer = view.findViewById(R.id.textViewEndGameAnswer);

        // Set the question and answer text
        textViewQuestion.setText(questionText);
        textViewAnswer.setText(correctAnswer);

        // Add the question card to the container layout
        container.addView(view);
    }
}
