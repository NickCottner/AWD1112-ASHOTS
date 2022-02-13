package org.insideranken.npcottner.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Totals extends AppCompatActivity {

    Button btnTotalsReturnToGame;
    TextView tvTotNumPlayerWins;
    TextView tvTotNumComputerWins;
    TextView tvTotalNumTies;

    int totalPlayerWins;
    int totalComputerWins;
    int totalTies;

    String playerWins;
    String computerWins;
    String ties;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);
        btnTotalsReturnToGame = findViewById(R.id.btnTotalsReturnToGame);
        tvTotNumPlayerWins = findViewById(R.id.tvTotNumPlayerWins);
        tvTotNumComputerWins = findViewById(R.id.tvTotNumComputerWins);
        tvTotalNumTies = findViewById(R.id.tvTotalNumTies);

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
        playerWins = "Total Player Wins: " + totalPlayerWins;
        computerWins = "Total Computer Wins: " + totalComputerWins;
        ties = "Total Ties: " + totalTies;

        tvTotNumPlayerWins.setText(playerWins);
        tvTotNumComputerWins.setText(computerWins);
        tvTotalNumTies.setText(ties);

        btnTotalsReturnToGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }

        });
    }
}