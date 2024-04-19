package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.util.ArrayList;
@IntfAuto(target = ICollisionItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ICollisionItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ICollisionItemImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICollisionItemImpl_change_ownership(ICollisionItemImpl iCollisionItemImpl, long j, boolean z);

    private static native void ICollisionItemImpl_director_connect(ICollisionItemImpl iCollisionItemImpl, long j, boolean z, boolean z2);

    private static native void applyOnVisibleNative(long j, ICollisionItemImpl iCollisionItemImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native ArrayList<PixelPoint> getBoundNative(long j, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean getOnVisibleNative(long j, ICollisionItemImpl iCollisionItemImpl);

    private static native int getPriorityNative(long j, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean getVisibleNative(long j, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean isAreaCollisionNative(long j, ICollisionItemImpl iCollisionItemImpl);

    private static native void onVisibleNative(long j, ICollisionItemImpl iCollisionItemImpl, boolean z);

    private static native void resetOnVisibleNative(long j, ICollisionItemImpl iCollisionItemImpl, boolean z);

    private static native void setAreaCollisionNative(long j, ICollisionItemImpl iCollisionItemImpl, boolean z);

    public ICollisionItemImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICollisionItemImpl) && getUID(this) == getUID((ICollisionItemImpl) obj);
    }

    private static long getUID(ICollisionItemImpl iCollisionItemImpl) {
        long cPtr = getCPtr(iCollisionItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICollisionItemImpl iCollisionItemImpl) {
        if (iCollisionItemImpl == null) {
            return 0L;
        }
        return iCollisionItemImpl.swigCPtr;
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
        ICollisionItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICollisionItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void resetOnVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetOnVisibleNative(j, this, z);
    }

    public void onVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onVisibleNative(j, this, z);
    }

    public boolean getOnVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOnVisibleNative(j, this);
    }

    public void applyOnVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        applyOnVisibleNative(j, this);
    }

    public ArrayList<PixelPoint> getBound() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBoundNative(j, this);
    }

    public boolean getVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this);
    }

    public int getPriority() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPriorityNative(j, this);
    }

    public boolean isAreaCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isAreaCollisionNative(j, this);
    }

    public void setAreaCollision(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAreaCollisionNative(j, this, z);
    }

    public ICollisionItemImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        ICollisionItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
