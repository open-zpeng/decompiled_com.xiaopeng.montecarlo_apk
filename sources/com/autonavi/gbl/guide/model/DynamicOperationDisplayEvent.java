package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.guide.model.Action;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DynamicOperationDisplayEvent implements Serializable {
    @Action.Action1
    public int action;
    public String displayID;
    public String eventID;
    public Coord2DDouble eventPos;

    public DynamicOperationDisplayEvent() {
        this.eventID = "";
        this.displayID = "";
        this.eventPos = new Coord2DDouble();
        this.action = 1;
    }

    public DynamicOperationDisplayEvent(String str, String str2, Coord2DDouble coord2DDouble, @Action.Action1 int i) {
        this.eventID = str;
        this.displayID = str2;
        this.eventPos = coord2DDouble;
        this.action = i;
    }
}
