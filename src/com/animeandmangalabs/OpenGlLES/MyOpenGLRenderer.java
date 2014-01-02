package com.animeandmangalabs.OpenGlLES;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by jeroenmathon on 1/2/14.
 */


public class MyOpenGLRenderer implements GLSurfaceView.Renderer {

    private float[] mViewMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

        //Set the background color to gray
        GLES20.glClearColor(0.5f,0.5f,0.5f,0.5f);

        //Position the eye behind the origin
        final float eyeX = 0.0f;
        final float eyeY = 0.0f;
        final float eyeZ = 1.5f;

        //We are looking toward the distance
        final float lookX = 0.0f;
        final float lookY = 0.0f;
        final float lookZ = -5.0f;

        //Set out up vector. this is where our head would be pointing were we holding the camera
        final float upX = 0.0f;
        final float upY = 1.0f;
        final float upZ = 0.0f;

        //Set the view matrix
        Matrix.setLookAtM(mViewMatrix, 0, eyeX, eyeY, eyeZ, lookX, lookY, lookZ, upX, upY, upZ);

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {

    }

    @Override
    public void onDrawFrame(GL10 gl10) {

    }
}
