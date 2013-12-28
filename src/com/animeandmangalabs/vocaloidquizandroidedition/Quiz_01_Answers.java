package com.animeandmangalabs.vocaloidquizandroidedition;

import android.widget.Button;

public class Quiz_01_Answers {
	
	public static void Question(Button btn_a,Button btn_b,int iQnum){
		if (iQnum == 0){
			Quiz_01.quiz_question_text.setText(R.string.q1_1);
			Quiz_01.quiz_img_view.setImageResource(R.drawable.miku_2);
			btn_a.setText("Hatsune Miku");
			btn_b.setText("Kagame Rin");
	}else if(iQnum == 1){
		Quiz_01.quiz_question_text.setText(R.string.q1_2);
		Quiz_01.quiz_img_view.setImageResource(R.drawable.kagames);
		btn_a.setText("Yagami");
		btn_b.setText("Kagame");
	}
	
}
	
	public static void Compare(Button btn_a,Button btn_b,int iQnum){
//-----------------------------QUESTION 1-------------------------------------------------		
		if (iQnum == 0){
			if(btn_a.isPressed()){
				Quiz_01.Correct();
			}else if (btn_b.isPressed()){
				Quiz_01.Incorrect();
			}
		
//-----------------------------QUESTION 2-------------------------------------------------	
		}else if(iQnum == 1){
				if(btn_a.isPressed()){
				Quiz_01.Incorrect();
			}else if(btn_b.isPressed()){
				Quiz_01.Correct();
			}
		}
		
	
	
	
	}
}
