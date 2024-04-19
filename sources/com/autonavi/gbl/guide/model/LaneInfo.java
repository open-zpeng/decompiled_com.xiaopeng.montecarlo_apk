package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LaneInfo implements Serializable {
    public ArrayList<Integer> backExtenLane;
    public ArrayList<Integer> backLane;
    public ArrayList<Integer> extensionLane;
    public ArrayList<Integer> frontExtenLane;
    public ArrayList<Integer> frontLane;
    public int linkIdx;
    public ArrayList<Integer> optimalLane;
    public Coord2DDouble point;
    public int segmentIdx;

    public LaneInfo() {
        this.backLane = new ArrayList<>();
        this.frontLane = new ArrayList<>();
        this.optimalLane = new ArrayList<>();
        this.backExtenLane = new ArrayList<>();
        this.frontExtenLane = new ArrayList<>();
        this.extensionLane = new ArrayList<>();
        this.point = new Coord2DDouble();
        this.segmentIdx = -1;
        this.linkIdx = -1;
    }

    public LaneInfo(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, ArrayList<Integer> arrayList4, ArrayList<Integer> arrayList5, ArrayList<Integer> arrayList6, Coord2DDouble coord2DDouble, int i, int i2) {
        this.backLane = arrayList;
        this.frontLane = arrayList2;
        this.optimalLane = arrayList3;
        this.backExtenLane = arrayList4;
        this.frontExtenLane = arrayList5;
        this.extensionLane = arrayList6;
        this.point = coord2DDouble;
        this.segmentIdx = i;
        this.linkIdx = i2;
    }
}
