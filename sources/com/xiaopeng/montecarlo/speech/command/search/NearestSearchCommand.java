package com.xiaopeng.montecarlo.speech.command.search;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.search.model.SearchNearestParam;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import java.util.List;
@CommandPriority(priority = 10)
@Deprecated
/* loaded from: classes3.dex */
public class NearestSearchCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("NearestSearchCommand");
    Coord2DDouble mCoord2DDouble;
    private boolean mIsExecute = false;
    private ResponseCallback mNearesSearchCallback = new ResponseCallback() { // from class: com.xiaopeng.montecarlo.speech.command.search.NearestSearchCommand.1
        @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
        public void onResponse(Request request, XPSearchResult xPSearchResult) {
            if (xPSearchResult != null) {
                NearestSearchCommand.this.onSearchResult(xPSearchResult.getXPPoiInfos());
            } else {
                L.i(NearestSearchCommand.TAG, "xpSearchResult is null");
            }
            NearestSearchCommand.this.mIsExecute = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchResult(List<XPPoiInfo> list) {
    }

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

    public NearestSearchCommand(SearchNearestParam searchNearestParam) {
        if (searchNearestParam != null) {
            this.mCoord2DDouble = searchNearestParam.poi_loc;
        } else {
            this.mCoord2DDouble = null;
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        nearestSearch();
    }

    private void nearestSearch() {
        if (this.mCoord2DDouble != null) {
            SearchClient.getInstance().enqueue(new RequestFactory(5).newBuilder().requestId(SearchClient.getInstance().getRequestId()).poiLocation(new XPCoordinate2DDouble(this.mCoord2DDouble.lon, this.mCoord2DDouble.lat)).build(), this.mNearesSearchCallback);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }
}
