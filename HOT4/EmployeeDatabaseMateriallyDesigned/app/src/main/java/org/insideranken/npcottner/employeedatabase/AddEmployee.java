package org.insideranken.npcottner.employeedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;

public class AddEmployee extends AppCompatActivity{

    //Widgets
    Button   btnAdd;
    Button btnReturnHome;
    EditText etAddTheName;
    EditText etAddTheId;
    EditText etAddTheDepartment;
    ImageView ivAddNewEmployeeImage;
    int id;
    List<EmployeeModel> employeeModelList;
    MyApplication myApplication = (MyApplication) this.getApplication();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        //  Get references to widgets
        btnAdd     = findViewById(R.id.btnAddEmployee);
        btnReturnHome = findViewById(R.id.btnAddReturnToAllEmployees);
        etAddTheDepartment = findViewById(R.id.etAddTheDEPT);
        etAddTheName  = findViewById(R.id.etAddTheName);
        etAddTheId   = findViewById(R.id.etAddTheID);
        ivAddNewEmployeeImage = findViewById(R.id.ivAddNewEmployeeImage);


        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        EmployeeModel employeeModel = null;

        employeeModelList = myApplication.getEmployeeModelList();

        if (id >= 0)
        {
            //  Edit an existing President
            //  Find the President
            for (EmployeeModel em: employeeModelList) {
                if (em.getEmployeeId() == id)
                {
                   employeeModel = em;
                }
            }

            //  Grab the current President's values and fill
            //  up the corresponding textView and editTexts.
            etAddTheId.setText(String.valueOf(id));
            etAddTheName.setText(employeeModel.getEmployeeName());
            etAddTheDepartment.setText(employeeModel.getEmployeeDepartment());
            ivAddNewEmployeeImage.setImageResource(employeeModel.getEmployeeImage());
        }

        // when clicked, this will save the edited or added personnel info.
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id >= 0)
                {
                    //  Update an existing president
                    EmployeeModel updatedEmployee = new EmployeeModel(
                            id,
                            etAddTheName.getText().toString(),
                            etAddTheDepartment.getText().toString(),
                            ivAddNewEmployeeImage.getResources().getDrawable());

                    //  Add the updated President to the list
                    employeeModelList.set(id, updatedEmployee);
                }
                else {
                    int nextId = myApplication.getNextId();
                    EmployeeModel newEmployee = new EmployeeModel(
                            nextId,
                            etAddTheName.getText().toString(),
                            etAddTheDepartment.getText().toString(),
                    ivAddNewEmployeeImage.setImageResource());

                    employeeModelList.add(newEmployee);
                    myApplication.setNextId(++nextId);
                }

                Intent intent = new Intent(AddEmployee.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //When clicked, return user to opening activity.
        btnReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AddEmployee.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}