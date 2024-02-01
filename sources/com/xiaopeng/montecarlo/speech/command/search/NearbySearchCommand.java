package com.xiaopeng.montecarlo.speech.command.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.speech.protocol.node.navi.bean.NearbySearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 10)
/* loaded from: classes3.dex */
public class NearbySearchCommand extends BaseSpeechCommand {
    private static final String EMPTY_STRING = "";
    private static final String SEARCH_RANGE_1KM = "1000";
    private static final String SEARCH_RANGE_2KM = "2000";
    private static final L.Tag TAG = new L.Tag("NearbySearchCommand");
    private XPCoordinate2DDouble mCarLocation;
    private NearbySearchBean mNearbySearchBean;
    @Nullable
    private String mSearchCenter;
    private String mSearchRadius;
    private String mSearchType;
    private boolean mIsExecute = false;
    private double mTargetLon = 0.0d;
    private double mTargetLat = 0.0d;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public NearbySearchCommand(NearbySearchBean nearbySearchBean, XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mSearchRadius = "1000";
        this.mCarLocation = xPCoordinate2DDouble;
        this.mNearbySearchBean = nearbySearchBean;
        this.mSearchRadius = "";
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        if (formatSearchInput()) {
            aroundSearch();
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "empty input, " + this.mNearbySearchBean.getDestination() + " " + this.mNearbySearchBean.getDestinationType());
        NaviSpeechUtils.postNearbyResult(this.mSearchType, null);
        onInterrupt();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        NaviSpeechUtils.postNearbyResult(this.mSearchType, null);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(19, 3);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }

    private boolean formatSearchInput() {
        NearbySearchBean nearbySearchBean = this.mNearbySearchBean;
        if (nearbySearchBean == null) {
            L.w(TAG, "mNearbySearchBean is null");
            return false;
        } else if (RootUtil.isEmptyString(nearbySearchBean.getDestination()) && RootUtil.isEmptyString(this.mNearbySearchBean.getDestinationType())) {
            return false;
        } else {
            this.mSearchCenter = RootUtil.isEmptyString(this.mNearbySearchBean.getDestination()) ? null : this.mNearbySearchBean.getDestination();
            this.mSearchType = RootUtil.isEmptyString(this.mNearbySearchBean.getDestinationType()) ? null : this.mNearbySearchBean.getDestinationType();
            L.Tag tag = TAG;
            L.i(tag, "formatSearchInput mSearchCenter:" + this.mSearchCenter + ",mSearchType:" + this.mSearchType);
            return true;
        }
    }

    private boolean isHomeOrCommany(String str) {
        return ContextUtils.getString(R.string.company).equals(str) || ContextUtils.getString(R.string.home).equals(str);
    }

    private void searchAroundHomeOrCommany(String str) {
        if (ContextUtils.getString(R.string.company).equals(str)) {
            FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
            if (company != null) {
                this.mTargetLon = company.getXPPoiInfo().getDisplayLon();
                this.mTargetLat = company.getXPPoiInfo().getDisplayLat();
            } else {
                L.i(TAG, "company not found");
                onSearchResultGet();
            }
        }
        if (ContextUtils.getString(R.string.home).equals(str)) {
            FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
            if (home != null) {
                this.mTargetLon = home.getXPPoiInfo().getDisplayLon();
                this.mTargetLat = home.getXPPoiInfo().getDisplayLat();
            } else {
                L.i(TAG, "home not found");
                onSearchResultGet();
            }
        }
        this.mSearchRadius = "1000";
        aroundSearch(this.mSearchType, this.mSearchRadius, new XPCoordinate2DDouble(this.mTargetLon, this.mTargetLat), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.NearbySearchCommand.1
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                NearbySearchCommand.this.handleAroundSearchResult(xPSearchResult);
            }
        });
    }

    private void aroundSearch() {
        L.i(TAG, "aroundSearch");
        if (RootUtil.isEmptyString(this.mSearchCenter)) {
            searchSelfAround(this.mSearchType, "1000");
        } else if (isHomeOrCommany(this.mSearchCenter)) {
            searchAroundHomeOrCommany(this.mSearchCenter);
        } else {
            keywordSearch(this.mSearchCenter, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.NearbySearchCommand.2
                @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                public void onResponse(Request request, XPSearchResult xPSearchResult) {
                    NearbySearchCommand.this.handleKeywordSearchResult(xPSearchResult);
                }
            });
        }
    }

    private void searchSelfAround(String str, String str2) {
        L.Tag tag = TAG;
        L.i(tag, "searchSelfAround " + str + " " + str2);
        XPCoordinate2DDouble xPCoordinate2DDouble = this.mCarLocation;
        if (xPCoordinate2DDouble != null) {
            this.mSearchRadius = str2;
            this.mTargetLon = xPCoordinate2DDouble.mLon;
            this.mTargetLat = xPCoordinate2DDouble.mLat;
            aroundSearch(str, this.mSearchRadius, xPCoordinate2DDouble, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.NearbySearchCommand.3
                @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                public void onResponse(Request request, XPSearchResult xPSearchResult) {
                    NearbySearchCommand.this.handleAroundSearchResult(xPSearchResult);
                }
            });
        }
    }

    private void onSearchResultGet() {
        onSearchResultGet(new ArrayList<>());
    }

    private void onSearchResultGet(@NonNull ArrayList<XPPoiInfo> arrayList) {
        if (arrayList.isEmpty()) {
            NaviSpeechUtils.postNearbyResult(this.mSearchType, null);
            return;
        }
        List<PoiBean> xpPoiInfos2PoiBeans = NaviSpeechUtils.xpPoiInfos2PoiBeans(arrayList, this.mCarLocation);
        if (xpPoiInfos2PoiBeans != null) {
            L.Tag tag = TAG;
            L.i(tag, "onSearchResultGet: " + xpPoiInfos2PoiBeans.size());
            SpeechStatProxy.getInstance().sendStatDataForSpeech(19, 2);
        } else {
            L.i(TAG, "onSearchResultGet, poiBeans is null");
            SpeechStatProxy.getInstance().sendStatDataForSpeech(19, 1);
        }
        NaviSpeechUtils.postNearbyResult(this.mSearchType, xpPoiInfos2PoiBeans);
    }

    private void aroundSearch(String str, String str2, XPCoordinate2DDouble xPCoordinate2DDouble, ResponseCallback responseCallback) {
        SearchClient.getInstance().enqueue(new RequestFactory(1).newBuilder().requestId(SearchClient.getInstance().getRequestId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND).keyword(str).radius(str2).poiLocation(xPCoordinate2DDouble).build(), responseCallback);
    }

    private void keywordSearch(String str, ResponseCallback responseCallback) {
        SearchClient.getInstance().enqueue(new RequestFactory(1).newBuilder().requestId(SearchClient.getInstance().getRequestId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD).keyword(str).build(), responseCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleKeywordSearchResult(XPSearchResult xPSearchResult) {
        if (xPSearchResult == null) {
            return;
        }
        List<XPPoiInfo> xPPoiInfos = xPSearchResult.getXPPoiInfos();
        if (xPPoiInfos == null) {
            L.i(TAG, "SEARCH_TYPE_KEYWORD, searchTargetResult is null");
            NaviSpeechUtils.postNearbyResult(this.mSearchType, null);
            onInterrupt();
        } else if (xPPoiInfos.isEmpty()) {
            L.i(TAG, "SEARCH_TYPE_KEYWORD, no search result");
            NaviSpeechUtils.postNearbyResult(this.mSearchType, null);
            onInterrupt();
        } else {
            L.Tag tag = TAG;
            L.i(tag, "aroundSearch 2.keywordAroundSearch size=" + xPPoiInfos.size());
            XPPoiInfo xPPoiInfo = xPPoiInfos.get(0);
            this.mSearchRadius = "1000";
            this.mTargetLon = xPPoiInfo.getDisplayLon();
            this.mTargetLat = xPPoiInfo.getDisplayLat();
            aroundSearch(this.mSearchType, this.mSearchRadius, new XPCoordinate2DDouble(this.mTargetLon, this.mTargetLat), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.NearbySearchCommand.4
                @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                public void onResponse(Request request, XPSearchResult xPSearchResult2) {
                    NearbySearchCommand.this.handleAroundSearchResult(xPSearchResult2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAroundSearchResult(XPSearchResult xPSearchResult) {
        if (xPSearchResult == null) {
            return;
        }
        List<XPPoiInfo> xPPoiInfos = xPSearchResult.getXPPoiInfos();
        if (xPPoiInfos == null) {
            L.Tag tag = TAG;
            L.i(tag, "no search result, last range is " + this.mSearchRadius);
            if ("1000".equals(this.mSearchRadius)) {
                this.mSearchRadius = SEARCH_RANGE_2KM;
                L.Tag tag2 = TAG;
                L.i(tag2, "search again, " + this.mSearchRadius);
                aroundSearch(this.mSearchType, this.mSearchRadius, new XPCoordinate2DDouble(this.mTargetLon, this.mTargetLat), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.NearbySearchCommand.5
                    @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                    public void onResponse(Request request, XPSearchResult xPSearchResult2) {
                        NearbySearchCommand.this.handleAroundSearchResult(xPSearchResult2);
                    }
                });
                return;
            } else if (SEARCH_RANGE_2KM.equals(this.mSearchRadius)) {
                L.i(TAG, "no result in 2km");
                NaviSpeechUtils.postNearbyResult(this.mSearchType, null);
            }
        } else {
            onSearchResultGet(new ArrayList<>(xPPoiInfos));
            L.Tag tag3 = TAG;
            L.i(tag3, "aroundSearch 3.onSearchResultGet" + xPPoiInfos.size());
        }
        this.mIsExecute = true;
    }
}
