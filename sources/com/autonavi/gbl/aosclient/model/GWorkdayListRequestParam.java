package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWorkdayListRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String diu = "";

    public GWorkdayListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WORKDAYLIST;
    }
}
