package com.xiaopeng.montecarlo.navcore.xptbt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.guide.GuideService;
import com.autonavi.gbl.guide.model.DriveEventTip;
import com.autonavi.gbl.guide.model.NaviStatisticsInfo;
import com.autonavi.gbl.guide.model.RangeType;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.map.model.MapModelConstants;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.adasehp.EHPServiceManager;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.location.XPLocInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.event.GuideWrapperNaviEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.navi.NaviPowerDisHelperContainer;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.ProtoSimulator;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.sr.data.HappyEnding;
import com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.TrafficEventHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPAsyncInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseLinkAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverConfig;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRouteTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPSoundInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTrafficEventInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GuideManager implements RouteManager.IRouteResultListener, OnUpdateRemainDisListener {
    private static final int CROSS_LINK_INTERVAL_DIST = 3;
    private static final long INTERVAL_CHECK_TRAFFIC_DIS_ONE_SEC = 1000;
    private static final long INTERVAL_CHECK_TRAFFIC_DIS_THREE_SEC = 3000;
    private static final int MSG_ADJUST_SIMULATION = 2006;
    private static final int MSG_ASYNC_MANEUVER_INFO = 2004;
    private static final int MSG_CHANGE_NAVI_PATH = 2022;
    private static final int MSG_CHECK_TRAFFIC_DIS = 3013;
    private static final int MSG_CLEAR_ETAEVENT_OVERLAY = 2008;
    private static final int MSG_CLEAR_GUIDE_ROUTE_OVERLAY = 2007;
    private static final int MSG_DELETE_PATH = 2018;
    private static final int MSG_EHP_SET_CONFIG = 2030;
    private static final int MSG_ENTER_3D = 2021;
    private static final int MSG_NAVI_ARRIVE_STOP = 2027;
    private static final int MSG_ON_CHANGE_NAVI_PATH = 3007;
    private static final int MSG_ON_DELETE_PATH = 3004;
    private static final int MSG_ON_MAIN_PATH_CHANGED = 3010;
    private static final int MSG_ON_NAVI_START = 3011;
    private static final int MSG_ON_NAVI_STOP_BY_USER = 3009;
    private static final int MSG_ON_OBTAIN_ASYNC_INFO = 2025;
    private static final int MSG_ON_SELECT_MAIN_PATH_STATUS = 3008;
    private static final int MSG_PLAY_NAVI_MANUAL = 2005;
    private static final int MSG_REFRESH_GUIDE_DATA = 2017;
    private static final int MSG_REMOVE_ROUTE_HISTORY = 3001;
    private static final int MSG_REQUEST_REROUTE = 2000;
    private static final int MSG_REROUTE_ERROR = 2020;
    private static final int MSG_REROUTE_ODD_ERROR = 2029;
    private static final int MSG_REROUTE_ODD_SUCCESS = 2028;
    private static final int MSG_REROUTE_SUCCESS = 2019;
    private static final int MSG_RESET_DATA_ON_NAVI_STOP = 2026;
    private static final int MSG_SAVE_ROUTE_HISTORY = 3000;
    private static final int MSG_SAVE_ROUTE_PARAMS = 3003;
    private static final int MSG_SELECT_MAIN_PATH = 2009;
    private static final int MSG_SELECT_MAIN_PATH_STATUS = 2023;
    private static final int MSG_SEND_REROUTE_ERROR = 3006;
    private static final int MSG_SEND_REROUTE_ODD_ERROR = 3015;
    private static final int MSG_SEND_REROUTE_ODD_SUCCESS = 3014;
    private static final int MSG_SEND_REROUTE_SUCCESS = 3005;
    private static final int MSG_SET_CRUISE_AHEAD_TRAFFIC = 2011;
    private static final int MSG_SET_CRUISE_OPEN_CAMERA = 2012;
    private static final int MSG_SET_DAY_NIGHT_MODE = 2014;
    private static final int MSG_SET_ETA_RESTRICTION = 2016;
    private static final int MSG_SET_NAVI_INFO_COUNT = 2010;
    private static final int MSG_SET_NAVI_PATH = 2003;
    private static final int MSG_SET_PLAY_STYLE = 2013;
    private static final int MSG_SET_VEHICLE = 2015;
    private static final int MSG_START_NAVI = 2001;
    private static final int MSG_STOP_NAVI = 2002;
    private static final int MSG_STOP_NAVI_BY_USER = 2024;
    private static final int MSG_UPDATE_ROUTE_HISTORY = 3002;
    private static final int NAVI_STOP_TIMEOUT_TIMER = 10000;
    private static final String ROUTE_HISTORY_FILE_NAME = "routeHistory.xml";
    private static final int ROUTE_HISTORY_MAX_DISTANCE = 100000;
    private static final int ROUTE_HISTORY_MIN_DISTANCE = 1000;
    private static final double TRAFFIC_EVENT_DIS_STATUS_CLOSE = 20.0d;
    private static final double TRAFFIC_EVENT_DIS_STATUS_NORMAL = 500.0d;
    private static final double TRAFFIC_EVENT_DIS_STATUS_WARNING = 400.0d;
    public static final int TRAFFIC_EVENT_TYPE_ACCIDENT = 1;
    public static final int TRAFFIC_EVENT_TYPE_CONSTRUCTION = 2;
    public static final int TRAFFIC_EVENT_TYPE_NONE = 0;
    private int mAsyncInfoArrowColor;
    private int mAsyncInfoBackColor;
    private int mAsyncInfoRoadColor;
    private final List<ICruiseListener> mCruiseListeners;
    private volatile XPObtainInfo mCurrentReqManeuverInfo;
    private String mHistoryFileDir;
    private volatile boolean mIsByUser;
    private volatile boolean mIsStopDelete;
    private NaviChargeReminder mNaviChargeReminder;
    private final List<INaviListener> mNaviListeners;
    private INavigationInfoUploadStrategy mNavigationInfoUpload;
    private NaviPowerDisHelperContainer mPowerDisHelperContainer;
    private RecommendParkingHelper mRecommendParkingHelper;
    private final Map<Long, IRerouteListener> mRerouteListenerMap;
    private final List<IRerouteListener> mRerouteListeners;
    private List<RouteParams> mRerouteParams;
    private List<Long> mRerouteRequestIds;
    private final List<ISoundPlayListener> mSoundPlayListeners;
    private XCountDownTimer mTimer;
    private static final L.Tag TAG = new L.Tag("GuideManager");
    private static final Long HOUR_3 = Long.valueOf((long) NavRestoreManager.SILENCE_TIME_SPAN_3H);
    private static final Long HOUR_12 = Long.valueOf((long) NavRestoreManager.SILENCE_TIME_SPAN_12H);
    private static final Long MINUTE_5 = Long.valueOf((long) CityDataBean.UNZIPPING_BLOCKING_TIME);
    private volatile boolean mIsOnChangeNaviPath = false;
    private boolean mIsNaviStop = false;
    private boolean mNeedWaitGuideEndTts = true;
    private int mOldSegIdx = 0;
    private final Handler mListenerHandler = new Handler(WorkThreadUtil.getInstance().getNavThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            L.Tag tag = GuideManager.TAG;
            L.i(tag, ">>> mListenerHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 3000:
                    GuideManager.this.onSaveRouteHistory();
                    return;
                case 3001:
                    GuideManager.this.onRemoveRouteHistory();
                    return;
                case 3002:
                    GuideManager.this.onUpdateRouteHistory();
                    return;
                case 3003:
                    RouteParams routeParams = (RouteParams) message.obj;
                    if (routeParams == null || routeParams.mEndInfo == null) {
                        return;
                    }
                    GuideManager.this.mGuideDataManager.setRestoreRouteParams(routeParams);
                    new FileIOUtil().writeObject2SDCard(GuideManager.this.mHistoryFileDir, GuideManager.ROUTE_HISTORY_FILE_NAME, routeParams);
                    return;
                case 3004:
                    List<Long> list = (List) message.obj;
                    long currentNaviId = GuideManager.this.mGuideDataManager.getCurrentNaviId();
                    for (INaviListener iNaviListener : GuideManager.this.mNaviListeners) {
                        if (iNaviListener != null) {
                            iNaviListener.onDeletePath(list, currentNaviId, GuideManager.this.mIsStopDelete);
                        }
                    }
                    return;
                case 3005:
                    long longValue = ((Long) message.obj).longValue();
                    RouteResult routeResult = TBTManager.getInstance().getRouteResult(longValue);
                    if (routeResult != null) {
                        GuideManager.this.sendRerouteSuccess(longValue, routeResult);
                        return;
                    }
                    return;
                case 3006:
                    long longValue2 = ((Long) message.obj).longValue();
                    RouteResult routeResult2 = TBTManager.getInstance().getRouteResult(longValue2);
                    if (routeResult2 != null) {
                        GuideManager.this.sendRerouteError(longValue2, routeResult2);
                        return;
                    }
                    return;
                case 3007:
                    long longValue3 = ((Long) message.obj).longValue();
                    for (INaviListener iNaviListener2 : GuideManager.this.mNaviListeners) {
                        if (iNaviListener2 != null) {
                            iNaviListener2.onChangeNaviPath(longValue3);
                        }
                    }
                    return;
                case 3008:
                    long longValue4 = ((Long) message.obj).longValue();
                    for (INaviListener iNaviListener3 : GuideManager.this.mNaviListeners) {
                        if (iNaviListener3 != null) {
                            iNaviListener3.onSelectMainPathStatus(longValue4, 1);
                        }
                    }
                    return;
                case 3009:
                case RangeType.RANGETYPE_U_TURN /* 3012 */:
                default:
                    return;
                case 3010:
                    GuideManager guideManager = GuideManager.this;
                    guideManager.refreshNaviPdHelper(guideManager.mGuideDataManager.getMainPathId());
                    for (INaviListener iNaviListener4 : GuideManager.this.mNaviListeners) {
                        if (iNaviListener4 != null) {
                            iNaviListener4.onMainPathChanged();
                        }
                    }
                    return;
                case 3011:
                    int intValue = ((Integer) message.obj).intValue();
                    for (INaviListener iNaviListener5 : GuideManager.this.mNaviListeners) {
                        if (iNaviListener5 != null) {
                            iNaviListener5.onNaviStart(intValue);
                        }
                    }
                    return;
                case 3013:
                    GuideManager.this.checkTrafficEventStatus(((Integer) message.obj).intValue());
                    return;
                case 3014:
                    long longValue5 = ((Long) message.obj).longValue();
                    RouteResult routeResult3 = TBTManager.getInstance().getRouteResult(longValue5);
                    if (routeResult3 != null) {
                        GuideManager.this.sendRerouteOddSuccess(longValue5, routeResult3);
                        return;
                    }
                    return;
                case 3015:
                    GuideManager.this.sendRerouteOddError(((Long) message.obj).longValue());
                    return;
            }
        }
    };
    private final Handler mCallHandler = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            L.Tag tag = GuideManager.TAG;
            L.i(tag, ">>> mRequestHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 2000:
                default:
                    return;
                case 2001:
                    int intValue = ((Integer) message.obj).intValue();
                    if (intValue != 2) {
                        GuideManager.this.createNaviPdHelper();
                        GuideManager.this.mNaviChargeReminder.start();
                    } else if (GuideManager.this.mPowerDisHelperContainer.size() > 0) {
                        GuideManager.this.closeNaviPdHelper();
                    }
                    long j = 0;
                    if (intValue == 1) {
                        j = 1;
                    } else if (intValue == 2) {
                        j = 2;
                    }
                    TBTManager.getInstance().setNaviId(j);
                    if (L.ENABLE) {
                        L.Tag tag2 = GuideManager.TAG;
                        L.d(tag2, "id " + j + " navitype " + intValue);
                    }
                    GuideManager.this.mIsStopDelete = false;
                    GuideManager.this.mGuideServiceWrapper.startNavi(j, intValue);
                    GuideManager.this.mListenerHandler.sendMessage(GuideManager.this.mListenerHandler.obtainMessage(3011, Integer.valueOf(intValue)));
                    return;
                case 2002:
                    GuideManager.this.closeNaviPdHelper();
                    TBTManager.getInstance().clearBizRouteOverlay(BizRouteType.BizRouteTypeGuideEtaEvent);
                    return;
                case 2003:
                    int intValue2 = ((Integer) message.obj).intValue();
                    GuideManager.this.mGuideServiceWrapper.setNaviPath(GuideManager.this.mGuideDataManager.getNaviPath(), intValue2);
                    GuideManager.this.setEhpConfigValue(true);
                    GuideManager.this.mRecommendParkingHelper.onNaviUpdate();
                    return;
                case 2004:
                    XPAsyncInfo xPAsyncInfo = (XPAsyncInfo) message.obj;
                    if (xPAsyncInfo != null) {
                        long asyncManeuverInfo = GuideManager.this.mGuideServiceWrapper.asyncManeuverInfo(xPAsyncInfo);
                        if (L.ENABLE) {
                            L.Tag tag3 = GuideManager.TAG;
                            L.d(tag3, ">>> asyncManeuverInfo  reqid=" + asyncManeuverInfo + " what=" + xPAsyncInfo.mWhat);
                        }
                        GuideManager.this.mCurrentReqManeuverInfo.mReqID = asyncManeuverInfo;
                        GuideManager.this.mCurrentReqManeuverInfo.mWhat = xPAsyncInfo.mWhat;
                        return;
                    }
                    return;
                case 2005:
                    GuideManager.this.mGuideServiceWrapper.playNaviManual();
                    return;
                case 2006:
                    int intValue3 = ((Integer) message.obj).intValue();
                    if (L.ENABLE) {
                        L.Tag tag4 = GuideManager.TAG;
                        L.d(tag4, ">>> mRequestHandler handleMessage speed=" + intValue3);
                    }
                    GuideManager.this.mGuideServiceWrapper.adjustSimulationSpeed(String.valueOf(intValue3));
                    return;
                case 2007:
                    if (TBTManager.getInstance().getMap() != null) {
                        TBTManager.getInstance().getMap().getBizControlManager().clearGuideRouteOverlay();
                        return;
                    }
                    return;
                case 2008:
                    TBTManager.getInstance().clearBizRouteOverlay(BizRouteType.BizRouteTypeGuideEtaEvent);
                    return;
                case 2009:
                    GuideManager.this.mGuideServiceWrapper.selectMainPathId(((Long) message.obj).longValue());
                    return;
                case 2010:
                    GuideManager.this.mGuideServiceWrapper.setNaviInfoCount(((Integer) message.obj).intValue());
                    return;
                case 2011:
                    GuideManager.this.mGuideServiceWrapper.setCruiseAheadTraffic(((Boolean) message.obj).booleanValue());
                    return;
                case 2012:
                    GuideManager.this.mGuideServiceWrapper.setCruiseOpenCamera(((Integer) message.obj).intValue());
                    return;
                case 2013:
                    GuideManager.this.mGuideServiceWrapper.setPlayStyle(((Integer) message.obj).intValue());
                    return;
                case 2014:
                    GuideManager.this.mGuideServiceWrapper.setDayNightMode(((Integer) message.obj).intValue());
                    return;
                case 2015:
                    GuideManager.this.mGuideServiceWrapper.setVehicleId((String) message.obj);
                    return;
                case 2016:
                    GuideManager.this.mGuideServiceWrapper.setETARestriction(((Boolean) message.obj).booleanValue());
                    return;
                case 2017:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    GuideManager.this.mGuideDataManager.setCurrentNaviId(((Long) message.obj).longValue(), i);
                    GuideManager.this.updatePathIndex(i2);
                    return;
                case GuideManager.MSG_DELETE_PATH /* 2018 */:
                    List list = (List) message.obj;
                    if (GuideManager.this.deletePath(list)) {
                        GuideManager.this.mListenerHandler.sendMessage(GuideManager.this.mListenerHandler.obtainMessage(3004, list));
                        return;
                    }
                    return;
                case 2019:
                    long longValue = ((Long) message.obj).longValue();
                    RouteResult routeResult = TBTManager.getInstance().getRouteResult(longValue);
                    if (routeResult != null) {
                        GuideManager.this.reRouteSuccess(longValue, routeResult);
                        return;
                    }
                    L.Tag tag5 = GuideManager.TAG;
                    L.w(tag5, "missing routeResult for request:" + longValue);
                    return;
                case 2020:
                    long longValue2 = ((Long) message.obj).longValue();
                    RouteResult routeResult2 = TBTManager.getInstance().getRouteResult(longValue2);
                    if (routeResult2 != null) {
                        GuideManager.this.reRouteError(longValue2, routeResult2);
                        return;
                    }
                    return;
                case 2021:
                    GuideManager.this.mGuideServiceWrapper.setEnter3D(((Boolean) message.obj).booleanValue());
                    return;
                case 2022:
                    long longValue3 = ((Long) message.obj).longValue();
                    if (GuideManager.this.selectMainPath(longValue3)) {
                        GuideManager.this.mListenerHandler.sendMessage(GuideManager.this.mListenerHandler.obtainMessage(3007, Long.valueOf(longValue3)));
                        return;
                    }
                    return;
                case 2023:
                    long longValue4 = ((Long) message.obj).longValue();
                    if (GuideManager.this.selectMainPath(longValue4)) {
                        GuideManager.this.mListenerHandler.sendMessage(GuideManager.this.mListenerHandler.obtainMessage(3008, Long.valueOf(longValue4)));
                        return;
                    }
                    return;
                case 2024:
                    GuideManager.this.stopNavi(((Boolean) message.obj).booleanValue());
                    return;
                case GuideManager.MSG_ON_OBTAIN_ASYNC_INFO /* 2025 */:
                    final XPObtainInfo xPObtainInfo = (XPObtainInfo) message.obj;
                    if (xPObtainInfo != null && GuideManager.this.mCurrentReqManeuverInfo.mWhat == xPObtainInfo.mWhat && GuideManager.this.mCurrentReqManeuverInfo.mReqID != xPObtainInfo.mReqID) {
                        L.Tag tag6 = GuideManager.TAG;
                        L.i(tag6, ">>> onObtainAsyncInfo but reqId != currentReqid currentid=" + GuideManager.this.mCurrentReqManeuverInfo.mReqID + " reqid=" + xPObtainInfo.mReqID);
                        return;
                    }
                    final XPManeuverInfo naviManeuverInfo = TBTManager.getInstance().getNaviManeuverInfo();
                    GuideManager.this.mListenerHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GuideManager.this.mNavigationInfoUpload != null) {
                                GuideManager.this.mNavigationInfoUpload.updateManeuverInfo(naviManeuverInfo, xPObtainInfo);
                            }
                        }
                    });
                    for (INaviListener iNaviListener : GuideManager.this.mNaviListeners) {
                        if (iNaviListener != null) {
                            iNaviListener.onObtainAsyncInfo(xPObtainInfo);
                        }
                    }
                    return;
                case 2026:
                    GuideManager.this.resetDataOnNaviStop();
                    return;
                case 2027:
                    GuideManager.this.stopNavi(false);
                    return;
                case 2028:
                    long longValue5 = ((Long) message.obj).longValue();
                    RouteResult routeResult3 = TBTManager.getInstance().getRouteResult(longValue5);
                    if (routeResult3 != null) {
                        GuideManager.this.reRouteOddSuccess(longValue5, routeResult3);
                        return;
                    }
                    return;
                case 2029:
                    GuideManager.this.reRouteOddError(((Long) message.obj).longValue());
                    return;
                case 2030:
                    boolean booleanValue = ((Boolean) message.obj).booleanValue();
                    EHPServiceManager.getInstance().setConfigValue(1, booleanValue ? 1 : 0);
                    EHPServiceManager.getInstance().setConfigValue(2, booleanValue ? 1 : 0);
                    return;
            }
        }
    };
    private long mOldPathID = 0;
    private XCountDownTimer.ITimerCallback mTimerCallback = new AnonymousClass3();
    private final GuideDataManager mGuideDataManager = new GuideDataManager();
    private final GuideServiceWrapper mGuideServiceWrapper = new GuideServiceWrapper(this);

    /* loaded from: classes3.dex */
    public interface IRerouteListener {
        void onRerouteError(long j, RouteResult routeResult);

        void onRerouteOddError(long j);

        void onRerouteOddSuccess(long j, RouteResult routeResult);

        void onRerouteSuccess(long j, RouteResult routeResult);

        void stopOnlineRouteRetryTimer();
    }

    /* loaded from: classes3.dex */
    public interface ISend2PhoneListener {
        void onFail();

        void onSuccess();
    }

    private int getSRTrafficEventType(int i) {
        if (i != 201) {
            switch (i) {
                case 101:
                case 102:
                case 103:
                case 104:
                    return 1;
                default:
                    return 0;
            }
        }
        return 2;
    }

    public void onDriveReport(String str, NaviStatisticsInfo naviStatisticsInfo) {
    }

    public void onShowDriveEventTip(ArrayList<DriveEventTip> arrayList) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements XCountDownTimer.ITimerCallback {
        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTick(long j) {
        }

        AnonymousClass3() {
        }

        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTimeOut() {
            L.i(GuideManager.TAG, ">>> onTimeOut navigation stop =");
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$GuideManager$3$KbPAJ5_E3l0FWgjcxwue5Qs7y1M
                @Override // java.lang.Runnable
                public final void run() {
                    GuideManager.AnonymousClass3.this.lambda$onTimeOut$0$GuideManager$3();
                }
            });
        }

        public /* synthetic */ void lambda$onTimeOut$0$GuideManager$3() {
            GuideManager.this.mNeedWaitGuideEndTts = false;
            GuideManager.this.mIsByUser = false;
            GuideManager.this.lambda$postNaviStop$0$GuideManager(TBTManager.getInstance().isSimulateGuidance() ? 1 : 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuideManager() {
        TTSManager.getInstance().init();
        TBTManager.getInstance().addRouteListener(this);
        this.mNaviListeners = new CopyOnWriteArrayList();
        this.mCruiseListeners = new CopyOnWriteArrayList();
        this.mSoundPlayListeners = new ArrayList();
        this.mRerouteListeners = new CopyOnWriteArrayList();
        this.mRerouteListenerMap = new HashMap();
        this.mRerouteRequestIds = new ArrayList();
        this.mRerouteParams = new ArrayList();
        this.mTimer = new XCountDownTimer(NavRestoreManager.WAKELOCK_TIMEOUT_10SEC, this.mTimerCallback);
        this.mPowerDisHelperContainer = new NaviPowerDisHelperContainer(this);
        this.mCurrentReqManeuverInfo = new XPObtainInfo();
        this.mCurrentReqManeuverInfo.mReqID = -1L;
        initTestReceiver();
        this.mNaviChargeReminder = new NaviChargeReminder();
        this.mNaviListeners.add(this.mNaviChargeReminder);
    }

    public void initTestReceiver() {
        if (DebugConfiguration.Debug.DEBUG_RECEIVER) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DebugConfiguration.RegisterAction.NAVI_LANE_TEST_ACTION);
            intentFilter.addAction(DebugConfiguration.RegisterAction.NAVI_ETA_REROUTE_TEST_ACTION);
            intentFilter.addAction(DebugConfiguration.RegisterAction.CRUISE_CONGESTION_TEST_ACTION);
            intentFilter.addAction(DebugConfiguration.RegisterAction.START_SEND_XPU_SIG);
            intentFilter.addAction(DebugConfiguration.RegisterAction.SEND_XPU_SIG_RD);
            intentFilter.addAction(DebugConfiguration.RegisterAction.SEND_XPU_SIG_SM);
            intentFilter.addAction(DebugConfiguration.RegisterAction.SEND_XPU_SIG);
            intentFilter.addAction(DebugConfiguration.RegisterAction.SEND_LANE_INFO);
            intentFilter.addAction(DebugConfiguration.RegisterAction.SHOW_HAPPY_ENDING);
            intentFilter.addAction(DebugConfiguration.RegisterAction.EHP_VERSION);
            ContextUtils.getContext().registerReceiver(new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.4
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (DebugConfiguration.RegisterAction.NAVI_LANE_TEST_ACTION.equals(intent.getAction())) {
                        int intExtra = intent.getIntExtra(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_LANE_COUNT, 0);
                        XPLaneInfo naviLaneInfo = GuideManager.this.mGuideDataManager.getNaviLaneInfo();
                        if (naviLaneInfo == null || naviLaneInfo.mFrontLane == null || naviLaneInfo.mFrontLane.length != intExtra) {
                            XPLaneInfo xPLaneInfo = new XPLaneInfo();
                            xPLaneInfo.mBackLane = new int[intExtra];
                            xPLaneInfo.mFrontLane = new int[intExtra];
                            for (int i = 0; i < intExtra; i++) {
                                xPLaneInfo.mFrontLane[i] = 0;
                                xPLaneInfo.mBackLane[i] = 0;
                            }
                            GuideManager.this.onUpdateNaviLaneInfo(xPLaneInfo, true);
                        }
                    } else if (DebugConfiguration.RegisterAction.NAVI_ETA_REROUTE_TEST_ACTION.equals(intent.getAction())) {
                        int intExtra2 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_ETA_REROUTE_TYPE, -1);
                        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
                        XPPoiInfo xPPoiInfo = new XPPoiInfo();
                        xPPoiInfo.setDisplayLon(116.40417d);
                        xPPoiInfo.setDisplayLat(39.909652d);
                        RouteParams build = new RouteParams.Builder().setStartInfo(startPOIFromCurrent).setEndInfo(xPPoiInfo).setRerouteType(9).setRouteLevel(2).build();
                        build.mIsFakeReroute = true;
                        GuideManager.this.requestReroute(build, null);
                        build.mFakeRerouteType = intExtra2;
                    } else if (DebugConfiguration.RegisterAction.CRUISE_CONGESTION_TEST_ACTION.equals(intent.getAction())) {
                        int intExtra3 = intent.getIntExtra("status", 0);
                        String stringExtra = intent.getStringExtra(DebugConfiguration.DebugActionExtra.CRUISE_CONGESTION_ROAD_NAME);
                        int intExtra4 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.CRUISE_CONGESTION_LENGTH, 0);
                        int intExtra5 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.CRUISE_CONGESTION_TIME, 0);
                        XPCruiseCongestionInfo xPCruiseCongestionInfo = new XPCruiseCongestionInfo();
                        xPCruiseCongestionInfo.mCongestionStatus = intExtra3;
                        xPCruiseCongestionInfo.mRoadName = stringExtra;
                        xPCruiseCongestionInfo.mLength = intExtra4;
                        xPCruiseCongestionInfo.mEtaTime = intExtra5;
                        GuideManager.this.onUpdateCruiseCongestionInfo(xPCruiseCongestionInfo);
                    } else if (DebugConfiguration.RegisterAction.START_SEND_XPU_SIG.equals(intent.getAction())) {
                        ProtoSimulator.getInstance().startModify(intent.getBooleanExtra("start", false));
                    } else if (DebugConfiguration.RegisterAction.SEND_XPU_SIG_RD.equals(intent.getAction())) {
                        ProtoSimulator.getInstance().modifyRd(intent.getIntExtra(DebugConfiguration.DebugActionExtra.TEST_XPU_SIG_RD, -1), intent.getIntExtra("value", -1));
                    } else if (DebugConfiguration.RegisterAction.SEND_XPU_SIG_SM.equals(intent.getAction())) {
                        ProtoSimulator.getInstance().modifySm(intent.getIntExtra(DebugConfiguration.DebugActionExtra.TEST_XPU_SIG_SM, -1), intent.getIntExtra("value", -1));
                    } else if (DebugConfiguration.RegisterAction.SEND_XPU_SIG.equals(intent.getAction())) {
                        String stringExtra2 = intent.getStringExtra(DebugConfiguration.DebugActionExtra.TEST_XPU_SIG_TYPE);
                        int intExtra6 = intent.getIntExtra("value", -1);
                        if (TextUtils.equals(stringExtra2, DebugConfiguration.DebugXpuSigType.SIG_TYPE_DISPLAY_ST)) {
                            ProtoSimulator.getInstance().modifyDisplaySt(intExtra6);
                        }
                    } else if (DebugConfiguration.RegisterAction.SEND_LANE_INFO.equals(intent.getAction())) {
                        boolean booleanExtra = intent.getBooleanExtra(DebugConfiguration.DebugActionExtra.TEST_LANE_INFO_IS_NAVI, false);
                        int intExtra7 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.TEST_LANE_INFO_BACK_TYPE, -1);
                        int intExtra8 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.TEST_LANE_INFO_FRONT_TYPE, -1);
                        if (-1 == intExtra7) {
                            if (booleanExtra) {
                                GuideManager.this.onUpdateNaviLaneInfo(null, false);
                                return;
                            } else {
                                GuideManager.this.onUpdateCruiseLaneInfo(null, false);
                                return;
                            }
                        }
                        XPLaneInfo xPLaneInfo2 = new XPLaneInfo();
                        xPLaneInfo2.mBackLane = new int[1];
                        xPLaneInfo2.mFrontLane = new int[1];
                        xPLaneInfo2.mBackLane[0] = intExtra7;
                        xPLaneInfo2.mFrontLane[0] = intExtra8;
                        if (booleanExtra) {
                            GuideManager.this.onUpdateNaviLaneInfo(xPLaneInfo2, true);
                        } else {
                            GuideManager.this.onUpdateCruiseLaneInfo(xPLaneInfo2, true);
                        }
                    } else if (DebugConfiguration.RegisterAction.SHOW_HAPPY_ENDING.equals(intent.getAction())) {
                        boolean booleanExtra2 = intent.getBooleanExtra(DebugConfiguration.DebugActionExtra.HAPPY_ENDING_AI, false);
                        int intExtra9 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.HAPPY_ENDING_TRAFFIC_LIGHTS, -1);
                        int intExtra10 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.HAPPY_ENDING_LANE_CHANGE, -1);
                        int intExtra11 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.HAPPY_ENDING_ROUNDABOUT, -1);
                        int intExtra12 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.HAPPY_ENDING_DETOUR_OBSTACLE, -1);
                        int intExtra13 = intent.getIntExtra(DebugConfiguration.DebugActionExtra.HAPPY_ENDING_TOTAL_MILEAGE, -1);
                        HappyEnding happyEnding = new HappyEnding(intExtra9, intExtra10, intExtra11, intExtra12, intExtra13);
                        if (intExtra9 < 0 && intExtra10 < 0 && intExtra11 < 0 && intExtra12 < 0 && intExtra13 > 0) {
                            LaneServiceManager.getInstance().setTotalMileage(intExtra13);
                        } else if (booleanExtra2) {
                            LaneServiceManager.getInstance().pushAiMsg(happyEnding);
                        } else {
                            LaneServiceManager.getInstance().showHappyEnding(happyEnding);
                        }
                    } else if (DebugConfiguration.RegisterAction.EHP_VERSION.equals(intent.getAction())) {
                        L.i(GuideManager.TAG, "EHP_VERSION called");
                        LaneServiceManager.getInstance().setEHPVersion(intent.getStringExtra(DebugConfiguration.DebugActionExtra.EHP_VERSION));
                    }
                }
            }, intentFilter);
        }
    }

    public GuideService getGuideService() {
        return this.mGuideServiceWrapper.getGuideService();
    }

    public boolean initGuideService(String str) {
        this.mHistoryFileDir = str;
        if (this.mRecommendParkingHelper == null) {
            this.mRecommendParkingHelper = new RecommendParkingHelper();
        }
        return this.mGuideServiceWrapper.initGuide();
    }

    public RecommendParkingHelper getRecommendParkingHelper() {
        return this.mRecommendParkingHelper;
    }

    public synchronized void addNaviListener(INaviListener iNaviListener) {
        if (!this.mNaviListeners.contains(iNaviListener)) {
            this.mNaviListeners.add(iNaviListener);
        }
    }

    public synchronized void removeNaviListener(INaviListener iNaviListener) {
        this.mNaviListeners.remove(iNaviListener);
    }

    public synchronized void addCruiseListener(ICruiseListener iCruiseListener) {
        if (!this.mCruiseListeners.contains(iCruiseListener)) {
            this.mCruiseListeners.add(iCruiseListener);
        }
    }

    public synchronized void removeCruiseListener(ICruiseListener iCruiseListener) {
        this.mCruiseListeners.remove(iCruiseListener);
    }

    public synchronized void addSoundPlayListener(ISoundPlayListener iSoundPlayListener) {
        if (!this.mSoundPlayListeners.contains(iSoundPlayListener)) {
            this.mSoundPlayListeners.add(iSoundPlayListener);
        }
    }

    public synchronized void removeSoundPlayListener(ISoundPlayListener iSoundPlayListener) {
        this.mSoundPlayListeners.remove(iSoundPlayListener);
    }

    public synchronized void addRerouteListener(IRerouteListener iRerouteListener) {
        if (!this.mRerouteListeners.contains(iRerouteListener)) {
            this.mRerouteListeners.add(iRerouteListener);
        }
    }

    public synchronized void removeRerouteListener(IRerouteListener iRerouteListener) {
        this.mRerouteListeners.remove(iRerouteListener);
    }

    public void setVehicleId(String str) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2015, str));
    }

    public void setETARestriction(boolean z) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2016, Boolean.valueOf(z)));
    }

    public void startNavi(int i) {
        this.mTimer.stop();
        this.mIsNaviStop = false;
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2001, Integer.valueOf(i)));
    }

    public void stopNavi(boolean z) {
        L.i(TAG, ">>>> stopNavi");
        EHPServiceManager.getInstance().setAutoUpdateRoute(false);
        this.mGuideServiceWrapper.stopNavi(TBTManager.getInstance().getNaviId());
        this.mIsStopDelete = true;
        this.mIsByUser = z;
    }

    public void stopNaviByUser(boolean z) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2024, Boolean.valueOf(z)));
    }

    public void setCurrentNaviId(long j, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setCurrentNaviId requestId=" + j + " routeType=" + i);
        }
        this.mGuideDataManager.setCurrentNaviId(j, i);
    }

    public long getCurrentNaviId() {
        return this.mGuideDataManager.getCurrentNaviId();
    }

    public long getCurrentNaviPathId() {
        return this.mGuideDataManager.getMainPathId();
    }

    public int getCurrentNaviPathIndex() {
        return this.mGuideDataManager.getCurrentNaviPathIndex();
    }

    public IPathResult getCurrentNaviPathResult() {
        return this.mGuideDataManager.getCurrentNaviPathResult();
    }

    public IPathResult getRecommendNaviPathResult() {
        return this.mGuideDataManager.getRecommendNaviPathResult();
    }

    public long getRecommendNaviId() {
        return this.mGuideDataManager.getRecommendNaviId();
    }

    public void setRecommendNaviId(long j) {
        this.mGuideDataManager.setRecommendNaviId(j);
    }

    public IVariantPath getOldNaviVariantPath() {
        return this.mGuideDataManager.getOldNaviVariantPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePathIndex(int i) {
        long mainPathId = this.mGuideDataManager.getMainPathId();
        this.mGuideDataManager.updatePathIndex(i);
        long mainPathId2 = this.mGuideDataManager.getMainPathId();
        if (mainPathId != mainPathId2) {
            Handler handler = this.mListenerHandler;
            handler.sendMessage(handler.obtainMessage(3010));
            if (TBTManager.getInstance().getMap() != null) {
                TBTManager.getInstance().getMap().getBizControlManager().clearLaneGuideRouteOverlay();
            }
        }
        L.Tag tag = TAG;
        L.i(tag, ">>> updatePathIndex oldPathId=" + mainPathId + " currentPathId=" + mainPathId2);
    }

    public XPPoiInfo getLastNaviEndInfo() {
        return this.mGuideDataManager.getLastNaviEndInfo();
    }

    public void resetLastNaviEndInfo() {
        this.mGuideDataManager.resetLastNaviEndInfo();
    }

    public XPPoiInfo getLastEndInfoForDataLog() {
        return this.mGuideDataManager.getLastEndInfoForDataLog();
    }

    public float getRouteRemainDistForDataLog() {
        return this.mGuideDataManager.getRouteRemainDistForDataLog();
    }

    public void asyncManeuverInfo(XPAsyncInfo xPAsyncInfo) {
        if (L.ENABLE) {
            L.d(TAG, ">>>> asyncManeuverInfo ");
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2004, xPAsyncInfo));
    }

    public void playNaviManual() {
        if (L.ENABLE) {
            L.d(TAG, ">>>> playNaviManual ");
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2005));
    }

    public void selectMainPathId(long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> selectMainPathId pathId=" + j);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2009, Long.valueOf(j)));
    }

    public void pauseSimulation() {
        if (L.ENABLE) {
            L.d(TAG, ">>>> pauseSimulation ");
        }
        this.mGuideDataManager.updateSimulationSpeed(0);
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2006, 0));
    }

    public void resumeSimulation() {
        if (L.ENABLE) {
            L.d(TAG, ">>>> resumeSimulation ");
        }
        this.mGuideDataManager.updateSimulationSpeed(60);
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2006, 60));
    }

    public void adjustSimulation(boolean z) {
        int decSimulationSpeed;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> adjustSimulation isSpeedUp = " + z);
        }
        if (z) {
            decSimulationSpeed = this.mGuideDataManager.incSimulationSpeed();
        } else {
            decSimulationSpeed = this.mGuideDataManager.decSimulationSpeed();
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2006, Integer.valueOf(decSimulationSpeed)));
    }

    public int getSimulationSpeed() {
        return this.mGuideDataManager.getSimulationSpeed();
    }

    public void setNaviInfoCount(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setNaviInfoCount count = " + i);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2010, Integer.valueOf(i)));
    }

    public void setCruiseAheadTraffic(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setCruiseAheadTraffic isOpen = " + z);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2011, Boolean.valueOf(z)));
    }

    public void setCruiseOpenCamera(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setCruiseOpenCamera state = " + i);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2012, Integer.valueOf(i)));
    }

    public void setPlayStyle(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setPlayStyle style = " + i);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2013, Integer.valueOf(i)));
    }

    public void setDayNightMode(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setDayNightMode state = " + i);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2014, Integer.valueOf(i)));
    }

    public void setEnter3D(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setEnterThree3D isOpen = " + z);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2021, Boolean.valueOf(z)));
    }

    public long requestReroute(RouteParams routeParams, IRerouteListener iRerouteListener) {
        L.Tag tag = TAG;
        L.i(tag, ">>>> requestReroute params=" + routeParams.toString() + " listener =" + iRerouteListener);
        RouteParams popRerouteParams = popRerouteParams();
        while (popRerouteParams != null) {
            if (popRerouteParams.mRerouteOption != null) {
                L.Tag tag2 = TAG;
                L.i(tag2, "requestReroute routeParams.mRerouteOption=" + popRerouteParams.mRerouteOption);
                RouteOption.destroy(popRerouteParams.mRerouteOption);
                popRerouteParams.mRerouteOption = null;
            }
            popRerouteParams = popRerouteParams();
        }
        long requestRouteReroute = TBTManager.getInstance().requestRouteReroute(routeParams, null);
        if (iRerouteListener != null) {
            addCurrentCallback(requestRouteReroute, iRerouteListener);
        }
        addCurrentRequestId(requestRouteReroute);
        return requestRouteReroute;
    }

    private long requestRouteByOnReroute(RouteParams routeParams) {
        L.Tag tag = TAG;
        L.i(tag, ">>>> requestRouteByOnReroute params=" + routeParams.toString());
        long requestRouteReroute = TBTManager.getInstance().requestRouteReroute(routeParams, null);
        addCurrentRequestId(requestRouteReroute);
        return requestRouteReroute;
    }

    private long requestRerouteNext() {
        RouteParams popRerouteParams = popRerouteParams();
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(">>>> requestRerouteNext params=");
        sb.append(popRerouteParams != null ? popRerouteParams.toString() : "null");
        L.i(tag, sb.toString());
        if (popRerouteParams != null) {
            RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
            if (currentNaviRouteParams != null) {
                popRerouteParams.mRouteCalcType = currentNaviRouteParams.mRouteCalcType;
                popRerouteParams.mConstrainCode = currentNaviRouteParams.mConstrainCode;
            }
            L.Tag tag2 = TAG;
            L.i(tag2, ">>>> requestRerouteNext params=" + popRerouteParams.toString());
            long requestRouteByOnReroute = requestRouteByOnReroute(popRerouteParams);
            for (INaviListener iNaviListener : this.mNaviListeners) {
                if (iNaviListener != null) {
                    iNaviListener.onReroute(popRerouteParams);
                }
            }
            return requestRouteByOnReroute;
        }
        return -1L;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteSuccess(long j, RouteResult routeResult) {
        L.Tag tag = TAG;
        L.i(tag, ">>>> onNewRouteSuccess requestId = " + j + " routeResult type =" + routeResult.mRouteType);
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2019, Long.valueOf(j)));
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteError(long j, RouteResult routeResult) {
        L.Tag tag = TAG;
        L.e(tag, ">>>> onNewRouteError requestId = " + j + " routeResult type =" + routeResult.mRouteType);
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2020, Long.valueOf(j)));
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteOddSuccess(long j, RouteResult routeResult) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2028, Long.valueOf(j)));
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
    public void onNewRouteOddError(long j) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2029, Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void reRouteSuccess(long r11, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult r13) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.reRouteSuccess(long, com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reRouteError(long j, RouteResult routeResult) {
        if (this.mRerouteRequestIds.contains(Long.valueOf(j))) {
            L.Tag tag = TAG;
            L.i(tag, ">>>> reRouteError requestId = " + j + " routeResult errorcode =" + routeResult.mErrorCode + " currentState=" + TBTManager.getInstance().getCurrentStatus());
            if (TBTManager.getInstance().getCurrentStatus() == 0) {
                this.mRerouteRequestIds.clear();
                return;
            }
            Handler handler = this.mListenerHandler;
            handler.sendMessage(handler.obtainMessage(3006, Long.valueOf(j)));
            if (routeResult.mErrorCode != 37) {
                requestRerouteNext();
                removeCurrentRequestId(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reRouteOddSuccess(long j, RouteResult routeResult) {
        Handler handler = this.mListenerHandler;
        handler.sendMessage(handler.obtainMessage(3014, Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reRouteOddError(long j) {
        Handler handler = this.mListenerHandler;
        handler.sendMessage(handler.obtainMessage(3015, Long.valueOf(j)));
    }

    private void refreshGuideData(long j, int i, int i2) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2017, i, i2, Long.valueOf(j)));
    }

    private void clearGuideRouteOverlay() {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2007));
    }

    private void speakReroute(int i) {
        if (i == 14 || i == 11 || i == 13) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "shutup TTS for reroute");
        }
        TTSProxy.getInstance().shutUp(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRerouteError(long j, RouteResult routeResult) {
        IRerouteListener iRerouteListener = this.mRerouteListenerMap.get(Long.valueOf(j));
        if (iRerouteListener != null) {
            iRerouteListener.onRerouteError(j, routeResult);
            if (routeResult.mErrorCode != 37) {
                removeCurrentCallback(j);
            }
        }
        for (IRerouteListener iRerouteListener2 : this.mRerouteListeners) {
            if (iRerouteListener2 != null) {
                iRerouteListener2.onRerouteError(j, routeResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRerouteSuccess(long j, RouteResult routeResult) {
        IRerouteListener iRerouteListener = this.mRerouteListenerMap.get(Long.valueOf(j));
        if (iRerouteListener != null) {
            iRerouteListener.onRerouteSuccess(j, routeResult);
            removeCurrentCallback(j);
        }
        for (IRerouteListener iRerouteListener2 : this.mRerouteListeners) {
            if (iRerouteListener2 != null) {
                iRerouteListener2.onRerouteSuccess(j, routeResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRerouteOddError(long j) {
        for (IRerouteListener iRerouteListener : this.mRerouteListeners) {
            if (iRerouteListener != null) {
                iRerouteListener.onRerouteOddError(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRerouteOddSuccess(long j, RouteResult routeResult) {
        for (IRerouteListener iRerouteListener : this.mRerouteListeners) {
            if (iRerouteListener != null) {
                iRerouteListener.onRerouteOddSuccess(j, routeResult);
            }
        }
    }

    private synchronized void addCurrentCallback(long j, IRerouteListener iRerouteListener) {
        this.mRerouteListenerMap.put(Long.valueOf(j), iRerouteListener);
    }

    private synchronized void removeCurrentCallback(long j) {
        this.mRerouteListenerMap.remove(Long.valueOf(j));
    }

    private synchronized void addCurrentRequestId(long j) {
        this.mRerouteRequestIds.add(Long.valueOf(j));
    }

    private synchronized void removeCurrentRequestId(long j) {
        this.mRerouteRequestIds.remove(Long.valueOf(j));
    }

    private synchronized void addRerouteParams(RouteParams routeParams) {
        this.mRerouteParams.add(routeParams);
    }

    private synchronized RouteParams popRerouteParams() {
        RouteParams routeParams;
        routeParams = null;
        if (this.mRerouteParams.size() > 0) {
            routeParams = this.mRerouteParams.get(0);
            this.mRerouteParams.remove(0);
        }
        return routeParams;
    }

    public void onPlayTTS(final XPSoundInfo xPSoundInfo) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.5
            @Override // java.lang.Runnable
            public void run() {
                GuideManager.this.playTTS(xPSoundInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playTTS(final XPSoundInfo xPSoundInfo) {
        if (xPSoundInfo == null || TextUtils.isEmpty(xPSoundInfo.mText)) {
            L.w(TAG, "playTTS: soundInfo is null or soundInfo.text is empty!!! ");
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "playTTS:" + NaviLogUtil.dumpTTS(xPSoundInfo));
        } else {
            L.Tag tag2 = TAG;
            L.i(tag2, "playTTS text:" + xPSoundInfo.mText + " type:" + xPSoundInfo.mSoundType + ",subType:" + xPSoundInfo.mSubSoundType + ", rangeType:" + xPSoundInfo.mRangeType + ", driveMode:" + SRNaviManager.getInstance().getDriveMode());
        }
        if (TTSManager.getInstance().filterTtsByMode(xPSoundInfo.mSoundType, xPSoundInfo.mSubSoundType, xPSoundInfo.mRangeType, xPSoundInfo.mText)) {
            String modifyBLTTSContent = modifyBLTTSContent(xPSoundInfo);
            if (TextUtils.isEmpty(modifyBLTTSContent)) {
                if (L.ENABLE) {
                    L.d(TAG, "playTTS drop empty tts");
                    return;
                }
                return;
            }
            String speak = TTSProxy.getInstance().speak(modifyBLTTSContent, new ISpeechCallback() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.6
                @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback
                public void onReceived(byte[] bArr) {
                }

                @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback
                public void onSpeechStart(String str) {
                    if (L.ENABLE) {
                        L.Tag tag3 = GuideManager.TAG;
                        L.d(tag3, "===>playTTS onSpeechStart ttsId:" + str);
                    }
                }

                @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback
                public void onSpeechFinish(String str, int i) {
                    if (L.ENABLE) {
                        L.Tag tag3 = GuideManager.TAG;
                        L.d(tag3, "===>playTTS onSpeechFinish ttsId:" + str + ",status:" + i);
                    }
                    if (GuideManager.this.isNaviEndTTS(xPSoundInfo.mText)) {
                        GuideManager.this.mNeedWaitGuideEndTts = false;
                        if (L.ENABLE) {
                            L.d(GuideManager.TAG, "playTTS finished，stop navi！");
                        }
                        GuideManager.this.tts2NavStop();
                    }
                }

                @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback
                public void onError(String str, String str2) {
                    L.Tag tag3 = GuideManager.TAG;
                    L.e(tag3, "===>playTTS onError ttsId:" + str + ", error:" + str2);
                    if (GuideManager.this.isNaviEndTTS(xPSoundInfo.mText)) {
                        GuideManager.this.mNeedWaitGuideEndTts = false;
                        GuideManager.this.tts2NavStop();
                    }
                }
            });
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "playTTS ttsId:" + speak);
            }
            if (speak == null && isNaviEndTTS(xPSoundInfo.mText)) {
                this.mNeedWaitGuideEndTts = false;
                tts2NavStop();
                return;
            }
            return;
        }
        L.Tag tag4 = TAG;
        L.i(tag4, ">>>playTTS is not play tts cur style:" + TTSManager.getInstance().getCurrentBroadcastStyle() + " cur ngp style:" + TTSManager.getInstance().getCurrentNgpBroadcastStyle() + " cur driveMode: " + SRNaviManager.getInstance().getDriveMode());
        if (isNaviEndTTS(xPSoundInfo.mText)) {
            this.mNeedWaitGuideEndTts = false;
            tts2NavStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tts2NavStop() {
        this.mTimer.stop();
        if (3 == TBTManager.getInstance().getCurrentStatus()) {
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.7
                @Override // java.lang.Runnable
                public void run() {
                    if (3 == TBTManager.getInstance().getCurrentStatus()) {
                        GuideManager.this.mIsByUser = false;
                        GuideManager.this.lambda$postNaviStop$0$GuideManager(TBTManager.getInstance().isSimulateGuidance() ? 1 : 0, false);
                    }
                }
            }, 500L);
        }
    }

    public void onUpdateCruiseLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, ">>> onUpdateCruiseLaneInfo isShow=" + z);
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateCruiseLaneInfo(xPLaneInfo, z);
        }
        this.mGuideDataManager.setCruiseLaneInfo(xPLaneInfo);
        for (ICruiseListener iCruiseListener : this.mCruiseListeners) {
            if (iCruiseListener != null) {
                iCruiseListener.onUpdateCruiseLaneInfo(xPLaneInfo, z);
            }
        }
    }

    public void onUpdateCruiseCongestionInfo(XPCruiseCongestionInfo xPCruiseCongestionInfo) {
        L.Tag tag = TAG;
        L.i(tag, ">>> onUpdateCruiseCongestionInfo info=" + xPCruiseCongestionInfo);
        this.mGuideDataManager.setCruiseCongestionInfo(xPCruiseCongestionInfo);
        for (ICruiseListener iCruiseListener : this.mCruiseListeners) {
            if (iCruiseListener != null) {
                iCruiseListener.onUpdateCruiseCongestionInfo(xPCruiseCongestionInfo);
            }
        }
    }

    public void onUpdateCruiseInfo(XPCruiseInfo xPCruiseInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(">>> onUpdateCruiseInfo info=");
            sb.append(xPCruiseInfo);
            sb.append(" roadName=");
            sb.append(xPCruiseInfo == null ? " " : xPCruiseInfo.mRoadName);
            L.d(tag, sb.toString());
        }
        this.mGuideDataManager.setXPCruiseInfo(xPCruiseInfo);
        for (ICruiseListener iCruiseListener : this.mCruiseListeners) {
            if (iCruiseListener != null) {
                iCruiseListener.onUpdateCruiseInfo(xPCruiseInfo);
            }
        }
    }

    public void onUpdateCruiseFacility(List<XPFacilityInfo> list) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>> onUpdateCruiseFacility info=" + list);
        }
        this.mGuideDataManager.setXPFacilityInfos(list);
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateCruiseCameraInfo(list);
        }
        for (ICruiseListener iCruiseListener : this.mCruiseListeners) {
            if (iCruiseListener != null) {
                iCruiseListener.onUpdateCruiseFacility(list);
            }
        }
    }

    public List<XPFacilityInfo> getNaviSapas() {
        return this.mGuideDataManager.getNaviSapas();
    }

    public List<XPFacilityInfo> getXPFacilityInfos() {
        return this.mGuideDataManager.getXPFacilityInfos();
    }

    public XPCruiseInfo getXPCruiseInfo() {
        return this.mGuideDataManager.getXPCruiseInfo();
    }

    public void setXPCruiseInfo(XPCruiseInfo xPCruiseInfo) {
        this.mGuideDataManager.setXPCruiseInfo(xPCruiseInfo);
    }

    public XPLaneInfo getCruiseLaneInfo() {
        return this.mGuideDataManager.getCruiseLaneInfo();
    }

    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
        XPBaseLinkAccessor linkAccessor;
        StringBuilder sb = new StringBuilder("onUpdateNaviInfo size: ");
        if (list != null) {
            sb.append(list.size());
            sb.append(", ");
            for (XPNaviInfo xPNaviInfo : list) {
                sb.append(xPNaviInfo.mPathID);
                sb.append("; ");
            }
        } else {
            sb.append("0");
        }
        if (L.ENABLE) {
            L.d(TAG, sb.toString());
        }
        if (list != null && list.size() > 0) {
            XPNaviInfo xPNaviInfo2 = list.get(0);
            this.mGuideDataManager.setNaviInfo(xPNaviInfo2);
            this.mGuideDataManager.setNaviInfoList(list);
            INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
            if (iNavigationInfoUploadStrategy != null) {
                iNavigationInfoUploadStrategy.updateNaviInfo(xPNaviInfo2, this.mGuideDataManager.getNaviExitDirectionInfo());
            }
            LaneServiceManager.getInstance().updateNaviInfo(xPNaviInfo2);
            this.mRecommendParkingHelper.onNaviInfoUpdate(xPNaviInfo2);
            long j = xPNaviInfo2.mPathID;
            int currentStatus = TBTManager.getInstance().getCurrentStatus();
            if (currentStatus == 1 && this.mOldPathID != j) {
                ViasHelper.getInstance().updateViaDist(list, j);
                this.mOldPathID = j;
            } else if (currentStatus == 2) {
                ViasHelper.getInstance().updateViaDist(list, false);
            }
            if (this.mOldSegIdx != xPNaviInfo2.mCurSegIdx) {
                this.mOldSegIdx = xPNaviInfo2.mCurSegIdx;
                XPDrivePathAccessor drivePathAccessor = getCurrentNaviPathResult().getPath(xPNaviInfo2.mPathID).getDrivePathAccessor();
                if (drivePathAccessor != null) {
                    XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(xPNaviInfo2.mCurSegIdx);
                    if (segmentAccessor != null && (linkAccessor = segmentAccessor.getLinkAccessor(xPNaviInfo2.mCurLinkIdx)) != null) {
                        if (L.ENABLE) {
                            L.Tag tag = TAG;
                            L.d(tag, "line length: " + linkAccessor.getLength() + " LinkRemainDist: " + xPNaviInfo2.mLinkRemainDist + " CurSegIdx: " + xPNaviInfo2.mCurSegIdx);
                        }
                        if (linkAccessor.getLength() - xPNaviInfo2.mLinkRemainDist <= 3 && TBTManager.getInstance().getMap() != null) {
                            TBTManager.getInstance().getMap().getBizControlManager().setViewPostureEvent(3, 4);
                        }
                    }
                    drivePathAccessor.recycle();
                }
            }
            if (this.mGuideDataManager.getNaviManeuverInfo() == null && xPNaviInfo2.mNaviInfoData != null && xPNaviInfo2.mNaviInfoData.length > xPNaviInfo2.mNaviInfoFlag && xPNaviInfo2.mNaviInfoData[xPNaviInfo2.mNaviInfoFlag] != null) {
                L.Tag tag2 = TAG;
                L.i(tag2, "onUpdateNaviInfo maneuverInfo id = " + xPNaviInfo2.mNaviInfoData[xPNaviInfo2.mNaviInfoFlag].mManeuverID);
                XPManeuverInfo xPManeuverInfo = new XPManeuverInfo();
                xPManeuverInfo.mPathID = xPNaviInfo2.mPathID;
                xPManeuverInfo.mSegmentIndex = (long) xPNaviInfo2.mCurSegIdx;
                xPManeuverInfo.mManeuverID = xPNaviInfo2.mNaviInfoData[xPNaviInfo2.mNaviInfoFlag].mManeuverID;
                onShowNaviManeuver(xPManeuverInfo);
            }
        }
        updateNaviPdHelper(list);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateNaviInfo(list);
            }
        }
    }

    public void onUpdateExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
        this.mGuideDataManager.setNaviExitDirectionInfo(xPExitDirectionInfo);
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateNaviInfo(getNaviInfo(), xPExitDirectionInfo);
        }
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateExitDirectionInfo(xPExitDirectionInfo);
            }
        }
    }

    public void onUpdateCrossImage(XPCrossImageInfo xPCrossImageInfo, int i, boolean z) {
        this.mGuideDataManager.setNaviCrossImageInfo(xPCrossImageInfo);
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateCrossInfo(xPCrossImageInfo, i, z);
        }
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateCrossImage(xPCrossImageInfo, i, z);
            }
        }
    }

    public void onUpdateNaviLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
        this.mGuideDataManager.setNaviLaneInfo(xPLaneInfo);
        if (xPLaneInfo == null && this.mGuideDataManager.getXPTollGateInfo() != null) {
            L.i(TAG, "ignore empty xpLaneInfo due to xpTollGateInfo is not null!");
            return;
        }
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateLaneInfo(xPLaneInfo, null, z);
        }
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateNaviLaneInfo(xPLaneInfo, z);
            }
        }
    }

    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo) {
        CloudRouteDataHelper.getInstance().checkAndReplaceViaInfo(xPManeuverInfo);
        this.mGuideDataManager.setNaviManeuverInfo(xPManeuverInfo);
        asyncManeuverInfo(xPManeuverInfo);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onShowNaviManeuver(xPManeuverInfo);
            }
        }
    }

    public void initAsyncInfoColor(int i, int i2, int i3) {
        this.mAsyncInfoBackColor = i;
        this.mAsyncInfoRoadColor = i2;
        this.mAsyncInfoArrowColor = i3;
    }

    public int getManeuverBackColor() {
        return this.mAsyncInfoBackColor;
    }

    public int getManeuverRoadColor() {
        return this.mAsyncInfoRoadColor;
    }

    public int getManeuverArrowColor() {
        return this.mAsyncInfoArrowColor;
    }

    public void asyncManeuverInfo(XPManeuverInfo xPManeuverInfo) {
        XPManeuverConfig xPManeuverConfig = new XPManeuverConfig();
        XPAsyncInfo xPAsyncInfo = new XPAsyncInfo();
        xPManeuverConfig.mWidth = 90;
        xPManeuverConfig.mHeight = 90;
        xPManeuverConfig.mBackColor = this.mAsyncInfoBackColor;
        xPManeuverConfig.mRoadColor = this.mAsyncInfoRoadColor;
        xPManeuverConfig.mArrowColor = this.mAsyncInfoArrowColor;
        xPManeuverConfig.mPathID = xPManeuverInfo.mPathID;
        xPManeuverConfig.mManeuverId = xPManeuverInfo.mManeuverID;
        xPManeuverConfig.mSegmentIdx = xPManeuverInfo.mSegmentIndex;
        xPAsyncInfo.mObject = xPManeuverConfig;
        xPAsyncInfo.mWhat = 2;
        asyncManeuverInfo(xPAsyncInfo);
    }

    public void onShowNaviCamera(List<XPCameraInfo> list) {
        this.mGuideDataManager.setNaviCameras(list);
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateNormalCameraInfo(list);
        }
        sendCurrentSpeedCamera2Xpu();
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onShowNaviCamera(list);
            }
        }
    }

    public void onShowNaviIntervalCamera(List<XPCameraInfo> list) {
        this.mGuideDataManager.setNaviIntervalCameras(list);
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateIntervalCameraInfo(list);
        }
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onShowNaviIntervalCamera(list);
            }
        }
    }

    public void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list) {
        this.mGuideDataManager.setNaviIntervalDynamicCameras(list);
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateIntervalCameraInfo(list);
        }
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateIntervalCameraDynamicInfo(list);
            }
        }
    }

    public void onUpdateSAPA(List<XPFacilityInfo> list) {
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateSapaInfo(list);
        }
        this.mGuideDataManager.setNaviSapas(list);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateSAPA(list);
            }
        }
    }

    public void onUpdateTMCLightBar(List<ILightBarInfo> list, int i, boolean z) {
        this.mGuideDataManager.setLightBarInfos(list);
        this.mGuideDataManager.setLightBarPassedIndex(i);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateTMCLightBar(list, i, z);
            }
        }
    }

    public void onUpdateTMCCongestionInfo(XPNaviCongestionInfo xPNaviCongestionInfo) {
        this.mGuideDataManager.setNaviCongestionInfo(xPNaviCongestionInfo);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateTMCCongestionInfo(xPNaviCongestionInfo);
            }
        }
    }

    public void onSuggestChangePath(long j, long j2, long j3) {
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onSuggestChangePath(j, j2, j3);
            }
        }
    }

    public void onUpdateTREvent(List<XPPathTrafficEventInfo> list, int i) {
        if (L.ENABLE) {
            L.d(TAG, "onUpdateTREvent");
        }
        this.mGuideDataManager.setPathTrafficEventInfos(list);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateTREvent(list, i);
            }
        }
        if (!CarFeatureManager.INSTANCE.isTrafficEventFromNaviToXpuEnable() || list == null || list.isEmpty()) {
            return;
        }
        for (XPPathTrafficEventInfo xPPathTrafficEventInfo : list) {
            LinkedList linkedList = new LinkedList();
            if (TBTManager.getInstance().getCurrentNaviPathId() == xPPathTrafficEventInfo.mPathID && xPPathTrafficEventInfo.mEventInfoArray != null) {
                for (XPTrafficEventInfo xPTrafficEventInfo : xPPathTrafficEventInfo.mEventInfoArray) {
                    if (TrafficEventHelper.getInstance().isEventInfoForXpu(xPTrafficEventInfo.mType)) {
                        linkedList.add(xPTrafficEventInfo);
                    }
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                TrafficEventHelper.getInstance().startCheckTrafficEventListForXpu(linkedList);
                return;
            }
        }
    }

    public void onUpdateCruiseEvent(XPCruiseEventInfo xPCruiseEventInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onUpdateCruiseEvent, cruiseEventInfo mEventType = " + xPCruiseEventInfo.mEventType);
        }
        if (CarFeatureManager.INSTANCE.isTrafficEventFromNaviToXpuEnable() && xPCruiseEventInfo != null && TrafficEventHelper.getInstance().isEventInfoForXpu(xPCruiseEventInfo.mEventType)) {
            TrafficEventHelper.getInstance().startCheckingCruiseEventStatusForXpu(xPCruiseEventInfo);
        }
    }

    public void onUpdateTRPlayView(XPRouteTrafficEventInfo xPRouteTrafficEventInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateTRPlayView routeTrafficEventInfo = ");
            sb.append(xPRouteTrafficEventInfo == null ? " is null" : xPRouteTrafficEventInfo.mId + ", type = " + xPRouteTrafficEventInfo.mType);
            L.d(tag, sb.toString());
        }
        this.mGuideDataManager.setRouteTrafficEventInfo(xPRouteTrafficEventInfo);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateTRPlayView(xPRouteTrafficEventInfo);
            }
        }
        if (xPRouteTrafficEventInfo == null) {
            sendSRTrafficViewHideListener();
            return;
        }
        Handler handler = this.mListenerHandler;
        handler.sendMessageDelayed(handler.obtainMessage(3013, Integer.valueOf(xPRouteTrafficEventInfo.mId)), 1000L);
    }

    private void sendSRTrafficViewHideListener() {
        if (L.ENABLE) {
            L.d(TAG, "sendSRTrafficViewHideListener");
        }
        this.mGuideDataManager.setSRTrafficEventType(0);
        this.mNavigationInfoUpload.updateSRTraffic(0);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onHideSRTrafficView();
            }
        }
    }

    private void sendSRTrafficViewShowListener(int i) {
        if (L.ENABLE) {
            L.d(TAG, "sendSRTrafficViewShowListener");
        }
        this.mGuideDataManager.setSRTrafficEventType(i);
        this.mNavigationInfoUpload.updateSRTraffic(i);
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onShowSRTrafficView(i);
            }
        }
    }

    public void onObtainAsyncInfo(XPObtainInfo xPObtainInfo) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(MSG_ON_OBTAIN_ASYNC_INFO, xPObtainInfo));
    }

    public void onShowTollGateLane(XPTollGateInfo xPTollGateInfo) {
        this.mGuideDataManager.setXPTollGateInfo(xPTollGateInfo);
        if (xPTollGateInfo == null && this.mGuideDataManager.getNaviLaneInfo() != null) {
            L.i(TAG, "ignore empty tollGateInfo due to NaviLaneInfo is not null!");
            return;
        }
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateLaneInfo(null, xPTollGateInfo, xPTollGateInfo != null);
        }
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onShowTollGateLane(xPTollGateInfo);
            }
        }
    }

    public void postNaviStop(final int i, final boolean z) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$GuideManager$aC1cYwQoEB5tnno4PKKrDlJtHC4
            @Override // java.lang.Runnable
            public final void run() {
                GuideManager.this.lambda$postNaviStop$0$GuideManager(i, z);
            }
        });
    }

    /* renamed from: onNaviStop */
    public void lambda$postNaviStop$0$GuideManager(int i, boolean z) {
        L.i(TAG, ">>> onNaviStop !!!");
        this.mIsNaviStop = true;
        this.mOldPathID = 0L;
        this.mOldSegIdx = 0;
        if (this.mNeedWaitGuideEndTts && z && !this.mIsByUser) {
            L.i(TAG, ">>> onNaviStop but tts was not finished!!!");
            TBTManager.getInstance().setCurrentStatus(3);
            this.mTimer.start();
            for (INaviListener iNaviListener : this.mNaviListeners) {
                if (iNaviListener != null) {
                    iNaviListener.onNaviStopWaitingForTTs(i, this.mIsByUser);
                }
            }
            return;
        }
        this.mTimer.stop();
        if (!this.mIsByUser) {
            this.mGuideDataManager.saveNaviEndInfo();
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2026));
        Handler handler2 = this.mCallHandler;
        handler2.sendMessage(handler2.obtainMessage(2002));
        for (INaviListener iNaviListener2 : this.mNaviListeners) {
            if (iNaviListener2 != null) {
                iNaviListener2.onNaviStop(i, this.mIsByUser);
            }
        }
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateNaviStop();
        }
        EventBus.getDefault().post(new GuideWrapperNaviEvent.Builder(13).setIntValue(i).build());
        if (CloudRouteDataHelper.getInstance().isCloudRouteModeOpen()) {
            CloudRouteDataHelper.getInstance().enableCloudRouteMode(false, "onNaviStop");
        }
        TBTManager.getInstance().startCruise();
    }

    public boolean isNaviStop() {
        return this.mIsNaviStop;
    }

    public void onUpdateViaPass(long j) {
        TBTManager.getInstance().updateViaPass(this.mGuideDataManager.getCurrentNaviId(), (int) (this.mGuideDataManager.getLastPassedIndexDiff() + j));
        saveCurrentRouteHistory();
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateViaPass(j);
            }
        }
    }

    public void onReroute(RouteParams routeParams) {
        if (5 == routeParams.mRerouteType && TBTManager.getInstance().getCurrentStatus() == 1 && SettingWrapper.isOpenRadar()) {
            L.i(TAG, "RECOMMEND_ROUTE ignore reroute RouteTypeTMC when radar open");
            RouteOption.destroy(routeParams.mRerouteOption);
        } else if (this.mRerouteRequestIds.size() > 0) {
            addRerouteParams(routeParams);
        } else {
            requestRouteByOnReroute(routeParams);
            for (INaviListener iNaviListener : this.mNaviListeners) {
                if (iNaviListener != null) {
                    iNaviListener.onReroute(routeParams);
                }
            }
        }
    }

    public void onDeletePath(List<Long> list) {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(MSG_DELETE_PATH, list));
    }

    public void onChangeNaviPath(long j) {
        this.mIsOnChangeNaviPath = true;
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2022, Long.valueOf(j)));
    }

    public void onSelectMainPathStatus(long j, int i) {
        if (1 == i) {
            this.mIsOnChangeNaviPath = true;
            Handler handler = this.mCallHandler;
            handler.sendMessage(handler.obtainMessage(2023, Long.valueOf(j)));
        }
    }

    public void onCurrentRoadSpeed(final int i) {
        int currentRoadSpeed;
        if (!CarFeatureManager.INSTANCE.isCurrentRoadSpeedLimitOn() || TBTManager.getInstance().getCurrentStatus() == 0 || i == (currentRoadSpeed = this.mGuideDataManager.getCurrentRoadSpeed())) {
            return;
        }
        this.mGuideDataManager.setCurrentRoadSpeed(i);
        L.Tag tag = TAG;
        L.i(tag, "onCurrentRoadSpeed = " + i + " oldSpeed = " + currentRoadSpeed);
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.8
            @Override // java.lang.Runnable
            public void run() {
                if (CarServiceManager.getInstance().isD22()) {
                    CarServiceManager.getInstance().setIntelligentSpeedLimitValue(i / 10);
                } else {
                    CarServiceManager.getInstance().setCurrentRoadSpeedLimit(i);
                }
            }
        });
    }

    private void sendCurrentSpeedCamera2Xpu() {
        if (CarFeatureManager.INSTANCE.isCurrentElectronicEyeSpeedLimitOn()) {
            int currentCameraSpeed = this.mGuideDataManager.getCurrentCameraSpeed();
            int currentCameraDist = this.mGuideDataManager.getCurrentCameraDist();
            XPCameraInfo currentCameraByNavCamera = this.mGuideDataManager.getCurrentCameraByNavCamera();
            final int i = currentCameraByNavCamera != null ? currentCameraByNavCamera.mSpeed[0] : 0;
            final int i2 = currentCameraByNavCamera == null ? MapModelConstants.MAP_PARAMETERNAME_PROCESS_ROADARROW : currentCameraByNavCamera.mDistance;
            if (currentCameraSpeed == i && currentCameraDist == i2) {
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, "sendCurrentSpeedCamera2Xpu = " + i + " oldSpeed = " + currentCameraSpeed + " dist = " + i2 + " oldDist = " + currentCameraDist);
            this.mGuideDataManager.setCurrentCameraSpeed(i);
            this.mGuideDataManager.setCurrentCameraDist(i2);
            WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.9
                @Override // java.lang.Runnable
                public void run() {
                    CarServiceManager.getInstance().setCurrentElectronicEyeSpeedLimitAndDistance(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean selectMainPath(long j) {
        this.mIsOnChangeNaviPath = false;
        int pathIndexFormPathId = this.mGuideDataManager.getPathIndexFormPathId(j);
        if (-1 == pathIndexFormPathId) {
            L.e(TAG, ">>> selectMainPath but newPathIndex is -1");
            return false;
        }
        this.mGuideDataManager.setNaviPathType(9001);
        updatePathIndex(pathIndexFormPathId);
        this.mGuideServiceWrapper.setNaviPath(this.mGuideDataManager.getNaviPath(), pathIndexFormPathId);
        this.mRecommendParkingHelper.onNaviUpdate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deletePath(List<Long> list) {
        if (list == null) {
            L.e(TAG, ">>> deletePath but list is null");
            return false;
        }
        beforePathChangedNotify(false);
        long currentPathId = this.mGuideDataManager.getCurrentPathId();
        long currentNaviId = this.mGuideDataManager.getCurrentNaviId();
        if (-1 == currentPathId) {
            L.e(TAG, ">>> deletePath but currentPathId is -1");
            return false;
        }
        int size = list.size();
        L.Tag tag = TAG;
        L.i(tag, ">>> deletePath currentPathId=" + currentPathId + " currentNaviId=" + currentNaviId + " delete size =" + size);
        for (int i = 0; i < size; i++) {
            long longValue = list.get(i).longValue();
            if (longValue != currentPathId) {
                boolean removeDeletePath = this.mGuideDataManager.removeDeletePath(longValue);
                L.Tag tag2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(">>> deletePath delete pathid=");
                sb.append(longValue);
                sb.append(removeDeletePath ? " success" : " fail");
                L.i(tag2, sb.toString());
            }
        }
        int pathIndexFormPathId = this.mGuideDataManager.getPathIndexFormPathId(currentPathId);
        if (-1 == pathIndexFormPathId) {
            L.e(TAG, ">>> deletePath but newPathIndex is -1");
            return false;
        }
        L.Tag tag3 = TAG;
        L.i(tag3, ">>> deletePath newPathIndex=" + pathIndexFormPathId);
        this.mGuideDataManager.setCurrentNaviId(currentNaviId, 1000);
        updatePathIndex(pathIndexFormPathId);
        if (TBTManager.getInstance().getMap() != null) {
            TBTManager.getInstance().getMap().getBizControlManager().guideDeletePath();
        }
        INaviPath naviPath = this.mGuideDataManager.getNaviPath();
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        if (1 == currentStatus || 2 == currentStatus) {
            this.mGuideServiceWrapper.setNaviPath(naviPath, pathIndexFormPathId);
        }
        this.mRecommendParkingHelper.onNaviUpdate();
        return true;
    }

    public void reset() {
        this.mListenerHandler.removeMessages(3002);
        this.mGuideDataManager.reset();
        this.mRerouteRequestIds.clear();
        this.mNaviChargeReminder.reset();
    }

    public RouteParams getCurrentRouteParams() {
        return this.mGuideDataManager.getCurrentRouteParams();
    }

    public INaviPath getNaviPath() {
        return this.mGuideDataManager.getNaviPath();
    }

    public void setNaviPath(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setNaviPath index=" + i);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2003, Integer.valueOf(i)));
    }

    public void setEhpConfigValue(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>> setEhpConfigValue isOpen=" + z);
        }
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2030, Boolean.valueOf(z)));
    }

    public IVariantPath getCurrentVariantPath() {
        return this.mGuideDataManager.getCurrentVariantPath();
    }

    public XPNaviInfo getNaviInfo() {
        return this.mGuideDataManager.getNaviInfo();
    }

    public XPNaviInfo getNaviInfo(long j) {
        List<XPNaviInfo> naviInfoList = this.mGuideDataManager.getNaviInfoList();
        if (naviInfoList != null) {
            for (XPNaviInfo xPNaviInfo : naviInfoList) {
                if (xPNaviInfo.mPathID == j) {
                    return xPNaviInfo;
                }
            }
            return null;
        }
        return null;
    }

    public XPCrossImageInfo getNaviCrossImageInfo() {
        return this.mGuideDataManager.getNaviCrossImageInfo();
    }

    public void setNaviCrossImageInfo(XPCrossImageInfo xPCrossImageInfo) {
        this.mGuideDataManager.setNaviCrossImageInfo(xPCrossImageInfo);
    }

    public XPExitDirectionInfo getNaviExitDirectionInfo() {
        return this.mGuideDataManager.getNaviExitDirectionInfo();
    }

    public void setNaviExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
        this.mGuideDataManager.setNaviExitDirectionInfo(xPExitDirectionInfo);
    }

    public XPLaneInfo getNaviLaneInfo() {
        return this.mGuideDataManager.getNaviLaneInfo();
    }

    public XPManeuverInfo getNaviManeuverInfo() {
        return this.mGuideDataManager.getNaviManeuverInfo();
    }

    public List<XPCameraInfo> getNaviCamera() {
        return this.mGuideDataManager.getNaviCameras();
    }

    public List<XPCameraInfo> getNaviIntervalCameras() {
        return this.mGuideDataManager.getNaviIntervalCameras();
    }

    public List<XPCameraInfo> getNaviIntervalDynamicCameras() {
        return this.mGuideDataManager.getNaviIntervalDynamicCameras();
    }

    public XPNaviCongestionInfo getNaviCongestionInfo() {
        return this.mGuideDataManager.getNaviCongestionInfo();
    }

    public XPCruiseCongestionInfo getCruiseCongestionInfo() {
        return this.mGuideDataManager.getCruiseCongestionInfo();
    }

    public XPTollGateInfo getXPTollGateInfo() {
        return this.mGuideDataManager.getXPTollGateInfo();
    }

    public long getParallelRoadId() {
        return this.mGuideDataManager.getParallelRoadId();
    }

    public void setParallelRoadId(long j) {
        this.mGuideDataManager.setParallelRoadId(j);
    }

    public int getLastPassedIndexDiff() {
        return this.mGuideDataManager.getLastPassedIndexDiff();
    }

    public void setLastPassedIndexDiff(int i) {
        this.mGuideDataManager.setLastPassedIndexDiff(i);
    }

    public XPRouteTrafficEventInfo getRouteTrafficEventInfo() {
        return this.mGuideDataManager.getRouteTrafficEventInfo();
    }

    public XPTrafficEventInfo getCurrentTrafficEventInfo(int i) {
        return this.mGuideDataManager.getCurrentTrafficEventInfo(i);
    }

    public void needWaitGuideEndTTS() {
        L.i(TAG, "needWaitGuideEndTTS");
        this.mNeedWaitGuideEndTts = true;
    }

    public ILightBarInfo getLightBarInfo(long j) {
        List<ILightBarInfo> lightBarInfos = this.mGuideDataManager.getLightBarInfos();
        if (lightBarInfos != null) {
            for (ILightBarInfo iLightBarInfo : lightBarInfos) {
                if (iLightBarInfo != null && iLightBarInfo.getPathId() == j) {
                    return iLightBarInfo;
                }
            }
            return null;
        }
        return null;
    }

    public int getLightBarPassedIndex() {
        return this.mGuideDataManager.getLightBarPassedIndex();
    }

    private String modifyBLTTSContent(@Nullable XPSoundInfo xPSoundInfo) {
        if (xPSoundInfo == null || TextUtils.isEmpty(xPSoundInfo.mText)) {
            return null;
        }
        String string = ContextUtils.getString(R.string.tts_gas_station);
        if (8 == xPSoundInfo.mSoundType && xPSoundInfo.mText.contains(string)) {
            String replace = xPSoundInfo.mText.replace(string, ContextUtils.getString(R.string.tts_service_area));
            L.Tag tag = TAG;
            L.i(tag, "onPlayTTS:newTTS=" + replace);
            return replace;
        }
        if (xPSoundInfo.mText.contains(ContextUtils.getString(R.string.tts_long_time_drive))) {
            return null;
        }
        return xPSoundInfo.mText;
    }

    private void saveRouteHistory(RouteParams routeParams) {
        this.mGuideDataManager.setRestoreRouteParams(routeParams);
        this.mListenerHandler.obtainMessage(3003, routeParams).sendToTarget();
    }

    public void saveCurrentRouteHistory() {
        this.mListenerHandler.sendEmptyMessage(3000);
    }

    public void removeRouteHistory() {
        this.mListenerHandler.sendEmptyMessage(3001);
    }

    public RouteParams getRestoreRouteParams() {
        if (this.mGuideDataManager.getRestoreRouteParams() == null) {
            GuideDataManager guideDataManager = this.mGuideDataManager;
            FileIOUtil fileIOUtil = new FileIOUtil(RouteParams.class);
            guideDataManager.setRestoreRouteParams((RouteParams) fileIOUtil.readObjectFromSDCard(this.mHistoryFileDir + ROUTE_HISTORY_FILE_NAME));
        }
        return this.mGuideDataManager.getRestoreRouteParams();
    }

    public void setRestoreRouteParams(RouteParams routeParams) {
        saveRouteHistory(routeParams);
    }

    public boolean isNeedRestoreRoute() {
        RouteParams routeParams;
        if (RootUtil.isSdcardExist()) {
            routeParams = getRestoreRouteParams();
        } else {
            L.i(TAG, ">>> getRestoreRouteParams getExternalStorageState is not MEDIA_MOUNTED");
            routeParams = null;
        }
        return routeParams != null;
    }

    public INavigationInfoUploadStrategy getNavigationInfoUpload() {
        return this.mNavigationInfoUpload;
    }

    public void setNavigationInfoUpload(INavigationInfoUploadStrategy iNavigationInfoUploadStrategy) {
        this.mNavigationInfoUpload = iNavigationInfoUploadStrategy;
    }

    public String getHighWayInfo() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            XPFacilityInfo nearestSapa = getNearestSapa(this.mGuideDataManager.getNaviSapas());
            if (nearestSapa != null) {
                jSONObject2.put("isHighWay", true);
                jSONObject2.put("remainDist", nearestSapa.mRemainDist);
                jSONObject2.put("name", nearestSapa.mName);
            } else {
                jSONObject2.put("isHighWay", false);
            }
            jSONObject.put("navi", jSONObject2);
        } catch (JSONException e) {
            L.i(TAG, "getHighWayInfo to json failed");
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return null;
    }

    private XPFacilityInfo getNearestSapa(List<XPFacilityInfo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (XPFacilityInfo xPFacilityInfo : list) {
                if (xPFacilityInfo != null && xPFacilityInfo.mType == 0) {
                    return xPFacilityInfo;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRemoveRouteHistory() {
        if (RootUtil.isSdcardExist()) {
            File file = new File(this.mHistoryFileDir + ROUTE_HISTORY_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
        }
        LaneServiceManager.getInstance().onNaviStop();
        this.mGuideDataManager.setRestoreRouteParams(null);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.ROUTE_HISTROY_LASTMODIFY_KEY, 0);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.ROUTE_HISTROY_DISTANCE_KEY, 0);
        TTSManager.getInstance().setIsGuideStartIgnoreTTS(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveRouteHistory() {
        L.i(TAG, "saveRestoreParam onSaveRouteHistory");
        RouteParams currentRouteParams = this.mGuideDataManager.getCurrentRouteParams();
        if (currentRouteParams != null && currentRouteParams.mEndInfo != null) {
            new FileIOUtil().writeObject2SDCard(this.mHistoryFileDir, ROUTE_HISTORY_FILE_NAME, currentRouteParams);
            IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
            if (currentNaviVariantPath != null) {
                updateRouteHistoryData(System.currentTimeMillis(), (int) currentNaviVariantPath.getPathLength(), LocationUtils.getLinearDistance(currentRouteParams));
            }
        }
        this.mGuideDataManager.setRestoreRouteParams(currentRouteParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateRouteHistory() {
        if (RootUtil.isSdcardExist() && new File(this.mHistoryFileDir, ROUTE_HISTORY_FILE_NAME).exists()) {
            IVariantPath currentVariantPath = getCurrentVariantPath();
            XPNaviInfo naviInfo = getNaviInfo();
            long j = 0;
            if (naviInfo != null) {
                j = (long) naviInfo.mRouteRemainDist;
            } else if (currentVariantPath != null) {
                j = currentVariantPath.getPathLength();
            }
            updateRouteHistoryData(System.currentTimeMillis(), (int) j, LocationUtils.getLinearDistance(getRestoreRouteParams()));
        }
    }

    private void updateRouteHistoryData(long j, int i, double d) {
        L.Tag tag = TAG;
        L.d(tag, "updateRouteHistoryData: " + i);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.ROUTE_HISTROY_LASTMODIFY_KEY, j);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.ROUTE_HISTROY_DISTANCE_KEY, i);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.ROUTE_HISTORY_LINEAR_DISTANCE_KEY, d);
        this.mListenerHandler.removeMessages(3002);
        this.mListenerHandler.sendEmptyMessageDelayed(3002, MINUTE_5.longValue());
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
    public void onUpdateRemainDis(long j, int i, int i2) {
        IVariantPath currentVariantPath;
        if (this.mNavigationInfoUpload != null && (currentVariantPath = getCurrentVariantPath()) != null && j == currentVariantPath.getPathId()) {
            RouteParams currentRouteParams = getCurrentRouteParams();
            int i3 = 0;
            if (currentRouteParams != null && currentRouteParams.mViaInfos != null) {
                int size = currentRouteParams.mViaInfos.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    XPViaPoint xPViaPoint = currentRouteParams.mViaInfos.get(i4);
                    if (xPViaPoint != null && !xPViaPoint.getIsPassedVia()) {
                        i3 = i4 + 1;
                        break;
                    }
                    i4++;
                }
            }
            this.mNavigationInfoUpload.updateNaviRemainDistInfo(i, i2, i3);
        }
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onUpdateRemainDis(j, i, i2);
            }
        }
    }

    public void updateNaviStopInfo() {
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateNaviStop();
        }
    }

    public void resetNaviInfo() {
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.resetNavi();
        }
    }

    public void updateSRInfo(boolean z) {
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateSRInfo(z);
        }
    }

    public void updateLocInfo(XPLocInfo xPLocInfo) {
        INavigationInfoUploadStrategy iNavigationInfoUploadStrategy = this.mNavigationInfoUpload;
        if (iNavigationInfoUploadStrategy != null) {
            iNavigationInfoUploadStrategy.updateLocInfo(xPLocInfo);
        }
    }

    public void updateTBTStatus(int i, int i2) {
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onTBTStatusUpdate(i, i2);
            }
        }
        this.mPowerDisHelperContainer.updateTBTStatus(i2);
        if (i2 != 0) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVIGATION_STATUS, i2);
        }
    }

    private void beforePathChangedNotify(boolean z) {
        for (INaviListener iNaviListener : this.mNaviListeners) {
            if (iNaviListener != null) {
                iNaviListener.onBeforePathChanged(z);
            }
        }
        L.i(NaviPowerDisHelperContainer.TAG, " beforePathChangedNotify--");
        stopNaviPdHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createNaviPdHelper() {
        this.mPowerDisHelperContainer.createNaviPowerDisHelper();
    }

    private void updateNaviPdHelper(List<XPNaviInfo> list) {
        this.mPowerDisHelperContainer.updateNaviPdHelper(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshNaviPdHelper(long j) {
        NaviPowerDisHelperContainer naviPowerDisHelperContainer = this.mPowerDisHelperContainer;
        if (naviPowerDisHelperContainer != null) {
            naviPowerDisHelperContainer.refreshPowerDistance(j);
        }
    }

    private void stopNaviPdHelper() {
        this.mPowerDisHelperContainer.stopNaviPowerDisHelper();
    }

    public ConcurrentHashMap<Long, NaviPowerDisHelperContainer.NaviPowerDisData> getNaviRemainDisMap() {
        return this.mPowerDisHelperContainer.getNaviRemainDisMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeNaviPdHelper() {
        this.mPowerDisHelperContainer.closeNaviPowerDisHelper();
    }

    private void saveHistoryPath() {
        RouteParams currentRouteParams = getCurrentRouteParams();
        if (currentRouteParams == null || currentRouteParams.mEndInfo == null || !CollectionUtils.isNotEmpty(currentRouteParams.mViaInfos)) {
            return;
        }
        final XPPoiInfo deepClone = currentRouteParams.mEndInfo.deepClone();
        final ArrayList arrayList = new ArrayList();
        if (currentRouteParams.mEndInfo.isNameAndAddressEmpty()) {
            L.i(TAG, "drop HISTORY_PATH because endinfo has no name and address");
            return;
        }
        for (int i = 0; i < currentRouteParams.mViaInfos.size(); i++) {
            XPViaPoint xPViaPoint = currentRouteParams.mViaInfos.get(i);
            if (xPViaPoint != null && xPViaPoint.getPoiPoint() != null && xPViaPoint.getPoiPoint().isNameAndAddressEmpty()) {
                L.i(TAG, "drop HISTORY_PATH because viaPoint has no name and address");
                return;
            }
            if (xPViaPoint != null && xPViaPoint.getPoiPoint() != null && xPViaPoint.getViaType() == 2) {
                arrayList.add(xPViaPoint.getPoiPoint().deepClone());
            }
        }
        if (deepClone == null || !CollectionUtils.isNotEmpty(arrayList)) {
            return;
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.10
            @Override // java.lang.Runnable
            public void run() {
                HistoryRecordInfo historyRecordInfo = new HistoryRecordInfo(deepClone, 3, arrayList);
                boolean insertOrReplace = FavoriteDataManager.getInstance().insertOrReplace(historyRecordInfo);
                if (L.ENABLE) {
                    L.Tag tag = GuideManager.TAG;
                    L.d(tag, "saveHistoryPath result=" + insertOrReplace + " recordInfo=" + NaviLogUtil.dumpHistoryRecordInfo(historyRecordInfo));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDataOnNaviStop() {
        SRNaviManager.getInstance().resetSRNaviDataInfo();
        this.mGuideDataManager.saveNaviInfoForDataLog();
        TTSProxy.getInstance().shutUp(null);
        saveHistoryPath();
        reset();
        removeRouteHistory();
        getRecommendParkingHelper().onStopNavi();
        TBTManager.getInstance().updateCarLocIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTrafficEventStatus(int i) {
        this.mListenerHandler.removeMessages(3013);
        XPTrafficEventInfo currentTrafficEventInfo = getCurrentTrafficEventInfo(i);
        if (currentTrafficEventInfo != null) {
            int sRTrafficEventType = getSRTrafficEventType(currentTrafficEventInfo.mType);
            if (sRTrafficEventType != 0) {
                double distance = LocationUtils.getDistance(currentTrafficEventInfo.mCoord2D, TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
                if (distance > TRAFFIC_EVENT_DIS_STATUS_NORMAL) {
                    Handler handler = this.mListenerHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(3013, Integer.valueOf(i)), INTERVAL_CHECK_TRAFFIC_DIS_THREE_SEC);
                    return;
                } else if (distance > TRAFFIC_EVENT_DIS_STATUS_WARNING) {
                    Handler handler2 = this.mListenerHandler;
                    handler2.sendMessageDelayed(handler2.obtainMessage(3013, Integer.valueOf(i)), 1000L);
                    return;
                } else if (distance <= TRAFFIC_EVENT_DIS_STATUS_WARNING) {
                    if (distance <= 20.0d) {
                        sendSRTrafficViewHideListener();
                        return;
                    }
                    if (sRTrafficEventType != this.mGuideDataManager.getSRTrafficEventType()) {
                        sendSRTrafficViewShowListener(sRTrafficEventType);
                        playSRTrafficEventTTS(ContextUtils.getString(1 == sRTrafficEventType ? R.string.srnavi_traffic_event_accident_tts : R.string.srnavi_traffic_event_construction_tts));
                    }
                    Handler handler3 = this.mListenerHandler;
                    handler3.sendMessageDelayed(handler3.obtainMessage(3013, Integer.valueOf(i)), 1000L);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        sendSRTrafficViewHideListener();
    }

    private void playSRTrafficEventTTS(String str) {
        TTSProxy.getInstance().speak(str, null);
    }

    public int getSRTrafficEventType() {
        return this.mGuideDataManager.getSRTrafficEventType();
    }

    public void setNaviPathType(int i) {
        this.mGuideDataManager.setNaviPathType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNaviEndTTS(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(ContextUtils.getString(R.string.tts_navi_stop));
    }

    public void naviArriveStop() {
        Handler handler = this.mCallHandler;
        handler.sendMessage(handler.obtainMessage(2027));
    }
}
