package com.autonavi.gbl.user.usertrack.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class HistoryRouteItem implements Serializable {
    public Coord2DDouble endLoc;
    public HistoryRoutePoiItem fromPoi;
    public String id;
    public int method;
    public ArrayList<HistoryRoutePoiItem> midPoi;
    public Coord2DDouble startLoc;
    public HistoryRoutePoiItem toPoi;
    public int type;
    public long updateTime;

    public HistoryRouteItem() {
        this.type = 302;
        this.id = "";
        this.startLoc = new Coord2DDouble();
        this.endLoc = new Coord2DDouble();
        this.updateTime = 0L;
        this.method = 0;
        this.fromPoi = new HistoryRoutePoiItem();
        this.toPoi = new HistoryRoutePoiItem();
        this.midPoi = new ArrayList<>();
    }

    public HistoryRouteItem(int i, String str, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, long j, int i2, HistoryRoutePoiItem historyRoutePoiItem, HistoryRoutePoiItem historyRoutePoiItem2, ArrayList<HistoryRoutePoiItem> arrayList) {
        this.type = i;
        this.id = str;
        this.startLoc = coord2DDouble;
        this.endLoc = coord2DDouble2;
        this.updateTime = j;
        this.method = i2;
        this.fromPoi = historyRoutePoiItem;
        this.toPoi = historyRoutePoiItem2;
        this.midPoi = arrayList;
    }
}
