package com.xiaopeng.montecarlo.navcore.download;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.autonavi.gbl.data.HotUpdateService;
import com.autonavi.gbl.data.MapDataService;
import com.autonavi.gbl.data.model.AdminCode;
import com.autonavi.gbl.data.model.Area;
import com.autonavi.gbl.data.model.AreaExtraInfo;
import com.autonavi.gbl.data.model.AutoInitResponseData;
import com.autonavi.gbl.data.model.CityDownLoadItem;
import com.autonavi.gbl.data.model.CityItemInfo;
import com.autonavi.gbl.data.model.DataErrorType;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.HotUpdateCheckParam;
import com.autonavi.gbl.data.model.HotUpdateFileType;
import com.autonavi.gbl.data.model.InitConfig;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.observer.IDataInitObserver;
import com.autonavi.gbl.data.observer.IDataListObserver;
import com.autonavi.gbl.data.observer.IDownloadObserver;
import com.autonavi.gbl.data.observer.IEHPDataObserver;
import com.autonavi.gbl.data.observer.IErrorDataObserver;
import com.autonavi.gbl.data.observer.IHotUpdateCheckObserver;
import com.autonavi.gbl.data.observer.IHotUpdateFileObserver;
import com.autonavi.gbl.data.observer.IMapNumObserver;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.download.MapDataServiceWrapper;
import com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.helper.ErrorMapDataHelper;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
/* loaded from: classes3.dex */
public class MapDataServiceWrapper {
    public static final int DATA_LIST_FETCH_STATUS_FAILED = 3;
    public static final int DATA_LIST_FETCH_STATUS_NEED_GET_LIST = 4;
    public static final int DATA_LIST_FETCH_STATUS_NONE = 0;
    public static final int DATA_LIST_FETCH_STATUS_PROCESSING = 1;
    public static final int DATA_LIST_FETCH_STATUS_SUCCEED = 2;
    private static final int HOT_UPDATE_CHECK_INTERVAL = 60000;
    private static final int HOT_UPDATE_CHECK_TIME_OUT = 60000;
    private static final L.Tag TAG = new L.Tag("MapDataServiceWrapper");
    ErrorMapDataHelper mErrorMapDataHelper;
    private HotUpdateService mHotUpdateService;
    private MapDataService mIMapDataService;
    private final IDownloadDataChangeCallback mMapDownloadCallback;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    protected volatile int mHotUpdateDataListFetchStatus = 0;
    Handler mMapDataServiceHandler = new Handler(WorkThreadUtil.getInstance().getDataProcessThreadLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapDataServiceWrapper(IDownloadDataChangeCallback iDownloadDataChangeCallback) {
        this.mMapDownloadCallback = iDownloadDataChangeCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask(Runnable runnable) {
        this.mMapDataServiceHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getAdcodeList(int i) {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getAdcodeList, mIMapDataService is null");
            return null;
        }
        ArrayList<Integer> adcodeList = mapDataService.getAdcodeList(0, i);
        if (CollectionUtils.isEmpty(adcodeList)) {
            FileUtil.deleteFile(RootUtil.SD_CARD_NAVI_PATH + File.separator + "offline_conf" + File.separator + "all_city_compile.json");
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_ALL_CITY_COMPILE_ERROR);
            return null;
        }
        return adcodeList.stream().mapToInt(new ToIntFunction() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$gfCssnBJI7TKfXb_Jmv7raVYNkY
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return Integer.valueOf(((Integer) obj).intValue()).intValue();
            }
        }).toArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAdcodeByLonLat(XPCoordinate2DDouble xPCoordinate2DDouble) {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getAdCodeByLonLat, mIMapDataService is null");
            return -1;
        }
        return mapDataService.getAdcodeByLonLat(xPCoordinate2DDouble.mLon, xPCoordinate2DDouble.mLat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getUrcodeByAdcode(int i) {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getUrcodeByAdcode, mIMapDataService is null");
            return -1;
        }
        return mapDataService.getUrcode(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Area getArea(int i) {
        Area area = new Area();
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getArea, mIMapDataService is null");
            return area;
        }
        return mapDataService.getArea(0, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CityItemInfo getCityInfo(int i) {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getCityInfo, mIMapDataService is null");
            return null;
        }
        return mapDataService.getCityInfo(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Integer> getWorkingQueueAdcodeList() {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getWorkingQueueAdcodeList, mIMapDataService is null");
            return null;
        }
        return mapDataService.getWorkingQueueAdcodeList(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestMapNum(MapNum mapNum, IMapNumObserver iMapNumObserver) {
        HotUpdateService hotUpdateService = this.mHotUpdateService;
        if (hotUpdateService == null) {
            L.w(TAG, "requestMapNum, mIMapDataService is null");
        } else {
            hotUpdateService.requestMapNum(mapNum, iMapNumObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AreaExtraInfo getAreaExtraInfo(int i) {
        if (this.mIMapDataService == null) {
            L.w(TAG, "getAreaExtraInfo, mIMapDataService is null");
            return null;
        }
        AdminCode adminCode = new AdminCode();
        adminCode.euRegionCode = 156;
        adminCode.nAdCode = i;
        return this.mIMapDataService.getAreaExtraInfo(adminCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDataFileVersion(int i, int i2) {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getDataFileVersion, mIMapDataService is null");
            return null;
        }
        return mapDataService.getDataFileVersion(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initIMapDataService() {
        executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$A-k80Y8zf76IUr-ytV7FbYj7lW4
            @Override // java.lang.Runnable
            public final void run() {
                MapDataServiceWrapper.this.handleInitIMapDataService();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInitIMapDataService() {
        if (this.mIMapDataService == null) {
            this.mIMapDataService = (MapDataService) ServiceMgr.getServiceMgrInstance().getBLService(8);
            if (this.mIMapDataService == null) {
                L.e(TAG, "mIMapDataService is null, init failed");
                return;
            }
        }
        if (this.mIMapDataService.isInit() == 1) {
            InitConfig initConfig = new InitConfig();
            initConfig.strStoredPath = "";
            initConfig.strConfigfilePath = RootUtil.SD_CARD_NAVI_PATH + File.separator + "offline_conf";
            initConfig.mapDataMode = 0;
            int init = this.mIMapDataService.init(initConfig, new DataInitObserver());
            L.Tag tag = TAG;
            L.i(tag, "mIMapDataService.init result: " + init + " strConfigfilePath:" + initConfig.strConfigfilePath);
            this.mErrorMapDataHelper = new ErrorMapDataHelper();
            this.mIMapDataService.setErrorDataObserver(new ErrorDataObserver());
            this.mIMapDataService.setEHPDataObserver(new EHPDataObserver());
            int addNetDownloadObserver = this.mIMapDataService.addNetDownloadObserver(new DownloadObserver());
            L.Tag tag2 = TAG;
            L.i(tag2, "mIMapDataService.addDownloadObserver result: " + addNetDownloadObserver);
        }
        initHotUpdateService();
    }

    public synchronized boolean isHotUpdateDataListFetchFailed() {
        return this.mHotUpdateDataListFetchStatus == 3;
    }

    public synchronized int getHotUpdateDataListFetchStatus() {
        return this.mHotUpdateDataListFetchStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setHotUpdateDataListFetchStatus(int i) {
        this.mHotUpdateDataListFetchStatus = i;
        if (this.mHotUpdateDataListFetchStatus == 3) {
            scheduleCheckHotUpdate();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleCheckHotUpdate() {
        L.i(TAG, "scheduleCheckHotUpdate   ");
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.MapDataServiceWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                if (MapDataServiceWrapper.this.isHotUpdateDataListFetchFailed()) {
                    L.i(MapDataServiceWrapper.TAG, "scheduleCheckHotUpdate run");
                    if (!XPNetworkManager.INSTANCE.isNetworkConnected()) {
                        MapDataServiceWrapper.this.scheduleCheckHotUpdate();
                    } else {
                        MapDataServiceWrapper.this.requestCheckHotUpdate();
                    }
                }
            }
        }, 60000L);
    }

    private synchronized void scheduleRequestTimeOut() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.MapDataServiceWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                L.e(MapDataServiceWrapper.TAG, "requestTimeOut");
                MapDataServiceWrapper.this.setHotUpdateDataListFetchStatus(3);
            }
        }, 60000L);
    }

    private void initHotUpdateService() {
        executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$14G_ckERJG5sz4cEyvlig1MrxMw
            @Override // java.lang.Runnable
            public final void run() {
                MapDataServiceWrapper.this.handleInitHotUpdateService();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInitHotUpdateService() {
        this.mHotUpdateService = (HotUpdateService) ServiceMgr.getServiceMgrInstance().getBLService(22);
        this.mHotUpdateService.init();
        int isInit = this.mHotUpdateService.isInit();
        L.Tag tag = TAG;
        L.i(tag, "HotUpdateService init result: " + isInit);
        if (isInit == 3) {
            requestCheckHotUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestCheckHotUpdate() {
        setHotUpdateDataListFetchStatus(1);
        executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$BZlupUPp20vIA3gpd7onlRucNB4
            @Override // java.lang.Runnable
            public final void run() {
                MapDataServiceWrapper.this.handleRequestCheckHotUpdate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRequestCheckHotUpdate() {
        HotUpdateCheckObserver hotUpdateCheckObserver = new HotUpdateCheckObserver();
        HotUpdateCheckParam hotUpdateCheckParam = new HotUpdateCheckParam();
        String version = this.mHotUpdateService.getVersion();
        L.Tag tag = TAG;
        L.i(tag, "handleRequestCheckHotUpdate, version is " + version);
        hotUpdateCheckParam.strTbtVersion = version;
        int requestCheckHotUpdate = this.mHotUpdateService.requestCheckHotUpdate(hotUpdateCheckParam, hotUpdateCheckObserver);
        L.Tag tag2 = TAG;
        L.i(tag2, "requestCheckHotUpdate result: " + requestCheckHotUpdate);
        if (requestCheckHotUpdate <= 0) {
            setHotUpdateDataListFetchStatus(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGlobalDBFile() {
        executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$tue-0931u1WSrUoQRFEqwukdAtw
            @Override // java.lang.Runnable
            public final void run() {
                MapDataServiceWrapper.this.handleUpdateGlobalDBFile();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateGlobalDBFile() {
        if (this.mHotUpdateService == null) {
            L.w(TAG, "updateGlobalDBFile, mIMapDataService is null");
            return;
        }
        UpdateHotFileObserver updateHotFileObserver = new UpdateHotFileObserver();
        HotUpdateService hotUpdateService = this.mHotUpdateService;
        int requestHotUpdateFile = hotUpdateService.requestHotUpdateFile(0, RootUtil.SD_CARD_NAVI_PATH + File.separator + "offline_conf", updateHotFileObserver);
        L.Tag tag = TAG;
        L.i(tag, "requestHotUpdateFile result:" + requestHotUpdateFile);
        if (requestHotUpdateFile <= 0) {
            setHotUpdateDataListFetchStatus(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestDataListCheck() {
        executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$fpefn7tpaORhKyYRgDxbXC0_qD8
            @Override // java.lang.Runnable
            public final void run() {
                MapDataServiceWrapper.this.handleRequestDataListCheck();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRequestDataListCheck() {
        if (this.mIMapDataService == null) {
            L.w(TAG, "requestDataListCheck, mIMapDataService is null");
            return;
        }
        int requestDataListCheck = this.mIMapDataService.requestDataListCheck(0, "", new DataListObserver());
        L.Tag tag = TAG;
        L.i(tag, "requestDataListCheck, requestMint: " + requestDataListCheck);
        if (requestDataListCheck <= 0) {
            setHotUpdateDataListFetchStatus(3);
        } else {
            scheduleRequestTimeOut();
        }
    }

    boolean isDataUpdatedOnServer() {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "isDataUpdatedOnServer, mIMapDataService is null");
            return false;
        }
        return mapDataService.isDataUpdatedOnServer(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CityDownLoadItem getCityDownLoadItem(int i) {
        MapDataService mapDataService = this.mIMapDataService;
        if (mapDataService == null) {
            L.w(TAG, "getCityDownLoadItem, mIMapDataService is null");
            return null;
        }
        return mapDataService.getCityDownLoadItem(0, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startDownload(int i) {
        if (this.mIMapDataService == null || i < 0) {
            L.Tag tag = TAG;
            L.w(tag, "startDownload, mIMapDataService is null or adcode less than 0 ,adcode:" + i);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "startDownload, adcode = " + i);
        this.mIMapDataService.operate(0, 0, RootUtil.intToList(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pauseDownload(int i) {
        if (this.mIMapDataService == null || i < 0) {
            L.Tag tag = TAG;
            L.w(tag, "pauseDownload, mIMapDataService is null or adcode less than 0 ,adcode:" + i);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "pauseDownload, adcode = " + i);
        this.mIMapDataService.operate(0, 1, RootUtil.intToList(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelDownload(int i) {
        if (this.mIMapDataService == null || i < 0) {
            L.Tag tag = TAG;
            L.w(tag, "cancelDownload, mIMapDataService is null or adcode less than 0 ,adcode:" + i);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "cancelDownload, adcode = " + i);
        this.mIMapDataService.operate(0, 2, RootUtil.intToList(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteDownload(int i) {
        if (this.mIMapDataService == null || i < 0) {
            L.Tag tag = TAG;
            L.w(tag, "deleteDownload, mIMapDataService is null or adcode less than 0 ,adcode:" + i);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "deleteDownload, adcode = " + i);
        this.mIMapDataService.operate(0, 3, RootUtil.intToList(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteErrorData(int i) {
        if (this.mIMapDataService == null || i < 0) {
            L.Tag tag = TAG;
            L.w(tag, "deleteErrorData, mIMapDataService is null or adcode less than 0 ,adCode:" + i);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "deleteErrorData, adcode = " + i);
        this.mIMapDataService.deleteErrorData(i);
    }

    void multiDownload(int[] iArr) {
        if (this.mIMapDataService == null) {
            L.w(TAG, "multiDownload, mIMapDataService is null");
        } else if (iArr == null) {
            L.w(TAG, "multiDownload, choosedCityAdcodeList is null");
        } else {
            L.Tag tag = TAG;
            L.i(tag, "multiDownload, size = " + iArr.length);
            this.mIMapDataService.operate(0, 0, new ArrayList<>((Collection) Arrays.stream(iArr).boxed().collect(Collectors.toList())));
        }
    }

    void multiPause(int[] iArr) {
        if (this.mIMapDataService == null) {
            L.w(TAG, "multiPause, mIMapDataService is null");
        } else if (iArr == null) {
            L.w(TAG, "multiPause, choosedCityAdcodeList is null");
        } else {
            L.Tag tag = TAG;
            L.i(tag, "multiPause, size = " + iArr.length);
            this.mIMapDataService.operate(0, 1, new ArrayList<>((Collection) Arrays.stream(iArr).boxed().collect(Collectors.toList())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DataInitObserver implements IDataInitObserver {
        DataInitObserver() {
        }

        @Override // com.autonavi.gbl.data.observer.IDataInitObserver
        @MainThread
        public void onInit(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "1.BL_DataInitObserver, onInit result:" + i3 + " ,isDataUpdatedOnServer: " + MapDataServiceWrapper.this.isDataUpdatedOnServer() + " ,getHotUpdateDataListFetchStatus:" + MapDataServiceWrapper.this.getHotUpdateDataListFetchStatus());
            MapDataServiceWrapper mapDataServiceWrapper = MapDataServiceWrapper.this;
            final IDownloadDataChangeCallback iDownloadDataChangeCallback = mapDataServiceWrapper.mMapDownloadCallback;
            iDownloadDataChangeCallback.getClass();
            mapDataServiceWrapper.executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$EMINKOLz4WuhlKJEOKWKwjfXw5Y
                @Override // java.lang.Runnable
                public final void run() {
                    IDownloadDataChangeCallback.this.onCityListCreated();
                }
            });
            if (MapDataServiceWrapper.this.getHotUpdateDataListFetchStatus() == 4) {
                MapDataServiceWrapper.this.requestDataListCheck();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class EHPDataObserver implements IEHPDataObserver {
        EHPDataObserver() {
        }

        @Override // com.autonavi.gbl.data.observer.IEHPDataObserver
        public void onEHPDataExistedAdcodeList(int i, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "mIMapDataService.onEHPDataExistedAdcodeList result: " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class ErrorDataObserver implements IErrorDataObserver {
        ErrorDataObserver() {
        }

        @Override // com.autonavi.gbl.data.observer.IErrorDataObserver
        @MainThread
        public void onErrorNotify(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, final int i3, @DataErrorType.DataErrorType1 final int i4, final String str) {
            MapDataServiceWrapper.this.executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$ErrorDataObserver$QwkH8SQss1BmhxXaUUj6inSEj7w
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataServiceWrapper.ErrorDataObserver.this.lambda$onErrorNotify$0$MapDataServiceWrapper$ErrorDataObserver(i4, i3, str);
                }
            });
        }

        public /* synthetic */ void lambda$onErrorNotify$0$MapDataServiceWrapper$ErrorDataObserver(@DataErrorType.DataErrorType1 int i, int i2, String str) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "BL_ErrorDataObserver, onErrorNotify " + i + ", adcode=" + i2 + " ,errMsg =" + str);
            MapDataServiceWrapper.this.mErrorMapDataHelper.handlerDataError(i2, i);
        }

        @Override // com.autonavi.gbl.data.observer.IErrorDataObserver
        @MainThread
        public void onDeleteErrorData(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, int i4) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "BL_onDeleteErrorData, onDeleteErrorData " + i4 + ", adcode=" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class HotUpdateCheckObserver implements IHotUpdateCheckObserver {
        HotUpdateCheckObserver() {
        }

        @Override // com.autonavi.gbl.data.observer.IHotUpdateCheckObserver
        public void onInitNotify(int i, AutoInitResponseData autoInitResponseData) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "HotUpdateCheckObserver, onInitNotify: " + i);
            if (i == 0) {
                MapDataServiceWrapper.this.updateGlobalDBFile();
            } else {
                MapDataServiceWrapper.this.setHotUpdateDataListFetchStatus(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DownloadObserver implements IDownloadObserver {
        DownloadObserver() {
        }

        @Override // com.autonavi.gbl.data.observer.IDownloadObserver
        @MainThread
        public void onOperated(int i, int i2, @OperationType.OperationType1 int i3, final ArrayList<Integer> arrayList) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("BL_onOperated: ");
            sb.append(i3);
            sb.append(", adcodeList.size: ");
            sb.append(arrayList == null ? 0 : arrayList.size());
            L.i(tag, sb.toString());
            final OperationTypeEnum parse = OperationTypeEnum.parse(i3);
            MapDataServiceWrapper.this.executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$DownloadObserver$XG1R5Nyeg717XwAteq_ofrWy6es
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataServiceWrapper.DownloadObserver.this.lambda$onOperated$0$MapDataServiceWrapper$DownloadObserver(parse, arrayList);
                }
            });
        }

        public /* synthetic */ void lambda$onOperated$0$MapDataServiceWrapper$DownloadObserver(OperationTypeEnum operationTypeEnum, ArrayList arrayList) {
            MapDataServiceWrapper.this.mMapDownloadCallback.onOperated(operationTypeEnum, arrayList);
        }

        @Override // com.autonavi.gbl.data.observer.IDownloadObserver
        @MainThread
        public void onDownLoadStatus(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, final int i3, @TaskStatusCode.TaskStatusCode1 int i4, int i5) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "BL_onDownLoadStatus: downLoadMode = " + i + "; dataType = " + i2 + "; taskCode = " + i4 + "; errorCode = " + i5 + " adcode=" + i3);
            final TaskStatusCodeEnum parse = TaskStatusCodeEnum.parse(i4);
            final OperationErrCodeEnum parse2 = OperationErrCodeEnum.parse(i5);
            MapDataServiceWrapper.this.executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$DownloadObserver$o0g0ZFbrPPDH1edwrzvPPFbijzE
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataServiceWrapper.DownloadObserver.this.lambda$onDownLoadStatus$1$MapDataServiceWrapper$DownloadObserver(i3, parse, parse2);
                }
            });
        }

        public /* synthetic */ void lambda$onDownLoadStatus$1$MapDataServiceWrapper$DownloadObserver(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
            MapDataServiceWrapper.this.mMapDownloadCallback.onDownLoadStatus(i, taskStatusCodeEnum, operationErrCodeEnum);
        }

        @Override // com.autonavi.gbl.data.observer.IDownloadObserver
        @MainThread
        public void onPercent(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, final int i3, final int i4, final float f) {
            if (L.ENABLE) {
                L.Tag tag = MapDataServiceWrapper.TAG;
                L.d(tag, "BL_onPercent " + i3 + " " + f);
            }
            MapDataServiceWrapper.this.executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$MapDataServiceWrapper$DownloadObserver$RxJ7EVHJ6AuT6Q57oI-BW5YVHkA
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataServiceWrapper.DownloadObserver.this.lambda$onPercent$2$MapDataServiceWrapper$DownloadObserver(i3, i4, f);
                }
            });
        }

        public /* synthetic */ void lambda$onPercent$2$MapDataServiceWrapper$DownloadObserver(int i, int i2, float f) {
            MapDataServiceWrapper.this.mMapDownloadCallback.onPercent(Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class UpdateHotFileObserver implements IHotUpdateFileObserver {
        UpdateHotFileObserver() {
        }

        @Override // com.autonavi.gbl.data.observer.IHotUpdateFileObserver
        public void onHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, int i2, String str) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "3.BL_UpdateHotFileObserver, onHotUpdateFile " + i2 + " fileType: " + i);
            if (i2 == 0) {
                if (MapDataServiceWrapper.this.mIMapDataService.isInit() == 3) {
                    MapDataServiceWrapper.this.requestDataListCheck();
                    return;
                } else {
                    MapDataServiceWrapper.this.setHotUpdateDataListFetchStatus(4);
                    return;
                }
            }
            MapDataServiceWrapper.this.setHotUpdateDataListFetchStatus(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class DataListObserver implements IDataListObserver {
        DataListObserver() {
        }

        @Override // com.autonavi.gbl.data.observer.IDataListObserver
        @MainThread
        public void onRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
            L.Tag tag = MapDataServiceWrapper.TAG;
            L.i(tag, "4.BL_DataListObserver, onRequestDataListCheck downLoadMode: " + i + " dataType " + i2 + " errorCode " + i3);
            if (i3 == 0) {
                MapDataServiceWrapper.this.setHotUpdateDataListFetchStatus(2);
                MapDataServiceWrapper mapDataServiceWrapper = MapDataServiceWrapper.this;
                final IDownloadDataChangeCallback iDownloadDataChangeCallback = mapDataServiceWrapper.mMapDownloadCallback;
                iDownloadDataChangeCallback.getClass();
                mapDataServiceWrapper.executeTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.-$$Lambda$6zNhkaI4cuDEXZCPxagmPN5hI9I
                    @Override // java.lang.Runnable
                    public final void run() {
                        IDownloadDataChangeCallback.this.onCityDataFetched();
                    }
                });
                return;
            }
            MapDataServiceWrapper.this.setHotUpdateDataListFetchStatus(3);
        }
    }
}
