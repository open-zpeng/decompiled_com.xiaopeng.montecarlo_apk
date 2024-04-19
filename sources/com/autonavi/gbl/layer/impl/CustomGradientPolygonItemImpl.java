package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.observer.ICustomGradientPolygonItem;
import com.autonavi.gbl.map.impl.MapViewImpl;
@IntfAuto(target = ICustomGradientPolygonItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class CustomGradientPolygonItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomGradientPolygonItemImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void CustomGradientPolygonItemImpl_change_ownership(CustomGradientPolygonItemImpl customGradientPolygonItemImpl, long j, boolean z);

    private static native void CustomGradientPolygonItemImpl_director_connect(CustomGradientPolygonItemImpl customGradientPolygonItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, MapViewImpl mapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mTypeGetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl);

    private static native void mTypeSetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl, int i);

    private static native String mValueGetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl);

    private static native void mValueSetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl, String str);

    public CustomGradientPolygonItemImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof CustomGradientPolygonItemImpl) && getUID(this) == getUID((CustomGradientPolygonItemImpl) obj);
    }

    private static long getUID(CustomGradientPolygonItemImpl customGradientPolygonItemImpl) {
        long cPtr = getCPtr(customGradientPolygonItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CustomGradientPolygonItemImpl customGradientPolygonItemImpl) {
        if (customGradientPolygonItemImpl == null) {
            return 0L;
        }
        return customGradientPolygonItemImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CustomGradientPolygonItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CustomGradientPolygonItemImpl_change_ownership(this, this.swigCPtr, true);
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

    public CustomGradientPolygonItemImpl(MapViewImpl mapViewImpl) {
        this(createNativeObj(MapViewImpl.getCPtr(mapViewImpl), mapViewImpl), true);
        LayerSvrJNI.swig_jni_init();
        CustomGradientPolygonItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }
}
