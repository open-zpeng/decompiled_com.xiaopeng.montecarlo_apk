package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.RectFloat;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchLQii implements Serializable {
    public SearchCacheDirective cache_directive;
    public int call_taxi;
    public int car_icon_flag;
    public String change_query_tip;
    public int change_query_type;
    public SearchClassifyRange classify_range;
    public String expand_range_tip;
    public int has_recommend;
    public int is_current_city;
    public int is_tupu_sug;
    public int is_view_city;
    public String no_result_suggest;
    public int preload_next_page;
    public int querytype;
    public int render_name_flag;
    public int self_navigation;
    public String show_pic;
    public int slayer;
    public String slayer_type;
    public int specialclassify;
    public SearchQllSuggestQuery suggest_query;
    public String suggestcontent;
    public int suggestionview;
    public SearchQllSuggestContent suggesttips;
    public String target_view_city;
    public SearchQllTeseCal tesecai;
    public int utd_sceneid;
    public RectFloat view_region;

    public SearchLQii() {
        this.querytype = -1;
        this.suggestionview = -1;
        this.utd_sceneid = -1;
        this.car_icon_flag = -1;
        this.is_current_city = -1;
        this.slayer = -1;
        this.target_view_city = "";
        this.call_taxi = -1;
        this.preload_next_page = -1;
        this.slayer_type = "";
        this.specialclassify = -1;
        this.is_view_city = -1;
        this.render_name_flag = -1;
        this.is_tupu_sug = -1;
        this.has_recommend = -1;
        this.classify_range = new SearchClassifyRange();
        this.cache_directive = new SearchCacheDirective();
        this.suggest_query = new SearchQllSuggestQuery();
        this.self_navigation = -1;
        this.no_result_suggest = "";
        this.view_region = new RectFloat();
        this.expand_range_tip = "";
        this.change_query_tip = "";
        this.change_query_type = -1;
        this.show_pic = "";
        this.tesecai = new SearchQllTeseCal();
        this.suggesttips = new SearchQllSuggestContent();
        this.suggestcontent = "";
    }

    public SearchLQii(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7, int i8, String str2, int i9, int i10, int i11, int i12, int i13, SearchClassifyRange searchClassifyRange, SearchCacheDirective searchCacheDirective, SearchQllSuggestQuery searchQllSuggestQuery, int i14, String str3, RectFloat rectFloat, String str4, String str5, int i15, String str6, SearchQllTeseCal searchQllTeseCal, SearchQllSuggestContent searchQllSuggestContent, String str7) {
        this.querytype = i;
        this.suggestionview = i2;
        this.utd_sceneid = i3;
        this.car_icon_flag = i4;
        this.is_current_city = i5;
        this.slayer = i6;
        this.target_view_city = str;
        this.call_taxi = i7;
        this.preload_next_page = i8;
        this.slayer_type = str2;
        this.specialclassify = i9;
        this.is_view_city = i10;
        this.render_name_flag = i11;
        this.is_tupu_sug = i12;
        this.has_recommend = i13;
        this.classify_range = searchClassifyRange;
        this.cache_directive = searchCacheDirective;
        this.suggest_query = searchQllSuggestQuery;
        this.self_navigation = i14;
        this.no_result_suggest = str3;
        this.view_region = rectFloat;
        this.expand_range_tip = str4;
        this.change_query_tip = str5;
        this.change_query_type = i15;
        this.show_pic = str6;
        this.tesecai = searchQllTeseCal;
        this.suggesttips = searchQllSuggestContent;
        this.suggestcontent = str7;
    }
}
