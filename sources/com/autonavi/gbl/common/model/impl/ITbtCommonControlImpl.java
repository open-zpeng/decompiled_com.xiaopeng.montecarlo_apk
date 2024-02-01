package com.autonavi.gbl.common.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.TbtCommonControl;
import com.autonavi.gbl.common.model.UserConfig;
import com.autonavi.gbl.common.model.WorkPath;
import com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl;
@IntfAuto(target = TbtCommonControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITbtCommonControlImpl {
    private static BindTable BIND_TABLE = new BindTable(ITbtCommonControlImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native long getInstanceNative();

    private static native int initNative(long j, ITbtCommonControlImpl iTbtCommonControlImpl, long j2, WorkPath workPath, long j3, UserConfig userConfig);

    private static native void setTBTResReaderNative(long j, ITbtCommonControlImpl iTbtCommonControlImpl, long j2, ITBTResReaderImpl iTBTResReaderImpl);

    private static native void unInitNative(long j, ITbtCommonControlImpl iTbtCommonControlImpl);

    public ITbtCommonControlImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITbtCommonControlImpl) && getUID(this) == getUID((ITbtCommonControlImpl) obj);
    }

    private static long getUID(ITbtCommonControlImpl iTbtCommonControlImpl) {
        long cPtr = getCPtr(iTbtCommonControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITbtCommonControlImpl iTbtCommonControlImpl) {
        if (iTbtCommonControlImpl == null) {
            return 0L;
        }
        return iTbtCommonControlImpl.swigCPtr;
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

    public static ITbtCommonControlImpl getInstance() {
        long instanceNative = getInstanceNative();
        if (instanceNative == 0) {
            return null;
        }
        return new ITbtCommonControlImpl(instanceNative, false);
    }

    public int init(WorkPath workPath, UserConfig userConfig) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, workPath, 0L, userConfig);
    }

    public void setTBTResReader(ITBTResReaderImpl iTBTResReaderImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setTBTResReaderNative(j, this, ITBTResReaderImpl.getCPtr(iTBTResReaderImpl), iTBTResReaderImpl);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }
}
