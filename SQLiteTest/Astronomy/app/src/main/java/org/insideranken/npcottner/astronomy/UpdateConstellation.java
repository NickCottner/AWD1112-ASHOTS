package org.insideranken.npcottner.astronomy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateConstellation extends AppCompatActivity {

    EditText etUpdateName, etUpdateFamily, etUpdateLatitude, etUpdateMonth;
    Button btnUpdate, btnDelete;
    String id, name, family, latitude, month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_constellation);

        etUpdateName = findViewById(R.id.etUpdateName);
        etUpdateFamily = findViewById(R.id.etUpdateFamily);
        etUpdateLatitude = findViewById(R.id.etUpdateLatitude);
        etUpdateMonth = findViewById(R.id.etUpdateMonth);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        getAndSetIntentData();
        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateConstellation.this);
                myDB.updateData(id, name, family, latitude, month);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }
    void getAndSetIntentData()
    {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("family") && getIntent().hasExtra("latitude") &&
                getIntent().hasExtra("month"))
        {
            //Getting Data From Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            family = getIntent().getStringExtra("family");
            latitude = getIntent().getStringExtra("latitude");
            month = getIntent().getStringExtra("month");

            //Setting Intent Data
            etUpdateName.setText(name);
            etUpdateFamily.setText(family);
            etUpdateLatitude.setText(latitude);
            etUpdateMonth.setText(month);
        }
        else
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateConstellation.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}