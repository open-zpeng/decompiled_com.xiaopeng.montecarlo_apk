package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.observer.IJniExceptionObserver;
@IntfAuto(target = IJniExceptionObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IJniExceptionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IJniExceptionObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IJniExceptionObserverImpl_change_ownership(IJniExceptionObserverImpl iJniExceptionObserverImpl, long j, boolean z);

    private static native void IJniExceptionObserverImpl_director_connect(IJniExceptionObserverImpl iJniExceptionObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onExceptionNative(long j, IJniExceptionObserverImpl iJniExceptionObserverImpl, String str);

    public IJniExceptionObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IJniExceptionObserverImpl) && getUID(this) == getUID((IJniExceptionObserverImpl) obj);
    }

    private static long getUID(IJniExceptionObserverImpl iJniExceptionObserverImpl) {
        long cPtr = getCPtr(iJniExceptionObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IJniExceptionObserverImpl iJniExceptionObserverImpl) {
        if (iJniExceptionObserverImpl == null) {
            return 0L;
        }
        return iJniExceptionObserverImpl.swigCPtr;
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
        IJniExceptionObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IJniExceptionObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onException(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onExceptionNative(j, this, str);
    }

    public IJniExceptionObserverImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        IJniExceptionObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
