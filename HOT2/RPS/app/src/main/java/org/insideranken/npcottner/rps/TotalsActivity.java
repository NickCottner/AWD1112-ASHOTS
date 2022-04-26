package org.insideranken.npcottner.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class TotalsActivity extends AppCompatActivity {
    Button btnReturnToGame;
    TextView tvThePlayerWins;
    TextView tvTheComputerWins;
    TextView tvTheTies;

    int totalPlayerWins;
    int totalComputerWins;
    int totalTies;

    String playerWins;
    String computerWins;
    String ties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals_acitivity);

        Objects.requireNonNull(getSupportActionBar()).setTitle
                ("Total Wins and Ties");
        tvThePlayerWins = findViewById(R.id.tvThePlayerWins);
        tvTheComputerWins = findViewById(R.id.tvTheComputerWins);
        tvTheTies = findViewById(R.id.tvTheTies);
        btnReturnToGame = findViewById(R.id.btnReturnHome);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if(extras != null)
        {
            if (extras.containsKey("totalPlayerWins"))
            {
                totalPlayerWins = extras.getInt("totalPlayerWins", 0);
            }
            if (extras.containsKey("totalComputerWins"))
            {
                totalComputerWins = extras.getInt("totalComputerWins", 0);
            }
            if (extras.containsKey("totalTies"))
            {
                totalTies = extras.getInt("totalTies", 0);
            }
        }
        playerWins = "Player Wins: " + totalPlayerWins;
        computerWins = "Computer Wins: " + totalComputerWins;
        ties = "Ties: " + totalTies;

        tvThePlayerWins.setText(playerWins);
        tvTheComputerWins.setText(computerWins);
        tvTheTies.setText(ties);

        btnReturnToGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }

        });
    }
}