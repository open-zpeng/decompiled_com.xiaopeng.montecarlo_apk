package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CEtaRequestRequestParam extends BLRequestBase implements Serializable {
    public String start_x = "";
    public String start_y = "";
    public String start_poi = "";
    public String end_x = "";
    public String end_y = "";
    public String end_poi = "";
    public String etype = "";
    public String start_adcode = "";
    public String end_adcode = "";
    public String taxi_price_flag = "";
    public String carplate = "";
    public String content_options = "";
    public String vehicle_type = "";
    public String vehichle_height = "";
    public String vehicle_load = "";
    public String policy2 = "";
    public String multi_routes = "";
    public String sdk_version = "";
    public String partial_result = "";
    public String use_truck_engine = "";
    public int vehicle_axis = 0;

    public CEtaRequestRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_ETAREQUEST;
    }
}
