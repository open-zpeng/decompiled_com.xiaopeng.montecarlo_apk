package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.observer.RunTask;
@IntfAuto(target = RunTask.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RunTaskImpl {
    private static BindTable BIND_TABLE = new BindTable(RunTaskImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void RunTaskImpl_change_ownership(RunTaskImpl runTaskImpl, long j, boolean z);

    private static native void RunTaskImpl_director_connect(RunTaskImpl runTaskImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str);

    private static native void destroyNativeObj(long j);

    private static native long getIdNative(long j, RunTaskImpl runTaskImpl);

    private static native String getTaskNameNative(long j, RunTaskImpl runTaskImpl);

    private static native String getTaskNameSwigExplicitRunTaskImplNative(long j, RunTaskImpl runTaskImpl);

    private static native void onCancelNative(long j, RunTaskImpl runTaskImpl);

    private static native void onCancelSwigExplicitRunTaskImplNative(long j, RunTaskImpl runTaskImpl);

    private static native void runNative(long j, RunTaskImpl runTaskImpl);

    public RunTaskImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof RunTaskImpl) && getUID(this) == getUID((RunTaskImpl) obj);
    }

    private static long getUID(RunTaskImpl runTaskImpl) {
        long cPtr = getCPtr(runTaskImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RunTaskImpl runTaskImpl) {
        if (runTaskImpl == null) {
            return 0L;
        }
        return runTaskImpl.swigCPtr;
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
        RunTaskImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RunTaskImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RunTaskImpl(String str) {
        this(createNativeObj(str), true);
        UtilModelObserverJNI.swig_jni_init();
        RunTaskImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void run() {
        $explicit_run();
    }

    public void $explicit_run() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        runNative(j, this);
    }

    public void onCancel() {
        $explicit_onCancel();
    }

    public void $explicit_onCancel() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RunTaskImpl.class) {
            onCancelNative(this.swigCPtr, this);
        } else {
            onCancelSwigExplicitRunTaskImplNative(this.swigCPtr, this);
        }
    }

    public long getId() {
        return $explicit_getId();
    }

    public long $explicit_getId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getIdNative(j, this);
    }

    public String getTaskName() {
        return $explicit_getTaskName();
    }

    public String $explicit_getTaskName() {
        if (this.swigCPtr != 0) {
            return getClass() == RunTaskImpl.class ? getTaskNameNative(this.swigCPtr, this) : getTaskNameSwigExplicitRunTaskImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
