package org.insideranken.npcottner.rankenemployeesrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    // Declare Widgets
    Button btnAddEmployee;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    Menu menu;

    List<Employee> employeeList;

    MyApplication myApplication = (MyApplication) this.getApplication();

    //Initialization code goes here.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication.checkIfFirstTimeInitiate();
        employeeList = MyApplication.getEmployeeList();

        //  Get references to widgets
        btnAddEmployee  = findViewById(R.id.btnAddEmployee);
        recyclerView     = findViewById(R.id.rvEmployees);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //Adapter creates Viewholder objects as needed and sets the data for those views.
        // This process is called binding.
        mAdapter = new rvEmployeeAdapter(employeeList, this);
        recyclerView.setAdapter(mAdapter);

        // When the Add President button is clicked, the AddPresident activity will open
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
                Collections.sort(employeeList, Employee.employeeSearchAscendingComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.employeeSearchDescending:
                Collections.sort(employeeList, Employee.employeeSearchDescendingComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.departmentSearchAscending:
                Collections.sort(employeeList, Employee.deptSearchAscendingComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.departmentSearchDescending:
                Collections.sort(employeeList, Employee.deptSearchDescendingComparator);
                mAdapter.notifyDataSetChanged();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}