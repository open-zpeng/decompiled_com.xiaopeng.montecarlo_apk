package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRestrictCity implements Serializable {
    public int cityCode;
    public String cityName;
    public String pinyin;
    public int ruleNums;
    public int ruleType;
    public ArrayList<GRestrictRule> rules;
    public String title;

    public GRestrictCity() {
        this.cityCode = 0;
        this.cityName = "";
        this.title = "";
        this.ruleNums = 0;
        this.ruleType = 0;
        this.rules = new ArrayList<>();
        this.pinyin = "";
    }

    public GRestrictCity(int i, String str, String str2, int i2, int i3, ArrayList<GRestrictRule> arrayList, String str3) {
        this.cityCode = i;
        this.cityName = str;
        this.title = str2;
        this.ruleNums = i2;
        this.ruleType = i3;
        this.rules = arrayList;
        this.pinyin = str3;
    }
}
