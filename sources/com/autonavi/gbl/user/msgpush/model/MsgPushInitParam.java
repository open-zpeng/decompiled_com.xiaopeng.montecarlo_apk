package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.user.msgpush.model.MsgSource;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MsgPushInitParam implements Serializable {
    public String dataPath;
    public String mqttKey;
    @MsgSource.MsgSource1
    public int msgSource;

    public MsgPushInitParam() {
        this.msgSource = 1;
        this.dataPath = "";
        this.mqttKey = "";
    }

    public MsgPushInitParam(@MsgSource.MsgSource1 int i, String str, String str2) {
        this.msgSource = i;
        this.dataPath = str;
        this.mqttKey = str2;
    }
}
