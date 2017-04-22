package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
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

import java.util.Currency;

public class ScrollingMessage extends AppCompatActivity {

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


    public String ComposeMessage() {

        String Message = "";
        String CALLINGNAME = getparam("CALLINGNAME").toUpperCase();
        String MARINENAME = getparam("MARINA").toUpperCase();
        String BOATNAME = getparam("myBoatName").toUpperCase();
        String step = getparam("STEP");
        String sEvent  = getparam("Event");
        String MYPOSITION = getparam("MYPOSITION").toUpperCase();


        WordToSpell wts = new WordToSpell();
        String spellMessage = (new WordToSpell()).SpellLine(BOATNAME);

      //  return CALLINGNAME + MARINENAME + BOATNAME + step;


        switch (sEvent) {
            case "":
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                break;
            case "Routine":
                //Toast.makeText(getApplicationContext(), "Routine", Toast.LENGTH_SHORT).show();
//-------------------------------------------Routine

                switch (step) {
                    case "":
                        Toast.makeText(getApplicationContext(), "ERROR STEP", Toast.LENGTH_SHORT).show();
                        break;
                    case "CALLVESSEL":
                        //Toast.makeText(getApplicationContext(), "Call Vessel to start conversation", Toast.LENGTH_SHORT).show();

                        if (MYPOSITION.equals("NONE")){
                            Message = Message + "If were nothing specific then use  06 or 13 channels";
                            Message = Message + "<h1> </h1>";
                            Message = Message + "<h1>" + CALLINGNAME + ", "+ CALLINGNAME + ", "+ CALLINGNAME + "</h1>";
                            Message = Message + "<h1>This is " + BOATNAME + ", "+ BOATNAME + ", "+ BOATNAME+ " ("+spellMessage +")</h1>";
                            Message = Message + "<h1>Switch to VHF channel " + "ZERO-SIX" + "</h1>";
                            Message = Message + "<h1>Over</h1>";

                        }
                        else {
                            Message = Message + "If were nothing specific then use  06 or 13 channels";
                            Message = Message + "<h1> </h1>";
                            Message = Message + "<h1>" + CALLINGNAME + ", " + CALLINGNAME + ", " + CALLINGNAME + "</h1>";
                            Message = Message + "<h1>This is Sailing Yatch " + BOATNAME + " on your " + MYPOSITION + "</h1>";
                            Message = Message + "<h1>Switch to VHF channel " + "ZERO-SIX" + "</h1>";
                            Message = Message + "<h1>Over</h1>";
                        }

                        break;

                    case "rbYOUGiveaWay":
                        //Toast.makeText(getApplicationContext(), "rbYOUGiveaWay", Toast.LENGTH_SHORT).show();

                        Message = Message + "If were nothing specific then use  06 or 13 channels";
                        Message = Message + "<h1> </h1>";
                        Message = Message + "<h1>" + CALLINGNAME + ", " + CALLINGNAME + ", " + CALLINGNAME + "</h1>";
                        Message = Message + "<h1>This is Sailing Yatch " + BOATNAME + " on your " + MYPOSITION + "</h1>";
                        Message = Message + "<h1>I will pass you on your stern </h1>";
                        Message = Message + "<h1>I am giving you way</h1>";
                        Message = Message + "<h1>Over</h1>";

                        break;


                    case "rbASKtheWAY":
                        //Toast.makeText(getApplicationContext(), "rbASKtheWAY", Toast.LENGTH_SHORT).show();

                        Message = Message + "If were nothing specific then use  06 or 13 channels";
                        Message = Message + "<h1> </h1>";
                        Message = Message + "<h1>" + CALLINGNAME + ", " + CALLINGNAME + ", " + CALLINGNAME + "</h1>";
                        Message = Message + "<h1>This is Sailing Yatch " + BOATNAME + " on your " + MYPOSITION + "</h1>";
                        Message = Message + "<h1>I am sailing now</h1>";
                        Message = Message + "<h1>I asking you to let me pass on your bow</h1>";
                        Message = Message + "<h1>Over</h1>";

                        break;

                    case "rbClarifyIntention":
                        Toast.makeText(getApplicationContext(), "rbClarifyIntention", Toast.LENGTH_SHORT).show();

                        Message = Message + "If were nothing specific then use  06 or 13 channels";
                        Message = Message + "<h1> </h1>";
                        Message = Message + "<h1>" + CALLINGNAME + ", " + CALLINGNAME + ", " + CALLINGNAME + "</h1>";
                        Message = Message + "<h1>This is Sailing Yatch " + BOATNAME + " on your " + MYPOSITION + "</h1>";
                        Message = Message + "<h1>I am sailing now</h1>";
                        Message = Message + "<h1>You are on the collision course, what is your intention, please</h1>";
                        Message = Message + "<h1>Over</h1>";

                        break;

                    case "PLACETOSTAY":
                        //Toast.makeText(getApplicationContext(), "PLACETOSTAY", Toast.LENGTH_SHORT).show();
                        Message = Message + "If were nothing specific in PILOT then use  09, 72, 71 channels";
                        Message = Message + "<h1> </h1>";
                        Message = Message + "<h1> MARINA " + MARINENAME.toUpperCase() + ", MARINA "+ MARINENAME.toUpperCase() + ", MARINA "+ MARINENAME.toUpperCase() + "</h1>";
                        Message = Message + "<h1>This is Sailing Yacht " + BOATNAME + ", "+ BOATNAME + ", "+ BOATNAME+ " </h1>";//("+spellMessage +")
                        Message = Message + "<h1>Need a place to stay</h1>";
                        Message = Message + getparam("MARINEAssistance");
                        Message = Message + "<h1>Over</h1>";
                        break;

                    case "HOMEMARINE":
                       // Toast.makeText(getApplicationContext(), "PLACETOSTAY", Toast.LENGTH_SHORT).show();
                        Message = Message + "If were nothing specific in pilot then use  09, 72, 71 channels";
                        Message = Message + "<h1> </h1>";
                        Message = Message + "<h1> MARINA " + MARINENAME.toUpperCase() + ", MARINA "+ MARINENAME.toUpperCase() + ", MARINA "+ MARINENAME.toUpperCase() + "</h1>";
                        Message = Message + "<h1>This is Sailing Yacht " + BOATNAME + ", "+ BOATNAME + ", "+ BOATNAME+ " </h1>"; //("+spellMessage +")
                        Message = Message + "<h1>We are comming home </h1>";
                        Message = Message + getparam("MARINEAssistance");
                        Message = Message + "<h1>Over</h1>";
                        break;
                    case "CUSTOMS":
                        //Toast.makeText(getApplicationContext(), "CUSTOMS", Toast.LENGTH_SHORT).show();

                    Message = Message + "If were nothing specific in pilot then use  09, 72, 71 channels";
                    Message = Message + "<h1> </h1>";
                    Message = Message + "<h1> " + MARINENAME.toUpperCase() + ", "+ MARINENAME.toUpperCase() + ", "+ MARINENAME.toUpperCase() + "</h1>";
                    Message = Message + "<h1>This is Sailing Yacht " + BOATNAME + ", "+ BOATNAME + ", "+ BOATNAME+ " ("+spellMessage +")</h1>";
                    Message = Message + "<h1>I am asking a place at the customs peer to pass border formalities</h1>";
                        Message = Message + getparam("MARINEAssistance");
                        Message = Message + "<h1>Over</h1>";
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Default ERROR", Toast.LENGTH_SHORT).show();
                        break;
                }

//-------------------------------------------

                break;

            case "Emergency":
                //Toast.makeText(getApplicationContext(), "Emergency", Toast.LENGTH_SHORT).show();


        switch (step) {
            case "":
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                break;
            case "MAYDAY":

                Message = Message + "<h1> " + step.toUpperCase() + " "+ step.toUpperCase() + " "+step.toUpperCase() + "</h1>";
                Message = Message + "<h1>" + "ALL SHIPS" + ","+ "ALL SHIPS" + ","+ "ALL SHIPS" + "</h1>";
                Message = Message + "<h1><u>This is</u> " + BOATNAME + ", "+ BOATNAME + ", "+ BOATNAME + ","+ " ("+spellMessage +")</h1>";
                Message = Message + "<h1><u>The nature of distress is</u> "+ getparam("TYPEOF").toUpperCase()+"</h1>";
                Message = Message + "<h1><u>Position:</u> "+ getparam("LongGPS").toUpperCase()+"</h1>";
                Message = Message + "<h1>" +getparam("HOWMUCHTIME") + ". There are " + getparam("myCREW") + " people on a board.</h1>";
                Message = Message + "<h1><u>OVER</u></h1>";
                Message = Message + "<h1>" + getparam("ShortGPS").toUpperCase()+ "</h1>";

                break;
            case "PANPAN":

                Message = Message + "<h1> " + step.toUpperCase() + " "+ step.toUpperCase() + " "+step.toUpperCase() + "</h1>";
                Message = Message + "<h1>" + "ALL SHIPS" + ","+ "ALL SHIPS" + ","+ "ALL SHIPS" + "</h1>";
                Message = Message + "<h1><u>This is</u> " + BOATNAME.toUpperCase() + ", "+ BOATNAME.toUpperCase() + ", "+ BOATNAME.toUpperCase() + ","+ " ("+spellMessage +")</h1>";
                Message = Message + "<h1>The nature of distress is "+ getparam("TYPEOF").toUpperCase()+"</h1>";
                Message = Message + "<h1>Position: "+ getparam("LongGPS").toUpperCase()+"</h1>";
                Message = Message + "<h1>" +getparam("HOWMUCHTIME") + ". There are " + getparam("myCREW") + " people on a board.</h1>";
                Message = Message + "<h1>OVER</h1>";


                break;
            case "MAYDAY RELAY":

                Message = Message + "<h1> " + step.toUpperCase() + " "+ step.toUpperCase() + " "+step.toUpperCase() + "</h1>";
                Message = Message + "<h1>" + "ALL SHIPS" + ","+ "ALL SHIPS" + ","+ "ALL SHIPS" + "</h1>";
                Message = Message + "<h1>This is sailing yacht " + BOATNAME.toUpperCase() + ", "+ BOATNAME.toUpperCase() + ", "+ BOATNAME.toUpperCase() + "</h1>";
                Message = Message + "<h1>RECEIVED MAYDAY at "+ getparam("TIMEOFMESSAGE").toUpperCase()+"</h1>";
                Message = Message + "<h1>---------------------</h1>" ;
                Message = Message + getparam("RECEIVEDMESSAGE") ;
                Message = Message + "<h1>---------------------</h1>" ;
                Message = Message + "<h1>OVER</h1>";
                //Message = Message + "<h1></h1>";
                //Message = Message + "<h1></h1>";



                break;
            case "CANCELDISTRESS":
                Message = Message + "<h1>ALL STATIONS, ALL STATIONS, ALL STATIONS</h1>";
                Message = Message + "<h1>This is sailing yacht " + BOATNAME.toUpperCase() + ", "+ BOATNAME.toUpperCase() + ", "+ BOATNAME.toUpperCase() + "</h1>";
                Message = Message + "<h1>Position: "+ getparam("LongGPS").toUpperCase()+"</h1>";
                Message = Message + "<h1>CANCEL MY DISTRESS ALERT OF " + getparam("DATEOFDISTRESS") +" " + getparam("MONTHOFDISTRESS")+ " at " + getparam("TIMEOFMESSAGE")+ "</h1>";
                Message = Message + "<h1>OVER</h1>";
                break;
            default:
                Toast.makeText(getApplicationContext(), "Default ERROR", Toast.LENGTH_SHORT).show();
                break;
        }

        break;
        default:
        Toast.makeText(getApplicationContext(), "Default ERROR", Toast.LENGTH_SHORT).show();
        break;
    }

    return Message ;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_message);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



            HTMLMessage =  ComposeMessage();
            setparam("LastMessage",HTMLMessage);

        final String sMeasurenment = Measurenment();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Snackbar.make(view, sMeasurenment, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

               // MessRotate();

              //  HTMLMessage = getparam("ArrayMessage"+CurentMessage);

               /// ((TextView) findViewById(R.id.tvMessage)).setText(Html.fromHtml(HTMLMessage));

            }
        });


        FloatingActionButton fabBack = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

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


}
