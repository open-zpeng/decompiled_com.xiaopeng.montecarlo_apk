package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFencingGroupsQueryStatus implements Serializable {
    public boolean Delete;
    public boolean add;
    public boolean change;

    public WsFencingGroupsQueryStatus() {
        this.Delete = false;
        this.change = false;
        this.add = false;
    }

    public WsFencingGroupsQueryStatus(boolean z, boolean z2, boolean z3) {
        this.Delete = z;
        this.change = z2;
        this.add = z3;
    }
}
