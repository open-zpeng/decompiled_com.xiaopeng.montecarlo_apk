package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.MapDataRequest;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
@RemoteClient(path = "/v2/map", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes2.dex */
public interface IMapDataService {
    @PostMapping(path = "/sync")
    ResponseWrapper<Object> uploadMapDataInfo(@RequestBody MapDataRequest mapDataRequest);
}
