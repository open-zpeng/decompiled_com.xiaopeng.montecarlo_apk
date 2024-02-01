package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTrafficEventCommentRequestParam extends BLRequestBase implements Serializable {
    public int Type = 1;
    public String Id = "";
    public double Lon = 10000.0d;
    public double Lat = 10000.0d;
    public String comment_from = "";
    public String report_link = "";
    public String comment_cost = "";
    public String navi_type = "";

    public GTrafficEventCommentRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_TRAFFICEVENTCOMMENT;
    }
}
