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

        tvInstructions.setText("1. Choose What Nation You Want to Convert Your Currency From" +
                               "\n2.Choose What Nation You Want To Convert Your Currency To" +
                               "\n3.Enter An Amount To Convert In The Text Box Reading " +
                               "\n\tEnter An Amount > 0 To Convert" +
                               "\n4. Click The Button That Says Convert" +
                               "\n5. Conversion Will Show In TextView ThaT Says Converted Amount" +
                                "\n6.Click Help On Activity Main To View These Instructions Again" +
                                "\n7.Finally Click Totals To View Total Conversions of Each Currency");

        btnHelpReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}