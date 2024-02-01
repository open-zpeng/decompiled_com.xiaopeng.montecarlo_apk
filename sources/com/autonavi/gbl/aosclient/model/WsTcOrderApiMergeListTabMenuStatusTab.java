package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTcOrderApiMergeListTabMenuStatusTab implements Serializable {
    public String name;
    public ArrayList<Integer> status;

    public WsTcOrderApiMergeListTabMenuStatusTab() {
        this.name = "";
        this.status = new ArrayList<>();
    }

    public WsTcOrderApiMergeListTabMenuStatusTab(String str, ArrayList<Integer> arrayList) {
        this.name = str;
        this.status = arrayList;
    }
}
