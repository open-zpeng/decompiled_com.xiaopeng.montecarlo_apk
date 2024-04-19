package com.xiaopeng.montecarlo.navcore.download.dataoperator.record;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.MapDataStatusEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataInfoUploader;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.record.MapDataRecorder;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CompositeRxAction;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class MapDataRecorder {
    private static final long RECORD_INTERVAL = 900000;
    private static final L.Tag TAG = new L.Tag("tMapDataRecorder");
    int mCurrentCityAdCode;
    private final MapDataInfoUploader mMapDataInfoUploader;
    MapDataOperator mMapDataOperator;
    Map<Integer, CityRecordBean> mMapDataRecordMap = new ConcurrentHashMap();
    CompositeRxAction mRxAction = new CompositeRxAction();

    public MapDataRecorder(int i, @NonNull MapDataOperator mapDataOperator, @NonNull MapDataInfoUploader mapDataInfoUploader) {
        this.mMapDataOperator = mapDataOperator;
        this.mMapDataInfoUploader = mapDataInfoUploader;
        this.mCurrentCityAdCode = i;
        loadCityRecordInfo();
    }

    public void fixLocalRecord() {
        L.i(TAG, "start fixLocalRecord~~~~~");
        boolean z = false;
        for (CityDataBean cityDataBean : MapDataManager.getInstance().getCityDataBeanMap().values()) {
            if (cityDataBean.isFinish()) {
                L.Tag tag = TAG;
                L.i(tag, "fixLocalRecord city:" + cityDataBean.getCityTitle() + " urid:" + cityDataBean.getUrcode() + ",adCode" + cityDataBean.getAdcode() + ",getDataFullSize:" + RootUtil.getFormatSize(cityDataBean.getDataFullSize()));
                if (!hasCityRecord(cityDataBean.getAdcode())) {
                    L.Tag tag2 = TAG;
                    L.i(tag2, "no local data! record download:" + cityDataBean.getAdcode());
                    recordDownloadDone(cityDataBean.getAdcode());
                    z = true;
                }
            }
        }
        if (z) {
            this.mMapDataInfoUploader.uploadMapDataInfo(new ArrayList(this.mMapDataRecordMap.values()));
        }
        L.i(TAG, "finish fixLocalRecord~~~~~");
    }

    private boolean hasCityRecord(int i) {
        return this.mMapDataRecordMap.get(Integer.valueOf(i)) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.dataoperator.record.MapDataRecorder$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends DisposableObserver<Long> {
        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(@NonNull Throwable th) {
        }

        AnonymousClass1() {
        }

        public /* synthetic */ void lambda$onNext$0$MapDataRecorder$1() {
            MapDataRecorder mapDataRecorder = MapDataRecorder.this;
            mapDataRecorder.recordCityUse(mapDataRecorder.mCurrentCityAdCode);
        }

        @Override // io.reactivex.Observer
        public void onNext(@NonNull Long l) {
            MapDataRecorder.this.mMapDataOperator.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.record.-$$Lambda$MapDataRecorder$1$vcDu0A7Jbd5uH9spIg-81ckUnQI
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataRecorder.AnonymousClass1.this.lambda$onNext$0$MapDataRecorder$1();
                }
            });
        }
    }

    public void startCityUseRecord() {
        this.mRxAction.unSubscribe();
        this.mRxAction.addSubscription(Observable.interval(RECORD_INTERVAL, TimeUnit.MILLISECONDS), new AnonymousClass1());
        L.Tag tag = TAG;
        L.i(tag, "startCityUseRecord currentCityAdCode:" + this.mCurrentCityAdCode);
    }

    public void stopCityUseRecord() {
        this.mRxAction.unSubscribe();
    }

    public void onCurrentCityChanged(int i) {
        if (i <= 0 || this.mCurrentCityAdCode == i) {
            return;
        }
        this.mCurrentCityAdCode = i;
        resetCurrentCity(this.mCurrentCityAdCode);
    }

    private void resetCurrentCity(int i) {
        CityRecordBean cityRecordInfo = getCityRecordInfo(i);
        if (fixCurrentCity(cityRecordInfo)) {
            this.mMapDataInfoUploader.uploadMapDataInfo(new ArrayList(this.mMapDataRecordMap.values()));
        }
        L.Tag tag = TAG;
        L.i(tag, "resetCurrentCity:" + GsonUtil.toJson(cityRecordInfo));
        saveCityRecordInfo();
    }

    private boolean fixCurrentCity(@NonNull CityRecordBean cityRecordBean) {
        if (cityRecordBean.getAdCode() != this.mCurrentCityAdCode || cityRecordBean.isCurrentCity()) {
            return false;
        }
        for (CityRecordBean cityRecordBean2 : this.mMapDataRecordMap.values()) {
            cityRecordBean2.setCurrentCity(false);
        }
        cityRecordBean.setCurrentCity(true);
        cityRecordBean.setLastUseTimeInMillis(System.currentTimeMillis());
        return true;
    }

    public void onDownLoadStatusChange(int i, TaskStatusCodeEnum taskStatusCodeEnum) {
        if (TaskStatusCodeEnum.TASK_STATUS_CODE_SUCCESS == taskStatusCodeEnum) {
            recordDownloadDone(i);
            this.mMapDataInfoUploader.uploadMapDataInfo(new ArrayList(this.mMapDataRecordMap.values()));
        }
    }

    public void onOperated(OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList) {
        if (OperationTypeEnum.OPERATION_TYPE_DELETE != operationTypeEnum || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "onOperated OPERATION_TYPE_DELETE adCode:" + arrayList);
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            deleteCityRecord(it.next().intValue());
        }
        saveCityRecordInfo();
        this.mMapDataInfoUploader.uploadMapDataInfo(new ArrayList(this.mMapDataRecordMap.values()));
    }

    public Map<Integer, CityRecordBean> getMapDataRecordInfo() {
        return new HashMap(this.mMapDataRecordMap);
    }

    private void deleteCityRecord(int i) {
        L.Tag tag = TAG;
        L.i(tag, "deleteCityRecord adCode:" + i);
        CityRecordBean cityRecordInfo = getCityRecordInfo(i);
        cityRecordInfo.setDeleteTimeInMillis(System.currentTimeMillis());
        cityRecordInfo.setDataStatus((long) MapDataStatusEnum.STATUS_DELETED.getStatus());
    }

    private void recordDownloadDone(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        CityRecordBean cityRecordInfo = getCityRecordInfo(i);
        cityRecordInfo.setDataStatus(MapDataStatusEnum.STATUS_DOWNLOAD_COMPLETE.getStatus());
        cityRecordInfo.setDownloadTimeInMillis(currentTimeMillis);
        cityRecordInfo.setMapDataVersion(MapDataManager.getInstance().getMapDataVersion(i));
        fixCurrentCity(cityRecordInfo);
        L.Tag tag = TAG;
        L.i(tag, "recordDownloadDone:" + GsonUtil.toJson(cityRecordInfo));
        saveCityRecordInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordCityUse(int i) {
        if (i <= 0) {
            L.Tag tag = TAG;
            L.e(tag, "recordCityUse adCode error:" + i);
            return;
        }
        CityRecordBean cityRecordInfo = getCityRecordInfo(i);
        cityRecordInfo.setLastUseTimeInMillis(System.currentTimeMillis());
        cityRecordInfo.setRecordCount(cityRecordInfo.getRecordCount() + 1);
        if (fixCurrentCity(cityRecordInfo)) {
            this.mMapDataInfoUploader.uploadMapDataInfo(new ArrayList(this.mMapDataRecordMap.values()));
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "recordCityUse:" + GsonUtil.toJson(cityRecordInfo));
        saveCityRecordInfo();
    }

    @NonNull
    private CityRecordBean getCityRecordInfo(int i) {
        CityRecordBean cityRecordBean = this.mMapDataRecordMap.get(Integer.valueOf(i));
        if (cityRecordBean == null) {
            CityRecordBean cityRecordBean2 = new CityRecordBean();
            cityRecordBean2.setAdCode(i);
            this.mMapDataRecordMap.put(Integer.valueOf(i), cityRecordBean2);
            L.Tag tag = TAG;
            L.i(tag, "getCityRecordInfo adCode:" + i);
            return cityRecordBean2;
        }
        return cityRecordBean;
    }

    private void loadCityRecordInfo() {
        String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_CITY_RECORD_INFO, "");
        L.Tag tag = TAG;
        L.i(tag, "loadCityRecordInfo json=" + string);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        List list = (List) GsonUtil.fromJson(string, new TypeToken<List<CityRecordBean>>() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.record.MapDataRecorder.2
        }.getType());
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                CityRecordBean cityRecordBean = (CityRecordBean) list.get(i);
                if (cityRecordBean != null) {
                    this.mMapDataRecordMap.put(Integer.valueOf(cityRecordBean.getAdCode()), cityRecordBean);
                }
            }
        } else {
            L.Tag tag2 = TAG;
            L.i(tag2, "json: " + string);
        }
        L.Tag tag3 = TAG;
        L.i(tag3, "loadCityRecordInfo finish size: " + this.mMapDataRecordMap.size());
    }

    private void saveCityRecordInfo() {
        Map<Integer, CityRecordBean> map = this.mMapDataRecordMap;
        if (map != null && !map.isEmpty()) {
            String json = GsonUtil.toJson(new ArrayList(this.mMapDataRecordMap.values()));
            L.Tag tag = TAG;
            L.i(tag, "saveCityRecordInfo recordListJson:" + json);
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_CITY_RECORD_INFO, json);
            return;
        }
        L.i(TAG, "saveMapInDatabase, mRecorderMap is null");
    }
}
