package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAuthcarServicelistDataService implements Serializable {
    public String charge_name;
    public int charge_type;
    public ArrayList<WsAuthcarServicelistDataServiceInterface> interfaces;
    public String name;
    public String name_en;
    public String name_tr;
    public String remind;
    public String remind2;
    public String remind2_en;
    public String remind2_tr;
    public String remind_en;
    public String remind_tr;
    public String sid;

    public WsAuthcarServicelistDataService() {
        this.name = "";
        this.name_en = "";
        this.name_tr = "";
        this.sid = "";
        this.charge_type = 0;
        this.charge_name = "";
        this.remind = "";
        this.remind_en = "";
        this.remind_tr = "";
        this.remind2 = "";
        this.remind2_en = "";
        this.remind2_tr = "";
        this.interfaces = new ArrayList<>();
    }

    public WsAuthcarServicelistDataService(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ArrayList<WsAuthcarServicelistDataServiceInterface> arrayList) {
        this.name = str;
        this.name_en = str2;
        this.name_tr = str3;
        this.sid = str4;
        this.charge_type = i;
        this.charge_name = str5;
        this.remind = str6;
        this.remind_en = str7;
        this.remind_tr = str8;
        this.remind2 = str9;
        this.remind2_en = str10;
        this.remind2_tr = str11;
        this.interfaces = arrayList;
    }
}
