package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.ErrorCodeHelper;
import com.autonavi.gbl.util.model.ErrorDetail;
@IntfAuto(target = ErrorCodeHelper.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ErrorCodeHelperImpl {
    private static BindTable BIND_TABLE = new BindTable(ErrorCodeHelperImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native ErrorDetail getErrorDetailNative(int i);

    public ErrorCodeHelperImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ErrorCodeHelperImpl) && getUID(this) == getUID((ErrorCodeHelperImpl) obj);
    }

    private static long getUID(ErrorCodeHelperImpl errorCodeHelperImpl) {
        long cPtr = getCPtr(errorCodeHelperImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ErrorCodeHelperImpl errorCodeHelperImpl) {
        if (errorCodeHelperImpl == null) {
            return 0L;
        }
        return errorCodeHelperImpl.swigCPtr;
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

    public ErrorCodeHelperImpl() {
        this(createNativeObj(), true);
    }

    public static ErrorDetail getErrorDetail(int i) {
        return getErrorDetailNative(i);
    }
}
