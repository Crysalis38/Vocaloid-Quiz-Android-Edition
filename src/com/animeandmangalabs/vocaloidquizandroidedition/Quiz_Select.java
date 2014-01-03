package com.animeandmangalabs.vocaloidquizandroidedition;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class Quiz_Select extends Activity {
	ImageButton btn_q1,btn_q2,btn_q3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__select);
        btn_q1 = (ImageButton)findViewById(R.id.quiz_select_q1);
        btn_q2 = (ImageButton)findViewById(R.id.quiz_select_q2);
        main();
      
    }
   
    //Main Method
    public void main(){
    	
    	btn_q1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {//Start Quiz 01
				// TODO Auto-generated method stub
		
				Intent intent = new Intent(Quiz_Select.this, Quiz_01.class);
			startActivity(intent);
			}
		});
    	
    	btn_q2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


			}
		});
    }

   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz__select, menu);
        return true;
    }
    
}
