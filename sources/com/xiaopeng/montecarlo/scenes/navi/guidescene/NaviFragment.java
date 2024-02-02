package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.model.PreviewParam;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.anim.AnimBuilder;
import com.xiaopeng.montecarlo.anim.SceneAnimHelper;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener;
import com.xiaopeng.montecarlo.navcore.event.ParallelRoadEvent;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.navcore.powerdistance.PowerDistanceManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.CloudRouteDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.NaviTipsData;
import com.xiaopeng.montecarlo.navcore.xptbt.RecommendParkingHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfoPanel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.navi.CommonNaviVuiHelper;
import com.xiaopeng.montecarlo.scenes.navi.NaviPresenterData;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.sapa.SapaData;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingPreferencePresenter;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.montecarlo.util.SRUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.util.uirelationship.IUIRelationshipHelper;
import com.xiaopeng.montecarlo.util.uirelationship.UIAction;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipHelper;
import com.xiaopeng.montecarlo.views.ImageTextView;
import com.xiaopeng.montecarlo.views.LaneInfoView;
import com.xiaopeng.montecarlo.views.MixedTextView;
import com.xiaopeng.montecarlo.views.OfflinePopView;
import com.xiaopeng.montecarlo.views.RecommendParkView;
import com.xiaopeng.montecarlo.views.RecommendRoutePop;
import com.xiaopeng.montecarlo.views.RestrictPopView;
import com.xiaopeng.montecarlo.views.RouteChargePanelView;
import com.xiaopeng.montecarlo.views.SapaContainerView;
import com.xiaopeng.montecarlo.views.SapaTollView;
import com.xiaopeng.montecarlo.views.TrafficBar;
import com.xiaopeng.montecarlo.views.XpNgpPanelView;
import com.xiaopeng.montecarlo.views.dialog.XIKnowDialog;
import com.xiaopeng.montecarlo.views.dialog.XLandLoadingDialog;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XFrameLayout;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRadioGroup;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes2.dex */
public class NaviFragment extends BaseMapScene implements INaviContract.LogicView, ISceneMapFragmentListener, RestrictHelper.IRestrictView, RecommendParkView.RecommendParkViewListener, View.OnClickListener {
    private static final int AI_COMPLETE = 11014;
    private static final String KEY_OUTSTATE_HAS_MOTION_EVENT = "key_outstate_has_motion_event";
    public static final int REQUEST_CODE_ADD_WAYPOINT = 100;
    private static final L.Tag TAG = new L.Tag("NaviFragment");
    @BindView(R.id.srnavi_acc_view_text)
    XTextView mAccSpeedViewText;
    private Unbinder mBind;
    @BindView(R.id.btn_guide_add_waypoint)
    XLinearLayout mBtnAddWaypoint;
    @BindView(R.id.btn_guide_add_waypoint_icon)
    XImageView mBtnAddWaypointIcon;
    @BindView(R.id.btn_guide_add_waypoint_text)
    XTextView mBtnAddWaypointTips;
    XButton mBtnSimSpeedControl;
    XButton mBtnSimSpeedDown;
    XButton mBtnSimSpeedUp;
    XTextView mCrossDistanceToTurn;
    XTextView mCrossDistanceToTurnUnit;
    @BindView(R.id.guide_cross_layout)
    ViewGroup mCrossLayout;
    XTextView mCrossNextTurnName;
    XImageView mCrossTurnIcon;
    XTextView mDistanceToNextTurn;
    XTextView mDistanceToNextTurnSpe;
    XTextView mDistanceToTurn;
    XTextView mDistanceToTurnUnit;
    @BindView(R.id.navi_info_eagle_bg_mask)
    XImageView mEagleBgMask;
    XImageView mExitInfoEndShadow;
    View mExitInfoLayout;
    @BindView(R.id.guide_3d_to_2d)
    XFrameLayout mGuideBackTo2D;
    XRelativeLayout mGuideContainer;
    ImageTextView mGuideExitNavi;
    @BindView(R.id.im_guide_cross_cross)
    XImageView mImCross;
    private boolean mIsParallelRoadShow;
    private boolean mIsStateActive;
    private LaneInfoView mLanesLayout;
    LinearLayout mLeftGuidePanel;
    @BindView(R.id.srnavi_limit_speed_view_text)
    XTextView mLimitSpeedViewText;
    private XPNaviInfo mNaviInfo;
    private List<XPCameraInfo> mNaviIntervalCameraDynamicInfoList;
    XRelativeLayout mNaviPanal;
    @BindView(R.id.navi_traffic_bar_container)
    XRelativeLayout mNaviTrafficbarContainer;
    String[] mNextTurnDistance;
    XImageView mNextTurnIcon;
    XImageView mNextTurnIconSpe;
    XTextView mNextTurnName;
    private CharSequence[] mNgpInfoTips;
    private CharSequence[] mNgpLcTips;
    private String mNgpLccText;
    private CharSequence[] mNgpOperates;
    private CharSequence[] mNgpQuitTips;
    OfflinePopView mOfflineView;
    MixedTextView mPowerStatus;
    private NaviScenePresenter mPresenter;
    RecommendParkView mRecommendParkView;
    RecommendRoutePop mRecommendRoutePop;
    private IUIRelationshipHelper mRelationshipHelper;
    private XTextView mRemainDistance;
    private int mResId;
    private RestrictHelper mRestrictHelper;
    XLinearLayout mRightViewContainer;
    private View mRootView;
    RouteChargePanelView mRouteChargePanelView;
    @BindView(R.id.route_charge_panel_stub)
    ViewStub mRouteChargeStub;
    private String[] mRouteFailReason;
    private XLandLoadingDialog mRoutingDialog;
    private Button mSRDynamicLevelMode;
    private Button mSRLevelMode;
    private ViewStub mSRLevelStub;
    private Button mSRLevelValue;
    private View mSRLevelView;
    @BindView(R.id.sr_view_angle_group)
    XRadioGroup mSRViewAngleBtnGroup;
    SapaContainerView mSapaContainer;
    LinearLayout mSimulationLayout;
    @BindView(R.id.interval_camera_container)
    XLinearLayout mSuggestSpeedCameras;
    XTextView mTimeArrive;
    private XTextView mTimeInfo;
    XTextView mTotalLeft;
    @BindView(R.id.navi_info_trafficbar)
    TrafficBar mTrafficBar;
    @BindView(R.id.srnavi_traffic_panel)
    XRelativeLayout mTrafficPanel;
    @BindView(R.id.srnavi_traffic_panel_icon)
    XImageView mTrafficPanelIcon;
    @BindView(R.id.srnavi_traffic_panel_text)
    XTextView mTrafficPanelText;
    XTextView mTurnEnter;
    XImageView mTurnIcon;
    private Bitmap mTurnIconBitmap;
    @BindView(R.id.tv_3d_to_2d)
    XTextView mTvBackTo2D;
    @BindView(R.id.guide_continue_navi)
    CurrentRoadNameView mTvContinuNavi;
    XTextView mTvCrossExitInfo;
    @BindView(R.id.guide_curroad_name)
    CurrentRoadNameView mTvCurrentRoad;
    XTextView mTvExitInfo;
    private XIKnowDialog mXIKnowDialog;
    @BindView(R.id.srnavi_ngp_panel_view)
    XpNgpPanelView mXpNgpPanelView;
    private boolean mIs3DCrossShow = false;
    private boolean mIsMapTouchLocked = false;
    private boolean mIs2DCrossShow = false;
    private String mSearchKeyword = "";
    private int mRetryEagleInitCount = 0;
    private boolean mIsExitDirectionShow = false;
    private boolean mHasMotionEvent = false;
    private int mCurrentSegIndex = 0;
    private final List<Integer> mLeftViews = new ArrayList();
    private boolean mOfflineViewRestore = false;

    /* loaded from: classes2.dex */
    public enum LaneMarginStatus {
        LANE_STATUS_NORMAL,
        LANE_STATUS_CROSS,
        LANE_STATUS_CAMERA_NORMAL,
        LANE_STATUS_CAMERA_MAX,
        LANE_STATUS_SAPA
    }

    private void updateCurrentRoadPos(boolean z, boolean z2) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void exchangeEagleEyeView(boolean z, boolean z2) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public boolean isLeftPanelShow() {
        return false;
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

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickRouteChargeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onMapRecenterUpdate() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void onRestrictViewVisibilityChanged(int i) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onSelectRoute(int i) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpInfoTips(boolean z, int i, int i2, int i3) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    public static NaviFragment newInstance() {
        return new NaviFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(@Nullable Bundle bundle) {
        super.onSceneCreate(bundle);
        EventBus.getDefault().register(this);
        if (bundle != null) {
            this.mHasMotionEvent = bundle.getBoolean(KEY_OUTSTATE_HAS_MOTION_EVENT);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.layout_guide, (ViewGroup) null);
        this.mBind = ButterKnife.bind(this, this.mRootView);
        this.mRelationshipHelper = new UIRelationshipHelper(this);
        this.mRelationshipHelper.register();
        this.mPresenter.create();
        this.mNgpInfoTips = getResources().getTextArray(R.array.srnavi_ngp_info_tips);
        this.mNgpLcTips = getResources().getTextArray(R.array.srnavi_ngp_lc_tips);
        this.mNgpQuitTips = getResources().getTextArray(R.array.srnavi_ngp_quit_tips);
        this.mNgpOperates = getResources().getTextArray(R.array.srnavi_ngp_operate);
        this.mNgpLccText = getResources().getString(R.string.srnavi_ngp_panel_lcc_text);
        this.mXpNgpPanelView.setOnNgpPanelListener(new XpNgpPanelView.OnNgpPanelStatusListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.1
            @Override // com.xiaopeng.montecarlo.views.XpNgpPanelView.OnNgpPanelStatusListener
            public void onClick(int i, int i2, View view) {
                NaviFragment.this.mPresenter.clickOperate(i, i2);
            }

            @Override // com.xiaopeng.montecarlo.views.XpNgpPanelView.OnNgpPanelStatusListener
            public void onNgpPanelSizeChanged() {
                NaviFragment.this.mRelationshipHelper.notifyElementUpdate(UIRelationshipConfig.ELEMENT_NGP);
                if (Utils.isLandscape()) {
                    return;
                }
                NaviFragment.this.updateLaneAvailableArea();
            }

            @Override // com.xiaopeng.montecarlo.views.XpNgpPanelView.OnNgpPanelStatusListener
            public void onNgpPanelWidthChanged() {
                if (Utils.isLandscape()) {
                    return;
                }
                NaviFragment.this.updateLaneAvailableArea();
            }
        });
        initSRViewAngle();
        return this.mRootView;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        RouteRequest routeRequest;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        super.onSceneViewCreated(view, bundle);
        boolean z6 = true;
        boolean z7 = false;
        boolean z8 = bundle == null;
        Bundle bundle2 = getBridge().getBundle();
        long j = -1;
        if (bundle2 != null) {
            routeRequest = (RouteRequest) bundle2.getParcelable(RouteBridge.ROUTE_REQUEST);
            boolean z9 = bundle2.getBoolean(NaviUtil.IS_NEED_START_NAVI_KEY, true);
            i3 = bundle2.getInt(SystemConst.ISOFFLINE_TYPE_KEY, -1);
            boolean z10 = bundle2.getBoolean(SystemConst.IS_FROM_COMMUTING_TYPE_KEY, false);
            z3 = bundle2.getBoolean(SystemConst.ROUTE_MANUAL, false);
            z4 = bundle2.getBoolean(NaviUtil.IS_NEED_TTSPROXY_SPEAK, false);
            z5 = bundle2.getBoolean(NaviUtil.IS_NEED_TO_SR, false) && (2 != SRNaviManager.getInstance().getSRDisplayState());
            long j2 = bundle2.getLong(SystemConst.START_NAVI_ID, -1L);
            long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
            j = (currentNaviId == -1 || currentNaviId == j2) ? j2 : currentNaviId;
            int i4 = bundle2.getInt(SystemConst.START_NAVI_PATH_INDEX, 0);
            z = bundle2.getBoolean(MapRouteMsg.MAPROUTEMSG_IS_FILTER_CHARGE, true);
            boolean z11 = bundle2.getBoolean(SystemConst.IS_REQUEST_RESTRICT, true);
            int i5 = SystemConst.ROUTE_TYPE_FROM_PHONE.equals(bundle2.getString(SystemConst.ROUTE_TYPE_KEY, "")) ? 4 : -1;
            i = i4;
            z7 = z10;
            int i6 = i5;
            z2 = z11;
            z6 = z9;
            i2 = i6;
        } else {
            routeRequest = null;
            z = true;
            i = 0;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            i2 = -1;
            i3 = -1;
        }
        getMapView().getSRShowLogHelper().logNaviStart();
        this.mPresenter.onViewCreated(new NaviPresenterData.Builder().setRouterRequest(routeRequest).setIsNeedStartNavi(z6).setOfflineRemainCount(i3).setCommutingState(z7).setIsManual(z3).setNaviId(j).setPathIndex(i).setIsFirstEnter(z8).setIsNeedTTSProxySpeak(z4).setIsFilterCharge(z).setIsRequestRestrict(z2).setRequestType(i2).setIsNeedToSrNav(z5).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        LaneInfoView laneInfoView;
        super.onSceneResume();
        this.mPresenter.onResume();
        getMainContext().updateRecenterShowTag(false);
        refreshEagleViewAfterResumeIfNotInit();
        if (Utils.isPortrait() && (laneInfoView = this.mLanesLayout) != null) {
            laneInfoView.setParentWidth(RootUtil.getScreenWidth());
        }
        renderLayoutByDayNightStatus(false);
        DataLogUtil.sendStatData(getPageType(), BtnType.GUIDE_PANEL_SHOW, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        this.mPresenter.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneStop() {
        super.onSceneStop();
        this.mPresenter.onStop();
        getMainContext().updateRecenterShowTag(true);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        TrafficBar trafficBar;
        super.onSceneDestroyView();
        getMapView().resetRestoreMapState();
        this.mPresenter.clearAlterLabelTableForVui(0);
        getMainContext().stopTakeOverWeakAnim();
        RecommendParkView recommendParkView = this.mRecommendParkView;
        if (recommendParkView != null) {
            recommendParkView.setListener(null);
            this.mRecommendParkView = null;
        }
        RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
        if (routeChargePanelView != null) {
            routeChargePanelView.setListener(null);
        }
        LaneInfoView laneInfoView = this.mLanesLayout;
        if (laneInfoView != null) {
            laneInfoView.setOnVisibilityChangeListener(null);
        }
        this.mPresenter.onDestroyView();
        getMainContext().updateRecenterShowTag(true);
        getMainContext().removeSceneMapFragmentListener(this);
        updateOverviewStatus(false);
        updateSRNaviSwitchStatus(8, false);
        this.mOfflineViewRestore = false;
        OfflinePopView offlinePopView = this.mOfflineView;
        if (offlinePopView != null) {
            offlinePopView.hide();
            this.mOfflineView = null;
        }
        RestrictHelper restrictHelper = this.mRestrictHelper;
        if (restrictHelper != null) {
            restrictHelper.unInit();
        }
        onHideRecommendRoutePop();
        Bitmap bitmap = this.mTurnIconBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mTurnIconBitmap.recycle();
            this.mTurnIconBitmap = null;
        }
        XIKnowDialog xIKnowDialog = this.mXIKnowDialog;
        if (xIKnowDialog != null && xIKnowDialog.isShowing()) {
            this.mXIKnowDialog.dismiss();
        }
        if (this.mIs2DCrossShow) {
            this.mPresenter.hideCrossImage();
        }
        if (isEagleEyeEnable()) {
            hideEagleEyeView(getMapView());
        }
        XImageView xImageView = this.mEagleBgMask;
        if (xImageView != null) {
            xImageView.setVisibility(8);
        }
        this.mSimulationLayout = null;
        this.mNaviInfo = null;
        IUIRelationshipHelper iUIRelationshipHelper = this.mRelationshipHelper;
        if (iUIRelationshipHelper != null) {
            iUIRelationshipHelper.unRegister();
        }
        this.mLeftViews.clear();
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        if (recommendRoutePop != null) {
            recommendRoutePop.setListener(null);
            this.mRecommendRoutePop = null;
        }
        this.mNaviPanal = null;
        releaseNgpPanelView();
        if (Utils.isLandscape() && (trafficBar = this.mTrafficBar) != null) {
            trafficBar.removeCarMoveListener();
        }
        Unbinder unbinder = this.mBind;
        if (unbinder != null) {
            unbinder.unbind();
        }
        getMapView().getSRShowLogHelper().logNaviStop();
    }

    private void releaseNgpPanelView() {
        if (L.ENABLE) {
            L.d(TAG, "releaseNgpPanelView");
        }
        XpNgpPanelView xpNgpPanelView = this.mXpNgpPanelView;
        if (xpNgpPanelView != null) {
            xpNgpPanelView.setOnNgpPanelListener(null);
            this.mXpNgpPanelView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        super.onSceneDestroy();
        EventBus.getDefault().unregister(this);
        onHideRouting();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onUpdate3DTo2DButton(boolean z) {
        XFrameLayout xFrameLayout;
        if (isSceneLegal() && (xFrameLayout = this.mGuideBackTo2D) != null) {
            xFrameLayout.setVisibility(z ? 0 : 8);
            if (isSceneVuiEnabled()) {
                VoiceFullScenesUtil.updateScene(this, this.mGuideBackTo2D);
            }
        }
    }

    @OnClick({R.id.guide_3d_to_2d})
    public void onClick3DTo2D(View view) {
        this.mPresenter.exitCross3D();
    }

    @OnClick({R.id.btn_guide_add_waypoint})
    public void onClickAddWaypoint(View view) {
        if (preventMultiClick(view)) {
            L.i(TAG, "open search with over mode for add way point");
            Bundle bundle = new Bundle();
            bundle.putInt(SearchBridge.SEARCH_MODE, 102);
            bundle.putInt(SearchBridge.FROM_SCENE_INDEX, getSceneStackSize());
            bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, getChildStackSize());
            bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, this.mSearchKeyword);
            bundle.putInt(SearchBridge.ANIM_TYPE, 0);
            bundle.putInt(SearchBridge.ANIM_START_Y, view.getTop());
            bundle.putInt(SearchBridge.ANIM_START_H, view.getHeight());
            startScene(new SearchBridge().enableOverMode().setBundle(bundle), 100);
            DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.SEARCH_ENTER_WAYPOINT, new Object[0]);
            this.mSearchKeyword = "";
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void initView() {
        this.mTrafficBar.updatePassedAndBasicColor(ThemeWatcherUtil.getColor(R.color.traffic_passed), ThemeWatcherUtil.getColor(R.color.traffic_none_info));
        this.mRootView.setVisibility(8);
        this.mGuideBackTo2D.setVisibility(8);
        this.mSapaContainer = (SapaContainerView) this.mRootView.findViewById(R.id.guide_sapa_container);
        if (Utils.isLandscape()) {
            this.mLeftGuidePanel = (LinearLayout) this.mRootView.findViewById(R.id.guide_left_info_panel);
            this.mGuideContainer = (XRelativeLayout) this.mRootView.findViewById(R.id.guide_container);
            this.mRemainDistance = (XTextView) this.mRootView.findViewById(R.id.navi_distance_remain);
            this.mTimeInfo = (XTextView) this.mRootView.findViewById(R.id.navi_time_info);
            this.mTrafficBar.setCarMoveListener(new TrafficBar.OnCarMoveListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$H74KPP9OpslTDmiY-OHPxjCosX8
                @Override // com.xiaopeng.montecarlo.views.TrafficBar.OnCarMoveListener
                public final void onCarMove(float f) {
                    NaviFragment.this.lambda$initView$0$NaviFragment(f);
                }
            });
            this.mGuideExitNavi = (ImageTextView) this.mRootView.findViewById(R.id.guide_exit_navi);
            setGuideExitNaviVisibility();
        } else {
            initNaviInfoPanal();
            this.mLanesLayout = (LaneInfoView) this.mRootView.findViewById(R.id.guide_lanes_layout);
            this.mCrossTurnIcon = (XImageView) this.mRootView.findViewById(R.id.im_cross_navi_info_turn);
            this.mCrossDistanceToTurn = (XTextView) this.mRootView.findViewById(R.id.tv_cross_navi_info_turn_distance);
            this.mCrossDistanceToTurnUnit = (XTextView) this.mRootView.findViewById(R.id.tv_cross_navi_info_turn_distance_unit);
            this.mTvCrossExitInfo = (XTextView) this.mRootView.findViewById(R.id.tv_cross_navi_info_turn_exit);
            this.mCrossNextTurnName = (XTextView) this.mRootView.findViewById(R.id.tv_cross_navi_info_turn_road_name);
            this.mRightViewContainer = (XLinearLayout) this.mRootView.findViewById(R.id.ll_right_view_container);
            this.mSRLevelStub = (ViewStub) this.mRootView.findViewById(R.id.simulation_button_sr_level_layout_stub);
            this.mLanesLayout.setOnVisibilityChangeListener(new LaneInfoView.IOnVisibilityChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.2
                @Override // com.xiaopeng.montecarlo.views.LaneInfoView.IOnVisibilityChangeListener
                public void onVisibilityChanged(int i) {
                    NaviFragment.this.updateRecommendParkLayout();
                }
            });
        }
        this.mGuideExitNavi.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                L.i(NaviFragment.TAG, "mGuideExitNavi ----------");
                TBTManager.getInstance().stopNavi(true);
            }
        });
        initLeftRightViewsList();
        updateLaneAvailableArea();
    }

    public /* synthetic */ void lambda$initView$0$NaviFragment(float f) {
        XTextView xTextView = this.mTimeInfo;
        xTextView.setTranslationY(f - (xTextView.getHeight() / 2.0f));
    }

    private void initNaviInfoPanal() {
        if (this.mNaviPanal == null) {
            this.mNaviPanal = (XRelativeLayout) ((ViewStub) this.mRootView.findViewById(R.id.guide_navi_info_stub)).inflate();
            this.mTurnIcon = (XImageView) this.mNaviPanal.findViewById(R.id.im_navi_info_turn);
            this.mDistanceToTurn = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_turn_distance);
            this.mDistanceToTurnUnit = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_turn_distance_unit);
            this.mNextTurnIcon = (XImageView) this.mNaviPanal.findViewById(R.id.im_navi_info_next_turn_normal);
            this.mDistanceToNextTurn = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_next_turn_distance_normal);
            this.mNextTurnIconSpe = (XImageView) this.mNaviPanal.findViewById(R.id.im_navi_info_next_turn_spe);
            this.mDistanceToNextTurnSpe = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_next_turn_distance_spe);
            this.mTotalLeft = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_remain);
            this.mTimeArrive = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_arrive_time);
            this.mTurnEnter = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_turn_enter);
            this.mNextTurnName = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_turn_road_name);
            this.mTvExitInfo = (XTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_turn_exit);
            this.mPowerStatus = (MixedTextView) this.mNaviPanal.findViewById(R.id.tv_navi_info_power_endurance_content);
            this.mExitInfoLayout = this.mNaviPanal.findViewById(R.id.navi_info_turn_road_layout);
            this.mExitInfoEndShadow = (XImageView) this.mNaviPanal.findViewById(R.id.iv_end_shadow);
            this.mGuideExitNavi = (ImageTextView) this.mNaviPanal.findViewById(R.id.guide_exit_navi);
            this.mNaviPanal.setVisibility(0);
            this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_NAVI_PANEL);
        }
        this.mGuideExitNavi.setTextSize(ContextUtils.getDimensionPixelSize(R.dimen.font_size_land_24_port_22));
        XRelativeLayout xRelativeLayout = this.mNaviPanal;
        if (xRelativeLayout != null) {
            xRelativeLayout.setOnClickListener(this);
        }
        XImageView xImageView = this.mTurnIcon;
        if (xImageView != null) {
            xImageView.setOnClickListener(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void initData(boolean z) {
        this.mRouteFailReason = ContextUtils.getStringArray(R.array.route_fail_reason);
        this.mRestrictHelper = new RestrictHelper(getActivity(), this);
        this.mRestrictHelper.init();
        this.mTrafficBar.setDrawTrafficBlock(!z);
        getMainContext().setSceneMapFragmentListener(this);
        getMapView().restoreCarPosition();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void initMapMode() {
        if (isSceneLegal()) {
            int savedMapMode = MapUtil.getSavedMapMode(true);
            L.Tag tag = TAG;
            L.i(tag, "initialized map mode： " + savedMapMode);
            getMapView().setMapMode(savedMapMode, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void initListener() {
        StateManager.getInstance().addListener(this.mPresenter.getStateListener());
    }

    private void updateTimeArrive() {
        int i;
        if (this.mNaviInfo == null) {
            L.w(TAG, "updateTimeArrive mNaviInfo is null");
        } else if (!Utils.isLandscape() && this.mPowerStatus != null) {
            double d = this.mNaviInfo.mRouteRemainDist;
            double d2 = this.mNaviInfo.mRouteRemainTime;
            if (!CollectionUtils.isEmpty(this.mNaviInfo.mViaRemainDist) && !CollectionUtils.isEmpty(this.mNaviInfo.mViaRemainTime)) {
                d = this.mNaviInfo.mViaRemainDist[0];
                d2 = this.mNaviInfo.mViaRemainTime[0];
            }
            int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
            int kValue = (int) (carRemainDistance - (PowerDistanceManager.getInstance().getKValue(this.mNaviInfo.mPathID) * d));
            try {
                i = NaviUtil.checkDistanceReachableStatus(carRemainDistance, kValue);
            } catch (NaviUtil.DistanceStatusIllegalArgumentException unused) {
                L.w(TAG, "invalid value carRemainDis: " + carRemainDistance + ", afterArriveRemainDis: " + kValue);
                i = 0;
            }
            if (L.ENABLE) {
                L.d(TAG, "remainDis:" + d + ", remainTime:" + d2 + ", carRemainDis:" + carRemainDistance + ", afterArriveRemainDis:" + kValue + ", status:" + i + ", via:" + TBTManager.getInstance().getPassingViaIndex());
            }
            if (i == 0) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(ContextUtils.getString(R.string.navi_unable_reach_end));
                this.mPowerStatus.updateMixedText(arrayList);
                this.mPowerStatus.setTextColorResId(ThemeWatcherUtil.getColorResId(R.color.batter_status_unreachable), 0);
            } else if (i == 1) {
                String[] remainDistanceArray = NaviUtil.getRemainDistanceArray(kValue);
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(getString(R.string.navi_reach_prefix_1) + remainDistanceArray[0] + remainDistanceArray[1]);
                this.mPowerStatus.updateMixedText(arrayList2);
                this.mPowerStatus.setTextColorResId(ThemeWatcherUtil.getColorResId(R.color.primary_text01), 0);
            } else if (i == 2) {
                ArrayList arrayList3 = new ArrayList(1);
                if (carRemainDistance >= 20000) {
                    String[] remainDistanceArray2 = NaviUtil.getRemainDistanceArray(kValue);
                    arrayList3.add(getString(R.string.navi_reach_prefix_1) + remainDistanceArray2[0] + remainDistanceArray2[1]);
                } else {
                    arrayList3.add(ContextUtils.getString(R.string.navi_lower_power_des));
                }
                this.mPowerStatus.updateMixedText(arrayList3);
                this.mPowerStatus.setTextColorResId(ThemeWatcherUtil.getColorResId(R.color.batter_status_warning), 0);
            }
            if (i != 1 && i != 2) {
                this.mTimeArrive.setVisibility(8);
            } else if (i == 2 && carRemainDistance < 20000) {
                this.mTimeArrive.setVisibility(8);
            } else {
                StringBuilder sb = new StringBuilder();
                List<String> travelTime = NaviUtil.getTravelTime((long) d2);
                if (!CollectionUtils.isEmpty(travelTime)) {
                    for (String str : travelTime) {
                        if (!TextUtils.isEmpty(str)) {
                            sb.append(str);
                        }
                    }
                }
                if (TBTManager.getInstance().getPassingViaIndex() >= 0) {
                    sb.append(NaviUtil.getRoutePointSuffix());
                }
                this.mTimeArrive.setVisibility(0);
                this.mTimeArrive.setText(sb.toString());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void updateViewState() {
        if (isSceneResumed()) {
            boolean z = true;
            boolean z2 = !this.mPresenter.isEagleEyeViewSettingEnabled();
            if (this.mEagleBgMask != null) {
                exchangeEagleEyeView(!z2, true);
            }
            if (Utils.isPortrait()) {
                if (this.mIs2DCrossShow || !z2) {
                    z = false;
                }
                onUpdateTrafficView(z);
                return;
            }
            onUpdateTrafficView(z2);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void unInitListener() {
        StateManager.getInstance().removeListener(this.mPresenter.getStateListener());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public boolean is3DCrossShow() {
        return this.mIs3DCrossShow;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void removeChildScene() {
        removeAllChildScene();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onOverviewModeChanged(boolean z) {
        NaviScenePresenter naviScenePresenter;
        if (isSceneLegal()) {
            MapUIStatus uIStatus = getUIStatus();
            uIStatus.mOverViewVisibility = (this.mIs3DCrossShow || this.mPresenter.isEagleEyeViewSettingEnabled()) ? 8 : 0;
            uIStatus.mOverViewSelected = z ? 1 : 0;
            if (!z) {
                SapaContainerView sapaContainerView = this.mSapaContainer;
                if (sapaContainerView != null && sapaContainerView.getVisibility() != 0 && (naviScenePresenter = this.mPresenter) != null && naviScenePresenter.isHaveSAPA() && Utils.isPortrait() && this.mRelationshipHelper.canElementShow(UIRelationshipConfig.ELEMENT_SAPA) && Utils.isPortrait()) {
                    setSapaContainerVisibility(true, true);
                }
            } else {
                SapaContainerView sapaContainerView2 = this.mSapaContainer;
                if (sapaContainerView2 != null && sapaContainerView2.getVisibility() == 0 && Utils.isPortrait()) {
                    setSapaContainerVisibility(false, true);
                }
            }
            updateMapRenderModeVisibility(uIStatus);
            updateUIStatus(uIStatus);
        }
    }

    private void setSapaContainerVisibility(boolean z, boolean z2) {
        if (this.mSapaContainer != null) {
            int i = z ? 0 : 8;
            if (this.mSapaContainer.getVisibility() != i) {
                this.mSapaContainer.setVisibility(i);
                if (z2) {
                    if (z) {
                        this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_SAPA);
                    } else {
                        this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_SAPA);
                    }
                }
                updateRightViewLayout();
            }
        }
        TrafficBar trafficBar = this.mTrafficBar;
        if (trafficBar == null || this.mTimeInfo == null || trafficBar.getVisibility() != 0) {
            return;
        }
        this.mTimeInfo.setVisibility(z ? 8 : 0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onUpdatePreview(RectDouble rectDouble) {
        if (L.ENABLE) {
            L.d(TAG, "onUpdatePreview");
        }
        FragmentActivity activity = getActivity();
        if (rectDouble == null || !isSceneLegal() || activity == null) {
            return;
        }
        hideContinueNavi();
        PreviewParam previewParam = new PreviewParam();
        previewParam.mapBound = rectDouble;
        previewParam.bUseRect = true;
        if (isLeftPanelShow()) {
            previewParam.screenLeft = NaviUtil.getNaviRouteOverviewOffsetLeftSpecial(activity);
        } else {
            previewParam.screenLeft = NaviUtil.getNaviRouteOverviewOffsetLeft(activity);
        }
        previewParam.screenTop = NaviUtil.getNaviRouteOverviewOffsetTop(activity);
        previewParam.screenRight = NaviUtil.getNaviRouteOverviewOffsetRight(activity);
        previewParam.screenBottom = NaviUtil.getNaviRouteOverviewOffsetBottom(activity);
        previewParam.bAdjustHeaderAngle = false;
        getMapView().showPreview(previewParam);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onShowExitInfo(XPExitDirectionInfo xPExitDirectionInfo) {
        if (!isSceneResumed() || Utils.isLandscape()) {
            return;
        }
        if (xPExitDirectionInfo != null && xPExitDirectionInfo.mDirectionInfo != null) {
            this.mTurnEnter.setVisibility(8);
            this.mExitInfoLayout.setVisibility(0);
            this.mTvExitInfo.setVisibility(0);
            this.mTvCrossExitInfo.setVisibility(0);
            List<String> list = xPExitDirectionInfo.mExitNameInfo;
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("showExitInfo exitNameInfo =");
            sb.append(list == null ? "is null" : Integer.valueOf(list.size()));
            L.i(tag, sb.toString());
            String str = (list == null || list.size() != 1) ? "" : list.get(0);
            String string = TextUtils.isEmpty(xPExitDirectionInfo.mEntranceExit) ? getResources().getString(R.string.navi_info_turn_exit_name, str) : xPExitDirectionInfo.mEntranceExit + str;
            this.mTvExitInfo.setText(string);
            this.mTvCrossExitInfo.setText(string);
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < xPExitDirectionInfo.mDirectionInfo.size(); i++) {
                String str2 = xPExitDirectionInfo.mDirectionInfo.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    if (sb2.length() == 0) {
                        sb2.append(str2);
                    } else {
                        sb2.append(" ");
                        sb2.append(str2);
                    }
                }
            }
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(sb3)) {
                this.mIsExitDirectionShow = true;
                this.mCrossNextTurnName.setText(sb3);
                this.mNextTurnName.setText(sb3);
                if (L.ENABLE) {
                    L.d(TAG, "hint = " + sb3 + " , mExitInfoLayout.getRight() = " + this.mExitInfoLayout.getRight() + " , mExitInfoEndShadow.getLeft() = " + this.mExitInfoEndShadow.getLeft());
                }
                if (this.mExitInfoLayout.getRight() > this.mExitInfoEndShadow.getLeft()) {
                    this.mExitInfoEndShadow.setVisibility(0);
                } else {
                    this.mExitInfoEndShadow.setVisibility(4);
                }
            } else {
                this.mIsExitDirectionShow = false;
            }
        } else {
            L.i(TAG, "showExitInfo exitDirectionInfo is null, set visibility to gone");
            this.mTurnEnter.setVisibility(0);
            this.mExitInfoLayout.setVisibility(4);
            this.mExitInfoEndShadow.setVisibility(4);
            this.mTvExitInfo.setVisibility(8);
            this.mTvCrossExitInfo.setVisibility(8);
            this.mIsExitDirectionShow = false;
        }
        if (L.ENABLE) {
            L.d(TAG, "showExitInfo mIsExitDirectionShow = " + this.mIsExitDirectionShow);
        }
        if (this.mDistanceToNextTurn.getVisibility() == 0 || this.mDistanceToNextTurnSpe.getVisibility() == 0) {
            tightTurnView(true);
        }
    }

    private int getLineMaxNumber(String str, TextPaint textPaint, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return new StaticLayout(str, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
    }

    private void updateOverviewStatus(boolean z) {
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mOverViewVisibility = z ? 0 : 8;
        updateUIStatus(uIStatus);
    }

    private void updateInfo(@NonNull XPNaviInfo xPNaviInfo) {
        if (isSceneResumed()) {
            this.mNaviInfo = xPNaviInfo;
            updateTimeArrive();
            View view = this.mRootView;
            if (view != null && view.getVisibility() != 0) {
                L.i(TAG, "updateInfo set rootview to visible");
                this.mRootView.setVisibility(0);
            }
            updateCurrentRoadName(xPNaviInfo.mCurRouteName);
            this.mTrafficBar.updateViasIcon();
            this.mTrafficBar.setLeftDistance(xPNaviInfo.mRouteRemainDist);
            if (Utils.isLandscape()) {
                if (this.mRemainDistance != null) {
                    this.mRemainDistance.setText(NaviUtil.getInfoFlowDistanceRemain(xPNaviInfo.mRouteRemainDist));
                }
                XTextView xTextView = this.mTimeInfo;
                if (xTextView != null) {
                    xTextView.setText(NaviUtil.getTimeShortString(xPNaviInfo.mRouteRemainTime));
                    return;
                }
                return;
            }
            NaviTipsData updateNaviTipsInfoForCloudRoute = CloudRouteDataHelper.getInstance().updateNaviTipsInfoForCloudRoute(xPNaviInfo);
            XPNaviInfoPanel[] xPNaviInfoPanelArr = xPNaviInfo.mNaviInfoData;
            XPCrossNaviInfo[] xPCrossNaviInfoArr = xPNaviInfo.mNextCrossInfo;
            Drawable drawable = null;
            if (this.mCurrentSegIndex != xPNaviInfo.mCurSegIdx) {
                onShowExitInfo(null);
            }
            this.mCurrentSegIndex = xPNaviInfo.mCurSegIdx;
            int i = (int) xPNaviInfo.mRouteRemainDist;
            StringBuilder sb = new StringBuilder();
            String[] distanceArray = NaviUtil.getDistanceArray(i);
            sb.append(getString(R.string.navi_info_remain_distance, distanceArray[0], distanceArray[1]));
            List<String> naviTimeString = NaviUtil.getNaviTimeString(xPNaviInfo.mRouteRemainTime, i);
            if (!CollectionUtils.isEmpty(naviTimeString)) {
                for (String str : naviTimeString) {
                    sb.append(str);
                }
            }
            this.mTotalLeft.setText(sb.toString());
            if (xPNaviInfoPanelArr == null || xPNaviInfoPanelArr.length <= 0) {
                return;
            }
            if (15 == xPNaviInfo.mCrossManeuverID) {
                if (!this.mIsExitDirectionShow) {
                    this.mTurnEnter.setText(getString(R.string.guide_arrive_destination));
                    this.mCrossNextTurnName.setText(getString(R.string.guide_arrive_destination));
                }
            } else if (!this.mIsExitDirectionShow) {
                String nextRouteName = updateNaviTipsInfoForCloudRoute != null ? updateNaviTipsInfoForCloudRoute.getNextRouteName() : xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag].mNextRouteName;
                String string = getResources().getString(R.string.navi_info_enter, nextRouteName);
                this.mTurnEnter.setText(string);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNextTurnIcon.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mDistanceToNextTurn.getLayoutParams();
                if (this.mTurnEnter.getLeft() + this.mTurnEnter.getPaint().measureText(string) > this.mNextTurnIcon.getLeft()) {
                    if (layoutParams.getRule(2) != this.mDistanceToTurnUnit.getId()) {
                        layoutParams.removeRule(8);
                        layoutParams.addRule(2, this.mDistanceToTurnUnit.getId());
                        this.mNextTurnIcon.setLayoutParams(layoutParams);
                    }
                    if (layoutParams2.getRule(2) != this.mDistanceToTurnUnit.getId()) {
                        layoutParams2.removeRule(8);
                        layoutParams2.addRule(2, this.mDistanceToTurnUnit.getId());
                        this.mDistanceToNextTurn.setLayoutParams(layoutParams2);
                    }
                } else {
                    if (layoutParams.getRule(8) != this.mDistanceToTurnUnit.getId()) {
                        layoutParams.removeRule(2);
                        layoutParams.addRule(8, this.mDistanceToTurnUnit.getId());
                        this.mNextTurnIcon.setLayoutParams(layoutParams);
                    }
                    if (layoutParams2.getRule(8) != this.mDistanceToTurnUnit.getId()) {
                        layoutParams2.removeRule(2);
                        layoutParams2.addRule(8, this.mDistanceToTurnUnit.getId());
                        this.mDistanceToNextTurn.setLayoutParams(layoutParams2);
                    }
                }
                this.mCrossNextTurnName.setText(nextRouteName);
            }
            String[] distanceArray2 = NaviUtil.getDistanceArray(updateNaviTipsInfoForCloudRoute != null ? updateNaviTipsInfoForCloudRoute.getDistance() : xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist);
            this.mDistanceToTurn.setText(distanceArray2[0]);
            this.mCrossDistanceToTurn.setText(distanceArray2[0]);
            this.mDistanceToTurnUnit.setText(distanceArray2[1]);
            this.mCrossDistanceToTurnUnit.setText(distanceArray2[1]);
            if ((xPNaviInfo.mNextCrossInfo != null ? xPNaviInfo.mNextCrossInfo.length : 0) > 0 && this.mPresenter.doesExistTightTurn(xPNaviInfo)) {
                XPCrossNaviInfo xPCrossNaviInfo = xPCrossNaviInfoArr[0];
                if (xPCrossNaviInfo != null) {
                    tightTurnView(true);
                    this.mResId = ResUtil.getNextManeuverResource(updateNaviTipsInfoForCloudRoute != null ? updateNaviTipsInfoForCloudRoute.getNextManeuverID() : xPCrossNaviInfo.mManeuverID);
                    int i2 = this.mResId;
                    if (i2 != 0) {
                        drawable = ThemeWatcherUtil.getDrawable(i2);
                    } else if (L.ENABLE) {
                        L.d(TAG, ">>> have not find the resource id of turn maneuver!");
                    }
                    if (this.mIsExitDirectionShow) {
                        this.mNextTurnIconSpe.setImageDrawable(drawable);
                    } else {
                        this.mNextTurnIcon.setImageDrawable(drawable);
                    }
                    this.mNextTurnDistance = NaviUtil.getDistanceArray(updateNaviTipsInfoForCloudRoute != null ? updateNaviTipsInfoForCloudRoute.getNextDistance() : xPCrossNaviInfo.mCurToSegmentDist);
                    updateNextTurnLayout(this.mNextTurnDistance);
                    return;
                }
                tightTurnView(false);
                return;
            }
            tightTurnView(false);
        }
    }

    private void updateNextTurnLayout(String[] strArr) {
        if (strArr == null || strArr.length < 2) {
            return;
        }
        if (this.mIsExitDirectionShow) {
            this.mDistanceToNextTurnSpe.setText(getResources().getString(R.string.navi_info_next_turn_distance, strArr[0], strArr[1]));
        } else {
            this.mDistanceToNextTurn.setText(getResources().getString(R.string.navi_info_next_turn_distance, strArr[0], strArr[1]));
        }
    }

    @MainThread
    private void updateTurnIcon(XPManeuverInfo xPManeuverInfo) {
        if (!isSceneResumed() || Utils.isLandscape() || xPManeuverInfo == null) {
            return;
        }
        int maneuverResource = ResUtil.getManeuverResource(xPManeuverInfo);
        Drawable drawable = null;
        if (maneuverResource != 0) {
            drawable = getResources().getDrawable(maneuverResource);
        } else if (L.ENABLE) {
            L.d(TAG, ">>>  have not find the resource id of turn maneuver!");
        }
        this.mTurnIcon.setImageDrawable(drawable);
        this.mCrossTurnIcon.setImageDrawable(drawable);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowNaviIntervalCamera(List<XPCameraInfo> list) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowNaviIntervalCamera:");
            sb.append(list == null ? 0 : list.size());
            L.d(tag, sb.toString());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onUpdateTraffic(double d, boolean z) {
        if (isSceneResumed()) {
            this.mTrafficBar.updateTrafficBarVariantPath(d, z, isSceneLegal());
        }
    }

    private void showBLCrossImage(XPCrossImageInfo xPCrossImageInfo, IBizCrossListener iBizCrossListener) {
        getMapView().getBizControlManager().showCross(xPCrossImageInfo, iBizCrossListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchSimlation() {
        NaviScenePresenter naviScenePresenter = this.mPresenter;
        if (naviScenePresenter != null) {
            naviScenePresenter.switchSimulation();
            onUpdateSimulatePanel();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowSimulatePanel() {
        if (isSceneLegal()) {
            if (this.mSimulationLayout == null) {
                this.mSimulationLayout = (LinearLayout) ((ViewStub) this.mRootView.findViewById(R.id.simulation_button_layout_stub)).inflate();
                this.mBtnSimSpeedControl = (XButton) this.mSimulationLayout.findViewById(R.id.btn_sim_guide_control);
                this.mBtnSimSpeedDown = (XButton) this.mSimulationLayout.findViewById(R.id.btn_sim_speed_down);
                this.mBtnSimSpeedUp = (XButton) this.mSimulationLayout.findViewById(R.id.btn_sim_speed_up);
                this.mBtnSimSpeedControl.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        NaviFragment.this.switchSimlation();
                    }
                });
                this.mBtnSimSpeedDown.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NaviFragment.this.mPresenter != null) {
                            NaviFragment.this.mPresenter.adjustSimulationsSpeed(false);
                        }
                    }
                });
                this.mBtnSimSpeedUp.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NaviFragment.this.mPresenter != null) {
                            NaviFragment.this.mPresenter.adjustSimulationsSpeed(true);
                        }
                    }
                });
            }
            this.mSimulationLayout.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onHideSimulatePanel() {
        LinearLayout linearLayout;
        if (isSceneLegal() && (linearLayout = this.mSimulationLayout) != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onUpdateSimulatePanel() {
        NaviScenePresenter naviScenePresenter = this.mPresenter;
        if (naviScenePresenter != null) {
            int bLSimulationNaviSpeed = naviScenePresenter.getBLSimulationNaviSpeed();
            if (bLSimulationNaviSpeed == 0) {
                this.mBtnSimSpeedControl.setText(R.string.button_sim_guide_go);
            } else {
                this.mBtnSimSpeedControl.setText(String.valueOf(bLSimulationNaviSpeed));
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public NaviScenePresenter mo96getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(NaviScenePresenter naviScenePresenter) {
        this.mPresenter = naviScenePresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
        XPNaviInfo xPNaviInfo;
        if (isAdded() && CollectionUtils.isNotEmpty(list) && (xPNaviInfo = list.get(0)) != null) {
            this.mTrafficBar.setLeftDistance(xPNaviInfo.mRouteRemainDist, isAdded());
            if (isAdded()) {
                updateInfo(xPNaviInfo);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onShowCrossImage(XPCrossImageInfo xPCrossImageInfo) {
        if (!isSceneResumed() || xPCrossImageInfo == null || this.mPresenter.isLaneViewShow()) {
            return;
        }
        if (!(StateManager.getInstance().getState() == 1)) {
            L.e(TAG, "onShowCrossImage isImmersion is false.");
            return;
        }
        if (!this.mRelationshipHelper.canElementShow(xPCrossImageInfo.mType == 4 ? UIRelationshipConfig.ELEMENT_CROSS_3D : UIRelationshipConfig.ELEMENT_CROSS_2D)) {
            L.e(TAG, "onShowCrossImage return canElementShow is false.");
            return;
        }
        int i = xPCrossImageInfo.mType;
        if (i == 1) {
            this.mPresenter.asyncToGetCrossIcon(xPCrossImageInfo, 15);
        } else if (i == 3) {
            showBLCrossImage(xPCrossImageInfo, new IBizCrossListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$nThg_GorTTQNxOkTeZ-fCztJ5bA
                @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener
                public final void onShowCross(boolean z) {
                    NaviFragment.this.lambda$onShowCrossImage$3$NaviFragment(z);
                }
            });
        } else if (i != 4) {
        } else {
            showCross3D(xPCrossImageInfo);
        }
    }

    public /* synthetic */ void lambda$onShowCrossImage$3$NaviFragment(boolean z) {
        if (z) {
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$L3bUGwbrF9ziwpAP1lOI5jepAwA
                @Override // java.lang.Runnable
                public final void run() {
                    NaviFragment.this.lambda$null$1$NaviFragment();
                }
            });
        } else {
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$KtfVw0aaU0EsKAawVb5_5CQil1w
                @Override // java.lang.Runnable
                public final void run() {
                    NaviFragment.this.lambda$null$2$NaviFragment();
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$1$NaviFragment() {
        if (!isSceneLegal()) {
            L.e(TAG, "showBLCrossImage but scene is not legal");
            return;
        }
        this.mImCross.setVisibility(8);
        updateViewsOnCross2DVisibilityChange(true);
    }

    public /* synthetic */ void lambda$null$2$NaviFragment() {
        updateViewsOnCross2DVisibilityChange(false);
    }

    private void showCross3D(XPCrossImageInfo xPCrossImageInfo) {
        if (hasChildScene() || SRUtil.isNgpPanelShow()) {
            return;
        }
        if (isShowRecommendPark() && isExpandRecommendParking()) {
            return;
        }
        showBLCrossImage(xPCrossImageInfo, new IBizCrossListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$cRO7hQa5bFW6-RioTw62rHFkLBs
            @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener
            public final void onShowCross(boolean z) {
                NaviFragment.this.lambda$showCross3D$5$NaviFragment(z);
            }
        });
    }

    public /* synthetic */ void lambda$showCross3D$5$NaviFragment(final boolean z) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$0ku_sNOd6XxAILzQUH3mLK7v3Vo
            @Override // java.lang.Runnable
            public final void run() {
                NaviFragment.this.lambda$null$4$NaviFragment(z);
            }
        });
    }

    public /* synthetic */ void lambda$null$4$NaviFragment(boolean z) {
        if (isLegal()) {
            if (z) {
                this.mIs3DCrossShow = true;
                onCross3DVisibilityChange(true);
                hideContinueNavi();
                exchangeEagleEyeView(false, false);
                return;
            }
            onCross3DVisibilityChange(false);
        }
    }

    private void hideCross3D() {
        getMapView().getBizControlManager().hideCross(4, new IBizCrossListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$A6FnsrUTVwCZRsaO-H7UTNDEa3E
            @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener
            public final void onShowCross(boolean z) {
                NaviFragment.this.lambda$hideCross3D$7$NaviFragment(z);
            }
        });
    }

    public /* synthetic */ void lambda$hideCross3D$7$NaviFragment(boolean z) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$-vG34Tl-1a8XkF8HBaKDNicuqxU
            @Override // java.lang.Runnable
            public final void run() {
                NaviFragment.this.lambda$null$6$NaviFragment();
            }
        });
    }

    public /* synthetic */ void lambda$null$6$NaviFragment() {
        this.mIs3DCrossShow = false;
        if (isLegal()) {
            onCross3DVisibilityChange(false);
            exchangeEagleEyeView(true, true);
            if (Utils.isPortrait()) {
                updateLaneAvailableArea();
            }
            refreshNgpPanelView();
        }
    }

    private void onCross3DVisibilityChange(boolean z) {
        if (!z) {
            this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_CROSS_3D);
            if (this.mIsMapTouchLocked) {
                getMainContext().unlockMapTouchEvent();
                this.mIsMapTouchLocked = false;
                if (L.ENABLE) {
                    L.d(TAG, "hideCross3D unlockMapTouchEvent");
                }
            }
        } else {
            this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_CROSS_3D);
            if (!this.mIsMapTouchLocked) {
                getMainContext().lockMapTouchEvent();
                this.mIsMapTouchLocked = true;
                if (L.ENABLE) {
                    L.d(TAG, "hideAllViewInCross3D lockMapTouchEvent");
                }
            }
        }
        getMainContext().setMapTouchEnable(!z);
        onUpdate3DTo2DButton(z);
        if (this.mPresenter.isLaneViewShow()) {
            return;
        }
        if (1 == StateManager.getInstance().getState()) {
            onStateImmersion();
        } else {
            onStateActive();
        }
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_SAPA)
    private void hideSapa() {
        SapaContainerView sapaContainerView = this.mSapaContainer;
        if (sapaContainerView == null || sapaContainerView.getVisibility() != 0) {
            return;
        }
        setSapaContainerVisibility(false, false);
    }

    @UIAction(methodType = 1, name = UIRelationshipConfig.ELEMENT_SAPA)
    private void showSapa() {
        SapaContainerView sapaContainerView;
        NaviScenePresenter naviScenePresenter;
        NaviScenePresenter naviScenePresenter2 = this.mPresenter;
        if ((naviScenePresenter2 != null && 1 == naviScenePresenter2.getCurrentMode()) || (sapaContainerView = this.mSapaContainer) == null || sapaContainerView.getVisibility() == 0 || (naviScenePresenter = this.mPresenter) == null || !naviScenePresenter.isHaveSAPA()) {
            return;
        }
        setSapaContainerVisibility(true, false);
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_NAVI_PANEL)
    private void hideNaviPanel() {
        XRelativeLayout xRelativeLayout = this.mNaviPanal;
        if (xRelativeLayout == null || xRelativeLayout.getVisibility() != 0) {
            return;
        }
        this.mNaviPanal.setVisibility(8);
    }

    @UIAction(methodType = 1, name = UIRelationshipConfig.ELEMENT_NAVI_PANEL)
    private void showNaviPanel() {
        XRelativeLayout xRelativeLayout;
        if (!Utils.isPortrait() || (xRelativeLayout = this.mNaviPanal) == null || xRelativeLayout.getVisibility() == 0) {
            return;
        }
        this.mNaviPanal.setVisibility(0);
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA)
    private void hideIntervalCamera() {
        XLinearLayout xLinearLayout = this.mSuggestSpeedCameras;
        if (xLinearLayout == null || xLinearLayout.getVisibility() != 0) {
            return;
        }
        this.mSuggestSpeedCameras.setVisibility(8);
        this.mPresenter.refreshSpeedInfo();
    }

    @UIAction(methodType = 1, name = UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA)
    private void showIntervalCamera() {
        XLinearLayout xLinearLayout = this.mSuggestSpeedCameras;
        if (xLinearLayout == null || xLinearLayout.getVisibility() == 0) {
            return;
        }
        realOnUpdateIntervalCameraDynamicInfo(this.mNaviIntervalCameraDynamicInfoList, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onHideCrossImage(int i) {
        if (!isSceneLegal()) {
            L.Tag tag = TAG;
            L.i(tag, "onHideCrossImage: fail, scene illegal ! i : " + i);
        } else if (i == 1) {
            updateViewsOnCross2DVisibilityChange(false);
        } else if (i == 3) {
            getMapView().getBizControlManager().hideCross(i, new IBizCrossListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$ZlneurFawd2Ru68Y_zFyevue6Ik
                @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener
                public final void onShowCross(boolean z) {
                    NaviFragment.this.lambda$onHideCrossImage$9$NaviFragment(z);
                }
            });
        } else if (i != 4) {
        } else {
            hideCross3D();
        }
    }

    public /* synthetic */ void lambda$null$8$NaviFragment() {
        updateViewsOnCross2DVisibilityChange(false);
    }

    public /* synthetic */ void lambda$onHideCrossImage$9$NaviFragment(boolean z) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$N81m92CbyWmubJbPXtHW2MCYG-E
            @Override // java.lang.Runnable
            public final void run() {
                NaviFragment.this.lambda$null$8$NaviFragment();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void hideCrossUI() {
        this.mImCross.setVisibility(8);
        this.mCrossLayout.setVisibility(8);
        updateViewsOnCross2DVisibilityChange(false);
        getMapView().getBizControlManager().hideCrossUI(new IBizCrossListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$pvSD0EL65WC6sbl9CjX0MVglvDA
            @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizCrossListener
            public final void onShowCross(boolean z) {
                NaviFragment.this.lambda$hideCrossUI$11$NaviFragment(z);
            }
        });
        hideCross3D();
    }

    public /* synthetic */ void lambda$hideCrossUI$11$NaviFragment(boolean z) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviFragment$_EVAX-SYMALLkqVS3YqyCvPLErA
            @Override // java.lang.Runnable
            public final void run() {
                NaviFragment.this.lambda$null$10$NaviFragment();
            }
        });
    }

    public /* synthetic */ void lambda$null$10$NaviFragment() {
        updateViewsOnCross2DVisibilityChange(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onShowNaviLaneInfo(XPLaneInfo xPLaneInfo) {
        if (!isSceneResumed() || Utils.isLandscape() || this.mLanesLayout == null) {
            return;
        }
        if (this.mPresenter.isLaneViewShow()) {
            this.mLanesLayout.hideLaneInfoView();
            return;
        }
        this.mLanesLayout.updateLaneData(xPLaneInfo);
        updateLaneAvailableArea();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onUpdateTollGateInfo(XPTollGateInfo xPTollGateInfo) {
        if (isSceneLegal()) {
            this.mPresenter.handleTollGateInfo(xPTollGateInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void showCruiseTollGateInfo(List<Integer> list) {
        if (!isSceneLegal() || Utils.isLandscape() || this.mLanesLayout == null) {
            return;
        }
        if (this.mPresenter.isLaneViewShow()) {
            this.mLanesLayout.hideLaneInfoView();
            return;
        }
        this.mLanesLayout.updateTollGateData(list);
        updateLaneAvailableArea();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void hideCruiseTollGateInfo() {
        LaneInfoView laneInfoView;
        if (!isSceneLegal() || Utils.isLandscape() || (laneInfoView = this.mLanesLayout) == null) {
            return;
        }
        laneInfoView.hideLaneInfoView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onHideNaviLaneInfo() {
        LaneInfoView laneInfoView;
        if (!isSceneLegal() || Utils.isLandscape() || (laneInfoView = this.mLanesLayout) == null) {
            return;
        }
        laneInfoView.hideLaneInfoView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView, com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>  onShowNaviManeuver maneuverInfo = " + xPManeuverInfo + " obtainInfo=" + xPObtainInfo);
        }
        if (isSceneLegal() && isAdded()) {
            if (xPObtainInfo == null) {
                updateTurnIcon(xPManeuverInfo);
            } else {
                this.mPresenter.asyncToGetTurnIcon(xPObtainInfo);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list) {
        realOnUpdateIntervalCameraDynamicInfo(list, true);
    }

    private void realOnUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list, boolean z) {
        if (isSceneResumed()) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateIntervalCameraDynamicInfo: ");
            sb.append(list == null ? "0" : Integer.valueOf(list.size()));
            L.i(tag, sb.toString());
            this.mNaviIntervalCameraDynamicInfoList = list;
            if (CollectionUtils.isEmpty(list)) {
                if (this.mSuggestSpeedCameras.getVisibility() != 8) {
                    this.mSuggestSpeedCameras.setVisibility(8);
                    if (z) {
                        this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA);
                    }
                }
            } else if (this.mRelationshipHelper.canElementShow(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA)) {
                if (this.mSuggestSpeedCameras.getVisibility() != 0) {
                    this.mSuggestSpeedCameras.setVisibility(0);
                    if (z) {
                        this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA);
                    }
                }
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nav_interval_camera_height);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    XPCameraInfo xPCameraInfo = list.get(i);
                    if (xPCameraInfo != null) {
                        View childAt = this.mSuggestSpeedCameras.getChildAt(i);
                        if (childAt == null) {
                            childAt = LayoutInflater.from(getActivity()).inflate(R.layout.layout_camera_info, (ViewGroup) null);
                            this.mSuggestSpeedCameras.addView(childAt, -2, dimensionPixelSize);
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
                while (size < this.mSuggestSpeedCameras.getChildCount()) {
                    this.mSuggestSpeedCameras.getChildAt(size).setVisibility(8);
                    size++;
                }
            }
            updateLaneAvailableArea();
            this.mPresenter.refreshSpeedInfo();
        }
    }

    private void initLeftRightViewsList() {
        if (Utils.isPortrait()) {
            XLinearLayout xLinearLayout = this.mBtnAddWaypoint;
            if (xLinearLayout != null) {
                this.mLeftViews.add(Integer.valueOf(xLinearLayout.getId()));
            }
            XpNgpPanelView xpNgpPanelView = this.mXpNgpPanelView;
            if (xpNgpPanelView != null) {
                this.mLeftViews.add(Integer.valueOf(xpNgpPanelView.getId()));
            }
            XRelativeLayout xRelativeLayout = this.mTrafficPanel;
            if (xRelativeLayout != null) {
                this.mLeftViews.add(Integer.valueOf(xRelativeLayout.getId()));
            }
            XLinearLayout xLinearLayout2 = this.mSuggestSpeedCameras;
            if (xLinearLayout2 != null) {
                this.mLeftViews.add(Integer.valueOf(xLinearLayout2.getId()));
                return;
            }
            return;
        }
        XLinearLayout xLinearLayout3 = this.mSuggestSpeedCameras;
        if (xLinearLayout3 != null) {
            this.mLeftViews.add(Integer.valueOf(xLinearLayout3.getId()));
        }
        ViewGroup viewGroup = this.mCrossLayout;
        if (viewGroup != null) {
            this.mLeftViews.add(Integer.valueOf(viewGroup.getId()));
        }
        RecommendParkView recommendParkView = this.mRecommendParkView;
        if (recommendParkView != null) {
            this.mLeftViews.add(Integer.valueOf(recommendParkView.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLaneAvailableArea() {
        updateLaneAvailableArea(false);
    }

    @MainThread
    private void updateLaneAvailableArea(boolean z) {
        if (Utils.isLandscape() || !isSceneResumed() || this.mPresenter.isLaneViewShow()) {
            return;
        }
        if (z) {
            updateOffLinePopViewParam();
        }
        int i = 0;
        Iterator<Integer> it = this.mLeftViews.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            View findViewById = this.mRootView.findViewById(it.next().intValue());
            if (Utils.isVisible(findViewById)) {
                i = Math.max(findViewById.getRight(), 0);
                break;
            }
        }
        int screenWidth = RootUtil.getScreenWidth();
        OfflinePopView offlinePopView = this.mOfflineView;
        int tipsLeft = (offlinePopView == null || offlinePopView.getVisibility() != 0) ? -1 : this.mOfflineView.getTipsLeft();
        if (tipsLeft != -1) {
            screenWidth = Math.min(tipsLeft, screenWidth);
        }
        this.mLanesLayout.setAvailableArea(i, screenWidth, ContextUtils.getDimensionPixelSize(this.mIs2DCrossShow ? R.dimen.lane_status_cross_top : R.dimen.lane_status_normal_top));
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onUpdateSAPA(List<SapaData> list) {
        if (!isSceneResumed() || this.mSapaContainer == null) {
            return;
        }
        NaviScenePresenter naviScenePresenter = this.mPresenter;
        if (naviScenePresenter != null && 1 == naviScenePresenter.getCurrentMode() && Utils.isPortrait()) {
            return;
        }
        updateSAPA(list);
    }

    private void updateSAPA(List<SapaData> list) {
        XLinearLayout xLinearLayout;
        SapaTollView sapaTollView;
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i >= this.mSapaContainer.getChildCount()) {
                    sapaTollView = new SapaTollView(this.mSapaContainer.getContext());
                    sapaTollView.setId(View.generateViewId());
                    this.mSapaContainer.addView(sapaTollView);
                } else {
                    sapaTollView = (SapaTollView) this.mSapaContainer.getChildAt(i);
                    sapaTollView.setVisibility(0);
                }
                sapaTollView.updateData(list.get((size - 1) - i));
            }
            while (size < this.mSapaContainer.getChildCount()) {
                ((SapaTollView) this.mSapaContainer.getChildAt(size)).setVisibility(8);
                size++;
            }
            if (!this.mRelationshipHelper.canElementShow(UIRelationshipConfig.ELEMENT_SAPA) && Utils.isPortrait()) {
                setSapaContainerVisibility(false, true);
            } else {
                setSapaContainerVisibility(true, true);
            }
            if (Utils.isLandscape() || (xLinearLayout = this.mBtnAddWaypoint) == null || xLinearLayout.getVisibility() != 8 || this.mSapaContainer.getVisibility() != 0) {
                return;
            }
            updateLaneAvailableArea();
            return;
        }
        setSapaContainerVisibility(false, true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onNaviStop(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onNaviStop: " + i);
        }
        this.mPresenter.noticeVoiceOnNaviStop();
        goToMap();
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

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onUpdateTMCLightBar(@NonNull ILightBarInfo iLightBarInfo, int i, boolean z) {
        if (isSceneResumed()) {
            this.mTrafficBar.setLightBarInfo(iLightBarInfo, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowRouteFailMsg(int i) {
        if (i == 38) {
            showPrompt(getResources().getString(R.string.route_fail_reason_msg, this.mRouteFailReason[36]));
        } else if (i < 0 || i > 35 || i >= this.mRouteFailReason.length || i == 23 || i == 15) {
        } else {
            showPrompt(getResources().getString(R.string.route_fail_reason_msg, this.mRouteFailReason[i]));
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
    @MainThread
    public void onStateActive() {
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mVolumeVisibility = 0;
        uIStatus.mZoomButtonVisibility = 8;
        if (this.mIs3DCrossShow) {
            uIStatus.mOverViewVisibility = 8;
            uIStatus.mSettingVisibility = 8;
            this.mBtnAddWaypoint.setVisibility(8);
            if (this.mGuideExitNavi != null && Utils.isLandscape()) {
                setGuideExitNaviVisibility();
            }
        } else {
            uIStatus.mOverViewVisibility = 0;
            uIStatus.mSettingVisibility = 0;
            this.mBtnAddWaypoint.setVisibility(0);
            if (Utils.isPortrait()) {
                ImageTextView imageTextView = this.mGuideExitNavi;
                if (imageTextView != null) {
                    imageTextView.setVisibility(0);
                }
                showNaviPanel();
                onUpdateTrafficView(Utils.isMapLightColumn());
            } else {
                setGuideExitNaviVisibility();
            }
        }
        updateScaleVisibility(uIStatus);
        updateMapRenderModeVisibility(uIStatus);
        if (this.mPresenter.isEagleEyeViewSettingEnabled()) {
            uIStatus.mOverViewVisibility = 8;
        }
        updateUIStatus(uIStatus);
        this.mPresenter.hideCrossImage();
        showContinueNavi();
        updateRestrictPopLayout();
        updateOffLinePopViewParam();
        updateLaneAvailableArea();
        if (Utils.isLandscape()) {
            updateCurrentRoadPos(true, this.mIsParallelRoadShow);
        }
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_CROSS_2D)
    private void hide2DCrossImage() {
        this.mPresenter.hide2DCrossImage();
    }

    @UIAction(methodType = 1, name = UIRelationshipConfig.ELEMENT_CROSS_2D)
    public void refresh2DCross() {
        this.mPresenter.refresh2DCross();
    }

    private void setGuideExitNaviVisibility() {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_NAVI_DEBUG_BUTTON_ENABLE, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setGuideExitNaviVisibility isDebugButtonEnable:" + z);
        }
        if (z) {
            this.mGuideExitNavi.setVisibility(0);
        } else if (this.mGuideExitNavi.getVisibility() == 0) {
            this.mGuideExitNavi.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onStateImmersion() {
        hideSceneTrafficEventPop();
        MapUIStatus uIStatus = getUIStatus();
        if (!this.mIs3DCrossShow) {
            uIStatus.mOverViewVisibility = 0;
            uIStatus.mZoomButtonVisibility = 8;
            uIStatus.mSettingVisibility = 8;
        } else {
            uIStatus.mOverViewVisibility = 8;
            uIStatus.mZoomButtonVisibility = 8;
            uIStatus.mSettingVisibility = 8;
        }
        updateScaleVisibility(uIStatus);
        updateMapRenderModeVisibility(uIStatus);
        if (this.mPresenter.isEagleEyeViewSettingEnabled()) {
            uIStatus.mOverViewVisibility = 8;
        }
        uIStatus.mVolumeVisibility = 0;
        updateUIStatus(uIStatus);
        this.mBtnAddWaypoint.setVisibility(8);
        if (this.mGuideExitNavi != null && Utils.isLandscape()) {
            setGuideExitNaviVisibility();
        }
        this.mPresenter.refresh2DCross();
        hideRouteChargePanelView(true);
        updateOffLinePopViewParam();
        updateRestrictPopLayout();
        hideContinueNavi();
        updateLaneAvailableArea();
        if (Utils.isLandscape()) {
            updateCurrentRoadPos(false, this.mIsParallelRoadShow);
        }
        this.mPresenter.resetDefaultSRViewAngle();
    }

    @UIAction(name = "offline")
    @MainThread
    private void updateOffLinePopViewParam() {
        OfflinePopView offlinePopView;
        if (isSceneLegal() && (offlinePopView = this.mOfflineView) != null && offlinePopView.getVisibility() == 0 && Utils.isPortrait()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mOfflineView.getLayoutParams();
            RecommendParkView recommendParkView = this.mRecommendParkView;
            if (recommendParkView != null && recommendParkView.getVisibility() == 0 && !this.mRecommendParkView.isExpand()) {
                marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.guide_restrict_margin_below_recommend_top);
            } else {
                marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.guide_restrict_margin_top);
            }
            this.mOfflineView.setLayoutParams(marginLayoutParams);
        }
    }

    @UIAction(methodType = 1, name = UIRelationshipConfig.ELEMENT_NGP)
    private void showNgp() {
        if (this.mRelationshipHelper.canElementShow(UIRelationshipConfig.ELEMENT_NGP) && SRUtil.isNgpPanelShow()) {
            this.mXpNgpPanelView.setVisibility(0);
            if (Utils.isLandscape()) {
                return;
            }
            updateLaneAvailableArea();
        }
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_NGP)
    private void hideNgp() {
        if (this.mXpNgpPanelView.getVisibility() == 0) {
            this.mXpNgpPanelView.setVisibility(8);
            if (Utils.isLandscape()) {
                return;
            }
            updateLaneAvailableArea();
        }
    }

    private void updateViewsOnCross2DVisibilityChange(boolean z) {
        if (!isSceneLegal()) {
            L.e(TAG, "updateViewsOnCross2DVisibilityChange but scene is not legal ,isVisible:" + z);
            return;
        }
        this.mIs2DCrossShow = z;
        boolean z2 = false;
        this.mCrossLayout.setVisibility(z ? 0 : 8);
        if (z && Utils.isLandscape()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCrossLayout.getLayoutParams();
            marginLayoutParams.topMargin = getResources().getDimensionPixelSize(StateManager.getInstance().getState() == 1 ? R.dimen.guide_cross_view_top_margin_immersion : R.dimen.guide_cross_view_top_margin);
            this.mCrossLayout.setLayoutParams(marginLayoutParams);
        }
        if (this.mIs2DCrossShow) {
            this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_CROSS_2D);
        } else {
            this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_CROSS_2D);
        }
        if (Utils.isPortrait()) {
            if (!z && Utils.isMapLightColumn()) {
                z2 = true;
            }
            onUpdateTrafficView(z2);
            updateLaneAvailableArea(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onMotionEvent() {
        if (L.ENABLE) {
            L.d(TAG, ">>> onMotionEvent");
        }
        this.mHasMotionEvent = true;
        showContinueNavi();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onMoveEvent() {
        if (L.ENABLE) {
            L.d(TAG, ">>> onMoveEvent");
        }
        closeRecommendPark();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void openSearchNormal() {
        onClickAddWaypoint(this.mBtnAddWaypoint);
    }

    private void initSRViewAngle() {
        XRadioGroup xRadioGroup = this.mSRViewAngleBtnGroup;
        if (xRadioGroup != null) {
            xRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.7
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (!NaviFragment.this.mPresenter.isLaneViewShow()) {
                        L.e(NaviFragment.TAG, "set SR view angle error! ");
                    } else if (i == R.id.sr_view_angle_overlook && ((RadioButton) NaviFragment.this.mSRViewAngleBtnGroup.findViewById(R.id.sr_view_angle_overlook)).isChecked()) {
                        NaviFragment.this.mPresenter.setSRViewAngle(2);
                    } else if (i == R.id.sr_view_angle_sidelook && ((RadioButton) NaviFragment.this.mSRViewAngleBtnGroup.findViewById(R.id.sr_view_angle_sidelook)).isChecked()) {
                        NaviFragment.this.mPresenter.setSRViewAngle(3);
                    }
                }
            });
        }
    }

    private void updateSRViewAngleVuiState(boolean z) {
        if (this.mSRViewAngleBtnGroup != null && CarFeatureManager.INSTANCE.isVoiceCmdSRViewAngle()) {
            if (z) {
                if (L.ENABLE) {
                    L.d(TAG, "updateSRViewAngleVuiState enable");
                }
                CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
                MainContext mainContext = this.mMainContext;
                XRadioGroup xRadioGroup = this.mSRViewAngleBtnGroup;
                commonVuiHelper.enableCanSpeechControl(mainContext, xRadioGroup, xRadioGroup, true);
                return;
            }
            if (L.ENABLE) {
                L.d(TAG, "updateSRViewAngleVuiState disable");
            }
            CommonVuiHelper commonVuiHelper2 = CommonVuiHelper.getInstance();
            MainContext mainContext2 = this.mMainContext;
            XRadioGroup xRadioGroup2 = this.mSRViewAngleBtnGroup;
            commonVuiHelper2.disableCanSpeechControl(mainContext2, xRadioGroup2, xRadioGroup2, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onMoveBegin(long j, long j2) {
        super.onMoveBegin(j, j2);
        if (this.mPresenter.isLaneViewShow()) {
            SRNaviManager.getInstance().openFollowMode(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onUpdateLimitSpeed(String str) {
        if (Utils.isLandscape() && this.mPresenter.isLaneViewShow() && this.mLimitSpeedViewText != null) {
            if (this.mSuggestSpeedCameras.getVisibility() == 0) {
                this.mLimitSpeedViewText.setVisibility(8);
            } else if (TextUtils.isEmpty(str)) {
                if (this.mLimitSpeedViewText.getVisibility() == 0) {
                    this.mLimitSpeedViewText.setVisibility(8);
                }
            } else {
                this.mLimitSpeedViewText.setText(str);
                if (this.mLimitSpeedViewText.getVisibility() != 0) {
                    this.mLimitSpeedViewText.setVisibility(0);
                }
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onUpdateAccSpeed(String str) {
        if (Utils.isLandscape() && this.mPresenter.isLaneViewShow() && this.mAccSpeedViewText != null) {
            if (CarServiceManager.getInstance().getXPolitDriveMode() == CarServiceManager.XPolitDriveMode.XPOLIT_DRIVE_MODE_NONE) {
                L.i(TAG, "onUpdateAccSpeed acc mode is not enabled!");
                this.mAccSpeedViewText.setVisibility(8);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                this.mAccSpeedViewText.setVisibility(8);
            } else {
                this.mAccSpeedViewText.setVisibility(0);
            }
            this.mAccSpeedViewText.setText(str);
        }
    }

    private void updateMapRenderModeVisibility(@NonNull MapUIStatus mapUIStatus) {
        if (!this.mIs3DCrossShow && !this.mPresenter.isPreview()) {
            if (this.mPresenter.isLaneViewShow()) {
                mapUIStatus.mMapRenderModeVisibility = 8;
                return;
            } else {
                mapUIStatus.mMapRenderModeVisibility = 0;
                return;
            }
        }
        mapUIStatus.mMapRenderModeVisibility = 8;
    }

    private void updateScaleVisibility(@NonNull MapUIStatus mapUIStatus) {
        if (this.mIs3DCrossShow || this.mPresenter.isLaneViewShow()) {
            mapUIStatus.mScaleVisibility = 8;
        } else {
            mapUIStatus.mScaleVisibility = 0;
        }
    }

    private void updateViewsForSRMode() {
        LaneInfoView laneInfoView;
        if (isPoiCardShowing()) {
            getMainContext().getDecoratorManager().clearFocus(this);
        }
        if (Utils.isPortrait() && (laneInfoView = this.mLanesLayout) != null) {
            laneInfoView.hideLaneInfoView();
        }
        hideCrossUI();
        MapUIStatus uIStatus = getUIStatus();
        updateMapRenderModeVisibility(uIStatus);
        uIStatus.mScaleVisibility = 8;
        updateUIStatus(uIStatus);
        this.mPresenter.updateSRTrafficView(TBTManager.getInstance().getSRTrafficEventType());
        RecommendParkView recommendParkView = this.mRecommendParkView;
        if (recommendParkView != null) {
            recommendParkView.setCanExpandOnShow(false);
            if (this.mRecommendParkView.isExpand()) {
                this.mRecommendParkView.collapse();
            }
        }
        hideContinueNavi();
        this.mPresenter.setStateModeAndTimeByMapMode();
        if (StateManager.getInstance().getState() == 1) {
            SRNaviManager.getInstance().updateDynamicViewAngle(true);
        } else {
            StateManager.getInstance().switchImmersionState();
        }
        updateSRLevel();
        this.mPresenter.refreshSpeedInfo();
        updateSRViewAngleVuiState(true);
    }

    private void updateViewsForSDMode() {
        this.mPresenter.updateLaneView();
        onHideTrafficPanel();
        RecommendParkView recommendParkView = this.mRecommendParkView;
        if (recommendParkView != null) {
            recommendParkView.setCanExpandOnShow(true);
        }
        MapUIStatus uIStatus = getUIStatus();
        updateMapRenderModeVisibility(uIStatus);
        uIStatus.mScaleVisibility = 0;
        updateUIStatus(uIStatus);
        this.mPresenter.setStateModeAndTimeByMapMode();
        hideContinueNavi();
        if (StateManager.getInstance().getState() == 1) {
            if (this.mPresenter.getCurrentMode() != 1) {
                getMapView().goBackCenter(true, true, false);
            }
            this.mPresenter.enableDynamicLevel();
        } else {
            this.mPresenter.disableDynamicLevel();
            StateManager.getInstance().switchImmersionState();
        }
        if (Utils.isLandscape()) {
            this.mAccSpeedViewText.setVisibility(8);
            this.mLimitSpeedViewText.setVisibility(8);
        }
        updateSRViewAngleVuiState(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onSRNaviShow() {
        if (isSceneLegal()) {
            refreshNgpPanelView();
            if (this.mPresenter.isPreview()) {
                this.mPresenter.exitOverviewMode();
            }
            getMapView().switchToLane(ThemeWatcherUtil.getMapModeByCurrentTheme());
            updateViewsForSRMode();
        }
    }

    private void updateSRLevel() {
        if (TBTManager.getInstance().isSRLevel()) {
            if (this.mSRLevelView == null) {
                this.mSRLevelView = this.mSRLevelStub.inflate();
                this.mSRLevelMode = (Button) this.mSRLevelView.findViewById(R.id.tv_sr_level_mode);
                this.mSRLevelMode.setOnClickListener(this);
                this.mSRDynamicLevelMode = (Button) this.mSRLevelView.findViewById(R.id.tv_sr_dynamic_level_mode);
                this.mSRDynamicLevelMode.setOnClickListener(this);
                this.mSRLevelView.findViewById(R.id.btn_sr_level_up).setOnClickListener(this);
                this.mSRLevelValue = (Button) this.mSRLevelView.findViewById(R.id.btn_sr_level_value);
                this.mSRLevelValue.setOnClickListener(this);
                this.mSRLevelView.findViewById(R.id.btn_sr_level_down).setOnClickListener(this);
            }
            setDynamicLevelModeText();
            this.mSRLevelView.setVisibility(0);
            return;
        }
        View view = this.mSRLevelView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void setDynamicLevelModeText() {
        int sRDynamicLevelMode = this.mPresenter.getSRDynamicLevelMode();
        if (sRDynamicLevelMode == 0) {
            this.mSRLevelMode.setText(getString(R.string.button_speed_mode));
            this.mSRDynamicLevelMode.setText("low");
            this.mSRLevelValue.setText(Utils.floatToString(SRNaviManager.getInstance().getCurrentLowSpeedLevel()));
        } else if (sRDynamicLevelMode == 1) {
            this.mSRLevelMode.setText(getString(R.string.button_speed_mode));
            this.mSRDynamicLevelMode.setText("high");
            this.mSRLevelValue.setText(Utils.floatToString(SRNaviManager.getInstance().getCurrentHighSpeedLevel()));
        } else if (sRDynamicLevelMode == 2) {
            this.mSRLevelMode.setText(getString(R.string.button_anchor_mode));
            this.mSRDynamicLevelMode.setText("in");
            this.mSRLevelValue.setText(Utils.floatToString(SRNaviManager.getInstance().getCurrentAnchorInLevel()));
        } else if (sRDynamicLevelMode != 3) {
        } else {
            this.mSRLevelMode.setText(getString(R.string.button_anchor_mode));
            this.mSRDynamicLevelMode.setText("out");
            this.mSRLevelValue.setText(Utils.floatToString(SRNaviManager.getInstance().getCurrentAnchorOutLevel()));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onSRNaviHide() {
        if (isSceneLegal()) {
            refreshNgpPanelView();
            if (getMapView().isLaneMode()) {
                getMapView().switchToSD(ThemeWatcherUtil.getMapModeByCurrentTheme());
                updateViewsForSDMode();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onShowTrafficPanel(int i) {
        if (isSceneLegal() && this.mPresenter.isLaneViewShow() && this.mTrafficPanel != null) {
            this.mTrafficPanelIcon.setImageDrawable(ThemeWatcherUtil.getDrawable(1 == i ? R.drawable.vector_ic_traffic_accident : R.drawable.vector_ic_traffic_construction));
            this.mTrafficPanelText.setText(1 == i ? R.string.srnavi_traffic_event_accident : R.string.srnavi_traffic_event_construction);
            this.mTrafficPanel.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onHideTrafficPanel() {
        XRelativeLayout xRelativeLayout = this.mTrafficPanel;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpLcTips(boolean z, int i, int i2, int i3, int i4, boolean z2, boolean z3) {
        XpNgpPanelView xpNgpPanelView;
        if (isSceneLegal() && (xpNgpPanelView = this.mXpNgpPanelView) != null) {
            xpNgpPanelView.updateNgpLcTips(i, i4, z2, i3 != -1 ? ThemeWatcherUtil.getDrawable(i3) : null, getTipsText());
            this.mXpNgpPanelView.updateNgpOperateBtnStatus(SRUtil.isShowOperateStatusByTipsStatus(i4));
            this.mXpNgpPanelView.updateLcTipsArrow(i3, z3);
        }
    }

    private String getTipsText() {
        String str;
        int scuNgpLcTips1Status = SRNaviManager.getInstance().getScuNgpLcTips1Status();
        int i = scuNgpLcTips1Status - 1;
        if (scuNgpLcTips1Status > 0) {
            CharSequence[] charSequenceArr = this.mNgpLcTips;
            if (i < charSequenceArr.length) {
                str = String.valueOf(charSequenceArr[i]);
                int scuQuitNgpOddStatus = SRNaviManager.getInstance().getScuQuitNgpOddStatus();
                return TextUtils.isEmpty(str) ? str : str;
            }
        }
        str = SRUtil.isLccStatus(SRNaviManager.getInstance().getDriveMode()) ? this.mNgpLccText : "";
        int scuQuitNgpOddStatus2 = SRNaviManager.getInstance().getScuQuitNgpOddStatus();
        return TextUtils.isEmpty(str) ? str : str;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpLcTipsByDriveMode(int i, int i2, boolean z, int i3) {
        XpNgpPanelView xpNgpPanelView;
        if (isSceneLegal() && (xpNgpPanelView = this.mXpNgpPanelView) != null) {
            xpNgpPanelView.updateNgpLcTips(i, i3, false, i2 != -1 ? ThemeWatcherUtil.getDrawable(i2) : null, this.mNgpLccText);
            this.mXpNgpPanelView.updateNgpOperateBtnStatus(true);
            this.mXpNgpPanelView.updateLcTipsArrow(i2, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView, com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpLcTipsProgress(boolean z, long j, int i, boolean z2) {
        if (!isSceneLegal()) {
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpQuitTips(boolean z, int i, int i2, int i3) {
        XpNgpPanelView xpNgpPanelView;
        if (isSceneLegal() && (xpNgpPanelView = this.mXpNgpPanelView) != null && z && i3 < this.mNgpQuitTips.length) {
            xpNgpPanelView.updateNgpLcTips(0, SRNaviManager.getInstance().getScuNgpLcTips1Status(), SRUtil.isNgpPanelNeedAnimatorByQuitNgpOddStatus(i2), ThemeWatcherUtil.getDrawable(SRUtil.getPanelIconByNgpOddStatus(i2)), String.valueOf(this.mNgpQuitTips[i3]));
            this.mXpNgpPanelView.updateNgpOperateBtnStatus(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateNgpOperateStatus(boolean z, int i, int i2, boolean z2) {
        XpNgpPanelView xpNgpPanelView;
        String str;
        if (isSceneResumed() && (xpNgpPanelView = this.mXpNgpPanelView) != null) {
            if (z) {
                CharSequence[] charSequenceArr = this.mNgpOperates;
                if (i2 < charSequenceArr.length) {
                    str = String.valueOf(charSequenceArr[i2]);
                    xpNgpPanelView.updateNgpOperateTips(i, str);
                }
            }
            str = "";
            xpNgpPanelView.updateNgpOperateTips(i, str);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateTakeOverWeakStatus(boolean z) {
        if (z) {
            getMainContext().startTakeOverWeakAnim();
        } else {
            getMainContext().stopTakeOverWeakAnim();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void refreshNgpPanelView() {
        XpNgpPanelView xpNgpPanelView = this.mXpNgpPanelView;
        if (xpNgpPanelView != null) {
            if (this.mIs2DCrossShow) {
                xpNgpPanelView.setVisibility(8);
                this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_NGP);
            } else if (SRUtil.isNgpPanelShow()) {
                if (this.mIs3DCrossShow) {
                    this.mPresenter.exitCross3D();
                    this.mIs3DCrossShow = false;
                } else if (this.mXpNgpPanelView.getVisibility() == 0 || !this.mRelationshipHelper.canElementShow(UIRelationshipConfig.ELEMENT_NGP)) {
                } else {
                    this.mXpNgpPanelView.setVisibility(0);
                    this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_NGP);
                }
            } else if (8 != this.mXpNgpPanelView.getVisibility()) {
                this.mXpNgpPanelView.setVisibility(8);
                this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_NGP);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public boolean isShowRecommendPark() {
        RecommendParkView recommendParkView;
        return isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null && recommendParkView.getVisibility() == 0;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public boolean isExpandRecommendParking() {
        RecommendParkView recommendParkView;
        return isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null && recommendParkView.isExpand();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public boolean isShowContinueNavi() {
        return isSceneLegal() && this.mTvContinuNavi.getVisibility() == 0;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void closeRecommendPark() {
        RecommendParkingHelper recommendParkingHelper;
        if (isSceneLegal() && this.mRecommendParkView != null && (recommendParkingHelper = TBTManager.getInstance().getRecommendParkingHelper()) != null && recommendParkingHelper.isShowRecommendRark()) {
            this.mRecommendParkView.collapseView();
            updateLaneAvailableArea(true);
            this.mRelationshipHelper.notifyElementUpdate(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
            this.mPresenter.restoreMapState();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public boolean canShowElement(@UIRelationshipConfig.UIElementDef String str) {
        return this.mRelationshipHelper.canElementShow(str);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onShowRecommendParking(List<XPPoiInfo> list, final boolean z) {
        RecommendParkView recommendParkView;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || !isSceneLegal()) {
            return;
        }
        if (this.mRecommendParkView == null) {
            this.mRecommendParkView = (RecommendParkView) ((ViewStub) this.mRootView.findViewById(R.id.guide_recommend_park_stub)).inflate();
            this.mRecommendParkView.setListener(this);
            if (this.mPresenter.isLaneViewShow()) {
                this.mRecommendParkView.setCanExpandOnShow(false);
            }
            if (Utils.isLandscape() && (recommendParkView = this.mRecommendParkView) != null) {
                this.mLeftViews.add(Integer.valueOf(recommendParkView.getId()));
            }
        }
        DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_SHOW, new Object[0]);
        SceneAnimHelper.getShowAnim(this, new AnimBuilder() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.8
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                view.setAlpha(0.0f);
                view.setTranslationY(160.0f);
                if (z || !NaviFragment.this.mRelationshipHelper.canElementShow(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK)) {
                    view.setVisibility(4);
                    NaviFragment.this.mRelationshipHelper.notifyElementNeedRestore(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
                } else {
                    view.setVisibility(0);
                    NaviFragment.this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.setClipChildren(false);
                    }
                }
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.setInterpolator(new AccelerateDecelerateInterpolator()).alpha(1.0f).translationY(0.0f).setDuration(400L);
            }
        }).start(this.mRecommendParkView);
        this.mRecommendParkView.onShow(list, z);
        updateRecommendParkVui();
        if (Utils.isPortrait()) {
            this.mRelationshipHelper.notifyElementUpdate(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onHideRecommendParking() {
        if (isSceneLegal()) {
            hideRecommendPark();
            this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
        }
    }

    @UIAction(methodType = 1, name = UIRelationshipConfig.ELEMENT_RECOMMEND_PARK)
    private void restoreRecommendParking() {
        RecommendParkView recommendParkView;
        if (TBTManager.getInstance().getRecommendParkingHelper() == null || !TBTManager.getInstance().getRecommendParkingHelper().isShowRecommendRark() || (recommendParkView = this.mRecommendParkView) == null) {
            return;
        }
        recommendParkView.setVisibility(0);
        updateRecommendParkVui();
        if (this.mRecommendParkView.isExpand()) {
            this.mRecommendParkView.resetCollapseRecommendTiming();
        }
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_RECOMMEND_PARK)
    private void hideRecommendPark() {
        RecommendParkView recommendParkView = this.mRecommendParkView;
        if (recommendParkView == null || recommendParkView.getVisibility() != 0) {
            return;
        }
        this.mRecommendParkView.onHide();
        updateRecommendParkVui();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UIAction(name = UIRelationshipConfig.ELEMENT_RECOMMEND_PARK)
    public void updateRecommendParkLayout() {
        RecommendParkView recommendParkView;
        if (Utils.isLandscape()) {
            return;
        }
        if (this.mIs2DCrossShow && (recommendParkView = this.mRecommendParkView) != null && recommendParkView.getVisibility() == 0 && this.mRecommendParkView.isExpand()) {
            this.mRecommendParkView.collapse();
        }
        updateRightViewLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRightViewLayout() {
        XLinearLayout xLinearLayout;
        if (Utils.isLandscape() || (xLinearLayout = this.mRightViewContainer) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) xLinearLayout.getLayoutParams();
        LaneInfoView laneInfoView = this.mLanesLayout;
        if (laneInfoView != null && laneInfoView.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.guide_lanes_layout);
        } else if (this.mIs2DCrossShow) {
            layoutParams.addRule(3, R.id.guide_cross_layout);
        } else {
            OfflinePopView offlinePopView = this.mOfflineView;
            if (offlinePopView != null && offlinePopView.getVisibility() == 0) {
                layoutParams.addRule(3, this.mOfflineView.getId());
            } else {
                layoutParams.addRule(3, R.id.guide_navi_info);
            }
        }
        this.mRightViewContainer.setLayoutParams(layoutParams);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onSelectRecommendParking(int i, boolean z) {
        RecommendParkView recommendParkView;
        if (isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null) {
            recommendParkView.expand();
            this.mRecommendParkView.setRecommendParkingContent(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    @MainThread
    public void onClickBlank(long j, float f, float f2) {
        super.onClickBlank(j, f, f2);
        closeRecommendPark();
        hideRouteChargePanelView(true);
        clearOverlayElemAllFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene
    public void clearOverlayElemAllFocus() {
        super.clearOverlayElemAllFocus();
        getMapView().getBizControlManager().clearFocus(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6022L);
        getMapView().getBizControlManager().clearFocus(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6021L);
        getMapView().getBizControlManager().clearFocus(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6020L);
        getMapView().getBizControlManager().clearFocus(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6012L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onIpcMessageEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        handleMessageEvent(ipcMessageEvent.getMsgID());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onIpcMessageEvent(IpcRouterUtil.IpcRouterEvent ipcRouterEvent) {
        handleMessageEvent(ipcRouterEvent.getMsgID());
    }

    private void handleMessageEvent(int i) {
        RecommendParkView recommendParkView;
        if (i != 11014 || TBTManager.getInstance().getRecommendParkingHelper() == null || !TBTManager.getInstance().getRecommendParkingHelper().isShowRecommendRark() || (recommendParkView = this.mRecommendParkView) == null || recommendParkView.getVisibility() == 0) {
            return;
        }
        this.mRecommendParkView.collapse();
        if (this.mIs2DCrossShow) {
            return;
        }
        updateRecommendParkVui();
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendParkView.RecommendParkViewListener
    public void onExpand() {
        checkMapviewMode3D();
        this.mPresenter.switchToSDForShowView();
        getMapView().setRestoreMapState(1);
        this.mPresenter.setRecommendParkZoomLevel(true);
        updateLaneAvailableArea(true);
        updateRecommendParkVui();
        this.mRelationshipHelper.notifyElementUpdate(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendParkView.RecommendParkViewListener
    public void onCollapse() {
        if (this.mPresenter.getCurrentMode() != 1) {
            getMapView().goBackCenterAndRestoreCarPosition(true);
        }
        this.mPresenter.enableDynamicLevel();
        updateLaneAvailableArea(true);
        updateRecommendParkVui();
        this.mRelationshipHelper.notifyElementUpdate(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK);
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendParkView.RecommendParkViewListener
    public void onSelectPopItem(int i) {
        checkMapviewMode3D();
        this.mPresenter.showRecommendParkingFocus(i);
        FragmentActivity activity = getActivity();
        if (!isSceneLegal() || activity == null) {
            return;
        }
        this.mPresenter.checkMoveParkItem(i, NaviUtil.getNaviRouteOverviewOffsetLeft(activity), NaviUtil.getNaviRouteOverviewOffsetTop(activity), getMapView().getMapWidth() - NaviUtil.getNaviRouteOverviewOffsetRight(activity), getMapView().getMapHeight() - NaviUtil.getNaviRouteOverviewOffsetBottom(activity));
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendParkView.RecommendParkViewListener
    public void onSwitchRouteToPark(XPPoiInfo xPPoiInfo) {
        this.mPresenter.requestRouteToRecommendParking(xPPoiInfo);
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendParkView.RecommendParkViewListener
    public void onRecommendParkShow() {
        if (L.ENABLE) {
            L.d(TAG, "hide pop card when recommend park pop");
        }
        updateRecommendParkVui();
        hideSceneTrafficEventPop();
        getMainContext().getDecoratorManager().clearFocus(this);
        updateLaneAvailableArea(true);
        updateRecommendParkLayout();
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendParkView.RecommendParkViewListener
    public void onRecommendParkHide() {
        updateRecommendParkVui();
        updateLaneAvailableArea(true);
        this.mPresenter.restoreMapState();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onChildSceneRemoved(IScene iScene) {
        super.onChildSceneRemoved(iScene);
        if ((iScene instanceof SearchFragment) && !hasChildScene() && iScene.getResultBundle() == null) {
            L.i(TAG, "onChildSceneRemoved  check can enter sr");
            this.mPresenter.restoreMapState();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        if (100 == i && bundle != null) {
            this.mSearchKeyword = bundle.getString(SearchBridge.SEARCH_KEYWORD_TEXT);
            RouteRequest routeRequest = (RouteRequest) bundle.getParcelable(RouteBridge.ROUTE_REQUEST);
            if (routeRequest != null) {
                this.mPresenter.requestReroute(routeRequest, 0);
            } else {
                this.mPresenter.restoreMapState();
            }
        }
        RestrictHelper restrictHelper = this.mRestrictHelper;
        if (restrictHelper != null) {
            restrictHelper.onBackResult(i, bundle);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void refreshMapStatus() {
        if (isSceneLegal()) {
            this.mMapStatus.mMapLevel = getMapView().getMapLevel();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void checkMapviewMode3D() {
        if (isSceneLegal() && this.mIs3DCrossShow) {
            this.mPresenter.exitCross3D();
            this.mIs3DCrossShow = false;
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_OUTSTATE_HAS_MOTION_EVENT, this.mHasMotionEvent);
        return true;
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
    @MainThread
    public void onShowChargeViaDetail(XPViaPoint xPViaPoint, int i) {
        if (!isSceneLegal() || xPViaPoint == null || xPViaPoint.getPoiPoint() == null || getRouteChargePanelView() == null) {
            return;
        }
        XPPoiInfo poiPoint = xPViaPoint.getPoiPoint();
        this.mRouteChargePanelView.setVisibility(0);
        this.mRouteChargePanelView.showDetail(poiPoint.getPoiId(), poiPoint.getName(), poiPoint.getDisplayLat(), poiPoint.getDisplayLon(), i, xPViaPoint.getIsPassedVia());
        if (Utils.isPortrait()) {
            ((RelativeLayout.LayoutParams) this.mRouteChargePanelView.getLayoutParams()).topMargin = getCurrentFreeBound().top + getResources().getDimensionPixelSize(R.dimen.scene_margin);
            this.mRouteChargePanelView.bringToFront();
        }
        this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_RECOMMEND_CHARGE);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onShowRoute(IPathResult iPathResult, int i) {
        getMainContext().addRoutePointsOverlay(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onSceneMapFragmentResult(int i, Bundle bundle) {
        if (bundle == null || 200 != i) {
            return;
        }
        boolean z = bundle.getBoolean(SettingPreferencePresenter.ROUTE_CHANGE_TYPE);
        boolean z2 = bundle.getBoolean(SettingPreferencePresenter.ALTERNATE_ROUTE_CHANGE_TYPE);
        if (z) {
            this.mPresenter.requestReroute(3, 1, true);
        }
        if (z2 && TBTManager.getInstance().getCurrentStatus() == 1) {
            this.mPresenter.updateTBTAndRoute(false, TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
        }
        if (bundle.getBoolean(SettingPreferencePresenter.OVERVIEW_CHANGE_TYPE)) {
            boolean isEagleEyeEnable = isEagleEyeEnable();
            this.mPresenter.updateOverViewState(isEagleEyeEnable, isEagleEyeEnable);
        }
        if (Utils.isLandscape()) {
            setGuideExitNaviVisibility();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickOverView() {
        this.mPresenter.switchOverView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public boolean onClickRecenter() {
        if (isSceneLegal()) {
            if (this.mPresenter.isPreview()) {
                this.mPresenter.exitOverviewMode();
            }
            getMapView().goBackCenterAndRestoreCarPosition(true);
            hideContinueNavi();
            return true;
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public boolean onClickSRNaviMode() {
        return this.mPresenter.switchNaviMode(true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void openFavourite() {
        L.i(TAG, "open search with over mode for open favorite");
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.KEY_START_FROM, 1);
        bundle.putInt(SearchBridge.SEARCH_MODE, 102);
        bundle.putInt(SearchBridge.FROM_SCENE_INDEX, getSceneStackSize());
        bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, getChildStackSize());
        bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, this.mSearchKeyword);
        bundle.putInt(SearchBridge.ANIM_TYPE, 0);
        bundle.putInt(SearchBridge.SUB_CONTAINER_TYPE, 1);
        XLinearLayout xLinearLayout = this.mBtnAddWaypoint;
        if (xLinearLayout != null) {
            bundle.putInt(SearchBridge.ANIM_START_Y, xLinearLayout.getTop());
            bundle.putInt(SearchBridge.ANIM_START_H, this.mBtnAddWaypoint.getHeight());
        }
        startScene(new SearchBridge().enableOverMode().setBundle(bundle), 100);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void saveCurrentRequestingId(long j) {
        saveHoldLong("NaviFragment_requestId", j);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public long getCurrentRequestingId() {
        return getHoldLong("NaviFragment_requestId", -1L);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void hideMapDecorators() {
        getMainContext().getDecoratorManager().clearFocus(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void setBackMapStatusByRequestCodeDelegate(MapStatus mapStatus, int i) {
        int savedMapMode = MapUtil.getSavedMapMode(false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, getClass().getSimpleName() + " get cruise saved map status :" + savedMapMode);
        }
        mapStatus.mMapMode = savedMapMode;
        if (!(StateManager.getInstance().getState() != 0)) {
            Coord2DDouble lonLatFromCenter = getMapView().getLonLatFromCenter();
            if (lonLatFromCenter != null) {
                mapStatus.mMapCenterLon = lonLatFromCenter.lon;
                mapStatus.mMapCenterLat = lonLatFromCenter.lat;
            }
            mapStatus.mMapCenterLeft = getMapView().getMapViewLeft();
            mapStatus.mMapCenterTop = getMapView().getMapViewTop();
            mapStatus.mFollowMode = getMapView().isFollowMode() ? 1 : 0;
            mapStatus.mMapLevel = getMapView().getMapLevel();
            return;
        }
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            mapStatus.mMapCenterLat = currentLocation.mLat;
            mapStatus.mMapCenterLon = currentLocation.mLon;
        }
        mapStatus.mMapCenterLeft = (int) (RootUtil.getScreenWidth() * 0.5d);
        mapStatus.mMapCenterTop = getMapView().getMapViewTop();
        mapStatus.mFollowMode = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public MapStatus pickupRestoreMapStatusByRequestCodeDelegate(MapStatus mapStatus, @NonNull MapStatus mapStatus2, int i) {
        mapStatus2.setMapStatus(mapStatus);
        return mapStatus2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public RectInt getCurrentFreeBound() {
        int dimensionPixelSize;
        int bottom;
        int dimensionPixelSize2;
        RectInt rectInt = this.mFreeBound;
        if (Utils.isLandscape()) {
            bottom = this.mBtnAddWaypoint.getBottom();
            dimensionPixelSize2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_bg_margin);
        } else {
            XRelativeLayout xRelativeLayout = this.mNaviPanal;
            if (xRelativeLayout != null) {
                bottom = xRelativeLayout.getBottom();
                dimensionPixelSize2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_bg_margin);
            } else {
                dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.guide_panel_bottom_gap) + 0;
                rectInt.top = dimensionPixelSize;
                return this.mFreeBound;
            }
        }
        dimensionPixelSize = bottom - dimensionPixelSize2;
        rectInt.top = dimensionPixelSize;
        return this.mFreeBound;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiShow(PoiCardView poiCardView) {
        XPViaPoint xPViaPoint;
        super.onPoiShow(poiCardView);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "POP=> poiPop.getDecoratorType() = " + poiCardView.getDecoratorType());
        }
        this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_POI_CARD);
        if (poiCardView.getDecoratorType() == DecoratorType.WAY_POINT) {
            int currentExpandedIndex = poiCardView.getMapDecorator().getCurrentExpandedIndex();
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
            if (currentExpandedIndex > -1 && currentExpandedIndex < viaInfos.size() && (xPViaPoint = viaInfos.get(currentExpandedIndex)) != null && xPViaPoint.getViaType() == 4) {
                onShowChargeViaDetail(xPViaPoint, currentExpandedIndex);
                return;
            }
        }
        hideRouteChargePanelView(false);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiHide(PoiCardView poiCardView) {
        super.onPoiHide(poiCardView);
        clearOverlayElemAllFocus();
        this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_POI_CARD);
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_POI_CARD)
    public void hidePoiPop() {
        this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_POI_CARD);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView, com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onAsyncManeuverInfo(XPManeuverInfo xPManeuverInfo) {
        if (xPManeuverInfo != null) {
            this.mPresenter.asyncManeuverInfo(xPManeuverInfo);
        }
    }

    private void updateManeuverInfoWhenThemeSwitch() {
        NaviScenePresenter naviScenePresenter = this.mPresenter;
        if (naviScenePresenter != null) {
            naviScenePresenter.updateManeuverInfoWhenThemeSwitch();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void onShowRecommendRoutePop(String str, int i, String str2, String str3, SpannableString spannableString, IVariantPath iVariantPath, int i2, boolean z) {
        if (this.mRecommendRoutePop == null) {
            this.mRecommendRoutePop = (RecommendRoutePop) ((ViewStub) this.mRootView.findViewById(R.id.guide_recommend_route_pop_stub)).inflate();
        }
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        if (recommendRoutePop != null) {
            recommendRoutePop.setListener(mo96getPresenter().getRecommendRouteSwitchListener());
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

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.NAVI_GUIDANCE;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onShowOfflineRoutePanel(boolean z) {
        if (isSceneLegal()) {
            initOfflinePopView();
            if (this.mOfflineView != null) {
                if (this.mRelationshipHelper.canElementShow("offline")) {
                    if (Utils.isLandscape()) {
                        RestrictHelper restrictHelper = this.mRestrictHelper;
                        if (restrictHelper != null && restrictHelper.isRestrictedPopShow()) {
                            this.mOfflineViewRestore = true;
                        } else {
                            showOfflineView(z);
                        }
                    } else {
                        showOfflineView(z);
                    }
                    NaviStatUtil.sendStatDataForOfflineView(getPageType(), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation(), BtnType.ROUTE_OFFLINEVIEW_SHOW);
                    return;
                }
                this.mRelationshipHelper.notifyElementNeedRestore("offline");
            }
        }
    }

    private void showOfflineView(boolean z) {
        if (this.mOfflineView.getVisibility() == 0) {
            this.mOfflineView.reStartCountDown();
            return;
        }
        this.mOfflineView.show(z);
        this.mRelationshipHelper.notifyElementShow("offline");
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void onHideOfflineRoutePanel() {
        OfflinePopView offlinePopView;
        if (isSceneLegal() && (offlinePopView = this.mOfflineView) != null && offlinePopView.getVisibility() == 0) {
            this.mOfflineView.hide();
            this.mRelationshipHelper.notifyElementHide("offline");
            if (this.mOfflineView.isReRoute()) {
                showPrompt(getResources().getString(R.string.offline_pop_reroute_success_toast_text));
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public boolean isOfflineRoutePanelExpand() {
        OfflinePopView offlinePopView = this.mOfflineView;
        return offlinePopView != null && offlinePopView.getVisibility() == 0 && this.mOfflineView.isExpand();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void initOfflineRoutePanel(int i) {
        if (isSceneLegal() && i >= 0) {
            initOfflinePopView();
            if (i > 0) {
                this.mOfflineView.setRemainTime(i);
            }
            onShowOfflineRoutePanel(i > 0);
        }
    }

    @UIAction(methodType = 0, name = "offline")
    private void hideOfflineViewOnOtherElementShow() {
        OfflinePopView offlinePopView = this.mOfflineView;
        if (offlinePopView == null || !offlinePopView.isShown()) {
            return;
        }
        this.mOfflineView.hide(true);
    }

    @UIAction(methodType = 1, name = "offline")
    private void restoreOfflineView() {
        OfflinePopView offlinePopView = this.mOfflineView;
        if (offlinePopView != null) {
            offlinePopView.restoreShow();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void showRestrictedPop(int i, String str, String str2, ArrayList<XPGRestrictCity> arrayList, String str3, RestrictPopView.IRestrictPopActionListener iRestrictPopActionListener) {
        if (isSceneLegal()) {
            OfflinePopView offlinePopView = this.mOfflineView;
            if (offlinePopView != null && offlinePopView.getVisibility() == 0) {
                if (L.ENABLE) {
                    L.d(TAG, "ignore RestrictedPop after offline");
                }
            } else if (!this.mRelationshipHelper.canElementShow(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW)) {
                this.mRelationshipHelper.notifyElementNeedRestore(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
                this.mRestrictHelper.setRestrictInfoForUncomingPop(i, str, str2, arrayList, str3, iRestrictPopActionListener, false);
            } else {
                this.mRestrictHelper.showRestrictedPop(i, str, str2, arrayList, str3, iRestrictPopActionListener, false);
                this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
            }
        }
    }

    private void initOfflinePopView() {
        if (this.mOfflineView == null) {
            this.mOfflineView = (OfflinePopView) ((ViewStub) this.mRootView.findViewById(R.id.offline_popview_stub)).inflate();
            if (Utils.isLandscape()) {
                this.mOfflineView.setLandscapeParentView(this.mGuideContainer, this.mLeftGuidePanel);
            }
            this.mOfflineView.setActionListener(new OfflineListener());
            this.mOfflineView.setMainContext(getMainContext());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public RelativeLayout.LayoutParams getPopPos() {
        if (Utils.isLandscape()) {
            return this.mRestrictHelper.getDefaultPopPos();
        }
        RelativeLayout.LayoutParams defaultPopPos = this.mRestrictHelper.getDefaultPopPos();
        if (defaultPopPos != null) {
            defaultPopPos.addRule(3, R.id.guide_navi_info);
            RecommendParkView recommendParkView = this.mRecommendParkView;
            if (recommendParkView != null && recommendParkView.getVisibility() == 0 && !this.mRecommendParkView.isExpand()) {
                defaultPopPos.topMargin = getResources().getDimensionPixelSize(R.dimen.guide_restrict_margin_below_recommend_top);
            } else {
                defaultPopPos.topMargin = getResources().getDimensionPixelSize(R.dimen.guide_restrict_margin_top);
            }
            defaultPopPos.leftMargin = getResources().getDimensionPixelSize(R.dimen.guide_restrict_margin_left);
            defaultPopPos.rightMargin = getResources().getDimensionPixelSize(R.dimen.guide_restrict_margin_right);
        }
        return defaultPopPos;
    }

    private void updateViewOnLeftViewsCharged(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.scene_margin);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.scene_margin);
        int i = 0;
        for (Integer num : this.mLeftViews) {
            View findViewById = this.mRootView.findViewById(num.intValue());
            if (findViewById != null && findViewById.getVisibility() == 0) {
                i = Math.max(findViewById.getRight(), i);
            }
        }
        RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
        if (routeChargePanelView != null && routeChargePanelView.getVisibility() == 0) {
            i = Math.max(this.mRouteChargePanelView.getRight(), i);
        }
        if (this.mTrafficIncidentPop != null && this.mTrafficIncidentPop.getVisibility() == 0) {
            i = Math.max(this.mTrafficIncidentPop.getRight(), i);
        }
        int max = Math.max(i, getResources().getDimensionPixelSize(R.dimen.scene_margin));
        L.Tag tag = TAG;
        L.i(tag, "updateViewOnLeftViewsCharged leftMargin: " + max);
        if (max <= dimensionPixelSize2) {
            if (this.mBtnAddWaypoint.isShown()) {
                dimensionPixelSize += getResources().getDimensionPixelSize(R.dimen.guide_add_waypoint_height) - getResources().getDimensionPixelSize(R.dimen.shadow_margin);
            }
            XpNgpPanelView xpNgpPanelView = this.mXpNgpPanelView;
            if (xpNgpPanelView != null && xpNgpPanelView.getVisibility() == 0) {
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "updateViewOnLeftViewsCharged ngppanel height = " + this.mXpNgpPanelView.getHeight());
                }
                dimensionPixelSize += this.mXpNgpPanelView.getHeight() + getResources().getDimensionPixelSize(R.dimen.shadow_margin);
            }
        } else {
            max += getResources().getDimensionPixelSize(R.dimen.guide_offline_left_margin);
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.leftMargin = max;
        }
        L.Tag tag3 = TAG;
        L.i(tag3, "topMargin: " + dimensionPixelSize + ", leftMargin: " + max);
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void hideRestrictedPop() {
        this.mRestrictHelper.hideRestrictedPop();
        this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW);
        if (this.mOfflineViewRestore) {
            this.mOfflineViewRestore = false;
            onShowOfflineRoutePanel(true);
        }
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_RESTRICT_VIEW)
    public void hideRestrictedPopOnOtherElementShow() {
        if (this.mRelationshipHelper != null) {
            this.mRestrictHelper.hideRestrictedPop(true);
            if (this.mOfflineViewRestore) {
                this.mOfflineViewRestore = false;
                onShowOfflineRoutePanel(true);
            }
        }
    }

    @UIAction(methodType = 1, name = UIRelationshipConfig.ELEMENT_RESTRICT_VIEW)
    private void restoreRestrictedPopOnOtherElementHide() {
        if (this.mRelationshipHelper != null) {
            this.mRestrictHelper.restoreShowRestrictPop();
        }
    }

    @UIAction(name = UIRelationshipConfig.ELEMENT_RESTRICT_VIEW)
    public void updateRestrictPopLayout() {
        RestrictHelper restrictHelper;
        if (isSceneLegal() && (restrictHelper = this.mRestrictHelper) != null && restrictHelper.isRestrictedPopShow()) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    if (NaviFragment.this.isSceneLegal()) {
                        NaviFragment.this.mRestrictHelper.updatePopLayout();
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public BaseScene getSceneForRestrict() {
        return getScene();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void requestRestrictReroute() {
        this.mPresenter.requestReroute(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public RestrictHelper getRestrictHelper() {
        return this.mRestrictHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        renderLayoutByDayNightStatus(true);
    }

    private void renderLayoutByDayNightStatus(boolean z) {
        if (z) {
            if (this.mGuideExitNavi != null) {
                if (Utils.isLandscape()) {
                    this.mGuideExitNavi.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_guide_suggest_cameras));
                } else {
                    this.mGuideExitNavi.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_exit_guide));
                }
                this.mGuideExitNavi.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
                this.mGuideExitNavi.setIcon(ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_small_quit));
            }
            this.mTrafficBar.updatePassedAndBasicColor(ThemeWatcherUtil.getColor(R.color.traffic_passed), ThemeWatcherUtil.getColor(R.color.traffic_none_info));
            RecommendParkView recommendParkView = this.mRecommendParkView;
            if (recommendParkView != null) {
                recommendParkView.updateTheme();
            }
            this.mTvContinuNavi.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.drawable_padding20_radius10_ripple10));
        }
        MixedTextView mixedTextView = this.mPowerStatus;
        if (mixedTextView != null) {
            mixedTextView.updateTheme();
        }
        onUpdateIntervalCameraDynamicInfo(TBTManager.getInstance().getNaviIntervalDynamicCameras());
        updateManeuverInfoWhenThemeSwitch();
        SapaContainerView sapaContainerView = this.mSapaContainer;
        if (sapaContainerView != null && sapaContainerView.getChildCount() > 0 && this.mSapaContainer.getVisibility() == 0) {
            for (int i = 0; i < this.mSapaContainer.getChildCount(); i++) {
                SapaTollView sapaTollView = (SapaTollView) this.mSapaContainer.getChildAt(i);
                if (sapaTollView != null && sapaTollView.getVisibility() == 0) {
                    sapaTollView.updateTheme();
                }
            }
        }
        if (Utils.isPortrait()) {
            if (this.mResId != 0) {
                if (this.mNextTurnIcon.getVisibility() == 0) {
                    this.mNextTurnIcon.setImageDrawable(ThemeWatcherUtil.getDrawable(this.mResId));
                }
                if (this.mNextTurnIconSpe.getVisibility() == 0) {
                    this.mNextTurnIconSpe.setImageDrawable(ThemeWatcherUtil.getDrawable(this.mResId));
                }
            }
            this.mTvCurrentRoad.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text01));
        }
        XPCrossImageInfo naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo();
        if (naviCrossImageInfo != null) {
            if ((3 == naviCrossImageInfo.mType && z) || 4 == naviCrossImageInfo.mType) {
                onHideCrossImage(naviCrossImageInfo.mType);
                onShowCrossImage(naviCrossImageInfo);
            }
        } else {
            ViewGroup viewGroup = this.mCrossLayout;
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                updateViewsOnCross2DVisibilityChange(false);
            }
        }
        this.mPresenter.updateNgpPanelInfo();
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
        this.mRoutingDialog.setMessage(ContextUtils.getString(z ? R.string.route_offline_routing : R.string.route_routing));
        this.mRoutingDialog.show();
        this.mRoutingDialog.correctedLocation();
        exchangeEagleEyeView(false, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void onHideRouting() {
        L.i(TAG, ">>> hideRouting");
        XLandLoadingDialog xLandLoadingDialog = this.mRoutingDialog;
        if (xLandLoadingDialog != null) {
            xLandLoadingDialog.dismiss();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void sendStatDataWhenSystemStartNavi(MainContext mainContext, XPPoiInfo xPPoiInfo, XPCoordinate2DDouble xPCoordinate2DDouble, XPPoiInfo xPPoiInfo2, boolean z, RouteParams routeParams) {
        NaviStatUtil.sendStatDataWhenSystemStartNavi(getActivity(), getMainContext(), routeParams.mStartInfo, xPCoordinate2DDouble, xPPoiInfo2, z, routeParams);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void showNavTrafficEventPop(TrafficEventPopParam trafficEventPopParam) {
        BaseScene currentScene = getCurrentScene();
        if (!(currentScene instanceof BaseMapScene) || Utils.isRestrictScene(currentScene)) {
            return;
        }
        ((BaseMapScene) currentScene).showSceneTrafficEventPop(trafficEventPopParam);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopShow(View view, double d, double d2) {
        super.onTrafficEventPopShow(view, d, d2);
        this.mRelationshipHelper.notifyElementShow(UIRelationshipConfig.ELEMENT_TRAFFIC_EVENT);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopHide(View view) {
        super.onTrafficEventPopHide(view);
        this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_TRAFFIC_EVENT);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void showCrossIcon(Bitmap bitmap, XPCrossImageInfo xPCrossImageInfo) {
        XPCrossImageInfo naviCrossImageInfo = this.mPresenter.getNaviCrossImageInfo();
        if (naviCrossImageInfo == null || naviCrossImageInfo != xPCrossImageInfo) {
            L.i(TAG, ">>> showCrossIcon current cross was hided");
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        } else if (!isSceneLegal() || this.mPresenter.isLaneViewShow() || StateManager.getInstance().getState() == 0) {
            L.e(TAG, "showCrossIcon but is active state ");
        } else if (bitmap == null || bitmap.isRecycled()) {
        } else {
            this.mImCross.setImageBitmap(bitmap);
            this.mImCross.setVisibility(0);
            updateViewsOnCross2DVisibilityChange(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public void showTurnIcon(Bitmap bitmap) {
        if (!isSceneLegal() || Utils.isLandscape()) {
            return;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mTurnIcon.setImageBitmap(bitmap);
            this.mCrossTurnIcon.setImageBitmap(bitmap);
            Bitmap bitmap2 = this.mTurnIconBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.mTurnIconBitmap.recycle();
                this.mTurnIconBitmap = null;
            }
            this.mTurnIconBitmap = bitmap;
            return;
        }
        showXPTurnIcon();
    }

    private void showXPTurnIcon() {
        if (L.ENABLE) {
            L.d(TAG, ">>>  onObtainAsyncInfo decode fail,use the maneuerId");
        }
        updateTurnIcon(this.mPresenter.getNaviManeuerInfo());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    @MainThread
    public void onUpdateTrafficView(boolean z) {
        SapaContainerView sapaContainerView;
        if (!isSceneResumed() || this.mNaviTrafficbarContainer == null || this.mTrafficBar == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "onUpdateTrafficView showLightColumn:" + z + "  mIs2DCrossShow:" + this.mIs2DCrossShow);
        if (z) {
            XRelativeLayout xRelativeLayout = this.mNaviTrafficbarContainer;
            if (xRelativeLayout != null && xRelativeLayout.getVisibility() != 0) {
                this.mNaviTrafficbarContainer.setVisibility(0);
            }
            if (this.mTimeInfo != null && (sapaContainerView = this.mSapaContainer) != null && this.mPresenter != null) {
                if (sapaContainerView.getVisibility() == 0 && this.mPresenter.isHaveSAPA()) {
                    if (this.mTimeInfo.getVisibility() != 8) {
                        this.mTimeInfo.setVisibility(8);
                    }
                } else if (this.mTimeInfo.getVisibility() != 0) {
                    this.mTimeInfo.setVisibility(0);
                }
            }
            XTextView xTextView = this.mRemainDistance;
            if (xTextView != null && xTextView.getVisibility() != 0) {
                this.mRemainDistance.setVisibility(0);
            }
            TrafficBar trafficBar = this.mTrafficBar;
            if (trafficBar == null || trafficBar.getVisibility() == 0) {
                return;
            }
            this.mTrafficBar.setVisibility(0);
            return;
        }
        XRelativeLayout xRelativeLayout2 = this.mNaviTrafficbarContainer;
        if (xRelativeLayout2 != null && xRelativeLayout2.getVisibility() != 8) {
            this.mNaviTrafficbarContainer.setVisibility(8);
        }
        XTextView xTextView2 = this.mTimeInfo;
        if (xTextView2 != null && xTextView2.getVisibility() != 8) {
            this.mTimeInfo.setVisibility(8);
        }
        XTextView xTextView3 = this.mRemainDistance;
        if (xTextView3 != null && xTextView3.getVisibility() != 8) {
            this.mRemainDistance.setVisibility(8);
        }
        TrafficBar trafficBar2 = this.mTrafficBar;
        if (trafficBar2 == null || trafficBar2.getVisibility() == 8) {
            return;
        }
        this.mTrafficBar.setVisibility(8);
    }

    private boolean isEagleEyeShow() {
        return getMapView().getBizControlManager().isEagleEyeShowing();
    }

    @OnClick({R.id.navi_info_eagle_bg_mask})
    public void onClickEagleBgMask(View view) {
        if (preventMultiClick(view)) {
            this.mPresenter.switchOverView();
        }
    }

    @OnLongClick({R.id.navi_info_eagle_bg_mask})
    public boolean onLongTouchEagleBgMask(View view) {
        onClickEagleBgMask(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshEagleViewAfterResumeIfNotInit() {
        if (isEagleEyeEnable()) {
            if (!getMapView().getBizControlManager().isInitEagleye() && !getMapView().isDayNightSwitching()) {
                if (this.mRetryEagleInitCount > 0) {
                    exchangeEagleEyeView(true, true);
                }
                if (!getMapView().getBizControlManager().isInitEagleye() && !getMapView().isDayNightSwitching()) {
                    int i = this.mRetryEagleInitCount;
                    this.mRetryEagleInitCount = i + 1;
                    if (i < 3) {
                        runOnUiThreadDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.10
                            @Override // java.lang.Runnable
                            public void run() {
                                L.i(NaviFragment.TAG, "refreshEagleViewAfterResumeIfNotInit");
                                NaviFragment.this.refreshEagleViewAfterResumeIfNotInit();
                            }
                        }, 1000L);
                        return;
                    }
                    return;
                }
                this.mRetryEagleInitCount = 0;
                return;
            }
            this.mRetryEagleInitCount = 0;
        }
    }

    private void showContinueNavi() {
        boolean z = this.mTvContinuNavi.getVisibility() == 0;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showContinueNavi isPreview : " + mo96getPresenter().isPreview() + ", mHasMotionEvent : " + this.mHasMotionEvent + ", mIs3DCrossShow : " + this.mIs3DCrossShow + ", isContinueNaviShown : " + z);
        }
        if (mo96getPresenter().isPreview()) {
            return;
        }
        if ((!this.mHasMotionEvent && !this.mPresenter.isLaneViewShow()) || this.mIs3DCrossShow || z) {
            return;
        }
        this.mTvCurrentRoad.setVisibility(4);
        this.mTvContinuNavi.setVisibility(0);
        this.mTvContinuNavi.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NaviStatUtil.sendStatDataWhenContinueNavi(NaviFragment.this.getPageType(), NaviFragment.this.getMapView().getMapLevel(), NaviFragment.this.getMapView().getXPCarLocation());
                if (!NaviFragment.this.mPresenter.isLaneViewShow() && SettingWrapper.isDynamicLevelEnabled()) {
                    NaviFragment.this.getMapView().setMapLevel(17.0f);
                }
                NaviFragment.this.closeRecommendPark();
                StateManager.getInstance().switchImmersionState();
            }
        });
    }

    private void hideContinueNavi() {
        if (this.mTvCurrentRoad.length() > 0) {
            this.mTvCurrentRoad.setVisibility(0);
        }
        this.mTvContinuNavi.setVisibility(4);
    }

    private void updateCurrentRoadName(String str) {
        this.mTvCurrentRoad.setText(str);
        boolean z = this.mTvContinuNavi.getVisibility() == 0;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.i(tag, "updateCurrentRoadName roadName : " + str + ", isContinueNaviShown : " + z);
        }
        if (z) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.mTvCurrentRoad.setVisibility(4);
            this.mTvContinuNavi.setVisibility(4);
            return;
        }
        this.mTvCurrentRoad.setVisibility(0);
        this.mTvContinuNavi.setVisibility(4);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene
    protected void setTrafficEventLayerState() {
        getMapView().setTrafficEventLayerState(2);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    public void onUpdateRemainDis(long j, int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "onUpdateRemainDis pathId:" + j + ", routeRemainDis:" + i + ", remainDis:" + i2);
        if (isSceneResumed()) {
            this.mPresenter.updateSAPA();
            updateTimeArrive();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    public boolean isRecommendComparing() {
        RecommendRoutePop recommendRoutePop = this.mRecommendRoutePop;
        return recommendRoutePop != null && recommendRoutePop.getVisibility() == 0;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickZoomView(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>> onClickZoomView isZoomIn : " + z);
        }
        this.mHasMotionEvent = true;
        showContinueNavi();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void restoreMotionEventFlag() {
        this.mHasMotionEvent = false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public boolean isMapPoiLocked() {
        MainContext mainContext = getMainContext();
        if (mainContext == null) {
            return true;
        }
        return mainContext.isMapPoiLocked();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void naviTo1thRecommendPark(View view) {
        RecommendParkView recommendParkView;
        if (isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null) {
            recommendParkView.onClickRecommendPark1(view);
            this.mRecommendParkView.onClickRecommendPardSwitch(null);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void naviTo2thRecommendPark(View view) {
        RecommendParkView recommendParkView;
        if (isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null) {
            recommendParkView.onClickRecommendPark2(view);
            this.mRecommendParkView.onClickRecommendPardSwitch(null);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void naviTo3thRecommendPark(View view) {
        RecommendParkView recommendParkView;
        if (isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null) {
            recommendParkView.onClickRecommendPark3(view);
            this.mRecommendParkView.onClickRecommendPardSwitch(null);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void show1thRecommendParkDetail(View view) {
        RecommendParkView recommendParkView;
        if (isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null) {
            recommendParkView.onClickRecommendPark1(view);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void show2thRecommendParkDetail(View view) {
        RecommendParkView recommendParkView;
        if (isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null) {
            recommendParkView.onClickRecommendPark2(view);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void show3thRecommendParkDetail(View view) {
        RecommendParkView recommendParkView;
        if (isSceneLegal() && (recommendParkView = this.mRecommendParkView) != null) {
            recommendParkView.onClickRecommendPark3(view);
        }
    }

    @UIAction(methodType = 0, name = UIRelationshipConfig.ELEMENT_RECOMMEND_CHARGE)
    public void hideRouteChargePanelView() {
        realHideRouteChargePanelView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
    @MainThread
    public void hideRouteChargePanelView(boolean z) {
        if (realHideRouteChargePanelView()) {
            this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_RECOMMEND_CHARGE);
        }
    }

    private boolean realHideRouteChargePanelView() {
        RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
        if (routeChargePanelView == null || routeChargePanelView.getVisibility() == 8) {
            return false;
        }
        this.mRouteChargePanelView.setVisibility(8);
        this.mRelationshipHelper.notifyElementHide(UIRelationshipConfig.ELEMENT_RECOMMEND_CHARGE);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sr_level_down /* 2131296448 */:
                this.mPresenter.setLevelDown();
                setDynamicLevelModeText();
                return;
            case R.id.btn_sr_level_up /* 2131296449 */:
                this.mPresenter.setLevelUp();
                setDynamicLevelModeText();
                return;
            case R.id.btn_sr_level_value /* 2131296450 */:
                this.mPresenter.resetLevel();
                setDynamicLevelModeText();
                return;
            case R.id.guide_navi_info /* 2131296687 */:
                NaviScenePresenter naviScenePresenter = this.mPresenter;
                if (naviScenePresenter != null) {
                    naviScenePresenter.switchActiveState();
                    return;
                }
                return;
            case R.id.im_navi_info_turn /* 2131296724 */:
                NaviScenePresenter naviScenePresenter2 = this.mPresenter;
                if (naviScenePresenter2 != null) {
                    naviScenePresenter2.playNaviManual();
                    this.mPresenter.switchActiveState();
                    if (L.ENABLE) {
                        L.d(TAG, ">>> onClick turn icon playNaviManual");
                        return;
                    }
                    return;
                }
                return;
            case R.id.tv_sr_dynamic_level_mode /* 2131297579 */:
                this.mPresenter.changeDynamicLevelMode();
                setDynamicLevelModeText();
                return;
            case R.id.tv_sr_level_mode /* 2131297585 */:
                this.mPresenter.changeLevelMode();
                setDynamicLevelModeText();
                return;
            default:
                return;
        }
    }

    private void tightTurnView(boolean z) {
        if (z) {
            if (this.mIsExitDirectionShow) {
                this.mNextTurnIconSpe.setVisibility(this.mIs2DCrossShow ? 4 : 0);
                this.mDistanceToNextTurnSpe.setVisibility(this.mIs2DCrossShow ? 4 : 0);
                this.mNextTurnIcon.setVisibility(4);
                this.mDistanceToNextTurn.setVisibility(4);
                return;
            }
            this.mNextTurnIcon.setVisibility(this.mIs2DCrossShow ? 4 : 0);
            this.mDistanceToNextTurn.setVisibility(this.mIs2DCrossShow ? 4 : 0);
            this.mNextTurnIconSpe.setVisibility(4);
            this.mDistanceToNextTurnSpe.setVisibility(4);
            return;
        }
        this.mNextTurnIcon.setVisibility(4);
        this.mDistanceToNextTurn.setVisibility(4);
        this.mNextTurnIconSpe.setVisibility(4);
        this.mDistanceToNextTurnSpe.setVisibility(4);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onParallelRoadEvent(ParallelRoadEvent parallelRoadEvent) {
        if (parallelRoadEvent != null && Utils.isLandscape() && parallelRoadEvent.getType() == 0) {
            if (parallelRoadEvent.mLocParallelRoadInfo != null) {
                L.Tag tag = TAG;
                L.i(tag, ">>> onParallelRoadEvent flag = " + parallelRoadEvent.mLocParallelRoadInfo.flag + " status = " + parallelRoadEvent.mLocParallelRoadInfo.status);
                if (parallelRoadEvent.mLocParallelRoadInfo.flag == 0) {
                    updateCurrentRoadPos(this.mIsStateActive, false);
                    return;
                } else {
                    updateCurrentRoadPos(this.mIsStateActive, true);
                    return;
                }
            }
            updateCurrentRoadPos(this.mIsStateActive, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract.LogicView
    public void clearSRViewAngleBtnGroupCheck() {
        this.mSRViewAngleBtnGroup.clearCheck();
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
        VuiElement onInterceptFindTargetVuiElement = CommonNaviVuiHelper.onInterceptFindTargetVuiElement(view, vuiEvent, this, R.id.btn_recommend_park1, R.id.btn_recommend_park2, R.id.btn_recommend_park3);
        if (onInterceptFindTargetVuiElement != null) {
            CommonNaviVuiHelper.handleRecommendParkVuiAction(view, onInterceptFindTargetVuiElement, mo96getPresenter());
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
        if (CommonNaviVuiHelper.onVuiEventHandleRouteAlterLabel(view, vuiEvent, mo96getPresenter(), this)) {
            return;
        }
        super.onVuiEvent(view, vuiEvent);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onBuildScene() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        MainContext mainContext = getMainContext();
        ImageTextView imageTextView = this.mGuideExitNavi;
        commonVuiHelper.enableCanSpeechControl(mainContext, imageTextView, imageTextView, false);
        CommonVuiHelper commonVuiHelper2 = CommonVuiHelper.getInstance();
        MainContext mainContext2 = getMainContext();
        XLinearLayout xLinearLayout = this.mBtnAddWaypoint;
        commonVuiHelper2.enableCanSpeechControl(mainContext2, xLinearLayout, xLinearLayout, false);
        CommonVuiHelper commonVuiHelper3 = CommonVuiHelper.getInstance();
        MainContext mainContext3 = getMainContext();
        XFrameLayout xFrameLayout = this.mGuideBackTo2D;
        commonVuiHelper3.enableCanSpeechControl(mainContext3, xFrameLayout, xFrameLayout, false);
        super.onBuildScene();
    }

    private void updateRecommendParkVui() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            VoiceFullScenesUtil.updateScene(this, this.mRecommendParkView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class OfflineListener implements OfflinePopView.IOfflinePopActionListener {
        OfflineListener() {
        }

        @Override // com.xiaopeng.montecarlo.views.OfflinePopView.IOfflinePopActionListener
        public void reRoute() {
            NaviFragment.this.mPresenter.requestOnlineReroute();
        }

        @Override // com.xiaopeng.montecarlo.views.OfflinePopView.IOfflinePopActionListener
        public void onVisibleStateExchanged(boolean z) {
            if (L.ENABLE) {
                L.Tag tag = NaviFragment.TAG;
                L.d(tag, "onVisibleStateExchanged isShow:" + z);
            }
            if (NaviFragment.this.isSceneVuiEnabled()) {
                NaviFragment naviFragment = NaviFragment.this;
                VoiceFullScenesUtil.updateScene(naviFragment, naviFragment.mOfflineView);
            }
            NaviFragment.this.updateRightViewLayout();
        }
    }
}
