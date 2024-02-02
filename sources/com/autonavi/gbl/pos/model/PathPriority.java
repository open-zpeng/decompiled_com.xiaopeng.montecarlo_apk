package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PathPriority implements Serializable {
    public long pathID;
    public int priority;

    public PathPriority() {
        this.pathID = 0L;
        this.priority = 0;
    }

    public PathPriority(long j, int i) {
        this.pathID = j;
        this.priority = i;
    }
}
