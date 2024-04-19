package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingModuleHeader implements Serializable {
    public String background;
    public String backgroundColor;
    public WsShieldSearchRanklist_landingCurrentCity current_city;
    public WsShieldSearchRanklist_landingHeaderIcon icon;
    public int show_city_selector;
    public String title_icon;
    public WsShieldSearchRanklist_landingTitleIconSize title_icon_size;
    public WsShieldSearchRanklist_landingUnionEntrance union_entrance;

    public WsShieldSearchRanklist_landingModuleHeader() {
        this.show_city_selector = 0;
        this.current_city = new WsShieldSearchRanklist_landingCurrentCity();
        this.title_icon = "";
        this.title_icon_size = new WsShieldSearchRanklist_landingTitleIconSize();
        this.union_entrance = new WsShieldSearchRanklist_landingUnionEntrance();
        this.backgroundColor = "";
        this.background = "";
        this.icon = new WsShieldSearchRanklist_landingHeaderIcon();
    }

    public WsShieldSearchRanklist_landingModuleHeader(int i, WsShieldSearchRanklist_landingCurrentCity wsShieldSearchRanklist_landingCurrentCity, String str, WsShieldSearchRanklist_landingTitleIconSize wsShieldSearchRanklist_landingTitleIconSize, WsShieldSearchRanklist_landingUnionEntrance wsShieldSearchRanklist_landingUnionEntrance, String str2, String str3, WsShieldSearchRanklist_landingHeaderIcon wsShieldSearchRanklist_landingHeaderIcon) {
        this.show_city_selector = i;
        this.current_city = wsShieldSearchRanklist_landingCurrentCity;
        this.title_icon = str;
        this.title_icon_size = wsShieldSearchRanklist_landingTitleIconSize;
        this.union_entrance = wsShieldSearchRanklist_landingUnionEntrance;
        this.backgroundColor = str2;
        this.background = str3;
        this.icon = wsShieldSearchRanklist_landingHeaderIcon;
    }
}
