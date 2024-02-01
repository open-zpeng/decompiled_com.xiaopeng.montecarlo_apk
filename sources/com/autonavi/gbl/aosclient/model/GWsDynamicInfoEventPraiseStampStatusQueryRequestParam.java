package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDynamicInfoEventPraiseStampStatusQueryRequestParam extends BLRequestBase implements Serializable {
    public String eventId = "";

    public GWsDynamicInfoEventPraiseStampStatusQueryRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_DYNAMIC_INFO_EVENT_PRAISE_STAMP_STATUS_QUERY;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
