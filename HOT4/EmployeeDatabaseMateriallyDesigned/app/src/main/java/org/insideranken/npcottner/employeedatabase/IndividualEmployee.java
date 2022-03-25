package org.insideranken.npcottner.employeedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IndividualEmployee extends AppCompatActivity {

    TextView tvIndEmployeeName;
    TextView tvIndEmployeeId;
    TextView tvIndEmployeeDepartment;
    ImageView ivIndEmployeeImage;
    Button btnIndEmployeeReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_employee);

        String theName = getIntent().getStringExtra("NAME");
        String theId = getIntent().getStringExtra("ID");
        String theDept = getIntent().getStringExtra("DEPT");
        int theImage = getIntent().getIntExtra("IMAGE",0);

        tvIndEmployeeName = findViewById(R.id.tvIndividualEmployeeName);
        tvIndEmployeeId = findViewById(R.id.tvIndividualEmployeeID);
        tvIndEmployeeDepartment = findViewById(R.id.tvIndividualEmployeeDept);
        ivIndEmployeeImage = findViewById(R.id.ivIndividualEmployeeImage);
        btnIndEmployeeReturnHome = findViewById(R.id.btnIndividualReturnHome);

        tvIndEmployeeName.setText(theName);
        tvIndEmployeeId.setText(theId);
        tvIndEmployeeDepartment.setText(theDept);
        ivIndEmployeeImage.setImageResource(theImage);

        btnIndEmployeeReturnHome.setOnClickListener(new View.OnClickListener() {
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