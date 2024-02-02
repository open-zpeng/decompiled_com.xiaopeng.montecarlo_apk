package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class QueryByLinksAckData implements Serializable {
    public ArrayList<QueryByLinksAckDataPathsItem> paths;

    public QueryByLinksAckData() {
        this.paths = new ArrayList<>();
    }

    public QueryByLinksAckData(ArrayList<QueryByLinksAckDataPathsItem> arrayList) {
        this.paths = arrayList;
    }
}
