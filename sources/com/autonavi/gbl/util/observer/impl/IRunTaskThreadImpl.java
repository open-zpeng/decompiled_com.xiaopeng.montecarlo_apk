package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.observer.IRunTaskThread;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = IRunTaskThread.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRunTaskThreadImpl {
    private static BindTable BIND_TABLE = new BindTable(IRunTaskThreadImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IRunTaskThreadImpl_change_ownership(IRunTaskThreadImpl iRunTaskThreadImpl, long j, boolean z);

    private static native void IRunTaskThreadImpl_director_connect(IRunTaskThreadImpl iRunTaskThreadImpl, long j, boolean z, boolean z2);

    private static native void cancel1Native(long j, IRunTaskThreadImpl iRunTaskThreadImpl, ArrayList<Long> arrayList);

    private static native void cancelNative(long j, IRunTaskThreadImpl iRunTaskThreadImpl, long j2);

    private static native void clearNative(long j, IRunTaskThreadImpl iRunTaskThreadImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void postNative(long j, IRunTaskThreadImpl iRunTaskThreadImpl, long j2, RunTaskImpl runTaskImpl, long j3, BigInteger bigInteger);

    public IRunTaskThreadImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRunTaskThreadImpl) && getUID(this) == getUID((IRunTaskThreadImpl) obj);
    }

    private static long getUID(IRunTaskThreadImpl iRunTaskThreadImpl) {
        long cPtr = getCPtr(iRunTaskThreadImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRunTaskThreadImpl iRunTaskThreadImpl) {
        if (iRunTaskThreadImpl == null) {
            return 0L;
        }
        return iRunTaskThreadImpl.swigCPtr;
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
        IRunTaskThreadImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IRunTaskThreadImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void post(RunTaskImpl runTaskImpl, long j, BigInteger bigInteger) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        postNative(j2, this, RunTaskImpl.getCPtr(runTaskImpl), runTaskImpl, j, bigInteger);
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

    public IRunTaskThreadImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        IRunTaskThreadImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
