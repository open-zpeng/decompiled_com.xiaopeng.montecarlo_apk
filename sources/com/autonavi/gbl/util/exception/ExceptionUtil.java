package com.autonavi.gbl.util.exception;
/* loaded from: classes2.dex */
public class ExceptionUtil {
    private transient long swigCPtr = createNativeObj();

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getExceptionDataNative(String str);

    public boolean equals(Object obj) {
        return (obj instanceof ExceptionUtil) && getUID(this) == getUID((ExceptionUtil) obj);
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            destroyNativeObj(this.swigCPtr);
            this.swigCPtr = 0L;
        }
    }

    public static long getCPtr(ExceptionUtil exceptionUtil) {
        if (exceptionUtil == null) {
            return 0L;
        }
        return exceptionUtil.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getExceptionData(String str) {
        return getExceptionDataNative(str);
    }

    private static long getUID(ExceptionUtil exceptionUtil) {
        long cPtr = getCPtr(exceptionUtil);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }
}
