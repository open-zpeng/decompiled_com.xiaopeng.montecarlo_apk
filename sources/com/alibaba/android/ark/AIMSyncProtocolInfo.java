package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMSyncProtocolInfo implements Serializable {
    private static final long serialVersionUID = 8016852523414364616L;
    public String bizName;
    public long bizType;
    public AIMSyncProtocolType protocolType;
    public String topic;

    public AIMSyncProtocolInfo(String str, long j, String str2, AIMSyncProtocolType aIMSyncProtocolType) {
        this.bizType = 0L;
        this.protocolType = AIMSyncProtocolType.RELIABLE;
        this.topic = str;
        this.bizType = j;
        this.bizName = str2;
        if (aIMSyncProtocolType != null) {
            this.protocolType = aIMSyncProtocolType;
        }
    }

    public AIMSyncProtocolInfo() {
        this.bizType = 0L;
        this.protocolType = AIMSyncProtocolType.RELIABLE;
    }

    public String getTopic() {
        return this.topic;
    }

    public long getBizType() {
        return this.bizType;
    }

    public String getBizName() {
        return this.bizName;
    }

    public AIMSyncProtocolType getProtocolType() {
        return this.protocolType;
    }

    public String toString() {
        return "AIMSyncProtocolInfo{topic=" + this.topic + ",bizType=" + this.bizType + ",bizName=" + this.bizName + ",protocolType=" + this.protocolType + "}";
    }
}
