package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsNavigationDynamicFatigueRequestParam extends BLRequestBase implements Serializable {
    public String dynamic_id = "";
    public ArrayList<String> dynamic_ids = new ArrayList<>();

    public GWsNavigationDynamicFatigueRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_NAVIGATION_DYNAMIC_FATIGUE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
