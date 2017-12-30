package com.codingblocks.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StudentAdapter studentAdapter = new StudentAdapter(getStudents(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    private ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Amit", "Android", "https://randomuser.me/api/portraits/women/13.jpg"));
        students.add(new Student("Varun", "Android", "https://randomuser.me/api/portraits/women/14.jpg"));
        students.add(new Student("Tanishq", "Android", "https://randomuser.me/api/portraits/women/15.jpg"));
        students.add(new Student("Supriya", "Android", "https://randomuser.me/api/portraits/women/16.jpg"));
        students.add(new Student("Zubia", "Android", "Dwarka"));
        students.add(new Student("Kritika", "Android", "Dwarka"));
        students.add(new Student("Naman", "Android", "Dwarka"));
        students.add(new Student("Ansh", "Android", "Dwarka"));
        students.add(new Student("Rishabh", "Android", "Pitampura"));
        students.add(new Student("Bhavya", "Web", "Pitampura"));
        students.add(new Student("Apoorva", "Web", "Pitampura"));
        students.add(new Student("Aayush", "Web", "Dwarka"));
        students.add(new Student("Amit", "Android", "Dwarka"));
        students.add(new Student("Varun", "Android", "Dwarka"));
        students.add(new Student("Tanishq", "Android", "Dwarka"));
        students.add(new Student("Supriya", "Android", "Dwarka"));
        students.add(new Student("Zubia", "Android", "Dwarka"));
        students.add(new Student("Kritika", "Android", "Dwarka"));
        students.add(new Student("Naman", "Android", "Dwarka"));
        students.add(new Student("Ansh", "Android", "Dwarka"));
        students.add(new Student("Rishabh", "Android", "Pitampura"));
        students.add(new Student("Bhavya", "Web", "Pitampura"));
        students.add(new Student("Apoorva", "Web", "Pitampura"));
        students.add(new Student("Aayush", "Web", "Dwarka"));
        students.add(new Student("Amit", "Android", "Dwarka"));
        students.add(new Student("Varun", "Android", "Dwarka"));
        students.add(new Student("Tanishq", "Android", "Dwarka"));
        students.add(new Student("Supriya", "Android", "Dwarka"));
        students.add(new Student("Zubia", "Android", "Dwarka"));
        students.add(new Student("Kritika", "Android", "Dwarka"));
        students.add(new Student("Naman", "Android", "Dwarka"));
        students.add(new Student("Ansh", "Android", "Dwarka"));
        students.add(new Student("Rishabh", "Android", "Pitampura"));
        students.add(new Student("Bhavya", "Web", "Pitampura"));
        students.add(new Student("Apoorva", "Web", "Pitampura"));
        students.add(new Student("Aayush", "Web", "Dwarka"));
        students.add(new Student("Supriya", "Android", "Dwarka"));
        students.add(new Student("Zubia", "Android", "Dwarka"));
        students.add(new Student("Kritika", "Android", "Dwarka"));
        students.add(new Student("Naman", "Android", "Dwarka"));
        students.add(new Student("Ansh", "Android", "Dwarka"));
        students.add(new Student("Rishabh", "Android", "Pitampura"));
        students.add(new Student("Bhavya", "Web", "Pitampura"));
        students.add(new Student("Apoorva", "Web", "Pitampura"));
        students.add(new Student("Aayush", "Web", "Dwarka"));
        students.add(new Student("Amit", "Android", "Dwarka"));
        students.add(new Student("Varun", "Android", "Dwarka"));
        students.add(new Student("Tanishq", "Android", "Dwarka"));
        students.add(new Student("Supriya", "Android", "Dwarka"));
        students.add(new Student("Zubia", "Android", "Dwarka"));
        students.add(new Student("Kritika", "Android", "Dwarka"));
        students.add(new Student("Naman", "Android", "Dwarka"));
        students.add(new Student("Ansh", "Android", "Dwarka"));
        students.add(new Student("Rishabh", "Android", "Pitampura"));
        students.add(new Student("Bhavya", "Web", "Pitampura"));
        students.add(new Student("Apoorva", "Web", "Pitampura"));
        students.add(new Student("Aayush", "Web", "Dwarka"));

        return students;
    }

}
