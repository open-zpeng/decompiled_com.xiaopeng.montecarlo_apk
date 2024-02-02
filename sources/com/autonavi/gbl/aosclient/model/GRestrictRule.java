package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRestrictRule implements Serializable {
    public ArrayList<GRestrictRulePoints> areapoints;
    public GRectDouble bound;
    public GCoord3DDouble centerpoint;
    public String desc;
    public int effect;
    public ArrayList<GRestrictRulePoints> linepoints;
    public int local;
    public String otherdesc;
    public String policyname;
    public int ring;
    public int ruleid;
    public String summary;
    public String time;
    public int vehicle;

    public GRestrictRule() {
        this.policyname = "";
        this.ruleid = 0;
        this.ring = 0;
        this.effect = 0;
        this.local = 0;
        this.vehicle = 0;
        this.time = "";
        this.summary = "";
        this.desc = "";
        this.otherdesc = "";
        this.centerpoint = new GCoord3DDouble();
        this.linepoints = new ArrayList<>();
        this.areapoints = new ArrayList<>();
        this.bound = new GRectDouble();
    }

    public GRestrictRule(String str, int i, int i2, int i3, int i4, int i5, String str2, String str3, String str4, String str5, GCoord3DDouble gCoord3DDouble, ArrayList<GRestrictRulePoints> arrayList, ArrayList<GRestrictRulePoints> arrayList2, GRectDouble gRectDouble) {
        this.policyname = str;
        this.ruleid = i;
        this.ring = i2;
        this.effect = i3;
        this.local = i4;
        this.vehicle = i5;
        this.time = str2;
        this.summary = str3;
        this.desc = str4;
        this.otherdesc = str5;
        this.centerpoint = gCoord3DDouble;
        this.linepoints = arrayList;
        this.areapoints = arrayList2;
        this.bound = gRectDouble;
    }
}
