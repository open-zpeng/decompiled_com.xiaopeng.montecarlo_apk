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
import com.autonavi.gbl.layer.model.BizLayerUtil;
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
import com.autonavi.gbl.pos.model.LocInfo;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.control.base.IBizAllItemsListener;
import com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener;
import com.xiaopeng.montecarlo.navcore.control.base.IBizDynamicLevelListener;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
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
/* loaded from: classes2.dex */
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
    private static final int MSG_CLEAR_LANE_GUIDE_ROUTE_OVERLAY = 192;
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
    private Looper mLooper;
    private boolean mUpdateMapEagleEyeViewRefreshRoute;
    private boolean mUpdateMapEagleEyeViewShow;
    private Handler mWorkHandler;
    private BizControlDataModel mLastBizControlDataModel = null;
    private volatile int mMapViewState = 0;

    public void init(int i, Looper looper) {
        this.mBizControlWrapper = new BizControlWrapper(this);
        this.mLooper = looper;
        this.mWorkHandler = new Handler(looper);
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

    public void unInitBizControl() {
        removeMessages(179);
        runOnBizThread(179, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$fm2QWkZ8eZ-Vwi1ynqnIqp7SFw4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$unInitBizControl$4$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$unInitBizControl$4$BizControlManager() {
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
        runOnBizThread(100, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$3cQI-eokX8PgJ4-57bHQ5QDJZ3U
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawRoute$5$BizControlManager(bizControlDataModel);
            }
        });
        return CalculatePreviewUtil.getPathBound(iPathResult);
    }

    public /* synthetic */ void lambda$drawRoute$5$BizControlManager(BizControlDataModel bizControlDataModel) {
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
        runOnBizThread(101, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$eDsBf8sDpIsE59SO0_f1Z1vMcEA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawComparingRoutes$6$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$drawComparingRoutes$6$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.drawComparingRoutes(bizControlDataModel);
    }

    public void hideCross(final int i, final IBizCrossListener iBizCrossListener) {
        runOnBizThread(102, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$eiHbrn8YsQabmTTWdGPX510HDJc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$hideCross$7$BizControlManager(i, iBizCrossListener);
            }
        });
    }

    public /* synthetic */ void lambda$hideCross$7$BizControlManager(int i, IBizCrossListener iBizCrossListener) {
        this.mBizControlWrapper.hideCross(i, iBizCrossListener);
    }

    public void setRouteArrowShowSegment(final ArrayList<Long> arrayList) {
        removeMessages(103);
        runOnBizThread(103, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$jPuM87phmVV5ZG6c19Z3LSxRRos
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setRouteArrowShowSegment$8$BizControlManager(arrayList);
            }
        });
    }

    public /* synthetic */ void lambda$setRouteArrowShowSegment$8$BizControlManager(ArrayList arrayList) {
        this.mBizControlWrapper.setRouteArrowShowSegment(arrayList);
    }

    public void updateRouteOverlayElem(final RouteParams routeParams) {
        removeMessages(104);
        runOnBizThread(104, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$jKpgK7rkOAsrsh2vE1T2raW0QXw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRouteOverlayElem$9$BizControlManager(routeParams);
            }
        });
    }

    public /* synthetic */ void lambda$updateRouteOverlayElem$9$BizControlManager(RouteParams routeParams) {
        this.mBizControlWrapper.updateRouteOverlayElem(routeParams);
    }

    public void setCarLineAndNaviEndVisible(final boolean z) {
        removeMessages(105);
        runOnBizThread(105, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$j_9HqyVQEEp3qZ_ASxfMauED7G8
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCarLineAndNaviEndVisible$10$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setCarLineAndNaviEndVisible$10$BizControlManager(boolean z) {
        this.mBizControlWrapper.setCarLineAndNaviEndVisible(z);
    }

    public void setCarLineVisible(final boolean z) {
        removeMessages(106);
        runOnBizThread(106, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$SFnTUX1NHTvycOlrIqAUgB5RBP4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCarLineVisible$11$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setCarLineVisible$11$BizControlManager(boolean z) {
        this.mBizControlWrapper.setCarLineVisible(z);
    }

    public void setCar2EndLine(final double d, final double d2) {
        removeMessages(107);
        runOnBizThread(107, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$O0gLmb2Hhzic4_vfjXN8eS-R_tw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCar2EndLine$12$BizControlManager(d, d2);
            }
        });
    }

    public /* synthetic */ void lambda$setCar2EndLine$12$BizControlManager(double d, double d2) {
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
        runOnBizThread(108, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$a_w9NIXpW8L6mzbpzqDHjB6e2Gg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initCar$13$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$initCar$13$BizControlManager(BizControlDataModel bizControlDataModel) {
        LocInfo currentLocInfo = TBTManager.getInstance().getCurrentLocInfo();
        if (currentLocInfo != null) {
            bizControlDataModel.mCarLoc = BizLayerUtil.locToCarLoc(currentLocInfo);
        }
        L.Tag tag = TAG;
        L.i(tag, "initCar mCarLoc : " + bizControlDataModel.mCarLoc);
        this.mBizControlWrapper.initCar(bizControlDataModel);
        this.mBizControlWrapper.initCarScaleByMapLevel();
    }

    public void initCarScaleByMapLevel() {
        removeMessages(109);
        runOnBizThread(109, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$FsAMXzNWe3m_r_EkQIY8RsDrnds
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initCarScaleByMapLevel$14$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initCarScaleByMapLevel$14$BizControlManager() {
        this.mBizControlWrapper.initCarScaleByMapLevel();
    }

    public void updateResMarker(final boolean z) {
        removeMessages(110);
        runOnBizThread(110, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ij-i_gGAPFfM7hyEdmQ180gc6Z4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateResMarker$15$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$updateResMarker$15$BizControlManager(boolean z) {
        this.mBizControlWrapper.updateResMarker(z);
    }

    public void initRouteCar() {
        removeMessages(111);
        runOnBizThread(111, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$u8iZAfYvkjcqO1YQnJRIcB1MZtI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initRouteCar$16$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initRouteCar$16$BizControlManager() {
        this.mBizControlWrapper.initRouteCar();
    }

    public void initNaviCar(final boolean z) {
        setFollowMode(true);
        removeMessages(114);
        runOnBizThread(114, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$U81KYsvNuEw3YmUjqpBrh2CTWy4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initNaviCar$17$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$initNaviCar$17$BizControlManager(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.i(tag, "initNaviCar.mMapViewState:" + this.mMapViewState);
        }
        if (this.mMapViewState == 22) {
            L.i(TAG, "initNaviCar is lane mode");
        } else {
            this.mBizControlWrapper.initNaviCar(z);
        }
    }

    public void initLaneCar() {
        setFollowMode(false);
        removeMessages(114);
        removeMessages(188);
        runOnBizThread(188, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$QM8N74GQG7mq6uTIXaOyspgXawM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initLaneCar$18$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initLaneCar$18$BizControlManager() {
        this.mBizControlWrapper.initLaneCar();
    }

    public void initCruiseCar(boolean z) {
        setFollowMode(z);
        removeMessages(115);
        runOnBizThread(115, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$RW4YQr03wY2ayYEOT-LSehmFtf4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initCruiseCar$19$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initCruiseCar$19$BizControlManager() {
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
        runOnBizThread(117, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ffmeU-RYJxqciWySSsPHu_oTv1Y
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeRoute$20$BizControlManager(i, z);
            }
        });
    }

    public /* synthetic */ void lambda$removeRoute$20$BizControlManager(int i, boolean z) {
        this.mBizControlWrapper.removeRoute(i, z);
    }

    public void updateRouteTmc(final List<ILightBarInfo> list) {
        removeMessages(118);
        runOnBizThread(118, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$-NmHtLWnTW_CyTtHy5TuUSLgAvc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRouteTmc$21$BizControlManager(list);
            }
        });
    }

    public /* synthetic */ void lambda$updateRouteTmc$21$BizControlManager(List list) {
        this.mBizControlWrapper.updateRouteTmc(list);
    }

    public void setSelectedPath(int i, long j, int i2) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mType = i;
        bizControlDataModel.mRequestId = j;
        bizControlDataModel.mIndex = i2;
        TBTManager.getInstance().updateCurrentRouteInfo(bizControlDataModel.mRequestId, bizControlDataModel.mIndex);
        removeMessages(119);
        runOnBizThread(119, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$dJl6JFJS7a9nz2PL0_FOEW4rgjw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setSelectedPath$22$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$setSelectedPath$22$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.setSelectedPath(bizControlDataModel);
    }

    public void removeRouteCache() {
        removeMessages(120);
        runOnBizThread(120, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$6XJoR56op1_1ZaoFeWf4wxBwgeA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeRouteCache$23$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$removeRouteCache$23$BizControlManager() {
        this.mBizControlWrapper.removeRouteCache();
    }

    public void clearEagleyeRoute() {
        removeMessages(121);
        runOnBizThread(121, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$sOrKK8V5pi8UHZa_LXsteJ7LHWg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearEagleyeRoute$24$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearEagleyeRoute$24$BizControlManager() {
        this.mBizControlWrapper.clearEagleyeRoute();
    }

    public void showCross(@Nullable final XPCrossImageInfo xPCrossImageInfo, final IBizCrossListener iBizCrossListener) {
        runOnBizThread(132, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$lZNsEr34tYHYcc5WVlI0m929Be8
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$showCross$25$BizControlManager(xPCrossImageInfo, iBizCrossListener);
            }
        });
    }

    public /* synthetic */ void lambda$showCross$25$BizControlManager(@Nullable XPCrossImageInfo xPCrossImageInfo, IBizCrossListener iBizCrossListener) {
        this.mBizControlWrapper.showCrossCallBack(xPCrossImageInfo, iBizCrossListener);
    }

    public void openDynamicLevel(final boolean z, final IBizDynamicLevelListener iBizDynamicLevelListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openDynamicLevel bOpen = " + z);
        }
        runOnBizThread(122, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$fR5ChlceALko_W2xNN0uf2q7S38
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$openDynamicLevel$26$BizControlManager(z, iBizDynamicLevelListener);
            }
        });
    }

    public /* synthetic */ void lambda$openDynamicLevel$26$BizControlManager(boolean z, IBizDynamicLevelListener iBizDynamicLevelListener) {
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
        runOnBizThread(122, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$kRhVOu1TkBQzvZWM8RXFFwVRe2I
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$openDynamicLevel$27$BizControlManager(z, i);
            }
        });
    }

    public /* synthetic */ void lambda$openDynamicLevel$27$BizControlManager(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        this.mBizControlWrapper.openDynamicLevel(z, i);
    }

    public void openDynamicLevel(final boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openDynamicLevel bOpen = " + z);
        }
        removeMessages(123);
        runOnBizThread(123, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$GXNqyWDowyY9EHDVxkx6-vfmdhM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$openDynamicLevel$28$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$openDynamicLevel$28$BizControlManager(boolean z) {
        this.mBizControlWrapper.openDynamicLevel(z);
    }

    public boolean getCarUpMode() {
        return this.mBizControlWrapper.getCarUpMode();
    }

    public void setCarUpMode(final boolean z) {
        removeMessages(113);
        runOnBizThread(113, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$WXj5L3H7udo9lZkpu8XEeubEUD0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setCarUpMode$29$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setCarUpMode$29$BizControlManager(boolean z) {
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

    public void setMapViewState(int i) {
        this.mMapViewState = i;
    }

    public boolean isInitEagleye() {
        return this.mBizControlWrapper.isInitEagleye();
    }

    public void showEagleye() {
        removeMessages(125);
        runOnBizThread(125, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$-UfFYHmgFi8FFJOXxvEy2hV0cf0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$showEagleye$30$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$showEagleye$30$BizControlManager() {
        this.mBizControlWrapper.showEagleye();
    }

    public boolean isEagleEyeShowing() {
        return this.mBizControlWrapper.isEagleEyeShowing();
    }

    public void updateEagleMapShowMode(final int i) {
        removeMessages(127);
        runOnBizThread(127, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$HPAL2NMPt-aYBYM__8FMGfUysVU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateEagleMapShowMode$31$BizControlManager(i);
            }
        });
    }

    public /* synthetic */ void lambda$updateEagleMapShowMode$31$BizControlManager(int i) {
        this.mBizControlWrapper.updateEagleMapShowMode(i);
    }

    public void disableEagleEyeState() {
        removeMessages(129);
        runOnBizThread(129, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$iWOtEASwlK68cPRpynUac1NUF44
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$disableEagleEyeState$32$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$disableEagleEyeState$32$BizControlManager() {
        this.mBizControlWrapper.disableEagleEyeState();
    }

    public void restoreRadarLabelVisibility() {
        removeMessages(131);
        runOnBizThread(131, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$keJunXPz2mfU7BKa19r2f_m2J-U
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$restoreRadarLabelVisibility$33$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$restoreRadarLabelVisibility$33$BizControlManager() {
        this.mBizControlWrapper.restoreRadarLabelVisibility();
    }

    public void updateMapEagleEyeView(boolean z, boolean z2) {
        this.mUpdateMapEagleEyeViewShow = z;
        this.mUpdateMapEagleEyeViewRefreshRoute = z2;
        removeMessages(130);
        runOnBizThread(130, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$3LI8cKAGY2t3LRDd6JCeTXd3J-Q
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateMapEagleEyeView$34$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$updateMapEagleEyeView$34$BizControlManager() {
        this.mBizControlWrapper.updateMapEagleEyeView(this.mUpdateMapEagleEyeViewShow, this.mUpdateMapEagleEyeViewRefreshRoute);
    }

    public void adjustEagleyePosition(EagleEyeStyle eagleEyeStyle, int[] iArr) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mEagleEyeStyle = eagleEyeStyle;
        bizControlDataModel.mNewlocation = (int[]) iArr.clone();
        removeMessages(126);
        runOnBizThread(126, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$37IwxG2sDaFqKjwW5Qd8S-vHC-Q
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$adjustEagleyePosition$35$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$adjustEagleyePosition$35$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.adjustEagleyePosition(bizControlDataModel);
    }

    public void clearAllItems(final String str, final long j) {
        cancelRequest(str, j);
        runOnBizThread(134, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$RZ8fId6Q_bakVONap0I1MgnCleE
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearAllItems$36$BizControlManager(str, j);
            }
        });
    }

    public /* synthetic */ void lambda$clearAllItems$36$BizControlManager(String str, long j) {
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
        runOnBizThread(135, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$nGndyH75tTarlyrIhGyQZgM5poQ
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addItems$37$BizControlManager(i, xPPointBaseDataArr, str);
            }
        });
    }

    public /* synthetic */ void lambda$addItems$37$BizControlManager(int i, XPPointBaseData[] xPPointBaseDataArr, String str) {
        ArrayList<LayerItem> translationLayerItems = NavCoreUtil.translationLayerItems(i, xPPointBaseDataArr);
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mAddItems.addAll(translationLayerItems);
        this.mBizControlWrapper.addItems(bizControlDataModel);
    }

    public void addItems(final String str, final int i, final ArrayList<BizAGroupBusinessInfo> arrayList) {
        runOnBizThread(135, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Vq4yZVA98E4yCbLWT0smi9JHC7c
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addItems$38$BizControlManager(arrayList, str, i);
            }
        });
    }

    public /* synthetic */ void lambda$addItems$38$BizControlManager(ArrayList arrayList, String str, int i) {
        ArrayList<LayerItem> translateBizAGroupBusiness2LayerItems = NavCoreUtil.translateBizAGroupBusiness2LayerItems(arrayList);
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mAddItems.addAll(translateBizAGroupBusiness2LayerItems);
        this.mBizControlWrapper.addItems(bizControlDataModel);
    }

    public void removeItem(final String str, final int i, final String str2) {
        runOnBizThread(144, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$bFxsj9XpkyQRAKEFtGi32-u0d0Y
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeItem$39$BizControlManager(str, i, str2);
            }
        });
    }

    public /* synthetic */ void lambda$removeItem$39$BizControlManager(String str, int i, String str2) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mItemID = str2;
        this.mBizControlWrapper.removeItem(bizControlDataModel);
    }

    public void setVisible(final String str, final int i, final boolean z) {
        runOnBizThread(136, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$qEo7ZwN8kYA8ImEIBUjF-4z5oJ4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setVisible$40$BizControlManager(z, str, i);
            }
        });
    }

    public /* synthetic */ void lambda$setVisible$40$BizControlManager(boolean z, String str, int i) {
        if (this.mMapViewState == 22 && z && BizControlWrapper.BIZ_CONTROL_TYPE_USER.equalsIgnoreCase(str)) {
            L.Tag tag = TAG;
            L.i(tag, "lane mode not setVisible:" + str + "," + i);
            return;
        }
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.isVisible = z;
        this.mBizControlWrapper.setVisible(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "bizcontrol type visible " + bizControlDataModel.mBizControlType);
            L.Tag tag3 = TAG;
            L.d(tag3, "biztype visible " + bizControlDataModel.mType);
        }
    }

    public void setVisible(final String str, final boolean z) {
        runOnBizThread(136, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$fJbrO4iWXh6A91j4st6cHLcS4PY
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setVisible$41$BizControlManager(z, str);
            }
        });
    }

    public /* synthetic */ void lambda$setVisible$41$BizControlManager(boolean z, String str) {
        if (this.mMapViewState == 22 && z && BizControlWrapper.BIZ_CONTROL_TYPE_USER.equalsIgnoreCase(str)) {
            L.Tag tag = TAG;
            L.i(tag, "lane mode not setVisible:" + str);
            return;
        }
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = -1;
        bizControlDataModel.isVisible = z;
        this.mBizControlWrapper.setVisible(bizControlDataModel);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "bizcontrol type visible " + bizControlDataModel.mBizControlType);
            L.Tag tag3 = TAG;
            L.d(tag3, "biztype visible " + bizControlDataModel.mType);
        }
    }

    public void setClickable(final String str, final long j, final boolean z) {
        runOnBizThread(137, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$iJYu1FdAAgBTMacjSuEnMjK04xs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setClickable$42$BizControlManager(str, j, z);
            }
        });
    }

    public /* synthetic */ void lambda$setClickable$42$BizControlManager(String str, long j, boolean z) {
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
        runOnBizThread(138, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ykV7AL74lUsj8Cx1GENLsaeCr3Y
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addAGroupMembers$43$BizControlManager(xPPointBaseDataArr);
            }
        });
    }

    public /* synthetic */ void lambda$addAGroupMembers$43$BizControlManager(XPPointBaseData[] xPPointBaseDataArr) {
        this.mBizControlWrapper.addAGroupMembers(NavCoreUtil.translationBizAGroupBusinessInfos(xPPointBaseDataArr));
    }

    public void updateRouteRestrict(final BizRouteRestrictInfo bizRouteRestrictInfo) {
        runOnBizThread(139, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$1VHT-clQabWaWGtehdGrMxkWDv4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRouteRestrict$44$BizControlManager(bizRouteRestrictInfo);
            }
        });
    }

    public /* synthetic */ void lambda$updateRouteRestrict$44$BizControlManager(BizRouteRestrictInfo bizRouteRestrictInfo) {
        this.mBizControlWrapper.updateRouteRestrict(bizRouteRestrictInfo);
    }

    public void guideEagleEyeClearPath() {
        removeMessages(140);
        runOnBizThread(140, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$pqPTARW87-kt3DbFvSZwKrCW6ck
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$guideEagleEyeClearPath$45$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$guideEagleEyeClearPath$45$BizControlManager() {
        this.mBizControlWrapper.guideEagleEyeClearPath();
    }

    public void clearFocus(final String str, final long j) {
        runOnBizThread(141, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$cLjc9QZvQNGpTkr0U_OxkfuLW3k
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearFocus$46$BizControlManager(str, j);
            }
        });
    }

    public /* synthetic */ void lambda$clearFocus$46$BizControlManager(String str, long j) {
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
        runOnBizThread(142, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$fCDuS9qlXM5HqBSSy3Cl80dZmq0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addClickObserver$47$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$addClickObserver$47$BizControlManager(BizControlDataModel bizControlDataModel) {
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
        runOnBizThread(142, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$2P08-6dbloWcqG9fjVInteZRgsc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addClickObserver$48$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$addClickObserver$48$BizControlManager(BizControlDataModel bizControlDataModel) {
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
        runOnBizThread(142, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Cavd0PGYeZ_Qf-7CIDGz_Ot5DSQ
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addClickObserver$49$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$addClickObserver$49$BizControlManager(BizControlDataModel bizControlDataModel) {
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

    public void removeClickObserver(String str, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = -1;
        runOnBizThread(143, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$bxVJr89OyaUVH-KNd1WUmpu-iQM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeClickObserver$51$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeClickObserver$51$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeClickObserver(bizControlDataModel);
    }

    public void removeClickObserver(String str, int i, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = i;
        runOnBizThread(143, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$y3mt7pA3-uxo4zYwgJfdrY2pwWA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeClickObserver$52$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeClickObserver$52$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeClickObserver(bizControlDataModel);
    }

    public void removeClickObserver(ArrayList<String> arrayList, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlList.addAll(arrayList);
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = -1;
        runOnBizThread(143, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$VfwxP-f5QdK9Qgkm3qqO26jFL28
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeClickObserver$53$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeClickObserver$53$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeClickObserver(bizControlDataModel);
    }

    public void removeClickObserver(ArrayList<String> arrayList, int i, ILayerClickObserver iLayerClickObserver) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlList.addAll(arrayList);
        bizControlDataModel.mObserver = iLayerClickObserver;
        bizControlDataModel.mType = i;
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

    public void setFocus(final String str, final long j, final String str2, final boolean z) {
        runOnBizThread(145, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$pG36G7MMQxemtUyO56hKZkEOdg8
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setFocus$55$BizControlManager(str, j, str2, z);
            }
        });
    }

    public /* synthetic */ void lambda$setFocus$55$BizControlManager(String str, long j, String str2, boolean z) {
        BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mBizType = j;
        bizControlDataModel.mItemID = str2;
        bizControlDataModel.mFocus = z;
        this.mBizControlWrapper.setFocus(bizControlDataModel);
    }

    public void updateSearchPolygon(final BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        runOnBizThread(146, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$vbPygNxm0OgtXb4Qwv5sSRgONYQ
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateSearchPolygon$56$BizControlManager(bizPolygonBusinessInfo);
            }
        });
    }

    public /* synthetic */ void lambda$updateSearchPolygon$56$BizControlManager(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        this.mBizControlWrapper.updateSearchPolygon(bizPolygonBusinessInfo);
    }

    public void updateFavoriteMain(final ArrayList<BizUserFavoritePoint> arrayList) {
        runOnBizThread(147, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$XfFPlAwIZw1AIIWlwxI2A_Su-3s
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateFavoriteMain$57$BizControlManager(arrayList);
            }
        });
    }

    public /* synthetic */ void lambda$updateFavoriteMain$57$BizControlManager(ArrayList arrayList) {
        this.mBizControlWrapper.updateFavoriteMain(arrayList);
    }

    public void updateCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mCustomPoints.addAll(arrayList);
        bizControlDataModel.mType = i;
        runOnBizThread(148, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$wNYi6VkcPuATCrX4PiNzvm78Rvs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateCustomPoint$58$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$updateCustomPoint$58$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.updateCustomPoint(bizControlDataModel);
    }

    public void removeItems(String str, int i, String[] strArr) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mItemIDs = (String[]) strArr.clone();
        runOnBizThread(149, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ZUl1PO004ArSJ7SGqaO5RIhlVAo
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$removeItems$59$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$removeItems$59$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.removeItems(bizControlDataModel);
    }

    public void getAllItems(String str, int i, IBizAllItemsListener iBizAllItemsListener) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mBizControlType = str;
        bizControlDataModel.mType = i;
        bizControlDataModel.mIBizControlListener = iBizAllItemsListener;
        runOnBizThread(183, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$jE8TheaHPz3CifJHdVR9wLkrvoE
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$getAllItems$60$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$getAllItems$60$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.getAllItems(bizControlDataModel);
    }

    public void updateCarStyle(@BizCarType.BizCarType1 final int i) {
        removeMessages(150);
        runOnBizThread(150, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$HXzz6Ngkxv6zOVXVqVdaaEB-lKk
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateCarStyle$61$BizControlManager(i);
            }
        });
    }

    public /* synthetic */ void lambda$updateCarStyle$61$BizControlManager(@BizCarType.BizCarType1 int i) {
        this.mBizControlWrapper.updateCarStyle(i);
    }

    public CarLoc getCarPosition() {
        return this.mBizControlWrapper.getCarPosition();
    }

    public void initMiniCarScaleByMapLevel() {
        removeMessages(151);
        runOnBizThread(151, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$MUhRWITMoLw4KlahJolfA7n2ZzU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$initMiniCarScaleByMapLevel$62$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$initMiniCarScaleByMapLevel$62$BizControlManager() {
        this.mBizControlWrapper.initMiniCarScaleByMapLevel();
    }

    public void clearNaviData() {
        removeMessages(152);
        runOnBizThread(152, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$e1mauwagbslwgvt1iBmveYmYOQs
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearNaviData$63$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearNaviData$63$BizControlManager() {
        this.mBizControlWrapper.clearNaviData();
    }

    public void remoteClearRenderRoutes() {
        removeMessages(153);
        runOnBizThread(153, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$uZpIFZ3s55SRpPxrAt47YcsxjOU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$remoteClearRenderRoutes$64$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$remoteClearRenderRoutes$64$BizControlManager() {
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
        runOnBizThread(154, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$F4kJq1EG_eNxBmQX3L1Jar2y-w0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateRoute$65$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$updateRoute$65$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.updateRoute(bizControlDataModel);
    }

    public void stopNavi() {
        removeMessages(155);
        runOnBizThread(155, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$uqLB3RXuvunBysCLT5O-Y7uyvos
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$stopNavi$66$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$stopNavi$66$BizControlManager() {
        this.mBizControlWrapper.stopNavi();
    }

    public void clearOverlay() {
        removeMessages(156);
        runOnBizThread(156, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$iasrqXcgdsHcNl1fn9Wen2y22Pw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearOverlay$67$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearOverlay$67$BizControlManager() {
        this.mBizControlWrapper.clearOverlay();
    }

    public void updateMapWhenExit(boolean z, final IXpLayerClickObserver iXpLayerClickObserver) {
        if (getPreviewMode()) {
            setPreviewMode(false);
        }
        setFollowMode(z);
        runOnBizThread(157, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$vhT9ZFl0ssu1DjzovbwfQ4IMYQI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateMapWhenExit$68$BizControlManager(iXpLayerClickObserver);
            }
        });
    }

    public /* synthetic */ void lambda$updateMapWhenExit$68$BizControlManager(IXpLayerClickObserver iXpLayerClickObserver) {
        this.mBizControlWrapper.updateMapWhenExit(iXpLayerClickObserver);
    }

    public void setRadarState() {
        removeMessages(158);
        runOnBizThread(158, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$A2OGGUWlGqdIq8WXuJvCWlZ6zag
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setRadarState$69$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$setRadarState$69$BizControlManager() {
        this.mBizControlWrapper.setRadarState();
    }

    public void clearAOIPolygon() {
        removeMessages(159);
        runOnBizThread(159, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$6xM3J_cwMGKNTqSwEtP8axTTAf8
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearAOIPolygon$70$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearAOIPolygon$70$BizControlManager() {
        this.mBizControlWrapper.clearAOIPolygon();
    }

    public void renderAoiAreaInfo(final BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        removeMessages(160);
        runOnBizThread(160, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$wkgL_CL1KhVVHLXnH1FpS6ZFOz4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$renderAoiAreaInfo$71$BizControlManager(bizPolygonBusinessInfo);
            }
        });
    }

    public /* synthetic */ void lambda$renderAoiAreaInfo$71$BizControlManager(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        this.mBizControlWrapper.renderAoiAreaInfo(bizPolygonBusinessInfo);
    }

    public void addMapOverLayItems(final XPPointBaseData[] xPPointBaseDataArr) {
        runOnBizThread(161, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$6dtDCUDQU0DdS0i6nZT5v5P6Fto
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$addMapOverLayItems$72$BizControlManager(xPPointBaseDataArr);
            }
        });
    }

    public /* synthetic */ void lambda$addMapOverLayItems$72$BizControlManager(XPPointBaseData[] xPPointBaseDataArr) {
        this.mBizControlWrapper.addMapOverLayItems(xPPointBaseDataArr);
    }

    public void drawPolygonByPoint(final BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        runOnBizThread(162, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Su0AwT7EoRhYzu6zJ8wnOTuhWzg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawPolygonByPoint$73$BizControlManager(bizPolygonBusinessInfo);
            }
        });
    }

    public /* synthetic */ void lambda$drawPolygonByPoint$73$BizControlManager(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        this.mBizControlWrapper.drawPolygonByPoint(bizPolygonBusinessInfo);
    }

    public void deletePath() {
        removeMessages(163);
        runOnBizThread(163, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$pqR3W_7DKgcT9cDlWxo9jcdA7f4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$deletePath$74$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$deletePath$74$BizControlManager() {
        this.mBizControlWrapper.deletePath();
    }

    public void refreshMultiAlternativeLabel() {
        removeMessages(164);
        runOnBizThread(164, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$TATVgspCXnnYI2pGnEMzwmY0w5s
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$refreshMultiAlternativeLabel$75$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$refreshMultiAlternativeLabel$75$BizControlManager() {
        this.mBizControlWrapper.refreshMultiAlternativeLabel();
    }

    public void showCharges(final XPPointBaseData[] xPPointBaseDataArr, final int i) {
        runOnBizThread(165, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$JYByB7rorHEQefDPo3KyfOTTT4E
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$showCharges$76$BizControlManager(xPPointBaseDataArr, i);
            }
        });
    }

    public /* synthetic */ void lambda$showCharges$76$BizControlManager(XPPointBaseData[] xPPointBaseDataArr, int i) {
        this.mBizControlWrapper.showCharges(xPPointBaseDataArr, i);
    }

    public void routeChargeDecorator(final int i, final IXpLayerClickObserver iXpLayerClickObserver) {
        runOnBizThread(166, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$03aT5vP6dUZtOYz7_21LLy2Irqg
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$routeChargeDecorator$77$BizControlManager(iXpLayerClickObserver, i);
            }
        });
    }

    public /* synthetic */ void lambda$routeChargeDecorator$77$BizControlManager(IXpLayerClickObserver iXpLayerClickObserver, int i) {
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
        runOnBizThread(167, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$G4OnpkTAc7YH6p6NPVx3C-_Hp3A
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$restoreStatus$78$BizControlManager(z2);
            }
        });
    }

    public /* synthetic */ void lambda$restoreStatus$78$BizControlManager(boolean z) {
        this.mBizControlWrapper.restoreStatus(z);
    }

    public void resetStatus(boolean z, final boolean z2) {
        if (!z) {
            setPreviewMode(true);
        }
        setFollowMode(false);
        removeMessages(168);
        runOnBizThread(168, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$84vKn65QAZio-WK08Xo_LK_sMks
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$resetStatus$79$BizControlManager(z2);
            }
        });
    }

    public /* synthetic */ void lambda$resetStatus$79$BizControlManager(boolean z) {
        this.mBizControlWrapper.resetStatus(z);
    }

    public void switchRecommendRoute() {
        removeMessages(169);
        runOnBizThread(169, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Wjp6y0TpshwTF3D2UZloveZkjWI
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$switchRecommendRoute$80$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$switchRecommendRoute$80$BizControlManager() {
        this.mBizControlWrapper.switchRecommendRoute();
    }

    public void clearOldOverlay(final boolean z) {
        removeMessages(170);
        runOnBizThread(170, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$mfZdo2k-VAXk5SImdT4Z90C4F70
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearOldOverlay$81$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$clearOldOverlay$81$BizControlManager(boolean z) {
        this.mBizControlWrapper.clearOldOverlay(z);
    }

    public void hideCrossUI(final IBizCrossListener iBizCrossListener) {
        removeMessages(171);
        runOnBizThread(171, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$VcOxsB9LIe-BG5hwVjEt6wPT4eA
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$hideCrossUI$82$BizControlManager(iBizCrossListener);
            }
        });
    }

    public /* synthetic */ void lambda$hideCrossUI$82$BizControlManager(IBizCrossListener iBizCrossListener) {
        this.mBizControlWrapper.hideCrossUI(iBizCrossListener);
    }

    public void deleteCandidatePath() {
        removeMessages(172);
        runOnBizThread(172, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$LvULl9YIgOXf_4yw7JQB9Nk32d8
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$deleteCandidatePath$83$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$deleteCandidatePath$83$BizControlManager() {
        this.mBizControlWrapper.deleteCandidatePath();
    }

    public void drawGPSandDRDataClearOverlay() {
        removeMessages(173);
        runOnBizThread(173, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$qi_3WJk9VI5d8LbxbiMGPqzw4xU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawGPSandDRDataClearOverlay$84$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$drawGPSandDRDataClearOverlay$84$BizControlManager() {
        this.mBizControlWrapper.drawGPSandDRDataClearOverlay();
    }

    public void drawGPSandDRDataAddIOverlay(XPPointBaseData[] xPPointBaseDataArr, XPPointBaseData[] xPPointBaseDataArr2) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.mOverlaysCp = (XPPointBaseData[]) xPPointBaseDataArr.clone();
        bizControlDataModel.mOverlaysTrace = (XPPointBaseData[]) xPPointBaseDataArr2.clone();
        runOnBizThread(174, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$ec0Hq_5sYidd8LaXK1-M0hYaIv4
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$drawGPSandDRDataAddIOverlay$85$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$drawGPSandDRDataAddIOverlay$85$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.drawGPSandDRDataAddIOverlay(bizControlDataModel);
    }

    public void setTestMode() {
        removeMessages(175);
        runOnBizThread(175, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$Nn6pPNwrLrRN2hqw1Aud4tQeP_w
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setTestMode$86$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$setTestMode$86$BizControlManager() {
        this.mBizControlWrapper.setTestMode();
    }

    public void clearGuideRouteOverlay() {
        removeMessages(176);
        runOnBizThread(176, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$QZLdfEiIgW1iB1H4uhUewvyPX6g
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearGuideRouteOverlay$87$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearGuideRouteOverlay$87$BizControlManager() {
        this.mBizControlWrapper.clearGuideRouteOverlay();
    }

    public void clearLaneGuideRouteOverlay() {
        removeMessages(192);
        runOnBizThread(192, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$hBjZ2TmquBMz692Z5aJkBGuOWYU
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$clearLaneGuideRouteOverlay$88$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$clearLaneGuideRouteOverlay$88$BizControlManager() {
        this.mBizControlWrapper.clearLaneGuideRouteOverlay();
    }

    public void guideDeletePath() {
        removeMessages(177);
        runOnBizThread(177, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$_LFL69Tm7nGypxjxNoK_W5W9SOM
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$guideDeletePath$89$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$guideDeletePath$89$BizControlManager() {
        this.mBizControlWrapper.guideDeletePath();
    }

    public void onExplorePoiHide() {
        removeMessages(178);
        runOnBizThread(178, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$I9lXlm9ssjoQb628i8Q-buTQ9oc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$onExplorePoiHide$90$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$onExplorePoiHide$90$BizControlManager() {
        this.mBizControlWrapper.onExplorePoiHide();
    }

    public void setOperatorFlyline() {
        removeMessages(184);
        runOnBizThread(184, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$yXdlDgV2ExCURUUHUN_fOtemFzE
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setOperatorFlyline$91$BizControlManager();
            }
        });
    }

    public /* synthetic */ void lambda$setOperatorFlyline$91$BizControlManager() {
        this.mBizControlWrapper.setOperatorFlyline();
    }

    public void setFlyLineStyle(final IPrepareLayerStyle iPrepareLayerStyle) {
        runOnBizThread(185, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$1vfGaxdQ6cAKUpjHqPh-S2397A0
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setFlyLineStyle$92$BizControlManager(iPrepareLayerStyle);
            }
        });
    }

    public /* synthetic */ void lambda$setFlyLineStyle$92$BizControlManager(IPrepareLayerStyle iPrepareLayerStyle) {
        this.mBizControlWrapper.setFlyLineStyle(iPrepareLayerStyle);
    }

    public void setDrawFlyLine(boolean z, boolean z2) {
        final BizControlDataModel bizControlDataModel = new BizControlDataModel();
        bizControlDataModel.bShowLine = z;
        bizControlDataModel.bShowPoint = z2;
        runOnBizThread(186, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$WDWukvmonfvW_SvYo8MaXAZYq1E
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setDrawFlyLine$93$BizControlManager(bizControlDataModel);
            }
        });
    }

    public /* synthetic */ void lambda$setDrawFlyLine$93$BizControlManager(BizControlDataModel bizControlDataModel) {
        this.mBizControlWrapper.setDrawFlyLine(bizControlDataModel);
    }

    public void updateOddInfo(final List<XPOddInfo> list) {
        runOnBizThread(187, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$5ATMYHwMY-gonULtHCVIUCeJlfc
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$updateOddInfo$94$BizControlManager(list);
            }
        });
    }

    public /* synthetic */ void lambda$updateOddInfo$94$BizControlManager(List list) {
        this.mBizControlWrapper.updateOddInfo(list);
    }

    public void setViewPostureEvent(final int i, final int i2) {
        runOnBizThread(189, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$0j56XK-5Jo5o9sBdmC-du0wwohQ
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setViewPostureEvent$95$BizControlManager(i, i2);
            }
        });
    }

    public /* synthetic */ void lambda$setViewPostureEvent$95$BizControlManager(int i, int i2) {
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
        if (BizControlWrapper.BIZ_CONTROL_TYPE_AREA.equals(str) && j == 1008) {
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
        runOnBizThread(190, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$aYnCLgzh-8ofOmUktwcjVNFWcUo
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setIsNeedRefresh$96$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setIsNeedRefresh$96$BizControlManager(boolean z) {
        this.mBizControlWrapper.setIsNeedRefresh(z);
    }

    public void setRouteChangeBackground(final boolean z) {
        removeMessages(191);
        runOnBizThread(191, new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.control.-$$Lambda$BizControlManager$mGECOELj7RAQp1nlw3oDFAd99cw
            @Override // java.lang.Runnable
            public final void run() {
                BizControlManager.this.lambda$setRouteChangeBackground$97$BizControlManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$setRouteChangeBackground$97$BizControlManager(boolean z) {
        this.mBizControlWrapper.setRouteChangeBackground(z);
    }

    public boolean is3DCrossShow() {
        return this.mBizControlWrapper.is3DCrossShow();
    }
}
