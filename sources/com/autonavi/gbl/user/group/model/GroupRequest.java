package com.autonavi.gbl.user.group.model;

import com.autonavi.gbl.user.group.model.GroupRequestType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupRequest implements Serializable {
    @GroupRequestType.GroupRequestType1
    public int reqType;
    public long taskId;

    public GroupRequest() {
        this.taskId = 0L;
        this.reqType = 0;
    }

    public GroupRequest(long j, @GroupRequestType.GroupRequestType1 int i) {
        this.taskId = j;
        this.reqType = i;
    }
}
