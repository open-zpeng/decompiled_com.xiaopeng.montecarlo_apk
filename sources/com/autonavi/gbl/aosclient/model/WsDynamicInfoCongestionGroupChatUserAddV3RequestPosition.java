package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsDynamicInfoCongestionGroupChatUserAddV3RequestPosition implements Serializable {
    public double latitude;
    public double longitude;

    public WsDynamicInfoCongestionGroupChatUserAddV3RequestPosition() {
        this.longitude = 0.0d;
        this.latitude = 0.0d;
    }

    public WsDynamicInfoCongestionGroupChatUserAddV3RequestPosition(double d, double d2) {
        this.longitude = d;
        this.latitude = d2;
    }
}
