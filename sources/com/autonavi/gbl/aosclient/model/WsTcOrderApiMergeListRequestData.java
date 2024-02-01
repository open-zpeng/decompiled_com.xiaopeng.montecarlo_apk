package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTcOrderApiMergeListRequestData implements Serializable {
    public String attachment;
    public String bizKey;
    public ArrayList<Integer> bizTypes;
    public long maxTs;
    public boolean menu;
    public ArrayList<Integer> orderStatusList;
    public int pageSize;
    public String statusKey;
    public String userId;

    public WsTcOrderApiMergeListRequestData() {
        this.pageSize = 0;
        this.menu = false;
        this.orderStatusList = new ArrayList<>();
        this.bizTypes = new ArrayList<>();
        this.attachment = "";
        this.userId = "";
        this.maxTs = -1L;
        this.statusKey = "";
        this.bizKey = "";
    }

    public WsTcOrderApiMergeListRequestData(int i, boolean z, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, String str, String str2, long j, String str3, String str4) {
        this.pageSize = i;
        this.menu = z;
        this.orderStatusList = arrayList;
        this.bizTypes = arrayList2;
        this.attachment = str;
        this.userId = str2;
        this.maxTs = j;
        this.statusKey = str3;
        this.bizKey = str4;
    }
}
