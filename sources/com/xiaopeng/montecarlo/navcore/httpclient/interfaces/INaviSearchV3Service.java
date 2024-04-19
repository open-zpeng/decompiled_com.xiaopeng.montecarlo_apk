package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDownloadRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviOfflineDataVersionResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(path = "/v3/location", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes2.dex */
public interface INaviSearchV3Service {
    @PostMapping(path = "/data/download")
    NaviOfflineDataVersionResponse downloadPatch(@RequestBody NaviDownloadRequest naviDownloadRequest);
}
