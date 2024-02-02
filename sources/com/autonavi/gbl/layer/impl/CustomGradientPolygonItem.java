package com.autonavi.gbl.layer.impl;

import com.autonavi.gbl.map.impl.MapViewImpl;
/* loaded from: classes.dex */
public class CustomGradientPolygonItem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj(long j, MapViewImpl mapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mTypeGetNative(long j, CustomGradientPolygonItem customGradientPolygonItem);

    private static native void mTypeSetNative(long j, CustomGradientPolygonItem customGradientPolygonItem, int i);

    private static native String mValueGetNative(long j, CustomGradientPolygonItem customGradientPolygonItem);

    private static native void mValueSetNative(long j, CustomGradientPolygonItem customGradientPolygonItem, String str);

    public CustomGradientPolygonItem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CustomGradientPolygonItem customGradientPolygonItem) {
        if (customGradientPolygonItem == null) {
            return 0L;
        }
        return customGradientPolygonItem.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setMType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    public int getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }

    public void setMValue(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mValueSetNative(j, this, str);
    }

    public String getMValue() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mValueGetNative(j, this);
    }

    public CustomGradientPolygonItem(MapViewImpl mapViewImpl) {
        this(createNativeObj(MapViewImpl.getCPtr(mapViewImpl), mapViewImpl), true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }
}
