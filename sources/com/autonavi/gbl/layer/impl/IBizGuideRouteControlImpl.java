package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.common.path.model.RoutePoints;
import com.autonavi.gbl.common.path.model.TrafficJamBubbles;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviOddInfo;
import com.autonavi.gbl.layer.BizGuideRouteControl;
import com.autonavi.gbl.layer.model.BizEnergyKeyInfo;
import com.autonavi.gbl.layer.model.BizGuideETAEventInfo;
import com.autonavi.gbl.layer.model.BizOddInfo;
import com.autonavi.gbl.layer.model.BizPathInfoAttrs;
import com.autonavi.gbl.layer.model.BizRouteRestAreaInfo;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.layer.model.BizRouteViaRoadInfo;
import com.autonavi.gbl.layer.model.BizRouteWeatherInfo;
import com.autonavi.gbl.layer.model.BizThreeUrgentInfo;
import com.autonavi.gbl.layer.model.DynamicLevelParam;
import com.autonavi.gbl.layer.model.DynamicLevelType;
import com.autonavi.gbl.layer.model.ODDDrawMode;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl;
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerStyleType;
import java.util.ArrayList;
@IntfAuto(target = BizGuideRouteControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizGuideRouteControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizGuideRouteControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizGuideRouteControlImpl_SWIGUpcast(long j);

    private static native void addSplicePathRoutePointsInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, long j3, RoutePoints routePoints);

    private static native void clearPathsCacheDataNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void clearPathsCacheStyleNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void clearPathsNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void destroyNativeObj(long j);

    private static native void enableArrowGrownNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void enableArrowWipeNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void enableDrawPathTMCNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void enableFamiliarRouteNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void enableOddAnimationNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z, long j2, AnimationStyleParam animationStyleParam);

    private static native void enablePathGrownNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z, int i, int i2);

    private static native void enableRoutePathNumberNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native boolean getDynamicLevelLock1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native boolean getDynamicLevelLockNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native float getDynamicLevelMapHeadDegree1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native float getDynamicLevelMapHeadDegreeNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native float getDynamicLevelNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i, boolean z);

    private static native boolean getDynamicLevelParamNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, DynamicLevelParam dynamicLevelParam);

    private static native int getOnePathBoundNative(long j, PathInfo pathInfo, long j2, RectDouble rectDouble);

    private static native void getPathArrowPreviewCenterNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i, long j2, Coord3DDouble coord3DDouble);

    private static native int getPathPointsBoundNative(long j, RoutePoints routePoints, long j2, RectDouble rectDouble);

    private static native int getPathResultBoundNative(long[] jArr, long j, RectDouble rectDouble);

    private static native void getPathSegPreviewPointNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i, long j2, Coord3DDouble coord3DDouble);

    private static native long getRouteLayerNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native boolean getRoutePathLayersNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<RoutePathLayerImpl> arrayList);

    private static native int getSelectedPathIndexNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void initDynamicLevelNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, DynamicLevelParam dynamicLevelParam);

    private static native void moveToPathSegmentNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native void onUpdateNaviOddInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, NaviOddInfo naviOddInfo);

    private static native void openDynamicCenterNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void openDynamicLevel1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void openDynamicLevelNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z, int i);

    private static native void resetDynamicCenterNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void resetDynamicLevel1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void resetDynamicLevelNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native void setCompareRouteModeNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native boolean setCurPathIdNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2);

    private static native void setDynamicLevelCustomCalculator1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl);

    private static native void setDynamicLevelCustomCalculatorNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, int i);

    private static native void setDynamicLevelLock1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void setDynamicLevelLockNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z, int i);

    private static native void setFamiliarRouteNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, PathInfo pathInfo);

    private static native void setGrownAnimInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i, int i2);

    private static native void setODDDrawModeNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native void setOddDisplayScaleNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, LayerScale layerScale);

    private static native void setParkFloorNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i, int i2);

    private static native void setParkingPathInfosNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizPathInfoAttrs> arrayList, int i);

    private static native void setPassGreyModeNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void setPathArrowSegmentNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<Long> arrayList);

    private static native void setPathDrawStyleNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RouteDrawStyle routeDrawStyle);

    private static native void setPathInfosNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizPathInfoAttrs> arrayList, int i);

    private static native void setPathPointsNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RoutePoints routePoints);

    private static native boolean setSelectedPathIndexNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native void setThreeUrgentDrawRectNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RectDouble rectDouble);

    private static native void setViaPassGreyModeNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, boolean z);

    private static native void showViaETAByIndexNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native boolean switchSelectedPathNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native boolean updateDynamicLevelNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, DynamicLevelParam dynamicLevelParam);

    private static native void updateEnergyKeyInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizEnergyKeyInfo> arrayList);

    private static native void updateGuideCongestionBoard1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void updateGuideCongestionBoardNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, NaviCongestionInfo naviCongestionInfo);

    private static native void updateGuideETAEventNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, BizGuideETAEventInfo bizGuideETAEventInfo);

    private static native void updateGuideFamiliarRoutePreviewRectNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RectInt rectInt);

    private static native void updateGuideLabelPreviewRectNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RectInt rectInt);

    private static native void updateNaviInfo1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<NaviInfo> arrayList);

    private static native void updateNaviInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<NaviInfo> arrayList, int i);

    private static native void updateOddInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizOddInfo> arrayList);

    private static native void updatePathArrowNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native void updatePathTMCPreviewRectNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RectInt rectInt);

    private static native void updatePathsNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl);

    private static native boolean updatePathsStyleWidth1Native(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i, int i2);

    private static native boolean updatePathsStyleWidthNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native void updateRouteDodgeLineNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, int i);

    private static native void updateRouteJamBubblesNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<TrafficJamBubbles> arrayList);

    private static native void updateRouteJamBubblesPreviewRectNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RectInt rectInt);

    private static native void updateRoutePathNumberPreviewRectNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RectInt rectInt);

    private static native void updateRouteRestAreaInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizRouteRestAreaInfo> arrayList);

    private static native void updateRouteViaRoadInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizRouteViaRoadInfo> arrayList);

    private static native void updateRouteWeatherInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizRouteWeatherInfo> arrayList);

    private static native void updateThreeUrgentInfoNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<BizThreeUrgentInfo> arrayList);

    private static native void updateTmcLightBarNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, ArrayList<LightBarInfo> arrayList);

    private static native void updateViaETAPreviewRectNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2, RectInt rectInt);

    private static native void updateViaPassIndexNative(long j, IBizGuideRouteControlImpl iBizGuideRouteControlImpl, long j2);

    public IBizGuideRouteControlImpl(long j, boolean z) {
        super(IBizGuideRouteControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizGuideRouteControlImpl) {
            return getUID(this) == getUID((IBizGuideRouteControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizGuideRouteControlImpl iBizGuideRouteControlImpl) {
        long cPtr = getCPtr(iBizGuideRouteControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizGuideRouteControlImpl iBizGuideRouteControlImpl) {
        if (iBizGuideRouteControlImpl == null) {
            return 0L;
        }
        return iBizGuideRouteControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public static RectDouble getOnePathBound(PathInfo pathInfo) {
        RectDouble rectDouble = new RectDouble();
        if (Integer.valueOf(getOnePathBound(pathInfo, rectDouble)).intValue() == 0) {
            return rectDouble;
        }
        return null;
    }

    private static int getOnePathBound(PathInfo pathInfo, RectDouble rectDouble) {
        return getOnePathBoundNative(PathInfo.getCPtr(pathInfo), pathInfo, 0L, rectDouble);
    }

    public static RectDouble getPathResultBound(ArrayList<PathInfo> arrayList) {
        RectDouble rectDouble = new RectDouble();
        if (Integer.valueOf(getPathResultBound(arrayList, rectDouble)).intValue() == 0) {
            return rectDouble;
        }
        return null;
    }

    private static int getPathResultBound(ArrayList<PathInfo> arrayList, RectDouble rectDouble) {
        long[] jArr;
        if (arrayList != null) {
            int size = arrayList.size();
            jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = PathInfo.getCPtr(arrayList.get(i));
            }
        } else {
            jArr = null;
        }
        return getPathResultBoundNative(jArr, 0L, rectDouble);
    }

    public static RectDouble getPathPointsBound(RoutePoints routePoints) {
        RectDouble rectDouble = new RectDouble();
        if (Integer.valueOf(getPathPointsBound(routePoints, rectDouble)).intValue() == 0) {
            return rectDouble;
        }
        return null;
    }

    private static int getPathPointsBound(RoutePoints routePoints, RectDouble rectDouble) {
        return getPathPointsBoundNative(0L, routePoints, 0L, rectDouble);
    }

    public void setPathInfos(ArrayList<BizPathInfoAttrs> arrayList, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPathInfosNative(j, this, arrayList, i);
    }

    public void setParkingPathInfos(ArrayList<BizPathInfoAttrs> arrayList, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setParkingPathInfosNative(j, this, arrayList, i);
    }

    public void addSplicePathRoutePointsInfo(long j, RoutePoints routePoints) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        addSplicePathRoutePointsInfoNative(j2, this, j, 0L, routePoints);
    }

    public void setPathPoints(RoutePoints routePoints) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPathPointsNative(j, this, 0L, routePoints);
    }

    public void setPathDrawStyle(RouteDrawStyle routeDrawStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPathDrawStyleNative(j, this, 0L, routeDrawStyle);
    }

    public boolean setSelectedPathIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSelectedPathIndexNative(j, this, i);
    }

    public int getSelectedPathIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSelectedPathIndexNative(j, this);
    }

    public boolean switchSelectedPath(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return switchSelectedPathNative(j, this, i);
    }

    public boolean setCurPathId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setCurPathIdNative(j2, this, j);
    }

    public void setParkFloor(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setParkFloorNative(j, this, i, i2);
    }

    public void updatePaths() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePathsNative(j, this);
    }

    public void clearPaths() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearPathsNative(j, this);
    }

    public void clearPathsCacheData() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearPathsCacheDataNative(j, this);
    }

    public void clearPathsCacheStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearPathsCacheStyleNative(j, this);
    }

    public boolean updatePathsStyleWidth(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updatePathsStyleWidthNative(j, this, i);
    }

    public boolean updatePathsStyleWidth(int i, @RouteLayerStyleType.RouteLayerStyleType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updatePathsStyleWidth1Native(j, this, i, i2);
    }

    public void updateTmcLightBar(ArrayList<LightBarInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateTmcLightBarNative(j, this, arrayList);
    }

    public void setPathArrowSegment(ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPathArrowSegmentNative(j, this, arrayList);
    }

    public void updatePathArrow() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePathArrowNative(j, this);
    }

    public Coord3DDouble getPathArrowPreviewCenter(int i) {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getPathArrowPreviewCenter(i, coord3DDouble);
        return coord3DDouble;
    }

    private void getPathArrowPreviewCenter(int i, Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getPathArrowPreviewCenterNative(j, this, i, 0L, coord3DDouble);
    }

    public Coord3DDouble getPathSegPreviewPoint(int i) {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        getPathSegPreviewPoint(i, coord3DDouble);
        return coord3DDouble;
    }

    private void getPathSegPreviewPoint(int i, Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getPathSegPreviewPointNative(j, this, i, 0L, coord3DDouble);
    }

    public void moveToPathSegment(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        moveToPathSegmentNative(j, this, i);
    }

    public void updateRouteWeatherInfo(ArrayList<BizRouteWeatherInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteWeatherInfoNative(j, this, arrayList);
    }

    public void updateRouteRestAreaInfo(ArrayList<BizRouteRestAreaInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteRestAreaInfoNative(j, this, arrayList);
    }

    public void updateRouteViaRoadInfo(ArrayList<BizRouteViaRoadInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteViaRoadInfoNative(j, this, arrayList);
    }

    public void updateRouteDodgeLine(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteDodgeLineNative(j, this, i);
    }

    public void updateEnergyKeyInfo(ArrayList<BizEnergyKeyInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateEnergyKeyInfoNative(j, this, arrayList);
    }

    public void updateThreeUrgentInfo(ArrayList<BizThreeUrgentInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateThreeUrgentInfoNative(j, this, arrayList);
    }

    public void setThreeUrgentDrawRect(RectDouble rectDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setThreeUrgentDrawRectNative(j, this, 0L, rectDouble);
    }

    public void setODDDrawMode(@ODDDrawMode.ODDDrawMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setODDDrawModeNative(j, this, i);
    }

    public void updateOddInfo(ArrayList<BizOddInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateOddInfoNative(j, this, arrayList);
    }

    public void onUpdateNaviOddInfo(NaviOddInfo naviOddInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateNaviOddInfoNative(j, this, 0L, naviOddInfo);
    }

    public void showViaETAByIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showViaETAByIndexNative(j, this, i);
    }

    public void updateViaETAPreviewRect(RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateViaETAPreviewRectNative(j, this, 0L, rectInt);
    }

    public void updateGuideLabelPreviewRect(RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideLabelPreviewRectNative(j, this, 0L, rectInt);
    }

    public void setFamiliarRoute(PathInfo pathInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setFamiliarRouteNative(j, this, PathInfo.getCPtr(pathInfo), pathInfo);
    }

    public void updateGuideFamiliarRoutePreviewRect(RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideFamiliarRoutePreviewRectNative(j, this, 0L, rectInt);
    }

    public void enableFamiliarRoute(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableFamiliarRouteNative(j, this, z);
    }

    public ArrayList<RoutePathLayerImpl> getRoutePathLayers() {
        ArrayList<RoutePathLayerImpl> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getRoutePathLayers(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getRoutePathLayers(ArrayList<RoutePathLayerImpl> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoutePathLayersNative(j, this, arrayList);
    }

    public BaseLayerImpl getRouteLayer(@BizRouteType.BizRouteType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long routeLayerNative = getRouteLayerNative(j, this, i);
        if (routeLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(routeLayerNative, false);
    }

    public void updatePathTMCPreviewRect(RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePathTMCPreviewRectNative(j, this, 0L, rectInt);
    }

    public void enableDrawPathTMC(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableDrawPathTMCNative(j, this, z);
    }

    public void updateRoutePathNumberPreviewRect(RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRoutePathNumberPreviewRectNative(j, this, 0L, rectInt);
    }

    public void enableRoutePathNumber(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableRoutePathNumberNative(j, this, z);
    }

    public void enablePathGrown(boolean z, int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enablePathGrownNative(j, this, z, i, i2);
    }

    public void enableArrowGrown(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableArrowGrownNative(j, this, z);
    }

    public void enableArrowWipe(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableArrowWipeNative(j, this, z);
    }

    public void setGrownAnimInfo(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setGrownAnimInfoNative(j, this, i, i2);
    }

    public void enableOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableOddAnimationNative(j, this, z, 0L, animationStyleParam);
    }

    public void setOddDisplayScale(LayerScale layerScale) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOddDisplayScaleNative(j, this, 0L, layerScale);
    }

    public void updateNaviInfo(ArrayList<NaviInfo> arrayList, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNaviInfoNative(j, this, arrayList, i);
    }

    public void updateNaviInfo(ArrayList<NaviInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNaviInfo1Native(j, this, arrayList);
    }

    public void setPassGreyMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPassGreyModeNative(j, this, z);
    }

    public void setCompareRouteMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCompareRouteModeNative(j, this, z);
    }

    public void initDynamicLevel(DynamicLevelParam dynamicLevelParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        initDynamicLevelNative(j, this, 0L, dynamicLevelParam);
    }

    public DynamicLevelParam getDynamicLevelParam() {
        DynamicLevelParam dynamicLevelParam = new DynamicLevelParam();
        if (Boolean.valueOf(getDynamicLevelParam(dynamicLevelParam)).booleanValue()) {
            return dynamicLevelParam;
        }
        return null;
    }

    private boolean getDynamicLevelParam(DynamicLevelParam dynamicLevelParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDynamicLevelParamNative(j, this, 0L, dynamicLevelParam);
    }

    public boolean updateDynamicLevel(DynamicLevelParam dynamicLevelParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateDynamicLevelNative(j, this, 0L, dynamicLevelParam);
    }

    public void openDynamicLevel(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openDynamicLevelNative(j, this, z, i);
    }

    public void openDynamicLevel(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openDynamicLevel1Native(j, this, z);
    }

    public void resetDynamicLevel(@DynamicLevelType.DynamicLevelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetDynamicLevelNative(j, this, i);
    }

    public void resetDynamicLevel() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetDynamicLevel1Native(j, this);
    }

    public void openDynamicCenter(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openDynamicCenterNative(j, this, z);
    }

    public void resetDynamicCenter() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetDynamicCenterNative(j, this);
    }

    public float getDynamicLevel(@DynamicLevelType.DynamicLevelType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDynamicLevelNative(j, this, i, z);
    }

    public float getDynamicLevelMapHeadDegree(@DynamicLevelType.DynamicLevelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDynamicLevelMapHeadDegreeNative(j, this, i);
    }

    public float getDynamicLevelMapHeadDegree() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDynamicLevelMapHeadDegree1Native(j, this);
    }

    public boolean getDynamicLevelLock(@DynamicLevelType.DynamicLevelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDynamicLevelLockNative(j, this, i);
    }

    public boolean getDynamicLevelLock() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDynamicLevelLock1Native(j, this);
    }

    public void setDynamicLevelLock(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDynamicLevelLockNative(j, this, z, i);
    }

    public void setDynamicLevelLock(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDynamicLevelLock1Native(j, this, z);
    }

    public void setDynamicLevelCustomCalculator(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, @DynamicLevelType.DynamicLevelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDynamicLevelCustomCalculatorNative(j, this, DynamicLevelCustomCalculatorImpl.getCPtr(dynamicLevelCustomCalculatorImpl), dynamicLevelCustomCalculatorImpl, i);
    }

    public void setDynamicLevelCustomCalculator(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDynamicLevelCustomCalculator1Native(j, this, DynamicLevelCustomCalculatorImpl.getCPtr(dynamicLevelCustomCalculatorImpl), dynamicLevelCustomCalculatorImpl);
    }

    public void updateGuideETAEvent(BizGuideETAEventInfo bizGuideETAEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideETAEventNative(j, this, 0L, bizGuideETAEventInfo);
    }

    public void updateGuideCongestionBoard(NaviCongestionInfo naviCongestionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideCongestionBoardNative(j, this, 0L, naviCongestionInfo);
    }

    public void updateGuideCongestionBoard() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideCongestionBoard1Native(j, this);
    }

    public void updateRouteJamBubbles(ArrayList<TrafficJamBubbles> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteJamBubblesNative(j, this, arrayList);
    }

    public void updateRouteJamBubblesPreviewRect(RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteJamBubblesPreviewRectNative(j, this, 0L, rectInt);
    }

    public void updateViaPassIndex(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        updateViaPassIndexNative(j2, this, j);
    }

    public void setViaPassGreyMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViaPassGreyModeNative(j, this, z);
    }
}
