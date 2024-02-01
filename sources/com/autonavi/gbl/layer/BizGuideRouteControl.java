package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
import com.autonavi.gbl.layer.impl.DynamicLevelCustomCalculatorImpl;
import com.autonavi.gbl.layer.impl.IBizGuideRouteControlImpl;
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
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.RoutePathLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl;
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerStyleType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
@IntfAuto(target = IBizGuideRouteControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizGuideRouteControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizGuideRouteControl.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IBizGuideRouteControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizGuideRouteControl(long j, boolean z) {
        this(new IBizGuideRouteControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizGuideRouteControl.class, this, this.mControl);
        }
    }

    public BizGuideRouteControl(IBizGuideRouteControlImpl iBizGuideRouteControlImpl) {
        super(iBizGuideRouteControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizGuideRouteControlImpl);
    }

    private void $constructor(IBizGuideRouteControlImpl iBizGuideRouteControlImpl) {
        if (iBizGuideRouteControlImpl != null) {
            this.mControl = iBizGuideRouteControlImpl;
            this.mTargetId = String.format("BizGuideRouteControl_%s_%d", String.valueOf(IBizGuideRouteControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizGuideRouteControlImpl getControl() {
        return this.mControl;
    }

    public static RectDouble getOnePathBound(PathInfo pathInfo) {
        return IBizGuideRouteControlImpl.getOnePathBound(pathInfo);
    }

    public static RectDouble getPathResultBound(ArrayList<PathInfo> arrayList) {
        return IBizGuideRouteControlImpl.getPathResultBound(arrayList);
    }

    public static RectDouble getPathPointsBound(RoutePoints routePoints) {
        return IBizGuideRouteControlImpl.getPathPointsBound(routePoints);
    }

    public void setPathInfos(ArrayList<BizPathInfoAttrs> arrayList, int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setPathInfos(arrayList, i);
        }
    }

    public void setParkingPathInfos(ArrayList<BizPathInfoAttrs> arrayList, int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setParkingPathInfos(arrayList, i);
        }
    }

    public void addSplicePathRoutePointsInfo(long j, RoutePoints routePoints) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.addSplicePathRoutePointsInfo(j, routePoints);
        }
    }

    public void setPathPoints(RoutePoints routePoints) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setPathPoints(routePoints);
        }
    }

    public void setPathDrawStyle(RouteDrawStyle routeDrawStyle) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setPathDrawStyle(routeDrawStyle);
        }
    }

    public boolean setSelectedPathIndex(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.setSelectedPathIndex(i);
        }
        return false;
    }

    public int getSelectedPathIndex() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getSelectedPathIndex();
        }
        return 0;
    }

    public boolean switchSelectedPath(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.switchSelectedPath(i);
        }
        return false;
    }

    public boolean setCurPathId(long j) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.setCurPathId(j);
        }
        return false;
    }

    public void setParkFloor(int i, int i2) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setParkFloor(i, i2);
        }
    }

    public void updatePaths() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updatePaths();
        }
    }

    public void clearPaths() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.clearPaths();
        }
    }

    public void clearPathsCacheData() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.clearPathsCacheData();
        }
    }

    public void clearPathsCacheStyle() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.clearPathsCacheStyle();
        }
    }

    public boolean updatePathsStyleWidth(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.updatePathsStyleWidth(i);
        }
        return false;
    }

    public boolean updatePathsStyleWidth(int i, @RouteLayerStyleType.RouteLayerStyleType1 int i2) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.updatePathsStyleWidth(i, i2);
        }
        return false;
    }

    public void updateTmcLightBar(ArrayList<LightBarInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateTmcLightBar(arrayList);
        }
    }

    public void setPathArrowSegment(ArrayList<Long> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setPathArrowSegment(arrayList);
        }
    }

    public void updatePathArrow() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updatePathArrow();
        }
    }

    public Coord3DDouble getPathArrowPreviewCenter(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getPathArrowPreviewCenter(i);
        }
        return null;
    }

    public Coord3DDouble getPathSegPreviewPoint(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getPathSegPreviewPoint(i);
        }
        return null;
    }

    public void moveToPathSegment(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.moveToPathSegment(i);
        }
    }

    public void updateRouteWeatherInfo(ArrayList<BizRouteWeatherInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateRouteWeatherInfo(arrayList);
        }
    }

    public void updateRouteRestAreaInfo(ArrayList<BizRouteRestAreaInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateRouteRestAreaInfo(arrayList);
        }
    }

    public void updateRouteViaRoadInfo(ArrayList<BizRouteViaRoadInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateRouteViaRoadInfo(arrayList);
        }
    }

    public void updateRouteDodgeLine(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateRouteDodgeLine(i);
        }
    }

    public void updateEnergyKeyInfo(ArrayList<BizEnergyKeyInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateEnergyKeyInfo(arrayList);
        }
    }

    public void updateThreeUrgentInfo(ArrayList<BizThreeUrgentInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateThreeUrgentInfo(arrayList);
        }
    }

    public void setThreeUrgentDrawRect(RectDouble rectDouble) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setThreeUrgentDrawRect(rectDouble);
        }
    }

    public void setODDDrawMode(@ODDDrawMode.ODDDrawMode1 int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setODDDrawMode(i);
        }
    }

    public void updateOddInfo(ArrayList<BizOddInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateOddInfo(arrayList);
        }
    }

    public void onUpdateNaviOddInfo(NaviOddInfo naviOddInfo) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.onUpdateNaviOddInfo(naviOddInfo);
        }
    }

    public void showViaETAByIndex(int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.showViaETAByIndex(i);
        }
    }

    public void updateViaETAPreviewRect(RectInt rectInt) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateViaETAPreviewRect(rectInt);
        }
    }

    public void updateGuideLabelPreviewRect(RectInt rectInt) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateGuideLabelPreviewRect(rectInt);
        }
    }

    public void setFamiliarRoute(PathInfo pathInfo) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setFamiliarRoute(pathInfo);
        }
    }

    public void updateGuideFamiliarRoutePreviewRect(RectInt rectInt) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateGuideFamiliarRoutePreviewRect(rectInt);
        }
    }

    public void enableFamiliarRoute(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.enableFamiliarRoute(z);
        }
    }

    public ArrayList<RoutePathLayer> getRoutePathLayers() {
        ArrayList<RoutePathLayerImpl> routePathLayers;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideRouteControl.class.getMethod("getRoutePathLayers", new Class[0]);
            IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
            if (iBizGuideRouteControlImpl == null || (routePathLayers = iBizGuideRouteControlImpl.getRoutePathLayers()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) routePathLayers, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BaseLayer getRouteLayer(@BizRouteType.BizRouteType1 int i) {
        BaseLayerImpl routeLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideRouteControl.class.getMethod("getRouteLayer", Integer.TYPE);
            IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
            if (iBizGuideRouteControlImpl == null || (routeLayer = iBizGuideRouteControlImpl.getRouteLayer(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) routeLayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updatePathTMCPreviewRect(RectInt rectInt) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updatePathTMCPreviewRect(rectInt);
        }
    }

    public void enableDrawPathTMC(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.enableDrawPathTMC(z);
        }
    }

    public void updateRoutePathNumberPreviewRect(RectInt rectInt) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateRoutePathNumberPreviewRect(rectInt);
        }
    }

    public void enableRoutePathNumber(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.enableRoutePathNumber(z);
        }
    }

    public void enablePathGrown(boolean z, int i, int i2) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.enablePathGrown(z, i, i2);
        }
    }

    public void enableArrowGrown(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.enableArrowGrown(z);
        }
    }

    public void enableArrowWipe(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.enableArrowWipe(z);
        }
    }

    public void setGrownAnimInfo(int i, int i2) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setGrownAnimInfo(i, i2);
        }
    }

    public void enableOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.enableOddAnimation(z, animationStyleParam);
        }
    }

    public void setOddDisplayScale(LayerScale layerScale) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setOddDisplayScale(layerScale);
        }
    }

    public void updateNaviInfo(ArrayList<NaviInfo> arrayList, int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateNaviInfo(arrayList, i);
        }
    }

    public void updateNaviInfo(ArrayList<NaviInfo> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateNaviInfo(arrayList);
        }
    }

    public void setPassGreyMode(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setPassGreyMode(z);
        }
    }

    public void setCompareRouteMode(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setCompareRouteMode(z);
        }
    }

    public void initDynamicLevel(DynamicLevelParam dynamicLevelParam) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.initDynamicLevel(dynamicLevelParam);
        }
    }

    public DynamicLevelParam getDynamicLevelParam() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getDynamicLevelParam();
        }
        return null;
    }

    public boolean updateDynamicLevel(DynamicLevelParam dynamicLevelParam) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.updateDynamicLevel(dynamicLevelParam);
        }
        return false;
    }

    public void openDynamicLevel(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.openDynamicLevel(z, i);
        }
    }

    public void openDynamicLevel(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.openDynamicLevel(z);
        }
    }

    public void resetDynamicLevel(@DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.resetDynamicLevel(i);
        }
    }

    public void resetDynamicLevel() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.resetDynamicLevel();
        }
    }

    public void openDynamicCenter(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.openDynamicCenter(z);
        }
    }

    public void resetDynamicCenter() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.resetDynamicCenter();
        }
    }

    public float getDynamicLevel(@DynamicLevelType.DynamicLevelType1 int i, boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getDynamicLevel(i, z);
        }
        return 0.0f;
    }

    public float getDynamicLevelMapHeadDegree(@DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getDynamicLevelMapHeadDegree(i);
        }
        return 0.0f;
    }

    public float getDynamicLevelMapHeadDegree() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getDynamicLevelMapHeadDegree();
        }
        return 0.0f;
    }

    public boolean getDynamicLevelLock(@DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getDynamicLevelLock(i);
        }
        return false;
    }

    public boolean getDynamicLevelLock() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            return iBizGuideRouteControlImpl.getDynamicLevelLock();
        }
        return false;
    }

    public void setDynamicLevelLock(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setDynamicLevelLock(z, i);
        }
    }

    public void setDynamicLevelLock(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setDynamicLevelLock(z);
        }
    }

    public void setDynamicLevelCustomCalculator(DynamicLevelCustomCalculator dynamicLevelCustomCalculator, @DynamicLevelType.DynamicLevelType1 int i) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideRouteControl.class.getMethod("setDynamicLevelCustomCalculator", DynamicLevelCustomCalculator.class, Integer.TYPE);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(dynamicLevelCustomCalculator);
            DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl = null;
            if (dynamicLevelCustomCalculator != null && (typeHelper = this.mTypeHelper) != null) {
                dynamicLevelCustomCalculatorImpl = (DynamicLevelCustomCalculatorImpl) typeHelper.transfer(method, 0, dynamicLevelCustomCalculator);
            }
            IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
            if (iBizGuideRouteControlImpl != null) {
                iBizGuideRouteControlImpl.setDynamicLevelCustomCalculator(dynamicLevelCustomCalculatorImpl, i);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setDynamicLevelCustomCalculator(DynamicLevelCustomCalculator dynamicLevelCustomCalculator) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideRouteControl.class.getMethod("setDynamicLevelCustomCalculator", DynamicLevelCustomCalculator.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(dynamicLevelCustomCalculator);
            DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl = null;
            if (dynamicLevelCustomCalculator != null && (typeHelper = this.mTypeHelper) != null) {
                dynamicLevelCustomCalculatorImpl = (DynamicLevelCustomCalculatorImpl) typeHelper.transfer(method, 0, dynamicLevelCustomCalculator);
            }
            IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
            if (iBizGuideRouteControlImpl != null) {
                iBizGuideRouteControlImpl.setDynamicLevelCustomCalculator(dynamicLevelCustomCalculatorImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateGuideETAEvent(BizGuideETAEventInfo bizGuideETAEventInfo) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateGuideETAEvent(bizGuideETAEventInfo);
        }
    }

    public void updateGuideCongestionBoard(NaviCongestionInfo naviCongestionInfo) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateGuideCongestionBoard(naviCongestionInfo);
        }
    }

    public void updateGuideCongestionBoard() {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateGuideCongestionBoard();
        }
    }

    public void updateRouteJamBubbles(ArrayList<TrafficJamBubbles> arrayList) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateRouteJamBubbles(arrayList);
        }
    }

    public void updateRouteJamBubblesPreviewRect(RectInt rectInt) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateRouteJamBubblesPreviewRect(rectInt);
        }
    }

    public void updateViaPassIndex(long j) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.updateViaPassIndex(j);
        }
    }

    public void setViaPassGreyMode(boolean z) {
        IBizGuideRouteControlImpl iBizGuideRouteControlImpl = this.mControl;
        if (iBizGuideRouteControlImpl != null) {
            iBizGuideRouteControlImpl.setViaPassGreyMode(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
