package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.model.SectorAngles;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class DynamicSectorData implements Serializable {
    public String bizDataDSL;
    public String id;
    public String itemDataDSL;
    public Coord3DDouble position;
    public double radius;
    public SectorAngles sectorAngles;

    public DynamicSectorData() {
        this.id = "";
        this.itemDataDSL = "";
        this.bizDataDSL = "";
        this.position = new Coord3DDouble();
        this.radius = 10.0d;
        this.sectorAngles = new SectorAngles();
    }

    public DynamicSectorData(String str, String str2, String str3, Coord3DDouble coord3DDouble, double d, SectorAngles sectorAngles) {
        this.id = str;
        this.itemDataDSL = str2;
        this.bizDataDSL = str3;
        this.position = coord3DDouble;
        this.radius = d;
        this.sectorAngles = sectorAngles;
    }
}
