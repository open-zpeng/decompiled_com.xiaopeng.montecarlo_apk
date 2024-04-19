package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class QueryByLinksAckDataPathsItem implements Serializable {
    public String pathId;
    public ArrayList<QueryByLinksAckDataPathsWeathersItem> weathers;

    public QueryByLinksAckDataPathsItem() {
        this.pathId = "";
        this.weathers = new ArrayList<>();
    }

    public QueryByLinksAckDataPathsItem(String str, ArrayList<QueryByLinksAckDataPathsWeathersItem> arrayList) {
        this.pathId = str;
        this.weathers = arrayList;
    }
}
