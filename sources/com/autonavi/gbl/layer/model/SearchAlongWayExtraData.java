package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.AlongRouteMode;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchAlongWayExtraData implements Serializable {
    @AlongRouteMode.AlongRouteMode1
    public int alongRouteMode;
    public BizChargeStationInfo chargeStationInfo;
    public int extraDistance;
    public int extraTime;
    public boolean isOnlineSearch;
    public String retainEnergy;

    public SearchAlongWayExtraData() {
        this.isOnlineSearch = true;
        this.extraTime = Integer.MAX_VALUE;
        this.extraDistance = Integer.MAX_VALUE;
        this.alongRouteMode = 0;
        this.retainEnergy = "";
        this.chargeStationInfo = new BizChargeStationInfo();
    }

    public SearchAlongWayExtraData(boolean z, int i, int i2, @AlongRouteMode.AlongRouteMode1 int i3, String str, BizChargeStationInfo bizChargeStationInfo) {
        this.isOnlineSearch = z;
        this.extraTime = i;
        this.extraDistance = i2;
        this.alongRouteMode = i3;
        this.retainEnergy = str;
        this.chargeStationInfo = bizChargeStationInfo;
    }
}
