package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalDataMeta implements Serializable {
    public String choose_rule;
    public WsShieldSearchRanklistPortalCitySelector city_selector;
    public int current_page;
    public String jump_map_url;
    public WsShieldSearchRanklistPortalMetaLog log;
    public int more_page;
    public int poi_tpl_style;
    public String selection_changed;
    public WsShieldSearchRanklistPortalMetaShare share;
    public String tail_text;
    public WsShieldSearchRanklistPortalMetaTheme theme;
    public WsShieldSearchRanklistPortalMetaToast toast;
    public String update_time;

    public WsShieldSearchRanklistPortalDataMeta() {
        this.share = new WsShieldSearchRanklistPortalMetaShare();
        this.tail_text = "";
        this.poi_tpl_style = 0;
        this.city_selector = new WsShieldSearchRanklistPortalCitySelector();
        this.choose_rule = "";
        this.log = new WsShieldSearchRanklistPortalMetaLog();
        this.toast = new WsShieldSearchRanklistPortalMetaToast();
        this.selection_changed = "";
        this.more_page = 0;
        this.current_page = 0;
        this.theme = new WsShieldSearchRanklistPortalMetaTheme();
        this.jump_map_url = "";
        this.update_time = "";
    }

    public WsShieldSearchRanklistPortalDataMeta(WsShieldSearchRanklistPortalMetaShare wsShieldSearchRanklistPortalMetaShare, String str, int i, WsShieldSearchRanklistPortalCitySelector wsShieldSearchRanklistPortalCitySelector, String str2, WsShieldSearchRanklistPortalMetaLog wsShieldSearchRanklistPortalMetaLog, WsShieldSearchRanklistPortalMetaToast wsShieldSearchRanklistPortalMetaToast, String str3, int i2, int i3, WsShieldSearchRanklistPortalMetaTheme wsShieldSearchRanklistPortalMetaTheme, String str4, String str5) {
        this.share = wsShieldSearchRanklistPortalMetaShare;
        this.tail_text = str;
        this.poi_tpl_style = i;
        this.city_selector = wsShieldSearchRanklistPortalCitySelector;
        this.choose_rule = str2;
        this.log = wsShieldSearchRanklistPortalMetaLog;
        this.toast = wsShieldSearchRanklistPortalMetaToast;
        this.selection_changed = str3;
        this.more_page = i2;
        this.current_page = i3;
        this.theme = wsShieldSearchRanklistPortalMetaTheme;
        this.jump_map_url = str4;
        this.update_time = str5;
    }
}
