package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GDriveReportSmsRequestParam extends BLRequestBase implements Serializable {
    public String id = "";
    public String phoneNumber = "";

    public GDriveReportSmsRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_OSS_DRIVEREPORTSMS;
    }
}
