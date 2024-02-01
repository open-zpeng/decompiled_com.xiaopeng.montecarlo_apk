package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShiledImMsgCommentSetRequestExtValue implements Serializable {
    public String nickname;
    public String uid;
    public String username;

    public WsShiledImMsgCommentSetRequestExtValue() {
        this.nickname = "";
        this.uid = "";
        this.username = "";
    }

    public WsShiledImMsgCommentSetRequestExtValue(String str, String str2, String str3) {
        this.nickname = str;
        this.uid = str2;
        this.username = str3;
    }
}
