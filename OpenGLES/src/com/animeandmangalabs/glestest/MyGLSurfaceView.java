package com.animeandmangalabs.glestest;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by jeroenmathon on 1/2/14.
 */
public class MyGLSurfaceView extends GLSurfaceView {
    public MyGLSurfaceView(Context context) {
        super(context);

        setRenderer(new testRenderer());
        setEGLContextClientVersion(2);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

    }
}
