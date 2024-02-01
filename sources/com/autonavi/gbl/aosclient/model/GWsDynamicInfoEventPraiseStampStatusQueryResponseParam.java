package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDynamicInfoEventPraiseStampStatusQueryResponseParam extends BLResponseBase implements Serializable {
    public int status = 0;

    public GWsDynamicInfoEventPraiseStampStatusQueryResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_DYNAMIC_INFO_EVENT_PRAISE_STAMP_STATUS_QUERY;
        this.mNetworkStatus = 0;
    }
}
