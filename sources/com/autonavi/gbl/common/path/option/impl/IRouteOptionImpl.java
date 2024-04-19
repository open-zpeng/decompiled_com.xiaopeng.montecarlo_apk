package com.autonavi.gbl.common.path.option.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.AvoidJamArea;
import com.autonavi.gbl.common.path.model.AvoidRestrictArea;
import com.autonavi.gbl.common.path.model.DispatchInfo;
import com.autonavi.gbl.common.path.model.ForbiddenInfo;
import com.autonavi.gbl.common.path.model.RoadClosedArea;
import com.autonavi.gbl.common.path.option.AbnormalActionInfo;
import com.autonavi.gbl.common.path.option.CalcRouteRespType;
import com.autonavi.gbl.common.path.option.CurrentNaviInfo;
import com.autonavi.gbl.common.path.option.CurrentPositionInfo;
import com.autonavi.gbl.common.path.option.LimitLinkInfo;
import com.autonavi.gbl.common.path.option.ParalleType;
import com.autonavi.gbl.common.path.option.RerouteInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.RouteStrategy;
import com.autonavi.gbl.common.path.option.RouteType;
import com.autonavi.gbl.common.path.option.SelectedPathInfo;
import com.autonavi.gbl.common.path.option.UserAvoidInfo;
import java.util.ArrayList;
@IntfAuto(target = RouteOption.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IRouteOptionImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteOptionImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void copyNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, IRouteOptionImpl iRouteOptionImpl2);

    private static native long create1Native(long j);

    private static native long createNative();

    private static native void destroyNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native void destroyNativeObj(long j);

    private static native boolean getAbnormalActionInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, AbnormalActionInfo abnormalActionInfo);

    private static native boolean getAvoidForbidAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, ForbiddenInfo forbiddenInfo);

    private static native boolean getAvoidJamAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, AvoidJamArea avoidJamArea);

    private static native boolean getAvoidRestrictAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, AvoidRestrictArea avoidRestrictArea);

    private static native boolean getBackupPathIsCannotUturnNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native int getCalcRouteRespTypeNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native void getConsisExternDataNative(long j, IRouteOptionImpl iRouteOptionImpl, String[] strArr);

    private static native int getConstrainCodeNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean getCurrentLocationNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, CurrentPositionInfo currentPositionInfo);

    private static native boolean getDispatchInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, DispatchInfo dispatchInfo);

    private static native boolean getEnableAstarNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean getEnableMutiThreadRoutePlanNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean getLimitLinkInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, LimitLinkInfo limitLinkInfo);

    private static native long getNativeTypeHandleNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean getNaviPathNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, PathInfoImpl pathInfoImpl);

    private static native void getOfflineReqCustomIdentityIdNative(long j, IRouteOptionImpl iRouteOptionImpl, String[] strArr);

    private static native long getPOIForRequestNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean getPOIIndexNative(long j, IRouteOptionImpl iRouteOptionImpl, ArrayList<Integer> arrayList);

    private static native int getParalleTypeNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean getRemainNaviInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, CurrentNaviInfo currentNaviInfo);

    private static native boolean getRerouteInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, RerouteInfo rerouteInfo);

    private static native boolean getRoadClosedAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, RoadClosedArea roadClosedArea);

    private static native long getRouteCalcNumberNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native long getRouteReqIdNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native int getRouteStrategyNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native int getRouteTypeNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean getSelectedPathInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, SelectedPathInfo selectedPathInfo);

    private static native boolean getSinglePathNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native UserAvoidInfo getUserAvoidInfoNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native float getVehicleChargeNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native long getWalkedDistNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean isOddEnabledNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean isOddMergeRespNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean isReqOptionSyncToConsisNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native void resetNative(long j, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean setAbnormalActionInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, AbnormalActionInfo abnormalActionInfo);

    private static native boolean setAstarRoutePlanNative(long j, IRouteOptionImpl iRouteOptionImpl, boolean z);

    private static native boolean setAvoidForbidAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, ForbiddenInfo forbiddenInfo);

    private static native boolean setAvoidJamAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, AvoidJamArea avoidJamArea);

    private static native boolean setAvoidRestrictAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, AvoidRestrictArea avoidRestrictArea);

    private static native void setBackupPathIsCannotUturnNative(long j, IRouteOptionImpl iRouteOptionImpl, boolean z);

    private static native boolean setCalcRouteRespTypeNative(long j, IRouteOptionImpl iRouteOptionImpl, int i);

    private static native void setConsisExternDataNative(long j, IRouteOptionImpl iRouteOptionImpl, String str);

    private static native boolean setConstrainCodeNative(long j, IRouteOptionImpl iRouteOptionImpl, int i);

    private static native boolean setCurrentLocationNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, CurrentPositionInfo currentPositionInfo);

    private static native boolean setDispatchInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, DispatchInfo dispatchInfo);

    private static native boolean setLimitLinkInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, LimitLinkInfo limitLinkInfo);

    private static native boolean setMutiThreadRoutePlanNative(long j, IRouteOptionImpl iRouteOptionImpl, boolean z);

    private static native boolean setNaviPathNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, PathInfoImpl pathInfoImpl);

    private static native void setOddFunctionNative(long j, IRouteOptionImpl iRouteOptionImpl, boolean z, boolean z2);

    private static native void setOfflineReqCustomIdentityIdNative(long j, IRouteOptionImpl iRouteOptionImpl, String str);

    private static native boolean setPOIForRequestNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, IPOIForRequestImpl iPOIForRequestImpl);

    private static native boolean setPOIIndexNative(long j, IRouteOptionImpl iRouteOptionImpl, ArrayList<Integer> arrayList);

    private static native boolean setParalleTypeNative(long j, IRouteOptionImpl iRouteOptionImpl, int i);

    private static native boolean setRemainNaviInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, CurrentNaviInfo currentNaviInfo);

    private static native void setReqOptionSyncToConsisNative(long j, IRouteOptionImpl iRouteOptionImpl, boolean z);

    private static native boolean setRerouteInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, RerouteInfo rerouteInfo);

    private static native boolean setRoadClosedAreaNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, RoadClosedArea roadClosedArea);

    private static native void setRouteCalcNumberNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2);

    private static native void setRouteReqIdNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2);

    private static native boolean setRouteStrategyNative(long j, IRouteOptionImpl iRouteOptionImpl, int i);

    private static native boolean setRouteTypeNative(long j, IRouteOptionImpl iRouteOptionImpl, int i);

    private static native boolean setSelectedPathInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, SelectedPathInfo selectedPathInfo);

    private static native boolean setSinglePathNative(long j, IRouteOptionImpl iRouteOptionImpl, boolean z);

    private static native void setUserAvoidInfoNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2, UserAvoidInfo userAvoidInfo);

    private static native void setVehicleChargeNative(long j, IRouteOptionImpl iRouteOptionImpl, float f);

    private static native boolean setWalkedDistNative(long j, IRouteOptionImpl iRouteOptionImpl, long j2);

    public IRouteOptionImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteOptionImpl) && getUID(this) == getUID((IRouteOptionImpl) obj);
    }

    private static long getUID(IRouteOptionImpl iRouteOptionImpl) {
        long cPtr = getCPtr(iRouteOptionImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteOptionImpl iRouteOptionImpl) {
        if (iRouteOptionImpl == null) {
            return 0L;
        }
        return iRouteOptionImpl.swigCPtr;
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

    public CurrentPositionInfo getCurrentLocation() {
        CurrentPositionInfo currentPositionInfo = new CurrentPositionInfo();
        if (getCurrentLocation(currentPositionInfo)) {
            return currentPositionInfo;
        }
        return null;
    }

    public CurrentNaviInfo getRemainNaviInfo() {
        CurrentNaviInfo currentNaviInfo = new CurrentNaviInfo();
        if (getRemainNaviInfo(currentNaviInfo)) {
            return currentNaviInfo;
        }
        return null;
    }

    public LimitLinkInfo getLimitLinkInfo() {
        LimitLinkInfo limitLinkInfo = new LimitLinkInfo();
        if (getLimitLinkInfo(limitLinkInfo)) {
            return limitLinkInfo;
        }
        return null;
    }

    public RerouteInfo getRerouteInfo() {
        RerouteInfo rerouteInfo = new RerouteInfo();
        if (getRerouteInfo(rerouteInfo)) {
            return rerouteInfo;
        }
        return null;
    }

    public PathInfoImpl getNaviPath() {
        PathInfoImpl pathInfoImpl = new PathInfoImpl();
        if (getNaviPath(pathInfoImpl)) {
            return pathInfoImpl;
        }
        return null;
    }

    public AvoidRestrictArea getAvoidRestrictArea() {
        AvoidRestrictArea avoidRestrictArea = new AvoidRestrictArea();
        if (getAvoidRestrictArea(avoidRestrictArea)) {
            return avoidRestrictArea;
        }
        return null;
    }

    public ForbiddenInfo getAvoidForbidArea() {
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        if (getAvoidForbidArea(forbiddenInfo)) {
            return forbiddenInfo;
        }
        return null;
    }

    public RoadClosedArea getRoadClosedArea() {
        RoadClosedArea roadClosedArea = new RoadClosedArea();
        if (getRoadClosedArea(roadClosedArea)) {
            return roadClosedArea;
        }
        return null;
    }

    public AvoidJamArea getAvoidJamArea() {
        AvoidJamArea avoidJamArea = new AvoidJamArea();
        if (getAvoidJamArea(avoidJamArea)) {
            return avoidJamArea;
        }
        return null;
    }

    public int[] getPOIIndex() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!getPOIIndex(arrayList) || arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        return iArr;
    }

    public SelectedPathInfo getSelectedPathInfo() {
        SelectedPathInfo selectedPathInfo = new SelectedPathInfo();
        if (getSelectedPathInfo(selectedPathInfo)) {
            return selectedPathInfo;
        }
        return null;
    }

    public DispatchInfo getDispatchInfo() {
        DispatchInfo dispatchInfo = new DispatchInfo();
        if (getDispatchInfo(dispatchInfo)) {
            return dispatchInfo;
        }
        return null;
    }

    public AbnormalActionInfo getAbnormalActionInfo() {
        AbnormalActionInfo abnormalActionInfo = new AbnormalActionInfo();
        if (getAbnormalActionInfo(abnormalActionInfo)) {
            return abnormalActionInfo;
        }
        return null;
    }

    public String getConsisExternData() {
        String[] strArr = new String[1];
        getConsisExternData(strArr);
        return strArr[0];
    }

    public String getOfflineReqCustomIdentityId() {
        String[] strArr = new String[1];
        getOfflineReqCustomIdentityId(strArr);
        return strArr[0];
    }

    public static IRouteOptionImpl create() {
        long createNative = createNative();
        if (createNative == 0) {
            return null;
        }
        return new IRouteOptionImpl(createNative, false);
    }

    public static IRouteOptionImpl create(long j) {
        long create1Native = create1Native(j);
        if (create1Native == 0) {
            return null;
        }
        return new IRouteOptionImpl(create1Native, false);
    }

    public static void destroy(IRouteOptionImpl iRouteOptionImpl) {
        destroyNative(getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    public long getRouteReqId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRouteReqIdNative(j, this);
    }

    public void setRouteReqId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setRouteReqIdNative(j2, this, j);
    }

    @RouteType.RouteType1
    public int getRouteType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRouteTypeNative(j, this);
    }

    public boolean setRouteType(@RouteType.RouteType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRouteTypeNative(j, this, i);
    }

    @RouteStrategy.RouteStrategy1
    public int getRouteStrategy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRouteStrategyNative(j, this);
    }

    public boolean setRouteStrategy(@RouteStrategy.RouteStrategy1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRouteStrategyNative(j, this, i);
    }

    public int getConstrainCode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getConstrainCodeNative(j, this);
    }

    public boolean setConstrainCode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setConstrainCodeNative(j, this, i);
    }

    public long getRouteCalcNumber() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRouteCalcNumberNative(j, this);
    }

    public void setRouteCalcNumber(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setRouteCalcNumberNative(j2, this, j);
    }

    public boolean setCurrentLocation(CurrentPositionInfo currentPositionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCurrentLocationNative(j, this, 0L, currentPositionInfo);
    }

    private boolean getCurrentLocation(CurrentPositionInfo currentPositionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCurrentLocationNative(j, this, 0L, currentPositionInfo);
    }

    public boolean setRemainNaviInfo(CurrentNaviInfo currentNaviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRemainNaviInfoNative(j, this, 0L, currentNaviInfo);
    }

    private boolean getRemainNaviInfo(CurrentNaviInfo currentNaviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRemainNaviInfoNative(j, this, 0L, currentNaviInfo);
    }

    public boolean setNaviPath(PathInfoImpl pathInfoImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setNaviPathNative(j, this, PathInfoImpl.getCPtr(pathInfoImpl), pathInfoImpl);
    }

    private boolean getNaviPath(PathInfoImpl pathInfoImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNaviPathNative(j, this, PathInfoImpl.getCPtr(pathInfoImpl), pathInfoImpl);
    }

    public IPOIForRequestImpl getPOIForRequest() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long pOIForRequestNative = getPOIForRequestNative(j, this);
        if (pOIForRequestNative == 0) {
            return null;
        }
        return new IPOIForRequestImpl(pOIForRequestNative, false);
    }

    public boolean setPOIForRequest(IPOIForRequestImpl iPOIForRequestImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPOIForRequestNative(j, this, IPOIForRequestImpl.getCPtr(iPOIForRequestImpl), iPOIForRequestImpl);
    }

    private boolean getPOIIndex(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPOIIndexNative(j, this, arrayList);
    }

    public boolean setPOIIndex(ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPOIIndexNative(j, this, arrayList);
    }

    public boolean setLimitLinkInfo(LimitLinkInfo limitLinkInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLimitLinkInfoNative(j, this, 0L, limitLinkInfo);
    }

    private boolean getLimitLinkInfo(LimitLinkInfo limitLinkInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLimitLinkInfoNative(j, this, 0L, limitLinkInfo);
    }

    public boolean setRerouteInfo(RerouteInfo rerouteInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRerouteInfoNative(j, this, 0L, rerouteInfo);
    }

    private boolean getRerouteInfo(RerouteInfo rerouteInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRerouteInfoNative(j, this, 0L, rerouteInfo);
    }

    public boolean setAvoidRestrictArea(AvoidRestrictArea avoidRestrictArea) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAvoidRestrictAreaNative(j, this, 0L, avoidRestrictArea);
    }

    private boolean getAvoidRestrictArea(AvoidRestrictArea avoidRestrictArea) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAvoidRestrictAreaNative(j, this, 0L, avoidRestrictArea);
    }

    public boolean setAvoidForbidArea(ForbiddenInfo forbiddenInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAvoidForbidAreaNative(j, this, 0L, forbiddenInfo);
    }

    private boolean getAvoidForbidArea(ForbiddenInfo forbiddenInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAvoidForbidAreaNative(j, this, 0L, forbiddenInfo);
    }

    public boolean setRoadClosedArea(RoadClosedArea roadClosedArea) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRoadClosedAreaNative(j, this, 0L, roadClosedArea);
    }

    private boolean getRoadClosedArea(RoadClosedArea roadClosedArea) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadClosedAreaNative(j, this, 0L, roadClosedArea);
    }

    public boolean setAvoidJamArea(AvoidJamArea avoidJamArea) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAvoidJamAreaNative(j, this, 0L, avoidJamArea);
    }

    private boolean getAvoidJamArea(AvoidJamArea avoidJamArea) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAvoidJamAreaNative(j, this, 0L, avoidJamArea);
    }

    public boolean setDispatchInfo(DispatchInfo dispatchInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDispatchInfoNative(j, this, 0L, dispatchInfo);
    }

    private boolean getDispatchInfo(DispatchInfo dispatchInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDispatchInfoNative(j, this, 0L, dispatchInfo);
    }

    private boolean getSelectedPathInfo(SelectedPathInfo selectedPathInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSelectedPathInfoNative(j, this, 0L, selectedPathInfo);
    }

    public boolean setSelectedPathInfo(SelectedPathInfo selectedPathInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSelectedPathInfoNative(j, this, 0L, selectedPathInfo);
    }

    public boolean setWalkedDist(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setWalkedDistNative(j2, this, j);
    }

    public long getWalkedDist() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getWalkedDistNative(j, this);
    }

    public float getVehicleCharge() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVehicleChargeNative(j, this);
    }

    public void setVehicleCharge(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVehicleChargeNative(j, this, f);
    }

    public void setBackupPathIsCannotUturn(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setBackupPathIsCannotUturnNative(j, this, z);
    }

    public boolean getBackupPathIsCannotUturn() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBackupPathIsCannotUturnNative(j, this);
    }

    public boolean setAbnormalActionInfo(AbnormalActionInfo abnormalActionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAbnormalActionInfoNative(j, this, 0L, abnormalActionInfo);
    }

    private boolean getAbnormalActionInfo(AbnormalActionInfo abnormalActionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAbnormalActionInfoNative(j, this, 0L, abnormalActionInfo);
    }

    @ParalleType.ParalleType1
    public int getParalleType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getParalleTypeNative(j, this);
    }

    public boolean setParalleType(@ParalleType.ParalleType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setParalleTypeNative(j, this, i);
    }

    public void setUserAvoidInfo(UserAvoidInfo userAvoidInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setUserAvoidInfoNative(j, this, 0L, userAvoidInfo);
    }

    public UserAvoidInfo getUserAvoidInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUserAvoidInfoNative(j, this);
    }

    public boolean setSinglePath(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSinglePathNative(j, this, z);
    }

    public boolean getSinglePath() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSinglePathNative(j, this);
    }

    public boolean setAstarRoutePlan(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAstarRoutePlanNative(j, this, z);
    }

    public boolean getEnableAstar() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEnableAstarNative(j, this);
    }

    public boolean setMutiThreadRoutePlan(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMutiThreadRoutePlanNative(j, this, z);
    }

    public boolean getEnableMutiThreadRoutePlan() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEnableMutiThreadRoutePlanNative(j, this);
    }

    public void reset() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetNative(j, this);
    }

    public void copy(IRouteOptionImpl iRouteOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        copyNative(j, this, getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    public void setOddFunction(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOddFunctionNative(j, this, z, z2);
    }

    public boolean isOddEnabled() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isOddEnabledNative(j, this);
    }

    public boolean isOddMergeResp() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isOddMergeRespNative(j, this);
    }

    public boolean setCalcRouteRespType(@CalcRouteRespType.CalcRouteRespType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCalcRouteRespTypeNative(j, this, i);
    }

    @CalcRouteRespType.CalcRouteRespType1
    public int getCalcRouteRespType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCalcRouteRespTypeNative(j, this);
    }

    public void setReqOptionSyncToConsis(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setReqOptionSyncToConsisNative(j, this, z);
    }

    public boolean isReqOptionSyncToConsis() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isReqOptionSyncToConsisNative(j, this);
    }

    public void setConsisExternData(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setConsisExternDataNative(j, this, str);
    }

    private void getConsisExternData(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getConsisExternDataNative(j, this, strArr);
    }

    public void setOfflineReqCustomIdentityId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOfflineReqCustomIdentityIdNative(j, this, str);
    }

    private void getOfflineReqCustomIdentityId(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getOfflineReqCustomIdentityIdNative(j, this, strArr);
    }

    public long getNativeTypeHandle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNativeTypeHandleNative(j, this);
    }
}
