package com.codingblocks.listviewcustomadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_row.view.*

/**
 * Created by harshit on 28/12/17.
 */
class KotlinAdapter(val context: Context, val students: ArrayList<Student>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val s: Student = getItem(position)
        /*
        In kotlin if and else also return a value, so

            val a : Int
            if(x) a = 2 else a = 3

        is same as

            val a : Int = if(x) 2 else 3
         */
        val view = if (convertView == null) {
            LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        } else
            convertView

        view.studentName.text = s.name
        view.studentSubject.text = s.batch
        view.studentCenter.text = s.center

        return view
    }

    override fun getItem(position: Int): Student = students[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = students.size
}