package com.codingblocks.notesdb

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class NoteAdapter(val notes: ArrayList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = NoteHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.item_row, parent, false)
    )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.itemView.tvTitle.text = notes[position].title
        holder.itemView.tvDesc.text = notes[position].description
        holder.itemView.tvId.text = notes[position].id.toString()
    }

    class NoteHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}