package com.autonavi.gbl.scene.model;

import com.autonavi.gbl.scene.model.SceneModuleID;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ClickedInfo implements Serializable {
    public long clickedMode;
    public long clickedStatus;
    public long contentType;
    public long elementType;
    @SceneModuleID.SceneModuleID1
    public int moduleType;

    public ClickedInfo() {
        this.moduleType = 1;
        this.contentType = 0L;
        this.elementType = 0L;
        this.clickedMode = 0L;
        this.clickedStatus = 0L;
    }

    public ClickedInfo(@SceneModuleID.SceneModuleID1 int i, long j, long j2, long j3, long j4) {
        this.moduleType = i;
        this.contentType = j;
        this.elementType = j2;
        this.clickedMode = j3;
        this.clickedStatus = j4;
    }
}
