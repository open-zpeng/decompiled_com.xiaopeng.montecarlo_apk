package com.xiaopeng.montecarlo.scenes.restrictscene;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaDataRuleRes;
import com.autonavi.gbl.aosclient.model.GRestrictCity;
import com.autonavi.gbl.aosclient.model.GRestrictRule;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceManager;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRestrictionInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class RestrictManager {
    private static final L.Tag TAG = new L.Tag("RestrictManager");
    private static final RestrictManager sInstance = new RestrictManager();

    public boolean isRouteIsRestrict(int i) {
        boolean z;
        switch (i) {
            case -1:
            case 0:
            case 1:
            default:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                z = true;
                break;
        }
        return !z;
    }

    private RestrictManager() {
    }

    @NonNull
    public static RestrictManager getInstance() {
        return sInstance;
    }

    public void requestRestrictedRule(long j) {
        XPPoiInfo poiPoint;
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(j);
        if (routeData != null) {
            XPPoiInfo xPPoiInfo = routeData.mRouteParams.mStartInfo;
            XPPoiInfo xPPoiInfo2 = routeData.mRouteParams.mEndInfo;
            List<XPViaPoint> list = routeData.mRouteParams.mViaInfos;
            if (xPPoiInfo2 == null || xPPoiInfo == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int adCodeByLonLat = MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(xPPoiInfo));
            sb.append(adCodeByLonLat);
            sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
            int adCodeByLonLat2 = MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(xPPoiInfo2));
            sb.append(adCodeByLonLat2);
            boolean hasNewRecord = hasNewRecord(!RestrictHelper.getRestrictTipStatusByAdCode(Integer.toString(adCodeByLonLat)), adCodeByLonLat2);
            if (CollectionUtils.isNotEmpty(list)) {
                for (XPViaPoint xPViaPoint : list) {
                    if (xPViaPoint != null && (poiPoint = xPViaPoint.getPoiPoint()) != null) {
                        sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                        int adCodeByLonLat3 = MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(poiPoint));
                        sb.append(adCodeByLonLat3);
                        hasNewRecord = hasNewRecord(hasNewRecord, adCodeByLonLat3);
                    }
                }
            }
            String licensePlate = SettingWrapper.getLicensePlate();
            if (TextUtils.isEmpty(licensePlate)) {
                licensePlate = BLParams.AOS_RESTRICTED_AREA_NO_PLATE_DEFAULT;
            }
            L.Tag tag = TAG;
            L.i(tag, "requestRestrictedRule: " + sb.toString() + ", hasNewRecord: " + hasNewRecord + ", plate: " + licensePlate);
            AosServiceManager.getInstance().requestRestrictedAreaByAdcode(licensePlate, sb.toString());
        }
    }

    private boolean hasNewRecord(boolean z, int i) {
        return z || !RestrictHelper.getRestrictTipStatusByAdCode(Integer.toString(i));
    }

    public int abortRequest(long j) {
        if (j < 0) {
            return 0;
        }
        return AosServiceWrapper.getInstance().abortRequest(j);
    }

    private boolean isRestrictionValid(GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes) {
        boolean z = false;
        if (gReStrictedAreaDataRuleRes != null && CollectionUtils.isNotEmpty(gReStrictedAreaDataRuleRes.cities)) {
            Iterator<GRestrictCity> it = gReStrictedAreaDataRuleRes.cities.iterator();
            while (it.hasNext()) {
                GRestrictCity next = it.next();
                if (next != null && CollectionUtils.isNotEmpty(next.rules)) {
                    Iterator<GRestrictRule> it2 = next.rules.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        GRestrictRule next2 = it2.next();
                        if (next2 != null && next2.effect == 1) {
                            z = true;
                            break;
                        }
                    }
                }
            }
        }
        return z;
    }

    public boolean isOpenVehicleRestriction() {
        return SettingWrapper.isOpenPlateSwitch();
    }

    @MainThread
    public XPRestrictionInfo getRestrictInfoByCurrentPath() {
        RouteResult.RouteInfo routeInfo;
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        if (routeResult == null || (routeInfo = routeResult.getRouteInfo(TBTManager.getInstance().getCurrentRoutePathIndex())) == null) {
            return null;
        }
        return routeInfo.mRestrictionInfo;
    }

    public boolean isSetLicencePlate() {
        return !TextUtils.isEmpty(SettingWrapper.getLicensePlate());
    }

    public int getStartCityCode() {
        XPPoiInfo startInfo = TBTManager.getInstance().getStartInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        if (startInfo != null) {
            return MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(startInfo));
        }
        return -1;
    }

    public int getEndCityCode() {
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        if (endInfo != null) {
            return MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(endInfo));
        }
        return -1;
    }
}
