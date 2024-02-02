package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.MapGestureState;
import com.autonavi.gbl.map.model.MapGestureType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GestureInfo implements Serializable {
    public int deviceId;
    @MapGestureState.MapGestureState1
    public int gestureState;
    @MapGestureType.MapGestureType1
    public int gestureType;
    public int numberOfTouches;
    public float rotation;
    public float scale;
    public float velocity;
    public float velocityX;
    public float velocityY;
    public float x;
    public float y;

    public GestureInfo() {
        this.deviceId = 0;
        this.gestureType = 1;
        this.gestureState = 0;
        this.x = 0.0f;
        this.y = 0.0f;
        this.numberOfTouches = 0;
        this.scale = 0.0f;
        this.rotation = 0.0f;
        this.velocity = 0.0f;
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
    }

    public GestureInfo(int i, @MapGestureType.MapGestureType1 int i2, @MapGestureState.MapGestureState1 int i3, float f, float f2, int i4, float f3, float f4, float f5, float f6, float f7) {
        this.deviceId = i;
        this.gestureType = i2;
        this.gestureState = i3;
        this.x = f;
        this.y = f2;
        this.numberOfTouches = i4;
        this.scale = f3;
        this.rotation = f4;
        this.velocity = f5;
        this.velocityX = f6;
        this.velocityY = f7;
    }
}
