package com.xiaopeng.montecarlo.scenes.mapscene;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.layer.CruiseCongestionEventLayerItem;
import com.autonavi.gbl.layer.CruiseFacilityLayerItem;
import com.autonavi.gbl.layer.GuideCameraLayerItem;
import com.autonavi.gbl.layer.GuideCongestionLayerItem;
import com.autonavi.gbl.layer.GuideETAEventLayerItem;
import com.autonavi.gbl.layer.GuideIntervalCameraLayerItem;
import com.autonavi.gbl.layer.GuideLabelLayerItem;
import com.autonavi.gbl.layer.GuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.LaneGuideCameraLayerItem;
import com.autonavi.gbl.layer.LaneGuideCongestionLayerItem;
import com.autonavi.gbl.layer.LaneGuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.LaneGuideTurnLayerItem;
import com.autonavi.gbl.layer.LaneRoutePathPointItem;
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
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.mapoverlay.mark.MarkPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecorator;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.NaviRouteOverlayParam;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.CloudRouteDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.MixedTextView;
import com.xiaopeng.xui.widget.XLinearLayout;
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
    private SearchChargeDecoratorViewHolder mSearchChargeDecoratorVHolder;
    private View mViaView;
    protected NaviRouteOverlayParam mNaviRouteOverlayParam = new NaviRouteOverlayParam();
    private ArrayList<Integer> mCameraMarkIds = new ArrayList<>();
    private int mCameraMarkId = 309;
    private int mCruiseCameraMarkId = 60;
    private ArrayList<Integer> mLaneCameraMarkIds = new ArrayList<>();
    private int mLaneCameraMarkId = 510;
    private List<String> mEventCache = new ArrayList();
    private List<Integer> mETAEventCache = new ArrayList();
    private List<Integer> mRouteEventCache = new ArrayList();
    private List<Integer> mRouteBlockEventCache = new ArrayList();
    private volatile int mMultiIndex = 0;
    private boolean mIsNeedRefresh = true;
    private Map<String, Integer> mECameraMarkIdCache = new HashMap();

    private int createVPAPointMarkId(boolean z) {
        return z ? 44 : 43;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public void clearLayerItem(BaseLayer baseLayer, LayerItem layerItem) {
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public void clearLayerItems(BaseLayer baseLayer) {
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
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0209, code lost:
        if (r1.equals("1") != false) goto L137;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0249 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02d7  */
    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getMarkerId(com.autonavi.gbl.map.layer.BaseLayer r22, com.autonavi.gbl.map.layer.LayerItem r23, com.autonavi.gbl.map.layer.model.ItemStyleInfo r24) {
        /*
            Method dump skipped, instructions count: 1404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.getMarkerId(com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.model.ItemStyleInfo):int");
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

    /* JADX WARN: Removed duplicated region for block: B:152:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x028a  */
    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getLayerStyle(com.autonavi.gbl.map.layer.BaseLayer r7, com.autonavi.gbl.map.layer.LayerItem r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 1196
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
    public void clearLayerStyle(BaseLayer baseLayer, LayerItem layerItem) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearLayerStyle itemType:" + layerItem.getBusinessType() + " layerName:" + baseLayer.getName());
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public String getCommonInfo(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getCommonInfo:" + str);
        }
        return CommonUtil.getStyleBeanJson("common_info_foreshortening");
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

    private int createExplorePathBoard(int i, String str) {
        XPManeuverInfo naviManeuverInfo = TBTManager.getInstance().getNaviManeuverInfo();
        if (naviManeuverInfo != null) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("getBizPointOverlayMarker >>> createExplorePathBoard directionStyle=" + i, this.mEngineID));
            int nextRoadTurnResource = ResUtil.getNextRoadTurnResource(naviManeuverInfo.mManeuverID);
            if (nextRoadTurnResource == 0 || TextUtils.isEmpty(str)) {
                return -1;
            }
            int exploreRoadNameLabelBgResource = ResUtil.getExploreRoadNameLabelBgResource(i);
            float commonBgRatioX = MarkUtils.getCommonBgRatioX(i);
            float commonBgRatioY = MarkUtils.getCommonBgRatioY(i);
            View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_next_road, null);
            inflate.setBackground(ThemeWatcherUtil.getDrawable(exploreRoadNameLabelBgResource));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.im_next_road_turn_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_next_road_name);
            imageView.setVisibility(0);
            imageView.setImageResource(nextRoadTurnResource);
            textView.setText(str);
            textView.setTextColor(ThemeWatcherUtil.getColor(R.color.explore_map_next_roadname_text_color));
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, 16, commonBgRatioX, commonBgRatioY, false, true, this.mIsMiniMap);
            return 16;
        }
        return -1;
    }

    private int createNaviPathBoard(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        L.Tag tag = TAG;
        L.i(tag, "getBizPointOverlayMarker >>> createNaviPathBoard directionStyle=" + i);
        int guideRoadNameLabelBgResource = ResUtil.getGuideRoadNameLabelBgResource(i);
        float commonBgRatioX = MarkUtils.getCommonBgRatioX(i);
        float commonBgRatioY = MarkUtils.getCommonBgRatioY(i);
        View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_next_road, null);
        inflate.setBackground(ThemeWatcherUtil.getDrawable(guideRoadNameLabelBgResource));
        TextView textView = (TextView) inflate.findViewById(R.id.tv_next_road_name);
        ((ImageView) inflate.findViewById(R.id.im_next_road_turn_icon)).setVisibility(8);
        textView.setText(str);
        textView.setTextColor(ThemeWatcherUtil.getColor(R.color.guide_map_next_roadname_text_color));
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, 16, commonBgRatioX, commonBgRatioY, false, true, this.mIsMiniMap);
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
        int i = mLabelIndex == 0 ? MarkUtils.MARKER_ID_TIE_1 : MarkUtils.MARKER_ID_TIE_2;
        this.mMultiIndex++;
        if (this.mMultiIndex >= 4) {
            this.mMultiIndex = 0;
            z = true;
        } else {
            z = false;
        }
        updateMultiAlternativePathDiff(mLabelIndex, mPathId);
        createMultiAlternativePathLabel(this.mMultiPathDiffLightCnt, this.mMultiPathDiffTotalDis, this.mMultiPathDiffTime, this.mMultiPathDiffToll, this.mMultiPathIsOnTollRoad, i, mPathId, mBoardStyle, z);
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateMultiAlternativePathDiff(int r29, long r30) {
        /*
            Method dump skipped, instructions count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.updateMultiAlternativePathDiff(int, long):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(1:8)(2:91|(21:93|10|(1:12)(3:86|(1:88)(1:90)|89)|13|(2:15|(1:17)(17:(1:82)(1:84)|83|(3:20|(1:22)(2:(1:77)(1:79)|78)|23)(1:80)|24|(1:26)|27|(1:29)(1:75)|30|(1:32)(1:74)|33|34|35|36|(2:40|(2:42|(1:46))(3:47|(4:49|(2:52|50)|53|54)|55))|56|(1:58)|59))(1:85)|18|(0)(0)|24|(0)|27|(0)(0)|30|(0)(0)|33|34|35|36|(3:38|40|(0)(0))|56|(0)|59)(1:94))|34|35|36|(0)|56|(0)|59) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0280, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0281, code lost:
        com.xiaopeng.montecarlo.root.util.L.w(com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.TAG, "createMakerByText" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0297, code lost:
        r17.mMultiAlternativePathLabelViewHolder.mLayout.destroyDrawingCache();
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0383  */
    @android.annotation.SuppressLint({"WrongThread"})
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createMultiAlternativePathLabel(long r18, long r20, double r22, int r24, boolean r25, int r26, long r27, int r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 976
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle.createMultiAlternativePathLabel(long, long, double, int, boolean, int, long, int, boolean):void");
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

    private int getRouteViaPointId(int i, boolean z) {
        XPViaPoint xPViaPoint;
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (viaInfos == null || i <= -1 || i >= viaInfos.size() || (xPViaPoint = viaInfos.get(i)) == null) {
            return -1;
        }
        boolean isPassedVia = xPViaPoint.getIsPassedVia();
        int realViaIndex = CloudRouteDataHelper.getInstance().getRealViaIndex(i);
        L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker RouteOverlayElemVias index: " + i + ", isPassedVia: " + isPassedVia + " realIndex: " + realViaIndex + ", viaType: " + viaInfos.get(i).getViaType(), this.mEngineID));
        if (realViaIndex <= -1 || realViaIndex >= viaInfos.size()) {
            return !CloudRouteDataHelper.getInstance().isCloudRouteModeOpen() ? 20 : -1;
        }
        if (this.mViaView == null) {
            this.mViaView = View.inflate(ContextUtils.getContext(), R.layout.layout_path_via, null);
        }
        TextView textView = (TextView) this.mViaView.findViewById(R.id.via_index);
        textView.setText(Integer.toString(realViaIndex + 1));
        if (z) {
            int i2 = ((isPassedVia ? realViaIndex + MarkUtils.MARKER_ID_BUBBLE_PASSED_FOCUSED_VIA : realViaIndex + 333) + 1) - 12;
            this.mViaView.setBackground(ThemeWatcherUtil.getDrawable(isPassedVia ? R.drawable.png_poi_small_pressed_passed_point : R.drawable.png_poi_small_pressed_passing_point));
            textView.setTextColor(ThemeWatcherUtil.getColor(R.color.main_title_text_color));
            MarkUtils.createMakerByViewSync(this.mMapViewWrapper, this.mViaView, i2, 0.5f, 1.0f, true, false, this.mIsMiniMap);
            return i2;
        }
        textView.setTextColor(ContextUtils.getColor(ThemeWatcherUtil.isDayMode() ? R.color.xui_white : R.color.palette_tag_drck_gray_night));
        int i3 = ((isPassedVia ? realViaIndex + MarkUtils.MARKER_ID_BUBBLE_PASSED_VIA : realViaIndex + 321) + 1) - 12;
        this.mViaView.setBackground(ThemeWatcherUtil.getDrawable(isPassedVia ? R.drawable.png_poi_small_passed_point : R.drawable.png_poi_small_passing_point));
        MarkUtils.createMakerByViewSync(this.mMapViewWrapper, this.mViaView, i3, 0.5f, 1.0f, true, false, this.mIsMiniMap);
        return i3;
    }

    private int createRouteTypeCompareTipMarkerId(RouteCompareTipsLayerItem routeCompareTipsLayerItem) {
        RouteLimitInfo routeLimitInfo;
        if (routeCompareTipsLayerItem == null) {
            L.w(TAG, "XPTRAFFICEVENT createRouteTypeCompareTipMarkerId compareTipsLayerItem is null");
            return -1;
        }
        View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_compare_route_tips, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        textView.setTextColor(ThemeWatcherUtil.getColor(R.color.guide_route_compare_tips_text_color));
        inflate.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_route_compare_tips_bg));
        float[] routeLabelRatioForDirection = MarkUtils.getRouteLabelRatioForDirection(5);
        long j = 0;
        StringBuilder sb = new StringBuilder(routeCompareTipsLayerItem.getMTipName());
        if (routeCompareTipsLayerItem.getMIsNewRoute()) {
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
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, 24, routeLabelRatioForDirection[0], routeLabelRatioForDirection[1], false, true, this.mIsMiniMap);
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("XPTRAFFICEVENT getBizPointOverlayMarker RouteOverlayElemCompareTips name: " + routeCompareTipsLayerItem.getMTipName() + ", pathId: " + routeCompareTipsLayerItem.getID() + ", save time: " + j, this.mEngineID));
            return 24;
        }
        return 23;
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

    private int createGuideCongestionMarkerId(GuideCongestionLayerItem guideCongestionLayerItem) {
        if (guideCongestionLayerItem == null) {
            L.w(TAG, ">>> createGuideCongestionMarkerId congestionLayerItem is null");
            return -1;
        }
        int mDirectionStyle = guideCongestionLayerItem.getMDirectionStyle();
        long mTotalTimeOfSeconds = guideCongestionLayerItem.getMTotalTimeOfSeconds();
        long mTotalRemainDist = guideCongestionLayerItem.getMTotalRemainDist();
        int mCongestionStatus = guideCongestionLayerItem.getMCongestionStatus();
        L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker >>> GuideOverlayTypeCongestion directionStyle=" + mDirectionStyle + " congestionStatus=" + mCongestionStatus, this.mEngineID));
        if (mCongestionStatus == 0 || 5 == mCongestionStatus) {
            mCongestionStatus = 1;
        }
        int congestionLabelBgResource = ResUtil.getCongestionLabelBgResource(mDirectionStyle, mCongestionStatus, ThemeWatcherUtil.isDayMode());
        if (congestionLabelBgResource != 0) {
            View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_guide_congestion, null);
            inflate.setBackground(ThemeWatcherUtil.getDrawable(congestionLabelBgResource));
            MixedTextView mixedTextView = (MixedTextView) inflate.findViewById(R.id.tv_congestion_distance);
            View findViewById = inflate.findViewById(R.id.vertical_line);
            String[] distanceArray = NaviUtil.getDistanceArray(mTotalRemainDist);
            List<String> timeListString = NaviUtil.getTimeListString(mTotalTimeOfSeconds);
            L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker >>> GuideOverlayTypeCongestion remainDis=" + mTotalRemainDist + ", remainTime =" + mTotalTimeOfSeconds, this.mEngineID));
            if (TextUtils.isEmpty(distanceArray[0])) {
                mixedTextView.setVisibility(8);
                findViewById.setVisibility(8);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(distanceArray[0]);
                arrayList.add(distanceArray[1]);
                mixedTextView.updateMixedText(arrayList);
                mixedTextView.setVisibility(0);
                findViewById.setVisibility(0);
            }
            MixedTextView mixedTextView2 = (MixedTextView) inflate.findViewById(R.id.tv_congestion_time);
            if (timeListString == null || CollectionUtils.isEmpty(timeListString)) {
                mixedTextView2.setVisibility(8);
            } else {
                mixedTextView2.updateMixedText(timeListString);
                mixedTextView2.setVisibility(0);
            }
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, 33, MarkUtils.getCommonBgRatioX(mDirectionStyle), MarkUtils.getCommonBgRatioY(mDirectionStyle), false, true, this.mIsMiniMap);
            return 33;
        }
        return -1;
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

    private int createGuideTrafficEventMarkerId(GuideTrafficEventLayerItem guideTrafficEventLayerItem) {
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
        LinearLayout linearLayout = (LinearLayout) View.inflate(ContextUtils.getContext(), R.layout.layout_navigation_traffic_event, null);
        View findViewById = linearLayout.findViewById(R.id.guide_traffic_content);
        findViewById.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.drawable_map_style_guide_map_traffic_event_bg));
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.guide_traffic_icon);
        imageView.setImageResource(ResUtil.getTrafficEventThemeIconId(valueOf, false));
        TextView textView = (TextView) linearLayout.findViewById(R.id.tv_traffic_event_title);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.tv_traffic_event_lane);
        String trafficName = ResUtil.getTrafficName(valueOf);
        if ((!mIsPreview && !TextUtils.isEmpty(mLane)) || !TextUtils.isEmpty(trafficName)) {
            findViewById.setVisibility(0);
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
            findViewById.setVisibility(8);
        }
        int viewWidth = RootUtil.getViewWidth(imageView);
        int viewWidth2 = RootUtil.getViewWidth(findViewById);
        float f = (viewWidth <= 0 || viewWidth2 <= 0 || viewWidth > viewWidth2) ? 0.2f : (viewWidth * 0.5f) / viewWidth2;
        int trafficEventTempId = 484 - getTrafficEventTempId(valueOf);
        MarkUtils.createMakerByView(this.mMapViewWrapper, linearLayout, trafficEventTempId, f, 0.5f, false, true, this.mIsMiniMap);
        return trafficEventTempId;
    }

    private int createGuideCameraMarkId(GuideCameraLayerItem guideCameraLayerItem) {
        if (guideCameraLayerItem == null) {
            return -1;
        }
        int mDirectionStyle = guideCameraLayerItem.getMDirectionStyle();
        int mCameraType = guideCameraLayerItem.getMCameraType();
        int mCameraSpeed = guideCameraLayerItem.getMCameraSpeed();
        int mDistance = guideCameraLayerItem.getMDistance();
        String id = guideCameraLayerItem.getID();
        if (L.ENABLE) {
            L.d(TAG, "createGuideCameraMarkId directionStyle:" + mDirectionStyle + ", cameraType:" + mCameraType + ", speed:" + mCameraSpeed + " , distance : " + mDistance + " , id = " + id);
        }
        int cameraBgResource = ResUtil.getCameraBgResource(mDirectionStyle, ThemeWatcherUtil.isDayMode());
        float cameraBgRatioX = MarkUtils.getCameraBgRatioX(mDirectionStyle);
        float cameraBgRatioY = MarkUtils.getCameraBgRatioY(mDirectionStyle);
        if (mCameraType < 0 || mCameraType > 10 || cameraBgResource == 0) {
            return -1;
        }
        View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_map_camera_info, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_map_camera_icon);
        inflate.setBackground(ThemeWatcherUtil.getDrawable(cameraBgResource));
        this.mCameraMarkId--;
        if (this.mCameraMarkId <= 299) {
            this.mCameraMarkId = 309;
        }
        int i = this.mCameraMarkId;
        if (this.mCameraMarkIds.contains(Integer.valueOf(i))) {
            this.mCameraMarkIds.remove(Integer.valueOf(i));
            this.mMapViewWrapper.cleanOverlayTexture(i, false);
        }
        this.mCameraMarkIds.add(Integer.valueOf(i));
        L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker: CAMERA markId = " + i, this.mEngineID));
        if (mCameraType != 0) {
            int cameraTypeResource = ResUtil.getCameraTypeResource(mCameraType);
            if (-1 != cameraTypeResource) {
                textView.setBackground(ThemeWatcherUtil.getDrawable(cameraTypeResource));
                MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
                return i;
            }
        } else if (mCameraSpeed > 0) {
            textView.setText(String.valueOf(mCameraSpeed));
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(R.style.font_digital_bold_land_30_port_28);
            } else {
                textView.setTextSize(ContextUtils.getDimensionPixelSize(R.dimen.guide_map_camera_text_size));
            }
            textView.setTextColor(ThemeWatcherUtil.getColor(R.color.vector_electroniceye_content_fill_color));
            textView.setPadding(0, ContextUtils.getDimensionPixelSize(R.dimen.guide_speed_camera_padding_top), 0, 0);
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            return i;
        } else if (mCameraSpeed == 0) {
            textView.setBackground(ThemeWatcherUtil.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_mid_speedmeasurement)));
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, cameraBgRatioX, cameraBgRatioY, false, true, this.mIsMiniMap);
            return i;
        }
        return -1;
    }

    private int createGuideIntervalCameraMarkId(GuideIntervalCameraLayerItem guideIntervalCameraLayerItem) {
        if (guideIntervalCameraLayerItem == null) {
            return -1;
        }
        int mCameraType = guideIntervalCameraLayerItem.getMCameraType();
        int mSpeed = guideIntervalCameraLayerItem.getMSpeed();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createGuideIntervalCameraMarkId type:" + mCameraType + ", speed:" + mSpeed);
        }
        if (mSpeed > 0) {
            View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_map_interval_camera_info, null);
            inflate.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.drawable_guide_navi_interval_camera_bg));
            TextView textView = (TextView) inflate.findViewById(R.id.tv_map_interval_camera_title);
            ((TextView) inflate.findViewById(R.id.tv_map_interval_camera_icon)).setText(String.valueOf(mSpeed));
            float f = ContextUtils.getFloat(R.dimen.dimen_map_style_internal_map_camera_ratio_x);
            float f2 = ContextUtils.getFloat(R.dimen.dimen_map_style_internal_map_camera_ratio_y);
            if (8 == mCameraType) {
                textView.setText(R.string.map_camera_info_interval_begin);
                MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, MarkUtils.MARKER_ID_INTERVAL_CAMERA_BEGIN, f, f2, false, true, this.mIsMiniMap);
                return MarkUtils.MARKER_ID_INTERVAL_CAMERA_BEGIN;
            } else if (9 == mCameraType) {
                textView.setText(R.string.map_camera_info_interval_end);
                MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, MarkUtils.MARKER_ID_INTERVAL_CAMERA_END, f, f2, false, true, this.mIsMiniMap);
                return MarkUtils.MARKER_ID_INTERVAL_CAMERA_END;
            } else {
                return -1;
            }
        }
        return -1;
    }

    private int createCruiseFacilityMarkId(CruiseFacilityLayerItem cruiseFacilityLayerItem) {
        int cruiseFacilityIconResId = ResUtil.getCruiseFacilityIconResId(cruiseFacilityLayerItem.getMType());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createCruiseFacilityMarkId addMarker type: " + cruiseFacilityLayerItem.getMType() + "  id: " + cruiseFacilityLayerItem.getID() + "    facilityResId:" + cruiseFacilityIconResId);
        }
        if (cruiseFacilityIconResId > 0) {
            View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_map_facilityinfo, null);
            ((ImageView) inflate.findViewById(R.id.facility_info_image)).setImageResource(cruiseFacilityIconResId);
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, 50, 0.5f, 0.9f, false, true, this.mIsMiniMap);
            return 50;
        }
        return -1;
    }

    private int createCruiseCameraMarkId(CruiseFacilityLayerItem cruiseFacilityLayerItem) {
        int mType = cruiseFacilityLayerItem.getMType();
        int mSpeed = cruiseFacilityLayerItem.getMSpeed();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("getExtraPointMarker: cameraType = " + mType + " speed = " + mSpeed, this.mEngineID));
        }
        View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_map_camera_info, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_map_camera_icon);
        inflate.setBackground(ThemeWatcherUtil.getDrawable(ResUtil.getCameraBgResource(1, ThemeWatcherUtil.isDayMode())));
        int i = this.mCruiseCameraMarkId;
        this.mCruiseCameraMarkId = i - 1;
        if (this.mCruiseCameraMarkId <= 50) {
            this.mCruiseCameraMarkId = 60;
        }
        if (4 != mType) {
            int cruiseCameraTypeResource = ResUtil.getCruiseCameraTypeResource(mType, false);
            if (cruiseCameraTypeResource == 0) {
                return -1;
            }
            textView.setBackground(ThemeWatcherUtil.getDrawable(cruiseCameraTypeResource));
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, 1.0f, 0.4f, false, true, this.mIsMiniMap);
        } else if (mSpeed > 0) {
            textView.setText(String.valueOf(mSpeed));
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(Utils.isLandscape() ? R.style.font_digital_bold_land_30_port_28 : R.style.font_digital_land_30_port_28);
            } else {
                textView.setTextSize(ContextUtils.getDimensionPixelSize(R.dimen.font_size_land_30_port_28));
            }
            textView.setTextColor(ThemeWatcherUtil.getColor(R.color.vector_electroniceye_content_fill_color));
            textView.setPadding(0, ContextUtils.getDimensionPixelSize(R.dimen.guide_speed_camera_padding_top), 0, 0);
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, 1.0f, 0.4f, false, true, this.mIsMiniMap);
        } else if (mSpeed != 0) {
            return -1;
        } else {
            textView.setBackground(ThemeWatcherUtil.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_mid_speedmeasurement)));
            MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, 1.0f, 0.4f, false, true, this.mIsMiniMap);
        }
        return i;
    }

    private int createCruiseTrafficEventMarkId(CruiseCongestionEventLayerItem cruiseCongestionEventLayerItem) {
        int indexOf;
        BizSocolEventInfo mSocolEventInfo = cruiseCongestionEventLayerItem.getMSocolEventInfo();
        if (mSocolEventInfo == null || mSocolEventInfo.mInfo == null) {
            return -1;
        }
        int i = mSocolEventInfo.mInfo.eventType;
        String cruiseTrafficEventName = ResUtil.getCruiseTrafficEventName(i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createCruiseTrafficEventMarkId addMarker eventType: " + i + "  id: " + cruiseCongestionEventLayerItem.getID() + "    label:" + cruiseTrafficEventName);
        }
        if (TextUtils.isEmpty(cruiseTrafficEventName)) {
            return -1;
        }
        View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_cruise_traffic_event, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        inflate.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_cruise_traffic_event_bg));
        textView.setText(cruiseTrafficEventName);
        textView.setTextColor(ThemeWatcherUtil.getColor(R.color.cruise_traffic_event_text_color));
        if (this.mEventCache.contains(cruiseTrafficEventName)) {
            indexOf = this.mEventCache.indexOf(cruiseTrafficEventName);
        } else {
            this.mEventCache.add(cruiseTrafficEventName);
            indexOf = this.mEventCache.indexOf(cruiseTrafficEventName);
        }
        int i2 = 469 - indexOf;
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i2, 1.0f, 0.45f, false, true, this.mIsMiniMap);
        return i2;
    }

    private int createMarkPointMarkId(String str, boolean z) {
        String[] split = str.split(MarkPointDecorator.TYPE_MID);
        if (split.length == 2 && TextUtils.isDigitsOnly(split[1]) && Integer.parseInt(split[1]) == 1) {
            return z ? 12 : 11;
        }
        return -1;
    }

    private int createSearchPoiParentPointMarkId(String str, boolean z) {
        int i;
        int drawableResId;
        int i2;
        int drawableResId2;
        int i3;
        XPPoiInfo xPPoiInfo;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        boolean z2 = true;
        boolean z3 = false;
        if (str.startsWith(RouteChargeDecorator.ROUTE_CHARGE_PRE)) {
            int[] createRouteChargeTexture = RouteChargeDecorator.createRouteChargeTexture(str);
            int i4 = z ? createRouteChargeTexture[1] : createRouteChargeTexture[0];
            if (L.ENABLE) {
                L.d(TAG, "ROUTE_CHARGE add overlay: " + str + ", markid: " + i4);
            }
            return i4;
        }
        boolean startsWith = str.startsWith(SearchDecorator.SEARCH_SINGLE_ID);
        XPPoiInfo xPPoiInfo2 = null;
        if (startsWith) {
            drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point_xp);
            i3 = 82;
            drawableResId2 = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point_xp_press);
            i2 = 83;
            xPPoiInfo = null;
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
                i = Integer.parseInt(str);
                MainContext mainContext = this.mMainContext;
                if (mainContext != null) {
                    IBaseScene currentScene = mainContext.getCurrentScene();
                    BaseMapDecorator currentSearchDecorator = this.mMainContext.getDecoratorManager().getCurrentSearchDecorator();
                    if (currentSearchDecorator instanceof SearchDecorator) {
                        int i5 = i - 1;
                        boolean isUnVisibleItem = ((SearchResultFragment) currentScene).isUnVisibleItem(i5);
                        xPPoiInfo2 = currentSearchDecorator.findPointByIndex(i5);
                        boolean z4 = xPPoiInfo2 != null && XPPoiCategory.isChargeWithOutAMapCharge(xPPoiInfo2.getCategory());
                        if (isUnVisibleItem) {
                            if (xPPoiInfo2 == null || !XPPoiCategory.isXPSelfCharge(xPPoiInfo2.getCategory())) {
                                z2 = false;
                            }
                            return z2 ? 402 : 403;
                        }
                        z3 = z4;
                    }
                }
            } else {
                i = 0;
            }
            drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point_xp);
            int i6 = 133 - i;
            i2 = 183 - i;
            drawableResId2 = ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point_xp_press);
            XPPoiInfo xPPoiInfo3 = xPPoiInfo2;
            i3 = i6;
            xPPoiInfo = xPPoiInfo3;
        }
        if (z) {
            if (z3) {
                createSearchChargeMarkerView(true, str, i2, xPPoiInfo, false);
            } else {
                createNormalFocusSearchMarkerView(drawableResId2, startsWith, str, i2);
            }
            return i2;
        } else if (z3) {
            createSearchChargeMarkerView(false, str, i3, xPPoiInfo, false);
            return i3;
        } else {
            createNormalSearchMarkerView(drawableResId, startsWith, str, i3);
            return i3;
        }
    }

    private int createLaneGuideTurnMarkId(LaneGuideTurnLayerItem laneGuideTurnLayerItem) {
        if (laneGuideTurnLayerItem == null) {
            return -1;
        }
        short mMainAction = laneGuideTurnLayerItem.getMMainAction();
        int mDirectionType = laneGuideTurnLayerItem.getMDirectionType();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createLaneGuideTurnMarkId directionType:" + mDirectionType + ", action:" + ((int) mMainAction));
        }
        int laneGuideTurnResId = ResUtil.getLaneGuideTurnResId(mMainAction);
        int laneGuideTurnLayout = ResUtil.getLaneGuideTurnLayout(mDirectionType);
        if (laneGuideTurnResId <= 0 || laneGuideTurnLayout <= 0) {
            return -1;
        }
        float laneGuideTurnRatioX = MarkUtils.getLaneGuideTurnRatioX(mDirectionType);
        float laneGuideTurnRatioY = MarkUtils.getLaneGuideTurnRatioY(mDirectionType);
        View inflate = View.inflate(ContextUtils.getContext(), laneGuideTurnLayout, null);
        ((ImageView) inflate.findViewById(R.id.iv_map_lane_turn_icon)).setBackground(ThemeWatcherUtil.getDrawable(laneGuideTurnResId));
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, 513, laneGuideTurnRatioX, laneGuideTurnRatioY, false, true, this.mIsMiniMap);
        return 513;
    }

    private int createLaneGuideCongestionMarkId(LaneGuideCongestionLayerItem laneGuideCongestionLayerItem) {
        if (laneGuideCongestionLayerItem == null) {
            return -1;
        }
        int mDirectionType = laneGuideCongestionLayerItem.getMDirectionType();
        String timeString = NaviUtil.getTimeString(laneGuideCongestionLayerItem.getMTotalTimeOfSeconds());
        String infoFlowDistanceRemain = NaviUtil.getInfoFlowDistanceRemain(laneGuideCongestionLayerItem.getMTotalRemainDist());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createLaneGuideCongestionMarkId directionStyle:" + mDirectionType + ", remainTime:" + timeString + ", remainDis:" + infoFlowDistanceRemain);
        }
        int laneCongestionLayout = ResUtil.getLaneCongestionLayout(mDirectionType);
        if (laneCongestionLayout <= 0) {
            return -1;
        }
        View inflate = View.inflate(ContextUtils.getContext(), laneCongestionLayout, null);
        ((TextView) inflate.findViewById(R.id.tv_lane_congestion_distance)).setText(infoFlowDistanceRemain);
        ((TextView) inflate.findViewById(R.id.tv_lane_congestion_time)).setText(timeString);
        float laneGuideCongestionRatioX = MarkUtils.getLaneGuideCongestionRatioX(mDirectionType);
        float laneGuideCongestionRatioY = MarkUtils.getLaneGuideCongestionRatioY(mDirectionType);
        int i = mDirectionType == 1 ? 516 : 517;
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, laneGuideCongestionRatioX, laneGuideCongestionRatioY, false, true, this.mIsMiniMap);
        return i;
    }

    private int createLaneGuideTrafficEventMarkId(LaneGuideTrafficEventLayerItem laneGuideTrafficEventLayerItem) {
        if (laneGuideTrafficEventLayerItem == null) {
            return -1;
        }
        int mDirectionType = laneGuideTrafficEventLayerItem.getMDirectionType();
        String valueOf = String.valueOf(laneGuideTrafficEventLayerItem.getMLayerTag());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "createLaneGuideTrafficEventMarkId directionType:" + mDirectionType + ", layerTag:" + valueOf);
        }
        float laneGuideTrafficEventRatioX = MarkUtils.getLaneGuideTrafficEventRatioX(mDirectionType);
        float laneGuideTrafficEventRatioY = MarkUtils.getLaneGuideTrafficEventRatioY(mDirectionType);
        int laneTrafficEventLayout = ResUtil.getLaneTrafficEventLayout(mDirectionType);
        int laneTrafficEventIconId = ResUtil.getLaneTrafficEventIconId(valueOf);
        if (laneTrafficEventLayout <= 0 || laneTrafficEventIconId <= 0) {
            return -1;
        }
        View inflate = View.inflate(ContextUtils.getContext(), laneTrafficEventLayout, null);
        ((ImageView) inflate.findViewById(R.id.iv_lane_traffic_event_icon)).setBackground(ThemeWatcherUtil.getDrawable(laneTrafficEventIconId));
        int i = mDirectionType == 1 ? 514 : 515;
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, laneGuideTrafficEventRatioX, laneGuideTrafficEventRatioY, false, true, this.mIsMiniMap);
        return i;
    }

    private int createLaneGuideIntervalCameraMarkId(LaneGuideCameraLayerItem laneGuideCameraLayerItem) {
        int laneIntervalCameraLayout;
        int i;
        if (laneGuideCameraLayerItem == null) {
            return -1;
        }
        int mDirectionType = laneGuideCameraLayerItem.getMDirectionType();
        int mCameraType = laneGuideCameraLayerItem.getMCameraType();
        int mCameraSpeed = laneGuideCameraLayerItem.getMCameraSpeed();
        if (L.ENABLE) {
            L.d(TAG, "createLaneGuideIntervalCameraMarkId directionStyle: " + mDirectionType + ", type:" + mCameraType + ", speed:" + mCameraSpeed);
        }
        if (mCameraSpeed <= 0 || (laneIntervalCameraLayout = ResUtil.getLaneIntervalCameraLayout(mDirectionType)) <= 0) {
            return -1;
        }
        View inflate = View.inflate(ContextUtils.getContext(), laneIntervalCameraLayout, null);
        int i2 = 511;
        if (1 == mDirectionType) {
            if (mCameraType == 8) {
                i = R.drawable.png_lane_bubble_container_interval_camera_start_left;
            } else {
                i = R.drawable.png_lane_bubble_container_interval_camera_end_left;
                i2 = 512;
            }
        } else if (mCameraType == 8) {
            i = R.drawable.png_lane_bubble_container_interval_camera_start_right;
        } else {
            i = R.drawable.png_lane_bubble_container_interval_camera_end_right;
            i2 = 512;
        }
        inflate.setBackground(ThemeWatcherUtil.getDrawable(i));
        ((TextView) inflate.findViewById(R.id.tv_map_interval_camera_title)).setText(String.valueOf(mCameraSpeed));
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i2, ContextUtils.getFloat(R.dimen.dimen_map_style_internal_map_camera_ratio_x), ContextUtils.getFloat(R.dimen.dimen_map_style_internal_map_camera_ratio_y), false, true, this.mIsMiniMap);
        return i2;
    }

    private int createLaneGuideCameraMarkId(LaneGuideCameraLayerItem laneGuideCameraLayerItem) {
        if (laneGuideCameraLayerItem == null) {
            return -1;
        }
        int mDirectionType = laneGuideCameraLayerItem.getMDirectionType();
        int mCameraType = laneGuideCameraLayerItem.getMCameraType();
        int mCameraSpeed = laneGuideCameraLayerItem.getMCameraSpeed();
        int mDistance = laneGuideCameraLayerItem.getMDistance();
        String id = laneGuideCameraLayerItem.getID();
        if (L.ENABLE) {
            L.d(TAG, "createLaneGuideCameraMarkId directionStyle:" + mDirectionType + ", cameraType:" + mCameraType + ", speed:" + mCameraSpeed + " , distance : " + mDistance + " , id = " + id);
        }
        float laneGuideCameraRatioX = MarkUtils.getLaneGuideCameraRatioX(mDirectionType);
        float laneGuideCameraRatioY = MarkUtils.getLaneGuideCameraRatioY(mDirectionType);
        int laneCameraLayout = ResUtil.getLaneCameraLayout(mDirectionType);
        if (laneCameraLayout <= 0) {
            return -1;
        }
        View inflate = View.inflate(ContextUtils.getContext(), laneCameraLayout, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_map_lane_camera_speed);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_map_lane_camera_dis);
        this.mLaneCameraMarkId--;
        if (this.mLaneCameraMarkId <= 500) {
            this.mLaneCameraMarkId = 510;
        }
        int i = this.mLaneCameraMarkId;
        if (this.mLaneCameraMarkIds.contains(Integer.valueOf(i))) {
            this.mLaneCameraMarkIds.remove(Integer.valueOf(i));
            this.mMapViewWrapper.cleanOverlayTexture(i, false);
        }
        this.mLaneCameraMarkIds.add(Integer.valueOf(i));
        L.i(TAG, L.formatWithEngine("getBizPointOverlayMarker: Lane CAMERA markId = " + i + " distance=" + mDistance, this.mEngineID));
        if (mCameraType != 0 || mCameraSpeed <= 0) {
            return -1;
        }
        textView.setText(String.valueOf(mCameraSpeed));
        textView2.setText(ContextUtils.getString(R.string.map_lane_camera_info_dis, Integer.valueOf(mDistance)));
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i, laneGuideCameraRatioX, laneGuideCameraRatioY, false, true, this.mIsMiniMap);
        return i;
    }

    private int createLaneRouteViaPointMarkId(LaneRoutePathPointItem laneRoutePathPointItem) {
        if (laneRoutePathPointItem == null) {
            return -1;
        }
        return getLaneRouteViaPointMarkId(Integer.valueOf(laneRoutePathPointItem.getID()).intValue());
    }

    private int getLaneRouteViaPointMarkId(int i) {
        XPViaPoint xPViaPoint;
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (viaInfos != null && i > -1 && i < viaInfos.size() && (xPViaPoint = viaInfos.get(i)) != null) {
            boolean isPassedVia = xPViaPoint.getIsPassedVia();
            int realViaIndex = CloudRouteDataHelper.getInstance().getRealViaIndex(i);
            viaInfos.get(i);
            L.i(TAG, L.formatWithEngine("getLaneRouteViaPointMarkId index: " + i + ", isPassedVia: " + isPassedVia + " realIndex: " + realViaIndex + ", size:" + viaInfos.size(), this.mEngineID));
            if (realViaIndex > -1 && realViaIndex < viaInfos.size()) {
                int drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_lane_bubble_location_mark_midd);
                if (1 == viaInfos.size()) {
                    drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_lane_bubble_location_mark_midd);
                } else if (realViaIndex == 0) {
                    drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_lane_bubble_location_mark_midd1);
                } else if (realViaIndex == 1) {
                    drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_lane_bubble_location_mark_midd2);
                } else if (realViaIndex == 2) {
                    drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.png_lane_bubble_location_mark_midd3);
                }
                int i2 = (((isPassedVia ? MarkUtils.MARKER_ID_LANE_PASSED_VIA : 529) + realViaIndex) + 1) - 12;
                MarkUtils.createMakerWithBg(this.mMapViewWrapper, drawableResId, i2, true, this.mIsMiniMap);
                return i2;
            }
        }
        return -1;
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

    private void createSearchChargeMarkerView(boolean z, String str, int i, XPPoiInfo xPPoiInfo, boolean z2) {
        if (this.mSearchChargeDecoratorVHolder == null) {
            this.mSearchChargeDecoratorVHolder = new SearchChargeDecoratorViewHolder();
        }
        this.mSearchChargeDecoratorVHolder.setData(ThemeWatcherUtil.isDayMode(), z, str, xPPoiInfo, z2);
        MarkUtils.createMakerByView(this.mMapViewWrapper, this.mSearchChargeDecoratorVHolder.getRootView(), i, 0.5f, 0.814f, false, true, this.mIsMiniMap);
    }

    private void createNormalSearchMarkerView(int i, boolean z, String str, int i2) {
        View inflate = View.inflate(ContextUtils.getContext(), R.layout.map_layout_search_point, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        inflate.setBackground(ContextUtils.getDrawable(i));
        if (z) {
            textView.setVisibility(8);
        } else {
            textView.setTextColor(ContextUtils.getColor(R.color.mark_normal_number_color));
            textView.setText(str);
        }
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i2, 0.5f, 0.814f, false, true, this.mIsMiniMap);
    }

    private void createNormalFocusSearchMarkerView(int i, boolean z, String str, int i2) {
        View inflate = View.inflate(ContextUtils.getContext(), R.layout.map_layout_search_point_focus, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        inflate.setBackground(ContextUtils.getDrawable(i));
        if (z) {
            textView.setVisibility(8);
        } else {
            textView.setTextColor(ContextUtils.getColor(R.color.search_decorator_charge_index_tx_color));
            textView.setText(str);
        }
        MarkUtils.createMakerByView(this.mMapViewWrapper, inflate, i2, 0.5f, 0.814f, false, true, this.mIsMiniMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class MultiAlternativePathLabelViewHolder {
        public XLinearLayout mLayout;
        public TextView mTvCost;
        public TextView mTvDistance;
        public ImageView mTvIndex;
        public TextView mTvTime;
        public TextView mTvTrafficLight;

        MultiAlternativePathLabelViewHolder() {
        }
    }
}
