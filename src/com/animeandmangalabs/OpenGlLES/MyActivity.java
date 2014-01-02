package com.animeandmangalabs.OpenGlLES;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    //initialize GLSurfaceView
    private GLSurfaceView mGLSurfaceView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Check for verison support GLES
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if (supportsEs2)
        {
            //Request OpenGL compat Context
            mGLSurfaceView.setEGLContextClientVersion(2);

            //setRenderer to my renderer
            mGLSurfaceView.setRenderer(new MyOpenGLRenderer());

        }
        else
        {
            //Add ES1 if possible
            return;
        }
        setContentView(mGLSurfaceView);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mGLSurfaceView.onPause();
    }
}
