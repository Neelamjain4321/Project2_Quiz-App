package com.example.rishika.project2;

/**
 * Created by RISHIKA on 26-02-2018.
 */

public class Question {

    private int ID;
    private String QUESTION;
    private String ANSWER;
    private String ANSWER1;
    private String ANSWER2;
    private String ANSWER3;
    private String ANSWER4;
    public Question()
    {
        ID = 0;
        QUESTION = "";
        ANSWER = "";
        ANSWER1 = "";
        ANSWER2 = "";
        ANSWER3 = "";
        ANSWER4 = "";
    }

    public  Question(String qUESTION, String aNSWER, String aNSWER1, String aNSWER2, String aNSWER3,
    String aNSWER4){

            QUESTION = qUESTION;
            ANSWER = aNSWER;
            ANSWER1= aNSWER1;
            ANSWER2 = aNSWER2;
            ANSWER3 =aNSWER3;
            ANSWER4 =aNSWER4;
    }

    public int getID(){return ID;}
    public String getQUESTION(){return QUESTION;}
    public  String getANSWER(){return ANSWER;}
    public  String getANSWER1(){return ANSWER1;}
    public  String getANSWER2(){return ANSWER2;}
    public  String getANSWER3(){return ANSWER3;}
    public  String getANSWER4(){return ANSWER4;}
    public void setID(int id){ID = id;}
    public void setQUESTION(String qUESTION){QUESTION = qUESTION;}
    public void setANSWER(String aNSWER){ANSWER = aNSWER;}
    public void setANSWER1(String aNSWER1){ANSWER1 = aNSWER1;}
    public void setANSWER2(String aNSWER2){ANSWER2 = aNSWER2;}
    public void setANSWER3(String aNSWER3){ANSWER3 = aNSWER3;}
    public void setANSWER4(String aNSWER4){ANSWER4 = aNSWER4;}




}
