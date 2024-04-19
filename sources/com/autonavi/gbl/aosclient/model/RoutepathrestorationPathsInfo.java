package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoutepathrestorationPathsInfo implements Serializable {
    public ArrayList<String> id;
    public int id_mode;

    public RoutepathrestorationPathsInfo() {
        this.id_mode = 0;
        this.id = new ArrayList<>();
    }

    public RoutepathrestorationPathsInfo(int i, ArrayList<String> arrayList) {
        this.id_mode = i;
        this.id = arrayList;
    }
}
