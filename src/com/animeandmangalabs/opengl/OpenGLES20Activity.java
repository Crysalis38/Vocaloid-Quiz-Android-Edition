package com.animeandmangalabs.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 * Created by jeroenmathon on 1/1/14.
 */
public class OpenGLES20Activity extends Activity {

    private GLSurfaceView mGLView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLView = new MyGLSurfaceView(this);
        setContentView(mGLView);
    }
}