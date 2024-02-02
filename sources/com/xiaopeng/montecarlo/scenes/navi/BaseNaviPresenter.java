package com.xiaopeng.montecarlo.scenes.navi;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.AiMsgUtils;
import com.xiaopeng.montecarlo.base.BaseFullScenes;
import com.xiaopeng.montecarlo.base.IRouteUpdateContract;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.charge.highspeed.NaviSuperChargeManager;
import com.xiaopeng.montecarlo.events.RestoreNaviEvent;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.montecarlo.navcore.event.ParallelRoadEvent;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.navcore.xptbt.INaviListener;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.AiMsgConfirmBean;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPAsyncInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.dataprovider.NaviDataProvider;
import com.xiaopeng.montecarlo.scenes.navi.dataprovider.NaviRequestParam;
import com.xiaopeng.montecarlo.scenes.navi.dataprovider.NaviReturnData;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.ChargeSearchAlongWayController;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.SRUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.RecommendRoutePop;
import com.xiaopeng.montecarlo.views.RouteChargePanelView;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes2.dex */
public abstract class BaseNaviPresenter<T extends IBaseNaviLogicView<? extends AbstractBasePresenter>> extends BaseNgpPresenter implements BaseMapDecorator.IMapDecoratorRouteUpdateListener, XCountDownTimer.ITimerCallback, BaseCallBack<NaviRequestParam, NaviReturnData>, SceneMapEvent.SceneMapListener, NavRestoreManager.NavRestoreListener, RouteChargePanelView.IRouteChargeDetailListener, IRouteUpdateContract, OddDataHelper.OddHelperListener {
    public static final int PARALLEL_REROUTE = 2;
    public static final int REROUTE = 1;
    public static final int SET_DESTINATION_RECOMMEND_PARKING = 3;
    private static final long SWITCH_ROUTE_TIME_OUT = 20000;
    private static final long SWITCH_SR_AUTO_TIMER = 5000;
    private static final L.Tag TAG = new L.Tag("BaseNaviPresenter");
    public static final int UPDATE_WAY_POINT_AND_SET_DESTINATION = 4;
    public static final int UPDATE_WAY_POINT_OR_SET_DESTINATION = 0;
    private ArrayList<String> mBizControlTypes;
    protected IXpLayerClickObserver mBizOverlayObserver;
    private ChargeSearchAlongWayController mChargeSearchController;
    private final T mLogicView;
    private final NaviDataProvider mNaviDataProvider;
    protected NaviPresenterListener mNaviPresenterListener;
    private final NaviSuperChargeManager mNaviSuperChargeManager;
    private XCountDownTimer mSwitchSRAutoTimer;
    private XCountDownTimer mTimer;
    public final boolean mIsNeedShowAiMsg = true;
    protected int mRequestType = -1;
    protected boolean mIsNeedShowRecommendRoute = false;
    protected boolean mIsNeedGotoMapCenter = false;
    protected int mSavedMapMode = -1;
    protected int mSavedMapLevel = -1000;
    protected int mTryCountOffline = 0;
    private String mAiMessageId = "";
    private boolean mIsIgnoreCloseAiMsg = false;
    private int mLastDriveMode = 1;
    private XCountDownTimer.ITimerCallback mSwitchSRTimerCallback = new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.1
        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTick(long j) {
        }

        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTimeOut() {
            L.i(BaseNaviPresenter.TAG, ">>> onTimeOut switch to sr =");
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.1.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseNaviPresenter.this.switchNaviMode(false);
                }
            });
        }
    };

    protected abstract void beforeStopNavi(boolean z);

    public void enterOverViewMode() {
    }

    protected abstract void exitPreviewByNaviStop();

    protected abstract IXpLayerClickObserver getBizOverlayObserver();

    protected abstract NaviPresenterListener getNaviPresenterListener();

    protected abstract int getTBTStatus();

    public boolean isETARerouteType(int i) {
        return i == 5 || i == 7 || i == 6 || i == 13 || i == 11;
    }

    public boolean isForceRerouteETAType(int i) {
        return i == 7 || i == 6 || i == 13 || i == 11;
    }

    public boolean isIgnoreETAReroute(int i) {
        return 5 == i;
    }

    protected abstract boolean isPreview();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull NaviReturnData naviReturnData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(NaviRequestParam naviRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(NaviRequestParam naviRequestParam) {
    }

    public abstract void onSelectRoute(int i);

    public void updateAccSpeed(float f) {
    }

    public void updateLimitSpeed(int i) {
    }

    public BaseNaviPresenter(T t) {
        if (t == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        this.mLogicView = t;
        this.mNaviPresenterListener = getNaviPresenterListener();
        this.mBizOverlayObserver = getBizOverlayObserver();
        this.mNaviDataProvider = new NaviDataProvider();
        this.mNaviSuperChargeManager = new NaviSuperChargeManager();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNgpPresenter
    @NonNull
    public T getLogicView() {
        return this.mLogicView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MapViewWrapper getMapView() {
        return getLogicView().getMapView();
    }

    public int getTryCountOffline() {
        return this.mTryCountOffline;
    }

    public void setTryCountOffline(int i) {
        this.mTryCountOffline = i;
    }

    @MainThread
    public void updateOverlayObserver(boolean z, String... strArr) {
        if (L.ENABLE) {
            L.d(TAG, "updateOverlayObserver");
        }
        ArrayList<String> arrayList = this.mBizControlTypes;
        if (arrayList == null) {
            this.mBizControlTypes = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.mBizControlTypes.add(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE);
        this.mBizControlTypes.add(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY);
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                this.mBizControlTypes.add(str);
            }
        }
        if (z) {
            this.mLogicView.getMapView().getBizControlManager().addClickObserver(this.mBizControlTypes, this.mBizOverlayObserver);
        } else {
            this.mLogicView.getMapView().getBizControlManager().removeClickObserver(this.mBizControlTypes, this.mBizOverlayObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorRouteUpdateListener
    public void onRouteUpdate(DecoratorType decoratorType, Bundle bundle) {
        BaseMapDecorator.IMapDecoratorRouteUpdateListener mapDecoratorRouteUpdateListener = getMapDecoratorRouteUpdateListener();
        if (mapDecoratorRouteUpdateListener != null) {
            mapDecoratorRouteUpdateListener.onRouteUpdate(decoratorType, bundle);
        }
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorRouteUpdateListener
    public void onDestinationUpdate(DecoratorType decoratorType, Bundle bundle) {
        BaseMapDecorator.IMapDecoratorRouteUpdateListener mapDecoratorRouteUpdateListener = getMapDecoratorRouteUpdateListener();
        if (mapDecoratorRouteUpdateListener != null) {
            mapDecoratorRouteUpdateListener.onDestinationUpdate(decoratorType, bundle);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (speechNaviEvent.what == 903) {
            return true;
        }
        return super.onInterceptSpeechEvent(speechNaviEvent, iCommandCallback);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        int i = speechNaviEvent.what;
        if (i == 100) {
            L.i(TAG, "SPEECH_OPEN_FAVORITE");
            getLogicView().getSpeechEventBizHelper().openFavorite(this);
            return true;
        } else if (i == 109) {
            L.i(TAG, "SPEECH_OPEN_SEARCH_NORMAL");
            getLogicView().getSpeechEventBizHelper().openSearchNormalInNavi(this);
            return true;
        } else {
            if (i == 501) {
                L.i(TAG, "SPEECH_SELECT_RECOMMEND_PARK");
                getLogicView().getSpeechEventBizHelper().selectRecommendPard(this, speechNaviEvent);
            } else if (i == 903) {
                L.i(TAG, "SPEECH_SET_POI_TO_CENTER");
                return true;
            } else if (i == 312) {
                L.i(TAG, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS");
                getLogicView().getSpeechEventBizHelper().routeNewDestWithViasInNav(this, speechNaviEvent);
                return true;
            } else if (i == 313) {
                L.i(TAG, "SPEECH_ADD_VIA");
                getLogicView().getSpeechEventBizHelper().addViaInNavi(this, speechNaviEvent);
            } else if (i == 405) {
                L.i(TAG, "SPEECH_ZOOM_IN");
                getLogicView().getSpeechEventBizHelper().zoomInInNavi(this);
            } else if (i != 406) {
                switch (i) {
                    case 303:
                        L.i(TAG, "SPEECH_REROUTE");
                        getLogicView().getSpeechEventBizHelper().reroute(this);
                        break;
                    case 304:
                        L.i(TAG, "SPEECH_START_NAVI");
                        getLogicView().getSpeechEventBizHelper().startNavi(this);
                        break;
                    case 305:
                        L.i(TAG, "SPEECH_STOP_NAVI");
                        getLogicView().getSpeechEventBizHelper().stopNavi(this);
                        break;
                    case 306:
                        L.i(TAG, "SPEECH_UPDATE_ROUTE");
                        if (TBTManager.getInstance().getCurrentStatus() == 1) {
                            updateTBTAndRoute(false, TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
                            break;
                        }
                        break;
                }
            } else {
                L.i(TAG, "SPEECH_ZOOM_OUT");
                getLogicView().getSpeechEventBizHelper().zoomOutInNavi(this);
            }
            return false;
        }
    }

    public void executeSpeechCmdOpenFavorite() {
        getLogicView().openFavourite();
        SpeechStatProxy.getInstance().sendStatDataForSpeech(9, 2);
    }

    public void executeSpeechCmdZoomOut() {
        getNaviSpeechEventHandler().onZoomOut();
    }

    public void executeSpeechCmdZoomIn() {
        getNaviSpeechEventHandler().onZoomIn();
    }

    public void executeSpeechCmdStartNavi() {
        getNaviSpeechEventHandler().onStartNavi();
    }

    public void executeSpeechCmdSelectRecommendPark(SpeechNaviEvent speechNaviEvent) {
        getNaviSpeechEventHandler().onSelectRecommendPark(speechNaviEvent.getIndex(), true);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(32, 2);
    }

    public void executeSpeechCmdAddVia(SpeechNaviEvent speechNaviEvent) {
        getNaviSpeechEventHandler().onViaAdd(speechNaviEvent.getDest());
        executePageExchange();
    }

    private void executePageExchange() {
        if (Utils.isLandscape()) {
            return;
        }
        StatusConst.Mode currentSceneMode = getLogicView().getCurrentSceneMode();
        if ((currentSceneMode == StatusConst.Mode.EXPLORE || currentSceneMode == StatusConst.Mode.NAVI) ? false : true) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "executePageExchange mode:" + currentSceneMode);
            }
            getLogicView().getMainContext().getCurrentScene().goBack();
        }
    }

    public void executeSpeechCmdRouteNewDestWithVias(SpeechNaviEvent speechNaviEvent) {
        getLogicView().hideMapDecorators();
        XPPoiInfo dest = speechNaviEvent.getDest();
        ArrayList<XPViaPoint> viaList = speechNaviEvent.getViaList();
        int settingParam = speechNaviEvent.getSettingParam();
        int startType = speechNaviEvent.getStartType();
        int routeSelectRef = speechNaviEvent.getRouteSelectRef();
        getNaviSpeechEventHandler().onNewDestWithViasReroute(speechNaviEvent.getOrig(), dest, viaList, settingParam, startType, routeSelectRef);
        executePageExchange();
    }

    public void executeSpeechCmdReroute() {
        getNaviSpeechEventHandler().onReroute();
    }

    public void executeSpeechCmdStopNavi() {
        getNaviSpeechEventHandler().onStopNavi();
        SpeechStatProxy.getInstance().sendStatDataForSpeech(1, 2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onParallelRoadEvent(ParallelRoadEvent parallelRoadEvent) {
        if (parallelRoadEvent != null) {
            if (StatusConst.Mode.EXPLORE == getLogicView().getCurrentSceneMode() || 2 != TBTManager.getInstance().getCurrentStatus()) {
                int type = parallelRoadEvent.getType();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "onParallelRoadEvent type:" + type);
                }
                IParallelRoadEventHandler parallelRoadEventHandler = getParallelRoadEventHandler();
                if (type != 1) {
                    return;
                }
                parallelRoadEventHandler.onRoadSwitchFinish();
            }
        }
    }

    public long requestReroute(boolean z) {
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
        if (endInfo == null) {
            return -1L;
        }
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams == null) {
            return -1L;
        }
        return requestReroute(new RouteParams.Builder().setStartInfo(startPOIFromCurrent).setEndInfo(endInfo).setViaInfos(currentNaviRouteParams.mViaInfos).setRerouteType(3).setConstrainCode(currentNaviRouteParams.mConstrainCode).setRouteCalcType(currentNaviRouteParams.mRouteCalcType).setRouteLevel(1).setNetworkProperty(z ? 1 : 2).setIsRequestOdd(CarServiceManager.getInstance().isNGPOn()).build(), false);
    }

    public long requestReroute(int i, int i2, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "requestReroute rerouteType:" + i + " requestType:" + i2);
        }
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentNaviId());
        this.mRequestType = i2;
        int i3 = 1;
        int i4 = this.mRequestType;
        i3 = (i4 == 0 || i4 == 3) ? 2 : 2;
        if (z) {
            return requestReroute(new RouteParams.Builder().setStartInfo(startPOIFromCurrent).setEndInfo(endInfo).setViaInfos(viaInfos).setRerouteType(i).setRouteLevel(i3).setIsRequestOdd(CarServiceManager.getInstance().isNGPOn()).build(), false);
        }
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams == null) {
            return -1L;
        }
        return requestReroute(new RouteParams.Builder().setStartInfo(startPOIFromCurrent).setEndInfo(endInfo).setViaInfos(viaInfos).setRerouteType(i).setConstrainCode(currentNaviRouteParams.mConstrainCode).setIsRequestOdd(CarServiceManager.getInstance().isNGPOn()).setRouteCalcType(currentNaviRouteParams.mRouteCalcType).setRouteLevel(i3).build(), false);
    }

    public long requestReroute(RouteRequest routeRequest, int i) {
        return requestReroute(routeRequest, i, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long requestReroute(com.xiaopeng.montecarlo.scenes.routescene.RouteRequest r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.requestReroute(com.xiaopeng.montecarlo.scenes.routescene.RouteRequest, int, boolean):long");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long requestReroute(RouteParams routeParams, boolean z) {
        if (routeParams == null) {
            return -1L;
        }
        if (routeParams.mRoutePriority == 2) {
            NaviStatUtil.sendStatDataWhenReroute(getLogicView().getMainContext(), routeParams.mEndInfo, z);
        } else {
            NaviStatUtil.sendStatDataWhenDeviation(getLogicView().getMainContext(), routeParams.mEndInfo);
        }
        getLogicView().getMainContext().getDecoratorManager().clearFocus();
        long requestReroute = TBTManager.getInstance().requestReroute(routeParams, null);
        if (getLogicView() != null && -1 != requestReroute) {
            getLogicView().saveCurrentRequestingId(requestReroute);
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.-$$Lambda$BaseNaviPresenter$uJISQ6GZ-2JnK4S_P3QqSydlxZY
                @Override // java.lang.Runnable
                public final void run() {
                    BaseNaviPresenter.this.lambda$requestReroute$0$BaseNaviPresenter();
                }
            });
        }
        return requestReroute;
    }

    public /* synthetic */ void lambda$requestReroute$0$BaseNaviPresenter() {
        getLogicView().onShowRouting(false);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.d(TAG, "onResume");
        }
        long currentRequestingId = getLogicView().getCurrentRequestingId();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onResume requestId = " + currentRequestingId);
        }
        if (-1 != currentRequestingId) {
            boolean isRouting = TBTManager.getInstance().isRouting(currentRequestingId);
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "onResume isRouting = " + isRouting);
            }
            if (isRouting) {
                RouteParams routeParams = TBTManager.getInstance().getRouteParams(currentRequestingId);
                getLogicView().onShowRouting(routeParams != null ? !routeParams.mCurRequestIsOnline : false);
            }
        }
        getLogicView().getMainContext().addSceneMapListener(this);
        if (AiMsgUtils.getInstance().getNeedChargeSearchWhenRestore()) {
            if (this.mChargeSearchController == null) {
                this.mChargeSearchController = new ChargeSearchAlongWayController(getLogicView().getMainContext());
            }
            this.mChargeSearchController.alongWayChargeSearch();
            AiMsgUtils.getInstance().setNeedChargeSearchWhenRestore(false);
        }
        if (!SRNaviManager.getInstance().canShowSRScene() || 2 == getTBTStatus()) {
            disableSRNaviMode();
            return;
        }
        getLogicView().getMainContext().updateSRNaviSwitchStatus(0, isLaneViewShow());
        restoreMapState();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        if (L.ENABLE) {
            L.d(TAG, "onPause");
        }
        getLogicView().getMainContext().removeSceneMapListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTick(long j) {
        getLogicView().onRecommendRoutePopTick(j);
    }

    public XPManeuverInfo getNaviManeuerInfo() {
        return TBTManager.getInstance().getNaviManeuverInfo();
    }

    public void asyncManeuverInfo(XPAsyncInfo xPAsyncInfo) {
        TBTManager.getInstance().asyncManeuverInfo(xPAsyncInfo);
    }

    public void asyncManeuverInfo(XPManeuverInfo xPManeuverInfo) {
        TBTManager.getInstance().asyncManeuverInfo(xPManeuverInfo);
    }

    public void updateManeuverInfoWhenThemeSwitch() {
        getLogicView().onAsyncManeuverInfo(getNaviManeuerInfo());
        updateNaviManeuerInfo(getNaviManeuerInfo());
    }

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTimeOut() {
        if (L.ENABLE) {
            L.d(TAG, "RecommendRoute: onTimeOut");
        }
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.-$$Lambda$BaseNaviPresenter$ChTdZnpTJFIuEtf6k2uCw3j87jg
            @Override // java.lang.Runnable
            public final void run() {
                BaseNaviPresenter.this.lambda$onTimeOut$1$BaseNaviPresenter();
            }
        });
        getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6031L);
    }

    public /* synthetic */ void lambda$onTimeOut$1$BaseNaviPresenter() {
        getLogicView().onHideRecommendRoutePop();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onShowRecommendRoute(com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult r18, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath r19, int r20, com.autonavi.gbl.common.path.model.RouteLimitInfo r21) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.onShowRecommendRoute(com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath, int, com.autonavi.gbl.common.path.model.RouteLimitInfo):void");
    }

    protected boolean isIgnoreDeletePath() {
        return !TextUtils.isEmpty(this.mAiMessageId);
    }

    public boolean doesExistTightTurn(XPNaviInfo xPNaviInfo) {
        return NavCoreUtil.doesTightTurnExist(xPNaviInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTrafficEventClick(double d, double d2, long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onTrafficEventClick: [" + d2 + ", " + d + "], eventId: " + j);
        }
        getLogicView().showNavTrafficEventPop(new TrafficEventPopParam.Builder(2).setEventId(Long.toString(j)).setIsZoom(false).setLon(d).setLat(d2).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSceneStrictLegal() {
        IBaseScene currentScene;
        if (!getLogicView().isSceneLegal() || (currentScene = getLogicView().getMainContext().getCurrentScene()) == null) {
            return false;
        }
        return !currentScene.hasChildScene();
    }

    public void restoreRecommendRouteShow() {
        if (this.mIsNeedShowRecommendRoute && isSceneStrictLegal()) {
            IPathResult recommendNaviPathResult = TBTManager.getInstance().getRecommendNaviPathResult();
            IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
            IVariantPath oldNaviVariantPath = TBTManager.getInstance().getOldNaviVariantPath();
            int routeType = TBTManager.getInstance().getRouteType(TBTManager.getInstance().getCurrentNaviId());
            RouteLimitInfo routeLimitInfo = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentNaviId()).mExternData;
            if (recommendNaviPathResult != null) {
                routeType = TBTManager.getInstance().getRouteType(TBTManager.getInstance().getRecommendNaviId());
                oldNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
                routeLimitInfo = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getRecommendNaviId()).mExternData;
            } else {
                recommendNaviPathResult = currentNaviPathResult;
            }
            L.Tag tag = TAG;
            L.i(tag, "RECOMMEND_ROUTE restore recommend route, routeType: " + routeType + ",pathResult: " + recommendNaviPathResult);
            if (recommendNaviPathResult != null && routeType != -1 && isETARerouteType(routeType)) {
                if (isIgnoreETAReroute(routeType)) {
                    getLogicView().onHideRecommendRoutePop();
                    L.i(TAG, "RECOMMEND_ROUTE ignore ETA reroute restore");
                    return;
                }
                onShowRecommendRoute(recommendNaviPathResult, oldNaviVariantPath, routeType, routeLimitInfo);
            } else {
                getLogicView().onHideRecommendRoutePop();
            }
            this.mIsNeedShowRecommendRoute = false;
        }
    }

    public void stopNaviWaitingForTTs(int i, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "stopNaviWaitingForTTs: " + i + ", isByUser: " + z);
        }
        if (isLaneViewShow()) {
            disableSRNaviMode();
        }
    }

    public void stopNavi(final int i, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "stopNavi: " + i + ", isByUser: " + z);
        }
        beforeStopNavi(z);
        exitPreviewByNaviStop();
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.-$$Lambda$BaseNaviPresenter$e2q3k6zDDi91KUjElZoqYnizoMM
            @Override // java.lang.Runnable
            public final void run() {
                BaseNaviPresenter.this.lambda$stopNavi$2$BaseNaviPresenter(i);
            }
        }, 500L);
        updateNaviRemainInfo(false);
        if (getAiMessageId() != null) {
            closeAiAssistant();
        }
    }

    public /* synthetic */ void lambda$stopNavi$2$BaseNaviPresenter(int i) {
        startCruise(i, !(StateManager.getInstance().getState() == 0));
    }

    public void adjustSimulationsSpeed(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "adjustSimulationsSpeed isSpeedUp:" + z);
        }
        TBTManager.getInstance().adjustSimulation(z);
        getLogicView().onUpdateSimulatePanel();
    }

    public int getBLSimulationNaviSpeed() {
        return TBTManager.getInstance().getSimulationSpeed();
    }

    public void switchSimulation() {
        L.Tag tag = TAG;
        L.i(tag, ">>> switchSimulation speed=" + TBTManager.getInstance().getSimulationSpeed());
        if (TBTManager.getInstance().getSimulationSpeed() == 0) {
            TBTManager.getInstance().resumeSimulation();
        } else {
            TBTManager.getInstance().pauseSimulation();
        }
    }

    public void switchActiveState() {
        if (1 == StateManager.getInstance().getState()) {
            StateManager.getInstance().switchActiveState();
        }
    }

    public void clearNaviData() {
        if (L.ENABLE) {
            L.d(TAG, "clearNaviData");
        }
        getMapView().getBizControlManager().clearNaviData();
    }

    public void exitOverviewMode() {
        exitOverviewMode(true);
    }

    public void exitOverviewMode(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "exitOveorviewMode mSavedMapMode:" + this.mSavedMapMode);
        }
        if (this.mSavedMapMode != -1) {
            getMapView().exitPreview(true, true);
            if (z) {
                getMapView().goBackCenter(false);
            }
            getMapView().setMapMode(this.mSavedMapMode);
            getMapView().setMapLevel(this.mSavedMapLevel);
        }
    }

    public void setIsNeedShowRecommendRoute(boolean z) {
        this.mIsNeedShowRecommendRoute = z;
    }

    public IStateListener getStateListener() {
        return this.mNaviPresenterListener.getStateListener();
    }

    public INaviSpeechEventHandler getNaviSpeechEventHandler() {
        return this.mNaviPresenterListener.getNaviSpeechEventHandler();
    }

    public IMapSceneEventHandler getMapSceneEventHandler() {
        return this.mNaviPresenterListener.getMapSceneEventHandler();
    }

    public RestrictHelper.IRestrictEventCallback getRestrictEventCallback() {
        return this.mNaviPresenterListener.getRestrictEventCallback();
    }

    public GuideManager.IRerouteListener getRerouteListener() {
        return this.mNaviPresenterListener.getRerouteListener();
    }

    public INaviListener getNaviListener() {
        return this.mNaviPresenterListener.getNaviListener();
    }

    public BaseMapDecorator.IMapDecoratorRouteUpdateListener getMapDecoratorRouteUpdateListener() {
        return this.mNaviPresenterListener.getMapDecoratorRouteUpdateListener();
    }

    public IRecommendParkingListener getRecommendParkingListener() {
        return this.mNaviPresenterListener.getRecommendParkingListener();
    }

    public IParallelRoadEventHandler getParallelRoadEventHandler() {
        return this.mNaviPresenterListener.getParallelRoadEventHandler();
    }

    public ISceneMapFragmentListener getSceneMapFragmentListener() {
        return this.mNaviPresenterListener.getSceneMapFragmentListener();
    }

    public IXPNetworkListener getXPNetworkListener() {
        return this.mNaviPresenterListener.getXPNetworkListener();
    }

    public IRouteUpdateContract getRouteUpdateContractImpl() {
        return this.mNaviPresenterListener.getRouteUpdateContractImpl();
    }

    public ISRInfoChangedListener getSRInfoChangedListener() {
        return this.mNaviPresenterListener.getSRInfoChangedListener();
    }

    public boolean deleteCandidatePath(List<Long> list, long j) {
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        L.Tag tag = TAG;
        L.i(tag, "CANDIDATE_PATH delete overdue candidate path size: " + list.size() + ", oldNavId: " + j + ", current naviId: " + currentNaviId);
        if (j != currentNaviId) {
            return false;
        }
        if (isIgnoreDeletePath() && updateRecommendRoute(currentNaviId)) {
            L.i(TAG, "CANDIDATE_PATH recommend route comparing is showing, ignore");
            return false;
        }
        getMapView().getBizControlManager().deleteCandidatePath();
        updateTBTAndRoute(false, currentNaviId, TBTManager.getInstance().getCurrentNaviPathIndex());
        return true;
    }

    protected boolean updateRecommendRoute(long j) {
        IPathResult iPathResult;
        RouteLimitInfo routeLimitInfo;
        IVariantPath iVariantPath;
        int i;
        if (isSceneStrictLegal()) {
            RouteResult routeResult = TBTManager.getInstance().getRouteResult(j);
            long recommendNaviId = TBTManager.getInstance().getRecommendNaviId();
            RouteResult routeResult2 = TBTManager.getInstance().getRouteResult(recommendNaviId);
            if (routeResult != null && isForceRerouteETAType(routeResult.mRouteType)) {
                iVariantPath = TBTManager.getInstance().getOldNaviVariantPath();
                iPathResult = routeResult.mPathResult;
                routeLimitInfo = routeResult.mExternData;
                i = routeResult.mRouteType;
            } else {
                if (recommendNaviId > 0 && routeResult2 != null && routeResult2.mRouteType == 5) {
                    IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
                    iPathResult = routeResult2.mPathResult;
                    routeLimitInfo = routeResult2.mExternData;
                    int i2 = routeResult2.mRouteType;
                    iVariantPath = currentNaviVariantPath;
                    i = i2;
                }
                return false;
            }
            if (routeLimitInfo == null || isIgnoreETAReroute(i)) {
                L.Tag tag = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("updateRecommendRouteOnDeletePath routeType: ");
                sb.append(i);
                sb.append(", external data is null: ");
                sb.append(routeLimitInfo == null);
                L.i(tag, sb.toString());
                return false;
            } else if (iPathResult == null) {
                L.i(TAG, "updateRecommendRouteOnDeletePath newPathResult: is null！ ");
                return false;
            } else {
                IVariantPath path = iPathResult.getPath(0);
                if (path == null || iVariantPath == null) {
                    L.Tag tag2 = TAG;
                    L.i(tag2, "updateRecommendRouteOnDeletePath newPath is : " + path + " and oldPath is : " + iVariantPath);
                    return false;
                }
                int i3 = i != 5 ? 0 : 1;
                clearOldOverlay(false);
                getMapView().getBizControlManager().drawComparingRoutes(BLParams.RouteOverlayGuide, i3, 0, true, TBTManager.getInstance().getCurrentNaviRouteParams(), path, iVariantPath);
                return true;
            }
        }
        return false;
    }

    public void selectMainPath(long j, boolean z) {
        getLogicView().hideRouteChargePanelView(true);
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        int pathIndexFromPathId = TBTUtil.getPathIndexFromPathId(currentNaviPathResult, j);
        if (pathIndexFromPathId > -1) {
            sendStatDataForOptionalRoute(z, currentNaviPathResult.getPath(pathIndexFromPathId), TBTManager.getInstance().getCurrentNaviRouteParams());
            getMapView().getBizControlManager().setSelectedPath(BLParams.RouteOverlayGuide, TBTManager.getInstance().getCurrentNaviId(), pathIndexFromPathId);
            if (z) {
                getLogicView().getMainContext().showPrompt(R.string.switch_route_success);
            }
            L.Tag tag = TAG;
            L.i(tag, "CANDIDATE_PATH selectMainPath: " + j + ",isUserSelect: " + z + ", path result index: " + pathIndexFromPathId);
        }
    }

    private void sendStatDataForOptionalRoute(boolean z, IVariantPath iVariantPath, RouteParams routeParams) {
        PathMatchInfo pathMatchInfo;
        if (iVariantPath == null || routeParams == null) {
            L.e(TAG, "sendStatDataForOptionalRoute variantPath or params is null.");
            return;
        }
        MapViewWrapper mapView = getMapView();
        if (mapView == null) {
            L.e(TAG, "sendStatDataForOptionalRoute mapViewWrapper is null.");
            return;
        }
        CarLoc carLocation = mapView.getBizControlManager().getCarLocation();
        if (carLocation == null) {
            L.e(TAG, "sendStatDataForOptionalRoute getCarLocation is null.");
            return;
        }
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        if (CollectionUtils.isNotEmpty(carLocation.vecPathMatchInfo) && (pathMatchInfo = carLocation.vecPathMatchInfo.get(0)) != null) {
            coord2DDouble.lat = pathMatchInfo.latitude;
            coord2DDouble.lon = pathMatchInfo.longitude;
        }
        if (iVariantPath != null) {
            DataLogUtil.sendStatData(TBTManager.getInstance().getCurrentStatus() == 1 ? PageType.NAVI_GUIDANCE : PageType.NAVI_DETECT_ROUTE, BtnType.GUIDE_OPTIONAL_ROUTE, Long.valueOf(NaviUtil.getTravelDistance(iVariantPath)), Long.valueOf(NaviUtil.getTravelTime(iVariantPath)), Integer.valueOf(NaviUtil.getTollCost(iVariantPath)), Long.valueOf(NaviUtil.getTrafficLightCount(iVariantPath)), coord2DDouble, routeParams.mEndInfo.getNaviPoint(false).toBLCoord2D(), Integer.valueOf(z ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void clearOldOverlay(boolean z) {
        getMapView().getBizControlManager().clearOldOverlay(z);
    }

    @MainThread
    public void updateTBTAndRoute(boolean z, long j, int i) {
        boolean z2;
        L.i(TAG, "updateTBTAndRoute isNeedStartNavi:" + z + " , naviId = " + j + " , pathIndex = " + i);
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(j);
        if (routeResult == null || routeResult.mPathResult == null) {
            L.w(TAG, "updateTBTAndRoute missing routeResult:" + routeResult);
            resetWhenNoNavi();
            return;
        }
        L.i(TAG, "updateTBTAndRoute getCurrentStatus:" + TBTManager.getInstance().getCurrentStatus());
        boolean z3 = false;
        if (z) {
            if (TBTManager.getInstance().getCurrentStatus() == 0) {
                z2 = true;
                z3 = true;
            } else {
                TBTManager.getInstance().setCurrentStatus(getTBTStatus());
                clearOldOverlay(true);
                z2 = false;
            }
            if (TBTManager.getInstance().getCurrentStatus() != 1 && TBTManager.getInstance().getCurrentStatus() != 2) {
                TBTManager.getInstance().startNavi(j, i, ThemeWatcherUtil.getMapModeByCurrentTheme(), getTBTStatus());
            }
        } else if (TBTManager.getInstance().getCurrentStatus() == 3) {
            TBTManager.getInstance().startNavi(j, i, ThemeWatcherUtil.getMapModeByCurrentTheme(), getTBTStatus());
            z2 = true;
            z3 = true;
        } else if (TBTManager.getInstance().getCurrentStatus() != 1 && TBTManager.getInstance().getCurrentStatus() != 2) {
            L.w(TAG, "updateTBTAndRoute currentStatus is:" + TBTManager.getInstance().getCurrentStatus());
            resetWhenNoNavi();
            return;
        } else {
            TBTManager.getInstance().setCurrentStatus(getTBTStatus());
            z2 = false;
        }
        updateRoute(routeResult.mPathResult, i, z2, z3);
        XPManeuverInfo naviManeuverInfo = TBTManager.getInstance().getNaviManeuverInfo();
        if (naviManeuverInfo != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(naviManeuverInfo.mSegmentIndex));
            getMapView().getBizControlManager().setRouteArrowShowSegment(arrayList);
        }
    }

    public void resetWhenNoNavi() {
        L.i(TAG, ">>> resetWhenNoNavi");
        if (TBTManager.getInstance().getCurrentStatus() == 0) {
            getLogicView().goToMap();
        } else {
            TBTManager.getInstance().stopNavi(true);
        }
    }

    private void startCruise(int i) {
        startCruise(i, true);
    }

    private void startCruise(int i, boolean z) {
        clearNaviData();
        getLogicView().onNaviStop(i);
        getLogicView().saveCurrentRequestingId(-1L);
        if (i == 1) {
            this.mIsNeedGotoMapCenter = true;
        } else {
            this.mIsNeedGotoMapCenter = false;
        }
        getMapView().initCruiseCar(ThemeWatcherUtil.getMapModeByCurrentTheme(), true);
        getMapView().getBizControlManager().initCruiseCar(z);
        StateManager.getInstance().switchActiveState();
    }

    public void requestRestrict() {
        RestrictHelper restrictHelper = getLogicView().getRestrictHelper();
        if (restrictHelper != null) {
            restrictHelper.requestRestrict(getRestrictEventCallback(), TBTManager.getInstance().getCurrentNaviId());
        }
    }

    protected void showRouteMsg(int i, int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showRouteMsg message:" + i2);
        }
        getLogicView().onShowOfflineRouteMsg(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRectDoubleValid(RectDouble rectDouble) {
        return rectDouble != null && 0.0d < rectDouble.left && 0.0d < rectDouble.top && 0.0d < rectDouble.right && 0.0d < rectDouble.bottom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRoute(IPathResult iPathResult, int i, boolean z, boolean z2) {
        L.Tag tag = TAG;
        L.i(tag, ">>> updateRoute index = " + i);
        getMapView().getBizControlManager().updateRoute(BLParams.RouteOverlayGuide, iPathResult, TBTManager.getInstance().getCurrentNaviRouteParams(), TBTManager.getInstance().getCurrentNaviId(), i, true, z, z2);
        getLogicView().onShowRoute(iPathResult, i);
        updateRemainDis();
    }

    public void stopTimer() {
        XCountDownTimer xCountDownTimer = this.mTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.stop();
        }
    }

    public void startSwitchToSRTimer() {
        if (this.mSwitchSRAutoTimer == null) {
            this.mSwitchSRAutoTimer = new XCountDownTimer(5000L, this.mSwitchSRTimerCallback);
        }
        this.mSwitchSRAutoTimer.start();
    }

    public void stopSwitchToSRTimer() {
        XCountDownTimer xCountDownTimer = this.mSwitchSRAutoTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.stop();
        }
    }

    public void handleTollGateInfo(XPTollGateInfo xPTollGateInfo) {
        if (xPTollGateInfo == null) {
            L.i(TAG, ">>> onShowTollGateLane:tollGateInfo end");
            getLogicView().hideCruiseTollGateInfo();
            return;
        }
        if (CollectionUtils.isEmpty(xPTollGateInfo.mLaneTypes)) {
            L.w(TAG, ">>> onShowTollGateLane:tollGateInfo invalid data");
        }
        List<Integer> list = xPTollGateInfo.mLaneTypes;
        if (CollectionUtils.isEmpty(list)) {
            L.i(TAG, ">>> onShowTollGateLane:tollGateInfo list is null");
            return;
        }
        if (L.ENABLE) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str = str + list.get(i);
            }
            L.d(TAG, " tollgate lanetype:" + str);
        }
        getLogicView().showCruiseTollGateInfo(list);
    }

    public void showAiMessage(String str, String str2, String str3, String str4, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RECOMMEND_ROUTE showAiMessage eventName: " + str + ", saveTime: " + str2 + ", dist: " + str4 + ", canSwitch:" + z);
        }
        MessageContentBean createContent = MessageContentBean.createContent();
        int i = 2501;
        if (z) {
            createContent.setType(13);
            createContent.addTitle(str);
            if (RootUtil.isEmptyString(str2)) {
                str2 = str4;
            }
            createContent.addTitle(str2);
            if (RootUtil.isEmptyString(str3)) {
                str3 = str4;
            }
            createContent.setTts(str3);
            createContent.setPermanent(0);
            AiMsgConfirmBean aiMsgConfirmBean = new AiMsgConfirmBean();
            aiMsgConfirmBean.setType(13);
            aiMsgConfirmBean.setStatus(true);
            createContent.addButton(MessageContentBean.MsgButton.create(ContextUtils.getString(R.string.ai_message_switch_route), ContextUtils.getContext().getPackageName(), GsonUtil.toJson(aiMsgConfirmBean)));
        } else {
            createContent.setType(10);
            createContent.addTitle(!RootUtil.isEmptyString(str4) ? str4 : str2);
            if (!RootUtil.isEmptyString(str4)) {
                str2 = str4;
            }
            createContent.setTts(str2);
            i = AiMessageEvent.SCENE_SWITCH_ROUTE_FORCE;
        }
        MessageCenterBean create = MessageCenterBean.create(2, createContent);
        this.mAiMessageId = create.getMessageId();
        create.setScene(i);
        create.getContentObject().setPosition(2);
        create.setRead_state(1);
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, GsonUtil.toJson(create));
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData(10009, bundle, "com.xiaopeng.aiassistant");
        } else {
            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(10009, bundle, IpcConfig.App.MESSAGE_CENTER);
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "RECOMMEND_ROUTE Ai message sent, mAiMessageId: " + this.mAiMessageId + "scene id:" + create.getScene());
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onAiMsgEvent(IpcRouterUtil.IpcRouterEvent ipcRouterEvent) {
        L.Tag tag = TAG;
        L.i(tag, "IpcMessageEvent, onEvent=" + ipcRouterEvent.getMsgID());
        handleMessageEvent(ipcRouterEvent.getMsgID(), ipcRouterEvent.getPayloadData());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onAiMsgEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        L.Tag tag = TAG;
        L.i(tag, "IpcMessageEvent, onEvent=" + ipcMessageEvent.getMsgID());
        handleMessageEvent(ipcMessageEvent.getMsgID(), ipcMessageEvent.getPayloadData());
    }

    private void handleMessageEvent(int i, Bundle bundle) {
        String str;
        if (bundle == null) {
            return;
        }
        final RecommendRoutePop.IRecommendRouteSwitchListener recommendRouteSwitchListener = this.mNaviPresenterListener.getRecommendRouteSwitchListener();
        if (i == 10011) {
            String string = bundle.getString(IpcConfig.IPCKey.STRING_MSG);
            L.Tag tag = TAG;
            L.i(tag, "messageContent=" + string);
            AiMsgConfirmBean aiMsgConfirmBean = (AiMsgConfirmBean) GsonUtil.fromJson(string, (Class<Object>) AiMsgConfirmBean.class);
            if (aiMsgConfirmBean != null && "for_map".equals(aiMsgConfirmBean.getTag()) && 13 == aiMsgConfirmBean.getType()) {
                this.mIsIgnoreCloseAiMsg = true;
                boolean isStatus = aiMsgConfirmBean.isStatus();
                L.Tag tag2 = TAG;
                L.i(tag2, "RECOMMEND_ROUTE isSwitchRoute from AI: " + isStatus);
                if (isStatus) {
                    final RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getRecommendNaviId());
                    final IPathResult recommendNaviPathResult = TBTManager.getInstance().getRecommendNaviPathResult();
                    if (routeResult != null && recommendNaviPathResult != null) {
                        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.2
                            @Override // java.lang.Runnable
                            public void run() {
                                RecommendRoutePop.IRecommendRouteSwitchListener iRecommendRouteSwitchListener = recommendRouteSwitchListener;
                                if (iRecommendRouteSwitchListener != null) {
                                    iRecommendRouteSwitchListener.onSwitch(recommendNaviPathResult.getPath(0), routeResult.mRouteType);
                                }
                            }
                        });
                    }
                } else {
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RecommendRoutePop.IRecommendRouteSwitchListener iRecommendRouteSwitchListener = recommendRouteSwitchListener;
                            if (iRecommendRouteSwitchListener != null) {
                                iRecommendRouteSwitchListener.onIgnore();
                            }
                        }
                    });
                }
            }
        }
        if (i == 11014 && (str = this.mAiMessageId) != null && str.equals(bundle.getString(IpcConfig.IPCKey.STRING_MSG))) {
            L.Tag tag3 = TAG;
            L.i(tag3, "RECOMMEND_ROUTE timeout then close from AI, mIsIgnoreCloseAiMsg: " + this.mIsIgnoreCloseAiMsg);
            closeAiAssistant();
            if (this.mIsIgnoreCloseAiMsg) {
                return;
            }
            this.mIsIgnoreCloseAiMsg = false;
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.4
                @Override // java.lang.Runnable
                public void run() {
                    RecommendRoutePop.IRecommendRouteSwitchListener iRecommendRouteSwitchListener = recommendRouteSwitchListener;
                    if (iRecommendRouteSwitchListener != null) {
                        iRecommendRouteSwitchListener.onIgnore();
                    }
                }
            });
        }
    }

    public void closeAiAssistant() {
        AiMsgUtils.closeAIAssistant(this.mAiMessageId);
        this.mAiMessageId = "";
    }

    public String getAiMessageId() {
        return this.mAiMessageId;
    }

    public RecommendRoutePop.IRecommendRouteSwitchListener getRecommendRouteSwitchListener() {
        return this.mNaviPresenterListener.getRecommendRouteSwitchListener();
    }

    public void updateNaviManeuerInfo(XPManeuverInfo xPManeuverInfo) {
        if (xPManeuverInfo != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(xPManeuverInfo.mSegmentIndex));
            getMapView().getBizControlManager().setRouteArrowShowSegment(arrayList);
        }
    }

    @Override // com.xiaopeng.montecarlo.navresetore.NavRestoreManager.NavRestoreListener
    public void onNavRestore(RestoreNaviEvent restoreNaviEvent) {
        if (restoreNaviEvent.getAction() != 0) {
            return;
        }
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                MapUtil.updateMapLevel(BaseNaviPresenter.this.getLogicView().getMainContext(), true);
                TBTManager.getInstance().stopNavi(true);
            }
        });
    }

    public void asyncToGetTurnIcon(XPObtainInfo xPObtainInfo) {
        NaviRequestParam naviRequestParam = new NaviRequestParam();
        naviRequestParam.setObtainInfo(xPObtainInfo);
        naviRequestParam.setNaviRequestType(0);
        this.mNaviDataProvider.fetchIcon(naviRequestParam, this);
    }

    public void asyncToGetCrossIcon(XPCrossImageInfo xPCrossImageInfo, int i) {
        NaviRequestParam naviRequestParam = new NaviRequestParam();
        naviRequestParam.setCrossImageInfo(xPCrossImageInfo);
        naviRequestParam.setNaviRequestType(1);
        naviRequestParam.setRadianType(i);
        this.mNaviDataProvider.fetchIcon(naviRequestParam, this);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull NaviReturnData naviReturnData) {
        int requestType = naviReturnData.getRequestType();
        if (requestType == 0) {
            getLogicView().showTurnIcon(naviReturnData.getTurnIcon());
        } else if (requestType != 1) {
        } else {
            getLogicView().showCrossIcon(naviReturnData.getCrossIcon(), naviReturnData.getCrossImageInfo());
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        L.e(TAG, str);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return getLogicView().isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent.SceneMapListener
    public void onMapEvent(SceneMapEvent.MapEvent mapEvent) {
        int i = mapEvent.type;
        if (i == 0 || i == 1) {
            UiHandlerUtil uiHandlerUtil = UiHandlerUtil.getInstance();
            final T logicView = getLogicView();
            logicView.getClass();
            uiHandlerUtil.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.-$$Lambda$q2kBdliOyt55JkWALR1i0TvKvrQ
                @Override // java.lang.Runnable
                public final void run() {
                    IBaseNaviLogicView.this.onMapRecenterUpdate();
                }
            });
        } else if (i == 2) {
            getLogicView().onMotionEvent();
        } else if (i != 3) {
        } else {
            getLogicView().onMoveEvent();
        }
    }

    public boolean needShowRoadName() {
        return !getMapView().needShowRecenterIsNavi(true);
    }

    @Override // com.xiaopeng.montecarlo.views.RouteChargePanelView.IRouteChargeDetailListener
    public void onChargeAdd(String str) {
        if (getLogicView().isSceneLegal() && !TextUtils.isEmpty(str)) {
            long currentRouteRequestId = TBTManager.getInstance().getCurrentRouteRequestId();
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(currentRouteRequestId);
            if (CollectionUtils.isEmpty(viaInfos)) {
                return;
            }
            for (XPViaPoint xPViaPoint : viaInfos) {
                XPPoiInfo poiPoint = xPViaPoint.getPoiPoint();
                if (poiPoint != null && str.equals(poiPoint.getPoiId())) {
                    requestReroute(RouteRequest.createAddViaRequest(poiPoint, currentRouteRequestId), 0);
                    return;
                }
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteChargePanelView.IRouteChargeDetailListener
    public void onChargeRemove(String str) {
        if (getLogicView().isSceneLegal()) {
            getLogicView().hideRouteChargePanelView(true);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long currentRouteRequestId = TBTManager.getInstance().getCurrentRouteRequestId();
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(currentRouteRequestId);
            if (CollectionUtils.isEmpty(viaInfos)) {
                return;
            }
            for (XPViaPoint xPViaPoint : viaInfos) {
                XPPoiInfo poiPoint = xPViaPoint.getPoiPoint();
                if (poiPoint != null && str.equals(poiPoint.getPoiId())) {
                    requestReroute(RouteRequest.createRemoveViaRequest(poiPoint, currentRouteRequestId), 0, false);
                    return;
                }
            }
        }
    }

    public void updateNaviRemainInfo(boolean z) {
        NaviSuperChargeManager naviSuperChargeManager = this.mNaviSuperChargeManager;
        if (naviSuperChargeManager != null) {
            naviSuperChargeManager.updateNaviInfo(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IRouteUpdateContract
    public void onRouteUpdate(Bundle bundle) {
        IRouteUpdateContract routeUpdateContractImpl = getRouteUpdateContractImpl();
        if (routeUpdateContractImpl != null) {
            routeUpdateContractImpl.onRouteUpdate(bundle);
        }
    }

    public void openSearchNormal() {
        getLogicView().openSearchNormal();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNgpPresenter
    public void updateDriveModeStatus(int i) {
        super.updateDriveModeStatus(i);
        if (isLaneViewShow() && getLogicView().isSceneResumed() && SRUtil.isNgpStatus(this.mLastDriveMode) && !SRUtil.isNgpStatus(i) && SettingWrapper.needBroadEnterLaneWhenExitNgp()) {
            L.i(TAG, "updateDriveModeStatus navi_quit_ngp_enter_lane");
            TTSProxy.getInstance().speak(ContextUtils.getString(R.string.navi_quit_ngp_enter_lane), null);
            SettingWrapper.setNeedBroadEnterLaneWhenExitNgp(false);
        }
        this.mLastDriveMode = i;
    }

    public boolean isLaneViewShow() {
        return getMapView().isLaneMode();
    }

    public void enableLaneNaviMode() {
        if (isLegal()) {
            stopSwitchToSRTimer();
            if (isLaneViewShow()) {
                return;
            }
            getLogicView().getMainContext().updateSRNaviSwitchStatus(0, false);
            if (SettingWrapper.canEnterSRWhenEnterHDArea() && canShowSR()) {
                L.i(TAG, "enableLaneNaviMode enterSR ~");
                enterSRNaviMode();
            }
        }
    }

    public void disableSRNaviMode() {
        L.i(TAG, "disableSRNaviMode");
        stopSwitchToSRTimer();
        getLogicView().getMainContext().updateSRNaviSwitchStatus(8, false);
        getLogicView().onSRNaviHide();
        getMapView().setRestoreMapState(1);
    }

    public void enterSRNaviMode() {
        L.i(TAG, "enterSRNaviMode");
        if (isLegal()) {
            stopSwitchToSRTimer();
            getLogicView().getMainContext().updateSRNaviSwitchStatus(0, true);
            getLogicView().onSRNaviShow();
            getMapView().setRestoreMapState(2);
        }
    }

    public void switchToSDForShowView() {
        if (isLaneViewShow()) {
            switchNaviMode(false);
        }
    }

    public void restoreMapState() {
        if (getMapView().needRestoreSR() && canShowSR()) {
            L.i(TAG, "restoreMapState");
            enterSRNaviMode();
        }
    }

    protected boolean canShowSR() {
        boolean z = (!SRNaviManager.getInstance().canShowSRScene() || isLaneViewShow() || isPreview()) ? false : true;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "canShowSR:" + z + " ,isLaneViewShow:" + isLaneViewShow() + ",isPreview:" + isPreview());
        }
        return z;
    }

    public boolean switchNaviMode(boolean z) {
        if (isLegal()) {
            boolean z2 = !isLaneViewShow();
            L.i(TAG, "switchNaviMode isSwitchToSR：" + z2);
            if (z2) {
                enterSRNaviMode();
            } else {
                stopSwitchToSRTimer();
                getLogicView().getMainContext().updateSRNaviSwitchStatus(0, false);
                getLogicView().onSRNaviHide();
            }
            if (z) {
                SettingWrapper.setCanAutoEnterSRWhenEnterHDArea(z2);
                if (z2) {
                    SettingWrapper.setFirstTimeUserEnterSR(false);
                }
                getMapView().setRestoreMapState(z2 ? 2 : 1);
            }
            return true;
        }
        return false;
    }

    public boolean isNeedCountdownToSRNavi(int i) {
        int driveMode = SRNaviManager.getInstance().getDriveMode();
        return (5 == driveMode || 6 == driveMode) && SRNaviManager.getInstance().canShowSRScene() && (i == 0 || 3 == i || 4 == i);
    }

    public void clearAlterLabelTableForVui(int i) {
        if (L.ENABLE) {
            L.d(TAG, "clearAlterLabelTableForVui");
        }
        if (this.mLogicView.isSceneVuiEnabled()) {
            MapVuiHelper.getInstance().clearAlterLabelTableForVui(i);
        }
        if (1 == i) {
            MapVuiHelper.getInstance().removeAlterLabelTable((BaseFullScenes) this.mLogicView);
        }
    }

    public void noticeVoiceOnNaviStop() {
        if (L.ENABLE) {
            L.d(TAG, "noticeVoiceOnNaviStop");
        }
        if (VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper.OddHelperListener
    public void updateOddInfo(List<XPOddInfo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            L.Tag tag = TAG;
            L.i(tag, " updateOddInfo size " + list.size());
            this.mLogicView.getMapView().getBizControlManager().updateOddInfo(list);
        }
    }

    public void outBLRenderFPS() {
        T t = this.mLogicView;
        float realRenderFPS = (t == null || t.getMapView().getGLMapView() == null) ? -1.0f : this.mLogicView.getMapView().getGLMapView().getRealRenderFPS();
        L.Tag tag = TAG;
        L.i(tag, "frame info autoNaviFps:" + realRenderFPS);
    }
}
