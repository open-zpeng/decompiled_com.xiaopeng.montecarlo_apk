package com.xiaopeng.montecarlo.root.httpclient.hosts;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpConst;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpEnvironment;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.lang.reflect.Type;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class XpServiceHostManager {
    private static final String ASSETS_JSON_DATA_XP_SERVICE_HOSTS = "xpServiceHosts.json";
    private static final L.Tag TAG = new L.Tag("XpServiceHostManager");
    private static final XpServiceHostManager sXpServiceHostManager = new XpServiceHostManager();
    private HashMap<String, XpServiceHost> mXpServiceHosts = new HashMap<>();

    public static XpServiceHostManager getInstance() {
        return sXpServiceHostManager;
    }

    public void init() {
        recreateServiceHostsMap();
    }

    private void recreateServiceHostsMap() {
        Type type = new TypeToken<HashMap<String, XpServiceHost>>() { // from class: com.xiaopeng.montecarlo.root.httpclient.hosts.XpServiceHostManager.1
        }.getType();
        String loadFromAssets = FileUtil.loadFromAssets(ASSETS_JSON_DATA_XP_SERVICE_HOSTS);
        if (loadFromAssets == null) {
            L.w(TAG, "read file failed, json is null");
        }
        try {
            HashMap<String, XpServiceHost> hashMap = (HashMap) GsonUtil.fromJson(loadFromAssets, type);
            if (CollectionUtils.isNotEmpty(hashMap)) {
                this.mXpServiceHosts = hashMap;
            }
        } catch (JsonSyntaxException unused) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.longLog(tag, "fail to parse json:" + loadFromAssets);
            }
        }
    }

    public String getUrl(RemoteServiceNameEnum remoteServiceNameEnum) {
        XpServiceHost xpServiceHost = this.mXpServiceHosts.get(remoteServiceNameEnum.getValue());
        String str = "";
        if (xpServiceHost == null) {
            L.Tag tag = TAG;
            L.w(tag, "getUrl failed for " + remoteServiceNameEnum);
            return "";
        }
        HttpEnvironment environmentByService = getEnvironmentByService(remoteServiceNameEnum);
        int i = AnonymousClass2.$SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment[environmentByService.ordinal()];
        if (i == 1) {
            str = xpServiceHost.getDevelop();
        } else if (i == 2) {
            str = xpServiceHost.getTest();
        } else if (i == 3) {
            str = xpServiceHost.getStaging();
        } else if (i == 4) {
            str = xpServiceHost.getProduct();
        }
        if (TextUtils.isEmpty(str)) {
            String test = !TextUtils.isEmpty(xpServiceHost.getTest()) ? xpServiceHost.getTest() : xpServiceHost.getStaging();
            L.Tag tag2 = TAG;
            L.w(tag2, "No suitable url for " + remoteServiceNameEnum + " at " + environmentByService + " new url:" + test);
            return test;
        }
        return str;
    }

    public String getAppSecret(RemoteServiceNameEnum remoteServiceNameEnum) {
        int i = AnonymousClass2.$SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment[getEnvironmentByService(remoteServiceNameEnum).ordinal()];
        return (i == 1 || i == 2 || i == 3) ? HttpConst.APP_SECRET_TEST : i != 4 ? "" : HttpConst.APP_SECRET_RELEASE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.root.httpclient.hosts.XpServiceHostManager$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment;

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RemoteServiceNameEnum[RemoteServiceNameEnum.SERVICE_CHARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RemoteServiceNameEnum[RemoteServiceNameEnum.SERVICE_XP_BIZ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RemoteServiceNameEnum[RemoteServiceNameEnum.SERVICE_ASSISTANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RemoteServiceNameEnum[RemoteServiceNameEnum.SERVICE_CHARGE_STATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RemoteServiceNameEnum[RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RemoteServiceNameEnum[RemoteServiceNameEnum.SERVICE_XP_CHARGE_SEARCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RemoteServiceNameEnum[RemoteServiceNameEnum.SERVICE_XP_XUI.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment = new int[HttpEnvironment.values().length];
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment[HttpEnvironment.NETWORK_ENVIRONMENT_DEVELOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment[HttpEnvironment.NETWORK_ENVIRONMENT_TEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment[HttpEnvironment.NETWORK_ENVIRONMENT_STAGING.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$HttpEnvironment[HttpEnvironment.NETWORK_ENVIRONMENT_PRODUCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private HttpEnvironment getEnvironmentByService(RemoteServiceNameEnum remoteServiceNameEnum) {
        int intValue = HttpEnvironment.NETWORK_ENVIRONMENT_PRODUCT.getIntValue();
        switch (remoteServiceNameEnum) {
            case SERVICE_CHARGE:
                intValue = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_CHARGE_SERVICE_ENV, intValue);
                break;
            case SERVICE_XP_BIZ:
                intValue = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_BIZ_SERVICE_ENV, intValue);
                break;
            case SERVICE_ASSISTANT:
                intValue = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_ASSISTANT_SERVICE_ENV, intValue);
                break;
            case SERVICE_CHARGE_STATION:
                intValue = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_CHARGE_STATION_SERVICE_ENV, intValue);
                break;
            case SERVICE_MAP_NAVI_SERVER:
                intValue = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_MAP_SERVER_SERVICE_ENV, intValue);
                break;
            case SERVICE_XP_CHARGE_SEARCH:
                intValue = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_CHARGE_SERVICE_ENV, intValue);
                break;
            case SERVICE_XP_XUI:
                intValue = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_SERVICE_XP_XUI_SERVICE_ENV, intValue);
                break;
        }
        return HttpEnvironment.parseInt(intValue);
    }
}
