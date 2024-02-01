package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDynamicInfoCongestionGroupChatUserAddV3RequestParam extends BLRequestBase implements Serializable {
    public String bizId = "";
    public String bizType = "";
    public String appCid = "";
    public String appUid = "";
    public String scene = "";
    public String nick = "";
    public WsDynamicInfoCongestionGroupChatUserAddV3RequestPosition position = new WsDynamicInfoCongestionGroupChatUserAddV3RequestPosition();

    public GWsDynamicInfoCongestionGroupChatUserAddV3RequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_DYNAMIC_INFO_CONGESTION_GROUP_CHAT_USER_ADD_V3;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
