package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathCamera3d implements Serializable {
    public Camera3d camera;
    public long linkIndex;
    public long segmentIndex;

    public PathCamera3d() {
        this.camera = new Camera3d();
        this.segmentIndex = 0L;
        this.linkIndex = 0L;
    }

    public PathCamera3d(Camera3d camera3d, long j, long j2) {
        this.camera = camera3d;
        this.segmentIndex = j;
        this.linkIndex = j2;
    }
}
