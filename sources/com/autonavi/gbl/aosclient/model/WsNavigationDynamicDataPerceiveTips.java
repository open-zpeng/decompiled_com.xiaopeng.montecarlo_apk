package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataPerceiveTips implements Serializable {
    public WsNavigationDynamicDataRespActionClass action;
    public WsNavigationDynamicDataRespDetail detail;
    public long dynamic_id_s;
    public int id;
    public ArrayList<WsNavigationDynamicDataRespOverlayItem> overlay;
    public ArrayList<Integer> pathIds;
    public String tag;
    public WsNavigationDynamicDataRespTip tips;
    public int tipsType;
    public int weight;

    public WsNavigationDynamicDataPerceiveTips() {
        this.id = 0;
        this.dynamic_id_s = 0L;
        this.pathIds = new ArrayList<>();
        this.tag = "";
        this.tips = new WsNavigationDynamicDataRespTip();
        this.detail = new WsNavigationDynamicDataRespDetail();
        this.overlay = new ArrayList<>();
        this.action = new WsNavigationDynamicDataRespActionClass();
        this.tipsType = 0;
        this.weight = 0;
    }

    public WsNavigationDynamicDataPerceiveTips(int i, long j, ArrayList<Integer> arrayList, String str, WsNavigationDynamicDataRespTip wsNavigationDynamicDataRespTip, WsNavigationDynamicDataRespDetail wsNavigationDynamicDataRespDetail, ArrayList<WsNavigationDynamicDataRespOverlayItem> arrayList2, WsNavigationDynamicDataRespActionClass wsNavigationDynamicDataRespActionClass, int i2, int i3) {
        this.id = i;
        this.dynamic_id_s = j;
        this.pathIds = arrayList;
        this.tag = str;
        this.tips = wsNavigationDynamicDataRespTip;
        this.detail = wsNavigationDynamicDataRespDetail;
        this.overlay = arrayList2;
        this.action = wsNavigationDynamicDataRespActionClass;
        this.tipsType = i2;
        this.weight = i3;
    }
}
