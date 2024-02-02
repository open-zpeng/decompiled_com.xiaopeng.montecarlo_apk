package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.map.layer.model.CarMode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PrepareLayerCarParam extends PrepareLayerMarkerParam implements Serializable {
    public boolean isPiviFunc = false;
    public boolean isGPSValid = false;
    public boolean isOverSpeed = false;
    public boolean isCruiseNetCarStyle = false;
    @CarMode.CarMode1
    public int carMode = 1;
    public int speed = -1;
}
