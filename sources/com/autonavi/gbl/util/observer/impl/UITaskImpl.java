package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.observer.UITask;
@IntfAuto(target = UITask.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class UITaskImpl {
    private static BindTable BIND_TABLE = new BindTable(UITaskImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void UITaskImpl_change_ownership(UITaskImpl uITaskImpl, long j, boolean z);

    private static native void UITaskImpl_director_connect(UITaskImpl uITaskImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str);

    private static native void destroyNativeObj(long j);

    private static native long getIdNative(long j, UITaskImpl uITaskImpl);

    private static native void onCancelNative(long j, UITaskImpl uITaskImpl);

    private static native void onCancelSwigExplicitUITaskImplNative(long j, UITaskImpl uITaskImpl);

    private static native void runNative(long j, UITaskImpl uITaskImpl);

    public UITaskImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof UITaskImpl) && getUID(this) == getUID((UITaskImpl) obj);
    }

    private static long getUID(UITaskImpl uITaskImpl) {
        long cPtr = getCPtr(uITaskImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(UITaskImpl uITaskImpl) {
        if (uITaskImpl == null) {
            return 0L;
        }
        return uITaskImpl.swigCPtr;
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
        UITaskImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        UITaskImpl_change_ownership(this, this.swigCPtr, true);
    }

    public UITaskImpl(String str) {
        this(createNativeObj(str), true);
        UtilModelObserverJNI.swig_jni_init();
        UITaskImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
        if (getClass() == UITaskImpl.class) {
            onCancelNative(this.swigCPtr, this);
        } else {
            onCancelSwigExplicitUITaskImplNative(this.swigCPtr, this);
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
}
