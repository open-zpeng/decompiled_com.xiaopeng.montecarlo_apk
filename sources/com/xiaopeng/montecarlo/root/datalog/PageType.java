package com.xiaopeng.montecarlo.root.datalog;
/* loaded from: classes2.dex */
public enum PageType {
    NONE,
    NAVI_CRUISE("P0201", "Navi_Cruise"),
    NAVI_ROUTING("P0101", "Navi_Routing"),
    NAVI_DETECT_ROUTE("P0102", "Navi_Detect_Route"),
    NAVI_GUIDANCE("P0103", "Navi_Guidance"),
    SEARCH_MAIN_PAGE("P0001", "Navi_Search_Main_Page"),
    Navi_Search_Main_Result("P0002", "Navi_Search_Main_Result"),
    SEARCH_WAYPOINT_PAGE("P0003", "Navi_Search_Waypoint_Page"),
    SEARCH_WAYPOINT_RESULT("P0004", "Navi_Search_Waypoint_Result"),
    SEARCH_HOME_PAGE("P0005", "Navi_Search_Home_Page"),
    SEARCH_HOME_RESULT("P0006", "Navi_Search_Home_Result"),
    SEARCH_OFFICE_PAGE("P0007", "Navi_Search_Office_Page"),
    SEARCH_OFFICE_RESULT("P0008", "Navi_Search_Office_Result"),
    SEARCH_NEARBY_PAGE("P0009", "Navi_Search_Nearby_Page"),
    SEARCH_NEARBY_RESULT("P0010", "Navi_Search_Nearby_Result"),
    SEARCH_CHARGINGSTATION_RESULT("P0011", "Navi_Search_ChargingStation_Result"),
    NAVI_SEARCH_FAVORITE("P0012", "Navi_Search_Favorite"),
    SETTING("P0301", "Navi_Setting"),
    MESSAGE_ACCOUNT("P0302", "Navi_Message_Account"),
    SETTING_USER_DATA("P0305", "Navi_Setting_User_Data"),
    MESSAGE_HISTORY_DATA("P0306", "Navi_Message_History_Data"),
    MESSAGE_FAVORITE("P0307", "Navi_Message_Favorite"),
    MESSAGE_HOME_RECOMMENDATION("P0308", "Navi_Message_Home_Recommendation"),
    MESSAGE_OFFICE_RECOMMENDATION("P0309", "Navi_Message_Office_Recommendation"),
    OTHER("P0401", "Navi_Other"),
    NAVI_MESSAGE_NAVI_SYNC("P0310", "Navi_Message_Navi_Sync"),
    NAVI_AMAPBINDING("P0311", "Navi_Amapbinding"),
    NAVI_CONTAINER("P0501", "Navi_Container"),
    BLSDK_ACTIVATE_RESULT("P0901", "Navi_ActivateFragment"),
    NAVI_SCAN_SEARCH("P0013", "Navi_Scan_Search"),
    NONE_UI_RELATED("P0999", "None_UI_Related"),
    NAVI_LANE_DATA_DOWNLOAD("P0700", "Navi_Lane_Data_Download"),
    NAVI_SR_PAGE_OPERATION("P0800", "Navi_SR_Page_Operation");
    
    private String mPageId;
    private String mPageName;

    PageType(String str, String str2) {
        this.mPageId = str;
        this.mPageName = str2;
    }

    public String getPageId() {
        return this.mPageId;
    }

    public String getPageName() {
        return this.mPageName;
    }
}
