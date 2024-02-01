package com.xiaopeng.montecarlo.views.mapmode;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class Simple3DModel {
    private float mRotateX;
    private float mRotateY;
    private float mRotateZ;
    private ArrayList<Triangle> mTriangles = new ArrayList<>();
    private float[] mRX = new float[9];

    public Simple3DModel() {
        float[] fArr = this.mRX;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    public void add(Triangle triangle) {
        this.mTriangles.add(triangle);
    }

    public void clear() {
        this.mTriangles.clear();
    }

    public void draw(Canvas canvas, Paint paint) {
        int size = this.mTriangles.size();
        for (int i = 0; i < size; i++) {
            this.mTriangles.get(i).draw(canvas, paint, this.mRX);
        }
    }

    public float getRotateX() {
        return this.mRotateX;
    }

    public void setRotateX(float f) {
        if (f != this.mRotateX) {
            double d = (f * 3.141592653589793d) / 180.0d;
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            float[] fArr = this.mRX;
            fArr[0] = 1.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = cos;
            fArr[5] = sin;
            fArr[6] = 0.0f;
            fArr[7] = -sin;
            fArr[8] = cos;
            this.mRotateX = f;
        }
    }

    public float getRotateY() {
        return this.mRotateY;
    }

    public void setRotateY(float f) {
        this.mRotateY = f;
    }

    public float getRotateZ() {
        return this.mRotateZ;
    }

    public void setRotateZ(float f) {
        this.mRotateZ = f;
    }
}
