package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.MergeInfoType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ViaMergeInfo implements Serializable {
    public ChargeStationInfo chargeStationInfo;
    public ElecPoiInfo elecPoiInfo;
    @MergeInfoType.MergeInfoType1
    public int type;

    public ViaMergeInfo() {
        this.type = 0;
        this.elecPoiInfo = new ElecPoiInfo();
        this.chargeStationInfo = new ChargeStationInfo();
    }

    public ViaMergeInfo(@MergeInfoType.MergeInfoType1 int i, ElecPoiInfo elecPoiInfo, ChargeStationInfo chargeStationInfo) {
        this.type = i;
        this.elecPoiInfo = elecPoiInfo;
        this.chargeStationInfo = chargeStationInfo;
    }
}
