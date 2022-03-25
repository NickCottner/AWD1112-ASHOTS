package org.insideranken.npcottner.employeedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAddEmployee;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Menu menu;

    List<EmployeeModel> employeeList;

    MyApplication myApplication = new MyApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication.checkIfFirstTimeInitiate();
        employeeList = MyApplication.getEmployeeModelList();

        //  Get references to widgets
        btnAddEmployee  = findViewById(R.id.btnMainActivityAddEmployee);
        recyclerView     = findViewById(R.id.allEmployeesRecyclerView);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new rvEmployeeAdapter(employeeList, this);
        recyclerView.setAdapter(adapter);


        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEmployee.class);
                startActivity(intent);
            }
        });
    }
    // Creates menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    // the menu items that allow user to choose how to display items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.employeeSearchAscending:
                Collections.sort(employeeList, EmployeeModel.employeeSearchAscendingComparator);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.employeeSearchDescending:
                Collections.sort(employeeList, EmployeeModel.employeeSearchDescendingComparator);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.departmentSearchAscending:
                Collections.sort(employeeList, EmployeeModel.deptSearchAscendingComparator);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.departmentSearchDescending:
                Collections.sort(employeeList, EmployeeModel.deptSearchDescendingComparator);
                adapter.notifyDataSetChanged();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}