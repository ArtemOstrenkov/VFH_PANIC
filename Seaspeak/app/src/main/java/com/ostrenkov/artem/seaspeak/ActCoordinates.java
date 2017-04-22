package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ActCoordinates extends AppCompatActivity {

    String Lat = "North";
    String Lon = "East";




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
        setContentView(R.layout.activity_act_coordinates);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final TextView twCoord = (TextView) findViewById(R.id.twCoordinates);
        final EditText metLatD = (EditText) findViewById(R.id.etLatD);
        final EditText metLatM = (EditText) findViewById(R.id.etLatM);
        final EditText metLatS = (EditText) findViewById(R.id.etLatS);

        final EditText metLongD = (EditText) findViewById(R.id.etLongD);
        final EditText metLongM = (EditText) findViewById(R.id.etLongM);
        final EditText metLongS = (EditText) findViewById(R.id.etLongS);



         //  -------------------
        metLatD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus ) {
                    String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
                    sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
                    twCoord.setText(sCoord);

                }
            }
        });

        metLatM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus ) {
                    String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
                    sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
                    twCoord.setText(sCoord);
                }
            }
        });


        metLatS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus ) {
                    String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
                    sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
                    twCoord.setText(sCoord);
                }
            }
        });

        metLongD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus ) {
                    String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
                    sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
                    twCoord.setText(sCoord);
                }
            }
        });

        metLongM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus ) {
                    String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
                    sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
                    twCoord.setText(sCoord);
                }
            }
        });

        metLongS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus ) {
                    String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
                    sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
                    twCoord.setText(sCoord);
                }
            }
        });

        //  -------------------


    }

   /* public void onClickNext(View view) {


        //final TextView twCoord = (TextView) findViewById(R.id.twCoordinates);

        //setparam("LongGPS", twCoord.getText().toString());
        //setparam("ShortGPS", twCoord.getText().toString());

       // Intent intent = new Intent(this, MainTimeYouHave.class);
       // startActivity(intent);
    }*/

    public void onClickrLatN(View view) {

        RadioButton rLatN = (RadioButton) findViewById(R.id.rLatN);
        rLatN.setChecked(true);

        RadioButton rLatS = (RadioButton) findViewById(R.id.rLatS);
        rLatS.setChecked(false);

        Lat = "North";

        final TextView twCoord = (TextView) findViewById(R.id.twCoordinates);
        final EditText metLatD = (EditText) findViewById(R.id.etLatD);
        final EditText metLatM = (EditText) findViewById(R.id.etLatM);
        final EditText metLatS = (EditText) findViewById(R.id.etLatS);

        final EditText metLongD = (EditText) findViewById(R.id.etLongD);
        final EditText metLongM = (EditText) findViewById(R.id.etLongM);
        final EditText metLongS = (EditText) findViewById(R.id.etLongS);

        String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
        sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
        twCoord.setText(sCoord);


    }
    public void onClickrLatS(View view) {

        RadioButton rLatN = (RadioButton) findViewById(R.id.rLatN);
        rLatN.setChecked(false);

        RadioButton rLatS = (RadioButton) findViewById(R.id.rLatS);
        rLatS.setChecked(true);

        Lat = "South";

        final TextView twCoord = (TextView) findViewById(R.id.twCoordinates);
        final EditText metLatD = (EditText) findViewById(R.id.etLatD);
        final EditText metLatM = (EditText) findViewById(R.id.etLatM);
        final EditText metLatS = (EditText) findViewById(R.id.etLatS);

        final EditText metLongD = (EditText) findViewById(R.id.etLongD);
        final EditText metLongM = (EditText) findViewById(R.id.etLongM);
        final EditText metLongS = (EditText) findViewById(R.id.etLongS);

        String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
        sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
        twCoord.setText(sCoord);

    }
    public void onClickrLonW(View view) {

        RadioButton rLonW = (RadioButton) findViewById(R.id.rLongW);
        rLonW.setChecked(true);

        RadioButton rLonE = (RadioButton) findViewById(R.id.rLongE);
        rLonE.setChecked(false);

        Lon = "West";


        final TextView twCoord = (TextView) findViewById(R.id.twCoordinates);
        final EditText metLatD = (EditText) findViewById(R.id.etLatD);
        final EditText metLatM = (EditText) findViewById(R.id.etLatM);
        final EditText metLatS = (EditText) findViewById(R.id.etLatS);

        final EditText metLongD = (EditText) findViewById(R.id.etLongD);
        final EditText metLongM = (EditText) findViewById(R.id.etLongM);
        final EditText metLongS = (EditText) findViewById(R.id.etLongS);

        String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
        sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
        twCoord.setText(sCoord);



    }
    public void onClickrLonE(View view) {

        RadioButton rLonW = (RadioButton) findViewById(R.id.rLongW);
        rLonW.setChecked(false);

        RadioButton rLonE = (RadioButton) findViewById(R.id.rLongE);
        rLonE.setChecked(true);

        Lon = "East";

        final TextView twCoord = (TextView) findViewById(R.id.twCoordinates);
        final EditText metLatD = (EditText) findViewById(R.id.etLatD);
        final EditText metLatM = (EditText) findViewById(R.id.etLatM);
        final EditText metLatS = (EditText) findViewById(R.id.etLatS);

        final EditText metLongD = (EditText) findViewById(R.id.etLongD);
        final EditText metLongM = (EditText) findViewById(R.id.etLongM);
        final EditText metLongS = (EditText) findViewById(R.id.etLongS);

        String sCoord = metLatD.getText().toString() +"˚ "+  metLatM.getText().toString()+"' "+ metLatS.getText().toString()+"'' "+Lat;
        sCoord = sCoord +" "+ metLongD.getText().toString() +"˚ "+  metLongM.getText().toString()+"' "+ metLongS.getText().toString()+"' "+Lon;
        twCoord.setText(sCoord);


    }

    public void onClickbNext(View view) {

     //Toast.makeText(this,"  wewe",Toast.LENGTH_LONG).show();

        final TextView twCoord = (TextView) findViewById(R.id.twCoordinates);

        setparam("LongGPS", twCoord.getText().toString());
        setparam("ShortGPS", twCoord.getText().toString());

         Intent intent = new Intent(this, MainTimeYouHave.class);
         startActivity(intent);

    }
}
