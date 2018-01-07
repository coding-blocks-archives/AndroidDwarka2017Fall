package com.codingblocks.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by harshit on 06/01/18.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {

    ArrayList<Note> noteArrayList;
    HandleLongClick handleLongClick;

    public NotesAdapter(ArrayList<Note> notes, HandleLongClick handleLongClick) {
        noteArrayList = notes;
        this.handleLongClick = handleLongClick;
    }

    @Override
    public NotesAdapter.NotesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final NotesAdapter.NotesHolder holder, int position) {
        if (noteArrayList.get(position).getDone()){
            //Striketrhrough
            //text setting
        }else{
            //normal flow
        }

        holder.title.setText(noteArrayList.get(position).getTitle());
        holder.title.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                noteArrayList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class NotesHolder extends RecyclerView.ViewHolder {

        TextView title;

        public NotesHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Strikethrough
                    handleLongClick.handleLongClick(getAdapterPosition());
//                    noteArrayList.get(getAdapterPosition()).setDone(true);
                }
            });
        }
    }
}
