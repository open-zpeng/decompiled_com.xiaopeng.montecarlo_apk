package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.LogIntf;
import com.autonavi.gbl.util.model.LogModuleConfig;
import com.autonavi.gbl.util.model.LogModuleType;
import com.autonavi.gbl.util.observer.impl.RuntimeInfoObserverImpl;
@IntfAuto(target = LogIntf.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LogIntfImpl {
    private static BindTable BIND_TABLE = new BindTable(LogIntfImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void configModuleNative(int i, long j, LogModuleConfig logModuleConfig);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void setModuleSwitchNative(boolean z);

    private static native boolean setRuntimeInfoObserverNative(int i, long j, RuntimeInfoObserverImpl runtimeInfoObserverImpl);

    public LogIntfImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof LogIntfImpl) && getUID(this) == getUID((LogIntfImpl) obj);
    }

    private static long getUID(LogIntfImpl logIntfImpl) {
        long cPtr = getCPtr(logIntfImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LogIntfImpl logIntfImpl) {
        if (logIntfImpl == null) {
            return 0L;
        }
        return logIntfImpl.swigCPtr;
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

    public static void configModule(int i, LogModuleConfig logModuleConfig) {
        configModuleNative(i, 0L, logModuleConfig);
    }

    public static boolean setRuntimeInfoObserver(@LogModuleType.LogModuleType1 int i, RuntimeInfoObserverImpl runtimeInfoObserverImpl) {
        return setRuntimeInfoObserverNative(i, RuntimeInfoObserverImpl.getCPtr(runtimeInfoObserverImpl), runtimeInfoObserverImpl);
    }

    public static void setModuleSwitch(boolean z) {
        setModuleSwitchNative(z);
    }

    public LogIntfImpl() {
        this(createNativeObj(), true);
    }
}
