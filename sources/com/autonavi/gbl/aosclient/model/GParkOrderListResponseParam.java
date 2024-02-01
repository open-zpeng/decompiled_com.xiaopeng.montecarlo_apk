package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GParkOrderListResponseParam extends BLResponseBase implements Serializable {
    public int Total = 0;
    public ArrayList<GParkOrderItem> vctOrderList = new ArrayList<>();

    public GParkOrderListResponseParam() {
        this.mEAosRequestType = 200009;
    }
}
