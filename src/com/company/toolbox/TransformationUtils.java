package com.company.toolbox;

import com.company.entities.Entity;
import com.company.terrains.Terrain;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by Saji on 11/22/2015.
 */
public class TransformationUtils {
    private TransformationUtils() {
    }

    public static Matrix4f createEntityTransformationMatrix(Entity entity) {
        return Maths.createTransformationMatrix(entity.getPosition(),
                entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
    }

    public static Matrix4f createEntityTransformationMatrix(Terrain terrain) {
        return Maths.createTransformationMatrix(new Vector3f(terrain.getX(), 0, terrain.getZ()),
                0, 0, 0, 1);
    }

}
