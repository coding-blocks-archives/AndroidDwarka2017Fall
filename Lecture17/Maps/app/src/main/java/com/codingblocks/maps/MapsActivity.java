package com.codingblocks.maps;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng lastKnownLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style));
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                mMap.addMarker(new MarkerOptions().position(marker.getPosition()).draggable(true));
                mMap.addPolyline(new PolylineOptions().add(lastKnownLocation, marker.getPosition()));
                lastKnownLocation = marker.getPosition();
            }
        });

        LatLng sydney = new LatLng(-34, 151);

        lastKnownLocation = sydney;

        mMap.addCircle(
                new CircleOptions().center(sydney).radius(1000).fillColor(Color.BLUE).strokeColor(Color.GREEN)
        );

        mMap.addPolygon(new PolygonOptions().add(
                new LatLng(28, 120), new LatLng(45, 100), new LatLng(30, 50)
        ).fillColor(Color.GRAY));

        // Add a marker in Sydney and move the camera
        MarkerOptions marker = new MarkerOptions().position(sydney).title("Marker in Sydney").draggable(true);


        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        mMap.clear();
    }
}
