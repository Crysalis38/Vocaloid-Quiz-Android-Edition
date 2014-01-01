package com.animeandmangalabs.quiz_engine;
import android.widget.TextView;
import android.content.Context;
public class quiz_question_engine
{

	public static void getQuizQuestion(int QNum,int QPack,TextView QText,Context contxt){
	String QnumPREF = "QKEY" + QPack + QNum; //sets Pref Key
	quiz_engine.q_data.getString(contxt,QnumPREF,"0");
	}
	
}
