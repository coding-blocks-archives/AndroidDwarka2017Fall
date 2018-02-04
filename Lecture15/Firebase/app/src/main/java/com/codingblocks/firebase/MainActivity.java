package com.codingblocks.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ChildEventListener {

    EditText etTitle, etDesc;

    FirebaseDatabase firebaseDatabase;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        etTitle = findViewById(R.id.titleEt);
        etDesc = findViewById(R.id.descEt);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser == null) {

            //Start sign in
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.EmailBuilder().build(),
                                    new AuthUI.IdpConfig.PhoneBuilder().build(),
                                    new AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    12345);

        } else {
            firebaseDatabase.getReference("notes").addChildEventListener(this);
        }

    }

    public void pushData(View view) {
        Notes notes = new Notes("" + System.currentTimeMillis(), etTitle.getText().toString(),
                etDesc.getText().toString(),
                false);
        DatabaseReference reference = firebaseDatabase.getReference("notes").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(notes.getId());
        reference.setValue(notes);

//        firebaseDatabase.getReference("notes").push().setValue(notes); //generate a random key

    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        Notes notes = dataSnapshot.getValue(Notes.class);
        Log.e("TAG", "onChildAdded: " + notes.getId());
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        Log.e("TAG", "onChildRemoved: ");

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 12345) {


        }
    }
}
