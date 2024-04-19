package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RestrictionInfo implements Serializable {
    public int cityCode;
    public String desc;
    public ArrayList<Long> ruleIDs;
    public ArrayList<Short> tailNums;
    public String tips;
    public String title;
    public short titleType;
    public short type;

    public RestrictionInfo() {
        this.title = "";
        this.desc = "";
        this.tips = "";
        this.cityCode = 0;
        this.type = (short) 0;
        this.titleType = (short) 0;
        this.ruleIDs = new ArrayList<>();
        this.tailNums = new ArrayList<>();
    }

    public RestrictionInfo(String str, String str2, String str3, int i, short s, short s2, ArrayList<Long> arrayList, ArrayList<Short> arrayList2) {
        this.title = str;
        this.desc = str2;
        this.tips = str3;
        this.cityCode = i;
        this.type = s;
        this.titleType = s2;
        this.ruleIDs = arrayList;
        this.tailNums = arrayList2;
    }
}
