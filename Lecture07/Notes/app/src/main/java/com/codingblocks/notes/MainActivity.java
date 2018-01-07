package com.codingblocks.notes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HandleLongClick{

    @Override
    public void handleLongClick(int position) {
        notes.remove(position);
        //notifyDatasetChanged
    }

    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.rvNotes);

        notes = new ArrayList<>();
        final NotesAdapter notesAdapter = new NotesAdapter(notes,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(notesAdapter);

        final EditText editText = findViewById(R.id.editTextNote);

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_layout, null, false);
        final EditText title = dialogView.findViewById(R.id.editTextTitle), description = dialogView.findViewById(R.id.editTextDescriotion);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Enter the note")
                .setCancelable(false)
                .setView(dialogView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notes.add(new Note(title.getText().toString(), description.getText().toString(), false));
                        notesAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                notes.add(new Note(editText.getText().toString()));
//                notesAdapter.notifyItemInserted(notes.size());
//                editText.setText("");
                alertDialog.show();
            }
        });

    }

}
