package com.ostrenkov.artem.seaspeak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class mayday_relay extends AppCompatActivity {

    //String[] data = {"UTC", "Local"};
    String[] data = {"Local", "UTC", "GMT"};

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
        setContentView(R.layout.activity_mayday_relay);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Local");
        setparam("TIMEFORMAT",data[0]);
        // выделяем элемент
        spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
                setparam("TIMEFORMAT",data[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }


    public void onClickNext(View view) {
        WordToSpell wts =  new WordToSpell();
        setparam("TIMEOFMESSAGE",wts.SpellNumbers(((EditText) findViewById(R.id.edTime)).getText().toString()) + " "+ getparam("TIMEFORMAT"));
      /*  EditText ee = ((EditText) findViewById(R.id.edMessRelay));
        String ss = ee.getText().toString();
        String ars[] = ss.split("/n");

        Toast.makeText(getBaseContext(), "ars = " + ars.length, Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(), "ars = " + ars[0], Toast.LENGTH_SHORT).show();
       // Toast.makeText(getBaseContext(), "ars = " + ars[1], Toast.LENGTH_SHORT).show();

        String Message = "";

        for (int x = 0; x < ars.length; x = x + 1) {
         Message = Message + "<h3>" + ars[x] + "</h3>" ;
        }*/
        setparam("RECEIVEDMESSAGE","<h3 font-size:medium>" + ((EditText) findViewById(R.id.edMessRelay)).getText().toString()+"</h3>" );
        Intent intent = new Intent(this, ScrollingMessage.class);
        startActivity(intent);
    }
}
