package com.xiaopeng.montecarlo.navcore.control;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizCarType;
import com.autonavi.gbl.layer.model.BizCustomPointInfo;
import com.autonavi.gbl.layer.model.BizCustomTypePoint;
import com.autonavi.gbl.layer.model.BizPolygonBusinessInfo;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.layer.model.DynamicLevelType;
import com.autonavi.gbl.layer.model.EagleEyeStyle;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.control.base.IBizAllItemsListener;
import com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener;
import com.xiaopeng.montecarlo.navcore.control.base.IBizDynamicLevelListener;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.util.CalculatePreviewUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.BizControlDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BizControlManager {
    private static final int MSG_ADD_AGROUP_MEMBERS = 138;
    private static final int MSG_ADD_CLICK_OBSERVER = 142;
    private static final int MSG_ADD_ITEMS = 135;
    private static final int MSG_ADD_MAP_OVERLAYI_TEMS = 161;
    private static final int MSG_ADJUST_EAGLEYE_POSITION = 126;
    private static final int MSG_BACKGROUND_FLAG = 190;
    private static final int MSG_CLEAR_ALL_ITEMS = 134;
    private static final int MSG_CLEAR_AOI_POLYGON = 159;
    private static final int MSG_CLEAR_EAGLEYE_ROUTE = 121;
    private static final int MSG_CLEAR_FOCUS = 141;
    private static final int MSG_CLEAR_GUIDE_ROUTE_OVERLAY = 176;
    private static final int MSG_CLEAR_NAVI_DATA = 152;
    private static final int MSG_CLEAR_OLD_OVERLAY = 170;
    private static final int MSG_CLEAR_OVERLAY = 156;
    private static final int MSG_DELETE_CANDIDATE_PATH = 172;
    private static final int MSG_DELETE_PATH = 163;
    private static final int MSG_DISABLE_EAGLEEYE_STATE = 129;
    private static final int MSG_DRAW_COMPARING_ROUTES = 101;
    private static final int MSG_DRAW_GPSANDDR_DATA_ADDIOVERLAY = 174;
    private static final int MSG_DRAW_GPSANDDR_DATA_CLEAROVERLAY = 173;
    private static final int MSG_DRAW_POLYGON_BY_POINT = 162;
    private static final int MSG_DRAW_ROUTE = 100;
    private static final int MSG_GET_ALL_ITEMS = 183;
    private static final int MSG_GUIDE_DELETE_PATH = 177;
    private static final int MSG_GUIDE_EAGLEEYE_CLEAR_PATH = 140;
    private static final int MSG_HIDE_CROSS = 102;
    private static final int MSG_HIDE_CROSS_UI = 171;
    private static final int MSG_INIT_BIZCONTROL = 180;
    private static final int MSG_INIT_BIZSERVICE = 181;
    private static final int MSG_INIT_CAR = 108;
    private static final int MSG_INIT_CAR_SCALE_BYMAP_LEVEL = 109;
    private static final int MSG_INIT_CRUISE_CAR = 115;
    private static final int MSG_INIT_EAGLEEYE = 128;
    private static final int MSG_INIT_LANE_CAR = 188;
    private static final int MSG_INIT_MINICAR_SCALE_BY_MAPLEVEL = 151;
    private static final int MSG_INIT_NAVI_CAR = 114;
    private static final int MSG_INIT_ROUTE_CAR = 111;
    private static final int MSG_ON_EXPLORE_POI_HIDE = 178;
    private static final int MSG_OPEN_DYNAMIC_LEVEL = 122;
    private static final int MSG_OPEN_DYNAMIC_LEVEL_NO_TYPE = 123;
    private static final int MSG_REFRESH_MULTI_ALTERNATIVE_LABEL = 164;
    private static final int MSG_REMOTE_CLEAR_RENDER_ROUTES = 153;
    private static final int MSG_REMOVE_CLICK_OBSERVER = 143;
    private static final int MSG_REMOVE_ITEM = 144;
    private static final int MSG_REMOVE_ITEMS = 149;
    private static final int MSG_REMOVE_ROUTE = 117;
    private static final int MSG_REMOVE_ROUTE_CACHE = 120;
    private static final int MSG_RENDER_AOI_AREAINFO = 160;
    private static final int MSG_RESET_STATUS = 168;
    private static final int MSG_RESTORE_RADARLABEL_VISIBILITY = 131;
    private static final int MSG_RESTORE_STATUS = 167;
    private static final int MSG_ROUTE_CHANGED_BACKGROUND = 191;
    private static final int MSG_ROUTE_CHARGE_DECORATOR = 166;
    private static final int MSG_SET_CAR2END_LINE = 107;
    private static final int MSG_SET_CARLINE_VISIBLE = 106;
    private static final int MSG_SET_CAR_LINEANDNAVIEND_VISIBLE = 105;
    private static final int MSG_SET_CAR_UP_MODE = 113;
    private static final int MSG_SET_CLICKABLE = 137;
    private static final int MSG_SET_DRAW_FLY_LINE = 186;
    private static final int MSG_SET_FLY_LINE_STYLE = 185;
    private static final int MSG_SET_FOCUS = 145;
    private static final int MSG_SET_FOLLOW_MODE = 112;
    private static final int MSG_SET_OPERATOR_FLY_LINE = 184;
    private static final int MSG_SET_PREVIEW_MODE = 124;
    private static final int MSG_SET_RADAR_STATE = 158;
    private static final int MSG_SET_ROUTE_ARROW_SHOW_SEGMENT = 103;
    private static final int MSG_SET_SELECTED_PATH = 119;
    private static final int MSG_SET_STYLE = 182;
    private static final int MSG_SET_TEST_MODE = 175;
    private static final int MSG_SET_VIEW_POSTURE_EVENT = 189;
    private static final int MSG_SET_VISIBLE = 136;
    private static final int MSG_SHOW_CHARGES = 165;
    private static final int MSG_SHOW_CROSS_CALL_BACK = 132;
    private static final int MSG_SHOW_EAGLEYE = 125;
    private static final int MSG_STOP_NAVI = 155;
    private static final int MSG_SWITCH_RECOMMEND_ROUTE = 169;
    private static final int MSG_UN_INIT_BIZCONTROL = 179;
    private static final int MSG_UPDATE_CARSTYLE = 150;
    private static final int MSG_UPDATE_CAR_MARK_STYLE = 192;
    private static final int MSG_UPDATE_CUSTOM_POINT = 148;
    private static final int MSG_UPDATE_EAGLE_MAP_SHOW_MODE = 127;
    private static final int MSG_UPDATE_FAVORITE_MAIN = 147;
    private static final int MSG_UPDATE_MAP_EAGLEEYE_VIEW = 130;
    private static final int MSG_UPDATE_MAP_WHEN_EXIT = 157;
    private static final int MSG_UPDATE_ODD_INFO = 187;
    private static final int MSG_UPDATE_RES_MARKER = 110;
    private static final int MSG_UPDATE_ROUTE = 154;
    private static final int MSG_UPDATE_ROUTE_OVERLAY_ELEM = 104;
    private static final int MSG_UPDATE_ROUTE_RESTRICT = 139;
    private static final int MSG_UPDATE_ROUTE_TMC = 118;
    private static final int MSG_UPDATE_SEARCH_POLYGON = 146;
    private static final L.Tag TAG = new L.Tag("BizControlManager");
    private BizControlWrapper mBizControlWrapper;
    private BizControlDataModel mLastBizControlDataModel = null;
    private Looper mLooper;
    private boolean mUpdateMapEagleEyeViewRefreshRoute;
    private boolean mUpdateMapEagleEyeViewShow;
    private Handler mWorkHandler;
    private final MapViewWrapper mapViewWrapper;

    public BizControlManager(MapViewWrapper mapViewWrapper) {
        this.mapViewWrapper = mapViewWrapper;
    }

    public void init(int i, Looper looper) {
        this.mBizControlWrapper = new BizControlWrapper(this, this.mapViewWrapper);
        this.mLooper = looper;
        this.mWorkHandler = new Handler(looper);
        ServiceMgr.getServiceMgrInstance().setUiLooper(i, looper);
    }

    public void initBizControl(MapView mapView, IMapListener iMapListener) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mapView = mapView;
        bizControlDataModel.iMapListener = iMapListener;
        removeMessages(180);
        runOnBizThread(180, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$-5rPp3sJzfXAnSdb0PLHRxt2ER0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initBizControl$0$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$initBizControl$0$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.initBizControl(bizControlDataModel);
    }

    public void initBizService(final int i) {
        removeMessages(181);
        runOnBizThread(181, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$qdh-7Q8P_zvyme7PE3zRFPj3XGM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initBizService$1$BizControlManager(i);
            }
        });
    }

    public /* synthetic */ void lambda$initBizService$1$BizControlManager(int i) {
        this.mBizControlWrapper.initBizService(i);
    }

    public void initEagleEye(final EagleEyeStyle eagleEyeStyle) {
        removeMessages(128);
        runOnBizThread(128, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$wgAGBO0FruBGHeOvN0eZX72SI8A
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initEagleEye$2$BizControlManager(eagleEyeStyle);
            }
        });
    }

    public /* synthetic */ void lambda$initEagleEye$2$BizControlManager(EagleEyeStyle eagleEyeStyle) {
        this.mBizControlWrapper.initEagleEye(eagleEyeStyle);
    }

    public boolean isInitBizService() {
        return this.mBizControlWrapper.isInitBizService();
    }

    public void setStyle(@MapEngineID.MapEngineID1 final int i, final IPrepareLayerStyle iPrepareLayerStyle) {
        runOnBizThread(182, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$vv8EFa3Suxq-WPDV2yqVnKEGdiI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setStyle$3$BizControlManager(i, iPrepareLayerStyle);
            }
        });
    }

    public /* synthetic */ void lambda$setStyle$3$BizControlManager(@MapEngineID.MapEngineID1 int i, IPrepareLayerStyle iPrepareLayerStyle) {
        this.mBizControlWrapper.setStyle(i, iPrepareLayerStyle);
    }

    public void updateCarMarkStyle() {
        removeMessages(192);
        runOnBizThread(192, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$BvpqxU_vNibUjD3MrXyab6wA9RE
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateCarMarkStyle$4$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$updateCarMarkStyle$4$BizControlManager() {
        this.mBizControlWrapper.updateCarMarkStyle();
    }

    public void unInitBizControl() {
        removeMessages(179);
        runOnBizThread(179, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$hUiH3hvz7xj8FetEurRWlcTZv2U
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$unInitBizControl$5$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$unInitBizControl$5$BizControlManager() {
        this.mBizControlWrapper.unInitBIzControl();
    }

    @MainThread
    public RectDouble drawRoute(int i, @NonNull IPathResult iPathResult, RouteParams routeParams, long j, int i2, boolean z) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mType = i;
        bizControlDataModel.mPathResult = iPathResult;
        if (bizControlDataModel.mPathResult != null) {
            bizControlDataModel.mPathResult.addRef();
        }
        bizControlDataModel.mRouteParams = routeParams;
        bizControlDataModel.mRequestId = j;
        bizControlDataModel.mSelectedIndex = i2;
        bizControlDataModel.isNavi = z;
        TBTManager.getInstance().updateCurrentRouteInfo(bizControlDataModel.mRequestId, bizControlDataModel.mSelectedIndex);
        if (hasMessages(100)) {
            removeMessages(100);
            BizControlDataModel bizControlDataModel2 = this.mLastBizControlDataModel;
            if (bizControlDataModel2 != null && bizControlDataModel2.mPathResult != null) {
                this.mLastBizControlDataModel.mPathResult.delRef();
            }
        }
        this.mLastBizControlDataModel = bizControlDataModel;
        runOnBizThread(100, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$MeTlovy11R6-QTymE5JYjfxkdHM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawRoute$6$BizControlManager(bizControlDataModel);
            }
        });
        return CalculatePreviewUtil.getPathBound(iPathResult);
    }

    public /* synthetic */ void lambda$drawRoute$6$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.drawRoute(bizControlDataModel);
    }

    public void drawComparingRoutes(int i, int i2, int i3, boolean z, RouteParams routeParams, IVariantPath... iVariantPathArr) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mType = i;
        bizControlDataModel.mSelectedIndex = i2;
        bizControlDataModel.mNewRouteIndex = i3;
        bizControlDataModel.isNavi = z;
        bizControlDataModel.mRouteParams = routeParams;
        bizControlDataModel.mPaths = (IVariantPath[]) iVariantPathArr.clone();
        removeMessages(101);
        runOnBizThread(101, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$sSdjzq9u-M2Bn4OYBECVJWUht2s
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawComparingRoutes$7$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$drawComparingRoutes$7$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.drawComparingRoutes(bizControlDataModel);
    }

    public void hideCross(final int i, final IBizCrossListener iBizCrossListener) {
        runOnBizThread(102, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$acJVWsRdZGhMNXcDWe9oixKyEVI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$hideCross$8$BizControlManager(i, iBizCrossListener);
            }
        });
    }

    public /* synthetic */ void lambda$hideCross$8$BizControlManager(int i, IBizCrossListener iBizCrossListener) {
        this.mBizControlWrapper.hideCross(i, iBizCrossListener);
    }

    public void setRouteArrowShowSegment(final ArrayList<Long> arrayList) {
        removeMessages(103);
        runOnBizThread(103, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ABpS_A-_ppGszuXh-h3pLOztlj4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setRouteArrowShowSegment$9$BizControlManager(arrayList);
            }
        });
    }

    public /* synthetic */ void lambda$setRouteArrowShowSegment$9$BizControlManager(ArrayList arrayList) {
        this.mBizControlWrapper.setRouteArrowShowSegment(arrayList);
    }

    public void updateRouteOverlayElem(final RouteParams routeParams) {
        removeMessages(104);
        runOnBizThread(104, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$npfO-nUAAwSU2SjpytfanBww78E
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRouteOverlayElem$10$BizControlManager(routeParams);
            }
        });
    }

    public /* synthetic */ void lambda$updateRouteOverlayElem$10$BizControlManager(RouteParams routeParams) {
        this.mBizControlWrapper.updateRouteOverlayElem(routeParams);
    }

    public void setCarLineAndNaviEndVisible(final boolean z) {
        removeMessages(105);
        runOnBizThread(105, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$0So084lcAJDM7gpArPeHspGWTwg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCarLineAndNaviEndVisible$11$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setCarLineAndNaviEndVisible$11$BizControlManager(boolean z) {
        this.mBizControlWrapper.setCarLineAndNaviEndVisible(z);
    }

    public void setCarLineVisible(final boolean z) {
        removeMessages(106);
        runOnBizThread(106, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$7CdhNcbxAxeBTuNDsUOoWgJ43I0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCarLineVisible$12$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setCarLineVisible$12$BizControlManager(boolean z) {
        this.mBizControlWrapper.setCarLineVisible(z);
    }

    public void setCar2EndLine(final double d, final double d2) {
        removeMessages(107);
        runOnBizThread(107, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$UXEGu57qgLsVf6PvF8O1euDUmNs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCar2EndLine$13$BizControlManager(d, d2);
            }
        });
    }

    public /* synthetic */ void lambda$setCar2EndLine$13$BizControlManager(double d, double d2) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mLat = d;
        bizControlDataModel.mLon = d2;
        this.mBizControlWrapper.setCar2EndLine(bizControlDataModel);
    }

    public void initCar(IPrepareLayerStyle iPrepareLayerStyle, CarLoc carLoc) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mMapStyleReader = iPrepareLayerStyle;
        bizControlDataModel.mCarLoc = carLoc;
        removeMessages(108);
        runOnBizThread(108, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$4EXhRE7T8q41Oxu6Vw9hLEu6HDc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initCar$14$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$initCar$14$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.initCar(bizControlDataModel);
        this.mBizControlWrapper.initCarScaleByMapLevel();
    }

    public void initCarScaleByMapLevel() {
        removeMessages(109);
        runOnBizThread(109, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$9tmpAJPfunUZyhSWx4Z5oavYXow
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initCarScaleByMapLevel$15$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initCarScaleByMapLevel$15$BizControlManager() {
        this.mBizControlWrapper.initCarScaleByMapLevel();
    }

    public void updateResMarker(final boolean z) {
        removeMessages(110);
        runOnBizThread(110, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$9r5HeW1Cg2UO6PCri0XHNjJgRwU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateResMarker$16$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$updateResMarker$16$BizControlManager(boolean z) {
        this.mBizControlWrapper.updateResMarker(z);
    }

    public void initRouteCar() {
        removeMessages(111);
        runOnBizThread(111, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$RPw-2YyJ-5-8QrTJlPHVcvG9XSo
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initRouteCar$17$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initRouteCar$17$BizControlManager() {
        this.mBizControlWrapper.initRouteCar();
    }

    public void initNaviCar(final boolean z) {
        setFollowMode(true);
        removeMessages(114);
        runOnBizThread(114, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$NuVwqNQ6gBWHoWtzsuqSd65nQeY
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initNaviCar$18$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$initNaviCar$18$BizControlManager(boolean z) {
        this.mBizControlWrapper.initNaviCar(z);
    }

    public void initLaneCar() {
        setFollowMode(false);
        removeMessages(188);
        runOnBizThread(188, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$BZzUSXbU4z0cL7xE2BEkKh7xIT0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initLaneCar$19$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initLaneCar$19$BizControlManager() {
        this.mBizControlWrapper.initLaneCar();
    }

    public void initCruiseCar(boolean z) {
        setFollowMode(z);
        removeMessages(115);
        runOnBizThread(115, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$xXt2c6bU4JlR82bPFTUOKDtsw48
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initCruiseCar$20$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initCruiseCar$20$BizControlManager() {
        this.mBizControlWrapper.initCruiseCar();
    }

    @Nullable
    public CarLoc getCarLocation() {
        return this.mBizControlWrapper.getCarLocation();
    }

    public void setCarLocation(@Nullable CarLoc carLoc) {
        this.mBizControlWrapper.setCarPosition(carLoc);
    }

    public void setCarLocation(@Nullable Location location) {
        if (location == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setCarLocation : location [ lat -> " + location.getLatitude() + ", lot -> " + location.getLongitude() + " ]");
        }
        CarLoc carLoc = new CarLoc();
        PathMatchInfo pathMatchInfo = new PathMatchInfo();
        pathMatchInfo.longitude = location.getLongitude();
        pathMatchInfo.latitude = location.getLatitude();
        carLoc.vecPathMatchInfo = new ArrayList<>();
        carLoc.vecPathMatchInfo.add(pathMatchInfo);
        setCarLocation(carLoc);
    }

    public void removeRoute(final int i, final boolean z) {
        removeMessages(117);
        runOnBizThread(117, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Go61qzHE89kBTXoIS9doUGE-bS0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeRoute$21$BizControlManager(i, z);
            }
        });
    }

    public /* synthetic */ void lambda$removeRoute$21$BizControlManager(int i, boolean z) {
        this.mBizControlWrapper.removeRoute(i, z);
    }

    public void updateRouteTmc(final List<ILightBarInfo> list) {
        removeMessages(118);
        runOnBizThread(118, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ZlphikZce3h-2KFmXDvkv1PzpOU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRouteTmc$22$BizControlManager(list);
            }
        });
    }

    public /* synthetic */ void lambda$updateRouteTmc$22$BizControlManager(List list) {
        this.mBizControlWrapper.updateRouteTmc(list);
    }

    public void setSelectedPath(int i, long j, int i2) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mType = i;
        bizControlDataModel.mRequestId = j;
        bizControlDataModel.mIndex = i2;
        TBTManager.getInstance().updateCurrentRouteInfo(bizControlDataModel.mRequestId, bizControlDataModel.mIndex);
        removeMessages(119);
        runOnBizThread(119, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$3OgLFs7ImuceD2RVLE79NonRLvs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setSelectedPath$23$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$setSelectedPath$23$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.setSelectedPath(bizControlDataModel);
    }

    public void removeRouteCache() {
        removeMessages(120);
        runOnBizThread(120, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ytiu2D9DQRVflQngxMGKRz0vzmU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeRouteCache$24$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$removeRouteCache$24$BizControlManager() {
        this.mBizControlWrapper.removeRouteCache();
    }

    public void clearEagleyeRoute() {
        removeMessages(121);
        runOnBizThread(121, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$mTMUQsdogyI2jW4vcV1X_Z0cVRw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearEagleyeRoute$25$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearEagleyeRoute$25$BizControlManager() {
        this.mBizControlWrapper.clearEagleyeRoute();
    }

    public void showCross(@Nullable final XPCrossImageInfo xPCrossImageInfo, final IBizCrossListener iBizCrossListener) {
        runOnBizThread(132, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$vbvczH-x-zH1BwJaibcMtC7I4Wc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$showCross$26$BizControlManager(xPCrossImageInfo, iBizCrossListener);
            }
        });
    }

    public /* synthetic */ void lambda$showCross$26$BizControlManager(@Nullable XPCrossImageInfo xPCrossImageInfo, IBizCrossListener iBizCrossListener) {
        this.mBizControlWrapper.showCrossCallBack(xPCrossImageInfo, iBizCrossListener);
    }

    public void openDynamicLevel(final boolean z, final IBizDynamicLevelListener iBizDynamicLevelListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openDynamicLevel bOpen = " + z);
        }
        runOnBizThread(122, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$8DIYcOy_jP6wVpyrL4mU1oIdPxk
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$openDynamicLevel$27$BizControlManager(z, iBizDynamicLevelListener);
            }
        });
    }

    public /* synthetic */ void lambda$openDynamicLevel$27$BizControlManager(boolean z, IBizDynamicLevelListener iBizDynamicLevelListener) {
        this.mBizControlWrapper.openDynamicLevel(z);
        if (iBizDynamicLevelListener != null) {
            iBizDynamicLevelListener.onOpenDynamicLevelFinish();
        }
    }

    public void openDynamicLevel(final boolean z, @DynamicLevelType.DynamicLevelType1 final int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openDynamicLevel bOpen = " + z + " , type = " + i);
        }
        runOnBizThread(122, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$JPaRULkuflpSXtjM3qQ5DLx76z0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$openDynamicLevel$28$BizControlManager(z, i);
            }
        });
    }

    public /* synthetic */ void lambda$openDynamicLevel$28$BizControlManager(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        this.mBizControlWrapper.openDynamicLevel(z, i);
    }

    public void setDynamicLevelLock(final boolean z, final IBizDynamicLevelListener iBizDynamicLevelListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setDynamicLevelLock bOpen = " + z);
        }
        runOnBizThread(122, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$dhmGP3M8AFzOfWVwne6rFhkWMvA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setDynamicLevelLock$29$BizControlManager(z, iBizDynamicLevelListener);
            }
        });
    }

    public /* synthetic */ void lambda$setDynamicLevelLock$29$BizControlManager(boolean z, IBizDynamicLevelListener iBizDynamicLevelListener) {
        this.mBizControlWrapper.setDynamicLevelLock(z);
        if (iBizDynamicLevelListener != null) {
            iBizDynamicLevelListener.onOpenDynamicLevelFinish();
        }
    }

    public void setDynamicLevelLock(final boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setDynamicLevelLock bOpen = " + z);
        }
        runOnBizThread(122, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$wcOW-IxBQcCtuW6MsElb7X3PY6g
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setDynamicLevelLock$30$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setDynamicLevelLock$30$BizControlManager(boolean z) {
        this.mBizControlWrapper.setDynamicLevelLock(z);
    }

    public void openDynamicLevel(final boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openDynamicLevel bOpen = " + z);
        }
        removeMessages(123);
        runOnBizThread(123, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$V0i2xTX3AOthAKnyoPPQqT0pJfs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$openDynamicLevel$31$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$openDynamicLevel$31$BizControlManager(boolean z) {
        this.mBizControlWrapper.openDynamicLevel(z);
    }

    public boolean getCarUpMode() {
        return this.mBizControlWrapper.getCarUpMode();
    }

    public void setCarUpMode(final boolean z) {
        removeMessages(113);
        runOnBizThread(113, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$z6blvCE1kCGUvAPmoRlx2-C8A3s
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCarUpMode$32$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setCarUpMode$32$BizControlManager(boolean z) {
        this.mBizControlWrapper.setCarUpMode(z);
    }

    public RectDouble getAGroupPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        return this.mBizControlWrapper.getAGroupPreviewRect(arrayList);
    }

    public boolean getPreviewMode() {
        return this.mBizControlWrapper.getPreviewMode();
    }

    public void setPreviewMode(boolean z) {
        this.mBizControlWrapper.setPreviewMode(z);
    }

    public boolean getFollowMode() {
        return this.mBizControlWrapper.getFollowMode();
    }

    public void setFollowMode(boolean z) {
        this.mBizControlWrapper.setFollowMode(z);
    }

    public boolean isInitEagleye() {
        return this.mBizControlWrapper.isInitEagleye();
    }

    public void showEagleye() {
        removeMessages(125);
        runOnBizThread(125, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$SsH_RsBiIu9zXUS4Ch5ApRX4CrI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$showEagleye$33$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$showEagleye$33$BizControlManager() {
        this.mBizControlWrapper.showEagleye();
    }

    public boolean isEagleEyeShowing() {
        return this.mBizControlWrapper.isEagleEyeShowing();
    }

    public void updateEagleMapShowMode(final int i) {
        removeMessages(127);
        runOnBizThread(127, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$CBVFMwsIo9ny3_0pKpT0Sv1zhdU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateEagleMapShowMode$34$BizControlManager(i);
            }
        });
    }

    public /* synthetic */ void lambda$updateEagleMapShowMode$34$BizControlManager(int i) {
        this.mBizControlWrapper.updateEagleMapShowMode(i);
    }

    public void disableEagleEyeState() {
        removeMessages(129);
        runOnBizThread(129, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ZYnMTkStGl8l4RbjEKlDkUlDMHo
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$disableEagleEyeState$35$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$disableEagleEyeState$35$BizControlManager() {
        this.mBizControlWrapper.disableEagleEyeState();
    }

    public void restoreRadarLabelVisibility() {
        removeMessages(131);
        runOnBizThread(131, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$yhX0VotMNI-s25wV7Fg1gn2xZ6s
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$restoreRadarLabelVisibility$36$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$restoreRadarLabelVisibility$36$BizControlManager() {
        this.mBizControlWrapper.restoreRadarLabelVisibility();
    }

    public void updateMapEagleEyeView(boolean z, boolean z2) {
        this.mUpdateMapEagleEyeViewShow = z;
        this.mUpdateMapEagleEyeViewRefreshRoute = z2;
        removeMessages(130);
        runOnBizThread(130, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$2ZUG8Aikfm6dF6FPQiX8RziGnMc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateMapEagleEyeView$37$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$updateMapEagleEyeView$37$BizControlManager() {
        this.mBizControlWrapper.updateMapEagleEyeView(this.mUpdateMapEagleEyeViewShow, this.mUpdateMapEagleEyeViewRefreshRoute);
    }

    public void adjustEagleyePosition(EagleEyeStyle eagleEyeStyle, int[] iArr) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mEagleEyeStyle = eagleEyeStyle;
        bizControlDataModel.mNewlocation = (int[]) iArr.clone();
        removeMessages(126);
        runOnBizThread(126, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$oTLrAiUzkBWGqJpa_1jFUb_j86c
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$adjustEagleyePosition$38$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$adjustEagleyePosition$38$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.adjustEagleyePosition(bizControlDataModel);
    }

    public void clearAllItems(final String str, final long j) {
        cancelRequest(str, j);
        runOnBizThread(134, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$JKkmn0i-SRa5xReq6_uOEIkpmGU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearAllItems$39$BizControlManager(str, j);
            }
        });
    }

    public /* synthetic */ void lambda$clearAllItems$39$BizControlManager(String str, long j) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mBizType = j;
        this.mBizControlWrapper.clearAllItems(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type clear item " + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype clear item " + bizControlDataModel.mBizType);
        }
    }

    public void addItems(final String str, final int i, final XPPointBaseData[] xPPointBaseDataArr) {
        runOnBizThread(135, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Np-Wd595uZlueaUOw80AICdKrjU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addItems$40$BizControlManager(i, xPPointBaseDataArr, str);
            }
        });
    }

    public /* synthetic */ void lambda$addItems$40$BizControlManager(int i, XPPointBaseData[] xPPointBaseDataArr, String str) {
        ArrayList<LayerItem> translationLayerItems = NavCoreUtil.translationLayerItems(i, xPPointBaseDataArr);
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mAddItems.addAll(translationLayerItems);
        this.mBizControlWrapper.addItems(bizControlDataModel);
    }

    public void addItems(final String str, final int i, final ArrayList<BizAGroupBusinessInfo> arrayList) {
        runOnBizThread(135, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ajMhajVMqwiCbZgKUeTse6P2OfU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addItems$41$BizControlManager(arrayList, str, i);
            }
        });
    }

    public /* synthetic */ void lambda$addItems$41$BizControlManager(ArrayList arrayList, String str, int i) {
        ArrayList<LayerItem> translateBizAGroupBusiness2LayerItems = NavCoreUtil.translateBizAGroupBusiness2LayerItems(arrayList);
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mAddItems.addAll(translateBizAGroupBusiness2LayerItems);
        this.mBizControlWrapper.addItems(bizControlDataModel);
    }

    public void removeItem(final String str, final int i, final String str2) {
        runOnBizThread(144, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$U-YQ1vNPHet6xnx_EidSdwMcbJM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeItem$42$BizControlManager(str, i, str2);
            }
        });
    }

    public /* synthetic */ void lambda$removeItem$42$BizControlManager(String str, int i, String str2) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mItemID = str2;
        this.mBizControlWrapper.removeItem(bizControlDataModel);
    }

    public void setVisible(final String str, final int i, final boolean z) {
        runOnBizThread(136, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$kJcsqYtGo7s7OmzejFocGCxmTDY
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setVisible$43$BizControlManager(str, i, z);
            }
        });
    }

    public /* synthetic */ void lambda$setVisible$43$BizControlManager(String str, int i, boolean z) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.isVisible = z;
        this.mBizControlWrapper.setVisible(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type visible " + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype visible " + bizControlDataModel.mType);
        }
    }

    public void setVisible(final String str, final boolean z) {
        runOnBizThread(136, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$MF0Nyr8jmb7Eax0bYuW6kcn0kww
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setVisible$44$BizControlManager(str, z);
            }
        });
    }

    public /* synthetic */ void lambda$setVisible$44$BizControlManager(String str, boolean z) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = -1;
        bizControlDataModel.isVisible = z;
        this.mBizControlWrapper.setVisible(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type visible " + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype visible " + bizControlDataModel.mType);
        }
    }

    public void setClickable(final String str, final long j, final boolean z) {
        runOnBizThread(137, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$quFvvvFOxbyMpHMpVY_FWUOET3o
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setClickable$45$BizControlManager(str, j, z);
            }
        });
    }

    public /* synthetic */ void lambda$setClickable$45$BizControlManager(String str, long j, boolean z) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mBizType = j;
        bizControlDataModel.isClickable = z;
        this.mBizControlWrapper.setClickable(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type clickble " + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype clickble " + bizControlDataModel.mBizType);
        }
    }

    public void addAGroupMembers(final XPPointBaseData[] xPPointBaseDataArr) {
        runOnBizThread(138, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$NxNwxENBJxRacNchqF-ANNFwv6w
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addAGroupMembers$46$BizControlManager(xPPointBaseDataArr);
            }
        });
    }

    public /* synthetic */ void lambda$addAGroupMembers$46$BizControlManager(XPPointBaseData[] xPPointBaseDataArr) {
        this.mBizControlWrapper.addAGroupMembers(NavCoreUtil.translationBizAGroupBusinessInfos(xPPointBaseDataArr));
    }

    public void updateRouteRestrict(final BizRouteRestrictInfo bizRouteRestrictInfo) {
        runOnBizThread(139, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$NpVPBxaK8c1E7Nqd5R5B_9T7Lcc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRouteRestrict$47$BizControlManager(bizRouteRestrictInfo);
            }
        });
    }

    public /* synthetic */ void lambda$updateRouteRestrict$47$BizControlManager(BizRouteRestrictInfo bizRouteRestrictInfo) {
        this.mBizControlWrapper.updateRouteRestrict(bizRouteRestrictInfo);
    }

    public void guideEagleEyeClearPath() {
        removeMessages(140);
        runOnBizThread(140, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$nyNuf2wE3tpdixBZknHVxfIsZGg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$guideEagleEyeClearPath$48$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$guideEagleEyeClearPath$48$BizControlManager() {
        this.mBizControlWrapper.guideEagleEyeClearPath();
    }

    public void clearFocus(final String str, final long j) {
        runOnBizThread(141, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$xWZKJs2n3JNdR_2cDioqxkKv9To
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearFocus$49$BizControlManager(str, j);
            }
        });
    }

    public /* synthetic */ void lambda$clearFocus$49$BizControlManager(String str, long j) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mBizType = j;
        this.mBizControlWrapper.clearFocus(bizControlDataModel);
    }

    public void addClickObserver(ArrayList<String> arrayList, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlList.addAll(arrayList);
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = -1;
        runOnBizThread(142, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$YV9_B3npaHmS6BjqWHBAq0Jz120
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addClickObserver$50$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$addClickObserver$50$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.addClickObserver(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type addClickObserver" + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype addClickObserver" + bizControlDataModel.mType);
        }
    }

    public void addClickObserver(ArrayList<String> arrayList, int i, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlList.addAll(arrayList);
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = i;
        runOnBizThread(142, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$07HQ9tus4ybcbCoG79vsUzh-k58
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addClickObserver$51$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$addClickObserver$51$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.addClickObserver(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type addClickObserver" + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype addClickObserver" + bizControlDataModel.mType);
        }
    }

    public void addClickObserver(String str, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = -1;
        runOnBizThread(142, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$9lXBSRtqXuLzetrCh-dwrCFMDtQ
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addClickObserver$52$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$addClickObserver$52$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.addClickObserver(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type addClickObserver" + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype addClickObserver" + bizControlDataModel.mType);
        }
    }

    public void addClickObserver(String str, int i, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = i;
        runOnBizThread(142, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$a4puE4PAcOHIp7FD5ABoZybbrXY
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addClickObserver$53$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$addClickObserver$53$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.addClickObserver(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bizcontrol type addClickObserver" + bizControlDataModel.mBizControlType);
            L.Tag tag2 = TAG;
            L.d(tag2, "biztype addClickObserver" + bizControlDataModel.mType);
        }
    }

    public void removeClickObserver(String str, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = -1;
        runOnBizThread(143, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$XKuXi8n71x2Pb_k4pQA6De-GdCc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeClickObserver$54$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeClickObserver$54$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeClickObserver(bizControlDataModel);
    }

    public void removeClickObserver(String str, int i, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = i;
        runOnBizThread(143, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$FU5vQONH4WrsLkjLq6nrWAx3TUM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeClickObserver$55$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeClickObserver$55$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeClickObserver(bizControlDataModel);
    }

    public void removeClickObserver(ArrayList<String> arrayList, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlList.addAll(arrayList);
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = -1;
        runOnBizThread(143, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ayJZPM23KAWJ1xOEP4hl_14pR8Y
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeClickObserver$56$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeClickObserver$56$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeClickObserver(bizControlDataModel);
    }

    public void removeClickObserver(ArrayList<String> arrayList, int i, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlList.addAll(arrayList);
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = i;
        runOnBizThread(143, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$7k-gCTbrgYyJ8BGxr744WngPnkY
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeClickObserver$57$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeClickObserver$57$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeClickObserver(bizControlDataModel);
    }

    public void setFocus(final String str, final long j, final String str2, final boolean z) {
        runOnBizThread(145, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$aAgX-ebpV-upU4LDwW56BUldMls
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setFocus$58$BizControlManager(str, j, str2, z);
            }
        });
    }

    public /* synthetic */ void lambda$setFocus$58$BizControlManager(String str, long j, String str2, boolean z) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mBizType = j;
        bizControlDataModel.mItemID = str2;
        bizControlDataModel.mFocus = z;
        this.mBizControlWrapper.setFocus(bizControlDataModel);
    }

    public void updateSearchPolygon(final BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        runOnBizThread(146, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$oYFglgLz6DZnXiiCSbOGBMdvhW4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateSearchPolygon$59$BizControlManager(bizPolygonBusinessInfo);
            }
        });
    }

    public /* synthetic */ void lambda$updateSearchPolygon$59$BizControlManager(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        this.mBizControlWrapper.updateSearchPolygon(bizPolygonBusinessInfo);
    }

    public void updateFavoriteMain(final ArrayList<BizUserFavoritePoint> arrayList) {
        runOnBizThread(147, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$FOaLj4I7ZKqBCE2wOqDRmcuUD14
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateFavoriteMain$60$BizControlManager(arrayList);
            }
        });
    }

    public /* synthetic */ void lambda$updateFavoriteMain$60$BizControlManager(ArrayList arrayList) {
        this.mBizControlWrapper.updateFavoriteMain(arrayList);
    }

    public void updateCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mCustomPoints.addAll(arrayList);
        bizControlDataModel.mType = i;
        runOnBizThread(148, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$PDaUdxX1RW_Btw2Grab9xDeQIq0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateCustomPoint$61$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$updateCustomPoint$61$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.updateCustomPoint(bizControlDataModel);
    }

    public void removeItems(String str, int i, String[] strArr) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mItemIDs = (String[]) strArr.clone();
        runOnBizThread(149, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$LSVdL-DPyF40p_apSRsFdQpFPLs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeItems$62$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeItems$62$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeItems(bizControlDataModel);
    }

    public void getAllItems(String str, int i, IBizAllItemsListener iBizAllItemsListener) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mIBizControlListener = iBizAllItemsListener;
        runOnBizThread(183, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$wFiqkxBMvMg89DGcRiu2YIIumK8
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$getAllItems$63$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$getAllItems$63$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.getAllItems(bizControlDataModel);
    }

    public void updateCarStyle(@BizCarType.BizCarType1 final int i) {
        removeMessages(150);
        runOnBizThread(150, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$mZwVIXbnbJu3RTkqG_oeY5Hcyig
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateCarStyle$64$BizControlManager(i);
            }
        });
    }

    public /* synthetic */ void lambda$updateCarStyle$64$BizControlManager(@BizCarType.BizCarType1 int i) {
        this.mBizControlWrapper.updateCarStyle(i);
    }

    public CarLoc getCarPosition() {
        return this.mBizControlWrapper.getCarPosition();
    }

    public void initMiniCarScaleByMapLevel() {
        removeMessages(151);
        runOnBizThread(151, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$B05UGdT30PdIFkb20mVcMAvELvI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initMiniCarScaleByMapLevel$65$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initMiniCarScaleByMapLevel$65$BizControlManager() {
        this.mBizControlWrapper.initMiniCarScaleByMapLevel();
    }

    public void clearNaviData() {
        removeMessages(152);
        runOnBizThread(152, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$nNBxOKqYf7RsLFTtrXbMIut9JMs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearNaviData$66$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearNaviData$66$BizControlManager() {
        this.mBizControlWrapper.clearNaviData();
    }

    public void remoteClearRenderRoutes() {
        removeMessages(153);
        runOnBizThread(153, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$nN5N91M77YThJ7kvH0AY9PLWvjI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$remoteClearRenderRoutes$67$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$remoteClearRenderRoutes$67$BizControlManager() {
        this.mBizControlWrapper.remoteClearRenderRoutes();
    }

    public void updateRoute(int i, IPathResult iPathResult, RouteParams routeParams, long j, int i2, boolean z, boolean z2, boolean z3) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mType = i;
        bizControlDataModel.mPathResult = iPathResult;
        if (bizControlDataModel.mPathResult != null) {
            bizControlDataModel.mPathResult.addRef();
        }
        bizControlDataModel.mRouteParams = routeParams;
        bizControlDataModel.mRequestId = j;
        bizControlDataModel.mSelectedIndex = i2;
        bizControlDataModel.isNavi = z;
        bizControlDataModel.isClearData = z2;
        bizControlDataModel.isClearOldOverlay = z3;
        TBTManager.getInstance().updateCurrentRouteInfo(bizControlDataModel.mRequestId, bizControlDataModel.mSelectedIndex);
        runOnBizThread(154, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$DoWnU5i272MLaZANF5uNT6ok3k4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRoute$68$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$updateRoute$68$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.updateRoute(bizControlDataModel);
    }

    public void stopNavi() {
        removeMessages(155);
        runOnBizThread(155, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$o2Nyb5J8_bp3beeCpE7tkq15hSs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$stopNavi$69$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$stopNavi$69$BizControlManager() {
        this.mBizControlWrapper.stopNavi();
    }

    public void clearOverlay() {
        removeMessages(156);
        runOnBizThread(156, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Xvc0fROw9reXoz6DQ-xYg6y1G3I
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearOverlay$70$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearOverlay$70$BizControlManager() {
        this.mBizControlWrapper.clearOverlay();
    }

    public void updateMapWhenExit(boolean z, final IXpLayerClickObserver iXpLayerClickObserver) {
        if (getPreviewMode()) {
            setPreviewMode(false);
        }
        setFollowMode(z);
        runOnBizThread(157, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$x1zELMidwn2-gq4QMQgBwjGIc9Y
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateMapWhenExit$71$BizControlManager(iXpLayerClickObserver);
            }
        });
    }

    public /* synthetic */ void lambda$updateMapWhenExit$71$BizControlManager(IXpLayerClickObserver iXpLayerClickObserver) {
        this.mBizControlWrapper.updateMapWhenExit(iXpLayerClickObserver);
    }

    public void setRadarState() {
        removeMessages(158);
        runOnBizThread(158, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Dke9Ei4ptLBLTI4WFACJygXYHCI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setRadarState$72$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$setRadarState$72$BizControlManager() {
        this.mBizControlWrapper.setRadarState();
    }

    public void clearAOIPolygon() {
        removeMessages(159);
        runOnBizThread(159, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$XXx_Am8uXVN6M3_RC3cErME3hxk
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearAOIPolygon$73$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearAOIPolygon$73$BizControlManager() {
        this.mBizControlWrapper.clearAOIPolygon();
    }

    public void renderAoiAreaInfo(final BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        removeMessages(160);
        runOnBizThread(160, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$JYIWHSD3aKux_of3jiQCrQRcGw0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$renderAoiAreaInfo$74$BizControlManager(bizPolygonBusinessInfo);
            }
        });
    }

    public /* synthetic */ void lambda$renderAoiAreaInfo$74$BizControlManager(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        this.mBizControlWrapper.renderAoiAreaInfo(bizPolygonBusinessInfo);
    }

    public void addMapOverLayItems(final XPPointBaseData[] xPPointBaseDataArr) {
        runOnBizThread(161, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$QPFs2oUAef6AwWM6wOVdeOCPpfE
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addMapOverLayItems$75$BizControlManager(xPPointBaseDataArr);
            }
        });
    }

    public /* synthetic */ void lambda$addMapOverLayItems$75$BizControlManager(XPPointBaseData[] xPPointBaseDataArr) {
        this.mBizControlWrapper.addMapOverLayItems(xPPointBaseDataArr);
    }

    public void drawPolygonByPoint(final BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        runOnBizThread(162, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$XxcCOMS28XaPhwqGbLmFrb36mAA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawPolygonByPoint$76$BizControlManager(bizPolygonBusinessInfo);
            }
        });
    }

    public /* synthetic */ void lambda$drawPolygonByPoint$76$BizControlManager(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        this.mBizControlWrapper.drawPolygonByPoint(bizPolygonBusinessInfo);
    }

    public void deletePath() {
        removeMessages(163);
        runOnBizThread(163, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$tLyQ3ZtXzSMgkilelR7Xk5QbvxI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$deletePath$77$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$deletePath$77$BizControlManager() {
        this.mBizControlWrapper.deletePath();
    }

    public void refreshMultiAlternativeLabel() {
        removeMessages(164);
        runOnBizThread(164, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Q8ZKRUye6ZRubKofvkieLVzlo1U
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$refreshMultiAlternativeLabel$78$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$refreshMultiAlternativeLabel$78$BizControlManager() {
        this.mBizControlWrapper.refreshMultiAlternativeLabel();
    }

    public void showCharges(final XPPointBaseData[] xPPointBaseDataArr, final int i) {
        runOnBizThread(165, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$chGIIpToIdyZqgdhOIob7KxVwQw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$showCharges$79$BizControlManager(xPPointBaseDataArr, i);
            }
        });
    }

    public /* synthetic */ void lambda$showCharges$79$BizControlManager(XPPointBaseData[] xPPointBaseDataArr, int i) {
        this.mBizControlWrapper.showCharges(xPPointBaseDataArr, i);
    }

    public void routeChargeDecorator(final int i, final IXpLayerClickObserver iXpLayerClickObserver) {
        runOnBizThread(166, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$d8h_ctvExsbihz3m1c0Zyuibbsc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$routeChargeDecorator$80$BizControlManager(iXpLayerClickObserver, i);
            }
        });
    }

    public /* synthetic */ void lambda$routeChargeDecorator$80$BizControlManager(IXpLayerClickObserver iXpLayerClickObserver, int i) {
        this.mBizControlWrapper.routeChargeDecorator(iXpLayerClickObserver, i);
    }

    public void restoreStatus(boolean z, final boolean z2, boolean z3) {
        if (!z) {
            setPreviewMode(false);
        }
        if (z3 != getFollowMode()) {
            setFollowMode(z3);
        }
        removeMessages(167);
        runOnBizThread(167, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$b7bGLiR1vnptG6mycZeOHEHcjrM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$restoreStatus$81$BizControlManager(z2);
            }
        });
    }

    public /* synthetic */ void lambda$restoreStatus$81$BizControlManager(boolean z) {
        this.mBizControlWrapper.restoreStatus(z);
    }

    public void resetStatus(boolean z, final boolean z2) {
        if (!z) {
            setPreviewMode(true);
        }
        setFollowMode(false);
        removeMessages(168);
        runOnBizThread(168, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$2T_PXL1qmHCgeKvwEOPX-I17oPQ
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$resetStatus$82$BizControlManager(z2);
            }
        });
    }

    public /* synthetic */ void lambda$resetStatus$82$BizControlManager(boolean z) {
        this.mBizControlWrapper.resetStatus(z);
    }

    public void switchRecommendRoute() {
        removeMessages(169);
        runOnBizThread(169, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$hSQFDUGBwMUigQlP_N5Xa-IIz1w
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$switchRecommendRoute$83$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$switchRecommendRoute$83$BizControlManager() {
        this.mBizControlWrapper.switchRecommendRoute();
    }

    public void clearOldOverlay(final boolean z) {
        removeMessages(170);
        runOnBizThread(170, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$LuKBDPPYdsj1DuT1pIhEB23PzmA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearOldOverlay$84$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$clearOldOverlay$84$BizControlManager(boolean z) {
        this.mBizControlWrapper.clearOldOverlay(z);
    }

    public void hideCrossUI(final IBizCrossListener iBizCrossListener) {
        removeMessages(171);
        runOnBizThread(171, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$OB_em5KREWueTJDs0o8LK2PNSN4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$hideCrossUI$85$BizControlManager(iBizCrossListener);
            }
        });
    }

    public /* synthetic */ void lambda$hideCrossUI$85$BizControlManager(IBizCrossListener iBizCrossListener) {
        this.mBizControlWrapper.hideCrossUI(iBizCrossListener);
    }

    public void deleteCandidatePath() {
        removeMessages(172);
        runOnBizThread(172, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$q-dfbyvJ86zR4akrZcxdBjpmXvg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$deleteCandidatePath$86$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$deleteCandidatePath$86$BizControlManager() {
        this.mBizControlWrapper.deleteCandidatePath();
    }

    public void drawGPSandDRDataClearOverlay() {
        removeMessages(173);
        runOnBizThread(173, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Rgu93M3WqlHdQ6WzQ9MrH5K9OUw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawGPSandDRDataClearOverlay$87$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$drawGPSandDRDataClearOverlay$87$BizControlManager() {
        this.mBizControlWrapper.drawGPSandDRDataClearOverlay();
    }

    public void drawGPSandDRDataAddIOverlay(XPPointBaseData[] xPPointBaseDataArr, XPPointBaseData[] xPPointBaseDataArr2) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mOverlaysCp = (XPPointBaseData[]) xPPointBaseDataArr.clone();
        bizControlDataModel.mOverlaysTrace = (XPPointBaseData[]) xPPointBaseDataArr2.clone();
        runOnBizThread(174, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$HLZ8cPdfn1NmQsQFOPcdmX-7qtA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawGPSandDRDataAddIOverlay$88$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$drawGPSandDRDataAddIOverlay$88$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.drawGPSandDRDataAddIOverlay(bizControlDataModel);
    }

    public void setTestMode() {
        removeMessages(175);
        runOnBizThread(175, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$XWImu2ROOLFUhuz-Q5AD5biudrg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setTestMode$89$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$setTestMode$89$BizControlManager() {
        this.mBizControlWrapper.setTestMode();
    }

    public void clearGuideRouteOverlay() {
        removeMessages(176);
        runOnBizThread(176, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$njC9_qBgnDsUhMv_5GM8pzPPR9Y
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearGuideRouteOverlay$90$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearGuideRouteOverlay$90$BizControlManager() {
        this.mBizControlWrapper.clearGuideRouteOverlay();
    }

    public void guideDeletePath() {
        removeMessages(177);
        runOnBizThread(177, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ulFAqgNoPt3mId--uZ9J8JNw4_Q
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$guideDeletePath$91$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$guideDeletePath$91$BizControlManager() {
        this.mBizControlWrapper.guideDeletePath();
    }

    public void onExplorePoiHide() {
        removeMessages(178);
        runOnBizThread(178, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$52UC2L-8gE3sqXbeCVqnP4usRBU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$onExplorePoiHide$92$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$onExplorePoiHide$92$BizControlManager() {
        this.mBizControlWrapper.onExplorePoiHide();
    }

    public void setOperatorFlyline() {
        removeMessages(184);
        runOnBizThread(184, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$RqV4Bk_50ymCefdk6JBTArzr15g
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setOperatorFlyline$93$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$setOperatorFlyline$93$BizControlManager() {
        this.mBizControlWrapper.setOperatorFlyline();
    }

    public void setFlyLineStyle(final IPrepareLayerStyle iPrepareLayerStyle) {
        runOnBizThread(185, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$xf1D9XGoNychvz8OgU2A9OBevrM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setFlyLineStyle$94$BizControlManager(iPrepareLayerStyle);
            }
        });
    }

    public /* synthetic */ void lambda$setFlyLineStyle$94$BizControlManager(IPrepareLayerStyle iPrepareLayerStyle) {
        this.mBizControlWrapper.setFlyLineStyle(iPrepareLayerStyle);
    }

    public void setDrawFlyLine(boolean z, boolean z2) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.bShowLine = z;
        bizControlDataModel.bShowPoint = z2;
        runOnBizThread(186, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$0z_4fQ2xc7Y9HHVfSFzBImNbalE
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setDrawFlyLine$95$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$setDrawFlyLine$95$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.setDrawFlyLine(bizControlDataModel);
    }

    public void updateOddInfo(final List<XPOddInfo> list) {
        runOnBizThread(187, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$LU98Sn6iJmEPxIWLKO362qw7jRg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateOddInfo$96$BizControlManager(list);
            }
        });
    }

    public /* synthetic */ void lambda$updateOddInfo$96$BizControlManager(List list) {
        this.mBizControlWrapper.updateOddInfo(list);
    }

    public void setViewPostureEvent(final int i, final int i2) {
        runOnBizThread(189, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ttH6g6wa0ldK3AEcjLDdis2VAv4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setViewPostureEvent$97$BizControlManager(i, i2);
            }
        });
    }

    public /* synthetic */ void lambda$setViewPostureEvent$97$BizControlManager(int i, int i2) {
        this.mBizControlWrapper.setViewPostureEvent(i, i2);
    }

    private boolean isCheckHandler() {
        return this.mWorkHandler == null;
    }

    private void runOnBizThread(int i, Runnable runnable) {
        if (Looper.myLooper() == this.mLooper) {
            runnable.run();
        } else if (isCheckHandler()) {
        } else {
            Message obtain = Message.obtain(this.mWorkHandler, runnable);
            obtain.what = i;
            this.mWorkHandler.sendMessage(obtain);
        }
    }

    private void cancelRequest(String str, long j) {
        if (BizControlWrapper.BIZ_CONTROL_TYPE_AREA.equals(str) && j == 1014) {
            removeMessages(139);
        }
    }

    private void removeMessages(int i) {
        if (!isCheckHandler() && this.mWorkHandler.hasMessages(i)) {
            this.mWorkHandler.removeMessages(i);
        }
    }

    private boolean hasMessages(int i) {
        if (isCheckHandler()) {
            return false;
        }
        return this.mWorkHandler.hasMessages(i);
    }

    public void setIsNeedRefresh(final boolean z) {
        removeMessages(190);
        runOnBizThread(190, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$MoRAH0Vrl4o2iQWOKIdxHvXkh9o
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setIsNeedRefresh$98$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setIsNeedRefresh$98$BizControlManager(boolean z) {
        this.mBizControlWrapper.setIsNeedRefresh(z);
    }

    public void setRouteChangeBackground(final boolean z) {
        removeMessages(191);
        runOnBizThread(191, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$L_DiPPKFD4UE5p_-M6mBKMK44e0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setRouteChangeBackground$99$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setRouteChangeBackground$99$BizControlManager(boolean z) {
        this.mBizControlWrapper.setRouteChangeBackground(z);
    }

    public boolean is3DCrossShow() {
        return this.mBizControlWrapper.is3DCrossShow();
    }

    public boolean isOpenDynamicLevel() {
        return this.mBizControlWrapper.isOpenDynamicLevel();
    }
}
