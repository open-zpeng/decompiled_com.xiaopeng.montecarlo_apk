package com.xiaopeng.montecarlo.navcore.search.response;

import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepinfoPoi;
import com.autonavi.gbl.search.model.SearchDeepInfoResult;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class XPDeepResponse extends XPSearchResponse<SearchDeepInfoResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse
    public XPSearchResult parseBody(@NonNull SearchDeepInfoResult searchDeepInfoResult) {
        XPSearchResult xPSearchResult = new XPSearchResult();
        DeepinfoPoi deepinfoPoi = searchDeepInfoResult.deepinfoPoi;
        if (deepinfoPoi == null) {
            return xPSearchResult;
        }
        if (L.ENABLE) {
            L.d(TAG, GsonUtil.toJson(deepinfoPoi));
        }
        ArrayList arrayList = new ArrayList();
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setName(deepinfoPoi.name);
        xPPoiInfo.setAddress(deepinfoPoi.address);
        xPPoiInfo.setTag(deepinfoPoi.tag);
        xPPoiInfo.setPoiId(deepinfoPoi.poiid);
        xPPoiInfo.setOpenTime(deepinfoPoi.opentime);
        xPPoiInfo.setOffline(searchDeepInfoResult.iPoiType == 0);
        if (deepinfoPoi.poi_loc != null) {
            xPPoiInfo.setDisplayLon(deepinfoPoi.poi_loc.lon);
            xPPoiInfo.setDisplayLat(deepinfoPoi.poi_loc.lat);
            xPPoiInfo.setNaviLat(deepinfoPoi.poi_navi.lat);
            xPPoiInfo.setNaviLon(deepinfoPoi.poi_navi.lon);
            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            if (currentLocation != null) {
                xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), currentLocation));
            }
        }
        xPPoiInfo.setCategory(XPPoiCategory.transformCategory(deepinfoPoi.typecode));
        xPPoiInfo.setBlCategory(deepinfoPoi.typecode);
        xPPoiInfo.setTel(deepinfoPoi.tel);
        xPPoiInfo.setAdCode(deepinfoPoi.adcode);
        xPPoiInfo.setCityCode(String.valueOf(deepinfoPoi.city_adcode));
        xPPoiInfo.setXPDeepInfoPoi(new XPDeepInfoPoi(deepinfoPoi));
        checkAndGenerateBlSupplePoiId(xPPoiInfo);
        arrayList.add(xPPoiInfo);
        xPSearchResult.setXPPoiInfos(arrayList);
        return xPSearchResult;
    }
}
