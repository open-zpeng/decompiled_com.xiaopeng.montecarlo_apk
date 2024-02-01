package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.user.msgpush.model.MsgPushType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class PushMsg implements Serializable {
    public AutoPushMsg autoMsg;
    @MsgPushType.MsgPushType1
    public int bizType;
    public TeamPushMsg teamMsg;

    public PushMsg() {
        this.bizType = -1;
        this.teamMsg = new TeamPushMsg();
        this.autoMsg = new AutoPushMsg();
    }

    public PushMsg(@MsgPushType.MsgPushType1 int i, TeamPushMsg teamPushMsg, AutoPushMsg autoPushMsg) {
        this.bizType = i;
        this.teamMsg = teamPushMsg;
        this.autoMsg = autoPushMsg;
    }
}
