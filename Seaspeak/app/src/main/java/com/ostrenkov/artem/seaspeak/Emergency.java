package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Emergency extends AppCompatActivity {

    public void getparam(String name, String res){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        String mySetting = sharedPref.getString(name, null);
        //EditText eboatName = (EditText) findViewById(R.id.eBoatName);
        res = mySetting;

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
        setContentView(R.layout.emergecy);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void onClickCD(View view) {

        setparam("STEP","CANCELDISTRESS");
        Toast.makeText(getBaseContext(), "onClickCD", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, CancelDIstress.class);
        startActivity(intent1);
    }


    public void onClickMAYDAY(View view) {

        setparam("STEP","MAYDAY");
        Intent intent = new Intent(this, TypeofDisaster.class);
        startActivity(intent);

    }

    public void onClickPanpan(View view) {
        setparam("STEP","PANPAN");
        Intent intent = new Intent(this, TypeofDisaster.class);
        startActivity(intent);
    }

    public void onClickReceived(View view) {
        setparam("STEP","MAYDAY RELAY");
        Intent intent = new Intent(this, mayday_relay.class);
        startActivity(intent);
    }



}
