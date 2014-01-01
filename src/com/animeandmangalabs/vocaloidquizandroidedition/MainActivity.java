package com.animeandmangalabs.vocaloidquizandroidedition;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import com.animeandmangalabs.quiz_engine.*;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
public static Button btn_start;
private AlphaAnimation buttonClick = new AlphaAnimation(10F, 0.5F);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //onCreate init
        btn_start  = (Button) findViewById(R.id.main_start_button);
       //Btn listener
        btn_start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(buttonClick);
				Intent intent = new Intent(MainActivity.this, Quiz_Select.class);
				startActivity(intent);
				
				
			}
		});
	}
   
  
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
