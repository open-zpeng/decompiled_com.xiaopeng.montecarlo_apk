package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.GestureAction;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class TouchEvent implements Serializable {
    @GestureAction.GestureAction1
    public int action;
    public int actionIndex;
    public long eventTime;
    public int pointCount;
    public int[] pointId;
    public float[] pointPressure;
    public float[] pointerCoordinate;
    public int x;
    public int y;

    public TouchEvent() {
        this.action = 4;
        this.x = 0;
        this.y = 0;
        this.pointCount = 0;
        this.eventTime = 0L;
        this.actionIndex = 0;
        this.pointerCoordinate = new float[20];
        this.pointPressure = new float[10];
        this.pointId = new int[10];
    }

    public TouchEvent(@GestureAction.GestureAction1 int i, int i2, int i3, int i4, long j, int i5, float[] fArr, float[] fArr2, int[] iArr) {
        this.action = i;
        this.x = i2;
        this.y = i3;
        this.pointCount = i4;
        this.eventTime = j;
        this.actionIndex = i5;
        this.pointerCoordinate = fArr;
        this.pointPressure = fArr2;
        this.pointId = iArr;
    }
}
