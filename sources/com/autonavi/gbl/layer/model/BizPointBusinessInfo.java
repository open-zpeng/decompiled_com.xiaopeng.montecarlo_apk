package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BizPointBusinessInfo extends BizBusinessInfo implements Serializable {
    public Coord3DDouble mPos3D = new Coord3DDouble();
    public String mTypeCode = "";
}
