package com.autonavi.gbl.aosclient.model;

import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiPoiVoicesearchRequestParam extends BLRequestBase implements Serializable {
    public GCoord2DDouble user_loc = new GCoord2DDouble();
    public boolean citysuggestion = true;
    public int search_operate = -1;
    public String version = "";
    public String input_method = "";
    public boolean driving = false;
    public String original_keywords = "";
    public String siv = "";
    public String query_type = KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD;
    public String data_type = "";
    public String city = "";
    public String keywords = "";
    public String category = "";
    public String src_type = "";
    public String scene_id = "";
    public String brand_id = "";
    public int sort_rule = -1;
    public int pagesize = -1;
    public int pagenum = -1;
    public boolean qii = true;
    public boolean is_classify = false;
    public String classify_data = "";
    public boolean query_acs = false;
    public boolean addr_poi_merge = false;
    public int with_deepinfo = -1;
    public int client_network_class = -1;
    public boolean need_locate = true;
    public boolean need_navidata = true;

    public GWsMapapiPoiVoicesearchRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WSMAPAPIPOIVOICESEARCH;
    }
}
