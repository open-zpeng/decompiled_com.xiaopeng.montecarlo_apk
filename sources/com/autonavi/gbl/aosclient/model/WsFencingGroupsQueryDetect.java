package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFencingGroupsQueryDetect implements Serializable {
    public boolean cross;
    public boolean enter;
    public boolean exit;
    public boolean inside;
    public boolean outside;
    public long stay;

    public WsFencingGroupsQueryDetect() {
        this.enter = false;
        this.inside = false;
        this.exit = false;
        this.outside = false;
        this.cross = false;
        this.stay = 0L;
    }

    public WsFencingGroupsQueryDetect(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j) {
        this.enter = z;
        this.inside = z2;
        this.exit = z3;
        this.outside = z4;
        this.cross = z5;
        this.stay = j;
    }
}
