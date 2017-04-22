package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Routine extends AppCompatActivity {

    public void getparam(String name, String res){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        String mySetting = sharedPref.getString(name, null);
        //EditText eboatName = (EditText) findViewById(R.id.eBoatName);
        res = mySetting;

    }
    public void setparam(String name,  String res){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(name,res);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routine);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.rgDest);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) throws NullPointerException {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "No choice", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbMarina:
                        ((TextView) findViewById(R.id.tNameMarinaBoat)).setText("Name of calling MARINA");
                        setparam("CallingName", "MARINA");
                        break;
                    case R.id.rbBoat:
                        ((TextView) findViewById(R.id.tNameMarinaBoat)).setText("Name of calling BOAT");
                        setparam("CallingName", "BOAT");
                        break;
                    default:
                        break;
                }


            }
        });
    }


    public void onClickNextDest(View view) {

        Intent intent = new Intent(this, MainTimeYouHave.class);
        startActivity(intent);


    }
}
