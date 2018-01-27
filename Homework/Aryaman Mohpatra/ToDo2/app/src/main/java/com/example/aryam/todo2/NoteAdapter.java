package com.example.aryam.todo2;

import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aryam on 1/6/2018.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    ArrayList<Note> noteArrayList;
    public NoteAdapter(ArrayList<Note> notes){noteArrayList = notes;}

    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        NoteHolder noteHolder = new NoteHolder(inflateView);
        return noteHolder;
    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {
        Note currentNote = noteArrayList.get(position);
        holder.title.setText(currentNote.getTitle());
        holder.description.setText(currentNote.getDescription());
        holder.title.setPaintFlags(holder.title.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
        holder.description.setPaintFlags(holder.description.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }
    public class NoteHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView description;
        CardView cardView;

        public NoteHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
           description = itemView.findViewById((R.id.description));
           cardView = itemView.findViewById((R.id.item_card));
           itemView.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View view) {
                   noteArrayList.remove(getAdapterPosition());
                   notifyDataSetChanged();
                   return true;
               }
           });

           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!noteArrayList.get(getAdapterPosition()).isDone()) {
                        title.setPaintFlags(title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        description.setPaintFlags(description.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        noteArrayList.get(getAdapterPosition()).setDone(true);
                    }
                    else{
                        title.setPaintFlags(title.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
                        description.setPaintFlags(description.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
                        noteArrayList.get(getAdapterPosition()).setDone(false );
                    }
                }
                });

        }
    }
}
