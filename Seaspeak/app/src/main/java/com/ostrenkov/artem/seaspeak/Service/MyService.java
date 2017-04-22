package com.ostrenkov.artem.seaspeak.Service;

/**
 * Created by Artem on 23/04/16.
 */

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Amado on 05/03/2015.
 */
public class MyService extends Service implements LocationListener {
    private Context mContext;
    double latitude;
    double longitude;
    Location location;
    boolean GPSActivated;
    TextView text;
    LocationManager locationManager;

    public MyService() {
        super();
        this.mContext = this.getApplicationContext();
    }

    public MyService(Context context) {
        super();
        this.mContext = context;
        getLocation();
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setView(View v) {
        text = (TextView) v;
        text.setText("Coordinates are " + latitude + ", " + longitude);
    }

    public void getLocation() {
        try {
            locationManager = (LocationManager) (this.mContext.getSystemService(LOCATION_SERVICE));
            GPSActivated = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            Log.d("MainActivity", "prueba");
            if (GPSActivated) {
                Log.d("MainActivity", "primer if");
                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 1000 * 60, 10, this);
                if (locationManager != null) {
                    Log.d("MainActivity", "segundo if");
                    location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    Log.d("MainActivity", longitude + " долгота");
                    Log.d("MainActivity", latitude + " широта");
                } else Log.d("MainActivity", "locationManager = null ");
            } else Log.d("MainActivity", "GPSActivated false");
        }catch(Exception e) {}
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}


