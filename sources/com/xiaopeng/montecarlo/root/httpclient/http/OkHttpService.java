package com.xiaopeng.montecarlo.root.httpclient.http;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.httpclient.IHttpDependency;
import com.xiaopeng.montecarlo.root.httpclient.constants.RequestType;
import com.xiaopeng.montecarlo.root.httpclient.core.OriginNetworkResponseInfoOnlyForHttpClient;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientDefine;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientHeaderDefine;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class OkHttpService extends AbstractHttpService {
    private static final L.Tag TAG = new L.Tag("OkHttpService");
    private OkHttpClient mOkHttpClient;

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public String getSecretKey(RemoteClientDefine remoteClientDefine) {
        return null;
    }

    public OkHttpService(IHttpDependency iHttpDependency) {
        super(iHttpDependency);
        this.mOkHttpClient = new OkHttpClient();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public String getUrl(RemoteClientDefine remoteClientDefine) {
        return remoteClientDefine.getSpecialUrl();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public Map<String, String> injectHeaders(RemoteClientHeaderDefine remoteClientHeaderDefine) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", "application/x-www-form-urlencoded ; charset=UTF-8");
        return hashMap;
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.http.IHttpService
    public OriginNetworkResponseInfoOnlyForHttpClient executeWithHttpClient(RequestType requestType, String str, String str2, Map<String, String> map, Map<String, Object> map2, Object obj, String str3) {
        Request.Builder builder = new Request.Builder();
        builder.url(str);
        if (CollectionUtils.isNotEmpty(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$root$httpclient$constants$RequestType[requestType.ordinal()];
        if (i == 1) {
            L.Tag tag = TAG;
            L.i(tag, "doGetSync, url=" + str);
            builder.get();
        } else if (i == 2) {
            L.Tag tag2 = TAG;
            L.i(tag2, "doGetSync, url=" + str);
            builder.post(RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), GsonUtil.toJson(obj)));
        }
        Request build = builder.build();
        int i2 = 400;
        String str4 = "no response";
        try {
            Response execute = this.mOkHttpClient.newCall(build).execute();
            i2 = execute.code();
            str4 = execute.message();
            r6 = execute.body() != null ? execute.body().string() : null;
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "response: " + r6 + ", path = " + str2);
            }
        } catch (IOException e) {
            L.printStackTrace(TAG, e);
        }
        return new OriginNetworkResponseInfoOnlyForHttpClient().setOriginNetworkResponseCode(i2).setOriginNetworkResponseMessage(str4).setOriginNetworkResponseData(r6);
    }

    /* renamed from: com.xiaopeng.montecarlo.root.httpclient.http.OkHttpService$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
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
    public Object parseJson2Object(OriginNetworkResponseInfoOnlyForHttpClient originNetworkResponseInfoOnlyForHttpClient, Type type, boolean z) {
        if (originNetworkResponseInfoOnlyForHttpClient == null) {
            L.i(TAG, "originResponse is null");
            return null;
        }
        int originNetworkResponseCode = originNetworkResponseInfoOnlyForHttpClient.getOriginNetworkResponseCode();
        String originNetworkResponseMessage = originNetworkResponseInfoOnlyForHttpClient.getOriginNetworkResponseMessage();
        String originNetworkResponseData = originNetworkResponseInfoOnlyForHttpClient.getOriginNetworkResponseData();
        if (TextUtils.isEmpty(originNetworkResponseData)) {
            L.i(TAG, "json is null");
            return null;
        }
        Object fromJson = GsonUtil.fromJson(originNetworkResponseData, type);
        if (z) {
            return new ResponseWrapper().setCode(originNetworkResponseCode).setMsg(originNetworkResponseMessage).setData(fromJson);
        }
        if (originNetworkResponseCode == 200) {
            return fromJson;
        }
        L.Tag tag = TAG;
        L.w(tag, "Response is error: " + originNetworkResponseCode + " " + originNetworkResponseMessage);
        return null;
    }
}
