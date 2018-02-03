package com.codingblocks.notesdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codingblocks.notesdb.TableContract.*;

import java.util.ArrayList;

import static com.codingblocks.notesdb.TableContract.DESCRIPTION;
import static com.codingblocks.notesdb.TableContract.ID;
import static com.codingblocks.notesdb.TableContract.IS_DONE;
import static com.codingblocks.notesdb.TableContract.TABLE_NAME;
import static com.codingblocks.notesdb.TableContract.TITLE;

public class NotesDb extends SQLiteOpenHelper {


    public static final String DB_NAME = "notesdb";
    public static final int DB_VERSION = 5;

    public NotesDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    public ArrayList<Note> getAllNotes() {
        Cursor c = getReadableDatabase().query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<Note> notes = new ArrayList<>();

        //convert cursor to ArrayList
        while (c.moveToNext()) {
            int id = c.getInt(0);
            String title = c.getString(1);
            String desc = c.getString(2);
            Boolean isDone = (c.getInt(3) == 1);
            Note note = new Note(id, title, desc, isDone);
            notes.add(note);
        }
        c.close();
        return notes;
    }


    public Note getNoteFromId(String id) {

        Cursor c = getReadableDatabase().query(TABLE_NAME,
                null,
                ID + " = ? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        c.moveToNext();

        int retId = c.getInt(0);
        String title = c.getString(1);
        String desc = c.getString(2);
        Boolean isDone = (c.getInt(3) == 1);

        c.close();

        return new Note(retId, title, desc, isDone);
    }


    public void insertNote(Note note) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, note.getId());
        contentValues.put(TITLE, note.getTitle());
        contentValues.put(DESCRIPTION, note.getDescription());
        contentValues.put(IS_DONE, note.isDone());

        getWritableDatabase().insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TableContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Drop the table
//        onCreate(sqLiteDatabase);
        if (i != i1){
            //Delete the current db
            //Call onCreate again

            //------------------------------

            //save the new db to a temporary db
            //Delete the current db
            //Call onCreate
            //Save the data from temporary db to the new db
        }

    }
}
