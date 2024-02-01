package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GFeedbackReportRequestParam extends BLRequestBase implements Serializable {
    public String type = "";
    public String title = "";
    public String contact = "";
    public GFeedbackDescription description = new GFeedbackDescription();
    public String poiid = "";
    public String category = "";
    public String name = "";
    public String address = "";
    public double longitude = 0.0d;
    public double latitude = 0.0d;
    public String points = "";
    public String tel = "";
    public String adcode = "";
    public String startpoint = "";
    public String endpoint = "";
    public String picture = "";
    public String offlinemap_log = "";
    public String attachment = "";
    public ArrayList<GFeedbackPictureInfo> picture_info = new ArrayList<>();
    public int errortype = -1;
    public int sourcepage = -1;
    public String subtype = "";
    public int promotion = -1;
    public String mode = "";
    public String mapver = "";
    public String Ad1 = "";
    public String Ad2 = "";
    public int errorcode = -1;
    public String token = "";
    public String dib = "";
    public String dibv = "";
    public String snowman_id = "";
    public String snowman_action = "";
    public String snowman_engine = "";
    public String content_options = "";
    public String passing_points = "";
    public String plate = "";
    public int error_id = -1;
    public String lineid = "";
    public String bus_lineids = "";
    public String bus_poiids = "";
    public String unique_id = "";
    public GFeedbackExtraInfo extra_info = new GFeedbackExtraInfo();
    public String aetraffic = "";
    public int wifi_status = -1;
    public int gps_status = -1;
    public String doc_id = "";
    public int report_tags = -1;
    public String doc_name = "";

    public GFeedbackReportRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_FEEDBACKREPORT;
    }
}
