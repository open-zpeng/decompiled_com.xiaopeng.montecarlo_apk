package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.UITaskThreadInfo;
import com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl;
@IntfAuto(target = UITaskThreadInfo.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class UITaskThreadInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(UITaskThreadInfoImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean enableExecutorGetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl);

    private static native void enableExecutorSetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl, boolean z);

    private static native long executorIdGetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl);

    private static native void executorIdSetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl, long j2);

    private static native long threadIdGetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl);

    private static native void threadIdSetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl, long j2);

    private static native long uiThreadGetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl);

    private static native void uiThreadSetNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl, long j2, IUITaskThreadImpl iUITaskThreadImpl);

    public UITaskThreadInfoImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof UITaskThreadInfoImpl) && getUID(this) == getUID((UITaskThreadInfoImpl) obj);
    }

    private static long getUID(UITaskThreadInfoImpl uITaskThreadInfoImpl) {
        long cPtr = getCPtr(uITaskThreadInfoImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(UITaskThreadInfoImpl uITaskThreadInfoImpl) {
        if (uITaskThreadInfoImpl == null) {
            return 0L;
        }
        return uITaskThreadInfoImpl.swigCPtr;
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

    public void setUiThread(IUITaskThreadImpl iUITaskThreadImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        uiThreadSetNative(j, this, IUITaskThreadImpl.getCPtr(iUITaskThreadImpl), iUITaskThreadImpl);
    }

    public IUITaskThreadImpl getUiThread() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long uiThreadGetNative = uiThreadGetNative(j, this);
        if (uiThreadGetNative == 0) {
            return null;
        }
        return new IUITaskThreadImpl(uiThreadGetNative, false);
    }

    public UITaskThreadInfoImpl() {
        this(createNativeObj(), true);
    }
}
