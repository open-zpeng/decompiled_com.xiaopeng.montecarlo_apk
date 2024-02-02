package com.xiaopeng.montecarlo.views.mapmode;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
/* loaded from: classes3.dex */
public class Triangle {
    private int mColor;
    private Path mPath = new Path();
    private XYZPoint mPont1;
    private XYZPoint mPont2;
    private XYZPoint mPont3;

    public Triangle(XYZPoint xYZPoint, XYZPoint xYZPoint2, XYZPoint xYZPoint3, int i) {
        this.mPont1 = xYZPoint;
        this.mPont2 = xYZPoint2;
        this.mPont3 = xYZPoint3;
        this.mColor = i;
    }

    public XYZPoint getPont1() {
        return this.mPont1;
    }

    public void setPont1(XYZPoint xYZPoint) {
        this.mPont1 = xYZPoint;
    }

    public XYZPoint getPont2() {
        return this.mPont2;
    }

    public void setPont2(XYZPoint xYZPoint) {
        this.mPont2 = xYZPoint;
    }

    public XYZPoint getPont3() {
        return this.mPont3;
    }

    public void setPont3(XYZPoint xYZPoint) {
        this.mPont3 = xYZPoint;
    }

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void draw(Canvas canvas, Paint paint, float[] fArr) {
        canvas.save();
        this.mPath.reset();
        float x = this.mPont1.getX() - 45;
        float y = this.mPont1.getY() - 45;
        float z = this.mPont1.getZ();
        this.mPath.moveTo((fArr[0] * x) + (fArr[1] * y) + (fArr[2] * z) + 45.0f, (x * fArr[3]) + (y * fArr[4]) + (z * fArr[5]) + 45.0f);
        float x2 = this.mPont2.getX() - 45;
        float y2 = this.mPont2.getY() - 45;
        float z2 = this.mPont2.getZ();
        this.mPath.lineTo((fArr[0] * x2) + (fArr[1] * y2) + (fArr[2] * z2) + 45.0f, (x2 * fArr[3]) + (y2 * fArr[4]) + (z2 * fArr[5]) + 45.0f);
        float x3 = this.mPont3.getX() - 45;
        float y3 = this.mPont3.getY() - 45;
        float z3 = this.mPont3.getZ();
        this.mPath.lineTo((fArr[0] * x3) + (fArr[1] * y3) + (fArr[2] * z3) + 45.0f, (x3 * fArr[3]) + (y3 * fArr[4]) + (z3 * fArr[5]) + 45.0f);
        this.mPath.close();
        paint.setColor(this.mColor);
        canvas.drawPath(this.mPath, paint);
        canvas.restore();
    }

    public String toString() {
        return "Triangle{mPont1=" + this.mPont1 + ", mPont2=" + this.mPont2 + ", mPont3=" + this.mPont3 + ", mColor=" + this.mColor + '}';
    }
}
