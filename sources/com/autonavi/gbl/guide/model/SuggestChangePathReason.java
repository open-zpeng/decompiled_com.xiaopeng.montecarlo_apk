package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SuggestChangePathReason implements Serializable {
    public long saveTime;

    public SuggestChangePathReason() {
        this.saveTime = 0L;
    }

    public SuggestChangePathReason(long j) {
        this.saveTime = j;
    }
}
