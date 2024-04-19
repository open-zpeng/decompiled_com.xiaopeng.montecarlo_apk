package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.observer.IUITaskThread;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = IUITaskThread.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IUITaskThreadImpl {
    private static BindTable BIND_TABLE = new BindTable(IUITaskThreadImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IUITaskThreadImpl_change_ownership(IUITaskThreadImpl iUITaskThreadImpl, long j, boolean z);

    private static native void IUITaskThreadImpl_director_connect(IUITaskThreadImpl iUITaskThreadImpl, long j, boolean z, boolean z2);

    private static native void cancel1Native(long j, IUITaskThreadImpl iUITaskThreadImpl, ArrayList<Long> arrayList);

    private static native void cancelNative(long j, IUITaskThreadImpl iUITaskThreadImpl, long j2);

    private static native void clearNative(long j, IUITaskThreadImpl iUITaskThreadImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void postNative(long j, IUITaskThreadImpl iUITaskThreadImpl, long j2, UITaskImpl uITaskImpl, long j3, BigInteger bigInteger);

    public IUITaskThreadImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IUITaskThreadImpl) && getUID(this) == getUID((IUITaskThreadImpl) obj);
    }

    private static long getUID(IUITaskThreadImpl iUITaskThreadImpl) {
        long cPtr = getCPtr(iUITaskThreadImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IUITaskThreadImpl iUITaskThreadImpl) {
        if (iUITaskThreadImpl == null) {
            return 0L;
        }
        return iUITaskThreadImpl.swigCPtr;
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
        IUITaskThreadImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IUITaskThreadImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void post(UITaskImpl uITaskImpl, long j, BigInteger bigInteger) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        postNative(j2, this, UITaskImpl.getCPtr(uITaskImpl), uITaskImpl, j, bigInteger);
    }

    public void cancel(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        cancelNative(j2, this, j);
    }

    public void cancel(ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        cancel1Native(j, this, arrayList);
    }

    public void clear() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearNative(j, this);
    }

    public IUITaskThreadImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        IUITaskThreadImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
