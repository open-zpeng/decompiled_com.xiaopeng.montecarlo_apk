package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MsgPoiInfo implements Serializable {
    public String address;
    public String name;
    public String poiId;
    public Coord2DDouble poiLoc;

    public MsgPoiInfo() {
        this.poiId = "";
        this.name = "";
        this.address = "";
        this.poiLoc = new Coord2DDouble();
    }

    public MsgPoiInfo(String str, String str2, String str3, Coord2DDouble coord2DDouble) {
        this.poiId = str;
        this.name = str2;
        this.address = str3;
        this.poiLoc = coord2DDouble;
    }
}
