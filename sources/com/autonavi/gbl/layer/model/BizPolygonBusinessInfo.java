package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BizPolygonBusinessInfo extends BizBusinessInfo implements Serializable {
    public boolean mDrawPolygonRim = false;
    public ArrayList<Coord3DDouble> mVecPoints = new ArrayList<>();
}
