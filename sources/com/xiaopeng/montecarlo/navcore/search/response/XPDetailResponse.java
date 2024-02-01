package com.xiaopeng.montecarlo.navcore.search.response;

import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DetailPoi;
import com.autonavi.gbl.search.model.SearchDetailInfoResult;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class XPDetailResponse extends XPSearchResponse<SearchDetailInfoResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse
    public XPSearchResult parseBody(@NonNull SearchDetailInfoResult searchDetailInfoResult) {
        XPSearchResult xPSearchResult = new XPSearchResult();
        ArrayList<DetailPoi> arrayList = searchDetailInfoResult.pois;
        if (arrayList == null) {
            return xPSearchResult;
        }
        ArrayList arrayList2 = new ArrayList();
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        for (int i = 0; i < arrayList.size(); i++) {
            DetailPoi detailPoi = arrayList.get(i);
            if (L.ENABLE) {
                L.d(TAG, GsonUtil.toJson(detailPoi));
            }
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            xPPoiInfo.setCityCode(detailPoi.citycode);
            xPPoiInfo.setIconType(detailPoi.iconType);
            xPPoiInfo.setIconUrl(detailPoi.iconURL);
            xPPoiInfo.setRenderRank(detailPoi.render_rank);
            if (detailPoi.baseinfo != null) {
                xPPoiInfo.setName(detailPoi.baseinfo.name);
                xPPoiInfo.setAddress(detailPoi.baseinfo.address);
                xPPoiInfo.setPoiId(detailPoi.baseinfo.id);
                xPPoiInfo.setTel(detailPoi.baseinfo.tel);
                xPPoiInfo.setAdCode(detailPoi.baseinfo.adcode);
                xPPoiInfo.setCityName(detailPoi.baseinfo.cityname);
                xPPoiInfo.setCategory(XPPoiCategory.transformCategory(detailPoi.baseinfo.typecode));
                xPPoiInfo.setBlCategory(detailPoi.baseinfo.typecode);
                xPPoiInfo.setEnters(detailPoi.baseinfo.enter);
                xPPoiInfo.setExits(detailPoi.baseinfo.exit);
                xPPoiInfo.setDistrictName(detailPoi.baseinfo.districtname);
                xPPoiInfo.setProvinceName(detailPoi.baseinfo.provincename);
                if (detailPoi.baseinfo.point != null) {
                    xPPoiInfo.setDisplayLon(detailPoi.baseinfo.point.lon);
                    xPPoiInfo.setDisplayLat(detailPoi.baseinfo.point.lat);
                    xPPoiInfo.setEnters(detailPoi.baseinfo.enter);
                    xPPoiInfo.setExits(detailPoi.baseinfo.exit);
                    if (currentLocation != null) {
                        xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), currentLocation));
                    }
                }
            }
            xPPoiInfo.setOffline(searchDetailInfoResult.iPoiType == 0);
            checkAndGenerateBlSupplePoiId(xPPoiInfo);
            arrayList2.add(xPPoiInfo);
        }
        xPSearchResult.setXPPoiInfos(arrayList2);
        return xPSearchResult;
    }
}
