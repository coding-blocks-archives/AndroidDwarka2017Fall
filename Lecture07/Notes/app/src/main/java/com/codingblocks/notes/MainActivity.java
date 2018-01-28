package com.codingblocks.notes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HandleLongClick,SearchView.OnQueryTextListener{
    @Override
    public void handleLongClick(int position) {
        notes.remove(position);
        //notifyDatasetChanged
    }
    NotesAdapter notesAdapter;//made global so that it can be used in other methods
    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.rvNotes);

        notes = new ArrayList<>();
        notesAdapter = new NotesAdapter(notes,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(notesAdapter);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_layout, null, false);
        final EditText title = dialogView.findViewById(R.id.editTextTitle), description = dialogView.findViewById(R.id.editTextDescriotion);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Enter the note")
                .setCancelable(false)
                .setView(dialogView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // notes.add(new Note(title.getText().toString(), description.getText().toString(), false));

                        //Directly adding an element to the arraylist and updating our adapter with
                        // every new data set was fine but as soon as we search something
                        // (Eg. if we had 2 notes like : Lunch and Dinner on display then if we would search 'l'
                        // then we will see only Lunch , which is infact fine but now if we search 'd' then we
                        // wont see Dinner which is because there is no mechanism to update the list we declared in
                        // Adapter class since it was initialised only once and this implies there should be a method
                        // that refreshes the list with our earlier data i.e there should be a link between list
                        // declared in Adapter, and the items that are added,so what we do is that we
                        // add items in the list declared in our Adapter class using the addItem() method
                        notesAdapter.addItem(new Note(title.getText().toString(), description.getText().toString(), false));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    //The default methods that we have to implement since we are implementing SearchView interface
    @Override
    public boolean onQueryTextSubmit(String query) {
        notesAdapter.filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        notesAdapter.filter(newText);
        return false;
    }
}
