package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MassDataPolylineInfo extends MassDataInfo implements Serializable {
    public Coord3DDouble center = new Coord3DDouble();
    public RectDouble rect = new RectDouble();
    public ArrayList<Coord3DDouble> points = new ArrayList<>();
}
