package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTcFuelQueryagreementResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<FuelQueryAgreementResponseData> data = new ArrayList<>();

    public GWsTcFuelQueryagreementResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_QUERYAGREEMENT;
        this.mNetworkStatus = 0;
    }
}
