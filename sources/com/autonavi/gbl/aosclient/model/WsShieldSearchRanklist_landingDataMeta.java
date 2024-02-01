package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingDataMeta implements Serializable {
    public String choose_rule;
    public WsShieldSearchRanklist_landingCitySelector city_selector;
    public int current_page;
    public String jump_map_url;
    public WsShieldSearchRanklist_landingMetaLog log;
    public int more_page;
    public int poi_tpl_style;
    public String selection_changed;
    public WsShieldSearchRanklist_landingMetaShare share;
    public String tail_text;
    public WsShieldSearchRanklist_landingMetaTheme theme;
    public WsShieldSearchRanklist_landingMetaToast toast;
    public String update_time;

    public WsShieldSearchRanklist_landingDataMeta() {
        this.share = new WsShieldSearchRanklist_landingMetaShare();
        this.tail_text = "";
        this.poi_tpl_style = 0;
        this.city_selector = new WsShieldSearchRanklist_landingCitySelector();
        this.choose_rule = "";
        this.log = new WsShieldSearchRanklist_landingMetaLog();
        this.toast = new WsShieldSearchRanklist_landingMetaToast();
        this.selection_changed = "";
        this.more_page = 0;
        this.current_page = 0;
        this.theme = new WsShieldSearchRanklist_landingMetaTheme();
        this.jump_map_url = "";
        this.update_time = "";
    }

    public WsShieldSearchRanklist_landingDataMeta(WsShieldSearchRanklist_landingMetaShare wsShieldSearchRanklist_landingMetaShare, String str, int i, WsShieldSearchRanklist_landingCitySelector wsShieldSearchRanklist_landingCitySelector, String str2, WsShieldSearchRanklist_landingMetaLog wsShieldSearchRanklist_landingMetaLog, WsShieldSearchRanklist_landingMetaToast wsShieldSearchRanklist_landingMetaToast, String str3, int i2, int i3, WsShieldSearchRanklist_landingMetaTheme wsShieldSearchRanklist_landingMetaTheme, String str4, String str5) {
        this.share = wsShieldSearchRanklist_landingMetaShare;
        this.tail_text = str;
        this.poi_tpl_style = i;
        this.city_selector = wsShieldSearchRanklist_landingCitySelector;
        this.choose_rule = str2;
        this.log = wsShieldSearchRanklist_landingMetaLog;
        this.toast = wsShieldSearchRanklist_landingMetaToast;
        this.selection_changed = str3;
        this.more_page = i2;
        this.current_page = i3;
        this.theme = wsShieldSearchRanklist_landingMetaTheme;
        this.jump_map_url = str4;
        this.update_time = str5;
    }
}
