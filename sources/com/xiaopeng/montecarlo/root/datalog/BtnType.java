package com.xiaopeng.montecarlo.root.datalog;
/* loaded from: classes3.dex */
public enum BtnType {
    EXPOSURE("B0102", 0, new int[]{6}),
    GOTOBACKGROUND("B0103", 0, new int[]{6}),
    GOTOFOREGROUND("B0104", 0, new int[]{6}),
    EXIT("B0105", 0, new int[]{6}),
    ONCLICKMAPMODE("B0106", 0, new int[]{2, 3, 4, 5}),
    ONCLICKZOOMOUT("B0107", 1, new int[]{2, 3, 4, 5}),
    ONCLICKZOOMIN("B0108", 1, new int[]{2, 3, 4, 5}),
    ONCLICKMAPRECENTER("B0109", 1, new int[]{2, 3, 4, 5}),
    ONCLICKOVERVIEW("B0110", 2, new int[]{2, 3, 4, 5}),
    TOUCHDOWN("B0111", 2, new int[]{1, 2, 3, 4, 5}),
    TOUCHUP("B0112", 2, new int[]{1, 2, 3, 4, 5}),
    CLICK("B0113", 2, new int[]{7, 8, 9}),
    DOWNLOAD_AUTO_SWITCH("B0037", 1, new int[]{6}),
    DOWNLOAD_VIEW_RESUME("B0038", 1),
    DOWNLOAD_START("B0039", 1, new int[]{32, 34, 35}),
    DOWNLOAD_FINISH("B0040", 1, new int[]{33, 34, 35, 6}),
    VOLUME_BUTTON("B0041", 0, new int[]{6}),
    VOLUME_SYSTEM("B0042", 0, new int[]{6}),
    VOLUME_RESTORE_BY_POWERON("B0062", 0, new int[]{6}),
    VOLUME_SHOW_PANEL_BUTTON("B0055", 2, new int[]{6}),
    VOLUME_LONG_PRESSED("B0065", 0, new int[]{6}),
    RESTORE_BY_POWER_ON("B0066", 0, new int[]{41}),
    RESTORE_BY_POWER_OFF("B0067", 0, new int[]{6, 21, 41}),
    VOLUME_SET_BY_USER("B0067", 0),
    VOLUME_SET_BY_SYSTEM("B0067", 0),
    ROAD_CHANGE_BUTTON("B0101", 2),
    POI_CARD_SHOW("B0513", 1, new int[]{15, 16, 17, 27}),
    POI_CARD_DISMISS("B0514", 1),
    POI_CARD_START_NAVI_BUTTON("B0515", 0),
    POI_CARD_ADD_WAYPOINT_BUTTON("B0516", 0),
    POI_CARD_DELETE_WAYPOINT_BUTTON("B0517", 0),
    POI_CARD_SUB_POI_BUTTON("B0518", 1),
    POI_CARD_FAVORITE_BUTTON("B0519", 1),
    POI_CARD_SEARCH_BUTTON("B0520", 0),
    POI_CARD_ACTION_GESTURE("B0521", 2, new int[]{6}),
    POI_CARD_SETTING_HOME_BUTTON("B0522", 0),
    POI_CARD_SETTING_COMPANY_BUTTON("B0523", 0),
    POI_CARD_SELECT_CHARGE_SPOT_BUTTON("B0525", 1),
    POI_CARD_DEAIL_WITH_BT_BUTTON("B0526", 1),
    POI_CARD_SHOW_PICTURE_BUTTON("B0527", 1),
    SEARCH_RESULT_REMOVE_VIA("B0528", 1, new int[]{25}),
    COMMUTING_FORECAST_HOME_SHOW("B0601", 0),
    COMMUTING_FORECAST_HOME_NAVI("B0602", 0),
    COMMUTING_FORECAST_HOME_EXPLORE("B0603", 0),
    COMMUTING_FORECAST_COMPANY_SHOW("B0604", 0),
    COMMUTING_FORECAST_COMPANY_NAVI("B0605", 0),
    COMMUTING_FORECAST_COMPANY_EXPLORE("B0606", 0),
    RECOMMEND_PARK_SHOW("B0312", 0),
    RECOMMEND_PARK_COLLAPSE("B0313", 0),
    RECOMMEND_PARK_EXPAND("B0314", 0),
    RECOMMEND_PARK_HIDE("B0315", 0),
    RECOMMEND_PARK_P1("B0316", 2, new int[]{16, 17}),
    RECOMMEND_PARK_P2("B0317", 2, new int[]{16, 17}),
    RECOMMEND_PARK_P3("B0318", 2, new int[]{16, 17}),
    RECOMMEND_PARK_SELECTED("B0319", 1, new int[]{26}),
    GUIDE_PANEL_SHOW("B0320", 0),
    GUIDE_DEVIATION("B0321", 0, new int[]{11, 12, 13, 14, 19, 21}),
    GUIDE_OPTIONAL_ROUTE("B0322", 0, new int[]{11, 12, 13, 14, 19, 21, 28}),
    GUIDE_REROUTE("B0323", 0, new int[]{15, 16, 17, 19, 21, 42}),
    GUIDE_CONTINUE_NAVI("B0324", 0, new int[]{2, 3}),
    ROUTE_BTN_CLICK_EXIT("B0201", 0, new int[]{19, 21, 29}),
    ROUTE_EXIT("B0202", 0, new int[]{19, 21, 28, 29}),
    ROUTE_START("B0203", 0, new int[]{6, 10, 15, 16, 17, 18, 19, 21, 28, 29, 42}),
    ROUTE_PANEL1_SHOW("B0204", 1, new int[]{36, 11, 12, 13, 14}),
    ROUTE_PANEL1_SELECTED("B0205", 0),
    ROUTE_PANEL2_SHOW("B0207", 1, new int[]{36, 11, 12, 13, 14}),
    ROUTE_PANEL2_SELECTED("B0208", 0),
    ROUTE_PANEL3_SHOW("B0210", 1, new int[]{36, 11, 12, 13, 14}),
    ROUTE_PANEL3_SELECTED("B0211", 0),
    ROUTE_PANEL3_NAVI_START("B0212", 0),
    ROUTE_BTN_START_NAVI("B0217", 0, new int[]{29}),
    ROUTE_BTN_START_EXPLORE("B0218", 0, new int[]{29}),
    ROUTE_MSG_START_EXPLORE("B0219", 0, new int[]{29}),
    ROUTE_OFFLINEVIEW_SHOW("B0220", 0, new int[]{19, 32}),
    ROUTE_OFFLINEVIEW_CLICK("B0221", 0, new int[]{19, 32}),
    ROUTE_START_NAVI_COUNT_DOWN("B0222", 0, new int[]{6, 29, 53}),
    HOME_SUGGEST_DIALOG_SHOW("B0447", 1),
    HOME_SUGGEST_CONFIRM_ADDED("B0448", 1),
    HOME_SUGGEST_CANCEL_ADDED("B0449", 1),
    OFFICE_SUGGEST_DIALOG_SHOW("B0450", 1),
    OFFICE_SUGGEST_CONFIRM_ADDED("B0451", 1),
    OFFICE_SUGGEST_CANCEL_ADDED("B0452", 1),
    ADD_WAYPOINT_WHEN_HOME_SETTING_DIALOG_SHOW("B0453", 1),
    ADD_WAYPOINT_WHEN_HOME_SETTING_DIALOG_ADD("B0454", 1),
    ADD_WAYPOINT_WHEN_HOME_SETTING_DIALOG_START_NAVI("B0455", 1),
    ADD_WAYPOINT_WHEN_OFFICE_SETTING_DIALOG_SHOW("B0456", 1),
    ADD_WAYPOINT_WHEN_OFFICE_SETTING_DIALOG_ADD("B0457", 1),
    ADD_WAYPOINT_WHEN_OFFICE_SETTING_DIALOG_START_NAVI("B0458", 1),
    SEARCH_ENTER_MAIN("B0401", 0),
    SEARCH_ENTER_WAYPOINT("B0402", 0),
    SEARCH_SCREEN_CHARGE("B0403", 0, new int[]{56}),
    SETTING_BTN_ENTER("B0001", 0),
    SETTING_EXPOSURE("B0002", 0),
    SETTING_TO_BACKGROUND("B0003", 0),
    SETTING_TO_FOREGROUND("B0004", 0),
    SETTING_EXIT("B0005", 0),
    SETTING_AVOID_CONGESTION("B0008", 1, new int[]{6, 28, 29}),
    SETTING_BTN_AVOID_FEE("B0009", 1, new int[]{6, 28, 29}),
    SETTING_BTN_AVOID_HIGHWAY("B0010", 1, new int[]{6, 28, 29}),
    SETTING_BTN_HIGHWAY_PRIORITY("B0011", 1, new int[]{6, 28, 29}),
    SETTING_BTN_NAVI_DETAIL_BROADCAST("B0012", 1, new int[]{6, 29}),
    SETTING_BTN_NAVI_NORMAL_BROADCAST("B0068", 1, new int[]{6, 29}),
    SETTING_BTN_NAVI_ULTRA_SIMPLE_BROADCAST("B0013", 1, new int[]{6, 29}),
    SETTING_BTN_CRUISE_AHEAD_TRAFFIC("B0014", 1, new int[]{6, 29}),
    SETTING_BTN_CRUISE_ELECTRONIC_EYE_BROADCAST("B0015", 1, new int[]{6, 29}),
    SETTING_BTN_CRUISE_SAFETY_BROADCAST("B0016", 1, new int[]{6, 29}),
    SETTING_BTN_AVOID_RESTRICTION_ROUTE("B0017", 1, new int[]{6, 29}),
    SETTING_BTN_EDIT_PLATE("B0018", 1, new int[]{6}),
    SETTING_BTN_SAVE_PLATE("B0019", 1, new int[]{6, 30}),
    SETTING_BTN_ROUTE_RADAR("B0020", 1, new int[]{6}),
    SETTING_BTN_CHARGING_STATION_SHOW("B0021", 1, new int[]{6}),
    SETTING_BTN_REAL_TIME_TRAFFIC("B0022", 1, new int[]{6}),
    SETTING_BTN_SCRATCH_SPOT("B0086", 1, new int[]{6}),
    SETTING_BTN_LOGIN_XP_ACCOUNT("B0023", 1),
    SETTING_MSG_LOGIN_XP_ACCOUNT("B0024", 1, new int[]{6}),
    SETTING_MATCH_AMAP_ACCOUNT_QUICK_BINDED("B0027", 1, new int[]{6}),
    SETTING_UNMATCH_AMAP_ACCOUNT_QUICK_BINDED("B0030", 1, new int[]{6}),
    SETTING_BTN_MINIMAP_MAPMODE_2D("B0079", 1),
    SETTING_BTN_MINIMAP_MAPMODE_3D("B0080", 1),
    SETTING_DAILOG_AMAP_QRCODE("B0032", 1),
    SETTING_BTN_DEL_USER_DATA("B0033", 1),
    SETTING_BTN_SECD_COFRIM_DEL_USER_DATA("B0034", 1),
    SETTING_BTN_CANCLE_USER_DATA("B0035", 1),
    SETTING_BTN_ONCLICK_RESET("B0036", 1, new int[]{6}),
    SETTING_BTN_MAP_DYNAMIC_LEVEL("B0053", 1, new int[]{6}),
    SETTING_BTN_RECOMMEND_PARK("B0087", 1, new int[]{6}),
    SETTING_BTN_MAP_THUMBNAIL("B0063", 1),
    SETTING_BTN_MAP_LIGHTCOLUMN("B0064", 1),
    CALL_NAVI_EVENT("B0074", 1, new int[]{15, 16, 17, 21}),
    SETTING_BTN_CUSTOM_CAR_LOGO_ENTER("B0075", 0),
    SETTING_BTN_CUSTOM_CAR_LOGO_CHANGE("B0076", 0, new int[]{45}),
    VOLUME_CHANGE_WITH_USER_OPERATE("B0069", 0, new int[]{6}),
    VOLUME_CHANGE_FOLLOW_SYSTEM("B0070", 0, new int[]{6}),
    VOLUME_REMEMBER_SHOW("B0071", 0),
    NAVI_GUIDER_GIF_ICON_BTN("B0043", 0),
    SETTING_NAVI_GUIDER_ENTER_ICON_BTN("B0044", 0),
    NAVI_GUIDER_BIND_AMAP_TAB_ICON_BTN("B0045", 0),
    NAVI_GUIDER_WECHAT_TAB_ICON_BTN("B0046", 0),
    NAVI_GUIDER_XP_ACCOUNT_TAB_ICON_BTN("B0047", 0),
    NAVI_GUIDER_BIND_AMAP_PAGER("B0048", 0),
    NAVI_GUIDER_WECHAT_PAGER("B0049", 0),
    NAVI_GUIDER_XP_ACCOUNT_PAGER("B0050", 0),
    NAVI_GUIDER_UNBIND_AMAP_BTN("B0051", 0),
    NAVI_GUIDER_CLOSE_EVENT("B0052", 0),
    NAVI_GUIDER_IS_AMAP_ACCOUNT("B0054", 0, new int[]{6}),
    NAVI_GUIDER_AMAP_SEND2AI("B0056", 0, new int[]{16, 17, 21}),
    NAVI_GUIDER_AMAP_SEND2CAR_START_NAVI("B0057", 0, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_AMAP_LAST_MILE_SEND2PHONE("B0058", 0, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_WECHAT_SEND2CART_START_NAVI("B0059", 0, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_XP_SEND2CAR_START_NAVI("B0060", 0, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_XP_ROUTE_SEND2CAR_START_NAVI("B0078", 0, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_BIND_AMAP_DIALOG_SHOW("B0061", 0),
    NAVI_GUIDER_GUO_DIAN_CALLED("B0072", 1, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_MAINTENANCE_SUPPORT_CALLED("B0073", 1, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_INTERFACE_CALLED("B0074", 1, new int[]{15, 16, 17, 21}),
    NAVI_GUIDER_BAIDU_ICON_BTN("B0081", 0),
    NAVI_GUIDER_DIANPING_ICON_BTN("B0082", 0),
    NAVI_GUIDER_MEITUAN_ICON_BTN("B0083", 0),
    NAVI_GUIDER_BIND_AMAP_BTN("B0084", 0),
    NAVI_GUIDER_BIND_WECHAT_BTN("B0085", 0),
    MAP_STATE_ACTIVE("B0114", 1),
    MAP_STATE_IMMERSION("B0115", 1),
    RECOMMEND_CHARGER_AROUND_SHOW("B0116", 1, new int[]{15, 16, 17}),
    RECOMMEND_CHARGER_AROUND_CLICK("B0117", 1, new int[]{15, 16, 17, 56}),
    RECOMMEND_CHARGER_FRE_SHOW("B0118", 1, new int[]{15, 16, 17}),
    RECOMMEND_CHARGER_FRE_CLICK("B0119", 1, new int[]{15, 16, 17, 56}),
    MAP_THUMB_OVERVIEW("B0120", 1),
    START_NAVI_SYSTEM("B0301", 1, new int[]{10, 11, 12, 15, 16, 17, 19, 21, 26, 28, 29}),
    STOP_NAVI("B0302", 0, new int[]{19, 20, 21}),
    STOP_NAVI_SYSTEM("B0303", 1, new int[]{19, 20, 21}),
    ROUTE_FAILURE("B0304", 2, new int[]{40}),
    ROUTE_FAILURE_FOR_WAYPOINT("B0305", 2, new int[]{40}),
    NAVI_RESTORE_CARD_SHOW("B0306", 0),
    NAVI_RESTORE_START("B0307", 0),
    NAVI_RESTORE_CLOSE("B0308", 0),
    RECOMMEND_ROUTE_SHOW("B0309", 1),
    RECOMMEND_ROUTE_IGNORE("B0310", 1),
    RECOMMEND_ROUTE_SWITCH("B0311", 1),
    RESTRICT_SHOW("B0213", 1),
    RESTRICT_BTN_SETTING_PLATE("B0214", 1),
    RESTRICT_BTN_DETAIL("B0215", 1),
    RESTRICT_BTN_CLOSE("B0216", 1),
    SEARCH_PAGE_SHOW("B0404", 0, new int[]{27}),
    SEARCH_PAGE_BACKGROUND("B0405", 0),
    SEARCH_PAGE_FOREGROUND("B0406", 0),
    SEARCH_PAGE_EXIT("B0407", 0),
    SEARCH_PAGE_GESTURE_OPERATIONS("B0408", 2, new int[]{26}),
    SEARCH_PAGE_HISTORY_ITEM_SELECTED("B0409", 1, new int[]{25, 26}),
    SEARCH_PAGE_HISTORY_PATH_ITEM_SELECTED("B0459", 0),
    SEARCH_PAGE_HISTORY_ITEM_NAVI("B0410", 0, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_HISTORY_ITEM_SETTING_HOME("B0411", 0, new int[]{25, 26}),
    SEARCH_PAGE_HISTORY_ITEM_SETTING_OFFICE("B0412", 0, new int[]{25, 26}),
    SEARCH_PAGE_HISTORY_ITEM_ADD_WAYPOINT("B0413", 1, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_HISTORY_ITEM_DELETE_WAYPOINT("B0414", 1, new int[]{25, 26}),
    SEARCH_PAGE_SUG_SELECTED("B0415", 1, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_SUG_NAVI("B0416", 0, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_SUG_SETTING_HOME("B0417", 1, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_SUG_SETTING_OFFICE("B0418", 1, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_SUG_ADD_WAYPOINT("B0419", 1, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_SUG_DELETE_WAYPOINT("B0420", 1, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_TAB_4S("B0421", 0),
    SEARCH_PAGE_TAB_CHARGE("B0422", 0, new int[]{56}),
    SEARCH_PAGE_TAB_REPAIR("B0423", 1),
    SEARCH_PAGE_TAB_PARKING("B0424", 1),
    SEARCH_PAGE_TAB_FOOD("B0425", 1),
    SEARCH_PAGE_TAB_WC("B0426", 1),
    SEARCH_PAGE_TAB_EXP_CENTER("B0464", 1),
    SEARCH_PAGE_TAB_HOME("B0427", 0),
    SEARCH_PAGE_TAB_HOME_EMPTY("B0428", 0),
    SEARCH_PAGE_TAB_HOME_EDIT("B0429", 0),
    SEARCH_PAGE_TAB_OFFICE("B0430", 0),
    SEARCH_PAGE_TAB_OFFICE_EMPTY("B0431", 0),
    SEARCH_PAGE_TAB_OFFICE_EDIT("B0432", 0),
    SEARCH_PAGE_EXIT_BUTTON("B0433", 1),
    SEARCH_PAGE_EXIT_GESTURE("B0434", 1),
    SEARCH_PAGE_CLEAR_KEYWORDS_BUTTON("B0435", 1),
    SEARCH_PAGE_DELETE_HISTORY_ITEM("B0436", 2, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_DELETE_ALL_HISTORIES("B0437", 2),
    SEARCH_PAGE_TAB_FAVORITES("B0438", 1),
    SEARCH_PAGE_DELETE_FAVORITE_ITEM("B0439", 2, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_CLEAR_ALL_FAVORITES("B0440", 2),
    SEARCH_PAGE_CANCELED("B0441", 1),
    SEARCH_PAGE_SEARCH_NONE_RESULT("B0442", 2, new int[]{24, 32}),
    SEARCH_PAGE_DELETE_ALL_HISTORIES_DIALOG_CONFIRM("B0443", 2),
    SEARCH_PAGE_DELETE_ALL_HISTORIES_DIALOG_CANCEL("B0444", 2),
    SEARCH_PAGE_DELETE_ALL_FAVORITES_DIALOG_CONFIRM("B0445", 2),
    SEARCH_PAGE_DELETE_ALL_FAVORITES_DIALOG_CANCEL("B0446", 2),
    SEARCH_PAGE_LIST_ITEM_SELECTED("B0460", 0, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_LIST_ITEM_START_NAVI_CLICK("B0461", 0, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_LIST_ITEM_ADD_WAY_POINT("B0462", 0, new int[]{15, 16, 17, 25, 26}),
    SEARCH_PAGE_LIST_ITEM_REMOVE_WAY_POINT("B0463", 0, new int[]{15, 16, 17, 25, 26}),
    AI_RECEIVE_MESSAGE_CENTER_TRAFFIC_WARNING("B0607", 0),
    AI_SEND_MESSAGE_CENTER_TRAFFIC_WARNING("B0608", 0),
    AI_TRAFFIC_DRAW_PATH("B0615", 0, new int[]{29}),
    AI_TRAFFIC_DRAW_COUNTDOWN("B0616", 0, new int[]{29}),
    AI_TRAFFIC_START_NAVI("B0617", 0, new int[]{29}),
    EXPLORE_PAGE_SHOW("B0309", 1),
    EXPLORE_PAGE_IGNORE("B0310", 1),
    EXPLORE_PAGE_EXCHANGE("B0311", 1),
    EXPLORE_PAGE_VUI_COMMAND("B0609", 0),
    VUI_SPEECH("B0609", 0, new int[]{22, 23}),
    VUI_ACC_TIP_OPEN("B0610", 0, new int[]{19}),
    VUI_ACC_TIP_CLOSE("B0612", 0, new int[]{19}),
    RECOMMEND_PARK_START("0614", 0),
    ACC_ON("B0618", 0, new int[]{19, 29, 37, 38, 39}),
    ACC_OFF("B0619", 0, new int[]{19, 29, 37, 38, 39}),
    ACC_MSG("B0620", 0, new int[]{55}),
    XPILOT_CHANGE_MSG("B0623", 0, new int[]{62, 6, 19, 29, 37, 38, 39}),
    CHARGE_SEARCH_RESULT_EXPOSURE("B0501", 0, new int[]{24, 56}),
    SEARCH_RESULT_EXPOSURE("B0501", 0, new int[]{24}),
    SEARCH_RESULT_GOTOBACKGROUND("B0502", 0),
    SEARCH_RESULT_GOTOFOREGROUND("B0503", 0),
    SEARCH_RESULT_EXIT("B0504", 0),
    SEARCH_RESULT_BROWSE("B0505", 2),
    SEARCH_RESULT_BACK_BUTTON("B0506", 0),
    SEARCH_RESULT_EXIT_BUTTON("B0507", 0),
    SEARCH_RESULT_ITEM_CLICK_BUTTON("B0508", 0),
    SEARCH_RESULT_NAVI_BUTTON("B0509", 0, new int[]{15, 16, 17, 25}),
    SEARCH_RESULT_ADD_WAY_BUTTON("B0510", 1, new int[]{15, 16, 17, 25}),
    SEARCH_RESULT_SET_HOME_BUTTON("B0511", 0, new int[]{25}),
    SEARCH_RESULT_SET_COMPANY_BUTTON("B0512", 0, new int[]{25}),
    SEARCH_RESULT_CLICK_FILTER_FREE("B0471", 0),
    SEARCH_RESULT_CLICK_FILTER_SELF_SALE("B0472", 0),
    LOCATION_RESET_UBX("B0901", 0, new int[]{6, 19, 53}),
    ACCELERATION_DETECT("B0903", 0, new int[]{43, 44}),
    GYRO_RATE_DETECT("B0904", 0, new int[]{43, 44}),
    GNSS_TTFF_TIME("B0908", 0, new int[]{19, 41, 53, 58, 59, 60, 61}),
    RESET_MINIMAP("B0909", 0),
    NAVI_RESTART("B0902", 0, new int[]{6, 29, 32}),
    NAVI_CONTAINER_MAP_DISPLAY("B0102", 2, new int[]{6}),
    NAVI_CONTAINER_MAP_EXIT("B0105", 2, new int[]{6}),
    NAVI_CONTAINER_TOUCH_DOWN("B0111", 2, new int[]{1, 2, 3, 4, 5}),
    NAVI_CONTAINER_TOUCH_UP("B0112", 2, new int[]{1, 2, 3, 4, 5}),
    NAVI_CONTAINER_MAP_CLICK("B0113", 2, new int[]{7, 8, 9}),
    NAVI_CONTAINER_EXCHANGE_PAGE("B0524", 2, new int[]{26}),
    NAVI_CONTAINER_SEARCHE_RESULT_SHOW("B0501", 2, new int[]{24}),
    NAVI_CONTAINER_SELECT_ITEM("B0508", 2),
    ROUTE_CHARGE_SWITCH("B0250", 0, new int[]{6, 56}),
    ROUTE_CHARGE_DETAIL_SHOW("B0251", 0, new int[]{16, 25, 46, 47, 48, 49, 50, 51}),
    ROUTE_CHARGE_ADD("B0252", 0, new int[]{16, 25, 46, 47, 48, 49, 50, 51, 52}),
    ROUTE_CHARGE_REMOVE("B0253", 0, new int[]{16, 25, 46, 47, 48, 49, 50, 51}),
    BLSDK_ACTIVATE_ACTION("B0905", 1, new int[]{6, 54}),
    USER_CENTER_WE_CHAT("B0077", 1),
    LANE_DATA_START_DOWNLOAD("B0701", 1, new int[]{63, 64, 65}),
    LANE_DATA_DOWNLOAD_SUCCESS("B0702", 1, new int[]{64, 65}),
    LANE_DATA_UPDATE_FAIL("B0703", 1, new int[]{64, 66}),
    LANE_DATA_MERGE_SUCCESS("B0704", 1, new int[]{64}),
    NGP_PANEL_EXPAND_PANEL("B0801", 1),
    NGP_PANEL_DOWNGRADE_TO_LCC("B0802", 0),
    NGP_PANEL_UPGRADE_TO_NGP("B0803", 0),
    NGP_PANEL_COLLAPSE("B0804", 1),
    NGP_PANEL_CANCEL_CHANGE_LANE("B0805", 0),
    SR_SHOW_TIME_PERCENT("B0809", 0, new int[]{67}),
    SR_PAGE_TWO_POINTER_ON_SR("B0806", 0),
    SR_PAGE_ENTER_MAP("B0807", 0),
    MAP_PAGE_ENTER_SR("B0808", 0),
    MAP_DATA_UPLOAD("B0089", 0, new int[]{78});
    
    private final String mButtonId;
    private final int mLevel;
    private int[] mParamIndexArray;

    BtnType(String str, int i, int[] iArr) {
        this.mButtonId = str;
        this.mLevel = i;
        this.mParamIndexArray = iArr;
    }

    BtnType(String str, int i) {
        this.mButtonId = str;
        this.mLevel = i;
    }

    public String getButtonId() {
        return this.mButtonId;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public int[] getParamIndexArray() {
        return this.mParamIndexArray;
    }
}
