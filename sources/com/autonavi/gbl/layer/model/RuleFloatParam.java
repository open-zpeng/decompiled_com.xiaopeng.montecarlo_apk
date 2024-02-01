package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RuleFloatParam implements Serializable {
    public String key;
    public String ruleType;
    public float value;

    public RuleFloatParam() {
        this.ruleType = "";
        this.key = "";
        this.value = 0.0f;
    }

    public RuleFloatParam(String str, String str2, float f) {
        this.ruleType = str;
        this.key = str2;
        this.value = f;
    }
}
