package com.xiaopeng.montecarlo.appengine;

import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.model.LocMatchInfo;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GuideInfoService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("GuideInfoService");

    @Publish
    public String getCongestionInfo() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            int currentStatus = TBTManager.getInstance().getCurrentStatus();
            jSONObject2.put("msgType", currentStatus);
            if (currentStatus == 0) {
                XPCruiseCongestionInfo cruiseCongestionInfo = TBTManager.getInstance().getCruiseCongestionInfo();
                if (cruiseCongestionInfo == null) {
                    L.i(TAG, "getCongestionInfo current is cruise but congestion is null");
                    return null;
                }
                jSONObject2.put("roadName", cruiseCongestionInfo.mRoadName);
                jSONObject2.put("congestionStatus", cruiseCongestionInfo.mCongestionStatus);
                jSONObject2.put("etaTime", cruiseCongestionInfo.mEtaTime);
                jSONObject2.put(DebugConfiguration.DebugActionExtra.CRUISE_CONGESTION_LENGTH, cruiseCongestionInfo.mLength);
            } else {
                XPNaviCongestionInfo naviCongestionInfo = TBTManager.getInstance().getNaviCongestionInfo();
                if (naviCongestionInfo != null && naviCongestionInfo.mCongestionInfos != null && naviCongestionInfo.mCongestionInfos.length > 0) {
                    jSONObject2.put("etaTime", naviCongestionInfo.mTotalTimeOfSeconds);
                    jSONObject2.put(DebugConfiguration.DebugActionExtra.CRUISE_CONGESTION_LENGTH, naviCongestionInfo.mTotalRemainDist);
                    if (naviCongestionInfo.mCongestionInfos[0] != null) {
                        jSONObject2.put("scopeFlag", naviCongestionInfo.mCongestionInfos[0].mScopeFlag);
                    } else {
                        jSONObject2.put("scopeFlag", 0);
                    }
                }
                L.i(TAG, "getCongestionInfo current is navi but congestion is null or congestion detail info is null");
                return null;
            }
            jSONObject.put("congestionInfo", jSONObject2);
        } catch (JSONException e) {
            L.i(TAG, "getCongestionInfo to json failed");
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            L.i(TAG, "getCongestionInfo data=" + jSONObject.toString());
            return jSONObject.toString();
        }
        return null;
    }

    @Publish
    public String getHighWayInfo() {
        return TBTManager.getInstance().getHighWayInfo();
    }

    @Publish
    public String getTBTStatus() {
        JSONObject jSONObject = new JSONObject();
        try {
            int currentStatus = TBTManager.getInstance().getCurrentStatus();
            if (3 == currentStatus) {
                currentStatus = 0;
            }
            jSONObject.put("tbtStatus", currentStatus);
        } catch (JSONException e) {
            L.i(TAG, "getTBTStatus to json failed");
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            L.i(TAG, "getTBTStatus data=" + jSONObject.toString());
            return jSONObject.toString();
        }
        return null;
    }

    @Publish
    public String getCurrentLocationInfo() {
        int i;
        double d;
        double d2;
        JSONObject jSONObject = new JSONObject();
        try {
            LocInfo currentLocInfo = TBTManager.getInstance().getCurrentLocInfo();
            int i2 = -1;
            int i3 = 0;
            boolean z = true;
            if (currentLocInfo != null && currentLocInfo.matchInfoCnt > 0 && CollectionUtils.isNotEmpty(currentLocInfo.matchInfo)) {
                LocMatchInfo locMatchInfo = currentLocInfo.matchInfo.get(0);
                d = 23.1595867537d;
                d2 = 113.3850753307d;
                if (locMatchInfo != null) {
                    i2 = locMatchInfo.roadClass;
                    int i4 = locMatchInfo.linkType;
                    i = locMatchInfo.formway;
                    if (locMatchInfo.stPos != null) {
                        d = locMatchInfo.stPos.lat;
                        d2 = locMatchInfo.stPos.lon;
                        z = false;
                    }
                    i3 = i4;
                } else {
                    i = -1;
                }
            } else {
                double d3 = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LON, 113385075L) / 1000000.0d;
                double d4 = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LAT, 23159586L) / 1000000.0d;
                L.i(TAG, "getCurrentLocationInfo() matchPosLon:" + d3 + "matchPosLat;:" + d4);
                i = -1;
                d = d4;
                d2 = d3;
            }
            jSONObject.put("roadClass", i2);
            jSONObject.put("linkType", i3);
            jSONObject.put("formway", i);
            jSONObject.put("matchPosLat", d);
            jSONObject.put("matchPosLon", d2);
            jSONObject.put("isDefaultPos", z);
            jSONObject.put("cityName", DRServiceManager.getInstance().getCityName());
        } catch (JSONException e) {
            L.w(TAG, "LocInfo to json failed");
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            L.i(TAG, "LocInfo data=" + jSONObject.toString());
            return jSONObject.toString();
        }
        return null;
    }
}
