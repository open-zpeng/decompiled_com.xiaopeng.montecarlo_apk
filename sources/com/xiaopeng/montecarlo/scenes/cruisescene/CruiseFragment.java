package com.xiaopeng.montecarlo.scenes.cruisescene;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.InitializerManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.appengine.CarGreetingInfoClient;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.ExploreBridge;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.charge.recommendcharger.IRecommendChargerView;
import com.xiaopeng.montecarlo.charge.recommendcharger.RecommendChargePresenter;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.RecommendChargeDecorator;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment;
import com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract;
import com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper;
import com.xiaopeng.montecarlo.scenes.cruisescene.view.PoiConflictRecommendChargeView;
import com.xiaopeng.montecarlo.scenes.mapscene.MapStateObserver;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import com.xiaopeng.montecarlo.stat.RecommendChargeStatUtil;
import com.xiaopeng.montecarlo.stat.SearchStatUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.LaneInfoView;
import com.xiaopeng.montecarlo.views.OnViewStateChangedListener;
import com.xiaopeng.montecarlo.views.RecommendChargerView;
import com.xiaopeng.montecarlo.views.camera.CameraSimpleViewContainer;
import com.xiaopeng.montecarlo.views.camera.data.DataParseHelper;
import com.xiaopeng.montecarlo.views.dialog.XLandLoadingDialog;
import com.xiaopeng.montecarlo.views.dialog.XTextDialog;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.montecarlo.views.road.congestion.CongestionTextView;
import com.xiaopeng.montecarlo.views.road.congestion.data.CruiseDataParse;
import com.xiaopeng.montecarlo.views.road.congestion.data.IDataParse;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes2.dex */
public class CruiseFragment extends BaseMapScene implements ICruiseContract.LogicView, MapStateObserver.OnMapStateChangeListener, IRecommendChargerView, RecommendChargerView.RecommendChargeClickListener {
    private static final long MILLIS_IN_FUTURE = 10000;
    private static final L.Tag TAG = new L.Tag("CruiseFragment");
    private Unbinder mButterBinder;
    private RelativeLayout.LayoutParams mCameraLayoutParams;
    CameraSimpleViewContainer mCameraSimpleViewContainer;
    @BindView(R.id.view_camera_simple_stub)
    ViewStub mCameraSimpleViewStub;
    CongestionTextView mCruiseCongestionInfo;
    @BindView(R.id.cruise_congestion_info_stub)
    ViewStub mCruiseCongestionInfoStub;
    LaneInfoView mCruiseLane;
    @BindView(R.id.mapfragment_cruise_lanes_stub)
    ViewStub mCruiseLaneStub;
    private String mCurRoadName;
    private XLandLoadingDialog mDialog;
    private XCountDownTimer mDialogTimer;
    XRelativeLayout mGifGuideLayout;
    @BindView(R.id.rl_seamless_stub)
    ViewStub mGifGuideLayoutStub;
    @BindView(R.id.map_current_road_name)
    CurrentRoadNameView mMapCurrentRoadName;
    private RecommendChargePresenter mRecommendChargePresenter;
    private RelativeLayout.LayoutParams mRecommendChargerlayoutParams;
    PoiConflictRecommendChargeView mRecommendChargers;
    @BindView(R.id.cruise_recommend_chargers_stub)
    ViewStub mRecommendChargersStub;
    private View mTrafficBarView;
    @BindView(R.id.tv_charge_count)
    XTextView mTvChargeCount;
    @BindView(R.id.tv_search_content)
    XTextView mTvSearchContent;
    private ViewPropertyAnimator mViewAnimator;
    @BindView(R.id.view_container)
    XRelativeLayout mViewContainer;
    protected int mSavedMapMode = -1;
    protected int mSavedMapLevel = -1000;
    IDataParse mIDataParse = new CruiseDataParse();
    private Interpolator mInterpolator = new BounceInterpolator();
    private XTextDialog mResumeTripDialog = null;
    private String mSearchKeyword = "";
    private CruiseScenePresenter mPresenter = null;
    private boolean mAlreadyResumeTrip = false;
    private XCountDownTimer.ITimerCallback mITimerCallback = new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment.1
        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTick(long j) {
            String string = ContextUtils.getString(NavRestoreManager.isRestoreExplore(false) ? R.string.navi_restore_explore_dialog_continue : R.string.navi_restore_dialog_continue);
            if (CruiseFragment.this.mResumeTripDialog == null || !CruiseFragment.this.mResumeTripDialog.isShowing()) {
                return;
            }
            CruiseFragment.this.mResumeTripDialog.setOkButtonText(Utils.getTimeOutText((int) j, string));
        }

        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTimeOut() {
            L.Tag tag = CruiseFragment.TAG;
            L.i(tag, "onTimeOut dismiss mResumeTripDialog: " + CruiseFragment.this.mResumeTripDialog);
            if (CruiseFragment.this.mResumeTripDialog == null || !CruiseFragment.this.mResumeTripDialog.isShowing()) {
                return;
            }
            CruiseFragment.this.mResumeTripDialog.dismiss();
            CruiseFragment.this.resumeTrip(false, false);
        }
    };

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
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

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneStop() {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    public static BaseScene newInstance() {
        return new CruiseFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return PageType.NAVI_CRUISE;
    }

    @OnClick({R.id.tv_search_content})
    public void onClickSearchBox() {
        this.mPresenter.checkAndCallBackUserSearchInThread();
        hideSceneTrafficEventPop();
        startSearchScene();
    }

    @OnClick({R.id.tv_charge_count})
    public void onClickChargePanel(View view) {
        this.mPresenter.searchCharge();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cruise, (ViewGroup) null);
        this.mButterBinder = ButterKnife.bind(this, inflate);
        this.mPresenter.init();
        if (L.ENABLE) {
            L.d(TAG, "onSceneCreateView");
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        boolean z = false;
        boolean z2 = bundle == null;
        if (!InitializerManager.getInstance().isInApplicationRestore()) {
            z = z2;
        } else if (InitializerManager.getInstance().isInRouteRestore()) {
            InitializerManager.getInstance().addRestoreCallback(new InitializerManager.IRestoreCallback() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseFragment$_ISKzrPR0Z-EZEE-9Zv94CmHNbc
                @Override // com.xiaopeng.montecarlo.InitializerManager.IRestoreCallback
                public final void finish() {
                    CruiseFragment.this.restoreRoute();
                }
            });
        } else {
            restoreRoute();
        }
        this.mPresenter.initView(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        this.mPresenter.onResume();
        toggleViewShowConflict();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void moveSearchBar(boolean z) {
        this.mTvChargeCount.setVisibility(z ? 8 : 0);
        animateStart(z);
    }

    private void animateStart(boolean z) {
        if (this.mViewAnimator == null) {
            this.mViewAnimator = this.mTvSearchContent.animate().setInterpolator(this.mInterpolator).setDuration(200L);
        }
        this.mViewAnimator.translationY(z ? CarGreetingInfoClient.getInstance().getCarGreetingRect() : 0.0f).start();
    }

    private void animateCancel() {
        ViewPropertyAnimator viewPropertyAnimator = this.mViewAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            this.mViewAnimator = null;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void renderCommutingForecastRoutes(IPathResult iPathResult, long j, boolean z) {
        if (isSceneLegal()) {
            L.Tag tag = TAG;
            L.i(tag, "renderCommutingForecastRoutes requestId=" + j + " isFromCarGreeting=" + z);
            getMainContext().addRoutePointsOverlay(this);
            TBTManager.getInstance().startRoute(ThemeWatcherUtil.getMapModeByCurrentTheme());
            this.mSavedMapLevel = getMapView().getMapLevel();
            this.mSavedMapMode = getMapView().getMapMode();
            getMapView().setMapMode(0, false);
            showRoutePreview(z, getMapView().getBizControlManager().drawRoute(769, iPathResult, TBTManager.getInstance().getRouteData(j).mRouteParams, j, 0, false));
            getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, true);
        }
    }

    private void showRoutePreview(boolean z, RectDouble rectDouble) {
        int i;
        if (isSceneLegal() && rectDouble != null) {
            Rect routePathOffsetRect = NaviUtil.getRoutePathOffsetRect();
            if (z) {
                i = CarGreetingInfoClient.getInstance().getCarGreetingRect();
            } else {
                i = routePathOffsetRect.top;
            }
            getMapView().showPreview(rectDouble, routePathOffsetRect.left, i, routePathOffsetRect.right, routePathOffsetRect.bottom);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void showCommutingForecast(int i, long j, long j2) {
        if (L.ENABLE) {
            L.d(TAG, "showCommutingForecast");
        }
        if (!isSceneLegal() || isResumeTripState()) {
            return;
        }
        setAiMsgShow(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        this.mPresenter.onPause();
        dismissLoadingDialog();
        unSelectRecommendChargers();
        toggleViewShowConflict();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void initRecomendChargeListener() {
        this.mRecommendChargePresenter = new RecommendChargePresenter(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void initDialogTimer() {
        this.mDialogTimer = new XCountDownTimer(10000L, this.mITimerCallback);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void setAiMsgShow(boolean z) {
        getMainContext().getAiMsgManager().setOnlyMapShow(z);
    }

    private void updateNaviGuiderEnter() {
        loadGifImageButton();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void updateSearchPanel(boolean z) {
        if (TextUtils.isEmpty(this.mSearchKeyword)) {
            this.mTvSearchContent.setText(R.string.search_hint_default);
        } else {
            this.mTvSearchContent.setText(this.mSearchKeyword);
        }
    }

    private boolean isShowNaviGuiderView() {
        return getActivity() != null && this.mPresenter.checkShowNaviGuiderView();
    }

    private void switchGifGuiderViewStatus(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "switchGifGuiderViewStatus" + z);
        }
        if (z && this.mGifGuideLayout == null) {
            this.mGifGuideLayout = (XRelativeLayout) this.mGifGuideLayoutStub.inflate();
            if (isSceneVuiEnabled()) {
                CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
                MainContext mainContext = getMainContext();
                XRelativeLayout xRelativeLayout = this.mGifGuideLayout;
                commonVuiHelper.enableCanSpeechControl(mainContext, xRelativeLayout, xRelativeLayout, false);
            }
            this.mGifGuideLayout.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CruiseFragment.this.preventMultiClick(view)) {
                        NaviGuiderStatUtil.bIGifIconBtn();
                        CruiseFragment.this.startNaviGuiderScene();
                    }
                }
            });
        }
        if (this.mGifGuideLayout != null) {
            if (z && !this.mPresenter.isImmerseState()) {
                this.mGifGuideLayout.setVisibility(0);
            } else {
                this.mGifGuideLayout.setVisibility(8);
            }
            updateCameraLayout();
            setLandscapeRecommendChargersLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLandscapeRecommendChargersLayout() {
        PoiConflictRecommendChargeView poiConflictRecommendChargeView;
        if (Utils.isLandscape() && (poiConflictRecommendChargeView = this.mRecommendChargers) != null && poiConflictRecommendChargeView.getVisibility() == 0) {
            if (this.mRecommendChargerlayoutParams == null) {
                this.mRecommendChargerlayoutParams = (RelativeLayout.LayoutParams) this.mRecommendChargers.getLayoutParams();
            }
            CameraSimpleViewContainer cameraSimpleViewContainer = this.mCameraSimpleViewContainer;
            if (cameraSimpleViewContainer != null && cameraSimpleViewContainer.getVisibility() == 0) {
                this.mRecommendChargerlayoutParams.addRule(3, R.id.view_camera_simple);
            } else {
                XRelativeLayout xRelativeLayout = this.mGifGuideLayout;
                if (xRelativeLayout != null && xRelativeLayout.getVisibility() == 0) {
                    this.mRecommendChargerlayoutParams.addRule(3, R.id.rl_seamless);
                } else {
                    this.mRecommendChargerlayoutParams.addRule(3, R.id.tv_search_content);
                }
            }
            this.mRecommendChargers.setLayoutParams(this.mRecommendChargerlayoutParams);
        }
    }

    private void startSearchScene() {
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_MODE, 100);
        bundle.putInt(SearchBridge.FROM_SCENE_INDEX, -1);
        bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, this.mSearchKeyword);
        startScene(new SearchBridge().setBundle(bundle), 100);
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.SEARCH_ENTER_MAIN, new Object[0]);
        this.mSearchKeyword = "";
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void startNaviGuiderScene() {
        this.mSpeechEventBizHelper.openLinkSeamlessNavi(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void remoteSetMapLevel(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "remoteSetMapLevel" + i + "___" + getMainContext().getMapView().getMapLevel());
        }
        if (i != getMainContext().getMapView().getMapLevel()) {
            getMainContext().getMapView().setMapLevel(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void remoteClearRenderRoutes(long j, boolean z) {
        getMapView().getBizControlManager().remoteClearRenderRoutes();
        TBTManager.getInstance().clearRouteData(j);
        getMapView().exitPreview(z, true);
        if (this.mSavedMapMode != -1) {
            getMapView().setMapMode(this.mSavedMapMode);
            getMapView().setMapLevel(this.mSavedMapLevel);
        }
    }

    @MainThread
    private void loadGifImageButton() {
        isShowNaviGuiderView();
        switchGifGuiderViewStatus((isShowTraffic() || isShowPoiCard()) ? false : false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void updateMapCurrentRoadStatus(boolean z) {
        CurrentRoadNameView currentRoadNameView = this.mMapCurrentRoadName;
        if (currentRoadNameView != null) {
            currentRoadNameView.setVisibility((z && this.mPresenter.needShowRoadName()) ? 0 : 8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public CarLoc getCarLocation() {
        return getMapView().getBizControlManager().getCarLocation();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.MapStateObserver.OnMapStateChangeListener
    public void notifyRefreshGifGuider() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseFragment$1cWwn2Qdct21mMoezN95OkSa9rg
            @Override // java.lang.Runnable
            public final void run() {
                CruiseFragment.this.lambda$notifyRefreshGifGuider$0$CruiseFragment();
            }
        });
    }

    public /* synthetic */ void lambda$notifyRefreshGifGuider$0$CruiseFragment() {
        if (coverGifGuiderView()) {
            return;
        }
        loadGifImageButton();
    }

    private boolean isShowTraffic() {
        View view = this.mTrafficBarView;
        return view != null && view.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowPoiCard() {
        return isPoiCardShowing();
    }

    private boolean coverGifGuiderView() {
        if (isShowTraffic() || isShowPoiCard()) {
            hideGuideLayout();
            return true;
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    @MainThread
    public void updateMapCurrentRoadName(String str) {
        if (TextUtils.isEmpty(str)) {
            updateMapCurrentRoadStatus(false);
        } else {
            if (StatusConst.Mode.CRUISE == getMainContext().getCurrentScene().getCurrentSceneMode()) {
                updateMapCurrentRoadStatus(true);
            }
            CurrentRoadNameView currentRoadNameView = this.mMapCurrentRoadName;
            if (currentRoadNameView != null) {
                currentRoadNameView.setText(str);
            }
        }
        this.mCurRoadName = str;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void onUpdateCruiseCongestionInfo(XPCruiseCongestionInfo xPCruiseCongestionInfo) {
        L.Tag tag = TAG;
        L.i(tag, "onUpdateCruiseCongestionInfo" + GsonUtil.toJson(xPCruiseCongestionInfo) + "++++" + this.mCruiseCongestionInfo + "___" + this.mTvSearchContent);
        this.mIDataParse.parseCongestionData(xPCruiseCongestionInfo);
        if (TextUtils.isEmpty(this.mIDataParse.parseCongestionStr()) && this.mCruiseCongestionInfo == null) {
            this.mCruiseCongestionInfo = (CongestionTextView) this.mCruiseCongestionInfoStub.inflate();
        }
        CongestionTextView congestionTextView = this.mCruiseCongestionInfo;
        if (congestionTextView != null) {
            congestionTextView.setShowCongestion(this.mIDataParse.parseCongestionStr(), this.mIDataParse.parseCongestionColor());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    @MainThread
    public void onShowCruiseLaneInfo(final XPLaneInfo xPLaneInfo) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseFragment$gxVVl1KHilhDi6SJETncTitQ6dw
            @Override // java.lang.Runnable
            public final void run() {
                CruiseFragment.this.lambda$onShowCruiseLaneInfo$1$CruiseFragment(xPLaneInfo);
            }
        });
    }

    public /* synthetic */ void lambda$onShowCruiseLaneInfo$1$CruiseFragment(XPLaneInfo xPLaneInfo) {
        if (this.mCruiseLane == null) {
            this.mCruiseLane = (LaneInfoView) this.mCruiseLaneStub.inflate();
        }
        this.mCruiseLane.updateLaneData(xPLaneInfo);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void onHideCruiseLaneInfo() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseFragment$Jy_CbHxg8VFlkri6bA7uMFoXv78
            @Override // java.lang.Runnable
            public final void run() {
                CruiseFragment.this.lambda$onHideCruiseLaneInfo$2$CruiseFragment();
            }
        });
    }

    public /* synthetic */ void lambda$onHideCruiseLaneInfo$2$CruiseFragment() {
        LaneInfoView laneInfoView = this.mCruiseLane;
        if (laneInfoView != null) {
            laneInfoView.removeAllViews();
            this.mCruiseLane.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void onStateImmersion() {
        getMainContext().onStateImmersion();
        switchGifGuiderViewStatus(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void onStateActive() {
        getMainContext().onStateActive();
        loadGifImageButton();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public RectInt getCurrentFreeBound() {
        if (Utils.isLandscape()) {
            this.mFreeBound.top = Utils.getVisibleViewsBottom(this.mTvSearchContent, this.mGifGuideLayout, this.mCameraSimpleViewContainer, this.mRecommendChargers) - ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_bg_margin_cruise);
        } else if (Utils.isPortrait()) {
            this.mFreeBound.top = 0;
        }
        return this.mFreeBound;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void updateViews() {
        updateSearchPanel(true);
        loadGifImageButton();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void registerMapStateObserver() {
        MapStateObserver.getInstance().registerMapStateObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        if (100 != i || bundle == null) {
            return;
        }
        this.mSearchKeyword = bundle.getString(SearchBridge.SEARCH_KEYWORD_TEXT);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void unregisterMapStateObserver() {
        MapStateObserver.getInstance().unregisterMapStateObserver();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void startRecommendCharge() {
        this.mRecommendChargePresenter.start();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void stopRecommendCharge() {
        this.mRecommendChargePresenter.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        super.onSceneDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mPresenter.onDestroy();
        Unbinder unbinder = this.mButterBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        XCountDownTimer xCountDownTimer = this.mDialogTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.stop();
        }
        animateCancel();
        updateAlreadyResumeTripState(false);
        this.mRecommendChargerlayoutParams = null;
        this.mTvSearchContent = null;
        this.mGifGuideLayout = null;
        this.mMapCurrentRoadName = null;
        this.mCruiseCongestionInfo = null;
        PoiConflictRecommendChargeView poiConflictRecommendChargeView = this.mRecommendChargers;
        if (poiConflictRecommendChargeView != null) {
            poiConflictRecommendChargeView.setOnVisibilityChangeListener(null);
        }
        this.mRecommendChargers = null;
        this.mTvChargeCount = null;
        CameraSimpleViewContainer cameraSimpleViewContainer = this.mCameraSimpleViewContainer;
        if (cameraSimpleViewContainer != null) {
            cameraSimpleViewContainer.setOnVisibilityChangeListener(null);
        }
        this.mCameraSimpleViewContainer = null;
        this.mCameraLayoutParams = null;
        this.mCruiseLane = null;
        XLandLoadingDialog xLandLoadingDialog = this.mDialog;
        if (xLandLoadingDialog == null || !xLandLoadingDialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public CruiseScenePresenter mo96getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(CruiseScenePresenter cruiseScenePresenter) {
        this.mPresenter = cruiseScenePresenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public MapStatus pickupRestoreMapStatusByRequestCodeDelegate(MapStatus mapStatus, MapStatus mapStatus2, int i) {
        if (this.mRestoreMapStatus == null || !this.mRestoreMapStatus.isValid()) {
            return (mapStatus == null || !mapStatus.isValid()) ? super.pickupRestoreMapStatusByRequestCodeDelegate(mapStatus, mapStatus2, i) : mapStatus;
        }
        this.mMapStatus = this.mRestoreMapStatus;
        return this.mMapStatus;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void resumeTrip(boolean z, boolean z2) {
        if (this.mAlreadyResumeTrip || InitializerManager.getInstance().isInApplicationRestore()) {
            L.w(TAG, ">>> resumeTrip start routefragment already resume trip");
            return;
        }
        L.i(TAG, ">>> resumeTrip start routefragment");
        updateAlreadyResumeTripState(true);
        L.Tag tag = TAG;
        L.i(tag, "resumeTrip mAlreadyResumeTrip:" + this.mAlreadyResumeTrip);
        Bundle bundle = RouteRequest.createRestoreRequest().toBundle();
        bundle.putString(SystemConst.ROUTE_TYPE_KEY, SystemConst.ROUTE_TYPE_RESTORE_ROUTE);
        bundle.putBoolean(SystemConst.IS_RESTORE_NAVI_AUTOMATICALLY, z);
        bundle.putBoolean(SystemConst.IS_RESTART_RESTORE_NAVI, z2);
        this.mPresenter.requestResumeTrip(bundle);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void startRouteSceneForResumeTrip(Bundle bundle) {
        IBaseScene currentScene = getMainContext().getCurrentScene();
        if (currentScene != null) {
            this.mPresenter.checkAndCallBackUserSearchInThread();
            currentScene.startScene(new RouteBridge().setBundle(bundle));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void showResumeTripDialog() {
        RouteParams restoreRouteParams = TBTManager.getInstance().getRestoreRouteParams();
        if (restoreRouteParams != null) {
            String name = restoreRouteParams.mEndInfo.getName();
            if (TextUtils.isEmpty(name)) {
                name = restoreRouteParams.mEndInfo.getAddress();
            }
            final XTextDialog xTextDialog = new XTextDialog(getActivity());
            xTextDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    CruiseFragment.this.setAiMsgShow(false);
                }
            });
            xTextDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (CruiseFragment.this.getMainContext().getCurrentScene().getMode() == StatusConst.Mode.CRUISE) {
                        CruiseFragment.this.setAiMsgShow(true);
                    }
                }
            });
            xTextDialog.setTitle(NavRestoreManager.isRestoreExplore(false) ? R.string.navi_restore_explore_dialog_title : R.string.navi_restore_dialog_title);
            XTextDialog xTextDialog2 = this.mResumeTripDialog;
            if (xTextDialog2 != null && xTextDialog2.isShowing()) {
                this.mResumeTripDialog.dismiss();
            }
            this.mResumeTripDialog = xTextDialog;
            this.mDialogTimer.start();
            xTextDialog.setOkButtonText(NavRestoreManager.isRestoreExplore(false) ? R.string.navi_restore_explore_dialog_continue : R.string.navi_restore_dialog_continue);
            xTextDialog.setCancelButtonText(R.string.navi_restore_dialog_cancel);
            if (TextUtils.isEmpty(name)) {
                xTextDialog.setContentText("");
            } else {
                xTextDialog.setContentText(getString(R.string.navi_restore_dialog_submsg, name));
            }
            xTextDialog.showClose(false);
            xTextDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CruiseFragment.this.mDialogTimer.stop();
                    xTextDialog.dismiss();
                    CruiseFragment.this.resumeTrip(false, false);
                    NaviStatUtil.sendStatDataWhenNaviRestoreStart(CruiseFragment.this.getMainContext());
                }
            });
            xTextDialog.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CruiseFragment.this.mDialogTimer.stop();
                    xTextDialog.dismiss();
                    CruiseFragment.this.mPresenter.cancelRestoreRoute();
                    NaviStatUtil.sendStatDataWhenNaviRestoreClose(CruiseFragment.this.getMainContext());
                }
            });
            this.mResumeTripDialog.show();
            this.mResumeTripDialog.setCanceledOnTouchOutside(false);
            if (isSceneVuiEnabled()) {
                CommonVuiHelper.getInstance().addDialogVuiSupport(this.mResumeTripDialog, "ResumeTripDialog");
            }
            NaviStatUtil.sendStatDataWhenNaviRestoreCardShow(getMainContext());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public boolean isNeedShowResumeTripShowing() {
        XTextDialog xTextDialog = this.mResumeTripDialog;
        return xTextDialog != null && xTextDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreRoute() {
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        if (currentNaviId != -1) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "requestID == " + currentNaviId);
            }
            Bundle bundle = new Bundle();
            bundle.putLong(SystemConst.START_NAVI_ID, currentNaviId);
            bundle.putInt(SystemConst.START_NAVI_PATH_INDEX, TBTManager.getInstance().getCurrentNaviPathIndex());
            bundle.putBoolean(NaviUtil.IS_NEED_TTSPROXY_SPEAK, false);
            bundle.putBoolean(SystemConst.IS_REQUEST_RESTRICT, true);
            bundle.putBoolean(NaviUtil.IS_NEED_START_NAVI_KEY, false);
            bundle.putBoolean(NaviUtil.IS_NEED_TO_SR, true);
            if (TBTManager.getInstance().getCurrentStatus() == 1) {
                startScene(new NaviBridge().setBundle(bundle));
            } else if (TBTManager.getInstance().getCurrentStatus() == 2) {
                startScene(new ExploreBridge().setBundle(bundle));
            }
        }
    }

    private void executeOnPoiShow() {
        this.mPresenter.checkAndCallBackUserSearchInThread();
        setAiMsgShow(false);
        hideGuideLayout();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiShow(PoiCardView poiCardView) {
        executeOnPoiShow();
        hideSceneTrafficEventPop();
        toggleViewShowConflict();
        super.onPoiShow(poiCardView);
        unSelectRecommendChargers();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiUpdate(PoiCardView poiCardView) {
        super.onPoiUpdate(poiCardView);
        unSelectRecommendChargers();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiHide(PoiCardView poiCardView) {
        super.onPoiHide(poiCardView);
        if (getMainContext().getCurrentScene().getMode() == StatusConst.Mode.CRUISE) {
            setAiMsgShow(true);
        }
        unSelectRecommendChargers();
        toggleViewShowConflict();
        loadGifImageButton();
    }

    private void toggleViewShowConflict() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("toggleViewShowConflictWithPoi canViewShow =");
            sb.append((isShowTraffic() || isShowPoiCard()) ? false : true);
            L.d(tag, sb.toString());
        }
        PoiConflictRecommendChargeView poiConflictRecommendChargeView = this.mRecommendChargers;
        boolean z = poiConflictRecommendChargeView == null || poiConflictRecommendChargeView.getVisibility() != 0;
        ToggleShowCardConflictHelper.toggleViewShow((isShowTraffic() || isShowPoiCard()) ? false : true, this.mCameraSimpleViewContainer, this.mRecommendChargers);
        PoiConflictRecommendChargeView poiConflictRecommendChargeView2 = this.mRecommendChargers;
        if (poiConflictRecommendChargeView2 != null && z && poiConflictRecommendChargeView2.getVisibility() == 0) {
            L.i(TAG, "toggleViewShowConflictWithPoi updateRecommendChargersTheme");
            updateRecommendChargersTheme();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void onUpdateCruiseFacility(final List<XPFacilityInfo> list) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseFragment$kd37aOG522NZkKRZXe-9m86uwg4
            @Override // java.lang.Runnable
            public final void run() {
                CruiseFragment.this.lambda$onUpdateCruiseFacility$4$CruiseFragment(list);
            }
        });
    }

    public /* synthetic */ void lambda$onUpdateCruiseFacility$4$CruiseFragment(List list) {
        if (CollectionUtils.isNotEmpty(list) || this.mCameraSimpleViewContainer != null) {
            if (this.mCameraSimpleViewContainer == null) {
                this.mCameraSimpleViewContainer = (CameraSimpleViewContainer) this.mCameraSimpleViewStub.inflate();
                this.mCameraSimpleViewContainer.setOnVisibilityChangeListener(new OnViewStateChangedListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseFragment$gLmJgwbdietitI-3FVATr-C7wic
                    @Override // com.xiaopeng.montecarlo.views.OnViewStateChangedListener
                    public final void onVisibleStateChanged(View view, VuiView vuiView, int i) {
                        CruiseFragment.this.lambda$null$3$CruiseFragment(view, vuiView, i);
                    }
                });
            }
            this.mCameraSimpleViewContainer.notifyListChange(DataParseHelper.parseCruisedataList(list));
            L.Tag tag = TAG;
            L.i(tag, "onUpdateCruiseFacility " + this.mCameraSimpleViewContainer.getVisibility());
        }
    }

    public /* synthetic */ void lambda$null$3$CruiseFragment(View view, VuiView vuiView, int i) {
        updateCameraLayout();
        setLandscapeRecommendChargersLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        super.onThemeSwitchDelegate(i);
        L.i(TAG, "onThemeSwitchDelegate");
        renderLayoutByDayNightStatus();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void renderLayoutByDayNightStatus() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "renderLayoutByDayNightStatus" + this.mTvSearchContent);
        }
        updateNaviGuiderEnter();
        onUpdateCruiseFacility(TBTManager.getInstance().getXPFacilityInfos());
        updateRecommendChargersTheme();
        onUpdateCruiseCongestionInfo(TBTManager.getInstance().getCruiseCongestionInfo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment$7  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ List val$beans;

        AnonymousClass7(List list) {
            this.val$beans = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CollectionUtils.isNotEmpty(this.val$beans) && CruiseFragment.this.mRecommendChargers == null) {
                CruiseFragment cruiseFragment = CruiseFragment.this;
                cruiseFragment.mRecommendChargers = (PoiConflictRecommendChargeView) cruiseFragment.mRecommendChargersStub.inflate();
                CruiseFragment.this.mRecommendChargers.setOnVisibilityChangeListener(new OnViewStateChangedListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseFragment$7$Eqaj-ALwNSZKpV7ARmDO7jAlmHk
                    @Override // com.xiaopeng.montecarlo.views.OnViewStateChangedListener
                    public final void onVisibleStateChanged(View view, VuiView vuiView, int i) {
                        CruiseFragment.AnonymousClass7.this.lambda$run$0$CruiseFragment$7(view, vuiView, i);
                    }
                });
            }
            if (CruiseFragment.this.mRecommendChargers != null) {
                if (Utils.isLandscape()) {
                    CruiseFragment.this.mRecommendChargers.setCanShowByOther(!CruiseFragment.this.isShowPoiCard());
                }
                CruiseFragment.this.mRecommendChargers.setRecommendViewDataList(this.val$beans, CruiseFragment.this);
            }
            if (CruiseFragment.this.isSceneVuiEnabled()) {
                CruiseVuiHelper.getInstance().syncRecommendChargeViewToVui(CruiseFragment.this.mRecommendChargers, CruiseFragment.this);
            }
        }

        public /* synthetic */ void lambda$run$0$CruiseFragment$7(View view, VuiView vuiView, int i) {
            CruiseFragment.this.setLandscapeRecommendChargersLayout();
        }
    }

    @Override // com.xiaopeng.montecarlo.charge.recommendcharger.IRecommendChargerView
    public void updateRecommendChargerView(List<RecommendChargerBean> list) {
        runOnUiThread(new AnonymousClass7(list));
    }

    private void updateRecommendChargersTheme() {
        PoiConflictRecommendChargeView poiConflictRecommendChargeView = this.mRecommendChargers;
        if (poiConflictRecommendChargeView != null) {
            int childCount = poiConflictRecommendChargeView.getChildCount();
            if (this.mRecommendChargers.getVisibility() == 0) {
                int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
                for (int i = 0; i < childCount; i++) {
                    RecommendChargerView recommendChargerView = (RecommendChargerView) this.mRecommendChargers.getChildAt(i);
                    if (recommendChargerView.getVisibility() == 0) {
                        recommendChargerView.updateTheme(carRemainDistance);
                    }
                }
            }
        }
    }

    private void unSelectRecommendChargers() {
        XPPoiInfo poiInfo = (!isShowPoiCard() || getPoiCard() == null) ? null : getPoiCard().getPoiInfo();
        PoiConflictRecommendChargeView poiConflictRecommendChargeView = this.mRecommendChargers;
        if (poiConflictRecommendChargeView != null) {
            int childCount = poiConflictRecommendChargeView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RecommendChargerView recommendChargerView = (RecommendChargerView) this.mRecommendChargers.getChildAt(i);
                if (recommendChargerView.getVisibility() == 0 && (recommendChargerView.getPoiInfo() == null || poiInfo == null || !TextUtils.equals(recommendChargerView.getPoiInfo().getPoiId(), poiInfo.getPoiId()))) {
                    recommendChargerView.setSelectedState(false);
                }
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendChargerView.RecommendChargeClickListener
    public void onClickRecommendCharge(RecommendChargerBean recommendChargerBean) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PoiDetailDecorator.POI_INFO, recommendChargerBean.getXPPoiInfo());
        bundle.putInt(RecommendChargeDecorator.RECOMMEND_CHARGE_TYPE, recommendChargerBean.getType());
        getMainContext().getDecoratorManager().showMapDecorator(this, DecoratorType.RECOMMEND_CHARGE, bundle);
        getMainContext().getDecoratorManager().focus(this, DecoratorType.RECOMMEND_CHARGE, recommendChargerBean.getXPPoiInfo());
        RecommendChargeStatUtil.sendClickData(recommendChargerBean);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    @AnyThread
    public void goToMapOnCruise() {
        goToMap();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void hideCruisePoiPop() {
        getMainContext().getDecoratorManager().clearFocus(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void showLoadingDialog() {
        if (this.mDialog == null) {
            this.mDialog = new XLandLoadingDialog(getActivity());
            this.mDialog.setMessage(ContextUtils.getString(R.string.dialog_loading_message));
            this.mDialog.setOnCancelListener(new XLoadingCancelButtonAction(this));
            this.mDialog.setCancelable(false);
        }
        if (this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        L.i(TAG, "showLoadingDialog");
        this.mDialog.show();
        this.mDialog.correctedLocation();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void dismissLoadingDialog() {
        XLandLoadingDialog xLandLoadingDialog = this.mDialog;
        if (xLandLoadingDialog == null || !xLandLoadingDialog.isShowing()) {
            return;
        }
        L.i(TAG, "dismissLoadingDialog");
        this.mDialog.dismiss();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public boolean isSearchLoading() {
        XLandLoadingDialog xLandLoadingDialog = this.mDialog;
        return xLandLoadingDialog != null && xLandLoadingDialog.isShowing();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public boolean isResumeTripState() {
        boolean z = isNeedShowResumeTripShowing() || this.mAlreadyResumeTrip;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isResumeTripState flag:" + z + ",isNeedShowResumeTripShowing:" + isNeedShowResumeTripShowing() + ",mAlreadyResumeTrip:" + this.mAlreadyResumeTrip);
        }
        return z;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void onMapRecenterUpdate() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseFragment.8
            @Override // java.lang.Runnable
            public void run() {
                if (CruiseFragment.this.isSceneLegal() && !TextUtils.isEmpty(CruiseFragment.this.mCurRoadName)) {
                    if (CruiseFragment.this.mPresenter.needShowRoadName()) {
                        CruiseFragment.this.updateMapCurrentRoadStatus(true);
                    } else {
                        CruiseFragment.this.updateMapCurrentRoadStatus(false);
                    }
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopShow(View view, double d, double d2) {
        this.mTrafficBarView = view;
        if (isSceneLegal()) {
            toggleViewShowConflict();
            hideGuideLayout();
            super.onTrafficEventPopShow(view, d, d2);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopHide(View view) {
        this.mTrafficBarView = view;
        if (isSceneLegal()) {
            super.onTrafficEventPopHide(view);
            loadGifImageButton();
            toggleViewShowConflict();
        }
    }

    private void hideGuideLayout() {
        XRelativeLayout xRelativeLayout = this.mGifGuideLayout;
        if (xRelativeLayout == null || xRelativeLayout.getVisibility() != 0) {
            return;
        }
        this.mGifGuideLayout.setVisibility(8);
        updateCameraLayout();
    }

    private void updateCameraLayout() {
        CameraSimpleViewContainer cameraSimpleViewContainer = this.mCameraSimpleViewContainer;
        if (cameraSimpleViewContainer == null || cameraSimpleViewContainer.getVisibility() != 0) {
            return;
        }
        if (this.mCameraLayoutParams == null) {
            this.mCameraLayoutParams = (RelativeLayout.LayoutParams) this.mCameraSimpleViewContainer.getLayoutParams();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("updateCameraLayout: mGifGuideLayout.getVisibility() = ");
            XRelativeLayout xRelativeLayout = this.mGifGuideLayout;
            sb.append(xRelativeLayout == null ? null : Integer.valueOf(xRelativeLayout.getVisibility()));
            L.d(tag, sb.toString());
        }
        XRelativeLayout xRelativeLayout2 = this.mGifGuideLayout;
        if (xRelativeLayout2 != null && xRelativeLayout2.getVisibility() == 0) {
            this.mCameraLayoutParams.addRule(3, R.id.rl_seamless);
        } else {
            this.mCameraLayoutParams.addRule(3, R.id.tv_search_content);
        }
        this.mCameraSimpleViewContainer.setLayoutParams(this.mCameraLayoutParams);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene
    protected void setTrafficEventLayerState() {
        getMapView().setTrafficEventLayerState(0);
    }

    @Override // com.xiaopeng.montecarlo.charge.recommendcharger.IRecommendChargerView
    public void updateTypeIcon() {
        PoiConflictRecommendChargeView poiConflictRecommendChargeView = this.mRecommendChargers;
        if (poiConflictRecommendChargeView != null) {
            int childCount = poiConflictRecommendChargeView.getChildCount();
            if (this.mRecommendChargers.getVisibility() == 0) {
                for (int i = 0; i < childCount; i++) {
                    RecommendChargerView recommendChargerView = (RecommendChargerView) this.mRecommendChargers.getChildAt(i);
                    if (recommendChargerView.getVisibility() == 0) {
                        recommendChargerView.setIconAndSign();
                    }
                }
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiEnabled() {
        return CommonVuiHelper.getInstance().isSceneVuiSupport();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onBuildScene() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        MainContext mainContext = getMainContext();
        XTextView xTextView = this.mTvSearchContent;
        commonVuiHelper.enableCanSpeechControl(mainContext, xTextView, xTextView, false);
        CommonVuiHelper commonVuiHelper2 = CommonVuiHelper.getInstance();
        MainContext mainContext2 = getMainContext();
        XRelativeLayout xRelativeLayout = this.mGifGuideLayout;
        commonVuiHelper2.enableCanSpeechControl(mainContext2, xRelativeLayout, xRelativeLayout, false);
        super.onBuildScene();
    }

    /* loaded from: classes2.dex */
    private static class XLoadingCancelButtonAction implements DialogInterface.OnCancelListener {
        private WeakReference<CruiseFragment> mWeakReference;

        public XLoadingCancelButtonAction(CruiseFragment cruiseFragment) {
            this.mWeakReference = new WeakReference<>(cruiseFragment);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CruiseFragment cruiseFragment = this.mWeakReference.get();
            if (cruiseFragment != null) {
                SearchStatUtil.sendStatDataWhenCancelSearch(cruiseFragment.getMainContext());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public boolean isTopSceneCruise() {
        return StatusConst.Mode.CRUISE == getMainContext().getCurrentScene().getCurrentSceneMode();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.LogicView
    public void updateAlreadyResumeTripState(boolean z) {
        this.mAlreadyResumeTrip = z;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "update already resume trip state:" + this.mAlreadyResumeTrip);
        }
    }
}
