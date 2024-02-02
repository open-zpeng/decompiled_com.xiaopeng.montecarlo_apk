package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GateInfo implements Serializable {
    public Coord2DInt32 m_coord;
    public String m_gateName;
    public String m_poiId;

    public GateInfo() {
        this.m_poiId = "";
        this.m_gateName = "";
        this.m_coord = new Coord2DInt32();
    }

    public GateInfo(String str, String str2, Coord2DInt32 coord2DInt32) {
        this.m_poiId = str;
        this.m_gateName = str2;
        this.m_coord = coord2DInt32;
    }
}
