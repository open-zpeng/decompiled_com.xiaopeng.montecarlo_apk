package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsUserviewFootprintSummaryAckData implements Serializable {
    public int cur_switch;
    public int is_login;
    public ArrayList<ModuleItem> module;

    public WsUserviewFootprintSummaryAckData() {
        this.cur_switch = 0;
        this.is_login = 0;
        this.module = new ArrayList<>();
    }

    public WsUserviewFootprintSummaryAckData(int i, int i2, ArrayList<ModuleItem> arrayList) {
        this.cur_switch = i;
        this.is_login = i2;
        this.module = arrayList;
    }
}
