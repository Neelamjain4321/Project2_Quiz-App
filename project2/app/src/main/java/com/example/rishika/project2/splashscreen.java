package com.example.rishika.project2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashscreen extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_splashscreen);

       new CountDownTimer(2000, 1000) {
           @Override
           public void onTick(long l) {

           }

           @Override
           public void onFinish() {

               Intent intent = new Intent(splashscreen.this, MainActivity.class);
               startActivity(intent);
               splashscreen.this.finish();

           }
       }.start();
   }
}
