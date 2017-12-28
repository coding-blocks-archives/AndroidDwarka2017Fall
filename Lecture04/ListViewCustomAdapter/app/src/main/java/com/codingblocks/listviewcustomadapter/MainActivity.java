package com.codingblocks.listviewcustomadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = findViewById(R.id.listView);
        KotlinAdapter studentAdapter = new KotlinAdapter(this, getStudents());
        gridView.setNumColumns(2);
        gridView.setAdapter(studentAdapter);
    }

    private ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
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
