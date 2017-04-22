package com.ostrenkov.artem.seaspeak;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ostrenkov.artem.seaspeak.Service.MyService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    public MyService service;

    private void   getLocationChecker() {
        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_FINE_LOCATION))
            permissionsNeeded.add("GPS");
        if (!addPermission(permissionsList, Manifest.permission.ACCESS_COARSE_LOCATION))
            permissionsNeeded.add("COARSE_LOCATION");

        if (permissionsList.size() > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            }
        }

    }

    private boolean addPermission(List<String> permissionsList, String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);
                // Check for Rationale Option
                if (!shouldShowRequestPermissionRationale(permission))
                    return false;
            }
        }
        return true;
    }


    public void getparam(String name, String res){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        String mySetting = sharedPref.getString(name, null);
        res = mySetting;

    }
    public String getparam(String name){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        String mySetting = sharedPref.getString(name, null);
        return mySetting;

    }
    public void setparam(String name,  String res){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(name, res);
        editor.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        SharedPreferences prefs = getSharedPreferences("com.ostrenkov.artem.seaspeak", MODE_PRIVATE);

        if (prefs.getBoolean("firstrun", true)) {
            setparam("CurrentMessage","0");

            setparam("LastMessage","0");
            setparam("TIMEOFMESSAGE","NOT DEFINED");
            setparam("RECEIVEDMESSAGE","NOT DEFINED");
            setparam("MARINA","'NAME'");
            setparam("CALLINGNAME","'NAME'");

            setparam("myBoatName","'boatname'");

            setparam("myDraught","0");
            setparam("myCREW","1");
            setparam("myLenght","0");
            setparam("myWidth","0");



            prefs.edit().putBoolean("firstrun", false).commit();
        }

        getLocationChecker();

        service = new MyService(getApplicationContext());

        service.getLocation();

        WordToSpell wts = new WordToSpell();




        //((TextView) (findViewById(R.id.tvDebug))).setText("широта "+ service.getLatitude() + " долгота  " + service.getLongitude());

        if (service.getLatitude() != 0) {
            setparam("ShortGPS",wts.LocationToCoordinates(service.getLatitude(),service.getLongitude()));
            wts.SpellLong(true);
            setparam("LongGPS",wts.LocationToCoordinates(service.getLatitude(),service.getLongitude()));
            setparam("SensorGPS", "OK");

            //wts.SpellNumbers(getparam("ShortGPS"));
            //Toast.makeText(this,"ShortGPS " + getparam("ShortGPS"),Toast.LENGTH_LONG).show();
            //Toast.makeText(this,"LongGPS " + getparam("LongGPS"),Toast.LENGTH_LONG).show();
        }

        else {
            setparam("LongGPS", "Failed");
            setparam("ShortGPS", "Failed");
            setparam("SensorGPS", "Failed");
        }

        Log.d("GPS", getparam("ShortGPS"));
        Log.d("GPS", getparam("LongGPS"));
        Toast.makeText(this,"GPS - " + getparam("ShortGPS"),Toast.LENGTH_LONG).show();
        //Toast.makeText(this,"GPS - " + getparam("LongGPS"),Toast.LENGTH_LONG).show();
      //  ((TextView) (findViewById(R.id.tvDebug))).setText(che + "широта "+service.getLatitude() + " долгота  " + service.getLongitude());

        // service.setView((TextView) (findViewById(R.id.textView4)));

       // setparam("myGPS", " " + service.getLongitude() + service.getLatitude());;


    }

    @Override
    public void onResume(){
        // Очистите все ресурсы. Это касается завершения работы
        // потоков, закрытия соединений с базой данных и т. д.

        SharedPreferences sharedPref = getSharedPreferences("mySettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("mySetting", "Hello Android");
        editor.commit();

        super.onResume();
    }

    @Override
    public void onRestart(){
        // Очистите все ресурсы. Это касается завершения работы
        // потоков, закрытия соединений с базой данных и т. д.

        super.onRestart();

    }

    public void onClickBoatInfo(View view) {

        Intent intent = new Intent(this, ActBoatInfo.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        startActivity(intent);
    }


    public void onClickGotoMessage(View view) {

        setparam("ShowMessage","LastMessage");

        Intent intent = new Intent(this, ScrollingShowMessage.class);
        startActivity(intent);
    }



    public void onCLickEmergency(View view) {
        setparam("Event","Emergency");
        setparam("ShowMessage","Nope");
        Intent intent = new Intent(this, Emergency.class);
        startActivity(intent);
    }

    public void onClickCallMArina(View view) {
        setparam("ShowMessage","Nope");
        setparam("Event","Routine");
        Intent intent = new Intent(this, CallMarine.class);
        startActivity(intent);
    }

    public void onClickSeaSpeak(View view) {
        //setparam("ShowMessage","Nope");
        Intent intent = new Intent(this, SeaspeakINFO.class);
        startActivity(intent);
    }

    public void onClickCallVessel(View view) {
        setparam("ShowMessage","Nope");
        setparam("Event","Routine");
        Intent intent = new Intent(this, CallVessel.class);
        startActivity(intent);
    }

    public void onClickGPS(View view) {

        getLocationChecker();

        service = new MyService(getApplicationContext());

        service.getLocation();

        WordToSpell wts = new WordToSpell();




        //((TextView) (findViewById(R.id.tvDebug))).setText("широта "+ service.getLatitude() + " долгота  " + service.getLongitude());

        if (service.getLatitude() != 0) {
            setparam("ShortGPS",wts.LocationToCoordinates(service.getLatitude(),service.getLongitude()));
            wts.SpellLong(true);
            setparam("LongGPS",wts.LocationToCoordinates(service.getLatitude(),service.getLongitude()));
            //Toast.makeText(this,"ShortGPS " + getparam("ShortGPS"),Toast.LENGTH_LONG).show();
            //Toast.makeText(this,"LongGPS " + getparam("LongGPS"),Toast.LENGTH_LONG).show();
            setparam("SensorGPS", "OK");
        }

        else {
            setparam("LongGPS", "Failed");
            setparam("ShortGPS", "Failed");
            setparam("SensorGPS", "Failed");
        }

        Toast.makeText(this,"GPS - " + getparam("ShortGPS"),Toast.LENGTH_LONG).show();





    }
}
