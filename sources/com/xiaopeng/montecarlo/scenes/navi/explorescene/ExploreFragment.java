package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.model.PreviewParam;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.CloudRouteDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.NaviConfig;
import com.xiaopeng.montecarlo.navcore.xptbt.NaviTipsData;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfoPanel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.navi.CommonNaviVuiHelper;
import com.xiaopeng.montecarlo.scenes.navi.NaviPresenterData;
import com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.routescene.RouteVuiHelper;
import com.xiaopeng.montecarlo.stat.ExploreStatUtil;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.LaneInfoView;
import com.xiaopeng.montecarlo.views.RecommendRoutePop;
import com.xiaopeng.montecarlo.views.RestrictPopView;
import com.xiaopeng.montecarlo.views.RouteChargePanelView;
import com.xiaopeng.montecarlo.views.RouteDetailItemView;
import com.xiaopeng.montecarlo.views.RouteDetailPanel;
import com.xiaopeng.montecarlo.views.camera.CameraSimpleViewContainer;
import com.xiaopeng.montecarlo.views.camera.data.DataParseHelper;
import com.xiaopeng.montecarlo.views.dialog.XIKnowDialog;
import com.xiaopeng.montecarlo.views.dialog.XLandLoadingDialog;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ExploreFragment extends BaseMapScene implements IExploreContract.LogicView, RouteDetailItemView.OnItemClickListener, RestrictHelper.IRestrictView, RouteDetailPanel.IActionListener {
    public static final int REQUEST_CODE_ADD_WAYPOINT = 100;
    private static final L.Tag TAG = new L.Tag("ExploreFragment");
    private Unbinder mBind;
    private XLinearLayout mBtnAddWayPoint;
    private XRelativeLayout mBtnCancelRoute;
    XButton mBtnSimSpeedControl;
    XButton mBtnSimSpeedDown;
    XButton mBtnSimSpeedUp;
    private XRelativeLayout mBtnStartExplore;
    private XRelativeLayout mBtnStartNavi;
    @Nullable
    @BindView(R.id.view_camera_simple_stub)
    ViewStub mCameraSimpleViewStub;
    private int mChildNormalH;
    private int mChildNormalW;
    private int mChildSelectedH;
    private String mCurRoadName;
    @Nullable
    @BindView(R.id.tv_navi_info_turn_distance)
    XTextView mDistanceToTurn;
    @Nullable
    @BindView(R.id.tv_navi_info_turn_distance_unit)
    XTextView mDistanceToTurnUnit;
    CameraSimpleViewContainer mExploreCameraLayout;
    XLinearLayout mInternalCameras;
    @Nullable
    @BindView(R.id.interval_camera_container_stub)
    ViewStub mIntervalCameraViewStub;
    private boolean mIsNeedRestoreRestrictView;
    @Nullable
    @BindView(R.id.iv_end_shadow)
    XImageView mIvEndShadow;
    @Nullable
    @BindView(R.id.explore_lanes_layout)
    LaneInfoView mLanesLayout;
    private ExploreScenePresenter mPresenter;
    RecommendRoutePop mRecommendRoutePop;
    private RestrictHelper mRestrictHelper;
    @BindView(R.id.route_view_container)
    XLinearLayout mRoutDetailContainer;
    private RouteChargePanelView mRouteChargePanelView;
    @BindView(R.id.route_charge_panel_stub)
    ViewStub mRouteChargeStub;
    @BindView(R.id.route_panel)
    RouteDetailPanel mRoutePanel;
    private XLandLoadingDialog mRoutingDialog;
    XLinearLayout mSimulationLayout;
    @Nullable
    @BindView(R.id.iv_navi_info_turn)
    XImageView mTurnIcon;
    @Nullable
    @BindView(R.id.layout_turn_info)
    RelativeLayout mTurnInfoLayout;
    @BindView(R.id.explore_curroad_name)
    CurrentRoadNameView mTvCurrentRoad;
    @Nullable
    @BindView(R.id.tv_navi_info_turn_road_name)
    XTextView mTvRoadName;
    private XIKnowDialog mXIKnowDialog;
    private View mRootView = null;
    private View.OnAttachStateChangeListener mViewAttachListener = new View.OnAttachStateChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreFragment.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (view instanceof RouteDetailItemView) {
                ExploreFragment.this.onRouteDetailViewAttached((RouteDetailItemView) view);
            }
        }
    };

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public boolean isLeftPanelShow() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes
    public boolean isNeedMergeBaseMapViewForVui() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isShowFavorite() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onMotionEvent() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onMoveEvent() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onSRNaviHide() {
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowNaviIntervalCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpInfoTips(boolean z, int i, int i2, int i3) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpLcTips(boolean z, int i, int i2, int i3, int i4, boolean z2, boolean z3) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpLcTipsByDriveMode(int i, int i2, boolean z, int i3) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView, com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpLcTipsProgress(boolean z, long j, int i, boolean z2) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpOperateStatus(boolean z, int i, int i2, boolean z2) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpQuitTips(boolean z, int i, int i2, int i3) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateTakeOverWeakStatus(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void showCrossIcon(Bitmap bitmap, XPCrossImageInfo xPCrossImageInfo) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void unInitData() {
    }

    public static ExploreFragment newInstance() {
        return new ExploreFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRouteDetailViewAttached(RouteDetailItemView routeDetailItemView) {
        int index = routeDetailItemView.getIndex();
        String routeType = routeDetailItemView.getRouteType();
        long routeLeftDistance = routeDetailItemView.getRouteLeftDistance();
        long travelTime = routeDetailItemView.getTravelTime();
        long tollCost = routeDetailItemView.getTollCost();
        long lightCount = routeDetailItemView.getLightCount();
        if (index == 0) {
            ExploreStatUtil.sendStatDataWhenFirstCardShow(getMainContext(), routeType, routeLeftDistance, travelTime, tollCost, lightCount);
        } else if (index == 1) {
            ExploreStatUtil.sendStatDataWhenSecondCardShow(getMainContext(), routeType, routeLeftDistance, travelTime, tollCost, lightCount);
        } else if (index != 2) {
        } else {
            ExploreStatUtil.sendStatDataWhenThirdCardShow(getMainContext(), routeType, routeLeftDistance, travelTime, tollCost, lightCount);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(@Nullable Bundle bundle) {
        super.onSceneCreate(bundle);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildNormalH = getResources().getDimensionPixelSize(R.dimen.explore_route_item_height);
        this.mChildSelectedH = getResources().getDimensionPixelSize(R.dimen.explore_route_item_selected_height);
        this.mChildNormalW = getResources().getDimensionPixelSize(R.dimen.explore_route_item_width);
        this.mRootView = layoutInflater.inflate(R.layout.layout_explore, (ViewGroup) null);
        this.mBtnStartNavi = (XRelativeLayout) this.mRootView.findViewById(R.id.btn_start_navi);
        this.mBtnAddWayPoint = (XLinearLayout) this.mRootView.findViewById(R.id.btn_add_waypoint_container);
        this.mBtnStartExplore = (XRelativeLayout) this.mRootView.findViewById(R.id.btn_explore);
        this.mBtnCancelRoute = (XRelativeLayout) this.mRootView.findViewById(R.id.route_cancel_panel);
        this.mBind = ButterKnife.bind(this, this.mRootView);
        initView();
        return this.mRootView;
    }

    private void initView() {
        this.mRoutePanel.setExitButtonText(getText(R.string.expore_exit_text));
        this.mRoutePanel.showExploreButton(8);
        this.mRoutePanel.setRouteDetailPanelActionListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        boolean z;
        super.onSceneViewCreated(view, bundle);
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = bundle == null;
        Bundle bundle2 = getBridge().getBundle();
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        int currentNaviPathIndex = TBTManager.getInstance().getCurrentNaviPathIndex();
        RouteRequest routeRequest = null;
        int i = -1;
        if (bundle2 == null || !z4) {
            z = true;
        } else {
            routeRequest = (RouteRequest) bundle2.getParcelable(RouteBridge.ROUTE_REQUEST);
            boolean z5 = bundle2.getBoolean(NaviUtil.IS_NEED_START_NAVI_KEY, true);
            long j = bundle2.getLong(SystemConst.START_NAVI_ID, -1L);
            long currentNaviId2 = TBTManager.getInstance().getCurrentNaviId();
            if (currentNaviId2 != -1 && currentNaviId2 != j) {
                j = currentNaviId2;
            }
            currentNaviPathIndex = bundle2.getInt(SystemConst.START_NAVI_PATH_INDEX, 0);
            z2 = bundle2.getBoolean(SystemConst.IS_FROM_COMMUTING_TYPE_KEY, false);
            i = bundle2.getInt(SystemConst.ISOFFLINE_TYPE_KEY, -1);
            z = bundle2.getBoolean(NaviUtil.IS_NEED_TTSPROXY_SPEAK, true);
            z3 = z5;
            currentNaviId = j;
        }
        this.mPresenter.onViewCreated(new NaviPresenterData.Builder().setRouterRequest(routeRequest).setIsNeedStartNavi(z3).setNaviId(currentNaviId).setPathIndex(currentNaviPathIndex).setCommutingState(z2).setOfflineRemainCount(i).setIsFirstEnter(z4).setIsNeedTTSProxySpeak(z).setIsRequestRestrict(Utils.isLandscape()).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneNewBridge(BaseBridge baseBridge) {
        super.onSceneNewBridge(baseBridge);
        Bundle bundle = getBridge().getBundle();
        if (bundle != null) {
            RouteRequest routeRequest = (RouteRequest) bundle.getParcelable(RouteBridge.ROUTE_REQUEST);
            this.mPresenter.onNewBridge(new NaviPresenterData.Builder().setRouterRequest(routeRequest).setIsFilterCharge(bundle.getBoolean(MapRouteMsg.MAPROUTEMSG_IS_FILTER_CHARGE, true)).setRequestType(SystemConst.ROUTE_TYPE_FROM_PHONE.equals(bundle.getString(SystemConst.ROUTE_TYPE_KEY, "")) ? 4 : -1).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        this.mPresenter.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        super.onSceneDestroy();
        onHideRouting();
        this.mPresenter.updateNaviRemainInfo(false);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mPresenter.clearAlterLabelTableForVui(0);
        RouteDetailPanel routeDetailPanel = this.mRoutePanel;
        if (routeDetailPanel != null) {
            routeDetailPanel.release();
        }
        if (this.mRoutDetailContainer != null) {
            for (int i = 0; i < this.mRoutDetailContainer.getChildCount(); i++) {
                ((RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i)).release();
            }
            this.mRoutDetailContainer.removeAllViews();
        }
        RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
        if (routeChargePanelView != null) {
            routeChargePanelView.setListener(null);
        }
        this.mSimulationLayout = null;
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        if (recommendRoutePop != null) {
            recommendRoutePop.setListener(null);
            this.mRecommendRoutePop = null;
        }
        Unbinder unbinder = this.mBind;
        if (unbinder != null) {
            unbinder.unbind();
        }
        this.mPresenter.onDestroyView();
        XIKnowDialog xIKnowDialog = this.mXIKnowDialog;
        if (xIKnowDialog != null && xIKnowDialog.isShowing()) {
            this.mXIKnowDialog.dismiss();
        }
        onHideRecommendRoutePop();
        updateSRNaviSwitchStatus(8, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        this.mPresenter.onPause();
        onHideRouting();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void saveCurrentRequestingId(long j) {
        saveHoldLong("ExploreFragment_requestId", j);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public long getCurrentRequestingId() {
        return getHoldLong("ExploreFragment_requestId", -1L);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public ExploreScenePresenter mo116getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(ExploreScenePresenter exploreScenePresenter) {
        this.mPresenter = exploreScenePresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onUpdateViaPass(long j) {
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams != null) {
            getMapView().getBizControlManager().updateRouteOverlayElem(currentNaviRouteParams);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, NaviUtil.transformXPViaPointToXPPoiInfo(currentNaviRouteParams.mViaInfos));
            getMainContext().getDecoratorManager().showMapDecorator(this, DecoratorType.WAY_POINT, bundle);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void onUpdateNaviCamera(List<XPCameraInfo> list) {
        ViewStub viewStub;
        if (!isSceneResumed() || isTrafficEventPopShown()) {
            return;
        }
        if (this.mExploreCameraLayout == null && (viewStub = this.mCameraSimpleViewStub) != null) {
            this.mExploreCameraLayout = (CameraSimpleViewContainer) viewStub.inflate();
        }
        CameraSimpleViewContainer cameraSimpleViewContainer = this.mExploreCameraLayout;
        if (cameraSimpleViewContainer != null) {
            cameraSimpleViewContainer.notifyListChange(DataParseHelper.parseNavidataList(list));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list) {
        if (!isSceneLegal() || isTrafficEventPopShown()) {
            return;
        }
        if (CollectionUtils.isEmpty(list)) {
            clearInternalCameras();
        } else {
            updateInternalCameras(list);
        }
    }

    private void updateInternalCameras(List<XPCameraInfo> list) {
        if (this.mInternalCameras == null) {
            this.mInternalCameras = (XLinearLayout) this.mIntervalCameraViewStub.inflate();
        }
        if (CollectionUtils.isEmpty(list)) {
            this.mInternalCameras.setVisibility(8);
            return;
        }
        this.mInternalCameras.setVisibility(0);
        if (!Utils.isLandscape()) {
            this.mInternalCameras.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_panel_with_corner));
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nav_interval_camera_height);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            XPCameraInfo xPCameraInfo = list.get(i);
            if (xPCameraInfo != null) {
                View childAt = this.mInternalCameras.getChildAt(i);
                if (childAt == null) {
                    childAt = LayoutInflater.from(getActivity()).inflate(R.layout.layout_camera_info, (ViewGroup) null);
                    this.mInternalCameras.addView(childAt, -2, dimensionPixelSize);
                }
                childAt.setVisibility(0);
                XTextView xTextView = (XTextView) childAt.findViewById(R.id.tv_singleshow_icon);
                XTextView xTextView2 = (XTextView) childAt.findViewById(R.id.tv_suggest_speed);
                XTextView xTextView3 = (XTextView) childAt.findViewById(R.id.tv_suggest_speed_title);
                XTextView xTextView4 = (XTextView) childAt.findViewById(R.id.tv_average_speed);
                XTextView xTextView5 = (XTextView) childAt.findViewById(R.id.tv_average_speed_head);
                XTextView xTextView6 = (XTextView) childAt.findViewById(R.id.tv_left_distance);
                XTextView xTextView7 = (XTextView) childAt.findViewById(R.id.tv_left_distance_head);
                xTextView.setText(String.valueOf(xPCameraInfo.mSpeed[0]));
                if (xPCameraInfo.mSpeed[0] >= 100) {
                    xTextView.setTextSize(getResources().getDimensionPixelSize(R.dimen.guide_interval_camera_speed_text_size_small));
                } else {
                    xTextView.setTextSize(getResources().getDimensionPixelSize(R.dimen.guide_interval_camera_speed_text_size));
                }
                xTextView4.setText(String.valueOf(xPCameraInfo.mAverageSpeed));
                if (xPCameraInfo.mAverageSpeed > xPCameraInfo.mSpeed[0]) {
                    xTextView4.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_negative_red_normal));
                    xTextView5.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_negative_red_normal));
                } else {
                    xTextView4.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
                    xTextView5.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
                }
                if (xPCameraInfo.mReasonableSpeedInRemainDist > 0 && xPCameraInfo.mReasonableSpeedInRemainDist < xPCameraInfo.mSpeed[0] && xPCameraInfo.mAverageSpeed > xPCameraInfo.mSpeed[0]) {
                    xTextView2.setVisibility(0);
                    xTextView3.setVisibility(0);
                    xTextView2.setText(String.valueOf(xPCameraInfo.mReasonableSpeedInRemainDist));
                } else {
                    xTextView2.setVisibility(8);
                    xTextView3.setVisibility(8);
                }
                String[] distanceArray = NaviUtil.getDistanceArray(xPCameraInfo.mRemainDistance);
                xTextView6.setText(distanceArray[0]);
                xTextView7.setText(getResources().getString(R.string.singleshow_info_remain_mileage, distanceArray[1]));
                if (Utils.isLandscape()) {
                    xTextView3.setTextAppearance(R.style.font_bold_22);
                    xTextView5.setTextAppearance(R.style.font_bold_22);
                    xTextView7.setTextAppearance(R.style.font_bold_22);
                }
            }
        }
        while (size < this.mInternalCameras.getChildCount()) {
            this.mInternalCameras.getChildAt(size).setVisibility(8);
            size++;
        }
    }

    private void clearInternalCameras() {
        XLinearLayout xLinearLayout = this.mInternalCameras;
        if (xLinearLayout != null) {
            xLinearLayout.removeAllViews();
            this.mInternalCameras.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
        if (isAdded() && list != null && list.size() > 0) {
            updateInfo(list.get(0));
        }
    }

    private void updateInfo(XPNaviInfo xPNaviInfo) {
        View view = this.mRootView;
        if (view != null && view.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        updateMapCurrentRoadStatus(xPNaviInfo.mCurRouteName);
        if (Utils.isLandscape()) {
            return;
        }
        updateTurnInfo(xPNaviInfo);
    }

    private void updateTurnInfo(XPNaviInfo xPNaviInfo) {
        String str;
        if (xPNaviInfo == null || this.mDistanceToTurn == null || this.mDistanceToTurnUnit == null || this.mTurnInfoLayout == null || this.mTvRoadName == null || this.mIvEndShadow == null) {
            return;
        }
        NaviTipsData updateNaviTipsInfoForCloudRoute = CloudRouteDataHelper.getInstance().updateNaviTipsInfoForCloudRoute(xPNaviInfo);
        XPNaviInfoPanel[] xPNaviInfoPanelArr = xPNaviInfo.mNaviInfoData;
        if (xPNaviInfoPanelArr == null || xPNaviInfoPanelArr.length <= 0) {
            return;
        }
        this.mTurnInfoLayout.setVisibility(0);
        String[] distanceArray = NaviUtil.getDistanceArray(updateNaviTipsInfoForCloudRoute != null ? updateNaviTipsInfoForCloudRoute.getDistance() : xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist);
        String str2 = "";
        if (distanceArray == null || distanceArray.length < 2) {
            str = "";
        } else {
            str2 = distanceArray[0];
            str = distanceArray[1];
        }
        this.mDistanceToTurn.setText(str2);
        this.mDistanceToTurnUnit.setText(str);
        float measureText = str2 != null ? this.mDistanceToTurn.getPaint().measureText(str2) : 0.0f;
        float measureText2 = str != null ? this.mDistanceToTurnUnit.getPaint().measureText(str) : 0.0f;
        this.mIvEndShadow.setVisibility(8);
        String nextRouteName = updateNaviTipsInfoForCloudRoute != null ? updateNaviTipsInfoForCloudRoute.getNextRouteName() : xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag].mNextRouteName;
        if (TextUtils.isEmpty(nextRouteName)) {
            return;
        }
        int length = nextRouteName.length();
        int lineMaxNumber = getLineMaxNumber(nextRouteName, this.mTvRoadName.getPaint(), (int) ((ContextUtils.getDimensionPixelSize(R.dimen.explore_navi_info_exclude_fixed_width) - measureText) - measureText2));
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>get road name text number : " + lineMaxNumber + ", roadName : " + nextRouteName + ", distanceText : " + str2 + ", distanceUnitWidth : " + measureText2);
        }
        if (lineMaxNumber > 0 && lineMaxNumber <= length) {
            nextRouteName = nextRouteName.substring(0, lineMaxNumber);
        }
        if (length > nextRouteName.length()) {
            this.mIvEndShadow.setVisibility(0);
        }
        this.mTvRoadName.setText(nextRouteName);
    }

    private int getLineMaxNumber(String str, TextPaint textPaint, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return new StaticLayout(str, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onNaviStop(int i) {
        this.mPresenter.noticeVoiceOnNaviStop();
        goToMap();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onSelectRoute(int i) {
        this.mPresenter.onSelectRoute(i);
        this.mPresenter.switchActiveState();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void updateViewOnSelectRoute(int i) {
        XLinearLayout xLinearLayout;
        if (!isSceneLegal() || (xLinearLayout = this.mRoutDetailContainer) == null) {
            return;
        }
        int childCount = xLinearLayout.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 < childCount) {
                boolean z = i2 == i;
                RouteDetailItemView routeDetailItemView = (RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i2);
                routeDetailItemView.setSelected(z);
                if (Utils.isLandscape()) {
                    ((LinearLayout.LayoutParams) routeDetailItemView.getLayoutParams()).height = z ? this.mChildSelectedH : this.mChildNormalH;
                }
                i2++;
            } else {
                this.mPresenter.updateNaviRemainInfo(true);
                return;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void updateNaviInfo(List<XPNaviInfo> list, int i) {
        if (isSceneResumed() && this.mRoutDetailContainer != null) {
            updateRouteDetailView(i, list);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void showStartExploreMsg() {
        L.i(TAG, "showStartExploreMsg");
        if (isSceneLegal()) {
            showPrompt(R.string.explore_start);
        }
    }

    private void updateRouteDetailView(int i, List<XPNaviInfo> list) {
        RouteDetailItemView routeDetailItemView;
        XLinearLayout xLinearLayout = this.mRoutDetailContainer;
        if (xLinearLayout == null || (routeDetailItemView = (RouteDetailItemView) xLinearLayout.getChildAt(i)) == null) {
            return;
        }
        long pathId = routeDetailItemView.getPathId();
        XPNaviInfo naviInfo = this.mPresenter.getNaviInfo(list, pathId);
        IVariantPath variantPath = this.mPresenter.getVariantPath(pathId);
        if (naviInfo == null || variantPath == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onUpdateNaviInfo: detailview index=" + i + " ,remainDist=" + naviInfo.mRouteRemainDist + " ,remainLightCount=" + naviInfo.mRouteRemainLightCount);
        }
        if (routeDetailItemView != null) {
            updateRouteDetailView(routeDetailItemView, naviInfo, variantPath);
        }
    }

    private void updateRouteDetailView(@NonNull RouteDetailItemView routeDetailItemView, @NonNull XPNaviInfo xPNaviInfo, @NonNull IVariantPath iVariantPath) {
        routeDetailItemView.updatePanelInfo(xPNaviInfo.mPathID, xPNaviInfo.mRouteRemainDist, xPNaviInfo.mRouteRemainLightCount, xPNaviInfo.mRouteRemainTime, NaviUtil.getTollCost(xPNaviInfo.mCurSegIdx, xPNaviInfo.mCurLinkIdx, iVariantPath));
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowRouteFailMsg(int i) {
        if (i == 38) {
            showPrompt(getResources().getString(R.string.route_fail_reason_msg, NaviConfig.getInstance().getErrorString(822083619)));
        } else if (i < 822083584 || i > 822083618 || i - 822083584 >= NaviConfig.getInstance().getErrorMapSize() || i == 822083606 || i == 822083598) {
        } else {
            showPrompt(getResources().getString(R.string.route_fail_reason_msg, NaviConfig.getInstance().getErrorString(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowOfflineRouteMsg(int i, int i2) {
        if (i == 1) {
            XIKnowDialog xIKnowDialog = this.mXIKnowDialog;
            if (xIKnowDialog != null && xIKnowDialog.isShowing()) {
                this.mXIKnowDialog.dismiss();
            }
            this.mXIKnowDialog = new XIKnowDialog(getActivity(), getString(i2));
            this.mXIKnowDialog.show();
            if (isSceneVuiEnabled()) {
                CommonVuiHelper.getInstance().addDialogVuiSupport(this.mXIKnowDialog, "XIKnowDialog");
                return;
            }
            return;
        }
        showPrompt(getString(i2));
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onUpdatePreview(RectDouble rectDouble) {
        Rect exploreRouteOffsetRect;
        if (L.ENABLE) {
            L.d(TAG, "updatePreviewByBound");
        }
        if (rectDouble == null || !isSceneResumed()) {
            return;
        }
        new Rect();
        if (Utils.isLandscape()) {
            exploreRouteOffsetRect = NaviUtil.getExploreRouteOffsetRect(isLeftPanelShow());
            if (StateManager.getInstance().getState() == 1) {
                exploreRouteOffsetRect = NaviUtil.getExploreOffsetRectImmersio(isLeftPanelShow());
            }
        } else {
            exploreRouteOffsetRect = NaviUtil.getExploreRouteOffsetRect(false);
        }
        PreviewParam previewParam = new PreviewParam();
        previewParam.mapBound = rectDouble;
        previewParam.bUseRect = true;
        previewParam.screenLeft = exploreRouteOffsetRect.left;
        previewParam.screenTop = exploreRouteOffsetRect.top;
        previewParam.screenRight = exploreRouteOffsetRect.right;
        previewParam.screenBottom = exploreRouteOffsetRect.bottom;
        previewParam.bAdjustHeaderAngle = false;
        getMapView().showPreview(previewParam);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onUpdateSimulatePanel() {
        ExploreScenePresenter exploreScenePresenter = this.mPresenter;
        if (exploreScenePresenter != null) {
            int bLSimulationNaviSpeed = exploreScenePresenter.getBLSimulationNaviSpeed();
            if (bLSimulationNaviSpeed == 0) {
                this.mBtnSimSpeedControl.setText(R.string.button_sim_guide_go);
            } else {
                this.mBtnSimSpeedControl.setText(String.valueOf(bLSimulationNaviSpeed));
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowSimulatePanel() {
        if (this.mSimulationLayout == null) {
            this.mSimulationLayout = (XLinearLayout) ((ViewStub) this.mRootView.findViewById(R.id.simulation_button_layout_stub)).inflate();
            this.mBtnSimSpeedControl = (XButton) this.mSimulationLayout.findViewById(R.id.btn_sim_guide_control);
            this.mBtnSimSpeedDown = (XButton) this.mSimulationLayout.findViewById(R.id.btn_sim_speed_down);
            this.mBtnSimSpeedUp = (XButton) this.mSimulationLayout.findViewById(R.id.btn_sim_speed_up);
            this.mBtnSimSpeedControl.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ExploreFragment.this.getMainContext().getDecoratorManager().clearFocus(ExploreFragment.this);
                    if (ExploreFragment.this.mPresenter != null) {
                        ExploreFragment.this.mPresenter.switchSimulation();
                        ExploreFragment.this.onUpdateSimulatePanel();
                    }
                }
            });
            this.mBtnSimSpeedDown.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ExploreFragment.this.getMainContext().getDecoratorManager().clearFocus(ExploreFragment.this);
                    if (ExploreFragment.this.mPresenter != null) {
                        ExploreFragment.this.mPresenter.adjustSimulationsSpeed(false);
                    }
                }
            });
            this.mBtnSimSpeedUp.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ExploreFragment.this.getMainContext().getDecoratorManager().clearFocus(ExploreFragment.this);
                    if (ExploreFragment.this.mPresenter != null) {
                        ExploreFragment.this.mPresenter.adjustSimulationsSpeed(true);
                    }
                }
            });
        }
        this.mSimulationLayout.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onHideSimulatePanel() {
        XLinearLayout xLinearLayout = this.mSimulationLayout;
        if (xLinearLayout != null) {
            xLinearLayout.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowRoute(IPathResult iPathResult, int i) {
        if (iPathResult == null || !isSceneLegal()) {
            return;
        }
        getMainContext().addRoutePointsOverlay(this);
        showRouteContent(iPathResult, i);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        if (100 == i && bundle != null) {
            this.mPresenter.requestReroute((RouteRequest) bundle.getParcelable(RouteBridge.ROUTE_REQUEST), 0);
        }
        this.mRestrictHelper.onBackResult(i, bundle);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onStateActive() {
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mOverViewVisibility = 8;
        uIStatus.mZoomButtonVisibility = 8;
        uIStatus.mScaleVisibility = 0;
        uIStatus.mSettingVisibility = 0;
        uIStatus.mVolumeVisibility = 0;
        uIStatus.mMapRenderModeVisibility = 8;
        getMainContext().updateRecenterShowTag(true);
        updateUIStatus(uIStatus);
        this.mRoutePanel.showBottomPanel(0);
        updateRouteDetailLevelOnStateChange();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onStateImmersion() {
        hideSceneTrafficEventPop();
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mOverViewVisibility = 8;
        uIStatus.mZoomButtonVisibility = 8;
        uIStatus.mScaleVisibility = 0;
        uIStatus.mSettingVisibility = 8;
        uIStatus.mVolumeVisibility = 0;
        uIStatus.mMapRenderModeVisibility = 8;
        getMainContext().updateRecenterShowTag(false);
        updateUIStatus(uIStatus);
        this.mRoutePanel.showBottomPanel(8);
        updateRouteDetailLevelOnStateChange();
        hideRouteChargePanelView(true);
    }

    public void onClickCancelRoute(View view) {
        TBTManager.getInstance().stopNavi(true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void openFavourite() {
        L.i(TAG, "open search with over mode for favorite");
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.KEY_START_FROM, 1);
        bundle.putInt(SearchBridge.SEARCH_MODE, 102);
        bundle.putInt(SearchBridge.FROM_SCENE_INDEX, getSceneStackSize());
        bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, getChildStackSize());
        bundle.putInt(SearchBridge.ANIM_TYPE, 0);
        bundle.putInt(SearchBridge.SUB_CONTAINER_TYPE, 1);
        startScene(new SearchBridge().enableOverMode().setBundle(bundle), 100);
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.SEARCH_ENTER_WAYPOINT, new Object[0]);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void hideMapDecorators() {
        getMainContext().getDecoratorManager().clearFocus(this);
    }

    public void onClickAddWaypoint(View view) {
        L.i(TAG, "open search with over mode for add way point");
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_MODE, 102);
        bundle.putInt(SearchBridge.FROM_SCENE_INDEX, getSceneStackSize());
        bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, getChildStackSize());
        bundle.putInt(SearchBridge.ANIM_TYPE, 0);
        bundle.putInt(SearchBridge.ANIM_START_Y, view.getTop());
        bundle.putInt(SearchBridge.ANIM_START_H, view.getHeight());
        startScene(new SearchBridge().enableOverMode().setBundle(bundle), 100);
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.SEARCH_ENTER_WAYPOINT, new Object[0]);
    }

    @MainThread
    private void showRouteContent(IPathResult iPathResult, int i) {
        boolean z;
        IVariantPath iVariantPath;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        IVariantPath iVariantPath2;
        LinearLayout.LayoutParams layoutParams;
        int i6 = i;
        if (isSceneVuiEnabled()) {
            RouteVuiHelper.clearRouteList();
        }
        int pathCount = (int) iPathResult.getPathCount();
        boolean isDrawMultiRoute = this.mPresenter.isDrawMultiRoute();
        boolean z5 = true;
        boolean z6 = Utils.isLandscape() ? false : !isDrawMultiRoute || 1 == pathCount;
        int i7 = this.mChildNormalH;
        int i8 = this.mChildNormalW;
        boolean isBottomPanelVisible = this.mRoutePanel.isBottomPanelVisible();
        int childCount = this.mRoutDetailContainer.getChildCount();
        int i9 = 0;
        int i10 = 0;
        while (i10 < pathCount) {
            if (isDrawMultiRoute || i10 == i6) {
                IVariantPath path = iPathResult.getPath(i10);
                boolean z7 = i6 == i10 ? z5 : false;
                XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
                long j = (naviInfo == null || path == null || path.getPathId() != naviInfo.mPathID) ? 0L : (long) naviInfo.mRouteRemainDist;
                RouteDetailItemView routeDetailItemView = null;
                if (i9 < childCount) {
                    routeDetailItemView = (RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i9);
                    i9++;
                }
                int i11 = i9;
                int routeDetailLevel = getRouteDetailLevel(pathCount, isDrawMultiRoute, isBottomPanelVisible, i10);
                if (routeDetailItemView == null) {
                    z = z7;
                    iVariantPath = path;
                    z3 = isDrawMultiRoute;
                    i4 = i10;
                    z2 = isBottomPanelVisible;
                    i2 = childCount;
                    i3 = pathCount;
                    i5 = i8;
                    routeDetailItemView = new RouteDetailItemView(getActivity(), i10, routeDetailLevel, z6, 1, j, this);
                    z4 = true;
                } else {
                    z = z7;
                    iVariantPath = path;
                    z2 = isBottomPanelVisible;
                    i2 = childCount;
                    i3 = pathCount;
                    z3 = isDrawMultiRoute;
                    i4 = i10;
                    i5 = i8;
                    routeDetailItemView.updateViewState(z6);
                    routeDetailItemView.setIndex(i4);
                    if (routeDetailItemView.getLevel() != routeDetailLevel) {
                        routeDetailItemView.setLevel(routeDetailLevel);
                    }
                    routeDetailItemView.updateTheme(false);
                    z4 = false;
                }
                RouteResult.RouteInfo routeResultInfo = TBTManager.getInstance().getRouteResultInfo(TBTManager.getInstance().getCurrentNaviId(), iVariantPath.getPathId());
                if (routeResultInfo != null) {
                    XPNaviInfo naviInfo2 = TBTManager.getInstance().getNaviInfo(iVariantPath.getPathId());
                    if (naviInfo2 != null) {
                        iVariantPath2 = iVariantPath;
                        updateRouteDetailView(routeDetailItemView, naviInfo2, iVariantPath2);
                    } else {
                        iVariantPath2 = iVariantPath;
                        routeDetailItemView.updatePanelInfo(iVariantPath2.getPathId(), j == 0 ? routeResultInfo.mPathLength : j, routeResultInfo.mTrafficLightCount, routeResultInfo.mTravelTime, routeResultInfo.mTollCost);
                    }
                    routeDetailItemView.updateRouteTypeContent(i4, routeResultInfo.mContentName);
                } else {
                    iVariantPath2 = iVariantPath;
                }
                routeDetailItemView.setSelected(z);
                routeDetailItemView.addOnAttachStateChangeListener(this.mViewAttachListener);
                routeDetailItemView.setTag(iVariantPath2);
                if (z4) {
                    if (Utils.isLandscape()) {
                        layoutParams = new LinearLayout.LayoutParams(i5, z ? this.mChildSelectedH : this.mChildNormalH);
                    } else {
                        layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.weight = 1.0f;
                    }
                    routeDetailItemView.setLayoutParams(layoutParams);
                    this.mRoutDetailContainer.addView(routeDetailItemView);
                    i11++;
                } else {
                    if (Utils.isLandscape()) {
                        ((LinearLayout.LayoutParams) routeDetailItemView.getLayoutParams()).height = z ? this.mChildSelectedH : this.mChildNormalH;
                    }
                    if (routeDetailItemView.getVisibility() != 0) {
                        routeDetailItemView.setVisibility(0);
                        if (isSceneVuiEnabled() && isSceneLegal()) {
                            this.mPresenter.collectRouteDetailInfoForVui(routeDetailItemView.getRouteDetailInfo(), i3, this.mRoutDetailContainer, this.mRoutePanel, this.mVuiSceneId);
                        }
                        i9 = i11;
                    }
                }
                if (isSceneVuiEnabled()) {
                    this.mPresenter.collectRouteDetailInfoForVui(routeDetailItemView.getRouteDetailInfo(), i3, this.mRoutDetailContainer, this.mRoutePanel, this.mVuiSceneId);
                }
                i9 = i11;
            } else {
                z2 = isBottomPanelVisible;
                i2 = childCount;
                i3 = pathCount;
                z3 = isDrawMultiRoute;
                i4 = i10;
                i5 = i8;
            }
            i10 = i4 + 1;
            i6 = i;
            i8 = i5;
            isBottomPanelVisible = z2;
            isDrawMultiRoute = z3;
            childCount = i2;
            pathCount = i3;
            z5 = true;
        }
        int i12 = pathCount;
        L.i(TAG, "showRouteContent() " + this.mRoutDetailContainer.getChildCount() + ",viewIndex:" + i9 + ";pathCount:" + i12);
        for (int childCount2 = this.mRoutDetailContainer.getChildCount() - 1; childCount2 > i12 - 1; childCount2--) {
            this.mRoutDetailContainer.removeViewAt(childCount2);
        }
        if (Utils.isLandscape()) {
            showRouteDetail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:
        if (r8 != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0034, code lost:
        if (r8 != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return 6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getRouteDetailLevel(int r6, boolean r7, boolean r8, int r9) {
        /*
            r5 = this;
            boolean r0 = com.xiaopeng.montecarlo.util.Utils.isLandscape()
            r1 = 6
            r2 = 2
            r3 = 5
            r4 = 1
            if (r0 == 0) goto L21
            if (r4 == r6) goto L1c
            if (r7 != 0) goto Lf
            goto L1c
        Lf:
            if (r9 != 0) goto L13
        L11:
            r2 = r3
            goto L37
        L13:
            int r6 = r6 - r4
            if (r6 != r9) goto L37
            if (r8 == 0) goto L19
            goto L37
        L19:
            r6 = 7
        L1a:
            r2 = r6
            goto L37
        L1c:
            if (r8 == 0) goto L1f
            goto L11
        L1f:
            r2 = r1
            goto L37
        L21:
            if (r4 == r6) goto L34
            if (r7 != 0) goto L26
            goto L34
        L26:
            if (r9 != 0) goto L2b
            r2 = r8 ^ 1
            goto L37
        L2b:
            int r6 = r6 - r4
            if (r6 != r9) goto L37
            if (r8 == 0) goto L32
            r6 = 3
            goto L1a
        L32:
            r6 = 4
            goto L1a
        L34:
            if (r8 == 0) goto L1f
            goto L11
        L37:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreFragment.getRouteDetailLevel(int, boolean, boolean, int):int");
    }

    private void updateRouteDetailLevelOnStateChange() {
        int childCount = this.mRoutDetailContainer.getChildCount();
        boolean isDrawMultiRoute = this.mPresenter.isDrawMultiRoute();
        boolean isBottomPanelVisible = this.mRoutePanel.isBottomPanelVisible();
        int currentNaviPathIndex = TBTManager.getInstance().getCurrentNaviPathIndex();
        for (int i = 0; i < childCount; i++) {
            RouteDetailItemView routeDetailItemView = (RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i);
            if ((isDrawMultiRoute || i == currentNaviPathIndex) && routeDetailItemView != null) {
                routeDetailItemView.setLevel(getRouteDetailLevel(childCount, isDrawMultiRoute, isBottomPanelVisible, routeDetailItemView.getIndex()));
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteDetailItemView.OnItemClickListener
    public void onItemClick(int i, View view) {
        if (preventMultiClick(view)) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ExploreFragment.this.getMainContext().getDecoratorManager().clearFocus(ExploreFragment.this);
                }
            });
            onSelectRoute(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ExploreScenePresenter exploreScenePresenter = this.mPresenter;
        if (exploreScenePresenter != null) {
            exploreScenePresenter.updateLastUpdateTime();
            return false;
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onShowRecommendRoutePop(String str, int i, String str2, String str3, SpannableString spannableString, IVariantPath iVariantPath, int i2, boolean z) {
        if (this.mRecommendRoutePop == null) {
            this.mRecommendRoutePop = (RecommendRoutePop) ((ViewStub) this.mRootView.findViewById(R.id.explore_recommend_route_pop_stub)).inflate();
        }
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        if (recommendRoutePop != null) {
            recommendRoutePop.setListener(mo116getPresenter().getRecommendRouteSwitchListener());
            this.mRecommendRoutePop.updateInfo(str, i, str2, "", spannableString, iVariantPath, i2, false);
            this.mRecommendRoutePop.show();
            L.i(TAG, "RECOMMEND_ROUTE RecommendRoutePop shown");
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onHideRecommendRoutePop() {
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        if (recommendRoutePop != null && recommendRoutePop.getVisibility() == 0) {
            this.mRecommendRoutePop.hide();
        }
        this.mPresenter.closeAiAssistant();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onRecommendRoutePopTick(long j) {
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        if (recommendRoutePop == null || recommendRoutePop.getVisibility() != 0) {
            return;
        }
        this.mRecommendRoutePop.setTimeOutText(j);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiShow(PoiCardView poiCardView) {
        XPViaPoint xPViaPoint;
        super.onPoiShow(poiCardView);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "POP=> poiPop.getDecoratorType() = " + poiCardView.getDecoratorType());
        }
        hideRestrictedPopOnOtherElementShow();
        if (poiCardView.getDecoratorType() == DecoratorType.WAY_POINT) {
            int currentExpandedIndex = poiCardView.getMapDecorator().getCurrentExpandedIndex();
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
            if (currentExpandedIndex > -1 && currentExpandedIndex < viaInfos.size() && (xPViaPoint = viaInfos.get(currentExpandedIndex)) != null && xPViaPoint.getViaType() == 4) {
                onShowChargeViaDetail(xPViaPoint, currentExpandedIndex);
                return;
            }
        }
        if (Utils.isLandscape()) {
            hideRouteDetail();
        }
        hideRouteChargePanelView(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene
    public boolean isPoiCardShowing() {
        RouteChargePanelView routeChargePanelView;
        return super.isPoiCardShowing() || ((routeChargePanelView = this.mRouteChargePanelView) != null && routeChargePanelView.getVisibility() == 0);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiHide(PoiCardView poiCardView) {
        super.onPoiHide(poiCardView);
        if (isSceneLegal()) {
            if (Utils.isLandscape()) {
                showRouteDetail();
            }
            restoreRestrictedPopOnOtherElementHide();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void showRestrictedPop(int i, String str, String str2, ArrayList<XPGRestrictCity> arrayList, String str3, RestrictPopView.IRestrictPopActionListener iRestrictPopActionListener) {
        if (isPoiCardShowing() && Utils.isLandscape()) {
            this.mRestrictHelper.setRestrictInfoForUncomingPop(i, str, str2, arrayList, str3, iRestrictPopActionListener, false);
            this.mIsNeedRestoreRestrictView = true;
            return;
        }
        this.mIsNeedRestoreRestrictView = false;
        this.mRestrictHelper.showRestrictedPop(i, str, str2, arrayList, str3, iRestrictPopActionListener, false);
    }

    private void restoreRestrictedPopOnOtherElementHide() {
        if (this.mIsNeedRestoreRestrictView) {
            this.mRestrictHelper.restoreShowRestrictPop();
            this.mIsNeedRestoreRestrictView = false;
        }
    }

    private void hideRestrictedPopOnOtherElementShow() {
        RestrictHelper restrictHelper;
        if (Utils.isLandscape() && (restrictHelper = this.mRestrictHelper) != null && restrictHelper.isRestrictedPopShow()) {
            this.mRestrictHelper.hideRestrictedPop(true);
            this.mIsNeedRestoreRestrictView = true;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public RelativeLayout.LayoutParams getPopPos() {
        if (Utils.isLandscape()) {
            RelativeLayout.LayoutParams popLayoutParams = this.mRestrictHelper.getPopLayoutParams();
            if (popLayoutParams != null) {
                popLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.scene_margin);
                popLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.route_restrict_margin_left);
            }
            return popLayoutParams;
        }
        RelativeLayout.LayoutParams defaultPopPos = this.mRestrictHelper.getDefaultPopPos();
        if (defaultPopPos != null) {
            defaultPopPos.addRule(3, R.id.route_panel);
            defaultPopPos.topMargin = getResources().getDimensionPixelSize(R.dimen.explore_restrict_margin_top);
            defaultPopPos.leftMargin = getResources().getDimensionPixelSize(R.dimen.explore_restrict_margin_left);
            defaultPopPos.rightMargin = getResources().getDimensionPixelSize(R.dimen.explore_restrict_margin_right);
        }
        return defaultPopPos;
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void hideRestrictedPop() {
        this.mRestrictHelper.hideRestrictedPop();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public BaseScene getSceneForRestrict() {
        return getScene();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void requestRestrictReroute() {
        this.mPresenter.requestReroute(9, 1, true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void onRestrictViewVisibilityChanged(int i) {
        RelativeLayout relativeLayout;
        int dimensionPixelSize;
        L.i(TAG, " onRestrictPopViewShow");
        if (!Utils.isPortrait() || (relativeLayout = this.mTurnInfoLayout) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (i == 0) {
            dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.explore_restrict_height);
        } else {
            dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.explore_navi_info_height);
        }
        layoutParams.height = dimensionPixelSize;
        this.mTurnInfoLayout.setLayoutParams(layoutParams);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public RestrictHelper getRestrictHelper() {
        return this.mRestrictHelper;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void removeChildScene() {
        removeAllChildScene();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.NAVI_DETECT_ROUTE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        renderLayoutByDayNightStatus();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void renderLayoutByDayNightStatus() {
        if (isSceneLegal()) {
            updateManeuverInfoWhenThemeSwitch();
            this.mPresenter.updateCameraViews();
            this.mPresenter.updateNaviLaneViews();
        }
    }

    private void updateManeuverInfoWhenThemeSwitch() {
        ExploreScenePresenter exploreScenePresenter = this.mPresenter;
        if (exploreScenePresenter != null) {
            exploreScenePresenter.updateManeuverInfoWhenThemeSwitch();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowRouting(boolean z) {
        FragmentActivity activity;
        L.i(TAG, ">>> showRouting isOffline=" + z);
        if (!isSceneLegal() || (activity = getActivity()) == null || activity.isDestroyed()) {
            return;
        }
        if (this.mRoutingDialog == null) {
            this.mRoutingDialog = new XLandLoadingDialog(activity);
            this.mRoutingDialog.setCancelable(false);
        }
        boolean isNetworkConnected = XPNetworkManager.INSTANCE.isNetworkConnected();
        if (!z) {
            z = !isNetworkConnected;
        }
        this.mRoutingDialog.setMessage(getString(z ? R.string.route_offline_routing : R.string.route_routing));
        this.mRoutingDialog.show();
        this.mRoutingDialog.correctedLocation();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onHideRouting() {
        L.i(TAG, ">>> hideRouting");
        XLandLoadingDialog xLandLoadingDialog = this.mRoutingDialog;
        if (xLandLoadingDialog != null) {
            xLandLoadingDialog.dismiss();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void onShowNaviLaneInfo(XPLaneInfo xPLaneInfo) {
        LaneInfoView laneInfoView;
        if (!isSceneResumed() || Utils.isLandscape() || (laneInfoView = this.mLanesLayout) == null) {
            return;
        }
        laneInfoView.updateLaneData(xPLaneInfo);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void onHideNaviLaneInfo() {
        if (isSceneResumed()) {
            hideLaneView();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void onUpdateTollGateInfo(XPTollGateInfo xPTollGateInfo) {
        if (isSceneResumed()) {
            this.mPresenter.handleTollGateInfo(xPTollGateInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void showCruiseTollGateInfo(List<Integer> list) {
        LaneInfoView laneInfoView;
        if (!isSceneLegal() || Utils.isLandscape() || (laneInfoView = this.mLanesLayout) == null) {
            return;
        }
        laneInfoView.updateTollGateData(list);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void hideCruiseTollGateInfo() {
        hideLaneView();
    }

    private void hideLaneView() {
        LaneInfoView laneInfoView;
        if (isSceneResumed() && (laneInfoView = this.mLanesLayout) != null) {
            laneInfoView.setVisibility(4);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void initRestrictHelper() {
        this.mRestrictHelper = new RestrictHelper(getActivity(), this);
        this.mRestrictHelper.init();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void showNavTrafficEventPop(TrafficEventPopParam trafficEventPopParam) {
        BaseScene currentScene = getCurrentScene();
        if (!(currentScene instanceof BaseMapScene) || Utils.isRestrictScene(currentScene)) {
            return;
        }
        ((BaseMapScene) currentScene).showSceneTrafficEventPop(trafficEventPopParam);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView, com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>  onShowNaviManeuver maneuverInfo = " + xPManeuverInfo + " obtainInfo=" + xPObtainInfo);
        }
        if (!isSceneResumed() || Utils.isLandscape()) {
            return;
        }
        if (xPObtainInfo == null) {
            updateTurnIcon(xPManeuverInfo);
        } else {
            this.mPresenter.asyncToGetTurnIcon(xPObtainInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView, com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onAsyncManeuverInfo(XPManeuverInfo xPManeuverInfo) {
        if (xPManeuverInfo != null) {
            this.mPresenter.asyncManeuverInfo(xPManeuverInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public boolean isMapPoiLocked() {
        MainContext mainContext = getMainContext();
        if (mainContext == null) {
            return true;
        }
        return mainContext.isMapPoiLocked();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.LogicView
    public void onMainPathChanged() {
        L.i(TAG, "onMainPathChanged");
        hideSceneTrafficEventPop();
        this.mMainContext.getDecoratorManager().clearFocus(this.mMainContext.getCurrentScene());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void showTurnIcon(Bitmap bitmap) {
        XImageView xImageView;
        if (!isSceneLegal() || Utils.isLandscape()) {
            return;
        }
        if (bitmap != null && (xImageView = this.mTurnIcon) != null) {
            xImageView.setImageBitmap(bitmap);
        } else {
            showXPTurnIcon();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteDetailPanel.IActionListener
    public void onActionPerformed(View view, int i) {
        if (i == 1) {
            onClickAddWaypoint(view);
        } else if (i != 2) {
            if (i != 4) {
                return;
            }
            onClickCancelRoute(view);
        } else {
            this.mPresenter.setClickStartNaviState(true);
            this.mPresenter.startGuidance();
            ExploreStatUtil.sendStatDataWhenStartNavi(getMainContext());
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteDetailPanel.IActionListener
    public void onInflateFinished(RouteDetailPanel routeDetailPanel) {
        VoiceFullScenesUtil.updateScene(this, routeDetailPanel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onMapRecenterUpdate() {
        if (isSceneLegal() && !TextUtils.isEmpty(this.mCurRoadName)) {
            if (this.mPresenter.needShowRoadName()) {
                updateMapCurrentRoadStatus(this.mCurRoadName);
            } else {
                this.mTvCurrentRoad.setVisibility(8);
            }
        }
    }

    @MainThread
    private void updateTurnIcon(XPManeuverInfo xPManeuverInfo) {
        if (xPManeuverInfo == null || this.mTurnIcon == null) {
            return;
        }
        int maneuverResource = ResUtil.getManeuverResource(xPManeuverInfo);
        Drawable drawable = null;
        if (maneuverResource != 0) {
            drawable = ContextUtils.getDrawable(maneuverResource);
        } else if (L.ENABLE) {
            L.d(TAG, ">>>  have not find the resource id of turn maneuver!");
        }
        this.mTurnIcon.setImageDrawable(drawable);
    }

    public void showXPTurnIcon() {
        if (L.ENABLE) {
            L.d(TAG, ">>>  onObtainAsyncInfo decode fail,use the maneuerId");
        }
        updateTurnIcon(this.mPresenter.getNaviManeuerInfo());
    }

    private void updateMapCurrentRoadStatus(String str) {
        if (TextUtils.isEmpty(str) || !this.mPresenter.needShowRoadName()) {
            this.mTvCurrentRoad.setVisibility(8);
        } else {
            this.mTvCurrentRoad.setVisibility(0);
            this.mTvCurrentRoad.setText(str);
        }
        this.mCurRoadName = str;
    }

    private void hideRouteDetail() {
        if (isSceneLegal() && this.mRoutePanel.getVisibility() == 0) {
            this.mRoutePanel.setVisibility(8);
        }
    }

    private void showRouteDetail() {
        if (!isSceneLegal() || isPoiCardShowing() || isTrafficEventPopShown() || this.mRoutePanel.getVisibility() == 0) {
            return;
        }
        this.mRoutePanel.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopShow(View view, double d, double d2) {
        super.onTrafficEventPopShow(view, d, d2);
        if (Utils.isLandscape()) {
            hideRouteDetail();
            clearInternalCameras();
            CameraSimpleViewContainer cameraSimpleViewContainer = this.mExploreCameraLayout;
            if (cameraSimpleViewContainer != null) {
                cameraSimpleViewContainer.notifyListChange(null);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopHide(View view) {
        super.onTrafficEventPopHide(view);
        if (Utils.isLandscape()) {
            showRouteDetail();
            this.mPresenter.updateCameraViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public RectInt getCurrentFreeBound() {
        if (Utils.isPortrait()) {
            this.mFreeBound.top = this.mRoutePanel.getBottom() + ContextUtils.getDimensionPixelSize(R.dimen.guide_panel_bottom_gap);
        }
        return this.mFreeBound;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene
    protected void setTrafficEventLayerState() {
        getMapView().setTrafficEventLayerState(2);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateRemainDis(long j, int i, int i2) {
        if (isSceneResumed() && this.mRoutDetailContainer != null) {
            for (int i3 = 0; i3 < this.mRoutDetailContainer.getChildCount(); i3++) {
                RouteDetailItemView routeDetailItemView = (RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i3);
                if (routeDetailItemView != null && routeDetailItemView.getPathId() == j) {
                    routeDetailItemView.onUpdateRemainDis(j, i, i2);
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, "onUpdateRemainDis-   pathId:" + j + "  routeRemainDis:" + i + "  remainDis:" + i2);
                    }
                }
            }
            this.mPresenter.updateNaviRemainInfo(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public boolean isRecommendComparing() {
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        return recommendRoutePop != null && recommendRoutePop.getVisibility() == 0;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowChargeViaDetail(XPViaPoint xPViaPoint, int i) {
        if (!isSceneLegal() || xPViaPoint == null || xPViaPoint.getPoiPoint() == null || getRouteChargePanelView() == null) {
            return;
        }
        if (Utils.isLandscape()) {
            hideRouteDetail();
        }
        XPPoiInfo poiPoint = xPViaPoint.getPoiPoint();
        this.mRouteChargePanelView.setVisibility(0);
        this.mRouteChargePanelView.bringToFront();
        this.mRouteChargePanelView.showDetail(poiPoint.getPoiId(), poiPoint.getName(), poiPoint.getDisplayLat(), poiPoint.getDisplayLon(), i, xPViaPoint.getIsPassedVia());
        if (Utils.isPortrait()) {
            ((RelativeLayout.LayoutParams) this.mRouteChargePanelView.getLayoutParams()).topMargin = getCurrentFreeBound().top;
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onClickBlank(long j, float f, float f2) {
        super.onClickBlank(j, f, f2);
        hideRouteChargePanelView(true);
        clearOverlayElemAllFocus();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void hideRouteChargePanelView(boolean z) {
        RouteChargePanelView routeChargePanelView;
        if (!isSceneResumed() || (routeChargePanelView = this.mRouteChargePanelView) == null || routeChargePanelView.getVisibility() == 8) {
            return;
        }
        this.mRouteChargePanelView.setVisibility(8);
        if (Utils.isLandscape()) {
            if (z) {
                showRouteDetail();
            } else {
                hideRouteDetail();
            }
        }
    }

    private RouteChargePanelView getRouteChargePanelView() {
        if (this.mRouteChargePanelView == null && this.mRouteChargeStub.getParent() != null) {
            try {
                this.mRouteChargeStub.inflate();
                this.mRouteChargePanelView = (RouteChargePanelView) this.mRootView.findViewById(R.id.route_charge_panel);
                this.mRouteChargePanelView.setChargeBarVisible(false);
                this.mRouteChargePanelView.setListener(this.mPresenter);
            } catch (IllegalArgumentException | IllegalStateException unused) {
                L.e(TAG, "inflate route charge panel view err");
            }
        }
        return this.mRouteChargePanelView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void openSearchNormal() {
        onClickAddWaypoint(this.mBtnAddWayPoint);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onSRNaviShow() {
        this.mPresenter.startGuidance(false, false, true);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiEnabled() {
        return CommonVuiHelper.getInstance().isSceneVuiSupport();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onInterceptVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",scene:" + this));
        }
        VuiElement onInterceptFindTargetVuiElement = CommonNaviVuiHelper.onInterceptFindTargetVuiElement(view, vuiEvent, this, R.id.vui_element_id_route_detail_item);
        if (onInterceptFindTargetVuiElement != null) {
            CommonNaviVuiHelper.handleSelectRouteVuiAction(view, onInterceptFindTargetVuiElement, mo116getPresenter());
            return true;
        }
        return super.onInterceptVuiEvent(view, vuiEvent);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onVuiEvent(View view, VuiEvent vuiEvent) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",scene:" + this));
        }
        if (CommonNaviVuiHelper.onVuiEventHandleRouteAlterLabel(view, vuiEvent, mo116getPresenter(), this)) {
            return;
        }
        super.onVuiEvent(view, vuiEvent);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onBuildScene() {
        dynamicSetVuiLabel();
        dynamicEnableSpeechControl();
        super.onBuildScene();
    }

    private void dynamicSetVuiLabel() {
        L.Tag tag = TAG;
        L.i(tag, "dynamicSetVuiLabel mBtnCancelRoute:" + this.mBtnCancelRoute);
        XRelativeLayout xRelativeLayout = this.mBtnCancelRoute;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVuiLabel(ContextUtils.getString(R.string.vui_label_route_exit_explore));
        }
    }

    private void dynamicEnableSpeechControl() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        MainContext mainContext = getMainContext();
        XRelativeLayout xRelativeLayout = this.mBtnStartNavi;
        commonVuiHelper.enableCanSpeechControl(mainContext, xRelativeLayout, xRelativeLayout, false);
        CommonVuiHelper commonVuiHelper2 = CommonVuiHelper.getInstance();
        MainContext mainContext2 = getMainContext();
        XLinearLayout xLinearLayout = this.mBtnAddWayPoint;
        commonVuiHelper2.enableCanSpeechControl(mainContext2, xLinearLayout, xLinearLayout, false);
        CommonVuiHelper commonVuiHelper3 = CommonVuiHelper.getInstance();
        MainContext mainContext3 = getMainContext();
        XRelativeLayout xRelativeLayout2 = this.mBtnCancelRoute;
        commonVuiHelper3.enableCanSpeechControl(mainContext3, xRelativeLayout2, xRelativeLayout2, false);
    }
}
