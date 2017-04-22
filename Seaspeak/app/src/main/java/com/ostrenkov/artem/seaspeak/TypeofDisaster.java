package com.ostrenkov.artem.seaspeak;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TypeofDisaster extends AppCompatActivity {
/*

    public ArrayAdapter<String> adapter;
    public ArrayList<String> arrayList;
*/
    View.OnClickListener radioListener;

    public Object thiss;

    public String getparam(String name){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        String mySetting = sharedPref.getString(name, null);
        return mySetting;

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
        setContentView(R.layout.activity_typeof_disaster);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //     thiss = this;


        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radiogroup);

	    radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) throws NullPointerException {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "No choice", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton:
                        setparam("TYPEOF", "MAN OVERBOARD");
                        break;
                    case R.id.radioButton2:
                        setparam("TYPEOF", " FIRE");
                        break;
                    case R.id.radioButton3:
                        setparam("TYPEOF", "Sinking");
                        break;
                    case R.id.radioButton4:
                        setparam("TYPEOF", "Collision");
                        break;
                    case R.id.radioButton5:
                        setparam("TYPEOF", "Disabled and drift");
                        break;
                    case R.id.radioButton6:
                        setparam("TYPEOF", "Medical consalting");
                        break;
                    case R.id.radioButton7:
                        setparam("TYPEOF", "Medical evacuation");
                        break;
                    case R.id.radioButton8:
                        setparam("TYPEOF", "Grounding");
                        break;
                    case R.id.radioButton9:
                        setparam("TYPEOF", "LAUNCH THE EPIRB");
                        break;
                    case R.id.radioButton10:
                        setparam("TYPEOF", "ABANDONING THE BOAT");
                        break;
                    default:
                        break;
                }


            }
        });
    }

    public void onClickNext(View view) {

        if (getparam("SensorGPS").equals("Failed")) {
            Intent intent = new Intent(this, ActCoordinates.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, MainTimeYouHave.class);
            startActivity(intent);
        }



    }
}