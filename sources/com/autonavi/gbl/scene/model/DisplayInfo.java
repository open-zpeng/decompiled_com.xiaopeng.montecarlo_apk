package com.autonavi.gbl.scene.model;

import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.scene.model.SceneModuleID;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class DisplayInfo implements Serializable {
    public long contentType;
    public ProtocolInfo info;
    @SceneModuleID.SceneModuleID1
    public int moduleType;
    public RectInt rect;

    public DisplayInfo() {
        this.moduleType = 1;
        this.contentType = 0L;
        this.rect = new RectInt();
        this.info = new ProtocolInfo();
    }

    public DisplayInfo(@SceneModuleID.SceneModuleID1 int i, long j, RectInt rectInt, ProtocolInfo protocolInfo) {
        this.moduleType = i;
        this.contentType = j;
        this.rect = rectInt;
        this.info = protocolInfo;
    }
}
