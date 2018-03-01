package com.example.rishika.project2;

import android.provider.BaseColumns;

/**
 * Created by RISHIKA on 26-02-2018.
 */

public class Quizcontract {

    public static class QuizEntry implements BaseColumns{
        public static final String TABLE_QUEST ="quest";

        public static final String KEY_ID="id";
        public static final String KEY_QUES="question";
        public static final String KEY_ANSWER="answer";
        public static final String KEY_ANSWER1="answer1";
        public static final String KEY_ANSWER2="answer2";
        public static final String KEY_ANSWER3="answer3";
        public static final String KEY_ANSWER4="answer4";

    }
}
