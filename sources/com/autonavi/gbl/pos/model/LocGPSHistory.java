package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocNaviType;
import com.autonavi.gbl.pos.model.LocPageType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LocGPSHistory implements Serializable {
    public ArrayList<LocGPSInfo> buffer;
    public String naviID;
    @LocNaviType.LocNaviType1
    public int naviType;
    public boolean nomove;
    @LocPageType.LocPageType1
    public int pageType;
    public int routeSource;
    public BigInteger timestampNavi;
    public BigInteger timestampRoute;

    public LocGPSHistory() {
        this.buffer = new ArrayList<>();
        this.nomove = false;
        this.pageType = -1;
        this.naviType = -1;
        this.naviID = "";
        this.routeSource = -1;
        this.timestampNavi = new BigInteger("0");
        this.timestampRoute = new BigInteger("0");
    }

    public LocGPSHistory(ArrayList<LocGPSInfo> arrayList, boolean z, @LocPageType.LocPageType1 int i, @LocNaviType.LocNaviType1 int i2, String str, int i3, BigInteger bigInteger, BigInteger bigInteger2) {
        this.buffer = arrayList;
        this.nomove = z;
        this.pageType = i;
        this.naviType = i2;
        this.naviID = str;
        this.routeSource = i3;
        this.timestampNavi = bigInteger;
        this.timestampRoute = bigInteger2;
    }
}
