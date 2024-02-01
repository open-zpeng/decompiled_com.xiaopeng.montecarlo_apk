package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTcOrderApiMergeListResponseData implements Serializable {
    public boolean hasMore;
    public long nextPageMaxTs;
    public ArrayList<WsTcOrderApiMergeListDataOrder> orders;
    public ArrayList<WsTcOrderApiMergeListDataTabMenu> tabMenu;

    public WsTcOrderApiMergeListResponseData() {
        this.orders = new ArrayList<>();
        this.hasMore = false;
        this.nextPageMaxTs = 0L;
        this.tabMenu = new ArrayList<>();
    }

    public WsTcOrderApiMergeListResponseData(ArrayList<WsTcOrderApiMergeListDataOrder> arrayList, boolean z, long j, ArrayList<WsTcOrderApiMergeListDataTabMenu> arrayList2) {
        this.orders = arrayList;
        this.hasMore = z;
        this.nextPageMaxTs = j;
        this.tabMenu = arrayList2;
    }
}
