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

public class CancelDIstress extends AppCompatActivity {


    String[] data = {"Local", "UTC", "GMT"};
    String[] dataMonth = {"January","February",	"March","April","May","June","July",	"August","September","October","November","December"};
    String[] dataDate = {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

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
        setContentView(R.layout.activity_cancel_distress);

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

        // адаптер DATE
        ArrayAdapter<String> adapterDATE = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataDate);
        adapterDATE.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinnerDATE = (Spinner) findViewById(R.id.spDATE);
        spinnerDATE.setAdapter(adapterDATE);
        // заголовок
        spinnerDATE.setPrompt("1");
        setparam("DATEOFDISTRESS",dataDate[0]);
        // выделяем элемент
        spinnerDATE.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerDATE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "DATEOFDISTRESS = " + dataDate[position], Toast.LENGTH_SHORT).show();
                setparam("DATEOFDISTRESS",dataDate[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        // адаптер Month
        ArrayAdapter<String> adapterMonth = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataMonth);
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinnerMonth = (Spinner) findViewById(R.id.spMonth);
        spinnerMonth.setAdapter(adapterMonth);
        // заголовок
        spinnerMonth.setPrompt("January");
        setparam("MONTHOFDISTRESS",dataMonth[0]);
        // выделяем элемент
        spinnerMonth.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "MONTHOFDISTRESS = " + dataMonth[position], Toast.LENGTH_SHORT).show();
                setparam("MONTHOFDISTRESS",dataMonth[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });



    }


    public void onClickNextDist(View view) {

        WordToSpell wts =  new WordToSpell();
        setparam("TIMEOFMESSAGE",wts.SpellNumbers(((EditText) findViewById(R.id.edTime)).getText().toString()) + " "+ getparam("TIMEFORMAT"));
        Intent intent = new Intent(this, ScrollingMessage.class);
        startActivity(intent);


    }
}

