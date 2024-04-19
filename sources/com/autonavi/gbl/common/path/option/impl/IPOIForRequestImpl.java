package com.autonavi.gbl.common.path.option.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.PointType;
import com.autonavi.gbl.common.path.option.POIForRequest;
import java.math.BigInteger;
@IntfAuto(target = POIForRequest.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IPOIForRequestImpl {
    private static BindTable BIND_TABLE = new BindTable(IPOIForRequestImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addPointNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i, long j2, POIInfo pOIInfo);

    private static native void clearPointNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i);

    private static native void copyNative(long j, IPOIForRequestImpl iPOIForRequestImpl, long j2, IPOIForRequestImpl iPOIForRequestImpl2);

    private static native long createNative();

    private static native void destroyNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native void destroyNativeObj(long j);

    private static native float fittingCreditNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float fittingDirNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float getAngleCompNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float getAngleGpsNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native int getAngleTypeNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float getDirectionNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native int getFormWayNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native int getLinkTypeNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native long getNativeTypeHandleNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native long getParkingBuildingIDNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native boolean getPointNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i, long j2, long j3, POIInfo pOIInfo);

    private static native long getPointSizeNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i);

    private static native float getReliabilityNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native String getSourceInfoNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float getSpeedNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float gpsCreditNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float matchingDirNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float precisionNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native float radiusNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native void resetNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    private static native void setAngleCompNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setAngleGpsNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setAngleTypeNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i);

    private static native void setDirectionNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setFittingCreditNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setFittingDirNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setFormWayNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i);

    private static native void setGpsCreditNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setLinkTypeNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i);

    private static native void setMatchingDirNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setParkingBuildingIDNative(long j, IPOIForRequestImpl iPOIForRequestImpl, long j2);

    private static native boolean setPointRoadIDNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i, long j2, BigInteger bigInteger);

    private static native void setPrecisionNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setRadiusNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setReliabilityNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native void setSigTypeNative(long j, IPOIForRequestImpl iPOIForRequestImpl, int i);

    private static native void setSourceInfoNative(long j, IPOIForRequestImpl iPOIForRequestImpl, String str);

    private static native void setSpeedNative(long j, IPOIForRequestImpl iPOIForRequestImpl, float f);

    private static native int sigTypeNative(long j, IPOIForRequestImpl iPOIForRequestImpl);

    public IPOIForRequestImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPOIForRequestImpl) && getUID(this) == getUID((IPOIForRequestImpl) obj);
    }

    private static long getUID(IPOIForRequestImpl iPOIForRequestImpl) {
        long cPtr = getCPtr(iPOIForRequestImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPOIForRequestImpl iPOIForRequestImpl) {
        if (iPOIForRequestImpl == null) {
            return 0L;
        }
        return iPOIForRequestImpl.swigCPtr;
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

    public POIInfo getPoint(@PointType.PointType1 int i, long j) {
        POIInfo pOIInfo = new POIInfo();
        if (getPoint(i, j, pOIInfo)) {
            return pOIInfo;
        }
        return null;
    }

    public static IPOIForRequestImpl create() {
        long createNative = createNative();
        if (createNative == 0) {
            return null;
        }
        return new IPOIForRequestImpl(createNative, false);
    }

    public static void destroy(IPOIForRequestImpl iPOIForRequestImpl) {
        destroyNative(getCPtr(iPOIForRequestImpl), iPOIForRequestImpl);
    }

    public void setDirection(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDirectionNative(j, this, f);
    }

    public float getDirection() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDirectionNative(j, this);
    }

    public void setReliability(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setReliabilityNative(j, this, f);
    }

    public float getReliability() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getReliabilityNative(j, this);
    }

    public void setAngleType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAngleTypeNative(j, this, i);
    }

    public int getAngleType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAngleTypeNative(j, this);
    }

    public void setSourceInfo(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSourceInfoNative(j, this, str);
    }

    public String getSourceInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSourceInfoNative(j, this);
    }

    public void setAngleGps(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAngleGpsNative(j, this, f);
    }

    public float getAngleGps() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAngleGpsNative(j, this);
    }

    public void setAngleComp(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAngleCompNative(j, this, f);
    }

    public float getAngleComp() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAngleCompNative(j, this);
    }

    public void setMatchingDir(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMatchingDirNative(j, this, f);
    }

    public float matchingDir() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return matchingDirNative(j, this);
    }

    public void setFittingDir(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFittingDirNative(j, this, f);
    }

    public float fittingDir() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return fittingDirNative(j, this);
    }

    public void setRadius(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRadiusNative(j, this, f);
    }

    public float radius() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return radiusNative(j, this);
    }

    public void setSigType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSigTypeNative(j, this, i);
    }

    public int sigType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sigTypeNative(j, this);
    }

    public void setGpsCredit(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setGpsCreditNative(j, this, f);
    }

    public float gpsCredit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return gpsCreditNative(j, this);
    }

    public void setFittingCredit(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFittingCreditNative(j, this, f);
    }

    public float fittingCredit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return fittingCreditNative(j, this);
    }

    public void setPrecision(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPrecisionNative(j, this, f);
    }

    public float precision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return precisionNative(j, this);
    }

    public void setSpeed(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSpeedNative(j, this, f);
    }

    public float getSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSpeedNative(j, this);
    }

    public void setFormWay(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFormWayNative(j, this, i);
    }

    public int getFormWay() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFormWayNative(j, this);
    }

    public void setLinkType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLinkTypeNative(j, this, i);
    }

    public int getLinkType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLinkTypeNative(j, this);
    }

    public void addPoint(@PointType.PointType1 int i, POIInfo pOIInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addPointNative(j, this, i, 0L, pOIInfo);
    }

    public void clearPoint(@PointType.PointType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearPointNative(j, this, i);
    }

    public long getPointSize(@PointType.PointType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPointSizeNative(j, this, i);
    }

    private boolean getPoint(@PointType.PointType1 int i, long j, POIInfo pOIInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getPointNative(j2, this, i, j, 0L, pOIInfo);
    }

    public boolean setPointRoadID(@PointType.PointType1 int i, long j, BigInteger bigInteger) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setPointRoadIDNative(j2, this, i, j, bigInteger);
    }

    public void reset() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetNative(j, this);
    }

    public long getNativeTypeHandle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNativeTypeHandleNative(j, this);
    }

    public void copy(IPOIForRequestImpl iPOIForRequestImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        copyNative(j, this, getCPtr(iPOIForRequestImpl), iPOIForRequestImpl);
    }

    public void setParkingBuildingID(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setParkingBuildingIDNative(j2, this, j);
    }

    public long getParkingBuildingID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getParkingBuildingIDNative(j, this);
    }
}
