package com.xiaopeng.montecarlo.service.navi.parser;

import android.content.Context;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.database.CarWashDataHelper;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.CarWashDataResponse;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.service.navi.INaviParser;
import com.xiaopeng.montecarlo.service.navi.IRequestEventCallback;
import com.xiaopeng.montecarlo.service.navi.request.CarWashRequest;
/* loaded from: classes3.dex */
public final class CarWashSearchParser implements INaviParser {
    private static final L.Tag TAG = new L.Tag("CarWashSearchParser");

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onCreate(@NonNull Context context) {
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onHandleEvent(@NonNull Context context, @NonNull final String str, @NonNull final IRequestEventCallback iRequestEventCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onHandleEvent content:" + str);
        }
        WorkThreadUtil.getInstance().executeBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.service.navi.parser.CarWashSearchParser.1
            @Override // java.lang.Runnable
            public void run() {
                CarWashRequest carWashRequest;
                Coord2DDouble coord2DDouble = null;
                try {
                    carWashRequest = (CarWashRequest) GsonUtil.fromJson(str, (Class<Object>) CarWashRequest.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    carWashRequest = null;
                }
                CarWashDataResponse carWashDataResponse = new CarWashDataResponse();
                if (carWashRequest != null && CarWashRequest.SEARCH_TYPE_AROUND.equalsIgnoreCase(carWashRequest.getSearchType())) {
                    int radius = carWashRequest.getRadius() > 0 ? carWashRequest.getRadius() : 50000;
                    int maxCount = carWashRequest.getMaxCount() > 0 ? carWashRequest.getMaxCount() : 50;
                    if (carWashRequest.getLongitude() <= 0.0d || carWashRequest.getLatitude() <= 0.0d) {
                        if (TBTManager.getInstance().getPosServiceWrapper() == null) {
                            L.w(CarWashSearchParser.TAG, "PosServiceWrapper is null");
                        } else {
                            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
                            if (currentLocation == null) {
                                L.w(CarWashSearchParser.TAG, "xpCoordinate2DDouble is null");
                            } else {
                                coord2DDouble = new Coord2DDouble(currentLocation.mLon, currentLocation.mLat);
                            }
                        }
                    } else {
                        coord2DDouble = new Coord2DDouble(carWashRequest.getLongitude(), carWashRequest.getLatitude());
                    }
                    carWashDataResponse.setData(CarWashDataHelper.query(coord2DDouble, coord2DDouble, radius, maxCount));
                    carWashDataResponse.setRetCode("0");
                    carWashDataResponse.setRetMsg("");
                }
                iRequestEventCallback.setNeedReturnResult(true, GsonUtil.toJson(carWashDataResponse));
                iRequestEventCallback.allWorkEnd();
            }
        });
    }
}
