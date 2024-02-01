package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsAppConfAppUpdateResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<GWsAppConfAppUpdateMemo> memoList = new ArrayList<>();

    public GWsAppConfAppUpdateResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WSAPPCONFAPPUPDATE;
    }
}
