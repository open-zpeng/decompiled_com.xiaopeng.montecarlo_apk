package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchQllSuggestQuery implements Serializable {
    public int col;
    public int row;
    public ArrayList<SearchQllSuggestData> sugData;

    public SearchQllSuggestQuery() {
        this.sugData = new ArrayList<>();
        this.col = 0;
        this.row = 0;
    }

    public SearchQllSuggestQuery(ArrayList<SearchQllSuggestData> arrayList, int i, int i2) {
        this.sugData = arrayList;
        this.col = i;
        this.row = i2;
    }
}
