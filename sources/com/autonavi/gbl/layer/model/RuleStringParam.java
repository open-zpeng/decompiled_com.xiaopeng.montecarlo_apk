package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RuleStringParam implements Serializable {
    public String key;
    public String ruleType;
    public String value;

    public RuleStringParam() {
        this.ruleType = "";
        this.key = "";
        this.value = "";
    }

    public RuleStringParam(String str, String str2, String str3) {
        this.ruleType = str;
        this.key = str2;
        this.value = str3;
    }
}
