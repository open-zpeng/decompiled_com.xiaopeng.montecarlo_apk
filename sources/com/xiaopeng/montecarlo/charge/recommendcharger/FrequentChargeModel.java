package com.xiaopeng.montecarlo.charge.recommendcharger;

import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.ChargeStationInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IBdSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeAlwaysUseOnRemainRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeAlwaysUseRequest;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.navcore.search.param.XPCloudRouteStrategy;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class FrequentChargeModel {
    private static final L.Tag TAG = new L.Tag("FrequentChargeModel");
    private long mLastUpdateTime;
    private final Object mLock = new Object();
    private HashMap<String, RecommendChargerBean> mFrequentCharges = new HashMap<>();
    private boolean mIsLastTempUser = false;
    private IBdSearchService mBdSearchController = (IBdSearchService) HttpClientManager.getInstance().getService(IBdSearchService.class);

    public static int getStrategyFromStrategySetting() {
        int allSettingValue = SettingWrapper.getAllSettingValue();
        boolean isAvoidCongestionEnabled = SettingWrapper.isAvoidCongestionEnabled(allSettingValue);
        boolean isAvoidChargeEnabled = SettingWrapper.isAvoidChargeEnabled(allSettingValue);
        boolean isNoFreewaysEnabled = SettingWrapper.isNoFreewaysEnabled(allSettingValue);
        boolean isHighwayPriorityEnabled = SettingWrapper.isHighwayPriorityEnabled(allSettingValue);
        if (isAvoidCongestionEnabled && isAvoidChargeEnabled && isNoFreewaysEnabled) {
            return 18;
        }
        if (isAvoidCongestionEnabled && isNoFreewaysEnabled) {
            return 15;
        }
        if (isAvoidCongestionEnabled && isAvoidChargeEnabled) {
            return 17;
        }
        if (isAvoidChargeEnabled && isNoFreewaysEnabled) {
            return 16;
        }
        if (isAvoidCongestionEnabled && isHighwayPriorityEnabled) {
            return 20;
        }
        if (isHighwayPriorityEnabled) {
            return 19;
        }
        if (isAvoidChargeEnabled) {
            return 14;
        }
        if (isNoFreewaysEnabled) {
            return 13;
        }
        return isAvoidCongestionEnabled ? 12 : 10;
    }

    public List<RecommendChargerBean> getData() {
        if (this.mLastUpdateTime < 0 || System.currentTimeMillis() - this.mLastUpdateTime > XpCacheConsts.ONE_DAY || this.mIsLastTempUser != XPAccountServiceWrapper.getInstance().isTempType()) {
            fetchData();
        } else {
            updateCharge();
        }
        ArrayList arrayList = new ArrayList();
        for (RecommendChargerBean recommendChargerBean : this.mFrequentCharges.values()) {
            arrayList.add(recommendChargerBean);
        }
        return arrayList;
    }

    private void fetchData() {
        boolean isTempType = XPAccountServiceWrapper.getInstance().isTempType();
        this.mIsLastTempUser = isTempType;
        if (isTempType) {
            L.w(TAG, "fetchData: current is temp user! ");
            this.mFrequentCharges.clear();
            return;
        }
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        int strategyFromStrategySetting = getStrategyFromStrategySetting();
        if (!XPCloudRouteStrategy.isLegal(strategyFromStrategySetting)) {
            strategyFromStrategySetting = 10;
        }
        ChargeAlwaysUseRequest needDis = new ChargeAlwaysUseRequest().setVin(RootUtil.getVin()).setLat(new DecimalFormat("#.00000").format(startPOIFromCurrent.getDisplayLat())).setLng(new DecimalFormat("#.00000").format(startPOIFromCurrent.getDisplayLon())).setRemainDis(CarServiceManager.getInstance().getCarRemainDistance()).setNeedDis(1);
        if (!XPCloudRouteStrategy.isLegal(strategyFromStrategySetting)) {
            strategyFromStrategySetting = 10;
        }
        List<ChargeStationInfo> alwaysUse = this.mBdSearchController.alwaysUse(needDis.setStrategy(strategyFromStrategySetting).setCduId(RootUtil.getHardwareId()));
        if (alwaysUse == null) {
            L.i(TAG, "fetchData, responses is null");
            return;
        }
        HashMap hashMap = new HashMap();
        for (ChargeStationInfo chargeStationInfo : alwaysUse) {
            RecommendChargerBean chargeStationInfo2RecommendChargerBean = chargeStationInfo2RecommendChargerBean(chargeStationInfo);
            if (RecommendChargerBean.isHomeOrCompany(chargeStationInfo2RecommendChargerBean.getFrequentOriginalType())) {
                chargeStationInfo2RecommendChargerBean.setRecommendType(1000);
                chargeStationInfo2RecommendChargerBean.setType(chargeStationInfo2RecommendChargerBean.getFrequentOriginalType() + 1000);
                chargeStationInfo2RecommendChargerBean.generateXPPoiInfo();
                chargeStationInfo2RecommendChargerBean.getXPPoiInfo().setDistance(chargeStationInfo2RecommendChargerBean.getLineDistance());
                hashMap.put(chargeStationInfo2RecommendChargerBean.getId(), chargeStationInfo2RecommendChargerBean);
            }
        }
        if (hashMap.size() > 0) {
            this.mFrequentCharges.clear();
            this.mFrequentCharges.putAll(hashMap);
        }
        this.mLastUpdateTime = System.currentTimeMillis();
    }

    public void updateCharge() {
        if (this.mFrequentCharges.size() < 1) {
            return;
        }
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        int strategyFromStrategySetting = getStrategyFromStrategySetting();
        if (!XPCloudRouteStrategy.isLegal(strategyFromStrategySetting)) {
            strategyFromStrategySetting = 10;
        }
        ArrayList arrayList = new ArrayList();
        for (RecommendChargerBean recommendChargerBean : this.mFrequentCharges.values()) {
            arrayList.add(recommendChargerBean2ChargeStationInfo(recommendChargerBean));
        }
        ChargeAlwaysUseOnRemainRequest stations = new ChargeAlwaysUseOnRemainRequest().setLat(new DecimalFormat("#.00000").format(startPOIFromCurrent.getDisplayLat())).setLng(new DecimalFormat("#.00000").format(startPOIFromCurrent.getDisplayLon())).setRemainDis(CarServiceManager.getInstance().getCarRemainDistance()).setStations(arrayList);
        if (!XPCloudRouteStrategy.isLegal(strategyFromStrategySetting)) {
            strategyFromStrategySetting = 10;
        }
        List<ChargeStationInfo> alwaysUseOnRemain = this.mBdSearchController.alwaysUseOnRemain(stations.setStrategy(strategyFromStrategySetting).setVin(RootUtil.getVin()).setTs(System.currentTimeMillis()));
        if (alwaysUseOnRemain == null) {
            L.i(TAG, "updateCharge, responses is null");
            return;
        }
        for (ChargeStationInfo chargeStationInfo : alwaysUseOnRemain) {
            RecommendChargerBean recommendChargerBean2 = this.mFrequentCharges.get(chargeStationInfo.getStationId());
            if (recommendChargerBean2 != null) {
                recommendChargerBean2.setLeftDistance(chargeStationInfo.getOnRemainDis());
                if (chargeStationInfo.getLineDistance() > 0) {
                    double lineDistance = chargeStationInfo.getLineDistance();
                    if (recommendChargerBean2.getXPPoiInfo() != null) {
                        recommendChargerBean2.getXPPoiInfo().setDistance(lineDistance);
                    }
                    recommendChargerBean2.setLineDistance((long) lineDistance);
                }
                if (chargeStationInfo.getNavDistance() > 0) {
                    recommendChargerBean2.setNavDistance(chargeStationInfo.getNavDistance());
                }
            }
        }
    }

    private RecommendChargerBean chargeStationInfo2RecommendChargerBean(ChargeStationInfo chargeStationInfo) {
        if (chargeStationInfo == null) {
            return null;
        }
        RecommendChargerBean recommendChargerBean = new RecommendChargerBean();
        recommendChargerBean.setId(chargeStationInfo.getStationId());
        recommendChargerBean.setLon(Double.valueOf(chargeStationInfo.getLng()).doubleValue());
        recommendChargerBean.setLat(Double.valueOf(chargeStationInfo.getLat()).doubleValue());
        recommendChargerBean.setName(chargeStationInfo.getName());
        recommendChargerBean.setAddress(chargeStationInfo.getAddress());
        recommendChargerBean.setFrequentOriType(chargeStationInfo.getType());
        recommendChargerBean.setLeftDistance(chargeStationInfo.getOnRemainDis());
        recommendChargerBean.setLineDistance(chargeStationInfo.getLineDistance());
        recommendChargerBean.setNavDistance(chargeStationInfo.getNavDistance());
        recommendChargerBean.setSource(chargeStationInfo.getSource());
        recommendChargerBean.generateXPPoiInfo();
        return recommendChargerBean;
    }

    private ChargeStationInfo recommendChargerBean2ChargeStationInfo(RecommendChargerBean recommendChargerBean) {
        if (recommendChargerBean == null) {
            return null;
        }
        return new ChargeStationInfo().setName(recommendChargerBean.getName()).setAddress(recommendChargerBean.getAddress()).setLat(new DecimalFormat("#.00000").format(recommendChargerBean.getLat())).setLng(new DecimalFormat("#.00000").format(recommendChargerBean.getLon())).setSource(recommendChargerBean.getSource()).setType(recommendChargerBean.getFrequentOriginalType()).setStationId(recommendChargerBean.getId());
    }
}
