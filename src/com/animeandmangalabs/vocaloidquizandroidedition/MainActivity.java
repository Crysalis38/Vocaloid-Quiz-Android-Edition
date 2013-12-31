package com.animeandmangalabs.vocaloidquizandroidedition;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.animeandmangalabs.quiz_engine.*;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.samples.plus.R;
public class MainActivity extends Activity implements
ConnectionCallbacks, OnConnectionFailedListener, OnClickListener {
	
	 //GPLUS
	private static final int REQUEST_CODE_RESOLVE_ERR = 9000;

	    private ProgressDialog mConnectionProgressDialog;
	    private PlusClient mPlusClient;
	    private ConnectionResult mConnectionResult;
	    private static final int DIALOG_GET_GOOGLE_PLAY_SERVICES = 1;

	    private static final int REQUEST_CODE_SIGN_IN = 1;
	    private static final int REQUEST_CODE_GET_GOOGLE_PLAY_SERVICES = 2;

	    private TextView mSignInStatus;

	    private SignInButton mSignInButton;
	    private View mSignOutButton;
	    private View mRevokeAccessButton;
	//GPLUS

public static Button btn_start,btn_sign_in;
private AlphaAnimation buttonClick = new AlphaAnimation(10F, 0.5F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //onCreate init
        btn_start  = (Button) findViewById(R.id.main_start_button);
        btn_sign_in = (Button) findViewById(R.id.sign_in_button);
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

  
    public void firstRunCheck(){
    	boolean firstRun = quiz_data_manager.getBoolean(this, "FIRST_RUN", false); 
    	if(firstRun == false){
    		//OPEN DIALOG
    		
    		//OPEN DIALOG
    		
    	}else{
    	System.out.println("USER IS REGISTERED");
    	}
    }
  
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //GPLUS
        mPlusClient = new PlusClient.Builder(this, this, this)
        .setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity")
        .build();
        //GPLUS
        return true;
    }

//GPLUS
	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		 if (mConnectionProgressDialog.isShowing()) {
             // The user clicked the sign-in button already. Start to resolve
             // connection errors. Wait until onConnected() to dismiss the
             // connection dialog.
             if (result.hasResolution()) {
                     try {
                             result.startResolutionForResult(this, REQUEST_CODE_RESOLVE_ERR);
                     } catch (SendIntentException e) {
                             mPlusClient.connect();
                     }
             
             }
             // Save the intent so that we can start an activity when the user clicks
             // the sign-in button.
             mConnectionResult = result;
      }


		 
		 }
	

	
	

	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		// We've resolved any connection errors.
		  mConnectionProgressDialog.dismiss();
	}


	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
	    if (requestCode == REQUEST_CODE_RESOLVE_ERR && responseCode == RESULT_OK) {
	        mConnectionResult = null;
	        mPlusClient.connect();
	    }
	}


	 @Override
	    public void onClick(View view) {
	        switch(view.getId()) {
	            case R.id.sign_in_button:
	                int available = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	                if (available != ConnectionResult.SUCCESS) {
	                    showDialog(DIALOG_GET_GOOGLE_PLAY_SERVICES);
	                    return;
	                }

	                try {
	                    mSignInStatus.setText(getString(R.string.signing_in_status));
	                    mConnectionResult.startResolutionForResult(this, REQUEST_CODE_SIGN_IN);
	                } catch (IntentSender.SendIntentException e) {
	                    // Fetch a new result to start.
	                    mPlusClient.connect();
	                }
	                break;
	            
	    }
	 @Override
	    protected Dialog onCreateDialog(int id) {
	        if (id != DIALOG_GET_GOOGLE_PLAY_SERVICES) {
	            return super.onCreateDialog(id);
	        }

	        int available = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	        if (available == ConnectionResult.SUCCESS) {
	            return null;
	        }
	        if (GooglePlayServicesUtil.isUserRecoverableError(available)) {
	            return GooglePlayServicesUtil.getErrorDialog(
	                    available, this, REQUEST_CODE_GET_GOOGLE_PLAY_SERVICES);
	        }
	        return new AlertDialog.Builder(this)
	                .setMessage(R.string.plus_generic_error)
	                .setCancelable(true)
	                .create();
	    }

//GPLUS
}
