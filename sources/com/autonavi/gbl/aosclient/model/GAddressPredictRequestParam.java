package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GAddressPredictRequestParam extends BLRequestBase implements Serializable {
    public String uid = "";
    public String queryType = "";
    public String label = "";

    public GAddressPredictRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_ADDRESSPREDICT;
    }
}
