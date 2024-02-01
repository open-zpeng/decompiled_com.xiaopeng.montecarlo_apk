package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAosDestinationSearchTabListDataList implements Serializable {
    public String aoiId;
    public String childType;
    public String fullName;
    public String groupId;
    public String index;
    public ArrayList<WsAosDestinationSearchDataListLabelList> labelList;
    public String name;
    public String parentPoiId;
    public String poiId;
    public String purpose;
    public ArrayList<WsAosDestinationSearchDataListTagList> tagList;
    public String templateId;
    public String typeCode;
    public String x;
    public String y;

    public WsAosDestinationSearchTabListDataList() {
        this.childType = "";
        this.purpose = "";
        this.groupId = "";
        this.index = "";
        this.fullName = "";
        this.templateId = "";
        this.typeCode = "";
        this.tagList = new ArrayList<>();
        this.labelList = new ArrayList<>();
        this.parentPoiId = "";
        this.name = "";
        this.x = "";
        this.y = "";
        this.poiId = "";
        this.aoiId = "";
    }

    public WsAosDestinationSearchTabListDataList(String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList<WsAosDestinationSearchDataListTagList> arrayList, ArrayList<WsAosDestinationSearchDataListLabelList> arrayList2, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.childType = str;
        this.purpose = str2;
        this.groupId = str3;
        this.index = str4;
        this.fullName = str5;
        this.templateId = str6;
        this.typeCode = str7;
        this.tagList = arrayList;
        this.labelList = arrayList2;
        this.parentPoiId = str8;
        this.name = str9;
        this.x = str10;
        this.y = str11;
        this.poiId = str12;
        this.aoiId = str13;
    }
}
