package com.xiaopeng.speech.protocol.query.navi;

import com.xiaopeng.speech.annotation.IQueryProcessor;
import com.xiaopeng.speech.protocol.event.query.QueryNaviEvent;
/* loaded from: classes3.dex */
public class MapQuery_Processor implements IQueryProcessor {
    private MapQuery mTarget;

    public MapQuery_Processor(MapQuery mapQuery) {
        this.mTarget = mapQuery;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.IQueryProcessor
    public Object querySensor(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1925707028:
                if (str.equals(QueryNaviEvent.GET_POI_DETAILS_FAVORITE_STATUS)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1697099311:
                if (str.equals("navi.is.cruise")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1571917085:
                if (str.equals("navi.scale.current.level")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1223775572:
                if (str.equals(QueryNaviEvent.CONTEXT_INFO_LIST_TOP)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1195178996:
                if (str.equals("navi.favorite.open.status")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -851414168:
                if (str.equals("navi.get.navigation.info")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -628698164:
                if (str.equals(QueryNaviEvent.CONTEXT_INFO_LIST_ONEPAGE)) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -372606704:
                if (str.equals("navi.is.navigation")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -98628845:
                if (str.equals("navi.main.road.status")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 13841718:
                if (str.equals(QueryNaviEvent.IS_ACCOUNT_LOGIN)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 18796803:
                if (str.equals("navi.is.zoomout.min")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 238106971:
                if (str.equals("navi.is.sr")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 334610996:
                if (str.equals("navi.common.addr.get")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1182098865:
                if (str.equals("navi.side.road.status")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1454660265:
                if (str.equals("navi.is.calculate.path")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1693312668:
                if (str.equals("navi.is.explore.path")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1706111678:
                if (str.equals(QueryNaviEvent.IS_NAVI_SEARCHING)) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1810158814:
                if (str.equals(QueryNaviEvent.IS_SPEECH_CRUISE_OPENED)) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1964219764:
                if (str.equals(QueryNaviEvent.CONTEXT_INFO_LIST_BOTTOM)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 2037098922:
                if (str.equals("navi.is.zoomin.max")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2041908174:
                if (str.equals("navi.open.controls.status")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return Boolean.valueOf(this.mTarget.isCruise(str, str2));
            case 1:
                return Boolean.valueOf(this.mTarget.isExplorePath(str, str2));
            case 2:
                return Boolean.valueOf(this.mTarget.isNavigation(str, str2));
            case 3:
                return this.mTarget.getAddress(str, str2);
            case 4:
                return this.mTarget.getNavigationInfo(str, str2);
            case 5:
                return Boolean.valueOf(this.mTarget.isZoominMax(str, str2));
            case 6:
                return Boolean.valueOf(this.mTarget.isZoomoutMax(str, str2));
            case 7:
                return Boolean.valueOf(this.mTarget.isCalculatePath(str, str2));
            case '\b':
                return Integer.valueOf(this.mTarget.getFavoriteOpenStatus(str, str2));
            case '\t':
                return Integer.valueOf(this.mTarget.getOpenControlStatus(str, str2));
            case '\n':
                return Integer.valueOf(this.mTarget.getSwitchMainRoadStatus(str, str2));
            case 11:
                return Integer.valueOf(this.mTarget.getSwitchSideRoadStatus(str, str2));
            case '\f':
                return Integer.valueOf(this.mTarget.getCurrentScaleLevel(str, str2));
            case '\r':
                return Integer.valueOf(this.mTarget.getPoiDetailsFavoriteStatus(str, str2));
            case 14:
                return Boolean.valueOf(this.mTarget.isSRMap(str, str2));
            case 15:
                return Integer.valueOf(this.mTarget.getListTop(str, str2));
            case 16:
                return Integer.valueOf(this.mTarget.getListBottom(str, str2));
            case 17:
                return Integer.valueOf(this.mTarget.getListPageInfo(str, str2));
            case 18:
                return Boolean.valueOf(this.mTarget.isAccountLogin(str, str2));
            case 19:
                return Boolean.valueOf(this.mTarget.isNaviSearching(str, str2));
            case 20:
                return Boolean.valueOf(this.mTarget.isNaviSpeechCruiseOpened(str, str2));
            default:
                return null;
        }
    }

    @Override // com.xiaopeng.speech.annotation.IQueryProcessor
    public String[] getQueryEvents() {
        return new String[]{"navi.is.cruise", "navi.is.explore.path", "navi.is.navigation", "navi.common.addr.get", "navi.get.navigation.info", "navi.is.zoomin.max", "navi.is.zoomout.min", "navi.is.calculate.path", "navi.favorite.open.status", "navi.open.controls.status", "navi.main.road.status", "navi.side.road.status", "navi.scale.current.level", QueryNaviEvent.GET_POI_DETAILS_FAVORITE_STATUS, "navi.is.sr", QueryNaviEvent.CONTEXT_INFO_LIST_TOP, QueryNaviEvent.CONTEXT_INFO_LIST_BOTTOM, QueryNaviEvent.CONTEXT_INFO_LIST_ONEPAGE, QueryNaviEvent.IS_ACCOUNT_LOGIN, QueryNaviEvent.IS_NAVI_SEARCHING, QueryNaviEvent.IS_SPEECH_CRUISE_OPENED};
    }
}
