package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTserviceIotDeviceListDataItem implements Serializable {
    public int code;
    public ArrayList<WsTserviceIotDeviceListDataItemInfoItem> data;
    public String type;

    public WsTserviceIotDeviceListDataItem() {
        this.code = 0;
        this.type = "";
        this.data = new ArrayList<>();
    }

    public WsTserviceIotDeviceListDataItem(int i, String str, ArrayList<WsTserviceIotDeviceListDataItemInfoItem> arrayList) {
        this.code = i;
        this.type = str;
        this.data = arrayList;
    }
}
