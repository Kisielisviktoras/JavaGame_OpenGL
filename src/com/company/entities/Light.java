package com.company.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by Saji on 11/22/2015.
 */
public class Light {

    private Vector3f position;
    private Vector3f colour;


    public Light(Vector3f position, Vector3f colour) {
        this.position = position;
        this.colour = colour;
    }

    public void moveLight() {
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            position.z-=0.08f;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            position.z+=0.08f;
        }
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getColour() {
        return colour;
    }

    public void setColour(Vector3f colour) {
        this.colour = colour;
    }
}
