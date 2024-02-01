package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsChargeListRequestParam extends BLRequestBase implements Serializable {
    public double mass = 0.0d;
    public String channel = "";
    public int costModelSwitch = 0;
    public int radius = 0;
    public double lat = 0.0d;
    public double lon = 0.0d;
    public int num = 0;
    public double chargePercent = 0.0d;
    public double chargeLeft = 0.0d;
    public double chargeReserve = 0.0d;
    public double charge_max = 0.0d;
    public int type = 0;
    public int size = 2;
    public double height = 0.0d;
    public double width = 0.0d;
    public double weight = 0.0d;
    public double load = 0.0d;
    public int topSpeed = 0;
    public String speedCost = "";
    public double transAccess = 0.0d;
    public double transDecess = 0.0d;
    public double curveAccess = 0.0d;
    public double curveDecess = 0.0d;
    public double slopeUp = 0.0d;
    public double slopeDown = 0.0d;
    public double aux = 0.0d;
    public double ferryRate = 0.0d;
    public String powerTrainLoss = "";
    public int page = 0;
    public int pageNum = 0;
    public String speed = "10";

    public GWsChargeListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_CUSTOM1_CHARGE_LIST;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
