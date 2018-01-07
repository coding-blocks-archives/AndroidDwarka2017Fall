package com.codingblocks.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by harshit on 30/12/17.
 */

public class StudentHolder extends RecyclerView.ViewHolder {

    TextView studentName;
    ImageView studentImage;
    TextView studentSubject;

    public static int constructor = 0;
    public static final String TAG = "StudentHolder";

    public void bind(final Student student) {
        studentName.setText(student.getName());
        studentSubject.setText(student.getBatch());
        Picasso.with(itemView.getContext()).load(student.getPhoto()).into(studentImage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Student's name : " + student.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public StudentHolder(View itemView) {
        super(itemView);
        studentName = itemView.findViewById(R.id.studentName);
        studentSubject = itemView.findViewById(R.id.studentSubject);
        studentImage = itemView.findViewById(R.id.studentImage);
        Log.e(TAG, "constructor: " + constructor++);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Item number clicked : " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
