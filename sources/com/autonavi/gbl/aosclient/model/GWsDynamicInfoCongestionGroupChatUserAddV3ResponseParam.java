package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam extends BLResponseBase implements Serializable {
    public WsDynamicInfoCongestionGroupChatUserAddV3ResponseData data = new WsDynamicInfoCongestionGroupChatUserAddV3ResponseData();

    public GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_DYNAMIC_INFO_CONGESTION_GROUP_CHAT_USER_ADD_V3;
        this.mNetworkStatus = 0;
    }
}
