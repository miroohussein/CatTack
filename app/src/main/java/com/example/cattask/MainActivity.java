package com.example.cattask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cattask.recyclerView.EmployeeAdabter;
import com.example.cattask.recyclerView.EmployeePojo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<EmployeePojo> employeePojos = new ArrayList<>();
        employeePojos.add(new EmployeePojo("Ahmed", "Mechanical Engineer", R.drawable.man));
        employeePojos.add(new EmployeePojo("Marwa", "Software Engineer", R.drawable.girl));
        employeePojos.add(new EmployeePojo("Samy", "civil Engineer", R.drawable.man));
        employeePojos.add(new EmployeePojo("nahla", "Arch Engineer", R.drawable.girlcurly));
        employeePojos.add(new EmployeePojo("Nadin", "HR", R.drawable.girl));
        employeePojos.add(new EmployeePojo("Khalid", "Pr", R.drawable.man));
        employeePojos.add(new EmployeePojo("Ramy", "DB manager", R.drawable.man));
        employeePojos.add(new EmployeePojo("lila", "Marketing", R.drawable.girlcurly));
        employeePojos.add(new EmployeePojo("Mariam", "Assistance", R.drawable.girl));

        RecyclerView recyclerView = findViewById(R.id.rv);
        EmployeeAdabter employeeAdabter = new EmployeeAdabter(employeePojos, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeAdabter);

    }
}