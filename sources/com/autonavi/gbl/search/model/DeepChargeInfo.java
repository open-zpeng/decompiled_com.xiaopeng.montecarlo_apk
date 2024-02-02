package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DeepChargeInfo implements Serializable {
    public ArrayList<DeepChargePlugsInfo> charge_Plugs_Info;
    public int max_vol;
    public int min_vol;
    public String plugstype;
    public String vol_type;

    public DeepChargeInfo() {
        this.charge_Plugs_Info = new ArrayList<>();
        this.max_vol = 0;
        this.min_vol = 0;
        this.plugstype = "";
        this.vol_type = "";
    }

    public DeepChargeInfo(ArrayList<DeepChargePlugsInfo> arrayList, int i, int i2, String str, String str2) {
        this.charge_Plugs_Info = arrayList;
        this.max_vol = i;
        this.min_vol = i2;
        this.plugstype = str;
        this.vol_type = str2;
    }
}
