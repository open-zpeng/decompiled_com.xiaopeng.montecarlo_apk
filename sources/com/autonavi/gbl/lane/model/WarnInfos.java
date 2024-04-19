package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WarnInfos implements Serializable {
    public int modelResID;
    public ArrayList<WarningPartsAnimation> partsAnimation;
    public ArrayList<WarningPartsAnimationFade> partsFade;
    public ArrayList<WarningPartsStyle> partsStyle;

    public WarnInfos() {
        this.modelResID = 0;
        this.partsStyle = new ArrayList<>();
        this.partsAnimation = new ArrayList<>();
        this.partsFade = new ArrayList<>();
    }

    public WarnInfos(int i, ArrayList<WarningPartsStyle> arrayList, ArrayList<WarningPartsAnimation> arrayList2, ArrayList<WarningPartsAnimationFade> arrayList3) {
        this.modelResID = i;
        this.partsStyle = arrayList;
        this.partsAnimation = arrayList2;
        this.partsFade = arrayList3;
    }
}
