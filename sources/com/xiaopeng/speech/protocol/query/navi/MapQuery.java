package com.xiaopeng.speech.protocol.query.navi;

import com.xiaopeng.speech.SpeechQuery;
import com.xiaopeng.speech.annotation.QueryAnnotation;
import com.xiaopeng.speech.protocol.event.query.QueryNaviEvent;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
/* loaded from: classes3.dex */
public class MapQuery extends SpeechQuery<IMapQueryCaller> {
    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.is.cruise")
    public boolean isCruise(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isCruise();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.is.explore.path")
    public boolean isExplorePath(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isExplorePath();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.is.navigation")
    public boolean isNavigation(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isNavigation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.common.addr.get")
    public String getAddress(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getCommonAddress(AddressBean.fromJson(str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.get.navigation.info")
    public String getNavigationInfo(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getNavigationInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.is.zoomin.max")
    public boolean isZoominMax(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isZoominMax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.is.zoomout.min")
    public boolean isZoomoutMax(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isZoomoutMin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.is.calculate.path")
    public boolean isCalculatePath(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isCalculatePath();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.favorite.open.status")
    public int getFavoriteOpenStatus(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getFavoriteOpenStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.open.controls.status")
    public int getOpenControlStatus(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getOpenControlStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.main.road.status")
    public int getSwitchMainRoadStatus(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getSwitchMainRoadStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.side.road.status")
    public int getSwitchSideRoadStatus(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getSwitchSideRoadStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.scale.current.level")
    public int getCurrentScaleLevel(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getCurrentScaleLevel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryNaviEvent.GET_POI_DETAILS_FAVORITE_STATUS)
    public int getPoiDetailsFavoriteStatus(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getPoiDetailsFavoriteStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = "navi.is.sr")
    public boolean isSRMap(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isSRMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryNaviEvent.CONTEXT_INFO_LIST_TOP)
    public int getListTop(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getListTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryNaviEvent.CONTEXT_INFO_LIST_BOTTOM)
    public int getListBottom(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getListBottom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryNaviEvent.CONTEXT_INFO_LIST_ONEPAGE)
    public int getListPageInfo(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).getListPageInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryNaviEvent.IS_ACCOUNT_LOGIN)
    public boolean isAccountLogin(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isGaodeLogin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryNaviEvent.IS_NAVI_SEARCHING)
    public boolean isNaviSearching(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isNaviSearching();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryNaviEvent.IS_SPEECH_CRUISE_OPENED)
    public boolean isNaviSpeechCruiseOpened(String str, String str2) {
        return ((IMapQueryCaller) this.mQueryCaller).isNaviSpeechCruiseOpened();
    }
}
