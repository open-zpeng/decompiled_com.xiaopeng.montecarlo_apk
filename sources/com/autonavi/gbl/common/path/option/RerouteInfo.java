package com.autonavi.gbl.common.path.option;

import com.autonavi.gbl.common.path.model.UpLoadLink;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RerouteInfo implements Serializable {
    public ArrayList<Integer> backupPathRemainDistance;
    public ArrayList<Integer> backupPathRemainTime;
    public int linkIDSize;
    public int upLoadLinkNum;
    public ArrayList<UpLoadLink> uploadLink;

    public RerouteInfo() {
        this.uploadLink = new ArrayList<>();
        this.upLoadLinkNum = 0;
        this.linkIDSize = 0;
        this.backupPathRemainTime = new ArrayList<>();
        this.backupPathRemainDistance = new ArrayList<>();
    }

    public RerouteInfo(ArrayList<UpLoadLink> arrayList, int i, int i2, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3) {
        this.uploadLink = arrayList;
        this.upLoadLinkNum = i;
        this.linkIDSize = i2;
        this.backupPathRemainTime = arrayList2;
        this.backupPathRemainDistance = arrayList3;
    }
}
