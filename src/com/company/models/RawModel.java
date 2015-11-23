package com.company.models;

/**
 * Created by Saji on 11/21/2015.
 */
public class RawModel {

    private int vaoID;
    private int vertexCount;

    public RawModel(int vaoID, int vertextCount) {
        this.vaoID = vaoID;
        this.vertexCount = vertextCount;
    }

    public int getVaoID() {
        return vaoID;
    }

    public void setVaoID(int vaoID) {
        this.vaoID = vaoID;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }
}
