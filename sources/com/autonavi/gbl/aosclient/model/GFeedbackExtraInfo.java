package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GFeedbackExtraInfo implements Serializable {
    public int bgc_status;
    public int car_used;
    public GFeedbackExtraContribute contribute;
    public String cpcode;
    public String diagonal;
    public String keywords;
    public String load;
    public String loc_unsure_time;
    public String max_height;
    public int open_switch;
    public String original_points;
    public String scaleaccuracy;
    public String sonPOIID;
    public String truck_navi_option;

    public GFeedbackExtraInfo() {
        this.truck_navi_option = "";
        this.max_height = "";
        this.load = "";
        this.bgc_status = 0;
        this.keywords = "";
        this.diagonal = "";
        this.scaleaccuracy = "";
        this.loc_unsure_time = "";
        this.open_switch = 0;
        this.car_used = 0;
        this.sonPOIID = "";
        this.cpcode = "";
        this.original_points = "";
        this.contribute = new GFeedbackExtraContribute();
    }

    public GFeedbackExtraInfo(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, int i2, int i3, String str8, String str9, String str10, GFeedbackExtraContribute gFeedbackExtraContribute) {
        this.truck_navi_option = str;
        this.max_height = str2;
        this.load = str3;
        this.bgc_status = i;
        this.keywords = str4;
        this.diagonal = str5;
        this.scaleaccuracy = str6;
        this.loc_unsure_time = str7;
        this.open_switch = i2;
        this.car_used = i3;
        this.sonPOIID = str8;
        this.cpcode = str9;
        this.original_points = str10;
        this.contribute = gFeedbackExtraContribute;
    }
}
