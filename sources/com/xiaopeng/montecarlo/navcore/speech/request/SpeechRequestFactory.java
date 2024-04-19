package com.xiaopeng.montecarlo.navcore.speech.request;

import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SpeechRequestFactory implements ISpeechRequest {
    public static final String PARAM_APP_ID = "app_id";
    public static final String PARAM_CONTENT = "content";
    public static final String PARAM_SERVICE_NAME = "service";
    public static final String PARAM_SPEECH_REQUEST = "speech_request";
    public static final String PARAM_WHAT = "what";
    public static final int SPEECH_CMD_ADDRESS_GET = 20;
    public static final int SPEECH_CMD_ADDRESS_GET_COMPANY = 48;
    public static final int SPEECH_CMD_ADDRESS_GET_HOME = 47;
    public static final int SPEECH_CMD_ADDRESS_GO_HOME = 49;
    public static final int SPEECH_CMD_ADDRESS_SET = 21;
    public static final int SPEECH_CMD_ADDRESS_SET_COMPANY = 46;
    public static final int SPEECH_CMD_ADDRESS_SET_HOME = 45;
    public static final int SPEECH_CMD_AVOID_CHARGE_OFF = 20027;
    public static final int SPEECH_CMD_CANCEL_ROUTE = 53;
    public static final int SPEECH_CMD_CLOSE_TRAFFIC = 5;
    public static final int SPEECH_CMD_CONFIRM_CANCEL = 37;
    public static final int SPEECH_CMD_CONFIRM_OK = 36;
    public static final int SPEECH_CMD_CONTROL_CHARGE_CLOSE = 12;
    public static final int SPEECH_CMD_CONTROL_CHARGE_OPEN = 11;
    public static final int SPEECH_CMD_CONTROL_CLOSE = 1;
    public static final int SPEECH_CMD_CONTROL_CLOSE_RIBBON_MAP = 20031;
    public static final int SPEECH_CMD_CONTROL_CLOSE_SMALL_MAP = 20029;
    public static final int SPEECH_CMD_CONTROL_DISPLAY_3D = 28;
    public static final int SPEECH_CMD_CONTROL_DISPLAY_CAR = 27;
    public static final int SPEECH_CMD_CONTROL_DISPLAY_NORTH = 26;
    public static final int SPEECH_CMD_CONTROL_FAVORITE_CLOSE = 20021;
    public static final int SPEECH_CMD_CONTROL_FAVORITE_OPEN = 9;
    public static final int SPEECH_CMD_CONTROL_OPEN_RIBBON_MAP = 20030;
    public static final int SPEECH_CMD_CONTROL_OPEN_SMALL_MAP = 20028;
    public static final int SPEECH_CMD_CONTROL_OVERVIEW_CLOSE = 7;
    public static final int SPEECH_CMD_CONTROL_OVERVIEW_OPEN = 6;
    public static final int SPEECH_CMD_CONTROL_RECOMMEND_PARK_OFF = 20039;
    public static final int SPEECH_CMD_CONTROL_RECOMMEND_PARK_ON = 20038;
    public static final int SPEECH_CMD_CONTROL_ROAD_AHEAD_OFF = 20020;
    public static final int SPEECH_CMD_CONTROL_ROAD_AHEAD_ON = 20019;
    public static final int SPEECH_CMD_CONTROL_SEARCH_CLOSE = 20022;
    public static final int SPEECH_CMD_CONTROL_SEARCH_NORMAL_OPEN = 55;
    public static final int SPEECH_CMD_CONTROL_SECURITY_REMIND_OFF = 20018;
    public static final int SPEECH_CMD_CONTROL_SECURITY_REMIND_ON = 20017;
    public static final int SPEECH_CMD_CONTROL_SETTINGS_OPEN = 10;
    public static final int SPEECH_CMD_CONTROL_SET_SCALE_LEVEL = 20040;
    public static final int SPEECH_CMD_CONTROL_SMART_SCALE_OFF = 20016;
    public static final int SPEECH_CMD_CONTROL_SMART_SCALE_ON = 20015;
    public static final int SPEECH_CMD_CONTROL_SPEECH_DETAIL = 25;
    public static final int SPEECH_CMD_CONTROL_SPEECH_EYE_OFF = 20014;
    public static final int SPEECH_CMD_CONTROL_SPEECH_EYE_ON = 20013;
    public static final int SPEECH_CMD_CONTROL_SPEECH_GENERAL = 20012;
    public static final int SPEECH_CMD_CONTROL_SPEECH_SIMPLE = 24;
    public static final int SPEECH_CMD_CONTROL_SPEECH_SUPER_SIMPLE = 20011;
    public static final int SPEECH_CMD_CONTROL_START = 22;
    public static final int SPEECH_CMD_CONTROL_START_EXPLORE = 20034;
    public static final int SPEECH_CMD_CONTROL_SWITCH_TO_MAIN_ROAD = 20023;
    public static final int SPEECH_CMD_CONTROL_SWITCH_TO_SLID_ROAD = 20024;
    public static final int SPEECH_CMD_CONTROL_VOL_OFF = 33;
    public static final int SPEECH_CMD_CONTROL_VOL_ON = 32;
    public static final int SPEECH_CMD_CONTROL_WAYPOINT_START = 23;
    public static final int SPEECH_CMD_CONTROL_ZOOM_IN_MAX = 20026;
    public static final int SPEECH_CMD_CONTROL_ZOOM_OUT_MIN = 20025;
    public static final int SPEECH_CMD_DATA_CONTROL_DISPLAY_3D_TTS = 29;
    public static final int SPEECH_CMD_DATA_CONTROL_DISPLAY_CAR_TTS = 30;
    public static final int SPEECH_CMD_DATA_CONTROL_DISPLAY_NORTH_TTS = 31;
    public static final int SPEECH_CMD_DATA_MAP_ZOOMIN_TTS = 41;
    public static final int SPEECH_CMD_DATA_MAP_ZOOMOUT_TTS = 42;
    public static final int SPEECH_CMD_DRIVE_ADVOID_TRAFFIC_CONTROL = 43;
    public static final int SPEECH_CMD_DRIVE_AVOID_CHARGE = 14;
    public static final int SPEECH_CMD_DRIVE_AVOID_CONGESTION = 13;
    public static final int SPEECH_CMD_DRIVE_AVOID_CONGESTION_CLOSE = 20004;
    public static final int SPEECH_CMD_DRIVE_AVOID_CONTROLS_OFF = 20008;
    public static final int SPEECH_CMD_DRIVE_AVOID_CONTROLS_ON = 20007;
    public static final int SPEECH_CMD_DRIVE_HIGHWAY_CLOSE = 20005;
    public static final int SPEECH_CMD_DRIVE_HIGHWAY_FIRST = 16;
    public static final int SPEECH_CMD_DRIVE_HIGHWAY_FIRST_CLOSE = 20006;
    public static final int SPEECH_CMD_DRIVE_HIGHWAY_NO = 15;
    public static final int SPEECH_CMD_DRIVE_RADAR_ROUTE_OFF = 20010;
    public static final int SPEECH_CMD_DRIVE_RADAR_ROUTE_ON = 20009;
    public static final int SPEECH_CMD_FOR_RESULT_GET_COMMON_ADDRESS = 10008;
    public static final int SPEECH_CMD_FOR_RESULT_GET_CURRENT_CHILD_SCENE_NAME = 10010;
    public static final int SPEECH_CMD_FOR_RESULT_GET_CURRENT_MAIN_SCENE_NAME = 10009;
    public static final int SPEECH_CMD_FOR_RESULT_GET_CURRENT_MAP_SCALE_LEVEL = 10014;
    public static final int SPEECH_CMD_FOR_RESULT_GET_MAP_MODE = 10012;
    public static final int SPEECH_CMD_FOR_RESULT_GET_MAP_SETTING_INFO = 10013;
    public static final int SPEECH_CMD_FOR_RESULT_GET_NAVI_INFO = 10007;
    public static final int SPEECH_CMD_FOR_RESULT_IS_CRUISE = 10002;
    public static final int SPEECH_CMD_FOR_RESULT_IS_EXPLORE = 10003;
    public static final int SPEECH_CMD_FOR_RESULT_IS_NAVI = 10001;
    public static final int SPEECH_CMD_FOR_RESULT_IS_OPEN_OVERVIEW_MODE = 10011;
    public static final int SPEECH_CMD_FOR_RESULT_IS_ROUTE = 10004;
    public static final int SPEECH_CMD_FOR_RESULT_IS_SR = 10015;
    public static final int SPEECH_CMD_FOR_RESULT_IS_ZOOMIN_MAX = 10005;
    public static final int SPEECH_CMD_FOR_RESULT_IS_ZOOMOUT_MIN = 10006;
    public static final int SPEECH_CMD_INFOFLOW_CARD_HEIGHT_CHANGED = 20036;
    public static final int SPEECH_CMD_INFOFLOW_SCROLL_END = 20032;
    public static final int SPEECH_CMD_MAP_OVERVIEW = 8;
    public static final int SPEECH_CMD_MAP_ZOOM_IN = 2;
    public static final int SPEECH_CMD_MAP_ZOOM_OUT = 3;
    public static final int SPEECH_CMD_NAVIGATING_GET = 17;
    public static final int SPEECH_CMD_NEARBY_SEARCH = 19;
    public static final int SPEECH_CMD_ON_DIALOG_START = 20033;
    public static final int SPEECH_CMD_ON_WIDGET_CANCEL = 20037;
    public static final int SPEECH_CMD_ON_WIDGET_LIST_EXPAND = 20035;
    public static final int SPEECH_CMD_OPEN_TRAFFIC = 4;
    public static final int SPEECH_CMD_PARKING_SELECT = 35;
    public static final int SPEECH_CMD_POI_SEARCH = 18;
    public static final int SPEECH_CMD_ROAD_INFO = 50;
    public static final int SPEECH_CMD_ROUTE_NEARBY_SEARCH = 34;
    public static final int SPEECH_CMD_ROUTE_SELECT = 38;
    public static final int SPEECH_CMD_SCRATCH_SPOT_BROADCAST_CLOSE = 57;
    public static final int SPEECH_CMD_SCRATCH_SPOT_BROADCAST_OPEN = 56;
    public static final int SPEECH_CMD_SELECT_PARKING_COUNT = 39;
    public static final int SPEECH_CMD_SELECT_ROUTE_COUNT = 40;
    public static final int SPEECH_CMD_SHOW_CHARGING_STATION = 54;
    public static final int SPEECH_CMD_SWITCH_MAP_MODE = 51;
    public static final int SPEECH_CMD_SWITCH_OVERVIEW = 52;
    public static final int SPEECH_CMD_VOICE_INTERACTIVE_END = 20001;
    public static final int SPEECH_CMD_VOICE_SEARCH_DATA_FETCHED = 20002;
    public static final int SPEECH_CMD_VOICE_SEARCH_DATA_ITEM_FOCUSED = 20003;
    public static final int SPEECH_CMD_WAYPOINT_SEARCH = 44;
    private static final L.Tag TAG = new L.Tag("SpeechRequestFactory");
    private static volatile SpeechRequestFactory sSpeechRequestFactory = new SpeechRequestFactory();
    private ISpeechRequest mImpl;

    public static SpeechRequestFactory getInstance() {
        return sSpeechRequestFactory;
    }

    public void init(ISpeechRequest iSpeechRequest) {
        this.mImpl = iSpeechRequest;
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public Object postRequestForResult(int i) {
        return postRequestForResult(i, null);
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public Object postRequestForResult(int i, String str) {
        ISpeechRequest iSpeechRequest = this.mImpl;
        if (iSpeechRequest == null) {
            L.w(TAG, "postRequestForResult, mImpl is null");
            return null;
        }
        return iSpeechRequest.postRequestForResult(i, str);
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i) {
        ISpeechRequest iSpeechRequest = this.mImpl;
        if (iSpeechRequest == null) {
            L.w(TAG, "postRequest, mImpl is null");
        } else {
            iSpeechRequest.postRequest(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i, String str) {
        ISpeechRequest iSpeechRequest = this.mImpl;
        if (iSpeechRequest == null) {
            L.w(TAG, "postRequest, mImpl is null");
        } else {
            iSpeechRequest.postRequest(i, str);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i, boolean z) {
        ISpeechRequest iSpeechRequest = this.mImpl;
        if (iSpeechRequest == null) {
            L.w(TAG, "postRequest, mImpl is null");
        } else {
            iSpeechRequest.postRequest(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(int i, String str, boolean z) {
        ISpeechRequest iSpeechRequest = this.mImpl;
        if (iSpeechRequest == null) {
            L.w(TAG, "postRequest, mImpl is null");
        } else {
            iSpeechRequest.postRequest(i, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.speech.request.ISpeechRequest
    public void postRequest(SpeechRequest speechRequest, boolean z) {
        ISpeechRequest iSpeechRequest = this.mImpl;
        if (iSpeechRequest == null) {
            L.w(TAG, "postRequest, mImpl is null");
        } else {
            iSpeechRequest.postRequest(speechRequest, z);
        }
    }
}
