package com.autonavi.gbl.common.path.option;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserAvoidInfo implements Serializable {
    public ArrayList<UserAvoidArea> areaList;
    public ArrayList<Long> linkList;
    public String roadName;
    public short type;

    public UserAvoidInfo() {
        this.type = (short) 4;
        this.roadName = "";
        this.areaList = new ArrayList<>();
        this.linkList = new ArrayList<>();
    }

    public UserAvoidInfo(short s, String str, ArrayList<UserAvoidArea> arrayList, ArrayList<Long> arrayList2) {
        this.type = s;
        this.roadName = str;
        this.areaList = arrayList;
        this.linkList = arrayList2;
    }
}
