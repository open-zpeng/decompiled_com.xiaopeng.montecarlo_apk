package com.xiaopeng.montecarlo.navcore.download.dataoperator.download;

import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.download.CityDistanceCalculator;
import com.xiaopeng.montecarlo.navcore.xptbt.INaviListener;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRouteTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.annotations.NonNull;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class AbstractMapDataDownloader implements INaviListener {
    CityDistanceCalculator mCityDistanceCalculator;
    protected int mCurrentCityAdCode;
    private final MapDataOperator mMapDataOperator;
    protected final L.Tag TAG = new L.Tag("tMapDataDownloader");
    CityDistanceCalculator.ICityListener mCityListener = new CityDistanceCalculator.ICityListener() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.download.AbstractMapDataDownloader.1
        @Override // com.xiaopeng.montecarlo.navcore.download.dataoperator.download.CityDistanceCalculator.ICityListener
        public void onNotifyCruiseCityDiff(int i) {
            AbstractMapDataDownloader.this.notifyCruiseCityDiff(i);
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.dataoperator.download.CityDistanceCalculator.ICityListener
        public void onNotifyNaviCityDownload(Long l) {
            AbstractMapDataDownloader.this.notifyNaviCityDownload(l);
        }
    };

    abstract void notifyCruiseCityDiff(int i);

    abstract void notifyNaviCityDownload(Long l);

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onBeforePathChanged(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onDeletePath(List<Long> list, long j, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onObtainAsyncInfo(XPObtainInfo xPObtainInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onReroute(RouteParams routeParams) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviIntervalCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowTollGateLane(XPTollGateInfo xPTollGateInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSuggestChangePath(long j, long j2, long j3) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateCrossImage(XPCrossImageInfo xPCrossImageInfo, int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateSAPA(List<XPFacilityInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCCongestionInfo(XPNaviCongestionInfo xPNaviCongestionInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCLightBar(List<ILightBarInfo> list, int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTREvent(List<XPPathTrafficEventInfo> list, int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTRPlayView(XPRouteTrafficEventInfo xPRouteTrafficEventInfo) {
    }

    abstract void removeAllNaviDownload();

    public AbstractMapDataDownloader(int i, @NonNull MapDataOperator mapDataOperator) {
        this.mCurrentCityAdCode = i;
        this.mMapDataOperator = mapDataOperator;
        this.mCityDistanceCalculator = new CityDistanceCalculator(i, this.mCityListener);
        TBTManager.getInstance().addNaviListener(this);
    }

    public MapDataOperator getMapDataOperator() {
        return this.mMapDataOperator;
    }

    public int getCurrentCityAdCode() {
        return this.mCurrentCityAdCode;
    }

    public void setCurrentCityAdCode(int i) {
        this.mCurrentCityAdCode = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startCityMonitorByMode() {
        if (TBTManager.getInstance().isInNaviMode()) {
            startNaviCityMonitor();
        } else {
            startCruiseCityMonitor();
        }
    }

    protected void startCruiseCityMonitor() {
        removeAllNaviDownload();
        this.mCityDistanceCalculator.startCruiseCityMonit();
    }

    public boolean isCityNeedCruiseDownload(int i) {
        return this.mCityDistanceCalculator.isCityNeedCruiseDownload(i);
    }

    protected void startNaviCityMonitor() {
        this.mCityDistanceCalculator.startNaviCityMonitor(TBTManager.getInstance().getCurrentNaviVariantPath());
    }

    public void refreshNaviInfo(int i) {
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if (currentNaviVariantPath != null) {
            this.mCityDistanceCalculator.refreshNaviInfo(currentNaviVariantPath, i);
        }
    }

    public void onCurrentCityChanged(int i) {
        this.mCityDistanceCalculator.onCurrentCityChanged(i);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStop(int i, boolean z) {
        L.i(this.TAG, "onNaviStop");
        this.mMapDataOperator.runOnDataThread(new $$Lambda$bgPzbLv_1ViiSp_T9TwJzYUgSYU(this));
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateViaPass(long j) {
        L.Tag tag = this.TAG;
        L.i(tag, "onUpdateViaPass index:" + j);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onChangeNaviPath(long j) {
        L.Tag tag = this.TAG;
        L.i(tag, "onChangeNaviPath pathId：" + j);
        this.mMapDataOperator.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.download.-$$Lambda$AbstractMapDataDownloader$DV9XqI5Ctt32ZPKVtnjqFMvIzNg
            @Override // java.lang.Runnable
            public final void run() {
                AbstractMapDataDownloader.this.lambda$onChangeNaviPath$0$AbstractMapDataDownloader();
            }
        });
    }

    public /* synthetic */ void lambda$onChangeNaviPath$0$AbstractMapDataDownloader() {
        refreshNaviInfo(-1);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSelectMainPathStatus(long j, int i) {
        L.Tag tag = this.TAG;
        L.i(tag, "onSelectMainPathStatus pathId：" + j + ",result:" + i);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateRemainDis(long j, int i, int i2) {
        L.Tag tag = this.TAG;
        L.i(tag, "onUpdateRemainDis pathId:" + j + ",routeRemainDis:" + i + ",remainDis:" + i2);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onMainPathChanged() {
        L.i(this.TAG, "onMainPathChanged");
        this.mMapDataOperator.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.download.-$$Lambda$AbstractMapDataDownloader$GcPy6Sq7S5U8Qrl-E2vsEB65CzE
            @Override // java.lang.Runnable
            public final void run() {
                AbstractMapDataDownloader.this.lambda$onMainPathChanged$1$AbstractMapDataDownloader();
            }
        });
    }

    public /* synthetic */ void lambda$onMainPathChanged$1$AbstractMapDataDownloader() {
        refreshNaviInfo(-1);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStart(int i) {
        L.Tag tag = this.TAG;
        L.i(tag, "onNaviStart:" + i);
        if (i != 2) {
            this.mMapDataOperator.runOnDataThread(new $$Lambda$bgPzbLv_1ViiSp_T9TwJzYUgSYU(this));
        }
    }
}
