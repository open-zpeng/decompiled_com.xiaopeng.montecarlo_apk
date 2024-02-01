package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.GestureAction;
import com.autonavi.gbl.map.observer.IMapGestureObserver;
@IntfAuto(target = IMapGestureObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapGestureObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapGestureObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapGestureObserverImpl_change_ownership(IMapGestureObserverImpl iMapGestureObserverImpl, long j, boolean z);

    private static native void IMapGestureObserverImpl_director_connect(IMapGestureObserverImpl iMapGestureObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onDoublePressNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native void onLongPressNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native void onMotionEventNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, int i, long j3, long j4);

    private static native void onMoveBeginNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native void onMoveEndNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native void onMoveLockedNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2);

    private static native void onMoveNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native void onPinchLockedNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2);

    private static native void onScaleRotateBeginNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native void onScaleRotateEndNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native void onScaleRotateNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4);

    private static native boolean onSinglePressNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, long j3, long j4, boolean z);

    private static native void onSlidingNative(long j, IMapGestureObserverImpl iMapGestureObserverImpl, long j2, float f, float f2);

    public IMapGestureObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapGestureObserverImpl) && getUID(this) == getUID((IMapGestureObserverImpl) obj);
    }

    private static long getUID(IMapGestureObserverImpl iMapGestureObserverImpl) {
        long cPtr = getCPtr(iMapGestureObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapGestureObserverImpl iMapGestureObserverImpl) {
        if (iMapGestureObserverImpl == null) {
            return 0L;
        }
        return iMapGestureObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
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
        IMapGestureObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapGestureObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMotionEvent(long j, @GestureAction.GestureAction1 int i, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onMotionEventNative(j4, this, j, i, j2, j3);
    }

    public void onMoveBegin(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onMoveBeginNative(j4, this, j, j2, j3);
    }

    public void onMoveEnd(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onMoveEndNative(j4, this, j, j2, j3);
    }

    public void onMove(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onMoveNative(j4, this, j, j2, j3);
    }

    public void onMoveLocked(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMoveLockedNative(j2, this, j);
    }

    public void onScaleRotateBegin(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onScaleRotateBeginNative(j4, this, j, j2, j3);
    }

    public void onScaleRotateEnd(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onScaleRotateEndNative(j4, this, j, j2, j3);
    }

    public void onScaleRotate(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onScaleRotateNative(j4, this, j, j2, j3);
    }

    public void onPinchLocked(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onPinchLockedNative(j2, this, j);
    }

    public void onLongPress(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        onLongPressNative(j4, this, j, j2, j3);
    }

    public boolean onDoublePress(long j, long j2, long j3) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        return onDoublePressNative(j4, this, j, j2, j3);
    }

    public boolean onSinglePress(long j, long j2, long j3, boolean z) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        return onSinglePressNative(j4, this, j, j2, j3, z);
    }

    public void onSliding(long j, float f, float f2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSlidingNative(j2, this, j, f, f2);
    }

    public IMapGestureObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapGestureObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
