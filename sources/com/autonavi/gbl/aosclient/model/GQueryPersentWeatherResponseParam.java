package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryPersentWeatherResponseParam extends BLResponseBase implements Serializable {
    public GQueryPersentWeatherAckData mAckData = new GQueryPersentWeatherAckData();

    public GQueryPersentWeatherResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_QUERYPERSENTWEATHER;
    }
}
