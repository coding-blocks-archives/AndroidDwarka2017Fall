package com.codingblocks.location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LocationListener ll = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        };

        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 200, this);

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.e("TAG", "onLocationChanged: Provider " + location.getProvider());
        Log.e("TAG", "onLocationChanged: Accuracy " + location.getAccuracy());
        Log.e("TAG", "onLocationChanged: Altitude " + location.getAltitude());
        Log.e("TAG", "onLocationChanged: Bearing " + location.getBearing());
        Log.e("TAG", "onLocationChanged: Latitude " + location.getLatitude());
        Log.e("TAG", "onLocationChanged: Longitude " + location.getLongitude());
        Log.e("TAG", "onLocationChanged: Speed " + location.getSpeed());
        Log.e("TAG", "onLocationChanged: Time " + location.getTime());
        Log.e("TAG", "onLocationChanged: IsFromMock " + location.isFromMockProvider());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.e("TAG", "onStatusChanged: Provider : " + provider + "Status " + status );
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.e("TAG", "onProviderEnabled: " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
