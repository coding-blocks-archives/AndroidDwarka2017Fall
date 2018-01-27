package com.example.aryam.universeapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by aryam on 12/30/2017.
 */

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsHolder>{
    private final ArrayList<Planets> planets;
    public PlanetsAdapter(ArrayList<Planets> planets){
        this.planets = planets;
    }
    @Override
    public PlanetsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context  = parent.getContext();
        View inflatedView = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);
        PlanetsHolder planetsHolder = new PlanetsHolder(inflatedView);
        return planetsHolder;
    }

    @Override
    public void onBindViewHolder(PlanetsHolder holder, int position) {
        Planets currentPlanet = planets.get(position);
        holder.planetName.setText(currentPlanet.getName());
        Picasso.with(holder.planetImage.getContext()).load(currentPlanet.getImage()) .into(holder.planetImage);
        holder.planetDist.setText(currentPlanet.getDist());

    }

    @Override
    public int getItemCount() {
        return planets.size();
    }
}
