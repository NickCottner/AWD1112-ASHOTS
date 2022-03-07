package org.insideranken.npcottner.rankenemployeesrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddEmployee extends AppCompatActivity {
    Button btnAddNew;
    Button btnCancel;
    Button btnAddReturnHome;
    EditText etEmployeeName;
    EditText etEmployeeDepartment;
    EditText etEmployeeImage;
    EditText etEmployeeID;
    int employeeId;
    List<Employee> employeeList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        //  Get references to widgets
        btnAddNew     = findViewById(R.id.btnAddEmployeeAdd);
        btnCancel   = findViewById(R.id.btnAddEmployeeCancel);
        btnAddReturnHome = findViewById(R.id.btnAddEmployeeReturnHome);
        etEmployeeName = findViewById(R.id.etEmployeeName);
        etEmployeeDepartment   = findViewById(R.id.etEmployeeDept);
        etEmployeeImage  = findViewById(R.id.etEmployeeImage);
        etEmployeeID     = findViewById(R.id.etEmployeeId);

        Intent intent = getIntent();
        employeeId = intent.getIntExtra("id", -1);
        Employee employee = null;

        employeeList = MyApplication.getEmployeeList();

        if (employeeId >= 0)
        {
            //  Edit an existing President
            //  Find the President
            for (Employee e: employeeList) {
                if (e.getEmployeeId() == employeeId)
                {
                    employee = e;
                }
            }

            //  Grab the current President's values and fill
            //  up the corresponding textView and editTexts.
            etEmployeeID.setText(String.valueOf(employeeId));
            etEmployeeName.setText(employee.getEmployeeName());
            etEmployeeDepartment.setText(employee.getEmployeeDepartment());
            etEmployeeImage.setText(employee.getEmployeeImage());
        }

        // when clicked, this will save the edited or added personnel info.
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (employeeId >= 0)
                {
                    //  Update an existing president
                    Employee updatedEmployee = new Employee(
                            employeeId,
                            etEmployeeName.getText().toString(),
                            etEmployeeDepartment.getText().toString(),
                            etEmployeeImage.getText().toString());

                    //  Add the updated President to the list
                    employeeList.set(employeeId, updatedEmployee);
                }
                else {
                    //  Put all below into a try/catch block!!!
                    //  Create a new President object
                    int nextId = MyApplication.getNextId();
                    Employee newEmployee = new Employee(
                            nextId,
                            etEmployeeName.getText().toString(),
                            etEmployeeDepartment.getText().toString(),
                            etEmployeeImage.getText().toString());
                    employeeList.add(newEmployee);
                    MyApplication.setNextId(++nextId);
                }

                Intent intent = new Intent(AddEmployee.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //When clicked, return user to opening activity.
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AddEmployee.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
