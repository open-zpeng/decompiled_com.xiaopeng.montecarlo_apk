package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepChargePlugsInfo implements Serializable {
    public String brand_desc;
    public int concur;
    public int conpower;
    public int convol;
    public int fastcur;
    public int fastpower;
    public int fastvol;
    public int speed_type;
    public int vol;
    public String vol_type;

    public DeepChargePlugsInfo() {
        this.vol = 0;
        this.speed_type = 0;
        this.vol_type = "";
        this.brand_desc = "";
        this.convol = 0;
        this.concur = 0;
        this.conpower = 0;
        this.fastvol = 0;
        this.fastcur = 0;
        this.fastpower = 0;
    }

    public DeepChargePlugsInfo(int i, int i2, String str, String str2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.vol = i;
        this.speed_type = i2;
        this.vol_type = str;
        this.brand_desc = str2;
        this.convol = i3;
        this.concur = i4;
        this.conpower = i5;
        this.fastvol = i6;
        this.fastcur = i7;
        this.fastpower = i8;
    }
}
