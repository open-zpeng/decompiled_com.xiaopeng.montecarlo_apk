package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsArchiveTrafficeventUpdateRequestParam extends BLRequestBase implements Serializable {
    public String appid = "";
    public int action = 1;
    public String event_id = "";
    public String displayname = "";
    public double longitude = 0.0d;
    public double latitude = 0.0d;
    public String gpsx = "";
    public String gpsy = "";
    public int mode = -1;
    public double accuracy = -1.0d;
    public int ontbt = -1;
    public int ismainroad = -1;
    public String speed = "";
    public String direction = "";
    public String gpstime = "";
    public String address = "";
    public String content = "";
    public String layerid = "1040";
    public String layertag = "";
    public int direct = -1;
    public int way = -1;
    public String pictype = "";
    public String file = "";
    public String audio = "";
    public String audiolen = "";
    public String rawid = "";
    public String source = "";
    public String level = "";
    public String expiretime = "";
    public String extend = "";
    public boolean anonymous = true;
    public int opposite = -1;
    public String videourl = "";
    public String driveway = "";
    public String label = "";
    public int reportfrom = -1;
    public String report_type = "";
    public String audio_content = "";

    public GWsArchiveTrafficeventUpdateRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WSARCHIVETRAFFICEVENTUPDATE;
        this.mEReqProtol = 0;
    }
}
