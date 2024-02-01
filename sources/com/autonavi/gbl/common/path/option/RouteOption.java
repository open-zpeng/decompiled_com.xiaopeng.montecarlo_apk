package com.autonavi.gbl.common.path.option;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.AvoidJamArea;
import com.autonavi.gbl.common.path.model.AvoidRestrictArea;
import com.autonavi.gbl.common.path.model.DispatchInfo;
import com.autonavi.gbl.common.path.model.ForbiddenInfo;
import com.autonavi.gbl.common.path.model.RoadClosedArea;
import com.autonavi.gbl.common.path.option.CalcRouteRespType;
import com.autonavi.gbl.common.path.option.ParalleType;
import com.autonavi.gbl.common.path.option.RouteStrategy;
import com.autonavi.gbl.common.path.option.RouteType;
import com.autonavi.gbl.common.path.option.impl.IPOIForRequestImpl;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IRouteOptionImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class RouteOption {
    private static String PACKAGE = ReflexTool.PN(RouteOption.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IRouteOptionImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected RouteOption(long j, boolean z) {
        this(new IRouteOptionImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(RouteOption.class, this, this.mControl);
        }
    }

    public RouteOption(IRouteOptionImpl iRouteOptionImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iRouteOptionImpl);
    }

    private void $constructor(IRouteOptionImpl iRouteOptionImpl) {
        if (iRouteOptionImpl != null) {
            this.mControl = iRouteOptionImpl;
            this.mTargetId = String.format("RouteOption_%s_%d", String.valueOf(IRouteOptionImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IRouteOptionImpl getControl() {
        return this.mControl;
    }

    public static RouteOption create() {
        TypeHelper typeHelper;
        try {
            Method method = RouteOption.class.getMethod("create", new Class[0]);
            IRouteOptionImpl create = IRouteOptionImpl.create();
            if (create == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (RouteOption) typeHelper.transfer(method, -1, (Object) create, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static RouteOption create(long j) {
        TypeHelper typeHelper;
        try {
            Method method = RouteOption.class.getMethod("create", Long.TYPE);
            IRouteOptionImpl create = IRouteOptionImpl.create(j);
            if (create == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (RouteOption) typeHelper.transfer(method, -1, (Object) create, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static void destroy(RouteOption routeOption) {
        TypeHelper typeHelper;
        try {
            Method method = RouteOption.class.getMethod("destroy", RouteOption.class);
            IRouteOptionImpl iRouteOptionImpl = null;
            if (routeOption != null && (typeHelper = gTypeHelper) != null) {
                iRouteOptionImpl = (IRouteOptionImpl) typeHelper.transfer(method, 0, routeOption);
            }
            if (iRouteOptionImpl != null) {
                IRouteOptionImpl.destroy(iRouteOptionImpl);
                routeOption.delete();
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public long getRouteReqId() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getRouteReqId();
        }
        return 0L;
    }

    public void setRouteReqId(long j) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setRouteReqId(j);
        }
    }

    @RouteType.RouteType1
    public int getRouteType() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getRouteType();
        }
        return Integer.MIN_VALUE;
    }

    public boolean setRouteType(@RouteType.RouteType1 int i) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setRouteType(i);
        }
        return false;
    }

    @RouteStrategy.RouteStrategy1
    public int getRouteStrategy() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getRouteStrategy();
        }
        return Integer.MIN_VALUE;
    }

    public boolean setRouteStrategy(@RouteStrategy.RouteStrategy1 int i) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setRouteStrategy(i);
        }
        return false;
    }

    public int getConstrainCode() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getConstrainCode();
        }
        return 0;
    }

    public boolean setConstrainCode(int i) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setConstrainCode(i);
        }
        return false;
    }

    public long getRouteCalcNumber() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getRouteCalcNumber();
        }
        return 0L;
    }

    public void setRouteCalcNumber(long j) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setRouteCalcNumber(j);
        }
    }

    public boolean setCurrentLocation(CurrentPositionInfo currentPositionInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setCurrentLocation(currentPositionInfo);
        }
        return false;
    }

    public CurrentPositionInfo getCurrentLocation() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getCurrentLocation();
        }
        return null;
    }

    public boolean setRemainNaviInfo(CurrentNaviInfo currentNaviInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setRemainNaviInfo(currentNaviInfo);
        }
        return false;
    }

    public CurrentNaviInfo getRemainNaviInfo() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getRemainNaviInfo();
        }
        return null;
    }

    public boolean setNaviPath(PathInfo pathInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setNaviPath(pathInfo);
        }
        return false;
    }

    public PathInfo getNaviPath() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getNaviPath();
        }
        return null;
    }

    public POIForRequest getPOIForRequest() {
        IPOIForRequestImpl pOIForRequest;
        TypeHelper typeHelper;
        try {
            Method method = RouteOption.class.getMethod("getPOIForRequest", new Class[0]);
            IRouteOptionImpl iRouteOptionImpl = this.mControl;
            if (iRouteOptionImpl == null || (pOIForRequest = iRouteOptionImpl.getPOIForRequest()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (POIForRequest) typeHelper.transfer(method, -1, (Object) pOIForRequest, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean setPOIForRequest(POIForRequest pOIForRequest) {
        TypeHelper typeHelper;
        try {
            Method method = RouteOption.class.getMethod("setPOIForRequest", POIForRequest.class);
            IPOIForRequestImpl iPOIForRequestImpl = null;
            if (pOIForRequest != null && (typeHelper = this.mTypeHelper) != null) {
                iPOIForRequestImpl = (IPOIForRequestImpl) typeHelper.transfer(method, 0, pOIForRequest);
            }
            IRouteOptionImpl iRouteOptionImpl = this.mControl;
            if (iRouteOptionImpl != null) {
                return iRouteOptionImpl.setPOIForRequest(iPOIForRequestImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public int[] getPOIIndex() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getPOIIndex();
        }
        return null;
    }

    public boolean setPOIIndex(ArrayList<Integer> arrayList) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setPOIIndex(arrayList);
        }
        return false;
    }

    public boolean setLimitLinkInfo(LimitLinkInfo limitLinkInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setLimitLinkInfo(limitLinkInfo);
        }
        return false;
    }

    public LimitLinkInfo getLimitLinkInfo() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getLimitLinkInfo();
        }
        return null;
    }

    public boolean setRerouteInfo(RerouteInfo rerouteInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setRerouteInfo(rerouteInfo);
        }
        return false;
    }

    public RerouteInfo getRerouteInfo() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getRerouteInfo();
        }
        return null;
    }

    public boolean setAvoidRestrictArea(AvoidRestrictArea avoidRestrictArea) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setAvoidRestrictArea(avoidRestrictArea);
        }
        return false;
    }

    public AvoidRestrictArea getAvoidRestrictArea() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getAvoidRestrictArea();
        }
        return null;
    }

    public boolean setAvoidForbidArea(ForbiddenInfo forbiddenInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setAvoidForbidArea(forbiddenInfo);
        }
        return false;
    }

    public ForbiddenInfo getAvoidForbidArea() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getAvoidForbidArea();
        }
        return null;
    }

    public boolean setRoadClosedArea(RoadClosedArea roadClosedArea) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setRoadClosedArea(roadClosedArea);
        }
        return false;
    }

    public RoadClosedArea getRoadClosedArea() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getRoadClosedArea();
        }
        return null;
    }

    public boolean setAvoidJamArea(AvoidJamArea avoidJamArea) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setAvoidJamArea(avoidJamArea);
        }
        return false;
    }

    public AvoidJamArea getAvoidJamArea() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getAvoidJamArea();
        }
        return null;
    }

    public boolean setDispatchInfo(DispatchInfo dispatchInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setDispatchInfo(dispatchInfo);
        }
        return false;
    }

    public DispatchInfo getDispatchInfo() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getDispatchInfo();
        }
        return null;
    }

    public SelectedPathInfo getSelectedPathInfo() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getSelectedPathInfo();
        }
        return null;
    }

    public boolean setSelectedPathInfo(SelectedPathInfo selectedPathInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setSelectedPathInfo(selectedPathInfo);
        }
        return false;
    }

    public boolean setWalkedDist(long j) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setWalkedDist(j);
        }
        return false;
    }

    public long getWalkedDist() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getWalkedDist();
        }
        return 0L;
    }

    public float getVehicleCharge() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getVehicleCharge();
        }
        return 0.0f;
    }

    public void setVehicleCharge(float f) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setVehicleCharge(f);
        }
    }

    public void setBackupPathIsCannotUturn(boolean z) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setBackupPathIsCannotUturn(z);
        }
    }

    public boolean getBackupPathIsCannotUturn() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getBackupPathIsCannotUturn();
        }
        return false;
    }

    public boolean setAbnormalActionInfo(AbnormalActionInfo abnormalActionInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setAbnormalActionInfo(abnormalActionInfo);
        }
        return false;
    }

    public AbnormalActionInfo getAbnormalActionInfo() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getAbnormalActionInfo();
        }
        return null;
    }

    @ParalleType.ParalleType1
    public int getParalleType() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getParalleType();
        }
        return Integer.MIN_VALUE;
    }

    public boolean setParalleType(@ParalleType.ParalleType1 int i) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setParalleType(i);
        }
        return false;
    }

    public void setUserAvoidInfo(UserAvoidInfo userAvoidInfo) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setUserAvoidInfo(userAvoidInfo);
        }
    }

    public UserAvoidInfo getUserAvoidInfo() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getUserAvoidInfo();
        }
        return null;
    }

    public boolean setSinglePath(boolean z) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setSinglePath(z);
        }
        return false;
    }

    public boolean getSinglePath() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getSinglePath();
        }
        return false;
    }

    public boolean setAstarRoutePlan(boolean z) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setAstarRoutePlan(z);
        }
        return false;
    }

    public boolean getEnableAstar() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getEnableAstar();
        }
        return false;
    }

    public boolean setMutiThreadRoutePlan(boolean z) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setMutiThreadRoutePlan(z);
        }
        return false;
    }

    public boolean getEnableMutiThreadRoutePlan() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getEnableMutiThreadRoutePlan();
        }
        return false;
    }

    public void reset() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.reset();
        }
    }

    public void copy(RouteOption routeOption) {
        TypeHelper typeHelper;
        try {
            Method method = RouteOption.class.getMethod("copy", RouteOption.class);
            IRouteOptionImpl iRouteOptionImpl = null;
            if (routeOption != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteOptionImpl = (IRouteOptionImpl) typeHelper.transfer(method, 0, routeOption);
            }
            IRouteOptionImpl iRouteOptionImpl2 = this.mControl;
            if (iRouteOptionImpl2 != null) {
                iRouteOptionImpl2.copy(iRouteOptionImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setOddFunction(boolean z, boolean z2) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setOddFunction(z, z2);
        }
    }

    public boolean isOddEnabled() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.isOddEnabled();
        }
        return false;
    }

    public boolean isOddMergeResp() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.isOddMergeResp();
        }
        return false;
    }

    public boolean setCalcRouteRespType(@CalcRouteRespType.CalcRouteRespType1 int i) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setCalcRouteRespType(i);
        }
        return false;
    }

    @CalcRouteRespType.CalcRouteRespType1
    public int getCalcRouteRespType() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getCalcRouteRespType();
        }
        return Integer.MIN_VALUE;
    }

    public void setReqOptionSyncToConsis(boolean z) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setReqOptionSyncToConsis(z);
        }
    }

    public boolean isReqOptionSyncToConsis() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.isReqOptionSyncToConsis();
        }
        return false;
    }

    public void setConsisExternData(String str) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setConsisExternData(str);
        }
    }

    public String getConsisExternData() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getConsisExternData();
        }
        return null;
    }

    public void setOfflineReqCustomIdentityId(String str) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setOfflineReqCustomIdentityId(str);
        }
    }

    public String getOfflineReqCustomIdentityId() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getOfflineReqCustomIdentityId();
        }
        return null;
    }

    public void setPriorityType(long j) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setPriorityType(j);
        }
    }

    public long getPriorityType() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getPriorityType();
        }
        return 0L;
    }

    public void setTrySwitchToLocal(boolean z) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            iRouteOptionImpl.setTrySwitchToLocal(z);
        }
    }

    public boolean getTrySwitchToLocal() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getTrySwitchToLocal();
        }
        return false;
    }

    public boolean setAutoRerouteCancel(boolean z) {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.setAutoRerouteCancel(z);
        }
        return false;
    }

    public boolean getAutoRerouteCancel() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getAutoRerouteCancel();
        }
        return false;
    }

    public long getNativeTypeHandle() {
        IRouteOptionImpl iRouteOptionImpl = this.mControl;
        if (iRouteOptionImpl != null) {
            return iRouteOptionImpl.getNativeTypeHandle();
        }
        return 0L;
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
