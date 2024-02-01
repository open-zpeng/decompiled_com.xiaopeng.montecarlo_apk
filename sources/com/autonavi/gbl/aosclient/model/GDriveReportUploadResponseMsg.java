package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GDriveReportUploadResponseMsg implements Serializable {
    public String content;
    public String name;
    public long timestamp;
    public String title;

    public GDriveReportUploadResponseMsg() {
        this.title = "";
        this.name = "";
        this.content = "";
        this.timestamp = 0L;
    }

    public GDriveReportUploadResponseMsg(String str, String str2, String str3, long j) {
        this.title = str;
        this.name = str2;
        this.content = str3;
        this.timestamp = j;
    }
}
