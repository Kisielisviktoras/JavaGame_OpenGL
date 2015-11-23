package com.company;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Created by Saji on 11/21/2015.
 */
public class DisplayManager {

    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    public static final int FPS_CAP = 1203;

    public static void createDisplay() {

        ContextAttribs attribs = new ContextAttribs(3,2)
        .withForwardCompatible(true).withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0,0,WIDTH, HEIGHT);

    }

    public static void closeDisplay() {
        Display.destroy();
    }

    public static void updateDisplay() {
        Display.sync(FPS_CAP);
        Display.update();
    }
}
