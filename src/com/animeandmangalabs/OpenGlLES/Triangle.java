package com.animeandmangalabs.OpenGlLES;

import android.opengl.GLES20;

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

    final String fragmentShader =
            "precision mediump float;   \n"     //Set the default precision to medium. We don't need as high of a
                                                //precision in the fragment shader.
    +       "varying vec4 V-Color;      \n"     //This is the color from the vertex shader interpolated across the
                                                //triangle per fragment.
    +       "void main()                \n"     //The entry point for out fragment shader.
    +       "{                          \n"
    +       "   gl_FragColor = v_Color; \n"     //Pass the color directly trough the pipeline.
    +       "}                          \n";

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

        //Load in the vertex shader.
        int vertexShaderHandle = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER);

        if(vertexShaderHandle != 0)
        {
            //Pass in the shader source.
            GLES20.glShaderSource(vertexShaderHandle, vertexShader);

            //Compile the shader.
            GLES20.glCompileShader(vertexShaderHandle);

            //Get the compilation status.
            final int[] compileStatus = new int[1];
            GLES20.glGetShaderiv(vertexShaderHandle, GLES20.GL_COMPILE_STATUS, compileStatus, 0);

            //If the compilation failed delete the shader.
            if (compileStatus[0] == 0)
            {
                GLES20.glDeleteShader(vertexShaderHandle);
                vertexShaderHandle = 0;
            }
        }

        if(vertexShaderHandle == 0)
        {
            throw new RuntimeException("Error creating vertex shader.");
        }

        //Create a program object and store the handle to it.
        int programHandle = GLES20.glCreateProgram();

        if(programHandle != 0)
        {
            //Bind the vertex shader to the program.
            GLES20.glAttachShader(programHandle, vertexShaderHandle);

            //Bind the fragment shader to the program.
            GLES20.glAttachShader(programHandle, fragmentShaderHandle);

            //Bind attributes.
            GLES20.glBindAttribLocation(programHandle, 0, "a_Position");
            GLES20.glBindAttribLocation(programHandle, 1, "a_Color");

            //Link the two shaders together into a program.
            GLES20.glLinkProgram(programHandle);

            //Get link status.
            final int[] linkStatus = new int[1];
            GLES20.glGetProgramiv(programHandle, GLES20.GL_LINK_STATUS, linkStatus, 0);

            //If the link failed, delete the program.
            if (linkStatus[0] == 0)
            {
                GLES20.glDeleteProgram(programHandle);
                programHandle = 0;
            }
        }
        if (programHandle == 0)
        {
            throw new RuntimeException("Error creating program.");
        }
    }
}
