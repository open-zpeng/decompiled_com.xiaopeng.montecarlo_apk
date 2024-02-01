package com.autonavi.gbl.user.forcast.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ForcastArrivedParam implements Serializable {
    public String adCode;
    public int nLevel;
    public String userId;
    public Coord2DDouble userLoc;

    public ForcastArrivedParam() {
        this.nLevel = 0;
        this.adCode = "";
        this.userId = "";
        this.userLoc = new Coord2DDouble();
    }

    public ForcastArrivedParam(int i, String str, String str2, Coord2DDouble coord2DDouble) {
        this.nLevel = i;
        this.adCode = str;
        this.userId = str2;
        this.userLoc = coord2DDouble;
    }
}
