package com.xiaopeng.montecarlo.charge.recommendcharger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelper;
import com.xiaopeng.montecarlo.navcore.search.AroundInfoRequest;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.OpenTimeUtils;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class RecommendChargeModel implements CarServiceManager.IXPCarStateListener {
    private static final int AVERAGE_TIME_PER_METRE = 60;
    private static final int CAR_REMAIN_DISTANCE_DELTA = 1000;
    private static final int CAR_REMAIN_DISTANCE_DELTA_THRESHOLD = 50;
    private static final int CAR_REMAIN_DISTANCE_ILLEGAL = 10;
    private static final int CAR_REMAIN_DISTANCE_LOW = 30000;
    private static final int CAR_REMAIN_DISTANCE_WARNING = 60000;
    private static final int CHECK_DISTANCE = 100000;
    private static final int CHECK_TIMER = 120000;
    private static final String KEY_WORD_CHARGE = "充电站";
    private static final int MAX_RECOMMEND_SIZE = 2;
    private static final int MAX_SHOW_CHARGE_DISTANCE = 60000;
    private static final int MIN_SHOW_CHARGE_DISTANCE = -10000;
    private static final long OPEN_TIME_DELAY = 1800000;
    private static final long ROUTE_TIME_OUT = 61000;
    private static final int SEARCH_AROUND_CHARGE_SIZE = 20;
    private static final int STATUS_ACTIVE = 1;
    private static final int STATUS_IDLE = 2;
    private static final int STATUS_INTERRUPT = 3;
    private static final int STATUS_NONE = -1;
    private static final int STATUS_START = 0;
    private static final int STATUS_STOP = 4;
    private static final L.Tag TAG = new L.Tag("RecommendChargeModel");
    private static final int TYPE_AROUND = 1;
    private static final int TYPE_FREQUENT = 0;
    private static final boolean mIsFrequentRecommend = true;
    private IRecommendDataListener mListener;
    private IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private final HashMap<RouteParams, RecommendChargerBean> mRoutingMap = new HashMap<>();
    private final HashMap<AroundInfoRequest, SearchResponseEvent> mSearchMap = new HashMap<>();
    private final ChargeComparator mComparator = new ChargeComparator();
    private final List<RecommendChargerBean> mFrequentCharges = new ArrayList();
    private final List<XPPoiInfo> mAroundCharges = new ArrayList();
    private final List<RecommendChargerBean> mRecommendCharges = new ArrayList();
    private volatile int mStatus = -1;
    private int mLastDistance = 0;
    private long mLastUpdateTime = 0;
    private final RecommendChargerHandler mHandler = new RecommendChargerHandler(WorkThreadUtil.getInstance().getStatusThreadLooper());
    private final FrequentChargeModel mFrequentChargeModel = new FrequentChargeModel();

    /* loaded from: classes2.dex */
    public interface IRecommendDataListener {
        void onRecommendChargeUpdate(List<RecommendChargerBean> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStatusName(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "STATUS_NONE" : "STATUS_STOP" : "STATUS_INTERRUPT" : "STATUS_IDLE" : "STATUS_ACTIVE" : "STATUS_START" : "STATUS_NONE";
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
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

    public void setListener(IRecommendDataListener iRecommendDataListener) {
        this.mListener = iRecommendDataListener;
    }

    public void start() {
        if (isAlive()) {
            return;
        }
        setStatus(0);
        CarServiceManager.getInstance().addCarStateListener(this);
        this.mHandler.sendEmptyMessage(0);
    }

    public void stop() {
        if (isAlive()) {
            CarServiceManager.getInstance().removeCarStateListener(this);
            removeMessages();
            setStatus(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleRefresh() {
        this.mHandler.removeMessages(7);
        long currentTimeMillis = System.currentTimeMillis() - this.mLastUpdateTime;
        long j = 0;
        if (currentTimeMillis <= 0) {
            j = 120000;
        } else if (currentTimeMillis < XpCacheConsts.MAX_DISTANCE_FOR_HOME_COMUTTING_FORECAST) {
            j = XpCacheConsts.MAX_DISTANCE_FOR_HOME_COMUTTING_FORECAST - currentTimeMillis;
        }
        L.i(TAG, "scheduleRefresh delayTime:" + j);
        this.mHandler.sendEmptyMessageDelayed(7, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAlive() {
        return this.mStatus < 4 && this.mStatus > -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        this.mStatus = i;
        L.Tag tag = TAG;
        L.i(tag, " mStatus: " + getStatusName(i));
    }

    private void removeMessages() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(7);
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(6);
    }

    private void notifyUpdate() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.charge.recommendcharger.-$$Lambda$RecommendChargeModel$5eu8UR1_SuWOkEdUl77R6zEEo2o
            @Override // java.lang.Runnable
            public final void run() {
                RecommendChargeModel.this.lambda$notifyUpdate$0$RecommendChargeModel();
            }
        });
    }

    public /* synthetic */ void lambda$notifyUpdate$0$RecommendChargeModel() {
        IRecommendDataListener iRecommendDataListener;
        if (!isAlive() || (iRecommendDataListener = this.mListener) == null) {
            return;
        }
        iRecommendDataListener.onRecommendChargeUpdate(this.mRecommendCharges);
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("notifyUpdate ===== size: ");
        List<RecommendChargerBean> list = this.mRecommendCharges;
        sb.append(list == null ? 0 : list.size());
        L.i(tag, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startProcessRecommendCharges() {
        L.i(TAG, "start LOOP <<<<<<<<<< ");
        setStatus(1);
        this.mRecommendCharges.clear();
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        this.mLastDistance = carRemainDistance;
        this.mLastUpdateTime = System.currentTimeMillis();
        startProcessFrequentRecommendCharges(carRemainDistance);
    }

    private void onProcessFinished() {
        L.i(TAG, ">>>>>>>> end LOOP");
        if (4 != this.mStatus) {
            setStatus(2);
            if (this.mStatus <= -1 || this.mStatus >= 4) {
                return;
            }
            notifyUpdate();
            return;
        }
        L.i(TAG, "process has already been stopped");
    }

    private void startProcessFrequentRecommendCharges(int i) {
        this.mFrequentCharges.clear();
        this.mFrequentCharges.addAll(this.mFrequentChargeModel.getData());
        L.i(TAG, "start frequent, total: " + this.mFrequentCharges.size() + ", mStatus: " + getStatusName(this.mStatus) + ", carRemainDistance: " + i);
        if (i >= 60000) {
            for (int i2 = 0; i2 < this.mFrequentCharges.size() && this.mRecommendCharges.size() < 2; i2++) {
                RecommendChargerBean recommendChargerBean = this.mFrequentCharges.get(i2);
                L.i(TAG, "process frequent: " + i2 + ", " + recommendChargerBean.toString() + ", mStatus: " + getStatusName(this.mStatus));
                if (!checkContinue()) {
                    return;
                }
                if (isLineDistanceInRange(recommendChargerBean)) {
                    long navDistance = recommendChargerBean.getNavDistance();
                    long leftDistance = recommendChargerBean.getLeftDistance();
                    L.Tag tag = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("frequent name: ");
                    sb.append(recommendChargerBean.getName());
                    sb.append(" routing result: navDistance: ");
                    sb.append(navDistance);
                    sb.append(", leftDis: ");
                    sb.append(leftDistance);
                    sb.append(", -10km < leftDis < 60km: ");
                    int i3 = (leftDistance > 60000L ? 1 : (leftDistance == 60000L ? 0 : -1));
                    sb.append(i3 < 0 && leftDistance > -10000);
                    L.i(tag, sb.toString());
                    if (navDistance > 0 && i3 < 0 && leftDistance > -10000) {
                        addRecommendCharge(recommendChargerBean);
                    }
                }
            }
        } else if (i >= 10 && !selectArrivalFrequentRecommendBean(this.mFrequentCharges)) {
            return;
        }
        onProcessFrequentFinished(i);
    }

    private void onProcessFrequentFinished(int i) {
        if (i >= 60000 || ((i >= 30000 && this.mRecommendCharges.size() > 0) || (i < 30000 && this.mRecommendCharges.size() >= 2))) {
            onProcessFinished();
        } else if (i <= 0) {
            onProcessFinished();
        } else {
            startProcessAroundRecommendCharges(i);
        }
    }

    private void startProcessAroundRecommendCharges(int i) {
        L.Tag tag = TAG;
        L.i(tag, "start AROUND, search CP charges , mStatus: " + getStatusName(this.mStatus) + ", carRemainDistance: " + i);
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        List<XPPoiInfo> fetchXPPoiInfoListFromSearchByOneResponse = HttpResponseConverter.fetchXPPoiInfoListFromSearchByOneResponse(this.mChargeStationSearchService.searchByOne(new ChargeSearchByOneRequest().setLat(new DecimalFormat("#.00000").format(startPOIFromCurrent.getDisplayLat())).setLng(new DecimalFormat("#.00000").format(startPOIFromCurrent.getDisplayLon())).setRemainDis(i).setSize(20).setDetail(true)));
        this.mAroundCharges.clear();
        this.mAroundCharges.addAll(fetchXPPoiInfoListFromSearchByOneResponse);
        L.Tag tag2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("CP total: ");
        List<XPPoiInfo> list = this.mAroundCharges;
        sb.append(list == null ? "0" : Integer.valueOf(list.size()));
        sb.append(", mStatus: ");
        sb.append(getStatusName(this.mStatus));
        sb.append(", carRemainDistance: ");
        sb.append(i);
        L.i(tag2, sb.toString());
        if (L.ENABLE) {
            for (XPPoiInfo xPPoiInfo : this.mAroundCharges) {
                XPDeepInfoPoi xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi();
                XPDeepCharging xPDeepCharging = null;
                if (xPDeepInfoPoi != null && xPDeepInfoPoi.getChargeData() != null && xPDeepInfoPoi.getChargeData().length > 0) {
                    xPDeepCharging = xPDeepInfoPoi.getChargeData()[0];
                }
                L.Tag tag3 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SORTED ");
                sb2.append(xPPoiInfo.getName());
                sb2.append(", isXP: ");
                sb2.append(XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory()));
                sb2.append(",  distance [");
                sb2.append(xPPoiInfo.getDistance());
                sb2.append("], fast[");
                sb2.append(xPDeepCharging != null ? xPDeepCharging.getNumFastFree() : 0);
                sb2.append("]");
                L.d(tag3, sb2.toString());
            }
        }
        if (CollectionUtils.isNotEmpty(fetchXPPoiInfoListFromSearchByOneResponse)) {
            for (XPPoiInfo xPPoiInfo2 : fetchXPPoiInfoListFromSearchByOneResponse) {
                if (L.ENABLE) {
                    L.Tag tag4 = TAG;
                    L.d(tag4, xPPoiInfo2.getName() + ": " + xPPoiInfo2.getOpenTime());
                }
                String openTime = xPPoiInfo2.getOpenTime();
                if (!OpenTimeUtils.is24Hour(openTime)) {
                    String[] split = new SimpleDateFormat("EEEE HH:mm", Locale.getDefault()).format(Double.valueOf(System.currentTimeMillis() + (xPPoiInfo2.getDistance() * 60.0d) + 1800000.0d)).split(" ");
                    if (!OpenTimeUtils.isOpenTime(openTime, split[0], split[1])) {
                        if (L.ENABLE) {
                            L.Tag tag5 = TAG;
                            L.d(tag5, "check CP time remove: " + xPPoiInfo2.getName() + ": " + xPPoiInfo2.getOpenTime() + ", " + split[0] + ", " + split[1]);
                        }
                        this.mAroundCharges.remove(xPPoiInfo2);
                    }
                }
            }
            L.Tag tag6 = TAG;
            L.i(tag6, "after around time check, CP total: " + this.mAroundCharges.size());
            if (CollectionUtils.isNotEmpty(this.mAroundCharges) && !selectArrivalCharges(this.mAroundCharges, 1, i)) {
                return;
            }
        }
        if (this.mRecommendCharges.size() > 0) {
            onProcessFinished();
            return;
        }
        L.i(TAG, "search BL charges ");
        XPPoiInfo startPOIFromCurrent2 = TBTManager.getInstance().getStartPOIFromCurrent();
        final AroundInfoRequest build = new AroundInfoRequest.Builder().mKeyword(KEY_WORD_CHARGE).mSearchId(SearchClient.getInstance().getRequestId()).mRange(Integer.toString(i)).mPoiLon(startPOIFromCurrent2.getDisplayLon()).mPoiLat(startPOIFromCurrent2.getDisplayLat()).build();
        SearchClient.getInstance().execute(new RequestFactory(1).newBuilder().requestId(build.mSearchId).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND).keyword(build.mKeyword).poiLocation(new XPCoordinate2DDouble(build.mPoiLon, build.mPoiLat)).radius(build.mRange).build(), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.charge.recommendcharger.RecommendChargeModel.1
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                RecommendChargeModel.this.filterChargeStation(xPSearchResult);
                RecommendChargeModel.this.mSearchMap.put(build, NavCoreUtil.convertXpResultToResponseEvent(4, build.mSearchId, xPSearchResult));
                synchronized (build) {
                    build.notify();
                }
            }
        });
        synchronized (build) {
            try {
                build.wait(ROUTE_TIME_OUT);
            } catch (InterruptedException unused) {
                L.i(TAG, "search BL charges interrupt");
            }
        }
        SearchResponseEvent remove = this.mSearchMap.remove(build);
        if (remove == null || CollectionUtils.isEmpty(remove.getList())) {
            L.Tag tag7 = TAG;
            L.i(tag7, "no BL charge in carRemainDistance: " + i);
            onProcessFinished();
            return;
        }
        this.mAroundCharges.clear();
        this.mAroundCharges.addAll(remove.getList());
        L.Tag tag8 = TAG;
        L.i(tag8, "BL charges size: " + remove.getList().size() + " in carRemainDistance: " + i);
        Collections.sort(this.mAroundCharges, this.mComparator);
        if (selectArrivalCharges(this.mAroundCharges, 1, i)) {
            onProcessFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filterChargeStation(XPSearchResult xPSearchResult) {
        List<XPPoiInfo> xPPoiInfos;
        if (xPSearchResult == null || (xPPoiInfos = xPSearchResult.getXPPoiInfos()) == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "recommend charge filter specific charge station begin size : " + xPPoiInfos.size());
        String string = ContextUtils.getString(R.string.search_result_filter_keyword_tesla);
        Iterator<XPPoiInfo> it = xPPoiInfos.iterator();
        while (it.hasNext()) {
            XPPoiInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getName()) && next.getName().contains(string)) {
                it.remove();
            }
        }
    }

    private boolean selectArrivalFrequentRecommendBean(List<RecommendChargerBean> list) {
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }
        for (int i = 0; i < list.size() && this.mRecommendCharges.size() < 2; i++) {
            RecommendChargerBean recommendChargerBean = list.get(i);
            L.i(TAG, "selectArrivalFrequentRecommendBean , mStatus: " + getStatusName(this.mStatus) + ", " + recommendChargerBean.toString());
            if (!checkContinue()) {
                L.i(TAG, "selectArrivalFrequentRecommendBean, interrupt ! ");
                return false;
            }
            if (recommendChargerBean.getLeftDistance() >= 1000) {
                addRecommendCharge(recommendChargerBean);
            }
        }
        return true;
    }

    private boolean selectArrivalCharges(List<XPPoiInfo> list, int i, int i2) {
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }
        int i3 = 0;
        while (i3 < list.size() && this.mRecommendCharges.size() < 2) {
            XPPoiInfo xPPoiInfo = list.get(i3);
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("check arrival start, index: ");
            sb.append(i3);
            sb.append(", type: ");
            sb.append(i == 1 ? "around " : "frequent ");
            sb.append(", name: ");
            sb.append(xPPoiInfo.getName());
            sb.append(", mStatus: ");
            sb.append(getStatusName(this.mStatus));
            L.i(tag, sb.toString());
            if (!checkContinue()) {
                L.i(TAG, "check arrival, interrupt ! ");
                return false;
            }
            if (xPPoiInfo != null) {
                RecommendChargerBean requestRoutingSync = requestRoutingSync(xPPoiInfo, i2);
                if (requestRoutingSync == null) {
                    continue;
                } else {
                    long navDistance = requestRoutingSync.getNavDistance();
                    long leftDistance = requestRoutingSync.getLeftDistance();
                    L.Tag tag2 = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("check arrival end, type: ");
                    sb2.append(i == 1 ? "around, " : "frequent, ");
                    sb2.append(xPPoiInfo.getName());
                    sb2.append(", routing result: ");
                    sb2.append(navDistance);
                    sb2.append(", left distance: ");
                    sb2.append(requestRoutingSync.getLeftDistance());
                    L.i(tag2, sb2.toString());
                    if (leftDistance >= 1000) {
                        int i4 = 2001;
                        if (i == 1 && !XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory())) {
                            int i5 = -1;
                            try {
                                i5 = xPPoiInfo.getXPDeepInfoPoi().getChargeData()[0].getNumFastFree();
                            } catch (Exception unused) {
                            }
                            i4 = i5 > 0 ? 2002 : 2003;
                        }
                        addRecommendCharge(i4, requestRoutingSync);
                    } else if (i != 0) {
                        L.i(TAG, "check arrival, nearest around cannot arrive, break");
                        return true;
                    }
                }
            }
            i3++;
        }
        return true;
    }

    private boolean checkContinue() {
        if (this.mStatus != 3) {
            return this.mStatus != 4;
        }
        startProcessRecommendCharges();
        return false;
    }

    private void addRecommendCharge(RecommendChargerBean recommendChargerBean) {
        this.mRecommendCharges.add(recommendChargerBean);
        L.Tag tag = TAG;
        L.i(tag, "ADDED RECOMMEND CHARGE:" + recommendChargerBean.getName());
    }

    private void addRecommendCharge(int i, RecommendChargerBean recommendChargerBean) {
        recommendChargerBean.setType(i);
        this.mRecommendCharges.add(recommendChargerBean);
        L.Tag tag = TAG;
        L.i(tag, "ADDED RECOMMEND CHARGE:" + recommendChargerBean.toString());
    }

    private boolean isLineDistanceInRange(RecommendChargerBean recommendChargerBean) {
        double lineDistance = recommendChargerBean.getLineDistance();
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("line distance: ");
        sb.append(lineDistance);
        sb.append(" LEGAL: ");
        int i = (lineDistance > 100000.0d ? 1 : (lineDistance == 100000.0d ? 0 : -1));
        sb.append(i < 0);
        L.i(tag, sb.toString());
        return i < 0;
    }

    private synchronized RecommendChargerBean requestRoutingSync(final XPPoiInfo xPPoiInfo, final int i) {
        final RouteParams build;
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        final RecommendChargerBean recommendChargerBean = new RecommendChargerBean(xPPoiInfo.getPoiId(), xPPoiInfo);
        recommendChargerBean.setName(xPPoiInfo.getName());
        recommendChargerBean.setXPPoiInfo(xPPoiInfo);
        build = new RouteParams.Builder().setStartInfo(startPOIFromCurrent).setEndInfo(xPPoiInfo).setRouteLevel(0).build();
        this.mRoutingMap.put(build, recommendChargerBean);
        long requestRoute = TBTManager.getInstance().requestRoute(build, new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.charge.recommendcharger.RecommendChargeModel.2
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(long j, RouteResult routeResult) {
                boolean z = (routeResult == null || routeResult.mPathResult == null) ? false : true;
                L.Tag tag = RecommendChargeModel.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onNewRouteSuccess success: ");
                sb.append(z);
                sb.append(", mStatus: ");
                RecommendChargeModel recommendChargeModel = RecommendChargeModel.this;
                sb.append(recommendChargeModel.getStatusName(recommendChargeModel.mStatus));
                sb.append(" for ");
                sb.append(xPPoiInfo.getName());
                L.i(tag, sb.toString());
                synchronized (build) {
                    if (RecommendChargeModel.this.mRoutingMap.get(build) == null) {
                        L.Tag tag2 = RecommendChargeModel.TAG;
                        L.i(tag2, "this routing is expired: " + j);
                    } else {
                        if (z && routeResult.mRouteInfos.size() != 0) {
                            new RoutePowerDisHelper(null, routeResult.mPathResult.getPath(0), routeResult.mPathResult, new OnUpdateRemainDisListener() { // from class: com.xiaopeng.montecarlo.charge.recommendcharger.RecommendChargeModel.2.1
                                @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
                                public void onUpdateRemainDis(long j2, int i2, int i3) {
                                    recommendChargerBean.setLeftDistance(i3);
                                }
                            }, true, true).updateRemainDis();
                            recommendChargerBean.setNavDistance((int) routeResult.mRouteInfos.get(0).mPathLength);
                        }
                        L.i(RecommendChargeModel.TAG, "pathResult is null");
                    }
                    TBTManager.getInstance().clearRouteData(j);
                    build.notify();
                }
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(long j, RouteResult routeResult) {
                L.Tag tag = RecommendChargeModel.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onNewRouteError mStatus: ");
                RecommendChargeModel recommendChargeModel = RecommendChargeModel.this;
                sb.append(recommendChargeModel.getStatusName(recommendChargeModel.mStatus));
                sb.append(" for ");
                sb.append(xPPoiInfo.getName());
                sb.append(", error code: ");
                sb.append(routeResult.mErrorCode);
                L.i(tag, sb.toString());
                synchronized (build) {
                    if (routeResult.mErrorCode != 37) {
                        if (RecommendChargeModel.this.mRoutingMap.get(build) == null) {
                            L.Tag tag2 = RecommendChargeModel.TAG;
                            L.i(tag2, "this routing result is expired: " + j);
                        }
                        TBTManager.getInstance().clearRouteData(j);
                        long distanceFromCurrentPos = (long) LocationUtils.getDistanceFromCurrentPos(new XPCoordinate2DDouble(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat()));
                        recommendChargerBean.setNavDistance(distanceFromCurrentPos);
                        recommendChargerBean.setLeftDistance(i - distanceFromCurrentPos);
                        build.notify();
                    }
                }
            }
        });
        synchronized (build) {
            try {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "routing result wait: " + build + ", request id: " + requestRoute);
                }
                build.wait(ROUTE_TIME_OUT);
            } catch (InterruptedException unused) {
                L.i(TAG, "interrupt failed");
            }
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "routing result notify: " + build);
        }
        return this.mRoutingMap.remove(build);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarRemainDistanceChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onCarRemainDistanceChange: " + i + ", mLastDistance: " + this.mLastDistance + ", mLastUpdateTime: " + TimeFormatUtil.formatTime(this.mLastUpdateTime));
        }
        this.mHandler.removeMessages(1);
        this.mHandler.obtainMessage(1, Integer.valueOf(i)).sendToTarget();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
        onCarRemainDistanceChange(CarServiceManager.getInstance().getCarRemainDistance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ChargeComparator implements Comparator<XPPoiInfo> {
        private ChargeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(@NonNull XPPoiInfo xPPoiInfo, @NonNull XPPoiInfo xPPoiInfo2) {
            XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
            double distance = LocationUtils.getDistance(startPOIFromCurrent, xPPoiInfo);
            double distance2 = LocationUtils.getDistance(startPOIFromCurrent, xPPoiInfo2);
            XPDeepInfoPoi xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi();
            XPDeepInfoPoi xPDeepInfoPoi2 = xPPoiInfo2.getXPDeepInfoPoi();
            XPDeepCharging xPDeepCharging = null;
            XPDeepCharging xPDeepCharging2 = (xPDeepInfoPoi == null || xPDeepInfoPoi.getChargeData() == null || xPDeepInfoPoi.getChargeData().length <= 0) ? null : xPDeepInfoPoi.getChargeData()[0];
            if (xPDeepInfoPoi2 != null && xPDeepInfoPoi2.getChargeData() != null && xPDeepInfoPoi2.getChargeData().length > 0) {
                xPDeepCharging = xPDeepInfoPoi2.getChargeData()[0];
            }
            boolean z = true;
            boolean z2 = xPDeepCharging2 != null && xPDeepCharging2.getNumFastFree() > 0;
            if (xPDeepCharging == null || xPDeepCharging.getNumFastFree() <= 0) {
                z = false;
            }
            int compare = Boolean.compare(z2, z);
            return compare == 0 ? Double.compare(distance, distance2) : -compare;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class RecommendChargerHandler extends Handler {
        static final int MESSAGE_CAR_REMAIN_DISTANCE_CHANGE = 1;
        static final int MESSAGE_REFRESH_TIME = 7;
        static final int MESSAGE_ROUTE_FINISH = 6;
        static final int MESSAGE_START = 0;

        public RecommendChargerHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            if (L.ENABLE) {
                L.Tag tag = RecommendChargeModel.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("received message: ");
                sb.append(message.what);
                sb.append(", status: ");
                RecommendChargeModel recommendChargeModel = RecommendChargeModel.this;
                sb.append(recommendChargeModel.getStatusName(recommendChargeModel.mStatus));
                L.d(tag, sb.toString());
            }
            if (RecommendChargeModel.this.isAlive()) {
                int i = message.what;
                boolean z2 = true;
                if (i != 0) {
                    if (i == 1) {
                        if (RecommendChargeModel.this.mLastUpdateTime > 0) {
                            checkDistanceAndTimeChange(((Integer) message.obj).intValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    if (i != 7) {
                        return;
                    }
                    startOrScheduleProcess();
                    return;
                }
                int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
                if (L.ENABLE) {
                    L.d(RecommendChargeModel.TAG, "distance: " + carRemainDistance + ", mLastUpdateTime: " + TimeFormatUtil.formatTime(RecommendChargeModel.this.mLastUpdateTime));
                }
                if (RecommendChargeModel.this.mLastUpdateTime > 0) {
                    if (checkDistanceAndTimeChange(carRemainDistance) || RecommendChargeModel.this.mStatus == 1) {
                        return;
                    }
                    List<RecommendChargerBean> data = RecommendChargeModel.this.mFrequentChargeModel.getData();
                    if (data.size() == RecommendChargeModel.this.mFrequentCharges.size()) {
                        if (data.size() > 0) {
                            for (RecommendChargerBean recommendChargerBean : data) {
                                Iterator it = RecommendChargeModel.this.mFrequentCharges.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (recommendChargerBean.getId().equals(((RecommendChargerBean) it.next()).getId())) {
                                            z = true;
                                            continue;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        continue;
                                        break;
                                    }
                                }
                                if (!z) {
                                    break;
                                }
                            }
                        }
                        z2 = false;
                    }
                    if (!z2) {
                        RecommendChargeModel.this.scheduleRefresh();
                        return;
                    } else {
                        startOrScheduleProcess();
                        return;
                    }
                }
                startOrScheduleProcess();
            }
        }

        private boolean checkDistanceAndTimeChange(int i) {
            int abs = Math.abs(RecommendChargeModel.this.mLastDistance - i);
            long currentTimeMillis = System.currentTimeMillis() - RecommendChargeModel.this.mLastUpdateTime;
            if (abs >= 950 || currentTimeMillis >= XpCacheConsts.MAX_DISTANCE_FOR_HOME_COMUTTING_FORECAST) {
                L.Tag tag = RecommendChargeModel.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("update due to DISTANCE/TIME CHANGED, remain distance: ");
                sb.append(i);
                sb.append(", mLastDistance: ");
                sb.append(RecommendChargeModel.this.mLastDistance);
                sb.append(", mLastUpdateTime: ");
                sb.append(TimeFormatUtil.formatTime(RecommendChargeModel.this.mLastUpdateTime));
                sb.append(", status: ");
                RecommendChargeModel recommendChargeModel = RecommendChargeModel.this;
                sb.append(recommendChargeModel.getStatusName(recommendChargeModel.mStatus));
                L.i(tag, sb.toString());
                startOrScheduleProcess();
                return true;
            }
            return false;
        }

        private void startOrScheduleProcess() {
            L.Tag tag = RecommendChargeModel.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("startOrScheduleProcess  , status: ");
            RecommendChargeModel recommendChargeModel = RecommendChargeModel.this;
            sb.append(recommendChargeModel.getStatusName(recommendChargeModel.mStatus));
            L.i(tag, sb.toString());
            if (RecommendChargeModel.this.mStatus != 1) {
                RecommendChargeModel.this.startProcessRecommendCharges();
                RecommendChargeModel.this.scheduleRefresh();
                return;
            }
            RecommendChargeModel.this.setStatus(3);
        }
    }
}
