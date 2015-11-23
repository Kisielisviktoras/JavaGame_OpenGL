package com.company.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by Saji on 11/22/2015.
 */
public class Camera {

    private Vector3f position = new Vector3f(0,0,0);
    //camera rotation around x,y,z
    private float pitch;
    //camera left or right
    private float yaw;
    //camera how much tilted
    private float roll;

    public void move() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            position.z-=0.1f;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            position.x+=0.1f;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            position.x-=0.1f;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            position.z+=0.1f;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            position.y+=0.1f;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
            position.y-=0.1f;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
            pitch+=0.1f;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
            pitch-=0.1f;
        }

    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
}
