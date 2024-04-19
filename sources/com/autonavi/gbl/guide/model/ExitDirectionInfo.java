package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExitDirectionInfo implements Serializable {
    public ArrayList<String> directionInfo;
    public int disToCurrentPos;
    public String entranceExit;
    public ArrayList<String> exitNameInfo;
    public int remainTime;

    public ExitDirectionInfo() {
        this.exitNameInfo = new ArrayList<>();
        this.directionInfo = new ArrayList<>();
        this.disToCurrentPos = 0;
        this.remainTime = 0;
        this.entranceExit = "";
    }

    public ExitDirectionInfo(ArrayList<String> arrayList, ArrayList<String> arrayList2, int i, int i2, String str) {
        this.exitNameInfo = arrayList;
        this.directionInfo = arrayList2;
        this.disToCurrentPos = i;
        this.remainTime = i2;
        this.entranceExit = str;
    }
}
