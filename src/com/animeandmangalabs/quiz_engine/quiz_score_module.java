package com.animeandmangalabs.quiz_engine;
import android.widget.TextView;
public class quiz_score_module
{

	public static void GetScoreStatus(boolean bCorrect,boolean bIncorrect,int iCorrect,int iIncorrect ,TextView t_correct,TextView t_incorrect){
		if(bCorrect = true){
			qCorrect(iCorrect,t_correct);
		}else if(bIncorrect = true){
			qIncorrect(iIncorrect,t_incorrect);
		}
	}
	public static void qCorrect(int iCorrect,TextView t_correct){
		iCorrect = iCorrect + 1;
		t_correct.setText("Correct: " + iCorrect);
	}
	public static void qIncorrect(int iIncorrect,TextView t_incorrect){
		iIncorrect = iIncorrect + 1;
		t_incorrect.setText("Incorrect: " + iIncorrect);
	}
	
}
