package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDynamicInfoCongestionGroupChatUserRemoveRequestParam extends BLRequestBase implements Serializable {
    public String appCid = "";
    public String appUid = "";
    public String bizId = "";
    public String bizType = "";

    public GWsDynamicInfoCongestionGroupChatUserRemoveRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_DYNAMIC_INFO_CONGESTION_GROUP_CHAT_USER_REMOVE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
