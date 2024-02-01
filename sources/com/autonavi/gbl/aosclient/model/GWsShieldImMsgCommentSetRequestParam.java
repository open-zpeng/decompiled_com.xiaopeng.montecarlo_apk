package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldImMsgCommentSetRequestParam extends BLRequestBase implements Serializable {
    public String appCode = "";
    public String bizType = "";
    public String cid = "";
    public String msgId = "";
    public String extKey = "";
    public WsShiledImMsgCommentSetRequestExtValue extValue = new WsShiledImMsgCommentSetRequestExtValue();

    public GWsShieldImMsgCommentSetRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_IM_MSG_COMMENT_SET;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
