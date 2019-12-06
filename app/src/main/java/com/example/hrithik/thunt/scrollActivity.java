package com.example.hrithik.thunt;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class scrollActivity extends AppCompatActivity {
    String[] riddleArray={"Straight in the centre I sit at the top,This time you won't be mocked.","The basics of all the sciences on the ground floor.","A way to get away from this premises, there are two of them use your mind because this is the task of the wises.","Garden and food together, from the entry /exit, you have got the caliber just don't quit.","Action ka ____ time? This is the location and a tagline.","Shouts, mocks and arguments, oppositions and parties you'll find where, our next clue lies there.","I give you oxygen and shadow, A lot of people who'll find there in a row. I stand alone but I'm surrounded by students and buildings. This is a clue ting ting tiding.","Bluff ain't effective for people of type-A.Become the type A because you have been bluffed.It will end from where it started and you know what? Life is a circle.So Go Run and Win this TREASURE HUNT!!"};
    int sec1=0,min1=0,hour1=0;
    public void nextButtonCalled(View view){
        Intent intent=new Intent(getApplicationContext(),activity2.class);
        intent.putExtra("sec",sec1);
        intent.putExtra("min",min1);
        intent.putExtra("hour",hour1);
        startActivity(intent);
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        TextView riddle=(TextView)findViewById(R.id.riddle);
        final  TextView timer= (TextView)findViewById(R.id.timer);
        int value=0;
        final int[] sec = {0};
        final int[] min = {0};
        final int[] hour = {0};
        final String[] second = new String[1];
        final String[] minute = {null};
        final String[] hourr = new String[1];

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           value = extras.getInt("m");
           sec[0]= extras.getInt("sec");
            min[0]= extras.getInt("min");
            hour[0]= extras.getInt("hour");
           Log.i("result","m="+String.valueOf(value));
                   }

           riddle.setText(riddleArray[value]);





        final Handler handler = new Handler();
        Runnable run =new Runnable() {
            @Override
            public void run() {
                sec[0]= sec[0] +1;
                if(sec[0]>=60){
                    min[0] = min[0] +sec[0]%60;
                    sec[0]= sec [0]- (sec[0]%60)*60;

                }
                if(min[0]>=60){
                    hour[0] = hour[0] +min[0]%60;
                    min[0]= min[0]- (min[0]%60)*60;

                }
                sec1=sec[0];
                min1=min[0];
                hour1=hour[0];
                second[0] =String.valueOf(sec[0]);
                minute[0] =String.valueOf(min[0]);
                hourr[0] =String.valueOf(hour[0]);
                if(sec[0]<10)
                    second[0]="0"+second[0];
                if(min[0]<10)
                    minute[0]="0"+minute[0];
                if(hour[0]<10)
                    hourr[0]="0"+hourr[0];
                timer.setText(String.valueOf(hourr[0])+":"+String.valueOf(minute[0])+":"+String.valueOf(second[0]));
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run); }
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
