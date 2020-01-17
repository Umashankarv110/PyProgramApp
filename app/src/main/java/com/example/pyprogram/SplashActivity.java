package com.example.pyprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.iv);
        textView = findViewById(R.id.tv);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);
        final Intent i = new Intent(this,StartAppActivity.class);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        thread.start();
    }
}
