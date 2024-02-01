package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ScenicMainPageRecDataScenicGuide implements Serializable {
    public int effective_level;
    public ArrayList<ScenicMainPageRecDataScenicGuideListItem> list;

    public ScenicMainPageRecDataScenicGuide() {
        this.effective_level = 0;
        this.list = new ArrayList<>();
    }

    public ScenicMainPageRecDataScenicGuide(int i, ArrayList<ScenicMainPageRecDataScenicGuideListItem> arrayList) {
        this.effective_level = i;
        this.list = arrayList;
    }
}
