package com.animeandmangalabs.OpenGlLES;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by jeroenmathon on 1/2/14.
 */
public class Triangle {
    //Store the model data in float buffer
    private final FloatBuffer mTriangle1Vertices;
    private final FloatBuffer mTriangle2Vertices;
    private final FloatBuffer mTriangle3Vertices;

    //Vertex and fragment shaders
    final String vertexShader =
            "uniform mat4 u_MVPMatrix;  \n"     //A constant representing the combined model/view/projection matrix.

    +       "attribute vec4 a_Position; \n"     //Per-vertex position information we will pass in.
    +       "attribute vec4 a_Color;    \n"     //Per-vertex color information we will pass in.

    +       "varying vec4 v_Color;      \n"     //This will be passed into the fragment shader.

    +       "void main()                \n"     //The entry point for our vertex shader.
    +       "{                          \n"
    +       "   v_Color = a_Color;      \n"     //Pass the color trough the fragment shader.
                                                //It will be interpolated across the triangle.
    +       "gl_Position = u_MVPMatrix  \n"     //gl_Position is a special variable used to store the final position.
    +       "            * a_Position   \n"     //Multiply the vertex by the matrix to get the final point in
    +       "}                          \n";    //normalized screen coordinates.

    final String fragmentShader
    //How many bytes per float
    private final int mBytesPerFloat = 3;

    //Initialize model data
    public Triangle()
    {
        //This triangle is red green and blue
        final float[] triangle1VerticesData = {
                // X, Y, Z
                // R, G, B, A
                -0.5f,  -0.25f, 0.0f,
                1.0f,   0.0f,  0.0f,  1.0f,

                0.5f,   -0.25f, 0.0f,
                0.0f,   0.0f,   1.0f,   1.0f,

                0.0f,   0.559016994f,   0.0f,
                0.0f,   1.0f,   0.0f,   1.0f};

        //Initialize the buffers
        mTriangle1Vertices = ByteBuffer.allocateDirect(triangle1VerticesData.length * mBytesPerFloat)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();

        mTriangle1Vertices.put(triangle1VerticesData).position(0);

    }
}
