package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.TimeUtil;
import com.autonavi.gbl.util.model.DateTime;
import com.autonavi.gbl.util.model.TimeSourceFlag;
import com.autonavi.gbl.util.observer.impl.TimeSourceImpl;
@IntfAuto(target = TimeUtil.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class TimeUtilImpl {
    private static BindTable BIND_TABLE = new BindTable(TimeUtilImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native long dateTime2UTCNative(long j, DateTime dateTime);

    private static native long dateTimeBj2UTCNative(long j, DateTime dateTime);

    private static native void destroyNativeObj(long j);

    private static native long getGPSTimeNative();

    private static native void getLocalTime1Native(long j, DateTime dateTime);

    private static native long getLocalTimeNative();

    private static native long getNetWorkTimeNative(int[] iArr);

    private static native long getTickCountNative();

    private static native long getTimeSpanNative();

    private static native long getTimeUTCNative();

    private static native void registerTimeSource1Native(long j, TimeSourceImpl timeSourceImpl);

    private static native void registerTimeSourceNative(long j, TimeSourceImpl timeSourceImpl, int i);

    private static native void setGPSTimeNative(long j);

    private static native void uTC2DateTimeBjNative(long j, long j2, DateTime dateTime);

    private static native void uTC2DateTimeNative(long j, long j2, DateTime dateTime);

    public TimeUtilImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof TimeUtilImpl) && getUID(this) == getUID((TimeUtilImpl) obj);
    }

    private static long getUID(TimeUtilImpl timeUtilImpl) {
        long cPtr = getCPtr(timeUtilImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(TimeUtilImpl timeUtilImpl) {
        if (timeUtilImpl == null) {
            return 0L;
        }
        return timeUtilImpl.swigCPtr;
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

    public static DateTime getLocalTime2() {
        DateTime dateTime = new DateTime();
        getLocalTime(dateTime);
        return dateTime;
    }

    public static DateTime uTC2DateTime(long j) {
        DateTime dateTime = new DateTime();
        uTC2DateTime(j, dateTime);
        return dateTime;
    }

    public static DateTime uTC2DateTimeBj(long j) {
        DateTime dateTime = new DateTime();
        uTC2DateTimeBj(j, dateTime);
        return dateTime;
    }

    public static void registerTimeSource(TimeSourceImpl timeSourceImpl, @TimeSourceFlag.TimeSourceFlag1 int i) {
        registerTimeSourceNative(TimeSourceImpl.getCPtr(timeSourceImpl), timeSourceImpl, i);
    }

    public static void registerTimeSource(TimeSourceImpl timeSourceImpl) {
        registerTimeSource1Native(TimeSourceImpl.getCPtr(timeSourceImpl), timeSourceImpl);
    }

    public static void setGPSTime(long j) {
        setGPSTimeNative(j);
    }

    public static long getGPSTime() {
        return getGPSTimeNative();
    }

    public static long getNetWorkTime(int[] iArr) {
        return getNetWorkTimeNative(iArr);
    }

    public static long getTickCount() {
        return getTickCountNative();
    }

    public static long getLocalTime() {
        return getLocalTimeNative();
    }

    private static void getLocalTime(DateTime dateTime) {
        getLocalTime1Native(0L, dateTime);
    }

    private static void uTC2DateTime(long j, DateTime dateTime) {
        uTC2DateTimeNative(j, 0L, dateTime);
    }

    private static void uTC2DateTimeBj(long j, DateTime dateTime) {
        uTC2DateTimeBjNative(j, 0L, dateTime);
    }

    public static long dateTime2UTC(DateTime dateTime) {
        return dateTime2UTCNative(0L, dateTime);
    }

    public static long dateTimeBj2UTC(DateTime dateTime) {
        return dateTimeBj2UTCNative(0L, dateTime);
    }

    public static long getTimeUTC() {
        return getTimeUTCNative();
    }

    public static long getTimeSpan() {
        return getTimeSpanNative();
    }

    public TimeUtilImpl() {
        this(createNativeObj(), true);
    }
}
