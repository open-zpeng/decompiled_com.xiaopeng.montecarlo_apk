package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.SkyboxMode;
import com.autonavi.gbl.util.model.BinaryStream;
import com.autonavi.gbl.util.model.DateTime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapSkyboxParam implements Serializable {
    public BinaryStream DataBuff;
    public int frogColor;
    public boolean is3DRes;
    public boolean isOn;
    @SkyboxMode.SkyboxMode1
    public int mode;
    public DateTime time;

    public MapSkyboxParam() {
        this.mode = 0;
        this.time = new DateTime();
        this.isOn = false;
        this.is3DRes = true;
        this.DataBuff = new BinaryStream();
        this.frogColor = -269156353;
    }

    public MapSkyboxParam(@SkyboxMode.SkyboxMode1 int i, DateTime dateTime, boolean z, boolean z2, BinaryStream binaryStream, int i2) {
        this.mode = i;
        this.time = dateTime;
        this.isOn = z;
        this.is3DRes = z2;
        this.DataBuff = binaryStream;
        this.frogColor = i2;
    }
}
