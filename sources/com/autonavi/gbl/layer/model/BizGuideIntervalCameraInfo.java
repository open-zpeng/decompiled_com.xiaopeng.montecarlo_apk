package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.CameraType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BizGuideIntervalCameraInfo extends BizBusinessInfo implements Serializable {
    @CameraType.CameraType1
    public int type = 255;
    public Coord3DDouble position = new Coord3DDouble();
    public ArrayList<Short> speed = new ArrayList<>();
}
