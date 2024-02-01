package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.List;
/* loaded from: classes3.dex */
public interface IRecommendParkingListener {
    void onHideRecommendParking();

    void onShowRecommendParking(List<XPPoiInfo> list, boolean z);
}
