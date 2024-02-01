package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQueryWeatherByLinkRequestParam extends BLRequestBase implements Serializable {
    public String userid = "";
    public String password = "";
    public String date = "";
    public int batch = 0;
    public String deviceid = "";
    public ArrayList<GQueryWeatherByLinkReqItem> mReqLst = new ArrayList<>();

    public GQueryWeatherByLinkRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_QUERYWEATHERBYLINK;
    }
}
