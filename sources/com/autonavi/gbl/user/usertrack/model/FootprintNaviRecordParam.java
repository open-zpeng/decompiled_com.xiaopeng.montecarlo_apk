package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FootprintNaviRecordParam implements Serializable {
    public String dstAdcode;
    public int maxCount;
    public int maxNaviDist;
    public int minNaviDist;
    public String naviTime;
    public String srcAdcode;

    public FootprintNaviRecordParam() {
        this.maxCount = 20;
        this.minNaviDist = 0;
        this.maxNaviDist = 0;
        this.naviTime = "";
        this.srcAdcode = "";
        this.dstAdcode = "";
    }

    public FootprintNaviRecordParam(int i, int i2, int i3, String str, String str2, String str3) {
        this.maxCount = i;
        this.minNaviDist = i2;
        this.maxNaviDist = i3;
        this.naviTime = str;
        this.srcAdcode = str2;
        this.dstAdcode = str3;
    }
}
