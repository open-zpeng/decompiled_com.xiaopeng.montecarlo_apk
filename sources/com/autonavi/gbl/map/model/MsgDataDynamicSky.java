package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgDataDynamicSky implements Serializable {
    public boolean bIsOn;
    public boolean bMakeCubeMap;
    public DynamicSkyParams params;
    public long uFrogColor;

    public MsgDataDynamicSky() {
        this.bIsOn = true;
        this.bMakeCubeMap = true;
        this.uFrogColor = 0L;
        this.params = new DynamicSkyParams();
    }

    public MsgDataDynamicSky(boolean z, boolean z2, long j, DynamicSkyParams dynamicSkyParams) {
        this.bIsOn = z;
        this.bMakeCubeMap = z2;
        this.uFrogColor = j;
        this.params = dynamicSkyParams;
    }
}
