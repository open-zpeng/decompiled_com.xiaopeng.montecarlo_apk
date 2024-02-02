package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathCamera implements Serializable {
    public Camera camera;
    public long linkIndex;
    public long segmentIndex;

    public PathCamera() {
        this.camera = new Camera();
        this.segmentIndex = 0L;
        this.linkIndex = 0L;
    }

    public PathCamera(Camera camera, long j, long j2) {
        this.camera = camera;
        this.segmentIndex = j;
        this.linkIndex = j2;
    }
}
