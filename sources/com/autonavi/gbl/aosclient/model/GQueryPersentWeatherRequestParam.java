package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryPersentWeatherRequestParam extends BLRequestBase implements Serializable {
    public String userid = "";
    public String password = "";
    public String date = "";
    public int batch = 0;
    public String deviceid = "";
    public GQueryPersentWeatherReqItem mReqData = new GQueryPersentWeatherReqItem();

    public GQueryPersentWeatherRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_QUERYPERSENTWEATHER;
    }
}
