package com.autonavi.gbl.ehp.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.ehp.observer.IGEhpAdasDataCallback;
@IntfAuto(target = IGEhpAdasDataCallback.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IGEhpAdasDataCallbackImpl {
    private static BindTable BIND_TABLE = new BindTable(IGEhpAdasDataCallbackImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGEhpAdasDataCallbackImpl_change_ownership(IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl, long j, boolean z);

    private static native void IGEhpAdasDataCallbackImpl_director_connect(IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl, long j, boolean z, boolean z2);

    private static native void adasDataResponseNative(long j, IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl, String str);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public IGEhpAdasDataCallbackImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGEhpAdasDataCallbackImpl) && getUID(this) == getUID((IGEhpAdasDataCallbackImpl) obj);
    }

    private static long getUID(IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl) {
        long cPtr = getCPtr(iGEhpAdasDataCallbackImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl) {
        if (iGEhpAdasDataCallbackImpl == null) {
            return 0L;
        }
        return iGEhpAdasDataCallbackImpl.swigCPtr;
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
        IGEhpAdasDataCallbackImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGEhpAdasDataCallbackImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void adasDataResponse(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        adasDataResponseNative(j, this, str);
    }

    public IGEhpAdasDataCallbackImpl() {
        this(createNativeObj(), true);
        EhpObserverJNI.swig_jni_init();
        IGEhpAdasDataCallbackImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
