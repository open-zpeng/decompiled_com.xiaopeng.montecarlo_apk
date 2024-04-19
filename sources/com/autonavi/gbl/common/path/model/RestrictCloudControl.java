package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RestrictCloudControl implements Serializable {
    public ArrayList<String> blankList;
    public DetailCloudControl detailCloudControl;
    public String strCityName;
    public String strContent;
    public TipsCloudControl tipsControl;
    public ArrayList<RelDetail> vecRelTipDetail;

    public RestrictCloudControl() {
        this.tipsControl = new TipsCloudControl();
        this.blankList = new ArrayList<>();
        this.strCityName = "";
        this.vecRelTipDetail = new ArrayList<>();
        this.strContent = "";
        this.detailCloudControl = new DetailCloudControl();
    }

    public RestrictCloudControl(TipsCloudControl tipsCloudControl, ArrayList<String> arrayList, String str, ArrayList<RelDetail> arrayList2, String str2, DetailCloudControl detailCloudControl) {
        this.tipsControl = tipsCloudControl;
        this.blankList = arrayList;
        this.strCityName = str;
        this.vecRelTipDetail = arrayList2;
        this.strContent = str2;
        this.detailCloudControl = detailCloudControl;
    }
}
