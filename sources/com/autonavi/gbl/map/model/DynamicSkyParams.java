package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DynamicSkyParams implements Serializable {
    public boolean bShowSun;
    public float fCloudOpacity;
    public float fCloudSpeed;
    public float fFallOff;
    public float fHoriHeight;
    public float fSunBrightness;
    public float fSunRadius;
    public long uCloudColor;
    public long uHorizonColor;
    public long uSunColor;
    public long uZenithColor;
    public float[] vSunDirection;

    public DynamicSkyParams() {
        this.bShowSun = true;
        this.fCloudSpeed = 1.0f;
        this.fHoriHeight = 1.0f;
        this.fCloudOpacity = 0.7f;
        this.fFallOff = 2.0f;
        this.fSunRadius = 0.02f;
        this.fSunBrightness = 2.0f;
        this.uCloudColor = -3368577L;
        this.uZenithColor = -13408564L;
        this.uHorizonColor = -4210753L;
        this.uSunColor = -32999L;
        this.vSunDirection = new float[3];
    }

    public DynamicSkyParams(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, long j, long j2, long j3, long j4) {
        this.bShowSun = z;
        this.fCloudSpeed = f;
        this.fHoriHeight = f2;
        this.fCloudOpacity = f3;
        this.fFallOff = f4;
        this.fSunRadius = f5;
        this.fSunBrightness = f6;
        this.vSunDirection = fArr;
        this.uCloudColor = j;
        this.uZenithColor = j2;
        this.uHorizonColor = j3;
        this.uSunColor = j4;
    }
}
