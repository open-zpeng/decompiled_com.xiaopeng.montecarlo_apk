package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.DrInfo;
import com.autonavi.gbl.pos.observer.IPosDrInfoObserver;
@IntfAuto(target = IPosDrInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosDrInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosDrInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosDrInfoObserverImpl_change_ownership(IPosDrInfoObserverImpl iPosDrInfoObserverImpl, long j, boolean z);

    private static native void IPosDrInfoObserverImpl_director_connect(IPosDrInfoObserverImpl iPosDrInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onDrInfoUpdateNative(long j, IPosDrInfoObserverImpl iPosDrInfoObserverImpl, long j2, DrInfo drInfo);

    public IPosDrInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosDrInfoObserverImpl) && getUID(this) == getUID((IPosDrInfoObserverImpl) obj);
    }

    private static long getUID(IPosDrInfoObserverImpl iPosDrInfoObserverImpl) {
        long cPtr = getCPtr(iPosDrInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosDrInfoObserverImpl iPosDrInfoObserverImpl) {
        if (iPosDrInfoObserverImpl == null) {
            return 0L;
        }
        return iPosDrInfoObserverImpl.swigCPtr;
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
        IPosDrInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosDrInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onDrInfoUpdate(DrInfo drInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDrInfoUpdateNative(j, this, 0L, drInfo);
    }

    public IPosDrInfoObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosDrInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
