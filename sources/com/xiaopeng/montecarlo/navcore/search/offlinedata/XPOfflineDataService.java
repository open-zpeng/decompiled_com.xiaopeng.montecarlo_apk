package com.xiaopeng.montecarlo.navcore.search.offlinedata;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.montecarlo.navcore.database.KeywordDataHelper;
import com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper;
import com.xiaopeng.montecarlo.navcore.database.ScratchSpotDataHelper;
import com.xiaopeng.montecarlo.navcore.database.ServiceCenterDataHelper;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IBizService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IXUIDataService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.BizCommonConfigsBySingleCodeRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDownloadRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.XUIResourceRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.BizCommonConfigsBySingleCodeResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviOfflineDataVersionResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.XUIResourceResponse;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPCommonCfgParam;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.http.HttpDownloadUtil;
import com.xiaopeng.montecarlo.root.http.MD5Encrypt;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.ZipUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XPOfflineDataService {
    private static final String ASSETS_JSON_DATA = "keyword.json";
    private static final String ASSETS_SEAMLESS = "seamlessassets.zip";
    private static final String CATEGORY_DOWNLOAD_CAR_SERVICE = "1000100";
    private static final String CATEGORY_DOWNLOAD_CAR_WASH = "010500";
    private static final String CATEGORY_DOWNLOAD_LCC_GEO_FENCE = "1070100";
    private static final String CATEGORY_DOWNLOAD_SCRATCH_SPOT = "1030100";
    public static final String CHARGE_DEFAULT_VERSION_ID = "197001010000";
    public static final String DEFAULT_VERSION_ID = "19700101000000";
    private static final L.Tag TAG = new L.Tag("XPOfflineDataService");
    private static final int TYPE_DOWNLOAD_POI = 1;
    private static final int TYPE_DOWNLOAD_SEAMLESS = 2;
    private List<XPKeywordConfigInfo> mKeywordList;
    private IXUIDataService mXUIDataService = (IXUIDataService) HttpClientManager.getInstance().getService(IXUIDataService.class);
    private IBizService mBizService = (IBizService) HttpClientManager.getInstance().getService(IBizService.class);
    private INaviSearchService mNaviSearchService = (INaviSearchService) HttpClientManager.getInstance().getService(INaviSearchService.class);
    private ChargeDataProvider mChargeDataProvider = new ChargeDataProvider();

    public boolean initKeywordConfigData() {
        if (RootUtil.isTabletApp()) {
            return initAssetsData();
        }
        XPKeywordConfigResponse queryXPConfigCfgData = queryXPConfigCfgData();
        if (queryXPConfigCfgData == null) {
            if (L.ENABLE) {
                L.d(TAG, "initKeywordConfigData xpKeywordConfigResponse is null");
            }
            initAssetsData();
            return false;
        }
        String keywordConfigVersion = SettingWrapper.getKeywordConfigVersion();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "initKeywordConfigData currentVersion:" + keywordConfigVersion + ", newVersion:" + queryXPConfigCfgData.getVersion());
        }
        if (!TextUtils.isEmpty(keywordConfigVersion) && keywordConfigVersion.compareTo(queryXPConfigCfgData.getVersion()) >= 0) {
            SettingWrapper.setKeywordConfigUpdateTime(System.currentTimeMillis());
            initXPKeywordData();
            return true;
        }
        return updateKeywordConfigData(queryXPConfigCfgData);
    }

    private boolean initAssetsData() {
        XPKeywordConfigResponse xPKeywordConfigResponse = (XPKeywordConfigResponse) GsonUtil.fromJson(FileUtil.loadFromAssets(ASSETS_JSON_DATA), (Class<Object>) XPKeywordConfigResponse.class);
        if (xPKeywordConfigResponse == null || TextUtils.isEmpty(xPKeywordConfigResponse.getVersion())) {
            L.Tag tag = TAG;
            L.w(tag, "initAssetsData fatal. xpKeywordConfigResponse:" + xPKeywordConfigResponse);
            return true;
        }
        String keywordConfigVersion = SettingWrapper.getKeywordConfigVersion();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "initAssetsData currentVersion:" + keywordConfigVersion + ", newVersion:" + xPKeywordConfigResponse.getVersion());
        }
        if (TextUtils.isEmpty(keywordConfigVersion) || keywordConfigVersion.compareTo(xPKeywordConfigResponse.getVersion()) < 0) {
            return updateKeywordConfigData(xPKeywordConfigResponse);
        }
        initXPKeywordData();
        return true;
    }

    private boolean updateKeywordConfigData(XPKeywordConfigResponse xPKeywordConfigResponse) {
        if (xPKeywordConfigResponse == null || CollectionUtils.isEmpty(xPKeywordConfigResponse.getData())) {
            L.Tag tag = TAG;
            L.w(tag, "updateKeywordConfigData data is null.xpKeywordConfigResponse:" + xPKeywordConfigResponse);
            return false;
        }
        List<XPKeywordConfigInfo> data = xPKeywordConfigResponse.getData();
        for (XPKeywordConfigInfo xPKeywordConfigInfo : data) {
            if (xPKeywordConfigInfo != null && CollectionUtils.isNotEmpty(xPKeywordConfigInfo.getKeywordList())) {
                String json = GsonUtil.toJson(xPKeywordConfigInfo.getKeywordList());
                if (!TextUtils.isEmpty(json)) {
                    xPKeywordConfigInfo.setKeyword(json);
                }
            }
        }
        boolean replaceAll = KeywordDataHelper.replaceAll(data);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "updateDb insertResult:" + replaceAll);
        }
        if (replaceAll) {
            SettingWrapper.setKeywordConfigVersion(xPKeywordConfigResponse.getVersion());
            SettingWrapper.setKeywordConfigUpdateTime(System.currentTimeMillis());
            initXPKeywordData();
            return true;
        }
        return false;
    }

    private XPKeywordConfigResponse queryXPConfigCfgData() {
        BizCommonConfigsBySingleCodeResponse commonConfigsBySingleCode = this.mBizService.commonConfigsBySingleCode(new BizCommonConfigsBySingleCodeRequest().setCfgCode(XPCommonCfgParam.getCfgKey(XPCommonCfgParam.Configuration.APP_NAVI_KEYWORD)));
        if (commonConfigsBySingleCode == null) {
            return null;
        }
        List<String> value = commonConfigsBySingleCode.getValue();
        if (CollectionUtils.isNotEmpty(value)) {
            return (XPKeywordConfigResponse) GsonUtil.fromJson(value.get(0), (Class<Object>) XPKeywordConfigResponse.class);
        }
        return null;
    }

    private void initXPKeywordData() {
        this.mKeywordList = KeywordDataHelper.listAll();
        if (CollectionUtils.isNotEmpty(this.mKeywordList)) {
            for (XPKeywordConfigInfo xPKeywordConfigInfo : this.mKeywordList) {
                if (xPKeywordConfigInfo != null && !TextUtils.isEmpty(xPKeywordConfigInfo.getKeyword())) {
                    xPKeywordConfigInfo.setKeywordList((List) GsonUtil.fromJson(xPKeywordConfigInfo.getKeyword(), new TypeToken<List<String>>() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataService.1
                    }.getType()));
                }
            }
        }
    }

    public List<XPKeywordConfigInfo> getXPKeywordData() {
        return this.mKeywordList;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean initChargeData() {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataService.initChargeData():boolean");
    }

    public boolean initXPServiceCenterData() {
        String xPServiceCenterDataVersion = SettingWrapper.getXPServiceCenterDataVersion();
        if (TextUtils.isEmpty(xPServiceCenterDataVersion)) {
            xPServiceCenterDataVersion = DEFAULT_VERSION_ID;
        }
        NaviOfflineDataVersionResponse queryServerCenterVersion = queryServerCenterVersion(xPServiceCenterDataVersion);
        if (queryServerCenterVersion == null) {
            if (L.ENABLE) {
                L.d(TAG, "initXPServiceCenterData offlineDataVersionResponse is null");
            }
            return false;
        }
        if (L.ENABLE) {
            L.d(TAG, "initXPServiceCenterData currentVersion:" + xPServiceCenterDataVersion + ", newVersion:" + queryServerCenterVersion.getLatestDataVersion());
        }
        if (xPServiceCenterDataVersion.compareTo(queryServerCenterVersion.getLatestDataVersion()) >= 0 || TextUtils.isEmpty(queryServerCenterVersion.getDataUrl())) {
            SettingWrapper.setXPServiceCenterUpdateTime(System.currentTimeMillis());
            return true;
        }
        if (!HttpDownloadUtil.downloadFromUrl(queryServerCenterVersion.getDataUrl(), RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SERVICE_CENTER_DATA_PATH, queryServerCenterVersion.getLatestDataVersion() + ".zip")) {
            if (L.ENABLE) {
                L.d(TAG, "initXPServiceCenterData download error");
            }
            return false;
        }
        String str = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SERVICE_CENTER_DATA_PATH + File.separator + queryServerCenterVersion.getLatestDataVersion() + ".zip";
        File file = new File(str);
        String unZipFolder = file.exists() ? ZipUtil.unZipFolder(str, file.getParent()) : "";
        if (TextUtils.isEmpty(unZipFolder)) {
            if (L.ENABLE) {
                L.d(TAG, "initXPServiceCenterData unzip error");
            }
            return false;
        } else if (ServiceCenterDataHelper.parseData(unZipFolder)) {
            SettingWrapper.setXPServiceCenterUpdateTime(System.currentTimeMillis());
            SettingWrapper.setXPServiceCenterDataVersion(queryServerCenterVersion.getLatestDataVersion());
            if (L.ENABLE) {
                L.d(TAG, "initXPServiceCenterData finished success");
            }
            return true;
        } else {
            return false;
        }
    }

    private NaviOfflineDataVersionResponse queryServerCenterVersion(String str) {
        return this.mNaviSearchService.download(new NaviDownloadRequest().setCategory("1000100").setType(1).setCurrentDataVersion(str));
    }

    @WorkerThread
    public boolean initSeamlessData() {
        String str;
        initSeamlessAssets();
        String seamlessDataVersion = SettingWrapper.getSeamlessDataVersion();
        if (TextUtils.isEmpty(seamlessDataVersion)) {
            seamlessDataVersion = DEFAULT_VERSION_ID;
        }
        NaviOfflineDataVersionResponse querySeamlessVersion = querySeamlessVersion(seamlessDataVersion);
        if (querySeamlessVersion == null) {
            if (L.ENABLE) {
                L.d(TAG, "initSeamlessData offlineDataVersionResponse is null");
            }
            return false;
        }
        if (L.ENABLE) {
            L.d(TAG, "initSeamlessData currentVersion:" + seamlessDataVersion + ", newVersion:" + querySeamlessVersion.getLatestDataVersion());
        }
        if (seamlessDataVersion.compareTo(querySeamlessVersion.getLatestDataVersion()) >= 0 || TextUtils.isEmpty(querySeamlessVersion.getDataUrl())) {
            SettingWrapper.setSeamlessUpdateTime(System.currentTimeMillis());
            return true;
        }
        if (HttpDownloadUtil.downloadFromUrl(querySeamlessVersion.getDataUrl(), RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_DATA_PATH, querySeamlessVersion.getLatestDataVersion() + ".zip")) {
            File[] listFiles = new File(RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_DATA_PATH).listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                File file = listFiles[i];
                if (file.isDirectory()) {
                    FileUtil.deleteDir(file);
                } else {
                    if (!file.getName().equalsIgnoreCase(querySeamlessVersion.getLatestDataVersion() + ".zip")) {
                        file.delete();
                    }
                }
            }
            String str2 = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_DATA_PATH + File.separator + querySeamlessVersion.getLatestDataVersion() + ".zip";
            File file2 = new File(str2);
            String mD5Three = MD5Encrypt.getMD5Three(str2);
            if (file2.exists()) {
                str = ZipUtil.unZipFolder(str2, file2.getParent());
            } else {
                if (L.ENABLE) {
                    L.d(TAG, "initSeamlessData unzip file not exist");
                }
                str = "";
            }
            if (L.ENABLE) {
                L.d(TAG, "initSeamlessData unzip path:" + str);
            }
            if (!TextUtils.isEmpty(str)) {
                SettingWrapper.setSeamlessDataVersion(querySeamlessVersion.getLatestDataVersion());
                SettingWrapper.setSeamlessUpdateTime(System.currentTimeMillis());
                SettingWrapper.setSeamlessDataPath(RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_DATA_PATH);
            }
            if (L.ENABLE) {
                L.d(TAG, "initSeamlessData md5 check:" + querySeamlessVersion.getMd5() + " " + mD5Three);
            }
            if (TextUtils.isEmpty(querySeamlessVersion.getMd5()) || !querySeamlessVersion.getMd5().equalsIgnoreCase(mD5Three)) {
                if (L.ENABLE) {
                    L.d(TAG, "initSeamlessData md5 check fail");
                }
                return false;
            }
            return true;
        }
        if (L.ENABLE) {
            L.d(TAG, "initSeamlessData download error");
        }
        return false;
    }

    private void initSeamlessAssets() {
        File file;
        if (new File(RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_ASSETS_DATA_PATH).exists()) {
            if (L.ENABLE) {
                L.d(TAG, "initSeamlessAssets save dir exists : " + file.getPath());
                return;
            }
            return;
        }
        FileUtil.copyFileFromAssets(ASSETS_SEAMLESS, RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_ASSETS_DATA_PATH, ASSETS_SEAMLESS);
        String str = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SEAMLESS_ASSETS_DATA_PATH + File.separator + ASSETS_SEAMLESS;
        File file2 = new File(str);
        if (file2.exists()) {
            ZipUtil.unZipFolder(str, file2.getParent());
        } else if (L.ENABLE) {
            L.d(TAG, "initSeamlessAssets unzip file not exist");
        }
    }

    private NaviOfflineDataVersionResponse querySeamlessVersion(String str) {
        return this.mNaviSearchService.download(new NaviDownloadRequest().setType(2).setCurrentDataVersion(str));
    }

    @WorkerThread
    public boolean initSRCarModelData() {
        File[] listFiles;
        XUIResourceResponse querySRCarModel = querySRCarModel();
        if (querySRCarModel == null) {
            if (L.ENABLE) {
                L.d(TAG, "initSRCarModelData response is null");
            }
            return false;
        }
        if (L.ENABLE) {
            L.d(TAG, "initSRCarModelData currentVersion:" + querySRCarModel.getCurrentVersion() + ", newVersion:" + querySRCarModel.getLatestVersion());
        }
        if (querySRCarModel.getCurrentVersion() == querySRCarModel.getLatestVersion()) {
            return true;
        }
        String content = querySRCarModel.getContent();
        if (TextUtils.isEmpty(content)) {
            L.e(TAG, "initSRCarModelData content is null, response = " + querySRCarModel);
            return false;
        }
        try {
            String string = new JSONObject(content).getString("url");
            if (TextUtils.isEmpty(string)) {
                L.e(TAG, "initSRCarModelData url is null, content = " + content);
                return false;
            }
            String str = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SR_CAR_MODEL_DATA_PATH;
            if (HttpDownloadUtil.downloadFromUrl(string, str, querySRCarModel.getLatestVersion() + ".zip")) {
                String str2 = str + File.separator + querySRCarModel.getLatestVersion();
                File file = new File(str2);
                if (file.isDirectory()) {
                    FileUtil.deleteDir(file);
                } else {
                    file.delete();
                }
                file.mkdir();
                String str3 = str2 + ".zip";
                if (new File(str3).exists()) {
                    String unZipFolder = ZipUtil.unZipFolder(str3, str2);
                    if (L.ENABLE) {
                        L.d(TAG, "initSRCarModelData unzip result:" + unZipFolder);
                    }
                    File file2 = new File(str);
                    String str4 = "" + querySRCarModel.getLatestVersion();
                    for (File file3 : file2.listFiles()) {
                        if (file3 != null) {
                            if (L.ENABLE) {
                                L.d(TAG, "child.name = " + file3.getName() + " path = " + file3.getAbsolutePath());
                            }
                            if (file3.isDirectory()) {
                                if (!str4.equalsIgnoreCase(file3.getName())) {
                                    FileUtil.deleteDir(file3);
                                }
                            } else {
                                file3.delete();
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(unZipFolder)) {
                        SettingWrapper.setSRCarModelVersion(querySRCarModel.getLatestVersion());
                        if (LaneServiceManager.getInstance().updateCarStyleInfo(true)) {
                            if (L.ENABLE) {
                                L.d(TAG, "initSRCarModelData success.");
                            }
                        } else {
                            if (L.ENABLE) {
                                L.d(TAG, "initSRCarModelData updateCarStyle error");
                            }
                            return false;
                        }
                    }
                    return true;
                }
                if (L.ENABLE) {
                    L.d(TAG, "initSRCarModelData unzip file not exist");
                }
                return false;
            }
            if (L.ENABLE) {
                L.d(TAG, "initSRCarModelData download error");
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            L.e(TAG, "initSRCarModelData content is invalid, content = " + content);
            return false;
        }
    }

    public long getCurrentVersion() {
        String str = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SR_CAR_MODEL_DATA_PATH;
        long sRCarModelVersion = SettingWrapper.getSRCarModelVersion();
        if (0 == sRCarModelVersion) {
            return sRCarModelVersion;
        }
        if (new File(str + File.separator + sRCarModelVersion).isDirectory()) {
            return sRCarModelVersion;
        }
        if (L.ENABLE) {
            L.d(TAG, "initSRCarModelData data is not directory.");
        }
        SettingWrapper.setSRCarModelVersion(0L);
        return 0L;
    }

    private XUIResourceResponse querySRCarModel() {
        long currentVersion = getCurrentVersion();
        HashMap hashMap = new HashMap();
        hashMap.put("car_subtype", "" + NavCoreUtil.getScissorsGate());
        hashMap.put("car_color", "" + NavCoreUtil.getBodyColor());
        return this.mXUIDataService.checkSRCarModel(new XUIResourceRequest().setAttrs(hashMap).setCurrentVersion(Long.valueOf(currentVersion)));
    }

    @WorkerThread
    public boolean initXPScratchSpotData() {
        String xPScratchSpotDataVersion = SettingWrapper.getXPScratchSpotDataVersion();
        if (TextUtils.isEmpty(xPScratchSpotDataVersion)) {
            xPScratchSpotDataVersion = DEFAULT_VERSION_ID;
        }
        NaviOfflineDataVersionResponse queryScratchSpotVersion = queryScratchSpotVersion(xPScratchSpotDataVersion);
        if (queryScratchSpotVersion == null) {
            if (L.ENABLE) {
                L.d(TAG, "initXPScratchSpotData offlineDataVersionResponse is null");
            }
            return false;
        }
        if (L.ENABLE) {
            L.d(TAG, "initXPScratchSpotData currentVersion:" + xPScratchSpotDataVersion + ", newVersion:" + queryScratchSpotVersion.getLatestDataVersion());
        }
        if (xPScratchSpotDataVersion.compareTo(queryScratchSpotVersion.getLatestDataVersion()) >= 0 || TextUtils.isEmpty(queryScratchSpotVersion.getDataUrl())) {
            SettingWrapper.setXPScratchSpotUpdateTime(System.currentTimeMillis());
            return true;
        }
        if (!HttpDownloadUtil.downloadFromUrl(queryScratchSpotVersion.getDataUrl(), RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SCRATCH_SPOT_DATA_PATH, queryScratchSpotVersion.getLatestDataVersion() + ".zip")) {
            if (L.ENABLE) {
                L.d(TAG, "initXPScratchSpotData download error");
            }
            return false;
        }
        String str = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SCRATCH_SPOT_DATA_PATH + File.separator + queryScratchSpotVersion.getLatestDataVersion() + ".zip";
        File file = new File(str);
        String unZipFolder = file.exists() ? ZipUtil.unZipFolder(str, file.getParent()) : "";
        if (TextUtils.isEmpty(unZipFolder)) {
            if (L.ENABLE) {
                L.d(TAG, "initXPScratchSpotData unzip error");
            }
            return false;
        } else if (ScratchSpotDataHelper.parseData(unZipFolder)) {
            SettingWrapper.setXPScratchSpotUpdateTime(System.currentTimeMillis());
            SettingWrapper.setXPScratchSpotDataVersion(queryScratchSpotVersion.getLatestDataVersion());
            if (L.ENABLE) {
                L.d(TAG, "initXPScratchSpotData finished success");
            }
            return true;
        } else {
            return false;
        }
    }

    private NaviOfflineDataVersionResponse queryScratchSpotVersion(String str) {
        return this.mNaviSearchService.download(new NaviDownloadRequest().setCategory(CATEGORY_DOWNLOAD_SCRATCH_SPOT).setType(1).setCurrentDataVersion(str));
    }

    @WorkerThread
    public boolean initLccGeoFenceData() {
        String str;
        long lccGeoFenceDataVersion = SettingWrapper.getLccGeoFenceDataVersion();
        XUIResourceResponse queryLccGeoFenceVersion = queryLccGeoFenceVersion(lccGeoFenceDataVersion);
        if (queryLccGeoFenceVersion == null) {
            if (L.ENABLE) {
                L.d(TAG, "initLccGeoFenceData response is null");
            }
            return false;
        }
        try {
            str = new JSONObject(queryLccGeoFenceVersion.getContent()).getString("url");
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        if (L.ENABLE) {
            L.d(TAG, "initLccGeoFenceData currentVersion:" + lccGeoFenceDataVersion + ", newVersion:" + queryLccGeoFenceVersion.getLatestVersion() + ", url:" + str);
        }
        if (lccGeoFenceDataVersion >= queryLccGeoFenceVersion.getLatestVersion() || TextUtils.isEmpty(str)) {
            SettingWrapper.setLccGeoFenceUpdateTime(System.currentTimeMillis());
            return true;
        }
        if (!HttpDownloadUtil.downloadFromUrl(str, RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_LCC_GEO_FENCE_DATA_PATH, queryLccGeoFenceVersion.getLatestVersion() + ".zip")) {
            if (L.ENABLE) {
                L.d(TAG, "initLccGeoFenceData download error");
            }
            return false;
        }
        String str2 = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_LCC_GEO_FENCE_DATA_PATH + File.separator + queryLccGeoFenceVersion.getLatestVersion() + ".zip";
        File file = new File(str2);
        String unZipFolder = file.exists() ? ZipUtil.unZipFolder(str2, file.getParent()) : "";
        if (TextUtils.isEmpty(unZipFolder)) {
            if (L.ENABLE) {
                L.d(TAG, "initLccGeoFenceData unzip error");
            }
            return false;
        } else if (LccGeoFenceDataHelper.parseData(unZipFolder)) {
            SettingWrapper.setLccGeoFenceUpdateTime(System.currentTimeMillis());
            SettingWrapper.setLccGeoFenceDataVersion(queryLccGeoFenceVersion.getLatestVersion());
            if (L.ENABLE) {
                L.d(TAG, "initLccGeoFenceData finished success");
            }
            return true;
        } else {
            return false;
        }
    }

    private XUIResourceResponse queryLccGeoFenceVersion(long j) {
        return this.mXUIDataService.checkSRCarModel(new XUIResourceRequest().setCategory(CATEGORY_DOWNLOAD_LCC_GEO_FENCE).setCurrentVersion(Long.valueOf(j)));
    }
}
