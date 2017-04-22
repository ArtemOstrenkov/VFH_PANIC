package com.ostrenkov.artem.seaspeak;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ostrenkov.artem.seaspeak.R;

public class ScrollingShowMessage extends AppCompatActivity {

    public Integer LastMessage = 0;
    public Integer CurentMessage = 0;
    public Integer MaxMessage = 1;
    public String  HTMLMessage = "";

    public String Measurenment(){

        String BOATNAME = getparam("myBoatName");
        String LOA = getparam("LOA");
        String myDraught = getparam("myDraught");
        String myLenght = getparam("myLenght");
        String myWidth = getparam("myWidth");
        String GPS = getparam("ShortGPS");

        return "Boat " + BOATNAME + " Lenght: " + myLenght +" ft, Draft: " +myDraught +" meters, Beam: " + myWidth +" meters, GPS: " + GPS;
    }


  /*  public void MessRotate() {

        //Toast.makeText(getApplicationContext(), "get param - "+ getparam("CurrentMessage"), Toast.LENGTH_SHORT).show();
        CurentMessage = Integer.parseInt(getparam("CurrentMessage"));
        LastMessage = Integer.parseInt(getparam("LastMessage"));

        CurentMessage = CurentMessage - 1;
        //Toast.makeText(getApplicationContext(), "CM +1 - "+ CurentMessage, Toast.LENGTH_SHORT).show();


        if ((CurentMessage) < 0) {

            CurentMessage = LastMessage;
            // Toast.makeText(getApplicationContext(), "CM - "+ CurentMessage, Toast.LENGTH_SHORT).show();
        }
        setparam("CurrentMessage", CurentMessage.toString());
        //Toast.makeText(getApplicationContext(), "CM - "+ CurentMessage, Toast.LENGTH_SHORT).show();

    }

    public void MessShift(){
        //Toast.makeText(getApplicationContext(), "get param - "+ getparam("CurrentMessage"), Toast.LENGTH_SHORT).show();
        CurentMessage = Integer.parseInt(getparam("CurrentMessage"));
        MaxMessage = Integer.parseInt(getparam("MaxMessage"));

        CurentMessage = CurentMessage + 1;

        if ((CurentMessage) > MaxMessage)  {
            CurentMessage = 0 ;
        }
        setparam("CurrentMessage",CurentMessage.toString());
        setparam("LastMessage",CurentMessage.toString());
        //Toast.makeText(getApplicationContext(), "CM - "+ CurentMessage, Toast.LENGTH_SHORT).show();

    }

    public void MessCheck(){
        //Toast.makeText(getApplicationContext(), "get param - "+ getparam("CurrentMessage"), Toast.LENGTH_SHORT).show();
        CurentMessage = Integer.parseInt(getparam("CurrentMessage"));
        LastMessage = Integer.parseInt(getparam("LastMessage"));

        if (getparam("ShowMessage").equals("Nope")){
            MessShift();
        } else

        {
            CurentMessage = Integer.parseInt(getparam("MaxMessage"));
        }

        HTMLMessage =  ComposeMessage();
    }
*/

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


  /*  public String ComposeMessage() {

        String Message = "";
        String CALLINGNAME = getparam("CALLINGNAME");
        String BOATNAME = getparam("myBoatName");

        WordToSpell wts = new WordToSpell();
        String spellMessage = (new WordToSpell()).SpellLine(BOATNAME);



        switch (getparam("Event")) {
            case "":
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                break;
            case "Routine":
                Toast.makeText(getApplicationContext(), "Routine", Toast.LENGTH_SHORT).show();
//-------------------------------------------Routine
                String step = getparam("STEP");

                switch (getparam(step)) {
                    case "":
                        Toast.makeText(getApplicationContext(), "ERROR STEP", Toast.LENGTH_SHORT).show();
                        break;
                    case "Call Vessel to start conversation":
                        Toast.makeText(getApplicationContext(), "Call Vessel to start conversation", Toast.LENGTH_SHORT).show();

                        Message = Message + "<h1>" + CALLINGNAME + ","+ CALLINGNAME + ","+ CALLINGNAME + "</h1>";
                        Message = Message + "<h1>This is " + BOATNAME + ", "+ BOATNAME + ", "+ BOATNAME + ","+ " ("+spellMessage +")</h1>";
                        Message = Message + "<h1>Switch to VHF channel " + "06" + "</h1>";
                        Message = Message + "<h1>Over</h1>";
                        break;

                    case "Divergence of ships at sea":
                        Toast.makeText(getApplicationContext(), "Divergence of ships at sea", Toast.LENGTH_SHORT).show();
                        break;

                    case "Clarify intentions of another ship":
                        Toast.makeText(getApplicationContext(), "Clarify intentions of another ship", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(getApplicationContext(), "Default ERROR", Toast.LENGTH_SHORT).show();
                        break;
                }

//-------------------------------------------

                break;
            case "Emergency":
                Toast.makeText(getApplicationContext(), "Emergency", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Default ERROR", Toast.LENGTH_SHORT).show();
                break;
        }

        return Message ;
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_message);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((FloatingActionButton) findViewById(R.id.floatingActionButton)).setVisibility(View.INVISIBLE);

        final String sInfo = Measurenment();

        HTMLMessage =  getparam("LastMessage");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, sInfo, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // MessRotate();

                //  HTMLMessage = getparam("ArrayMessage"+CurentMessage);

                /// ((TextView) findViewById(R.id.tvMessage)).setText(Html.fromHtml(HTMLMessage));

            }
        });




        ((TextView) findViewById(R.id.tvMessage)).setText(Html.fromHtml(HTMLMessage));

    }



    @Override
    public void onResume(){
        // Очистите все ресурсы. Это касается завершения работы
        // потоков, закрытия соединений с базой данных и т. д.


        super.onResume();
    }

    public void onClickBack(View view) {


    }
}
