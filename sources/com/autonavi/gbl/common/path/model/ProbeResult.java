package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ProbeResult implements Serializable {
    public ArrayList<Coord3DDouble> geolinePoints;
    public ArrayList<Long> routeLinkIds;
    public ArrayList<ProbeViaPointInfo> viaPoints;

    public ProbeResult() {
        this.geolinePoints = new ArrayList<>();
        this.routeLinkIds = new ArrayList<>();
        this.viaPoints = new ArrayList<>();
    }

    public ProbeResult(ArrayList<Coord3DDouble> arrayList, ArrayList<Long> arrayList2, ArrayList<ProbeViaPointInfo> arrayList3) {
        this.geolinePoints = arrayList;
        this.routeLinkIds = arrayList2;
        this.viaPoints = arrayList3;
    }
}
