package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.CommonTextureResources;
import com.autonavi.gbl.map.model.MapViewType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class MapViewParam implements Serializable {
    public int asyncTaskThreadCount;
    public boolean bWriteLog;
    public float cacheCountFactor;
    public int deviceId;
    public long engineId;
    @CommonTextureResources.CommonTextureResources1
    public int euCommonTexture;
    public BigInteger glThreadId;
    public long height;
    public boolean isLoadCommonTextureResources;
    public String laneProfileName;
    public long mapDevice;
    public String mapProfileName;
    public long screenHeight;
    public long screenWidth;
    @MapViewType.MapViewType1
    public int viewType;
    public long width;
    public long x;
    public long y;

    public MapViewParam() {
        this.viewType = 0;
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
        this.euCommonTexture = -1;
        this.isLoadCommonTextureResources = true;
        this.bWriteLog = true;
    }

    public MapViewParam(@MapViewType.MapViewType1 int i, long j, BigInteger bigInteger, int i2, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, float f, String str, String str2, @CommonTextureResources.CommonTextureResources1 int i4, boolean z, boolean z2) {
        this.viewType = i;
        this.mapDevice = j;
        this.glThreadId = bigInteger;
        this.deviceId = i2;
        this.engineId = j2;
        this.x = j3;
        this.y = j4;
        this.width = j5;
        this.height = j6;
        this.screenWidth = j7;
        this.screenHeight = j8;
        this.asyncTaskThreadCount = i3;
        this.cacheCountFactor = f;
        this.mapProfileName = str;
        this.laneProfileName = str2;
        this.euCommonTexture = i4;
        this.isLoadCommonTextureResources = z;
        this.bWriteLog = z2;
    }
}
