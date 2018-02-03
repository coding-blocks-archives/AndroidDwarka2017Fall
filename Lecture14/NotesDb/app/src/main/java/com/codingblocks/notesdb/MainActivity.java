package com.codingblocks.notesdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotesDb notesDb = new NotesDb(this);

//        Button button = findViewById(R.id.idBtn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Note note = new Note(System.currentTimeMillis(), "TITLE", "DESC", false);
//                notesDb.insertNote(note);
//            }
//        });

        RecyclerView recyclerView = findViewById(R.id.rvNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notes = notesDb.getAllNotes();

        NoteAdapter noteAdapter = new NoteAdapter(notes);
        recyclerView.setAdapter(noteAdapter);
    }
}
