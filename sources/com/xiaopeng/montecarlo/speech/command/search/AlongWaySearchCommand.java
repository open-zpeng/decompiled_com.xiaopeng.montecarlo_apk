package com.xiaopeng.montecarlo.speech.command.search;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.speech.protocol.node.navi.bean.NearbySearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 10)
/* loaded from: classes3.dex */
public class AlongWaySearchCommand extends BaseSpeechCommand {
    private static final String SEARCH_RANGE_2KM = "2000";
    private static final L.Tag TAG = new L.Tag("AlongWaySearchCommand");
    private NearbySearchBean mAlongWaySearchBean;
    private XPCoordinate2DDouble mCarLocation;
    private String mKeyword;
    private boolean mIsExecute = false;
    private ResponseCallback mAlongWayCallback = new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.AlongWaySearchCommand.1
        @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
        public void onResponse(Request request, XPSearchResult xPSearchResult) {
            if (xPSearchResult != null) {
                AlongWaySearchCommand.this.onSearchResult(xPSearchResult.getXPPoiInfos());
            }
            AlongWaySearchCommand.this.mIsExecute = true;
        }
    };

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public AlongWaySearchCommand(NearbySearchBean nearbySearchBean, XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mCarLocation = xPCoordinate2DDouble;
        this.mAlongWaySearchBean = nearbySearchBean;
        this.mCarLocation = xPCoordinate2DDouble;
        NearbySearchBean nearbySearchBean2 = this.mAlongWaySearchBean;
        if (nearbySearchBean2 == null) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(31, 3);
            return;
        }
        String destination = nearbySearchBean2.getDestination();
        this.mKeyword = TextUtils.isEmpty(destination) ? this.mAlongWaySearchBean.getDestinationType() : destination;
        L.Tag tag = TAG;
        L.i(tag, "nearbySearchBean=" + nearbySearchBean);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.speech.command.search.AlongWaySearchCommand.2
            @Override // java.lang.Runnable
            public void run() {
                AlongWaySearchCommand.this.alongWaySearch();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        NaviSpeechUtils.postRouteNearbyResult(this.mKeyword, null);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(31, 3);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alongWaySearch() {
        if (NaviSpeechUtils.getCurrentVariantPath() == null) {
            L.i(TAG, "alongWaySearch failed, no route path exist");
            onInterrupt();
            return;
        }
        String mapKeywordToCategoryForAlongWay = SearchServiceWrapper.getInstance().mapKeywordToCategoryForAlongWay(this.mKeyword);
        if (!RootUtil.isEmptyString(mapKeywordToCategoryForAlongWay)) {
            SearchClient.getInstance().enqueue(new RequestFactory(2).newBuilder().requestId(SearchClient.getInstance().getRequestId()).keyword(this.mKeyword).category(mapKeywordToCategoryForAlongWay).orderPolicy("DISTANCE").build(), this.mAlongWayCallback);
            return;
        }
        SearchClient.getInstance().enqueue(new RequestFactory(1).newBuilder().requestId(SearchClient.getInstance().getRequestId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND).keyword(this.mKeyword).radius(SEARCH_RANGE_2KM).poiLocation(this.mCarLocation).build(), this.mAlongWayCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchResult(@Nullable List<XPPoiInfo> list) {
        if (list == null) {
            NaviSpeechUtils.postRouteNearbyResult(this.mKeyword, null);
            SpeechStatProxy.getInstance().sendStatDataForSpeech(31, 3);
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "searchResult.size=" + list.size());
        List<PoiBean> xpPoiInfos2PoiBeans = NaviSpeechUtils.xpPoiInfos2PoiBeans(new ArrayList(list), this.mCarLocation);
        for (PoiBean poiBean : xpPoiInfos2PoiBeans) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "poiResultBeans: " + poiBean);
            }
        }
        NaviSpeechUtils.postRouteNearbyResult(this.mKeyword, xpPoiInfos2PoiBeans);
        if (xpPoiInfos2PoiBeans.isEmpty()) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(31, 1);
        } else {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(31, 2);
        }
    }
}
