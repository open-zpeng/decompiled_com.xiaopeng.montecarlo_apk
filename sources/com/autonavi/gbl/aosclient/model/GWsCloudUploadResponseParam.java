package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsCloudUploadResponseParam extends BLResponseBase implements Serializable {
    public boolean data = false;

    public GWsCloudUploadResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_CLOUD_UPLOAD;
        this.mNetworkStatus = 0;
    }
}
