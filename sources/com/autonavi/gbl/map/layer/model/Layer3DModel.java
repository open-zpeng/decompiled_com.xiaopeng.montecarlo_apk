package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Layer3DModel implements Serializable {
    public BinaryStream dataBuff;
    public boolean needPBR;
    public int resourceID;

    public Layer3DModel() {
        this.resourceID = 0;
        this.dataBuff = new BinaryStream();
        this.needPBR = false;
    }

    public Layer3DModel(int i, BinaryStream binaryStream, boolean z) {
        this.resourceID = i;
        this.dataBuff = binaryStream;
        this.needPBR = z;
    }
}
