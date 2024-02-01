package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryCarMsgRequestParam extends BLRequestBase implements Serializable {
    public String userId = "";
    public String diu = "";
    public String tid = "";
    public String autodiv = "";
    public String sourceid = "";
    public String bizType = "";

    public GQueryCarMsgRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_QUERYCARMSG;
    }
}
