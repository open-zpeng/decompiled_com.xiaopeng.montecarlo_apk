package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AOIInfo implements Serializable {
    public ArrayList<GateInfo> m_gateInfos;
    public String m_id;
    public String m_name;
    public ArrayList<Coord2DInt32> m_shape;

    public AOIInfo() {
        this.m_id = "";
        this.m_name = "";
        this.m_shape = new ArrayList<>();
        this.m_gateInfos = new ArrayList<>();
    }

    public AOIInfo(String str, String str2, ArrayList<Coord2DInt32> arrayList, ArrayList<GateInfo> arrayList2) {
        this.m_id = str;
        this.m_name = str2;
        this.m_shape = arrayList;
        this.m_gateInfos = arrayList2;
    }
}
