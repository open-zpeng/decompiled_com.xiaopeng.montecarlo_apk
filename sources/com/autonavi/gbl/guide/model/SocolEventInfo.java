package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SocolEventInfo implements Serializable {
    public int eventID;
    public Coord2DDouble eventPos;
    public int eventType;
    public int layer;
    public int layerTag;
    public String socolPicUrl;

    public SocolEventInfo() {
        this.eventID = 0;
        this.eventType = 0;
        this.eventPos = new Coord2DDouble();
        this.layer = 0;
        this.layerTag = 0;
        this.socolPicUrl = "";
    }

    public SocolEventInfo(int i, int i2, Coord2DDouble coord2DDouble, int i3, int i4, String str) {
        this.eventID = i;
        this.eventType = i2;
        this.eventPos = coord2DDouble;
        this.layer = i3;
        this.layerTag = i4;
        this.socolPicUrl = str;
    }
}
