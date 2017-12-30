package com.codingblocks.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by harshit on 30/12/17.
 */

public class StudentHolder extends RecyclerView.ViewHolder {

    TextView studentName;
    ImageView studentImage;
    TextView studentSubject;

    public static int constructor = 0;
    public static final String TAG = "StudentHolder";

    public StudentHolder(View itemView) {
        super(itemView);
        studentName = itemView.findViewById(R.id.studentName);
        studentSubject = itemView.findViewById(R.id.studentSubject);
        studentImage = itemView.findViewById(R.id.studentImage);
        Log.e(TAG, "constructor: " + constructor++);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Item number clicked : " + getAdapterPosition(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
