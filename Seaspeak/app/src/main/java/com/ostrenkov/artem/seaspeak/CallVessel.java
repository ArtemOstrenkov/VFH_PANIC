package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CallVessel extends AppCompatActivity {

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

    public Boolean Position = false;
    /*private RadioButton rb00;
    private RadioButton rb01;
    private RadioButton rb02;
    private RadioButton rb03;
    private RadioButton rb04;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_vessel);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        final RadioButton rb00  = (RadioButton) findViewById(R.id.rbVesselName);
        final RadioButton rb01 = (RadioButton) findViewById(R.id.rbSailingYacht);
        final RadioButton rb02 = (RadioButton) findViewById(R.id.rbMotorYacht);
        final RadioButton rb03 = (RadioButton) findViewById(R.id.rbCargoShip);
        final RadioButton rb04 = (RadioButton) findViewById(R.id.rbPassengersShip);

        setparam("STEP","None");
        setparam("MYPOSITION","None");

       // ((EditText) findViewById(R.id.eBoatName)).setText(getparam("CALLINGNAME"));


        EditText eBoatN1 = (EditText) findViewById(R.id.eBoatName);


        eBoatN1.addTextChangedListener(new TextWatcher() {
                                           @Override
                                           public void beforeTextChanged(CharSequence s, int start, int count,
                                                                         int after) {
                                               rb00.setChecked(true);
                                               rb01.setChecked(false);
                                               rb02.setChecked(false);
                                               rb03.setChecked(false);
                                               rb04.setChecked(false);

                                           }


                                           @Override
                                           public void onTextChanged(CharSequence s, int start, int before, int count) {

                                           }

                                           @Override
                                           public void afterTextChanged(Editable s) {

                                               setparam("CALLINGNAME", ((EditText) findViewById(R.id.eBoatName)).getText().toString());

                                           }
                                       });





        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.rgVesselPurpose);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) throws NullPointerException {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "No choice", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbNeedtoCallVessel:
                        setparam("VESSELCALLPURPOSE", "Conversation");
                        setparam("STEP","CALLVESSEL");

                        //((RadioButton) findViewById(R.id.rbNeedtoCallVessel)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbYOUGiveaWay)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbASKtheWAY)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbClarifyIntention)).setVisibility(View.GONE);


                        ((TextView) findViewById(R.id.tTypeOfVessel)).setVisibility(View.VISIBLE);
                        ((LinearLayout) findViewById(R.id.llTypeORName)).setVisibility(View.VISIBLE);

                        break;
                    case R.id.rbYOUGiveaWay:
                        setparam("VESSELCALLPURPOSE", "rbYOUGiveaWay");
                        setparam("STEP","rbYOUGiveaWay");

                        ((RadioButton) findViewById(R.id.rbNeedtoCallVessel)).setVisibility(View.GONE);
                        //((RadioButton) findViewById(R.id.rbYOUGiveaWay)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbASKtheWAY)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbClarifyIntention)).setVisibility(View.GONE);


                        ((TextView) findViewById(R.id.tTypeOfVessel)).setVisibility(View.VISIBLE);
                        ((LinearLayout) findViewById(R.id.llTypeORName)).setVisibility(View.VISIBLE);


                        break;
                    case R.id.rbASKtheWAY:
                        setparam("VESSELCALLPURPOSE", "askaway");
                        setparam("STEP","rbASKtheWAY");

                        ((RadioButton) findViewById(R.id.rbNeedtoCallVessel)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbYOUGiveaWay)).setVisibility(View.GONE);
                        //((RadioButton) findViewById(R.id.rbASKtheWAY)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbClarifyIntention)).setVisibility(View.GONE);


                        ((TextView) findViewById(R.id.tTypeOfVessel)).setVisibility(View.VISIBLE);
                        ((LinearLayout) findViewById(R.id.llTypeORName)).setVisibility(View.VISIBLE);

                        break;


                    case R.id.rbClarifyIntention:
                        setparam("VESSELCALLPURPOSE", "clarify");
                        setparam("STEP","rbClarifyIntention");

                        ((RadioButton) findViewById(R.id.rbNeedtoCallVessel)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbYOUGiveaWay)).setVisibility(View.GONE);
                        ((RadioButton) findViewById(R.id.rbASKtheWAY)).setVisibility(View.GONE);
                        //((RadioButton) findViewById(R.id.rbClarifyIntention)).setVisibility(View.GONE);


                        ((TextView) findViewById(R.id.tTypeOfVessel)).setVisibility(View.VISIBLE);
                        ((LinearLayout) findViewById(R.id.llTypeORName)).setVisibility(View.VISIBLE);
                        break;


                    default:
                        break;
                }


            }
        });


        RadioGroup radiogroupVessel = (RadioGroup) findViewById(R.id.rgTypeOfVessel);


        radiogroupVessel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) throws NullPointerException {
                // TODO Auto-generated method stub


                Position = false;
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "No choice", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbVesselName:
                        setparam("CALLINGNAME", ((EditText) findViewById(R.id.eBoatName)).getText().toString());
                        Position = true;

                        break;
                    case R.id.rbSailingYacht:
                        //setparam("VESSELCALLPURPOSE", "Call Vessel to start conversation");
                        //setparam("STEP","CALLVESSEL");
                        setparam("CALLINGNAME","Sailing Yacht");
                        break;
                    case R.id.rbCargoShip:
                        //setparam("VESSELCALLPURPOSE", "Divergence of ships at sea");
                        //setparam("STEP","Divergence");
                        setparam("CALLINGNAME","CARGO SHIP");

                        break;
                    case R.id.rbPassengersShip:
                        //setparam("VESSELCALLPURPOSE", "Clarify intentions of another ship");
                        //setparam("STEP","Clarify");
                        setparam("CALLINGNAME","PASSENGERS SHIP");
                        break;

                    case R.id.rbMotorYacht:
                        //setparam("VESSELCALLPURPOSE", "Clarify intentions of another ship");
                        //setparam("STEP","Clarify");
                        setparam("CALLINGNAME","MOTORYACHT");

                        break;

                    default:
                        break;
                }


            }
        });




    }

    public void onClickNextCALLVESSEL(View view) {
        String Step = getparam("STEP");



        if (Step.equals("None")){
            Toast.makeText(getApplicationContext(), "Check the variant", Toast.LENGTH_SHORT).show();
        } else {

            //Boolean br00 = ((RadioButton) findViewById(R.id.rbCargoShip)).isChecked();

            if (((RadioButton) findViewById(R.id.rbVesselName)).isChecked()|((RadioButton) findViewById(R.id.rbCargoShip)).isChecked()|((RadioButton) findViewById(R.id.rbPassengersShip)).isChecked()|((RadioButton) findViewById(R.id.rbMotorYacht)).isChecked()|((RadioButton) findViewById(R.id.rbSailingYacht)).isChecked()){

                if ((((RadioButton) findViewById(R.id.rbNeedtoCallVessel)).isChecked())&((RadioButton) findViewById(R.id.rbVesselName)).isChecked()){

                    Intent intent = new Intent(this, ScrollingMessage.class);
                    startActivity(intent);

                } else {

                    Intent intent = new Intent(this, ActMessage.class);
                    startActivity(intent);

                }


              /*
                if (Position) {
                    //setparam("STEP", "VESSELCALLPURPOSE");
                    Intent intent = new Intent(this, ScrollingMessage.class);
                    startActivity(intent);
                } else {
                    //setparam("STEP", "VESSELCALLPURPOSE");
                    Intent intent = new Intent(this, ActMessage.class);
                    startActivity(intent);

                }
*/
            }
            else Toast.makeText(getApplicationContext(), "Check vessel type or put the name", Toast.LENGTH_SHORT).show();
        }
    }
}
