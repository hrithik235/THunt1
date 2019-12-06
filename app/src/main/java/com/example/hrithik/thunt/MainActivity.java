package com.example.hrithik.thunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    public void animation(View view){
        ImageView border= (ImageView) findViewById(R.id.border);
        ImageView skull= (ImageView) findViewById(R.id.skull);
        ImageView logo= (ImageView) findViewById(R.id.logo);
        ImageView scroll=(ImageView)findViewById(R.id.scroll);
        Button rulesOkButton=(Button)findViewById(R.id.rulesOkButton);

        border.animate()
                .alpha(0f)
                .setDuration(3000);
        skull.animate()
                .alpha(0f)
                .setDuration(3000);
        logo.animate()
                .alpha(0f)
                .setDuration(3000);
        scroll.animate()
                .translationX(0f)
                .setDuration(3000)
                .setStartDelay(2000);
        rulesOkButton.animate()
                .alpha(1f)
                .setDuration(3000)
                .setStartDelay(2000);
        }

        public void rulesOk(View view){
            Intent intent=new Intent(getApplicationContext(),activity2.class);
            startActivity(intent);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView scroll=(ImageView)findViewById(R.id.scroll);
        Button rulesOkButton=(Button)findViewById(R.id.rulesOkButton);
        scroll.setTranslationX(-2000f);
        rulesOkButton.setAlpha(0f);


    }
}
