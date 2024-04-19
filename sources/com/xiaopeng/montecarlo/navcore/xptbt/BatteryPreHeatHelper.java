package com.xiaopeng.montecarlo.navcore.xptbt;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.powerdistance.PowerDistanceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.BatteryPreHeatBean;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPVariantPath;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.validation.constraints.NotNull;
/* loaded from: classes3.dex */
public class BatteryPreHeatHelper implements CarServiceManager.IXPCarStateListener {
    private static final int LOG_PRINT_FREQUENCY = 10;
    private static final int MAX_SEGMENT_LENGTH = 100;
    private static final int MAX_VALUE = 255;
    private static final L.Tag TAG = new L.Tag("BatteryPreHeatHelper");
    private XPPoiInfo mDest;
    private IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private BatteryPreHeatBean mBatteryPreHeatBean = new BatteryPreHeatBean();
    private long mCount = 0;
    private boolean mNeedSendDetail = false;
    private BaseNaviListener mBaseNaviListener = new BaseNaviListener() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.BatteryPreHeatHelper.1
        @Override // com.xiaopeng.montecarlo.navcore.xptbt.BaseNaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
        public void onUpdateNaviInfo(final List<XPNaviInfo> list) {
            WorkThreadUtil.getInstance().executeBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.BatteryPreHeatHelper.1.1
                @Override // java.lang.Runnable
                public void run() {
                    XPNaviInfo xPNaviInfo;
                    int i;
                    int i2;
                    int currentStatus = TBTManager.getInstance().getCurrentStatus();
                    if (currentStatus > 2) {
                        currentStatus = 0;
                    }
                    if (currentStatus == 0 || CollectionUtils.isEmpty(list) || (xPNaviInfo = (XPNaviInfo) list.get(0)) == null) {
                        return;
                    }
                    if (!CollectionUtils.isEmpty(xPNaviInfo.mViaRemainDist) && !CollectionUtils.isEmpty(xPNaviInfo.mViaRemainTime)) {
                        i = xPNaviInfo.mViaRemainDist[0] / 1000;
                        i2 = xPNaviInfo.mViaRemainTime[0] / 60;
                    } else {
                        i = ((int) xPNaviInfo.mRouteRemainDist) / 1000;
                        i2 = ((int) xPNaviInfo.mRouteRemainTime) / 60;
                    }
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setRemainDis(Math.min(i, 255));
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setRemainTime(Math.min(i2, 255));
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setNavigationType(currentStatus);
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setKValue(PowerDistanceManager.getInstance().getKValue(xPNaviInfo.mPathID));
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setPathID(xPNaviInfo.mPathID);
                    if (BatteryPreHeatHelper.this.isDestChange()) {
                        BatteryPreHeatHelper.this.searchDestType(BatteryPreHeatHelper.this.mDest);
                    }
                    if (BatteryPreHeatHelper.this.mNeedSendDetail) {
                        L.i(BatteryPreHeatHelper.TAG, "enter mNeedSendDetail");
                        BatteryPreHeatHelper.this.mNeedSendDetail = false;
                        BatteryPreHeatHelper.this.mBatteryPreHeatBean.setRoadSeqStages(BatteryPreHeatHelper.this.getRoadSeqStages());
                        BatteryPreHeatHelper.this.sendDetailData();
                        return;
                    }
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setRoadSeqStages(null);
                    BatteryPreHeatHelper.this.sendSimpleData(false);
                }
            });
        }

        @Override // com.xiaopeng.montecarlo.navcore.xptbt.BaseNaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
        public void onNaviStop(final int i, boolean z) {
            WorkThreadUtil.getInstance().executeBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.BatteryPreHeatHelper.1.2
                @Override // java.lang.Runnable
                public void run() {
                    int currentStatus = TBTManager.getInstance().getCurrentStatus();
                    L.Tag tag = BatteryPreHeatHelper.TAG;
                    L.i(tag, "onNaviStop type:" + i + ", status:" + currentStatus);
                    if (currentStatus > 2) {
                        currentStatus = 0;
                    }
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setNavigationType(currentStatus);
                    BatteryPreHeatHelper.this.sendSimpleData(true);
                }
            });
        }

        @Override // com.xiaopeng.montecarlo.navcore.xptbt.BaseNaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
        public void onNaviStart(final int i) {
            WorkThreadUtil.getInstance().executeBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.BatteryPreHeatHelper.1.3
                @Override // java.lang.Runnable
                public void run() {
                    int currentStatus = TBTManager.getInstance().getCurrentStatus();
                    L.Tag tag = BatteryPreHeatHelper.TAG;
                    L.i(tag, "onNaviStart type:" + i + ", status:" + currentStatus);
                    if (currentStatus > 2) {
                        currentStatus = 0;
                    }
                    BatteryPreHeatHelper.this.mBatteryPreHeatBean.setNavigationType(currentStatus);
                    BatteryPreHeatHelper.this.sendSimpleData(true);
                }
            });
        }
    };

    public void start() {
        L.i(TAG, "start");
        TBTManager.getInstance().addNaviListener(this.mBaseNaviListener);
        CarServiceManager.getInstance().addCarStateListener(this);
    }

    public void stop() {
        L.i(TAG, "stop");
        TBTManager.getInstance().removeNaviListener(this.mBaseNaviListener);
        CarServiceManager.getInstance().removeCarStateListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestChange() {
        XPViaPoint xPViaPoint;
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        List<XPViaPoint> unPassedViasPoiInfo = TBTManager.getInstance().getUnPassedViasPoiInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        if (CollectionUtils.isNotEmpty(unPassedViasPoiInfo) && (xPViaPoint = unPassedViasPoiInfo.get(0)) != null) {
            endInfo = xPViaPoint.getPoiPoint();
        }
        if (endInfo == null) {
            L.w(TAG, "isDestChange xpPoiInfo is null");
            return false;
        }
        XPPoiInfo xPPoiInfo = this.mDest;
        if (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getPoiId())) {
            this.mDest = endInfo;
            return true;
        } else if (this.mDest.getPoiId().equalsIgnoreCase(endInfo.getPoiId())) {
            return false;
        } else {
            this.mDest = endInfo;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchDestType(@NotNull XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.w(TAG, "searchDestType xpPoiInfo is null");
            return;
        }
        int i = 0;
        if (XPPoiCategory.isCharge(xPPoiInfo.getCategory())) {
            XPDeepCharging xPDeepCharging = (XPDeepCharging) Optional.ofNullable(xPPoiInfo).map($$Lambda$keL39oucN_Rjy4R361GtJ6_g2Go.INSTANCE).map($$Lambda$FtjFyCh3jC3CGvdCU1dCI0T1CKc.INSTANCE).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$BatteryPreHeatHelper$3xxurGgbzy57fwDLpgY0rFGnEwk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BatteryPreHeatHelper.lambda$searchDestType$0((XPDeepCharging[]) obj);
                }
            }).orElse(null);
            if (xPDeepCharging != null) {
                if (xPDeepCharging.getNumFast() > 0) {
                    i = XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory()) ? 1 : 2;
                }
            } else {
                XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
                final ChargeSearchByOneRequest stationIds = new ChargeSearchByOneRequest().setLat(new DecimalFormat("#.00000").format(currentLocation.mLat)).setLng(new DecimalFormat("#.00000").format(currentLocation.mLon)).setDetail(true).setStationIds(xPPoiInfo.getPoiId());
                WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$BatteryPreHeatHelper$Y85a6Cptmz_SS5zD6WvainKtYkE
                    @Override // java.lang.Runnable
                    public final void run() {
                        BatteryPreHeatHelper.this.lambda$searchDestType$2$BatteryPreHeatHelper(stationIds);
                    }
                });
            }
        }
        L.Tag tag = TAG;
        L.i(tag, "poiId:" + xPPoiInfo.getPoiId() + ", category:" + xPPoiInfo.getCategory() + ", destType:" + i);
        this.mBatteryPreHeatBean.setDestType(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ XPDeepCharging lambda$searchDestType$0(XPDeepCharging[] xPDeepChargingArr) {
        return xPDeepChargingArr[0];
    }

    public /* synthetic */ void lambda$searchDestType$2$BatteryPreHeatHelper(ChargeSearchByOneRequest chargeSearchByOneRequest) {
        List<XPPoiInfo> fetchXPPoiInfoListFromSearchByOneResponse = HttpResponseConverter.fetchXPPoiInfoListFromSearchByOneResponse(this.mChargeStationSearchService.searchByOne(chargeSearchByOneRequest));
        if (CollectionUtils.isNotEmpty(fetchXPPoiInfoListFromSearchByOneResponse) && fetchXPPoiInfoListFromSearchByOneResponse.get(0) != null) {
            XPDeepCharging xPDeepCharging = (XPDeepCharging) Optional.ofNullable(fetchXPPoiInfoListFromSearchByOneResponse.get(0)).map($$Lambda$keL39oucN_Rjy4R361GtJ6_g2Go.INSTANCE).map($$Lambda$FtjFyCh3jC3CGvdCU1dCI0T1CKc.INSTANCE).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$BatteryPreHeatHelper$50HOQg2lIW1T2rVJ040oothTDRw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BatteryPreHeatHelper.lambda$null$1((XPDeepCharging[]) obj);
                }
            }).orElse(null);
            if (xPDeepCharging != null && xPDeepCharging.getNumFast() > 0) {
                if (XPPoiCategory.isXPSelfCharge(fetchXPPoiInfoListFromSearchByOneResponse.get(0).getCategory())) {
                    L.i(TAG, "search result is DEST_TYPE_FAST_CHARGE_XP");
                    this.mBatteryPreHeatBean.setDestType(1);
                    return;
                }
                L.i(TAG, "search result is DEST_TYPE_FAST_CHARGE_OTHER");
                this.mBatteryPreHeatBean.setDestType(2);
                return;
            }
            L.i(TAG, "search result is DEST_TYPE_OTHER_CHARGE");
            this.mBatteryPreHeatBean.setDestType(0);
            return;
        }
        L.w(TAG, "xpPoiInfos is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ XPDeepCharging lambda$null$1(XPDeepCharging[] xPDeepChargingArr) {
        return xPDeepChargingArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BatteryPreHeatBean.RoadSeqStages> getRoadSeqStages() {
        IVariantPath path;
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        ArrayList arrayList = null;
        if (routeResult != null && routeResult.mPathResult != null && (path = routeResult.mPathResult.getPath(TBTManager.getInstance().getCurrentRoutePathIndex())) != null && (path instanceof XPVariantPath)) {
            arrayList = new ArrayList();
            XPDrivePathAccessor drivePathAccessor = path.getDrivePathAccessor();
            if (drivePathAccessor != null) {
                XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
                int segmentCount = (int) drivePathAccessor.getSegmentCount();
                if (CollectionUtils.isNotEmpty(drivePathAccessor.getViaPointInfo())) {
                    segmentCount = drivePathAccessor.getViaPointInfo().get(0).segmentIdx;
                }
                for (int i = naviInfo != null ? naviInfo.mCurSegIdx : 0; i <= segmentCount; i++) {
                    XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(i);
                    if (segmentAccessor != null) {
                        if (arrayList.size() < 100) {
                            BatteryPreHeatBean.RoadSeqStages roadSeqStages = new BatteryPreHeatBean.RoadSeqStages();
                            roadSeqStages.setDs(segmentAccessor.getLength());
                            roadSeqStages.setTs(segmentAccessor.getTravelTime());
                            arrayList.add(roadSeqStages);
                        } else {
                            BatteryPreHeatBean.RoadSeqStages roadSeqStages2 = (BatteryPreHeatBean.RoadSeqStages) arrayList.get(arrayList.size() - 1);
                            roadSeqStages2.setDs(roadSeqStages2.getDs() + segmentAccessor.getLength());
                            roadSeqStages2.setTs(roadSeqStages2.getTs() + segmentAccessor.getTravelTime());
                        }
                    }
                }
                drivePathAccessor.recycle();
                L.Tag tag = TAG;
                L.i(tag, "sendRoadSeqStages list:" + arrayList.size());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSimpleData(boolean z) {
        if (z) {
            L.i(TAG, "sendSimpleData " + GsonUtil.toJson(this.mBatteryPreHeatBean));
        } else {
            if (0 == this.mCount % 10) {
                L.i(TAG, "sendSimpleData " + GsonUtil.toJson(this.mBatteryPreHeatBean));
            }
            this.mCount++;
        }
        CarServiceManager.getInstance().setNaviDestType(this.mBatteryPreHeatBean.getDestType());
        CarServiceManager.getInstance().setNaviRemainDistance((int) this.mBatteryPreHeatBean.getRemainDis());
        CarServiceManager.getInstance().setNaviRemainTime((int) this.mBatteryPreHeatBean.getRemainTime());
        CarServiceManager.getInstance().setNaviPathId((int) this.mBatteryPreHeatBean.getPathID());
        CarServiceManager.getInstance().setNaviType(this.mBatteryPreHeatBean.getNavigationType());
        CarServiceManager.getInstance().setNaviKValue((float) this.mBatteryPreHeatBean.getKValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDetailData() {
        String json = GsonUtil.toJson(this.mBatteryPreHeatBean);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendDetailData " + json);
        }
        CarServiceManager.getInstance().setNaviDestInfo(json);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onNaviDestInfoReq() {
        L.i(TAG, "onNaviDestInfoReq");
        WorkThreadUtil.getInstance().executeBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.BatteryPreHeatHelper.2
            @Override // java.lang.Runnable
            public void run() {
                BatteryPreHeatHelper.this.mNeedSendDetail = true;
            }
        });
    }
}
