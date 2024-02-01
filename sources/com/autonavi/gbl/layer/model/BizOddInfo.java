package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.OddSegInfo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BizOddInfo extends BizBusinessInfo implements Serializable {
    public OddSegInfo oddSegInfo = new OddSegInfo();
    public ArrayList<Coord3DDouble> vecPoints = new ArrayList<>();
}
