package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by harshit on 28/12/17.
 */

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        students = studentArrayList;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutInflater li = LayoutInflater.from(context);

        /*
          parent : The viewGroup that's created by default at every row (Generally a FrameLayout)
          Pass in the third param as false if you want your inflated view to replace this parent, otherwise pass true.

          Also if we are the ones handling the addition of a view to the ViewGroup, add true over here otherwise add false to let
          the OS take care of it
         */
        Log.e("TAG", "getView: " + convertView );

        View inflatedView;
        if (convertView == null)
            inflatedView = li.inflate(R.layout.item_row, parent, false);
        else
            inflatedView = convertView;

        bindView(inflatedView, position);

        return inflatedView;
    }


    private void bindView(View view, int position) {
        final Student currentStudent = students.get(position);

        TextView studentName = view.findViewById(R.id.studentName),
                studentCenter = view.findViewById(R.id.studentCenter),
                studentSubject = view.findViewById(R.id.studentSubject);

        studentName.setText(currentStudent.getName());
        studentSubject.setText(currentStudent.getBatch());
        studentCenter.setText(currentStudent.getCenter());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, currentStudent.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
