package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GHolidayListResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<String> lstHoliday = new ArrayList<>();

    public GHolidayListResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_HOLIDAYLIST;
    }
}
