package com.autonavi.gbl.multi.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DisplayAttr implements Serializable {
    public int asyncTaskThreadCount;
    public boolean bWriteLog;
    public float cacheCountFactor;
    public long displayId;
    public long height;
    public boolean isLoadCommonTextureResources;
    public String laneProfileName;
    public String mapProfileName;
    public long topographyMaxLevel;
    public long topographyMinLevel;
    public long width;
    public long x;
    public long y;

    public DisplayAttr() {
        this.displayId = -1L;
        this.x = 0L;
        this.y = 0L;
        this.width = 0L;
        this.height = 0L;
        this.asyncTaskThreadCount = -1;
        this.cacheCountFactor = 2.0f;
        this.mapProfileName = "";
        this.laneProfileName = "";
        this.isLoadCommonTextureResources = true;
        this.topographyMinLevel = 3L;
        this.topographyMaxLevel = 10L;
        this.bWriteLog = true;
    }

    public DisplayAttr(long j, long j2, long j3, long j4, long j5, int i, float f, String str, String str2, boolean z, long j6, long j7, boolean z2) {
        this.displayId = j;
        this.x = j2;
        this.y = j3;
        this.width = j4;
        this.height = j5;
        this.asyncTaskThreadCount = i;
        this.cacheCountFactor = f;
        this.mapProfileName = str;
        this.laneProfileName = str2;
        this.isLoadCommonTextureResources = z;
        this.topographyMinLevel = j6;
        this.topographyMaxLevel = j7;
        this.bWriteLog = z2;
    }
}
