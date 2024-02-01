package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsArchiveTrafficeventUpdateResponseParam extends BLResponseBase implements Serializable {
    public String id = "";
    public String eventId = "";
    public int isLogin = -1;
    public int noticeStyle = -1;
    public String noticeContent = "";

    public GWsArchiveTrafficeventUpdateResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WSARCHIVETRAFFICEVENTUPDATE;
    }
}
