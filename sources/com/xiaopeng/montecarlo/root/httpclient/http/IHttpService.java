package com.xiaopeng.montecarlo.root.httpclient.http;

import com.xiaopeng.montecarlo.root.httpclient.constants.RequestType;
import com.xiaopeng.montecarlo.root.httpclient.core.OriginNetworkResponseInfoOnlyForHttpClient;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientDefine;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientHeaderDefine;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public interface IHttpService {
    OriginNetworkResponseInfoOnlyForHttpClient executeWithHttpClient(RequestType requestType, String str, String str2, Map<String, String> map, Map<String, Object> map2, Object obj, String str3);

    String getSecretKey(RemoteClientDefine remoteClientDefine);

    String getUrl(RemoteClientDefine remoteClientDefine);

    Object parseJson2Object(OriginNetworkResponseInfoOnlyForHttpClient originNetworkResponseInfoOnlyForHttpClient, Type type, boolean z);

    default Map<String, String> injectHeaders(RemoteClientHeaderDefine remoteClientHeaderDefine) {
        return new HashMap();
    }
}
