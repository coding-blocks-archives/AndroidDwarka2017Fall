package com.example.supriya.todolist1;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
int value;
Activity activity;
String topic="";
String des="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = MainActivity.this;
        //this command returns int value 1 for Portrait and 2 for Landscape
        value=activity.getResources().getConfiguration().orientation;
        if (value == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
            final ArrayList<Note> notes = new ArrayList<>();
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            final NoteAdapter noteAdapter = new NoteAdapter(notes);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            //use false for having a simple straight layout
            //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
            //span count gives: no of columns required
            //StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL;)

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(noteAdapter);
            Button bt1=findViewById(R.id.bt);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText et1 = findViewById(R.id.et1);
                    EditText et2 = findViewById(R.id.et2);
                    topic=et1.getText().toString();
                    des=et2.getText().toString();
                    notes.add(new Note(topic,des));
                    noteAdapter.notifyItemInserted(notes.size());
                    et1.setText("");
                    et2.setText("");

                }
            });

        }

        if (value == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.land);
            final ArrayList<Note> notes = new ArrayList<>();
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            final NoteAdapter1 noteAdapter1 = new NoteAdapter1(this,notes,this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            //use false for having a simple straight layout
            //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
            //span count gives: no of columns required
            //StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL;)

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(noteAdapter1);
            Button bt1=findViewById(R.id.bt);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText et1 = findViewById(R.id.edit1);
                    EditText et2 = findViewById(R.id.edit2);
                    topic=et1.getText().toString();
                    des=et2.getText().toString();
                    notes.add(new Note(topic,des));
                    noteAdapter1.notifyItemInserted(notes.size());
                    et1.setText("");
                    et2.setText("");

                }
            });

        }
    }
}
