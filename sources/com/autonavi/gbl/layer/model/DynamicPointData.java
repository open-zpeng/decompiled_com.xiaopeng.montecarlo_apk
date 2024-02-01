package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class DynamicPointData implements Serializable {
    public String bizDataDSL;
    public String id;
    public String itemDataDSL;
    public Coord3DDouble position;

    public DynamicPointData() {
        this.id = "";
        this.itemDataDSL = "";
        this.bizDataDSL = "";
        this.position = new Coord3DDouble();
    }

    public DynamicPointData(String str, String str2, String str3, Coord3DDouble coord3DDouble) {
        this.id = str;
        this.itemDataDSL = str2;
        this.bizDataDSL = str3;
        this.position = coord3DDouble;
    }
}
