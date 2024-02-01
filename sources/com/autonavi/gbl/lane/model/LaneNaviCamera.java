package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.guide.model.NaviCameraExt;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneNaviCamera implements Serializable {
    public HDExtendInfo hdExtendInfo;
    public NaviCameraExt sdNaviCamera;

    public LaneNaviCamera() {
        this.sdNaviCamera = new NaviCameraExt();
        this.hdExtendInfo = new HDExtendInfo();
    }

    public LaneNaviCamera(NaviCameraExt naviCameraExt, HDExtendInfo hDExtendInfo) {
        this.sdNaviCamera = naviCameraExt;
        this.hdExtendInfo = hDExtendInfo;
    }
}
