package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchRoadId implements Serializable {
    public long roadId;
    public long tileId;
    public long urId;

    public SearchRoadId() {
        this.urId = 0L;
        this.tileId = 0L;
        this.roadId = 0L;
    }

    public SearchRoadId(long j, long j2, long j3) {
        this.urId = j;
        this.tileId = j2;
        this.roadId = j3;
    }
}
