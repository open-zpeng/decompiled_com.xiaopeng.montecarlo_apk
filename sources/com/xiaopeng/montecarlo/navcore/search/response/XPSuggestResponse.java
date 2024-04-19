package com.xiaopeng.montecarlo.navcore.search.response;

import android.text.Html;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.data.model.AreaExtraInfo;
import com.autonavi.gbl.search.model.SearchSuggestResult;
import com.autonavi.gbl.search.model.SearchSuggestTip;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.request.SuggestSearchRequest;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class XPSuggestResponse extends XPSearchResponse<SearchSuggestResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse
    public XPSearchResult parseBody(@NonNull SearchSuggestResult searchSuggestResult) {
        AreaExtraInfo areaExtraInfo;
        XPSearchResult xPSearchResult = new XPSearchResult();
        ArrayList<SearchSuggestTip> arrayList = searchSuggestResult.tipList;
        if (arrayList == null) {
            return xPSearchResult;
        }
        ArrayList arrayList2 = new ArrayList();
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        int size = arrayList.size() <= 10 ? arrayList.size() : 10;
        for (int i = 0; i < size; i++) {
            SearchSuggestTip searchSuggestTip = arrayList.get(i);
            if (L.ENABLE) {
                L.d(TAG, GsonUtil.toJson(searchSuggestTip));
            }
            if (XPPoiCategory.isValidBLPoi(searchSuggestTip.category)) {
                XPPoiInfo xPPoiInfo = new XPPoiInfo();
                xPPoiInfo.setAddress(searchSuggestTip.address);
                xPPoiInfo.setName(searchSuggestTip.name);
                xPPoiInfo.setPoiId(searchSuggestTip.poiid);
                xPPoiInfo.setAdCode(searchSuggestTip.adcode);
                xPPoiInfo.setCityCode(String.valueOf(searchSuggestTip.citycode));
                xPPoiInfo.setKey(getKeyword());
                xPPoiInfo.setTag(Html.fromHtml(searchSuggestTip.poi_tag).toString());
                if (!TextUtils.isEmpty(searchSuggestTip.category)) {
                    xPPoiInfo.setCategory(XPPoiCategory.transformCategory(searchSuggestTip.category));
                    xPPoiInfo.setBlCategory(searchSuggestTip.category);
                }
                xPPoiInfo.setDistrictName(searchSuggestTip.district);
                if (searchSuggestTip.point != null) {
                    xPPoiInfo.setDisplayLon(searchSuggestTip.point.lon);
                    xPPoiInfo.setDisplayLat(searchSuggestTip.point.lat);
                }
                if (searchSuggestTip.naviPoint != null) {
                    xPPoiInfo.setNaviLon(searchSuggestTip.naviPoint.lon);
                    xPPoiInfo.setNaviLat(searchSuggestTip.naviPoint.lat);
                }
                if (xPPoiInfo.getDisplayLon() <= 0.0d || xPPoiInfo.getDisplayLat() <= 0.0d) {
                    xPPoiInfo.setDisplayLon(xPPoiInfo.getNaviLon());
                    xPPoiInfo.setDisplayLat(xPPoiInfo.getNaviLat());
                }
                if (xPPoiInfo.getNaviLon() <= 0.0d || xPPoiInfo.getNaviLat() <= 0.0d) {
                    xPPoiInfo.setNaviLon(xPPoiInfo.getDisplayLon());
                    xPPoiInfo.setNaviLat(xPPoiInfo.getDisplayLat());
                }
                if ((xPPoiInfo.getDisplayLon() <= 0.0d || xPPoiInfo.getDisplayLat() <= 0.0d) && (areaExtraInfo = MapDataManager.getInstance().getAreaExtraInfo(searchSuggestTip.adcode)) != null && areaExtraInfo.stCenterPoint != null) {
                    xPPoiInfo.setDisplayLon((areaExtraInfo.stCenterPoint.nLon * 1.0d) / 1000000.0d);
                    xPPoiInfo.setDisplayLat((areaExtraInfo.stCenterPoint.nLat * 1.0d) / 1000000.0d);
                    xPPoiInfo.setNaviLon(xPPoiInfo.getDisplayLon());
                    xPPoiInfo.setNaviLat(xPPoiInfo.getDisplayLat());
                }
                xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo.getNaviLon(), xPPoiInfo.getNaviLat()), currentLocation));
                xPPoiInfo.setOffline(searchSuggestResult.iPoiType == 0);
                checkAndGenerateBlSupplePoiId(xPPoiInfo);
                arrayList2.add(xPPoiInfo);
            }
        }
        xPSearchResult.setXPPoiInfos(arrayList2);
        return xPSearchResult;
    }

    private String getKeyword() {
        return this.mRequest instanceof SuggestSearchRequest ? ((SuggestSearchRequest) this.mRequest).getSearchSuggestParam().getKeyword() : "";
    }
}
