package org.insideranken.npcottner.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class totalsActivity extends AppCompatActivity {
    TextView tvDubaiConversions;
    TextView tvEuroConversions;
    TextView tvYenConversions;
    TextView tvUsConversions;
    TextView tvNairaConversions;
    TextView tvNzdConversions;
    Button btnTotalsReturnToConverter;

    int totalUsConversions;
    int totalEuroConversions;
    int totalDirhamConversions;
    int totalYenConversions;
    int totalNairaConversions;
    int totalNzdConvervsions;

    String yenConversions;
    String euroConversions;
    String dirhamConversions;
    String nairaConversions;
    String nzdConversions;
    String usConversions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);

        tvDubaiConversions = findViewById(R.id.tvDubaiConversions);
        tvEuroConversions = findViewById(R.id.tvEuroConversions);
        tvNairaConversions = findViewById(R.id.tvNairaConversions);
        tvUsConversions = findViewById(R.id.tvUsConversions);
        tvYenConversions = findViewById(R.id.tvYenConversions);
        tvNzdConversions = findViewById(R.id.tvNzdConversions);
        btnTotalsReturnToConverter = findViewById(R.id.btnTotalsReturnHome);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            if (extras.containsKey("totalUsConversions")) {
                totalUsConversions = extras.getInt("totalUsConversions", 0);
            }
            if (extras.containsKey("totalEuroConversions")) {
                totalEuroConversions = extras.getInt("totalEuroConversions", 0);
            }
            if (extras.containsKey("totalDirhamConversions")) {
                totalDirhamConversions = extras.getInt("totalDirhamConversions", 0);
            }
            if (extras.containsKey("totalYenConversions")) {
                totalYenConversions = extras.getInt("totalYenConversions", 0);
            }
            if (extras.containsKey("totalNairaConversions")) {
                totalNairaConversions = extras.getInt("totalNairaConversions", 0);
            }
            if (extras.containsKey("totalNzdConvervsions")) {
                totalNzdConvervsions = extras.getInt("totalNzdConvervsions", 0);
            }
        }
        yenConversions = "Total Japanese Yen Converions: " + totalYenConversions;
        usConversions = "Total US Dollar Converions: " + totalUsConversions;
        euroConversions = "Total Euro Converions: " + totalEuroConversions;
        nzdConversions = "Total New Zealand Dollar Converions: " + totalNzdConvervsions;
        nairaConversions = "Total Nigerian Naira Converions: " + totalNairaConversions;
        dirhamConversions = "Total Dubai Dirham Converions: " + totalDirhamConversions;

        tvNzdConversions.setText(nzdConversions);
        tvYenConversions.setText(yenConversions);
        tvUsConversions.setText(usConversions);
        tvNairaConversions.setText(nairaConversions);
        tvEuroConversions.setText(euroConversions);
        tvDubaiConversions.setText(dirhamConversions);

        btnTotalsReturnToConverter.setOnClickListener(v -> {
            Intent totalsReturnIntent = new Intent(getApplicationContext(), MainActivity.class);

            totalsReturnIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(totalsReturnIntent);
            this.finish();
        });
    }
}