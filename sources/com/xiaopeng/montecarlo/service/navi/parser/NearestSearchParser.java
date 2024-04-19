package com.xiaopeng.montecarlo.service.navi.parser;

import android.content.Context;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.service.navi.INaviParser;
import com.xiaopeng.montecarlo.service.navi.IRequestEventCallback;
import com.xiaopeng.montecarlo.service.navi.request.NearestRequest;
import com.xiaopeng.montecarlo.service.navi.result.NearestResult;
/* loaded from: classes3.dex */
public class NearestSearchParser implements INaviParser {
    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onCreate(@NonNull Context context) {
    }

    static /* synthetic */ String access$000() {
        return getError();
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onHandleEvent(@NonNull Context context, @NonNull String str, @NonNull final IRequestEventCallback iRequestEventCallback) {
        boolean z = false;
        try {
            NearestRequest nearestRequest = (NearestRequest) GsonUtil.fromJson(str, (Class<Object>) NearestRequest.class);
            XPCoordinate2DDouble xPCoordinate2DDouble = null;
            if ("wgs84".equals(nearestRequest.getType())) {
                Coord3DDouble coord3DDouble = new Coord3DDouble();
                coord3DDouble.lat = nearestRequest.getLatitude();
                coord3DDouble.lon = nearestRequest.getLongitude();
                Coord3DDouble encryptLonLat = TBTManager.getInstance().getPosServiceWrapper().encryptLonLat(coord3DDouble);
                if (encryptLonLat != null) {
                    xPCoordinate2DDouble = new XPCoordinate2DDouble(encryptLonLat.lon, encryptLonLat.lat);
                }
            } else {
                xPCoordinate2DDouble = new XPCoordinate2DDouble(nearestRequest.getLongitude(), nearestRequest.getLatitude());
            }
            if (xPCoordinate2DDouble != null) {
                SearchClient.getInstance().execute(new RequestFactory(5).newBuilder().requestId(SearchClient.getInstance().getRequestId()).poiLocation(xPCoordinate2DDouble).build(), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.service.navi.parser.NearestSearchParser.1
                    @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                    public void onResponse(Request request, XPSearchResult xPSearchResult) {
                        if (xPSearchResult == null || xPSearchResult.getResultCode() != 0 || CollectionUtils.isEmpty(xPSearchResult.getXPPoiInfos())) {
                            iRequestEventCallback.setNeedReturnResult(true, NearestSearchParser.access$000());
                            iRequestEventCallback.allWorkEnd();
                            return;
                        }
                        NearestResult nearestResult = new NearestResult();
                        XPPoiInfo xPPoiInfo = xPSearchResult.getXPPoiInfos().get(0);
                        nearestResult.setCode("0");
                        String str2 = "null";
                        nearestResult.setAddress((xPPoiInfo == null || xPPoiInfo.getAddress() == null) ? "null" : xPPoiInfo.getAddress());
                        nearestResult.setProvince((xPPoiInfo == null || xPPoiInfo.getProvinceName() == null) ? "null" : xPPoiInfo.getProvinceName());
                        nearestResult.setCity((xPPoiInfo == null || xPPoiInfo.getCityName() == null) ? "null" : xPPoiInfo.getCityName());
                        if (xPPoiInfo != null && xPPoiInfo.getDistrictName() != null) {
                            str2 = xPPoiInfo.getDistrictName();
                        }
                        nearestResult.setDistrict(str2);
                        iRequestEventCallback.setNeedReturnResult(true, GsonUtil.toJson(nearestResult));
                        iRequestEventCallback.allWorkEnd();
                    }
                });
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return;
        }
        iRequestEventCallback.setNeedReturnResult(true, getError());
        iRequestEventCallback.allWorkEnd();
    }

    private static String getError() {
        return GsonUtil.toJson(new NearestResult());
    }
}
