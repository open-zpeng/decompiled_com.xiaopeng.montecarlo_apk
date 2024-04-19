package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GPathsReqParam implements Serializable {
    public ArrayList<GLinkInfosReqParam> linkInfos;
    public String pathId;

    public GPathsReqParam() {
        this.pathId = "";
        this.linkInfos = new ArrayList<>();
    }

    public GPathsReqParam(String str, ArrayList<GLinkInfosReqParam> arrayList) {
        this.pathId = str;
        this.linkInfos = arrayList;
    }
}
