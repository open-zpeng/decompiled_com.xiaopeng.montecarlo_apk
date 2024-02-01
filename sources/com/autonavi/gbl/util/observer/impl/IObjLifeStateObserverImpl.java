package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.model.ObjLifeState;
import com.autonavi.gbl.util.observer.IObjLifeStateObserver;
@IntfAuto(target = IObjLifeStateObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IObjLifeStateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IObjLifeStateObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IObjLifeStateObserverImpl_change_ownership(IObjLifeStateObserverImpl iObjLifeStateObserverImpl, long j, boolean z);

    private static native void IObjLifeStateObserverImpl_director_connect(IObjLifeStateObserverImpl iObjLifeStateObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void inProgressNative(long j, IObjLifeStateObserverImpl iObjLifeStateObserverImpl, int i, long j2, String str);

    public IObjLifeStateObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IObjLifeStateObserverImpl) && getUID(this) == getUID((IObjLifeStateObserverImpl) obj);
    }

    private static long getUID(IObjLifeStateObserverImpl iObjLifeStateObserverImpl) {
        long cPtr = getCPtr(iObjLifeStateObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IObjLifeStateObserverImpl iObjLifeStateObserverImpl) {
        if (iObjLifeStateObserverImpl == null) {
            return 0L;
        }
        return iObjLifeStateObserverImpl.swigCPtr;
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
        IObjLifeStateObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IObjLifeStateObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void inProgress(@ObjLifeState.ObjLifeState1 int i, long j, String str) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        inProgressNative(j2, this, i, j, str);
    }

    public IObjLifeStateObserverImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        IObjLifeStateObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
