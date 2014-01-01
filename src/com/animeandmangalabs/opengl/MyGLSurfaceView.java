package com.animeandmangalabs.opengl;

import android.opengl.GLSurfaceView;

/**
 * Created by jeroenmathon on 1/1/14.
 */
public class MyGLSurfaceView extends GLSurfaceView {
    public MyGLSurfaceView(OpenGLES20Activity openGLES20Activity) {
        super(context);

        setRenderer(new MyRenderer());
    }
}
