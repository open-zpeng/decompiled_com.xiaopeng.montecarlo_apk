package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMNewMessage implements Serializable {
    private static final long serialVersionUID = 7761132741373913040L;
    public AIMMessage msg;
    public AIMMsgSourceType type;

    public AIMNewMessage(AIMMessage aIMMessage, AIMMsgSourceType aIMMsgSourceType) {
        this.type = AIMMsgSourceType.SOURCE_TYPE_UNKNOWN;
        this.msg = aIMMessage;
        if (aIMMsgSourceType != null) {
            this.type = aIMMsgSourceType;
        }
    }

    public AIMNewMessage() {
        this.type = AIMMsgSourceType.SOURCE_TYPE_UNKNOWN;
    }

    public AIMMessage getMsg() {
        return this.msg;
    }

    public AIMMsgSourceType getType() {
        return this.type;
    }

    public String toString() {
        return "AIMNewMessage{msg=" + this.msg + ",type=" + this.type + "}";
    }
}
