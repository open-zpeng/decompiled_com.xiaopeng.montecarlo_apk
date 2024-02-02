package com.autonavi.gbl.common.path.option;

import com.autonavi.gbl.common.path.model.UpLoadLink;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RerouteInfo implements Serializable {
    public int linkIDSize;
    public int minPathDist;
    public int minPathTime;
    public ArrayList<UpLoadLink> uploadLink;

    public RerouteInfo() {
        this.uploadLink = new ArrayList<>();
        this.linkIDSize = 0;
        this.minPathTime = 0;
        this.minPathDist = 0;
    }

    public RerouteInfo(ArrayList<UpLoadLink> arrayList, int i, int i2, int i3) {
        this.uploadLink = arrayList;
        this.linkIDSize = i;
        this.minPathTime = i2;
        this.minPathDist = i3;
    }
}
