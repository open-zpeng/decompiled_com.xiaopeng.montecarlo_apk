package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LockScreenTip implements Serializable {
    public String lockScreenTips;
    public long maneuverID;
    public long remainSegmentLen;

    public LockScreenTip() {
        this.lockScreenTips = "";
        this.maneuverID = 0L;
        this.remainSegmentLen = 0L;
    }

    public LockScreenTip(String str, long j, long j2) {
        this.lockScreenTips = str;
        this.maneuverID = j;
        this.remainSegmentLen = j2;
    }
}
