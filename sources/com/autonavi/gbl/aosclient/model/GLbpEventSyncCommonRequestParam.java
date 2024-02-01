package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GLbpEventSyncCommonRequestParam extends BLRequestBase implements Serializable {
    public ArrayList<EventSyncCommonRequestPush> push = new ArrayList<>();
    public String partner = "";

    public GLbpEventSyncCommonRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_LBP_EVENT_SYNC_COMMON;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
