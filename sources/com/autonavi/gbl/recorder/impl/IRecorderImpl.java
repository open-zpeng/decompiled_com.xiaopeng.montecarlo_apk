package com.autonavi.gbl.recorder.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.recorder.Recorder;
import com.autonavi.gbl.recorder.model.RecordParam;
@IntfAuto(target = Recorder.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRecorderImpl {
    private static BindTable BIND_TABLE = new BindTable(IRecorderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int getParamNative(long j, IRecorderImpl iRecorderImpl, long j2, RecordParam recordParam);

    private static native int setParamNative(long j, IRecorderImpl iRecorderImpl, long j2, RecordParam recordParam);

    private static native int startNative(long j, IRecorderImpl iRecorderImpl);

    private static native int stopNative(long j, IRecorderImpl iRecorderImpl);

    public IRecorderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRecorderImpl) && getUID(this) == getUID((IRecorderImpl) obj);
    }

    private static long getUID(IRecorderImpl iRecorderImpl) {
        long cPtr = getCPtr(iRecorderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRecorderImpl iRecorderImpl) {
        if (iRecorderImpl == null) {
            return 0L;
        }
        return iRecorderImpl.swigCPtr;
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

    public int setParam(RecordParam recordParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setParamNative(j, this, 0L, recordParam);
    }

    public RecordParam getParam() {
        RecordParam recordParam = new RecordParam();
        if (Integer.valueOf(getParam(recordParam)).intValue() == 0) {
            return recordParam;
        }
        return null;
    }

    private int getParam(RecordParam recordParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getParamNative(j, this, 0L, recordParam);
    }

    public int start() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startNative(j, this);
    }

    public int stop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return stopNative(j, this);
    }
}
