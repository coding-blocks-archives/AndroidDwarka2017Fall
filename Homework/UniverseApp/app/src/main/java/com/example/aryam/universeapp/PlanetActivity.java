package com.example.aryam.universeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by aryam on 12/30/2017.
 */

public class PlanetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPlanets);
        PlanetsAdapter planetsAdapter = new PlanetsAdapter(getPlanets());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(planetsAdapter);
    }
    private ArrayList<Planets> getPlanets() {
        ArrayList<Planets> planets = new ArrayList<>();
        planets.add(new Planets("https://www.nasa.gov/sites/default/files/mercury_1.jpg", "Mercury", "57.91 million km"));
        planets.add(new Planets("https://solarsystem.nasa.gov/images/galleries/VenusIR_jaxa_9601.jpg","Venus","108.2 million km"));
        planets.add(new Planets("https://www.popsci.com/sites/popsci.com/files/styles/655_1x_/public/images/2016/04/marsheader1.jpg?itok=KppdPDXC&fc=50,50","Mars","227.9 million km"));
        planets.add(new Planets("https://images.pexels.com/photos/2422/sky-earth-galaxy-universe.jpg?w=1260&h=750&auto=compress&cs=tinysrgb","Earth","149.6 million km"));
        planets.add(new Planets("https://www.nasa.gov/sites/default/files/styles/full_width/public/thumbnails/image/jupapr3color-jd-170304.png?itok=H3AGeVPH","Jupiter","778.5 million km"));
        planets.add(new Planets("https://www.nasa.gov/sites/default/files/styles/full_width/public/thumbnails/image/pia21046_main.jpg?itok=JVZLqFXf","Saturn","1.429 billion km"));
        planets.add(new Planets("https://www.nasa.gov/sites/default/files/styles/full_width_feature/public/thumbnails/imageneptune_full.jpg","Neptune","4.498 billion km"));
        planets.add(new Planets("https://solarsystem.nasa.gov/images/galleries/Hubble_Uranus-732X520.jpg","Uranus","2.871 billion km"));
        return planets;
    }
}
