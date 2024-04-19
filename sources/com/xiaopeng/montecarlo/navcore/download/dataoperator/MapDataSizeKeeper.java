package com.xiaopeng.montecarlo.navcore.download.dataoperator;

import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataSizeKeeper;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.record.CityRecordBean;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.ToLongFunction;
/* loaded from: classes2.dex */
public class MapDataSizeKeeper {
    private static final int DATA_SIZE_REFRESH_INTERVAL = 10000;
    private static final L.Tag TAG = new L.Tag("tMapDataSizeKeeper");
    private final File mMapDataFolder;
    private final MapDataOperator mMapDataOperator;
    private final float MAX_MAP_DATA_SIZE = 4.8318382E9f;
    private final PublishSubject<Boolean> mRefreshDataSizePublisher = PublishSubject.create();

    public MapDataSizeKeeper(@NonNull MapDataOperator mapDataOperator, String str) {
        L.Tag tag = TAG;
        L.i(tag, "MapDataSizeKeeper map folderPath:" + str);
        this.mMapDataFolder = new File(str);
        this.mMapDataOperator = mapDataOperator;
        initDataSizeRefresher();
    }

    public void onCityDataFetched() {
        scheduleRefreshDataSize();
    }

    public void onDownLoadStatusChange() {
        scheduleRefreshDataSize();
    }

    public void onPercent(Integer num, Integer num2, Float f) {
        if (f.floatValue() <= 5.0f || f.floatValue() >= 95.0f) {
            L.Tag tag = TAG;
            L.i(tag, "onPercent, adcode: " + num + " percentType: " + num2 + " percent: " + f);
        }
        scheduleRefreshDataSize();
    }

    public void onOperated(OperationTypeEnum operationTypeEnum) {
        if (operationTypeEnum != OperationTypeEnum.OPERATION_TYPE_DELETE) {
            scheduleRefreshDataSize();
        }
    }

    private void startDeleteMapData(long j) {
        float f = ((float) j) - 4.8318382E9f;
        L.i(TAG, "startDeleteMapData currentSize:" + RootUtil.getFormatSize(j) + ",sizeNeedToFree:" + RootUtil.getFormatSize(f));
        long j2 = 0L;
        for (CityDataBean cityDataBean : MapDataManager.getInstance().getCityDataBeanMap().values()) {
            if (cityDataBean.isPaused()) {
                L.i(TAG, "delete paused Download city :" + cityDataBean.getCityTitle() + " download paused");
                j2 += cityDataBean.getLocalDataSize();
                MapDataManager.getInstance().deleteDownload(Integer.valueOf(cityDataBean.getAdcode()));
                if (((float) j2) >= f) {
                    L.i(TAG, "total delete size >= sizeNeedToFree,finish delete!");
                    return;
                }
            }
        }
        Map<Integer, CityRecordBean> mapDataRecordInfo = this.mMapDataOperator.getMapDataRecordInfo();
        if (mapDataRecordInfo.size() > 0) {
            mapDataRecordInfo.remove(0);
            CityRecordBean cityRecordBean = null;
            CityRecordBean cityRecordBean2 = null;
            for (CityRecordBean cityRecordBean3 : mapDataRecordInfo.values()) {
                if (cityRecordBean != null) {
                    if (cityRecordBean3.getRecordCount() > cityRecordBean.getRecordCount()) {
                        if (cityRecordBean2 != null && cityRecordBean2.getRecordCount() >= cityRecordBean.getRecordCount()) {
                            cityRecordBean = cityRecordBean2;
                        }
                        cityRecordBean2 = cityRecordBean;
                    } else if (cityRecordBean2 == null || cityRecordBean3.getRecordCount() > cityRecordBean2.getRecordCount()) {
                        cityRecordBean2 = cityRecordBean3;
                    }
                }
                cityRecordBean = cityRecordBean3;
            }
            ArrayList<Integer> arrayList = new ArrayList();
            if (cityRecordBean != null) {
                arrayList.add(Integer.valueOf(cityRecordBean.getAdCode()));
                arrayList.addAll(MapDataManager.getInstance().getNearbyCityAdCodeList(cityRecordBean.getAdCode()));
                L.i(TAG, "111 maxUsedCityRecordInfo :" + GsonUtil.toJson(cityRecordBean));
            }
            if (cityRecordBean2 != null) {
                arrayList.add(Integer.valueOf(cityRecordBean2.getAdCode()));
                L.i(TAG, "111 minorUsedCityRecordInfo  :" + GsonUtil.toJson(cityRecordBean2));
                arrayList.addAll(MapDataManager.getInstance().getNearbyCityAdCodeList(cityRecordBean2.getAdCode()));
            }
            L.i(TAG, "111 exceptionCityCodeList :" + GsonUtil.toJson(arrayList));
            for (Integer num : arrayList) {
                mapDataRecordInfo.remove(num);
            }
        }
        ArrayList<CityRecordBean> arrayList2 = new ArrayList(mapDataRecordInfo.values());
        arrayList2.sort(Comparator.comparingLong(new ToLongFunction() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$3NL31-e4IdATRwVchHflfDmKGDg
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((CityRecordBean) obj).getLastOperateTime();
            }
        }));
        for (CityRecordBean cityRecordBean4 : arrayList2) {
            CityDataBean cityDataBean2 = MapDataManager.getInstance().getCityDataBean(cityRecordBean4.getAdCode());
            L.i(TAG, "delete adCode:" + cityRecordBean4.getAdCode() + ",cityData:" + cityDataBean2.getCityTitle() + ",getLastOperateTime:" + cityRecordBean4.getLastOperateTime());
            long localDataSize = cityDataBean2.getLocalDataSize();
            if (localDataSize == 0) {
                localDataSize = getCityLocalMapDataSize(cityDataBean2.getUrcode());
                L.i(TAG, "getCityLocalMapDataSize file size:" + localDataSize);
            }
            if (localDataSize <= 0) {
                L.e(TAG, "error city Data size error:" + localDataSize);
            } else {
                j2 += localDataSize;
                L.i(TAG, "totalDeleteSize:" + RootUtil.getFormatSize(j2));
                MapDataManager.getInstance().deleteDownload(Integer.valueOf(cityDataBean2.getAdcode()));
                if (((float) j2) >= f) {
                    L.i(TAG, "total delete size >= sizeNeedToFree,finish delete!");
                    return;
                }
            }
        }
        L.e(TAG, "Delete fail, data overflow!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataSizeKeeper$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends DisposableObserver<Boolean> {
        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(@NonNull Throwable th) {
        }

        AnonymousClass1() {
        }

        @Override // io.reactivex.Observer
        public void onNext(@NonNull Boolean bool) {
            MapDataSizeKeeper.this.mMapDataOperator.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataSizeKeeper$1$iwj1Z3OXOpGkCWQsyiATBnf6D3Q
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataSizeKeeper.AnonymousClass1.this.lambda$onNext$0$MapDataSizeKeeper$1();
                }
            });
        }

        public /* synthetic */ void lambda$onNext$0$MapDataSizeKeeper$1() {
            L.i(MapDataSizeKeeper.TAG, "refreshDataSize execute~");
            MapDataSizeKeeper.this.refreshDataSizeInternal();
        }
    }

    private void initDataSizeRefresher() {
        this.mRefreshDataSizePublisher.debounce(NavRestoreManager.WAKELOCK_TIMEOUT_10SEC, TimeUnit.MILLISECONDS).subscribe(new AnonymousClass1());
    }

    private void scheduleRefreshDataSize() {
        this.mRefreshDataSizePublisher.onNext(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshDataSizeInternal() {
        long dirSize = FileUtil.getDirSize(this.mMapDataFolder, true);
        L.Tag tag = TAG;
        L.i(tag, "1111 refreshDataSize file total size:" + RootUtil.getFormatSize(dirSize));
        long j = 0L;
        for (CityDataBean cityDataBean : MapDataManager.getInstance().getCityDataBeanMap().values()) {
            long cityLocalMapDataSize = getCityLocalMapDataSize(cityDataBean.getUrcode());
            if (cityLocalMapDataSize != 0) {
                j += cityLocalMapDataSize;
            }
        }
        File file = new File(this.mMapDataFolder.getPath() + File.separator + "tempDownload");
        long dirSize2 = j + FileUtil.getDirSize(file, true) + FileUtil.getDirSize(new File(this.mMapDataFolder.getPath() + File.separator + "tempUnzip"), true);
        L.Tag tag2 = TAG;
        L.i(tag2, "22222 refreshDataSize getLocalDataSize:" + RootUtil.getFormatSize(dirSize2) + ",MAX_MAP_DATA_SIZE:" + RootUtil.getFormatSize(4831838208L));
        if (((float) dirSize2) > 4.8318382E9f) {
            startDeleteMapData(dirSize2);
        }
    }

    private long getCityLocalMapDataSize(int i) {
        File file = new File(this.mMapDataFolder.getPath() + File.separator + "a" + i);
        if (file.exists()) {
            return FileUtil.getDirSize(file, true);
        }
        return 0L;
    }
}
