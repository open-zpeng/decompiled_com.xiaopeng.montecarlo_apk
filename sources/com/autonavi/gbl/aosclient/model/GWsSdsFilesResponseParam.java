package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsSdsFilesResponseParam extends BLResponseBase implements Serializable {
    public String errdetail = "";
    public WsSdsFilesData data = new WsSdsFilesData();

    public GWsSdsFilesResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SDS_FILES;
        this.mNetworkStatus = 0;
    }
}
