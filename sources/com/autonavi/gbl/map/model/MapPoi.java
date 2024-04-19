package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapPoi implements Serializable {
    public String extInfo;
    public int iconXmax;
    public int iconXmin;
    public int iconYmax;
    public int iconYmin;
    public boolean isFocus;
    public int mapx;
    public int mapy;
    public int mapz;
    public String name;
    public int poiType;
    public String poiid;
    public int subType;
    public int timeStamp;
    public int winx;
    public int winy;

    public MapPoi() {
        this.poiid = "";
        this.name = "";
        this.timeStamp = 0;
        this.winx = 0;
        this.winy = 0;
        this.mapx = 0;
        this.mapy = 0;
        this.mapz = 0;
        this.iconXmin = 0;
        this.iconXmax = 0;
        this.iconYmin = 0;
        this.iconYmax = 0;
        this.poiType = 0;
        this.subType = 0;
        this.isFocus = false;
        this.extInfo = "";
    }

    public MapPoi(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z, String str3) {
        this.poiid = str;
        this.name = str2;
        this.timeStamp = i;
        this.winx = i2;
        this.winy = i3;
        this.mapx = i4;
        this.mapy = i5;
        this.mapz = i6;
        this.iconXmin = i7;
        this.iconXmax = i8;
        this.iconYmin = i9;
        this.iconYmax = i10;
        this.poiType = i11;
        this.subType = i12;
        this.isFocus = z;
        this.extInfo = str3;
    }
}
