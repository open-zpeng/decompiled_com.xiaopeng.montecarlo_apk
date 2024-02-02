package com.xiaopeng.montecarlo.account.sync;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.navcore.account.AccountStore;
import com.xiaopeng.montecarlo.navcore.account.ObjectConvertor;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataResponseCode;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataUploadResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.SessionFailResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSettingService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviClearDataRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviSyncSettingsRequest;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpConst;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class SyncNetworkWrapper {
    private static final String LOCAL_VERSION_KEY = "localVersion";
    private static final L.Tag TAG = new L.Tag("Xp_Sync_net_wrapper");
    private static INaviSettingService sNaviSettingService = (INaviSettingService) HttpClientManager.getInstance().getService(INaviSettingService.class);

    public static AccountDataPullResponse getAccountSyncData(@NonNull XpUserData xpUserData, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, xpUserData.getSid());
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY, xpUserData.getOpenId());
        HashMap hashMap2 = new HashMap();
        hashMap2.put(LOCAL_VERSION_KEY, "" + SettingWrapper.getLocalVersion());
        return getAccountDataFromServer(xpUserData, hashMap, hashMap2, z);
    }

    private static AccountDataPullResponse getAccountDataFromServer(@NonNull XpUserData xpUserData, Map<String, String> map, Map<String, String> map2, boolean z) {
        String data = sNaviSettingService.getSettings(map2.get(LOCAL_VERSION_KEY), map).getData();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "SyncNetworkWrapper getAccountSyncData() body = " + data);
        }
        try {
            AccountDataPullResponse jsonToPullResponse = ObjectConvertor.jsonToPullResponse(data);
            if (jsonToPullResponse != null && z) {
                int code = jsonToPullResponse.getCode();
                checkSessionFailResult(xpUserData, code, data);
                if (11081120 == code) {
                    L.i(TAG, "getAccountDataFromServer session fail");
                    String sid = xpUserData.getSid();
                    if (map != null) {
                        map.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, sid);
                    }
                    return getAccountDataFromServer(xpUserData, map, map2, false);
                }
            }
            return jsonToPullResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AccountDataUploadResponse syncAccountData(@NonNull XpUserData xpUserData, boolean z, @NonNull List<DataOperation> list, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, xpUserData.getSid());
        hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY, xpUserData.getOpenId());
        return syncAccountDataToServer(xpUserData, hashMap, new NaviSyncSettingsRequest().setIgnoreError(Boolean.valueOf(z)).setLocalVersion(Long.valueOf(SettingWrapper.getLocalVersion())).setDataList(list), z2);
    }

    private static AccountDataUploadResponse syncAccountDataToServer(@NonNull XpUserData xpUserData, Map<String, String> map, NaviSyncSettingsRequest naviSyncSettingsRequest, boolean z) {
        String data = sNaviSettingService.syncSettings(naviSyncSettingsRequest, map).getData();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "SyncNetworkWrapper syncAccountData() body = " + data);
        }
        try {
            AccountDataUploadResponse jsonToUploadResponse = ObjectConvertor.jsonToUploadResponse(data);
            if (jsonToUploadResponse != null && z) {
                int code = jsonToUploadResponse.getCode();
                checkSessionFailResult(xpUserData, code, data);
                if (11081120 == code) {
                    L.i(TAG, "syncAccountDataToServer session fail");
                    String sid = xpUserData.getSid();
                    if (map != null) {
                        map.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, sid);
                    }
                    return syncAccountDataToServer(xpUserData, map, naviSyncSettingsRequest, false);
                }
            }
            return jsonToUploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            if (L.ENABLE) {
                L.d(TAG, "SyncNetworkWrapper response null ");
                return null;
            }
            return null;
        }
    }

    public static void checkSessionFailResult(@NonNull XpUserData xpUserData, int i, String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "SyncNetworkWrapper checkSessionFailResult() code: " + i);
        }
        if (11081120 == i) {
            try {
                SessionFailResponse jsonToSessionFailResponse = ObjectConvertor.jsonToSessionFailResponse(str);
                if (jsonToSessionFailResponse == null || jsonToSessionFailResponse.getData() == null) {
                    return;
                }
                if (xpUserData.isCurrentLoginUser()) {
                    SettingWrapper.saveAccountSid("" + jsonToSessionFailResponse.getData().getSid());
                }
                xpUserData.setSid("" + jsonToSessionFailResponse.getData().getSid());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (AccountDataResponseCode.isNeedReLogin(i)) {
            AccountStore.getInstance().clearCurrentXpAccountInfo();
            AccountManager.getInstance().startAccountInit();
        }
    }

    public static AccountDeleteUserDataResponse deleteUserData(@NonNull XpUserData xpUserData, int i, int i2, Map<Integer, List<Integer>> map) {
        if (XPAccountServiceWrapper.getInstance().isLoginXp() && xpUserData.isCurrentLoginUser()) {
            String sid = xpUserData.getSid();
            String openId = xpUserData.getOpenId();
            L.Tag tag = TAG;
            L.i(tag, "del_user_data localVerison:" + i + " deletedVersion:" + i2 + "  type:" + map);
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "del_user_data sId:" + sid + " openId:" + openId);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, sid);
            hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY, openId);
            return deleteUserData(xpUserData, (Map<String, String>) hashMap, new NaviClearDataRequest().setDataTypesMap(map).setDeletedVersion(Long.valueOf(i2)).setLocalVersion(Long.valueOf(i)), true);
        }
        L.i(TAG, "del_user_data  fail not login xp");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse deleteUserData(@androidx.annotation.NonNull com.xiaopeng.montecarlo.navcore.account.XpUserData r3, java.util.Map<java.lang.String, java.lang.String> r4, com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviClearDataRequest r5, boolean r6) {
        /*
            com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSettingService r0 = com.xiaopeng.montecarlo.account.sync.SyncNetworkWrapper.sNaviSettingService
            com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper r0 = r0.clearData(r5, r4)
            java.lang.Object r0 = r0.getData()
            java.lang.String r0 = (java.lang.String) r0
            com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse r1 = com.xiaopeng.montecarlo.navcore.account.ObjectConvertor.jsonToAccountDataClearResponse(r0)     // Catch: java.lang.Exception -> L3a
            if (r1 == 0) goto L40
            if (r6 == 0) goto L40
            int r6 = r1.getCode()     // Catch: java.lang.Exception -> L38
            checkSessionFailResult(r3, r6, r0)     // Catch: java.lang.Exception -> L38
            r2 = 11081120(0xa915a0, float:1.5527956E-38)
            if (r2 != r6) goto L40
            com.xiaopeng.montecarlo.root.util.L$Tag r6 = com.xiaopeng.montecarlo.account.sync.SyncNetworkWrapper.TAG     // Catch: java.lang.Exception -> L38
            java.lang.String r2 = "deleteUserData session fail"
            com.xiaopeng.montecarlo.root.util.L.i(r6, r2)     // Catch: java.lang.Exception -> L38
            java.lang.String r6 = r3.getSid()     // Catch: java.lang.Exception -> L38
            if (r4 == 0) goto L32
            java.lang.String r2 = "XP-Navi-Sid"
            r4.put(r2, r6)     // Catch: java.lang.Exception -> L38
        L32:
            r6 = 0
            com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse r3 = deleteUserData(r3, r4, r5, r6)     // Catch: java.lang.Exception -> L38
            return r3
        L38:
            r3 = move-exception
            goto L3d
        L3a:
            r3 = move-exception
            r4 = 0
            r1 = r4
        L3d:
            r3.printStackTrace()
        L40:
            boolean r3 = com.xiaopeng.montecarlo.root.util.L.ENABLE
            if (r3 == 0) goto L5a
            com.xiaopeng.montecarlo.root.util.L$Tag r3 = com.xiaopeng.montecarlo.account.sync.SyncNetworkWrapper.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "del_user_data  body = "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.xiaopeng.montecarlo.root.util.L.d(r3, r4)
        L5a:
            if (r1 != 0) goto L66
            com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse r1 = new com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse
            r1.<init>()
            r3 = 99
            r1.setCode(r3)
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.SyncNetworkWrapper.deleteUserData(com.xiaopeng.montecarlo.navcore.account.XpUserData, java.util.Map, com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviClearDataRequest, boolean):com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse");
    }
}
