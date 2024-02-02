package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.FlylineDrawMode;
import com.autonavi.gbl.layer.model.FlylineType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PrepareLayerFlylineParam extends PrepareLayerMarkerParam implements Serializable {
    @FlylineType.FlylineType1
    public int type = 0;
    @FlylineDrawMode.FlylineDrawMode1
    public int drawMode = 0;
    public int width = -1;
}
