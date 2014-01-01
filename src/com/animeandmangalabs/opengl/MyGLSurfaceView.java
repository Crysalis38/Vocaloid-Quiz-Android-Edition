package com.animeandmangalabs.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by jeroenmathon on 1/1/14.
 */
public class MyGLSurfaceView extends GLSurfaceView {


    public MyGLSurfaceView(Context context) {
        super(context);

        setRenderer(new MyRenderer());

        setEGLContextClientVersion(2);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }




}
