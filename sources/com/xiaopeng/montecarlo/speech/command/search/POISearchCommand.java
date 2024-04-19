package com.xiaopeng.montecarlo.speech.command.search;

import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
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
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiSearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.WaypointSearchBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@CommandPriority(priority = 10)
/* loaded from: classes3.dex */
public class POISearchCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("POISearchCommand");
    private static final int TYPE_POI_SEARCH = 1;
    private static final int TYPE_WAY_POINT_SEARCH = 2;
    private XPCoordinate2DDouble mCarLocation;
    private String mDestination;
    private boolean mIsSetAsDestination;
    private boolean mIsExecute = false;
    private ResponseCallback mPoiSearchCallback = new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.POISearchCommand.1
        @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
        public void onResponse(Request request, XPSearchResult xPSearchResult) {
            if (xPSearchResult != null) {
                POISearchCommand.this.onSearchResult(xPSearchResult.getXPPoiInfos());
            } else {
                L.i(POISearchCommand.TAG, "xpSearchResult is null");
            }
            POISearchCommand.this.mIsExecute = true;
        }
    };
    private int mSearchType = 1;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public POISearchCommand(WaypointSearchBean waypointSearchBean, XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mCarLocation = xPCoordinate2DDouble;
        if (waypointSearchBean != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(waypointSearchBean.getDestinationName() != null ? waypointSearchBean.getDestinationName() : "");
            sb.append(" ");
            sb.append(waypointSearchBean.getDestinationType() != null ? waypointSearchBean.getDestinationType() : "");
            this.mDestination = sb.toString();
            this.mIsSetAsDestination = waypointSearchBean.isSetAsDestination();
        }
        L.Tag tag = TAG;
        L.i(tag, "waypointSearchBean = " + this.mDestination);
    }

    public POISearchCommand(PoiSearchBean poiSearchBean, XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mCarLocation = xPCoordinate2DDouble;
        StringBuilder sb = new StringBuilder();
        sb.append(poiSearchBean.getDestination() != null ? poiSearchBean.getDestination() : "");
        sb.append(" ");
        sb.append(poiSearchBean.getDestinationType() != null ? poiSearchBean.getDestinationType() : "");
        this.mDestination = sb.toString();
        L.Tag tag = TAG;
        L.i(tag, "poiSearchBean = " + this.mDestination);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        int i = this.mSearchType;
        if (i == 1) {
            keywordSearch();
        } else if (i != 2) {
        } else {
            List<XPViaPoint> viaInfos = NaviSpeechUtils.getViaInfos();
            if (viaInfos != null && viaInfos.size() >= NaviSpeechUtils.getMaxViaSize()) {
                L.i(TAG, "postToAddVia, postWaypointListFull");
                NaviSpeechUtils.postWaypointListFull(this.mDestination);
                onInterrupt();
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, "isExistRoute: " + NaviSpeechUtils.isExistRoute() + " mIsSetAsDestination: " + this.mIsSetAsDestination);
            if (NaviSpeechUtils.isExistRoute()) {
                keywordSearch();
            } else if (this.mIsSetAsDestination) {
                keywordSearch();
            } else {
                NaviSpeechUtils.postWaypointsNotExitRoute(this.mDestination);
                this.mIsExecute = true;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        postResult(this.mDestination, null);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(18, 3);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }

    private void keywordSearch() {
        if (this.mDestination != null) {
            L.Tag tag = TAG;
            L.i(tag, "keywordSearch, mDestination=" + this.mDestination);
            if (handleSpecialAddress()) {
                this.mIsExecute = true;
                return;
            }
            SearchClient.getInstance().enqueue(new RequestFactory(1).newBuilder().requestId(SearchClient.getInstance().getRequestId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD).keyword(this.mDestination).build(), this.mPoiSearchCallback);
        }
    }

    private boolean handleSpecialAddress() {
        FavoriteAddress company;
        FavoriteAddress company2;
        if (this.mDestination == null) {
            return false;
        }
        if (ContextUtils.getString(R.string.company).equals(this.mDestination.trim()) && (company2 = FavoriteDataManager.getInstance().getCompany()) != null) {
            onSearchResult(new ArrayList(Collections.singletonList(company2.getXPPoiInfo())));
            return true;
        } else if (!ContextUtils.getString(R.string.home).equals(this.mDestination.trim()) || (company = FavoriteDataManager.getInstance().getCompany()) == null) {
            return false;
        } else {
            onSearchResult(new ArrayList(Collections.singletonList(company.getXPPoiInfo())));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchResult(List<XPPoiInfo> list) {
        if (list == null) {
            L.i(TAG, "searchResult is null");
            postResult(this.mDestination, null);
            SpeechStatProxy.getInstance().sendStatDataForSpeech(18, 1);
        } else {
            L.Tag tag = TAG;
            L.i(tag, "searchResult.size=" + list.size());
            List<PoiBean> xpPoiInfos2PoiBeans = NaviSpeechUtils.xpPoiInfos2PoiBeans(new ArrayList(list), this.mCarLocation);
            postResult(this.mDestination, xpPoiInfos2PoiBeans);
            if (xpPoiInfos2PoiBeans != null && xpPoiInfos2PoiBeans.isEmpty()) {
                SpeechStatProxy.getInstance().sendStatDataForSpeech(18, 1);
            } else {
                SpeechStatProxy.getInstance().sendStatDataForSpeech(18, 2);
            }
        }
        this.mIsExecute = true;
    }

    private void postResult(String str, List<PoiBean> list) {
        int i = this.mSearchType;
        if (1 == i) {
            NaviSpeechUtils.postPoiResult(str, list);
        } else if (2 == i) {
            NaviSpeechUtils.postWaypointSearchResult(str, list);
        }
    }
}
