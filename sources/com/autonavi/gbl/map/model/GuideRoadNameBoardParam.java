package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GuideRoadNameBoardParam implements Serializable {
    public boolean isCruise;
    public PointD leftButtom;
    public PointD leftTop;
    public float maxLevel;
    public int maxRoadNameCount;
    public float minLevel;
    public PointD rightBottom;
    public PointD rightTop;
    public String roadName;

    public GuideRoadNameBoardParam() {
        this.isCruise = false;
        this.maxRoadNameCount = 5;
        this.maxLevel = 19.0f;
        this.minLevel = 15.0f;
        this.leftTop = new PointD();
        this.leftButtom = new PointD();
        this.rightTop = new PointD();
        this.rightBottom = new PointD();
        this.roadName = "";
    }

    public GuideRoadNameBoardParam(boolean z, int i, float f, float f2, PointD pointD, PointD pointD2, PointD pointD3, PointD pointD4, String str) {
        this.isCruise = z;
        this.maxRoadNameCount = i;
        this.maxLevel = f;
        this.minLevel = f2;
        this.leftTop = pointD;
        this.leftButtom = pointD2;
        this.rightTop = pointD3;
        this.rightBottom = pointD4;
        this.roadName = str;
    }
}
