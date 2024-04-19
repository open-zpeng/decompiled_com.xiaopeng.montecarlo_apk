package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SystemParam implements Serializable {
    public int cpucorenum;
    public String cpuname;
    public short dpi;
    public String gpuname;
    public int memory;
    public float memoryRation;
    public String mobiletype;
    public boolean permitPreLoad;
    public String platform;
    public String platform_version;
    public int renderSystemVersion;

    public SystemParam() {
        this.dpi = (short) 240;
        this.mobiletype = "";
        this.platform = "";
        this.platform_version = "";
        this.cpuname = "";
        this.gpuname = "";
        this.cpucorenum = 0;
        this.memory = 0;
        this.permitPreLoad = true;
        this.memoryRation = 1.0f;
        this.renderSystemVersion = 1;
    }

    public SystemParam(short s, String str, String str2, String str3, String str4, String str5, int i, int i2, boolean z, float f, int i3) {
        this.dpi = s;
        this.mobiletype = str;
        this.platform = str2;
        this.platform_version = str3;
        this.cpuname = str4;
        this.gpuname = str5;
        this.cpucorenum = i;
        this.memory = i2;
        this.permitPreLoad = z;
        this.memoryRation = f;
        this.renderSystemVersion = i3;
    }
}
