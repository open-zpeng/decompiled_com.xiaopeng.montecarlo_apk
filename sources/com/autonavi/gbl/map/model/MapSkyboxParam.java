package com.autonavi.gbl.map.model;

import com.autonavi.gbl.util.model.BinaryStream;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapSkyboxParam implements Serializable {
    public BinaryStream DataBuff;
    public int frogColor;
    public boolean is3DRes;
    public boolean isOn;

    public MapSkyboxParam() {
        this.isOn = false;
        this.is3DRes = true;
        this.DataBuff = new BinaryStream();
        this.frogColor = -269156353;
    }

    public MapSkyboxParam(boolean z, boolean z2, BinaryStream binaryStream, int i) {
        this.isOn = z;
        this.is3DRes = z2;
        this.DataBuff = binaryStream;
        this.frogColor = i;
    }
}
