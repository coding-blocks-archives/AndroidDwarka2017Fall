package com.example.aryam.universeapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aryam on 12/30/2017.
 */

public class PlanetsHolder extends RecyclerView.ViewHolder {
    ImageView planetImage;
    TextView planetName;
    TextView planetDist;
    public PlanetsHolder(View itemView) {
        super(itemView);
        planetImage = itemView.findViewById(R.id.bodyImage);
        planetName = itemView.findViewById(R.id.bodyName);
        planetDist = itemView.findViewById(R.id.bodyDist);
    }
}
