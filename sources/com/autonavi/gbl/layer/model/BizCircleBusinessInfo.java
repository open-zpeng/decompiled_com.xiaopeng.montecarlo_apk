package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizCircleBusinessInfo extends BizBusinessInfo implements Serializable {
    public boolean isDrawRim = false;
    public boolean isDrawPoint = false;
    public double radius = 100.0d;
    public Coord3DDouble center = new Coord3DDouble();
}
