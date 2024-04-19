package com.xiaopeng.montecarlo.navcore.download;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.autonavi.gbl.data.model.Area;
import com.autonavi.gbl.data.model.AreaExtraInfo;
import com.autonavi.gbl.data.model.CityDownLoadItem;
import com.autonavi.gbl.data.model.CityItemInfo;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.observer.IMapNumObserver;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.autodownload.AutoDownloadManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.bean.ProvinceDataBean;
import com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback;
import com.xiaopeng.montecarlo.navcore.download.constant.CityTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.ProvinceTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.helper.DownloadDataHelper;
import com.xiaopeng.montecarlo.navcore.download.helper.DownloadMementoHelper;
import com.xiaopeng.montecarlo.navcore.download.helper.MapNumHelper;
import com.xiaopeng.montecarlo.navcore.download.helper.SDCardListenerHelper;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.sr.data.LaneDataAction;
import com.xiaopeng.montecarlo.navcore.sr.data.LaneDataLogHelper;
import com.xiaopeng.montecarlo.navcore.sr.data.LaneMapDataServiceWrapper;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/* loaded from: classes2.dex */
public class MapDataManager implements IDownloadOperate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MSG_ONE_CITY_AUTO_DOWNLOAD_READY = 105;
    private static final int MSG_ONE_CITY_AUTO_DOWNLOAD_RETRY = 106;
    private static final L.Tag TAG = new L.Tag("MapDataManager");
    private static final MapDataManager sMapDataManager = new MapDataManager();
    private DownloadDataHelper mDownloadDataHelper;
    private LaneDataLogHelper mLaneDataLogHelper;
    private LaneMapDataServiceWrapper mLaneMapDataServiceWrapper;
    private IMapDataOperator mMapDataOperator;
    private volatile MapNumHelper mMapNumHelper;
    private NetworkChangeListener mNetworkChangeListener;
    private final ConcurrentLinkedQueue<IDownloadDataChangeCallback> mDataChangeCallbackList = new ConcurrentLinkedQueue<>();
    private boolean mIsCityListReady = false;
    private boolean mIsCompletedInitialized = false;
    private boolean mIsNeedNotifyOOBE = false;
    private DownloadDataChangeCallback mDataChangeListener = new DownloadDataChangeCallback();
    private final MapDataServiceWrapper mMapDataServiceWrapper = new MapDataServiceWrapper(this.mDataChangeListener);
    private DownloadMementoHelper mMementoHelper = new DownloadMementoHelper();

    private MapDataManager() {
        if (CarServiceManager.getInstance().hasXpuForNgp()) {
            this.mLaneDataLogHelper = new LaneDataLogHelper();
            this.mLaneMapDataServiceWrapper = new LaneMapDataServiceWrapper(createLaneDataObserver());
        }
        this.mNetworkChangeListener = new NetworkChangeListener();
        XPNetworkManager.INSTANCE.addNetworkListener(this.mNetworkChangeListener);
    }

    @NonNull
    public static MapDataManager getInstance() {
        return sMapDataManager;
    }

    public void init() {
        this.mMapDataServiceWrapper.initIMapDataService();
        LaneMapDataServiceWrapper laneMapDataServiceWrapper = this.mLaneMapDataServiceWrapper;
        if (laneMapDataServiceWrapper != null) {
            laneMapDataServiceWrapper.init();
        }
    }

    public Map<Integer, CityDataBean> getCityDataBeanMap() {
        DownloadDataHelper downloadDataHelper = this.mDownloadDataHelper;
        if (downloadDataHelper == null) {
            return null;
        }
        return downloadDataHelper.getCityDataBeanList();
    }

    public Map<String, ProvinceDataBean> getProvinceDataBeanList() {
        DownloadDataHelper downloadDataHelper = this.mDownloadDataHelper;
        if (downloadDataHelper == null) {
            return null;
        }
        return downloadDataHelper.getProvinceDataBeanList();
    }

    public void setContainCitiesListForNearbyProvince(ProvinceDataBean provinceDataBean, List<Integer> list) {
        DownloadDataHelper downloadDataHelper = this.mDownloadDataHelper;
        if (downloadDataHelper != null) {
            downloadDataHelper.setContainCitiesListForNearbyProvince(provinceDataBean, list);
        }
    }

    public void registerDownloadDataChangeObserver(IDownloadDataChangeCallback iDownloadDataChangeCallback) {
        if (this.mDataChangeCallbackList.contains(iDownloadDataChangeCallback)) {
            return;
        }
        this.mDataChangeCallbackList.add(iDownloadDataChangeCallback);
    }

    public void unregisterObserver(IDownloadDataChangeCallback iDownloadDataChangeCallback) {
        this.mDataChangeCallbackList.remove(iDownloadDataChangeCallback);
    }

    public IMapDataOperator getMapDataOperator() {
        return this.mMapDataOperator;
    }

    public CityDataBean getCityDataBean(int i) {
        DownloadDataHelper downloadDataHelper = this.mDownloadDataHelper;
        if (downloadDataHelper == null) {
            return null;
        }
        return downloadDataHelper.getRealCityDataBean(i);
    }

    public CityDataBean getCityDataBeanByUrID(int i) {
        DownloadDataHelper downloadDataHelper = this.mDownloadDataHelper;
        if (downloadDataHelper == null) {
            return null;
        }
        return downloadDataHelper.getCityDataBeanByUrId(i);
    }

    public ProvinceDataBean getProvinceDataBean(String str) {
        DownloadDataHelper downloadDataHelper = this.mDownloadDataHelper;
        if (downloadDataHelper == null) {
            return null;
        }
        return downloadDataHelper.getRealProvinceDataBean(str);
    }

    public void printAllProvince() {
        if (this.mDownloadDataHelper == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "printAllProvince " + GsonUtil.toJson(this.mDownloadDataHelper.getProvinceDataBeanList()));
    }

    public int getCurrentCityAdCode() {
        return DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_CURRENT_CITY_AD_CODE, 440100);
    }

    public void onCarLocationChange() {
        if (this.mIsCompletedInitialized) {
            refreshAllCityAndProvinceData();
        } else {
            L.i(TAG, "onCarLocationChange, not init yet");
        }
    }

    public boolean isCityListReady() {
        boolean z = this.mDownloadDataHelper != null && this.mIsCityListReady;
        L.Tag tag = TAG;
        L.d(tag, "isCityListReady " + z);
        return z;
    }

    public boolean isCompletedInitialized() {
        return this.mDownloadDataHelper != null && this.mIsCompletedInitialized;
    }

    public synchronized void startOOBE() {
        if (this.mMapDataOperator == null) {
            this.mIsNeedNotifyOOBE = true;
        } else {
            this.mMapDataOperator.onOOBE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public synchronized void handleOnCityListCreated() {
        L.i(TAG, "handleOnCityListCreated");
        refreshAllCityAndProvinceData();
        if (this.mIsCityListReady) {
            L.w(TAG, "handleOnCityListCreated failed, already initialized");
            return;
        }
        if (CarFeatureManager.INSTANCE.isMapDataPreInstalled()) {
            this.mMapDataOperator = new AutoDownloadManager();
        } else {
            this.mMapDataOperator = new MapDataOperator();
        }
        this.mMapDataOperator.initAutoDownload();
        if (this.mIsNeedNotifyOOBE) {
            this.mMapDataOperator.onOOBE();
            this.mIsNeedNotifyOOBE = false;
        }
        Iterator<IDownloadDataChangeCallback> it = this.mDataChangeCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onCityListCreated();
        }
        getMapNumHelper().initMapNum();
        new SDCardListenerHelper(RootUtil.DIR_OFFLINE_RELATIVE_PATH).startWatching();
        this.mIsCityListReady = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void refreshAllCityAndProvinceData() {
        if (this.mDownloadDataHelper == null) {
            this.mDownloadDataHelper = new DownloadDataHelper(this);
        }
        this.mDownloadDataHelper.generateAllCityData();
        this.mDownloadDataHelper.generateAllProvinceData();
        calculateAllProvinceDataSize();
        Iterator<IDownloadDataChangeCallback> it = this.mDataChangeCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onCityDataGenerated();
        }
        outputDataVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void handleDataDownloadComplete(int i, int i2, CityDataBean cityDataBean) {
        CityTypeEnum cityTypeByAdcode = this.mDownloadDataHelper.getCityTypeByAdcode(i);
        long realDataPatchSize = cityDataBean.getRealDataPatchSize();
        L.Tag tag = TAG;
        L.i(tag, "sendStatData PageType.SETTING, BtnType.DOWNLOAD_SUCCESS,  LastPatchSize: " + realDataPatchSize + ", Adcode: " + i + ", CityType: " + cityTypeByAdcode + ", errorCode: " + i2);
        DataLogUtil.sendStatData(PageType.NONE_UI_RELATED, BtnType.DOWNLOAD_FINISH, Long.valueOf(realDataPatchSize), Integer.valueOf(i), Integer.valueOf(cityTypeByAdcode.getId()), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void handleDataDownloadComplete(int i) {
        CityTypeEnum cityTypeByAdcode = this.mDownloadDataHelper.getCityTypeByAdcode(i);
        L.Tag tag = TAG;
        L.i(tag, "sendStatData PageType.SETTING, BtnType.DOWNLOAD_START,  NetworkType: " + XPNetworkManager.INSTANCE.getNetworkType() + ", Adcode: " + i + ", CityType: " + cityTypeByAdcode);
        DataLogUtil.sendStatData(PageType.NONE_UI_RELATED, BtnType.DOWNLOAD_START, XPNetworkManager.INSTANCE.getNetworkType(), Integer.valueOf(i), Integer.valueOf(cityTypeByAdcode.getId()));
    }

    public List<Integer> getDirectCityAdCodeList() {
        Map<String, ProvinceDataBean> provinceDataBeanList = this.mDownloadDataHelper.getProvinceDataBeanList();
        if (CollectionUtils.isEmpty(provinceDataBeanList)) {
            return Collections.emptyList();
        }
        return (List) ((ArrayList) Optional.ofNullable(provinceDataBeanList.get(ContextUtils.getString(R.string.map_data_direct_province))).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$NaVYAFmkm1RtTzkUCGP4vvkdXeI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ProvinceDataBean) obj).getContainCityList();
            }
        }).orElse(new ArrayList())).stream().filter($$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA.INSTANCE).map($$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk.INSTANCE).collect(Collectors.toList());
    }

    public List<Integer> getNearbyCityAdCodeList() {
        return getNearbyCityAdCodeList(getCurrentCityAdCode());
    }

    @NonNull
    public List<Integer> getNearbyCityAdCodeList(int i) {
        CityDataBean cityDataBean = getCityDataBean(i);
        if (cityDataBean != null) {
            return cityDataBean.getNearbyCityList();
        }
        return new ArrayList();
    }

    public AreaExtraInfo getAreaExtraInfo(int i) {
        return this.mMapDataServiceWrapper.getAreaExtraInfo(i);
    }

    public CityItemInfo getCityInfo(int i) {
        return this.mMapDataServiceWrapper.getCityInfo(i);
    }

    public Area getArea(int i) {
        return this.mMapDataServiceWrapper.getArea(i);
    }

    public CityDownLoadItem getCityDownLoadItem(int i) {
        return this.mMapDataServiceWrapper.getCityDownLoadItem(i);
    }

    public long getAllProvinceDataSize() {
        return DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.SETTING_ALL_PROVINCE_SIZE, -1L);
    }

    private void saveAllProvinceDataSize(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.SETTING_ALL_PROVINCE_SIZE, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void calculateAllProvinceDataSize() {
        long j = 0;
        if (this.mDownloadDataHelper != null) {
            for (ProvinceDataBean provinceDataBean : this.mDownloadDataHelper.getProvinceDataBeanList().values()) {
                if (provinceDataBean.getProvinceBeanType() != ProvinceTypeEnum.PROVINCE_TYPE_NEARBY_CITY) {
                    j += provinceDataBean.getRemainSize();
                }
            }
            saveAllProvinceDataSize(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapNumHelper getMapNumHelper() {
        if (this.mMapNumHelper == null) {
            synchronized (this) {
                if (this.mMapNumHelper == null) {
                    this.mMapNumHelper = new MapNumHelper();
                }
            }
        }
        return this.mMapNumHelper;
    }

    public String getMapNumContent() {
        if (this.mMapNumHelper == null) {
            return ContextUtils.getString(R.string.setting_map_num_content);
        }
        return this.mMapNumHelper.getPublicationMapNumContent();
    }

    public String getInternetMapNumContent() {
        return this.mMapNumHelper == null ? "" : this.mMapNumHelper.getInternetMapNumContent();
    }

    public String getLocalLaneMapNumContent() {
        return this.mMapNumHelper == null ? "" : this.mMapNumHelper.getLocalLaneMapNumContent();
    }

    public String getLocalLane30MapNumContent() {
        return this.mMapNumHelper == null ? "" : this.mMapNumHelper.getLocalLane30MapNumContent();
    }

    public String getMapNumAndLaneMapNumContent() {
        StringBuilder sb = new StringBuilder(getMapNumContent());
        String replace = getInternetMapNumContent().replace("审图号", "");
        int indexOf = sb.indexOf("号\n");
        String replace2 = getLocalLane30MapNumContent().replace("审图号", "");
        if (CarServiceManager.getInstance().isNGPOn()) {
            if (!TextUtils.isEmpty(replace2) && !TextUtils.isEmpty(replace)) {
                replace = replace2 + " /" + replace;
            } else {
                replace = replace2 + replace;
            }
        }
        if (indexOf > 0 && !TextUtils.isEmpty(replace)) {
            sb.insert(indexOf + 1, " /").insert(indexOf + 3, replace);
        }
        return sb.toString();
    }

    public int getAdCodeByLonLat(XPCoordinate2DDouble xPCoordinate2DDouble) {
        return this.mMapDataServiceWrapper.getAdcodeByLonLat(xPCoordinate2DDouble);
    }

    public void requestMapNum(MapNum mapNum, IMapNumObserver iMapNumObserver) {
        this.mMapDataServiceWrapper.requestMapNum(mapNum, iMapNumObserver);
    }

    public List<Integer> getAdcodeList(int i) {
        int[] adcodeList = this.mMapDataServiceWrapper.getAdcodeList(i);
        if (adcodeList == null) {
            L.Tag tag = TAG;
            L.w(tag, "getAdcodeList failed, adcodeList is null:" + i);
            return null;
        }
        return (List) Arrays.stream(adcodeList).boxed().collect(Collectors.toList());
    }

    public int getUrcodeByAdcode(int i) {
        return this.mMapDataServiceWrapper.getUrcodeByAdcode(i);
    }

    public List<Integer> getWorkingQueueAdcodeList() {
        ArrayList<Integer> workingQueueAdcodeList = this.mMapDataServiceWrapper.getWorkingQueueAdcodeList();
        if (workingQueueAdcodeList == null) {
            return Collections.emptyList();
        }
        return (List) workingQueueAdcodeList.stream().map(new $$Lambda$DYaGluDu5oxUZFn4YZNlCcjtrG0(this)).filter($$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA.INSTANCE).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataManager$pQ6Jowb4HFObOInTFhmc20LI-sc
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MapDataManager.lambda$getWorkingQueueAdcodeList$0((CityDataBean) obj);
            }
        }).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataManager$isULLPHaNa89mqv9EfWi4YU7Y9o
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MapDataManager.lambda$getWorkingQueueAdcodeList$1((CityDataBean) obj);
            }
        }).map($$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk.INSTANCE).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getWorkingQueueAdcodeList$0(CityDataBean cityDataBean) {
        return !cityDataBean.isPaused();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getWorkingQueueAdcodeList$1(CityDataBean cityDataBean) {
        return !cityDataBean.isError();
    }

    public List<Integer> getCurrentDownloadingAndWaitingAdcode() {
        ArrayList<Integer> workingQueueAdcodeList = this.mMapDataServiceWrapper.getWorkingQueueAdcodeList();
        if (workingQueueAdcodeList == null) {
            return null;
        }
        List<Integer> list = (List) workingQueueAdcodeList.stream().map(new $$Lambda$DYaGluDu5oxUZFn4YZNlCcjtrG0(this)).filter($$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA.INSTANCE).filter(new Predicate() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataManager$rSlNcGQ0ZB2Sq9i_CsXjDQK1-qg
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MapDataManager.lambda$getCurrentDownloadingAndWaitingAdcode$2((CityDataBean) obj);
            }
        }).map($$Lambda$Eb5Z0AmnOwGEcs2GKLfi96yc5Sk.INSTANCE).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getCurrentDownloadingAndWaitingAdcode$2(CityDataBean cityDataBean) {
        return cityDataBean.isDownloading() || cityDataBean.isWaiting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOneCityAutoDownloadReady(Integer num) {
        this.mMementoHelper.onDownloadFinish(num);
        List<Integer> workingQueueAdcodeList = getInstance().getWorkingQueueAdcodeList();
        if (CollectionUtils.isNotEmpty(workingQueueAdcodeList)) {
            L.Tag tag = TAG;
            L.i(tag, "getNextDownloadAdcode canceled, these cities are downloading:" + workingQueueAdcodeList);
            return;
        }
        Integer nextDownloadAdcode = this.mMementoHelper.getNextDownloadAdcode();
        L.Tag tag2 = TAG;
        L.i(tag2, "onOneCityAutoDownloadReady " + nextDownloadAdcode);
        startDownload(nextDownloadAdcode);
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
    public void startDownload(Integer num) {
        L.Tag tag = TAG;
        L.i(tag, "startDownload, adcode: " + num);
        if (num != null) {
            this.mMapDataServiceWrapper.startDownload(num.intValue());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
    public void pauseDownload(Integer num) {
        L.Tag tag = TAG;
        L.i(tag, "pauseDownload, adcode: " + num);
        if (num != null) {
            this.mMapDataServiceWrapper.pauseDownload(num.intValue());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
    public void cancelDownload(Integer num) {
        L.Tag tag = TAG;
        L.i(tag, "cancelDownload, adcode: " + num);
        if (num != null) {
            this.mMapDataServiceWrapper.cancelDownload(num.intValue());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
    public void deleteDownload(Integer num) {
        L.Tag tag = TAG;
        L.i(tag, "deleteDownload, adcode: " + num);
        if (num != null) {
            this.mMapDataServiceWrapper.deleteDownload(num.intValue());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
    public void deleteErrorData(Integer num) {
        L.Tag tag = TAG;
        L.i(tag, "deleteErrorData, adcode: " + num);
        if (num != null) {
            this.mMapDataServiceWrapper.deleteErrorData(num.intValue());
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
    public void multiDownload(Collection<Integer> collection) {
        if (collection == null) {
            L.w(TAG, "multiDownload, adcodeList is null");
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "multiDownload, size: " + collection.size());
        realMultiStartOrPauseDownload(OperationTypeEnum.OPERATION_TYPE_START, new ArrayList<>(collection));
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
    public void multiPause(Collection<Integer> collection) {
        if (collection == null) {
            L.w(TAG, "multiPause, adcodeList is null");
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "multiPause, size: " + collection.size());
        realMultiStartOrPauseDownload(OperationTypeEnum.OPERATION_TYPE_PAUSE, new ArrayList<>(collection));
    }

    public void realMultiStartOrPauseDownload(OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList) {
        if (CollectionUtils.isEmpty(arrayList)) {
            return;
        }
        int i = AnonymousClass2.$SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum[operationTypeEnum.ordinal()];
        if (i == 1) {
            this.mMementoHelper.recordDownload(OperationTypeEnum.OPERATION_TYPE_START, arrayList);
            onOneCityAutoDownloadReady(null);
        } else if (i == 2) {
            this.mMementoHelper.recordDownload(OperationTypeEnum.OPERATION_TYPE_PAUSE, arrayList);
            List<Integer> currentDownloadingAndWaitingAdcode = getInstance().getCurrentDownloadingAndWaitingAdcode();
            if (CollectionUtils.isEmpty(currentDownloadingAndWaitingAdcode)) {
                return;
            }
            currentDownloadingAndWaitingAdcode.retainAll(arrayList);
            if (CollectionUtils.isNotEmpty(currentDownloadingAndWaitingAdcode)) {
                final MapDataManager mapDataManager = getInstance();
                mapDataManager.getClass();
                currentDownloadingAndWaitingAdcode.forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$nCK91Dl-Aw5sk-ZaWjvR9TEIx5s
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        MapDataManager.this.pauseDownload((Integer) obj);
                    }
                });
            }
        } else {
            L.i(TAG, "MSG_MULTI_UPDATE_MAP_DATA invalid arg");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.MapDataManager$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum = new int[OperationTypeEnum.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum[OperationTypeEnum.OPERATION_TYPE_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$OperationTypeEnum[OperationTypeEnum.OPERATION_TYPE_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void outputDataVersion() {
        int currentCityAdCode = getCurrentCityAdCode();
        String dataFileVersion = this.mMapDataServiceWrapper.getDataFileVersion(currentCityAdCode, 0);
        L.Tag tag = TAG;
        L.i(tag, "outputDataVersion:" + currentCityAdCode + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + dataFileVersion);
        for (Integer num : getNearbyCityAdCodeList(currentCityAdCode)) {
            String dataFileVersion2 = this.mMapDataServiceWrapper.getDataFileVersion(num.intValue(), 0);
            L.Tag tag2 = TAG;
            L.i(tag2, num + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + dataFileVersion2);
        }
    }

    public String getMapDataVersion(int i) {
        MapDataServiceWrapper mapDataServiceWrapper = this.mMapDataServiceWrapper;
        return mapDataServiceWrapper == null ? "" : mapDataServiceWrapper.getDataFileVersion(i, 0);
    }

    public synchronized boolean hasDataBlockedInUnzipping() {
        if (this.mDownloadDataHelper == null) {
            return false;
        }
        Map<Integer, CityDataBean> cityDataBeanList = this.mDownloadDataHelper.getCityDataBeanList();
        if (cityDataBeanList != null) {
            long j = Long.MAX_VALUE;
            for (CityDataBean cityDataBean : cityDataBeanList.values()) {
                if (cityDataBean.getUnzippingStartTime() != Long.MAX_VALUE) {
                    L.i(TAG, "adcode: " + cityDataBean.getAdcode() + " is in unZipping,startTime:" + cityDataBean.getUnzippingStartTime());
                    if (j == Long.MAX_VALUE || cityDataBean.getUnzippingStartTime() < j) {
                        j = cityDataBean.getUnzippingStartTime();
                    }
                }
            }
            if (j != Long.MAX_VALUE) {
                L.i(TAG, "hasDataBlockedInUnzipping earliestUnzippingTime:" + j + ",current elapsedRealtime:" + SystemClock.elapsedRealtime());
                return SystemClock.elapsedRealtime() - j > CityDataBean.UNZIPPING_BLOCKING_TIME;
            }
        }
        return false;
    }

    public Disposable registerLaneDataObserver(@NonNull DisposableObserver<LaneDataAction> disposableObserver) {
        LaneMapDataServiceWrapper laneMapDataServiceWrapper = this.mLaneMapDataServiceWrapper;
        if (laneMapDataServiceWrapper == null) {
            if (L.ENABLE) {
                L.w(TAG, "registerDownloadObserver error:LNDSService is not init yet!");
                return null;
            }
            return null;
        }
        return laneMapDataServiceWrapper.registerLaneDataObserver(disposableObserver);
    }

    public MapNum requestLaneMapNum(IMapNumObserver iMapNumObserver) {
        LaneMapDataServiceWrapper laneMapDataServiceWrapper = this.mLaneMapDataServiceWrapper;
        if (laneMapDataServiceWrapper == null) {
            return null;
        }
        return laneMapDataServiceWrapper.requestLaneMapNum(iMapNumObserver);
    }

    public MapNum requestLane30MapNum(IMapNumObserver iMapNumObserver) {
        LaneMapDataServiceWrapper laneMapDataServiceWrapper = this.mLaneMapDataServiceWrapper;
        if (laneMapDataServiceWrapper == null) {
            return null;
        }
        return laneMapDataServiceWrapper.requestLane30MapNum(iMapNumObserver);
    }

    private Observer<LaneDataAction> createLaneDataObserver() {
        return new DisposableObserver<LaneDataAction>() { // from class: com.xiaopeng.montecarlo.navcore.download.MapDataManager.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(@io.reactivex.annotations.NonNull Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(@io.reactivex.annotations.NonNull LaneDataAction laneDataAction) {
                if (laneDataAction.getActionCode() == 1) {
                    MapDataManager.this.getMapNumHelper().initLaneMapNum();
                } else {
                    MapDataManager.this.mLaneDataLogHelper.sendDataLogFromLaneDataAction(laneDataAction);
                }
            }
        };
    }

    /* loaded from: classes2.dex */
    class NetworkChangeListener implements IXPNetworkListener {
        NetworkChangeListener() {
        }

        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            if (z && MapDataManager.this.mMapDataServiceWrapper.isHotUpdateDataListFetchFailed()) {
                L.i(MapDataManager.TAG, "onNetworkChanged requestCheckHotUpdate");
                MapDataManager.this.mMapDataServiceWrapper.requestCheckHotUpdate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class DownloadDataChangeCallback implements IDownloadDataChangeCallback {
        private long mLastTimes = 0;

        DownloadDataChangeCallback() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        @WorkerThread
        public void onCityDataFetched() {
            L.i(MapDataManager.TAG, "onCityDataFetched");
            MapDataManager.this.refreshAllCityAndProvinceData();
            MapDataManager.this.mIsCompletedInitialized = true;
            Iterator it = MapDataManager.this.mDataChangeCallbackList.iterator();
            while (it.hasNext()) {
                ((IDownloadDataChangeCallback) it.next()).onCityDataFetched();
            }
            if (MapDataManager.this.mNetworkChangeListener != null) {
                XPNetworkManager.INSTANCE.removeNetworkListener(MapDataManager.this.mNetworkChangeListener);
                MapDataManager.this.mNetworkChangeListener = null;
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        @WorkerThread
        public void onCityListCreated() {
            L.i(MapDataManager.TAG, "onCityListCreated");
            MapDataManager.this.handleOnCityListCreated();
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        @WorkerThread
        public void onOperated(OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList) {
            L.Tag tag = MapDataManager.TAG;
            L.i(tag, "onOperated: " + operationTypeEnum + " " + arrayList);
            if (MapDataManager.this.mDownloadDataHelper == null) {
                L.w(MapDataManager.TAG, "mDownloadDataHelper hasn't init yet");
            } else {
                Stream stream = ((ArrayList) Optional.ofNullable(arrayList).orElse(new ArrayList())).stream();
                final DownloadDataHelper downloadDataHelper = MapDataManager.this.mDownloadDataHelper;
                downloadDataHelper.getClass();
                stream.map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$iJLhYu7l1EJXZHPZ99YD3U-cOm4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return DownloadDataHelper.this.getRealCityDataBean(((Integer) obj).intValue());
                    }
                }).filter($$Lambda$qRBVtvAYnDDljMDqhMYo8lNz7DA.INSTANCE).forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataManager$DownloadDataChangeCallback$GIYpjh9cmEzhpho-wtssmJuwQvw
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        MapDataManager.DownloadDataChangeCallback.this.lambda$onOperated$0$MapDataManager$DownloadDataChangeCallback((CityDataBean) obj);
                    }
                });
            }
            Iterator it = MapDataManager.this.mDataChangeCallbackList.iterator();
            while (it.hasNext()) {
                ((IDownloadDataChangeCallback) it.next()).onOperated(operationTypeEnum, arrayList);
            }
            if (operationTypeEnum != OperationTypeEnum.OPERATION_TYPE_PAUSE || MapDataManager.this.mMapDataOperator == null) {
                return;
            }
            MapDataManager.this.mMapDataOperator.retriggerAutoDownload();
        }

        public /* synthetic */ void lambda$onOperated$0$MapDataManager$DownloadDataChangeCallback(CityDataBean cityDataBean) {
            CityDownLoadItem cityDownLoadItem = MapDataManager.this.mMapDataServiceWrapper.getCityDownLoadItem(cityDataBean.getAdcode());
            if (cityDownLoadItem != null) {
                cityDataBean.refreshData(cityDownLoadItem);
            }
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        @WorkerThread
        public void onDownLoadStatus(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
            CityDataBean realCityDataBean;
            L.Tag tag = MapDataManager.TAG;
            L.i(tag, "onDownLoadStatus, adcode: " + i + " taskCode: " + taskStatusCodeEnum + " errCode: " + operationErrCodeEnum);
            if (MapDataManager.this.mDownloadDataHelper == null || MapDataManager.this.mDownloadDataHelper.getRealCityDataBean(i) == null || (realCityDataBean = MapDataManager.this.mDownloadDataHelper.getRealCityDataBean(i)) == null) {
                return;
            }
            realCityDataBean.refreshData(MapDataManager.this.mMapDataServiceWrapper.getCityDownLoadItem(i));
            if (TaskStatusCodeEnum.TASK_STATUS_CODE_SUCCESS == taskStatusCodeEnum) {
                handleRefreshProvince(realCityDataBean, i, taskStatusCodeEnum);
            }
            Iterator it = MapDataManager.this.mDataChangeCallbackList.iterator();
            while (it.hasNext()) {
                ((IDownloadDataChangeCallback) it.next()).onDownLoadStatus(i, taskStatusCodeEnum, operationErrCodeEnum);
            }
            if (TaskStatusCodeEnum.TASK_STATUS_CODE_SUCCESS == taskStatusCodeEnum || TaskStatusCodeEnum.TASK_STATUS_CODE_ERR == taskStatusCodeEnum) {
                MapDataManager.this.handleDataDownloadComplete(i, operationErrCodeEnum.getId(), realCityDataBean);
            }
            if (TaskStatusCodeEnum.TASK_STATUS_CODE_DOING == taskStatusCodeEnum) {
                MapDataManager.this.handleDataDownloadComplete(i);
            }
            if (CarFeatureManager.INSTANCE.isMapDataPreInstalled()) {
                if (TaskStatusCodeEnum.TASK_STATUS_CODE_SUCCESS == taskStatusCodeEnum) {
                    MapDataManager.this.onOneCityAutoDownloadReady(Integer.valueOf(i));
                }
                if (TaskStatusCodeEnum.TASK_STATUS_CODE_ERR == taskStatusCodeEnum || TaskStatusCodeEnum.TASK_STATUS_CODE_PAUSE == taskStatusCodeEnum) {
                    L.Tag tag2 = MapDataManager.TAG;
                    L.i(tag2, "MSG_ONE_CITY_AUTO_DOWNLOAD_RETRY " + i + ", last taskcode=" + taskStatusCodeEnum);
                    MapDataManager.this.mMementoHelper.retryDownload(Integer.valueOf(i));
                    MapDataManager.this.onOneCityAutoDownloadReady(null);
                }
            }
        }

        private void handleRefreshProvince(@NonNull CityDataBean cityDataBean, int i, TaskStatusCodeEnum taskStatusCodeEnum) {
            ProvinceDataBean realProvinceDataBean;
            ProvinceDataBean provinceDataBean = cityDataBean.getProvinceDataBean();
            if (provinceDataBean == null || MapDataManager.this.mDownloadDataHelper == null) {
                return;
            }
            provinceDataBean.refreshData();
            MapDataManager mapDataManager = MapDataManager.this;
            if (mapDataManager.getNearbyCityAdCodeList(mapDataManager.getCurrentCityAdCode()).contains(Integer.valueOf(i)) && (realProvinceDataBean = MapDataManager.this.mDownloadDataHelper.getRealProvinceDataBean(ContextUtils.getString(R.string.map_data_nearby_city))) != null) {
                realProvinceDataBean.refreshData();
            }
            MapDataManager.this.calculateAllProvinceDataSize();
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        @WorkerThread
        public void onPercent(Integer num, Integer num2, Float f) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTimes > 1000) {
                this.mLastTimes = currentTimeMillis;
                handleOnPercent(num.intValue(), num2.intValue(), f.floatValue());
            }
        }

        private void handleOnPercent(int i, int i2, float f) {
            if (MapDataManager.this.mDownloadDataHelper == null) {
                L.w(MapDataManager.TAG, "handleOnPercent, mDownloadDataHelper is null");
                return;
            }
            CityDataBean realCityDataBean = MapDataManager.this.mDownloadDataHelper.getRealCityDataBean(i);
            if (realCityDataBean != null) {
                realCityDataBean.refreshPercent(f);
                Iterator it = MapDataManager.this.mDataChangeCallbackList.iterator();
                while (it.hasNext()) {
                    ((IDownloadDataChangeCallback) it.next()).onPercent(Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f));
                }
            }
        }
    }
}
