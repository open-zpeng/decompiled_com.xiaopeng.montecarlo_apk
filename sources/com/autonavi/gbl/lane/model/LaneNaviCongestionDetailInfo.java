package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.guide.model.NaviCongestionDetailInfo;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneNaviCongestionDetailInfo implements Serializable {
    public HDExtendInfo leftHdExtendInfo;
    public HDExtendInfo rightHdExtendInfo;
    public NaviCongestionDetailInfo sdNaviCongestionDetail;

    public LaneNaviCongestionDetailInfo() {
        this.sdNaviCongestionDetail = new NaviCongestionDetailInfo();
        this.leftHdExtendInfo = new HDExtendInfo();
        this.rightHdExtendInfo = new HDExtendInfo();
    }

    public LaneNaviCongestionDetailInfo(NaviCongestionDetailInfo naviCongestionDetailInfo, HDExtendInfo hDExtendInfo, HDExtendInfo hDExtendInfo2) {
        this.sdNaviCongestionDetail = naviCongestionDetailInfo;
        this.leftHdExtendInfo = hDExtendInfo;
        this.rightHdExtendInfo = hDExtendInfo2;
    }
}
