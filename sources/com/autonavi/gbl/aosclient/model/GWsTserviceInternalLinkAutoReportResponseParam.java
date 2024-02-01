package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceInternalLinkAutoReportResponseParam extends BLResponseBase implements Serializable {
    public WsTserviceinternalLinkAutoReportData data = new WsTserviceinternalLinkAutoReportData();

    public GWsTserviceInternalLinkAutoReportResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_INTERNAL_LINK_AUTO_REPORT;
        this.mNetworkStatus = 0;
    }
}
