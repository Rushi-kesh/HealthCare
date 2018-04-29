package com.rushikeshgaikwad.healthcaree;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {
    ImageView IV;
    private static int time_span=4000;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        IV=findViewById(R.id.imageView2 );
        textView=findViewById(R.id.textView14 );
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        IV.startAnimation(animation);
        textView.setAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent=new Intent(StartScreen.this,Home.class);
                startActivity(myIntent);
                finish();

            }
        },time_span);
    }
}
