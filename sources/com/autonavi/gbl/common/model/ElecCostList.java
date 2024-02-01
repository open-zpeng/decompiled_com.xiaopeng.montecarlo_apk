package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ElecCostList implements Serializable {
    public int ID;
    public float auxValue;
    public ElecCommonParameter curve;
    public float ferryRate;
    public ArrayList<PowertrainLoss> powertrainLoss;
    public ElecCommonParameter slope;
    public ArrayList<ElecSpeedCostList> speedCost;
    public ElecCommonParameter trans;
    public int type;

    public ElecCostList() {
        this.ID = 0;
        this.type = 0;
        this.speedCost = new ArrayList<>();
        this.powertrainLoss = new ArrayList<>();
        this.trans = new ElecCommonParameter();
        this.curve = new ElecCommonParameter();
        this.slope = new ElecCommonParameter();
        this.auxValue = 0.0f;
        this.ferryRate = 0.0f;
    }

    public ElecCostList(int i, int i2, ArrayList<ElecSpeedCostList> arrayList, ArrayList<PowertrainLoss> arrayList2, ElecCommonParameter elecCommonParameter, ElecCommonParameter elecCommonParameter2, ElecCommonParameter elecCommonParameter3, float f, float f2) {
        this.ID = i;
        this.type = i2;
        this.speedCost = arrayList;
        this.powertrainLoss = arrayList2;
        this.trans = elecCommonParameter;
        this.curve = elecCommonParameter2;
        this.slope = elecCommonParameter3;
        this.auxValue = f;
        this.ferryRate = f2;
    }
}
