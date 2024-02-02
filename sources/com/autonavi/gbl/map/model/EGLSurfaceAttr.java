package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.EGLDeviceID;
import java.io.Serializable;
/* loaded from: classes.dex */
public class EGLSurfaceAttr implements Serializable {
    public long display;
    public int height;
    public int initColor;
    public boolean isBackSurface;
    public boolean isNativeWindowFromSurface;
    public boolean isNeedInitDraw;
    public boolean isOnlyCreatePBSurface;
    public long nativeWindow;
    @EGLDeviceID.EGLDeviceID1
    public int shareDeviceID;
    public int width;

    public EGLSurfaceAttr() {
        this.display = -1L;
        this.nativeWindow = -1L;
        this.width = 0;
        this.height = 0;
        this.shareDeviceID = -1;
        this.isBackSurface = false;
        this.isNeedInitDraw = true;
        this.isOnlyCreatePBSurface = false;
        this.initColor = -1;
        this.isNativeWindowFromSurface = false;
    }

    public EGLSurfaceAttr(long j, long j2, int i, int i2, @EGLDeviceID.EGLDeviceID1 int i3, boolean z, boolean z2, boolean z3, int i4, boolean z4) {
        this.display = j;
        this.nativeWindow = j2;
        this.width = i;
        this.height = i2;
        this.shareDeviceID = i3;
        this.isBackSurface = z;
        this.isNeedInitDraw = z2;
        this.isOnlyCreatePBSurface = z3;
        this.initColor = i4;
        this.isNativeWindowFromSurface = z4;
    }
}
