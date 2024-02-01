package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsUserviewFootprintNaviRecordData implements Serializable {
    public int cur_switch;
    public int is_login;
    public ArrayList<WsUserviewFootprintNaviRecordRecordItem> record;

    public WsUserviewFootprintNaviRecordData() {
        this.cur_switch = 0;
        this.is_login = 0;
        this.record = new ArrayList<>();
    }

    public WsUserviewFootprintNaviRecordData(int i, int i2, ArrayList<WsUserviewFootprintNaviRecordRecordItem> arrayList) {
        this.cur_switch = i;
        this.is_login = i2;
        this.record = arrayList;
    }
}
