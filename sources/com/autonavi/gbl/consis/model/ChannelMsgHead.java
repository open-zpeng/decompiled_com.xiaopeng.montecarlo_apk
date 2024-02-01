package com.autonavi.gbl.consis.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChannelMsgHead implements Serializable {
    public int customCode;
    public String receiverName;
    public String senderName;

    public ChannelMsgHead() {
        this.customCode = 0;
        this.senderName = "";
        this.receiverName = "";
    }

    public ChannelMsgHead(int i, String str, String str2) {
        this.customCode = i;
        this.senderName = str;
        this.receiverName = str2;
    }
}
