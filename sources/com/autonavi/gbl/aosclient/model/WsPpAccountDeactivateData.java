package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsPpAccountDeactivateData implements Serializable {
    public String mobile;
    public ArrayList<String> reason;
    public int remain;

    public WsPpAccountDeactivateData() {
        this.remain = 0;
        this.reason = new ArrayList<>();
        this.mobile = "";
    }

    public WsPpAccountDeactivateData(int i, ArrayList<String> arrayList, String str) {
        this.remain = i;
        this.reason = arrayList;
        this.mobile = str;
    }
}
