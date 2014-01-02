package com.animeandmangalabs.OpenGlLES;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by jeroenmathon on 1/2/14.
 */


public class MyOpenGLRenderer implements GLSurfaceView.Renderer {

    private float[] mViewMatrix = new float[16];
    //New class members

    //This will be used to pass in the transformation matrix.
    private int mMVPMatrixHandle;

    //This will be used to pass in model position information.
    private int mPositionHandle;

    //This will be used to pass in model color information.
    private int mColorHandle;

    //Store the projection matrix. This is used to project the scene onto a 2D viewport.
    private float[] mProjectionMatrix = new float[16];

    //Store the model matrix. This matrix is used to move models from object space (where each model can be tought
    //of being located at the center of the universe) to world space.
    private final[] mModelMatrix = new float[16];



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

        //Set program handles. These will later be used to pass in values to the program.
        mMVPMatrixHandle = GLES20.glGetUniformLocation(programHandle, "u_MVPMatrix");
        mPositionHandle = GLES20.glGetAttribLocation(programHandle, "a_Position");
        mColorHandle =GLES20.glGetAttribLocation(programHandle, "a_Color");

        //Tell OpenGL to use this program when rendering.
        GLES20.glUseProgram(programHandle);

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {

        //Set the OpenGL viewport to the same size as the surface.
        GLES20.glViewport(0, 0, width, height);

        //Create a new perspective projection matrix. The height will stay the same
        //while the width will vary as per aspect ratio.
        final float ratio = (float) width / height;
        final float left = -ratio;
        final float right = ratio;
        final float bottom = -1.0f;
        final float top = 1.0f;
        final float near = 1.0f;
        final float far = 10.0f;

        Matrix.frustumM(mProjectionMatrix, 0, left, right, bottom, top, near, far);

    }

    @Override
    public void onDrawFrame(GL10 gl10) {

        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);

        //Do a complete rotation every 10 seconds.
        long time = SystemClock.uptimeMillis() % 10000L;
        float angleInDecrees = (360.0f / 10000.0f) * ((int) time);

        //Draw the triangle facing straight on.
        Matrix.setIdentityM(mModelMatrix, 0);

    }
}
