package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord3DInt32;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CameraExt3d implements Serializable {
    public CameraExt cameraExt;
    public Coord3DInt32 pos;

    public CameraExt3d() {
        this.cameraExt = new CameraExt();
        this.pos = new Coord3DInt32();
    }

    public CameraExt3d(CameraExt cameraExt, Coord3DInt32 coord3DInt32) {
        this.cameraExt = cameraExt;
        this.pos = coord3DInt32;
    }
}
