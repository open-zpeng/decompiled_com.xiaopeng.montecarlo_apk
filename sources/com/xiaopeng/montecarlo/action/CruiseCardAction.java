package com.xiaopeng.montecarlo.action;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchResultBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDetailSearchRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.ChargeSearchByOneResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviDetailSearchResponse;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchKeywordParam;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.KeywordQueryRequest;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.searchscene.PresenterData;
import com.xiaopeng.montecarlo.util.BundleUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.dialog.XLandLoadingDialog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class CruiseCardAction implements IIntentAction {
    private static final String PATH_SERARCH_CATEGORY = "/search/category";
    private static final String PATH_SERARCH_MAIN = "/search/main";
    private static final L.Tag TAG = new L.Tag("CruiseCardAction");
    private static final AtomicBoolean mShowSearchAvailable = new AtomicBoolean(true);
    private static long sLastAcceptTime;
    private IChargeStationSearchService mChargeSearch = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private INaviSearchService mNaviSearchService = (INaviSearchService) HttpClientManager.getInstance().getService(INaviSearchService.class);
    private XLandLoadingDialog mXLoadingDialog;

    @Override // com.xiaopeng.montecarlo.action.IIntentAction
    public boolean handlerIntentAction(IIntentActionContext iIntentActionContext, Intent intent) {
        if (iIntentActionContext != null) {
            if (intent == null) {
                throw new IllegalArgumentException("Intent is null");
            }
            final MainContext mainContext = iIntentActionContext.getMainContext();
            if (mainContext == null) {
                L.w(TAG, "mainContext is null");
                return false;
            }
            final MapViewWrapper mapView = mainContext.getMapView();
            if (mapView == null) {
                L.w(TAG, "mapViewWrapper is null");
                return false;
            }
            final Uri parse = Uri.parse(intent.getStringExtra(IntentActions.ActionsKey.KEY_URI));
            if (mapView.isMapSurfaceCreate()) {
                return showSearch(parse, mainContext);
            }
            L.w(TAG, "map Surface is not created， try later");
            WorkThreadUtil.getInstance().executeScheduledBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.action.CruiseCardAction.1
                @Override // java.lang.Runnable
                public void run() {
                    if (mapView.isMapSurfaceCreate()) {
                        CruiseCardAction.this.showSearch(parse, mainContext);
                    } else {
                        L.w(CruiseCardAction.TAG, "map Surface is still not created， failed");
                    }
                }
            }, 200L, TimeUnit.MILLISECONDS);
            return false;
        }
        throw new IllegalArgumentException("IIntentActionContext is null ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
        if (r8.equals(com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory.SEARCH_CATEGORY_CHARGE) != false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean showSearch(android.net.Uri r8, com.xiaopeng.montecarlo.base.MainContext r9) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.action.CruiseCardAction.showSearch(android.net.Uri, com.xiaopeng.montecarlo.base.MainContext):boolean");
    }

    private void showLoading(MainContext mainContext) {
        final Activity currentActivity = mainContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.action.CruiseCardAction.3
            @Override // java.lang.Runnable
            public void run() {
                if (CruiseCardAction.this.mXLoadingDialog == null) {
                    CruiseCardAction.this.mXLoadingDialog = new XLandLoadingDialog(currentActivity);
                    CruiseCardAction.this.mXLoadingDialog.setMessage(ContextUtils.getString(R.string.dialog_loading_message));
                    CruiseCardAction.this.mXLoadingDialog.setCanceledOnTouchOutside(true);
                }
                if (CruiseCardAction.this.mXLoadingDialog.isShowing()) {
                    return;
                }
                L.i(CruiseCardAction.TAG, "showLoading");
                CruiseCardAction.this.mXLoadingDialog.show();
                CruiseCardAction.this.mXLoadingDialog.correctedLocation();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading(MainContext mainContext) {
        Activity currentActivity = mainContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.action.CruiseCardAction.4
            @Override // java.lang.Runnable
            public void run() {
                if (CruiseCardAction.this.mXLoadingDialog == null || !CruiseCardAction.this.mXLoadingDialog.isShowing()) {
                    return;
                }
                L.i(CruiseCardAction.TAG, "hideLoading");
                CruiseCardAction.this.mXLoadingDialog.dismiss();
            }
        });
    }

    private void startKeywordSearch(final MainContext mainContext, final String str, final String str2) {
        showLoading(mainContext);
        RequestFactory requestFactory = new RequestFactory(1);
        int requestId = SearchClient.getInstance().getRequestId();
        SearchClient.getInstance().execute(requestFactory.newBuilder().requestId(requestId).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD).keyword(str).category(str2).poiLocation(TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation()).build(), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.action.CruiseCardAction.5
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                List<XPPoiInfo> xPPoiInfos = xPSearchResult != null ? xPSearchResult.getXPPoiInfos() : null;
                if (CollectionUtils.isEmpty(xPPoiInfos)) {
                    CruiseCardAction.this.hideLoading(mainContext);
                    return;
                }
                if (Utils.isFoodOpen() && XPPoiCategory.SEARCH_CATEGORY_FOOD.equals(str2)) {
                    CruiseCardAction.this.startFoodSearch(mainContext, xPPoiInfos);
                }
                if (!(request instanceof KeywordQueryRequest)) {
                    L.w(CruiseCardAction.TAG, "request error");
                    return;
                }
                KeywordQueryRequest keywordQueryRequest = (KeywordQueryRequest) request;
                keywordQueryRequest.nextPage();
                XPSearchKeywordParam keywordParam = keywordQueryRequest.getKeywordParam();
                if (keywordParam == null) {
                    return;
                }
                keywordParam.setKeywords(str);
                CruiseCardAction.this.doJumpSearchResultScene(mainContext, new BundleUtil().searchBundleToBundle(new PresenterData.Builder().searchMode(104).searchType(4).searchResult(new ArrayList<>(xPPoiInfos)).searchKeywordText(str).searchResultSearchParams(keywordParam).build()));
            }
        });
    }

    private void startChargeSearch(MainContext mainContext, String str, String str2) {
        if (mainContext == null || mainContext.getMapView() == null || mainContext.getMapView().getLonLatFromCenter() == null) {
            return;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble(mainContext.getMapView().getLonLatFromCenter());
        showLoading(mainContext);
        ChargeSearchByOneResponse searchByOne = this.mChargeSearch.searchByOne(new ChargeSearchByOneRequest().setQuery(str).setLng(new DecimalFormat("#.000000").format(xPCoordinate2DDouble.mLon)).setLat(new DecimalFormat("#.000000").format(xPCoordinate2DDouble.mLat)).setRadius(10000).setOrder("DISTANCE").setDetail(true).setSize(50).setIndex(0));
        if (searchByOne != null) {
            List<XPPoiInfo> fetchXPPoiInfoListFromSearchByOneResponse = HttpResponseConverter.fetchXPPoiInfoListFromSearchByOneResponse(searchByOne);
            if (!CollectionUtils.isEmpty(fetchXPPoiInfoListFromSearchByOneResponse)) {
                Bundle bundle = new Bundle();
                bundle.putInt(SearchBridge.SEARCH_MODE, 104);
                bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, str);
                bundle.putParcelableArrayList("search_result", new ArrayList<>(fetchXPPoiInfoListFromSearchByOneResponse));
                doJumpSearchResultScene(mainContext, bundle);
                return;
            }
            startKeywordSearch(mainContext, str, str2);
            return;
        }
        startKeywordSearch(mainContext, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<XPPoiInfo> startFoodSearch(MainContext mainContext, List<XPPoiInfo> list) {
        XPPoiInfo xPPoiInfo;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        boolean z = size > 20;
        int i = z ? 20 : size;
        for (int i2 = 0; i2 < i; i2++) {
            XPPoiInfo xPPoiInfo2 = list.get(i2);
            if (xPPoiInfo2 != null) {
                linkedHashMap.put(xPPoiInfo2.getPoiId(), xPPoiInfo2);
                if (115 == xPPoiInfo2.getCategory()) {
                    arrayList.add(new NaviDetailSearchRequest.PoiIdInfoForDetailRequest().setId(xPPoiInfo2.getPoiId()).setSource(1));
                }
            }
        }
        ArrayList arrayList2 = z ? new ArrayList(list.subList(20, size)) : null;
        if (CollectionUtils.isNotEmpty(arrayList)) {
            NaviDetailSearchResponse detailList = this.mNaviSearchService.detailList(new NaviDetailSearchRequest().setPoiIdList(arrayList).setCurrentLocation(null));
            if (detailList != null && !CollectionUtils.isEmpty(detailList.getData())) {
                for (XPPoiInfo xPPoiInfo3 : HttpResponseConverter.fetchXPPoiInfoListFromNaviDetailSearchResponse(detailList)) {
                    if (xPPoiInfo3 != null && (xPPoiInfo = (XPPoiInfo) linkedHashMap.get(xPPoiInfo3.getPoiId())) != null) {
                        xPPoiInfo.setPrice(xPPoiInfo3.getPrice());
                        xPPoiInfo.setRating(xPPoiInfo3.getRating());
                        xPPoiInfo.setImageUrlList(xPPoiInfo3.getImageUrlList());
                        linkedHashMap.put(xPPoiInfo3.getPoiId(), xPPoiInfo);
                    }
                }
                ArrayList arrayList3 = new ArrayList(linkedHashMap.values());
                if (arrayList2 != null && !CollectionUtils.isEmpty(arrayList2)) {
                    arrayList3.addAll(arrayList2);
                }
                if (!CollectionUtils.isEmpty(arrayList3)) {
                    return arrayList3;
                }
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJumpSearchResultScene(MainContext mainContext, final Bundle bundle) {
        hideLoading(mainContext);
        final IBaseScene currentScene = mainContext.getCurrentScene();
        if (currentScene == null || !mShowSearchAvailable.get()) {
            return;
        }
        mShowSearchAvailable.set(false);
        clearScene(currentScene);
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.action.CruiseCardAction.6
            @Override // java.lang.Runnable
            public void run() {
                currentScene.startScene(new SearchResultBridge().setBundle(bundle));
                CruiseCardAction.mShowSearchAvailable.set(true);
            }
        }, 350L);
    }

    private void clearScene(IBaseScene iBaseScene) {
        if (StatusConst.Mode.NAVI == iBaseScene.getMode() || StatusConst.Mode.EXPLORE == iBaseScene.getMode()) {
            AbstractBasePresenter presenter = iBaseScene.getPresenter();
            if (presenter == null || !(presenter instanceof BaseNaviPresenter)) {
                return;
            }
            TBTManager.getInstance().stopNavi(true);
            try {
                Thread.sleep(700L);
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        iBaseScene.backToMode(StatusConst.Mode.CRUISE, false);
    }

    private boolean acceptAction(int i) {
        boolean z = System.currentTimeMillis() - sLastAcceptTime >= ((long) i);
        sLastAcceptTime = System.currentTimeMillis();
        return z;
    }
}
