package com.autonavi.gbl.user.usertrack.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class HistoryRecvRouteItem implements Serializable {
    public Coord2DDouble endLoc;
    public RecvRoutePoi fromPoi;
    public String itemId;
    public String method;
    public ArrayList<RecvRoutePoi> midPoi;
    public Coord2DDouble startLoc;
    public RecvRoutePoi toPoi;
    public long updateTime;

    public HistoryRecvRouteItem() {
        this.itemId = "";
        this.startLoc = new Coord2DDouble();
        this.endLoc = new Coord2DDouble();
        this.method = "";
        this.fromPoi = new RecvRoutePoi();
        this.toPoi = new RecvRoutePoi();
        this.midPoi = new ArrayList<>();
        this.updateTime = 0L;
    }

    public HistoryRecvRouteItem(String str, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, String str2, RecvRoutePoi recvRoutePoi, RecvRoutePoi recvRoutePoi2, ArrayList<RecvRoutePoi> arrayList, long j) {
        this.itemId = str;
        this.startLoc = coord2DDouble;
        this.endLoc = coord2DDouble2;
        this.method = str2;
        this.fromPoi = recvRoutePoi;
        this.toPoi = recvRoutePoi2;
        this.midPoi = arrayList;
        this.updateTime = j;
    }
}
