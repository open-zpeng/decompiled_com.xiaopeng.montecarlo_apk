package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.guide.model.NaviSubCameraExt;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BizGuideCameraInfo extends BizBusinessInfo implements Serializable {
    public NaviSubCameraExt subCameraExt = new NaviSubCameraExt();
    public ArrayList<NaviSubCameraExt> aggregatedExts = new ArrayList<>();
    public int priority = 0;
    public int distance = 0;
    public Coord3DDouble position = new Coord3DDouble();
    public long cameraId = 0;
    public int segmentIndex = 0;
    public int linkIndex = 0;
    public int distanceToEnd = 0;
    @RoadClass.RoadClass1
    public int roadClass = -1;
    public boolean isHidden = false;
}
