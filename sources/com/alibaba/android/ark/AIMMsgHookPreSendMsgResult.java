package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgHookPreSendMsgResult implements Serializable {
    private static final long serialVersionUID = -305976696652247937L;
    public AIMMessage msg;
    public AIMMsgXpnPush xpnPush;

    public AIMMsgHookPreSendMsgResult(AIMMessage aIMMessage, AIMMsgXpnPush aIMMsgXpnPush) {
        this.msg = aIMMessage;
        this.xpnPush = aIMMsgXpnPush;
    }

    public AIMMsgHookPreSendMsgResult() {
    }

    public AIMMessage getMsg() {
        return this.msg;
    }

    public AIMMsgXpnPush getXpnPush() {
        return this.xpnPush;
    }

    public String toString() {
        return "AIMMsgHookPreSendMsgResult{msg=" + this.msg + ",xpnPush=" + this.xpnPush + "}";
    }
}
