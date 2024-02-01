package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GLbpEventSyncCommonResponseParam extends BLResponseBase implements Serializable {
    public String code = "";
    public String msg = "";

    public GLbpEventSyncCommonResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_LBP_EVENT_SYNC_COMMON;
        this.mNetworkStatus = 0;
    }
}
