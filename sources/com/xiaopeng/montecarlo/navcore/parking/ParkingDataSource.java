package com.xiaopeng.montecarlo.navcore.parking;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.List;
/* loaded from: classes3.dex */
public interface ParkingDataSource {
    List<XPPoiInfo> fetchParking(XPPoiInfo xPPoiInfo);
}
