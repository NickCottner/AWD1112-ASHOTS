package org.insideranken.npcottner.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpScreen extends AppCompatActivity {
    Button btnReturnToGame;
    TextView tvRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        btnReturnToGame = findViewById(R.id.btnReturnToGame);
        tvRules = findViewById(R.id.tvRules);

        tvRules.setText("1. Player Chooses First" +
                        "\n2. You Are To Click on Rock, Paper, or Scissors Image" +
                        "\n#. After Choosing Your Suit, The Computer Chooses" +
                        "\n4. How To Win, is Displayed Below");

        btnReturnToGame.setOnClickListener(new View.OnClickListener()
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