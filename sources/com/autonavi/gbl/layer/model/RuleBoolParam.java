package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RuleBoolParam implements Serializable {
    public String key;
    public String ruleType;
    public boolean value;

    public RuleBoolParam() {
        this.ruleType = "";
        this.key = "";
        this.value = false;
    }

    public RuleBoolParam(String str, String str2, boolean z) {
        this.ruleType = str;
        this.key = str2;
        this.value = z;
    }
}
