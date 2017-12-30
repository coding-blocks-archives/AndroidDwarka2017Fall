package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by harshit on 30/12/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentHolder> {

    private final ArrayList<Student> students;
    Context context;
    static int countOnCreate = 0, countOnBind = 0;
    public static final String TAG = "STUDENTADAPTER";

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View inflatedView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        StudentHolder studentHolder = new StudentHolder(inflatedView);
        Log.e(TAG, "onCreateViewHolder: " + countOnCreate++);
        return studentHolder;
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, int position) {
        Student currentStudent = students.get(position);
        holder.studentName.setText(currentStudent.getName());
        holder.studentSubject.setText(currentStudent.getBatch());

        Picasso.with(holder.studentImage.getContext())
                .load(currentStudent.getPhoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_action_name)
                .into(holder.studentImage);

        Log.e(TAG, "onBindViewHolder: " + countOnBind++);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

}
