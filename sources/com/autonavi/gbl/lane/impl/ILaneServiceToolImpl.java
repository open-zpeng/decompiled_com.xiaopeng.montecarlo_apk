package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.lane.LaneServiceTool;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.util.ArrayList;
@IntfAuto(target = LaneServiceTool.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneServiceToolImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneServiceToolImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native boolean enableDynamicLevelUseExternalSpeedNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, int i, boolean z);

    private static native boolean getPathCityListNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, long j2, PathInfo pathInfo, ArrayList<Long> arrayList);

    private static native String getProjectInfoNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl);

    private static native boolean openDCLUploadNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, boolean z);

    private static native boolean openRenderOutlineNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, int i, boolean z);

    private static native boolean openWaterArrowNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, int i, boolean z);

    private static native boolean sendHdDataVersionNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, String str);

    private static native boolean setDynamicLevelExternalSpeedNative(long j, ILaneServiceToolImpl iLaneServiceToolImpl, int i, float f);

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

    public ArrayList<Long> getPathCityList(PathInfo pathInfo) {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getPathCityList(pathInfo, arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getPathCityList(PathInfo pathInfo, ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPathCityListNative(j, this, PathInfo.getCPtr(pathInfo), pathInfo, arrayList);
    }

    public boolean enableDynamicLevelUseExternalSpeed(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enableDynamicLevelUseExternalSpeedNative(j, this, i, z);
    }

    public boolean setDynamicLevelExternalSpeed(@LaneRenderScreen.LaneRenderScreen1 int i, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDynamicLevelExternalSpeedNative(j, this, i, f);
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

    public boolean openDCLUpload(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openDCLUploadNative(j, this, z);
    }

    public boolean sendHdDataVersion(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sendHdDataVersionNative(j, this, str);
    }

    public boolean openWaterArrow(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openWaterArrowNative(j, this, i, z);
    }

    public boolean openRenderOutline(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openRenderOutlineNative(j, this, i, z);
    }
}
