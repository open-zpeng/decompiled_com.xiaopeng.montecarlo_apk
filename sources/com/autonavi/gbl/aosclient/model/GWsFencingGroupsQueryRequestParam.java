package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsFencingGroupsQueryRequestParam extends BLRequestBase implements Serializable {
    public String cid = "";
    public String gids = "";
    public int priority = 0;
    public String tenantid = "";
    public String uid = "";
    public int pageSize = 0;
    public int page = 0;
    public String coordinate = "";
    public long updateTime = 0;

    public GWsFencingGroupsQueryRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_FENCING_GROUPS_QUERY_;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
