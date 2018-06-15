package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int player1Score = 0;
    int player2Score = 0;
    boolean isturn1 = true;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, resetButton, startButton;
    Button ready_player_1, ready_player_2, quit_player_1, quit_player_2;
    EditText player1Name, player2Name;
    TextView roundCount;
    int countNoOfRounds = 1;
    boolean isReadyPlayer_1 = false;
    boolean isReadyPlayer_2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.addOneButton);
        button2 = (Button) findViewById(R.id.addTwoButton);
        button3 = (Button) findViewById(R.id.addThreeButton);
        button4 = (Button) findViewById(R.id.addFourButton);
        button5 = (Button) findViewById(R.id.addFiveButton);
        button6 = (Button) findViewById(R.id.addSixButton);
        button7 = (Button) findViewById(R.id.addSevenButton);
        button8 = (Button) findViewById(R.id.addEightButton);
        button9 = (Button) findViewById(R.id.addNineButton);
        button10 = (Button) findViewById(R.id.addTenButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        ready_player_1 = (Button) findViewById(R.id.ready_1_Button);
        ready_player_2 = (Button) findViewById(R.id.ready_2_Button);
        quit_player_1 = (Button) findViewById(R.id.quit_1_Button);
        quit_player_2 = (Button) findViewById(R.id.quit_2_Button);
        startButton = (Button) findViewById(R.id.startButton);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        startButton.setOnClickListener(this);
        ready_player_1.setOnClickListener(this);
        ready_player_2.setOnClickListener(this);
        quit_player_1.setOnClickListener(this);
        quit_player_2.setOnClickListener(this);

        player1Name = (EditText) findViewById(R.id.player_1_name);
        player2Name = (EditText) findViewById(R.id.player_2_name);

        disableAllButtons();
        }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ready_1_Button:
                isReadyPlayer_1 = true;
                areBothPlayersReady();
                break;
            case R.id.ready_2_Button:
                isReadyPlayer_2 = true;
                areBothPlayersReady();
                break;
            case R.id.startButton:
                enableAllButtons();
                break;
            case R.id.quit_1_Button:
                player_1_quit();
                break;
            case R.id.quit_2_Button:
                player_2_quit();
                break;

            case R.id.addOneButton:
                add(1);
                break;
            case R.id.addTwoButton:
                add(2);
                break;
            case R.id.addThreeButton:
                add(3);
                break;
            case R.id.addFourButton:
                add(4);
                break;
            case R.id.addFiveButton:
                add(5);
                break;
            case R.id.addSixButton:
                add(6);
                break;
            case R.id.addSevenButton:
                add(7);
                break;
            case R.id.addEightButton:
                add(8);
                break;
            case R.id.addNineButton:
                add(9);
                break;
            case R.id.addTenButton:
                add(10);
                break;
            case R.id.resetButton:
                reset();
                break;
        }
    }

    public void add(int score) {
        if (isturn1) {
            player1Score = player1Score + score;
            displayPlayer1(player1Score);
            displayTurn();
            isturn1 = false;

        } else {
            countNoOfRounds++;
            player2Score = player2Score + score;
            displayPlayer2(player2Score);
            displayTurn();
            setRoundCount();
            isturn1 = true;
        }
    }

    public void displayPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));

    }

    public void displayPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTurn() {
        String name1, name2;
        TextView playerturn = (TextView) findViewById(R.id.playerTurn);
        if (countNoOfRounds == 6) {
            name1 = player1Name.getText().toString();
            name2 = player2Name.getText().toString();

            if (player1Score > player2Score) {
                playerturn.setText(name1 + " is the winner with score : " + player1Score + "\n" + name2 + " scored : " + player2Score);
            } else if (player2Score > player1Score) {
                playerturn.setText(name2 + " is the winner with score : " + player2Score + "\n" + name1 + " scored :" + player1Score);
            } else {
                playerturn.setText("Draw !" + "\nBoth players scored :" + player1Score);
            }
            reset();
        } else if (isturn1) {
            name2 = player2Name.getText().toString();
            playerturn.setText(name2 + " 's turn");
        } else {
            name1 = player1Name.getText().toString();
            playerturn.setText(name1 + " 's turn");
        }
    }

    public void setRoundCount() {
        roundCount = (TextView) findViewById(R.id.roundCount);
        roundCount.setText(String.valueOf(countNoOfRounds));
    }

    public void areBothPlayersReady() {
        if (isReadyPlayer_1 && isReadyPlayer_2)
            startButton.setEnabled(true);
    }

    public void disableAllButtons() {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
        button10.setEnabled(false);
        startButton.setEnabled(false);
        quit_player_1.setEnabled(false);
        quit_player_2.setEnabled(false);
        resetButton.setEnabled(false);
    }

    public void enableAllButtons() {

        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        button10.setEnabled(true);
        quit_player_1.setEnabled(true);
        quit_player_2.setEnabled(true);
        resetButton.setEnabled(true);
    }

    public void player_2_quit() {
        String name1, name2;
        name1 = player1Name.getText().toString();
        name2 = player2Name.getText().toString();
        TextView playerturn = (TextView) findViewById(R.id.playerTurn);
        playerturn.setText(name2 + " has chose to Quit.\n" + name1 + " is the winner");
        reset();
    }

    public void player_1_quit() {
        String name1, name2;
        name1 = player1Name.getText().toString();
        name2 = player2Name.getText().toString();
        TextView playerturn = (TextView) findViewById(R.id.playerTurn);
        playerturn.setText(name1 + " has chose to Quit.\n" + name2 + " is the winner");
        reset();
    }

    public void reset() {
        countNoOfRounds = 1;
        player1Score = 0;
        player2Score = 0;
        displayPlayer1(player1Score);
        displayPlayer2(player2Score);
        setRoundCount();
        disableAllButtons();
        isReadyPlayer_1 = false;
        isReadyPlayer_2 = false;
    }
}
