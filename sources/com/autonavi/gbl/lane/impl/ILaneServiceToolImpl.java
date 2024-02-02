package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import java.util.ArrayList;
@IntfAuto(target = com.autonavi.gbl.lane.LaneServiceTool.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneServiceToolImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneServiceToolImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native boolean enableDynamicLevelUseExternalSpeedNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, boolean z);

    private static native boolean getPathCityListNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, long j2, PathInfoImpl pathInfoImpl, ArrayList<Long> arrayList);

    private static native String getProjectInfoNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl);

    private static native boolean setDynamicLevelExternalSpeedNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, float f);

    private static native boolean setProjectInfoNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, String str);

    public ILaneServiceToolImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneServiceToolImpl) && getUID(this) == getUID((ILaneServiceToolImpl) obj);
    }

    private static long getUID(ILaneServiceToolImpl iLaneServiceToolImpl) {
        long cPtr = getCPtr(iLaneServiceToolImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneServiceToolImpl iLaneServiceToolImpl) {
        if (iLaneServiceToolImpl == null) {
            return 0L;
        }
        return iLaneServiceToolImpl.swigCPtr;
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

    public ArrayList<Long> getPathCityList(PathInfoImpl pathInfoImpl) {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (getPathCityList(pathInfoImpl, arrayList)) {
            return arrayList;
        }
        return null;
    }

    private boolean getPathCityList(PathInfoImpl pathInfoImpl, ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPathCityListNative(j, this, PathInfoImpl.getCPtr(pathInfoImpl), pathInfoImpl, arrayList);
    }

    public boolean enableDynamicLevelUseExternalSpeed(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enableDynamicLevelUseExternalSpeedNative(j, this, z);
    }

    public boolean setDynamicLevelExternalSpeed(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDynamicLevelExternalSpeedNative(j, this, f);
    }

    public String getProjectInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getProjectInfoNative(j, this);
    }

    public boolean setProjectInfo(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setProjectInfoNative(j, this, str);
    }
}
