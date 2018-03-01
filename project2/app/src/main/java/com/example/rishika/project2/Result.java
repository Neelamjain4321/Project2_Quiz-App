package com.example.rishika.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RatingBar bar = (RatingBar)findViewById(R.id.ratingbar);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        TextView t =(TextView)findViewById(R.id.textresult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("Score");
        bar.setRating(score);
        switch (score){
            case 0:t.setText("0%,very bad!");
            break;
            case 1:t.setText("20%,it was ok..");
                break;
            case 2:t.setText("40%,good try to improve");
                break;
            case 3:t.setText("60%, very good try to improve");
                break;
            case 4:t.setText("80%,Excellent");
                break;
            case 5:t.setText("100%,Fantastic, u have done a great job");
                break;

        }

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==R.id.action_settings){
            Intent settingsIntent = new Intent(this,MainActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }



}
