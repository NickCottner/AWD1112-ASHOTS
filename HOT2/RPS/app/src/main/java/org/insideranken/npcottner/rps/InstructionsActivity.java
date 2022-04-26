package org.insideranken.npcottner.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class InstructionsActivity extends AppCompatActivity {
    Button btnPlayOnInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        btnPlayOnInstructions = findViewById(R.id.btnPlayOnInstructions);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Instructions & How To Win");

        btnPlayOnInstructions.setOnClickListener(view -> {
            Intent intent = new Intent(InstructionsActivity.this, GameActivity.class);
            startActivity(intent);
        });
    }
}