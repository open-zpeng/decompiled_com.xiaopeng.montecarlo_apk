package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ActionPlayDesc implements Serializable {
    public String actionName;
    public int repeatTime;

    public ActionPlayDesc() {
        this.actionName = "";
        this.repeatTime = 0;
    }

    public ActionPlayDesc(String str, int i) {
        this.actionName = str;
        this.repeatTime = i;
    }
}
