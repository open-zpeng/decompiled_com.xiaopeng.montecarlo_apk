package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataServicearea implements Serializable {
    public ArrayList<WsNavigationDynamicDataDataSubitem> data;
    public ArrayList<String> show_type;

    public WsNavigationDynamicDataServicearea() {
        this.show_type = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    public WsNavigationDynamicDataServicearea(ArrayList<String> arrayList, ArrayList<WsNavigationDynamicDataDataSubitem> arrayList2) {
        this.show_type = arrayList;
        this.data = arrayList2;
    }
}
