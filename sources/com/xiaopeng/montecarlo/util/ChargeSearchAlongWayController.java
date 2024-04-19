package com.xiaopeng.montecarlo.util;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.AiMsgUtils;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchResultBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.CPSearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChargeSearchAlongWayController implements BaseCallBack<SearchRequestParam, SearchResultData> {
    private static final L.Tag TAG = new L.Tag("CSAController");
    private final MainContext mMainContext;
    private final SearchDataProvider mSearchDataProvider = new SearchDataProvider();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull SearchResultData searchResultData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(SearchRequestParam searchRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(SearchRequestParam searchRequestParam) {
    }

    public ChargeSearchAlongWayController(MainContext mainContext) {
        this.mMainContext = mainContext;
    }

    public void alongWayChargeSearch() {
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "TBTManager current status: " + currentStatus);
        }
        if (duringNavOrExplore()) {
            doSearch();
        } else {
            doException();
        }
    }

    private boolean duringNavOrExplore() {
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        return 1 == currentStatus || 2 == currentStatus;
    }

    public void checkScene(IBaseScene iBaseScene) {
        if (iBaseScene == null) {
            return;
        }
        iBaseScene.removeAllChildScene();
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        if (1 == currentStatus || 2 == currentStatus) {
            StatusConst.Mode mode = 1 == currentStatus ? StatusConst.Mode.NAVI : StatusConst.Mode.EXPLORE;
            if (StatusConst.Mode.EXPLORE == iBaseScene.getMode() || StatusConst.Mode.NAVI == iBaseScene.getMode()) {
                return;
            }
            iBaseScene.backToLastMode(mode, false);
            return;
        }
        doException();
    }

    private void doException() {
        AiMsgUtils.getInstance().setNeedChargeSearchWhenRestore(false);
        this.mMainContext.showPrompt(ContextUtils.getString(R.string.ai_push_charge_search_scene_exception));
        if (L.ENABLE) {
            L.e(TAG, "TBTManager obtain status is not NAVIGATION_STATUS or EXPLORE_STATUS");
        }
    }

    private void doSearch() {
        String string = ContextUtils.getString(R.string.search_category_charge);
        CarLoc carLocation = this.mMainContext.getMapView().getBizControlManager().getCarLocation();
        GeneralChargeRequestParam generalChargeRequestParam = new GeneralChargeRequestParam();
        if (carLocation != null && carLocation.vecPathMatchInfo != null && carLocation.vecPathMatchInfo.size() > 0) {
            generalChargeRequestParam.setLng(carLocation.vecPathMatchInfo.get(0).longitude);
            generalChargeRequestParam.setLat(carLocation.vecPathMatchInfo.get(0).latitude);
        }
        generalChargeRequestParam.setQuery(string);
        generalChargeRequestParam.setDetail(true);
        generalChargeRequestParam.setOrder("DISTANCE");
        generalChargeRequestParam.setSize(20);
        generalChargeRequestParam.setIndex(0);
        CPSearchRequestParam cPSearchRequestParam = new CPSearchRequestParam(generalChargeRequestParam);
        cPSearchRequestParam.setSearchType(6);
        this.mSearchDataProvider.searchChargeAlongWay(cPSearchRequestParam, this);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "doSearch param:" + generalChargeRequestParam);
        }
    }

    private void handleSearchChargeResult(@NonNull SearchResultData searchResultData) {
        ArrayList<XPPoiInfo> list = searchResultData != null ? searchResultData.getSearchResponseEvent().getList() : null;
        if (CollectionUtils.isEmpty(list)) {
            this.mMainContext.showPrompt(R.string.ai_push_charge_search_no_result);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_MODE, 103);
        bundle.putParcelableArrayList("search_result", new ArrayList<>(list));
        this.mMainContext.startScene(new SearchResultBridge().setBundle(bundle), 0);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull SearchResultData searchResultData) {
        if (searchResultData.getSearchType() != 6) {
            return;
        }
        handleSearchChargeResult(searchResultData);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onError: " + i + " errorMessage: " + str);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        MainContext mainContext = this.mMainContext;
        return mainContext != null && mainContext.getCurrentScene().isSceneLegal();
    }
}
