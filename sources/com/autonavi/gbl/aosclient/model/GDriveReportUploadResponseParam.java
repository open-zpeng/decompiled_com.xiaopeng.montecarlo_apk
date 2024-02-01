package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GDriveReportUploadResponseParam extends BLResponseBase implements Serializable {
    public String id = "";
    public String url = "";
    public String words = "";
    public GDriveReportUploadResponseMsg userMsgList = new GDriveReportUploadResponseMsg();
    public int userMsgListSize = 0;
    public GDriveReportUploadResponseMsg systemMsgList = new GDriveReportUploadResponseMsg();
    public int systemMsgListSize = 0;

    public GDriveReportUploadResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_OSS_DRIVEREPORTUPLOAD;
    }
}
