package com.xiaopeng.montecarlo.scenes.routescene;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.common.path.model.AvoidTrafficJamInfo;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import com.autonavi.gbl.layer.GuideLabelLayerItem;
import com.autonavi.gbl.layer.GuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.RouteBlockLayerItem;
import com.autonavi.gbl.layer.RouteJamPointLayerItem;
import com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.layer.model.BizCustomTypePlane;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.layer.model.RouteTrafficEventTipsPoint;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.observer.impl.ClickViewIdInfo;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.type.AiMsgBroadcastEvent;
import com.xiaopeng.montecarlo.base.IRouteUpdateContract;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.route.RouteDetailInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelperContainer;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.util.comparator.SortRouteInfoByPathLength;
import com.xiaopeng.montecarlo.navcore.util.comparator.SortRouteInfoByTrafficLightCount;
import com.xiaopeng.montecarlo.navcore.xptbt.CloudRouteDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TTSManager;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.AiMsgSelectBean;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.Configuration;
import com.xiaopeng.montecarlo.scenes.mapscene.MapVuiHelper;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.IRouteContract;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.routescene.dataprovider.RouteDataProvider;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.ExploreStatUtil;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import com.xiaopeng.montecarlo.stat.MapStateChangeStatUtil;
import com.xiaopeng.montecarlo.stat.StatUtil;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.ChargeRouteView;
import com.xiaopeng.montecarlo.views.RouteChargePanelView;
import com.xiaopeng.montecarlo.views.RouteDetailPanel;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class RouteScenePresenter extends BasePresenter implements IRouteContract.Presenter, BaseMapDecorator.IMapDecoratorRouteUpdateListener, IStateListener, RouteManager.IRouteResultListener, RestrictHelper.IRestrictEventCallback, CarServiceManager.IXPCarStateListener, IRouteChargeContract.IRouteChargePresenter, RouteChargeDecorator.IRouteChargeDecoratorListener, RouteChargePanelView.IRouteChargeDetailListener, IRouteUpdateContract, OddDataHelper.OddHelperListener {
    private static final int AI_MESSAGE_TYPE_EXPLORER = 2;
    private static final int AI_MESSAGE_TYPE_NAVI = 1;
    public static final int ROUTE_PANEL_ANIM_NULL = 0;
    public static final int ROUTE_PANEL_ANIM_SLIDEDOWN = 1;
    private static final L.Tag TAG = new L.Tag("RouteScenePresenter");
    private String mAvoidJamAreaStr;
    private AvoidTrafficJamInfo mAvoidTrafficJamInfo;
    private ArrayList<String> mBizControlTypes;
    private int mCurrentPathIndex;
    private long mCurrentRequestId;
    private XPCoordinate2DDouble mEndPoint;
    private IRouteChargeContract.IRouteChargeHelper mIRouteChargeHelper;
    private String mIncidentStr;
    private boolean mIsManual;
    private boolean mIsOfflineReroute;
    private String mLastRouteContent;
    private IRouteContract.LogicView mLogicView;
    private long mOldRequestId;
    private RoutePowerDisHelperContainer mPowerDisHelperContainer;
    private RouteChargeDecorator mRouteChargeDecorator;
    private TrafficIncident mRouteIncident;
    private RouteDataProvider mRouteProvider;
    private String mRouteType = "";
    private MainContext mMainContext = null;
    private boolean mIsStartNaviImmediately = false;
    private int mStartType = 0;
    private int mRouteSelectRef = 0;
    private int mCurrentRoute = -1;
    private boolean mIsStartByAiMsg = false;
    private boolean mNeedRequestRoute = true;
    private int mNumRouteOffline = 0;
    private String mAiMessageId = null;
    private boolean mAlreadySynced = false;
    private Hashtable<String, Boolean> mRefreshTable = new Hashtable<>();
    private Hashtable<String, RouteDetailInfo> mRouteInfoTable = new Hashtable<>();
    private boolean mIsRestoreNaviAutomatically = false;
    private boolean mIsRestartRestore = true;
    private boolean mIsRouteChargeGuide = false;
    private int mRouteChargeMsg = -1;
    private boolean mIsIgnoreOldTTS = false;
    private boolean mRouteChargeIsExplore = false;
    private long mRouteChargeRequestId = -1;
    private boolean mIsSwitchedRouteChargePlan = false;
    private boolean mHasReqRestrict = false;
    private boolean mIsCountDownToNavShow = false;
    private boolean mIsAlreadyStopCountdownByUserTouch = false;
    private boolean mIsAlreadyStartNavi = false;
    private Object mAiMsgEventListener = new Object() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.1
        @Subscribe(threadMode = ThreadMode.MAIN)
        public void onReceive(AiMsgBroadcastEvent aiMsgBroadcastEvent) {
            if (1000 == aiMsgBroadcastEvent.getId()) {
                if (StateManager.getInstance().getState() == 1) {
                    StateManager.getInstance().switchActiveState();
                }
                if (L.ENABLE) {
                    L.Tag tag = RouteScenePresenter.TAG;
                    L.d(tag, "mAiMsgEventListener onReceive event" + aiMsgBroadcastEvent.toString());
                }
                if (RouteScenePresenter.this.checkIsLegal()) {
                    RouteScenePresenter.this.mLogicView.cancelCountdownGuide(false);
                    StateManager.getInstance().start(1, BizCustomTypePlane.BizCustomTypePlaneInvalid, true);
                }
            }
        }
    };
    private IXpLayerClickObserver mBizOverlayObserver = new IXpLayerClickObserver() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.2
        @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
        public void onNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
            long j;
            try {
                j = Long.parseLong(layerItem.getID());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                j = 0;
            }
            int businessType = layerItem.getBusinessType();
            L.Tag tag = RouteScenePresenter.TAG;
            L.i(tag, ">>> onNotifyClick id=" + j + " clickType =" + businessType);
            RouteScenePresenter.this.handleNotifyClick(j, businessType, layerItem);
        }
    };

    private boolean isSpecialSelfCommand(int i) {
        if (i == 100 || i == 109 || i == 307 || i == 903 || i == 2008 || i == 312 || i == 313 || i == 2002 || i == 2003) {
            return true;
        }
        switch (i) {
            case 303:
            case 304:
            case 305:
                return true;
            default:
                return false;
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
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

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteOddError(long j) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictEventCallback
    public void onResponseError(long j, int i) {
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

    static /* synthetic */ int access$808(RouteScenePresenter routeScenePresenter) {
        int i = routeScenePresenter.mNumRouteOffline;
        routeScenePresenter.mNumRouteOffline = i + 1;
        return i;
    }

    public RouteScenePresenter(IRouteContract.LogicView logicView) {
        if (logicView == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
        this.mCurrentRequestId = -1L;
        this.mOldRequestId = -1L;
        updateSelectRoute(0);
        this.mRouteProvider = new RouteDataProvider();
        this.mPowerDisHelperContainer = new RoutePowerDisHelperContainer();
        this.mIRouteChargeHelper = new RouteChargeHelper(this);
    }

    private static float getCarSpeed() {
        return TBTManager.getInstance().getCarSpeed();
    }

    public IXpLayerClickObserver getBizOverlayObserver() {
        return this.mBizOverlayObserver;
    }

    public int getStartType() {
        return this.mStartType;
    }

    public boolean isStartNaviImmediately() {
        return this.mIsStartNaviImmediately;
    }

    public int getCurrentPathIndex() {
        return this.mCurrentPathIndex;
    }

    public List<RouteDetailInfo> getRouteInfo() {
        if (CollectionUtils.isEmpty(this.mRouteInfoTable)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, RouteDetailInfo> entry : this.mRouteInfoTable.entrySet()) {
            arrayList.add(entry.getValue());
        }
        Collections.sort(arrayList, new Comparator<RouteDetailInfo>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.3
            @Override // java.util.Comparator
            public int compare(RouteDetailInfo routeDetailInfo, RouteDetailInfo routeDetailInfo2) {
                return routeDetailInfo.getRouteTypeNo().compareTo(routeDetailInfo2.getRouteTypeNo());
            }
        });
        return arrayList;
    }

    public void setRouteInfo(List<RouteDetailInfo> list) {
        this.mRouteInfoTable.clear();
        if (CollectionUtils.isNotEmpty(list)) {
            for (RouteDetailInfo routeDetailInfo : list) {
                this.mRouteInfoTable.put(routeDetailInfo.getRouteTypeNo(), routeDetailInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotifyClick(long j, int i, LayerItem layerItem) {
        double d;
        GuideTrafficEventLayerItem guideTrafficEventLayerItem;
        GuideLabelLayerItem guideLabelLayerItem;
        PointLayerItem pointLayerItem;
        Coord3DDouble position;
        double d2 = 0.0d;
        if (!(layerItem instanceof PointLayerItem) || (pointLayerItem = (PointLayerItem) layerItem) == null || (position = pointLayerItem.getPosition()) == null) {
            d = 0.0d;
        } else {
            d2 = position.lon;
            d = position.lat;
        }
        if (i == 5008) {
            this.mLogicView.onRouteElemClick();
            if (!(layerItem instanceof GuideTrafficEventLayerItem) || (guideTrafficEventLayerItem = (GuideTrafficEventLayerItem) layerItem) == null) {
                return;
            }
            handleBizRouteFacilityTypeTrafficEventTipClick(d2, d, guideTrafficEventLayerItem.getMId());
        } else if (i == 6009) {
            this.mLogicView.onRouteElemClick();
            handleRouteTypePathClick(j, d2, d);
        } else if (i == 6012) {
            this.mLogicView.onRouteElemClick();
            RouteJamPointLayerItem routeJamPointLayerItem = (RouteJamPointLayerItem) layerItem;
            if (routeJamPointLayerItem != null) {
                handleBizRouteTypeJamPointClick(routeJamPointLayerItem.getMAvoidJamCloud(), d2, d);
            }
        } else if (i != 6029) {
            switch (i) {
                case BizRouteType.BizRouteTypeTrafficBlock /* 6020 */:
                case BizRouteType.BizRouteTypeTrafficBlockOuter /* 6021 */:
                    this.mLogicView.onRouteElemClick();
                    RouteBlockLayerItem routeBlockLayerItem = (RouteBlockLayerItem) layerItem;
                    if (routeBlockLayerItem != null) {
                        handleBizRouteTypeTrafficBlockClick(routeBlockLayerItem.getPosition(), j);
                        return;
                    }
                    return;
                case BizRouteType.BizRouteTypeTrafficEventTip /* 6022 */:
                    this.mLogicView.onRouteElemClick();
                    RouteTrafficEventTipsLayerItem routeTrafficEventTipsLayerItem = (RouteTrafficEventTipsLayerItem) layerItem;
                    if (routeTrafficEventTipsLayerItem != null) {
                        handleBizRouteTypeTrafficEventTipClick(routeTrafficEventTipsLayerItem.getMTrafficEventTipsInfo());
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.mLogicView.onRouteElemClick();
            if (!(layerItem instanceof GuideLabelLayerItem) || (guideLabelLayerItem = (GuideLabelLayerItem) layerItem) == null) {
                return;
            }
            long mPathId = guideLabelLayerItem.getMPathId();
            if (L.ENABLE) {
                L.d(TAG, "CANDIDATE_PATH onClick pathID: " + mPathId);
            }
            Coord3DDouble position2 = guideLabelLayerItem.getPosition();
            if (position2 != null) {
                d2 = position2.lon;
                d = position2.lat;
            }
            handleBizRouteTypeGuideLabelClick(mPathId, d2, d);
        }
    }

    private void handleBizRouteTypeGuideLabelClick(final long j, final double d, final double d2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.4
            @Override // java.lang.Runnable
            public void run() {
                IPathResult routePathResult = TBTManager.getInstance().getRoutePathResult(TBTManager.getInstance().getCurrentRouteRequestId());
                if (routePathResult != null) {
                    int pathIndex = routePathResult.getPathIndex(j);
                    if (RouteScenePresenter.this.isRouteFromSpeech()) {
                        VoiceFusionUtil.getInstance().sendGUIEventWhenItemFocused(pathIndex + 1, Utils.getPackageName(ContextUtils.getContext()));
                    }
                    RouteScenePresenter.this.setSelectRoute(pathIndex);
                    MapOpStatUtil.sendStatDataWhenMapClick(RouteScenePresenter.this.mLogicView.getMainContext(), BLParams.RouteOverlayGuide, 5, d, d2);
                }
            }
        });
    }

    private void handleBizRouteFacilityTypeTrafficEventTipClick(final double d, final double d2, final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.5
            @Override // java.lang.Runnable
            public void run() {
                RouteScenePresenter.this.onTrafficEventClick(d, d2, i);
            }
        });
    }

    private void handleBizRouteTypeJamPointClick(final AvoidJamCloudControl avoidJamCloudControl, final double d, final double d2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.6
            @Override // java.lang.Runnable
            public void run() {
                AvoidJamCloudControl avoidJamCloudControl2 = avoidJamCloudControl;
                if (avoidJamCloudControl2 != null) {
                    double d3 = d;
                    double d4 = d2;
                    String str = avoidJamCloudControl2.strJamDist;
                    String str2 = avoidJamCloudControl.strJamTime;
                    String str3 = avoidJamCloudControl.strJamTime;
                    if (avoidJamCloudControl.pointDetail != null && avoidJamCloudControl.pointDetail.pointControl != null && avoidJamCloudControl.pointDetail.pointControl.pos2D != null) {
                        d3 = avoidJamCloudControl.pointDetail.pointControl.pos2D.lon;
                        d4 = avoidJamCloudControl.pointDetail.pointControl.pos2D.lat;
                    }
                    TrafficEventPopParam.Builder builder = new TrafficEventPopParam.Builder(1);
                    builder.setJamLen(str).setJamETA(str2).setJamRoadName(str3).setIsZoom(false).setLon(d3).setLat(d4);
                    RouteScenePresenter.this.mLogicView.showRouteTrafficEventPop(builder.build());
                }
            }
        });
    }

    private void handleBizRouteTypeTrafficBlockClick(final Coord3DDouble coord3DDouble, final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.7
            @Override // java.lang.Runnable
            public void run() {
                Coord3DDouble coord3DDouble2 = coord3DDouble;
                if (coord3DDouble2 != null) {
                    RouteScenePresenter.this.onTrafficEventClick(coord3DDouble2.lon, coord3DDouble.lat, j);
                }
            }
        });
    }

    private void handleBizRouteTypeTrafficEventTipClick(final RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.8
            @Override // java.lang.Runnable
            public void run() {
                RouteTrafficEventTipsPoint routeTrafficEventTipsPoint2 = routeTrafficEventTipsPoint;
                if (routeTrafficEventTipsPoint2 == null || routeTrafficEventTipsPoint2.mP20Point == null || routeTrafficEventTipsPoint.mTrafficIncident == null) {
                    return;
                }
                RouteScenePresenter.this.onTrafficEventClick(routeTrafficEventTipsPoint.mP20Point.lon, routeTrafficEventTipsPoint.mP20Point.lat, routeTrafficEventTipsPoint.mTrafficIncident.ID);
            }
        });
    }

    private void handleBizRouteTypeViaPointClick(final long j, final double d, final double d2) {
        L.e(TAG, "handleBizRouteTypeViaPointClick should't be called.");
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.9
            @Override // java.lang.Runnable
            public void run() {
                List<XPViaPoint> viaInfos;
                if (RouteScenePresenter.this.mMainContext == null || RouteScenePresenter.this.mMainContext.isMapPoiLocked() || (viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId())) == null || viaInfos.size() <= j) {
                    return;
                }
                RouteScenePresenter.this.mLogicView.showPoiPop(DecoratorType.WAY_POINT, viaInfos.get((int) j).getPoiPoint());
                MapOpStatUtil.sendStatDataWhenMapClick(RouteScenePresenter.this.mLogicView.getMainContext(), BLParams.RouteOverlayGuide, 4, d, d2);
            }
        });
    }

    private void handleBizRouteTypeEndPointClick(final double d, final double d2) {
        L.e(TAG, "handleBizRouteTypeEndPointClick should't be called.");
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.10
            @Override // java.lang.Runnable
            public void run() {
                MapOpStatUtil.sendStatDataWhenMapClick(RouteScenePresenter.this.mLogicView.getMainContext(), BLParams.RouteOverlayGuide, 4, d, d2);
            }
        });
    }

    private void handleBizRouteTypeStartPointClick(final double d, final double d2) {
        L.e(TAG, "handleBizRouteTypeStartPointClick should't be called.");
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.11
            @Override // java.lang.Runnable
            public void run() {
                RouteScenePresenter.this.mLogicView.showPoiPop(DecoratorType.START_POINT, TBTManager.getInstance().getStartInfo(TBTManager.getInstance().getCurrentRouteRequestId()));
                MapOpStatUtil.sendStatDataWhenMapClick(RouteScenePresenter.this.mLogicView.getMainContext(), BLParams.RouteOverlayGuide, 4, d, d2);
            }
        });
    }

    private void handleRouteTypePathClick(final long j, final double d, final double d2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.12
            @Override // java.lang.Runnable
            public void run() {
                IPathResult routePathResult = TBTManager.getInstance().getRoutePathResult(TBTManager.getInstance().getCurrentRouteRequestId());
                if (routePathResult != null) {
                    int pathIndex = routePathResult.getPathIndex(j);
                    if (RouteScenePresenter.this.isRouteFromSpeech()) {
                        VoiceFusionUtil.getInstance().sendGUIEventWhenItemFocused(pathIndex + 1, Utils.getPackageName(ContextUtils.getContext()));
                    }
                    RouteScenePresenter.this.setSelectRoute(pathIndex);
                    MapOpStatUtil.sendStatDataWhenMapClick(RouteScenePresenter.this.mLogicView.getMainContext(), BLParams.RouteOverlayGuide, 5, d, d2);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictEventCallback
    public boolean onShowRestrictGuide(short s) {
        L.Tag tag = TAG;
        L.i(tag, "ROUTEEVENT onShowRestrictGuide: " + ((int) s));
        if (s <= 0) {
            TrafficIncident trafficIncident = this.mRouteIncident;
            if (trafficIncident != null && trafficIncident.titleType > 3 && !TextUtils.isEmpty(this.mIncidentStr)) {
                this.mLogicView.showTip(this.mRouteIncident.titleType, this.mIncidentStr);
                return false;
            } else if (this.mAvoidTrafficJamInfo == null || TextUtils.isEmpty(this.mAvoidJamAreaStr)) {
                return true;
            } else {
                this.mLogicView.showTip(6, this.mAvoidJamAreaStr);
                return false;
            }
        }
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public XPCoordinate2DDouble getEndPoint() {
        if (this.mEndPoint == null) {
            this.mEndPoint = TBTManager.getInstance().getRouteLastPoint(this.mOldRequestId, this.mCurrentPathIndex);
        }
        return this.mEndPoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTrafficEventClick(double d, double d2, long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onTrafficEventClick: [" + d2 + ", " + d + "], eventId: " + j);
        }
        this.mLogicView.showRouteTrafficEventPop(new TrafficEventPopParam.Builder(2).setEventId(Long.toString(j)).setLon(d).setLat(d2).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIsLegal() {
        IRouteContract.LogicView logicView = this.mLogicView;
        return logicView != null && logicView.isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onInit(MainContext mainContext, RouteSaveState routeSaveState) {
        RouteDataModel routeData;
        this.mMainContext = mainContext;
        TBTManager.getInstance().addRouteListener(this);
        TBTManager.getInstance().startRoute(ThemeWatcherUtil.getMapModeByCurrentTheme());
        this.mNeedRequestRoute = true;
        registerAiMsgEventListener();
        addOverlayObserver(true);
        OddDataHelper.getInstance().addUpdateOddInfoListener(this);
        if (routeSaveState.mRequestId != -1 && (routeData = TBTManager.getInstance().getRouteData(routeSaveState.mRequestId)) != null && routeData.mRouteResult != null) {
            this.mCurrentRequestId = routeSaveState.mRequestId;
            this.mOldRequestId = this.mCurrentRequestId;
            this.mCurrentPathIndex = routeSaveState.mSelectPathId;
            if (routeSaveState.mIsOfflineRoute) {
                this.mLogicView.showOfflineTips(false);
                this.mNumRouteOffline++;
            }
            this.mNeedRequestRoute = false;
            this.mIRouteChargeHelper.onRouteUpdate(routeData.mRouteResult.mPathResult, this.mCurrentPathIndex, routeData.mRouteParams);
        }
        this.mLogicView.onInitView();
        this.mIsSwitchedRouteChargePlan = routeSaveState.mIsStopCountDown;
        StateManager.getInstance().removeListener(this);
        this.mLogicView.cancelCountdownGuide(false);
        if (routeSaveState.mIsRouteChargeEnable) {
            this.mIRouteChargeHelper.enableChargeFunction(true);
            this.mLogicView.updateRouteChargePlanSwitchStatus(true, false);
        }
        this.mLogicView.getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void showRoutes(IPathResult iPathResult, int i, int i2) {
        this.mIsAlreadyStopCountdownByUserTouch = false;
        boolean z = (i2 & 1) == 1;
        if (z) {
            this.mLogicView.routePanelInvisible();
        }
        this.mLogicView.updateDebugContainerDisplayState(isRouteFromSpeech());
        this.mLogicView.renderRoutes(iPathResult, i);
        clearPowerDisHelperContainer();
        this.mLogicView.createRouteContent(iPathResult, i);
        if (z) {
            this.mLogicView.showRoutePanelWithAnimate();
        }
        updateRemainDis();
    }

    public double getOnlineK(int i) {
        return this.mPowerDisHelperContainer.getOnlineK(i);
    }

    private void updateRemainDis() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.-$$Lambda$RouteScenePresenter$GOtrqvBEZEU1WrwSKCQYawhI69k
            @Override // java.lang.Runnable
            public final void run() {
                RouteScenePresenter.this.lambda$updateRemainDis$0$RouteScenePresenter();
            }
        });
    }

    public /* synthetic */ void lambda$updateRemainDis$0$RouteScenePresenter() {
        this.mPowerDisHelperContainer.updateRemainDis();
    }

    private void updateRouteChargeCarRemain() {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.updateRouteChargeCarRemain();
        }
    }

    public void createDisHelper(@NonNull IVariantPath iVariantPath, @NonNull IPathResult iPathResult, @NonNull OnUpdateRemainDisListener onUpdateRemainDisListener) {
        this.mPowerDisHelperContainer.createDisHelper(null, iVariantPath, iPathResult, onUpdateRemainDisListener, this.mIRouteChargeHelper);
    }

    private void clearPowerDisHelperContainer() {
        this.mPowerDisHelperContainer.clear();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onUninit() {
        updateAlreadySynced(false);
        clearPowerDisHelperContainer();
        TBTManager.getInstance().removeRouteListener(this);
        ExploreStatUtil.sendStatDataWhenSystemExitRouting(PageType.NAVI_ROUTING, this.mMainContext, getEndPoint());
        StateManager.getInstance().removeListener(this);
        unregisterAiMsgEventListener();
        this.mIRouteChargeHelper.onUnInit();
        RouteChargeDecorator routeChargeDecorator = this.mRouteChargeDecorator;
        if (routeChargeDecorator != null) {
            routeChargeDecorator.unInit();
        }
        this.mRouteChargeDecorator = null;
        this.mStartType = 0;
        this.mRouteSelectRef = 0;
        this.mIsStartNaviImmediately = false;
        this.mRouteType = "";
        OddDataHelper.getInstance().removeUpdateOddInfoListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAlreadySynced(boolean z) {
        if (isRouteFromSpeech()) {
            this.mAlreadySynced = z;
            if (this.mAlreadySynced) {
                return;
            }
            this.mRefreshTable.clear();
        }
    }

    public boolean isRouteFromSpeech() {
        boolean equals = SystemConst.ROUTE_TYPE_FROM_SPEECH.equals(this.mRouteType);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isRouteFromSpeech flag:" + equals + ",mRouteType:" + this.mRouteType);
        }
        return equals;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void updateDataWhenRequest(String str, boolean z, int i, boolean z2, boolean z3, int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateDataWhenRequest routetype:" + str);
        }
        if (!isRouteFromSpeech()) {
            this.mRouteType = str;
        }
        this.mIsManual = z;
        this.mStartType = i;
        this.mRouteSelectRef = i2;
        this.mIsRestoreNaviAutomatically = z2;
        this.mIsRestartRestore = z3;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void startGuidance() {
        startGuidance(this.mCurrentPathIndex);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void startGuidance(final int i) {
        if (!checkIsLegal()) {
            L.Tag tag = TAG;
            L.w(tag, "startGuidance failure index:" + i);
            return;
        }
        this.mIsAlreadyStartNavi = true;
        if (i != this.mCurrentRoute) {
            this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.13
                @Override // java.lang.Runnable
                public void run() {
                    RouteScenePresenter.this.setSelectRoute(i);
                    RouteScenePresenter.this.mLogicView.startGuidance(true, RouteScenePresenter.this.mOldRequestId, RouteScenePresenter.this.mCurrentPathIndex, RouteScenePresenter.this.mNumRouteOffline);
                }
            });
        } else {
            this.mLogicView.startGuidance(true, this.mOldRequestId, this.mCurrentPathIndex, this.mNumRouteOffline);
        }
    }

    private void notifyWithAiMessage(int i, int i2) {
        if (isRouteFromSpeech() && Configuration.Dependency.AIASSISTANT_ENABLE) {
            MessageContentBean createContent = MessageContentBean.createContent();
            createContent.setType(10);
            if (1 == i2) {
                createContent.addTitle(String.format(Locale.CHINA, ContextUtils.getString(R.string.speech_navi_will_start_soon), Integer.valueOf(i + 1)));
            } else if (2 != i2) {
                L.w(TAG, "notifyWithAiMessage, type error");
                return;
            } else {
                createContent.addTitle(String.format(Locale.CHINA, ContextUtils.getString(R.string.speech_explorer_will_start_soon), Integer.valueOf(i + 1)));
            }
            MessageCenterBean create = MessageCenterBean.create(2, createContent);
            create.setScene(AiMessageEvent.SCENE_SELECT_ROUTE);
            create.getContentObject().setPosition(2);
            create.setRead_state(1);
            Bundle bundle = new Bundle();
            bundle.putString(IpcConfig.IPCKey.STRING_MSG, GsonUtil.toJson(create));
            if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
                IpcRouterUtil.sendData(10009, bundle, "com.xiaopeng.aiassistant");
            } else {
                ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(10009, bundle, IpcConfig.App.MESSAGE_CENTER);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void startExplore() {
        sendStatDataForBtnExplore();
        this.mIsAlreadyStartNavi = true;
        this.mLogicView.startExplore(this.mNumRouteOffline, this.mOldRequestId, this.mCurrentPathIndex, true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onResume(boolean z, @Nullable RouteRequest routeRequest) {
        super.onResume();
        CarServiceManager.getInstance().addCarStateListener(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.mNeedRequestRoute) {
            this.mIsStartByAiMsg = z;
            if (this.mIsStartByAiMsg) {
                long routeFinishEvent = this.mMainContext.getAiMsgManager().getRouteFinishEvent();
                if (-1 != routeFinishEvent) {
                    this.mOldRequestId = routeFinishEvent;
                    this.mCurrentRequestId = routeFinishEvent;
                    updateSelectRoute(0);
                    if (canStartExploreCountDown()) {
                        startExploreCountDown();
                    }
                } else {
                    this.mLogicView.goBack();
                    return;
                }
            } else if (-1 == requestRoute(routeRequest)) {
                this.mLogicView.goBack();
                return;
            }
            this.mNeedRequestRoute = false;
        }
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
        if (routeData != null && routeData.mRouteResult != null && routeData.mRouteResult.mPathResult != null) {
            showRoutes(routeData.mRouteResult.mPathResult, this.mCurrentPathIndex, this.mIsStartByAiMsg ? 1 : 0);
            if (canStartExploreCountDown()) {
                if (!isCountDownToNavShow()) {
                    startExploreCountDown();
                } else if (canStartCountdownGuide()) {
                    setCountDownToNavShow(false);
                    this.mLogicView.startCountdownGuide(true);
                }
            }
        }
        if (TBTManager.getInstance().isRouting(this.mCurrentRequestId)) {
            StateManager.getInstance().removeListener(this);
            RouteParams routeParams = TBTManager.getInstance().getRouteParams(this.mCurrentRequestId);
            this.mLogicView.showRouting(routeParams != null ? !routeParams.mCurRequestIsOnline : false);
        } else if (this.mIRouteChargeHelper.isRouteChargeEnable() && this.mIRouteChargeHelper.isRouteChargeLoading()) {
            this.mLogicView.showChargeLoading(true);
        }
        this.mLogicView.updateMapUi();
        restoreRouteChargeDecorator();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onSceneNewBridge(boolean z, @Nullable RouteRequest routeRequest) {
        if (this.mIsStartByAiMsg) {
            long routeFinishEvent = this.mMainContext.getAiMsgManager().getRouteFinishEvent();
            if (-1 != routeFinishEvent) {
                this.mOldRequestId = routeFinishEvent;
                this.mCurrentRequestId = routeFinishEvent;
                updateSelectRoute(0);
            }
        } else {
            requestRoute(routeRequest);
        }
        if (this.mLogicView.isRouting()) {
            return;
        }
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
        if (routeData != null && routeData.mRouteResult != null) {
            showRoutes(routeData.mRouteResult.mPathResult, this.mCurrentPathIndex, 0);
        } else {
            this.mLogicView.goBack();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
        this.mLogicView.hideRouting();
        StateManager.getInstance().removeListener(this);
        CarServiceManager.getInstance().removeCarStateListener(this);
        resetRouteChargeUI(true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onBackResult(int i, RouteRequest routeRequest) {
        if (10 == i) {
            if (L.ENABLE) {
                L.d(TAG, "startSceneForResult save licence plate success ");
            }
            requestReroute(false);
            return;
        }
        requestRoute(routeRequest);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
        if (checkIsLegal()) {
            this.mLogicView.hide();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
        if (checkIsLegal()) {
            this.mLogicView.show();
        }
    }

    public void cancelRouteClick() {
        VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
        if (routeData != null) {
            XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
            xPCoordinate2DDouble.mLat = routeData.mRouteParams.mEndInfo.getNaviLat();
            xPCoordinate2DDouble.mLon = routeData.mRouteParams.mEndInfo.getNaviLon();
            ExploreStatUtil.sendStatDataWhenExitRoutingByButton(this.mLogicView.getMainContext(), xPCoordinate2DDouble);
        }
        cancelRoute();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void cancelRoute() {
        if (checkIsLegal()) {
            L.d(TAG, "cancelRoute");
            this.mIsStartByAiMsg = false;
            this.mLogicView.hideRouting();
            this.mLogicView.getMapView().exitPreview(false, true);
            this.mLogicView.getMapView().getBizControlManager().removeRoute(769, true);
            this.mLogicView.cancelCountdownGuide(false);
            if (isRouteFromSpeech() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
                this.mLogicView.setReturnResult(new Bundle());
            }
            this.mLogicView.goBack();
            this.mEndPoint = TBTManager.getInstance().getRouteLastPoint(this.mOldRequestId, this.mCurrentPathIndex);
            long j = this.mOldRequestId;
            long j2 = this.mCurrentRequestId;
            if (j != j2) {
                this.mRouteProvider.cancelRoute(j2);
            }
            L.i(TAG, "clearAllRouteData");
            TBTManager.getInstance().clearAllRouteData();
        }
    }

    private int preHandleBundle(RouteRequest routeRequest) {
        List<XPViaPoint> vias = routeRequest.getVias();
        RouteRequest.RouteRequestType routeRequestType = routeRequest.getRouteRequestType();
        if (routeRequestType == null) {
            return -1;
        }
        int i = AnonymousClass21.$SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[routeRequestType.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3 && i == 4) {
                return checkViasCountMsg(vias);
            }
            return -1;
        } else if (CollectionUtils.isEmpty(vias)) {
            return -1;
        } else {
            boolean isExistedViaPoi = NaviUtil.isExistedViaPoi(vias);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "preHandleBundle: " + isExistedViaPoi);
            }
            return isExistedViaPoi ? R.string.route_fail_reason_waypoint_already_existed : NaviUtil.isDestinationInVia(vias) ? R.string.route_fail_reason_waypoint_same_as_destination : checkViasCountMsg(vias);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter$21  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass21 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType = new int[RouteRequest.RouteRequestType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[RouteRequest.RouteRequestType.ROUTE_REQUEST_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[RouteRequest.RouteRequestType.ROUTE_REQUEST_ADD_VIA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[RouteRequest.RouteRequestType.ROUTE_REQUEST_REMOVE_VIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[RouteRequest.RouteRequestType.ROUTE_REQUEST_NEW_DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$routescene$RouteRequest$RouteRequestType[RouteRequest.RouteRequestType.ROUTE_REQUEST_RESTORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private int checkViasCountMsg(List<XPViaPoint> list) {
        if (CollectionUtils.isEmpty(list)) {
            return -1;
        }
        int maxViaSize = TBTManager.getInstance().getMaxViaSize();
        if (CloudRouteDataHelper.getInstance().isCloudRouteModeOpen()) {
            list = CloudRouteDataHelper.getInstance().getRealViaList(TBTManager.getInstance().getCurrentRouteRequestId());
        }
        int i = 0;
        for (XPViaPoint xPViaPoint : list) {
            if (xPViaPoint.getViaType() == 2) {
                i++;
            }
        }
        if (i > maxViaSize) {
            return R.string.route_fail_reason_waypoint_exceed;
        }
        if (list.size() - i > 9) {
            return R.string.route_fail_reason_charge_waypoint_exceed;
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public long requestRoute(RouteRequest routeRequest) {
        RouteParams routeParams = null;
        if (routeRequest != null) {
            if (routeRequest.getRouteRequestType() == RouteRequest.RouteRequestType.ROUTE_REQUEST_RESTORE) {
                RouteParams restoreRouteParams = TBTManager.getInstance().getRestoreRouteParams();
                if (restoreRouteParams != null) {
                    restoreRouteParams.mStartInfo = TBTManager.getInstance().getStartPOIFromCurrent();
                    routeParams = restoreRouteParams;
                }
            } else {
                int preHandleBundle = preHandleBundle(routeRequest);
                if (preHandleBundle != -1) {
                    this.mLogicView.showRouteMsg(1, preHandleBundle);
                } else {
                    routeParams = new RouteParams.Builder().setStartInfo(routeRequest.getStartXP()).setEndInfo(routeRequest.getEndXP()).setViaInfos(routeRequest.getVias()).setRoutePreference(routeRequest.getRoutePreference()).setRouteLevel(2).build();
                }
            }
        }
        return requestRoute(routeParams);
    }

    private long requestRoute(RouteParams routeParams) {
        if (checkIsLegal()) {
            if (routeParams == null) {
                if (L.ENABLE) {
                    L.d(TAG, ">>> requestRoute param was null");
                }
                return -1L;
            }
            long requestRoute = this.mRouteProvider.requestRoute(routeParams, null);
            if (-1 != requestRoute) {
                this.mCurrentRequestId = requestRoute;
                StateManager.getInstance().removeListener(this);
                IRouteContract.LogicView logicView = this.mLogicView;
                if (logicView != null) {
                    logicView.showRouting(false);
                }
            }
            return requestRoute;
        }
        return -1L;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public long requestReroute(boolean z) {
        if (checkIsLegal()) {
            if (L.ENABLE) {
                L.d(TAG, "requestReroute");
            }
            RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
            if (routeData == null || routeData.mRouteParams == null) {
                return -1L;
            }
            routeData.mRouteParams.mNetworkProperty = 2;
            if (z) {
                routeData.mRouteParams.mRoutePreference = -1;
            }
            long requestRoute = this.mRouteProvider.requestRoute(routeData.mRouteParams, null);
            if (-1 != requestRoute) {
                this.mCurrentRequestId = requestRoute;
                StateManager.getInstance().removeListener(this);
                IRouteContract.LogicView logicView = this.mLogicView;
                if (logicView != null) {
                    logicView.showRouting(false);
                }
            }
            return requestRoute;
        }
        return -1L;
    }

    public long requestOnlineRoute() {
        if (checkIsLegal()) {
            if (L.ENABLE) {
                L.d(TAG, "requestRoute");
            }
            RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
            if (routeData == null || routeData.mRouteParams == null) {
                return -1L;
            }
            routeData.mRouteParams.mNetworkProperty = 1;
            long requestRoute = TBTManager.getInstance().requestRoute(routeData.mRouteParams, null);
            if (-1 != requestRoute) {
                this.mCurrentRequestId = requestRoute;
                StateManager.getInstance().removeListener(this);
                IRouteContract.LogicView logicView = this.mLogicView;
                if (logicView != null) {
                    logicView.showRouting(false);
                }
                this.mIsOfflineReroute = true;
            }
            return requestRoute;
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatDataForRoute(RouteResult routeResult, Boolean bool) {
        String str;
        String str2;
        int i;
        int i2;
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        XPCoordinate2DDouble xPCoordinate2DDouble2 = new XPCoordinate2DDouble();
        int i3 = -1;
        if (routeData == null || routeData.mRouteParams == null) {
            str = "";
            str2 = str;
            i = -1;
            i2 = 0;
        } else {
            i3 = routeData.mRouteParams.mRoutePreference;
            i = StatUtil.getPoiType(routeData.mRouteParams.mEndInfo);
            str = routeData.mRouteParams.mEndInfo.getPoiId();
            str2 = StatUtil.getPoiCategory(routeData.mRouteParams.mEndInfo);
            i2 = (routeResult == null || routeResult.mPathResult == null) ? 0 : (int) routeResult.mPathResult.getPathCount();
            if (TBTManager.getInstance().getPosServiceWrapper() != null) {
                xPCoordinate2DDouble = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            }
            xPCoordinate2DDouble2.mLat = routeData.mRouteParams.mEndInfo.getDisplayLat();
            xPCoordinate2DDouble2.mLon = routeData.mRouteParams.mEndInfo.getDisplayLon();
        }
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.ROUTE_START, Integer.valueOf(bool.booleanValue() ? 1 : 0), Integer.valueOf(i3), Integer.valueOf(i), str, str2, Integer.valueOf(i2), xPCoordinate2DDouble, xPCoordinate2DDouble2, "1", Integer.valueOf(isRouteFromSpeech() ? 1 : 0), Float.valueOf(getCarSpeed()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRoutePlanErrorAosToLocal() {
        if (checkIsLegal()) {
            this.mLogicView.showRouting(true);
            this.mLogicView.showRouteMsg(0, R.string.route_offline_reroute_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRoutePlanError(int i) {
        if (checkIsLegal()) {
            this.mLogicView.hideRouting();
            if (i == 38) {
                this.mLogicView.showRouteFailMsg(36);
            } else if (i >= 0 && i <= 35 && i < this.mLogicView.getErrorCodeLen() && !this.mIsOfflineReroute) {
                this.mLogicView.showRouteFailMsg(i);
            }
            this.mIsOfflineReroute = false;
            if (-1 != this.mOldRequestId) {
                showRoutes(TBTManager.getInstance().getRouteResult(this.mOldRequestId).mPathResult, this.mCurrentPathIndex, 0);
                if (canStartExploreCountDown()) {
                    startExploreCountDown();
                    return;
                }
                return;
            }
            this.mLogicView.goBack();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void startExploreCountDown() {
        if (this.mIsSwitchedRouteChargePlan) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "startExploreCountDown");
        }
        StateManager.getInstance().start(1);
        StateManager.getInstance().addListener(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void stopSpeechDialog() {
        if (isRouteFromSpeech()) {
            VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void startSpeechDialog() {
        if (isRouteFromSpeech() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            NaviModel.getInstance().startSpeechDialog();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void collectRouteDetailInfo(long j, RouteDetailInfo routeDetailInfo, int i, boolean z) {
        if (checkNeedCollectRouteDetailInfo(j, i)) {
            if (z) {
                refreshRoutesInfoToVoice(routeDetailInfo, i);
            } else {
                syncRoutesInfoToVoice(routeDetailInfo, i);
            }
        }
    }

    private boolean checkNeedCollectRouteDetailInfo(long j, int i) {
        if (!isRouteFromSpeech()) {
            L.w(TAG, "collectRouteDetailInfo is not route from speech");
            return false;
        } else if (this.mStartType != 0) {
            L.w(TAG, "collectRouteDetailInfo auto navi or explore no need to sync");
            return false;
        } else if (!this.mLogicView.isSceneLegal()) {
            L.w(TAG, "collectRouteDetailInfo is illegal scene");
            return false;
        } else if (TBTManager.getInstance().getRouteResultInfo(TBTManager.getInstance().getCurrentRouteRequestId(), j) == null) {
            L.w(TAG, "collectRouteDetailInfo is illegal route path");
            return false;
        } else if (i == 1) {
            L.w(TAG, "collectRouteDetailInfo pathCount is 1 from speech,no need to collect");
            return false;
        } else if (this.mIsAlreadyStartNavi) {
            L.Tag tag = TAG;
            L.w(tag, "collectRouteDetailInfo already start navi,pathId:" + j);
            return false;
        } else {
            return true;
        }
    }

    private void refreshRoutesInfoToVoice(RouteDetailInfo routeDetailInfo, int i) {
        if (this.mRefreshTable.get(routeDetailInfo.getRouteTypeNo()) == null || !this.mRefreshTable.get(routeDetailInfo.getRouteTypeNo()).booleanValue()) {
            refreshRouteInfos(routeDetailInfo);
            syncRouteInfos(i);
        }
    }

    private void syncRouteInfos(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "syncRouteInfos pathCount:" + i + ",RefreshTable.size():" + this.mRefreshTable.size() + ",RouteInfoTable.size():" + this.mRefreshTable.size());
        }
        if (this.mRefreshTable.size() == i) {
            if (this.mRouteInfoTable.size() != i || this.mAlreadySynced) {
                return;
            }
            updateAlreadySynced(true);
            NavCoreUtil.syncRouteInfoToVoice(getRouteInfo(), TBTManager.getInstance().getCurrentRouteRequestId(), false);
            if (!canStartCountdownGuide() || this.mIsAlreadyStopCountdownByUserTouch) {
                return;
            }
            setCountDownToNavShow(false);
            this.mLogicView.startCountdownGuide(false);
            return;
        }
        L.Tag tag2 = TAG;
        L.e(tag2, "syncRouteInfos route count is not matched,mRefreshTable size:" + this.mRefreshTable.size() + ",pathCount:" + i);
    }

    public void setStopCountdownByUserTouch(boolean z) {
        this.mIsAlreadyStopCountdownByUserTouch = z;
    }

    public boolean canStartCountdownGuide() {
        return (VoiceFusionUtil.getInstance().isVoiceFusionSupported() && isRouteFromSpeech()) ? false : true;
    }

    private boolean canStartExploreCountDown() {
        return canStartExploreCountDown(false);
    }

    private boolean canStartExploreCountDown(boolean z) {
        boolean z2 = true;
        boolean z3 = !isRouteFromSpeech();
        boolean z4 = isRouteFromSpeech() && z;
        if (!z3 && !z4) {
            z2 = false;
        }
        if (L.ENABLE) {
            L.d(TAG, "canStartExploreCountDown flag:" + z2 + ",flag1:" + z3 + ",flag2:" + z4);
        }
        return z2;
    }

    private void refreshRouteInfos(RouteDetailInfo routeDetailInfo) {
        this.mRouteInfoTable.put(routeDetailInfo.getRouteTypeNo(), routeDetailInfo);
        this.mRefreshTable.put(routeDetailInfo.getRouteTypeNo(), true);
    }

    private void syncRoutesInfoToVoice(RouteDetailInfo routeDetailInfo, int i) {
        this.mRouteInfoTable.put(routeDetailInfo.getRouteTypeNo(), routeDetailInfo);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "collectRouteDetailInfo mRouteInfoTable:" + this.mRouteInfoTable + ",mAlreadySynced:" + this.mAlreadySynced + ",pathCount:" + i);
        }
        if (this.mRouteInfoTable.size() != i || this.mAlreadySynced) {
            return;
        }
        NavCoreUtil.syncRouteInfoToVoice(getRouteInfo(), TBTManager.getInstance().getCurrentRouteRequestId(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseRouteExtraDetails(IPathResult iPathResult) {
        IVariantPath path;
        XPDrivePathAccessor drivePathAccessor;
        boolean z;
        AvoidTrafficJamInfo avoidTrafficJam;
        this.mRouteIncident = null;
        this.mAvoidTrafficJamInfo = null;
        this.mIncidentStr = "";
        this.mAvoidJamAreaStr = "";
        if (iPathResult == null || iPathResult.getPath(0) == null || (path = iPathResult.getPath(0)) == null || (drivePathAccessor = path.getDrivePathAccessor()) == null) {
            return "";
        }
        short trafficIncidentCount = drivePathAccessor.getTrafficIncidentCount(false);
        L.i(TAG, "ROUTEEVENT incidentCount: " + ((int) trafficIncidentCount));
        short s = (short) 0;
        boolean z2 = false;
        while (true) {
            z = true;
            if (s >= trafficIncidentCount) {
                break;
            }
            TrafficIncident trafficIncident = drivePathAccessor.getTrafficIncident(s, false);
            if (!TextUtils.isEmpty(trafficIncident.title) && (trafficIncident.titleType == 0 || trafficIncident.titleType == 1 || trafficIncident.titleType == 2 || trafficIncident.titleType == 3)) {
                TrafficIncident trafficIncident2 = this.mRouteIncident;
                if (trafficIncident2 == null) {
                    this.mRouteIncident = trafficIncident;
                } else {
                    short s2 = trafficIncident2.titleType;
                    short s3 = trafficIncident.titleType;
                    if (s2 == 3 && s3 != 3) {
                        this.mRouteIncident = trafficIncident;
                    } else if (s2 == 1 && (s3 == 2 || s3 == 0)) {
                        this.mRouteIncident = trafficIncident;
                    } else if (s2 == 0 && s3 == 2) {
                        this.mRouteIncident = trafficIncident;
                    }
                }
                if (this.mRouteIncident.titleType == 2) {
                    z2 = true;
                    break;
                }
                z2 = true;
            }
            s = (short) (s + 1);
        }
        if (z2) {
            this.mIncidentStr = this.mLogicView.getIncidentDesc(this.mRouteIncident);
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("ROUTEEVENT mIncidentStr: ");
            sb.append(this.mIncidentStr);
            sb.append(", titleType: ");
            TrafficIncident trafficIncident3 = this.mRouteIncident;
            sb.append(trafficIncident3 != null ? Short.valueOf(trafficIncident3.titleType) : "");
            L.i(tag, sb.toString());
            drivePathAccessor.recycle();
            return this.mIncidentStr;
        }
        short trafficIncidentCount2 = drivePathAccessor.getTrafficIncidentCount(true);
        L.i(TAG, "ROUTEEVENT incidentOutterCount: " + ((int) trafficIncidentCount2));
        short s4 = (short) 0;
        boolean z3 = false;
        while (true) {
            if (s4 >= trafficIncidentCount2) {
                z = z3;
                break;
            }
            TrafficIncident trafficIncident4 = drivePathAccessor.getTrafficIncident(s4, true);
            if (trafficIncident4 != null && !TextUtils.isEmpty(trafficIncident4.title)) {
                if (this.mRouteIncident == null) {
                    this.mRouteIncident = trafficIncident4;
                    this.mRouteIncident.reversed = s4;
                    break;
                }
                z3 = true;
            }
            s4 = (short) (s4 + 1);
        }
        if (z) {
            this.mIncidentStr = this.mLogicView.getIncidentDesc(this.mRouteIncident);
            L.Tag tag2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ROUTEEVENT mIncidentStr: ");
            sb2.append(this.mIncidentStr);
            sb2.append(", titleType: ");
            TrafficIncident trafficIncident5 = this.mRouteIncident;
            sb2.append(trafficIncident5 != null ? Short.valueOf(trafficIncident5.titleType) : "");
            L.i(tag2, sb2.toString());
            drivePathAccessor.recycle();
            return this.mIncidentStr;
        }
        short avoidTrafficJamCount = drivePathAccessor.getAvoidTrafficJamCount();
        L.i(TAG, "ROUTEEVENT avoidJamCount: " + ((int) avoidTrafficJamCount));
        if (avoidTrafficJamCount > 0 && (avoidTrafficJam = drivePathAccessor.getAvoidTrafficJam((short) 0)) != null) {
            this.mAvoidJamAreaStr = this.mLogicView.getAvoidJamDesc(avoidTrafficJam);
            this.mAvoidTrafficJamInfo = avoidTrafficJam;
        }
        drivePathAccessor.recycle();
        L.i(TAG, "ROUTEEVENT mAvoidJamAreaStr: " + this.mAvoidJamAreaStr);
        return this.mAvoidJamAreaStr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldShowRestrictTip() {
        TrafficIncident trafficIncident = this.mRouteIncident;
        return trafficIncident == null || trafficIncident.titleType >= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void speechSelectRoute() {
        L.Tag tag = TAG;
        L.i(tag, "speechSelectRoute mRouteType: " + this.mRouteType);
        if (!RootUtil.isTabletApp() && isRouteFromSpeech()) {
            final int pathCount = (int) TBTManager.getInstance().getRouteResult(this.mOldRequestId).mPathResult.getPathCount();
            L.Tag tag2 = TAG;
            L.i(tag2, "speechSelectRoute pathNums:" + pathCount);
            if (pathCount == 0) {
                return;
            }
            WorkThreadUtil.getInstance().executeBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.14
                @Override // java.lang.Runnable
                public void run() {
                    if (Configuration.Dependency.AIASSISTANT_ENABLE) {
                        RouteScenePresenter.this.speechStartRouteWithAiMsg(pathCount);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void speechStartRouteWithAiMsg(int i) {
        L.Tag tag = TAG;
        L.i(tag, "speechStartRouteWithAiMsg pathNums:" + i);
        MessageContentBean createContent = MessageContentBean.createContent();
        createContent.setType(16);
        for (int i2 = 0; i2 < i; i2++) {
            AiMsgSelectBean aiMsgSelectBean = new AiMsgSelectBean();
            aiMsgSelectBean.setType(16);
            aiMsgSelectBean.setIndex(i2);
            createContent.addButton(MessageContentBean.MsgButton.create("", ContextUtils.getContext().getPackageName(), GsonUtil.toJson(aiMsgSelectBean)));
        }
        createContent.addTitle(String.format(Locale.CHINA, ContextUtils.getString(R.string.speech_select_route_multiple), Integer.valueOf(i)));
        createContent.setTts(String.format(ContextUtils.getString(R.string.speech_select_route_multiple), Integer.valueOf(i)));
        MessageCenterBean create = MessageCenterBean.create(2, createContent);
        create.setScene(AiMessageEvent.SCENE_SELECT_ROUTE);
        this.mAiMessageId = create.getMessageId();
        L.Tag tag2 = TAG;
        L.i(tag2, "create messageId=" + this.mAiMessageId);
        create.getContentObject().setPosition(2);
        create.setRead_state(1);
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, GsonUtil.toJson(create));
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData(10009, bundle, "com.xiaopeng.aiassistant");
        } else {
            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(10009, bundle, IpcConfig.App.MESSAGE_CENTER);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onEvent msgID = " + ipcMessageEvent.getMsgID());
        handleMessageEvent(ipcMessageEvent.getMsgID(), ipcMessageEvent.getPayloadData());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(IpcRouterUtil.IpcRouterEvent ipcRouterEvent) {
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            L.Tag tag = TAG;
            L.i(tag, "onEvent msgID = " + ipcRouterEvent.getMsgID());
            handleMessageEvent(ipcRouterEvent.getMsgID(), ipcRouterEvent.getPayloadData());
        }
    }

    private void handleMessageEvent(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (i == 10011) {
            String string = bundle.getString(IpcConfig.IPCKey.STRING_MSG);
            L.Tag tag = TAG;
            L.i(tag, "onEvent messageContent = " + string);
            AiMsgSelectBean aiMsgSelectBean = (AiMsgSelectBean) GsonUtil.fromJson(string, (Class<Object>) AiMsgSelectBean.class);
            if (aiMsgSelectBean != null && 16 == aiMsgSelectBean.getType()) {
                SpeechRequestFactory.getInstance().postRequest(38, String.valueOf(aiMsgSelectBean.getIndex()));
                notifyWithAiMessage(aiMsgSelectBean.getIndex(), 1);
            }
        }
        if (i == 11019) {
            String string2 = bundle.getString(IpcConfig.IPCKey.STRING_MSG);
            L.Tag tag2 = TAG;
            L.i(tag2, "onEvent mAiMessageId = " + this.mAiMessageId + ", PayloadData = " + string2);
            String str = this.mAiMessageId;
            if (str == null || !str.equals(string2)) {
                return;
            }
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.15
                @Override // java.lang.Runnable
                public void run() {
                    RouteScenePresenter.this.cancelRoute();
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (speechNaviEvent.what != 903) {
            return super.onInterceptSpeechEvent(speechNaviEvent, iCommandCallback);
        }
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.Tag tag = TAG;
        L.i(tag, "onSpeechEvent event: " + speechNaviEvent.what);
        if (isSpecialSelfCommand(speechNaviEvent.what) && this.mLogicView.isSceneLegal()) {
            if (L.ENABLE) {
                L.d(TAG, "onSpeechEvent self command need to stop start navi countdown");
            }
            this.mLogicView.cancelCountdownGuide(false);
        }
        int i = speechNaviEvent.what;
        if (i != 100) {
            if (i != 109) {
                if (i != 307) {
                    if (i != 903) {
                        if (i != 312) {
                            if (i == 313) {
                                handleSpeechEventAddVia(speechNaviEvent, iCommandCallback);
                                return false;
                            } else if (i != 2007) {
                                if (i != 2008) {
                                    switch (i) {
                                        case 303:
                                            handleSpeechEventReroute(speechNaviEvent, iCommandCallback);
                                            return false;
                                        case 304:
                                            handleSpeechEventStartNavi(speechNaviEvent, iCommandCallback);
                                            return false;
                                        case 305:
                                            handleSpeechEventStopNavi(speechNaviEvent, iCommandCallback);
                                            return false;
                                        default:
                                            switch (i) {
                                                case 407:
                                                    return handleSpeechEventMapModeNorthUp(iCommandCallback);
                                                case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_2D /* 408 */:
                                                    return handleSpeechEventMapModeHeadUp2D(iCommandCallback);
                                                case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_3D /* 409 */:
                                                    return handleSpeechEventModeHeadUp3D(iCommandCallback);
                                                default:
                                                    switch (i) {
                                                        case 2001:
                                                            return handleSpeechEventInteractiveEnd(speechNaviEvent, iCommandCallback);
                                                        case 2002:
                                                        default:
                                                            return false;
                                                        case 2003:
                                                            return handleSpeechEventDataItemFocused(speechNaviEvent, iCommandCallback);
                                                    }
                                            }
                                    }
                                }
                                return handleWidgetCancel(speechNaviEvent, iCommandCallback);
                            } else {
                                return handleInfoflowCardHeightChanged(speechNaviEvent, iCommandCallback);
                            }
                        }
                        return handleSpeechEventRouteNewDestWithVias(speechNaviEvent, iCommandCallback);
                    }
                    return handleSpeechEventSetPoiToCenter();
                }
                return handleSpeechEventStartExplore(speechNaviEvent, iCommandCallback);
            }
            return handleSpeechEventOpenSearchNormal(speechNaviEvent, iCommandCallback);
        }
        return handleSpeechEventOpenFavorite(speechNaviEvent, iCommandCallback);
    }

    private boolean handleWidgetCancel(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_VOICE_ON_WIDGET_CANCEL");
        if (isRouteFromSpeech() && Utils.isPortrait()) {
            this.mLogicView.goBackToRoute();
            if (!this.mLogicView.isSceneLegal()) {
                this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
                return false;
            }
            return this.mLogicView.getSpeechEventBizHelper().executeWhenWidgetCancel(this, speechNaviEvent);
        }
        return false;
    }

    private boolean handleInfoflowCardHeightChanged(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_INFOFLOW_CARD_HEIGHT_CHANGED");
        if (isRouteFromSpeech() && Utils.isPortrait()) {
            if (!this.mLogicView.isSceneLegal()) {
                this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
                return false;
            }
            return this.mLogicView.getSpeechEventBizHelper().executeWhenInfoflowCardHeightChangedInRoute(this, speechNaviEvent);
        }
        return false;
    }

    private void handleVoiceSearchDataFetched() {
        L.i(TAG, "SPEECH_VOICE_SEARCH_DATA_FETCHED");
        this.mLogicView.getSpeechEventBizHelper().executeVoiceSearchDataFetched(this);
    }

    private boolean handleSpeechEventStartExplore(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_START_EXPLORE");
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
            return false;
        }
        return this.mLogicView.getSpeechEventBizHelper().executeStartExploreInRoute(this);
    }

    private boolean handleSpeechEventOpenSearchNormal(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_OPEN_SEARCH_NORMAL");
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
            return false;
        }
        return this.mLogicView.getSpeechEventBizHelper().executeOpenSearchNormalInRoute(this);
    }

    private boolean handleSpeechEventInteractiveEnd(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (isRouteFromSpeech()) {
            L.i(TAG, "SPEECH_VOICE_INTERACTIVE_END");
            if (isRouteFromSpeech()) {
                this.mLogicView.goBackToRoute();
                if (!this.mLogicView.isSceneLegal()) {
                    this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
                    return false;
                }
                return this.mLogicView.getSpeechEventBizHelper().executeWhenVoiceInteractiveEndInRoute(this);
            }
            return false;
        }
        return false;
    }

    private boolean handleSpeechEventDataItemFocused(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (isRouteFromSpeech()) {
            L.i(TAG, "SPEECH_VOICE_SEARCH_DATA_ITEM_FOCUSED");
            this.mLogicView.goBackToRoute();
            if (!this.mLogicView.isSceneLegal()) {
                this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
                return false;
            }
            return this.mLogicView.getSpeechEventBizHelper().executeWhenVoiceSearchDataItemFocusedInRoute(this, speechNaviEvent);
        }
        return false;
    }

    private boolean handleSpeechEventOpenFavorite(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_OPEN_FAVORITE");
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
            return false;
        }
        this.mLogicView.getSpeechEventBizHelper().openFavoriteInRoute(this);
        return true;
    }

    private boolean handleSpeechEventSetPoiToCenter() {
        L.i(TAG, "SPEECH_SET_POI_TO_CENTER");
        return true;
    }

    private void handleSpeechEventAddVia(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_ADD_VIA");
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
        } else {
            this.mLogicView.getSpeechEventBizHelper().addViaInRoute(this, speechNaviEvent);
        }
    }

    private boolean handleSpeechEventRouteNewDestWithVias(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS");
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
            return false;
        }
        this.mLogicView.getSpeechEventBizHelper().routeNewDestWithViasInRoute(this, speechNaviEvent);
        return true;
    }

    private void handleSpeechEventReroute(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_REROUTE");
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
        } else {
            this.mLogicView.getSpeechEventBizHelper().rerouteInRoute(this);
        }
    }

    private void handleSpeechEventStartNavi(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.Tag tag = TAG;
        L.i(tag, "SPEECH_START_NAVI " + speechNaviEvent.getIndex());
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
        } else {
            this.mLogicView.getSpeechEventBizHelper().startNaviInRoute(this, speechNaviEvent);
        }
    }

    private void handleSpeechEventStopNavi(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_STOP_NAVI");
        this.mLogicView.goBackToRoute();
        if (!this.mLogicView.isSceneLegal()) {
            this.mPendingEventMap.put(speechNaviEvent, iCommandCallback);
            return;
        }
        cancelRoute();
        SpeechStatProxy.getInstance().sendStatDataForSpeech(21, 2);
    }

    private boolean handleSpeechEventModeHeadUp3D(ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_3D");
        this.mLogicView.getSpeechEventBizHelper().setMapModeHeadUp3DNotSupported(iCommandCallback);
        return true;
    }

    private boolean handleSpeechEventMapModeHeadUp2D(ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_2D");
        this.mLogicView.getSpeechEventBizHelper().setMapModeHeadUp2DNotSupported(iCommandCallback);
        return true;
    }

    private boolean handleSpeechEventMapModeNorthUp(ICommandCallback iCommandCallback) {
        L.i(TAG, "SPEECH_MAP_MODE_NORTH_UP");
        this.mLogicView.getSpeechEventBizHelper().setMapModeNorthUpNotSupported(iCommandCallback);
        return true;
    }

    public boolean executeSpeechCmdVoiceSearchDataItemFocused(SpeechNaviEvent speechNaviEvent) {
        if (Utils.isRouteScene(this.mLogicView.getMainContext().getCurrentScene())) {
            L.i(TAG, "SPEECH_VOICE_SEARCH_DATA_ITEM_FOCUSED");
            handleVoiceSearchDataItemFocused(speechNaviEvent.getFocusIndex());
            return true;
        }
        return false;
    }

    public void executeSpeechCmdOpenFavorite() {
        this.mLogicView.openFavourate();
    }

    public void executeSpeechCmdAddVia(SpeechNaviEvent speechNaviEvent) {
        requestRoute(RouteRequest.createAddViaRequest(speechNaviEvent.getDest(), TBTManager.getInstance().getCurrentRouteRequestId()));
        IRouteContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.removeChildScene();
        }
    }

    public void executeSpeechCmdRouteNewDestWithVias(SpeechNaviEvent speechNaviEvent) {
        this.mStartType = speechNaviEvent.getStartType();
        this.mRouteSelectRef = speechNaviEvent.getRouteSelectRef();
        requestRoute(new RouteParams.Builder().setStartInfo(TBTManager.getInstance().getStartPOIFromCurrent()).setEndInfo(speechNaviEvent.getDest()).setViaInfos(speechNaviEvent.getViaList()).setRouteLevel(2).setRoutePreference(speechNaviEvent.getSettingParam()).build());
        IRouteContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.removeChildScene();
        }
    }

    public void executeSpeechCmdReroute() {
        requestReroute(false);
        IRouteContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.removeChildScene();
        }
    }

    public void executeSpeechCmdStartNavi(SpeechNaviEvent speechNaviEvent) {
        startGuidance(speechNaviEvent.getIndex());
        SpeechStatProxy.getInstance().sendStatDataForSpeech(35, 2);
    }

    private void handleVoiceSearchDataItemFocused(int i) {
        if (this.mLogicView.isSceneLegal() && Utils.isRouteScene(this.mLogicView.getMainContext().getCurrentScene())) {
            if (L.ENABLE) {
                L.d(TAG, "handleVoiceSearchDataItemFocused focusIndex:" + i);
            }
            if (i > 0) {
                int i2 = i - 1;
                if (L.ENABLE) {
                    L.d(TAG, "handleVoiceSearchDataItemFocused currentIndex:" + this.mCurrentPathIndex + ",realIndex:" + i2);
                }
                if (this.mCurrentPathIndex == i2) {
                    return;
                }
                RouteResult routeResult = TBTManager.getInstance().getRouteResult(this.mOldRequestId);
                if (routeResult == null || routeResult.mPathResult == null || i2 >= routeResult.mPathResult.getPathCount() || i2 < 0) {
                    L.w(TAG, "realIndex:" + i2 + " " + routeResult);
                    return;
                }
                setSelectRoute(i2);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    @MainThread
    public void startRestoreGuidance() {
        if (checkIsLegal()) {
            TTSManager.getInstance().setIsGuideStartIgnoreTTS(this.mIsRestoreNaviAutomatically);
            startGuidanceImmediately(TBTUtil.isRestoreExplore(this.mIsRestartRestore), !this.mIsRestoreNaviAutomatically);
        }
    }

    public void startGuidanceImmediately(boolean z, boolean z2) {
        int selectRouteByStrategy;
        if (checkIsLegal()) {
            if (L.ENABLE) {
                L.d(TAG, "startGuidanceImmediately startType:" + this.mStartType);
            }
            this.mIsStartNaviImmediately = true;
            if (this.mStartType == 0) {
                RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
                selectRouteByStrategy = 0;
                if (routeData != null) {
                    String str = routeData.mRouteParams.mRouteContent;
                    RouteResult routeResult = routeData.mRouteResult;
                    if (!str.isEmpty() && routeResult != null) {
                        int size = routeResult.mRouteInfos.size();
                        int i = 0;
                        while (true) {
                            if (i < size) {
                                RouteResult.RouteInfo routeInfo = routeResult.mRouteInfos.get(i);
                                if (routeInfo != null && str.equalsIgnoreCase(routeInfo.mContentName)) {
                                    selectRouteByStrategy = i;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                selectRouteByStrategy = selectRouteByStrategy();
            }
            updateSelectRoute(selectRouteByStrategy);
            if (z) {
                this.mLogicView.startExplore(this.mNumRouteOffline, this.mOldRequestId, this.mCurrentPathIndex, z2);
            } else {
                this.mLogicView.startGuidance(this.mIsManual, this.mOldRequestId, this.mCurrentPathIndex, this.mNumRouteOffline);
            }
        }
    }

    private int getPathIndexByContentName(String str, RouteDataModel routeDataModel) {
        if (routeDataModel != null) {
            RouteResult routeResult = routeDataModel.mRouteResult;
            if (!TextUtils.isEmpty(str) && routeResult != null) {
                int size = routeResult.mRouteInfos.size();
                for (int i = 0; i < size; i++) {
                    RouteResult.RouteInfo routeInfo = routeResult.mRouteInfos.get(i);
                    if (routeInfo != null && str.equalsIgnoreCase(routeInfo.mContentName)) {
                        L.i(TAG, "found path index: " + i + " for routeContent: " + str);
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    private void printRouteInfo(List<RouteResult.RouteInfo> list, String str) {
        if (CollectionUtils.isNotEmpty(list)) {
            StringBuilder sb = new StringBuilder();
            for (RouteResult.RouteInfo routeInfo : list) {
                sb.append("mPathId:");
                sb.append(routeInfo.mPathId);
                sb.append(",mTravelTime:");
                sb.append(routeInfo.mTravelTime);
                sb.append(",mPathLength:");
                sb.append(routeInfo.mPathLength);
                sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "printRouteInfo " + str + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + sb.toString());
            }
        }
    }

    private int selectRouteByStrategy() {
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "selectRouteByStrategy currentRoute:" + routeData.mRequestId + ",mRouteSelectRef:" + this.mRouteSelectRef);
        }
        if (routeData != null) {
            List<RouteResult.RouteInfo> list = routeData.mRouteResult.mRouteInfos;
            ArrayList arrayList = new ArrayList(routeData.mRouteResult.mRouteInfos);
            int i = this.mRouteSelectRef;
            if (i == 10) {
                Collections.sort(arrayList, new SortRouteInfoByPathLength());
            } else if (i == 11) {
                Collections.sort(arrayList, new SortRouteInfoByTrafficLightCount());
            }
            printRouteInfo(list, "infos before");
            printRouteInfo(arrayList, "infos after");
            return arrayList.indexOf(list.get(0));
        }
        return 0;
    }

    public long getCurrentRequestId() {
        return this.mOldRequestId;
    }

    public RouteSaveState getNeedSaveState() {
        RouteSaveState routeSaveState = new RouteSaveState();
        routeSaveState.mRequestId = getCurrentRequestId();
        routeSaveState.mSelectPathId = this.mCurrentPathIndex;
        routeSaveState.mIsOfflineRoute = this.mNumRouteOffline >= 1;
        return routeSaveState;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void countDownOnEnd() {
        if (isRouteChargeEnable() || (isRouteFromSpeech() && VoiceFusionUtil.getInstance().isVoiceFusionSupported())) {
            L.i(TAG, "countDownOnEnd route charge or speech, no need to start guide");
            return;
        }
        startGuidance(0);
        notifyWithAiMessage(0, 1);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void updateSelectRoute(int i) {
        RouteResult routeResult;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateSelectRoute mCurrentPathIndex:" + i);
        }
        this.mCurrentPathIndex = i;
        if (this.mOldRequestId == -1 || (routeResult = TBTManager.getInstance().getRouteResult(this.mOldRequestId)) == null || routeResult.mRouteInfos == null || i <= -1 || i >= routeResult.mRouteInfos.size()) {
            return;
        }
        this.mLastRouteContent = routeResult.mRouteInfos.get(i).mContentName;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void setSelectRoute(int i) {
        if (L.ENABLE) {
            L.d(TAG, "setSelectRoute ");
        }
        sendStatDataForSelectRoute(i);
        if (this.mCurrentPathIndex == i) {
            this.mLogicView.showRoutePreview();
            return;
        }
        updateSelectRoute(i);
        this.mLogicView.getMapView().getBizControlManager().setSelectedPath(769, this.mOldRequestId, i);
        this.mLogicView.renderRoute(i);
        resetRouteChargeUI(true);
        this.mIRouteChargeHelper.onMainRouteChange(i);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public boolean onBackPressed() {
        cancelRoute();
        return true;
    }

    public boolean isStartByAiMsg() {
        return this.mIsStartByAiMsg;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorRouteUpdateListener
    public void onRouteUpdate(DecoratorType decoratorType, Bundle bundle) {
        if (checkIsLegal()) {
            requestRoute(this.mLogicView.convertBundle2Request(bundle));
        }
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorRouteUpdateListener
    public void onDestinationUpdate(DecoratorType decoratorType, Bundle bundle) {
        if (checkIsLegal()) {
            requestRoute(this.mLogicView.convertBundle2Request(bundle));
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        L.Tag tag = TAG;
        L.i(tag, ">>>onStateChange state = " + i);
        IRouteContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            MapStateChangeStatUtil.sendStatData(logicView.getMainContext(), i);
            if (1 == i) {
                if (this.mStartType == 0 && !this.mLogicView.hasChildScene() && !this.mIsStartByAiMsg) {
                    sendStatDataForMsgExplore();
                    this.mLogicView.startExplore(this.mNumRouteOffline, this.mOldRequestId, this.mCurrentPathIndex, true);
                    notifyWithAiMessage(this.mCurrentPathIndex, 2);
                    return;
                }
                this.mLogicView.hidePoiPop();
            }
        }
    }

    private void addOverlayObserver(boolean z) {
        ArrayList<String> arrayList = this.mBizControlTypes;
        if (arrayList == null) {
            this.mBizControlTypes = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.mBizControlTypes.add(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE);
        this.mBizControlTypes.add(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY);
        if (z) {
            this.mLogicView.getMapView().getBizControlManager().addClickObserver(this.mBizControlTypes, this.mBizOverlayObserver);
        } else {
            this.mLogicView.getMapView().getBizControlManager().removeClickObserver(this.mBizControlTypes, this.mBizOverlayObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void handleDetailIncident() {
        if (this.mRouteIncident != null) {
            this.mLogicView.showRouteTrafficEventPop(new TrafficEventPopParam.Builder(2).setEventId(Long.toString(this.mRouteIncident.ID)).setIsZoom(true).setLon(this.mRouteIncident.pos.lon).setLat(this.mRouteIncident.pos.lat).build());
            return;
        }
        AvoidTrafficJamInfo avoidTrafficJamInfo = this.mAvoidTrafficJamInfo;
        if (avoidTrafficJamInfo != null) {
            String distanceString = NavCoreUtil.getDistanceString(avoidTrafficJamInfo.length);
            String timeString = NaviUtil.getTimeString(this.mAvoidTrafficJamInfo.travelTime);
            String str = this.mAvoidTrafficJamInfo.roadName;
            this.mLogicView.showRouteTrafficEventPop(new TrafficEventPopParam.Builder(1).setJamLen(distanceString).setJamETA(timeString).setJamRoadName(str).setIsZoom(true).setLat(this.mAvoidTrafficJamInfo.pos.lat).setLon(this.mAvoidTrafficJamInfo.pos.lon).build());
        }
    }

    private void registerAiMsgEventListener() {
        if (EventBus.getDefault().isRegistered(this.mAiMsgEventListener)) {
            return;
        }
        EventBus.getDefault().register(this.mAiMsgEventListener);
    }

    private void unregisterAiMsgEventListener() {
        if (EventBus.getDefault().isRegistered(this.mAiMsgEventListener)) {
            EventBus.getDefault().unregister(this.mAiMsgEventListener);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void sendStatDataForRoutePlate(int i, Object... objArr) {
        BtnType btnType;
        if (i == 0) {
            btnType = BtnType.ROUTE_PANEL1_SHOW;
        } else if (i == 1) {
            btnType = BtnType.ROUTE_PANEL2_SHOW;
        } else if (i != 2) {
            return;
        } else {
            btnType = BtnType.ROUTE_PANEL3_SHOW;
        }
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, btnType, objArr);
    }

    private void sendStatDataForSelectRoute(int i) {
        BtnType btnType;
        if (i == 0) {
            btnType = BtnType.ROUTE_PANEL1_SELECTED;
        } else if (i == 1) {
            btnType = BtnType.ROUTE_PANEL2_SELECTED;
        } else if (i != 2) {
            return;
        } else {
            btnType = BtnType.ROUTE_PANEL3_SELECTED;
        }
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, btnType, new Object[0]);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void sendStatDataForBtnNavi() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.ROUTE_BTN_START_NAVI, Float.valueOf(getCarSpeed()));
    }

    public void sendStatDataForBtnExplore() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.ROUTE_BTN_START_EXPLORE, Float.valueOf(getCarSpeed()));
    }

    public void sendStatDataForMsgExplore() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.ROUTE_MSG_START_EXPLORE, Float.valueOf(getCarSpeed()));
    }

    public void sendStatDataForAiTrafficDrawCountDown() {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.AI_TRAFFIC_DRAW_COUNTDOWN, Float.valueOf(getCarSpeed()));
    }

    public void sendStatDataForStartNaviCountDown(int i, int i2) {
        DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.ROUTE_START_NAVI_COUNT_DOWN, Integer.valueOf(i), Float.valueOf(getCarSpeed()), Integer.valueOf(i2));
    }

    public RouteParams getCurrentRouteParams() {
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mOldRequestId);
        if (routeData != null) {
            return routeData.mRouteParams;
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteSuccess(final long j, RouteResult routeResult) {
        if (this.mCurrentRequestId == j) {
            clearAlterLabelTableForVui(1);
            L.Tag tag = TAG;
            L.i(tag, "performance test route fragment show start requestId:" + j);
            this.mIsOfflineReroute = false;
            this.mHasReqRestrict = false;
            TBTManager.getInstance().clearRouteData(this.mOldRequestId);
            this.mOldRequestId = this.mCurrentRequestId;
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.16
                @Override // java.lang.Runnable
                public void run() {
                    if (RouteScenePresenter.this.checkIsLegal()) {
                        RouteScenePresenter.this.resetRouteChargeUI(true);
                        if (RouteScenePresenter.this.isRouteFromSpeech()) {
                            RouteScenePresenter.this.updateAlreadySynced(false);
                            RouteResult routeResult2 = TBTManager.getInstance().getRouteResult(RouteScenePresenter.this.mOldRequestId);
                            if (routeResult2 == null) {
                                RouteScenePresenter.this.mLogicView.goBack();
                                return;
                            } else if (1 == ((int) routeResult2.mPathResult.getPathCount()) && RouteScenePresenter.this.mStartType == 0) {
                                RouteScenePresenter.this.mStartType = 1;
                            }
                        }
                        if (RouteScenePresenter.this.mLogicView != null) {
                            RouteScenePresenter.this.mLogicView.hideRouting();
                            RouteScenePresenter.this.mLogicView.showOverViewButton(false);
                        }
                        if (!SystemConst.ROUTE_TYPE_RESTORE_ROUTE.equals(RouteScenePresenter.this.mRouteType)) {
                            if (RouteScenePresenter.this.mStartType != 0 || RouteScenePresenter.this.mIsRouteChargeGuide || SystemConst.ROUTE_TYPE_FROM_PHONE.equals(RouteScenePresenter.this.mRouteType)) {
                                if (RouteScenePresenter.this.mIsRouteChargeGuide && j == RouteScenePresenter.this.mRouteChargeRequestId) {
                                    RouteScenePresenter routeScenePresenter = RouteScenePresenter.this;
                                    routeScenePresenter.startNaviOnChargeUpdate(routeScenePresenter.mIsIgnoreOldTTS, RouteScenePresenter.this.mRouteChargeIsExplore, RouteScenePresenter.this.mRouteChargeMsg);
                                    RouteScenePresenter.this.mIsRouteChargeGuide = false;
                                    return;
                                }
                                RouteScenePresenter routeScenePresenter2 = RouteScenePresenter.this;
                                routeScenePresenter2.startGuidanceImmediately(routeScenePresenter2.mStartType == 2, true);
                                RouteScenePresenter.this.mStartType = 0;
                                RouteScenePresenter.this.mRouteSelectRef = 0;
                                return;
                            }
                            RouteScenePresenter.this.updateSelectRoute(0);
                            RouteResult routeResult3 = TBTManager.getInstance().getRouteResult(RouteScenePresenter.this.mOldRequestId);
                            if (routeResult3 == null) {
                                RouteScenePresenter.this.mLogicView.goBack();
                                return;
                            }
                            RouteScenePresenter.this.mLogicView.hideTip();
                            RestrictHelper restrictHelper = RouteScenePresenter.this.mLogicView.getRestrictHelper();
                            String parseRouteExtraDetails = RouteScenePresenter.this.parseRouteExtraDetails(routeResult3.mPathResult);
                            if (restrictHelper == null || !restrictHelper.isNeedRequestRestrict(routeResult3.mRouteType) || !RouteScenePresenter.this.shouldShowRestrictTip()) {
                                RouteScenePresenter.this.mLogicView.showTip(0, parseRouteExtraDetails);
                            } else {
                                if (restrictHelper.isRestrictedPopShow()) {
                                    restrictHelper.hideRestrictedPop();
                                }
                                restrictHelper.requestRestrict(RouteScenePresenter.this, j);
                                RouteScenePresenter.this.mHasReqRestrict = true;
                            }
                            RouteScenePresenter.this.mIRouteChargeHelper.onRouteUpdate(routeResult3.mPathResult, RouteScenePresenter.this.mCurrentPathIndex, TBTManager.getInstance().getRouteParams(RouteScenePresenter.this.mOldRequestId));
                            RouteScenePresenter.this.showRoutes(routeResult3.mPathResult, RouteScenePresenter.this.mCurrentPathIndex, 0);
                            RouteScenePresenter.this.speechSelectRoute();
                            if (RouteScenePresenter.this.canStartCountdownGuide()) {
                                RouteScenePresenter.this.setCountDownToNavShow(false);
                                RouteScenePresenter.this.mLogicView.startCountdownGuide(false);
                            }
                            RouteScenePresenter.this.sendStatDataForRoute(routeResult3, true);
                            if (!routeResult3.mIsLocal) {
                                RouteScenePresenter.this.mNumRouteOffline = 0;
                                RouteScenePresenter.this.mLogicView.hideOffline();
                                return;
                            }
                            RouteScenePresenter.access$808(RouteScenePresenter.this);
                            RouteScenePresenter.this.mLogicView.showOfflineTips(true);
                            return;
                        }
                        RouteScenePresenter.this.startRestoreGuidance();
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteError(final long j, RouteResult routeResult) {
        if (this.mCurrentRequestId == j) {
            final int i = routeResult.mErrorCode;
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.17
                @Override // java.lang.Runnable
                public void run() {
                    if (RouteScenePresenter.this.checkIsLegal()) {
                        RouteScenePresenter.this.updateAlreadySynced(false);
                        if (37 == i) {
                            RouteScenePresenter.this.handleRoutePlanErrorAosToLocal();
                        } else {
                            if (RouteScenePresenter.this.mLogicView.isOfflineRoutePanelExpand()) {
                                RouteScenePresenter.this.mLogicView.showOfflineTips(true);
                            }
                            RouteScenePresenter.this.handleRoutePlanError(i);
                            TBTManager.getInstance().clearRouteData(j);
                        }
                        RouteScenePresenter.this.sendStatDataForRoute(null, false);
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteOddSuccess(long j, RouteResult routeResult) {
        OddDataHelper.getInstance().updateOddInfo();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
        updateRemainDis();
        updateRouteChargeCarRemain();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
        updateRemainDis();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
        updateRemainDis();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
        updateRemainDis();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onClickBlank() {
        hideRouteChargePanel(true);
    }

    public boolean executeWhenVoiceInteractiveEnd() {
        if (this.mLogicView.isSceneLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "executeWhenVoiceInteractiveEnd isRouteFromSpeech:" + isRouteFromSpeech() + ",state:" + StateManager.getInstance().getState());
            }
            if (isRouteFromSpeech()) {
                cancelRoute();
                return true;
            }
            this.mLogicView.cancelCountdownGuide(false);
            StateManager.getInstance().removeListener(this);
            return false;
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void updateRouteChargePlanSwitchStatus(boolean z, boolean z2) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.updateRouteChargePlanSwitchStatus(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void resetRouteChargeUI(boolean z) {
        RouteChargeDecorator routeChargeDecorator = this.mRouteChargeDecorator;
        if (routeChargeDecorator != null) {
            routeChargeDecorator.hideCharges();
        }
        hideRouteChargePanel(z);
        this.mLogicView.showChargeLoading(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onRouteChargePlanBtnSwitched(boolean z) {
        if (this.mLogicView.isSceneLegal()) {
            L.Tag tag = TAG;
            L.i(tag, "ROUTE_CHARGE switch routeChargePlan: " + z);
            DataLogUtil.sendStatData(PageType.NAVI_ROUTING, BtnType.ROUTE_CHARGE_SWITCH, Integer.valueOf(z ? 1 : 0), Integer.valueOf(CarServiceManager.getInstance().getCarRemainDistance()));
            this.mIsSwitchedRouteChargePlan = true;
            StateManager.getInstance().removeListener(this);
            this.mLogicView.cancelCountdownGuide(false);
            if (!z) {
                resetRouteChargeUI(true);
            }
            this.mIRouteChargeHelper.enableChargeFunction(z);
        }
    }

    public boolean isSwitchedRouteChargePlan() {
        return this.mIsSwitchedRouteChargePlan;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void showRouteChargeDetailView(boolean z, boolean z2, boolean z3, String str, String str2, long j, long j2, boolean z4, long j3, boolean z5, boolean z6) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.showRouteChargeDetailView(z, z2, z3, str, str2, j, j2, z4, j3, z5, z6);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void hideRouteChargePanel(boolean z) {
        this.mLogicView.hideRouteChargePanel(z);
        RouteChargeDecorator routeChargeDecorator = this.mRouteChargeDecorator;
        if (routeChargeDecorator != null) {
            routeChargeDecorator.unFocus();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void showRouteChargeToast(final String str) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.18
                @Override // java.lang.Runnable
                public void run() {
                    RouteScenePresenter.this.mLogicView.showRouteMsg(0, str);
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void notifyOverViewRouteChargeDecorator(final RectDouble rectDouble) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.19
                @Override // java.lang.Runnable
                public void run() {
                    if (rectDouble == null) {
                        RouteScenePresenter.this.mLogicView.showRoutePreview();
                        RouteScenePresenter.this.mLogicView.showOverViewButton(false);
                        return;
                    }
                    RouteScenePresenter.this.mLogicView.updatePreviewRect(rectDouble);
                    RouteScenePresenter.this.mLogicView.showOverViewButton(true);
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void showRouteChargerDecorator(XPPointBaseData[] xPPointBaseDataArr, int i) {
        if (this.mRouteChargeDecorator == null) {
            this.mRouteChargeDecorator = new RouteChargeDecorator(this.mMainContext);
            this.mRouteChargeDecorator.setListener(this);
        }
        this.mRouteChargeDecorator.showCharges(xPPointBaseDataArr);
        this.mRouteChargeDecorator.focus(i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public RectDouble getPreviewRect(ArrayList<XPPointBaseData> arrayList) {
        return this.mLogicView.getMapView().getPreviewRect(NavCoreUtil.translationBizAGroupBusinessInfos(arrayList));
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void removeRouteChargeDecorators(XPPointBaseData[] xPPointBaseDataArr) {
        RouteChargeDecorator routeChargeDecorator = this.mRouteChargeDecorator;
        if (routeChargeDecorator != null) {
            routeChargeDecorator.removeCharges(xPPointBaseDataArr);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator.IRouteChargeDecoratorListener
    public void onFocusCharge(final String str, final int i, final int i2) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter.20
                @Override // java.lang.Runnable
                public void run() {
                    RouteScenePresenter.this.mIRouteChargeHelper.onFocusCharge(str, i, i2);
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void addRouteKeyPintsTestDecorator(List<Coord2DDouble> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        XPCoordinate2DDouble[] xPCoordinate2DDoubleArr = new XPCoordinate2DDouble[list.size()];
        for (int i = 0; i < list.size(); i++) {
            xPCoordinate2DDoubleArr[i] = new XPCoordinate2DDouble(list.get(i));
        }
        MapUtil.addMapOverLayItems(this.mLogicView.getMainContext(), xPCoordinate2DDoubleArr);
    }

    @Override // com.xiaopeng.montecarlo.views.RouteChargePanelView.IRouteChargeDetailListener
    public void onChargeAdd(String str) {
        if (this.mLogicView.isSceneLegal()) {
            this.mIRouteChargeHelper.onUpdateChargePlan(str, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteChargePanelView.IRouteChargeDetailListener
    public void onChargeRemove(String str) {
        if (this.mLogicView.isSceneLegal()) {
            this.mIRouteChargeHelper.onUpdateChargePlan(str, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public void onClickStartNavi(boolean z) {
        this.mIRouteChargeHelper.onStartNavi(z);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void requestRouteWithCharges(int i, boolean z, boolean z2, RouteRequest routeRequest) {
        this.mRouteChargeRequestId = requestRoute(routeRequest);
        this.mIsRouteChargeGuide = true;
        this.mRouteChargeIsExplore = z;
        this.mRouteChargeMsg = i;
        this.mIsIgnoreOldTTS = z2;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void startNaviNoCharge(boolean z, int i, boolean z2) {
        startNaviOnChargeUpdate(z2, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNaviOnChargeUpdate(boolean z, boolean z2, int i) {
        TTSManager.getInstance().setIsGuideStartIgnoreTTS(z);
        if (checkIsLegal()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "startNaviOnChargeUpdate routeChargeIsExplore:" + z2 + ", isIgnoreOldTTS: " + z + ", mLastRouteContent: " + this.mLastRouteContent);
            }
            updateSelectRoute(TextUtils.isEmpty(this.mLastRouteContent) ? 0 : getPathIndexByContentName(this.mLastRouteContent, TBTManager.getInstance().getRouteData(this.mOldRequestId)));
            if (z2) {
                this.mLogicView.startExplore(this.mNumRouteOffline, this.mOldRequestId, this.mCurrentPathIndex, true);
            } else {
                this.mLogicView.startGuidance(this.mIsManual, this.mOldRequestId, this.mCurrentPathIndex, this.mNumRouteOffline);
            }
            if (i > -1) {
                TTSProxy.getInstance().speak(ContextUtils.getString(i), null);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    @MainThread
    public void showRouteChargePlanDialog(String str, String str2, IRouteChargeContract.IRoutePlanConfirmCallBack iRoutePlanConfirmCallBack) {
        if (this.mLogicView.isSceneLegal()) {
            if (str.equals(ContextUtils.getString(R.string.route_fail_reason_charge_waypoint_exceed)) || str.equals(ContextUtils.getString(R.string.route_charge_add_on_vias_route))) {
                this.mLogicView.showRouteMsg(1, str);
            } else {
                this.mLogicView.showRouteChargePlanDialog(str, str2, iRoutePlanConfirmCallBack);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void addRouteChargeToBar(ChargeRouteView.ChargePoint chargePoint, double d, boolean z) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.addRouteChargeToBar(chargePoint, d, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void removeRouteChargesOnBar(List<String> list, double d, boolean z) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.removeRouteChargesOnBar(list, d, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void initRouteChargeBar(long j, long j2, long j3, double d, boolean z) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.initRouteChargeBar(j, j2, j3, d, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void updateRouteChargesBar(long j, long j2, long j3, List<ChargeRouteView.ChargePoint> list, double d, boolean z) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.updateRouteChargesBar(j, j2, j3, list, d, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void focusRouteChargeOnBar(ChargeRouteView.ChargePoint chargePoint) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.focusRouteChargeOnBar(chargePoint);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void showChargeLoading(boolean z) {
        this.mLogicView.showChargeLoading(z);
    }

    private void restoreRouteChargeDecorator() {
        XPPointBaseData[] decoratorData = this.mIRouteChargeHelper.getDecoratorData();
        if (CollectionUtils.isNotEmpty(decoratorData) && this.mRouteChargeDecorator != null && this.mIRouteChargeHelper.isRouteChargeEnable()) {
            this.mRouteChargeDecorator.showCharges(decoratorData);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void updatePathK(double d) {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.updatePathK(d);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public boolean isRouteChargeFocused() {
        RouteChargeDecorator routeChargeDecorator = this.mRouteChargeDecorator;
        if (routeChargeDecorator != null) {
            return routeChargeDecorator.isFocused();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.IRouteContract.Presenter
    public boolean isRouteChargeEnable() {
        return this.mIRouteChargeHelper.isRouteChargeEnable();
    }

    public void stopRouteChargeAutoOverViewTimer() {
        this.mIRouteChargeHelper.stopAutoOverViewTimer();
    }

    @Override // com.xiaopeng.montecarlo.base.IRouteUpdateContract
    public void onRouteUpdate(Bundle bundle) {
        if (checkIsLegal()) {
            requestRoute(this.mLogicView.convertBundle2Request(bundle));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargePresenter
    public void onNetworkError(int i) {
        this.mMainContext.showPrompt(i);
    }

    public boolean hasReqRestrict() {
        return this.mHasReqRestrict;
    }

    public void collectRouteDetailInfoForVui(RouteDetailInfo routeDetailInfo, int i, XLinearLayout xLinearLayout, RouteDetailPanel routeDetailPanel, String str) {
        if (isRouteFromSpeech()) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("collectRouteDetailInfoForVui"));
        }
        RouteVuiHelper.updateRouteVui(routeDetailInfo, i, xLinearLayout, routeDetailPanel, this.mLogicView.getMainContext().getCurrentScene());
    }

    public boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent, IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onInterceptVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",scene:" + iBaseScene);
        }
        return RouteVuiHelper.onInterceptVuiEvent(view, vuiEvent, this, iBaseScene);
    }

    public boolean onVuiEvent(View view, VuiEvent vuiEvent, IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",scene:" + iBaseScene);
        }
        return RouteVuiHelper.onVuiEvent(view, vuiEvent, this, iBaseScene);
    }

    public boolean executeWhenOnDialogStart() {
        if (this.mLogicView.isSceneLegal()) {
            this.mLogicView.cancelCountdownGuide(false);
            StateManager.getInstance().removeListener(this);
            return true;
        }
        return false;
    }

    public boolean executeOpenSearchNormal() {
        this.mLogicView.openSearchNormal();
        return true;
    }

    public boolean executeStartExplore() {
        if (L.ENABLE) {
            L.d(TAG, "executeStartExplore");
        }
        startExplore();
        return true;
    }

    public boolean isCountDownToNavShow() {
        return this.mIsCountDownToNavShow;
    }

    public void setCountDownToNavShow(boolean z) {
        this.mIsCountDownToNavShow = z;
    }

    public boolean executeWhenInfoflowCardHeightChanged(SpeechNaviEvent speechNaviEvent) {
        this.mLogicView.onInfoflowCardHeightChanged(speechNaviEvent.getInfoflowCardHeight());
        return true;
    }

    public void clearAlterLabelTableForVui(int i) {
        if (this.mLogicView.isSceneVuiEnabled()) {
            MapVuiHelper.getInstance().clearAlterLabelTableForVui(i);
        }
    }

    public boolean executeWhenWidgetCancel(SpeechNaviEvent speechNaviEvent) {
        IRouteContract.LogicView logicView = this.mLogicView;
        if (logicView == null || !logicView.isSceneLegal()) {
            return true;
        }
        this.mLogicView.hideExploreAndReferenceForVoice();
        return true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper.OddHelperListener
    public void updateOddInfo(List<XPOddInfo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            this.mLogicView.updateOddInfo(list);
        }
    }
}
