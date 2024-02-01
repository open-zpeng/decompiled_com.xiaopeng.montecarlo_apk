package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GFeedbackReportResponseParam extends BLResponseBase implements Serializable {
    public boolean Bind = false;
    public int RecordId = -1;
    public int Promotion = -1;

    public GFeedbackReportResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_FEEDBACKREPORT;
    }
}
