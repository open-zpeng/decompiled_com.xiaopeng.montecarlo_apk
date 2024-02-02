package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnRegisterData implements Serializable {
    public String mobile;
    public ArrayList<String> reason;
    public int remain;

    public UnRegisterData() {
        this.remain = 0;
        this.mobile = "";
        this.reason = new ArrayList<>();
    }

    public UnRegisterData(int i, String str, ArrayList<String> arrayList) {
        this.remain = i;
        this.mobile = str;
        this.reason = arrayList;
    }
}
