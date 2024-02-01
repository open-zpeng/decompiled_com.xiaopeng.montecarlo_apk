package com.xiaopeng.montecarlo.scenes.cruisescene;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.ClickViewIdInfo;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.AiMsgUtils;
import com.xiaopeng.montecarlo.appengine.CarGreetingInfoClient;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchResultBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper;
import com.xiaopeng.montecarlo.dynamiclevel.cruise.CruiseDynamicLevelHelper;
import com.xiaopeng.montecarlo.events.RestoreNaviEvent;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingClearRenderRoutesEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingGetAroundTrafficInfoEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingMoveSearchBarEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingRenderRoutesEvent;
import com.xiaopeng.montecarlo.navcore.event.GuideWrapperNaviEvent;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.event.VoiceFusionExitEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.xptbt.ICruiseListener;
import com.xiaopeng.montecarlo.navcore.xptbt.SrCarServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.carservice.XpSRCarService;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TimeUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CommutingForecastParam;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseChargeParam;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseDataProvider;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseLoadDistanceParam;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseRequestParam;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseReturnData;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.LicensePlateFromVinParam;
import com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.RecognitionHomeCompanyParam;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import com.xiaopeng.montecarlo.stat.MapStateChangeStatUtil;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class CruiseScenePresenter extends BasePresenter implements ICruiseContract.Presenter, BaseCallBack<CruiseRequestParam, CruiseReturnData>, IStateListener, ICruiseListener, NavRestoreManager.NavRestoreListener, NavRestoreManager.PowerOnNavStatusListener, SceneMapEvent.SceneMapListener, CarServiceManager.IXPCarStateListener {
    private static final int RESUME_ROUTE_DELAY_TIME = 5000;
    private static final L.Tag TAG = new L.Tag("CruiseScenePresenter");
    private ArrayList<String> mBizControlTypes;
    private XPCoordinate2DDouble mCarEndCoordinate;
    private long mCarGreetingrequestRouteId;
    private CruiseDataProvider mCruiseDataProvider;
    private long mCurrentRequestId;
    private DynamicLevelHelper mDynamicLevelHelper;
    private boolean mIsClearCarGreetingRoutes;
    private boolean mIsFromAiCarGreetingRoute;
    private ICruiseContract.LogicView mLogicView;
    private MapViewWrapper mMapViewWrapper;
    private int mCommutingForecastType = 0;
    private boolean mIsNeedShowResumeTrip = false;
    private int mRatioScale = 0;
    private boolean mIsSearchBarUp = true;
    private RestoreNaviEvent mRestoreNaviEvent = null;
    private boolean mIsRestoreInitState = false;
    private boolean mNeedCommutingForecast = false;
    private boolean mIsVoiceFusionExit = false;
    private AiMsgManager.MsgListener mMsgListener = new AiMsgManager.MsgListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter.1
        @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
        public String getName() {
            return "CruiseScenePresenter";
        }

        @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
        public void onReceive(@NonNull AiMsgManager.IpcMessage ipcMessage) {
            if (CruiseScenePresenter.this.checkIsLegal() && AiMsgUtils.isCarStateGetOnMsg(ipcMessage)) {
                L.Tag tag = CruiseScenePresenter.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onReceive OPPORTUNITY_GETON_SCENE: ");
                sb.append(CruiseScenePresenter.this.mRestoreNaviEvent == null ? "" : Integer.valueOf(CruiseScenePresenter.this.mRestoreNaviEvent.getAction()));
                L.d(tag, sb.toString());
                if (CruiseScenePresenter.this.mRestoreNaviEvent == null) {
                    return;
                }
                if (CruiseScenePresenter.this.mRestoreNaviEvent.getAction() == 1) {
                    if (CruiseScenePresenter.this.mRestoreNaviEvent.isNeedConfirm()) {
                        CruiseScenePresenter.this.mLogicView.showResumeTripDialog();
                    } else {
                        CruiseScenePresenter.this.mLogicView.resumeTrip(true, false);
                    }
                } else if (CruiseScenePresenter.this.mRestoreNaviEvent.getAction() == 2 && !NavRestoreManager.getInstance().isAiMsgShownFromPowerOn()) {
                    CruiseScenePresenter.this.startCommutingForecast();
                }
                CruiseScenePresenter.this.mRestoreNaviEvent = null;
            }
        }
    };
    private IXpLayerClickObserver mBizOverlayObserver = new IXpLayerClickObserver() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter.2
        @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
        public void onNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
            final double d;
            final double d2;
            PointLayerItem pointLayerItem;
            Coord3DDouble position;
            int count = baseLayer.getCount();
            int businessType = layerItem.getBusinessType();
            if (L.ENABLE) {
                L.d(CruiseScenePresenter.TAG, "onClick run index:" + count + "  clickType:" + businessType);
            }
            if (6009 != businessType) {
                return;
            }
            if (!(layerItem instanceof PointLayerItem) || (pointLayerItem = (PointLayerItem) layerItem) == null || (position = pointLayerItem.getPosition()) == null) {
                d = 0.0d;
                d2 = 0.0d;
            } else {
                double d3 = position.lon;
                d2 = position.lat;
                d = d3;
            }
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter.2.1
                @Override // java.lang.Runnable
                public void run() {
                    MapOpStatUtil.sendStatDataWhenMapClick(CruiseScenePresenter.this.mLogicView.getMainContext(), BLParams.RouteOverlayGuide, 5, d, d2);
                }
            });
        }
    };
    private Observer mXPAccountChangeObserver = new Observer() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter.3
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            UserInfo userInfo;
            if (obj == null || !(obj instanceof UserInfo) || (userInfo = (UserInfo) obj) == null) {
                return;
            }
            UserInfo.InfoType infoType = userInfo.getInfoType();
            UserInfo.UserType userType = userInfo.getUserType();
            L.Tag tag = CruiseScenePresenter.TAG;
            L.i(tag, "mXPAccountChangeObserver update infoType = " + infoType + ", userType = " + userType);
            if (infoType == UserInfo.InfoType.CHANGED) {
                CruiseScenePresenter.this.requestHomeByBigData();
                CruiseScenePresenter.this.requestCompanyByBigData();
            }
        }
    };

    private long getMaxDistance(int i) {
        return i == 1 ? XpCacheConsts.MAX_DISTANCE_FOR_HOME_COMUTTING_FORECAST : i == 2 ? 60000L : 0L;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull CruiseReturnData cruiseReturnData) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    public CruiseScenePresenter(ICruiseContract.LogicView logicView) {
        if (logicView == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
        this.mCruiseDataProvider = new CruiseDataProvider();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.Presenter
    public void init() {
        this.mLogicView.initDialogTimer();
        registerEventBus();
        initListener();
        AccountObservable.getInstance().addObserver(this.mXPAccountChangeObserver);
        delayRegistSrCarService();
    }

    private void delayRegistSrCarService() {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter.4
            @Override // java.lang.Runnable
            public void run() {
                if (ContextUtils.getActivity() != null) {
                    L.i(CruiseScenePresenter.TAG, "delay regist sr car serice");
                    SrCarServiceManager.getInstance().init(new XpSRCarService());
                }
            }
        }, UILooperObserver.ANR_TRIGGER_TIME);
    }

    private void initListener() {
        TBTManager.getInstance().addCruiseListener(this);
        this.mLogicView.initRecomendChargeListener();
        if (this.mLogicView.getMainContext() != null) {
            this.mLogicView.getMainContext().setCheckAndMoveCarGreetingListner(this);
        }
        addOverlayObserver(true);
    }

    private void addOverlayObserver(boolean z) {
        ArrayList<String> arrayList = this.mBizControlTypes;
        if (arrayList == null) {
            this.mBizControlTypes = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "addOverlayObserver isAdd:" + z);
        }
        if (z) {
            this.mLogicView.getMapView().getBizControlManager().addClickObserver(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, this.mBizOverlayObserver);
        } else {
            this.mLogicView.getMapView().getBizControlManager().removeClickObserver(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, this.mBizOverlayObserver);
        }
    }

    private void handleIsRestoreCruiseState() {
        if (this.mIsRestoreInitState) {
            L.i(TAG, "NavRestore: restore init state");
            goToMapOnNavRestore(false);
            this.mIsRestoreInitState = false;
        }
    }

    private void handleIsNeedResumeTrip() {
        if (this.mIsNeedShowResumeTrip) {
            this.mLogicView.resumeTrip(true, true);
            this.mIsNeedShowResumeTrip = false;
            return;
        }
        if (this.mRestoreNaviEvent == null) {
            this.mRestoreNaviEvent = NavRestoreManager.getInstance().getRestoreNaviEvent();
            if (this.mRestoreNaviEvent != null) {
                L.Tag tag = TAG;
                L.i(tag, "get mRestoreNaviEvent:" + this.mRestoreNaviEvent.getAction());
            } else {
                L.i(TAG, "get mRestoreNaviEvent = null");
            }
        }
        NavRestoreManager.getInstance().clearNavRestoreEvent();
        RestoreNaviEvent restoreNaviEvent = this.mRestoreNaviEvent;
        if (restoreNaviEvent != null) {
            if (restoreNaviEvent.getAction() == 1 || this.mRestoreNaviEvent.getAction() == 2) {
                this.mLogicView.getMainContext().getAiMsgManager().requestCarState(this.mMsgListener);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.Presenter
    public void initView(boolean z) {
        this.mMapViewWrapper = this.mLogicView.getMapView();
        checkIsNeedShowResumeTrip(z);
        requestLicensePlateByVinCode();
        NavRestoreManager.getInstance().addRestoreListener(this);
        NavRestoreManager.getInstance().setNavStatusListener(this);
        this.mDynamicLevelHelper = new CruiseDynamicLevelHelper(this.mMapViewWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommutingForecast() {
        if (this.mNeedCommutingForecast) {
            CommutingForecastParam commutingForecastParam = new CommutingForecastParam();
            commutingForecastParam.setCount(60);
            commutingForecastParam.setPeriod(1000);
            commutingForecastParam.setCruiseType(0);
            this.mCruiseDataProvider.requestCommutingForecast(commutingForecastParam, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestHomeByBigData() {
        if (checkIsLegal()) {
            RecognitionHomeCompanyParam recognitionHomeCompanyParam = new RecognitionHomeCompanyParam();
            recognitionHomeCompanyParam.setCruiseType(2);
            recognitionHomeCompanyParam.setCount(480000);
            recognitionHomeCompanyParam.setPeriod(NaviUtil.DISTANCE_120KM);
            this.mCruiseDataProvider.requestRecognitionHome(recognitionHomeCompanyParam, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCompanyByBigData() {
        if (checkIsLegal()) {
            RecognitionHomeCompanyParam recognitionHomeCompanyParam = new RecognitionHomeCompanyParam();
            recognitionHomeCompanyParam.setCount(480000);
            recognitionHomeCompanyParam.setPeriod(NaviUtil.DISTANCE_120KM);
            recognitionHomeCompanyParam.setCruiseType(3);
            this.mCruiseDataProvider.requestRecognitionCompany(recognitionHomeCompanyParam, this);
        }
    }

    private void requestLicensePlateByVinCode() {
        LicensePlateFromVinParam licensePlateFromVinParam = new LicensePlateFromVinParam();
        licensePlateFromVinParam.setCount(480000);
        licensePlateFromVinParam.setPeriod(NaviUtil.DISTANCE_120KM);
        licensePlateFromVinParam.setCruiseType(4);
        this.mCruiseDataProvider.requestLicensePlate(licensePlateFromVinParam, this);
    }

    private boolean canShowCommutingForecast(FavoriteAddress favoriteAddress, int i) {
        boolean z = false;
        boolean z2 = favoriteAddress != null;
        if (z2) {
            boolean z3 = TBTManager.getInstance().getCurrentStatus() == 0;
            boolean isResumeTripState = this.mLogicView.isResumeTripState();
            boolean isInADay = this.mCruiseDataProvider.isInADay(i);
            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            if (currentLocation == null) {
                L.e(TAG, "COMMUTING_FORECAST canShowCommutingForecast getCurrentLocation is null.");
                return false;
            }
            double distance = LocationUtils.getDistance(currentLocation, new XPCoordinate2DDouble(favoriteAddress.getXPPoiInfo()));
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "COMMUTING_FORECAST distanceToDest:" + distance);
            }
            boolean z4 = distance > 1000.0d;
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "COMMUTING_FORECAST isDestLegal > min distance:" + z4);
            }
            long maxDistance = getMaxDistance(i);
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "COMMUTING_FORECAST maxDistance:" + maxDistance);
            }
            if (maxDistance > 0) {
                z4 &= distance < ((double) maxDistance);
                if (L.ENABLE) {
                    L.Tag tag4 = TAG;
                    L.d(tag4, "COMMUTING_FORECAST isDestLegal < max distance:" + maxDistance);
                }
            }
            boolean isRouting = TBTManager.getInstance().isRouting();
            if (z3 && !isInADay && z4 && !isRouting && !isResumeTripState) {
                z = true;
            }
            if (L.ENABLE) {
                L.Tag tag5 = TAG;
                L.d(tag5, "COMMUTING_FORECAST isSettingDest:" + z2 + ",isCruise:" + z3 + ",isInADay:" + isInADay + ",isDestLegal:" + z4 + ",isRouting:" + isRouting + ",type:" + i + ",isResumeTrip:" + isResumeTripState);
            }
        } else if (L.ENABLE) {
            L.Tag tag6 = TAG;
            L.d(tag6, "COMMUTING_FORECAST isSettingDest:" + z2);
        }
        return z;
    }

    private void handleStateManager() {
        XPPoiInfo lastNaviEndInfo = TBTManager.getInstance().getLastNaviEndInfo();
        if (isImmerseState() && lastNaviEndInfo == null) {
            onStateChange(1);
            StateManager.getInstance().setStateMode(0);
            return;
        }
        onStateChange(0);
        StateManager.getInstance().start(0, 10000);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        StateManager.getInstance().addListener(this);
        this.mLogicView.setAiMsgShow(true);
        handleIsRestoreCruiseState();
        handleIsNeedResumeTrip();
        handleStateManager();
        if (this.mLogicView.getMapView().isBLRouteScene()) {
            TBTManager.getInstance().startCruise(ThemeWatcherUtil.getMapModeByCurrentTheme());
        }
        if (this.mLogicView.getMapView().isPreview()) {
            this.mLogicView.getMapView().exitPreview(false, true);
        }
        int i = this.mRatioScale;
        if (i != 0) {
            this.mLogicView.remoteSetMapLevel(i);
            this.mRatioScale = 0;
        }
        this.mLogicView.onUpdateCruiseCongestionInfo(TBTManager.getInstance().getCruiseCongestionInfo());
        this.mLogicView.startRecommendCharge();
        this.mLogicView.registerMapStateObserver();
        this.mLogicView.updateViews();
        this.mLogicView.onMapRecenterUpdate();
        remoteClearRenderRoutes(true);
        XPCruiseInfo xPCruiseInfo = TBTManager.getInstance().getXPCruiseInfo();
        if (xPCruiseInfo != null) {
            this.mLogicView.updateMapCurrentRoadName(xPCruiseInfo.mRoadName);
        } else {
            this.mLogicView.updateMapCurrentRoadName("");
        }
        this.mLogicView.onUpdateCruiseFacility(TBTManager.getInstance().getXPFacilityInfos());
        XPLaneInfo cruiseLaneInfo = TBTManager.getInstance().getCruiseLaneInfo();
        if (cruiseLaneInfo != null) {
            this.mLogicView.onShowCruiseLaneInfo(cruiseLaneInfo);
        } else {
            this.mLogicView.onHideCruiseLaneInfo();
        }
        showCarEndLine();
        this.mLogicView.getMainContext().addSceneMapListener(this);
        if (this.mIsVoiceFusionExit) {
            this.mIsVoiceFusionExit = false;
            this.mLogicView.getMapView().goBackCenterAndRestoreCarPosition(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        unSubscribeCommutingForecast();
        StateManager.getInstance().removeListener(this);
        this.mLogicView.unregisterMapStateObserver();
        this.mLogicView.stopRecommendCharge();
        disableDynamicLevel();
        hideCarEndLine();
        this.mLogicView.getMainContext().removeSceneMapListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
        if (this.mLogicView.getMainContext() != null) {
            this.mLogicView.getMainContext().setCheckAndMoveCarGreetingListner(null);
        }
        unSubscribeRecognition();
        unSubscribeLicensePlateNo();
        unregisterEventBus();
        TBTManager.getInstance().removeCruiseListener(this);
        AccountObservable.getInstance().deleteObserver(this.mXPAccountChangeObserver);
        NavRestoreManager.getInstance().removeRestoreListener(this);
        NavRestoreManager.getInstance().removeNavStatusListener();
        addOverlayObserver(false);
        this.mDynamicLevelHelper.release();
        this.mIsFromAiCarGreetingRoute = false;
        this.mIsClearCarGreetingRoutes = false;
        this.mIsVoiceFusionExit = false;
    }

    private void unSubscribeRecognition() {
        this.mCruiseDataProvider.cancleRecognition();
    }

    private void unSubscribeLicensePlateNo() {
        this.mCruiseDataProvider.cancleLicensePlateNo();
    }

    private void unSubscribeCommutingForecast() {
        this.mCruiseDataProvider.cancleCommutingForecast();
    }

    public void unregisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    public void registerEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    private void checkIsNeedShowResumeTrip(boolean z) {
        this.mIsNeedShowResumeTrip = z && TBTManager.getInstance().isNeedRestoreRoute();
        if (this.mIsNeedShowResumeTrip) {
            this.mLogicView.updateAlreadyResumeTripState(false);
        } else {
            SettingWrapper.setCanAutoEnterSRWhenEnterHDArea(false);
            SettingWrapper.setFirstTimeUserEnterSR(true);
            SettingWrapper.setNeedBroadEnterLaneWhenExitNgp(true);
        }
        L.Tag tag = TAG;
        L.i(tag, "mIsNeedShowResumeTrip:" + this.mIsNeedShowResumeTrip);
    }

    private void forecastHome() {
        FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
        if (canShowCommutingForecast(home, 1)) {
            requestDistanceForForecast(home);
        }
    }

    private void forecastCompany() {
        FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
        if (canShowCommutingForecast(company, 2)) {
            requestDistanceForForecast(company);
        }
    }

    private void requestDistanceForForecast(FavoriteAddress favoriteAddress) {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            L.e(TAG, "COMMUTING_FORECAST showCommutingForecast getCurrentLocation is null.");
            return;
        }
        XPPoiInfo generateStartPoint = TBTManager.getInstance().generateStartPoint(currentLocation);
        XPPoiInfo xPPoiInfo = favoriteAddress.getXPPoiInfo();
        CruiseLoadDistanceParam cruiseLoadDistanceParam = new CruiseLoadDistanceParam();
        cruiseLoadDistanceParam.setStartPoi(generateStartPoint);
        cruiseLoadDistanceParam.setEndPoi(xPPoiInfo);
        this.mCruiseDataProvider.requestDistance(cruiseLoadDistanceParam, this);
    }

    private void requestCarGreetingRouters(XPPoiInfo xPPoiInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "requestCarGreetingRouters" + GsonUtil.toJson(xPPoiInfo));
        }
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            if (L.ENABLE) {
                L.d(TAG, "requestCarGreetingRouters isnull");
                return;
            }
            return;
        }
        XPPoiInfo generateStartPoint = TBTManager.getInstance().generateStartPoint(currentLocation);
        CruiseLoadDistanceParam cruiseLoadDistanceParam = new CruiseLoadDistanceParam();
        cruiseLoadDistanceParam.setStartPoi(generateStartPoint);
        cruiseLoadDistanceParam.setEndPoi(xPPoiInfo);
        cruiseLoadDistanceParam.setCruiseType(6);
        this.mCruiseDataProvider.requestRouters(cruiseLoadDistanceParam, this);
    }

    @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
    @MainThread
    public void onStateChange(int i) {
        if (checkIsLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onStateChange state:" + i);
            }
            MapStateChangeStatUtil.sendStatData(this.mLogicView.getMainContext(), i);
            if (i == 1) {
                this.mLogicView.onStateImmersion();
                goBackMapCenter();
                clearCarEndLine();
                enableDynamicLevel();
                return;
            }
            this.mLogicView.onStateActive();
            disableDynamicLevel();
        }
    }

    public boolean isImmerseState() {
        return StateManager.getInstance().getState() == 1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.Presenter
    public boolean checkShowNaviGuiderView() {
        if (this.mCruiseDataProvider.isBindAccount() && XPNetworkManager.INSTANCE.isNetworkConnected()) {
            if (L.ENABLE) {
                L.d(TAG, "showguider xp logined  and netconnected");
            }
            if (!SettingWrapper.getFistBindAmap()) {
                if (L.ENABLE) {
                    L.d(TAG, "showguider not first bind amap  ");
                }
                if (SettingWrapper.isShowEnterSeamlessNavi(1)) {
                    if (L.ENABLE) {
                        L.d(TAG, "showguider show navi_guider ");
                    }
                    SettingWrapper.saveSeamlessGuideNextShow(1);
                    return true;
                }
                if (TimeUtil.isSameDay(System.currentTimeMillis(), SettingWrapper.getGuideFirstShowTime(1).longValue())) {
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, "showguider show navi_guider on show while  one day true");
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSceneResumed() {
        ICruiseContract.LogicView logicView = this.mLogicView;
        return logicView != null && logicView.isSceneResumed();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.Presenter
    public boolean checkIsLegal() {
        ICruiseContract.LogicView logicView = this.mLogicView;
        return logicView != null && logicView.isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.Presenter
    public void goBackMapCenter() {
        if (checkIsLegal()) {
            this.mMapViewWrapper.restoreCarPosition();
            this.mMapViewWrapper.goBackCenter();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.Presenter
    public void cancelRestoreRoute() {
        TBTManager.getInstance().clearRouteParams();
    }

    private void handleRoutePlanSucceed(final long j, final long j2, final long j3, final boolean z) {
        if (checkIsLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "handleRoutePlanSucceed" + j2 + "______" + z);
            }
            NaviUtil.checkRestore(0, System.currentTimeMillis() - NavRestoreManager.getInstance().getLastPowerOffTime(), new NavRestoreManager.CheckRestoreCallback() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter.5
                @Override // com.xiaopeng.montecarlo.navresetore.NavRestoreManager.CheckRestoreCallback
                public void restoreNavImmediate(RouteParams routeParams) {
                    if (routeParams == null) {
                        CruiseScenePresenter.this.processCarGreeting(j, j2, j3, z);
                        if (L.ENABLE) {
                            L.d(CruiseScenePresenter.TAG, "handleRoutePlanSucceed restoreNav none and try to process");
                        }
                    }
                }

                @Override // com.xiaopeng.montecarlo.navresetore.NavRestoreManager.CheckRestoreCallback
                public void restoreNavLater() {
                    if (L.ENABLE) {
                        L.d(CruiseScenePresenter.TAG, "handleRoutePlanSucceed restoreNavLater");
                    }
                }

                @Override // com.xiaopeng.montecarlo.navresetore.NavRestoreManager.CheckRestoreCallback
                public void restoreNone() {
                    CruiseScenePresenter.this.processCarGreeting(j, j2, j3, z);
                    if (L.ENABLE) {
                        L.d(CruiseScenePresenter.TAG, "handleRoutePlanSucceed restoreNav none and try to process");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCarGreeting(long j, long j2, long j3, boolean z) {
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(j);
        if (routeResult == null || routeResult.mPathResult == null) {
            L.w(TAG, "handleRoutePlanSucceed pathResult is null");
            return;
        }
        this.mLogicView.renderCommutingForecastRoutes(routeResult.mPathResult, j, z);
        if (z) {
            return;
        }
        this.mCarGreetingrequestRouteId = j;
        this.mLogicView.showCommutingForecast(this.mCommutingForecastType, j2, j3);
        this.mCruiseDataProvider.saveCommutingforecastLastShowTime(this.mCommutingForecastType);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNaviEvent(GuideWrapperNaviEvent guideWrapperNaviEvent) {
        if (guideWrapperNaviEvent == null || this.mLogicView == null || guideWrapperNaviEvent.getType() != 13) {
            return;
        }
        L.i(TAG, "receive event navi stop");
        this.mLogicView.getMainContext().getDecoratorManager().clearFocus();
    }

    private void remoteClearRenderRoutes(boolean z) {
        ICruiseContract.LogicView logicView;
        if (!this.mIsFromAiCarGreetingRoute || (logicView = this.mLogicView) == null) {
            return;
        }
        logicView.remoteClearRenderRoutes(this.mCarGreetingrequestRouteId, z);
        this.mIsFromAiCarGreetingRoute = false;
        this.mCarGreetingrequestRouteId = -1L;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.CheckAndMoveCarGreetingListner
    public void checkAndCallBackUserSearchInThread() {
        if (this.mIsSearchBarUp) {
            return;
        }
        CarGreetingInfoClient.getInstance().onCheckCallBackUserSearchInThread();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onGetCarGreetingMoveSearchBarEventFromSticky(CarGreetingMoveSearchBarEvent carGreetingMoveSearchBarEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onGetCarGreetingMoveSearchBarEventFromSticky= " + GsonUtil.toJson(carGreetingMoveSearchBarEvent));
        if (this.mLogicView == null || Utils.isLandscape()) {
            return;
        }
        EventBus.getDefault().removeStickyEvent(carGreetingMoveSearchBarEvent);
        this.mIsSearchBarUp = !carGreetingMoveSearchBarEvent.isDownMove();
        this.mLogicView.moveSearchBar(carGreetingMoveSearchBarEvent.isDownMove());
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onCarGreetingGetAroundTrafficInfoEventFromSticky(CarGreetingGetAroundTrafficInfoEvent carGreetingGetAroundTrafficInfoEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onCarGreetingGetAroundTrafficInfoEventFromSticky= " + GsonUtil.toJson(carGreetingGetAroundTrafficInfoEvent));
        EventBus.getDefault().removeStickyEvent(carGreetingGetAroundTrafficInfoEvent);
        if (isSceneResumed()) {
            this.mLogicView.remoteSetMapLevel(carGreetingGetAroundTrafficInfoEvent.getRatioScale());
        } else {
            this.mRatioScale = carGreetingGetAroundTrafficInfoEvent.getRatioScale();
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onCarGreetingClearRenderRoutesEventFromSticky(CarGreetingClearRenderRoutesEvent carGreetingClearRenderRoutesEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onCarGreetingClearRenderRoutesEventFromSticky= " + GsonUtil.toJson(carGreetingClearRenderRoutesEvent));
        this.mIsClearCarGreetingRoutes = true;
        if (!this.mLogicView.isSceneResumed()) {
            L.i(TAG, "onCarGreetingClearRenderRoutesEventFromSticky but scene is legal!");
            return;
        }
        if (this.mLogicView.getMapView().isBLRouteScene()) {
            TBTManager.getInstance().startCruise(ThemeWatcherUtil.getMapModeByCurrentTheme());
        }
        EventBus.getDefault().removeStickyEvent(carGreetingClearRenderRoutesEvent);
        remoteClearRenderRoutes(false);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.BACKGROUND)
    public void onCarGreetingRenderRoutesEventFromSticky(CarGreetingRenderRoutesEvent carGreetingRenderRoutesEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onCarGreetingRenderRoutesEventFromSticky= " + GsonUtil.toJson(carGreetingRenderRoutesEvent));
        this.mIsClearCarGreetingRoutes = false;
        EventBus.getDefault().removeStickyEvent(carGreetingRenderRoutesEvent);
        String endInfo = carGreetingRenderRoutesEvent.getEndInfo();
        if (endInfo == null || TextUtils.isEmpty(endInfo) || this.mIsNeedShowResumeTrip) {
            return;
        }
        requestCarGreetingRouters((XPPoiInfo) GsonUtil.fromJson(endInfo, (Class<Object>) XPPoiInfo.class));
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.ICruiseListener
    public void onUpdateCruiseLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
        if (isSceneResumed()) {
            if (z) {
                this.mLogicView.onShowCruiseLaneInfo(xPLaneInfo);
            } else {
                this.mLogicView.onHideCruiseLaneInfo();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.ICruiseListener
    public void onUpdateCruiseCongestionInfo(final XPCruiseCongestionInfo xPCruiseCongestionInfo) {
        if (isSceneResumed()) {
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseScenePresenter$AWeyTspMZrFd3TdLQjnX3zVw-18
                @Override // java.lang.Runnable
                public final void run() {
                    CruiseScenePresenter.this.lambda$onUpdateCruiseCongestionInfo$0$CruiseScenePresenter(xPCruiseCongestionInfo);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUpdateCruiseCongestionInfo$0$CruiseScenePresenter(XPCruiseCongestionInfo xPCruiseCongestionInfo) {
        if (checkIsLegal()) {
            this.mLogicView.onUpdateCruiseCongestionInfo(xPCruiseCongestionInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.ICruiseListener
    public void onUpdateCruiseInfo(final XPCruiseInfo xPCruiseInfo) {
        if (isSceneResumed()) {
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseScenePresenter$ycyL_3-VbSHEv9e4ljW1bTgMskU
                @Override // java.lang.Runnable
                public final void run() {
                    CruiseScenePresenter.this.lambda$onUpdateCruiseInfo$1$CruiseScenePresenter(xPCruiseInfo);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUpdateCruiseInfo$1$CruiseScenePresenter(XPCruiseInfo xPCruiseInfo) {
        this.mLogicView.updateMapCurrentRoadName(xPCruiseInfo == null ? null : xPCruiseInfo.mRoadName);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.ICruiseListener
    public void onUpdateCruiseFacility(List<XPFacilityInfo> list) {
        if (isSceneResumed()) {
            this.mLogicView.onUpdateCruiseFacility(list);
        }
    }

    private void forecastHomeOrCompany(int i) {
        if (i == 1) {
            forecastHome();
        } else if (i != 2) {
        } else {
            forecastCompany();
        }
    }

    public void searchCharge() {
        double d;
        CruiseChargeParam cruiseChargeParam = new CruiseChargeParam();
        cruiseChargeParam.setKeyword(ContextUtils.getString(R.string.search_category_charge));
        CarLoc carLocation = this.mLogicView.getCarLocation();
        if (carLocation != null) {
            double d2 = 0.0d;
            if (carLocation.vecPathMatchInfo == null || carLocation.vecPathMatchInfo.size() <= 0 || carLocation.vecPathMatchInfo.get(0) == null) {
                d = 0.0d;
            } else {
                d2 = carLocation.vecPathMatchInfo.get(0).longitude;
                d = carLocation.vecPathMatchInfo.get(0).latitude;
            }
            cruiseChargeParam.setCarLocation(new XPCoordinate2DDouble(d2, d));
        }
        this.mCruiseDataProvider.searchCharge(cruiseChargeParam, this);
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.SEARCH_SCREEN_CHARGE, Integer.valueOf(CarServiceManager.getInstance().getCarRemainDistance()));
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull CruiseReturnData cruiseReturnData) {
        int cruisType = cruiseReturnData.getCruisType();
        if (cruisType == 0) {
            this.mCommutingForecastType = cruiseReturnData.getCommutingForecastResult().getCommutingForecastType();
            forecastHomeOrCompany(this.mCommutingForecastType);
            return;
        }
        if (cruisType != 1) {
            if (cruisType == 5) {
                handleSearchChargeResult(cruiseReturnData);
                return;
            } else if (cruisType != 6) {
                return;
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "requestCarGreetingRouters_ondatafetch" + GsonUtil.toJson(cruiseReturnData));
        }
        long requestId = cruiseReturnData.getCruiseDistanceResult().getRequestId();
        long distance = cruiseReturnData.getCruiseDistanceResult().getDistance();
        long travelTime = cruiseReturnData.getCruiseDistanceResult().getTravelTime();
        if (this.mIsClearCarGreetingRoutes) {
            TBTManager.getInstance().clearRouteData(requestId);
            this.mIsClearCarGreetingRoutes = false;
            return;
        }
        TBTManager.getInstance().clearRouteData(this.mCurrentRequestId);
        this.mCurrentRequestId = requestId;
        this.mIsFromAiCarGreetingRoute = cruiseReturnData.getCruisType() == 6;
        handleRoutePlanSucceed(requestId, distance, travelTime, this.mIsFromAiCarGreetingRoute);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        L.e(TAG, str);
        dismissLoadingDialog();
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(CruiseRequestParam cruiseRequestParam) {
        if (cruiseRequestParam.getCruiseType() != 5) {
            return;
        }
        showLoadingDialog();
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(CruiseRequestParam cruiseRequestParam) {
        if (cruiseRequestParam.getCruiseType() != 5) {
            return;
        }
        dismissLoadingDialog();
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return this.mLogicView.isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.navresetore.NavRestoreManager.PowerOnNavStatusListener
    public void onNavStatus(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "isNeedRestore: " + z);
    }

    @Override // com.xiaopeng.montecarlo.navresetore.NavRestoreManager.NavRestoreListener
    public void onNavRestore(final RestoreNaviEvent restoreNaviEvent) {
        if (this.mLogicView == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreNaviEvent:needConfirm action" + restoreNaviEvent.getAction());
        }
        int action = restoreNaviEvent.getAction();
        if (action == 1) {
            if (restoreNaviEvent.getRestoreRouteParams() == null) {
                return;
            }
            if (this.mLogicView.isSceneLegal()) {
                this.mLogicView.updateAlreadyResumeTripState(false);
                TBTManager.getInstance().setRestoreRouteParams(restoreNaviEvent.getRestoreRouteParams());
                UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseScenePresenter$5JQco3hq5S5xsl-Dylr_p4B45I0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CruiseScenePresenter.this.lambda$onNavRestore$2$CruiseScenePresenter(restoreNaviEvent);
                    }
                });
                return;
            }
            this.mRestoreNaviEvent = restoreNaviEvent;
        } else if (action == 2) {
            if (this.mLogicView.isSceneLegal()) {
                startCommutingForecast();
            } else {
                this.mRestoreNaviEvent = restoreNaviEvent;
            }
        } else if (action == 3) {
            requestCompanyByBigData();
            requestHomeByBigData();
        } else if (action != 4) {
            if (action == 5) {
                requestLicensePlateByVinCode();
            } else {
                this.mRestoreNaviEvent = null;
            }
        } else {
            L.i(TAG, "ACTION_RESTORE_CRUISE_INIT_STATE");
            this.mIsRestoreInitState = true;
            if (this.mLogicView.isSceneLegal()) {
                goToMapOnNavRestore(true);
                this.mIsRestoreInitState = false;
            } else if (this.mLogicView.getCurrentSceneMode() == StatusConst.Mode.NAVI || this.mLogicView.getCurrentSceneMode() == StatusConst.Mode.EXPLORE) {
            } else {
                this.mLogicView.goToMapOnCruise();
            }
        }
    }

    public /* synthetic */ void lambda$onNavRestore$2$CruiseScenePresenter(RestoreNaviEvent restoreNaviEvent) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreNaviEvent:needConfirm " + restoreNaviEvent.isNeedConfirm() + IntentActions.ActionsKey.KEY_ACTION + restoreNaviEvent.getAction());
        }
        if (restoreNaviEvent.isNeedConfirm()) {
            this.mLogicView.showResumeTripDialog();
        } else {
            this.mLogicView.resumeTrip(true, false);
        }
        this.mIsNeedShowResumeTrip = false;
    }

    private void goToMapOnNavRestore(final boolean z) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.-$$Lambda$CruiseScenePresenter$MN6yJU2hsmkSnn8oQjQZi0CwGDM
            @Override // java.lang.Runnable
            public final void run() {
                CruiseScenePresenter.this.lambda$goToMapOnNavRestore$3$CruiseScenePresenter(z);
            }
        });
    }

    public /* synthetic */ void lambda$goToMapOnNavRestore$3$CruiseScenePresenter(boolean z) {
        this.mLogicView.hideCruisePoiPop();
        if (z) {
            StateManager.getInstance().switchImmersionState();
        } else {
            StateManager.getInstance().switchActiveState();
        }
        goBackMapCenter();
    }

    private void handleSearchChargeResult(CruiseReturnData cruiseReturnData) {
        if (this.mLogicView.isSearchLoading()) {
            List<XPPoiInfo> list = cruiseReturnData != null ? cruiseReturnData.getList() : null;
            if (CollectionUtils.isEmpty(list)) {
                if (CarServiceManager.getInstance().getCarRemainDistance() <= 60000) {
                    this.mLogicView.getMainContext().showPrompt(R.string.no_charge_low_power);
                    return;
                } else {
                    this.mLogicView.getMainContext().showPrompt(R.string.no_charge_normal_power);
                    return;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt(SearchBridge.SEARCH_MODE, 103);
            bundle.putInt(SearchBridge.SEARCH_RADIUS, cruiseReturnData.getRadius());
            if (cruiseReturnData.getGeneralChargeRequestParam() != null) {
                bundle.putInt(SearchBridge.SEARCH_TYPE_KEY, 5);
                bundle.putParcelable(SearchResultBridge.SEARCH_RESULT_SEARCH_PARAMS, cruiseReturnData.getGeneralChargeRequestParam());
            }
            bundle.putParcelableArrayList("search_result", new ArrayList<>(list));
            this.mLogicView.startScene(new SearchResultBridge().setBundle(bundle));
        }
    }

    private void disableDynamicLevel() {
        if (L.ENABLE) {
            L.d(TAG, "disableDynamicLevel");
        }
        DynamicLevelHelper dynamicLevelHelper = this.mDynamicLevelHelper;
        if (dynamicLevelHelper != null) {
            dynamicLevelHelper.disableDynamicLevel();
        }
    }

    private void enableDynamicLevel() {
        DynamicLevelHelper dynamicLevelHelper;
        if (L.ENABLE) {
            L.d(TAG, "enableDynamicLevel");
        }
        if (SettingWrapper.isDynamicLevelEnabled() && (dynamicLevelHelper = this.mDynamicLevelHelper) != null) {
            dynamicLevelHelper.enableDynamicLevel();
        } else {
            MapUtil.updateMapLevel(this.mLogicView.getMainContext());
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIgStatusChange(int i) {
        if (1 == i) {
            MapUtil.updateMapLevel(this.mLogicView.getMainContext());
        } else if (i == 0) {
            clearCarEndLine();
        }
    }

    private void showCarEndLine() {
        XPPoiInfo lastNaviEndInfo = TBTManager.getInstance().getLastNaviEndInfo();
        this.mCarEndCoordinate = null;
        if (lastNaviEndInfo != null) {
            this.mCarEndCoordinate = new XPCoordinate2DDouble();
            this.mCarEndCoordinate.mLon = lastNaviEndInfo.getDisplayLon();
            this.mCarEndCoordinate.mLat = lastNaviEndInfo.getDisplayLat();
            CarServiceManager.getInstance().addCarStateListener(this);
            this.mMapViewWrapper.getBizControlManager().setCar2EndLine(this.mCarEndCoordinate.mLat, this.mCarEndCoordinate.mLon);
            TBTManager.getInstance().resetLastNaviEndInfo();
        }
    }

    private void updateCarEndLine() {
        if (this.mCarEndCoordinate != null) {
            boolean isPoiOutOfScreen = this.mLogicView.getMainContext().getMapView().isPoiOutOfScreen(this.mCarEndCoordinate);
            L.Tag tag = TAG;
            L.v(tag, " updateCarEndLine--isOutScreen:" + isPoiOutOfScreen);
            if (isPoiOutOfScreen) {
                this.mMapViewWrapper.getBizControlManager().setCarLineAndNaviEndVisible(true);
            } else {
                this.mMapViewWrapper.getBizControlManager().setCarLineVisible(false);
            }
        }
    }

    private void hideCarEndLine() {
        CarServiceManager.getInstance().removeCarStateListener(this);
        this.mMapViewWrapper.getBizControlManager().setCarLineAndNaviEndVisible(false);
    }

    private void clearCarEndLine() {
        hideCarEndLine();
        TBTManager.getInstance().resetLastNaviEndInfo();
        this.mCarEndCoordinate = null;
    }

    private void showLoadingDialog() {
        this.mLogicView.showLoadingDialog();
    }

    private void dismissLoadingDialog() {
        this.mLogicView.dismissLoadingDialog();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent.SceneMapListener
    public void onMapEvent(SceneMapEvent.MapEvent mapEvent) {
        int i = mapEvent.type;
        if (i == 0) {
            this.mLogicView.onMapRecenterUpdate();
            updateCarEndLine();
        } else if (i != 1) {
        } else {
            updateCarEndLine();
        }
    }

    public boolean needShowRoadName() {
        return !this.mLogicView.getMapView().needShowRecenterIsNavi(true);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        int i = speechNaviEvent.what;
        if (i == 106) {
            L.i(TAG, "SPEECH_OPEN_LINK_SEAMLESS_NAVI");
            this.mLogicView.startNaviGuiderScene();
            return true;
        }
        if (i == 312) {
            L.Tag tag = TAG;
            L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneVisible:" + this.mLogicView.isSceneLegal());
            this.mLogicView.updateAlreadyResumeTripState(true);
            if (this.mLogicView.isSceneLegal()) {
                this.mLogicView.getSpeechEventBizHelper().routeNewDestWithVias(this.mLogicView.getMainContext().getCurrentScene(), speechNaviEvent);
                return true;
            }
            L.Tag tag2 = TAG;
            L.w(tag2, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS isSceneLegal:" + this.mLogicView.sceneLegalStatus());
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
        } else if (i == 503) {
            L.i(TAG, "SPEECH_SWITCH_SMART_SCALE");
            this.mLogicView.getSpeechEventBizHelper().onSmartScaleSwitch(speechNaviEvent, this);
        }
        return false;
    }

    public void onSmartScaleSwitch(SpeechNaviEvent speechNaviEvent) {
        if (speechNaviEvent.getSwitchState()) {
            enableDynamicLevel();
        } else {
            disableDynamicLevel();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onVoiceFusionExit(VoiceFusionExitEvent voiceFusionExitEvent) {
        L.i(TAG, "onVoiceFusionExit");
        this.mIsVoiceFusionExit = true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.ICruiseContract.Presenter
    public void requestResumeTrip(final Bundle bundle) {
        if (XPNetworkManager.INSTANCE.isNetworkConnected() || !SystemConst.ROUTE_TYPE_RESTORE_ROUTE.equals(bundle.getString(SystemConst.ROUTE_TYPE_KEY)) || bundle.getBoolean(SystemConst.IS_RESTART_RESTORE_NAVI)) {
            this.mLogicView.startRouteSceneForResumeTrip(bundle);
            return;
        }
        L.i(TAG, "network broken retry later");
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter.6
            @Override // java.lang.Runnable
            public void run() {
                if (CruiseScenePresenter.this.mLogicView.isTopSceneCruise()) {
                    L.i(CruiseScenePresenter.TAG, "startRouteSceneForResumeTrip");
                    CruiseScenePresenter.this.mLogicView.startRouteSceneForResumeTrip(bundle);
                    return;
                }
                L.i(CruiseScenePresenter.TAG, "skip resume trip");
            }
        }, UILooperObserver.ANR_TRIGGER_TIME);
    }
}
