package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CleanContinueGuide implements Serializable {
    public boolean bCleanNaviPathInfo;
    public boolean bCleanPathInfo;

    public CleanContinueGuide() {
        this.bCleanNaviPathInfo = true;
        this.bCleanPathInfo = true;
    }

    public CleanContinueGuide(boolean z, boolean z2) {
        this.bCleanNaviPathInfo = z;
        this.bCleanPathInfo = z2;
    }
}
