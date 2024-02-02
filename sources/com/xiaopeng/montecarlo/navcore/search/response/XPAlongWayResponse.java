package com.xiaopeng.montecarlo.navcore.search.response;

import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.AlongWayPoi;
import com.autonavi.gbl.search.model.SearchAlongWayResult;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.request.AlongWayRequest;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class XPAlongWayResponse extends XPSearchResponse<SearchAlongWayResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse
    public XPSearchResult parseBody(@NonNull SearchAlongWayResult searchAlongWayResult) {
        XPSearchResult xPSearchResult = new XPSearchResult();
        if (searchAlongWayResult.pois == null) {
            return xPSearchResult;
        }
        String keyword = getKeyword();
        ArrayList<AlongWayPoi> arrayList = searchAlongWayResult.pois;
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        int size = arrayList.size() < 50 ? arrayList.size() : 50;
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < size; i++) {
            AlongWayPoi alongWayPoi = arrayList.get(i);
            if (L.ENABLE) {
                L.d(TAG, GsonUtil.toJson(alongWayPoi));
            }
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            xPPoiInfo.setName(alongWayPoi.name);
            xPPoiInfo.setAddress(alongWayPoi.address);
            xPPoiInfo.setPoiId(alongWayPoi.id);
            xPPoiInfo.setKey(keyword);
            xPPoiInfo.setBlCategory(alongWayPoi.typecode);
            xPPoiInfo.setCategory(XPPoiCategory.transformCategory(alongWayPoi.typecode));
            if (alongWayPoi.point != null) {
                xPPoiInfo.setDisplayLon(alongWayPoi.point.lon);
                xPPoiInfo.setDisplayLat(alongWayPoi.point.lat);
                xPPoiInfo.setEnter(alongWayPoi.pointEnter);
                xPPoiInfo.setExit(alongWayPoi.pointEnter);
                if (currentLocation != null) {
                    xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), currentLocation));
                }
            }
            xPPoiInfo.setAdCode(alongWayPoi.nAdCode);
            xPPoiInfo.setCityCode(String.valueOf(alongWayPoi.nCityAdCode));
            xPPoiInfo.setOffline(searchAlongWayResult.iPoiType == 0);
            checkAndGenerateBlSupplePoiId(xPPoiInfo);
            arrayList2.add(xPPoiInfo);
        }
        if ("DISTANCE".equals(getRequest().getOrder())) {
            NavCoreUtil.sortXPPoiInfosByDistance(arrayList2, 2);
        }
        xPSearchResult.setXPPoiInfos(arrayList2);
        return xPSearchResult;
    }

    private String getKeyword() {
        return this.mRequest instanceof AlongWayRequest ? ((AlongWayRequest) this.mRequest).getSearchAlongWayParam().getKeyword() : "";
    }
}
