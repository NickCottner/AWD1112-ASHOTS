package org.insideranken.npcottner.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class helpScreen extends AppCompatActivity {
    TextView tvInstructions;
    Button btnHelpReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        tvInstructions = findViewById(R.id.tvInstructions);
        btnHelpReturnHome = findViewById(R.id.btnHelpReturnHome);

        tvInstructions.setText("1. Enter An Amount To Convert In EditText Below Currency Converter" +
                               "\n2. Choose What Nation To Convert From" +
                                "\n3. Choose What Nation To Convert To" +
                               "\n4. Click The Button That Says Convert" +
                               "\n5. Conversion Will Show In Conversion Shows Here" +
                                "\n6. Click Help On Activity Main To View These Instructions Again" +
                                "\n7. Finally Click Totals To View Total Conversions of Each Currency");

        btnHelpReturnHome.setOnClickListener(v -> {
            Intent helpReturnIntent = new Intent(getApplicationContext(), MainActivity.class);

            helpReturnIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(helpReturnIntent);
            finish();
        });
    }
}