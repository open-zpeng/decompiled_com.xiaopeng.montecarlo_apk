package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.LaneServiceRecorder;
@IntfAuto(target = LaneServiceRecorder.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneServiceRecorderImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneServiceRecorderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native boolean enableRecordLaneResourceNative(long j, ILaneServiceRecorderImpl iLaneServiceRecorderImpl, boolean z);

    private static native boolean setAutoDeleteRecordNative(long j, ILaneServiceRecorderImpl iLaneServiceRecorderImpl, boolean z, int i, int i2);

    private static native boolean setRecordPathNative(long j, ILaneServiceRecorderImpl iLaneServiceRecorderImpl, String str);

    private static native boolean startRecordNative(long j, ILaneServiceRecorderImpl iLaneServiceRecorderImpl);

    private static native boolean stopRecordNative(long j, ILaneServiceRecorderImpl iLaneServiceRecorderImpl);

    public ILaneServiceRecorderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneServiceRecorderImpl) && getUID(this) == getUID((ILaneServiceRecorderImpl) obj);
    }

    private static long getUID(ILaneServiceRecorderImpl iLaneServiceRecorderImpl) {
        long cPtr = getCPtr(iLaneServiceRecorderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneServiceRecorderImpl iLaneServiceRecorderImpl) {
        if (iLaneServiceRecorderImpl == null) {
            return 0L;
        }
        return iLaneServiceRecorderImpl.swigCPtr;
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

    public boolean setAutoDeleteRecord(boolean z, int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAutoDeleteRecordNative(j, this, z, i, i2);
    }

    public boolean setRecordPath(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRecordPathNative(j, this, str);
    }

    public boolean enableRecordLaneResource(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enableRecordLaneResourceNative(j, this, z);
    }

    public boolean startRecord() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startRecordNative(j, this);
    }

    public boolean stopRecord() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return stopRecordNative(j, this);
    }
}
