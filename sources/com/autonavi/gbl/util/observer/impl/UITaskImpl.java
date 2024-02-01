package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.observer.UITask;
@IntfAuto(target = UITask.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class UITaskImpl extends RunTaskImpl {
    private static BindTable BIND_TABLE = new BindTable(UITaskImpl.class);
    private transient long swigCPtr;

    private static native long UITaskImpl_SWIGUpcast(long j);

    private static native void UITaskImpl_change_ownership(UITaskImpl uITaskImpl, long j, boolean z);

    private static native void UITaskImpl_director_connect(UITaskImpl uITaskImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str);

    private static native void destroyNativeObj(long j);

    private static native long getIdNative(long j, UITaskImpl uITaskImpl);

    private static native void onCancelNative(long j, UITaskImpl uITaskImpl);

    private static native void onCancelSwigExplicitUITaskImplNative(long j, UITaskImpl uITaskImpl);

    private static native void runNative(long j, UITaskImpl uITaskImpl);

    public UITaskImpl(long j, boolean z) {
        super(UITaskImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public boolean equals(Object obj) {
        if (obj instanceof UITaskImpl) {
            return getUID(this) == getUID((UITaskImpl) obj);
        }
        return super.equals(obj);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        UITaskImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        UITaskImpl_change_ownership(this, this.swigCPtr, true);
    }

    public UITaskImpl(String str) {
        this(createNativeObj(str), true);
        UtilModelObserverJNI.swig_jni_init();
        UITaskImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void run() {
        $explicit_run();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void $explicit_run() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        runNative(j, this);
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void onCancel() {
        $explicit_onCancel();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
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

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public long getId() {
        return $explicit_getId();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public long $explicit_getId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getIdNative(j, this);
    }
}
