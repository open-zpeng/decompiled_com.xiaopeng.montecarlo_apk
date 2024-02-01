package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GHolidayListRequestParam extends BLRequestBase implements Serializable {
    public String dic = "";
    public String div = "";

    public GHolidayListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_HOLIDAYLIST;
    }
}
