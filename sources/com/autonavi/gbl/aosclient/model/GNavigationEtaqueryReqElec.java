package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqElec implements Serializable {
    public double charge;
    public ArrayList<GNavigationEtaqueryReqElecConstList> cost_list;
    public int cost_model_switch;
    public int cost_uint;
    public int drive_train;
    public int fes_mode;
    public int has_traffic;
    public int mass;
    public String orga;
    public int top_speed;

    public GNavigationEtaqueryReqElec() {
        this.orga = "";
        this.drive_train = 0;
        this.fes_mode = 0;
        this.cost_model_switch = 0;
        this.top_speed = 0;
        this.mass = 0;
        this.charge = 0.0d;
        this.cost_uint = 0;
        this.has_traffic = 0;
        this.cost_list = new ArrayList<>();
    }

    public GNavigationEtaqueryReqElec(String str, int i, int i2, int i3, int i4, int i5, double d, int i6, int i7, ArrayList<GNavigationEtaqueryReqElecConstList> arrayList) {
        this.orga = str;
        this.drive_train = i;
        this.fes_mode = i2;
        this.cost_model_switch = i3;
        this.top_speed = i4;
        this.mass = i5;
        this.charge = d;
        this.cost_uint = i6;
        this.has_traffic = i7;
        this.cost_list = arrayList;
    }
}
