package org.insideranken.npcottner.rectanglecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class rectangleSplashScreen extends AppCompatActivity {

    Handler mHandler;
    Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_splash_screen);

        mHandler = new Handler();

        mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(rectangleSplashScreen.this,
                        MainActivity.class);

                startActivity(intent);
                finish();
            }
        };

        mHandler.postDelayed(mRunnable, 5000);
    }
}