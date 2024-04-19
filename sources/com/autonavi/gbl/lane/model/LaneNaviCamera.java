package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.guide.model.NaviCamera;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneNaviCamera implements Serializable {
    public HDExtendInfo hdExtendInfo;
    public NaviCamera sdNaviCamera;

    public LaneNaviCamera() {
        this.sdNaviCamera = new NaviCamera();
        this.hdExtendInfo = new HDExtendInfo();
    }

    public LaneNaviCamera(NaviCamera naviCamera, HDExtendInfo hDExtendInfo) {
        this.sdNaviCamera = naviCamera;
        this.hdExtendInfo = hDExtendInfo;
    }
}
