package com.xiaopeng.montecarlo.navcore.search.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.data.model.AreaExtraInfo;
import com.autonavi.gbl.search.model.NearestPoi;
import com.autonavi.gbl.search.model.SearchNearestResult;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.request.NearestSearchRequest;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class XPNearestResponse extends XPSearchResponse<SearchNearestResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse
    public XPSearchResult parseBody(@NonNull SearchNearestResult searchNearestResult) {
        XPSearchResult xPSearchResult = new XPSearchResult();
        ArrayList<NearestPoi> arrayList = searchNearestResult.poi_list;
        if (arrayList == null) {
            return xPSearchResult;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            NearestPoi nearestPoi = arrayList.get(i);
            if (L.ENABLE) {
                L.d(TAG, GsonUtil.toJson(nearestPoi));
            }
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            xPPoiInfo.setAddress(nearestPoi.address);
            xPPoiInfo.setName(nearestPoi.name);
            xPPoiInfo.setPoiId(nearestPoi.poiid);
            xPPoiInfo.setPoiSource(2);
            xPPoiInfo.setCategory(XPPoiCategory.transformCategory(nearestPoi.typecode));
            xPPoiInfo.setBlCategory(nearestPoi.typecode);
            xPPoiInfo.setTag(nearestPoi.type);
            xPPoiInfo.setTel(nearestPoi.tel);
            xPPoiInfo.setAdCode(nearestPoi.nAdCode);
            xPPoiInfo.setCityCode(String.valueOf(nearestPoi.nCityAdCode));
            AreaExtraInfo areaExtraInfo = MapDataManager.getInstance().getAreaExtraInfo(nearestPoi.nAdCode);
            if (areaExtraInfo != null) {
                xPPoiInfo.setCityName(areaExtraInfo.cityName);
                xPPoiInfo.setProvinceName(areaExtraInfo.provName);
                xPPoiInfo.setDistrictName(areaExtraInfo.townName);
            }
            if (nearestPoi.point != null) {
                xPPoiInfo.setDisplayLon(nearestPoi.point.lon);
                xPPoiInfo.setDisplayLat(nearestPoi.point.lat);
            }
            if (nearestPoi.naviPoint != null) {
                xPPoiInfo.setNaviLon(nearestPoi.naviPoint.lon);
                xPPoiInfo.setNaviLat(nearestPoi.naviPoint.lat);
            }
            xPPoiInfo.setOffline(searchNearestResult.iPoiType == 0);
            xPPoiInfo.setDistance(getDistance(xPPoiInfo));
            checkAndGenerateBlSupplePoiId(xPPoiInfo);
            arrayList2.add(xPPoiInfo);
        }
        Collections.sort(arrayList2, new Comparator<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.navcore.search.response.XPNearestResponse.1
            @Override // java.util.Comparator
            public int compare(@Nullable XPPoiInfo xPPoiInfo2, @Nullable XPPoiInfo xPPoiInfo3) {
                if (xPPoiInfo3 == null) {
                    return -1;
                }
                return (xPPoiInfo2 != null && xPPoiInfo2.getDistance() - xPPoiInfo3.getDistance() < 0.0d) ? -1 : 1;
            }
        });
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                XPPoiInfo xPPoiInfo2 = (XPPoiInfo) it.next();
                xPPoiInfo2.setDistance(getCarLocationDistance(xPPoiInfo2, currentLocation));
            }
        }
        xPSearchResult.setXPPoiInfos(arrayList2);
        return xPSearchResult;
    }

    private double getDistance(XPPoiInfo xPPoiInfo) {
        if (this.mRequest instanceof NearestSearchRequest) {
            return LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), ((NearestSearchRequest) this.mRequest).getSearchNearestParam().getPoiLocation());
        }
        return 0.0d;
    }

    private double getCarLocationDistance(XPPoiInfo xPPoiInfo, XPCoordinate2DDouble xPCoordinate2DDouble) {
        return LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), xPCoordinate2DDouble);
    }
}
