package com.example.rishika.project2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Question>quesList;
    int score = 0;
    int qid =0;
    Question currentQ;
    TextView question;
    Button answer1, answer2, answer3, answer4;
    Button Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database db = new Database(this);
        quesList= db.getALLQUESTIONS();
        currentQ=quesList.get(qid);
        question=(TextView)findViewById(R.id.question);
        answer1= (Button)(findViewById(R.id.answer1));
        answer2= (Button)(findViewById(R.id.answer2));
        answer3= (Button)(findViewById(R.id.answer3));
        answer4= (Button)(findViewById(R.id.answer4));
        Next=(Button)(findViewById(R.id.button));
        setQuestionView();
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button answer= (Button)findViewById(R.id.button);
                Log.d("YOURANS", currentQ.getANSWER()+" "+answer.getText());
                if (currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    TextView score = (TextView) findViewById(R.id.score);
                    score.setText(String.valueOf(MainActivity.this.score));
                    Log.d("Score","Your Score"+score);
                }

                if (qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else {
                    Intent intent = new Intent(MainActivity.this, Result.class);
                    Bundle b = new Bundle();
                    b.putInt("Score", score);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();

                }

            }
        });
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("YOURANS", currentQ.getANSWER() + " " + answer1.getText());
                if (currentQ.getANSWER().equals(answer1.getText())) {
                    score++;
                    TextView score = (TextView) findViewById(R.id.score);
                    score.setText(String.valueOf(MainActivity.this.score));
                    Log.d("Score", "Your Score" + score);
                }

            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("YOURANS", currentQ.getANSWER() + " " + answer2.getText());
                if (currentQ.getANSWER().equals(answer2.getText())) {
                    score++;
                    TextView score = (TextView) findViewById(R.id.score);
                    score.setText(String.valueOf(MainActivity.this.score));
                    Log.d("Score", "Your Score" + score);
                }

            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("YOURANS", currentQ.getANSWER() + " " + answer3.getText());
                if (currentQ.getANSWER().equals(answer3.getText())) {
                    score++;
                    TextView score = (TextView) findViewById(R.id.score);
                    score.setText(String.valueOf(MainActivity.this.score));
                    Log.d("Score", "Your Score" + score);
                }

            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("YOURANS", currentQ.getANSWER() + " " + answer4.getText());
                if (currentQ.getANSWER().equals(answer4.getText())) {
                    score++;
                    TextView score = (TextView) findViewById(R.id.score);
                    score.setText(String.valueOf(MainActivity.this.score));
                    Log.d("Score", "Your Score" + score);
                }

            }
        });
        new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {

                TextView time = (TextView) findViewById(R.id.time);
                time.setText(String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(MainActivity.this, Result.class);
                Bundle b = new Bundle();
                b.putInt("Score", score);
                intent.putExtras(b);
                startActivity(intent);
                MainActivity.this.finish();

            }
        }.start();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private  void setQuestionView(){
        question.setText(currentQ.getQUESTION());
        answer1.setText(currentQ.getANSWER1());
        answer2.setText(currentQ.getANSWER2());
        answer3.setText(currentQ.getANSWER3());
        answer4.setText(currentQ.getANSWER4());
        qid++;
    }
}
