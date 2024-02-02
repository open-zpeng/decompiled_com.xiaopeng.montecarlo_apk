package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.MapGestureState;
import com.autonavi.gbl.map.model.MapGestureType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GestureCallbackParam implements Serializable {
    @MapGestureState.MapGestureState1
    public int gestureState;
    @MapGestureType.MapGestureType1
    public int gestureType;
    public boolean hasInertia;

    public GestureCallbackParam() {
        this.gestureType = 1;
        this.gestureState = 0;
        this.hasInertia = false;
    }

    public GestureCallbackParam(@MapGestureType.MapGestureType1 int i, @MapGestureState.MapGestureState1 int i2, boolean z) {
        this.gestureType = i;
        this.gestureState = i2;
        this.hasInertia = z;
    }
}
