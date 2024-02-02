package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqElecConstList implements Serializable {
    public double aux;
    public GNavigationEtaqueryReqElecConstListRangeTrans curve;
    public double ferry_rate;
    public int id;
    public ArrayList<GNavigationEtaqueryReqElecConstListPowertrainloss> powertrainloss;
    public GNavigationEtaqueryReqElecConstListRange range;
    public GNavigationEtaqueryReqElecConstListRangeSlope slope;
    public GNavigationEtaqueryReqElecConstListSpeed speed;
    public GNavigationEtaqueryReqElecConstListRangeTrans trans;
    public int type;

    public GNavigationEtaqueryReqElecConstList() {
        this.id = 0;
        this.type = 0;
        this.aux = 0.0d;
        this.ferry_rate = 0.0d;
        this.range = new GNavigationEtaqueryReqElecConstListRange();
        this.speed = new GNavigationEtaqueryReqElecConstListSpeed();
        this.powertrainloss = new ArrayList<>();
        this.trans = new GNavigationEtaqueryReqElecConstListRangeTrans();
        this.curve = new GNavigationEtaqueryReqElecConstListRangeTrans();
        this.slope = new GNavigationEtaqueryReqElecConstListRangeSlope();
    }

    public GNavigationEtaqueryReqElecConstList(int i, int i2, double d, double d2, GNavigationEtaqueryReqElecConstListRange gNavigationEtaqueryReqElecConstListRange, GNavigationEtaqueryReqElecConstListSpeed gNavigationEtaqueryReqElecConstListSpeed, ArrayList<GNavigationEtaqueryReqElecConstListPowertrainloss> arrayList, GNavigationEtaqueryReqElecConstListRangeTrans gNavigationEtaqueryReqElecConstListRangeTrans, GNavigationEtaqueryReqElecConstListRangeTrans gNavigationEtaqueryReqElecConstListRangeTrans2, GNavigationEtaqueryReqElecConstListRangeSlope gNavigationEtaqueryReqElecConstListRangeSlope) {
        this.id = i;
        this.type = i2;
        this.aux = d;
        this.ferry_rate = d2;
        this.range = gNavigationEtaqueryReqElecConstListRange;
        this.speed = gNavigationEtaqueryReqElecConstListSpeed;
        this.powertrainloss = arrayList;
        this.trans = gNavigationEtaqueryReqElecConstListRangeTrans;
        this.curve = gNavigationEtaqueryReqElecConstListRangeTrans2;
        this.slope = gNavigationEtaqueryReqElecConstListRangeSlope;
    }
}
