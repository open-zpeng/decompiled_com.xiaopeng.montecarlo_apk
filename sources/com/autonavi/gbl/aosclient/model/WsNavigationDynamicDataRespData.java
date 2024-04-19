package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespData implements Serializable {
    public WsNavigationDynamicDataRespAction action;
    public String backupHighlightedImg;
    public String backupNormalImgackup;
    public String borderColor;
    public int collisionGroupId;
    public String color;
    public String highlightedImg;
    public boolean isCollision;
    public boolean isDodgeRoute;
    public boolean isPoiFilter;
    public int itemPriority;
    public String latitude;
    public int lay;
    public String longitude;
    public int mainPriority;
    public int maxLevel;
    public int minLevel;
    public String normalImg;
    public ArrayList<WsNavigationDynamicDataRespPoint> points;
    public int subPriority;

    public WsNavigationDynamicDataRespData() {
        this.points = new ArrayList<>();
        this.color = "";
        this.borderColor = "";
        this.longitude = "";
        this.latitude = "";
        this.normalImg = "";
        this.highlightedImg = "";
        this.backupNormalImgackup = "";
        this.backupHighlightedImg = "";
        this.collisionGroupId = 0;
        this.mainPriority = 0;
        this.subPriority = 0;
        this.maxLevel = 0;
        this.minLevel = 0;
        this.lay = 0;
        this.itemPriority = 0;
        this.isDodgeRoute = false;
        this.isCollision = false;
        this.isPoiFilter = false;
        this.action = new WsNavigationDynamicDataRespAction();
    }

    public WsNavigationDynamicDataRespData(ArrayList<WsNavigationDynamicDataRespPoint> arrayList, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3, WsNavigationDynamicDataRespAction wsNavigationDynamicDataRespAction) {
        this.points = arrayList;
        this.color = str;
        this.borderColor = str2;
        this.longitude = str3;
        this.latitude = str4;
        this.normalImg = str5;
        this.highlightedImg = str6;
        this.backupNormalImgackup = str7;
        this.backupHighlightedImg = str8;
        this.collisionGroupId = i;
        this.mainPriority = i2;
        this.subPriority = i3;
        this.maxLevel = i4;
        this.minLevel = i5;
        this.lay = i6;
        this.itemPriority = i7;
        this.isDodgeRoute = z;
        this.isCollision = z2;
        this.isPoiFilter = z3;
        this.action = wsNavigationDynamicDataRespAction;
    }
}
