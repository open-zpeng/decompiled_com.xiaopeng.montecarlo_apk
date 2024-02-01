package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizTrafficEventInfo extends BizPointBusinessInfo implements Serializable {
    public int type = 0;
    public long pathId = 0;
    public int layer = 0;
    public int layerTag = 0;
    public int eventId = 0;
    public Coord2DDouble coord2D = new Coord2DDouble();
    public boolean official = false;
    public boolean detail = false;
    public String lane = "";
    public String labelDesc = "";
}
