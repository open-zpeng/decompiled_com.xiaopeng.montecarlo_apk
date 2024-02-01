package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RuleInt64Param implements Serializable {
    public String key;
    public String ruleType;
    public long value;

    public RuleInt64Param() {
        this.ruleType = "";
        this.key = "";
        this.value = 0L;
    }

    public RuleInt64Param(String str, String str2, long j) {
        this.ruleType = str;
        this.key = str2;
        this.value = j;
    }
}
