package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderDataItemInfo implements Serializable {
    public int buy_limit;
    public String cp_name;
    public String item_name;
    public String item_pic;
    public int price_dis;
    public int price_ori;
    public int price_red;
    public int price_sal;
    public int price_total_dis;
    public WsSearchPoiAutoCmallFillOrderPromotionInfo promotion_info;
    public ArrayList<String> service_desc;
    public String shop_name;
    public String sku_id;
    public int sub_error_code;
    public String sub_error_msg;

    public WsSearchPoiAutoCmallFillOrderDataItemInfo() {
        this.cp_name = "";
        this.sku_id = "";
        this.item_name = "";
        this.shop_name = "";
        this.item_pic = "";
        this.price_ori = 0;
        this.buy_limit = -1;
        this.price_sal = 0;
        this.price_red = 0;
        this.price_dis = 0;
        this.price_total_dis = 0;
        this.service_desc = new ArrayList<>();
        this.promotion_info = new WsSearchPoiAutoCmallFillOrderPromotionInfo();
        this.sub_error_code = 0;
        this.sub_error_msg = "";
    }

    public WsSearchPoiAutoCmallFillOrderDataItemInfo(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5, int i6, ArrayList<String> arrayList, WsSearchPoiAutoCmallFillOrderPromotionInfo wsSearchPoiAutoCmallFillOrderPromotionInfo, int i7, String str6) {
        this.cp_name = str;
        this.sku_id = str2;
        this.item_name = str3;
        this.shop_name = str4;
        this.item_pic = str5;
        this.price_ori = i;
        this.buy_limit = i2;
        this.price_sal = i3;
        this.price_red = i4;
        this.price_dis = i5;
        this.price_total_dis = i6;
        this.service_desc = arrayList;
        this.promotion_info = wsSearchPoiAutoCmallFillOrderPromotionInfo;
        this.sub_error_code = i7;
        this.sub_error_msg = str6;
    }
}
