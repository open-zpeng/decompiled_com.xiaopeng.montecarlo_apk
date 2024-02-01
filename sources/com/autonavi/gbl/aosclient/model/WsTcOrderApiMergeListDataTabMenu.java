package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTcOrderApiMergeListDataTabMenu implements Serializable {
    public ArrayList<Integer> checkedValue;
    public String conditionName;
    public int countTag;
    public String key;
    public String name;
    public ArrayList<WsTcOrderApiMergeListTabMenuStatusTab> statusTabs;

    public WsTcOrderApiMergeListDataTabMenu() {
        this.name = "";
        this.key = "";
        this.countTag = 0;
        this.checkedValue = new ArrayList<>();
        this.statusTabs = new ArrayList<>();
        this.conditionName = "";
    }

    public WsTcOrderApiMergeListDataTabMenu(String str, String str2, int i, ArrayList<Integer> arrayList, ArrayList<WsTcOrderApiMergeListTabMenuStatusTab> arrayList2, String str3) {
        this.name = str;
        this.key = str2;
        this.countTag = i;
        this.checkedValue = arrayList;
        this.statusTabs = arrayList2;
        this.conditionName = str3;
    }
}
