package com.company;


import com.company.entities.Camera;
import com.company.entities.Entity;
import com.company.entities.Light;
import com.company.models.RawModel;
import com.company.models.TexturedModel;
import com.company.render.MasterRenderer;
import com.company.shaders.StaticShader;
import com.company.terrains.Terrain;
import com.company.textures.ModelTexture;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        StaticShader shader = new StaticShader();

        RawModel model = OBJLoader.loadObjModel("bear", loader);
        ModelTexture texture = new ModelTexture(loader.loadTexture("mashup"));
        texture.setShineDamper(10);
        texture.setReflectivity(1);

        TexturedModel texturedModel = new TexturedModel(model, texture);

        Entity entity = new Entity(texturedModel, new Vector3f(0, 0, -25), 0, 0, 0, 1);
        Light light = new Light(new Vector3f(3000, 2000, 2000), new Vector3f(1, 1, 1));

        Terrain terrain = new Terrain(0,0, loader, new ModelTexture(loader.loadTexture("bush")));
        Terrain terrain2 = new Terrain(1,0, loader, new ModelTexture(loader.loadTexture("red")));
        Terrain terrain3 = new Terrain(0,1, loader, new ModelTexture(loader.loadTexture("bush")));
        Terrain terrain4 = new Terrain(1,1, loader, new ModelTexture(loader.loadTexture("red")));

        Camera camera = new Camera();
        List<Entity> allCubes = new ArrayList<>();

        MasterRenderer renderer = new MasterRenderer();

        while (!Display.isCloseRequested()) {
            camera.move();
            renderer.processTerrain(terrain);
            renderer.processTerrain(terrain2);
            renderer.processTerrain(terrain3);
            renderer.processTerrain(terrain4);
            renderer.processEntity(entity);
            renderer.render(light, camera);
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();

    }
}
