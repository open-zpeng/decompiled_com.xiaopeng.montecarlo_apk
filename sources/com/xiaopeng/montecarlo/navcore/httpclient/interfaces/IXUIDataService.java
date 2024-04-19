package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.XUIResourceRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.XUIResourceResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(path = "/v1", serviceName = RemoteServiceNameEnum.SERVICE_XP_XUI)
/* loaded from: classes2.dex */
public interface IXUIDataService {
    @PostMapping(path = "/data/checkUpdate")
    XUIResourceResponse checkSRCarModel(@RequestBody XUIResourceRequest xUIResourceRequest);
}
