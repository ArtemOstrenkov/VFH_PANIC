package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ActMessage extends AppCompatActivity {

    public String getparam(String name) {

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        String message =  sharedPref.getString(name, null);
        return message;

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
        setContentView(R.layout.activity_act_message);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        /*  String message = getparam("Event");
          ((TextView) findViewById(R.id.tMAYDAY)).setText(message.toUpperCase()+", "+message.toUpperCase()+", "+message.toUpperCase());

        message = getparam("TYPEOF");
           ((TextView) findViewById(R.id.tTypeofDisaster)).setText("The nature of distress is " + message.toUpperCase());

        message = getparam("myBoatName");

        WordToSpell wts = new WordToSpell();

        String spellMessage = (new WordToSpell()).SpellLine(message);

           ((TextView) findViewById(R.id.tThisis)).setText("THIS IS " + message.toUpperCase() + ", " + message.toUpperCase() + ", " + message.toUpperCase()+" ("+spellMessage +" ).");


        message = getparam("myGPS");
        ((TextView) findViewById(R.id.tPosition)).setText("Position: "+ message.toUpperCase());

        message = getparam("HOWMUCHTIME") + ". There are " + getparam("myCREW") + " people on a board.";
        ((TextView) findViewById(R.id.tAdditionalQuestion)).setText(message.toUpperCase());

        // getparam("myBoatName",(EditText) findViewById(R.id.eBoatName));

       // getparam("myGPS",(EditText) findViewById(R.id.eGPS));
       // getparam("myDraught",(EditText) findViewById(R.id.eBoatDraught));
      //  getparam("myCREW",(EditText) findViewById(R.id.eCrewCount));*/
    }

    public void onClickBoard(View view) {

        Boolean forward = false;
        RadioButton r1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton r2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton r3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton r4 = (RadioButton) findViewById(R.id.rb4);


        if (r1.isChecked()) {

            forward = true;
            // BOW

            setparam("MYPOSITION","BOW");
        }

        if (r2.isChecked()) {

            forward = true;
            setparam("MYPOSITION","PORT");
            //port
        }


        if (r3.isChecked()) {

            forward = true;
            setparam("MYPOSITION","STARBOARD");
            //starboard
        }

        if (r4.isChecked()) {

            forward = true;
            setparam("MYPOSITION","STERN");
            //stern
        }

        if (forward) {

            Intent intent = new Intent(this, ScrollingMessage.class);
            startActivity(intent);

        } else {

            Toast.makeText(this, "Define your position", Toast.LENGTH_SHORT).show();
        }



    }
}
