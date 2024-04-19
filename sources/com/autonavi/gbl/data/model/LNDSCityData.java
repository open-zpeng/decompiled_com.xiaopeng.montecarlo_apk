package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.TaskStatusCode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LNDSCityData implements Serializable {
    public long dataSize;
    @TaskStatusCode.TaskStatusCode1
    public int taskState;
    public int urId;

    public LNDSCityData() {
        this.urId = 0;
        this.taskState = 0;
        this.dataSize = 0L;
    }

    public LNDSCityData(int i, @TaskStatusCode.TaskStatusCode1 int i2, long j) {
        this.urId = i;
        this.taskState = i2;
        this.dataSize = j;
    }
}
