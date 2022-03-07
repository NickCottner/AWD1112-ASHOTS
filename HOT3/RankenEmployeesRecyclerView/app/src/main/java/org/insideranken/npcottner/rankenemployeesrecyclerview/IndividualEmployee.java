package org.insideranken.npcottner.rankenemployeesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        tvIndEmployeeName = findViewById(R.id.tvIndEmployeeName);
        tvIndEmployeeId = findViewById(R.id.tvIndEmployeeId);
        tvIndEmployeeDepartment = findViewById(R.id.tvIndEmployeeDept);
        ivIndEmployeeImage = findViewById(R.id.ivIndEmployee);
        btnIndEmployeeReturnHome = findViewById(R.id.btnIndEmployeeReturnHome);

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