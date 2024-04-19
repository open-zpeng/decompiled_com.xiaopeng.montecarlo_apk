package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataNaviRouteLink implements Serializable {
    public String endsegmentidx;
    public WsNavigationDynamicDataLinksAdcode links_adcode;
    public ArrayList<String> links_eta;
    public ArrayList<String> links_prop_start_end;
    public long path_id;
    public ArrayList<String> segment;
    public ArrayList<String> segment_distance;
    public ArrayList<String> service_area_poi_ids;
    public String startsegmentidx;
    public String sub_e_poiid;

    public WsNavigationDynamicDataNaviRouteLink() {
        this.startsegmentidx = "";
        this.endsegmentidx = "";
        this.segment = new ArrayList<>();
        this.links_prop_start_end = new ArrayList<>();
        this.segment_distance = new ArrayList<>();
        this.links_adcode = new WsNavigationDynamicDataLinksAdcode();
        this.links_eta = new ArrayList<>();
        this.path_id = 0L;
        this.sub_e_poiid = "";
        this.service_area_poi_ids = new ArrayList<>();
    }

    public WsNavigationDynamicDataNaviRouteLink(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, WsNavigationDynamicDataLinksAdcode wsNavigationDynamicDataLinksAdcode, ArrayList<String> arrayList4, long j, String str3, ArrayList<String> arrayList5) {
        this.startsegmentidx = str;
        this.endsegmentidx = str2;
        this.segment = arrayList;
        this.links_prop_start_end = arrayList2;
        this.segment_distance = arrayList3;
        this.links_adcode = wsNavigationDynamicDataLinksAdcode;
        this.links_eta = arrayList4;
        this.path_id = j;
        this.sub_e_poiid = str3;
        this.service_area_poi_ids = arrayList5;
    }
}
