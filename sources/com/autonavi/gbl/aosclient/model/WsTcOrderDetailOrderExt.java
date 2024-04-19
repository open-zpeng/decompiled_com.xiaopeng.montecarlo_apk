package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTcOrderDetailOrderExt implements Serializable {
    public WsTcOrderDetailFailReason failReason;
    public String feeDesc;
    public ArrayList<String> feedbackTipsList;
    public WsTcOrderDetailGoodsExt goodsExt;
    public String goodsId;
    public String goodsName;
    public String playTime;
    public String poiId;
    public String poiName;
    public int ticketSeason;
    public ArrayList<WsTcOrderDetailUserInfoItem> userInfo;

    public WsTcOrderDetailOrderExt() {
        this.goodsId = "";
        this.goodsName = "";
        this.poiId = "";
        this.poiName = "";
        this.playTime = "";
        this.ticketSeason = 0;
        this.feeDesc = "";
        this.failReason = new WsTcOrderDetailFailReason();
        this.feedbackTipsList = new ArrayList<>();
        this.goodsExt = new WsTcOrderDetailGoodsExt();
        this.userInfo = new ArrayList<>();
    }

    public WsTcOrderDetailOrderExt(String str, String str2, String str3, String str4, String str5, int i, String str6, WsTcOrderDetailFailReason wsTcOrderDetailFailReason, ArrayList<String> arrayList, WsTcOrderDetailGoodsExt wsTcOrderDetailGoodsExt, ArrayList<WsTcOrderDetailUserInfoItem> arrayList2) {
        this.goodsId = str;
        this.goodsName = str2;
        this.poiId = str3;
        this.poiName = str4;
        this.playTime = str5;
        this.ticketSeason = i;
        this.feeDesc = str6;
        this.failReason = wsTcOrderDetailFailReason;
        this.feedbackTipsList = arrayList;
        this.goodsExt = wsTcOrderDetailGoodsExt;
        this.userInfo = arrayList2;
    }
}
