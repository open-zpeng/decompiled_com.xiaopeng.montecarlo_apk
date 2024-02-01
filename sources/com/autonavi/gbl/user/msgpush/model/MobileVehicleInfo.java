package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MobileVehicleInfo implements Serializable {
    public int axis;
    public double height;
    public double load;
    public String plate;
    public int size;
    public int type;
    public double weight;
    public double width;

    public MobileVehicleInfo() {
        this.type = 0;
        this.size = 2;
        this.height = 0.0d;
        this.width = 0.0d;
        this.load = 0.0d;
        this.weight = 0.0d;
        this.axis = 0;
        this.plate = "";
    }

    public MobileVehicleInfo(int i, int i2, double d, double d2, double d3, double d4, int i3, String str) {
        this.type = i;
        this.size = i2;
        this.height = d;
        this.width = d2;
        this.load = d3;
        this.weight = d4;
        this.axis = i3;
        this.plate = str;
    }
}
