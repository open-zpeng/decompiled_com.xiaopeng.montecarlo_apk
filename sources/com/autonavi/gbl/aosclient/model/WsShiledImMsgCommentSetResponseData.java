package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShiledImMsgCommentSetResponseData implements Serializable {
    public double createTime;
    public String msgId;

    public WsShiledImMsgCommentSetResponseData() {
        this.msgId = "";
        this.createTime = 0.0d;
    }

    public WsShiledImMsgCommentSetResponseData(String str, double d) {
        this.msgId = str;
        this.createTime = d;
    }
}
