package com.xiaopeng.montecarlo.navcore.control;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.RoutePoint;
import com.autonavi.gbl.common.path.model.RoutePoints;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizCarType;
import com.autonavi.gbl.layer.model.BizOddInfo;
import com.autonavi.gbl.layer.model.BizPathInfoAttrs;
import com.autonavi.gbl.layer.model.BizPolygonBusinessInfo;
import com.autonavi.gbl.layer.model.BizRoadFacilityType;
import com.autonavi.gbl.layer.model.BizRouteDrawCtrlAttrs;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.layer.model.BizSearchType;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.layer.model.BizUserType;
import com.autonavi.gbl.layer.model.DynamicLevelType;
import com.autonavi.gbl.layer.model.EagleEyeStyle;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.control.base.IBizAllItemsListener;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.BLDataModelUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.BizControlDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPVariantPath;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BizControlWrapper {
    public static final String BIZ_CONTROL_TYPE_AGROUP = "AGroupControlProxy";
    public static final String BIZ_CONTROL_TYPE_AREA = "AreaControlProxy";
    public static final String BIZ_CONTROL_TYPE_CAR = "CarControlProxy";
    public static final String BIZ_CONTROL_TYPE_CUSTOM = "CustomControlProxy";
    public static final String BIZ_CONTROL_TYPE_FLYLINE = "FlyLineControlProxy";
    public static final String BIZ_CONTROL_TYPE_GUIDEEAGLEEYE = "GuideEagleEyeControlProxy";
    public static final String BIZ_CONTROL_TYPE_GUIDEROUTE = "GuideRouteControlProxy";
    public static final String BIZ_CONTROL_TYPE_LABEL = "LabelControlProxy";
    public static final String BIZ_CONTROL_TYPE_ROADCROSS = "RoadCrossControlProxy";
    public static final String BIZ_CONTROL_TYPE_ROADFACILITY = "RoadFacilityControlProxy";
    public static final String BIZ_CONTROL_TYPE_SEARCH = "SearchControlProxy";
    public static final String BIZ_CONTROL_TYPE_USER = "UserControlProxy";
    private static final L.Tag TAG = new L.Tag("BizControlWrapper");
    private Map<String, IBizControlProxy> mBizControlMap;
    private BizControlService mBizService;
    private IMapListener mCustomMapListener;
    private MapView mMapView;
    private IPrepareLayerStyle mPrepareLayerStyle;
    private AGroupControlProxy mAGroupControlProxy = new AGroupControlProxy();
    private AreaControlProxy mAreaControlProxy = new AreaControlProxy();
    private GuideEagleEyeControlProxy mGuideEagleEyeControlProxy = new GuideEagleEyeControlProxy();
    private GuideRouteControlProxy mGuideRouteControlProxy = new GuideRouteControlProxy();
    private LabelControlProxy mLabelControlProxy = new LabelControlProxy();
    private RoadCrossControlProxy mRoadCrossControlProxy = new RoadCrossControlProxy();
    private RoadFacilityControlProxy mRoadFacilityControlProxy = new RoadFacilityControlProxy();
    private SearchControlProxy mSearchControlProxy = new SearchControlProxy();
    private UserControlProxy mUserControlProxy = new UserControlProxy();
    private CarControlProxy mCarControlProxy = new CarControlProxy();
    private BizServiceControlProxy mBizServiceControlProxy = new BizServiceControlProxy();
    private CustomControlProxy mCustomControlProxy = new CustomControlProxy();
    private FlyLineControlProxy mFlyLineControlProxy = new FlyLineControlProxy();
    private boolean mGlMapViewInitialized = false;
    private boolean mIs2DCrossShow = false;
    private boolean mIs3DCrossShow = false;
    private boolean mRouteChangeBackground = false;
    private boolean mIsNeedRefresh = true;

    public void onExplorePoiHide() {
    }

    public BizControlWrapper(BizControlManager bizControlManager) {
    }

    public void initBizControl(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null) {
            return;
        }
        this.mMapView = bizControlDataModel.mapView;
        this.mCustomMapListener = bizControlDataModel.iMapListener;
        this.mGlMapViewInitialized = true;
        BizControlService bizControlService = this.mBizService;
        MapView mapView = this.mMapView;
        bizControlService.initCollisionConfig(mapView, RootUtil.SD_CARD_NAVI_PATH + "/style_bl.json");
        this.mAGroupControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mAreaControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mCarControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mGuideEagleEyeControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mGuideRouteControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mLabelControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mRoadCrossControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mRoadFacilityControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mSearchControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mUserControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mCustomControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mFlyLineControlProxy.init(this.mBizService, this.mMapView, this.mCustomMapListener);
        this.mRoadFacilityControlProxy.enableDistanceRefresh(false);
        RoadFacilityControlProxy roadFacilityControlProxy = this.mRoadFacilityControlProxy;
        roadFacilityControlProxy.parseGuideCameraLayerProperty(RootUtil.SD_CARD_NAVI_PATH + "/style_camera.json");
        Map<String, IBizControlProxy> map = this.mBizControlMap;
        if (map == null) {
            this.mBizControlMap = new HashMap();
        } else {
            map.clear();
        }
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_AGROUP, this.mAGroupControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_AREA, this.mAreaControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_CAR, this.mCarControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_GUIDEEAGLEEYE, this.mGuideEagleEyeControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_GUIDEROUTE, this.mGuideRouteControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_LABEL, this.mLabelControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_ROADCROSS, this.mRoadCrossControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_ROADFACILITY, this.mRoadFacilityControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_SEARCH, this.mSearchControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_USER, this.mUserControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_CUSTOM, this.mCustomControlProxy);
        this.mBizControlMap.put(BIZ_CONTROL_TYPE_FLYLINE, this.mFlyLineControlProxy);
    }

    public void initBizService(int i) {
        this.mBizService = (BizControlService) ServiceMgr.getServiceMgrInstance().getBLService(19);
        String str = RootUtil.SD_CARD_NAVI_PATH + "/style_bl.json";
        boolean init = this.mBizService.init(i, str);
        this.mBizService.init(i + 1, str);
        if (this.mBizService.isInit() != 3) {
            L.i(TAG, "biz control init fail");
        }
        if (L.ENABLE) {
            L.d(TAG, "initLayerControl style_bl path: " + str);
        }
        L.i(TAG, L.formatWithEngine("initLayerControl: finish init = " + init, getMainEngineID()));
    }

    public void setStyle(@MapEngineID.MapEngineID1 int i, IPrepareLayerStyle iPrepareLayerStyle) {
        this.mPrepareLayerStyle = iPrepareLayerStyle;
        BizControlService bizControlService = this.mBizService;
        if (bizControlService != null) {
            bizControlService.setStyle(i, iPrepareLayerStyle);
        }
    }

    public void updateCarMarkStyle() {
        IBizControlProxy iBizControlProxy = this.mBizControlMap.get(BIZ_CONTROL_TYPE_CAR);
        if (iBizControlProxy != null) {
            L.i(TAG, "updateCarMarkStyle!!!");
            iBizControlProxy.updateStyle();
        }
    }

    public void setIsNeedRefresh(boolean z) {
        this.mIsNeedRefresh = z;
    }

    public void setRouteChangeBackground(boolean z) {
        this.mRouteChangeBackground = z;
    }

    public void drawRoute(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel != null) {
            drawRoute(bizControlDataModel.mType, bizControlDataModel.mPathResult, bizControlDataModel.mRouteParams, bizControlDataModel.mSelectedIndex, bizControlDataModel.isNavi);
            if (bizControlDataModel.mPathResult != null) {
                bizControlDataModel.mPathResult.delRef();
            }
        }
    }

    private void drawRoute(int i, IPathResult iPathResult, RouteParams routeParams, int i2, boolean z) {
        int i3;
        boolean z2;
        IPathResult iPathResult2 = iPathResult;
        if (!checkMapViewValid() || iPathResult2 == null) {
            return;
        }
        setRadarState();
        RoutePoints createPathPoints = createPathPoints(routeParams);
        boolean isOpenRadar = SettingWrapper.isOpenRadar();
        if (TBTManager.getInstance().getCurrentStatus() == 2) {
            isOpenRadar = true;
        }
        boolean z3 = false;
        boolean z4 = i == 771 && isOpenRadar && !TBTManager.getInstance().isSimulateGuidance();
        boolean z5 = z4 || i != 771;
        long currentNaviPathId = TBTManager.getInstance().getCurrentNaviPathId();
        if (currentNaviPathId == -1 || (i3 = iPathResult2.getPathIndex(currentNaviPathId)) == i2) {
            i3 = i2;
        } else {
            L.e(TAG, "selectedIndex != currentPathIndex ,selectedIndex:" + i2 + " currentPathIndex:" + i3);
        }
        StringBuilder sb = new StringBuilder("");
        sb.append("drawRoute: ");
        sb.append(i);
        sb.append(", selectedIndex : ");
        sb.append(i3);
        sb.append(", isNavi : ");
        sb.append(z);
        sb.append(", isMultiRouteGuide: ");
        sb.append(z4);
        sb.append(", isMultiRoute: ");
        sb.append(z5);
        long pathCount = iPathResult.getPathCount();
        ArrayList<BizPathInfoAttrs> arrayList = new ArrayList<>();
        sb.append(", is alternate: ");
        sb.append(isOpenRadar);
        int i4 = 0;
        while (i4 < pathCount) {
            if (!z5 && i4 != i3) {
                sb.append(", ignore alternative path: ");
                sb.append(i4);
            } else {
                IVariantPath path = iPathResult2.getPath(i4);
                if (path != null) {
                    BizRouteDrawCtrlAttrs bizRouteDrawCtrlAttrs = new BizRouteDrawCtrlAttrs();
                    bizRouteDrawCtrlAttrs.mIsDrawPath = true;
                    bizRouteDrawCtrlAttrs.mIsDrawPathCamera = z3;
                    bizRouteDrawCtrlAttrs.mIsDrawPathTrafficLight = i == 771;
                    bizRouteDrawCtrlAttrs.mIsDrawArrow = true;
                    bizRouteDrawCtrlAttrs.mIsVisible = true;
                    bizRouteDrawCtrlAttrs.mIsTrafficEventOpen = i == 769;
                    bizRouteDrawCtrlAttrs.mIsHighLightRoadName = true;
                    arrayList.add(new BizPathInfoAttrs(((XPVariantPath) path).getVariantPath(), bizRouteDrawCtrlAttrs));
                    long pathId = path.getPathId();
                    sb.append(", path ");
                    sb.append(i4);
                    sb.append(": ");
                    sb.append(pathId);
                }
            }
            i4++;
            iPathResult2 = iPathResult;
            z3 = false;
        }
        if (769 == i) {
            double d = 9;
            double d2 = 19;
            this.mGuideRouteControlProxy.setDisplayScale(BizRouteType.BizRouteTypeTrafficBlockOuter, new LayerScale(d, d2));
            this.mGuideRouteControlProxy.setDisplayScale(BizRouteType.BizRouteTypeTrafficBlock, new LayerScale(d, d2));
            this.mGuideRouteControlProxy.setDisplayScale(BizRouteType.BizRouteTypeGuideEtaEvent, new LayerScale(d, d2));
            this.mGuideRouteControlProxy.setDisplayScale(BizRouteType.BizRouteTypeJamPoint, new LayerScale(d, d2));
            this.mGuideRouteControlProxy.setDisplayScale(BizRouteType.BizRouteTypeJamLine, new LayerScale(d, d2));
            z2 = true;
            this.mGuideRouteControlProxy.setClickable(6021L, true);
            this.mGuideRouteControlProxy.setClickable(6020L, true);
            this.mGuideRouteControlProxy.setClickable(6012L, true);
            this.mGuideRouteControlProxy.setClickable(6022L, true);
        } else {
            z2 = true;
        }
        this.mGuideRouteControlProxy.setClickable(6001L, z2);
        this.mGuideRouteControlProxy.setClickable(6002L, z2);
        this.mGuideRouteControlProxy.setClickable(6003L, z2);
        this.mGuideRouteControlProxy.setPathDrawStyle(getRouteDrawStyleParam(z, isOpenRadar));
        this.mGuideRouteControlProxy.setPathPoints(createPathPoints);
        GuideRouteControlProxy guideRouteControlProxy = this.mGuideRouteControlProxy;
        if (!z5) {
            i3 = 0;
        }
        guideRouteControlProxy.setPathInfos(arrayList, i3);
        this.mGuideRouteControlProxy.setCompareRouteMode(false);
        this.mGuideRouteControlProxy.updatePaths();
        if (!this.mIsNeedRefresh) {
            this.mRouteChangeBackground = true;
        }
        OddDataHelper.getInstance().updateOddInfo();
        L.i(TAG, sb.toString());
    }

    public void drawComparingRoutes(BizControlDataModel bizControlDataModel) {
        if (!checkMapViewValid() || bizControlDataModel == null || CollectionUtils.isEmpty(bizControlDataModel.mPaths)) {
            return;
        }
        StringBuilder sb = new StringBuilder("");
        sb.append("drawComparingRoutes: ");
        sb.append(bizControlDataModel.mType);
        sb.append(", selectedIndex : ");
        sb.append(bizControlDataModel.mSelectedIndex);
        sb.append(", newRouteIndex,");
        sb.append(bizControlDataModel.mNewRouteIndex);
        sb.append(", isNavi : ");
        sb.append(bizControlDataModel.isNavi);
        long length = bizControlDataModel.mPaths.length;
        ArrayList<BizPathInfoAttrs> arrayList = new ArrayList<>();
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                IVariantPath iVariantPath = bizControlDataModel.mPaths[i2];
                if (iVariantPath == null) {
                    return;
                }
                BizRouteDrawCtrlAttrs bizRouteDrawCtrlAttrs = new BizRouteDrawCtrlAttrs();
                bizRouteDrawCtrlAttrs.mIsDrawPath = true;
                bizRouteDrawCtrlAttrs.mIsDrawPathCamera = false;
                bizRouteDrawCtrlAttrs.mIsDrawPathTrafficLight = false;
                bizRouteDrawCtrlAttrs.mIsDrawArrow = false;
                bizRouteDrawCtrlAttrs.mIsVisible = true;
                bizRouteDrawCtrlAttrs.mIsTrafficEventOpen = true;
                if (i2 != bizControlDataModel.mNewRouteIndex) {
                    z = false;
                }
                bizRouteDrawCtrlAttrs.mIsNewRouteForCompareRoute = z;
                arrayList.add(new BizPathInfoAttrs(((XPVariantPath) iVariantPath).getVariantPath(), bizRouteDrawCtrlAttrs));
                long pathId = iVariantPath.getPathId();
                sb.append(", path " + i2 + ": ");
                sb.append(pathId);
                i2++;
            } else {
                RoutePoints createPathPoints = createPathPoints(bizControlDataModel.mRouteParams);
                this.mGuideRouteControlProxy.setPathDrawStyle(getRouteDrawStyleParam(bizControlDataModel.isNavi, false));
                this.mGuideRouteControlProxy.setPathPoints(createPathPoints);
                if (bizControlDataModel.mSelectedIndex > -1 && bizControlDataModel.mSelectedIndex < length) {
                    i = bizControlDataModel.mSelectedIndex;
                }
                this.mGuideRouteControlProxy.setPathInfos(arrayList, i);
                this.mGuideRouteControlProxy.setCompareRouteMode(true);
                this.mGuideRouteControlProxy.updatePaths();
                if (!this.mIsNeedRefresh) {
                    this.mRouteChangeBackground = true;
                }
                OddDataHelper.getInstance().updateOddInfo();
                L.i(TAG, sb.toString());
                return;
            }
        }
    }

    public void hideCross(int i, IBizCrossListener iBizCrossListener) {
        if (checkMapViewValid()) {
            this.mRoadCrossControlProxy.setVisible(i, false);
            this.mRoadCrossControlProxy.hideCross(i);
            if (i == 3) {
                this.mIs2DCrossShow = false;
            } else if (i == 4) {
                this.mIs3DCrossShow = false;
            }
            if (iBizCrossListener != null) {
                iBizCrossListener.onShowCross(true);
            }
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("hideCross callBack: type " + i, getMainEngineID()));
        }
    }

    public void setRouteArrowShowSegment(ArrayList<Long> arrayList) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("setRouteArrowShowSegment:", getMainEngineID()));
            this.mGuideRouteControlProxy.setPathArrowSegment(arrayList);
            this.mGuideRouteControlProxy.updatePathArrow();
        }
    }

    public void updateRouteOverlayElem(RouteParams routeParams) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("updateRouteOverlayElem: ", getMainEngineID()));
            this.mGuideRouteControlProxy.setPathPoints(createPathPoints(routeParams));
            this.mGuideRouteControlProxy.updateStyle();
        }
    }

    public void setCarLineAndNaviEndVisible(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setCarLineAndNaviEndVisible: " + z, getMainEngineID()));
            this.mGuideRouteControlProxy.setVisible(BizRouteType.BizRouteTypeStartEndLine, z);
            this.mGuideRouteControlProxy.setVisible(BizRouteType.BizRouteTypeStartEndPoint, z);
        }
    }

    public void setCarLineVisible(boolean z) {
        if (checkMapViewValid()) {
            this.mGuideRouteControlProxy.setVisible(BizRouteType.BizRouteTypeStartEndLine, z);
            this.mGuideRouteControlProxy.setVisible(BizRouteType.BizRouteTypeStartEndPoint, true);
        }
    }

    public void setCar2EndLine(BizControlDataModel bizControlDataModel) {
        if (!checkMapViewValid() || bizControlDataModel == null) {
            return;
        }
        RoutePoints routePoints = new RoutePoints();
        routePoints.mEndPoints = new ArrayList<>();
        routePoints.mEndPoints.add(new RoutePoint());
        routePoints.mEndPoints.get(0).mPos.lat = bizControlDataModel.mLat;
        routePoints.mEndPoints.get(0).mPos.lon = bizControlDataModel.mLon;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("setCar2EndLine: lat -> " + bizControlDataModel.mLat + ", lon -> " + bizControlDataModel.mLon, getMainEngineID()));
        }
        this.mGuideRouteControlProxy.setPathPoints(routePoints);
    }

    public void initCar(BizControlDataModel bizControlDataModel) {
        if (!checkMapViewValid() || bizControlDataModel == null || bizControlDataModel.mCarLoc == null || bizControlDataModel.mMapStyleReader == null) {
            return;
        }
        if (bizControlDataModel.mCarLoc != null && bizControlDataModel.mCarLoc.vecPathMatchInfo != null && bizControlDataModel.mCarLoc.vecPathMatchInfo.size() > 0) {
            L.Tag tag = TAG;
            L.i(tag, "initCar: mPrepareLayerStyle = " + bizControlDataModel.mMapStyleReader + " lon:" + bizControlDataModel.mCarLoc.vecPathMatchInfo.get(0).longitude + " lat:" + bizControlDataModel.mCarLoc.vecPathMatchInfo.get(0).latitude);
        }
        this.mCarControlProxy.setVisible(true);
        this.mCarControlProxy.setCarAnimationSwitch(true);
        this.mCarControlProxy.setCarStyle(bizControlDataModel.mMapStyleReader);
        this.mCarControlProxy.updateCarStyle(2002);
        this.mCarControlProxy.setCarPosition(bizControlDataModel.mCarLoc);
    }

    public void initCarScaleByMapLevel() {
        float[] fArr = new float[21];
        Arrays.fill(fArr, 0, 20, 1.0f);
        this.mCarControlProxy.setCarScaleByMapLevel(fArr);
    }

    public void updateResMarker(boolean z) {
        if (checkMapViewValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("updateResMarker mRouteChangeBackground = " + this.mRouteChangeBackground + " this :" + this, getMainEngineID()));
            }
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_AGROUP).updateStyle();
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_AREA).updateStyle();
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_CAR).updateStyle();
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_GUIDEEAGLEEYE).updateStyle(!z);
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_LABEL).updateStyle();
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_ROADFACILITY).updateStyle();
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_SEARCH).updateStyle();
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_USER).updateStyle();
            this.mBizControlMap.get(BIZ_CONTROL_TYPE_CUSTOM).updateStyle();
            if (this.mRouteChangeBackground) {
                this.mRouteChangeBackground = false;
                this.mGuideRouteControlProxy.updatePaths();
                return;
            }
            this.mGuideRouteControlProxy.updateStyle();
        }
    }

    public void initRouteCar() {
        if (checkMapViewValid()) {
            setVisible(BIZ_CONTROL_TYPE_ROADFACILITY, false);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, true);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeStartEndLine, false);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeStartEndPoint, false);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, false);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeOddPoint, true);
        }
    }

    private void setVisible(String str, boolean z) {
        this.mBizControlMap.get(str).setVisible(z);
    }

    private void setVisible(String str, int i, boolean z) {
        this.mBizControlMap.get(str).setVisible(i, z);
    }

    public void initNaviCar(boolean z) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("initNaviCar", getMainEngineID()));
            this.mGuideRouteControlProxy.setRouteControlPassGreyMode(true);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, SettingWrapper.isOpenRadar());
            if (z) {
                setVisible(BIZ_CONTROL_TYPE_ROADFACILITY, true);
                setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, true);
                setVisible(BIZ_CONTROL_TYPE_LABEL, true);
                setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeOddPoint, true);
                setVisible(BIZ_CONTROL_TYPE_CAR, true);
                setVisible(BIZ_CONTROL_TYPE_AREA, true);
                setVisible(BIZ_CONTROL_TYPE_ROADCROSS, true);
                setVisible(BIZ_CONTROL_TYPE_CUSTOM, true);
                setVisible(BIZ_CONTROL_TYPE_USER, true);
            }
            this.mCarControlProxy.updateCarStyle(2001);
            setCarUpMode(this.mMapView.getMapMode() != 0);
        }
    }

    public void initLaneCar() {
        if (checkMapViewValid()) {
            IMapListener iMapListener = this.mCustomMapListener;
            if (iMapListener != null) {
                iMapListener.onMapFollowModeChanged(false);
            }
            this.mCarControlProxy.setCarUpMode(true);
            this.mGuideRouteControlProxy.openDynamicLevel(false);
        }
    }

    public void initCruiseCar() {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("initCruiseCar", getMainEngineID()));
            setCarUpMode(this.mMapView.getMapMode() != 0);
            this.mGuideRouteControlProxy.setRouteControlPassGreyMode(true);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, false);
            setVisible(BIZ_CONTROL_TYPE_LABEL, false);
            setVisible(BIZ_CONTROL_TYPE_ROADFACILITY, true);
            setVisible(BIZ_CONTROL_TYPE_CAR, true);
            setVisible(BIZ_CONTROL_TYPE_AREA, true);
            setVisible(BIZ_CONTROL_TYPE_CUSTOM, true);
            setVisible(BIZ_CONTROL_TYPE_USER, true);
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeOddPoint, false);
            this.mCarControlProxy.updateCarStyle(2002);
        }
    }

    public void removeRoute(int i, boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("removeRoute: " + i + " isClearData : " + z, getMainEngineID()));
            if (z) {
                this.mGuideRouteControlProxy.clearPathsCacheData();
            }
            if (i == 769) {
                this.mGuideRouteControlProxy.clearAllItems(6012L);
                this.mGuideRouteControlProxy.clearAllItems(6013L);
                this.mGuideRouteControlProxy.clearAllItems(6020L);
                this.mGuideRouteControlProxy.clearAllItems(6022L);
            }
            this.mGuideRouteControlProxy.clearPaths();
        }
    }

    private void clearAllItems(String str, long j) {
        if (j != 0) {
            this.mBizControlMap.get(str).clearAllItems(j);
        } else {
            clearAllItems(str);
        }
    }

    private void clearAllItems(String str) {
        this.mBizControlMap.get(str).clearAllItems();
    }

    public void updateRouteTmc(List<ILightBarInfo> list) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("updateRouteTmc ", getMainEngineID()));
            ArrayList<LightBarInfo> arrayList = new ArrayList<>();
            Iterator<ILightBarInfo> it = list.iterator();
            while (it.hasNext()) {
                XPLightBarInfo xPLightBarInfo = (XPLightBarInfo) it.next();
                if (xPLightBarInfo != null) {
                    arrayList.add(xPLightBarInfo.getLightBarInfo());
                }
            }
            this.mGuideRouteControlProxy.updatePathsTmc(arrayList);
            this.mGuideRouteControlProxy.updatePaths();
            if (!this.mIsNeedRefresh) {
                this.mRouteChangeBackground = true;
            }
            OddDataHelper.getInstance().updateOddInfo();
        }
    }

    public void setSelectedPath(BizControlDataModel bizControlDataModel) {
        if (!checkMapViewValid() || bizControlDataModel == null) {
            return;
        }
        this.mGuideRouteControlProxy.clearPaths();
        this.mGuideRouteControlProxy.setSelectedPathIndex(bizControlDataModel.mIndex);
        this.mGuideRouteControlProxy.setCompareRouteMode(false);
        this.mGuideRouteControlProxy.updatePaths();
        if (771 == bizControlDataModel.mType) {
            this.mGuideRouteControlProxy.updatePathArrow();
        }
        OddDataHelper.getInstance().updateOddInfo();
    }

    public void removeRouteCache() {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("removeRouteCache: ", getMainEngineID()));
            this.mGuideRouteControlProxy.clearPathsCacheData();
        }
    }

    public void clearEagleyeRoute() {
        if (checkMapViewValid()) {
            this.mGuideEagleEyeControlProxy.clearPath();
        }
    }

    public void openDynamicLevel(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openDynamicLevel bOpen = " + z + " , type = " + i);
        }
        this.mGuideRouteControlProxy.openDynamicLevel(z, i);
    }

    public void openDynamicLevel(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openDynamicLevel bOpen = " + z);
        }
        this.mGuideRouteControlProxy.openDynamicLevel(z);
    }

    public void showEagleye() {
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine("showEagleye", getMainEngineID()));
        }
        this.mGuideEagleEyeControlProxy.setVisible(true);
    }

    public void updateEagleMapShowMode(int i) {
        this.mBizServiceControlProxy.setBizMode(i);
    }

    public void disableEagleEyeState() {
        if (L.ENABLE) {
            L.d(TAG, "disableEagleEyeState ");
        }
        if (checkMapViewValid() && this.mGuideEagleEyeControlProxy.isInitialized()) {
            this.mGuideEagleEyeControlProxy.destroyEagleEye();
        }
    }

    public void updateMapEagleEyeView(boolean z, boolean z2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateMapEagleEyeView show:" + z + " refreshRoute :" + z2);
        }
        if (checkMapViewValid()) {
            boolean eagleVisible = this.mGuideEagleEyeControlProxy.getEagleVisible();
            if (!z) {
                if (eagleVisible) {
                    this.mGuideEagleEyeControlProxy.setVisible(false);
                    return;
                }
                return;
            }
            if (!eagleVisible) {
                this.mGuideEagleEyeControlProxy.setVisible(true);
            }
            if (z2) {
                this.mGuideEagleEyeControlProxy.eagleShowPath();
            }
        }
    }

    public void adjustEagleyePosition(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || CollectionUtils.isEmpty(bizControlDataModel.mNewlocation) || bizControlDataModel.mEagleEyeStyle == null || bizControlDataModel.mEagleEyeStyle.mapViewParam == null || this.mGuideEagleEyeControlProxy == null) {
            return;
        }
        MapViewPortParam mapViewPortParam = new MapViewPortParam();
        mapViewPortParam.x = bizControlDataModel.mNewlocation[0];
        mapViewPortParam.y = bizControlDataModel.mNewlocation[1];
        mapViewPortParam.width = bizControlDataModel.mEagleEyeStyle.mapViewParam.width;
        mapViewPortParam.height = bizControlDataModel.mEagleEyeStyle.mapViewParam.height;
        mapViewPortParam.screenWidth = bizControlDataModel.mEagleEyeStyle.mapViewParam.screenWidth;
        mapViewPortParam.screenHeight = bizControlDataModel.mEagleEyeStyle.mapViewParam.screenHeight;
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine("adjustEagleyePosition style!", getMainEngineID()));
        }
        if (this.mGuideEagleEyeControlProxy.isInitialized()) {
            this.mGuideEagleEyeControlProxy.updateMapViewPort(mapViewPortParam, false);
        }
    }

    public void initEagleEye(EagleEyeStyle eagleEyeStyle) {
        this.mGuideEagleEyeControlProxy.initEagleEye(eagleEyeStyle, this.mPrepareLayerStyle);
    }

    public boolean isInitBizService() {
        return this.mBizService == null;
    }

    private int getMainEngineID() {
        if (checkMapViewValid()) {
            return this.mMapView.getEngineId();
        }
        return 0;
    }

    private boolean checkMapViewValid() {
        return this.mGlMapViewInitialized && this.mMapView != null;
    }

    public void restoreRadarLabelVisibility() {
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        if (currentStatus == 1 || currentStatus == 2) {
            this.mGuideRouteControlProxy.setVisible(BizRouteType.BizRouteTypeGuideLabel, SettingBLManager.isRadarEnableInNavigation());
        }
    }

    public boolean isInitEagleye() {
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine("isInitEagleye", getMainEngineID()));
        }
        return this.mGuideEagleEyeControlProxy.isInitialized();
    }

    public boolean getFollowMode() {
        if (checkMapViewValid()) {
            return this.mCarControlProxy.getFollowMode();
        }
        return false;
    }

    public void setFollowMode(boolean z) {
        if (checkMapViewValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("setFollowMode ： " + z, getMainEngineID()));
            }
            this.mCarControlProxy.setFollowMode(z);
            IMapListener iMapListener = this.mCustomMapListener;
            if (iMapListener != null) {
                iMapListener.onMapFollowModeChanged(z);
            }
        }
    }

    public boolean isEagleEyeShowing() {
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine("isEagleEyeShowing", getMainEngineID()));
        }
        return this.mGuideEagleEyeControlProxy.getEagleVisible();
    }

    @Nullable
    public CarLoc getCarLocation() {
        if (checkMapViewValid()) {
            return this.mCarControlProxy.getCarPosition();
        }
        return null;
    }

    public void showCrossCallBack(XPCrossImageInfo xPCrossImageInfo, IBizCrossListener iBizCrossListener) {
        boolean showCross = showCross(xPCrossImageInfo);
        if (iBizCrossListener != null) {
            iBizCrossListener.onShowCross(showCross);
        }
    }

    public boolean getCarUpMode() {
        return this.mCarControlProxy.getCarUpMode();
    }

    public void setCarUpMode(boolean z) {
        this.mCarControlProxy.setCarUpMode(z);
    }

    public RectDouble getAGroupPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        return this.mAGroupControlProxy.getPreviewRect(arrayList);
    }

    public boolean getPreviewMode() {
        return this.mCarControlProxy.getPreviewMode();
    }

    public void setPreviewMode(boolean z) {
        L.Tag tag = TAG;
        L.d(tag, L.formatWithEngine("setPreviewMode enable " + z, getMainEngineID()));
        this.mCarControlProxy.setPreviewMode(z);
    }

    private RoutePoints createPathPoints(RouteParams routeParams) {
        RoutePoints routePoints = new RoutePoints();
        if (routeParams != null) {
            routePoints.mStartPoints = new ArrayList<>();
            routePoints.mEndPoints = new ArrayList<>();
            routePoints.mStartPoints.add(new RoutePoint());
            if (routeParams.mStartInfo != null) {
                routePoints.mStartPoints.get(0).mPos.lat = routeParams.mStartInfo.getDisplayLat();
                routePoints.mStartPoints.get(0).mPos.lon = routeParams.mStartInfo.getDisplayLon();
            } else if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine(">>> createPathPoints startInfo is null", getMainEngineID()));
            }
            routePoints.mEndPoints.add(new RoutePoint());
            if (routeParams.mEndInfo != null) {
                routePoints.mEndPoints.get(0).mPos.lat = routeParams.mEndInfo.getDisplayLat();
                routePoints.mEndPoints.get(0).mPos.lon = routeParams.mEndInfo.getDisplayLon();
            } else if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine(">>> createPathPoints endInfo is null", getMainEngineID()));
            }
            if (routeParams.mViaInfos != null) {
                List<XPViaPoint> list = routeParams.mViaInfos;
                if (CollectionUtils.isNotEmpty(list)) {
                    routePoints.mViaPoints = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        RoutePoint routePoint = new RoutePoint();
                        if (list.get(i).getPoiPoint() != null) {
                            routePoint.mPos.lat = list.get(i).getPoiPoint().getDisplayLat();
                            routePoint.mPos.lon = list.get(i).getPoiPoint().getDisplayLon();
                        }
                        routePoints.mViaPoints.add(routePoint);
                    }
                }
                L.i(TAG, L.formatWithEngine("createPathPoints: ", routePoints.mViaPoints != null ? routePoints.mViaPoints.size() : 0));
            } else if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine(">>> createPathPoints pointInfos is null", getMainEngineID()));
            }
        } else if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine(">>> createPathPoints mRouteOption is null", getMainEngineID()));
        }
        return routePoints;
    }

    private RouteDrawStyle getRouteDrawStyleParam(boolean z, boolean z2) {
        RouteDrawStyle routeDrawStyle = new RouteDrawStyle();
        routeDrawStyle.mIsNavi = z;
        routeDrawStyle.mIsOffLine = false;
        routeDrawStyle.mRouteScene = 0;
        routeDrawStyle.mRouteMapMode = 0;
        routeDrawStyle.mIsMultipleMode = z2;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("getRouteDrawStyleParam : mIsNavi->" + z + ",isAlternate->" + z2, getMainEngineID()));
        }
        return routeDrawStyle;
    }

    private boolean showCross(@Nullable XPCrossImageInfo xPCrossImageInfo) {
        XPCrossImageInfo naviCrossImageInfo;
        if (!checkMapViewValid() || xPCrossImageInfo == null || ((xPCrossImageInfo.mType == 4 && getMapMode() != 2) || (naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo()) == null || !naviCrossImageInfo.mDataBuf.equals(xPCrossImageInfo.mDataBuf))) {
            return false;
        }
        if (StateManager.getInstance().getState() == 0 && xPCrossImageInfo.mType == 3) {
            return false;
        }
        if (this.mIs2DCrossShow && xPCrossImageInfo.mType == 3) {
            return true;
        }
        if (this.mIs3DCrossShow && xPCrossImageInfo.mType == 4) {
            return true;
        }
        boolean updateCross = this.mRoadCrossControlProxy.updateCross(xPCrossImageInfo.mDataBuf, xPCrossImageInfo.mType);
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("showCross: type " + xPCrossImageInfo.mType + " updateCross " + updateCross, getMainEngineID()));
        if (updateCross) {
            this.mRoadCrossControlProxy.setVisible(xPCrossImageInfo.mType, true);
            if (xPCrossImageInfo.mType == 3) {
                this.mIs2DCrossShow = true;
            } else if (xPCrossImageInfo.mType == 4) {
                this.mIs3DCrossShow = true;
            }
        }
        return updateCross;
    }

    public void clearAllItems(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType)) {
            return;
        }
        clearAllItems(bizControlDataModel.mBizControlType, bizControlDataModel.mBizType);
    }

    public void addItems(BizControlDataModel bizControlDataModel) {
        BaseLayer baseLayer;
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType) || CollectionUtils.isEmpty(bizControlDataModel.mAddItems) || (baseLayer = this.mBizControlMap.get(bizControlDataModel.mBizControlType).getBaseLayer(bizControlDataModel.mType)) == null) {
            return;
        }
        baseLayer.addItems(bizControlDataModel.mAddItems);
    }

    public void addItems(String str, int i, ArrayList<LayerItem> arrayList) {
        BaseLayer baseLayer = this.mBizControlMap.get(str).getBaseLayer(i);
        if (baseLayer != null) {
            baseLayer.addItems(arrayList);
        }
    }

    public void setVisible(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType)) {
            return;
        }
        if (bizControlDataModel.mType == -1) {
            setVisible(bizControlDataModel.mBizControlType, bizControlDataModel.isVisible);
        } else {
            setVisible(bizControlDataModel.mBizControlType, bizControlDataModel.mType, bizControlDataModel.isVisible);
        }
    }

    public void setClickable(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType)) {
            return;
        }
        this.mBizControlMap.get(bizControlDataModel.mBizControlType).setClickable(bizControlDataModel.mBizType, bizControlDataModel.isClickable);
    }

    public void addAGroupMembers(ArrayList<BizAGroupBusinessInfo> arrayList) {
        this.mAGroupControlProxy.addAGroupMembers(arrayList);
    }

    public void guideEagleEyeClearPath() {
        this.mGuideEagleEyeControlProxy.clearPath();
    }

    public void updateRouteRestrict(BizRouteRestrictInfo bizRouteRestrictInfo) {
        this.mAreaControlProxy.updateRouteRestrict(bizRouteRestrictInfo);
    }

    public void clearFocus(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType)) {
            return;
        }
        this.mBizControlMap.get(bizControlDataModel.mBizControlType).clearFocus(bizControlDataModel.mBizType);
    }

    public void clearFocus(String str, int i) {
        this.mBizControlMap.get(str).clearFocus(i);
    }

    public void addClickObserver(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || bizControlDataModel.mObserver == null) {
            return;
        }
        ArrayList<String> arrayList = bizControlDataModel.mBizControlList;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (bizControlDataModel.mType == -1) {
                    this.mBizControlMap.get(arrayList.get(i)).addClickObserver(bizControlDataModel.mObserver);
                } else {
                    BaseLayer baseLayer = this.mBizControlMap.get(arrayList.get(i)).getBaseLayer(bizControlDataModel.mType);
                    if (baseLayer != null) {
                        baseLayer.addClickObserver(bizControlDataModel.mObserver);
                    }
                }
            }
        } else if (!TextUtils.isEmpty(bizControlDataModel.mBizControlType)) {
            if (bizControlDataModel.mType == -1) {
                this.mBizControlMap.get(bizControlDataModel.mBizControlType).addClickObserver(bizControlDataModel.mObserver);
                return;
            }
            BaseLayer baseLayer2 = this.mBizControlMap.get(bizControlDataModel.mBizControlType).getBaseLayer(bizControlDataModel.mType);
            if (baseLayer2 != null) {
                baseLayer2.addClickObserver(bizControlDataModel.mObserver);
            }
        }
    }

    private void addClickObserver(String str, int i, IXpLayerClickObserver iXpLayerClickObserver) {
        BaseLayer baseLayer = this.mBizControlMap.get(str).getBaseLayer(i);
        if (baseLayer != null) {
            baseLayer.addClickObserver(iXpLayerClickObserver);
        }
    }

    public void removeClickObserver(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || bizControlDataModel.mObserver == null) {
            return;
        }
        ArrayList<String> arrayList = bizControlDataModel.mBizControlList;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (bizControlDataModel.mType == -1) {
                    this.mBizControlMap.get(arrayList.get(i)).removeClickObserver(bizControlDataModel.mObserver);
                } else {
                    this.mBizControlMap.get(arrayList.get(i)).getBaseLayer(bizControlDataModel.mType);
                }
            }
        } else if (!TextUtils.isEmpty(bizControlDataModel.mBizControlType)) {
            if (bizControlDataModel.mType == -1) {
                this.mBizControlMap.get(bizControlDataModel.mBizControlType).removeClickObserver(bizControlDataModel.mObserver);
                return;
            }
            BaseLayer baseLayer = this.mBizControlMap.get(bizControlDataModel.mBizControlType).getBaseLayer(bizControlDataModel.mType);
            if (baseLayer != null) {
                baseLayer.removeClickObserver(bizControlDataModel.mObserver);
            }
        }
    }

    public void removeItem(BizControlDataModel bizControlDataModel) {
        BaseLayer baseLayer;
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType) || TextUtils.isEmpty(bizControlDataModel.mItemID) || (baseLayer = this.mBizControlMap.get(bizControlDataModel.mBizControlType).getBaseLayer(bizControlDataModel.mType)) == null) {
            return;
        }
        baseLayer.removeItem(bizControlDataModel.mItemID);
    }

    public void setFocus(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType) || TextUtils.isEmpty(bizControlDataModel.mItemID)) {
            return;
        }
        this.mBizControlMap.get(bizControlDataModel.mBizControlType).setFocus(bizControlDataModel.mBizType, bizControlDataModel.mItemID, bizControlDataModel.mFocus);
    }

    public void updateSearchPolygon(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        this.mSearchControlProxy.updateSearchPolygon(bizPolygonBusinessInfo);
    }

    public void updateFavoriteMain(ArrayList<BizUserFavoritePoint> arrayList) {
        this.mUserControlProxy.updateFavoriteMain(arrayList);
    }

    public void updateCustomPoint(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || CollectionUtils.isEmpty(bizControlDataModel.mCustomPoints)) {
            return;
        }
        this.mCustomControlProxy.updateCustomPoint(bizControlDataModel.mCustomPoints, bizControlDataModel.mType);
    }

    public void removeItems(BizControlDataModel bizControlDataModel) {
        BaseLayer baseLayer;
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType) || CollectionUtils.isEmpty(bizControlDataModel.mItemIDs) || (baseLayer = this.mBizControlMap.get(bizControlDataModel.mBizControlType).getBaseLayer(bizControlDataModel.mType)) == null) {
            return;
        }
        baseLayer.removeItems(bizControlDataModel.mItemIDs);
    }

    public void getAllItems(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || TextUtils.isEmpty(bizControlDataModel.mBizControlType) || bizControlDataModel.mIBizControlListener == null || !(bizControlDataModel.mIBizControlListener instanceof IBizAllItemsListener)) {
            return;
        }
        BaseLayer baseLayer = this.mBizControlMap.get(bizControlDataModel.mBizControlType).getBaseLayer(bizControlDataModel.mType);
        if (baseLayer == null) {
            ((IBizAllItemsListener) bizControlDataModel.mIBizControlListener).onGetAllItems(null);
        } else {
            ((IBizAllItemsListener) bizControlDataModel.mIBizControlListener).onGetAllItems(baseLayer.getAllItems());
        }
    }

    public void updateCarStyle(@BizCarType.BizCarType1 int i) {
        this.mCarControlProxy.updateCarStyle(i);
    }

    public CarLoc getCarPosition() {
        return this.mCarControlProxy.getCarPosition();
    }

    public void setCarPosition(CarLoc carLoc) {
        if (!checkMapViewValid() || carLoc == null) {
            return;
        }
        if (!CollectionUtils.isEmpty(carLoc.vecPathMatchInfo) && carLoc.vecPathMatchInfo.get(0) != null) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setCarLocation : CarLocation [ lot -> " + carLoc.vecPathMatchInfo.get(0).longitude + " lat -> " + carLoc.vecPathMatchInfo.get(0).latitude + " carDir -> " + carLoc.vecPathMatchInfo.get(0).carDir + " ]", getMainEngineID()));
        }
        this.mCarControlProxy.setCarPosition(carLoc);
    }

    public void setCarPosition(BizControlDataModel bizControlDataModel) {
        if (!checkMapViewValid() || bizControlDataModel == null) {
            return;
        }
        if (bizControlDataModel.mCarLoc != null && CollectionUtils.isEmpty(bizControlDataModel.mCarLoc.vecPathMatchInfo) && bizControlDataModel.mCarLoc.vecPathMatchInfo.get(0) != null) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setCarLocation : CarLocation [ lot -> " + bizControlDataModel.mCarLoc.vecPathMatchInfo.get(0).longitude + " lat -> " + bizControlDataModel.mCarLoc.vecPathMatchInfo.get(0).latitude + " carDir -> " + bizControlDataModel.mCarLoc.vecPathMatchInfo.get(0).carDir + " ]", getMainEngineID()));
        }
        this.mCarControlProxy.setCarPosition(bizControlDataModel.mCarLoc);
    }

    public void initMiniCarScaleByMapLevel() {
        float[] fArr = new float[21];
        Arrays.fill(fArr, 0, 20, 0.7f);
        this.mCarControlProxy.setCarScaleByMapLevel(fArr);
    }

    public void clearNaviData() {
        removeRoute(BLParams.RouteOverlayGuide, true);
        hideCross(3, null);
        hideCross(4, null);
        setVisible(BIZ_CONTROL_TYPE_ROADCROSS, 4002, false);
    }

    public void remoteClearRenderRoutes() {
        removeRoute(769, true);
        setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, false);
    }

    public void updateRoute(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null) {
            return;
        }
        if (bizControlDataModel.isClearOldOverlay) {
            clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
            removeRoute(769, bizControlDataModel.isClearData);
            removeRoute(BLParams.RouteOverlayGuide, bizControlDataModel.isClearData);
        }
        drawRoute(bizControlDataModel);
        setCarLineAndNaviEndVisible(true);
    }

    public void unInitBIzControl() {
        this.mGlMapViewInitialized = false;
        this.mMapView = null;
        this.mCustomMapListener = null;
        this.mBizService = null;
        this.mPrepareLayerStyle = null;
        this.mAGroupControlProxy.unInit();
        this.mAreaControlProxy.unInit();
        this.mCarControlProxy.unInit();
        this.mGuideEagleEyeControlProxy.unInit();
        this.mGuideRouteControlProxy.unInit();
        this.mLabelControlProxy.unInit();
        this.mRoadCrossControlProxy.unInit();
        this.mRoadFacilityControlProxy.unInit();
        this.mSearchControlProxy.unInit();
        this.mUserControlProxy.unInit();
        this.mCustomControlProxy.unInit();
        this.mFlyLineControlProxy.unInit();
    }

    public void stopNavi() {
        this.mUserControlProxy.clearAllItems(8001L);
        this.mUserControlProxy.clearAllItems(8003L);
        this.mUserControlProxy.clearFocus(8001L);
        this.mUserControlProxy.clearFocus(8003L);
        this.mSearchControlProxy.clearAllItems(7002L);
        this.mSearchControlProxy.clearAllItems(7003L);
    }

    public void clearOverlay() {
        removeRoute(BLParams.RouteOverlayGuide, true);
        clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
        setVisible(BIZ_CONTROL_TYPE_ROADCROSS, 4002, false);
        hideCross(3, null);
        hideCross(4, null);
    }

    public void updateMapWhenExit(IXpLayerClickObserver iXpLayerClickObserver) {
        removeRoute(769, true);
        setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, false);
        this.mGuideRouteControlProxy.removeClickObserver(iXpLayerClickObserver);
        this.mRoadFacilityControlProxy.removeClickObserver(iXpLayerClickObserver);
    }

    public void setRadarState() {
        setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, SettingBLManager.isRadarEnableInNavigation());
        setVisible(BIZ_CONTROL_TYPE_ROADFACILITY, BizRoadFacilityType.BizRoadFacilityTypeGuideTrafficEvent, SettingBLManager.isRadarEnableInNavigation());
    }

    public void clearAOIPolygon() {
        clearAllItems(BIZ_CONTROL_TYPE_SEARCH, 7002L);
        clearAllItems(BIZ_CONTROL_TYPE_SEARCH, 7003L);
    }

    public void renderAoiAreaInfo(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        updateSearchPolygon(bizPolygonBusinessInfo);
        setVisible(BIZ_CONTROL_TYPE_SEARCH, BizSearchType.BizSearchTypePoiEndAreaPolygon, true);
        setVisible(BIZ_CONTROL_TYPE_SEARCH, BizSearchType.BizSearchTypePoiEndAreaPolyline, true);
    }

    public void addMapOverLayItems(XPPointBaseData[] xPPointBaseDataArr) {
        clearAllItems(BIZ_CONTROL_TYPE_USER, 8001L);
        clearAllItems(BIZ_CONTROL_TYPE_USER, 8003L);
        this.mUserControlProxy.clearFocus(8001L);
        this.mUserControlProxy.clearFocus(8003L);
        addItems(BIZ_CONTROL_TYPE_USER, BizUserType.BizUserTypeGpsTrack, NavCoreUtil.translationLayerItems(BizUserType.BizUserTypeGpsTrack, xPPointBaseDataArr));
        addItems(BIZ_CONTROL_TYPE_USER, BizUserType.BizUserTypeSendToCar, NavCoreUtil.translationLayerItems(BizUserType.BizUserTypeSendToCar, xPPointBaseDataArr));
    }

    public void drawPolygonByPoint(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        clearAllItems(BIZ_CONTROL_TYPE_SEARCH, 7002L);
        clearAllItems(BIZ_CONTROL_TYPE_SEARCH, 7003L);
        updateSearchPolygon(bizPolygonBusinessInfo);
        setVisible(BIZ_CONTROL_TYPE_SEARCH, BizSearchType.BizSearchTypePoiEndAreaPolygon, true);
        setVisible(BIZ_CONTROL_TYPE_SEARCH, BizSearchType.BizSearchTypePoiEndAreaPolyline, true);
    }

    public void deletePath() {
        clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
        removeRoute(BLParams.RouteOverlayGuide, true);
    }

    public void refreshMultiAlternativeLabel() {
        clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
        removeRoute(BLParams.RouteOverlayGuide, false);
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        int currentNaviPathIndex = TBTManager.getInstance().getCurrentNaviPathIndex();
        if (-1 != currentNaviId) {
            drawRoute(BLParams.RouteOverlayGuide, TBTManager.getInstance().getCurrentNaviPathResult(), TBTManager.getInstance().getCurrentNaviRouteParams(), currentNaviPathIndex, true);
        }
        setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, SettingBLManager.isRadarEnableInNavigation());
    }

    public void showCharges(XPPointBaseData[] xPPointBaseDataArr, int i) {
        clearAllItems(BIZ_CONTROL_TYPE_CUSTOM, i);
        clearFocus(BIZ_CONTROL_TYPE_CUSTOM, i);
        setVisible(BIZ_CONTROL_TYPE_CUSTOM, i, true);
        addItems(BIZ_CONTROL_TYPE_CUSTOM, i, NavCoreUtil.translationLayerItems(i, xPPointBaseDataArr));
    }

    public void routeChargeDecorator(IXpLayerClickObserver iXpLayerClickObserver, int i) {
        setVisible(BIZ_CONTROL_TYPE_CUSTOM, i, true);
        addClickObserver(BIZ_CONTROL_TYPE_CUSTOM, i, iXpLayerClickObserver);
    }

    public void restoreStatus(boolean z) {
        if (z) {
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, true);
        }
    }

    public void resetStatus(boolean z) {
        if (z) {
            setVisible(BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, false);
        }
    }

    public void switchRecommendRoute() {
        clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
        removeRoute(769, true);
        removeRoute(BLParams.RouteOverlayGuide, true);
    }

    public void clearOldOverlay(boolean z) {
        clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
        removeRoute(769, z);
        removeRoute(BLParams.RouteOverlayGuide, z);
    }

    public void hideCrossUI(IBizCrossListener iBizCrossListener) {
        setVisible(BIZ_CONTROL_TYPE_ROADCROSS, 4002, false);
        hideCross(3, iBizCrossListener);
    }

    public void deleteCandidatePath() {
        clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
        removeRoute(769, true);
        removeRoute(BLParams.RouteOverlayGuide, true);
    }

    public void drawGPSandDRDataClearOverlay() {
        clearAllItems(BIZ_CONTROL_TYPE_USER, 8001L);
        clearAllItems(BIZ_CONTROL_TYPE_USER, 8003L);
    }

    public void drawGPSandDRDataAddIOverlay(BizControlDataModel bizControlDataModel) {
        if (bizControlDataModel == null || CollectionUtils.isEmpty(bizControlDataModel.mOverlaysCp) || CollectionUtils.isEmpty(bizControlDataModel.mOverlaysTrace)) {
            return;
        }
        clearAllItems(BIZ_CONTROL_TYPE_USER, 8001L);
        addItems(BIZ_CONTROL_TYPE_USER, BizUserType.BizUserTypeGpsTrack, NavCoreUtil.translationLayerItems(BizUserType.BizUserTypeGpsTrack, bizControlDataModel.mOverlaysCp));
        addItems(BIZ_CONTROL_TYPE_USER, BizUserType.BizUserTypeSendToCar, NavCoreUtil.translationLayerItems(BizUserType.BizUserTypeSendToCar, bizControlDataModel.mOverlaysTrace));
    }

    public void setTestMode() {
        clearAllItems(BIZ_CONTROL_TYPE_USER, 8001L);
        clearAllItems(BIZ_CONTROL_TYPE_USER, 8003L);
    }

    public void clearGuideRouteOverlay() {
        clearAllItems(BIZ_CONTROL_TYPE_GUIDEROUTE, 6028L);
        removeRoute(769, true);
        removeRoute(BLParams.RouteOverlayGuide, true);
    }

    public void guideDeletePath() {
        removeRouteCache();
    }

    private int getMapMode() {
        if (checkMapViewValid()) {
            int mapMode = this.mMapView.getMapMode();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getMapMode ： " + mapMode, getMainEngineID()));
            }
            return mapMode;
        }
        return 0;
    }

    public void setOperatorFlyline() {
        if (checkMapViewValid()) {
            this.mFlyLineControlProxy.setClickLabelMoveMap(false);
        }
    }

    public void setFlyLineStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (!checkMapViewValid() || iPrepareLayerStyle == null) {
            return;
        }
        this.mFlyLineControlProxy.setStyle(iPrepareLayerStyle);
    }

    public void setDrawFlyLine(BizControlDataModel bizControlDataModel) {
        if (!checkMapViewValid() || bizControlDataModel == null) {
            return;
        }
        this.mFlyLineControlProxy.setDrawFlyLine(bizControlDataModel.bShowLine, bizControlDataModel.bShowPoint);
    }

    public void updateOddInfo(List<XPOddInfo> list) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("updateOddInfo size = ");
            sb.append(list == null ? 0 : list.size());
            L.i(tag, sb.toString());
            this.mGuideRouteControlProxy.setODDDrawMode(1);
            ArrayList<BizOddInfo> arrayList = new ArrayList<>();
            for (XPOddInfo xPOddInfo : list) {
                if (xPOddInfo != null) {
                    BizOddInfo bizOddInfo = new BizOddInfo();
                    bizOddInfo.oddSegInfo.m_StartSegIdx = xPOddInfo.mStartSegIdx;
                    bizOddInfo.oddSegInfo.m_StartLinkIdx = xPOddInfo.mStartLinkIdx;
                    bizOddInfo.oddSegInfo.m_StartOffSet = xPOddInfo.mStartOffSet;
                    bizOddInfo.oddSegInfo.m_EndSegIdx = xPOddInfo.mEndSegIdx;
                    bizOddInfo.oddSegInfo.m_EndLinkIdx = xPOddInfo.mEndLinkIdx;
                    bizOddInfo.oddSegInfo.m_EndOffSet = xPOddInfo.mEndOffSet;
                    for (XPCoord3DDouble xPCoord3DDouble : xPOddInfo.mPoints) {
                        bizOddInfo.vecPoints.add(BLDataModelUtil.toBLCoord3DDouble(xPCoord3DDouble));
                    }
                    arrayList.add(bizOddInfo);
                }
            }
            this.mGuideRouteControlProxy.updateOddInfo(arrayList);
        }
    }

    public void setViewPostureEvent(int i, int i2) {
        if (checkMapViewValid()) {
            this.mRoadCrossControlProxy.setViewPostureEvent(i, i2);
        }
    }

    public boolean is3DCrossShow() {
        return this.mIs3DCrossShow;
    }
}
