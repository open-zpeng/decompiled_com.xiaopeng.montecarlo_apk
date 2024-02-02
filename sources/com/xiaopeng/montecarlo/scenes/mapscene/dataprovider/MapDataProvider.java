package com.xiaopeng.montecarlo.scenes.mapscene.dataprovider;

import android.graphics.Point;
import android.text.TextUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.CPDataHelper;
import com.xiaopeng.montecarlo.navcore.database.ScratchSpotDataHelper;
import com.xiaopeng.montecarlo.navcore.database.ServiceCenterDataHelper;
import com.xiaopeng.montecarlo.navcore.database.VPADataHelper;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeCache;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeCacheInfo;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class MapDataProvider extends BaseDataProvider<MapSceneResultData, MapSceneRequestParam, BaseCallBack> {
    private static final int DISTANCE_UPDATE_CHARGE = 270;
    public static final int MAP_LEVEL_SHOW_CP = 10;
    private static final int QUERY_CP_DELAY = 1000;
    private static final boolean QUERY_GROUP_POINT_DETAIL = true;
    private static final int SCREEN_MAX_CP = 50;
    private static final L.Tag TAG = new L.Tag("MapDataProvider");
    private IMapDataCallBack mCallBack;
    private int mLastMapLevel;
    private XPCoordinate2DDouble mLastCarLocation = new XPCoordinate2DDouble();
    private XPCoordinate2DDouble mLastCenterLocation = new XPCoordinate2DDouble();
    private ChargeCache mChargeCache = new ChargeCache();
    private PublishSubject<MapSceneRequestParam> mPublishSubject = null;
    private Disposable mChargeDisposable = null;
    private IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return "";
    }

    public MapDataProvider(IMapDataCallBack iMapDataCallBack) {
        this.mCallBack = iMapDataCallBack;
        init();
    }

    public void deInit() {
        if (this.mPublishSubject != null) {
            this.mPublishSubject = null;
        }
        Disposable disposable = this.mChargeDisposable;
        if (disposable != null) {
            disposable.dispose();
            this.mChargeDisposable = null;
        }
    }

    public void init() {
        this.mPublishSubject = PublishSubject.create();
        this.mChargeDisposable = this.mPublishSubject.filter(new Predicate<MapSceneRequestParam>() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapDataProvider.2
            @Override // io.reactivex.functions.Predicate
            public boolean test(MapSceneRequestParam mapSceneRequestParam) throws Exception {
                if (L.ENABLE) {
                    L.d(MapDataProvider.TAG, "test filter");
                }
                return MapDataProvider.this.doFilterPre(mapSceneRequestParam);
            }
        }).debounce(1000L, TimeUnit.MILLISECONDS).subscribe(new Consumer<MapSceneRequestParam>() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapDataProvider.1
            @Override // io.reactivex.functions.Consumer
            public void accept(MapSceneRequestParam mapSceneRequestParam) throws Exception {
                if (L.ENABLE) {
                    L.d(MapDataProvider.TAG, "accept doFetchData");
                }
                MapDataProvider.this.queryChargeDB(mapSceneRequestParam.getQueryBox(), mapSceneRequestParam.getScaleLevel());
            }
        });
    }

    public void initFavoriteOverlay() {
        if (L.ENABLE) {
            L.d(TAG, "initFavoriteOverlay");
        }
        MapSceneRequestParam mapSceneRequestParam = new MapSceneRequestParam();
        mapSceneRequestParam.setSearchType(4);
        doFetchData(mapSceneRequestParam, this.mCallBack);
    }

    public void updateVPAOverlay(Coord2DDouble[] coord2DDoubleArr, int i) {
        if (L.ENABLE) {
            L.d(TAG, "updateVPAOverlay");
        }
        if (coord2DDoubleArr == null) {
            if (L.ENABLE) {
                L.d(TAG, "updateVPAOverlay param error");
                return;
            }
            return;
        }
        MapSceneRequestParam mapSceneRequestParam = new MapSceneRequestParam();
        mapSceneRequestParam.setSearchType(5);
        mapSceneRequestParam.setQueryBox(coord2DDoubleArr);
        mapSceneRequestParam.setScaleLevel(i);
        doFetchData(mapSceneRequestParam, this.mCallBack);
    }

    public void queryChargeDBPre(Coord2DDouble[] coord2DDoubleArr, int i) {
        if (L.ENABLE) {
            L.d(TAG, "queryChargeDBPre");
        }
        if (coord2DDoubleArr == null || this.mPublishSubject == null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "queryChargeDBPre error mPublishSubject:" + this.mPublishSubject);
                return;
            }
            return;
        }
        MapSceneRequestParam mapSceneRequestParam = new MapSceneRequestParam();
        mapSceneRequestParam.setSearchType(0);
        mapSceneRequestParam.setQueryBox(coord2DDoubleArr);
        mapSceneRequestParam.setScaleLevel(i);
        this.mPublishSubject.onNext(mapSceneRequestParam);
    }

    public void queryChargeDB(Coord2DDouble[] coord2DDoubleArr, int i) {
        if (L.ENABLE) {
            L.d(TAG, "queryChargeDB");
        }
        if (coord2DDoubleArr == null) {
            if (L.ENABLE) {
                L.d(TAG, "queryChargeDB param error");
                return;
            }
            return;
        }
        this.mLastCarLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        this.mLastCenterLocation = new XPCoordinate2DDouble(this.mCallBack.getLonLatFromCenter());
        MapSceneRequestParam mapSceneRequestParam = new MapSceneRequestParam();
        mapSceneRequestParam.setSearchType(1);
        mapSceneRequestParam.setQueryBox(coord2DDoubleArr);
        mapSceneRequestParam.setScaleLevel(i);
        doFetchData(mapSceneRequestParam, this.mCallBack);
    }

    public void queryCloud(List<XPPoiInfo> list, int i) {
        if (L.ENABLE) {
            L.d(TAG, "queryCloud");
        }
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        MapSceneRequestParam mapSceneRequestParam = new MapSceneRequestParam();
        mapSceneRequestParam.setSearchType(3);
        mapSceneRequestParam.setQueryList(list);
        mapSceneRequestParam.setScaleLevel(i);
        doFetchData(mapSceneRequestParam, this.mCallBack);
    }

    private List<XPPoiInfo> queryCacheAndFilter(List<XPPoiInfo> list) {
        if (L.ENABLE) {
            L.d(TAG, "queryCacheAndFilter");
        }
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        List<XPPoiInfo> filterInScreenCP = filterInScreenCP(list);
        for (XPPoiInfo xPPoiInfo : filterInScreenCP) {
            ChargeCacheInfo value = this.mChargeCache.getValue(xPPoiInfo.getPoiId());
            if (value != null && System.currentTimeMillis() - value.getUpdateTime() < this.mCallBack.getChargeUpdateInterval()) {
                try {
                    xPPoiInfo.getXPDeepInfoPoi().getChargeData()[0].setNumFastFree(value.getFastFreeNums());
                    xPPoiInfo.getXPDeepInfoPoi().getChargeData()[0].setNumSlowFree(value.getSlowFreeNums());
                    xPPoiInfo.getXPDeepInfoPoi().getChargeData()[0].setAllXpPile(value.isAllXpPile());
                    xPPoiInfo.getXPDeepInfoPoi().getChargeData()[0].setFreeStation(value.isFreeStation());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return filterInScreenCP;
    }

    private List<XPPoiInfo> updateAndQueryCache(List<XPPoiInfo> list, List<XPPoiInfo> list2) {
        if (L.ENABLE) {
            L.d(TAG, "updateAndQueryCache");
        }
        if (CollectionUtils.isEmpty(list2)) {
            return list;
        }
        for (XPPoiInfo xPPoiInfo : list2) {
            if (xPPoiInfo != null) {
                this.mChargeCache.putValue(xPPoiInfo.getPoiId(), ChargeCacheInfo.parse(xPPoiInfo));
            }
        }
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        HashMap hashMap = new HashMap();
        for (XPPoiInfo xPPoiInfo2 : list) {
            if (xPPoiInfo2 != null) {
                hashMap.put(xPPoiInfo2.getPoiId(), xPPoiInfo2);
            }
        }
        for (XPPoiInfo xPPoiInfo3 : list2) {
            if (xPPoiInfo3 != null && hashMap.containsKey(xPPoiInfo3.getPoiId())) {
                hashMap.put(xPPoiInfo3.getPoiId(), xPPoiInfo3);
            }
        }
        Collection<? extends XPPoiInfo> values = hashMap.values();
        list.clear();
        list.addAll(values);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(MapSceneRequestParam mapSceneRequestParam) throws DataProviderException {
        if (mapSceneRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        int searchType = mapSceneRequestParam.getSearchType();
        if (searchType == 0 || searchType == 1) {
            return fetchDBResult(mapSceneRequestParam);
        }
        if (searchType != 3) {
            if (searchType == 5) {
                return fetchVPAPoint(mapSceneRequestParam);
            }
            L.Tag tag = TAG;
            L.w(tag, "param type error:" + mapSceneRequestParam.getSearchType());
            return null;
        }
        return fetchCloudResult(mapSceneRequestParam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public void onFetchError(Throwable th, MapSceneRequestParam mapSceneRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "onFetchError");
        }
        if (th != null) {
            L.Tag tag = TAG;
            L.w(tag, "throwable:" + th.getMessage());
        }
        if (mapSceneRequestParam == null) {
            L.w(TAG, "param is null");
        }
    }

    private DataProviderResponse<MapSceneResultData> fetchDBResult(MapSceneRequestParam mapSceneRequestParam) throws DataProviderException {
        if (L.ENABLE) {
            L.d(TAG, "fetchDBResult");
        }
        if (mapSceneRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        ArrayList arrayList = new ArrayList();
        List<XPPoiInfo> query = CPDataHelper.query(mapSceneRequestParam.getQueryBox(), mapSceneRequestParam.getScaleLevel(), this.mCallBack.isChargeEnabled());
        List<XPPoiInfo> query2 = ServiceCenterDataHelper.query(mapSceneRequestParam.getQueryBox(), mapSceneRequestParam.getScaleLevel(), true);
        if (CollectionUtils.isNotEmpty(query)) {
            arrayList.addAll(query);
        }
        if (CollectionUtils.isNotEmpty(query2)) {
            arrayList.addAll(query2);
        }
        if (CommonUtil.isScratchSpotEnable()) {
            int scaleLevel = mapSceneRequestParam.getScaleLevel();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "scaleLevel:" + scaleLevel);
            }
            if (scaleLevel >= 16 && scaleLevel <= 19) {
                List<XPPoiInfo> query3 = ScratchSpotDataHelper.query(mapSceneRequestParam.getQueryBox());
                if (CollectionUtils.isNotEmpty(query3)) {
                    arrayList.addAll(query3);
                }
            }
        }
        List<XPPoiInfo> queryCacheAndFilter = queryCacheAndFilter(arrayList);
        DataProviderResponse<MapSceneResultData> dataProviderResponse = new DataProviderResponse<>();
        MapSceneResultData mapSceneResultData = new MapSceneResultData();
        mapSceneResultData.setSearchType(mapSceneRequestParam.getSearchType());
        mapSceneResultData.setList(queryCacheAndFilter);
        mapSceneResultData.setScaleLevel(mapSceneRequestParam.getScaleLevel());
        dataProviderResponse.setResultData(mapSceneResultData);
        return dataProviderResponse;
    }

    private DataProviderResponse<MapSceneResultData> fetchVPAPoint(MapSceneRequestParam mapSceneRequestParam) throws DataProviderException {
        if (L.ENABLE) {
            L.d(TAG, "fetchVPAPoint");
        }
        if (mapSceneRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        List<XPPoiInfo> query = VPADataHelper.query(mapSceneRequestParam.getQueryBox());
        DataProviderResponse<MapSceneResultData> dataProviderResponse = new DataProviderResponse<>();
        MapSceneResultData mapSceneResultData = new MapSceneResultData();
        mapSceneResultData.setSearchType(mapSceneRequestParam.getSearchType());
        mapSceneResultData.setList(query);
        mapSceneResultData.setScaleLevel(mapSceneRequestParam.getScaleLevel());
        dataProviderResponse.setResultData(mapSceneResultData);
        return dataProviderResponse;
    }

    private DataProviderResponse<MapSceneResultData> fetchCloudResult(MapSceneRequestParam mapSceneRequestParam) throws DataProviderException {
        if (L.ENABLE) {
            L.d(TAG, "fetchCloudResult");
        }
        if (mapSceneRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        List<XPPoiInfo> queryList = mapSceneRequestParam.getQueryList();
        if (CollectionUtils.isEmpty(queryList)) {
            throw new DataProviderException("query cloud list is null");
        }
        StringBuilder sb = new StringBuilder();
        for (XPPoiInfo xPPoiInfo : queryList) {
            if (XPPoiCategory.isCharge(xPPoiInfo.getCategory())) {
                ChargeCacheInfo value = this.mChargeCache.getValue(xPPoiInfo.getPoiId());
                if (value == null) {
                    sb.append(xPPoiInfo.getPoiId());
                    if (queryList.indexOf(xPPoiInfo) < queryList.size() - 1) {
                        sb.append(",");
                    }
                } else if (System.currentTimeMillis() - value.getUpdateTime() > this.mCallBack.getChargeUpdateInterval()) {
                    sb.append(xPPoiInfo.getPoiId());
                    if (queryList.indexOf(xPPoiInfo) < queryList.size() - 1) {
                        sb.append(",");
                    }
                    this.mChargeCache.remove(xPPoiInfo.getPoiId());
                }
            }
        }
        List<XPPoiInfo> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(sb.toString())) {
            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            arrayList = HttpResponseConverter.fetchXPPoiInfoListFromSearchByOneResponse(this.mChargeStationSearchService.searchByOne(new ChargeSearchByOneRequest().setLat(new DecimalFormat("#.00000").format(currentLocation.mLat)).setLng(new DecimalFormat("#.00000").format(currentLocation.mLon)).setDetail(false).setStationIds(sb.toString())));
        }
        List<XPPoiInfo> updateAndQueryCache = updateAndQueryCache(queryList, arrayList);
        DataProviderResponse<MapSceneResultData> dataProviderResponse = new DataProviderResponse<>();
        MapSceneResultData mapSceneResultData = new MapSceneResultData();
        mapSceneResultData.setSearchType(mapSceneRequestParam.getSearchType());
        mapSceneResultData.setList(updateAndQueryCache);
        mapSceneResultData.setScaleLevel(mapSceneRequestParam.getScaleLevel());
        dataProviderResponse.setResultData(mapSceneResultData);
        return dataProviderResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a8, code lost:
        if (java.lang.Math.sqrt((r4 * r4) + (r8 * r8)) > 270.0d) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean doFilterPre(com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapSceneRequestParam r11) {
        /*
            r10 = this;
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r0 = r10.mCallBack
            r1 = 0
            if (r0 == 0) goto Ld8
            if (r11 != 0) goto L9
            goto Ld8
        L9:
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapStatus r0 = r0.getMapStatus()
            if (r0 != 0) goto L10
            return r1
        L10:
            int r0 = r0.getLevel()
            int r2 = r10.mLastMapLevel
            r3 = 1
            r4 = 10
            if (r2 == r0) goto L27
            if (r0 < r4) goto L20
        L1d:
            r1 = r3
            goto Lb9
        L20:
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r11 = r10.mCallBack
            r11.removeChargeDecorator()
            goto Lb9
        L27:
            if (r0 < r4) goto Lb9
            com.xiaopeng.montecarlo.navcore.xptbt.TBTManager r2 = com.xiaopeng.montecarlo.navcore.xptbt.TBTManager.getInstance()
            com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper r2 = r2.getPosServiceWrapper()
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r2 = r2.getCurrentLocation()
            if (r2 == 0) goto Lb8
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r4 = r10.mLastCarLocation
            if (r4 != 0) goto L3d
            goto Lb8
        L3d:
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r4 = r10.mCallBack
            android.graphics.Point r2 = r4.lonLatToPoint(r2)
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r4 = r10.mCallBack
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r5 = r10.mLastCarLocation
            android.graphics.Point r4 = r4.lonLatToPoint(r5)
            int r5 = r2.x
            int r6 = r4.x
            int r5 = r5 - r6
            int r5 = java.lang.Math.abs(r5)
            double r5 = (double) r5
            int r2 = r2.y
            int r4 = r4.y
            int r2 = r2 - r4
            int r2 = java.lang.Math.abs(r2)
            double r7 = (double) r2
            double r5 = r5 * r5
            double r7 = r7 * r7
            double r5 = r5 + r7
            double r4 = java.lang.Math.sqrt(r5)
            r6 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto Lac
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r11 = r10.mCallBack
            com.autonavi.gbl.common.model.Coord2DDouble r11 = r11.getLonLatFromCenter()
            if (r11 != 0) goto L78
            return r1
        L78:
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r2 = new com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble
            r2.<init>(r11)
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r11 = r10.mCallBack
            android.graphics.Point r11 = r11.lonLatToPoint(r2)
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r2 = r10.mCallBack
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r4 = r10.mLastCenterLocation
            android.graphics.Point r2 = r2.lonLatToPoint(r4)
            int r4 = r11.x
            int r5 = r2.x
            int r4 = r4 - r5
            int r4 = java.lang.Math.abs(r4)
            double r4 = (double) r4
            int r11 = r11.y
            int r2 = r2.y
            int r11 = r11 - r2
            int r11 = java.lang.Math.abs(r11)
            double r8 = (double) r11
            double r4 = r4 * r4
            double r8 = r8 * r8
            double r4 = r4 + r8
            double r4 = java.lang.Math.sqrt(r4)
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 <= 0) goto Lb9
            goto L1d
        Lac:
            com.autonavi.gbl.common.model.Coord2DDouble[] r2 = r11.getQueryBox()
            int r11 = r11.getScaleLevel()
            r10.queryChargeDB(r2, r11)
            goto Lb9
        Lb8:
            return r1
        Lb9:
            if (r1 == 0) goto Ld6
            com.xiaopeng.montecarlo.navcore.xptbt.TBTManager r11 = com.xiaopeng.montecarlo.navcore.xptbt.TBTManager.getInstance()
            com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper r11 = r11.getPosServiceWrapper()
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r11 = r11.getCurrentLocation()
            r10.mLastCarLocation = r11
            com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble r11 = new com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble
            com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack r2 = r10.mCallBack
            com.autonavi.gbl.common.model.Coord2DDouble r2 = r2.getLonLatFromCenter()
            r11.<init>(r2)
            r10.mLastCenterLocation = r11
        Ld6:
            r10.mLastMapLevel = r0
        Ld8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapDataProvider.doFilterPre(com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapSceneRequestParam):boolean");
    }

    private List<XPPoiInfo> filterInScreenCP(List<XPPoiInfo> list) {
        MapStatus mapStatus;
        if (this.mCallBack == null || CollectionUtils.isEmpty(list) || (mapStatus = this.mCallBack.getMapStatus()) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (XPPoiInfo xPPoiInfo : list) {
            Point lonLatToPoint = this.mCallBack.lonLatToPoint(new XPCoordinate2DDouble(xPPoiInfo));
            if (lonLatToPoint != null && lonLatToPoint.x >= 0 && lonLatToPoint.x <= mapStatus.getWidth() && lonLatToPoint.y >= 0 && lonLatToPoint.y <= mapStatus.getHeight() && arrayList.size() < 50) {
                arrayList.add(xPPoiInfo);
            }
        }
        list.clear();
        list.addAll(arrayList);
        arrayList.clear();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "end query real size: " + list.size());
        }
        return list;
    }
}
