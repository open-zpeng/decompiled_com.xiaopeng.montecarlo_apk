package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalDataData implements Serializable {
    public WsShieldSearchRanklistPortalDataBookIcon book_icon;
    public String brief_comment;
    public String business_area;
    public String business_type;
    public String distance;
    public int hot_icon;
    public String hot_rise_number;
    public String lat;
    public String list_hot_back_color;
    public double list_hot_number;
    public String list_hot_suffix;
    public String list_hot_text;
    public String list_hot_text_color;
    public String lon;
    public String name;
    public String outstandingReason;
    public String pic_info;
    public String poiid;
    public int position_rise;
    public String price;
    public int rank_num;
    public String rank_num_bg;
    public String rank_num_text_color;
    public String rating;
    public String rating_color;
    public String rec_reason;
    public String recommendReason;
    public String schema;
    public int show_collect;
    public String type_tag;
    public String typecode;

    public WsShieldSearchRanklistPortalDataData() {
        this.show_collect = 0;
        this.name = "";
        this.pic_info = "";
        this.poiid = "";
        this.typecode = "";
        this.schema = "";
        this.rank_num = 0;
        this.rank_num_bg = "";
        this.rank_num_text_color = "";
        this.business_area = "";
        this.type_tag = "";
        this.list_hot_number = 0.0d;
        this.list_hot_text = "";
        this.list_hot_suffix = "";
        this.list_hot_text_color = "";
        this.list_hot_back_color = "";
        this.position_rise = 0;
        this.lon = "";
        this.lat = "";
        this.hot_icon = 0;
        this.business_type = "";
        this.hot_rise_number = "";
        this.distance = "";
        this.rec_reason = "";
        this.book_icon = new WsShieldSearchRanklistPortalDataBookIcon();
        this.rating = "";
        this.rating_color = "";
        this.brief_comment = "";
        this.price = "";
        this.recommendReason = "";
        this.outstandingReason = "";
    }

    public WsShieldSearchRanklistPortalDataData(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8, String str9, double d, String str10, String str11, String str12, String str13, int i3, String str14, String str15, int i4, String str16, String str17, String str18, String str19, WsShieldSearchRanklistPortalDataBookIcon wsShieldSearchRanklistPortalDataBookIcon, String str20, String str21, String str22, String str23, String str24, String str25) {
        this.show_collect = i;
        this.name = str;
        this.pic_info = str2;
        this.poiid = str3;
        this.typecode = str4;
        this.schema = str5;
        this.rank_num = i2;
        this.rank_num_bg = str6;
        this.rank_num_text_color = str7;
        this.business_area = str8;
        this.type_tag = str9;
        this.list_hot_number = d;
        this.list_hot_text = str10;
        this.list_hot_suffix = str11;
        this.list_hot_text_color = str12;
        this.list_hot_back_color = str13;
        this.position_rise = i3;
        this.lon = str14;
        this.lat = str15;
        this.hot_icon = i4;
        this.business_type = str16;
        this.hot_rise_number = str17;
        this.distance = str18;
        this.rec_reason = str19;
        this.book_icon = wsShieldSearchRanklistPortalDataBookIcon;
        this.rating = str20;
        this.rating_color = str21;
        this.brief_comment = str22;
        this.price = str23;
        this.recommendReason = str24;
        this.outstandingReason = str25;
    }
}
