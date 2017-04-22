package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CallMarine extends AppCompatActivity {


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
    public void setparam(String name,  String res) {

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(name, res);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_marine);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        ((EditText) findViewById(R.id.eNameMarinaBoat)).setText(getparam("MARINA"));


        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.rgCallMarine);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) throws NullPointerException {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "No choice", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbPlacetoStay:
                        setparam("MARINACALLPURPOSE", "Need a place to stay");
                        setparam("STEP","PLACETOSTAY");
                        ((RadioButton) findViewById(R.id.rbHomeMarine)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbCustoms)).setVisibility(View.GONE);
                        ((LinearLayout) findViewById(R.id.rgCallMarine)).setVisibility(View.VISIBLE);

                        ((TextView) findViewById(R.id.tNameMarinaBoat)).setVisibility(View.VISIBLE);
                        ((EditText) findViewById(R.id.eNameMarinaBoat)).setVisibility(View.VISIBLE);
                        ((CheckBox) findViewById(R.id.chAssistanse)).setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbHomeMarine:
                        setparam("MARINACALLPURPOSE", "We are comming to home marine");
                        setparam("STEP","HOMEMARINE");
                        ((RadioButton) findViewById(R.id.rbPlacetoStay)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbCustoms)).setVisibility(View.GONE);
                        ((LinearLayout) findViewById(R.id.rgCallMarine)).setVisibility(View.VISIBLE);

                        ((TextView) findViewById(R.id.tNameMarinaBoat)).setVisibility(View.VISIBLE);
                        ((EditText) findViewById(R.id.eNameMarinaBoat)).setVisibility(View.VISIBLE);
                        ((CheckBox) findViewById(R.id.chAssistanse)).setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbCustoms:
                        setparam("MARINACALLPURPOSE", "I am asking a place at the customs peer to pass border formalities");
                        setparam("STEP","CUSTOMS");
                        ((RadioButton) findViewById(R.id.rbPlacetoStay)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbHomeMarine)).setVisibility(View.GONE);
                        ((LinearLayout) findViewById(R.id.rgCallMarine)).setVisibility(View.VISIBLE);
                       ((TextView) findViewById(R.id.tNameMarinaBoat)).setVisibility(View.VISIBLE);
                        ((EditText) findViewById(R.id.eNameMarinaBoat)).setVisibility(View.VISIBLE);
                        ((CheckBox) findViewById(R.id.chAssistanse)).setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }


            }
        });


    }


    public void onClickNextDest(View view) {
        setparam("MARINA",((EditText) findViewById(R.id.eNameMarinaBoat)).getText().toString());
        //Toast.makeText(getApplicationContext(), getparam("MARINACALLPURPOSE"), Toast.LENGTH_SHORT).show();

       boolean trig = ( (CheckBox)findViewById(R.id.chAssistanse)).isChecked();

        if (trig){

            Toast.makeText(getApplicationContext(), "NEED MORE ACT", Toast.LENGTH_LONG).show();
            setparam("MARINEAssistance","<h1>We need an assistance</h1>");

        }   else

        {
            setparam("MARINEAssistance","");

        }
        Intent intent = new Intent(this, ScrollingMessage.class);
        startActivity(intent);



    }
}
