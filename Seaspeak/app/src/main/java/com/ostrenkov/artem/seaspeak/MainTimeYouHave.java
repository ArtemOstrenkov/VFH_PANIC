package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainTimeYouHave extends AppCompatActivity {

    public void setparam(String name,  String res){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        //EditText eboatName = (EditText) findViewById(R.id.eBoatName);
        //String bName = ed.getText().toString();
        editor.putString(name,res);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time_you_have);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


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
                        setparam("HOWMUCHTIME", "WE ARE LEAVING BOAT");
                        break;
                    case R.id.radioButton2:
                        setparam("HOWMUCHTIME", "WE HAVE ABOUT THREE ZERO MINUTES");
                        break;
                    case R.id.radioButton3:
                        setparam("HOWMUCHTIME", "WE HAVE ABOUT ONE HOUR");
                        break;
                    case R.id.radioButton4:
                        setparam("HOWMUCHTIME", "WE HAVE ABOUT TWO HOUR");
                        break;
                    case R.id.radioButton5:
                        setparam("HOWMUCHTIME", "WE HAVE ABOUT THREE HOURS");
                        break;
                    case R.id.radioButton6:
                        setparam("HOWMUCHTIME", "WE HAVE ABOUT FOUR HOURS");
                        break;
                    case R.id.radioButton7:
                        setparam("HOWMUCHTIME", "WE HAVE ABOUT ONE ZERO HOURS");
                        break;

                    default:
                        break;
                }


            }
        });

    }
    public void onClickNext(View view) {

        Intent intent = new Intent(this, ScrollingMessage.class);
        startActivity(intent);
    }
}
