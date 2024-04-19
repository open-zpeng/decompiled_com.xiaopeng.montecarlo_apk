package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviMultiQueryRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviQueryRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviMultiQueryResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviQueryResponse;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.sapa.SapaData;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
/* loaded from: classes3.dex */
public class SapaChargeDataHelper {
    private static final int INTERVAL_QUERY_CHARGE_DATA = 120000;
    private static final int MSG_QUERY_CHARGE_DETAIL = 2;
    private static final int MSG_QUERY_CHARGE_ID = 1;
    private static final L.Tag TAG = new L.Tag("SapaChargeDataHelper");
    private SapaChargeListener mListener;
    private ConcurrentHashMap<String, SapaData> mSapaDataHashMap = new ConcurrentHashMap<>();
    private INaviSearchService mNaviSearchService = (INaviSearchService) HttpClientManager.getInstance().getService(INaviSearchService.class);
    private IChargeStationSearchService mChargeSearch = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private Handler mHandler = new BroadcastHandler(WorkThreadUtil.getInstance().getStatusThreadLooper());

    /* loaded from: classes3.dex */
    public interface SapaChargeListener {
        void onChargeInfoUpdate();
    }

    public SapaChargeDataHelper(SapaChargeListener sapaChargeListener) {
        this.mListener = sapaChargeListener;
    }

    @MainThread
    public void release() {
        L.i(TAG, "release");
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
    }

    public SapaData getCache(String str) {
        return this.mSapaDataHashMap.get(str);
    }

    @MainThread
    public void update(List<SapaData> list) {
        if (CarFeatureManager.INSTANCE.isSapaChargeEnable() && !CollectionUtils.isEmpty(list)) {
            ArrayList<SapaData> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (SapaData sapaData : list) {
                if (sapaData != null && sapaData.mXPFacilityInfo != null && sapaData.mXPFacilityInfo.mType == 0) {
                    SapaData sapaData2 = this.mSapaDataHashMap.get(sapaData.mXPFacilityInfo.mName);
                    if (sapaData2 != null) {
                        arrayList.add(sapaData2);
                    } else {
                        sapaData.mCharegeInfo.mId = null;
                        arrayList.add(sapaData);
                        arrayList2.add(sapaData);
                        L.Tag tag = TAG;
                        L.i(tag, "add new service area:" + sapaData.mXPFacilityInfo.mName);
                    }
                }
            }
            this.mSapaDataHashMap.clear();
            for (SapaData sapaData3 : arrayList) {
                this.mSapaDataHashMap.put(sapaData3.mXPFacilityInfo.mName, sapaData3);
            }
            if (CollectionUtils.isNotEmpty(arrayList2)) {
                if (this.mHandler.hasMessages(1)) {
                    this.mHandler.removeMessages(1);
                }
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(1, arrayList2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void queryChargeId(List<SapaData> list) {
        SapaData sapaData;
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SapaData sapaData2 : list) {
            if (sapaData2 != null && sapaData2.mXPFacilityInfo != null && sapaData2.mXPFacilityInfo.mPos != null) {
                arrayList.add(new NaviQueryRequest().setCategory(XPNaviSearchParam.PARAM_CATEGORY_VALUE_CHARGE).setType(Integer.valueOf(XPNaviSearchParam.PARAM_TYPE_VALUE_AOI).intValue()).setAoiInfo(new NaviQueryRequest.NaviQueryAoiInfo().setAoiId("").setLat(sapaData2.mXPFacilityInfo.mPos.mLat).setLon(sapaData2.mXPFacilityInfo.mPos.mLon).setName(sapaData2.mXPFacilityInfo.mName).setCategory("180300")));
            }
        }
        NaviMultiQueryResponse multiQuery = this.mNaviSearchService.multiQuery(new NaviMultiQueryRequest().setType(Integer.valueOf(XPNaviSearchParam.PARAM_TYPE_VALUE_AOI).intValue()).setRequestList(arrayList));
        if (multiQuery != null) {
            List<NaviQueryResponse> resultList = multiQuery.getResultList();
            if (CollectionUtils.isNotEmpty(resultList)) {
                int i = 0;
                while (i < resultList.size()) {
                    StringBuilder sb = new StringBuilder();
                    List<XPPoiInfo> fetchXPPoiInfoListFromNaviQueryResponse = HttpResponseConverter.fetchXPPoiInfoListFromNaviQueryResponse(resultList.get(i));
                    if (CollectionUtils.isNotEmpty(fetchXPPoiInfoListFromNaviQueryResponse)) {
                        for (int i2 = 0; i2 < fetchXPPoiInfoListFromNaviQueryResponse.size(); i2++) {
                            XPPoiInfo xPPoiInfo = fetchXPPoiInfoListFromNaviQueryResponse.get(i2);
                            if (xPPoiInfo != null) {
                                sb.append(xPPoiInfo.getPoiId());
                                if (i2 < fetchXPPoiInfoListFromNaviQueryResponse.size() - 1) {
                                    sb.append(",");
                                }
                            }
                        }
                    }
                    String str = (i >= list.size() || (sapaData = list.get(i)) == null || sapaData.mXPFacilityInfo == null) ? "" : sapaData.mXPFacilityInfo.mName;
                    SapaData sapaData3 = this.mSapaDataHashMap.get(str);
                    if (sapaData3 != null) {
                        sapaData3.mCharegeInfo.mId = sb.toString();
                    }
                    L.i(TAG, "service area:" + str + ", chargeId:" + sb.toString());
                    i++;
                }
            }
        }
        queryChargeDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void queryChargeDetail() {
        XPDeepCharging xPDeepCharging;
        Collection<SapaData> values = this.mSapaDataHashMap.values();
        if (CollectionUtils.isEmpty(values)) {
            L.w(TAG, "queryChargeDetail collection:" + values);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (SapaData sapaData : values) {
            if (sapaData != null && sapaData.mCharegeInfo != null && !TextUtils.isEmpty(sapaData.mCharegeInfo.mId)) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(sapaData.mCharegeInfo.mId);
            }
        }
        new ArrayList();
        if (!TextUtils.isEmpty(sb.toString())) {
            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            List<XPPoiInfo> fetchXPPoiInfoListFromSearchByOneResponse = HttpResponseConverter.fetchXPPoiInfoListFromSearchByOneResponse(this.mChargeSearch.searchByOne(new ChargeSearchByOneRequest().setLat(new DecimalFormat("#.00000").format(currentLocation.mLat)).setLng(new DecimalFormat("#.00000").format(currentLocation.mLon)).setDetail(false).setStationIds(sb.toString())));
            L.i(TAG, "queryChargeDetail id:" + sb.toString() + ", result:" + fetchXPPoiInfoListFromSearchByOneResponse.size());
            for (SapaData sapaData2 : values) {
                L.i(TAG, "name:" + sapaData2.mXPFacilityInfo.mName + ", id:" + sapaData2.mCharegeInfo.mId);
                if (sapaData2 != null && sapaData2.mCharegeInfo != null && !TextUtils.isEmpty(sapaData2.mCharegeInfo.mId)) {
                    if (!CollectionUtils.isEmpty(fetchXPPoiInfoListFromSearchByOneResponse)) {
                        sapaData2.mCharegeInfo.mFastFreeNums = 0;
                        sapaData2.mCharegeInfo.mSlowFreeNums = 0;
                    }
                    for (XPPoiInfo xPPoiInfo : fetchXPPoiInfoListFromSearchByOneResponse) {
                        if (sapaData2.mCharegeInfo.mId.contains(xPPoiInfo.getPoiId()) && (xPDeepCharging = (XPDeepCharging) Optional.ofNullable(xPPoiInfo).map(new Function() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$keL39oucN_Rjy4R361GtJ6_g2Go
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return ((XPPoiInfo) obj).getXPDeepInfoPoi();
                            }
                        }).map(new Function() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$FtjFyCh3jC3CGvdCU1dCI0T1CKc
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return ((XPDeepInfoPoi) obj).getChargeData();
                            }
                        }).map(new Function() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$SapaChargeDataHelper$kuqp2X5e1hNy_Fb1D1eAzVoHnts
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return SapaChargeDataHelper.lambda$queryChargeDetail$0((XPDeepCharging[]) obj);
                            }
                        }).orElse(null)) != null) {
                            sapaData2.mCharegeInfo.mFastFreeNums += xPDeepCharging.getNumFastFree();
                            sapaData2.mCharegeInfo.mSlowFreeNums += xPDeepCharging.getNumSlowFree();
                            sapaData2.mCharegeInfo.mUltraFreeNums += xPDeepCharging.getNumUltraFree();
                            sapaData2.mCharegeInfo.mFastTotalNums += xPDeepCharging.getNumFast();
                            sapaData2.mCharegeInfo.mSlowTotalNums += xPDeepCharging.getNumSlow();
                            sapaData2.mCharegeInfo.mUltraTotalNums += xPDeepCharging.getNumUltra();
                        }
                    }
                    L.i(TAG, "service area:" + sapaData2.mXPFacilityInfo.mName + ", chargeId:" + sapaData2.mCharegeInfo.mId + ", fast:" + sapaData2.mCharegeInfo.mFastFreeNums + ", slow:" + sapaData2.mCharegeInfo.mSlowFreeNums);
                }
            }
            SapaChargeListener sapaChargeListener = this.mListener;
            if (sapaChargeListener != null) {
                sapaChargeListener.onChargeInfoUpdate();
            } else {
                L.w(TAG, "mListener is null");
            }
            if (this.mHandler.hasMessages(2)) {
                this.mHandler.removeMessages(2);
            }
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(2), XpCacheConsts.MAX_DISTANCE_FOR_HOME_COMUTTING_FORECAST);
            return;
        }
        L.i(TAG, "no charge id to query");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ XPDeepCharging lambda$queryChargeDetail$0(XPDeepCharging[] xPDeepChargingArr) {
        return xPDeepChargingArr[0];
    }

    /* loaded from: classes3.dex */
    private class BroadcastHandler extends Handler {
        public BroadcastHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 1) {
                SapaChargeDataHelper.this.queryChargeId((List) message.obj);
            } else if (i != 2) {
            } else {
                SapaChargeDataHelper.this.queryChargeDetail();
            }
        }
    }
}
