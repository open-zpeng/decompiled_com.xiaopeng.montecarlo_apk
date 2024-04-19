package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalModuleHeader implements Serializable {
    public String background;
    public String backgroundColor;
    public WsShieldSearchRanklistPortalCurrentCity current_city;
    public WsShieldSearchRanklistPortalHeaderIcon icon;
    public int show_city_selector;
    public String title_icon;
    public WsShieldSearchRanklistPortalTitleIconSize title_icon_size;
    public WsShieldSearchRanklistPortalUnionEntrance union_entrance;

    public WsShieldSearchRanklistPortalModuleHeader() {
        this.show_city_selector = 0;
        this.current_city = new WsShieldSearchRanklistPortalCurrentCity();
        this.title_icon = "";
        this.title_icon_size = new WsShieldSearchRanklistPortalTitleIconSize();
        this.union_entrance = new WsShieldSearchRanklistPortalUnionEntrance();
        this.backgroundColor = "";
        this.background = "";
        this.icon = new WsShieldSearchRanklistPortalHeaderIcon();
    }

    public WsShieldSearchRanklistPortalModuleHeader(int i, WsShieldSearchRanklistPortalCurrentCity wsShieldSearchRanklistPortalCurrentCity, String str, WsShieldSearchRanklistPortalTitleIconSize wsShieldSearchRanklistPortalTitleIconSize, WsShieldSearchRanklistPortalUnionEntrance wsShieldSearchRanklistPortalUnionEntrance, String str2, String str3, WsShieldSearchRanklistPortalHeaderIcon wsShieldSearchRanklistPortalHeaderIcon) {
        this.show_city_selector = i;
        this.current_city = wsShieldSearchRanklistPortalCurrentCity;
        this.title_icon = str;
        this.title_icon_size = wsShieldSearchRanklistPortalTitleIconSize;
        this.union_entrance = wsShieldSearchRanklistPortalUnionEntrance;
        this.backgroundColor = str2;
        this.background = str3;
        this.icon = wsShieldSearchRanklistPortalHeaderIcon;
    }
}
