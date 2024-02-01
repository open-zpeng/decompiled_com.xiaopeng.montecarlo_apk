package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldImMsgCommentSetResponseParam extends BLResponseBase implements Serializable {
    public WsShiledImMsgCommentSetResponseData data = new WsShiledImMsgCommentSetResponseData();

    public GWsShieldImMsgCommentSetResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_IM_MSG_COMMENT_SET;
        this.mNetworkStatus = 0;
    }
}
