package com.xiaopeng.montecarlo.scenes.mapscene;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.layer.CruiseCongestionEventLayerItem;
import com.autonavi.gbl.layer.CruiseFacilityLayerItem;
import com.autonavi.gbl.layer.GuideCameraLayerItem;
import com.autonavi.gbl.layer.GuideETAEventLayerItem;
import com.autonavi.gbl.layer.GuideLabelLayerItem;
import com.autonavi.gbl.layer.GuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.GuideTrafficSignalLightLayerItem;
import com.autonavi.gbl.layer.LaneGuideTrafficLightCountdownLayerItem;
import com.autonavi.gbl.layer.LaneGuideTrafficLightIconLayerItem;
import com.autonavi.gbl.layer.LaneGuideTurnLayerItem;
import com.autonavi.gbl.layer.RouteBlockLayerItem;
import com.autonavi.gbl.layer.RouteCompareTipsLayerItem;
import com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.layer.model.BizSocolEventInfo;
import com.autonavi.gbl.layer.model.RouteTrafficEventTipsPoint;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.RouteLayerItem;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.model.RouteLayerParam;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizData;
import com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizDataManager;
import com.xiaopeng.montecarlo.mapoverlay.mark.MarkPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecorator;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.NaviRouteOverlayParam;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.CloudRouteDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.LayerHolder;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.ViewCacheManager;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class MapPrepareLayerStyle implements IPrepareLayerStyle, ActivityLifecycleHelper.ActivityLifecycleListener {
    public static final int CONGESTION_STATUS_BAD = 3;
    public static final int CONGESTION_STATUS_DARK = 4;
    public static final int CONGESTION_STATUS_SLOW = 2;
    private static final String MARK_INDEX_PREFIX = "1";
    private static final int MULTI_ALTERNATIVE_PATH_LABEL_DIRECTION_MAX = 4;
    private static final String POINT_MARK_FOCUS = "point_mark_focus";
    private static final String POINT_MARK_NORMAL = "point_mark_normal";
    private static final String POINT_ROUTE_VIA_FOCUS = "point_route_via_focus";
    private static final String POINT_ROUTE_VIA_NORMAL = "point_route_via_normal";
    private static final String POINT_SEARCH_CENTROL_FOCUS = "point_search_centrol_focus";
    private static final String POINT_SEARCH_CENTROL_NORMAL = "point_search_centrol_normal";
    private static final String POINT_SEARCH_PARENT_FOCUS = "point_search_parent_focus";
    private static final String POINT_SEARCH_PARENT_NORMAL = "point_search_parent_normal";
    private static final String POINT_USER_CHARGE_FOCUS_MARK_ID = "point_user_charge_focus_mark_id";
    private static final String POINT_USER_CHARGE_NORMAL_MARK_ID = "point_user_charge_normal_mark_id";
    private static final String POINT_USER_FAV_FOCUS_MARK_ID = "point_user_fav_focus_mark_id";
    private static final String POINT_USER_FAV_NORMAL_MARK_ID = "point_user_fav_normal_mark_id";
    private static final String POINT_VPA_FOCUS = "point_vpa_focus";
    private static final String POINT_VPA_NORMAL = "point_vpa_normal";
    public static final int ROUTE_LABEL_DISTANCE_THRESHOLD = 200;
    public static final long ROUTE_LABEL_TIME_THRESHOLD = 120;
    private static final L.Tag TAG = new L.Tag("MapPrepareLayerReader");
    private int mEndFlyLineColor;
    private int mEndFlyLineWidth;
    protected int mEngineID;
    private List<LayerTexture> mGLTextureProperties;
    protected boolean mIsMiniMap;
    protected final MainContext mMainContext;
    private MapView mMapView;
    protected final MapViewWrapper mMapViewWrapper;
    private int mMarkOneXOffset;
    private int mMarkOtherXOffset;
    private int mMarkTwoXOffset;
    private int mMarkYOffset;
    private MultiAlternativePathLabelViewHolder mMultiAlternativePathLabelViewHolder;
    private long mMultiPathDiffLightCnt;
    private double mMultiPathDiffTime;
    private int mMultiPathDiffToll;
    private long mMultiPathDiffTotalDis;
    private boolean mMultiPathIsOnTollRoad;
    private ViewCacheManager viewCacheManager;
    protected NaviRouteOverlayParam mNaviRouteOverlayParam = new NaviRouteOverlayParam();
    private ArrayList<Integer> mCameraMarkIds = new ArrayList<>();
    private int mCameraMarkId = 309;
    private int mCruiseCameraMarkId = 60;
    private List<String> mEventCache = new ArrayList();
    private List<Integer> mETAEventCache = new ArrayList();
    private List<Integer> mRouteEventCache = new ArrayList();
    private List<Integer> mRouteBlockEventCache = new ArrayList();
    private volatile int mMultiIndex = 0;
    private boolean mIsNeedRefresh = true;
    private Map<String, Integer> mECameraMarkIdCache = new HashMap();
    private int mLaneCameraMarkId = 512;
    private boolean cruseDirectionLeft = true;
    private ArrayList<Integer> mLaneCameraMarkIds = new ArrayList<>();
    private int mLaneTurnMarkId = MarkUtils.MARKER_ID_LANE_TURN;
    private int mGuideTrafficLightMarkId = 525;
    private ArrayList<Integer> mGuideTrafficLightMarkIds = new ArrayList<>();
    private int mLaneGuideTrafficLightMarkId = 536;
    private ArrayList<Integer> mLaneGuideTrafficLightMarkIds = new ArrayList<>();
    int mLastLightCountDown = -1;

    private int createVPAPointMarkId(boolean z) {
        return z ? 44 : 43;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean isRouteCacheStyleEnabled() {
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean isRouteStyleNightMode() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityStopped() {
    }

    public MapPrepareLayerStyle(MapViewWrapper mapViewWrapper, int i, MainContext mainContext, boolean z) {
        this.mIsMiniMap = false;
        if (mapViewWrapper == null) {
            throw new IllegalArgumentException(L.formatWithEngine(" MapViewWrapper is null ", i));
        }
        MapView gLMapView = mapViewWrapper.getGLMapView();
        if (gLMapView == null) {
            throw new IllegalArgumentException(L.formatWithEngine(" MapViewWrapper isn't initialized !  ", i));
        }
        this.mMapViewWrapper = mapViewWrapper;
        this.mMainContext = mainContext;
        this.mMapView = gLMapView;
        this.mEngineID = i;
        this.mIsMiniMap = z;
        this.viewCacheManager = new ViewCacheManager(6);
    }

    public void init() {
        MapTextureResourcesHelper.clearResources();
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        MarkUtils.addOverlayTexturesAsync(mapViewWrapper, mapViewWrapper.getMainEngineID(), MapTextureResourcesHelper.getDefaultMapTextureResources());
        this.mEndFlyLineColor = ContextUtils.getColor(R.color.palette_rad);
        this.mEndFlyLineWidth = ContextUtils.getDimensionPixelSize(R.dimen.guide_end_flyline_width);
        this.mNaviRouteOverlayParam.mNightMode = !ThemeWatcherUtil.isDayMode();
        this.mMarkYOffset = ContextUtils.getDimensionPixelSize(R.dimen.style_reader_mark_yoffset);
        this.mMarkOneXOffset = ContextUtils.getDimensionPixelSize(R.dimen.style_reader_mark_one_xoffset);
        this.mMarkTwoXOffset = ContextUtils.getDimensionPixelSize(R.dimen.style_reader_mark_two_xoffset);
        this.mMarkOtherXOffset = ContextUtils.getDimensionPixelSize(R.dimen.style_reader_mark_other_xoffset);
        this.mCameraMarkId = 309;
        this.mCruiseCameraMarkId = 60;
        this.mGLTextureProperties = new ArrayList();
        this.mMultiPathDiffLightCnt = 0L;
        this.mMultiPathDiffTime = 0.0d;
        this.mMultiPathDiffToll = 0;
        this.mMultiPathDiffTotalDis = 0L;
        this.mMultiPathIsOnTollRoad = false;
    }

    public void uninit() {
        this.mMapView = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01a7, code lost:
        if (r1.equals("1") != false) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0275  */
    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getMarkerId(com.autonavi.gbl.map.layer.BaseLayer r25, com.autonavi.gbl.map.layer.LayerItem r26, com.autonavi.gbl.map.layer.model.ItemStyleInfo r27) {
        /*
            Method dump skipped, instructions count: 1240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.getMarkerId(com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.model.ItemStyleInfo):int");
    }

    private synchronized int getLabelTypeGuideMixFprkMarkerId(BaseLayer baseLayer, LayerItem layerItem, int i) {
        int i2;
        LayerHolder view = this.viewCacheManager.getView(layerItem.getBusinessType(), R.layout.layout_map_mixforkinfo);
        view.getRootView().setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_card_trafficcondition_divergentroad));
        XTextView xTextView = (XTextView) view.getView(R.id.mixfork_num);
        xTextView.setText(ContextUtils.getString(R.string.mixfork_info_label, String.valueOf(i + 1)));
        xTextView.setTextColor(ThemeWatcherUtil.getColor(R.color.guide_mixfork_label_text_color));
        i2 = 405 - i;
        MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i2, ContextUtils.getFloat(R.dimen.dimen_map_style_map_mixfork_ratio_x), ContextUtils.getFloat(R.dimen.dimen_map_style_map_mixfork_ratio_y), false, true, this.mIsMiniMap);
        L.Tag tag = TAG;
        L.i(tag, "getBizPointOverlayMarker mix roadinfo !!!! index is : " + i + " markId:" + i2);
        return i2;
    }

    @Nullable
    private synchronized Integer getInteger(BaseLayer baseLayer, LayerItem layerItem, String str) {
        ChargeBizData generateChargeTextureView = ChargeBizDataManager.getInstance().generateChargeTextureView(this.mMapViewWrapper, layerItem.getID(), layerItem.getBusinessType(), this.viewCacheManager);
        if (generateChargeTextureView != null) {
            if (POINT_USER_CHARGE_NORMAL_MARK_ID.equals(str)) {
                return Integer.valueOf(generateChargeTextureView.getTextureMarkerId());
            } else if (POINT_USER_CHARGE_FOCUS_MARK_ID.equals(str)) {
                return Integer.valueOf(generateChargeTextureView.getTextureFocusMarkerId());
            }
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "get3DModelId str3DModelId:" + str);
        }
        if (CommonUtil.isInteger(str.trim())) {
            return Integer.valueOf(str.trim()).intValue();
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0213  */
    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getLayerStyle(com.autonavi.gbl.map.layer.BaseLayer r7, com.autonavi.gbl.map.layer.LayerItem r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.getLayerStyle(com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.LayerItem, boolean):java.lang.String");
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean getRouteLayerStyle(BaseLayer baseLayer, LayerItem layerItem, RouteLayerStyle routeLayerStyle) {
        if (!this.mIsNeedRefresh) {
            this.mMapViewWrapper.getBizControlManager().setRouteChangeBackground(true);
            return false;
        }
        RouteLayerItem routeLayerItem = (RouteLayerItem) layerItem;
        if (routeLayerItem == null) {
            L.w(TAG, "getRouteLayerStyle routeLayerItem was null");
            return false;
        }
        RouteLayerDrawParam routeDrawParam = routeLayerItem.getRouteDrawParam();
        int i = routeDrawParam.mRouteStyleType;
        boolean z = routeDrawParam.mIsMultipleMode;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getRouteLayerStyle: route routeStyleType = " + i + ",isMultipleMode = " + z);
        }
        this.mNaviRouteOverlayParam.mNightMode = !ThemeWatcherUtil.isDayMode();
        List<RouteLayerParam> properties = this.mNaviRouteOverlayParam.getProperties(this.mMapViewWrapper, i, z, this.mIsMiniMap);
        int size = properties.size();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "getRouteLayerStyle: route listSize = " + size);
        }
        routeLayerStyle.vecParam = new ArrayList<>();
        routeLayerStyle.vecParam.addAll(properties);
        if (this.mNaviRouteOverlayParam.mNightMode) {
            routeLayerStyle.mPassedColor[0] = -8157293;
            routeLayerStyle.mPassedColor[1] = -1;
            routeLayerStyle.mPassedColor[2] = -1;
        } else {
            routeLayerStyle.mPassedColor[0] = -9275780;
            routeLayerStyle.mPassedColor[1] = -8222306;
            routeLayerStyle.mPassedColor[2] = -1;
        }
        return true;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public synchronized void clearLayerItems(BaseLayer baseLayer) {
        if (baseLayer == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearLayerItems baseLayer :" + baseLayer.getLayerID());
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public synchronized void clearLayerItem(BaseLayer baseLayer, LayerItem layerItem) {
        if (baseLayer == null || layerItem == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearLayerItems BusinessType: " + layerItem.getBusinessType() + " , " + layerItem.getID());
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public synchronized void clearLayerStyle(BaseLayer baseLayer, LayerItem layerItem) {
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public String getCommonInfo(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getCommonInfo:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return CommonUtil.getStyleBeanJson("common_info_foreshortening");
        }
        return CommonUtil.getStyleBeanJson(str);
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean switchStyle(int i) {
        L.Tag tag = TAG;
        L.i(tag, "switchStyle: " + i);
        this.viewCacheManager.resetCache();
        return false;
    }

    private int getCarEndMarkId() {
        boolean isDayMode = ThemeWatcherUtil.isDayMode();
        if (TBTManager.getInstance().isHomeEndInfo(TBTManager.getInstance().getCurrentRouteRequestId())) {
            return isDayMode ? MarkUtils.MARKER_ID_HOME : MarkUtils.MARKER_ID_HOME_NIGHT;
        } else if (TBTManager.getInstance().isCompanyEndInfo(TBTManager.getInstance().getCurrentRouteRequestId())) {
            if (isDayMode) {
                return 364;
            }
            return MarkUtils.MARKER_ID_COMPANY_NIGHT;
        } else {
            return -1;
        }
    }

    private synchronized int createExplorePathBoard(int i, String str, int i2) {
        XPManeuverInfo naviManeuverInfo = TBTManager.getInstance().getNaviManeuverInfo();
        if (naviManeuverInfo != null) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("getBizPointOverlayMarker >>> createExplorePathBoard directionStyle=" + i, this.mEngineID));
            int nextRoadTurnResource = ResUtil.getNextRoadTurnResource(naviManeuverInfo.mManeuverID);
            if (nextRoadTurnResource != 0 && !TextUtils.isEmpty(str)) {
                int exploreRoadNameLabelBgResource = ResUtil.getExploreRoadNameLabelBgResource(i);
                float commonBgRatioX = MarkUtils.getCommonBgRatioX(i);
                float commonBgRatioY = MarkUtils.getCommonBgRatioY(i);
                LayerHolder view = this.viewCacheManager.getView(i2, R.layout.layout_next_road);
                view.getRootView().setBackground(ThemeWatcherUtil.getDrawable(exploreRoadNameLabelBgResource));
                ImageView imageView = (ImageView) view.getView(R.id.im_next_road_turn_icon);
                TextView textView = (TextView) view.getView(R.id.tv_next_road_name);
                imageView.setVisibility(0);
                imageView.setImageResource(nextRoadTurnResource);
                textView.setText(str);
                textView.setTextColor(ThemeWatcherUtil.getColor(R.color.explore_map_next_roadname_text_color));
                MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), 16, commonBgRatioX, commonBgRatioY, false, true, this.mIsMiniMap);
                return 16;
            }
        }
        return -1;
    }

    private synchronized int createNaviPathBoard(int i, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        L.Tag tag = TAG;
        L.i(tag, "getBizPointOverlayMarker >>> createNaviPathBoard directionStyle=" + i);
        int guideRoadNameLabelBgResource = ResUtil.getGuideRoadNameLabelBgResource(i);
        float commonBgRatioX = MarkUtils.getCommonBgRatioX(i);
        float commonBgRatioY = MarkUtils.getCommonBgRatioY(i);
        LayerHolder view = this.viewCacheManager.getView(i2, R.layout.layout_next_road);
        view.getRootView().setBackground(ThemeWatcherUtil.getDrawable(guideRoadNameLabelBgResource));
        TextView textView = (TextView) view.getView(R.id.tv_next_road_name);
        ((ImageView) view.getView(R.id.im_next_road_turn_icon)).setVisibility(8);
        textView.setText(str);
        textView.setTextColor(ThemeWatcherUtil.getColor(R.color.guide_map_next_roadname_text_color));
        MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), 16, commonBgRatioX, commonBgRatioY, false, true, this.mIsMiniMap);
        return 16;
    }

    private int createMultiPathLabelMarkerId(GuideLabelLayerItem guideLabelLayerItem) {
        boolean z;
        if (guideLabelLayerItem == null) {
            L.w(TAG, "XPTRAFFICEVENT createMultiPathLabelMarkerId labelLayerItem is null");
            return -1;
        }
        int mLabelIndex = guideLabelLayerItem.getMLabelIndex();
        long mPathId = guideLabelLayerItem.getMPathId();
        int mBoardStyle = guideLabelLayerItem.getMBoardStyle();
        guideLabelLayerItem.getMPathCost();
        int i = mLabelIndex == 0 ? MarkUtils.MARKER_ID_TIE_1 : mLabelIndex == 1 ? MarkUtils.MARKER_ID_TIE_2 : 502;
        this.mMultiIndex++;
        if (this.mMultiIndex >= 4) {
            this.mMultiIndex = 0;
            z = true;
        } else {
            z = false;
        }
        updateMultiAlternativePathDiff(mLabelIndex, mPathId);
        createMultiAlternativePathLabel(this.mMultiPathDiffLightCnt, this.mMultiPathDiffTotalDis, this.mMultiPathDiffTime, this.mMultiPathDiffToll, this.mMultiPathIsOnTollRoad, i, mPathId, mBoardStyle, z, guideLabelLayerItem.getBusinessType());
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateMultiAlternativePathDiff(int r29, long r30) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.updateMultiAlternativePathDiff(int, long):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(1:8)(2:91|(21:93|10|(1:12)(3:86|(1:88)(1:90)|89)|13|(2:15|(1:17)(17:(1:82)(1:84)|83|(3:20|(1:22)(2:(1:77)(1:79)|78)|23)(1:80)|24|(1:26)|27|(1:29)(1:75)|30|(1:32)(1:74)|33|34|35|36|(2:40|(2:42|(1:46))(3:47|(4:49|(2:52|50)|53|54)|55))|56|(1:58)|59))(1:85)|18|(0)(0)|24|(0)|27|(0)(0)|30|(0)(0)|33|34|35|36|(3:38|40|(0)(0))|56|(0)|59)(1:94))|34|35|36|(0)|56|(0)|59) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x027e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x027f, code lost:
        com.xiaopeng.montecarlo.root.util.L.w(com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.TAG, "createMakerByText" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0295, code lost:
        r17.mMultiAlternativePathLabelViewHolder.mLayout.destroyDrawingCache();
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0381  */
    @android.annotation.SuppressLint({"WrongThread"})
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createMultiAlternativePathLabel(long r18, long r20, double r22, int r24, boolean r25, int r26, long r27, int r29, boolean r30, int r31) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.createMultiAlternativePathLabel(long, long, double, int, boolean, int, long, int, boolean, int):void");
    }

    private int getRouteInfoIntIndexForVui(RouteResult routeResult, long j) {
        for (int i = 0; i < routeResult.mPathResult.getPathCount(); i++) {
            RouteResult.RouteInfo routeInfo = routeResult.getRouteInfo(i);
            if (routeInfo != null && routeInfo.mPathId == j) {
                return i;
            }
        }
        return 0;
    }

    private int getRouteLabelTextColor(boolean z, boolean z2) {
        int i = R.color.route_label_title_highlight_color;
        if (z) {
            if (!z2) {
                i = R.color.route_label_title_normal_color;
            }
            return ThemeWatcherUtil.getColor(i);
        }
        if (!z2) {
            i = R.color.route_label_title_normal_color;
        }
        return ThemeWatcherUtil.getColor(i);
    }

    private int getTrafficEventTempId(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("11011".equals(str)) {
            return 1;
        }
        if ("11010".equals(str)) {
            return 2;
        }
        if ("11040".equals(str)) {
            return 3;
        }
        return "11100".equals(str) ? 4 : 0;
    }

    private Drawable getRouteInfoIndex(RouteResult routeResult, long j) {
        int i = 0;
        while (true) {
            if (i >= routeResult.mPathResult.getPathCount()) {
                break;
            }
            RouteResult.RouteInfo routeInfo = routeResult.getRouteInfo(i);
            if (routeInfo == null || routeInfo.mPathId != j) {
                i++;
            } else if (i == 0) {
                return ThemeWatcherUtil.getDrawable(R.drawable.vector_tag_number_1);
            } else {
                if (i == 1) {
                    return ThemeWatcherUtil.getDrawable(R.drawable.vector_tag_number_2);
                }
                if (i == 2) {
                    return ThemeWatcherUtil.getDrawable(R.drawable.vector_tag_number_3);
                }
            }
        }
        return null;
    }

    private synchronized int getRouteViaPointId(int i, boolean z, BaseLayer baseLayer, LayerItem layerItem) {
        int i2;
        XPViaPoint xPViaPoint;
        int i3;
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        i2 = -1;
        if (viaInfos != null && i > -1 && i < viaInfos.size() && (xPViaPoint = viaInfos.get(i)) != null) {
            boolean isPassedVia = xPViaPoint.getIsPassedVia();
            int realViaIndex = CloudRouteDataHelper.getInstance().getRealViaIndex(i);
            L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker RouteOverlayElemVias index: " + i + ", isPassedVia: " + isPassedVia + " realIndex: " + realViaIndex + ", viaType: " + viaInfos.get(i).getViaType(), this.mEngineID));
            if (realViaIndex > -1 && realViaIndex < viaInfos.size()) {
                LayerHolder view = this.viewCacheManager.getView(layerItem.getBusinessType(), R.layout.layout_path_via);
                int i4 = realViaIndex + 1;
                layerItem.setPriority(i4);
                TextView textView = (TextView) view.getView(R.id.via_index);
                textView.setText(Integer.toString(i4));
                if (z) {
                    i3 = ((isPassedVia ? realViaIndex + MarkUtils.MARKER_ID_BUBBLE_PASSED_FOCUSED_VIA : realViaIndex + 333) + 1) - 12;
                    view.getRootView().setBackground(ThemeWatcherUtil.getDrawable(isPassedVia ? R.drawable.png_poi_small_pressed_passed_point : R.drawable.png_poi_small_pressed_passing_point));
                    textView.setTextColor(ThemeWatcherUtil.getColor(R.color.main_title_text_color));
                    MarkUtils.createMakerByViewSync(this.mMapViewWrapper, view.getRootView(), i3, 0.5f, 1.0f, true, false, this.mIsMiniMap);
                } else {
                    textView.setTextColor(ThemeWatcherUtil.isDayMode() ? ContextUtils.getColor(R.color.xui_white) : ContextUtils.getColor(R.color.palette_tag_drck_gray_night));
                    i3 = ((isPassedVia ? realViaIndex + MarkUtils.MARKER_ID_BUBBLE_PASSED_VIA : realViaIndex + 321) + 1) - 12;
                    view.getRootView().setBackground(ThemeWatcherUtil.getDrawable(isPassedVia ? R.drawable.png_poi_small_passed_point : R.drawable.png_poi_small_passing_point));
                    MarkUtils.createMakerByViewSync(this.mMapViewWrapper, view.getRootView(), i3, 0.5f, 1.0f, true, false, this.mIsMiniMap);
                }
                i2 = i3;
            } else if (!CloudRouteDataHelper.getInstance().isCloudRouteModeOpen()) {
                i2 = 20;
            }
        }
        return i2;
    }

    private synchronized int createRouteTypeCompareTipMarkerId(RouteCompareTipsLayerItem routeCompareTipsLayerItem, BaseLayer baseLayer) {
        int i;
        RouteLimitInfo routeLimitInfo;
        if (routeCompareTipsLayerItem == null) {
            L.w(TAG, "XPTRAFFICEVENT createRouteTypeCompareTipMarkerId compareTipsLayerItem is null");
            return -1;
        }
        LayerHolder view = this.viewCacheManager.getView(routeCompareTipsLayerItem.getBusinessType(), R.layout.layout_compare_route_tips);
        TextView textView = (TextView) view.getView(R.id.tv_content);
        textView.setTextColor(ThemeWatcherUtil.getColor(R.color.guide_route_compare_tips_text_color));
        view.getRootView().setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_route_compare_tips_bg));
        float[] routeLabelRatioForDirection = MarkUtils.getRouteLabelRatioForDirection(5);
        long j = 0;
        StringBuilder sb = new StringBuilder(routeCompareTipsLayerItem.getMLabelContent());
        if (routeCompareTipsLayerItem.getMIsFaster()) {
            i = 24;
            RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentNaviId());
            if (routeResult != null && routeResult.mRouteType == 5 && (routeLimitInfo = routeResult.mExternData) != null && routeLimitInfo.avoidJamArea != null) {
                j = routeLimitInfo.avoidJamArea.saveTime;
                String string = ContextUtils.getString(R.string.recommend_route_save_time, NaviUtil.getTimeString(j));
                if (!TextUtils.isEmpty(string)) {
                    sb.append(", ");
                    sb.append(string);
                }
            }
            textView.setText(sb.toString());
            MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), 24, routeLabelRatioForDirection[0], routeLabelRatioForDirection[1], false, true, this.mIsMiniMap);
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("XPTRAFFICEVENT getBizPointOverlayMarker RouteOverlayElemCompareTips name: " + routeCompareTipsLayerItem.getMLabelContent() + ", pathId: " + routeCompareTipsLayerItem.getID() + ", save time: " + j, this.mEngineID));
        } else {
            i = 23;
        }
        return i;
    }

    private int createRouteTypeTrafficEventTipMarkerId(RouteTrafficEventTipsLayerItem routeTrafficEventTipsLayerItem) {
        int indexOf;
        if (routeTrafficEventTipsLayerItem == null) {
            L.w(TAG, "XPTRAFFICEVENT createRouteTypeTrafficEventTipMarkerId trafficEventTipsLayerItem is null");
            return -1;
        }
        RouteTrafficEventTipsPoint mTrafficEventTipsInfo = routeTrafficEventTipsLayerItem.getMTrafficEventTipsInfo();
        int i = (mTrafficEventTipsInfo == null || mTrafficEventTipsInfo.mTrafficIncident == null) ? -1 : (int) mTrafficEventTipsInfo.mTrafficIncident.eventType;
        L.Tag tag = TAG;
        L.i(tag, "XPTRAFFICEVENT createRouteTypeTrafficEventTipMarkerId eventType: " + i);
        int routeTrafficEventIconId = ResUtil.getRouteTrafficEventIconId(i);
        if (routeTrafficEventIconId > 0) {
            if (this.mRouteEventCache.contains(Integer.valueOf(i))) {
                indexOf = this.mRouteEventCache.indexOf(Integer.valueOf(i));
            } else {
                this.mRouteEventCache.add(Integer.valueOf(i));
                indexOf = this.mRouteEventCache.indexOf(Integer.valueOf(i));
            }
            int i2 = 445 - indexOf;
            MarkUtils.createMakerWithBg(this.mMapViewWrapper, routeTrafficEventIconId, i2, false, this.mIsMiniMap);
            return i2;
        }
        return -1;
    }

    private int createTrafficBlockMarkerId(RouteBlockLayerItem routeBlockLayerItem) {
        int indexOf;
        if (routeBlockLayerItem == null) {
            L.w(TAG, "XPTRAFFICEVENT createTrafficBlockMarkerId blockLayerItem is null");
            return -1;
        }
        int i = (int) routeBlockLayerItem.getMEventCloud().pointDetail.pointControl.pTType;
        routeBlockLayerItem.getTypeIdName();
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("XPTRAFFICEVENT getBizPointOverlayMarker RouteOverlayElemTrafficBlock, layerTag: " + i, this.mEngineID));
        int roadCloseIconResId = ResUtil.getRoadCloseIconResId(i);
        if (roadCloseIconResId > 0) {
            if (this.mRouteBlockEventCache.contains(Integer.valueOf(i))) {
                indexOf = this.mRouteBlockEventCache.indexOf(Integer.valueOf(i));
            } else {
                this.mRouteBlockEventCache.add(Integer.valueOf(i));
                indexOf = this.mRouteBlockEventCache.indexOf(Integer.valueOf(i));
            }
            int i2 = 480 - indexOf;
            MarkUtils.createMakerWithBg(this.mMapViewWrapper, roadCloseIconResId, i2, false, true, this.mIsMiniMap);
            return i2;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[Catch: all -> 0x0172, TryCatch #0 {, blocks: (B:5:0x0004, B:8:0x000d, B:15:0x004d, B:17:0x0057, B:19:0x0091, B:21:0x0095, B:22:0x009a, B:24:0x009e, B:26:0x00a7, B:29:0x00b1, B:31:0x00d7, B:33:0x00f7, B:35:0x0111, B:37:0x0130, B:39:0x013b, B:42:0x0142, B:44:0x014c, B:43:0x0149, B:36:0x0118, B:28:0x00ad, B:45:0x0167), top: B:53:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized int createGuideCongestionMarkerId(com.autonavi.gbl.layer.GuideCongestionLayerItem r13, com.autonavi.gbl.map.layer.BaseLayer r14) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.createGuideCongestionMarkerId(com.autonavi.gbl.layer.GuideCongestionLayerItem, com.autonavi.gbl.map.layer.BaseLayer):int");
    }

    private int createGuideEtaEventMarkerId(GuideETAEventLayerItem guideETAEventLayerItem) {
        int indexOf;
        if (guideETAEventLayerItem == null) {
            L.w(TAG, ">>> createGuideEtaEventMarkerId etaEventLayerItem is null");
            return -1;
        }
        int mType = guideETAEventLayerItem.getMType();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("XPTRAFFICEVENT getBizPointOverlayMarker GuideOverlayTypeETAEvent： " + mType, this.mEngineID));
        }
        int eTAEventIconId = ResUtil.getETAEventIconId(mType, false);
        if (eTAEventIconId > 0) {
            if (this.mETAEventCache.contains(Integer.valueOf(mType))) {
                indexOf = this.mETAEventCache.indexOf(Integer.valueOf(mType));
            } else {
                this.mETAEventCache.add(Integer.valueOf(mType));
                indexOf = this.mETAEventCache.indexOf(Integer.valueOf(mType));
            }
            int i = 474 - indexOf;
            MarkUtils.createMakerWithBg(this.mMapViewWrapper, eTAEventIconId, i, false, this.mIsMiniMap);
            return i;
        }
        return -1;
    }

    private synchronized int createGuideTrafficEventMarkerId(GuideTrafficEventLayerItem guideTrafficEventLayerItem, BaseLayer baseLayer) {
        if (guideTrafficEventLayerItem == null) {
            L.w(TAG, ">>> createGuideTrafficEventMarkerId trafficEventLayerItem is null");
            return -1;
        }
        guideTrafficEventLayerItem.getMDirectionStyle();
        int mId = guideTrafficEventLayerItem.getMId();
        int mLayerTag = guideTrafficEventLayerItem.getMLayerTag();
        boolean mIsPreview = guideTrafficEventLayerItem.getMIsPreview();
        String mLane = guideTrafficEventLayerItem.getMLane();
        long pathId = guideTrafficEventLayerItem.getPathId();
        String valueOf = String.valueOf(mLayerTag);
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("XPTRAFFICEVENT getBizPointOverlayMarker: GuideOverlayTypeTrafficEvent layerTag = " + valueOf + ", lane = " + mLane + ", previewValue = " + mIsPreview + ",eventId = " + mId + ", pathID: " + pathId, this.mEngineID));
        LayerHolder view = this.viewCacheManager.getView(guideTrafficEventLayerItem.getBusinessType(), R.layout.layout_navigation_traffic_event);
        View view2 = view.getView(R.id.guide_traffic_content);
        view2.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.drawable_map_style_guide_map_traffic_event_bg));
        ImageView imageView = (ImageView) view.getView(R.id.guide_traffic_icon);
        imageView.setImageResource(ResUtil.getTrafficEventThemeIconId(valueOf, false));
        TextView textView = (TextView) view.getView(R.id.tv_traffic_event_title);
        TextView textView2 = (TextView) view.getView(R.id.tv_traffic_event_lane);
        float f = 0.2f;
        String trafficName = ResUtil.getTrafficName(valueOf);
        if ((!mIsPreview && !TextUtils.isEmpty(mLane)) || !TextUtils.isEmpty(trafficName)) {
            view2.setVisibility(0);
            if (!mIsPreview && !TextUtils.isEmpty(mLane)) {
                textView2.setText(mLane);
                textView2.setVisibility(0);
                textView2.setTextColor(ThemeWatcherUtil.getColor(R.color.guide_map_traffic_event_text_color));
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(trafficName)) {
                textView.setText(trafficName);
                textView.setVisibility(0);
                textView.setTextColor(ThemeWatcherUtil.getColor(R.color.guide_map_traffic_event_text_color));
            } else {
                textView.setVisibility(8);
            }
        } else {
            view2.setVisibility(8);
        }
        int viewWidth = RootUtil.getViewWidth(imageView);
        int viewWidth2 = RootUtil.getViewWidth(view2);
        if (viewWidth > 0 && viewWidth2 > 0 && viewWidth <= viewWidth2) {
            f = (viewWidth * 0.5f) / viewWidth2;
        }
        int trafficEventTempId = 484 - getTrafficEventTempId(valueOf);
        MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), trafficEventTempId, f, 0.5f, false, true, this.mIsMiniMap);
        return trafficEventTempId;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0092 A[Catch: all -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x000a, B:13:0x002f, B:18:0x0039, B:22:0x0040, B:28:0x004c, B:34:0x0058, B:41:0x0077, B:46:0x008a, B:50:0x0092, B:54:0x009a, B:56:0x00ed, B:59:0x0116, B:62:0x0149, B:64:0x0153, B:66:0x0157, B:68:0x015f, B:70:0x016e, B:72:0x017e, B:74:0x018c, B:76:0x0194, B:79:0x01a2, B:61:0x0131, B:11:0x0027), top: B:90:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized int createGuideCameraMarkId(com.autonavi.gbl.map.layer.BaseLayer r22, com.autonavi.gbl.layer.GuideCameraLayerItem r23) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.createGuideCameraMarkId(com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.layer.GuideCameraLayerItem):int");
    }

    private int getCameraMarkId(GuideCameraLayerItem guideCameraLayerItem) {
        int i = guideCameraLayerItem.getNormalStyle().poiMarkerId;
        if (i == -1) {
            this.mCameraMarkId--;
            if (this.mCameraMarkId <= 299) {
                this.mCameraMarkId = 309;
            }
            i = this.mCameraMarkId;
            if (this.mCameraMarkIds.contains(Integer.valueOf(i))) {
                this.mCameraMarkIds.remove(Integer.valueOf(i));
                this.mMapViewWrapper.cleanOverlayTexture(i, false);
            }
            this.mCameraMarkIds.add(Integer.valueOf(i));
            L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker: CAMERA new markId = " + i, this.mEngineID));
        } else {
            L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker: CAMERA old markId = " + i, this.mEngineID));
        }
        return i;
    }

    private synchronized int createGuideIntervalCameraMarkId(BaseLayer baseLayer, GuideCameraLayerItem guideCameraLayerItem) {
        int i = -1;
        if (guideCameraLayerItem == null) {
            return -1;
        }
        int mCameraExtType = guideCameraLayerItem.getMCameraExtType();
        int mCameraSpeed = guideCameraLayerItem.getMCameraSpeed();
        int mDirectionStyle = guideCameraLayerItem.getMDirectionStyle();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createGuideIntervalCameraMarkId type:" + mCameraExtType + ", speed:" + mCameraSpeed);
        }
        if (mCameraSpeed > 0) {
            i = getCameraMarkId(guideCameraLayerItem);
            this.mCameraMarkIds.add(Integer.valueOf(i));
            LayerHolder view = this.viewCacheManager.getView(guideCameraLayerItem.getBusinessType(), R.layout.map_layout_interval_camera_info, VuiConstants.PROPS_INTERVAL);
            view.getRootView().setBackgroundResource(ResUtil.getGuideIntervalCameraLayout(mDirectionStyle));
            TextView textView = (TextView) view.getView(R.id.tv_name);
            ((ImageView) view.getView(R.id.camera_icon)).setImageResource(ResUtil.getSpeedCameraResource(mCameraSpeed));
            float cameraBgRatioX = MarkUtils.getCameraBgRatioX(mDirectionStyle);
            float cameraBgRatioY = MarkUtils.getCameraBgRatioY(mDirectionStyle);
            if (25 == mCameraExtType) {
                textView.setText(R.string.map_camera_info_interval_begin);
                MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            } else if (26 == mCameraExtType) {
                textView.setText(R.string.map_camera_info_interval_end);
                MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            } else {
                textView.setText(R.string.map_camera_info_interval_end_start);
                MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0093 A[Catch: all -> 0x00d8, TryCatch #0 {, blocks: (B:8:0x0008, B:10:0x0018, B:19:0x0050, B:21:0x0093, B:24:0x00ac, B:25:0x00c1), top: B:32:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized int createLaneGuideIntervalCameraMarkId(com.autonavi.gbl.map.layer.BaseLayer r17, com.autonavi.gbl.layer.LaneGuideCameraLayerItem r18) {
        /*
            r16 = this;
            r1 = r16
            monitor-enter(r16)
            r0 = -1
            if (r18 != 0) goto L8
            monitor-exit(r16)
            return r0
        L8:
            int r2 = r18.getMDirectionType()     // Catch: java.lang.Throwable -> Ld8
            int r3 = r18.getMCameraExtType()     // Catch: java.lang.Throwable -> Ld8
            int r4 = r18.getMCameraSpeed()     // Catch: java.lang.Throwable -> Ld8
            boolean r5 = com.xiaopeng.montecarlo.root.util.L.ENABLE     // Catch: java.lang.Throwable -> Ld8
            if (r5 == 0) goto L3e
            com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.TAG     // Catch: java.lang.Throwable -> Ld8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld8
            r6.<init>()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r7 = "createLaneGuideIntervalCameraMarkId directionStyle: "
            r6.append(r7)     // Catch: java.lang.Throwable -> Ld8
            r6.append(r2)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r7 = ", type:"
            r6.append(r7)     // Catch: java.lang.Throwable -> Ld8
            r6.append(r3)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r7 = ", speed:"
            r6.append(r7)     // Catch: java.lang.Throwable -> Ld8
            r6.append(r4)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Ld8
            com.xiaopeng.montecarlo.root.util.L.d(r5, r6)     // Catch: java.lang.Throwable -> Ld8
        L3e:
            if (r4 <= 0) goto Ld6
            r0 = 1
            r5 = 513(0x201, float:7.19E-43)
            r6 = 514(0x202, float:7.2E-43)
            r7 = 25
            if (r0 != r2) goto L4c
            if (r3 != r7) goto L4f
            goto L50
        L4c:
            if (r3 != r7) goto L4f
            goto L50
        L4f:
            r5 = r6
        L50:
            com.xiaopeng.montecarlo.util.ViewCacheManager r0 = r1.viewCacheManager     // Catch: java.lang.Throwable -> Ld8
            int r6 = r18.getBusinessType()     // Catch: java.lang.Throwable -> Ld8
            r8 = 2131493127(0x7f0c0107, float:1.8609725E38)
            java.lang.String r9 = "interval"
            com.xiaopeng.montecarlo.util.LayerHolder r0 = r0.getView(r6, r8, r9)     // Catch: java.lang.Throwable -> Ld8
            android.view.View r6 = r0.getRootView()     // Catch: java.lang.Throwable -> Ld8
            int r2 = com.xiaopeng.montecarlo.util.ResUtil.getGuideIntervalCameraLayout(r2)     // Catch: java.lang.Throwable -> Ld8
            r6.setBackgroundResource(r2)     // Catch: java.lang.Throwable -> Ld8
            r2 = 2131296460(0x7f0900cc, float:1.8210837E38)
            android.view.View r2 = r0.getView(r2)     // Catch: java.lang.Throwable -> Ld8
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch: java.lang.Throwable -> Ld8
            r6 = 2131297526(0x7f0904f6, float:1.8213E38)
            android.view.View r6 = r0.getView(r6)     // Catch: java.lang.Throwable -> Ld8
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch: java.lang.Throwable -> Ld8
            int r4 = com.xiaopeng.montecarlo.util.ResUtil.getSpeedCameraResource(r4)     // Catch: java.lang.Throwable -> Ld8
            r2.setImageResource(r4)     // Catch: java.lang.Throwable -> Ld8
            r2 = 2131165380(0x7f0700c4, float:1.7944975E38)
            float r11 = com.xiaopeng.montecarlo.root.util.ContextUtils.getFloat(r2)     // Catch: java.lang.Throwable -> Ld8
            r2 = 2131165381(0x7f0700c5, float:1.7944978E38)
            float r12 = com.xiaopeng.montecarlo.root.util.ContextUtils.getFloat(r2)     // Catch: java.lang.Throwable -> Ld8
            if (r7 != r3) goto La8
            r2 = 2131689868(0x7f0f018c, float:1.9008764E38)
            r6.setText(r2)     // Catch: java.lang.Throwable -> Ld8
            com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper r8 = r1.mMapViewWrapper     // Catch: java.lang.Throwable -> Ld8
            android.view.View r9 = r0.getRootView()     // Catch: java.lang.Throwable -> Ld8
            r13 = 0
            r14 = 1
            boolean r15 = r1.mIsMiniMap     // Catch: java.lang.Throwable -> Ld8
            r10 = r5
            com.xiaopeng.montecarlo.navcore.util.MarkUtils.createMakerByView(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> Ld8
            goto Ld5
        La8:
            r2 = 26
            if (r2 != r3) goto Lc1
            r2 = 2131689869(0x7f0f018d, float:1.9008766E38)
            r6.setText(r2)     // Catch: java.lang.Throwable -> Ld8
            com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper r8 = r1.mMapViewWrapper     // Catch: java.lang.Throwable -> Ld8
            android.view.View r9 = r0.getRootView()     // Catch: java.lang.Throwable -> Ld8
            r13 = 0
            r14 = 1
            boolean r15 = r1.mIsMiniMap     // Catch: java.lang.Throwable -> Ld8
            r10 = r5
            com.xiaopeng.montecarlo.navcore.util.MarkUtils.createMakerByView(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> Ld8
            goto Ld5
        Lc1:
            r2 = 2131689870(0x7f0f018e, float:1.9008768E38)
            r6.setText(r2)     // Catch: java.lang.Throwable -> Ld8
            com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper r8 = r1.mMapViewWrapper     // Catch: java.lang.Throwable -> Ld8
            android.view.View r9 = r0.getRootView()     // Catch: java.lang.Throwable -> Ld8
            r13 = 0
            r14 = 1
            boolean r15 = r1.mIsMiniMap     // Catch: java.lang.Throwable -> Ld8
            r10 = r5
            com.xiaopeng.montecarlo.navcore.util.MarkUtils.createMakerByView(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> Ld8
        Ld5:
            r0 = r5
        Ld6:
            monitor-exit(r16)
            return r0
        Ld8:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.createLaneGuideIntervalCameraMarkId(com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.layer.LaneGuideCameraLayerItem):int");
    }

    private synchronized int createLaneGuideTurnMarkId(LaneGuideTurnLayerItem laneGuideTurnLayerItem) {
        if (laneGuideTurnLayerItem == null) {
            return -1;
        }
        short mMainAction = laneGuideTurnLayerItem.getMMainAction();
        int mDirectionType = laneGuideTurnLayerItem.getMDirectionType();
        if (L.ENABLE) {
            L.d(TAG, "createLaneGuideTurnMarkId directionType:" + mDirectionType + ", action:" + ((int) mMainAction));
        }
        int laneGuideTurnResId = ResUtil.getLaneGuideTurnResId(mMainAction);
        int laneGuideTurnLayout = ResUtil.getLaneGuideTurnLayout(mDirectionType);
        if (laneGuideTurnResId > 0 && laneGuideTurnLayout > 0) {
            float laneGuideTurnRatioX = MarkUtils.getLaneGuideTurnRatioX(mDirectionType);
            float laneGuideTurnRatioY = MarkUtils.getLaneGuideTurnRatioY(mDirectionType);
            String guideCameraLayoutLeftOrRight = ResUtil.getGuideCameraLayoutLeftOrRight(mDirectionType);
            LayerHolder view = this.viewCacheManager.getView(laneGuideTurnLayerItem.getBusinessType(), laneGuideTurnLayout, guideCameraLayoutLeftOrRight);
            XLinearLayout xLinearLayout = (XLinearLayout) view.getView(R.id.ll_main_content);
            ((ImageView) view.getView(R.id.iv_map_lane_turn_icon)).setBackground(ThemeWatcherUtil.getDrawable(laneGuideTurnResId));
            xLinearLayout.setBackground("0".equals(guideCameraLayoutLeftOrRight) ? ThemeWatcherUtil.getDrawable(R.drawable.png_lane_bubble_container_left) : ThemeWatcherUtil.getDrawable(R.drawable.png_lane_bubble_container_right));
            this.mLaneTurnMarkId++;
            if (this.mLaneTurnMarkId > 548) {
                this.mLaneTurnMarkId = MarkUtils.MARKER_ID_LANE_TURN;
            }
            int i = this.mLaneTurnMarkId;
            MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i, laneGuideTurnRatioX, laneGuideTurnRatioY, false, true, this.mIsMiniMap);
            return i;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0066 A[Catch: all -> 0x02a0, TryCatch #0 {, blocks: (B:8:0x0008, B:13:0x0031, B:18:0x003b, B:22:0x0042, B:28:0x004e, B:38:0x0062, B:40:0x0066, B:42:0x00c8, B:43:0x00e6, B:50:0x0105, B:54:0x0115, B:58:0x011d, B:60:0x0170, B:64:0x019e, B:67:0x01d1, B:69:0x01dd, B:70:0x01e1, B:72:0x01ef, B:73:0x01fe, B:75:0x020d, B:77:0x0211, B:79:0x0219, B:81:0x0228, B:83:0x0238, B:85:0x0246, B:87:0x024e, B:90:0x025c, B:91:0x0275, B:66:0x01b9, B:11:0x0029), top: B:100:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0113 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0115 A[Catch: all -> 0x02a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x0008, B:13:0x0031, B:18:0x003b, B:22:0x0042, B:28:0x004e, B:38:0x0062, B:40:0x0066, B:42:0x00c8, B:43:0x00e6, B:50:0x0105, B:54:0x0115, B:58:0x011d, B:60:0x0170, B:64:0x019e, B:67:0x01d1, B:69:0x01dd, B:70:0x01e1, B:72:0x01ef, B:73:0x01fe, B:75:0x020d, B:77:0x0211, B:79:0x0219, B:81:0x0228, B:83:0x0238, B:85:0x0246, B:87:0x024e, B:90:0x025c, B:91:0x0275, B:66:0x01b9, B:11:0x0029), top: B:100:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized int createLaneGuideCameraMarkId(com.autonavi.gbl.map.layer.BaseLayer r22, com.autonavi.gbl.layer.LaneGuideCameraLayerItem r23) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.createLaneGuideCameraMarkId(com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.layer.LaneGuideCameraLayerItem):int");
    }

    private synchronized int createCruiseFacilityMarkId(CruiseFacilityLayerItem cruiseFacilityLayerItem) {
        int cruiseFacilityIconResId = ResUtil.getCruiseFacilityIconResId(cruiseFacilityLayerItem.getMType());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createCruiseFacilityMarkId addMarker type: " + cruiseFacilityLayerItem.getMType() + "  id: " + cruiseFacilityLayerItem.getID() + "    facilityResId:" + cruiseFacilityIconResId);
        }
        if (cruiseFacilityIconResId > 0) {
            LayerHolder view = this.viewCacheManager.getView(cruiseFacilityLayerItem.getBusinessType(), R.layout.layout_map_facilityinfo);
            ((ImageView) view.getView(R.id.facility_info_image)).setImageResource(cruiseFacilityIconResId);
            MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), 50, 0.5f, 0.9f, false, true, this.mIsMiniMap);
            return 50;
        }
        return -1;
    }

    private synchronized int createCruiseCameraMarkId(CruiseFacilityLayerItem cruiseFacilityLayerItem, BaseLayer baseLayer) {
        int i;
        int mType = cruiseFacilityLayerItem.getMType();
        int mSpeed = cruiseFacilityLayerItem.getMSpeed();
        i = cruiseFacilityLayerItem.getNormalStyle().poiMarkerId;
        int i2 = this.cruseDirectionLeft ? 1 : 2;
        this.cruseDirectionLeft = !this.cruseDirectionLeft;
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine("getExtraPointMarker: cameraType = " + mType + " speed = " + mSpeed, this.mEngineID));
        }
        LayerHolder view = this.viewCacheManager.getView(cruiseFacilityLayerItem.getBusinessType(), R.layout.map_layout_camera_info);
        XImageView xImageView = (XImageView) view.getView(R.id.tv_map_guide_camera_icon);
        view.getRootView().setBackground(ContextUtils.getDrawable(ResUtil.getGuideCameraBgId(i2, false)));
        float cameraBgRatioX = MarkUtils.getCameraBgRatioX(i2);
        float cameraBgRatioY = MarkUtils.getCameraBgRatioY(i2);
        if (i == -1) {
            this.mCruiseCameraMarkId--;
            i = this.mCruiseCameraMarkId;
            if (this.mCruiseCameraMarkId <= 50) {
                this.mCruiseCameraMarkId = 60;
            }
        }
        if (4 != mType) {
            int cruiseCameraTypeResId = ResUtil.getCruiseCameraTypeResId(mType);
            if (cruiseCameraTypeResId != 0) {
                xImageView.setBackground(ContextUtils.getDrawable(cruiseCameraTypeResId));
                MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            }
            i = -1;
        } else if (mSpeed > 0) {
            xImageView.setBackground(ContextUtils.getDrawable(ResUtil.getSpeedCameraResource(mSpeed)));
            MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
        } else {
            if (mSpeed == 0) {
                xImageView.setBackground(ContextUtils.getDrawable(R.drawable.vector_ic_mid_scan_speed));
                MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            }
            i = -1;
        }
        return i;
    }

    private synchronized int createTrafficLightMarkId(GuideTrafficSignalLightLayerItem guideTrafficSignalLightLayerItem, BaseLayer baseLayer) {
        if (guideTrafficSignalLightLayerItem == null) {
            return -1;
        }
        int quadrantType = guideTrafficSignalLightLayerItem.getQuadrantType();
        long waitRoundCount = guideTrafficSignalLightLayerItem.getWaitRoundCount();
        int crossManeuverID = guideTrafficSignalLightLayerItem.getCrossManeuverID();
        int lightCountDown = guideTrafficSignalLightLayerItem.getLightCountDown();
        int trafficLightStatus = guideTrafficSignalLightLayerItem.getTrafficLightStatus();
        float lightAlpha = guideTrafficSignalLightLayerItem.getLightAlpha();
        float arrowDirectionAlpha = guideTrafficSignalLightLayerItem.getArrowDirectionAlpha();
        int i = guideTrafficSignalLightLayerItem.getNormalStyle().poiMarkerId;
        String str = "createTrafficLightMarkId directionStyle:" + quadrantType + " , id = " + guideTrafficSignalLightLayerItem.getID() + " , waitRoundCount = " + waitRoundCount + " , crossManeuver = " + crossManeuverID + ", lightCountDown = " + lightCountDown + ", trafficLightStatus = " + trafficLightStatus + ", lightAlpha = " + lightAlpha + ", arrowAlpha = " + arrowDirectionAlpha;
        if (L.ENABLE) {
            L.d(TAG, str);
        } else if (lightCountDown != this.mLastLightCountDown) {
            L.i(TAG, str);
            this.mLastLightCountDown = lightCountDown;
        }
        int guideTrafficLightArrowDirectionId = ResUtil.getGuideTrafficLightArrowDirectionId(crossManeuverID);
        int guideTrafficLightBgId = ResUtil.getGuideTrafficLightBgId(quadrantType);
        float cameraBgRatioX = MarkUtils.getCameraBgRatioX(quadrantType);
        float cameraBgRatioY = MarkUtils.getCameraBgRatioY(quadrantType);
        if (guideTrafficLightBgId > 0 && guideTrafficLightArrowDirectionId > 0) {
            LayerHolder view = this.viewCacheManager.getView(guideTrafficSignalLightLayerItem.getBusinessType(), R.layout.layout_traffic_signal_light);
            XImageView xImageView = (XImageView) view.getView(R.id.traffic_light_color);
            XImageView xImageView2 = (XImageView) view.getView(R.id.traffic_light_arrow);
            XLinearLayout xLinearLayout = (XLinearLayout) view.getView(R.id.traffic_light_countdown_text_group);
            XTextView xTextView = (XTextView) view.getView(R.id.traffic_light_countdown_text_wait);
            XTextView xTextView2 = (XTextView) view.getView(R.id.traffic_light_countdown_text_number);
            XTextView xTextView3 = (XTextView) view.getView(R.id.traffic_light_countdown_text_unit);
            xTextView2.setTextSize(CommonUtil.getResources().getDimension(R.dimen.font_size_50));
            xTextView2.setTextColor(ContextUtils.getColor(R.color.xlbs_color_text_traffic));
            xTextView3.setTextColor(ContextUtils.getColor(R.color.xlbs_color_text_traffic));
            xTextView.setTextColor(ContextUtils.getColor(R.color.xlbs_color_text_traffic));
            xTextView3.setVisibility(0);
            xTextView.setVisibility(8);
            xLinearLayout.setVisibility(8);
            ((XImageView) view.getView(R.id.traffic_light_arrow_direction)).setVisibility(8);
            view.getRootView().setBackground(ContextUtils.getDrawable(guideTrafficLightBgId));
            switch (trafficLightStatus) {
                case 1:
                    xImageView.setImageDrawable(ContextUtils.getDrawable(R.drawable.png_light_red));
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(guideTrafficLightArrowDirectionId));
                    xTextView2.setText(String.valueOf(waitRoundCount));
                    xTextView2.setTextColor(ContextUtils.getColor(R.color.xlbs_color_red));
                    xTextView3.setText(ContextUtils.getString(R.string.guide_traffic_light_wait_round));
                    xTextView.setVisibility(0);
                    xLinearLayout.setVisibility(0);
                    break;
                case 2:
                    xImageView.setImageDrawable(ContextUtils.getDrawable(R.drawable.png_light_red));
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(guideTrafficLightArrowDirectionId));
                    if (lightCountDown < 0) {
                        xTextView2.setText("等待");
                        xTextView2.setTextSize(CommonUtil.getResources().getDimension(R.dimen.font_size_30));
                        xTextView3.setVisibility(8);
                        xLinearLayout.setVisibility(0);
                        break;
                    } else {
                        xTextView3.setText(ContextUtils.getString(R.string.guide_traffic_light_wait_seconds));
                        xTextView2.setText(String.valueOf(lightCountDown));
                        xLinearLayout.setVisibility(0);
                        break;
                    }
                case 3:
                    Drawable drawable = ContextUtils.getDrawable(R.drawable.png_light_red);
                    drawable.setAlpha((int) (lightAlpha * 255.0f));
                    xImageView.setImageDrawable(drawable);
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(guideTrafficLightArrowDirectionId));
                    xTextView3.setText(ContextUtils.getString(R.string.guide_traffic_light_wait_seconds));
                    xTextView2.setText(String.valueOf(lightCountDown));
                    xLinearLayout.setVisibility(0);
                    break;
                case 4:
                case 5:
                    xImageView.setImageDrawable(ContextUtils.getDrawable(R.drawable.png_light_green));
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(guideTrafficLightArrowDirectionId));
                    if (lightCountDown < 0) {
                        xTextView2.setText("通行");
                        xTextView2.setTextSize(CommonUtil.getResources().getDimension(R.dimen.font_size_30));
                        xTextView3.setVisibility(8);
                        xLinearLayout.setVisibility(0);
                        break;
                    } else {
                        xTextView3.setText(ContextUtils.getString(R.string.guide_traffic_light_wait_seconds));
                        xTextView2.setText(String.valueOf(lightCountDown));
                        xLinearLayout.setVisibility(0);
                        break;
                    }
                case 6:
                    Drawable drawable2 = ContextUtils.getDrawable(R.drawable.png_light_green);
                    drawable2.setAlpha((int) (lightAlpha * 255.0f));
                    xImageView.setImageDrawable(drawable2);
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(guideTrafficLightArrowDirectionId));
                    xTextView2.setText("通行");
                    xTextView2.setTextSize(CommonUtil.getResources().getDimension(R.dimen.font_size_30));
                    xTextView3.setVisibility(8);
                    xLinearLayout.setVisibility(0);
                    break;
                case 7:
                default:
                    return -1;
                case 8:
                    xImageView.setBackground(null);
                    xImageView.setImageDrawable(ContextUtils.getDrawable(R.drawable.png_light_yellow));
                    xImageView.setAlpha(lightAlpha);
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(guideTrafficLightArrowDirectionId));
                    if (lightCountDown < 0) {
                        xTextView2.setText("等待");
                        xTextView2.setTextSize(CommonUtil.getResources().getDimension(R.dimen.font_size_30));
                        xTextView3.setVisibility(8);
                        xLinearLayout.setVisibility(0);
                        break;
                    }
                    break;
            }
            int i2 = i;
            if (i2 == -1) {
                this.mGuideTrafficLightMarkId--;
                if (this.mGuideTrafficLightMarkId <= 515) {
                    this.mGuideTrafficLightMarkId = 525;
                }
                int i3 = this.mGuideTrafficLightMarkId;
                if (this.mGuideTrafficLightMarkIds.contains(Integer.valueOf(i3))) {
                    this.mGuideTrafficLightMarkIds.remove(Integer.valueOf(i3));
                    this.mMapViewWrapper.cleanOverlayTexture(i3, false);
                }
                this.mGuideTrafficLightMarkIds.add(Integer.valueOf(i3));
                L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker: GUIDE_TRAFFIC_LIGHT markId = " + i3, this.mEngineID));
                i2 = i3;
            }
            MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i2, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            return i2;
        }
        return -1;
    }

    private synchronized int createLaneTrafficLightIconMarkId(LaneGuideTrafficLightIconLayerItem laneGuideTrafficLightIconLayerItem) {
        if (laneGuideTrafficLightIconLayerItem == null) {
            return -1;
        }
        View.inflate(ContextUtils.getContext(), R.layout.layout_tranffic_light_icon, null);
        MarkUtils.createMakerByView(this.mMapViewWrapper, this.viewCacheManager.getView(laneGuideTrafficLightIconLayerItem.getBusinessType(), R.layout.layout_tranffic_light_icon).getRootView(), MarkUtils.MARKER_ID_LANE_GUIDE_TRAFFIC_LIGHT_ICON, 0.5f, 0.9f, false, true, this.mIsMiniMap);
        return MarkUtils.MARKER_ID_LANE_GUIDE_TRAFFIC_LIGHT_ICON;
    }

    private synchronized int createLaneTrafficLightMarkId(LaneGuideTrafficLightCountdownLayerItem laneGuideTrafficLightCountdownLayerItem, BaseLayer baseLayer) {
        int i;
        if (laneGuideTrafficLightCountdownLayerItem == null) {
            return -1;
        }
        int quadrantType = laneGuideTrafficLightCountdownLayerItem.getQuadrantType();
        long waitRound = laneGuideTrafficLightCountdownLayerItem.getWaitRound();
        String lightDirection = laneGuideTrafficLightCountdownLayerItem.getLightDirection();
        int remainSeconds = laneGuideTrafficLightCountdownLayerItem.getRemainSeconds();
        int lightStatus = laneGuideTrafficLightCountdownLayerItem.getLightStatus();
        float lightBodyAlpha = laneGuideTrafficLightCountdownLayerItem.getLightBodyAlpha();
        float lightDirectionAlpha = laneGuideTrafficLightCountdownLayerItem.getLightDirectionAlpha();
        String id = laneGuideTrafficLightCountdownLayerItem.getID();
        int laneGuideTrafficLightBgId = ResUtil.getLaneGuideTrafficLightBgId(quadrantType);
        int guideTrafficLightArrowDirectionId = ResUtil.getGuideTrafficLightArrowDirectionId(lightDirection);
        float cameraBgRatioX = MarkUtils.getCameraBgRatioX(quadrantType);
        float trafficLightBgRatioY = MarkUtils.getTrafficLightBgRatioY(quadrantType);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            i = guideTrafficLightArrowDirectionId;
            sb.append("createLaneTrafficLightMarkId directionStyle:");
            sb.append(quadrantType);
            sb.append(" , id = ");
            sb.append(id);
            sb.append(" , waitRoundCount = ");
            sb.append(waitRound);
            sb.append(" , crossManeuver = ");
            sb.append(lightDirection);
            sb.append(", lightCountDown = ");
            sb.append(remainSeconds);
            sb.append(", trafficLightStatus = ");
            sb.append(lightStatus);
            sb.append(", radioX = ");
            sb.append(cameraBgRatioX);
            sb.append(", radioY = ");
            sb.append(trafficLightBgRatioY);
            sb.append(", lightAlpha = ");
            sb.append(lightBodyAlpha);
            sb.append(", arrowAlpha = ");
            sb.append(lightDirectionAlpha);
            L.d(tag, sb.toString());
        } else {
            i = guideTrafficLightArrowDirectionId;
        }
        if (laneGuideTrafficLightBgId > 0 && i > 0) {
            LayerHolder view = this.viewCacheManager.getView(laneGuideTrafficLightCountdownLayerItem.getBusinessType(), R.layout.layout_traffic_signal_light);
            XImageView xImageView = (XImageView) view.getView(R.id.traffic_light_color);
            XImageView xImageView2 = (XImageView) view.getView(R.id.traffic_light_arrow);
            XLinearLayout xLinearLayout = (XLinearLayout) view.getView(R.id.traffic_light_countdown_text_group);
            XTextView xTextView = (XTextView) view.getView(R.id.traffic_light_countdown_text_wait);
            XTextView xTextView2 = (XTextView) view.getView(R.id.traffic_light_countdown_text_number);
            XTextView xTextView3 = (XTextView) view.getView(R.id.traffic_light_countdown_text_unit);
            view.getRootView().setBackground(ContextUtils.getDrawable(laneGuideTrafficLightBgId));
            xLinearLayout.setVisibility(8);
            ((XImageView) view.getView(R.id.traffic_light_arrow_direction)).setVisibility(8);
            xTextView.setVisibility(8);
            switch (lightStatus) {
                case 1:
                    xImageView.setImageDrawable(ContextUtils.getDrawable(R.drawable.png_light_red));
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(i));
                    xTextView2.setText(String.valueOf(waitRound));
                    xTextView2.setTextColor(ContextUtils.getColor(R.color.xlbs_color_red));
                    xTextView3.setText(ContextUtils.getString(R.string.guide_traffic_light_wait_round));
                    xTextView.setVisibility(0);
                    xLinearLayout.setVisibility(0);
                    break;
                case 2:
                    xImageView.setImageDrawable(ContextUtils.getDrawable(R.drawable.png_light_red));
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(i));
                    xTextView3.setText(ContextUtils.getString(R.string.guide_traffic_light_wait_seconds));
                    xTextView2.setText(String.valueOf(remainSeconds));
                    xLinearLayout.setVisibility(0);
                    break;
                case 3:
                    Drawable drawable = ContextUtils.getDrawable(R.drawable.png_light_red);
                    drawable.setAlpha((int) (lightBodyAlpha * 255.0f));
                    xImageView.setImageDrawable(drawable);
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(i));
                    xTextView3.setText(ContextUtils.getString(R.string.guide_traffic_light_wait_seconds));
                    xTextView2.setText(String.valueOf(remainSeconds));
                    xLinearLayout.setVisibility(0);
                    break;
                case 4:
                case 5:
                case 6:
                    Drawable drawable2 = ContextUtils.getDrawable(R.drawable.png_light_green);
                    drawable2.setAlpha((int) (lightBodyAlpha * 255.0f));
                    xImageView.setImageDrawable(drawable2);
                    xImageView2.setImageDrawable(ContextUtils.getDrawable(i));
                    xTextView2.setText("通行");
                    xTextView2.setTextSize(CommonUtil.getResources().getDimension(R.dimen.font_size_30));
                    xTextView3.setVisibility(8);
                    xLinearLayout.setVisibility(0);
                    break;
                default:
                    return -1;
            }
            this.mLaneGuideTrafficLightMarkId--;
            if (this.mLaneGuideTrafficLightMarkId <= 526) {
                this.mLaneGuideTrafficLightMarkId = 536;
            }
            int i2 = this.mLaneGuideTrafficLightMarkId;
            if (this.mLaneGuideTrafficLightMarkIds.contains(Integer.valueOf(i2))) {
                this.mLaneGuideTrafficLightMarkIds.remove(Integer.valueOf(i2));
                this.mMapViewWrapper.cleanOverlayTexture(i2, false);
            }
            this.mLaneGuideTrafficLightMarkIds.add(Integer.valueOf(i2));
            L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker: GUIDE_LANE_TRAFFIC_LIGHT markId = " + i2, this.mEngineID));
            MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i2, cameraBgRatioX, trafficLightBgRatioY, false, true, this.mIsMiniMap);
            return i2;
        }
        return -1;
    }

    private synchronized int createCruiseTrafficEventMarkId(CruiseCongestionEventLayerItem cruiseCongestionEventLayerItem, BaseLayer baseLayer) {
        int indexOf;
        BizSocolEventInfo mSocolEventInfo = cruiseCongestionEventLayerItem.getMSocolEventInfo();
        if (mSocolEventInfo != null && mSocolEventInfo.mInfo != null) {
            int i = mSocolEventInfo.mInfo.eventType;
            String cruiseTrafficEventName = ResUtil.getCruiseTrafficEventName(i);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "createCruiseTrafficEventMarkId addMarker eventType: " + i + "  id: " + cruiseCongestionEventLayerItem.getID() + "    label:" + cruiseTrafficEventName);
            }
            if (TextUtils.isEmpty(cruiseTrafficEventName)) {
                return -1;
            }
            LayerHolder view = this.viewCacheManager.getView(cruiseCongestionEventLayerItem.getBusinessType(), R.layout.layout_cruise_traffic_event);
            TextView textView = (TextView) view.getView(R.id.tv_content);
            view.getRootView().setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_cruise_traffic_event_bg));
            textView.setText(cruiseTrafficEventName);
            textView.setTextColor(ThemeWatcherUtil.getColor(R.color.cruise_traffic_event_text_color));
            if (this.mEventCache.contains(cruiseTrafficEventName)) {
                indexOf = this.mEventCache.indexOf(cruiseTrafficEventName);
            } else {
                this.mEventCache.add(cruiseTrafficEventName);
                indexOf = this.mEventCache.indexOf(cruiseTrafficEventName);
            }
            int i2 = 469 - indexOf;
            MarkUtils.createMakerByView(this.mMapViewWrapper, view.getRootView(), i2, 1.0f, 0.45f, false, true, this.mIsMiniMap);
            return i2;
        }
        return -1;
    }

    private int createMarkPointMarkId(String str, boolean z) {
        String[] split = str.split(MarkPointDecorator.TYPE_MID);
        if (split.length == 2 && TextUtils.isDigitsOnly(split[1]) && Integer.parseInt(split[1]) == 1) {
            return z ? 12 : 11;
        }
        return -1;
    }

    private int createSearchPoiParentPointMarkId(String str, boolean z) {
        int drawableResId;
        int drawableResId2;
        int i;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int i2 = 0;
        if (str.startsWith(RouteChargeDecorator.ROUTE_CHARGE_PRE)) {
            int[] createRouteChargeTexture = RouteChargeDecorator.createRouteChargeTexture(str);
            int i3 = z ? createRouteChargeTexture[1] : createRouteChargeTexture[0];
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "ROUTE_CHARGE add overlay: " + str + ", markid: " + i3);
            }
            return i3;
        }
        int i4 = 82;
        int i5 = 83;
        boolean startsWith = str.startsWith(SearchDecorator.SEARCH_SINGLE_ID);
        if (startsWith) {
            drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point);
            drawableResId2 = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point_pressed);
        } else if (str.startsWith(SearchDecorator.SEARCH_CENTER_ID)) {
            if (L.ENABLE) {
                L.d(TAG, "createSearchPoiParentPointMarkId SEARCH_CENTER_ID");
            }
            if (ThemeWatcherUtil.isDayMode()) {
                return 446;
            }
            return MarkUtils.MARKER_ID_SEARCH_AROUNT_POI_CENTER_NIGHT;
        } else {
            if (TextUtils.isDigitsOnly(str)) {
                int parseInt = Integer.parseInt(str);
                MainContext mainContext = this.mMainContext;
                if (mainContext != null) {
                    IBaseScene currentScene = mainContext.getCurrentScene();
                    if ((currentScene instanceof SearchResultFragment) && ((SearchResultFragment) currentScene).isUnVisibleItem(parseInt - 1)) {
                        return 402;
                    }
                }
                i2 = parseInt;
            }
            drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point01);
            drawableResId2 = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point01_pressed);
            i4 = 133 - i2;
            i5 = 183 - i2;
        }
        int i6 = drawableResId;
        int i7 = drawableResId2;
        if (i2 == 1) {
            i = this.mMarkOneXOffset;
        } else if (i2 > 9) {
            i = this.mMarkOtherXOffset;
        } else {
            i = this.mMarkTwoXOffset;
        }
        int i8 = i;
        if (z) {
            int i9 = Utils.isLandscape() ? this.mMarkYOffset - 2 : this.mMarkYOffset;
            MarkUtils.createMakerWithTextAndBg(this.mMapViewWrapper, startsWith ? "" : str, ThemeWatcherUtil.getColorResId(Utils.isLandscape() ? R.color.search_overlay_root_focus : R.color.main_title_text_color), ContextUtils.getDimensionPixelSize(R.dimen.text_size_search_overlay_root_focus), true, i8, i9, i7, i5, false, true, this.mIsMiniMap);
            return i5;
        }
        MarkUtils.createMakerWithTextAndBg(this.mMapViewWrapper, startsWith ? "" : str, ThemeWatcherUtil.getColorResId(R.color.mark_normal_number_color), ContextUtils.getDimensionPixelSize(R.dimen.text_size_search_overlay_root_unfocus), true, i8, this.mMarkYOffset, i6, i4, false, true, this.mIsMiniMap);
        return i4;
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityResumed() {
        setIsNeedRefresh(true);
        this.mMapViewWrapper.getBizControlManager().updateResMarker(ThemeWatcherUtil.isDayMode());
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityCovered(boolean z) {
        setIsNeedRefresh(false);
    }

    public void setIsNeedRefresh(boolean z) {
        this.mIsNeedRefresh = z;
        this.mMapViewWrapper.getBizControlManager().setIsNeedRefresh(this.mIsNeedRefresh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class MultiAlternativePathLabelViewHolder {
        public XLinearLayout mLayout;
        public XTextView mTvCost;
        public XTextView mTvDistance;
        public XImageView mTvIndex;
        public XTextView mTvTime;
        public XTextView mTvTrafficLight;

        MultiAlternativePathLabelViewHolder() {
        }
    }
}
