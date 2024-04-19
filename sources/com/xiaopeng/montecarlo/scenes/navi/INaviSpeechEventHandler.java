package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.List;
/* loaded from: classes3.dex */
public interface INaviSpeechEventHandler {
    void onNewDestWithViasReroute(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, List<XPViaPoint> list, int i, int i2, int i3);

    void onReroute();

    void onSelectRecommendPark(int i, boolean z);

    void onStartNavi();

    void onStopNavi();

    void onViaAdd(XPPoiInfo xPPoiInfo);

    void onZoomIn();

    void onZoomOut();
}
