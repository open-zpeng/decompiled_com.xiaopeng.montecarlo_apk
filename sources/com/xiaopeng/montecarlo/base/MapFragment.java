package com.xiaopeng.montecarlo.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.map.adapter.MapSurfaceView;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.DayNightFragment;
import com.xiaopeng.montecarlo.InitializerManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.account.AccountEventManager;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.action.schedule.IntentTaskScheduler;
import com.xiaopeng.montecarlo.appengine.MapMarkService;
import com.xiaopeng.montecarlo.appengine.MapVPAService;
import com.xiaopeng.montecarlo.base.MapFragment;
import com.xiaopeng.montecarlo.base.ScenesManager;
import com.xiaopeng.montecarlo.base.scene.FragmentRunnable;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.base.scene.SceneBuilder;
import com.xiaopeng.montecarlo.base.scene.SceneBuilderImpl;
import com.xiaopeng.montecarlo.base.scene.SceneLifeScheduler;
import com.xiaopeng.montecarlo.base.scene.SceneLifeSchedulerImpl;
import com.xiaopeng.montecarlo.base.scene.XPBroadcast;
import com.xiaopeng.montecarlo.base.scene.XPBroadcastImpl;
import com.xiaopeng.montecarlo.base.scene.XPHandlerBuilder;
import com.xiaopeng.montecarlo.base.scene.XPHandlerBuilderImpl;
import com.xiaopeng.montecarlo.bridge.ActivateBridge;
import com.xiaopeng.montecarlo.bridge.CruiseBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SettingBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorManager;
import com.xiaopeng.montecarlo.mapoverlay.mark.MarkPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.vpa.VPADecorator;
import com.xiaopeng.montecarlo.navcore.activate.ActivateManager;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.LaneServicePlayRecordWrapper;
import com.xiaopeng.montecarlo.navcore.sr.ProtoSimulator;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.MapModeUtil;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.MapSize;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract;
import com.xiaopeng.montecarlo.scenes.debugscene.CameraDegreeHelper;
import com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper;
import com.xiaopeng.montecarlo.scenes.mapscene.IMapContract;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapDelegate;
import com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter;
import com.xiaopeng.montecarlo.scenes.mapscene.MapStateObserver;
import com.xiaopeng.montecarlo.scenes.mapscene.MapTextureResourcesHelper;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import com.xiaopeng.montecarlo.service.navi.binder.NaviStatusService;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.montecarlo.stat.SpeechStatUtil;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.DialogUtils;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.SpeechEventBizHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.MapScaleLineView;
import com.xiaopeng.montecarlo.views.NavVolumeTipsView;
import com.xiaopeng.montecarlo.views.mapmode.DrawModeType;
import com.xiaopeng.montecarlo.views.mapmode.MapModeIconView;
import com.xiaopeng.montecarlo.views.road.CurrentRoadNameView;
import com.xiaopeng.montecarlo.views.volumn.VolumePanelView;
import com.xiaopeng.montecarlo.views.volumn.seekbar.VerticalSeekBar;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.vui.commons.VuiMode;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XSeekBar;
import com.xiaopeng.xui.widget.XTextView;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class MapFragment extends DayNightFragment implements ActivityLifecycleHelper.ActivityLifecycleListener, IMapContract.LogicView, ISpeechEvent, MapViewWrapper.IXPMapSurfaceListener {
    public static final String KEY_ARG_SAVED_WRAPPER_ID = "KEY_ARG_SAVED_WRAPPER_ID";
    private static final int MSG_QUERY_CP_DATA = 100;
    private static final int SURFACE_CORNER_RADIUS = 20;
    private static final L.Tag TAG = new L.Tag("MapFragment");
    TextView mADRDebugWindow;
    private DisposableObserver<Boolean> mAMapUnBindObserver;
    @BindView(R.id.btn_map_mode)
    MapModeIconView mBtnMapMode;
    @BindView(R.id.btn_recenter)
    CurrentRoadNameView mBtnMapRecenter;
    @BindView(R.id.btn_overview)
    XImageButton mBtnOverView;
    @BindView(R.id.btn_parallel)
    XImageButton mBtnRoadChange;
    @BindView(R.id.btn_setting)
    XImageButton mBtnSetting;
    Button mBtnSpeedDown;
    Button mBtnSpeedUp;
    @BindView(R.id.btn_volume)
    XImageButton mBtnVolume;
    @BindView(R.id.btn_zoom_in)
    XImageButton mBtnZoomIn;
    @BindView(R.id.btn_zoom_out)
    XImageButton mBtnZoomOut;
    Unbinder mButterBinder;
    @BindView(R.id.map_buttons)
    RelativeLayout mButtonsContainer;
    TextView mCalibrationSpeedWindow;
    View mContainerSpeed;
    TextView mDrDebugWindow;
    @BindView(R.id.img_auto_logo)
    XImageView mImgAutologo;
    private IntentTaskScheduler mIntentTaskScheduler;
    XTextView mLaneLonlatTv;
    Button mLanePlayBtn;
    XSeekBar mLanePlayProgress;
    Button mLaneRecordBtn;
    View mLaneRecordPlay;
    Button mLaneResetBtn;
    XTextView mLaneTimeTv;
    @BindView(R.id.left_btn_container)
    ViewGroup mLeftBtnContainer;
    TextView mLocationInfo;
    @BindView(R.id.location_info_container_stub)
    ViewStub mLocationInfoContainer;
    private View mLocationInfoView;
    private String[] mMapLevelTexts;
    @BindView(R.id.map_scale_text_bg)
    MapScaleLineView mMapScale;
    @BindView(R.id.map_scale_text_content)
    XTextView mMapScaleText;
    @BindView(R.id.map_scale_text_container)
    XLinearLayout mMapScaleTextContainer;
    @BindView(R.id.map_view)
    MapSurfaceView mMapView;
    @BindView(R.id.map_level_stepper)
    ViewGroup mMapZoomContainer;
    @BindView(R.id.mode_container)
    View mModeContainer;
    View mProtoPlay;
    XButton mProtoPlayBtn;
    XSeekBar mProtoPlayProgress;
    TextView mProtoSaveTime;
    private View mRootView;
    @BindView(R.id.route_charge_plan_switch_btn)
    XImageButton mRouteChargeSwitchBtn;
    @BindView(R.id.route_charge_switch_container)
    View mRouteChargeSwitchContainer;
    TextView mRouteChargeTipsView;
    TextView mSRDataDebugDisplayStView;
    TextView mSRDataDebugDriveModeView;
    TextView mSRDataDebugFrameAveCostView;
    TextView mSRDataDebugFrameRateView;
    TextView mSRDataDebugInfoTipsView;
    TextView mSRDataDebugLaneStView;
    TextView mSRDataDebugLcTipsView;
    TextView mSRDataDebugLndsDisView;
    TextView mSRDataDebugOddStView;
    TextView mSRDataDebugOperateTipsView;
    @BindView(R.id.sr_data_debug_stub)
    ViewStub mSRDataDebugStub;
    TextView mSRDataDebugTTSStView;
    LinearLayout mSRDataDebugView;
    @BindView(R.id.sr_normal_switch)
    XImageView mSRNaviSwitch;
    protected ScenesManager mScenesManager;
    private SpeechStatUtil mSpeechStatUtil;
    @BindView(R.id.sr_mask)
    XImageView mSrMask;
    @BindView(R.id.debug_lane_record_play_stub)
    ViewStub mStubLaneRecordPlay;
    @BindView(R.id.debug_proto_play_stub)
    ViewStub mStubProtoPlay;
    @BindView(R.id.ngp_mask_take_over_weak)
    XImageView mTakeOverWeak;
    private AnimationDrawable mTakeOverWeakAnimator;
    private long mTotalMsgCount;
    TextView mTvSpeed;
    private VolumePanelView mVolumePanelViewManager;
    private final SpeechEventBizHelper mSpeechEventBizHelper = new SpeechEventBizHelper();
    private final ArrayList<ISceneMapFragmentListener> mSceneMapFragmentListeners = new ArrayList<>();
    private final MapDelegate mMapDelegate = new MapDelegate(this);
    private final AtomicInteger mWrapperIdGenerator = new AtomicInteger();
    protected MapScenePresenter mMapScenePresenter = null;
    protected boolean mIsRestoreCreation = false;
    private boolean mIsDraging = false;
    private int mSpeed = 1;
    private MainContext mMainContext = null;
    private final ScenesManager.SceneManagerListener mSceneManagerListener = new ScenesManager.SceneManagerListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment.1
        @Override // com.xiaopeng.montecarlo.base.ScenesManager.SceneManagerListener
        public void sceneCountChanged(int i) {
            MapFragment.this.sceneAdded(i);
        }

        @Override // com.xiaopeng.montecarlo.base.ScenesManager.SceneManagerListener
        public void backResultToMap(int i, Bundle bundle) {
            MapFragment.this.onBackResult(i, bundle);
        }
    };
    private final IStateListener mIStateListener = new IStateListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$2mbmKz1EbrcI7M3eSFiKzjexqaE
        @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
        public final void onStateChange(int i) {
            MapFragment.this.lambda$new$0$MapFragment(i);
        }
    };
    private boolean mIsInPreload = false;
    private SceneManagerState mSceneManagerState = null;
    private CaptureHelper mCaptureHelper = null;
    private CameraDegreeHelper mCameraDegreeHelper = null;
    private AccountEventManager mAccountEventManager = null;
    private boolean mIsParallelRoadShow = false;
    private boolean mIsSRNavi = false;
    private IBaseScene mEmptyScene = null;
    private int mMapWrapperId = -1;
    private volatile boolean mIsNeedCallGoBackCenter = true;
    private boolean mDrawFramFirst = false;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.xiaopeng.montecarlo.base.MapFragment.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 100) {
                MapFragment.this.mMapScenePresenter.queryChargeDB(false);
                MapFragment.this.mHandler.sendEmptyMessageDelayed(100, MapFragment.this.mMapScenePresenter.getChargeUpdateInterval());
            }
            return false;
        }
    });

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean dispatchSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public boolean getHoldBoolean(String str, boolean z) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public double getHoldDouble(String str, double d) {
        return 0.0d;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public int getHoldInt(String str, int i) {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public Parcelable getHoldParcelable(String str) {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public String getHoldString(String str, String str2) {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityStopped() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onSurfaceDestroy(int i) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void saveHoldBoolean(String str, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void saveHoldDouble(String str, double d) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void saveHoldInt(String str, int i) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void saveHoldParcelable(@Nullable String str, @Nullable Parcelable parcelable) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void saveHoldString(String str, String str2) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView, com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(MapScenePresenter mapScenePresenter) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setReturnResult(Bundle bundle) {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public final void stopSelf() {
    }

    public /* synthetic */ void lambda$new$0$MapFragment(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onStateChange state = " + i);
        }
        if (i == 1) {
            this.mMainContext.getDecoratorManager().clearFocus();
        }
    }

    @OnClick({R.id.btn_setting})
    public void onClickSetting(View view) {
        preventMultiClick(view);
        if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode() && StatusConst.Mode.SEARCH_RESULT == this.mMainContext.getCurrentScene().getMode()) {
            VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MapFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    if (MapFragment.this.isSceneLegal()) {
                        MapFragment.this.startSettingScene();
                    }
                }
            }, 500L);
            return;
        }
        startSettingScene();
    }

    @OnClick({R.id.sr_normal_switch})
    public void onClickSrAndNormalSwitch(View view) {
        L.i(TAG, "onClickSrAndNormalSwitch");
        preventMultiClick(view);
        if (!SRNaviManager.getInstance().canShowSRScene() || this.mSRNaviSwitch.getVisibility() != 0) {
            L.i(TAG, "onClickSrAndNormalSwitch return");
            return;
        }
        if (this.mIsSRNavi) {
            DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.SR_PAGE_ENTER_MAP, new Object[0]);
        } else {
            DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.MAP_PAGE_ENTER_SR, new Object[0]);
        }
        Iterator<ISceneMapFragmentListener> it = this.mSceneMapFragmentListeners.iterator();
        while (it.hasNext() && !it.next().onClickSRNaviMode()) {
        }
    }

    @OnClick({R.id.btn_zoom_in})
    public void onClickZoomIn(View view) {
        ArrayList<ISceneMapFragmentListener> arrayList;
        preventMultiClick(view);
        if (this.mMapScenePresenter.zoomIn() && (arrayList = this.mSceneMapFragmentListeners) != null) {
            Iterator<ISceneMapFragmentListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onClickZoomView(true);
            }
        }
        MapOpStatUtil.sendStatDataWhenMapZoomin(this.mMainContext);
    }

    @OnClick({R.id.btn_zoom_out})
    public void onClickZoomOut(View view) {
        ArrayList<ISceneMapFragmentListener> arrayList;
        preventMultiClick(view);
        if (this.mMapScenePresenter.zoomOut() && (arrayList = this.mSceneMapFragmentListeners) != null) {
            Iterator<ISceneMapFragmentListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onClickZoomView(false);
            }
        }
        MapOpStatUtil.sendStatDataWhenMapZoomout(this.mMainContext);
    }

    @OnClick({R.id.btn_parallel})
    public void onClickRoadChange(View view) {
        preventMultiClick(view);
        this.mMapScenePresenter.roadChange();
        MapOpStatUtil.sendStatDataWhenMapRoadChange(this.mMainContext);
    }

    @OnClick({R.id.btn_overview})
    public void onClickOverView(View view) {
        preventMultiClick(view);
        ArrayList<ISceneMapFragmentListener> arrayList = this.mSceneMapFragmentListeners;
        if (arrayList != null) {
            Iterator<ISceneMapFragmentListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onClickOverView();
            }
        }
        MapOpStatUtil.sendStatDataWhenOnClickOverview(this.mMainContext);
    }

    @OnLongClick({R.id.btn_overview})
    public boolean onLongClickOverView(View view) {
        preventMultiClick(view);
        ArrayList<ISceneMapFragmentListener> arrayList = this.mSceneMapFragmentListeners;
        if (arrayList != null) {
            Iterator<ISceneMapFragmentListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onClickOverView();
            }
        }
        MapOpStatUtil.sendStatDataWhenOnClickOverview(this.mMainContext);
        return true;
    }

    @OnClick({R.id.btn_map_mode})
    public void onClickMapMode(View view) {
        preventMultiClick(view);
        this.mMapScenePresenter.switchMapMode();
        MapOpStatUtil.sendStatDataWhenOnClickMapmode(this.mMainContext);
    }

    @OnClick({R.id.btn_recenter})
    public void onClickMapRecenter(View view) {
        boolean z;
        preventMultiClick(view);
        ArrayList<ISceneMapFragmentListener> arrayList = this.mSceneMapFragmentListeners;
        boolean z2 = false;
        if (arrayList != null) {
            Iterator<ISceneMapFragmentListener> it = arrayList.iterator();
            loop0: while (true) {
                z = false;
                while (it.hasNext()) {
                    boolean onClickRecenter = it.next().onClickRecenter();
                    if (z || onClickRecenter) {
                        z = true;
                    }
                }
            }
            z2 = z;
        }
        if (!z2) {
            MapViewWrapper mapView = getMapView();
            if (mapView != null && mapView.getPreviewParam() != null) {
                mapView.showPreview(mapView.getPreviewParam());
            } else {
                this.mMapScenePresenter.goBackMapCenter();
            }
        }
        MapOpStatUtil.sendStatDataWhenOnClickMapRecenter(this.mMainContext);
    }

    @OnClick({R.id.btn_volume})
    public void onClickVolume(View view) {
        preventMultiClick(view);
        this.mMapScenePresenter.showVolumePanelView();
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityResumed() {
        refreshRenderFps(true);
        if (getMapView() != null) {
            getMapView().renderResume();
        }
    }

    @Override // com.xiaopeng.montecarlo.util.ActivityLifecycleHelper.ActivityLifecycleListener
    public void onActivityCovered(boolean z) {
        L.i(TAG, "onActivityCovered");
        refreshRenderFps(false);
        if (z) {
            return;
        }
        if (getMapView() != null) {
            getMapView().renderPause();
        }
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported() && VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode()) {
            VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
        }
    }

    private void refreshRenderFps(boolean z) {
        if (getMapView() != null) {
            getMapView().setRenderFpsByMode(0, z ? 15 : 1);
            getMapView().setRenderFpsByMode(1, z ? getMapView().isLaneMode() ? 16 : 10 : 1);
            getMapView().setRenderFpsByMode(2, z ? getMapView().isLaneMode() ? 20 : 30 : 1);
            getMapView().setRenderFpsByMode(3, z ? 20 : 1);
        }
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceUtils.alwaysTraceBegin("Map onCreate");
        if (bundle != null) {
            bundle.putParcelable("android:fragments", null);
            bundle.putParcelable("android:support:fragments", null);
            restoreSceneManagerState(bundle);
        }
        this.mIsInPreload = false;
        this.mAccountEventManager = new AccountEventManager();
        this.mMapLevelTexts = getResources().getStringArray(R.array.map_levels_text);
        FragmentActivity activity = getActivity();
        createScenesManager(activity);
        createScenePresenter(activity == null ? (Application) getContext() : activity.getApplication());
        super.onCreate(bundle);
        this.mMapScenePresenter.init();
        this.mMapScenePresenter.registerEventBus();
        this.mMapScenePresenter.registerAccountAsync();
        this.mMapScenePresenter.registerAccountChangeObserver();
        this.mMapScenePresenter.setChargeEnable(SettingWrapper.isChargeEnable());
        this.mMapScenePresenter.registerXPCarStateListener();
        TraceUtils.alwaysTraceEnd();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        TraceUtils.alwaysTraceBegin("Map onCreateView");
        View view = this.mRootView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.fragment_map, viewGroup, false);
        }
        this.mRootView = view;
        if (this.mRootView == null) {
            throw new IllegalArgumentException("MapFragment root view is null");
        }
        NaviSpeechUtils.setPageType(PageType.NAVI_CRUISE);
        ActivityLifecycleHelper.getInstance().registerActivityLifecycleListener(this);
        this.mButterBinder = ButterKnife.bind(this, this.mRootView);
        TraceUtils.alwaysTraceEnd();
        return this.mRootView;
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        AccountEventManager accountEventManager = this.mAccountEventManager;
        if (accountEventManager != null) {
            accountEventManager.registerEvent();
        }
        initListener();
        formatElementsForVui();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        TraceUtils.alwaysTraceBegin("Map onActivityCreated");
        TBTManager.getInstance().initAsyncInfoColor(ContextUtils.getColor(R.color.color_route_detail_bg), ContextUtils.getColor(R.color.color_guide_turn_icon_road), ContextUtils.getColor(R.color.color_route_detail_arrow));
        this.mScenesManager.init(new SceneLifeScheduler(new SceneLifeSchedulerImpl(getChildFragmentManager())), new SceneBuilder(new SceneBuilderImpl()), this.mIntentTaskScheduler);
        SceneManagerState sceneManagerState = this.mSceneManagerState;
        if (sceneManagerState != null && sceneManagerState.mActive != null) {
            SceneState[] sceneStateArr = this.mSceneManagerState.mActive;
            int length = sceneStateArr.length;
            for (int i = length - 1; i >= 0; i--) {
                SceneState sceneState = sceneStateArr[i];
                if (sceneState.mSavedSceneState != null) {
                    sceneState.mSavedSceneState.setClassLoader(getClass().getClassLoader());
                    if (sceneState.mResultBundle != null) {
                        sceneState.mResultBundle.setClassLoader(getClass().getClassLoader());
                    }
                    if (sceneState.mSavedSceneState.getBoolean("scene:save_enable", false)) {
                        BaseBridge createBridge = StatusConst.Mode.createBridge(sceneState.mBridge);
                        if (createBridge != null) {
                            if (L.ENABLE) {
                                L.d(TAG, "baseBridge" + createBridge + ",getMode = " + createBridge.getMode());
                            }
                            createBridge.mSceneState = sceneState;
                            createBridge.startSceneForResult(this.mScenesManager, createBridge.getRequestCode(), createBridge.getBackSceneId());
                        }
                    } else if (i == 0 && length > 1 && getView() != null) {
                        getView().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MapFragment.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((IScene) MapFragment.this.mScenesManager.getCurrentScene()).showScene(MapFragment.this.mScenesManager.getSceneLifeScheduler());
                            }
                        }, 10L);
                    }
                }
            }
            InitializerManager.getInstance().setInRouteRestore(false);
        }
        if (this.mSpeechStatUtil == null) {
            this.mSpeechStatUtil = new SpeechStatUtil();
        }
        this.mSpeechStatUtil.init(this.mMainContext);
        InitializerManager.getInstance().initMapFragmentCycleInstanceSerivce(this.mMainContext);
        super.onActivityCreated(bundle);
        final DecoratorManager decoratorManager = new DecoratorManager(this.mMainContext);
        this.mMainContext.setDecoratorManager(decoratorManager);
        StateManager.getInstance().addListener(this.mIStateListener);
        this.mIsNeedCallGoBackCenter = true;
        MapSize calculateMapSize = CommonUtil.calculateMapSize(Utils.isLandscape());
        RootUtil.setMapSize(calculateMapSize);
        L.i(TAG, "map size width:" + calculateMapSize.getWidth() + ",height:" + calculateMapSize.getHeight());
        int mapWrapperId = getMapWrapperId(bundle);
        this.mMapWrapperId = mapWrapperId;
        TraceUtils.alwaysTraceBegin("MapFragement_bind_map");
        this.mMapScenePresenter.bindMapEngine(this.mMapView, calculateMapSize.getWidth(), calculateMapSize.getHeight(), mapWrapperId);
        if (CarFeatureManager.INSTANCE.isMapMarkEnable()) {
            MapMarkService.observerMarkPoint(this, new Observer() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$GVBBLDBAHHINkcCkHa_DdNGr1lo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MarkPointDecorator.showMark(DecoratorManager.this, (List) obj);
                }
            });
        }
        if (CarFeatureManager.INSTANCE.isVPAEnable()) {
            MapVPAService.observerVPA(this, new Observer() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$2LP4pBaGjcYpEg-Fv1QC7PISWMs
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MapFragment.this.lambda$onActivityCreated$2$MapFragment((String) obj);
                }
            });
            MapVPAService.checkVPAVersion();
        }
        setSurfaceCornerRadius(this.mMapView, 20.0f);
        this.mMapScenePresenter.initFavoriteOverlayManager();
        this.mMapScenePresenter.initMapLevel(MapUtil.getSavedMapMode(false));
        this.mMapScenePresenter.initMapMode();
        this.mMapScenePresenter.getMapView().startCheckCarIconStatus();
        TraceUtils.alwaysTraceEnd();
        MapModeIconView mapModeIconView = this.mBtnMapMode;
        if (mapModeIconView != null) {
            mapModeIconView.setMapViewWrapper(this.mMapScenePresenter.getMapView());
        }
        getMapView().setXPMapSurfaceListener(this);
        if (getMapView().isMapSurfaceCreate()) {
            this.mIsNeedCallGoBackCenter = false;
            getMapView().restoreCarPosition();
            getMapView().initMapCenter(true, true);
        }
        mapViewsDisplayController();
        renderLayoutByDayNightStatus(false);
        initMapDelegate();
        if (TBTManager.getInstance().getCurrentStatus() == 0) {
            TBTManager.getInstance().startCruise(ThemeWatcherUtil.getMapModeByCurrentTheme());
            if (getMapView() != null) {
                getMapView().getBizControlManager().removeRoute(BLParams.RouteOverlayGuide, true);
            }
        }
        this.mMapScenePresenter.goToRootPage(this.mIsRestoreCreation);
        registerAMapUnbindObserver();
        AccountManager.getInstance().startAccountInit();
        this.mHandler.sendEmptyMessageDelayed(100, this.mMapScenePresenter.getChargeUpdateInterval());
        TraceUtils.alwaysTraceEnd();
    }

    public /* synthetic */ void lambda$onActivityCreated$2$MapFragment(String str) {
        VPADecorator.showVPA(this.mMapScenePresenter, str);
    }

    private void setSurfaceCornerRadius(SurfaceView surfaceView, float f) {
        if (surfaceView == null) {
            return;
        }
        try {
            SurfaceView.class.getMethod("setCornerRadius", Float.TYPE).invoke(surfaceView, Float.valueOf(f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        surfaceView.getHolder().setFormat(-3);
    }

    private void registerAMapUnbindObserver() {
        if (this.mAMapUnBindObserver == null) {
            this.mAMapUnBindObserver = new DisposableObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.base.MapFragment.5
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(@NonNull Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(@NonNull Boolean bool) {
                    if (MapFragment.this.isSceneLegal()) {
                        DialogUtils.showUnbindDialog(MapFragment.this.getActivity());
                    }
                }
            };
            AccountManager.getInstance().registerAMapAccountUnbindObserver(this.mAMapUnBindObserver);
        }
    }

    private void unRegisterAMapUnBindObserver() {
        DisposableObserver<Boolean> disposableObserver = this.mAMapUnBindObserver;
        if (disposableObserver != null && !disposableObserver.isDisposed()) {
            this.mAMapUnBindObserver.dispose();
        }
        this.mAMapUnBindObserver = null;
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainContext mainContext = this.mMainContext;
        if (mainContext != null) {
            mainContext.getAiMsgManager().setIsRunInBackground(false);
        }
        MapOpStatUtil.sendStatDataWhenMapGotoforeground();
        L.i(TAG, "onStart");
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public void onResume() {
        L.i(TAG, "onResume");
        TraceUtils.alwaysTraceBegin("Map onResume");
        if (this.mMainContext.getCurrentScene() != null) {
            NaviSpeechUtils.setPageType(this.mMainContext.getCurrentScene().getPageType());
        }
        super.onResume();
        sendStatDataWhenMapShow();
        if (this.mCaptureHelper == null) {
            this.mCaptureHelper = new CaptureHelper(getActivity(), getMapView());
        }
        this.mCaptureHelper.initCaptureView();
        if (this.mCameraDegreeHelper == null) {
            this.mCameraDegreeHelper = new CameraDegreeHelper(getActivity(), getMapView());
        }
        this.mCameraDegreeHelper.initCameraDegreeView();
        this.mMapScenePresenter.onResume();
        this.mBtnMapMode.setPaused(false);
        updateParallelRoadBtnStatus(this.mBtnRoadChange.getVisibility() == 0);
        exchangeDayNightMapAndLane(false);
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LANE_RECORD_PLAY, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_LANE_RECORD_PLAY);
        showProtoPlayBtn(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_DEFAULT_PLAY_PROTO, false));
        showLaneRecordPlayBtn(z);
        TraceUtils.alwaysTraceEnd();
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public void onPause() {
        TraceUtils.alwaysTraceBegin("Map onPause");
        super.onPause();
        CaptureHelper captureHelper = this.mCaptureHelper;
        if (captureHelper != null) {
            captureHelper.destroyCapturnBtn();
        }
        CameraDegreeHelper cameraDegreeHelper = this.mCameraDegreeHelper;
        if (cameraDegreeHelper != null) {
            cameraDegreeHelper.destroyCameraDegreeView();
        }
        this.mMapScenePresenter.onPause();
        this.mBtnMapMode.setPaused(true);
        TraceUtils.alwaysTraceEnd();
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MainContext mainContext = this.mMainContext;
        if (mainContext != null) {
            mainContext.getAiMsgManager().setIsRunInBackground(true);
        }
        NaviSpeechUtils.setPageType(PageType.NONE);
        MapOpStatUtil.sendStatDataWhenMapGotobackground();
        L.i(TAG, "onStop");
        if (this.mDrawFramFirst) {
            return;
        }
        L.e(TAG, "map init is interrupted, need reboot");
        RootUtil.delayExitApp(RootUtil.KILL_NAVI_MAP_INIT_INTERRUPTED);
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProtoSimulator.getInstance().setProgressListener(null);
        ActivityLifecycleHelper.getInstance().unregisterActivityLifecycleListener(this);
        StateManager.getInstance().removeListener(this.mIStateListener);
        this.mRootView = null;
        AccountEventManager accountEventManager = this.mAccountEventManager;
        if (accountEventManager != null) {
            accountEventManager.unRegisterEvent();
        }
        this.mHandler.removeMessages(100);
        this.mMapScenePresenter.getMapView().stopCheckCarIconStatus();
        this.mMapScenePresenter.unregisterEventBus();
        this.mMapScenePresenter.unregisterAccountAsync();
        this.mMapScenePresenter.unregisterAccountChangeObserver();
        L.i(TAG, "remove decorator for map fragment");
        this.mMapScenePresenter.removeChargeDecorator();
        this.mMapScenePresenter.onDestroy();
        this.mMapScenePresenter.unbindMapSurfaceView(this.mMapView);
        Unbinder unbinder = this.mButterBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        this.mDrDebugWindow = null;
        this.mCalibrationSpeedWindow = null;
        this.mMapView = null;
        this.mSRNaviSwitch = null;
        this.mTakeOverWeak = null;
        this.mBtnMapMode = null;
        this.mBtnZoomOut = null;
        this.mBtnRoadChange = null;
        this.mMapZoomContainer = null;
        this.mLocationInfoContainer = null;
        this.mADRDebugWindow = null;
        this.mBtnOverView = null;
        this.mMapScale = null;
        this.mLocationInfo = null;
        this.mBtnSetting = null;
        this.mRootView = null;
        this.mBtnZoomIn = null;
        this.mMapScaleText = null;
        this.mBtnVolume = null;
        this.mBtnMapRecenter = null;
        this.mVolumePanelViewManager = null;
        this.mImgAutologo = null;
        this.mModeContainer = null;
        this.mLeftBtnContainer = null;
        this.mStubProtoPlay = null;
        this.mProtoPlay = null;
        this.mProtoPlayBtn = null;
        this.mProtoPlayProgress = null;
        this.mProtoSaveTime = null;
        this.mStubLaneRecordPlay = null;
        this.mLaneRecordPlay = null;
        this.mLaneRecordBtn = null;
        this.mLanePlayBtn = null;
        this.mRouteChargeTipsView = null;
        this.mRouteChargeSwitchContainer = null;
        this.mRouteChargeSwitchBtn = null;
        this.mButtonsContainer = null;
        this.mMapScaleTextContainer = null;
        this.mLocationInfoView = null;
        this.mSRDataDebugStub = null;
        this.mSRDataDebugView = null;
        this.mSRDataDebugInfoTipsView = null;
        this.mSRDataDebugLcTipsView = null;
        this.mSRDataDebugOperateTipsView = null;
        this.mSRDataDebugDisplayStView = null;
        this.mSRDataDebugOddStView = null;
        this.mSRDataDebugDriveModeView = null;
        this.mSRDataDebugLaneStView = null;
        this.mSRDataDebugTTSStView = null;
        this.mSRDataDebugFrameRateView = null;
        this.mSRDataDebugFrameAveCostView = null;
        this.mSRDataDebugLndsDisView = null;
        super.onDestroyView();
        removeAllRunTimeHandlerMsg();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        NaviUtil.sIsMapFirstFrameDrew = false;
        this.mMapScenePresenter.noticeFirstFrameDrawToAI(false);
        unRegisterAMapUnBindObserver();
        if (needSendStatDataWhenMapExit()) {
            sendStatDataWhenMapExit();
        }
        dispatchScenesManagerOnDestroy();
        InitializerManager.getInstance().deInitMapFragmentLifeCycleInstanceSerivce();
        this.mMainContext.onDestroy();
        SpeechStatUtil speechStatUtil = this.mSpeechStatUtil;
        if (speechStatUtil != null) {
            speechStatUtil.deinit();
            this.mSpeechStatUtil = null;
        }
        L.i(TAG, "onDestroy");
        this.mMapScenePresenter.unregisterXPCarStateListener();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        this.mTakeOverWeakAnimator = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(ThemeType themeType) {
        super.onThemeSwitchDelegate(themeType);
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$MCox38GwbDeiuQ6g-MWTUl7eXIA
            @Override // java.lang.Runnable
            public final void run() {
                MapFragment.this.lambda$onThemeSwitchDelegate$3$MapFragment();
            }
        });
        renderLayoutByDayNightStatus(true);
    }

    public /* synthetic */ void lambda$onThemeSwitchDelegate$3$MapFragment() {
        exchangeDayNightMapAndLane(true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void onScreenOn() {
        if (CarFeatureManager.INSTANCE.isVPAEnable()) {
            MapVPAService.checkVPAVersion();
        }
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$fWqtfBK7gINulkL_8ZUUKzAbiBI
            @Override // java.lang.Runnable
            public final void run() {
                MapFragment.this.lambda$onScreenOn$4$MapFragment();
            }
        });
    }

    public /* synthetic */ void lambda$onScreenOn$4$MapFragment() {
        exchangeDayNightMapAndLane(true);
        if (TBTManager.getInstance().isMiniMapEnable()) {
            Intent intent = new Intent();
            intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
            intent.setAction("com.xiaopeng.montecarlo.minimap.ACTION_CAR_ICON_CHANGE");
            ContextUtils.getContext().startService(intent);
            L.i(TAG, "MiniMapService startService ACTION_CAR_ICON_CHANGE in MapFragment onScreenOn");
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateSRNaviGuideLineStatus(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateSRNaviGuideLineStatus isShow = " + z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateSRNaviSwitchStatus(int i, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "updateSRNaviSwitchStatus visibility = " + i + " isSRNavi = " + z);
        if (i == 0) {
            this.mIsSRNavi = z;
            this.mSRNaviSwitch.setBackgroundDrawable(ThemeWatcherUtil.getDrawable(z ? R.drawable.entrance_map : R.drawable.entrance_sr));
            updateSRSwitchBtnForVui(this.mIsSRNavi);
            getMapView().getSRShowLogHelper().logSRAvailable();
        } else {
            this.mIsSRNavi = false;
            getMapView().getSRShowLogHelper().logSRDisabled();
        }
        XImageView xImageView = this.mSRNaviSwitch;
        if (xImageView != null) {
            xImageView.setVisibility(i);
        }
        XImageButton xImageButton = this.mBtnRoadChange;
        if (xImageButton != null) {
            xImageButton.setVisibility((!this.mIsParallelRoadShow || this.mIsSRNavi) ? 8 : 0);
        }
        if (this.mIsSRNavi) {
            this.mSrMask.setVisibility(0);
        } else {
            this.mSrMask.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateAutoLogoStatus(int i) {
        XImageView xImageView = this.mImgAutologo;
        if (xImageView != null) {
            xImageView.setVisibility(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void showDebugSRData(boolean z) {
        if (this.mSRDataDebugView == null && z) {
            this.mSRDataDebugView = (LinearLayout) this.mSRDataDebugStub.inflate();
            this.mSRDataDebugInfoTipsView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_info_tips);
            this.mSRDataDebugLcTipsView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_lc_tips);
            this.mSRDataDebugOddStView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_odd_st);
            this.mSRDataDebugTTSStView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_tts_st);
            this.mSRDataDebugOperateTipsView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_operate_tips);
            this.mSRDataDebugDisplayStView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_display_st);
            this.mSRDataDebugLaneStView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_lane_st);
            this.mSRDataDebugDriveModeView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_drive_mode);
            this.mSRDataDebugFrameRateView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_frame_count);
            this.mSRDataDebugFrameAveCostView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_frame_total_time);
            this.mSRDataDebugLndsDisView = (TextView) this.mSRDataDebugView.findViewById(R.id.tv_sr_lnds_dis);
        }
        LinearLayout linearLayout = this.mSRDataDebugView;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRLcTips(int i) {
        TextView textView = this.mSRDataDebugLcTipsView;
        if (textView != null) {
            textView.setText(String.format("面板信号(RD10): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRInfoTips(int i) {
        TextView textView = this.mSRDataDebugInfoTipsView;
        if (textView != null) {
            textView.setText(String.format("提示信号(RD9): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSROperateTips(int i) {
        TextView textView = this.mSRDataDebugOperateTipsView;
        if (textView != null) {
            textView.setText(String.format("操作信号(RD14): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRDisplaySt(int i) {
        TextView textView = this.mSRDataDebugDisplayStView;
        if (textView != null) {
            textView.setText(String.format("SR进出信号(RD10): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRODDSt(int i) {
        TextView textView = this.mSRDataDebugOddStView;
        if (textView != null) {
            textView.setText(String.format("NGP退出信号(RD11): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRLaneSt(int i) {
        TextView textView = this.mSRDataDebugLaneStView;
        if (textView != null) {
            textView.setText(String.format("变道信号(RD15): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRTTSSt(int i) {
        TextView textView = this.mSRDataDebugTTSStView;
        if (textView != null) {
            textView.setText(String.format("TTS信号(RD13): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRDriveMode(int i) {
        TextView textView = this.mSRDataDebugDriveModeView;
        if (textView != null) {
            textView.setText(String.format("驾驶模式信号(RD30): %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRFrameRate(int i) {
        if (this.mSRDataDebugFrameRateView != null) {
            float f = -1.0f;
            if (getMapView() != null && getMapView().getGLMapView() != null) {
                f = getMapView().getGLMapView().getRealRenderFPS();
            }
            this.mSRDataDebugFrameRateView.setText(String.format("数据帧数: %d, 高德帧数: %.1f", Integer.valueOf(i), Float.valueOf(f)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRFrameAveCostTime(int i) {
        TextView textView = this.mSRDataDebugFrameAveCostView;
        if (textView != null) {
            textView.setText(String.format("平均处理时间: %d", Integer.valueOf(i)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugSRLndsDis(int i, int i2) {
        TextView textView = this.mSRDataDebugLndsDisView;
        if (textView != null) {
            textView.setText(String.format("高精结束距离: %d \n当前道路属性(formway): %d", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDebugMapCenter() {
        XPPoiInfo startPOIFromCurrent;
        View view = this.mLaneRecordPlay;
        if (view == null || this.mLaneLonlatTv == null || view.getVisibility() != 0 || (startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent()) == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("自车位置：\n");
        stringBuffer.append("Lon: ");
        stringBuffer.append(String.format("%.6f", Double.valueOf(startPOIFromCurrent.getDisplayLon())));
        stringBuffer.append(FDManager.LINE_SEPERATOR);
        stringBuffer.append("Lat: ");
        stringBuffer.append(String.format("%.6f", Double.valueOf(startPOIFromCurrent.getDisplayLat())));
        this.mLaneLonlatTv.setText(stringBuffer.toString());
    }

    @Override // com.xiaopeng.montecarlo.DayNightFragment
    protected boolean canSwitchDayNight() {
        return isSceneLegal();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView, com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public MapScenePresenter mo118getPresenter() {
        return this.mMapScenePresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public final boolean isSceneResumed() {
        return isResumed();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public boolean isSceneLegal() {
        boolean z = (!isAdded() || isHidden() || isDetached() || getActivity() == null) ? false : true;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isSceneLegal flag:" + z + ",scene:" + getClass().getSimpleName());
        }
        return z;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public String sceneLegalStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSceneLegal ");
        sb.append("isAdded:");
        sb.append(isAdded());
        sb.append(",");
        sb.append("!isHidden:");
        sb.append(!isHidden());
        sb.append(",");
        sb.append("!isDetached:");
        sb.append(!isDetached());
        sb.append(",");
        sb.append("null != getActivity:");
        sb.append(getActivity() != null);
        sb.append(",");
        sb.append("scene:");
        sb.append(this);
        return sb.toString();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void showPoiTrafficEventPop(final TrafficEventPopParam trafficEventPopParam) {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MapFragment.6
            @Override // java.lang.Runnable
            public void run() {
                IBaseScene currentScene = MapFragment.this.getMainContext().getCurrentScene();
                if (!(currentScene instanceof BaseMapScene) || Utils.isRestrictScene(currentScene)) {
                    L.i(MapFragment.TAG, "current scene is not map scene, or route scene or restrict scene is alive");
                } else {
                    ((BaseMapScene) currentScene).showSceneTrafficEventPop(trafficEventPopParam);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void hidePoiTrafficEventPop() {
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MapFragment.7
            @Override // java.lang.Runnable
            public void run() {
                IBaseScene currentScene = MapFragment.this.getMainContext().getCurrentScene();
                if (currentScene instanceof BaseMapScene) {
                    ((BaseMapScene) currentScene).hideSceneTrafficEventPop();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView, com.xiaopeng.montecarlo.base.IBaseLogicView
    @MainThread
    public void show() {
        if (isSceneLegal()) {
            this.mRootView.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView, com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
        if (isSceneLegal()) {
            this.mRootView.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    @MainThread
    public void switchNorthUp() {
        if (isSceneLegal()) {
            this.mBtnMapMode.setMode(DrawModeType.NORTHUP);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    @MainThread
    public void switchHeadUp2D() {
        if (isSceneLegal()) {
            this.mBtnMapMode.setMode(DrawModeType.HEADUP_2D);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    @MainThread
    public void switchHeadUp3D() {
        if (isSceneLegal()) {
            this.mBtnMapMode.setMode(DrawModeType.HEADUP_3D);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    @MainThread
    public void updateRecenterBtnStatus(boolean z) {
        if (isSceneLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "updateRecenterBtnStatus visible:" + z);
            }
            if (getMapView().getRestrictStatus()) {
                if (L.ENABLE) {
                    L.d(TAG, "getRestrictStatus is true");
                }
                this.mBtnMapRecenter.setVisibility(8);
                return;
            }
            this.mBtnMapRecenter.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    @MainThread
    public boolean isRecenterBtnVisible() {
        return isSceneResumed() && this.mBtnMapRecenter.getVisibility() == 0;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateMapAngle() {
        MapModeIconView mapModeIconView = this.mBtnMapMode;
        if (mapModeIconView != null) {
            mapModeIconView.resetMapStatus();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateMapMode() {
        if (isSceneLegal()) {
            if (this.mModeContainer.getVisibility() == 0) {
                this.mMapScenePresenter.initMapLevel(2);
                this.mMapScenePresenter.initMapMode();
                switchHeadUp3D();
            }
            getMapView().updateCarLocIcon();
        }
    }

    @MainThread
    public void updateRecenterShowTag(boolean z) {
        mo118getPresenter().updateRecenterShowTag(z);
    }

    @MainThread
    public void updateRecenterShowStatus(boolean z) {
        CurrentRoadNameView currentRoadNameView = this.mBtnMapRecenter;
        if (currentRoadNameView != null) {
            currentRoadNameView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    @MainThread
    public void updateUIStatus(@androidx.annotation.NonNull MapUIStatus mapUIStatus) {
        updateMapZoomWhenUIStatusChange(mapUIStatus);
        updateMapScaleWhenUIStatusChange(mapUIStatus);
        updateOverviewWhenUIStatusChange(mapUIStatus);
        updateSettingWhenUIStatusChange(mapUIStatus);
        updateVolumeWhenUIStatusChange(mapUIStatus);
        updateRouteChargeSwitchWhenUIStatusChange(mapUIStatus);
        updateModeRecenterWhenUIStatusChange(mapUIStatus);
        updateSceneForVui();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public MapUIStatus getUIStatus() {
        MapUIStatus mapUIStatus = new MapUIStatus();
        ViewGroup viewGroup = this.mMapZoomContainer;
        if (viewGroup != null) {
            mapUIStatus.mZoomButtonVisibility = viewGroup.getVisibility();
        }
        XImageButton xImageButton = this.mBtnVolume;
        if (xImageButton != null) {
            mapUIStatus.mVolumeVisibility = xImageButton.getVisibility();
        }
        View view = this.mModeContainer;
        if (view != null) {
            mapUIStatus.mMapRenderModeVisibility = view.getVisibility();
        }
        XImageButton xImageButton2 = this.mBtnSetting;
        if (xImageButton2 != null) {
            mapUIStatus.mSettingVisibility = xImageButton2.getVisibility();
        }
        XImageButton xImageButton3 = this.mBtnOverView;
        if (xImageButton3 != null) {
            mapUIStatus.mOverViewVisibility = xImageButton3.getVisibility();
        }
        XImageButton xImageButton4 = this.mBtnOverView;
        if (xImageButton4 != null) {
            mapUIStatus.mOverViewSelected = xImageButton4.isSelected() ? 1 : 0;
        }
        View view2 = this.mRouteChargeSwitchContainer;
        if (view2 != null) {
            mapUIStatus.mRouteChargeVisibility = view2.getVisibility();
            XImageButton xImageButton5 = this.mRouteChargeSwitchBtn;
            if (xImageButton5 != null) {
                mapUIStatus.mRouteChargeEnable = xImageButton5.isSelected() ? 1 : 0;
            }
            if (this.mRouteChargeTipsView != null) {
                mapUIStatus.mRouteChargeTipsVisibility = this.mRouteChargeSwitchContainer.getVisibility() == 0 ? this.mRouteChargeTipsView.getVisibility() : this.mRouteChargeSwitchContainer.getVisibility();
            }
        }
        return mapUIStatus;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateScaleText(int i, int i2) {
        if (isSceneResumed() && i >= 0) {
            String[] strArr = this.mMapLevelTexts;
            if (i >= strArr.length) {
                return;
            }
            this.mMapScaleText.setText(strArr[i]);
            ViewGroup.LayoutParams layoutParams = this.mMapScale.getLayoutParams();
            layoutParams.width = i2;
            this.mMapScale.setLayoutParams(layoutParams);
            updateMapScaleForVui(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateZoomInOutBtnStatus(boolean z, boolean z2) {
        if (isSceneLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, " updateZoomInOutBtnStatus :  canZoomIn ->" + z + "; canZoomOut -> " + z2);
            }
            this.mBtnZoomIn.setEnabled(z);
            this.mBtnZoomOut.setEnabled(z2);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateParallelRoadBtnStatus(boolean z) {
        int i;
        int drawableResId;
        int drawableResId2;
        if (L.ENABLE) {
            L.d(TAG, ">>> updateParallelRoadBtnStatus visible=" + z);
        }
        if (isSceneResumed()) {
            this.mIsParallelRoadShow = z;
            boolean z2 = false;
            if (!z) {
                this.mBtnRoadChange.setVisibility(8);
                i = 0;
            } else {
                this.mBtnRoadChange.setVisibility(this.mIsSRNavi ? 8 : 0);
                int currentRoadFlag = this.mMapScenePresenter.getCurrentRoadFlag();
                int currentRoadHWFlag = this.mMapScenePresenter.getCurrentRoadHWFlag();
                i = currentRoadFlag == 0 ? currentRoadHWFlag : currentRoadFlag;
                if (currentRoadFlag != 0) {
                    XImageButton xImageButton = this.mBtnRoadChange;
                    if (currentRoadFlag == 1) {
                        drawableResId2 = ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_mid_mineroad);
                    } else {
                        drawableResId2 = ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_mid_assistroad);
                    }
                    xImageButton.setImageResource(drawableResId2);
                } else if (currentRoadHWFlag != 0) {
                    XImageButton xImageButton2 = this.mBtnRoadChange;
                    if (currentRoadHWFlag == 1) {
                        drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_mid_onbridge);
                    } else {
                        drawableResId = ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_mid_underbridge);
                    }
                    xImageButton2.setImageResource(drawableResId);
                    z2 = true;
                }
                this.mBtnRoadChange.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.selector_map_toggle_button_bg));
            }
            if (CommonVuiHelper.getInstance().isCanUpdateVui(this.mMainContext)) {
                MapVuiHelper.getInstance().updateRoadChangeForVui(this.mMainContext, z2, i, this.mBtnRoadChange);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void onParallelRoadSwitchFinish() {
        if (!isSceneLegal()) {
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void onStateActive() {
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mOverViewVisibility = 8;
        uIStatus.mZoomButtonVisibility = 8;
        uIStatus.mScaleVisibility = 0;
        uIStatus.mSettingVisibility = 0;
        uIStatus.mVolumeVisibility = 0;
        if (this.mIsSRNavi) {
            uIStatus.mMapRenderModeVisibility = 8;
        } else {
            uIStatus.mMapRenderModeVisibility = 0;
        }
        uIStatus.mOverViewSelected = -1;
        updateUIStatus(uIStatus);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void onStateImmersion() {
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mOverViewVisibility = 8;
        uIStatus.mSettingVisibility = 8;
        uIStatus.mZoomButtonVisibility = 8;
        uIStatus.mScaleVisibility = 0;
        uIStatus.mVolumeVisibility = 0;
        if (this.mIsSRNavi) {
            uIStatus.mMapRenderModeVisibility = 8;
        } else {
            uIStatus.mMapRenderModeVisibility = 0;
        }
        uIStatus.mOverViewSelected = 0;
        updateUIStatus(uIStatus);
        hidePoiTrafficEventPop();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateADRDebugMessage(String str) {
        TextView textView;
        if (isSceneLegal() && (textView = this.mADRDebugWindow) != null) {
            textView.setText(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateDRDebugMessage(String str) {
        TextView textView;
        if (isSceneLegal() && (textView = this.mDrDebugWindow) != null) {
            textView.setText(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateCalibrationSpeedMessage(String str) {
        TextView textView;
        if (isSceneLegal() && (textView = this.mCalibrationSpeedWindow) != null) {
            textView.setText(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void showLocationInfo(boolean z) {
        if (isSceneLegal()) {
            if (this.mLocationInfoView == null && z) {
                this.mLocationInfoView = this.mLocationInfoContainer.inflate();
                this.mADRDebugWindow = (TextView) this.mRootView.findViewById(R.id.tv_adr_debug);
                this.mCalibrationSpeedWindow = (TextView) this.mRootView.findViewById(R.id.tv_calibration_speed);
                this.mDrDebugWindow = (TextView) this.mRootView.findViewById(R.id.tv_dr_debug);
                this.mLocationInfo = (TextView) this.mRootView.findViewById(R.id.tv_location_info);
            }
            View view = this.mLocationInfoView;
            if (view != null) {
                view.setVisibility(z ? 0 : 8);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateLocationInfo(String str) {
        TextView textView;
        if (isSceneLegal() && (textView = this.mLocationInfo) != null) {
            textView.setText(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public final void startScene(BaseBridge baseBridge, int i) {
        this.mMainContext.startScene(baseBridge, i);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public SpeechEventBizHelper getSpeechEventBizHelper() {
        return this.mSpeechEventBizHelper;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public boolean isSceneVuiEnabled() {
        return VoiceFullScenesUtil.isSceneVuiSupport();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public StatusConst.Mode getCurrentSceneMode() {
        return this.mEmptyScene.getMode();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public MainContext getMainContext() {
        return this.mMainContext;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public PageType getPageType() {
        return DataLogHelper.getPageTypeByCurScene(getMainContext());
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void initListener() {
        MapModeIconView mapModeIconView = this.mBtnMapMode;
        if (mapModeIconView != null) {
            mapModeIconView.setListener(new MapModeIconView.OnMapModeStateChangeListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$4LTmznhZ0KAcwrfzkPMERKH5Fg0
                @Override // com.xiaopeng.montecarlo.views.mapmode.MapModeIconView.OnMapModeStateChangeListener
                public final void onMapModeChange(DrawModeType drawModeType) {
                    MapFragment.this.lambda$initListener$5$MapFragment(drawModeType);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initListener$5$MapFragment(DrawModeType drawModeType) {
        updateMapModeForVui(true);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void backToMode(StatusConst.Mode mode, boolean z) {
        this.mEmptyScene.backToMode(mode, z);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void backToLastMode(StatusConst.Mode mode, boolean z) {
        this.mEmptyScene.backToLastMode(mode, z);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public boolean isPreScene(StatusConst.Mode mode) {
        return this.mEmptyScene.isPreScene(mode);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void removeSceneAfterIndex(int i, int i2) {
        this.mEmptyScene.removeSceneAfterIndex(i, i2);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public BaseBridge getBridge() {
        return this.mEmptyScene.getBridge();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void startSettingScene() {
        ICruiseContract.CheckAndMoveCarGreetingListner checkAndMoveCarGreetingListner;
        SettingStatUtil.sendStatDataEnter(this.mMainContext);
        MainContext mainContext = this.mMainContext;
        if (mainContext != null && (checkAndMoveCarGreetingListner = mainContext.getCheckAndMoveCarGreetingListner()) != null) {
            checkAndMoveCarGreetingListner.checkAndCallBackUserSearchInThread();
        }
        startScene(new SettingBridge().setStartMode(1), 200);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void startSearchHistories() {
        IBaseScene currentScene = this.mMainContext.getCurrentScene();
        if (currentScene.hasChildScene()) {
            currentScene.backChildScene();
        }
        startScene(new SearchBridge());
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void showRememberVolumeTips() {
        if (isSceneLegal()) {
            hideVolumePanel();
            FragmentActivity activity = getActivity();
            Resources resources = getResources();
            final NavVolumeTipsView navVolumeTipsView = new NavVolumeTipsView(getActivity());
            navVolumeTipsView.setWidth(Utils.dp2px(activity, resources.getDimension(R.dimen.navi_volume_tips_width)));
            navVolumeTipsView.setHeight(Utils.dp2px(activity, resources.getDimension(R.dimen.navi_volume_tips_height)));
            navVolumeTipsView.setBackgroundDrawable(new ColorDrawable());
            navVolumeTipsView.setFocusable(true);
            navVolumeTipsView.setOutsideTouchable(true);
            navVolumeTipsView.showAsDropDown(this.mBtnVolume, 0, Utils.dp2px(getActivity(), resources.getDimension(R.dimen.navi_volume_y_offset)));
            this.mBtnVolume.postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MapFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    NavVolumeTipsView navVolumeTipsView2 = navVolumeTipsView;
                    if (navVolumeTipsView2 != null) {
                        navVolumeTipsView2.dismiss();
                    }
                }
            }, NavRestoreManager.WAKELOCK_TIMEOUT_10SEC);
            MapOpStatUtil.sendStatDataForVolumeWhenCruise(getMainContext(), BtnType.VOLUME_REMEMBER_SHOW, new Object[0]);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void popToastForMapModeChange(int i) {
        this.mMainContext.showPrompt(i != 0 ? i != 1 ? i != 2 ? R.string.map_mode_default_toast : R.string.head_up_3d_toast : R.string.head_up_2d_toast : R.string.north_up_toast);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(KEY_ARG_SAVED_WRAPPER_ID, this.mMapWrapperId);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void runOnUiThread(Runnable runnable) {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        activity.runOnUiThread(new FragmentRunnable(this, runnable, 1));
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void runOnUiThreadDelayed(Runnable runnable, long j) {
        View view = getView();
        if (view != null) {
            view.postDelayed(new FragmentRunnable(this, runnable, 1), j);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void runOnUiThreadRelyMap(Runnable runnable) {
        runOnUiThread(runnable);
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void goBack() {
        this.mEmptyScene.goBack();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void startScene(BaseBridge baseBridge) {
        startScene(baseBridge, 0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void goToRootPage() {
        Bundle bundle = new Bundle();
        if (!ActivateManager.getInstance().isActivateSuccess()) {
            startScene(new ActivateBridge().setBundle(bundle));
        } else {
            startScene(new CruiseBridge().setBundle(bundle));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void executeAfterNaviStop() {
        this.mMapScenePresenter.onRestoreView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void showVolumePanel() {
        XImageButton xImageButton;
        if (isSceneLegal()) {
            if (this.mVolumePanelViewManager == null) {
                this.mVolumePanelViewManager = new VolumePanelView.Builder().setAnchorView(Utils.isLandscape() ? this.mLeftBtnContainer : this.mBtnVolume).setMaxVolume(this.mMapScenePresenter.maxVolume()).setIgnoreAnchorViewTouchEvent(true).setOnViewChangedListener(this.mMapScenePresenter).setRotationAngle(Utils.isLandscape() ? VerticalSeekBar.ROTATION_ANGLE_CW_270 : 0).build(getActivity());
            }
            this.mVolumePanelViewManager.show(this.mMapScenePresenter.getVolume(), this.mMapScenePresenter.isMute());
            if (Utils.isPortrait() && (xImageButton = this.mBtnVolume) != null) {
                xImageButton.setImageResource(R.drawable.vector_ic_mid_volume_back);
            }
            MapOpStatUtil.sendStatDataForShowPanel(this.mMainContext, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void hideVolumePanel() {
        if (isSceneLegal()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$0hCs4GEk2WmyzSbDX6ibVhz6MBo
                @Override // java.lang.Runnable
                public final void run() {
                    MapFragment.this.lambda$hideVolumePanel$6$MapFragment();
                }
            });
        }
    }

    public /* synthetic */ void lambda$hideVolumePanel$6$MapFragment() {
        XImageButton xImageButton;
        if (isVolumePanelVisible()) {
            this.mVolumePanelViewManager.hide();
            if (Utils.isPortrait() && (xImageButton = this.mBtnVolume) != null) {
                xImageButton.setImageResource(R.drawable.layer_volume_button_level);
            }
            updateVolumeBtnStatus();
            MapOpStatUtil.sendStatDataForShowPanel(this.mMainContext, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateVolumeProcess(final int i, final boolean z) {
        if (isSceneLegal()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$47fy0YZThKpvOOVcwalb6cdUqDY
                @Override // java.lang.Runnable
                public final void run() {
                    MapFragment.this.lambda$updateVolumeProcess$7$MapFragment(i, z);
                }
            });
        }
    }

    public /* synthetic */ void lambda$updateVolumeProcess$7$MapFragment(int i, boolean z) {
        this.mVolumePanelViewManager.update(i, false, z);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public void updateVolumeBtnStatus() {
        if (isSceneLegal()) {
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$y2b4xoODzbZ7dgoxBBEAFD3o9Pw
                @Override // java.lang.Runnable
                public final void run() {
                    MapFragment.this.lambda$updateVolumeBtnStatus$9$MapFragment();
                }
            });
        }
    }

    public /* synthetic */ void lambda$updateVolumeBtnStatus$9$MapFragment() {
        final int volumeLevel = this.mMapScenePresenter.getVolumeLevel();
        runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$Rh3SW8Q0mwn_T6IqUf7842FCblQ
            @Override // java.lang.Runnable
            public final void run() {
                MapFragment.this.lambda$null$8$MapFragment(volumeLevel);
            }
        });
    }

    public /* synthetic */ void lambda$null$8$MapFragment(int i) {
        XImageButton xImageButton = this.mBtnVolume;
        if (xImageButton != null) {
            if (xImageButton.getVisibility() != 0) {
                this.mBtnVolume.setVisibility(0);
            }
            this.mBtnVolume.setImageLevel(i);
        }
        VolumePanelView volumePanelView = this.mVolumePanelViewManager;
        if (volumePanelView != null) {
            volumePanelView.toggleMute(i == 0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.LogicView
    public boolean isVolumePanelVisible() {
        VolumePanelView volumePanelView = this.mVolumePanelViewManager;
        return volumePanelView != null && volumePanelView.isShowing();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        return mo118getPresenter().onInterceptSpeechEvent(speechNaviEvent, iCommandCallback);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        return mo118getPresenter().onSpeechEvent(speechNaviEvent, iCommandCallback);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onSurfaceCreated(int i) {
        if (this.mIsNeedCallGoBackCenter) {
            this.mIsNeedCallGoBackCenter = false;
            getMapView().initMapCenter(true, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onSurfaceChanged(int i, int i2, int i3) {
        if (this.mIsNeedCallGoBackCenter) {
            this.mIsNeedCallGoBackCenter = false;
            getMapView().goBackCenter(true, true, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onDeviceRender(int i, int i2) {
        if (this.mDrawFramFirst || 5 != i2) {
            return;
        }
        this.mDrawFramFirst = true;
        NaviUtil.sIsMapFirstFrameDrew = true;
        L.Tag tag = TAG;
        L.i(tag, "DrawFramFirst onDeviceRender:" + i + " status:" + i2);
        this.mMapScenePresenter.noticeFirstFrameDrawToAI(true);
    }

    public boolean backScene() {
        ScenesManager scenesManager = this.mScenesManager;
        if (scenesManager == null || scenesManager.isAllSceneClosed()) {
            return false;
        }
        if (this.mScenesManager.getCurrentScene().onBackPressed()) {
            return true;
        }
        this.mScenesManager.back();
        return true;
    }

    public void syncMapMode() {
        IBaseScene currentScene = this.mMainContext.getCurrentScene();
        if (currentScene == null) {
            return;
        }
        StatusConst.Mode mode = currentScene.getMode();
        L.Tag tag = TAG;
        L.i(tag, "onSyncMapModeEvent sceneMode : " + mode);
        int i = AnonymousClass14.$SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[mode.ordinal()];
        int i2 = 0;
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            if (i == 5) {
                i2 = MapModeUtil.getSavedMapMode(true);
            } else {
                i2 = MapModeUtil.getSavedMapMode(false);
            }
        }
        getMapView().setMapMode(i2);
    }

    /* renamed from: com.xiaopeng.montecarlo.base.MapFragment$14  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass14 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode = new int[StatusConst.Mode.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[StatusConst.Mode.ROUTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[StatusConst.Mode.EXPLORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[StatusConst.Mode.SEARCH_RESULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[StatusConst.Mode.RESTRICT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[StatusConst.Mode.NAVI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$bridge$StatusConst$Mode[StatusConst.Mode.CRUISE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public MapViewWrapper getMapView() {
        return this.mMapScenePresenter.getMapView();
    }

    public void restoreSceneManagerState(@androidx.annotation.NonNull Bundle bundle) {
        if (InitializerManager.getInstance().isInApplicationRestore() || InitializerManager.getInstance().isInRouteRestore() || TBTManager.getInstance().getCurrentStatus() == 0) {
            return;
        }
        this.mSceneManagerState = (SceneManagerState) bundle.getParcelable("scene_manager");
        SceneManagerState sceneManagerState = this.mSceneManagerState;
        if (sceneManagerState != null && sceneManagerState.mActive != null) {
            InitializerManager.getInstance().setInRouteRestore(true);
        }
        L.Tag tag = TAG;
        L.i(tag, "restoreSceneManagerState mSceneManagerState:" + this.mSceneManagerState);
    }

    public void saveSceneManagerState(@androidx.annotation.NonNull Bundle bundle) {
        InitializerManager.getInstance().setInApplicationRestore(false);
        bundle.putParcelable("scene_manager", new SceneManagerState(this.mScenesManager));
    }

    public void clearSceneManagerState() {
        this.mScenesManager.clearSceneManagerState();
    }

    public void setIntentTaskScheduler(IntentTaskScheduler intentTaskScheduler) {
        this.mIntentTaskScheduler = intentTaskScheduler;
    }

    public boolean isInPreload() {
        return this.mIsInPreload;
    }

    public void preloadView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mIsInPreload = true;
        this.mRootView = layoutInflater.inflate(R.layout.fragment_map, viewGroup, false);
        this.mIsRestoreCreation = this.mSceneManagerState != null;
        L.Tag tag = TAG;
        L.i(tag, "preloadView mIsRestoreCreation:" + this.mIsRestoreCreation);
        TraceUtils.alwaysTraceBegin("MapFragment_preloadView_createScenesManager");
        createScenesManager(viewGroup.getContext());
        createScenePresenter((Application) viewGroup.getContext().getApplicationContext());
        TraceUtils.alwaysTraceEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showRecenterBtnAlways(boolean z) {
        mo118getPresenter().showRecenterBtnAlways(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTakeOverWeakAnim() {
        if (this.mTakeOverWeak == null) {
            return;
        }
        AnimationDrawable animationDrawable = this.mTakeOverWeakAnimator;
        if (animationDrawable == null || !animationDrawable.isRunning()) {
            this.mTakeOverWeak.setVisibility(0);
            this.mTakeOverWeakAnimator = (AnimationDrawable) this.mTakeOverWeak.getBackground();
            this.mTakeOverWeakAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopTakeOverWeakAnim() {
        AnimationDrawable animationDrawable = this.mTakeOverWeakAnimator;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.mTakeOverWeakAnimator.stop();
        }
        XImageView xImageView = this.mTakeOverWeak;
        if (xImageView != null) {
            xImageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CaptureHelper getCaptureHelper() {
        return this.mCaptureHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraDegreeHelper getCameraDegreeHelper() {
        return this.mCameraDegreeHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lockMapTouchEvent() {
        this.mMapScenePresenter.lockMapTouchEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unlockMapTouchEvent() {
        this.mMapScenePresenter.unlockMapTouchEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lockMapPoiEvent() {
        this.mMapScenePresenter.lockMapPoiEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMapPoiLocked() {
        return this.mMapScenePresenter.isMapPoiLocked();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unlockMapPoiEvent() {
        this.mMapScenePresenter.unlockMapPoiEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMapScenePresenter.addSceneMapListener(sceneMapListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMapScenePresenter.removeSceneMapListener(sceneMapListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener) {
        CollectionUtils.listAdd(this.mSceneMapFragmentListeners, iSceneMapFragmentListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSceneMapFragmentListener(ISceneMapFragmentListener iSceneMapFragmentListener) {
        this.mSceneMapFragmentListeners.remove(iSceneMapFragmentListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setMapTouchEnable(boolean z) {
        return this.mMapScenePresenter.setMapTouchEnable(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMapSceneView() {
        View view = this.mRootView;
        if (view == null) {
            return null;
        }
        return view.findViewById(R.id.map_buttons);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRoadChangeStatus() {
        return this.mMapScenePresenter.getCurrentRoadFlag();
    }

    private void sendStatDataWhenMapShow() {
        MapOpStatUtil.sendStatDataWhenMapExposure();
    }

    private void createScenePresenter(Application application) {
        if (this.mMapScenePresenter == null) {
            this.mMapScenePresenter = new MapScenePresenter(application, this, this.mMainContext);
        }
    }

    private void createScenesManager(Context context) {
        if (this.mScenesManager == null) {
            this.mScenesManager = new ScenesManager();
            this.mScenesManager.setXPBroadcast(new XPBroadcast(new XPBroadcastImpl(context)));
            this.mMainContext = new MainContext(new MainContextImpl(this, this.mScenesManager));
            this.mEmptyScene = this.mMainContext.getEmptyScene();
            this.mScenesManager.setMainContext(this.mMainContext);
            this.mScenesManager.setXPHandlerBuilder(new XPHandlerBuilder(new XPHandlerBuilderImpl()));
            this.mScenesManager.setSceneTaskStatusListener(this.mSceneManagerListener);
        }
    }

    private void sendStatDataWhenMapExit() {
        MapOpStatUtil.sendStatDataWhenMapExit();
    }

    private void dispatchScenesManagerOnDestroy() {
        this.mScenesManager.onDestroy();
    }

    private boolean needSendStatDataWhenMapExit() {
        return !Utils.isRouteScene(this.mMainContext.getCurrentScene());
    }

    private void initMapDelegate() {
        TraceUtils.alwaysTraceBegin("initMapDelegate");
        DRServiceManager.getInstance().setMapDelegate(this.mMapDelegate);
        LocationServiceManager.getInstance().setMapDelegate(this.mMapDelegate);
        SettingBLManager.getInstance().setMapDelegate(this.mMapDelegate);
        TBTManager.getInstance().setMapDelegate(this.mMapDelegate);
        SearchClient.getInstance().setIMapDelegate(this.mMapDelegate);
        AccountManager.getInstance().setMapDelegate(this.mMapDelegate);
        NaviStatusService.setMapDelegate(this.mMapDelegate);
        TraceUtils.alwaysTraceEnd();
    }

    private int getMapWrapperId(Bundle bundle) {
        int i = bundle != null ? bundle.getInt(KEY_ARG_SAVED_WRAPPER_ID, -1) : -1;
        return i < 0 ? this.mWrapperIdGenerator.getAndIncrement() : i;
    }

    private void exchangeDayNightMapAndLane(boolean z) {
        exchangeDayNight(ThemeWatcherUtil.getMapModeByCurrentTheme(), z);
    }

    private void exchangeDayNight(int i, boolean z) {
        MapViewWrapper mapView = getMapView();
        if (mapView == null) {
            L.i(TAG, L.formatDayNightSwitchLog("exchangeDayNight failure"));
            return;
        }
        int dayNightMode = mapView.getDayNightMode();
        L.Tag tag = TAG;
        L.i(tag, L.formatDayNightSwitchLog("exchangeDayNight currentMode: " + dayNightMode + ", targetMode:" + i));
        if (dayNightMode != i || z) {
            boolean isEagleEyeShowing = mapView.getBizControlManager().isEagleEyeShowing();
            mapView.setIsDayNightSwitching(true);
            L.Tag tag2 = TAG;
            L.i(tag2, L.formatDayNightSwitchLog("exchangeDayNight disable EagleEye isEagleEyeShowing : " + isEagleEyeShowing));
            if (isEagleEyeShowing) {
                mapView.getBizControlManager().disableEagleEyeState();
                mapView.getBizControlManager().updateMapEagleEyeView(false, false);
            }
            mapView.updateDayNightMode(i, ThemeWatcherUtil.getCurrentTheme());
            UiHandlerUtil.getInstance().post(new DayNightMapTask(isEagleEyeShowing, mapView));
        }
    }

    private void renderLayoutByDayNightStatus(boolean z) {
        TraceUtils.alwaysTraceBegin("renderLayoutByDayNightStatus");
        if (z) {
            this.mMapScale.setPaintColor(ContextUtils.getColor(ThemeWatcherUtil.getColorResId(R.color.main_title_text_color)));
            this.mMapScale.invalidate();
            this.mBtnMapMode.setNightMode(!ThemeWatcherUtil.isDayMode());
            MapScenePresenter mapScenePresenter = this.mMapScenePresenter;
            if (mapScenePresenter != null) {
                mapScenePresenter.updateMapModeButton();
            }
            updateParallelRoadBtnStatus(this.mBtnRoadChange.getVisibility() == 0);
        }
        this.mSRNaviSwitch.setBackgroundDrawable(ThemeWatcherUtil.getDrawable(this.mIsSRNavi ? R.drawable.entrance_map : R.drawable.entrance_sr));
        this.mBtnOverView.setImageDrawable(ThemeWatcherUtil.getDrawable(getMapView().isPreview() ? R.drawable.vector_ic_mid_quitfullview : R.drawable.vector_ic_mid_fullview));
        TraceUtils.alwaysTraceEnd();
    }

    private void formatElementsForVui() {
        updateMapModeForVui(true);
        updateMapScaleForVui(true);
        enableSpeechControlForVui();
    }

    private void enableSpeechControlForVui() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        MainContext mainContext = this.mMainContext;
        XImageButton xImageButton = this.mBtnVolume;
        commonVuiHelper.enableCanSpeechControl(mainContext, xImageButton, xImageButton, false);
    }

    private void mapViewsDisplayController() {
        this.mBtnVolume.setVisibility(0);
        this.mBtnMapRecenter.setVisibility(0);
        this.mModeContainer.setVisibility(0);
        this.mBtnRoadChange.setVisibility(0);
        this.mBtnSetting.setVisibility(0);
    }

    private void removeAllRunTimeHandlerMsg() {
        MainContext mainContext = this.mMainContext;
        if (mainContext != null) {
            mainContext.getRunTimeHandler().removeCallbacksAndMessages(this);
        }
    }

    private void updateModeRecenterWhenUIStatusChange(MapUIStatus mapUIStatus) {
        if (this.mModeContainer != null) {
            if (mapUIStatus.mMapRenderModeVisibility == 0) {
                this.mModeContainer.setVisibility(0);
                this.mModeContainer.setClickable(true);
                this.mBtnMapMode.setVisibility(0);
                return;
            }
            this.mModeContainer.setClickable(false);
            this.mModeContainer.setVisibility(8);
            this.mBtnMapMode.setVisibility(8);
        }
    }

    private void updateRouteChargeSwitchWhenUIStatusChange(MapUIStatus mapUIStatus) {
        XImageButton xImageButton = this.mRouteChargeSwitchBtn;
        if (xImageButton != null) {
            boolean isSelected = xImageButton.isSelected();
            this.mRouteChargeSwitchContainer.setVisibility(mapUIStatus.mRouteChargeVisibility);
            this.mRouteChargeSwitchBtn.setSelected(mapUIStatus.mRouteChargeEnable == 1);
            this.mRouteChargeSwitchBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MapFragment.this.onClickRouteChargeSwitch(view);
                }
            });
            if (mapUIStatus.mRouteChargeVisibility == 0 && mapUIStatus.mRouteChargeTipsVisibility == 0 && this.mRouteChargeTipsView == null) {
                LayoutInflater.from(getActivity()).inflate(R.layout.layout_route_charge_tips, this.mButtonsContainer);
                this.mRouteChargeTipsView = (TextView) this.mButtonsContainer.findViewById(R.id.route_charge_tips);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRouteChargeTipsView.getLayoutParams();
                layoutParams.addRule(1, Utils.isLandscape() ? this.mRouteChargeSwitchContainer.getId() : this.mLeftBtnContainer.getId());
                layoutParams.addRule(12);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.route_charge_tips_margin_bottom);
                this.mRouteChargeTipsView.setLayoutParams(layoutParams);
            }
            TextView textView = this.mRouteChargeTipsView;
            if (textView != null) {
                textView.setVisibility(mapUIStatus.mRouteChargeVisibility == 0 ? mapUIStatus.mRouteChargeTipsVisibility : 8);
            }
            boolean isSelected2 = this.mRouteChargeSwitchBtn.isSelected();
            boolean z = this.mRouteChargeSwitchBtn.getVuiElementType() == VuiElementType.CHECKBOX;
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateUIStatus update route charge switch button vui,oldState:" + isSelected + ",newState:" + isSelected2 + ",isVuiInit:" + z));
            }
            if (CommonVuiHelper.getInstance().isCanUpdateVui(this.mMainContext)) {
                if (isSelected == isSelected2 && z) {
                    return;
                }
                CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
                MainContext mainContext = this.mMainContext;
                XImageButton xImageButton2 = this.mRouteChargeSwitchBtn;
                commonVuiHelper.updateCheckboxStateForVui(mainContext, xImageButton2, xImageButton2, xImageButton2.isSelected());
            }
        }
    }

    private void updateVolumeWhenUIStatusChange(MapUIStatus mapUIStatus) {
        XImageButton xImageButton = this.mBtnVolume;
        if (xImageButton != null) {
            xImageButton.setVisibility(mapUIStatus.mVolumeVisibility);
            if (mapUIStatus.mVolumeVisibility != 0) {
                hideVolumePanel();
            }
            this.mBtnVolume.setClickable(mapUIStatus.mVolumeVisibility == 0);
        }
    }

    private void updateSettingWhenUIStatusChange(MapUIStatus mapUIStatus) {
        XImageButton xImageButton = this.mBtnSetting;
        if (xImageButton != null) {
            xImageButton.setVisibility(mapUIStatus.mSettingVisibility);
            this.mBtnSetting.setClickable(mapUIStatus.mSettingVisibility == 0);
        }
    }

    private void updateOverviewWhenUIStatusChange(MapUIStatus mapUIStatus) {
        XImageButton xImageButton = this.mBtnOverView;
        if (xImageButton != null) {
            xImageButton.setVisibility(mapUIStatus.mOverViewVisibility);
            this.mBtnOverView.setImageDrawable(ThemeWatcherUtil.getDrawable(mapUIStatus.mOverViewSelected != 0 ? R.drawable.vector_ic_mid_quitfullview : R.drawable.vector_ic_mid_fullview));
            this.mBtnOverView.setSelected(mapUIStatus.mOverViewSelected != 0);
            this.mBtnOverView.setClickable(mapUIStatus.mOverViewVisibility == 0);
            if (CommonVuiHelper.getInstance().isCanUpdateVui(this.mMainContext)) {
                MapVuiHelper.getInstance().updateOverviewForVui(this.mMainContext, this.mBtnOverView);
            }
        }
    }

    private void updateMapScaleWhenUIStatusChange(MapUIStatus mapUIStatus) {
        XTextView xTextView = this.mMapScaleText;
        if (xTextView != null) {
            xTextView.setVisibility(mapUIStatus.mScaleVisibility);
            this.mMapScaleText.setClickable(mapUIStatus.mScaleVisibility == 0);
        }
        MapScaleLineView mapScaleLineView = this.mMapScale;
        if (mapScaleLineView != null) {
            mapScaleLineView.setVisibility(mapUIStatus.mScaleVisibility);
            this.mMapScale.setClickable(mapUIStatus.mScaleVisibility == 0);
        }
    }

    private void updateMapZoomWhenUIStatusChange(MapUIStatus mapUIStatus) {
        ViewGroup viewGroup = this.mMapZoomContainer;
        if (viewGroup != null) {
            viewGroup.setClickable(mapUIStatus.mZoomButtonVisibility == 0);
            this.mMapZoomContainer.setVisibility(mapUIStatus.mZoomButtonVisibility);
        }
    }

    private void updateSceneForVui() {
        if (CommonVuiHelper.getInstance().isCanUpdateVui(this.mMainContext)) {
            MapModeIconView mapModeIconView = this.mBtnMapMode;
            if (mapModeIconView != null) {
                mapModeIconView.setVuiMode(2 == TBTManager.getInstance().getCurrentStatus() ? VuiMode.DISABLED : VuiMode.NORMAL);
            }
            VoiceFullScenesUtil.updateScene(this.mMainContext.getCurrentScene(), getView());
        }
    }

    private void updateMapModeForVui(boolean z) {
        if ((CommonVuiHelper.getInstance().isCanUpdateVui(this.mMainContext) || z) && this.mBtnMapMode != null) {
            MapVuiHelper.getInstance().formatMapMode(this.mMainContext, this.mBtnMapMode);
        }
    }

    private void updateSRSwitchBtnForVui(boolean z) {
        if (CommonVuiHelper.getInstance().isCanUpdateVui(this.mMainContext) && this.mSRNaviSwitch != null) {
            MapVuiHelper.getInstance().formatSRSwitch(this.mMainContext, this.mSRNaviSwitch, z);
        }
    }

    private void updateMapScaleForVui(boolean z) {
        if (CommonVuiHelper.getInstance().isCanUpdateVui(this.mMainContext) || z) {
            MapVuiHelper.getInstance().formatMapScaleTextContainer(this.mMainContext, this.mMapScale, this.mMapScaleText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sceneAdded(int i) {
        this.mMainContext.getAiMsgManager().setOnlyMapShow(i <= 1);
        IBaseScene currentScene = this.mMainContext.getCurrentScene();
        if (1 == i && currentScene != null && currentScene.getBridge().isOverMode()) {
            return;
        }
        this.mMapScenePresenter.updateFavoriteOverlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackResult(int i, Bundle bundle) {
        if (200 != i) {
            if (300 == i) {
                if (L.ENABLE) {
                    L.d(TAG, "back from naviGuiderfragment");
                }
                MapStateObserver.getInstance().notifyRefreshGifGuider();
                return;
            }
            return;
        }
        ArrayList<ISceneMapFragmentListener> arrayList = this.mSceneMapFragmentListeners;
        if (arrayList != null) {
            Iterator<ISceneMapFragmentListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onSceneMapFragmentResult(i, bundle);
            }
        }
        MapStateObserver.getInstance().notifyRefreshGifGuider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickRouteChargeSwitch(View view) {
        preventMultiClick(view);
        L.i(TAG, "click route charge switch");
        ArrayList<ISceneMapFragmentListener> arrayList = this.mSceneMapFragmentListeners;
        if (arrayList != null) {
            Iterator<ISceneMapFragmentListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onClickRouteChargeSwitch();
            }
        }
    }

    private void preventMultiClick(final View view) {
        if (view != null) {
            if (view.getId() != R.id.btn_volume) {
                hideVolumePanel();
            }
            view.setClickable(false);
            runOnUiThreadDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$bIjAFTforwHuPaDDpK4sMjOndnU
                @Override // java.lang.Runnable
                public final void run() {
                    view.setClickable(true);
                }
            }, 500L);
        }
    }

    private void setMapButtonLayoutParams(int i) {
        ViewGroup viewGroup = this.mLeftBtnContainer;
        if (viewGroup != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.setMarginStart(i);
            this.mLeftBtnContainer.setLayoutParams(layoutParams);
        }
    }

    public void showProtoPlayBtn(boolean z) {
        XButton xButton;
        ProtoSimulator.getInstance().startSimulator(z);
        if (z && this.mProtoPlay == null && this.mStubProtoPlay != null) {
            if (L.ENABLE) {
                L.d(TAG, "showProtoPlayBtn ");
            }
            this.mProtoPlay = this.mStubProtoPlay.inflate();
            this.mProtoPlayBtn = (XButton) this.mProtoPlay.findViewById(R.id.btn_debug_proto_play);
            this.mProtoPlayProgress = (XSeekBar) this.mProtoPlay.findViewById(R.id.btn_debug_proto_progress);
            this.mProtoSaveTime = (TextView) this.mProtoPlay.findViewById(R.id.proto_time);
            ProtoSimulator.getInstance().setProgressListener(new AnonymousClass10());
            this.mProtoPlayBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$rKw-FbcW3mdkkMebQ-k8zmyIdio
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapFragment.this.lambda$showProtoPlayBtn$11$MapFragment(view);
                }
            });
            this.mProtoPlayProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment.11
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
                    if (L.ENABLE && z2) {
                        L.Tag tag = MapFragment.TAG;
                        L.d(tag, "proto onProgressChanged progress = " + i);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    ProtoSimulator.getInstance().play(false);
                    if (MapFragment.this.mProtoPlayBtn != null) {
                        MapFragment.this.mProtoPlayBtn.setText(R.string.debug_proto_play);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    ProtoSimulator.getInstance().seekTo(seekBar.getProgress());
                }
            });
        }
        if (this.mProtoPlay == null || (xButton = this.mProtoPlayBtn) == null) {
            return;
        }
        xButton.setText(ProtoSimulator.getInstance().isRunning() ? R.string.debug_proto_stop : R.string.debug_proto_play);
        this.mProtoPlay.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.base.MapFragment$10  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass10 implements ProtoSimulator.ProgressListener {
        AnonymousClass10() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.sr.ProtoSimulator.ProgressListener
        public void onProgressChanged(final int i) {
            MapFragment.this.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$10$u3k94Qhq8kFcvPO6wFDVxZFc77Q
                @Override // java.lang.Runnable
                public final void run() {
                    MapFragment.AnonymousClass10.this.lambda$onProgressChanged$0$MapFragment$10(i);
                }
            });
        }

        public /* synthetic */ void lambda$onProgressChanged$0$MapFragment$10(int i) {
            if (MapFragment.this.mProtoPlayProgress != null) {
                MapFragment.this.mProtoPlayProgress.setProgress(i);
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.sr.ProtoSimulator.ProgressListener
        public void onRelayTimeChange(final long j) {
            MapFragment.this.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$10$-AUB9XriUPTgB80nkd2JXxhB46g
                @Override // java.lang.Runnable
                public final void run() {
                    MapFragment.AnonymousClass10.this.lambda$onRelayTimeChange$1$MapFragment$10(j);
                }
            });
        }

        public /* synthetic */ void lambda$onRelayTimeChange$1$MapFragment$10(long j) {
            if (MapFragment.this.mProtoSaveTime != null) {
                MapFragment.this.mProtoSaveTime.setText(TimeFormatUtil.formatTime(j));
            }
        }
    }

    public /* synthetic */ void lambda$showProtoPlayBtn$11$MapFragment(View view) {
        if (this.mProtoPlayBtn != null) {
            ProtoSimulator.getInstance().play(!ProtoSimulator.getInstance().isRunning());
            this.mProtoPlayBtn.setText(ProtoSimulator.getInstance().isRunning() ? R.string.debug_proto_stop : R.string.debug_proto_play);
        }
    }

    public void showLaneRecordPlayBtn(boolean z) {
        ViewStub viewStub;
        if (z && this.mLaneRecordPlay == null && (viewStub = this.mStubLaneRecordPlay) != null) {
            this.mLaneRecordPlay = viewStub.inflate();
            this.mLaneLonlatTv = (XTextView) this.mLaneRecordPlay.findViewById(R.id.tv_debug_lane_lonlat);
            this.mLaneTimeTv = (XTextView) this.mLaneRecordPlay.findViewById(R.id.tv_debug_lane_time);
            this.mLanePlayBtn = (Button) this.mLaneRecordPlay.findViewById(R.id.btn_debug_lane_play);
            this.mLaneRecordBtn = (Button) this.mLaneRecordPlay.findViewById(R.id.btn_debug_lane_record);
            this.mLaneResetBtn = (Button) this.mLaneRecordPlay.findViewById(R.id.btn_debug_lane_reset);
            this.mLanePlayProgress = (XSeekBar) this.mLaneRecordPlay.findViewById(R.id.sb_debug_lane_process);
            this.mContainerSpeed = this.mLaneRecordPlay.findViewById(R.id.container_speed);
            this.mBtnSpeedUp = (Button) this.mLaneRecordPlay.findViewById(R.id.btn_speed_up);
            this.mBtnSpeedDown = (Button) this.mLaneRecordPlay.findViewById(R.id.btn_speed_down);
            this.mTvSpeed = (TextView) this.mLaneRecordPlay.findViewById(R.id.tv_speed);
            this.mBtnSpeedUp.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$8vyuYxu6V2An8YiqCZqtkBcNnB8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapFragment.this.lambda$showLaneRecordPlayBtn$12$MapFragment(view);
                }
            });
            this.mBtnSpeedDown.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$-h7QJO-5AMGe_H-atXohrqUo7d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapFragment.this.lambda$showLaneRecordPlayBtn$13$MapFragment(view);
                }
            });
            this.mLanePlayProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment.12
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    MapFragment.this.mIsDraging = true;
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    MapFragment.this.mIsDraging = false;
                    int progress = seekBar.getProgress();
                    L.Tag tag = MapFragment.TAG;
                    L.i(tag, "onStopTrackingTouch process:" + progress + ", mTotalMsgCount:" + MapFragment.this.mTotalMsgCount);
                    LaneServiceManager.getInstance().setPlayIndex(((((long) progress) * MapFragment.this.mTotalMsgCount) / 100) - 1);
                }
            });
            UiHandlerUtil.getInstance().postDelayed(new AnonymousClass13(), UILooperObserver.ANR_TRIGGER_TIME);
            this.mLaneRecordBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$LRLMYCGzzxPgJelx-3ZvOmjTP1M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapFragment.this.lambda$showLaneRecordPlayBtn$14$MapFragment(view);
                }
            });
            this.mLanePlayBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$Vvbs_N8wWxRG4Lvnw_ltH4eWcDE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapFragment.this.lambda$showLaneRecordPlayBtn$15$MapFragment(view);
                }
            });
            this.mLaneResetBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.-$$Lambda$MapFragment$sRyda07soGFNWWWpIZ6lTZPc_kk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapFragment.this.lambda$showLaneRecordPlayBtn$16$MapFragment(view);
                }
            });
        }
        View view = this.mLaneRecordPlay;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public /* synthetic */ void lambda$showLaneRecordPlayBtn$12$MapFragment(View view) {
        TextView textView = this.mTvSpeed;
        if (textView != null) {
            this.mSpeed++;
            textView.setText(String.valueOf(this.mSpeed));
            LaneServiceManager.getInstance().setPlaySpeed(this.mSpeed);
        }
    }

    public /* synthetic */ void lambda$showLaneRecordPlayBtn$13$MapFragment(View view) {
        if (this.mTvSpeed != null) {
            this.mSpeed--;
            if (this.mSpeed <= 1) {
                this.mSpeed = 1;
            }
            this.mTvSpeed.setText(String.valueOf(this.mSpeed));
            LaneServiceManager.getInstance().setPlaySpeed(this.mSpeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.base.MapFragment$13  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass13 implements Runnable {
        AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LaneServiceManager.getInstance().setPlayerListener(new LaneServicePlayRecordWrapper.IPlayerListener() { // from class: com.xiaopeng.montecarlo.base.MapFragment.13.1
                @Override // com.xiaopeng.montecarlo.navcore.sr.LaneServicePlayRecordWrapper.IPlayerListener
                public void onPlayProgress(long j, long j2, String str, final long j3, final long j4) {
                    MapFragment.this.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.MapFragment.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MapFragment.this.mLanePlayProgress == null || MapFragment.this.mIsDraging) {
                                return;
                            }
                            MapFragment.this.mLanePlayProgress.setProgress((int) (((j3 + 1) * 100) / j4));
                            MapFragment.this.mTotalMsgCount = j4;
                        }
                    });
                }

                @Override // com.xiaopeng.montecarlo.navcore.sr.LaneServicePlayRecordWrapper.IPlayerListener
                public void onTimeChanged(String str) {
                    if (MapFragment.this.mLaneTimeTv != null) {
                        MapFragment.this.mLaneTimeTv.setText(str);
                    }
                }
            });
        }
    }

    public /* synthetic */ void lambda$showLaneRecordPlayBtn$14$MapFragment(View view) {
        Button button = this.mLaneRecordBtn;
        if (button == null || this.mLanePlayBtn == null) {
            return;
        }
        CharSequence text = button.getText();
        int i = R.string.debug_lane_record;
        boolean equals = TextUtils.equals(text, getString(R.string.debug_lane_record));
        LaneServiceManager.getInstance().startRecord(equals);
        Button button2 = this.mLaneRecordBtn;
        if (equals) {
            i = R.string.debug_lane_stop;
        }
        button2.setText(i);
        this.mLanePlayBtn.setVisibility(equals ? 8 : 0);
    }

    public /* synthetic */ void lambda$showLaneRecordPlayBtn$15$MapFragment(View view) {
        Button button;
        if (this.mLaneRecordBtn == null || (button = this.mLanePlayBtn) == null || this.mLaneResetBtn == null) {
            return;
        }
        CharSequence text = button.getText();
        int i = R.string.debug_lane_play;
        boolean equals = TextUtils.equals(text, getString(R.string.debug_lane_play));
        if (equals) {
            this.mLaneResetBtn.setText(R.string.debug_lane_pause);
            this.mContainerSpeed.setVisibility(0);
        } else {
            this.mContainerSpeed.setVisibility(8);
            this.mSpeed = 1;
            this.mTvSpeed.setText(String.valueOf(this.mSpeed));
            LaneServiceManager.getInstance().setPlaySpeed(this.mSpeed);
        }
        LaneServiceManager.getInstance().resetPlay(equals);
        this.mLaneRecordBtn.setVisibility(equals ? 8 : 0);
        Button button2 = this.mLanePlayBtn;
        if (equals) {
            i = R.string.debug_lane_stop;
        }
        button2.setText(i);
        this.mLaneResetBtn.setVisibility(equals ? 0 : 8);
    }

    public /* synthetic */ void lambda$showLaneRecordPlayBtn$16$MapFragment(View view) {
        Button button;
        if (this.mLaneRecordBtn == null || this.mLanePlayBtn == null || (button = this.mLaneResetBtn) == null) {
            return;
        }
        CharSequence text = button.getText();
        int i = R.string.debug_lane_play;
        boolean equals = TextUtils.equals(text, getString(R.string.debug_lane_play));
        LaneServiceManager.getInstance().startPlay(equals);
        Button button2 = this.mLaneResetBtn;
        if (equals) {
            i = R.string.debug_lane_pause;
        }
        button2.setText(i);
    }

    public void enableLccGeoFenceTest(boolean z) {
        this.mMapScenePresenter.enableLccGeoFence(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class DayNightMapTask implements Runnable {
        private boolean mIsEagleEyeShowing;
        private WeakReference<MapViewWrapper> mWeakReference;

        DayNightMapTask(boolean z, MapViewWrapper mapViewWrapper) {
            this.mIsEagleEyeShowing = z;
            this.mWeakReference = new WeakReference<>(mapViewWrapper);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapViewWrapper mapViewWrapper = this.mWeakReference.get();
            if (mapViewWrapper != null) {
                MapTextureResourcesHelper.clearResources();
                L.i(MapFragment.TAG, L.formatDayNightSwitchLog("addOverlayTexturesAsync"));
                MarkUtils.addOverlayTexturesAsync(mapViewWrapper, mapViewWrapper.getMainEngineID(), MapTextureResourcesHelper.getDefaultMapTextureResources());
                mapViewWrapper.updateCarLocIcon();
                if (this.mIsEagleEyeShowing && !Utils.isMapLightColumn()) {
                    if (L.ENABLE) {
                        L.d(MapFragment.TAG, "exchangeDayNight restore EagleEye isEagleEyeShowing true");
                    }
                    mapViewWrapper.enableEagleEyeState(ContextUtils.getDimensionPixelSize(R.dimen.guide_eagle_view_width), ThemeWatcherUtil.isDayMode(), MapUtil.getDefaultEagleLocation());
                    mapViewWrapper.getBizControlManager().updateMapEagleEyeView(true, true);
                }
                mapViewWrapper.setIsDayNightSwitching(false);
            }
        }
    }
}
