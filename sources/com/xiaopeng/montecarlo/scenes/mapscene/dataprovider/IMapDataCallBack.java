package com.xiaopeng.montecarlo.scenes.mapscene.dataprovider;

import android.graphics.Point;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import java.util.List;
/* loaded from: classes3.dex */
public interface IMapDataCallBack extends BaseCallBack<MapSceneRequestParam, MapSceneResultData> {
    int getChargeUpdateInterval();

    Coord2DDouble getLonLatFromCenter();

    MapStatus getMapStatus();

    boolean isChargeEnabled();

    Point lonLatToPoint(XPCoordinate2DDouble xPCoordinate2DDouble);

    void removeChargeDecorator();

    void updateChargeDecorator(List<XPPoiInfo> list);
}
