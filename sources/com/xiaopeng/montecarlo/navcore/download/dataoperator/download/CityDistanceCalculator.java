package com.xiaopeng.montecarlo.navcore.download.dataoperator.download;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.layer.model.BizLayerUtil;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPVariantPath;
import com.xiaopeng.montecarlo.root.util.CompositeRxAction;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class CityDistanceCalculator {
    private static final int CRUISE_MONIT_DISTANCE = 10000;
    private static final long CRUISE_MONIT_INTERVAL = 60000;
    private final ICityListener mCityListener;
    int mCurrentCityAdCode;
    protected final L.Tag TAG = new L.Tag("tMapDataCalculator");
    CompositeRxAction mRxAction = new CompositeRxAction();
    private final ArrayList<Long> mNaviCityAdCodeList = new ArrayList<>();
    private long mNaviRouteRemainDis = 0;

    /* loaded from: classes2.dex */
    public interface ICityListener {
        void onNotifyCruiseCityDiff(int i);

        void onNotifyNaviCityDownload(Long l);
    }

    public CityDistanceCalculator(int i, @NonNull ICityListener iCityListener) {
        this.mCurrentCityAdCode = i;
        this.mCityListener = iCityListener;
    }

    public void onCurrentCityChanged(int i) {
        this.mCurrentCityAdCode = i;
        if (this.mNaviCityAdCodeList.isEmpty()) {
            return;
        }
        notifyNextNaviDownloadCity();
    }

    public boolean isCityNeedCruiseDownload(int i) {
        XPCoordinate2DDouble positionFromCarLocationAndDistance = getPositionFromCarLocationAndDistance(TBTManager.getInstance().getPosServiceWrapper().getCurrentCarLocation());
        return positionFromCarLocationAndDistance != null && MapDataManager.getInstance().getAdCodeByLonLat(positionFromCarLocationAndDistance) == i;
    }

    public void startCruiseCityMonit() {
        L.i(this.TAG, "startCruiseCityMonit");
        clean();
        this.mRxAction.addSubscription(Observable.interval(60000L, TimeUnit.MILLISECONDS), new DisposableObserver<Long>() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.download.CityDistanceCalculator.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(@NonNull Long l) {
                XPCoordinate2DDouble positionFromCarLocationAndDistance = CityDistanceCalculator.this.getPositionFromCarLocationAndDistance(TBTManager.getInstance().getPosServiceWrapper().getCurrentCarLocation());
                if (positionFromCarLocationAndDistance != null) {
                    int adCodeByLonLat = MapDataManager.getInstance().getAdCodeByLonLat(positionFromCarLocationAndDistance);
                    L.Tag tag = CityDistanceCalculator.this.TAG;
                    L.i(tag, "adCodeByDistance:" + adCodeByLonLat);
                    if (adCodeByLonLat <= 0 || adCodeByLonLat == CityDistanceCalculator.this.mCurrentCityAdCode) {
                        return;
                    }
                    CityDistanceCalculator.this.mCityListener.onNotifyCruiseCityDiff(adCodeByLonLat);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startNaviCityMonitor(IVariantPath iVariantPath) {
        L.i(this.TAG, "startNaviCityMonitor");
        clean();
        if (iVariantPath != null) {
            refreshNaviInfo(iVariantPath, -1);
        }
    }

    private void clean() {
        this.mRxAction.unSubscribe();
        this.mNaviCityAdCodeList.clear();
        this.mNaviRouteRemainDis = 0L;
    }

    public void refreshNaviInfo(@NonNull IVariantPath iVariantPath, int i) {
        XPVariantPath xPVariantPath;
        PathInfo variantPath;
        L.Tag tag = this.TAG;
        L.i(tag, "refreshNaviInfo routeRemianDis:" + i);
        if (i != -1) {
            this.mNaviRouteRemainDis = i;
        }
        if (!(iVariantPath instanceof XPVariantPath) || (variantPath = (xPVariantPath = (XPVariantPath) iVariantPath).getVariantPath()) == null) {
            return;
        }
        ArrayList<Long> cityAdcodeList = variantPath.getCityAdcodeList();
        L.Tag tag2 = this.TAG;
        L.i(tag2, "refreshNaviInfo pathId:" + xPVariantPath.getPathId() + ",cityAdCodeList:" + cityAdcodeList);
        if (cityAdcodeList == null) {
            L.i(this.TAG, "refreshNaviInfo cityAdCodeList is null!");
        } else if (this.mNaviCityAdCodeList.size() == cityAdcodeList.size() && this.mNaviCityAdCodeList.equals(cityAdcodeList)) {
            L.i(this.TAG, "refreshNaviInfo cityAdCodeList is the same! ");
        } else {
            this.mNaviCityAdCodeList.clear();
            this.mNaviCityAdCodeList.addAll(cityAdcodeList);
            notifyNextNaviDownloadCity();
        }
    }

    private void notifyNextNaviDownloadCity() {
        int i;
        L.Tag tag = this.TAG;
        L.i(tag, "notifyNextNaviDownloadCity mCurrentCityAdCode:" + this.mCurrentCityAdCode + ",cityAdCodeList:" + this.mNaviCityAdCodeList);
        int size = this.mNaviCityAdCodeList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mNaviCityAdCodeList.get(i2).longValue() == this.mCurrentCityAdCode && size > (i = i2 + 1)) {
                Long l = this.mNaviCityAdCodeList.get(i);
                L.Tag tag2 = this.TAG;
                L.i(tag2, i2 + "-fetchNextNaviDownloadCity onNotifyNaviCityChanged nextCityCode:" + l);
                this.mCityListener.onNotifyNaviCityDownload(l);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public XPCoordinate2DDouble getPositionFromCarLocationAndDistance(XPCarLocation xPCarLocation) {
        if (xPCarLocation == null) {
            return null;
        }
        double radians = Math.toRadians(xPCarLocation.mCarDir);
        double radians2 = Math.toRadians(xPCarLocation.mLatitude);
        double asin = Math.asin((Math.sin(radians2) * Math.cos(0.0015695154889990306d)) + (Math.cos(radians2) * Math.sin(0.0015695154889990306d) * Math.cos(radians)));
        double degrees = Math.toDegrees(asin);
        double degrees2 = xPCarLocation.mLongitude + Math.toDegrees(Math.atan2(Math.sin(radians) * Math.sin(0.0015695154889990306d) * Math.cos(radians2), Math.cos(0.0015695154889990306d) - (Math.sin(radians2) * Math.sin(asin))));
        L.Tag tag = this.TAG;
        L.i(tag, " car lon lat :" + xPCarLocation.mLongitude + "," + xPCarLocation.mLatitude + ",carDir:" + xPCarLocation.mCarDir + "-----dest lon lat :" + degrees2 + "," + degrees + ",distanceBetween:" + BizLayerUtil.calcDistanceBetweenPoints(new Coord2DDouble(xPCarLocation.mLongitude, xPCarLocation.mLatitude), new Coord2DDouble(degrees2, degrees)));
        return new XPCoordinate2DDouble(degrees2, degrees);
    }
}
