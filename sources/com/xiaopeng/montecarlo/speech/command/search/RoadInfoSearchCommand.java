package com.xiaopeng.montecarlo.speech.command.search;

import android.text.Html;
import androidx.annotation.Nullable;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiSearchBean;
import java.util.List;
@CommandPriority(priority = 10)
@Deprecated
/* loaded from: classes3.dex */
public class RoadInfoSearchCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("RoadInfoSearchCommand");
    PoiSearchBean mPoiSearchBean;
    private boolean mIsExecute = false;
    private ResponseCallback mRoadInfoCallback = new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.RoadInfoSearchCommand.1
        @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
        public void onResponse(Request request, XPSearchResult xPSearchResult) {
            RoadInfoSearchCommand.this.onSearchResult(xPSearchResult);
            RoadInfoSearchCommand.this.mIsExecute = true;
        }
    };

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public RoadInfoSearchCommand(PoiSearchBean poiSearchBean) {
        this.mPoiSearchBean = poiSearchBean;
        L.Tag tag = TAG;
        L.i(tag, "mPoiSearchBean=" + poiSearchBean);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        keywordSearch();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }

    private void keywordSearch() {
        if (this.mPoiSearchBean != null) {
            SearchClient.getInstance().enqueue(new RequestFactory(1).newBuilder().requestId(SearchClient.getInstance().getRequestId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD).keyword(this.mPoiSearchBean.getDestination()).build(), this.mRoadInfoCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchResult(XPSearchResult xPSearchResult) {
        if (xPSearchResult == null) {
            List<XPPoiInfo> xPPoiInfos = xPSearchResult.getXPPoiInfos();
            if (xPPoiInfos == null) {
                postRoadInfoResult(null);
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, "searchResult.size=" + xPPoiInfos.size());
            if (xPPoiInfos.isEmpty()) {
                return;
            }
            String roadInfo = xPPoiInfos.get(0).getRoadInfo();
            if (roadInfo == null) {
                postRoadInfoResult(null);
            } else {
                postRoadInfoResult(formatRoadInfo(roadInfo));
            }
        }
    }

    @Nullable
    private String formatRoadInfo(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String replace = Html.fromHtml(str).toString().replace(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR, FDManager.LINE_SEPERATOR);
        String[] split = str.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        for (int i = 0; i < split.length; i++) {
            split[i].substring(split[i].indexOf("\">") + 2, split[i].indexOf("</font>"));
            replace = replace.replace("->", "到");
        }
        return replace;
    }

    private void postRoadInfoResult(String str) {
        L.Tag tag = TAG;
        L.i(tag, "postRoadInfoResult, roadInfo: " + str);
    }
}
