package com.xiaopeng.montecarlo.navcore.event;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.speech.log.ILogCollector;
import com.xiaopeng.montecarlo.navcore.speech.log.SpeechLogCollector;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
import com.xiaopeng.speech.protocol.node.navi.bean.NearbySearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiSearchBean;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SpeechNaviEvent {
    public static final int SPEECH_ADD_VIA = 313;
    public static final int SPEECH_CANCEL_MUTE = 402;
    public static final int SPEECH_CLOSE_OVERVIEW = 203;
    public static final int SPEECH_CLOSE_SCENE = 905;
    public static final int SPEECH_CMD_CONTROL_SET_SCALE_LEVEL = 2010;
    public static final int SPEECH_CMD_CONTROL_SWITCH_TO_MAIN_ROAD = 1110;
    public static final int SPEECH_CMD_CONTROL_SWITCH_TO_SLID_ROAD = 1111;
    public static final int SPEECH_CMD_CONTROL_ZOOM_IN_MAX = 1113;
    public static final int SPEECH_CMD_CONTROL_ZOOM_OUT_MIN = 1112;
    public static final int SPEECH_ENTER_ACTIVE_STATE = 412;
    public static final int SPEECH_EXIT_CROSS_3D = 411;
    public static final int SPEECH_GO_TO_CRUISE_MODE = 901;
    public static final int SPEECH_INFOFLOW_CARD_HEIGHT_CHANGED = 2007;
    public static final int SPEECH_INFOFLOW_LIST_STATE_CHANGED = 2006;
    public static final int SPEECH_INFOFLOW_SCROLL_END = 2004;
    public static final int SPEECH_MAP_MODE_HEAD_UP_2D = 408;
    public static final int SPEECH_MAP_MODE_HEAD_UP_3D = 409;
    public static final int SPEECH_MAP_MODE_NORTH_UP = 407;
    public static final int SPEECH_ON_DIALOG_START = 2005;
    public static final int SPEECH_OPEN_DEBUG = 104;
    public static final int SPEECH_OPEN_FAVORITE = 100;
    public static final int SPEECH_OPEN_LINK_SEAMLESS_NAVI = 106;
    public static final int SPEECH_OPEN_OVERVIEW = 202;
    public static final int SPEECH_OPEN_SCENE = 904;
    public static final int SPEECH_OPEN_SEARCH_NORMAL = 109;
    public static final int SPEECH_OPEN_SETTINGS = 103;
    public static final int SPEECH_OPEN_SETTING_LICENCE_PLATE = 105;
    public static final int SPEECH_OPEN_SETTING_MAP_DOWNLOAD = 107;
    public static final String SPEECH_OPERATE_TYPE_DEBUG_ROUTE_REQUEST = "debug_route_request";
    public static final String SPEECH_OPERATE_TYPE_OPEN_FAVORITE = "open_favorite";
    public static final String SPEECH_OPERATE_TYPE_POST_REQUEST = "post_request";
    public static final String SPEECH_OPERATE_TYPE_START_ROUTE_WITH_VIA = "start_route_with_via";
    public static final String SPEECH_OPERATE_TYPE_STOP_NAVI = "stop_navi";
    public static final String SPEECH_OPERATE_TYPE_VOICE_SEARCH_FUSION = "voice_search_fusion";
    public static final int SPEECH_REMOVE_ALL_TOP_CHILD_SCENE = 110;
    public static final int SPEECH_REROUTE = 303;
    public static final int SPEECH_ROUTE_NEW_DEST_WITH_VIAS = 312;
    public static final int SPEECH_SCRATCH_SPOT_BROADCAST = 1110;
    public static final int SPEECH_SELECT_RECOMMEND_PARK = 501;
    public static final int SPEECH_SETTING_AVOID_CHARGE = 1101;
    public static final int SPEECH_SETTING_AVOID_CONGESTION = 1102;
    public static final int SPEECH_SETTING_AVOID_HIGHWAY = 1103;
    public static final int SPEECH_SETTING_DETAIL_BROADCAST = 1106;
    public static final int SPEECH_SETTING_EXIT = 1109;
    public static final int SPEECH_SETTING_HIGH_FIRST = 1104;
    public static final int SPEECH_SETTING_REALTIME_TRAFFIC = 1107;
    public static final int SPEECH_SETTING_REFRESH_ALL = 1100;
    public static final int SPEECH_SETTING_SIMPLE_BROADCAST = 1105;
    public static final int SPEECH_SET_MUTE = 401;
    public static final int SPEECH_SET_POI_TO_CENTER = 903;
    public static final int SPEECH_START_EXPLORE = 307;
    public static final int SPEECH_START_NAVI = 304;
    public static final int SPEECH_STOP_NAVI = 305;
    public static final int SPEECH_SWITCH_CHARGING_STATION = 502;
    public static final int SPEECH_SWITCH_MAP_MODE = 410;
    public static final int SPEECH_SWITCH_OVERVIEW = 201;
    public static final int SPEECH_SWITCH_RECOMMEND_PARK = 504;
    public static final int SPEECH_SWITCH_SMART_SCALE = 503;
    public static final int SPEECH_UPDATE_FAVORITE_BUTTON = 108;
    public static final int SPEECH_UPDATE_ROUTE = 306;
    public static final int SPEECH_VOICE_EXIT_SR_LANE_MODE = 2009;
    public static final int SPEECH_VOICE_INTERACTIVE_END = 2001;
    public static final int SPEECH_VOICE_ON_WIDGET_CANCEL = 2008;
    public static final int SPEECH_VOICE_SEARCH_DATA_FETCHED = 2002;
    public static final int SPEECH_VOICE_SEARCH_DATA_ITEM_FOCUSED = 2003;
    public static final int SPEECH_WAKE_UP_MAP = 902;
    public static final int SPEECH_ZOOM_IN = 405;
    public static final int SPEECH_ZOOM_OUT = 406;
    private static final L.Tag TAG = new L.Tag("SpeechNaviEvent");
    private AddressBean mAddressBean;
    private XPPoiInfo mDest;
    private int mFirstVisibleIndex;
    private int mFocusIndex;
    private int mIndex;
    private int mInfoflowCardHeight;
    private boolean mIsDebugRoute;
    private boolean mIsExpand;
    private int mLevel;
    private PoiBean mPoiBean;
    private PoiSearchBean mPoiSearchBean;
    private int mSceneMode;
    private NearbySearchBean mSearchBean;
    int mSettingParam;
    private boolean mSwitchState;
    private ArrayList<XPViaPoint> mViaList;
    private String mVoiceSearchData;
    public int what;
    private XPPoiInfo mOrig = null;
    private int mStartType = 0;
    private int mRouteSelectRef = 0;
    private ILogCollector mSpeechLogCollector = new SpeechLogCollector();

    public PoiSearchBean getPoiSearchBean() {
        return this.mPoiSearchBean;
    }

    public void setPoiSearchBean(PoiSearchBean poiSearchBean) {
        this.mPoiSearchBean = poiSearchBean;
    }

    public NearbySearchBean getSearchBean() {
        return this.mSearchBean;
    }

    public void setSearchBean(NearbySearchBean nearbySearchBean) {
        this.mSearchBean = nearbySearchBean;
    }

    public AddressBean getAddressBean() {
        return this.mAddressBean;
    }

    public void setAddressBean(AddressBean addressBean) {
        this.mAddressBean = addressBean;
    }

    public XPPoiInfo getDest() {
        return this.mDest;
    }

    public void setDest(XPPoiInfo xPPoiInfo) {
        this.mDest = xPPoiInfo;
    }

    public XPPoiInfo getOrig() {
        return this.mOrig;
    }

    public void setOrig(XPPoiInfo xPPoiInfo) {
        this.mOrig = xPPoiInfo;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public ArrayList<XPViaPoint> getViaList() {
        return this.mViaList;
    }

    public void setViaList(ArrayList<XPViaPoint> arrayList) {
        this.mViaList = arrayList;
    }

    public int getSettingParam() {
        return this.mSettingParam;
    }

    public void setSettingParam(int i) {
        this.mSettingParam = i;
    }

    public PoiBean getPoiBean() {
        return this.mPoiBean;
    }

    public void setPoiBean(PoiBean poiBean) {
        this.mPoiBean = poiBean;
    }

    public int getSceneMode() {
        return this.mSceneMode;
    }

    public void setSceneMode(int i) {
        this.mSceneMode = i;
    }

    public boolean isDebugRoute() {
        return this.mIsDebugRoute;
    }

    public void setDebugRoute(boolean z) {
        this.mIsDebugRoute = z;
    }

    public String getVoiceSearchData() {
        return this.mVoiceSearchData;
    }

    public void setVoiceSearchData(String str) {
        this.mVoiceSearchData = str;
    }

    public int getFocusIndex() {
        return this.mFocusIndex;
    }

    public void setFocusIndex(int i) {
        this.mFocusIndex = i;
    }

    public int getFirstVisibleIndex() {
        return this.mFirstVisibleIndex;
    }

    public void setFirstVisibleIndex(int i) {
        this.mFirstVisibleIndex = i;
    }

    public boolean isExpand() {
        return this.mIsExpand;
    }

    public void setExpand(boolean z) {
        this.mIsExpand = z;
    }

    public int getStartType() {
        return this.mStartType;
    }

    public void setStartType(int i) {
        this.mStartType = i;
    }

    public int getRouteSelectRef() {
        return this.mRouteSelectRef;
    }

    public void setRouteSelectRef(int i) {
        this.mRouteSelectRef = i;
    }

    public int getInfoflowCardHeight() {
        return this.mInfoflowCardHeight;
    }

    public void setInfoflowCardHeight(int i) {
        this.mInfoflowCardHeight = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public SpeechNaviEvent(int i) {
        this.what = i;
        record("create " + i);
    }

    public boolean getSwitchState() {
        return this.mSwitchState;
    }

    public void setSwitchState(boolean z) {
        this.mSwitchState = z;
    }

    public void record(String str, String str2, String... strArr) {
        this.mSpeechLogCollector.record(this.what, str, str2, strArr);
    }

    public void record(String str) {
        this.mSpeechLogCollector.record(this.what, str);
    }

    public void printRecord() {
        L.Tag tag = TAG;
        L.i(tag, "printRecord:\n" + this.mSpeechLogCollector.getLogStr());
    }
}
