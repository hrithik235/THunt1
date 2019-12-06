package com.example.hrithik.thunt;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class activity2 extends AppCompatActivity {
    static int s=0;
    int flag=0;
    static int arry[]={0,0,0,0,0,0,0,0};
    int m;
    int sec1=0,min1=0,hour1=0;
    String b;
    int[][] pin={{1,4,6},{6,9,0},{4,8,9},{5,3,1},{8,2,7},{9,1,7},{2,4,7},{8,0,9},{1,9,7}};

    Random rand= new Random();

    public String numberGenerator(int i){
        Log.i("result","number generate kr rha hai?");
        String num="";
        int l=0;
        int arr[] = {0, 0, 0};
        while(l<3) {
            Log.i("result","OK pressed 1");
            int p = rand.nextInt(3);

            if (arr[p] == 0) {
                num+=(String.valueOf(pin[i][p]));
                arr[p] = 1;
                l++;
            }
        }
        num.trim();
        Log.i("result","num:"+num);
    return num;
    }

    public void checkRiddleRepeat() {
        int w;
        for( w=0;w<8;w++){
            if(arry[w]==0)
            {
                break;
            }
        }
        if(w!=7)
        {while(true){
           int y = rand.nextInt(7);
            if (arry[y] == 0) {
                  m=y;
                s = y + 1;
                arry[y]=1;
                 break;
            }
        }}
        else
        {s=8;
        m=7;}
    }

    public void okPressed(View view) {
        Log.i("result","OK pressed!");
        TextView editTextEnterPin= (TextView) findViewById(R.id.editTextEnterPin);
        if((editTextEnterPin.getText().toString()).equals(b)){
            Toast.makeText(activity2.this,
                    "Correct Pin!", Toast.LENGTH_SHORT).show();

            checkRiddleRepeat();
            Log.i("result",String.valueOf(flag));
            if(flag==1){
                Log.i("result","yaaaa!");
                Intent intent=new Intent(getApplicationContext(),finalActivity.class);
                intent.putExtra("sec",sec1);
                intent.putExtra("min",min1);
                intent.putExtra("hour",hour1);
                startActivity(intent);
            }
           else{
            Intent intent=new Intent(getApplicationContext(),scrollActivity.class);
            intent.putExtra("m",m);
            intent.putExtra("sec",sec1);
            intent.putExtra("min",min1);
            intent.putExtra("hour",hour1);
            startActivity(intent);
            }}
        else
            Toast.makeText(activity2.this,
                    "Wrong Pin!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
            b=numberGenerator(s);
            Log.i("result",b);
          final  TextView timer= (TextView)findViewById(R.id.timer);

        final int[] sec = {0};
        final int[] min = {0};
        final int[] hour = {0};

        final String[] second = new String[1];
        final String[] minute = {null};
        final String[] hourr = new String[1];


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            sec[0] = extras.getInt("sec");
            min[0] = extras.getInt("min");
            hour[0] = extras.getInt("hour");

        }

        final Handler handler = new Handler();
            Runnable run =new Runnable() {
                @Override
                public void run() {
                    sec[0] = sec[0] +1;
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
    handler.post(run);
        if(s==8)
        {flag=1;
        Log.i("result",String.valueOf(flag));}
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
