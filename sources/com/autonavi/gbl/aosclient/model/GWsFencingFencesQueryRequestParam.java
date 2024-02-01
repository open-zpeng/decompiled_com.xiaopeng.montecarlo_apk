package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsFencingFencesQueryRequestParam extends BLRequestBase implements Serializable {
    public String cid = "";
    public String gid = "";
    public boolean enable = false;
    public String tenantid = "";
    public String uid = "";
    public int pageSize = 0;
    public int page = 0;
    public String coordinate = "";
    public long updateTime = 0;
    public String batch = "";
    public String adcode = "";

    public GWsFencingFencesQueryRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_FENCING_FENCES_QUERY_;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
