package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.user.msgpush.model.SceneSendType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MsgPushItem implements Serializable {
    public String accessKey;
    public String bizType;
    public String clientId;
    public String createTime;
    public String deviceId;
    public String expiration;
    public String id;
    public boolean isReaded;
    public long messageId;
    public int messageType;
    public String sendTime;
    @SceneSendType.SceneSendType1
    public int sendType;
    public String sessionId;
    public String sourceId;
    public int status;
    public String text;
    public String title;
    public String traceId;
    public String userId;
    public String version;

    public MsgPushItem() {
        this.messageId = 0L;
        this.messageType = 0;
        this.status = 0;
        this.id = "";
        this.bizType = "";
        this.clientId = "";
        this.sourceId = "";
        this.userId = "";
        this.createTime = "";
        this.expiration = "";
        this.sendTime = "";
        this.text = "";
        this.title = "";
        this.version = "";
        this.accessKey = "";
        this.deviceId = "";
        this.sessionId = "";
        this.isReaded = false;
        this.sendType = 0;
        this.traceId = "";
    }

    public MsgPushItem(long j, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, boolean z, @SceneSendType.SceneSendType1 int i3, String str15) {
        this.messageId = j;
        this.messageType = i;
        this.status = i2;
        this.id = str;
        this.bizType = str2;
        this.clientId = str3;
        this.sourceId = str4;
        this.userId = str5;
        this.createTime = str6;
        this.expiration = str7;
        this.sendTime = str8;
        this.text = str9;
        this.title = str10;
        this.version = str11;
        this.accessKey = str12;
        this.deviceId = str13;
        this.sessionId = str14;
        this.isReaded = z;
        this.sendType = i3;
        this.traceId = str15;
    }
}
