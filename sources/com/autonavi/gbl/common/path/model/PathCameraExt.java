package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathCameraExt implements Serializable {
    public CameraExt camera;
    public long linkIndex;
    public long segmentIndex;

    public PathCameraExt() {
        this.camera = new CameraExt();
        this.segmentIndex = 0L;
        this.linkIndex = 0L;
    }

    public PathCameraExt(CameraExt cameraExt, long j, long j2) {
        this.camera = cameraExt;
        this.segmentIndex = j;
        this.linkIndex = j2;
    }
}
