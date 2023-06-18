 package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

 public class MainActivity extends AppCompatActivity {
    Button b_rock, b_scissors, b_paper;
    TextView tv_score;
    ImageView iv_ComputerChoice, iv_HumanChoice;
    int HumanScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_rock = findViewById(R.id.b_rock);
        b_scissors = findViewById(R.id.b_scissor);
        b_paper = findViewById(R.id.b_paper);
        tv_score = findViewById(R.id.tv_score);
        iv_HumanChoice = findViewById(R.id.iv_HumanChoice);
        iv_ComputerChoice = findViewById(R.id.iv_ComputerChoice);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("you: " + Integer.toString(HumanScore) + "| computer: " + Integer.toString(ComputerScore));

            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("you: " + Integer.toString(HumanScore) + "| computer: " + Integer.toString(ComputerScore));
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("you: " + Integer.toString(HumanScore) + "| computer: " + Integer.toString(ComputerScore));
            }
        });
    }

    public String play_turn(String player_choice) {
         String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3) + 1;
        if (computer_choice_number == 1) {
            computer_choice = "rock";
        } else if (computer_choice_number == 2) {
            computer_choice = "scissors";
        } else if (computer_choice_number == 3) {
            computer_choice = "paper";
        }

        if (computer_choice == "rock") {
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        } else if (computer_choice == "scissors") {
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        } else if (computer_choice == "paper") {
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }


        if (computer_choice == player_choice) {
            return "Draw. Nobody won!";
        } else if (player_choice == "rock" && computer_choice == "scissors") {
            HumanScore++;
            return "Rock crushes scissors. You won!";
        } else if (player_choice == "rock" && computer_choice == "paper") {
            ComputerScore++;
            return "Paper covers rock. Computer Won!";
        } else if (player_choice == "scissors" && computer_choice == "rock") {
            ComputerScore++;
            return "Rock crushes scissors, Computer Won!";
        } else if (player_choice == "scissors" && computer_choice == "paper") {
            HumanScore++;
            return "Scissors cuts paper. You won!";
        } else if (player_choice == "paper" && computer_choice == "rock") {
            HumanScore++;
            return "Papers covers rock. You won!";
        } else if (player_choice == "paper" && computer_choice == "scissors") {
            ComputerScore++;
            return "Scissors cuts paper. Computer wins";
        }
        return "not so sure!";
    }
}