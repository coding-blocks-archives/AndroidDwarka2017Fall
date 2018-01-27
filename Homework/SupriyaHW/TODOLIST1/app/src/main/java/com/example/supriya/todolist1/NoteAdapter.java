package com.example.supriya.todolist1;

/**
 * Created by Supriya on 1/7/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


/**
 * Created by Supriya on 1/2/2018.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    Context context1;


    public static int count=0;
    public static int count1=0;
    public int counter=0;

    private ArrayList<Note> notes;
    public class NoteHolder extends RecyclerView.ViewHolder {

        TextView noteTopic;
        TextView noteStatus;
        public NoteHolder(View itemView) {

            super(itemView);
            noteTopic=itemView.findViewById(R.id.noteTopic);
            noteStatus=itemView.findViewById(R.id.noteStatus);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    notes.remove(getAdapterPosition());
                    notifyItemRemoved(notes.size());
                    notifyItemRangeChanged(getAdapterPosition(),notes.size());
                    return false;
                }

            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context1=view.getContext();
                    Intent intent=new Intent(context1,DetailActivity.class);
                    context1.startActivity(intent);
                }
            });

        }
    }

    public NoteAdapter(ArrayList<Note> notes)
    {
        this.notes=notes;

    }



    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context=  parent.getContext();
        Log.e(TAG, "onCreateViewHolder: was called "+count++ );
        View inflatedView= LayoutInflater.from(context).inflate(R.layout.itemrow,parent,false);
        NoteHolder noteHolder=new NoteHolder(inflatedView);
        return noteHolder ;

    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {
        Log.d("onBindViewHoler ", notes.size() + "");
        Note currentNote=notes.get(position);
        Log.e(TAG, "onBindViewHolder: was called "+count1++ );
        holder.noteTopic.setText((currentNote.getTopic()));
        //internally saves reference of the textviews in a view eliminating the use of invoking findviewbyid again .
        holder.noteStatus.setText((currentNote.getDescription()));


    }


    @Override
    public int getItemCount() {
        return notes.size();
    }


}


