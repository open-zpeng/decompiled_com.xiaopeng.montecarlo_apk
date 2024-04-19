package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.LightBarItem;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LightBarInfo implements Serializable {
    public ArrayList<LightBarItem> itemList;
    public long pathID;

    public LightBarInfo() {
        this.itemList = new ArrayList<>();
        this.pathID = 0L;
    }

    public LightBarInfo(ArrayList<LightBarItem> arrayList, long j) {
        this.itemList = arrayList;
        this.pathID = j;
    }
}
