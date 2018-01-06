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

    public NotesAdapter(ArrayList<Note> notes) {
        noteArrayList = notes;
    }

    @Override
    public NotesAdapter.NotesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(NotesAdapter.NotesHolder holder, int position) {
        holder.title.setText(noteArrayList.get(position).getTitle());
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
        }
    }
}
