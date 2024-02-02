package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.UtilDayStatusNotify;
import com.autonavi.gbl.map.model.DAY_STATUS;
import java.util.ArrayList;
@IntfAuto(target = UtilDayStatusNotify.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class UtilDayStatusNotifyImpl {
    private static BindTable BIND_TABLE = new BindTable(UtilDayStatusNotifyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addListenerNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl, long j2, IDayStatusListenerImpl iDayStatusListenerImpl);

    private static native void destroyNativeObj(long j);

    private static native int getDayStatusNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl);

    private static native long getInstanceNative();

    private static native long[] getListenersNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl);

    private static native void initNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl);

    private static native boolean isNormalDayNative(int i);

    private static native boolean isNormalNightNative(int i);

    private static native boolean removeListenerNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl, long j2, IDayStatusListenerImpl iDayStatusListenerImpl);

    private static native void setSystemUtilNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl, long j2, IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl);

    private static native void startNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl);

    private static native void stopNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl);

    private static native void unInitNative(long j, UtilDayStatusNotifyImpl utilDayStatusNotifyImpl);

    public UtilDayStatusNotifyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof UtilDayStatusNotifyImpl) && getUID(this) == getUID((UtilDayStatusNotifyImpl) obj);
    }

    private static long getUID(UtilDayStatusNotifyImpl utilDayStatusNotifyImpl) {
        long cPtr = getCPtr(utilDayStatusNotifyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(UtilDayStatusNotifyImpl utilDayStatusNotifyImpl) {
        if (utilDayStatusNotifyImpl == null) {
            return 0L;
        }
        return utilDayStatusNotifyImpl.swigCPtr;
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

    public static UtilDayStatusNotifyImpl getInstance() {
        long instanceNative = getInstanceNative();
        if (instanceNative == 0) {
            return null;
        }
        return new UtilDayStatusNotifyImpl(instanceNative, false);
    }

    public void init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        initNative(j, this);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public ArrayList<IDayStatusListenerImpl> getListeners() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ArrayList<IDayStatusListenerImpl> arrayList = null;
        long[] listenersNative = getListenersNative(j, this);
        if (listenersNative != null) {
            arrayList = new ArrayList<>();
            for (long j2 : listenersNative) {
                arrayList.add(new IDayStatusListenerImpl(j2, false));
            }
        }
        return arrayList;
    }

    public void setSystemUtil(IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSystemUtilNative(j, this, IDayStatusSystemUtilImpl.getCPtr(iDayStatusSystemUtilImpl), iDayStatusSystemUtilImpl);
    }

    public boolean addListener(IDayStatusListenerImpl iDayStatusListenerImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addListenerNative(j, this, IDayStatusListenerImpl.getCPtr(iDayStatusListenerImpl), iDayStatusListenerImpl);
    }

    public boolean removeListener(IDayStatusListenerImpl iDayStatusListenerImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeListenerNative(j, this, IDayStatusListenerImpl.getCPtr(iDayStatusListenerImpl), iDayStatusListenerImpl);
    }

    public void start() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        startNative(j, this);
    }

    public void stop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        stopNative(j, this);
    }

    @DAY_STATUS.DAY_STATUS1
    public int getDayStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDayStatusNative(j, this);
    }

    public static boolean isNormalDay(@DAY_STATUS.DAY_STATUS1 int i) {
        return isNormalDayNative(i);
    }

    public static boolean isNormalNight(@DAY_STATUS.DAY_STATUS1 int i) {
        return isNormalNightNative(i);
    }
}
