package com.ostrenkov.artem.seaspeak;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActBoatInfo extends AppCompatActivity {

    public Context mainContext;


    public String[] data1 = {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};

    public void getparam(String name, EditText ed){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);
        String mySetting = sharedPref.getString(name, null);
        //EditText eboatName = (EditText) findViewById(R.id.eBoatName);
        ed.setText(mySetting);

    }

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

    public void setparam(String name, EditText ed){

        SharedPreferences sharedPref = getSharedPreferences(name, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        //EditText eboatName = (EditText) findViewById(R.id.eBoatName);
        //String bName = ed.getText().toString();
        editor.putString(name,ed.getText().toString());
        editor.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_boat_info);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner1 = (Spinner) findViewById(R.id.sCrewcount);
        spinner1.setAdapter(adapter);
        // заголовок
        ;
        //spinner1.setPrompt(getparam("myCREW"));

        spinner1.setSelection(Integer.parseInt(getparam("myCREW"))-1);
        // выделяем элемент

        // устанавливаем обработчик нажатия
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                //Toast.makeText(getBaseContext(), "Position = " + data1[position] +" " + getparam("myCREW"), Toast.LENGTH_SHORT).show();
                setparam("myCREW",data1[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }







    @Override
    protected void onStart(){

        getparam("myBoatName",(EditText) findViewById(R.id.eBoatName));

        getparam("myDraught",(EditText) findViewById(R.id.eBoatDraught));
        getparam("myLenght",(EditText) findViewById(R.id.eLOA));
        getparam("myWidth",(EditText) findViewById(R.id.eWidtgBoat));
       // final Spinner spinner = (Spinner) findViewById(R.id.spinner);
       // spinner.setPrompt(getparam("myCREW"));

        super.onStart();

    }

    @Override
    public void onPause(){
        // Очистите все ресурсы. Это касается завершения работы
        // потоков, закрытия соединений с базой данных и т. д.


        setparam("myBoatName",(EditText) findViewById(R.id.eBoatName));

        setparam("myDraught",(EditText) findViewById(R.id.eBoatDraught));
        setparam("myLenght",(EditText) findViewById(R.id.eLOA));
        setparam("myWidth",(EditText) findViewById(R.id.eWidtgBoat));


        super.onPause();
    }


    public void onClickSave(View view) {

        onBackPressed();

    }
}
