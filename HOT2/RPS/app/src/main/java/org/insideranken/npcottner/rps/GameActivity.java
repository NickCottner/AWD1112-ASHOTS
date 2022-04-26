package org.insideranken.npcottner.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class GameActivity extends AppCompatActivity {
    Button btnTotals, btnRestart;
    ImageView ivPlayer, ivComputer, ivRock, ivPaper, ivScissors;

    int totalPlayerWins = 0;
    int totalComputerWins = 0;
    int totalTies = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btnRestart = findViewById(R.id.btnRestartGameActivity);
        btnTotals = findViewById(R.id.btnTotalsGameActivity);
        ivPlayer = findViewById(R.id.ivPlayerImage);
        ivComputer = findViewById(R.id.ivComputerImage);
        ivRock = findViewById(R.id.ivRock);
        ivPaper = findViewById(R.id.ivPaper);
        ivScissors = findViewById(R.id.ivScissors);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Game Time");

        btnRestart.setOnClickListener(v -> clearGame());
        btnTotals.setOnClickListener(v -> {
            Bundle extras = new Bundle();
            extras.putInt("totalPlayerWins", totalPlayerWins);
            extras.putInt("totalComputerWins", totalComputerWins);
            extras.putInt("totalTies", totalTies);

            Intent intent = new Intent(getApplicationContext(), TotalsActivity.class);

            intent.putExtras(extras);
            startActivity(intent);
        });
        ivRock.setOnClickListener(v -> {
            ivPlayer.setImageDrawable(getDrawable(R.drawable.rock));

            int computerMove = (int) (Math.random() * 3);

            if (computerMove == 1)
            {
                ivComputer.setImageDrawable(getDrawable(R.drawable.rock));

                Toast.makeText(getApplicationContext(), "You Both Chose Rock",
                        Toast.LENGTH_SHORT).show();
                totalTies++;
            }
            else if(computerMove == 2)
            {
                ivComputer.setImageDrawable(getDrawable(R.drawable.paper));
                Toast.makeText(getApplicationContext(), "Computer Wins",
                        Toast.LENGTH_SHORT).show();
                totalComputerWins++;
            }
            else
            {
                ivComputer.setImageDrawable(getDrawable(R.drawable.scissors));
                Toast.makeText(getApplicationContext(), "Player Wins",
                        Toast.LENGTH_SHORT).show();
                totalPlayerWins++;
            }
        });
        ivPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPlayer.setImageDrawable(getDrawable(R.drawable.paper));

                int computerMove = (int) (Math.random() * 3);

                if (computerMove == 1)
                {
                    ivComputer.setImageDrawable(getDrawable(R.drawable.rock));

                    Toast.makeText(getApplicationContext(), "Player Wins",
                            Toast.LENGTH_SHORT).show();
                    totalPlayerWins++;
                }
                else if(computerMove == 2)
                {
                    ivComputer.setImageDrawable(getDrawable(R.drawable.paper));
                    Toast.makeText(getApplicationContext(), "You Both Chose Paper",
                            Toast.LENGTH_SHORT).show();
                    totalTies++;
                }
                else
                {
                    ivComputer.setImageDrawable(getDrawable(R.drawable.scissors));
                    Toast.makeText(getApplicationContext(), "Computer Wins",
                            Toast.LENGTH_SHORT).show();
                    totalComputerWins++;
                }
            }
        });
        ivScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPlayer.setImageDrawable(getDrawable(R.drawable.scissors));

                int computerMove = (int) (Math.random() * 3);

                if (computerMove == 1)
                {
                    ivComputer.setImageDrawable(getDrawable(R.drawable.rock));

                    Toast.makeText(getApplicationContext(), "Computer Wins",
                            Toast.LENGTH_SHORT).show();
                    totalComputerWins++;
                }
                else if(computerMove == 2)
                {
                    ivComputer.setImageDrawable(getDrawable(R.drawable.paper));
                    Toast.makeText(getApplicationContext(), "Player Wins",
                            Toast.LENGTH_SHORT).show();
                    totalPlayerWins++;
                }
                else
                {
                    ivComputer.setImageDrawable(getDrawable(R.drawable.scissors));
                    Toast.makeText(getApplicationContext(), "Player Wins",
                            Toast.LENGTH_SHORT).show();
                    totalTies++;
                }
            }
        });
    }
    public void clearGame()
    {
        ivComputer.setImageDrawable(getDrawable(R.drawable.controller));
        ivPlayer.setImageDrawable(getDrawable(R.drawable.controller));
    }
}