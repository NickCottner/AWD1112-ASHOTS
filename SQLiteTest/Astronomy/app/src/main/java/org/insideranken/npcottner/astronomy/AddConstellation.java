package org.insideranken.npcottner.astronomy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddConstellation extends AppCompatActivity {
    EditText constellation_name, constellation_family, constellation_latitude, constellation_month;
    Button btnAddConstellation;
    TextView tvConstellationLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_constellation);
        constellation_family = findViewById(R.id.etAddFamily);
        constellation_name = findViewById(R.id.etAddName);
        constellation_latitude = findViewById(R.id.etAddLatitiude);
        constellation_month = findViewById(R.id.etAddMonth);
        btnAddConstellation = findViewById(R.id.btnAdd);
        tvConstellationLink = findViewById(R.id.tvAddConstellationInformation);

        btnAddConstellation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddConstellation.this);
                myDB.AddConstellation(constellation_name.getText().toString().trim(),
                        constellation_family.getText().toString().trim(),
                        constellation_latitude.getText().toString().trim(),
                        constellation_month.getText().toString().trim());
            }
        });

        tvConstellationLink.setMovementMethod(LinkMovementMethod.getInstance());
    }
}