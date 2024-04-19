package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ScenicMainPageRecDataCommute implements Serializable {
    public int flag;
    public ArrayList<PointItem> list;
    public int show;
    public int type;

    public ScenicMainPageRecDataCommute() {
        this.show = 0;
        this.flag = 0;
        this.type = 0;
        this.list = new ArrayList<>();
    }

    public ScenicMainPageRecDataCommute(int i, int i2, int i3, ArrayList<PointItem> arrayList) {
        this.show = i;
        this.flag = i2;
        this.type = i3;
        this.list = arrayList;
    }
}
