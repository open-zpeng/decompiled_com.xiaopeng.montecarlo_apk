package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.UtilDayStatusNotify;
import com.autonavi.gbl.map.model.DAY_STATUS;
import java.util.ArrayList;
@IntfAuto(target = UtilDayStatusNotify.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IUtilDayStatusNotifyImpl {
    private static BindTable BIND_TABLE = new BindTable(IUtilDayStatusNotifyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addListenerNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl, long j2, IDayStatusListenerImpl iDayStatusListenerImpl);

    private static native void destroyNativeObj(long j);

    private static native int getDayStatusNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl);

    private static native long getInstanceNative();

    private static native long[] getListenersNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl);

    private static native boolean getSunTimeNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl, double[] dArr, double[] dArr2, double[] dArr3);

    private static native void initNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl);

    private static native boolean isNormalDayNative(int i);

    private static native boolean isNormalNightNative(int i);

    private static native boolean removeListenerNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl, long j2, IDayStatusListenerImpl iDayStatusListenerImpl);

    private static native void setSystemUtilNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl, long j2, IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl);

    private static native void startNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl);

    private static native void stopNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl);

    private static native void unInitNative(long j, IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl);

    public IUtilDayStatusNotifyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IUtilDayStatusNotifyImpl) && getUID(this) == getUID((IUtilDayStatusNotifyImpl) obj);
    }

    private static long getUID(IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl) {
        long cPtr = getCPtr(iUtilDayStatusNotifyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl) {
        if (iUtilDayStatusNotifyImpl == null) {
            return 0L;
        }
        return iUtilDayStatusNotifyImpl.swigCPtr;
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

    public static IUtilDayStatusNotifyImpl getInstance() {
        long instanceNative = getInstanceNative();
        if (instanceNative == 0) {
            return null;
        }
        return new IUtilDayStatusNotifyImpl(instanceNative, false);
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

    public ArrayList getSunTime() {
        ArrayList arrayList = new ArrayList();
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        double[] dArr3 = new double[1];
        if (Boolean.valueOf(getSunTime(dArr, dArr2, dArr3)).booleanValue()) {
            arrayList.add(dArr);
            arrayList.add(dArr2);
            arrayList.add(dArr3);
        }
        return arrayList;
    }

    private boolean getSunTime(double[] dArr, double[] dArr2, double[] dArr3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSunTimeNative(j, this, dArr, dArr2, dArr3);
    }

    public static boolean isNormalDay(@DAY_STATUS.DAY_STATUS1 int i) {
        return isNormalDayNative(i);
    }

    public static boolean isNormalNight(@DAY_STATUS.DAY_STATUS1 int i) {
        return isNormalNightNative(i);
    }
}
