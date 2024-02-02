package com.autonavi.gbl.guide.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.guide.model.NaviCongestionDetailInfo;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import java.util.ArrayList;
@IntfAuto(target = NaviCongestionInfo.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class NaviCongestionInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(NaviCongestionInfoImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native ArrayList<NaviCongestionDetailInfo> congestionInfosGetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl);

    private static native void congestionInfosSetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl, ArrayList<NaviCongestionDetailInfo> arrayList);

    private static native void copyNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl, long j2, NaviCongestionInfoImpl naviCongestionInfoImpl2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native CongestExtend extendGetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl);

    private static native void extendSetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl, long j2, CongestExtend congestExtend);

    private static native long pathIDGetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl);

    private static native void pathIDSetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl, long j2);

    private static native long totalRemainDistGetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl);

    private static native void totalRemainDistSetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl, long j2);

    private static native long totalTimeOfSecondsGetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl);

    private static native void totalTimeOfSecondsSetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl, long j2);

    private static native boolean unobstructedGetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl);

    private static native void unobstructedSetNative(long j, NaviCongestionInfoImpl naviCongestionInfoImpl, boolean z);

    public NaviCongestionInfoImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof NaviCongestionInfoImpl) && getUID(this) == getUID((NaviCongestionInfoImpl) obj);
    }

    private static long getUID(NaviCongestionInfoImpl naviCongestionInfoImpl) {
        long cPtr = getCPtr(naviCongestionInfoImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(NaviCongestionInfoImpl naviCongestionInfoImpl) {
        if (naviCongestionInfoImpl == null) {
            return 0L;
        }
        return naviCongestionInfoImpl.swigCPtr;
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

    public void setPathID(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        pathIDSetNative(j2, this, j);
    }

    public long getPathID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pathIDGetNative(j, this);
    }

    public void setTotalTimeOfSeconds(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        totalTimeOfSecondsSetNative(j2, this, j);
    }

    public long getTotalTimeOfSeconds() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return totalTimeOfSecondsGetNative(j, this);
    }

    public void setTotalRemainDist(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        totalRemainDistSetNative(j2, this, j);
    }

    public long getTotalRemainDist() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return totalRemainDistGetNative(j, this);
    }

    public void setUnobstructed(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unobstructedSetNative(j, this, z);
    }

    public boolean getUnobstructed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return unobstructedGetNative(j, this);
    }

    public void setCongestionInfos(ArrayList<NaviCongestionDetailInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        congestionInfosSetNative(j, this, arrayList);
    }

    public ArrayList<NaviCongestionDetailInfo> getCongestionInfos() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return congestionInfosGetNative(j, this);
    }

    public void setExtend(CongestExtend congestExtend) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        extendSetNative(j, this, 0L, congestExtend);
    }

    public CongestExtend getExtend() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return extendGetNative(j, this);
    }

    public NaviCongestionInfoImpl() {
        this(createNativeObj(), true);
    }

    public void copy(NaviCongestionInfoImpl naviCongestionInfoImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        copyNative(j, this, getCPtr(naviCongestionInfoImpl), naviCongestionInfoImpl);
    }
}
