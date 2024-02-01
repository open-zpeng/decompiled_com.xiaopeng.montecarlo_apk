package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CloudShowInfo implements Serializable {
    public ArrayList<AvoidJamCloudControl> vecAvoidJamCloudControl;
    public ArrayList<AvoidJamDetail> vecAvoidJamDetail;
    public ArrayList<BankingHoursCloudControl> vecBankingHoursCloudControl;
    public ArrayList<DetailCloudControl> vecDetailCloudControl;
    public ArrayList<EventCloudControl> vecEventCloudControl;
    public ArrayList<EventDetail> vecEventDetail;
    public ArrayList<ForbiddenCloudControl> vecForbiddenCloudControl;
    public ArrayList<ForbiddenDetail> vecForbiddenDetail;
    public ArrayList<HolidayCloudControl> vecHolidayCloudControl;
    public ArrayList<LineDetail> vecLineDetail;
    public ArrayList<PointDetail> vecPointDetail;
    public ArrayList<RestrictCloudControl> vecRestrictCloudControl;
    public ArrayList<TipsCloudControl> vecTipsCloudControl;

    public CloudShowInfo() {
        this.vecTipsCloudControl = new ArrayList<>();
        this.vecDetailCloudControl = new ArrayList<>();
        this.vecPointDetail = new ArrayList<>();
        this.vecLineDetail = new ArrayList<>();
        this.vecEventDetail = new ArrayList<>();
        this.vecAvoidJamDetail = new ArrayList<>();
        this.vecForbiddenDetail = new ArrayList<>();
        this.vecRestrictCloudControl = new ArrayList<>();
        this.vecEventCloudControl = new ArrayList<>();
        this.vecAvoidJamCloudControl = new ArrayList<>();
        this.vecForbiddenCloudControl = new ArrayList<>();
        this.vecHolidayCloudControl = new ArrayList<>();
        this.vecBankingHoursCloudControl = new ArrayList<>();
    }

    public CloudShowInfo(ArrayList<TipsCloudControl> arrayList, ArrayList<DetailCloudControl> arrayList2, ArrayList<PointDetail> arrayList3, ArrayList<LineDetail> arrayList4, ArrayList<EventDetail> arrayList5, ArrayList<AvoidJamDetail> arrayList6, ArrayList<ForbiddenDetail> arrayList7, ArrayList<RestrictCloudControl> arrayList8, ArrayList<EventCloudControl> arrayList9, ArrayList<AvoidJamCloudControl> arrayList10, ArrayList<ForbiddenCloudControl> arrayList11, ArrayList<HolidayCloudControl> arrayList12, ArrayList<BankingHoursCloudControl> arrayList13) {
        this.vecTipsCloudControl = arrayList;
        this.vecDetailCloudControl = arrayList2;
        this.vecPointDetail = arrayList3;
        this.vecLineDetail = arrayList4;
        this.vecEventDetail = arrayList5;
        this.vecAvoidJamDetail = arrayList6;
        this.vecForbiddenDetail = arrayList7;
        this.vecRestrictCloudControl = arrayList8;
        this.vecEventCloudControl = arrayList9;
        this.vecAvoidJamCloudControl = arrayList10;
        this.vecForbiddenCloudControl = arrayList11;
        this.vecHolidayCloudControl = arrayList12;
        this.vecBankingHoursCloudControl = arrayList13;
    }
}
