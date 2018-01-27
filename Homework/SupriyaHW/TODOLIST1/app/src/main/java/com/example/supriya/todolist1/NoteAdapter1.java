package com.example.supriya.todolist1;

/**
 * Created by Supriya on 1/7/2018.
 */

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Supriya on 1/7/2018.
 */




/**
 * Created by Supriya on 1/2/2018.
 */

public class NoteAdapter1 extends RecyclerView.Adapter<NoteAdapter1.NoteHolder1> {
    int value;
    Context context;
    MainActivity main;

    public static int count=0;
    public static int count1=0;
    public int counter=0;

    private ArrayList<Note> notes;
    public class NoteHolder1 extends RecyclerView.ViewHolder {
        TextView noteTopic;
        TextView noteStatus;
        public NoteHolder1(final View itemView) {

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
                    Fragment fragment=new Fragment();
                    FragmentManager fragmentManager=main.getSupportFragmentManager();
                    final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    //Fragment fragment=new Fragment();
                    fragmentTransaction.add(R.id.container,fragment);
                    fragmentTransaction.replace(R.id.container,new Fragment());
                    fragmentTransaction.commit();

                }
            });

        }
    }

    public NoteAdapter1(Context context,ArrayList<Note> notes,MainActivity ma)

    {
        this.context=context;
        main=ma;
        this.notes=notes;
    }



    @Override
    public NoteHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context=parent.getContext();
        Log.e(TAG, "onCreateViewHolder: was called "+count++ );
        View inflatedView= LayoutInflater.from(context).inflate(R.layout.itemrow,parent,false);
        NoteHolder1 noteHolder1=new NoteHolder1(inflatedView);
        return noteHolder1 ;

    }

    @Override
    public void onBindViewHolder(NoteHolder1 holder, int position) {
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


