package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsDynamicInfoCongestionGroupChatUserAddV3ResponseData implements Serializable {
    public String appCid;
    public boolean firstTimeAdd;
    public int groupChatUserAddPv;
    public int role;

    public WsDynamicInfoCongestionGroupChatUserAddV3ResponseData() {
        this.groupChatUserAddPv = 0;
        this.role = 0;
        this.appCid = "";
        this.firstTimeAdd = false;
    }

    public WsDynamicInfoCongestionGroupChatUserAddV3ResponseData(int i, int i2, String str, boolean z) {
        this.groupChatUserAddPv = i;
        this.role = i2;
        this.appCid = str;
        this.firstTimeAdd = z;
    }
}
