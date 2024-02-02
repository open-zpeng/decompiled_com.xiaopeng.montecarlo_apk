package com.autonavi.gbl.card.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.card.CardManager;
@IntfAuto(target = CardManager.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICardManagerImpl {
    private static BindTable BIND_TABLE = new BindTable(ICardManagerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public ICardManagerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICardManagerImpl) && getUID(this) == getUID((ICardManagerImpl) obj);
    }

    private static long getUID(ICardManagerImpl iCardManagerImpl) {
        long cPtr = getCPtr(iCardManagerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICardManagerImpl iCardManagerImpl) {
        if (iCardManagerImpl == null) {
            return 0L;
        }
        return iCardManagerImpl.swigCPtr;
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

    public ICardManagerImpl() {
        this(createNativeObj(), true);
    }
}
