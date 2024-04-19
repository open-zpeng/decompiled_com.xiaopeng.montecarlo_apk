package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BizLineBusinessInfo extends BizBusinessInfo implements Serializable {
    public int type = 0;
    public ArrayList<Coord3DDouble> mVecPoints = new ArrayList<>();
}
