package com.xiaopeng.montecarlo.mapoverlay.mark;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.montecarlo.appengine.MapMarkService;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorManager;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseDecoratorPresenter;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MarkPointDecorator extends BaseMapDecorator {
    private static final L.Tag TAG = new L.Tag("MarkPointDecorator");
    public static final int TYPE_DJI = 1;
    public static final String TYPE_MID = "_type_";

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public int getOverlayType() {
        return 20005;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public boolean isGlobalDecorator() {
        return true;
    }

    public static void showMark(@NonNull DecoratorManager decoratorManager, List<MapMarkService.MarkPoint> list) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (MapMarkService.MarkPoint markPoint : list) {
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            xPPoiInfo.setPoiId(markPoint.getId() + TYPE_MID + markPoint.getType());
            String coordinateType = markPoint.getCoordinateType();
            char c = 65535;
            int hashCode = coordinateType.hashCode();
            if (hashCode != 98175376) {
                if (hashCode == 113079775 && coordinateType.equals("wgs84")) {
                    c = 0;
                }
            } else if (coordinateType.equals("gcj02")) {
                c = 1;
            }
            if (c == 0) {
                Coord3DDouble coord3DDouble = new Coord3DDouble();
                coord3DDouble.lat = markPoint.getLat();
                coord3DDouble.lon = markPoint.getLon();
                Coord3DDouble encryptLonLat = TBTManager.getInstance().getPosServiceWrapper().encryptLonLat(coord3DDouble);
                if (encryptLonLat != null) {
                    if (L.ENABLE) {
                        L.d(TAG, "showMark wgsPoint.lat = " + coord3DDouble.lat + " , wgsPoint.lon = " + coord3DDouble.lon);
                        L.d(TAG, "showMark encryptPoint.lat = " + encryptLonLat.lat + " , encryptPoint.lon = " + encryptLonLat.lon);
                    }
                    xPPoiInfo.setDisplayLat(encryptLonLat.lat);
                    xPPoiInfo.setDisplayLon(encryptLonLat.lon);
                }
            } else if (c == 1) {
                if (L.ENABLE) {
                    L.d(TAG, "showMark GCJ02.lat = " + markPoint.getLat() + " , GCJ02.lon = " + markPoint.getLon());
                }
                xPPoiInfo.setDisplayLat(markPoint.getLat());
                xPPoiInfo.setDisplayLon(markPoint.getLon());
            }
            arrayList.add(xPPoiInfo);
        }
        if (arrayList.isEmpty()) {
            decoratorManager.removeMapDecorator(DecoratorType.MARK);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, arrayList);
        decoratorManager.showMapDecorator(null, DecoratorType.MARK, bundle);
    }

    public MarkPointDecorator(DecoratorType decoratorType, MainContext mainContext, BaseMapDecorator.IMapDecoratorStatusListener iMapDecoratorStatusListener) {
        super(decoratorType, mainContext, iMapDecoratorStatusListener);
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator
    public BaseDecoratorPresenter createPresenter() {
        return new MarkDecoratorPresenter(this.mDecoratorCallback);
    }
}
