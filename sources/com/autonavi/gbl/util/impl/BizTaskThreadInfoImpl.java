package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.BizTaskThreadInfo;
import com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl;
@IntfAuto(target = BizTaskThreadInfo.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class BizTaskThreadInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(BizTaskThreadInfoImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long bizThreadGetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl);

    private static native void bizThreadSetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl, long j2, IRunTaskThreadImpl iRunTaskThreadImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean enableExecutorGetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl);

    private static native void enableExecutorSetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl, boolean z);

    private static native long executorIdGetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl);

    private static native void executorIdSetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl, long j2);

    private static native long threadIdGetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl);

    private static native void threadIdSetNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl, long j2);

    public BizTaskThreadInfoImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BizTaskThreadInfoImpl) && getUID(this) == getUID((BizTaskThreadInfoImpl) obj);
    }

    private static long getUID(BizTaskThreadInfoImpl bizTaskThreadInfoImpl) {
        long cPtr = getCPtr(bizTaskThreadInfoImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BizTaskThreadInfoImpl bizTaskThreadInfoImpl) {
        if (bizTaskThreadInfoImpl == null) {
            return 0L;
        }
        return bizTaskThreadInfoImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setEnableExecutor(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableExecutorSetNative(j, this, z);
    }

    public boolean getEnableExecutor() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enableExecutorGetNative(j, this);
    }

    public void setExecutorId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        executorIdSetNative(j2, this, j);
    }

    public long getExecutorId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return executorIdGetNative(j, this);
    }

    public void setThreadId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        threadIdSetNative(j2, this, j);
    }

    public long getThreadId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return threadIdGetNative(j, this);
    }

    public void setBizThread(IRunTaskThreadImpl iRunTaskThreadImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bizThreadSetNative(j, this, IRunTaskThreadImpl.getCPtr(iRunTaskThreadImpl), iRunTaskThreadImpl);
    }

    public IRunTaskThreadImpl getBizThread() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizThreadGetNative = bizThreadGetNative(j, this);
        if (bizThreadGetNative == 0) {
            return null;
        }
        return new IRunTaskThreadImpl(bizThreadGetNative, false);
    }

    public BizTaskThreadInfoImpl() {
        this(createNativeObj(), true);
    }
}
