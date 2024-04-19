package com.autonavi.gbl.map.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class MapViewParam implements Serializable {
    public int asyncTaskThreadCount;
    public boolean bWriteLog;
    public float cacheCountFactor;
    public int deviceId;
    public long engineId;
    public BigInteger glThreadId;
    public long height;
    public boolean isLoadCommonTextureResources;
    public String laneProfileName;
    public long mapDevice;
    public String mapProfileName;
    public long screenHeight;
    public long screenWidth;
    public long topographyMaxLevel;
    public long topographyMinLevel;
    public long width;
    public long x;
    public long y;

    public MapViewParam() {
        this.mapDevice = 0L;
        this.glThreadId = new BigInteger("0");
        this.deviceId = 0;
        this.engineId = 0L;
        this.x = 0L;
        this.y = 0L;
        this.width = 0L;
        this.height = 0L;
        this.screenWidth = 0L;
        this.screenHeight = 0L;
        this.asyncTaskThreadCount = -1;
        this.cacheCountFactor = 2.0f;
        this.mapProfileName = "";
        this.laneProfileName = "";
        this.isLoadCommonTextureResources = true;
        this.topographyMinLevel = 3L;
        this.topographyMaxLevel = 10L;
        this.bWriteLog = true;
    }

    public MapViewParam(long j, BigInteger bigInteger, int i, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i2, float f, String str, String str2, boolean z, long j9, long j10, boolean z2) {
        this.mapDevice = j;
        this.glThreadId = bigInteger;
        this.deviceId = i;
        this.engineId = j2;
        this.x = j3;
        this.y = j4;
        this.width = j5;
        this.height = j6;
        this.screenWidth = j7;
        this.screenHeight = j8;
        this.asyncTaskThreadCount = i2;
        this.cacheCountFactor = f;
        this.mapProfileName = str;
        this.laneProfileName = str2;
        this.isLoadCommonTextureResources = z;
        this.topographyMinLevel = j9;
        this.topographyMaxLevel = j10;
        this.bWriteLog = z2;
    }
}
