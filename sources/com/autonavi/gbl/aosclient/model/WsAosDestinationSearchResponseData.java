package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAosDestinationSearchResponseData implements Serializable {
    public ArrayList<WsAosDestinationSearchDataAoiDetail> aoiDetail;
    public String driveNotice;
    public String driveNoticeTag;
    public String driveNoticeType;
    public WsAosDestinationSearchDataPoiInfo poiInfo;
    public int resultType;
    public ArrayList<WsAosDestinationSearchDataTabList> tabList;
    public String title;

    public WsAosDestinationSearchResponseData() {
        this.driveNoticeType = "";
        this.aoiDetail = new ArrayList<>();
        this.tabList = new ArrayList<>();
        this.driveNoticeTag = "";
        this.poiInfo = new WsAosDestinationSearchDataPoiInfo();
        this.driveNotice = "";
        this.title = "";
        this.resultType = 0;
    }

    public WsAosDestinationSearchResponseData(String str, ArrayList<WsAosDestinationSearchDataAoiDetail> arrayList, ArrayList<WsAosDestinationSearchDataTabList> arrayList2, String str2, WsAosDestinationSearchDataPoiInfo wsAosDestinationSearchDataPoiInfo, String str3, String str4, int i) {
        this.driveNoticeType = str;
        this.aoiDetail = arrayList;
        this.tabList = arrayList2;
        this.driveNoticeTag = str2;
        this.poiInfo = wsAosDestinationSearchDataPoiInfo;
        this.driveNotice = str3;
        this.title = str4;
        this.resultType = i;
    }
}
