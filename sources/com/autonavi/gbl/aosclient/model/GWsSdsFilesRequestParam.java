package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsSdsFilesRequestParam extends BLRequestBase implements Serializable {
    public String project = "";
    public String swVer = "";
    public String brand = "";
    public String fromVer = "";
    public String diu = "";
    public String terminal = "";

    public GWsSdsFilesRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SDS_FILES;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
