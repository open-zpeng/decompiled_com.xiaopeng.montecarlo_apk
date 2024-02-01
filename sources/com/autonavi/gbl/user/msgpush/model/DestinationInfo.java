package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DestinationInfo implements Serializable {
    public MsgPoiInfo endPoi;
    public ArrayList<MsgPoiInfo> midPois;

    public DestinationInfo() {
        this.endPoi = new MsgPoiInfo();
        this.midPois = new ArrayList<>();
    }

    public DestinationInfo(MsgPoiInfo msgPoiInfo, ArrayList<MsgPoiInfo> arrayList) {
        this.endPoi = msgPoiInfo;
        this.midPois = arrayList;
    }
}
