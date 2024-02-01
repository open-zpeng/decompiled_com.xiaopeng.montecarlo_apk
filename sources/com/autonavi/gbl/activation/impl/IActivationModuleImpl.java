package com.autonavi.gbl.activation.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.activation.ActivationModule;
import com.autonavi.gbl.activation.model.ActivateReturnParam;
import com.autonavi.gbl.activation.model.ActivationInitParam;
import com.autonavi.gbl.activation.model.ProjectType;
import com.autonavi.gbl.activation.observer.impl.INetActivateObserverImpl;
@IntfAuto(target = ActivationModule.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IActivationModuleImpl {
    private static BindTable BIND_TABLE = new BindTable(IActivationModuleImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native ActivateReturnParam backDoorActivateNative(long j, IActivationModuleImpl iActivationModuleImpl, String str);

    private static native void destroyInstanceNative();

    private static native void destroyNativeObj(long j);

    private static native String digitCompletionNative(long j, IActivationModuleImpl iActivationModuleImpl, String str);

    private static native int getActivateStatusNative(long j, IActivationModuleImpl iActivationModuleImpl);

    private static native long getInstanceNative();

    private static native int initNative(long j, IActivationModuleImpl iActivationModuleImpl, long j2, ActivationInitParam activationInitParam);

    private static native ActivateReturnParam manualActivateNative(long j, IActivationModuleImpl iActivationModuleImpl, String str, String str2);

    private static native int netActivateNative(long j, IActivationModuleImpl iActivationModuleImpl, String str);

    private static native void setNetActivateObserverNative(long j, IActivationModuleImpl iActivationModuleImpl, long j2, INetActivateObserverImpl iNetActivateObserverImpl);

    private static native void setProjectTypeNative(long j, IActivationModuleImpl iActivationModuleImpl, int i);

    private static native void unInitNative(long j, IActivationModuleImpl iActivationModuleImpl);

    public IActivationModuleImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IActivationModuleImpl) && getUID(this) == getUID((IActivationModuleImpl) obj);
    }

    private static long getUID(IActivationModuleImpl iActivationModuleImpl) {
        long cPtr = getCPtr(iActivationModuleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IActivationModuleImpl iActivationModuleImpl) {
        if (iActivationModuleImpl == null) {
            return 0L;
        }
        return iActivationModuleImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static IActivationModuleImpl getInstance() {
        long instanceNative = getInstanceNative();
        if (instanceNative == 0) {
            return null;
        }
        return new IActivationModuleImpl(instanceNative, false);
    }

    public static void destroyInstance() {
        destroyInstanceNative();
    }

    public int init(ActivationInitParam activationInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, activationInitParam);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public void setNetActivateObserver(INetActivateObserverImpl iNetActivateObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNetActivateObserverNative(j, this, INetActivateObserverImpl.getCPtr(iNetActivateObserverImpl), iNetActivateObserverImpl);
    }

    public int getActivateStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getActivateStatusNative(j, this);
    }

    public ActivateReturnParam manualActivate(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return manualActivateNative(j, this, str, str2);
    }

    public int netActivate(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return netActivateNative(j, this, str);
    }

    public ActivateReturnParam backDoorActivate(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return backDoorActivateNative(j, this, str);
    }

    public String digitCompletion(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return digitCompletionNative(j, this, str);
    }

    public void setProjectType(@ProjectType.ProjectType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setProjectTypeNative(j, this, i);
    }
}
