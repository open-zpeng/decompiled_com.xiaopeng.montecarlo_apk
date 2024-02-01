package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTserviceInternalLinkCarReportRequestParam extends BLRequestBase implements Serializable {
    public String appType = "";
    public int naviStatus = 0;
    public String clientTraceId = "";
    public int naviCalcuResult = 0;
    public WsTserviceInternalLinkCarReportNaviLocInfo naviLocInfo = new WsTserviceInternalLinkCarReportNaviLocInfo();
    public WsTserviceInternalLinkCarReportPoiInfo endPoi = new WsTserviceInternalLinkCarReportPoiInfo();
    public ArrayList<WsTserviceInternalLinkCarReportPoiInfo> midPois = new ArrayList<>();
    public int dataChange = 0;
    public String data = "";

    public GWsTserviceInternalLinkCarReportRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_INTERNAL_LINK_CAR_REPORT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
