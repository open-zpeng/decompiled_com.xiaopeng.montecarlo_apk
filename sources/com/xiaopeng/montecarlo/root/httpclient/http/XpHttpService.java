package com.xiaopeng.montecarlo.root.httpclient.http;

import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IBizHelper;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.httpclient.IHttpDependency;
import com.xiaopeng.montecarlo.root.httpclient.constants.EncryptTypeEnum;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpConst;
import com.xiaopeng.montecarlo.root.httpclient.constants.RequestType;
import com.xiaopeng.montecarlo.root.httpclient.core.OriginNetworkResponseInfoOnlyForHttpClient;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientDefine;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientHeaderDefine;
import com.xiaopeng.montecarlo.root.httpclient.hosts.XpServiceHostManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XpHttpService extends AbstractHttpService {
    private static final L.Tag TAG = new L.Tag("XpHttpService");

    public XpHttpService(IHttpDependency iHttpDependency) {
        super(iHttpDependency);
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public String getUrl(RemoteClientDefine remoteClientDefine) {
        return XpServiceHostManager.getInstance().getUrl(remoteClientDefine.getServiceName());
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public String getSecretKey(RemoteClientDefine remoteClientDefine) {
        return XpServiceHostManager.getInstance().getAppSecret(remoteClientDefine.getServiceName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.root.httpclient.http.XpHttpService$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RequestType = new int[RequestType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RequestType[RequestType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RequestType[RequestType.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public OriginNetworkResponseInfoOnlyForHttpClient executeWithHttpClient(RequestType requestType, String str, String str2, Map<String, String> map, Map<String, Object> map2, Object obj, String str3) {
        IResponse doGetSync;
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RequestType[requestType.ordinal()];
        if (i == 1) {
            doGetSync = doGetSync(str, str2, map, map2, str3);
        } else {
            doGetSync = i != 2 ? null : doPostSync(str, str2, map, map2, obj, str3);
        }
        int code = doGetSync != null ? doGetSync.code() : 400;
        String message = doGetSync != null ? doGetSync.message() : "no response";
        String body = doGetSync != null ? doGetSync.body() : null;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "response: " + body + ", path = " + str2);
        }
        return new OriginNetworkResponseInfoOnlyForHttpClient().setOriginNetworkResponseCode(code).setOriginNetworkResponseMessage(message).setOriginNetworkResponseData(body);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object parseJson2Object(com.xiaopeng.montecarlo.root.httpclient.core.OriginNetworkResponseInfoOnlyForHttpClient r10, java.lang.reflect.Type r11, boolean r12) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            int r1 = r10.getOriginNetworkResponseCode()
            int r2 = r10.getOriginNetworkResponseCode()
            java.lang.String r3 = r10.getOriginNetworkResponseMessage()
            java.lang.String r10 = r10.getOriginNetworkResponseData()
            boolean r4 = r9.isStringType(r11)
            if (r4 == 0) goto L1c
            goto Lb9
        L1c:
            if (r10 == 0) goto Lb8
            boolean r4 = android.text.TextUtils.isEmpty(r10)
            if (r4 != 0) goto Lb8
            com.google.gson.JsonParser r4 = new com.google.gson.JsonParser     // Catch: java.lang.Exception -> L9c
            r4.<init>()     // Catch: java.lang.Exception -> L9c
            com.google.gson.JsonElement r4 = r4.parse(r10)     // Catch: java.lang.Exception -> L9c
            if (r4 == 0) goto L85
            boolean r5 = r4.isJsonObject()     // Catch: java.lang.Exception -> L9d
            if (r5 == 0) goto L85
            com.google.gson.JsonObject r5 = r4.getAsJsonObject()     // Catch: java.lang.Exception -> L9d
            java.lang.String r6 = "data"
            com.google.gson.JsonElement r6 = r5.get(r6)     // Catch: java.lang.Exception -> L9d
            java.lang.String r7 = "code"
            com.google.gson.JsonElement r7 = r5.get(r7)     // Catch: java.lang.Exception -> L9d
            java.lang.String r8 = "msg"
            com.google.gson.JsonElement r5 = r5.get(r8)     // Catch: java.lang.Exception -> L9d
            if (r7 == 0) goto L59
            com.google.gson.JsonNull r8 = com.google.gson.JsonNull.INSTANCE     // Catch: java.lang.Exception -> L9d
            boolean r8 = r8.equals(r7)     // Catch: java.lang.Exception -> L9d
            if (r8 != 0) goto L59
            int r2 = r7.getAsInt()     // Catch: java.lang.Exception -> L9d
        L59:
            if (r7 == 0) goto Lb3
            if (r6 == 0) goto Lb3
            if (r5 == 0) goto Lb3
            com.google.gson.JsonNull r8 = com.google.gson.JsonNull.INSTANCE     // Catch: java.lang.Exception -> L9d
            boolean r8 = r8.equals(r7)     // Catch: java.lang.Exception -> L9d
            if (r8 != 0) goto L6b
            int r1 = r7.getAsInt()     // Catch: java.lang.Exception -> L9d
        L6b:
            com.google.gson.JsonNull r7 = com.google.gson.JsonNull.INSTANCE     // Catch: java.lang.Exception -> L9d
            boolean r7 = r7.equals(r5)     // Catch: java.lang.Exception -> L9d
            if (r7 != 0) goto L77
            java.lang.String r3 = r5.getAsString()     // Catch: java.lang.Exception -> L9d
        L77:
            com.google.gson.JsonNull r5 = com.google.gson.JsonNull.INSTANCE     // Catch: java.lang.Exception -> L9d
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Exception -> L9d
            if (r5 != 0) goto L81
            r4 = r6
            goto Lb3
        L81:
            com.google.gson.JsonNull r10 = com.google.gson.JsonNull.INSTANCE     // Catch: java.lang.Exception -> L9d
            r4 = r10
            goto Lb3
        L85:
            com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.root.httpclient.http.XpHttpService.TAG     // Catch: java.lang.Exception -> L9d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9d
            r6.<init>()     // Catch: java.lang.Exception -> L9d
            java.lang.String r7 = "error response: "
            r6.append(r7)     // Catch: java.lang.Exception -> L9d
            r6.append(r10)     // Catch: java.lang.Exception -> L9d
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L9d
            com.xiaopeng.montecarlo.root.util.L.e(r5, r6)     // Catch: java.lang.Exception -> L9d
            goto Lb3
        L9c:
            r4 = r0
        L9d:
            com.xiaopeng.montecarlo.root.util.L$Tag r5 = com.xiaopeng.montecarlo.root.httpclient.http.XpHttpService.TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "json is invalid json = "
            r6.append(r7)
            r6.append(r10)
            java.lang.String r10 = r6.toString()
            com.xiaopeng.montecarlo.root.util.L.i(r5, r10)
        Lb3:
            java.lang.Object r10 = com.xiaopeng.montecarlo.root.util.GsonUtil.fromJson(r4, r11)
            goto Lb9
        Lb8:
            r10 = r0
        Lb9:
            if (r12 == 0) goto Ld1
            com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper r11 = new com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper
            r11.<init>()
            com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper r11 = r11.setCode(r1)
            com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper r11 = r11.setResponseCode(r2)
            com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper r11 = r11.setMsg(r3)
            com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper r10 = r11.setData(r10)
            return r10
        Ld1:
            r11 = 200(0xc8, float:2.8E-43)
            if (r1 != r11) goto Ld6
            return r10
        Ld6:
            com.xiaopeng.montecarlo.root.util.L$Tag r10 = com.xiaopeng.montecarlo.root.httpclient.http.XpHttpService.TAG
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Response is error: code="
            r11.append(r12)
            r11.append(r1)
            java.lang.String r12 = ", msg="
            r11.append(r12)
            r11.append(r3)
            java.lang.String r11 = r11.toString()
            com.xiaopeng.montecarlo.root.util.L.w(r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.httpclient.http.XpHttpService.parseJson2Object(com.xiaopeng.montecarlo.root.httpclient.core.OriginNetworkResponseInfoOnlyForHttpClient, java.lang.reflect.Type, boolean):java.lang.Object");
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public Map<String, String> injectHeaders(RemoteClientHeaderDefine remoteClientHeaderDefine) {
        HashMap hashMap = new HashMap();
        if (remoteClientHeaderDefine == null) {
            return hashMap;
        }
        if (remoteClientHeaderDefine.getEncryptType() != null) {
            hashMap.put("XP-Encryption-Type", remoteClientHeaderDefine.getEncryptType().getValue());
        }
        if (remoteClientHeaderDefine.getClientType() != null) {
            hashMap.put("XP-Client-Type", remoteClientHeaderDefine.getClientType().getValue());
        }
        if (remoteClientHeaderDefine.getClientEncodingType() != null) {
            hashMap.put("XP-Client-Encoding", remoteClientHeaderDefine.getClientEncodingType().getValue());
        }
        if (remoteClientHeaderDefine.isRequireNonce()) {
            hashMap.put("XP-Nonce", String.valueOf(System.currentTimeMillis()));
        }
        if (remoteClientHeaderDefine.isRequireClientKey()) {
            hashMap.put("XP-Client", getXpClient());
        }
        if (remoteClientHeaderDefine.isRequireOpenId()) {
            String openId = this.mDependency.getOpenId();
            if (!TextUtils.isEmpty(openId)) {
                hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_OPENID_KEY, openId);
            } else {
                L.i(TAG, "openId is null");
            }
        }
        if (remoteClientHeaderDefine.isRequireSid()) {
            String sid = this.mDependency.getSid();
            if (!TextUtils.isEmpty(sid)) {
                hashMap.put(HttpConst.XP_CLIENT_XP_NAVI_SID_KEY, sid);
            } else {
                L.i(TAG, "sid is null");
            }
        }
        if (remoteClientHeaderDefine.isRequireVin()) {
            String vin = this.mDependency.getVin();
            if (!TextUtils.isEmpty(vin)) {
                hashMap.put(HttpConst.XP_VIN_KEY, vin);
            } else {
                L.i(TAG, "vin is null");
            }
        }
        if (remoteClientHeaderDefine.isRequireUserId()) {
            String userId = this.mDependency.getUserId();
            if (!TextUtils.isEmpty(userId)) {
                hashMap.put("XP-Uid", userId);
            } else {
                L.i(TAG, "userId is null");
            }
        }
        if (remoteClientHeaderDefine.isRequireOtp()) {
            String authToken = this.mDependency.getAuthToken();
            if (!TextUtils.isEmpty(authToken)) {
                hashMap.put(HttpConst.XP_OTP_KEY, authToken);
            } else {
                L.i(TAG, "otp token is null");
            }
        }
        return hashMap;
    }

    private String getXpClient() {
        return "di=" + this.mDependency.getHardwareId() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + HttpConst.XP_CLIENT_PARAMETER_PN + "=" + this.mDependency.getPackageName() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + HttpConst.XP_CLIENT_PARAMETER_VE + "=" + this.mDependency.getVersionCode() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + HttpConst.XP_CLIENT_PARAMETER_BR + "=Xiaopeng;" + HttpConst.XP_CLIENT_PARAMETER_MO + "=" + this.mDependency.getBuildModel() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + HttpConst.XP_CLIENT_PARAMETER_ST + "=1;" + HttpConst.XP_CLIENT_PARAMETER_SV + "=" + this.mDependency.getSystemVersion() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + HttpConst.XP_CLIENT_PARAMETER_NT + "=" + this.mDependency.getNetworkType() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + HttpConst.XP_CLIENT_PARAMETER_T + "=" + System.currentTimeMillis();
    }

    private IResponse doGetSync(String str, String str2, Map<String, String> map, Map<String, Object> map2, String str3) {
        if (str == null || str2 == null) {
            L.Tag tag = TAG;
            L.i(tag, "doGetSync, Invalid serviceName/path: " + str + " " + str2);
            return null;
        }
        IRequest createRequest = createRequest(RequestType.GET, str, str2, map, map2, null, str3);
        if (createRequest == null) {
            return null;
        }
        try {
            L.Tag tag2 = TAG;
            L.i(tag2, "doGetSync, url=" + createRequest.getUrl());
            return createRequest.execute();
        } catch (IOException e) {
            L.printStackTrace(TAG, e);
            return null;
        }
    }

    private IResponse doPostSync(String str, String str2, Map<String, String> map, Map<String, Object> map2, Object obj, String str3) {
        if (str == null || str2 == null) {
            L.Tag tag = TAG;
            L.i(tag, "doPostSync, Invalid serviceName/path: " + str + " " + str2);
            return null;
        }
        IRequest createRequest = createRequest(RequestType.POST, str, str2, map, map2, obj, str3);
        if (createRequest == null) {
            L.i(TAG, "doPostSync, request is null");
            return null;
        }
        try {
            L.Tag tag2 = TAG;
            L.i(tag2, "doPostSync, url=" + createRequest.getUrl());
            return createRequest.execute();
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
            return null;
        }
    }

    private IRequest createRequest(RequestType requestType, String str, String str2, Map<String, String> map, Map<String, Object> map2, Object obj, String str3) {
        String str4;
        IBizHelper bizHelper = ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).bizHelper();
        if (TextUtils.isEmpty(str)) {
            L.w(TAG, "createPostRequest, url is null");
        }
        String str5 = str + str2;
        String formatParams = formatParams(map2);
        L.d(TAG, "formatParams params:" + formatParams);
        if (!TextUtils.isEmpty(formatParams)) {
            str5 = str5 + formatParams;
        }
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RequestType[requestType.ordinal()];
        if (i == 1) {
            bizHelper.get(str5);
            str4 = "";
        } else if (i == 2) {
            str4 = (String) Optional.ofNullable(obj).map(new Function() { // from class: com.xiaopeng.montecarlo.root.httpclient.http.-$$Lambda$geixJUWiUzDI1BPwaVBmOkAcSfg
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return GsonUtil.toJson(obj2);
                }
            }).orElse(new JSONObject().toString());
            bizHelper.post(str5, str4);
            if (obj == null) {
                L.d(TAG, "body is null, do you forget to add @RequestBody before param for url " + str + " ?");
            }
        } else {
            L.w(TAG, "requestType invalid");
            return null;
        }
        if (CollectionUtils.isNotEmpty(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bizHelper.extendBizHeader(entry.getKey(), entry.getValue());
            }
        }
        if (EncryptTypeEnum.parse(map.get("XP-Encryption-Type")) != EncryptTypeEnum.XP_ENCRYPT_TYPE_NONE) {
            bizHelper.enableSecurityEncoding();
            String str6 = map.get(HttpConst.XP_OTP_KEY);
            if (!TextUtils.isEmpty(str6)) {
                HashMap hashMap = new HashMap();
                hashMap.put(HttpConst.XP_OTP_KEY, str6);
                bizHelper.needAuthorizationInfo(hashMap);
            }
        }
        IRequest buildWithSecretKey = bizHelper.appId(HttpConst.APP_ID_VALUE).buildWithSecretKey(str3);
        L.d(TAG, "createRequest requestUri:" + str5 + ", header:" + map + ", queryParams:" + formatParams + ",bodyStr:" + str4);
        return buildWithSecretKey;
    }
}
