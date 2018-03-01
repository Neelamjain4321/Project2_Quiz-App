package com.example.rishika.project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.example.rishika.project2.Quizcontract.QuizEntry.KEY_ANSWER;
import static com.example.rishika.project2.Quizcontract.QuizEntry.KEY_ANSWER1;
import static com.example.rishika.project2.Quizcontract.QuizEntry.KEY_ANSWER2;
import static com.example.rishika.project2.Quizcontract.QuizEntry.KEY_ANSWER3;
import static com.example.rishika.project2.Quizcontract.QuizEntry.KEY_ANSWER4;
import static com.example.rishika.project2.Quizcontract.QuizEntry.KEY_ID;
import static com.example.rishika.project2.Quizcontract.QuizEntry.KEY_QUES;
import static com.example.rishika.project2.Quizcontract.QuizEntry.TABLE_QUEST;

/**
 * Created by RISHIKA on 26-02-2018.
 */

 public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Quizapp";

    private SQLiteDatabase dbase;
    public Database(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = " CREATE TABLE IF NOT EXISTS  " + TABLE_QUEST + "(" +  KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_QUES + " TEXT," + KEY_ANSWER + " TEXT, " + KEY_ANSWER1 + "  TEXT, " + KEY_ANSWER2 + " TEXT, " + KEY_ANSWER3
                + " TEXT, " + KEY_ANSWER4 + " TEXT) ";
        db.execSQL(sql);
        addQuestions();
    }
    private void addQuestions(){

        Question q1 = new Question("3+5","8","3","4","8","7");
        this.addQuestion(q1);
        Question q2 = new Question("National Animal","Tiger","Tiger","Lion","Elephant","Bear");
        this.addQuestion(q2);
        Question q3 = new Question("9-7+2","4","5","3","4","8");
        this.addQuestion(q3);
        Question q4= new Question("42-5","37","41","36","37","35");
        this.addQuestion(q4);
        Question q5 = new Question("National Bird","Peacock","Sparrow","Peacock","Nightangle","Parrot");
        this.addQuestion(q5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {



        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);

    }

    public  void addQuestion(Question quest){
        Log.d("answer ",quest.getANSWER());
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_ANSWER1, quest.getANSWER1());
        values.put(KEY_ANSWER2, quest.getANSWER2());
        values.put(KEY_ANSWER3, quest.getANSWER3());
        values.put(KEY_ANSWER4, quest.getANSWER4());

        dbase.insert(TABLE_QUEST,null,values);
    }

    public List<Question> getALLQUESTIONS(){
        List<Question> quesList = new ArrayList<>();
        String selectQuerry = " SELECT * FROM " + TABLE_QUEST;
        dbase= this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuerry, null);

        if (cursor.moveToFirst()){
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setANSWER1(cursor.getString(3));
                quest.setANSWER2(cursor.getString(4));
                quest.setANSWER3(cursor.getString(5));
                quest.setANSWER4(cursor.getString(6));
                quesList.add(quest);


            }while (cursor.moveToNext());
        }
        return quesList;

    }

    public int rowcount(){
        int row = 0;
        String selectQurrey = " SELECT * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQurrey, null);
        row = cursor.getCount();
        return row;

    }


}
