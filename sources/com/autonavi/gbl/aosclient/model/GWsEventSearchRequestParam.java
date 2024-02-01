package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsEventSearchRequestParam extends BLRequestBase implements Serializable {
    public String adiu = "";
    public String navi_id = "";
    public String path_id = "";
    public EventRect event_rect = new EventRect();
    public ArrayList<Integer> white_list = new ArrayList<>();
    public ArrayList<Integer> black_list = new ArrayList<>();
    public ArrayList<String> poi_ids1 = new ArrayList<>();

    public GWsEventSearchRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5__WS_CUSTOM1_EVENT_SEARCH;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
