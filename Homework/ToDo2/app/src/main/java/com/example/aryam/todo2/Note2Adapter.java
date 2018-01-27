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
 * Created by aryam on 1/11/2018.
 */

public class Note2Adapter extends RecyclerView.Adapter<Note2Adapter.Note2Holder> {
    ArrayList<Note2> noteArrayList;
    public Note2Adapter(ArrayList<Note2> notes){noteArrayList = notes;}

    @Override
    public Note2Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        Note2Holder note2Holder = new Note2Holder(inflateView);
        return note2Holder;
    }

    @Override
    public void onBindViewHolder(Note2Holder holder, int position) {
        Note2 currentNote = noteArrayList.get(position);
        holder.title.setText(currentNote.getTitle());
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }
    public class Note2Holder extends RecyclerView.ViewHolder{
        TextView title;
        CardView cardView;

        public Note2Holder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
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

                }
            });

        }
    }
}
