package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class VehicleParam extends BaseParam implements Serializable {
    public String vehicleId = "";
    public int type = 0;
    public int size = 0;
    public int axis = 0;
    public float width = 0.0f;
    public float length = 0.0f;
    public float height = 0.0f;
    public float load = 0.0f;
    public float weight = 0.0f;

    public VehicleParam() {
        this.paramType = 12;
    }
}
