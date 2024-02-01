package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class STRestrictTips extends STBaseTips implements Serializable {
    public String strCityName = "";
    public String strContent = "";
    public String strCityCode = "";
    public String strTitle = "";
    public ArrayList<String> blankList = new ArrayList<>();

    public STRestrictTips() {
        this.tipsCategory = 3;
    }
}
