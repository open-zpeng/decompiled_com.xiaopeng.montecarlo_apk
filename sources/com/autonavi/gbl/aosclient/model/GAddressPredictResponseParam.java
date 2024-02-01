package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GAddressPredictResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<GPredictInfo> vctPredictList = new ArrayList<>();

    public GAddressPredictResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_ADDRESSPREDICT;
    }
}
