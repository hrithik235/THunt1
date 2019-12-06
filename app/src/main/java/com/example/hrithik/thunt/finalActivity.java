package com.example.hrithik.thunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class finalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        TextView finalTime=(TextView)findViewById(R.id.finalTime);
        int sec=0,min=0,hour=0;
        final String[] second = new String[1];
        final String[] minute = {null};
        final String[] hourr = new String[1];
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            sec= extras.getInt("sec");
            min = extras.getInt("min");
            hour = extras.getInt("hour");
            }
        second[0] =String.valueOf(sec);
        minute[0] =String.valueOf(min);
        hourr[0] =String.valueOf(hour);
        if(sec<10)
            second[0]="0"+second[0];
        if(min<10)
            minute[0]="0"+minute[0];
        if(hour<10)
            hourr[0]="0"+hourr[0];



        finalTime.setText(String.valueOf(hourr[0])+":"+String.valueOf(minute[0])+":"+String.valueOf(second[0]));

    }
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
    }
}
