package com.autonavi.gbl.aosclient.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.EGAOSSERVERTYPE;
import com.autonavi.gbl.aosclient.model.GAosServerType;
@IntfAuto(target = GAosServerType.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class GAosServerTypeImpl {
    private static BindTable BIND_TABLE = new BindTable(GAosServerTypeImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native short[] getStringNative(int i);

    public GAosServerTypeImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof GAosServerTypeImpl) && getUID(this) == getUID((GAosServerTypeImpl) obj);
    }

    private static long getUID(GAosServerTypeImpl gAosServerTypeImpl) {
        long cPtr = getCPtr(gAosServerTypeImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GAosServerTypeImpl gAosServerTypeImpl) {
        if (gAosServerTypeImpl == null) {
            return 0L;
        }
        return gAosServerTypeImpl.swigCPtr;
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

    public GAosServerTypeImpl() {
        this(createNativeObj(), true);
    }

    public static short[] getString(@EGAOSSERVERTYPE.EGAOSSERVERTYPE1 int i) {
        return getStringNative(i);
    }
}
