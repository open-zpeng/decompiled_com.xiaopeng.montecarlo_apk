package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathCameraExt3d implements Serializable {
    public CameraExt3d camera;
    public long linkIndex;
    public long segmentIndex;

    public PathCameraExt3d() {
        this.camera = new CameraExt3d();
        this.segmentIndex = 0L;
        this.linkIndex = 0L;
    }

    public PathCameraExt3d(CameraExt3d cameraExt3d, long j, long j2) {
        this.camera = cameraExt3d;
        this.segmentIndex = j;
        this.linkIndex = j2;
    }
}
