package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.common.path.model.RoutePoints;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.impl.NaviCongestionInfoImpl;
import com.autonavi.gbl.layer.impl.DynamicLevelCustomCalculatorImpl;
import com.autonavi.gbl.layer.impl.IBizGuideRouteControl;
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
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerStyleType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
@IntfAuto(target = IBizGuideRouteControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizGuideRouteControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizGuideRouteControl.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IBizGuideRouteControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizGuideRouteControl(long j, boolean z) {
        this(new IBizGuideRouteControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizGuideRouteControl.class, this, this.mControl);
        }
    }

    public BizGuideRouteControl(IBizGuideRouteControl iBizGuideRouteControl) {
        super(iBizGuideRouteControl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizGuideRouteControl);
    }

    private void $constructor(IBizGuideRouteControl iBizGuideRouteControl) {
        if (iBizGuideRouteControl != null) {
            this.mControl = iBizGuideRouteControl;
            this.mTargetId = String.format("BizGuideRouteControl_%s_%d", String.valueOf(IBizGuideRouteControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizGuideRouteControl getControl() {
        return this.mControl;
    }

    public static RectDouble getOnePathBound(PathInfo pathInfo) {
        try {
            Method method = BizGuideRouteControl.class.getMethod("getOnePathBound", PathInfo.class);
            if (pathInfo != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (PathInfoImpl) typeHelper.transfer(method, 0, pathInfo) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $pathInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.1
                    }));
                }
            }
            return IBizGuideRouteControl.getOnePathBound(r0);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static RectDouble getPathResultBound(ArrayList<PathInfo> arrayList) {
        try {
            Method method = BizGuideRouteControl.class.getMethod("getPathResultBound", ArrayList.class);
            if (arrayList != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $pathInfoList == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.2
                    }));
                }
            }
            return IBizGuideRouteControl.getPathResultBound(r0);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static RectDouble getPathPointsBound(RoutePoints routePoints) {
        return IBizGuideRouteControl.getPathPointsBound(routePoints);
    }

    public Coord3DDouble getPathArrowPreviewCenter(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getPathArrowPreviewCenter(i);
        }
        return null;
    }

    public Coord3DDouble getPathSegPreviewPoint(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getPathSegPreviewPoint(i);
        }
        return null;
    }

    public DynamicLevelParam getDynamicLevelParam() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getDynamicLevelParam();
        }
        return null;
    }

    public ArrayList<RoutePathLayer> getRoutePathLayers() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getRoutePathLayers();
        }
        return null;
    }

    public void setPathInfos(ArrayList<BizPathInfoAttrs> arrayList, int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setPathInfos(arrayList, i);
        }
    }

    public void setPathPoints(RoutePoints routePoints) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setPathPoints(routePoints);
        }
    }

    public void setPathDrawStyle(RouteDrawStyle routeDrawStyle) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setPathDrawStyle(routeDrawStyle);
        }
    }

    public void setSelectedPathIndex(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setSelectedPathIndex(i);
        }
    }

    public int getSelectedPathIndex() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getSelectedPathIndex();
        }
        return 0;
    }

    public void switchSelectedPath(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.switchSelectedPath(i);
        }
    }

    public void setParkFloor(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setParkFloor(i);
        }
    }

    public void updatePaths() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updatePaths();
        }
    }

    public void clearPaths() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.clearPaths();
        }
    }

    public void clearPathsCacheData() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.clearPathsCacheData();
        }
    }

    public void clearPathsCacheStyle() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.clearPathsCacheStyle();
        }
    }

    public boolean updatePathsStyleWidth(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.updatePathsStyleWidth(i);
        }
        return false;
    }

    public boolean updatePathsStyleWidth(int i, @RouteLayerStyleType.RouteLayerStyleType1 int i2) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.updatePathsStyleWidth(i, i2);
        }
        return false;
    }

    public void updateTmcLightBar(ArrayList<LightBarInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateTmcLightBar(arrayList);
        }
    }

    public void setPathArrowSegment(ArrayList<Long> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setPathArrowSegment(arrayList);
        }
    }

    public void updatePathArrow() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updatePathArrow();
        }
    }

    public void moveToPathSegment(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.moveToPathSegment(i);
        }
    }

    public void updateRouteWeatherInfo(ArrayList<BizRouteWeatherInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateRouteWeatherInfo(arrayList);
        }
    }

    public void updateRouteRestAreaInfo(ArrayList<BizRouteRestAreaInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateRouteRestAreaInfo(arrayList);
        }
    }

    public void updateRouteViaRoadInfo(ArrayList<BizRouteViaRoadInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateRouteViaRoadInfo(arrayList);
        }
    }

    public void updateRouteDodgeLine(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateRouteDodgeLine(i);
        }
    }

    public void updateEnergyKeyInfo(ArrayList<BizEnergyKeyInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateEnergyKeyInfo(arrayList);
        }
    }

    public void updateThreeUrgentInfo(ArrayList<BizThreeUrgentInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateThreeUrgentInfo(arrayList);
        }
    }

    public void setThreeUrgentDrawRect(RectDouble rectDouble) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setThreeUrgentDrawRect(rectDouble);
        }
    }

    public void setODDDrawMode(@ODDDrawMode.ODDDrawMode1 int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setODDDrawMode(i);
        }
    }

    public void updateOddInfo(ArrayList<BizOddInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateOddInfo(arrayList);
        }
    }

    public void showViaETAByIndex(int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.showViaETAByIndex(i);
        }
    }

    public void updateViaETAPreviewRect(RectInt rectInt) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateViaETAPreviewRect(rectInt);
        }
    }

    public void updateGuideLabelPreviewRect(RectInt rectInt) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateGuideLabelPreviewRect(rectInt);
        }
    }

    public BaseLayer getRouteLayer(@BizRouteType.BizRouteType1 int i) {
        BaseLayerImpl routeLayer;
        try {
            Method method = BizGuideRouteControl.class.getMethod("getRouteLayer", Integer.TYPE);
            IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
            if (iBizGuideRouteControl != null && (routeLayer = iBizGuideRouteControl.getRouteLayer(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) routeLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updatePathTMCPreviewRect(RectInt rectInt) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updatePathTMCPreviewRect(rectInt);
        }
    }

    public void enableDrawPathTMC(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.enableDrawPathTMC(z);
        }
    }

    public void enablePathGrown(boolean z, int i, int i2) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.enablePathGrown(z, i, i2);
        }
    }

    public void enableArrowGrown(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.enableArrowGrown(z);
        }
    }

    public void enableArrowWipe(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.enableArrowWipe(z);
        }
    }

    public void setGrownAnimInfo(int i, int i2) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setGrownAnimInfo(i, i2);
        }
    }

    public void enableOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.enableOddAnimation(z, animationStyleParam);
        }
    }

    public void setOddDisplayScale(LayerScale layerScale) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setOddDisplayScale(layerScale);
        }
    }

    public void updateNaviInfo(ArrayList<NaviInfo> arrayList, int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateNaviInfo(arrayList, i);
        }
    }

    public void updateNaviInfo(ArrayList<NaviInfo> arrayList) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateNaviInfo(arrayList);
        }
    }

    public void setPassGreyMode(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setPassGreyMode(z);
        }
    }

    public void setCompareRouteMode(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setCompareRouteMode(z);
        }
    }

    public void initDynamicLevel(DynamicLevelParam dynamicLevelParam) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.initDynamicLevel(dynamicLevelParam);
        }
    }

    public boolean updateDynamicLevel(DynamicLevelParam dynamicLevelParam) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.updateDynamicLevel(dynamicLevelParam);
        }
        return false;
    }

    public void openDynamicLevel(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.openDynamicLevel(z, i);
        }
    }

    public void openDynamicLevel(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.openDynamicLevel(z);
        }
    }

    public void resetDynamicLevel(@DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.resetDynamicLevel(i);
        }
    }

    public void resetDynamicLevel() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.resetDynamicLevel();
        }
    }

    public void openDynamicCenter(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.openDynamicCenter(z);
        }
    }

    public void resetDynamicCenter() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.resetDynamicCenter();
        }
    }

    public float getDynamicLevel(@DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getDynamicLevel(i);
        }
        return 0.0f;
    }

    public float getDynamicLevel() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getDynamicLevel();
        }
        return 0.0f;
    }

    public float getDynamicLevelMapHeadDegree(@DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getDynamicLevelMapHeadDegree(i);
        }
        return 0.0f;
    }

    public float getDynamicLevelMapHeadDegree() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getDynamicLevelMapHeadDegree();
        }
        return 0.0f;
    }

    public boolean getDynamicLevelLock(@DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getDynamicLevelLock(i);
        }
        return false;
    }

    public boolean getDynamicLevelLock() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            return iBizGuideRouteControl.getDynamicLevelLock();
        }
        return false;
    }

    public void setDynamicLevelLock(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setDynamicLevelLock(z, i);
        }
    }

    public void setDynamicLevelLock(boolean z) {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.setDynamicLevelLock(z);
        }
    }

    public void setDynamicLevelCustomCalculator(DynamicLevelCustomCalculator dynamicLevelCustomCalculator, @DynamicLevelType.DynamicLevelType1 int i) {
        HashSet hashSet;
        try {
            Method method = BizGuideRouteControl.class.getMethod("setDynamicLevelCustomCalculator", DynamicLevelCustomCalculator.class, Integer.TYPE);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(dynamicLevelCustomCalculator);
            if (dynamicLevelCustomCalculator != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (DynamicLevelCustomCalculatorImpl) typeHelper2.transfer(method, 0, dynamicLevelCustomCalculator) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $calculator == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.4
                    }));
                }
            }
            IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
            if (iBizGuideRouteControl != null) {
                iBizGuideRouteControl.setDynamicLevelCustomCalculator(r2, i);
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
        try {
            Method method = BizGuideRouteControl.class.getMethod("setDynamicLevelCustomCalculator", DynamicLevelCustomCalculator.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(dynamicLevelCustomCalculator);
            if (dynamicLevelCustomCalculator != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (DynamicLevelCustomCalculatorImpl) typeHelper2.transfer(method, 0, dynamicLevelCustomCalculator) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $calculator == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.5
                    }));
                }
            }
            IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
            if (iBizGuideRouteControl != null) {
                iBizGuideRouteControl.setDynamicLevelCustomCalculator(r3);
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
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateGuideETAEvent(bizGuideETAEventInfo);
        }
    }

    public void updateGuideCongestionBoard(NaviCongestionInfo naviCongestionInfo) {
        try {
            Method method = BizGuideRouteControl.class.getMethod("updateGuideCongestionBoard", NaviCongestionInfo.class);
            if (naviCongestionInfo != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (NaviCongestionInfoImpl) typeHelper.transfer(method, 0, naviCongestionInfo) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $naviCongestionInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.6
                    }));
                }
            }
            IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
            if (iBizGuideRouteControl != null) {
                iBizGuideRouteControl.updateGuideCongestionBoard(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateGuideCongestionBoard() {
        IBizGuideRouteControl iBizGuideRouteControl = this.mControl;
        if (iBizGuideRouteControl != null) {
            iBizGuideRouteControl.updateGuideCongestionBoard();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.7
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.8
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideRouteControl.9
        }));
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
