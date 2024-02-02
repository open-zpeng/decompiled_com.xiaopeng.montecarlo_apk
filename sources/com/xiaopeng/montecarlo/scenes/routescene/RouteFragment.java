package com.xiaopeng.montecarlo.scenes.routescene;

import android.animation.Animator;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.common.path.model.AvoidTrafficJamInfo;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bridge.ExploreBridge;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SettingBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.CountDownModel;
import com.xiaopeng.montecarlo.scenes.routescene.IRouteContract;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingPreferencePresenter;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.ChargeRouteView;
import com.xiaopeng.montecarlo.views.ImageTextView;
import com.xiaopeng.montecarlo.views.OfflinePopView;
import com.xiaopeng.montecarlo.views.RestrictPopView;
import com.xiaopeng.montecarlo.views.RouteChargePanelView;
import com.xiaopeng.montecarlo.views.RouteDetailItemView;
import com.xiaopeng.montecarlo.views.RouteDetailPanel;
import com.xiaopeng.montecarlo.views.RoutePreferenceView;
import com.xiaopeng.montecarlo.views.TipsView;
import com.xiaopeng.montecarlo.views.dialog.XIKnowDialog;
import com.xiaopeng.montecarlo.views.dialog.XLandLoadingDialog;
import com.xiaopeng.montecarlo.views.dialog.XTextDialog;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
import com.xiaopeng.vui.commons.VuiMode;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RouteFragment extends BaseMapScene implements IRouteContract.LogicView, RouteDetailItemView.OnItemClickListener, RestrictHelper.IRestrictView, TipsView.IActionListener, ISceneMapFragmentListener, RouteDetailPanel.IActionListener, View.OnClickListener, RoutePreferenceView.IActionListener {
    public static final int BACK_REQUESTCODE_SEARCH = 100;
    private static final int ROUNTE_STAT_START_NAVI_COUNT_DOWN_CANCELED = 0;
    private static final int ROUNTE_STAT_START_NAVI_COUNT_DOWN_NOT_CANCELED = 1;
    private static final int ROUTE_BACK_TYPE_NORMAL = 0;
    private static final int ROUTE_BACK_TYPE_WAYPOINT = 1;
    private static final L.Tag TAG = new L.Tag("RouteFragment");
    private XRelativeLayout mBackToRoute;
    private XLinearLayout mBtnAddWayPoint;
    private XRelativeLayout mBtnCancelRoute;
    private ImageTextView mBtnDebugStartExplore;
    private XTextView mBtnRouteAddWaypoint;
    private XRelativeLayout mBtnStartExplore;
    private XRelativeLayout mBtnStartNavi;
    private XLandLoadingDialog mChargeLoadingDialog;
    private CountDownModel mCountDownModel;
    private RectDouble mCurrentPreviewRect;
    private XLinearLayout mDebugContainer;
    private boolean mIsNeedResoreOffLineView;
    private boolean mIsNeedRestoreRestrictView;
    private XImageButton mIvBack;
    private OfflinePopView mOfflineView;
    private RelativeLayout.LayoutParams mOfflineViewLayoutParams;
    private RestrictHelper mRestrictHelper;
    private XRelativeLayout mRoutContent;
    private XLinearLayout mRoutDetailContainer;
    private RouteChargePanelView mRouteChargePanelView;
    private XTextDialog mRouteChargePlanDialog;
    private ViewStub mRouteChargeStub;
    private RelativeLayout.LayoutParams mRouteContentLayoutParams;
    private RouteDetailPanel mRoutePanel;
    private RoutePreferenceView mRoutePreferenceView;
    private TipsView mRouteTrafficTipsView;
    private RelativeLayout.LayoutParams mRouteTrafficTipsViewLayoutParams;
    private XLandLoadingDialog mRoutingDialog;
    private boolean mShowRoutePanelOnPoiHide;
    private int mTipType;
    private XTextView mTvBack;
    private XIKnowDialog mXIKnowDialog;
    private View mRootView = null;
    private RouteScenePresenter mPresenter = null;
    private String[] mRouteFailReason = null;
    private boolean mOriginFollowMode = false;
    private String mSearchKeyword = "";
    private int mInfoFlowCardHeight = 0;
    private int mOldRoutePreferenceTopMargin = -1;
    private int mOldRouteBackTopMargin = -1;

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes
    public boolean isNeedMergeBaseMapViewForVui() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isShowFavorite() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.views.TipsView.IActionListener
    public void onClose() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void onRestrictViewVisibilityChanged(int i) {
    }

    public static RouteFragment newInstance() {
        return new RouteFragment();
    }

    private void sendStatDataForRoutePlate(RouteDetailItemView routeDetailItemView) {
        this.mPresenter.sendStatDataForRoutePlate(routeDetailItemView.getIndex(), routeDetailItemView.getRouteType(), Long.valueOf(routeDetailItemView.getRouteLeftDistance()), Long.valueOf(routeDetailItemView.getTravelTime()), Long.valueOf(routeDetailItemView.getTollCost()), Long.valueOf(routeDetailItemView.getLightCount()));
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    @MainThread
    public void onRouteElemClick() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.isSceneLegal()) {
                    RouteFragment.this.hidePoiPop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(@Nullable Bundle bundle) {
        super.onSceneCreate(bundle);
        this.mInfoFlowCardHeight = (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) ? VoiceFusionUtil.getInstance().getDefaultInfoflowCardHeight(1) : 0;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRouteFailReason = getResources().getStringArray(R.array.route_fail_reason);
        this.mRootView = layoutInflater.inflate(R.layout.layout_fragment_route_plan, (ViewGroup) null);
        this.mRoutePanel = (RouteDetailPanel) this.mRootView.findViewById(R.id.route_panel);
        this.mRoutDetailContainer = (XLinearLayout) this.mRootView.findViewById(R.id.route_view_container);
        this.mRoutContent = (XRelativeLayout) this.mRootView.findViewById(R.id.route_content);
        this.mBackToRoute = (XRelativeLayout) this.mRootView.findViewById(R.id.container_back_view);
        this.mBackToRoute.setOnClickListener(this);
        this.mBtnRouteAddWaypoint = (XTextView) this.mRootView.findViewById(R.id.btn_route_add_waypoint);
        this.mBtnRouteAddWaypoint.setOnClickListener(this);
        this.mIvBack = (XImageButton) this.mRootView.findViewById(R.id.iv_back);
        this.mIvBack.setOnClickListener(this);
        this.mTvBack = (XTextView) this.mRootView.findViewById(R.id.tv_back);
        this.mBtnStartNavi = (XRelativeLayout) this.mRootView.findViewById(R.id.btn_start_navi);
        this.mBtnAddWayPoint = (XLinearLayout) this.mRootView.findViewById(R.id.btn_add_waypoint_container);
        this.mBtnStartExplore = (XRelativeLayout) this.mRootView.findViewById(R.id.btn_explore);
        this.mBtnCancelRoute = (XRelativeLayout) this.mRootView.findViewById(R.id.route_cancel_panel);
        this.mRouteChargeStub = (ViewStub) this.mRootView.findViewById(R.id.route_charge_panel_stub);
        this.mRoutePanel.setRouteDetailPanelActionListener(this);
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported() && Utils.isLandscape()) {
            this.mDebugContainer = (XLinearLayout) this.mRootView.findViewById(R.id.debug_button_container);
            this.mBtnDebugStartExplore = (ImageTextView) this.mRootView.findViewById(R.id.btn_debug_explore);
            this.mBtnDebugStartExplore.setOnClickListener(this);
        }
        this.mRoutePreferenceView = (RoutePreferenceView) this.mRootView.findViewById(R.id.route_preference_view);
        this.mRoutePreferenceView.setClickListener(this);
        return this.mRootView;
    }

    private void showRouteBackView(int i) {
        resetViewInRouteBack();
        if (i == 0) {
            this.mTvBack.setVisibility(0);
        } else {
            this.mBtnRouteAddWaypoint.setVisibility(0);
        }
        if (this.mBackToRoute.getVisibility() != 0) {
            this.mBackToRoute.setVisibility(0);
        } else if (isSceneVuiEnabled()) {
            VoiceFullScenesUtil.updateScene(this, this.mBackToRoute);
        }
    }

    private void hideRouteBackView() {
        resetViewInRouteBack();
        if (8 != this.mBackToRoute.getVisibility()) {
            this.mBackToRoute.setVisibility(8);
        } else if (isSceneVuiEnabled()) {
            VoiceFullScenesUtil.updateScene(this, this.mBackToRoute);
        }
    }

    private void resetViewInRouteBack() {
        this.mTvBack.setVisibility(8);
        this.mBtnRouteAddWaypoint.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneNewBridge(BaseBridge baseBridge) {
        super.onSceneNewBridge(baseBridge);
        this.mPresenter.onSceneNewBridge(isStartAiMsg(), convertBundle2Request(baseBridge.getBundle()));
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void createRouteContent(IPathResult iPathResult, int i) {
        if (isSceneLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "createRouteContent isRouteFromSpeech:" + this.mPresenter.isRouteFromSpeech());
            }
            if (Utils.isLandscape()) {
                if (!this.mPresenter.isRouteFromSpeech()) {
                    showRouteBackView(1);
                } else {
                    hideRouteBackView();
                }
            }
            showRouteContent(iPathResult, i);
        }
    }

    private void showRouteContent(IPathResult iPathResult, int i) {
        int i2;
        RouteDetailItemView routeDetailItemView;
        IVariantPath iVariantPath;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        int i7;
        int i8;
        boolean z3;
        LinearLayout.LayoutParams layoutParams;
        if (isSceneVuiEnabled()) {
            RouteVuiHelper.clearRouteList();
        }
        hidePoiPop();
        boolean z4 = false;
        this.mRoutContent.setVisibility(0);
        if (isSceneVuiEnabled()) {
            VoiceFullScenesUtil.updateScene(this, this.mRoutContent);
        }
        RouteDetailItemView routeDetailItemView2 = null;
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            updateLayoutVisibleState(this.mPresenter.isRouteFromSpeech());
            XLinearLayout xLinearLayout = this.mDebugContainer;
            if (xLinearLayout != null && xLinearLayout.getVisibility() == 0) {
                updateRoutePreferenceLayout(this.mDebugContainer);
            } else {
                XRelativeLayout xRelativeLayout = this.mBackToRoute;
                if (xRelativeLayout != null && xRelativeLayout.getVisibility() == 0) {
                    updateRoutePreferenceLayout(this.mBackToRoute);
                } else {
                    updateRoutePreferenceLayout(null);
                }
            }
        }
        this.mRoutePreferenceView.setPreferenceText(getCurrentRoutePreference(TBTManager.getInstance().getRouteParams(this.mPresenter.getCurrentRequestId())));
        if (this.mRoutePreferenceView.getVisibility() != 0) {
            if (isSceneVuiEnabled()) {
                this.mRoutePreferenceView.setVuiLabel(getResources().getString(R.string.setting_route_title_name));
                this.mRoutePreferenceView.setVuiAction(getResources().getString(R.string.vui_action_click));
            }
            this.mRoutePreferenceView.setVisibility(0);
            updateRestrictLayout();
        }
        this.mPresenter.setRouteInfo(null);
        final int pathCount = (int) iPathResult.getPathCount();
        if (L.ENABLE) {
            L.d(TAG, "render route detail pathCount:" + pathCount);
        }
        boolean z5 = Utils.isLandscape() ? false : 1 == pathCount;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.route_detail_panel_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.route_detail_panel_width);
        if (!Utils.isLandscape() && pathCount > 0) {
            dimensionPixelSize2 /= pathCount;
        }
        int i9 = dimensionPixelSize2;
        boolean isBottomPanelVisible = this.mRoutePanel.isBottomPanelVisible();
        int childCount = this.mRoutDetailContainer.getChildCount();
        resetDetailViewDataRefreshListener();
        int i10 = 0;
        int i11 = 0;
        while (i11 < pathCount) {
            IVariantPath path = iPathResult.getPath(i11);
            if (i10 < childCount) {
                routeDetailItemView = (RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i10);
                i2 = i10 + 1;
            } else {
                i2 = i10;
                routeDetailItemView = routeDetailItemView2;
            }
            int routeDetailLevel = getRouteDetailLevel(i11, pathCount, isBottomPanelVisible);
            if (routeDetailItemView == null) {
                iVariantPath = path;
                i3 = i11;
                i4 = childCount;
                i5 = i9;
                z = isBottomPanelVisible;
                i6 = dimensionPixelSize;
                routeDetailItemView = new RouteDetailItemView(getActivity(), i11, routeDetailLevel, z5, 0, 0L, this);
                z2 = true;
            } else {
                iVariantPath = path;
                i3 = i11;
                i4 = childCount;
                i5 = i9;
                z = isBottomPanelVisible;
                i6 = dimensionPixelSize;
                routeDetailItemView.updateViewState(z5);
                routeDetailItemView.setIndex(i3);
                if (routeDetailItemView.getLevel() != routeDetailLevel) {
                    routeDetailItemView.setLevel(routeDetailLevel);
                }
                routeDetailItemView.updateTheme(z4);
                z2 = z4;
            }
            boolean z6 = i == routeDetailItemView.getIndex() ? true : z4;
            if (L.ENABLE) {
                L.d(TAG, "setSelected flag:" + z6 + ",index:" + routeDetailItemView.getIndex());
            }
            routeDetailItemView.setSelected(z6);
            long currentRouteRequestId = TBTManager.getInstance().getCurrentRouteRequestId();
            RouteResult.RouteInfo routeResultInfo = TBTManager.getInstance().getRouteResultInfo(currentRouteRequestId, iVariantPath.getPathId());
            if (routeResultInfo != null) {
                routeDetailItemView.updatePanelInfo(iVariantPath.getPathId(), routeResultInfo.mPathLength, routeResultInfo.mTrafficLightCount, routeResultInfo.mTravelTime, routeResultInfo.mTollCost);
                i7 = i3;
                routeDetailItemView.updateRouteTypeContent(i7, routeResultInfo.mContentName);
            } else {
                i7 = i3;
                L.w(TAG, "routeInfo not found! currentRouteRequestId:" + currentRouteRequestId);
            }
            this.mPresenter.collectRouteDetailInfo(iVariantPath.getPathId(), routeDetailItemView.getRouteDetailInfo(), pathCount, false);
            sendStatDataForRoutePlate(routeDetailItemView);
            routeDetailItemView.setOnRouteDetailViewDataRefreshListener(new RouteDetailItemView.OnRouteDetailViewDataRefreshListener() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.2
                @Override // com.xiaopeng.montecarlo.views.RouteDetailItemView.OnRouteDetailViewDataRefreshListener
                public void onRouteDetailViewRemainDistanceDataRefresh(RouteDetailItemView routeDetailItemView3) {
                    RouteFragment.this.mPresenter.collectRouteDetailInfo(routeDetailItemView3.getPathId(), routeDetailItemView3.getRouteDetailInfo(), pathCount, true);
                }
            });
            IVariantPath iVariantPath2 = iVariantPath;
            this.mPresenter.createDisHelper(iVariantPath2, iPathResult, routeDetailItemView);
            routeDetailItemView.setTag(iVariantPath2);
            if (z2) {
                if (Utils.isLandscape()) {
                    i8 = i5;
                    dimensionPixelSize = i6;
                    layoutParams = new LinearLayout.LayoutParams(i8, dimensionPixelSize);
                } else {
                    i8 = i5;
                    dimensionPixelSize = i6;
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.weight = 1.0f;
                }
                routeDetailItemView.setLayoutParams(layoutParams);
                this.mRoutDetailContainer.addView(routeDetailItemView);
                i2++;
            } else {
                i8 = i5;
                dimensionPixelSize = i6;
                if (routeDetailItemView.getVisibility() != 0) {
                    z3 = false;
                    routeDetailItemView.setVisibility(0);
                    if (isSceneVuiEnabled() && isSceneLegal()) {
                        this.mPresenter.collectRouteDetailInfoForVui(routeDetailItemView.getRouteDetailInfo(), pathCount, this.mRoutDetailContainer, this.mRoutePanel, this.mVuiSceneId);
                    }
                    i11 = i7 + 1;
                    z4 = z3;
                    i9 = i8;
                    childCount = i4;
                    i10 = i2;
                    isBottomPanelVisible = z;
                    routeDetailItemView2 = null;
                }
            }
            z3 = false;
            if (isSceneVuiEnabled()) {
                this.mPresenter.collectRouteDetailInfoForVui(routeDetailItemView.getRouteDetailInfo(), pathCount, this.mRoutDetailContainer, this.mRoutePanel, this.mVuiSceneId);
            }
            i11 = i7 + 1;
            z4 = z3;
            i9 = i8;
            childCount = i4;
            i10 = i2;
            isBottomPanelVisible = z;
            routeDetailItemView2 = null;
        }
        int i12 = childCount;
        while (i10 >= 0 && i10 < i12) {
            int i13 = i10 + 1;
            RouteDetailItemView routeDetailItemView3 = (RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i10);
            if (routeDetailItemView3 != null) {
                routeDetailItemView3.setVisibility(8);
            }
            i10 = i13;
        }
    }

    private void updateRestrictLayout() {
        RestrictHelper restrictHelper = this.mRestrictHelper;
        if (restrictHelper == null || !restrictHelper.isRestrictedPopShow()) {
            return;
        }
        this.mRestrictHelper.updatePopLayout();
    }

    private void updateLayoutVisibleState(boolean z) {
        this.mRoutePanel.setVuiMode(z ? VuiMode.DISABLED : VuiMode.NORMAL);
        this.mRoutePanel.setVisibility(z ? 8 : 0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updateDebugContainerDisplayState(boolean z) {
        XLinearLayout xLinearLayout;
        if (!VoiceFusionUtil.getInstance().isVoiceFusionSupported() || (xLinearLayout = this.mDebugContainer) == null) {
            return;
        }
        xLinearLayout.setVuiMode(z ? VuiMode.NORMAL : VuiMode.DISABLED);
        this.mDebugContainer.setVisibility(z ? 0 : 8);
        updateDebugContainerLayoutForVoiceRoute();
    }

    private String getCurrentRoutePreference(RouteParams routeParams) {
        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.setting_route_title_name));
        if (routeParams != null) {
            int i = routeParams.mRoutePreference;
            if (-1 == i) {
                i = SettingWrapper.getAllSettingValue();
            }
            boolean isAvoidCongestionEnabled = SettingWrapper.isAvoidCongestionEnabled(i);
            boolean isAvoidChargeEnabled = SettingWrapper.isAvoidChargeEnabled(i);
            boolean isNoFreewaysEnabled = SettingWrapper.isNoFreewaysEnabled(i);
            boolean isHighwayPriorityEnabled = SettingWrapper.isHighwayPriorityEnabled(i);
            if (isAvoidCongestionEnabled && isAvoidChargeEnabled && isNoFreewaysEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_avoid_congestion_btn_name));
                sb.append(" / ");
                sb.append(getResources().getString(R.string.setting_route_avoid_charge_btn_name));
                sb.append(" / ");
                sb.append(getResources().getString(R.string.setting_route_no_freeways_btn_name));
            } else if (isAvoidCongestionEnabled && isNoFreewaysEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_avoid_congestion_btn_name));
                sb.append(" / ");
                sb.append(getResources().getString(R.string.setting_route_no_freeways_btn_name));
            } else if (isAvoidCongestionEnabled && isAvoidChargeEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_avoid_congestion_btn_name));
                sb.append(" / ");
                sb.append(getResources().getString(R.string.setting_route_avoid_charge_btn_name));
            } else if (isAvoidChargeEnabled && isNoFreewaysEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_avoid_charge_btn_name));
                sb.append(" / ");
                sb.append(getResources().getString(R.string.setting_route_no_freeways_btn_name));
            } else if (isAvoidCongestionEnabled && isHighwayPriorityEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_avoid_congestion_btn_name));
                sb.append(" / ");
                sb.append(getResources().getString(R.string.setting_route_highway_priority_btn_name));
            } else if (isHighwayPriorityEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_highway_priority_btn_name));
            } else if (isAvoidChargeEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_avoid_charge_btn_name));
            } else if (isNoFreewaysEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_no_freeways_btn_name));
            } else if (isAvoidCongestionEnabled) {
                sb.append("：");
                sb.append(getResources().getString(R.string.setting_route_avoid_congestion_btn_name));
            }
        }
        return sb.toString();
    }

    private void updateRoutePreferenceLayout(View view) {
        if (Utils.isLandscape() && view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoutePreferenceView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, ContextUtils.getDimensionPixelSize(R.dimen.route_preference_view_height));
            }
            layoutParams.removeRule(1);
            layoutParams.removeRule(6);
            layoutParams.addRule(1, view.getId());
            layoutParams.addRule(6, view.getId());
        }
        updateRoutePreferenceLayoutForVoiceRoute();
    }

    private void resetDetailViewDataRefreshListener() {
        if (!isSceneLegal() || this.mRoutDetailContainer == null) {
            return;
        }
        for (int i = 0; i < this.mRoutDetailContainer.getChildCount(); i++) {
            RouteDetailItemView routeDetailItemView = (RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i);
            if (routeDetailItemView != null) {
                routeDetailItemView.setOnRouteDetailViewDataRefreshListener(null);
            }
        }
    }

    private int getRouteDetailLevel(int i, int i2, boolean z) {
        if (!Utils.isLandscape()) {
            if (1 == i2) {
                return 5;
            }
            if (i != 0) {
                if (i == i2 - 1) {
                    return 3;
                }
                return 2;
            }
            return 0;
        }
        if (1 == i2) {
            if (!z) {
                return 5;
            }
        } else if (i != 0) {
            if (i == i2 - 1 && !z) {
                return 7;
            }
            return 2;
        }
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void routePanelInvisible() {
        RouteDetailPanel routeDetailPanel;
        if (isSceneLegal() && (routeDetailPanel = this.mRoutePanel) != null) {
            routeDetailPanel.setVisibility(4);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRoutePanelWithAnimate() {
        RouteDetailPanel routeDetailPanel;
        if (isSceneLegal() && (routeDetailPanel = this.mRoutePanel) != null) {
            routeDetailPanel.animate().cancel();
            this.mRoutePanel.post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    if (RouteFragment.this.mRoutePanel == null || !RouteFragment.this.mRoutePanel.isAttachedToWindow()) {
                        return;
                    }
                    RouteFragment.this.mRoutePanel.setTranslationY(-RouteFragment.this.mRoutePanel.getHeight());
                    RouteFragment.this.mRoutePanel.setVisibility(0);
                    RouteFragment.this.mRoutePanel.animate().translationY(0.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.3.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (RouteFragment.this.mPresenter.canStartCountdownGuide()) {
                                RouteFragment.this.startCountdownGuide(false);
                            }
                        }
                    }).start();
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void onInitView() {
        if (isSceneLegal()) {
            if (getMainContext() != null) {
                getMainContext().setSceneMapFragmentListener(this);
            }
            getMapView().setMapMode(0);
            this.mOriginFollowMode = getMapView().isFollowMode();
            getMapView().getBizControlManager().setFollowMode(false);
            if (!getMapView().getBizControlManager().getPreviewMode()) {
                getMapView().getBizControlManager().setPreviewMode(true);
            }
            this.mRestrictHelper = new RestrictHelper(getActivity(), this);
            this.mRestrictHelper.init();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteDetailItemView.OnItemClickListener
    public void onItemClick(int i, View view) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onItemClick position:" + i);
        }
        if (preventMultiClick(view)) {
            this.mPresenter.setSelectRoute(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void renderRoute(int i) {
        if (L.ENABLE) {
            L.d(TAG, "renderRoute index:" + i);
        }
        if (isSceneLegal()) {
            hidePoiPop();
            XLinearLayout xLinearLayout = this.mRoutDetailContainer;
            if (xLinearLayout != null) {
                int childCount = xLinearLayout.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    ((RouteDetailItemView) this.mRoutDetailContainer.getChildAt(i2)).setSelected(i2 == i);
                    i2++;
                }
                runOnUiThreadDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RouteFragment.this.showRoutePreview();
                    }
                }, 100L);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRoutePreview() {
        if (L.ENABLE && this.mCurrentPreviewRect != null) {
            L.Tag tag = TAG;
            L.d(tag, "showRoutePreview mCurrentPreviewRect left:" + this.mCurrentPreviewRect.left + ",top:" + this.mCurrentPreviewRect.top + ",right:" + this.mCurrentPreviewRect.right + ",bottom:" + this.mCurrentPreviewRect.bottom);
        }
        showOverViewButton(false);
        updatePreviewRect(this.mCurrentPreviewRect);
    }

    private ViewGroup getCountDownParentView() {
        if (this.mPresenter.isStartByAiMsg()) {
            return (ViewGroup) this.mRootView.findViewById(R.id.route_cancel_panel);
        }
        XRelativeLayout xRelativeLayout = this.mBtnStartNavi;
        if (xRelativeLayout != null) {
            return xRelativeLayout;
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public int getErrorCodeLen() {
        if (this.mRouteFailReason == null) {
            this.mRouteFailReason = getResources().getStringArray(R.array.route_fail_reason);
        }
        return this.mRouteFailReason.length;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRouteFailMsg(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showRouteFailMsg errorCode:" + i);
        }
        if (isSceneLegal()) {
            showPrompt(getResources().getString(R.string.route_fail_reason_msg, this.mRouteFailReason[i]));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRouteMsg(int i, int i2) {
        if (isSceneLegal()) {
            showRouteMsg(i, getString(i2));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    @MainThread
    public void showRouteMsg(int i, String str) {
        if (isSceneLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "showRouteFailMsg message:" + str);
            }
            if (i != 1) {
                if (i == 2) {
                    showPrompt(str);
                    return;
                } else {
                    showPrompt(str);
                    return;
                }
            }
            XIKnowDialog xIKnowDialog = this.mXIKnowDialog;
            if (xIKnowDialog != null && xIKnowDialog.isShowing()) {
                this.mXIKnowDialog.dismiss();
            }
            this.mXIKnowDialog = new XIKnowDialog(getActivity(), str);
            this.mXIKnowDialog.show();
            if (isSceneVuiEnabled()) {
                CommonVuiHelper.getInstance().addDialogVuiSupport(this.mXIKnowDialog, "XIKnowDialog");
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void startGuidance(boolean z, long j, int i, int i2) {
        if (isSceneLegal()) {
            if (this.mPresenter.isRouteFromSpeech() && this.mPresenter.isStartNaviImmediately()) {
                this.mPresenter.startSpeechDialog();
            } else {
                this.mPresenter.stopSpeechDialog();
            }
            Bundle bundle = new Bundle();
            bundle.putInt(SystemConst.NAVI_TYPE_KEY, 0);
            bundle.putBoolean(SystemConst.ROUTE_MANUAL, z);
            if (i2 > 0) {
                bundle.putInt(SystemConst.ISOFFLINE_TYPE_KEY, getOfflineRemainTime());
            }
            bundle.putLong(SystemConst.START_NAVI_ID, j);
            bundle.putInt(SystemConst.START_NAVI_PATH_INDEX, i);
            bundle.putBoolean(SystemConst.IS_REQUEST_RESTRICT, !this.mPresenter.hasReqRestrict());
            startScene(new NaviBridge().enableKillTopSceneMode().setBundle(bundle));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void startExplore(int i, long j, int i2, boolean z) {
        if (isSceneLegal()) {
            if (this.mPresenter.isRouteFromSpeech() && this.mPresenter.isStartNaviImmediately()) {
                this.mPresenter.startSpeechDialog();
            } else {
                this.mPresenter.stopSpeechDialog();
            }
            Bundle bundle = new Bundle();
            bundle.putLong(SystemConst.START_NAVI_ID, j);
            bundle.putInt(SystemConst.START_NAVI_PATH_INDEX, i2);
            if (i > 0) {
                bundle.putInt(SystemConst.ISOFFLINE_TYPE_KEY, 0);
            }
            bundle.putBoolean(NaviUtil.IS_NEED_TTSPROXY_SPEAK, z);
            bundle.putBoolean(SystemConst.IS_REQUEST_RESTRICT, !this.mPresenter.hasReqRestrict());
            startScene(new ExploreBridge().enableKillTopSceneMode().setBundle(bundle));
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteDetailPanel.IActionListener
    public void onActionPerformed(View view, int i) {
        hidePoiPop();
        if (i == 1) {
            executeAddWaypoint(view);
        } else if (i == 2) {
            executeStartNavi();
        } else if (i == 3) {
            executeStartExplore();
        } else if (i != 4) {
        } else {
            executeExitRoute();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteDetailPanel.IActionListener
    public void onInflateFinished(RouteDetailPanel routeDetailPanel) {
        VoiceFullScenesUtil.updateScene(this, routeDetailPanel);
    }

    private void executeStartExplore() {
        if (this.mPresenter.isRouteChargeEnable()) {
            this.mPresenter.onClickStartNavi(true);
        } else {
            this.mPresenter.startExplore();
        }
    }

    private void executeStartNavi() {
        this.mPresenter.sendStatDataForBtnNavi();
        if (this.mPresenter.isRouteChargeEnable()) {
            this.mPresenter.onClickStartNavi(false);
            return;
        }
        RouteScenePresenter routeScenePresenter = this.mPresenter;
        CountDownModel countDownModel = this.mCountDownModel;
        routeScenePresenter.sendStatDataForStartNaviCountDown(0, countDownModel == null ? 0 : countDownModel.getRouteDownCountRemain());
        this.mPresenter.startGuidance();
    }

    private void executeAddWaypoint(View view) {
        L.i(TAG, "open search with over mode for add way point");
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.SEARCH_ENTER_WAYPOINT, new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_MODE, 102);
        bundle.putInt(SearchBridge.FROM_SCENE_INDEX, getSceneStackSize());
        bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, getChildStackSize());
        bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, this.mSearchKeyword);
        bundle.putInt(SearchBridge.ANIM_TYPE, 0);
        bundle.putInt(SearchBridge.ANIM_START_Y, view.getTop());
        bundle.putInt(SearchBridge.ANIM_START_H, view.getHeight());
        startScene(new SearchBridge().enableOverMode().setBundle(bundle), 100);
        this.mSearchKeyword = "";
    }

    private void executeExitRoute() {
        this.mPresenter.cancelRouteClick();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
        if (this.mRootView == null) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "show()");
        }
        this.mRoutContent.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean onBackPressed() {
        return this.mPresenter.onBackPressed();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
        if (this.mRootView == null) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "hide()");
        }
        this.mRootView.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public RouteScenePresenter mo96getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(RouteScenePresenter routeScenePresenter) {
        this.mPresenter = routeScenePresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void renderRoutes(final IPathResult iPathResult, final int i) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.isSceneLegal()) {
                    RouteFragment.this.getMapView().getBizControlManager().removeRoute(769, true);
                    RouteFragment.this.getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, false);
                    RouteFragment routeFragment = RouteFragment.this;
                    routeFragment.mCurrentPreviewRect = routeFragment.getMapView().getBizControlManager().drawRoute(769, iPathResult, RouteFragment.this.mPresenter.getCurrentRouteParams(), RouteFragment.this.mPresenter.getCurrentRequestId(), i, false);
                    RouteFragment.this.showRadarForRoutePlan(i);
                    RouteFragment.this.getMainContext().addRoutePointsOverlay(RouteFragment.this);
                    RouteFragment.this.showRoutePreview();
                    RouteFragment.this.mShowRoutePanelOnPoiHide = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRadarForRoutePlan(int i) {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.6
            @Override // java.lang.Runnable
            public void run() {
                RouteFragment.this.getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, true);
            }
        }, 500L);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void openFavourate() {
        if (isSceneLegal()) {
            L.i(TAG, "open search with over mode for open favorite");
            DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.SEARCH_ENTER_WAYPOINT, new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putInt(SearchBridge.KEY_START_FROM, 1);
            bundle.putInt(SearchBridge.SEARCH_MODE, 102);
            bundle.putInt(SearchBridge.FROM_SCENE_INDEX, getSceneStackSize());
            bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, getChildStackSize());
            bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, this.mSearchKeyword);
            bundle.putInt(SearchBridge.ANIM_TYPE, 0);
            bundle.putInt(SearchBridge.SUB_CONTAINER_TYPE, 1);
            startScene(new SearchBridge().enableOverMode().setBundle(bundle), 100);
            this.mSearchKeyword = "";
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        RouteSaveState routeSaveState = new RouteSaveState();
        routeSaveState.mRequestId = getHoldLong(RouteSaveState.KEY_ROUTE_REQUEST_ID, -1L);
        routeSaveState.mSelectPathId = getHoldInt(RouteSaveState.KEY_ROUTE_SELECT_PATHID, 0);
        routeSaveState.mIsOfflineRoute = getHoldBoolean(RouteSaveState.KEY_ROUTE_ISOFFLINE, false);
        this.mPresenter.onInit(getMainContext(), routeSaveState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        View view = this.mRootView;
        if (view != null) {
            view.setVisibility(0);
        }
        this.mPresenter.onResume(isStartAiMsg(), convertBundle2Request(getBridge().getBundle()));
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updateMapUi() {
        if (isSceneLegal()) {
            MapUIStatus uIStatus = getUIStatus();
            uIStatus.mMapRenderModeVisibility = 8;
            uIStatus.mZoomButtonVisibility = 8;
            uIStatus.mScaleVisibility = 0;
            uIStatus.mVolumeVisibility = 0;
            uIStatus.mSettingVisibility = 0;
            uIStatus.mRouteChargeVisibility = 0;
            updateUIStatus(uIStatus);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public RouteRequest convertBundle2Request(Bundle bundle) {
        if (bundle != null) {
            RouteRequest routeRequest = (RouteRequest) bundle.getParcelable(RouteBridge.ROUTE_REQUEST);
            if (routeRequest != null) {
                String string = bundle.getString(SystemConst.ROUTE_TYPE_KEY, "");
                if (1 == routeRequest.getRequestFrom()) {
                    string = SystemConst.ROUTE_TYPE_FROM_SPEECH;
                }
                this.mPresenter.updateDataWhenRequest(string, bundle.getBoolean(SystemConst.ROUTE_MANUAL, false), routeRequest.getStartType(), bundle.getBoolean(SystemConst.IS_RESTORE_NAVI_AUTOMATICALLY, false), bundle.getBoolean(SystemConst.IS_RESTART_RESTORE_NAVI, true), routeRequest.getRouteSelectRef());
                return routeRequest;
            }
            return routeRequest;
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mPresenter.clearAlterLabelTableForVui(0);
        this.mPresenter.onUninit();
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
        if (getMainContext() != null) {
            getMainContext().removeSceneMapFragmentListener(this);
        }
        hideTip();
        OfflinePopView offlinePopView = this.mOfflineView;
        if (offlinePopView != null) {
            offlinePopView.hide();
        }
        this.mIsNeedResoreOffLineView = false;
        this.mRestrictHelper.unInit();
        XIKnowDialog xIKnowDialog = this.mXIKnowDialog;
        if (xIKnowDialog != null && xIKnowDialog.isShowing()) {
            this.mXIKnowDialog.dismiss();
        }
        updateMapWhenExit();
        RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
        if (routeChargePanelView != null) {
            routeChargePanelView.setListener(null);
        }
        RoutePreferenceView routePreferenceView = this.mRoutePreferenceView;
        if (routePreferenceView != null) {
            routePreferenceView.setClickListener(null);
        }
        showRouteChargeContainer(false);
        XTextDialog xTextDialog = this.mRouteChargePlanDialog;
        if (xTextDialog != null && xTextDialog.isShowing()) {
            this.mRouteChargePlanDialog.dismiss();
        }
        this.mRouteContentLayoutParams = null;
        this.mOfflineViewLayoutParams = null;
        this.mRouteTrafficTipsViewLayoutParams = null;
        this.mInfoFlowCardHeight = 0;
        this.mOldRoutePreferenceTopMargin = -1;
        this.mOldRouteBackTopMargin = -1;
    }

    private void updateMapWhenExit() {
        getMapView().updateRouteStyle(ThemeWatcherUtil.getMapModeByCurrentTheme(), getMapView().getMapViewState());
        getMapView().getBizControlManager().updateMapWhenExit(this.mOriginFollowMode, this.mPresenter.getBizOverlayObserver());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        this.mPresenter.onPause();
        XLandLoadingDialog xLandLoadingDialog = this.mChargeLoadingDialog;
        if (xLandLoadingDialog != null) {
            xLandLoadingDialog.dismiss();
            this.mChargeLoadingDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneStop() {
        super.onSceneStop();
        if (this.mPresenter.isCountDownToNavShow()) {
            cancelCountdownGuide(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        if (200 == i) {
            onSceneMapFragmentResult(i, bundle);
            return;
        }
        if (100 == i && bundle != null) {
            this.mSearchKeyword = bundle.getString(SearchBridge.SEARCH_KEYWORD_TEXT);
        }
        this.mRestrictHelper.onBackResult(i, bundle);
        RouteRequest convertBundle2Request = convertBundle2Request(bundle);
        if (convertBundle2Request != null) {
            this.mPresenter.onBackResult(i, convertBundle2Request);
        } else {
            L.w(TAG, "onBackResult bundle is null!");
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        cancelCountdownGuide(false);
        this.mPresenter.setStopCountdownByUserTouch(true);
        XLandLoadingDialog xLandLoadingDialog = this.mRoutingDialog;
        if ((xLandLoadingDialog == null || !xLandLoadingDialog.isShowing()) && !this.mPresenter.isRouteFromSpeech()) {
            this.mPresenter.startExploreCountDown();
        }
        XRelativeLayout xRelativeLayout = this.mRoutContent;
        if (xRelativeLayout == null || xRelativeLayout.getVisibility() != 0 || this.mRoutDetailContainer == null || motionEvent.getX() <= this.mRoutDetailContainer.getLeft() || motionEvent.getX() >= this.mRoutDetailContainer.getRight() || motionEvent.getY() <= this.mRoutDetailContainer.getTop() || motionEvent.getY() >= this.mRoutDetailContainer.getBottom()) {
            this.mPresenter.stopRouteChargeAutoOverViewTimer();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showPoiPop(DecoratorType decoratorType, XPPoiInfo xPPoiInfo) {
        if (isSceneLegal()) {
            getMainContext().getDecoratorManager().focus(this, decoratorType, xPPoiInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        RouteSaveState needSaveState = this.mPresenter.getNeedSaveState();
        saveHoldLong(RouteSaveState.KEY_ROUTE_REQUEST_ID, needSaveState.mRequestId);
        saveHoldInt(RouteSaveState.KEY_ROUTE_SELECT_PATHID, needSaveState.mSelectPathId);
        saveHoldBoolean(RouteSaveState.KEY_ROUTE_ISOFFLINE, needSaveState.mIsOfflineRoute);
        saveHoldBoolean(RouteSaveState.KEY_IS_STOP_COUNT_DOWN, this.mPresenter.isSwitchedRouteChargePlan());
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiShow(PoiCardView poiCardView) {
        super.onPoiShow(poiCardView);
        L.i(TAG, "onPoiShow");
        if (isSceneLegal()) {
            showBackToRouteView(true);
            hideRouteDetail();
            hideRestrictedPopOnOtherElementShow();
            this.mPresenter.hideRouteChargePanel(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiHide(PoiCardView poiCardView) {
        super.onPoiHide(poiCardView);
        L.i(TAG, "onPoiHide");
        if (isSceneLegal()) {
            if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported() && !this.mPresenter.isRouteChargeFocused()) {
                backToRoute();
            }
            XRelativeLayout xRelativeLayout = this.mRoutContent;
            if (xRelativeLayout == null || xRelativeLayout.getVisibility() != 0) {
                return;
            }
            restoreRestrictedPopOnOtherElementHide();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void removeChildScene() {
        super.removeAllChildScene();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.NAVI_ROUTING;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showOfflineTips(boolean z) {
        XRelativeLayout xRelativeLayout;
        if (isSceneLegal()) {
            RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
            if (routeChargePanelView == null || routeChargePanelView.getVisibility() != 0) {
                if (this.mOfflineView == null) {
                    this.mOfflineView = (OfflinePopView) ((ViewStub) this.mRootView.findViewById(R.id.offline_popview_sub)).inflate();
                    this.mOfflineView.setActionListener(new OfflineListener());
                    this.mOfflineView.setMainContext(getMainContext());
                }
                if (this.mOfflineView.getVisibility() != 0) {
                    this.mOfflineView.show(z);
                } else {
                    this.mOfflineView.reStartCountDown();
                }
                this.mIsNeedResoreOffLineView = false;
                XLinearLayout xLinearLayout = this.mDebugContainer;
                if (xLinearLayout != null && xLinearLayout.getVisibility() == 0 && (xRelativeLayout = this.mRoutContent) != null) {
                    if (this.mRouteContentLayoutParams == null) {
                        this.mRouteContentLayoutParams = (RelativeLayout.LayoutParams) xRelativeLayout.getLayoutParams();
                    }
                    this.mRouteContentLayoutParams.addRule(3, R.id.debug_button_container);
                    if (this.mOfflineViewLayoutParams == null) {
                        this.mOfflineViewLayoutParams = (RelativeLayout.LayoutParams) this.mOfflineView.getLayoutParams();
                    }
                    this.mOfflineViewLayoutParams.addRule(9);
                    this.mOfflineViewLayoutParams.leftMargin = 0;
                }
                NaviStatUtil.sendStatDataForOfflineView(getPageType(), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation(), BtnType.ROUTE_OFFLINEVIEW_SHOW);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void hideOffline() {
        OfflinePopView offlinePopView;
        if (isSceneLegal() && (offlinePopView = this.mOfflineView) != null && offlinePopView.getVisibility() == 0) {
            this.mOfflineView.hide();
            this.mIsNeedResoreOffLineView = false;
            if (this.mOfflineView.isReRoute()) {
                showPrompt(R.string.offline_pop_reroute_success_toast_text);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideOfflineViewOnOtherElementShow() {
        OfflinePopView offlinePopView;
        if (Utils.isLandscape() || (offlinePopView = this.mOfflineView) == null || !offlinePopView.isShown()) {
            return;
        }
        this.mOfflineView.hide(true);
        this.mIsNeedResoreOffLineView = true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public boolean isOfflineRoutePanelExpand() {
        OfflinePopView offlinePopView = this.mOfflineView;
        return offlinePopView != null && offlinePopView.getVisibility() == 0 && this.mOfflineView.isExpand();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreOfflineView() {
        if (this.mIsNeedResoreOffLineView) {
            this.mOfflineView.restoreShow();
            this.mIsNeedResoreOffLineView = false;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    @MainThread
    public void hidePoiPop() {
        if (isSceneLegal()) {
            getMainContext().getDecoratorManager().clearFocus(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void showRestrictedPop(int i, String str, String str2, ArrayList<XPGRestrictCity> arrayList, String str3, RestrictPopView.IRestrictPopActionListener iRestrictPopActionListener) {
        RouteChargePanelView routeChargePanelView;
        if (isSceneLegal()) {
            OfflinePopView offlinePopView = this.mOfflineView;
            if ((offlinePopView != null && offlinePopView.getVisibility() == 0) || (Utils.isPortrait() && (routeChargePanelView = this.mRouteChargePanelView) != null && routeChargePanelView.getVisibility() == 0)) {
                if (L.ENABLE) {
                    L.d(TAG, "ignore RestrictedPop after offline OR routecharge");
                }
            } else if (isPoiCardShowing()) {
                this.mIsNeedRestoreRestrictView = true;
                this.mRestrictHelper.setRestrictInfoForUncomingPop(i, str, str2, arrayList, str3, iRestrictPopActionListener, false);
            } else {
                this.mIsNeedRestoreRestrictView = false;
                this.mRestrictHelper.showRestrictedPop(i, str, str2, arrayList, str3, iRestrictPopActionListener, false);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public BaseScene getSceneForRestrict() {
        return getScene();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public RelativeLayout.LayoutParams getPopPos() {
        if (Utils.isLandscape()) {
            RelativeLayout.LayoutParams popLayoutParams = this.mRestrictHelper.getPopLayoutParams();
            if (popLayoutParams != null) {
                if (this.mPresenter.isRouteFromSpeech()) {
                    popLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.route_restrict_vui_margin_top);
                    popLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.route_restrict_vui_margin_left);
                } else {
                    popLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.route_restrict_margin_top);
                    popLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.route_restrict_margin_left);
                }
            }
            return popLayoutParams;
        }
        RelativeLayout.LayoutParams defaultPopPos = this.mRestrictHelper.getDefaultPopPos();
        if (defaultPopPos != null) {
            RoutePreferenceView routePreferenceView = this.mRoutePreferenceView;
            if (routePreferenceView != null && routePreferenceView.getVisibility() == 0) {
                if (this.mPresenter.isRouteFromSpeech() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
                    defaultPopPos.topMargin = this.mInfoFlowCardHeight + this.mRoutePreferenceView.getHeight() + getResources().getDimensionPixelSize(R.dimen.route_preference_view_restrit_margin_top);
                } else {
                    defaultPopPos.topMargin = this.mRoutePanel.getTop() + this.mRoutePanel.getHeight() + this.mRoutePreferenceView.getHeight() + getResources().getDimensionPixelSize(R.dimen.route_preference_view_restrit_margin_top);
                }
            } else {
                defaultPopPos.topMargin = this.mRoutePanel.getTop() + this.mRoutePanel.getHeight() + getResources().getDimensionPixelSize(R.dimen.route_restrict_margin_top);
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "restrict layout top margin:" + defaultPopPos.topMargin);
            }
            defaultPopPos.leftMargin = getResources().getDimensionPixelSize(R.dimen.route_restrict_margin_left);
            defaultPopPos.rightMargin = getResources().getDimensionPixelSize(R.dimen.route_restrict_margin_right);
        }
        return defaultPopPos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreRestrictedPopOnOtherElementHide() {
        if (this.mIsNeedRestoreRestrictView) {
            this.mRestrictHelper.restoreShowRestrictPop();
            this.mIsNeedRestoreRestrictView = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideRestrictedPopOnOtherElementShow() {
        this.mRestrictHelper.hideRestrictedPop(true);
        this.mIsNeedRestoreRestrictView = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBackToRouteView(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "showBackToRouteView:" + z);
        if (isSceneLegal()) {
            if (!Utils.isLandscape()) {
                if (z) {
                    showRouteBackView(0);
                    updateRouteBackLayoutForVoiceRoute();
                    return;
                }
                hideRouteBackView();
            } else if (this.mPresenter.isRouteFromSpeech()) {
                hideRouteBackView();
            } else if (z) {
                showRouteBackView(0);
            } else {
                showRouteBackView(1);
            }
        }
    }

    private void updateRouteBackLayoutForVoiceRoute() {
        if (this.mBackToRoute.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBackToRoute.getLayoutParams();
            if (this.mOldRouteBackTopMargin == 0) {
                this.mOldRouteBackTopMargin = layoutParams.topMargin;
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "updateRouteBackLayoutForVoiceRoute mOldRouteBackTopMargin:" + this.mOldRouteBackTopMargin);
            }
            if (this.mPresenter.isRouteFromSpeech() && Utils.isPortrait()) {
                layoutParams.topMargin = this.mInfoFlowCardHeight;
            } else {
                layoutParams.topMargin = this.mOldRouteBackTopMargin;
            }
        }
    }

    @MainThread
    private void backToRoute() {
        showBackToRouteView(false);
        showRouteDetail();
        hidePoiPop();
        this.mPresenter.hideRouteChargePanel(false);
        hideSceneTrafficEventPop();
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void hideRestrictedPop() {
        this.mRestrictHelper.hideRestrictedPop();
        this.mIsNeedRestoreRestrictView = false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictView
    public void requestRestrictReroute() {
        this.mPresenter.requestReroute(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public RestrictHelper getRestrictHelper() {
        return this.mRestrictHelper;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showTip(int i, String str) {
        XRelativeLayout xRelativeLayout;
        if (isSceneLegal()) {
            if (this.mRouteTrafficTipsView == null) {
                this.mRouteTrafficTipsView = (TipsView) ((ViewStub) this.mRootView.findViewById(R.id.route_traffic_event_tips_stub)).inflate();
            }
            if (!TextUtils.isEmpty(str) && str.contains(NaviUtil.TRAFFIC_STRING_SPLITTER)) {
                String[] split = str.split(NaviUtil.TRAFFIC_STRING_SPLITTER);
                if (!CollectionUtils.isEmpty(split)) {
                    this.mRouteTrafficTipsView.setTitle(split[0]);
                    this.mRouteTrafficTipsView.setContent(split[1]);
                }
            } else {
                this.mRouteTrafficTipsView.setTitle(str);
            }
            this.mRouteTrafficTipsView.setActionListener(this);
            if (i == 4 || i == 6) {
                this.mTipType = 1;
            } else {
                this.mTipType = 0;
            }
            this.mRouteTrafficTipsView.setUseBgImage(false);
            this.mRouteTrafficTipsView.updateView(this.mTipType);
            this.mRouteTrafficTipsView.show();
            XLinearLayout xLinearLayout = this.mDebugContainer;
            if (xLinearLayout != null && xLinearLayout.getVisibility() == 0 && (xRelativeLayout = this.mRoutContent) != null) {
                if (this.mRouteContentLayoutParams == null) {
                    this.mRouteContentLayoutParams = (RelativeLayout.LayoutParams) xRelativeLayout.getLayoutParams();
                }
                this.mRouteContentLayoutParams.addRule(3, R.id.debug_button_container);
                if (this.mRouteTrafficTipsViewLayoutParams == null) {
                    this.mRouteTrafficTipsViewLayoutParams = (RelativeLayout.LayoutParams) this.mRouteTrafficTipsView.getLayoutParams();
                }
                this.mRouteTrafficTipsViewLayoutParams.addRule(9);
                this.mRouteTrafficTipsViewLayoutParams.leftMargin = 0;
            }
            updateRouteTrafficTipsVuiInfo();
        }
    }

    private void updateRouteTrafficTipsVuiInfo() {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.7
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.isSceneVuiEnabled()) {
                    RouteFragment routeFragment = RouteFragment.this;
                    VoiceFullScenesUtil.updateScene(routeFragment, routeFragment.mRouteTrafficTipsView);
                }
            }
        }, 500L);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void hideTip() {
        TipsView tipsView;
        if (isSceneLegal() && (tipsView = this.mRouteTrafficTipsView) != null) {
            tipsView.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        renderLayoutByDayNightStatus();
    }

    private void renderLayoutByDayNightStatus() {
        TipsView tipsView = this.mRouteTrafficTipsView;
        if (tipsView != null && tipsView.getVisibility() == 0) {
            this.mRouteTrafficTipsView.updateView(this.mTipType);
        }
        exchangeThemeForDebugContainer();
    }

    private void exchangeThemeForDebugContainer() {
        ImageTextView imageTextView;
        if (isSceneLegal() && VoiceFusionUtil.getInstance().isVoiceFusionSupported() && (imageTextView = this.mBtnDebugStartExplore) != null) {
            imageTextView.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_route_explore));
            this.mBtnDebugStartExplore.setIcon(ThemeWatcherUtil.getDrawable(R.drawable.selector_explore_button));
            this.mBtnDebugStartExplore.setTextColor(ThemeWatcherUtil.getColor(R.color.route_explore_tx_color));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void cancelCountdownGuide(boolean z) {
        this.mPresenter.setCountDownToNavShow(z);
        if (isSceneLegal()) {
            ViewGroup countDownParentView = getCountDownParentView();
            if (countDownParentView == null) {
                if (L.ENABLE) {
                    L.d(TAG, "cancelCountdownGuide parent is null");
                    return;
                }
                return;
            }
            if (this.mCountDownModel != null) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "cancelCountdownGuide isPause:" + z);
                }
                if (this.mCountDownModel.isRun()) {
                    if (this.mPresenter.isStartByAiMsg()) {
                        this.mPresenter.sendStatDataForAiTrafficDrawCountDown();
                    } else {
                        this.mPresenter.sendStatDataForStartNaviCountDown(0, this.mCountDownModel.getRouteDownCountRemain());
                    }
                }
                this.mCountDownModel.stopCountDown(countDownParentView, z);
            }
            if (this.mPresenter.isRouteFromSpeech()) {
                VoiceFusionUtil.getInstance().sendGUIEventWhenMapOperation(true);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void startCountdownGuide(boolean z) {
        ViewGroup countDownParentView;
        if (!isSceneLegal() || (countDownParentView = getCountDownParentView()) == null || this.mPresenter.isCountDownToNavShow() || this.mPresenter.isRouteChargeEnable()) {
            return;
        }
        this.mPresenter.setCountDownToNavShow(true);
        if (this.mCountDownModel == null) {
            this.mCountDownModel = new CountDownModel();
        }
        this.mCountDownModel.setMsgFromAI(this.mPresenter.isStartByAiMsg());
        this.mCountDownModel.startCountDown(countDownParentView, z, new CountDownModel.CountDownCallback() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.8
            @Override // com.xiaopeng.montecarlo.scenes.routescene.CountDownModel.CountDownCallback
            public void onViewAdded() {
            }

            @Override // com.xiaopeng.montecarlo.scenes.routescene.CountDownModel.CountDownCallback
            public void onStart() {
                StateManager.getInstance().removeListener(RouteFragment.this.mPresenter);
            }

            @Override // com.xiaopeng.montecarlo.scenes.routescene.CountDownModel.CountDownCallback
            public void onEnd() {
                RouteFragment.this.mPresenter.setCountDownToNavShow(false);
                if (RouteFragment.this.mPresenter.isStartByAiMsg()) {
                    RouteFragment.this.mPresenter.cancelRoute();
                    return;
                }
                RouteFragment.this.mPresenter.sendStatDataForStartNaviCountDown(1, RouteFragment.this.mCountDownModel.getRouteDownCountRemain());
                RouteFragment.this.mPresenter.countDownOnEnd();
            }

            @Override // com.xiaopeng.montecarlo.scenes.routescene.CountDownModel.CountDownCallback
            public void onViewRemoved() {
                StateManager.getInstance().start(1);
                StateManager.getInstance().addListener(RouteFragment.this.mPresenter);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public String getAvoidJamDesc(AvoidTrafficJamInfo avoidTrafficJamInfo) {
        return NaviUtil.getAvoidJamDesc(getActivity(), avoidTrafficJamInfo);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public String getIncidentDesc(TrafficIncident trafficIncident) {
        return NaviUtil.getIncidentDesc(getActivity(), trafficIncident);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public String getSpeechSelectRouteStr(int i) {
        return 1 == i ? getString(R.string.route_speech_select_route_single) : String.format(getString(R.string.route_speech_select_route_muliple), Integer.valueOf(i));
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRouteTrafficEventPop(TrafficEventPopParam trafficEventPopParam) {
        BaseScene currentScene = getCurrentScene();
        hideRestrictedPopOnOtherElementShow();
        if (!(currentScene instanceof BaseMapScene) || Utils.isRestrictScene(currentScene)) {
            return;
        }
        ((BaseMapScene) currentScene).showSceneTrafficEventPop(trafficEventPopParam);
    }

    private boolean isStartAiMsg() {
        Bundle bundle = getBridge().getBundle();
        return bundle != null && RouteBridge.ROUTE_SENDER_AIMSG.equals(bundle.getString(RouteBridge.ROUTE_SENDER));
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public int getOfflineRemainTime() {
        OfflinePopView offlinePopView;
        if (isSceneLegal() && (offlinePopView = this.mOfflineView) != null && offlinePopView.getVisibility() == 0) {
            return this.mOfflineView.getRemainTime();
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.views.TipsView.IActionListener
    public void onTipsAction() {
        this.mPresenter.handleDetailIncident();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRouting(boolean z) {
        L.i(TAG, ">>> showRouting isOffline=" + z);
        if (isSceneLegal()) {
            if (this.mRoutingDialog == null) {
                this.mRoutingDialog = new XLandLoadingDialog(getActivity());
                this.mRoutingDialog.setCancelable(false);
            }
            boolean isNetworkConnected = XPNetworkManager.INSTANCE.isNetworkConnected();
            if (!z) {
                z = !isNetworkConnected;
            }
            this.mRoutingDialog.setMessage(getString(z ? R.string.route_offline_routing : R.string.route_routing));
            this.mRoutingDialog.show();
            this.mRoutingDialog.correctedLocation();
            hideExploreAndReferenceForVoice();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void hideExploreAndReferenceForVoice() {
        if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported() && this.mPresenter.isRouteFromSpeech()) {
            XLinearLayout xLinearLayout = this.mDebugContainer;
            if (xLinearLayout != null && 8 != xLinearLayout.getVisibility()) {
                this.mDebugContainer.setVisibility(8);
            }
            RoutePreferenceView routePreferenceView = this.mRoutePreferenceView;
            if (routePreferenceView == null || 8 == routePreferenceView.getVisibility()) {
                return;
            }
            this.mRoutePreferenceView.setVisibility(8);
        }
    }

    private void showExploreAndReferenceForVoice() {
        if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported() && this.mPresenter.isRouteFromSpeech()) {
            XLinearLayout xLinearLayout = this.mDebugContainer;
            if (xLinearLayout != null && xLinearLayout.getVisibility() != 0) {
                this.mDebugContainer.setVisibility(0);
            }
            RoutePreferenceView routePreferenceView = this.mRoutePreferenceView;
            if (routePreferenceView == null || routePreferenceView.getVisibility() == 0) {
                return;
            }
            this.mRoutePreferenceView.setVisibility(0);
            updateRestrictLayout();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void hideRouting() {
        L.i(TAG, ">>> hideRouting");
        XLandLoadingDialog xLandLoadingDialog = this.mRoutingDialog;
        if (xLandLoadingDialog != null) {
            xLandLoadingDialog.dismiss();
        }
        showExploreAndReferenceForVoice();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onSceneMapFragmentResult(int i, Bundle bundle) {
        if (bundle != null && 200 == i && bundle.getBoolean(SettingPreferencePresenter.ROUTE_CHANGE_TYPE)) {
            hideSceneTrafficEventPop();
            hidePoiPop();
            this.mPresenter.requestReroute(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickOverView() {
        showRoutePreview();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onClickBlank(long j, float f, float f2) {
        super.onClickBlank(j, f, f2);
        this.mPresenter.onClickBlank();
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

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public boolean onClickRecenter() {
        showRoutePreview();
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickRouteChargeSwitch() {
        boolean z = !this.mPresenter.isRouteChargeEnable();
        this.mPresenter.onRouteChargePlanBtnSwitched(z);
        updateRouteChargePlanSwitchStatus(z, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickZoomView(boolean z) {
        showOverViewButton(true);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onMotionEvent(long j, int i, long j2, long j3) {
        super.onMotionEvent(j, i, j2, j3);
        showOverViewButton(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideRouteDetail() {
        if (this.mRoutContent.getVisibility() == 0) {
            this.mRoutContent.setVisibility(8);
            this.mShowRoutePanelOnPoiHide = true;
        }
    }

    private void showRouteDetail() {
        XRelativeLayout xRelativeLayout;
        if (isSceneLegal() && (xRelativeLayout = this.mRoutContent) != null && xRelativeLayout.getVisibility() != 0 && this.mShowRoutePanelOnPoiHide) {
            this.mRoutContent.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopShow(View view, double d, double d2) {
        super.onTrafficEventPopShow(view, d, d2);
        showBackToRouteView(true);
        hideRouteDetail();
        this.mPresenter.hideRouteChargePanel(false);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopHide(View view) {
        super.onTrafficEventPopHide(view);
        if (Utils.isLandscape()) {
            showRoutePreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public RectInt getCurrentFreeBound() {
        if (Utils.isPortrait()) {
            if (this.mPresenter.isRouteFromSpeech() && this.mInfoFlowCardHeight != 0) {
                this.mFreeBound.top = this.mInfoFlowCardHeight;
            } else {
                this.mFreeBound.top = 0;
            }
        } else {
            this.mFreeBound.top = ContextUtils.getDimensionPixelSize(R.dimen.route_scene_back_bar_height) - ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_bg_margin);
        }
        L.Tag tag = TAG;
        L.i(tag, "getCurrentFreeBound:" + this.mFreeBound.top);
        return this.mFreeBound;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene
    protected void setTrafficEventLayerState() {
        getMapView().setTrafficEventLayerState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RouteChargePanelView getRouteChargePanelView() {
        if (this.mRouteChargePanelView == null && this.mRouteChargeStub.getParent() != null) {
            this.mRouteChargeStub.inflate();
            this.mRouteChargePanelView = (RouteChargePanelView) this.mRootView.findViewById(R.id.route_charge_panel);
            this.mRouteChargePanelView.setChargeBarVisible(true);
            this.mRouteChargePanelView.setListener(this.mPresenter);
        }
        return this.mRouteChargePanelView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updateRouteChargePlanSwitchStatus(boolean z, boolean z2) {
        if (isSceneLegal()) {
            MapUIStatus uIStatus = getUIStatus();
            uIStatus.mRouteChargeTipsVisibility = z2 ? 0 : 8;
            uIStatus.mRouteChargeEnable = z ? 1 : 0;
            updateUIStatus(uIStatus);
        }
    }

    private void showRouteChargeContainer(boolean z) {
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mRouteChargeVisibility = z ? 0 : 8;
        uIStatus.mRouteChargeEnable = 0;
        updateUIStatus(uIStatus);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showChargeLoading(final boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "ROUTE_CHARGE showLoadingCharge: " + z);
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.9
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    if (RouteFragment.this.mChargeLoadingDialog == null) {
                        RouteFragment routeFragment = RouteFragment.this;
                        routeFragment.mChargeLoadingDialog = new XLandLoadingDialog(routeFragment.getActivity());
                        RouteFragment.this.mChargeLoadingDialog.setCancelable(false);
                    }
                    RouteFragment.this.mChargeLoadingDialog.setMessage(RouteFragment.this.getString(R.string.route_charge_loading));
                    RouteFragment.this.mChargeLoadingDialog.show();
                    RouteFragment.this.mChargeLoadingDialog.correctedLocation();
                } else if (RouteFragment.this.mChargeLoadingDialog != null) {
                    RouteFragment.this.mChargeLoadingDialog.dismiss();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRouteChargeDetailView(final boolean z, final boolean z2, final boolean z3, final String str, final String str2, final long j, final long j2, final boolean z4, final long j3, final boolean z5, final boolean z6) {
        L.i(TAG, "showRouteChargeDetailView");
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.10
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.getRouteChargePanelView() == null) {
                    return;
                }
                RouteFragment.this.hidePoiPop();
                RouteFragment.this.showBackToRouteView(true);
                RouteFragment.this.hideRouteDetail();
                RouteFragment.this.hideOfflineViewOnOtherElementShow();
                RouteFragment.this.hideSceneTrafficEventPop();
                if (RouteFragment.this.mRestrictHelper.isRestrictVisible()) {
                    RouteFragment.this.hideRestrictedPopOnOtherElementShow();
                }
                RouteFragment.this.mRouteChargePanelView.setVisibility(0);
                RouteFragment.this.mRouteChargePanelView.showDetail(z, z2, z3, str, str2, j, j2, z4, j3, z5, z6);
                RouteFragment.this.updateRouteChargePanelViewLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRouteChargePanelViewLayout() {
        if (Utils.isPortrait() && this.mPresenter.isRouteFromSpeech() && this.mInfoFlowCardHeight != 0) {
            ((RelativeLayout.LayoutParams) this.mRouteChargePanelView.getLayoutParams()).topMargin = this.mInfoFlowCardHeight;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showRouteChargePlanDialog(final String str, final String str2, final IRouteChargeContract.IRoutePlanConfirmCallBack iRoutePlanConfirmCallBack) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.11
            @Override // java.lang.Runnable
            public void run() {
                final XTextDialog xTextDialog = new XTextDialog(RouteFragment.this.getActivity());
                xTextDialog.setContentText(str);
                xTextDialog.showTitle(false);
                xTextDialog.showClose(false);
                if (RouteFragment.this.mRouteChargePlanDialog != null && RouteFragment.this.mRouteChargePlanDialog.isShowing()) {
                    RouteFragment.this.mRouteChargePlanDialog.dismiss();
                }
                RouteFragment.this.mRouteChargePlanDialog = xTextDialog;
                xTextDialog.setOkButtonText(R.string.route_charge_plan_warning_confirm);
                xTextDialog.setCancelButtonText(R.string.route_charge_plan_warning_cancel);
                xTextDialog.showClose(false);
                xTextDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.11.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        xTextDialog.dismiss();
                        if (iRoutePlanConfirmCallBack != null) {
                            iRoutePlanConfirmCallBack.onConfirm(str2);
                        }
                    }
                });
                xTextDialog.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.11.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        xTextDialog.dismiss();
                    }
                });
                RouteFragment.this.mRouteChargePlanDialog.show();
                RouteFragment.this.mRouteChargePlanDialog.setCanceledOnTouchOutside(false);
                if (RouteFragment.this.isSceneVuiEnabled()) {
                    CommonVuiHelper.getInstance().addDialogVuiSupport(RouteFragment.this.mRouteChargePlanDialog, "RouteChargePlanDialog");
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void addRouteChargeToBar(final ChargeRouteView.ChargePoint chargePoint, final double d, final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.12
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.getRouteChargePanelView() == null) {
                    return;
                }
                RouteFragment.this.mRouteChargePanelView.setK(d);
                RouteFragment.this.mRouteChargePanelView.addCharge(chargePoint);
                RouteFragment.this.mRouteChargePanelView.updateChargeAddView(true, true);
                RouteFragment.this.mRouteChargePanelView.updateRouteChargeBarInfo(z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void removeRouteChargesOnBar(final List<String> list, final double d, final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.13
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.getRouteChargePanelView() == null) {
                    return;
                }
                RouteFragment.this.mRouteChargePanelView.setK(d);
                RouteFragment.this.mRouteChargePanelView.removeCharges(list);
                RouteFragment.this.mRouteChargePanelView.updateRouteChargeBarInfo(z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void initRouteChargeBar(final long j, final long j2, final long j3, final double d, final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.14
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.getRouteChargePanelView() == null) {
                    return;
                }
                RouteFragment.this.mRouteChargePanelView.removeAllCharge();
                RouteFragment.this.mRouteChargePanelView.updateRouteDistance(j, j2, j3, d);
                RouteFragment.this.mRouteChargePanelView.updateRouteChargeBarInfo(z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void hideRouteChargePanel(final boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "hideRouteChargePanel:" + z);
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.15
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.mRouteChargePanelView == null || RouteFragment.this.mRouteChargePanelView.getVisibility() == 8) {
                    return;
                }
                if (z) {
                    RouteFragment.this.restoreOfflineView();
                    RouteFragment.this.restoreRestrictedPopOnOtherElementHide();
                }
                RouteFragment.this.mRouteChargePanelView.setVisibility(8);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updateRouteChargesBar(final long j, final long j2, final long j3, final List<ChargeRouteView.ChargePoint> list, final double d, final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.16
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.getRouteChargePanelView() == null) {
                    return;
                }
                RouteFragment.this.mRouteChargePanelView.clearAndUpdateCharges(list);
                RouteFragment.this.mRouteChargePanelView.updateRouteDistance(j, j2, j3, d);
                RouteFragment.this.mRouteChargePanelView.updateRouteChargeBarInfo(z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void focusRouteChargeOnBar(ChargeRouteView.ChargePoint chargePoint) {
        if (getRouteChargePanelView() == null) {
            return;
        }
        this.mRouteChargePanelView.setSelect(chargePoint);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updatePreviewRect(final RectDouble rectDouble) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.17
            @Override // java.lang.Runnable
            public void run() {
                RouteFragment.this.updatePreviewRect(rectDouble, (RouteFragment.this.mPresenter.isRouteFromSpeech() && Utils.isPortrait()) ? RouteFragment.this.mInfoFlowCardHeight : 0);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updatePreviewRect(RectDouble rectDouble, int i) {
        XLinearLayout xLinearLayout;
        if (!isSceneLegal() || rectDouble == null || this.mRootView == null) {
            return;
        }
        Rect routePathOffsetRect = NaviUtil.getRoutePathOffsetRect();
        if (this.mPresenter.isRouteFromSpeech() && Utils.isLandscape()) {
            routePathOffsetRect = NaviUtil.getRoutePathOffsetRectForVoiceFusion();
        }
        if (Utils.isPortrait()) {
            if (this.mPresenter.isRouteFromSpeech() && i != 0 && (xLinearLayout = this.mDebugContainer) != null) {
                routePathOffsetRect.top = i;
                if (xLinearLayout.getVisibility() == 0) {
                    routePathOffsetRect.top += getResources().getDimensionPixelSize(R.dimen.guide_add_waypoint_height);
                }
            } else {
                RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
                if (routeChargePanelView != null && routeChargePanelView.getVisibility() == 0) {
                    routePathOffsetRect.top = this.mRouteChargePanelView.getMeasuredHeight() + getResources().getDimensionPixelSize(R.dimen.route_detail_margin_left) + getResources().getDimensionPixelSize(R.dimen.route_charge_preview_offset);
                }
            }
        }
        if (L.ENABLE) {
            L.d(TAG, "updatePreviewRect offset rect:" + routePathOffsetRect);
        }
        getMapView().showPreview(rectDouble, routePathOffsetRect.left, routePathOffsetRect.top, routePathOffsetRect.right, routePathOffsetRect.bottom);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void showOverViewButton(final boolean z) {
        if (this.mPresenter.isRouteChargeEnable()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.18
                @Override // java.lang.Runnable
                public void run() {
                    MapUIStatus uIStatus = RouteFragment.this.getUIStatus();
                    uIStatus.mOverViewVisibility = z ? 0 : 8;
                    uIStatus.mOverViewSelected = 0;
                    RouteFragment.this.updateUIStatus(uIStatus);
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updatePathK(double d) {
        if (getRouteChargePanelView() == null) {
            return;
        }
        this.mRouteChargePanelView.updatePathK(d);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updateRouteChargeCarRemain() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteFragment.19
            @Override // java.lang.Runnable
            public void run() {
                if (RouteFragment.this.getRouteChargePanelView() == null) {
                    return;
                }
                RouteFragment.this.mRouteChargePanelView.updateRouteChargeCarRemain();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void goBackToRoute() {
        backToMode(StatusConst.Mode.ROUTE, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void openSearchNormal() {
        executeAddWaypoint(this.mBtnAddWayPoint);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void onInfoflowCardHeightChanged(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onInfoflowCardHeightChanged height:" + i);
        }
        this.mInfoFlowCardHeight = i;
        updateDebugContainerLayoutForVoiceRoute();
        updateRoutePreferenceLayoutForVoiceRoute();
    }

    private void updateRoutePreferenceLayoutForVoiceRoute() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoutePreferenceView.getLayoutParams();
        if (this.mOldRoutePreferenceTopMargin == 0) {
            this.mOldRoutePreferenceTopMargin = layoutParams.topMargin;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateRoutePreferenceLayoutForVoiceRoute mOldRoutePreferenceTopMargin:" + this.mOldRoutePreferenceTopMargin);
        }
        if (Utils.isPortrait() && this.mPresenter.isRouteFromSpeech()) {
            int i = this.mInfoFlowCardHeight;
            if (i != 0) {
                layoutParams.topMargin = i;
                return;
            } else {
                layoutParams.topMargin = VoiceFusionUtil.getInstance().getDefaultInfoflowCardHeight(1);
                return;
            }
        }
        layoutParams.topMargin = this.mOldRoutePreferenceTopMargin;
    }

    private void updateDebugContainerLayoutForVoiceRoute() {
        XLinearLayout xLinearLayout;
        if (Utils.isPortrait() && this.mPresenter.isRouteFromSpeech() && (xLinearLayout = this.mDebugContainer) != null && xLinearLayout.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDebugContainer.getLayoutParams();
            int i = this.mInfoFlowCardHeight;
            if (i != 0) {
                layoutParams.topMargin = i;
            } else {
                layoutParams.topMargin = VoiceFusionUtil.getInstance().getDefaultInfoflowCardHeight(1);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public boolean isRouting() {
        XLandLoadingDialog xLandLoadingDialog = this.mRoutingDialog;
        return xLandLoadingDialog != null && xLandLoadingDialog.isShowing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_waypoint_container /* 2131296415 */:
            case R.id.btn_route_add_waypoint /* 2131296442 */:
                executeAddWaypoint(view);
                return;
            case R.id.btn_debug_explore /* 2131296420 */:
                executeStartExplore();
                return;
            case R.id.container_back_view /* 2131296503 */:
            case R.id.iv_back /* 2131296752 */:
            case R.id.tv_back /* 2131297448 */:
                handleBackClick(view);
                return;
            default:
                return;
        }
    }

    private void handleBackClick(View view) {
        if (this.mTvBack.getVisibility() == 0) {
            backToRoute();
            restoreRestrictedPopOnOtherElementHide();
            return;
        }
        onActionPerformed(view, 4);
    }

    @Override // com.xiaopeng.montecarlo.views.RoutePreferenceView.IActionListener
    public void onRoutePreferenceClick(View view) {
        if (view != null && preventMultiClick(view)) {
            startScene(new SettingBridge().setStartMode(1), 200);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiEnabled() {
        return CommonVuiHelper.getInstance().isSceneVuiSupport();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onInterceptVuiEvent view:" + view + ",vuiEvent:" + vuiEvent));
        }
        if (this.mPresenter.onInterceptVuiEvent(view, vuiEvent, this)) {
            return true;
        }
        return super.onInterceptVuiEvent(view, vuiEvent);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onVuiEvent(View view, VuiEvent vuiEvent) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onVuiEvent view:" + view + ",vuiEvent:" + vuiEvent));
        }
        if (this.mPresenter.onVuiEvent(view, vuiEvent, this)) {
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

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.LogicView
    public void updateOddInfo(List<XPOddInfo> list) {
        getMapView().getBizControlManager().updateOddInfo(list);
    }

    private void dynamicSetVuiLabel() {
        XRelativeLayout xRelativeLayout = this.mBtnCancelRoute;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVuiLabel(ContextUtils.getString(R.string.vui_label_route_exit_route));
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
        XRelativeLayout xRelativeLayout2 = this.mBtnStartExplore;
        commonVuiHelper3.enableCanSpeechControl(mainContext3, xRelativeLayout2, xRelativeLayout2, false);
        CommonVuiHelper commonVuiHelper4 = CommonVuiHelper.getInstance();
        MainContext mainContext4 = getMainContext();
        XRelativeLayout xRelativeLayout3 = this.mBtnCancelRoute;
        commonVuiHelper4.enableCanSpeechControl(mainContext4, xRelativeLayout3, xRelativeLayout3, false);
    }

    /* loaded from: classes2.dex */
    class OfflineListener implements OfflinePopView.IOfflinePopActionListener {
        OfflineListener() {
        }

        @Override // com.xiaopeng.montecarlo.views.OfflinePopView.IOfflinePopActionListener
        public void reRoute() {
            RouteFragment.this.mPresenter.requestOnlineRoute();
        }

        @Override // com.xiaopeng.montecarlo.views.OfflinePopView.IOfflinePopActionListener
        public void onVisibleStateExchanged(boolean z) {
            if (L.ENABLE) {
                L.Tag tag = RouteFragment.TAG;
                L.d(tag, "onVisibleStateExchanged isShow:" + z);
            }
            if (RouteFragment.this.isSceneVuiEnabled()) {
                RouteFragment routeFragment = RouteFragment.this;
                VoiceFullScenesUtil.updateScene(routeFragment, routeFragment.mOfflineView);
            }
        }
    }
}
