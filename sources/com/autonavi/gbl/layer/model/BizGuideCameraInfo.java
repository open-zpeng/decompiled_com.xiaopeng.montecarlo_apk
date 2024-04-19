package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.guide.model.NaviSubCamera;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BizGuideCameraInfo extends BizBusinessInfo implements Serializable {
    @CameraType.CameraType1
    public int type = 255;
    public int priority = 0;
    public int distance = 0;
    public Coord3DDouble position = new Coord3DDouble();
    public ArrayList<Short> speed = new ArrayList<>();
    public ArrayList<NaviSubCamera> subCameras = new ArrayList<>();
    public int penalty = 0;
    public boolean isNewCamera = false;
    public long cameraId = 0;
}
