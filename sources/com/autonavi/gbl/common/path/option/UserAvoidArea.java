package com.autonavi.gbl.common.path.option;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserAvoidArea implements Serializable {
    public ArrayList<Coord2DInt32> points;

    public UserAvoidArea() {
        this.points = new ArrayList<>();
    }

    public UserAvoidArea(ArrayList<Coord2DInt32> arrayList) {
        this.points = arrayList;
    }
}
