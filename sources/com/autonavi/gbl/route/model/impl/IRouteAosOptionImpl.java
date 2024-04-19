package com.autonavi.gbl.route.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.route.model.ExtraRequestParam;
import com.autonavi.gbl.route.model.RouteAosOption;
@IntfAuto(target = RouteAosOption.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteAosOptionImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteAosOptionImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addExtraParamNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i, String str);

    private static native long createNative();

    private static native void destroyNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl);

    private static native void destroyNativeObj(long j);

    private static native String getExtraParamByFildNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setAngleRadiusNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setCarHeightNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setCarLengthNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setCarLoadNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setCarPlateNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setCarSizeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setCarTypeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setCarWeightNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setCarWidthNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setCompassDirNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setContentOptionNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setEndPoiIdNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setEndPoiTypeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setEndTypeCodeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setFlagNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setFromXNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setFromYNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setGpsCredibilityNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setGpsDirNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setGpsHelterNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setInvokerNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setMatchingDirNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setPlayStyleNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setPolicy2Native(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setRefreshNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setRequestTimeOutNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, long j2);

    private static native void setReturnFormatNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setRouteModeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setRouteVerNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setSdkVerNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setSigTypeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setSoundTypeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setStartAngleAngleNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setStartAngleCredibilityNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setStartDirTypeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setStartLocatePrecisionNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setStartLocateSpeedNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setStartPoiIdNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setStartPoiTypeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setStartTypeCodeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setThreeDNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, int i);

    private static native void setToXNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setToYNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setUsePoiQueryNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setVehicleChargeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, float f);

    private static native void setViaPoiTypeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setViaPointIdsNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setViaPointsNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    private static native void setViaTypeCodeNative(long j, IRouteAosOptionImpl iRouteAosOptionImpl, String str);

    public IRouteAosOptionImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteAosOptionImpl) && getUID(this) == getUID((IRouteAosOptionImpl) obj);
    }

    private static long getUID(IRouteAosOptionImpl iRouteAosOptionImpl) {
        long cPtr = getCPtr(iRouteAosOptionImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteAosOptionImpl iRouteAosOptionImpl) {
        if (iRouteAosOptionImpl == null) {
            return 0L;
        }
        return iRouteAosOptionImpl.swigCPtr;
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

    public static IRouteAosOptionImpl create() {
        long createNative = createNative();
        if (createNative == 0) {
            return null;
        }
        return new IRouteAosOptionImpl(createNative, false);
    }

    public static void destroy(IRouteAosOptionImpl iRouteAosOptionImpl) {
        destroyNative(getCPtr(iRouteAosOptionImpl), iRouteAosOptionImpl);
    }

    public void setFromX(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFromXNative(j, this, str);
    }

    public void setFromY(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFromYNative(j, this, str);
    }

    public void setStartPoiType(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartPoiTypeNative(j, this, str);
    }

    public void setToX(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setToXNative(j, this, str);
    }

    public void setToY(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setToYNative(j, this, str);
    }

    public void setEndPoiType(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setEndPoiTypeNative(j, this, str);
    }

    public void setStartPoiId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartPoiIdNative(j, this, str);
    }

    public void setEndPoiId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setEndPoiIdNative(j, this, str);
    }

    public void setViaPoints(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViaPointsNative(j, this, str);
    }

    public void setViaPointIds(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViaPointIdsNative(j, this, str);
    }

    public void setViaPoiType(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViaPoiTypeNative(j, this, str);
    }

    public void setPolicy2(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPolicy2Native(j, this, str);
    }

    public void setRequestTimeOut(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setRequestTimeOutNative(j2, this, j);
    }

    public void setFlag(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFlagNative(j, this, i);
    }

    public void setSdkVer(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSdkVerNative(j, this, str);
    }

    public void setRouteVer(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRouteVerNative(j, this, str);
    }

    public void setCarType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarTypeNative(j, this, i);
    }

    public void setVehicleCharge(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVehicleChargeNative(j, this, f);
    }

    public void setCarHeight(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarHeightNative(j, this, f);
    }

    public void setCarLoad(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarLoadNative(j, this, f);
    }

    public void setCarWeight(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarWeightNative(j, this, f);
    }

    public void setCarWidth(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarWidthNative(j, this, f);
    }

    public void setCarLength(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarLengthNative(j, this, f);
    }

    public void setCarSize(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarSizeNative(j, this, i);
    }

    public void setRefresh(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRefreshNative(j, this, i);
    }

    public void setContentOption(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setContentOptionNative(j, this, i);
    }

    public void setCarPlate(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarPlateNative(j, this, str);
    }

    public void setUsePoiQuery(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setUsePoiQueryNative(j, this, str);
    }

    public void setReturnFormat(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setReturnFormatNative(j, this, i);
    }

    public void setPlayStyle(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPlayStyleNative(j, this, i);
    }

    public void setSoundType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSoundTypeNative(j, this, i);
    }

    public void setGpsHelter(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setGpsHelterNative(j, this, str);
    }

    public void setThreeD(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setThreeDNative(j, this, i);
    }

    public void setStartLocatePrecision(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartLocatePrecisionNative(j, this, f);
    }

    public void setStartLocateSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartLocateSpeedNative(j, this, i);
    }

    public void setStartAngleCredibility(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartAngleCredibilityNative(j, this, f);
    }

    public void setStartAngleAngle(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartAngleAngleNative(j, this, i);
    }

    public void setStartDirType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartDirTypeNative(j, this, i);
    }

    public void setCompassDir(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCompassDirNative(j, this, f);
    }

    public void setGpsDir(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setGpsDirNative(j, this, f);
    }

    public void setMatchingDir(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMatchingDirNative(j, this, f);
    }

    public void setSigType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSigTypeNative(j, this, i);
    }

    public void setGpsCredibility(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setGpsCredibilityNative(j, this, f);
    }

    public void setRouteMode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRouteModeNative(j, this, i);
    }

    public void setAngleRadius(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAngleRadiusNative(j, this, f);
    }

    public void setInvoker(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setInvokerNative(j, this, str);
    }

    public void setStartTypeCode(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartTypeCodeNative(j, this, str);
    }

    public void setViaTypeCode(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViaTypeCodeNative(j, this, str);
    }

    public void setEndTypeCode(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setEndTypeCodeNative(j, this, str);
    }

    public void addExtraParam(@ExtraRequestParam.ExtraRequestParam1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addExtraParamNative(j, this, i, str);
    }

    public String getExtraParamByFild(@ExtraRequestParam.ExtraRequestParam1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getExtraParamByFildNative(j, this, i);
    }
}
