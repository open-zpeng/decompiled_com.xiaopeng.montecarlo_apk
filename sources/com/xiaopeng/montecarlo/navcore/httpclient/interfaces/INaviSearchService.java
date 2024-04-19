package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDetailSearchRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDownloadRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviMultiQueryRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviQueryRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviDetailSearchResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviMultiQueryResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviOfflineDataVersionResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviQueryResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviSearchResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(path = "/v2/location", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes2.dex */
public interface INaviSearchService {
    @PostMapping(path = "/details")
    NaviDetailSearchResponse detailList(@RequestBody NaviDetailSearchRequest naviDetailSearchRequest);

    @PostMapping(path = "/data/download")
    NaviOfflineDataVersionResponse download(@RequestBody NaviDownloadRequest naviDownloadRequest);

    @PostMapping(path = "/data/download/encrypt")
    NaviOfflineDataVersionResponse downloadEncrypt(@RequestBody NaviDownloadRequest naviDownloadRequest);

    @PostMapping(path = "/multiQuery")
    NaviMultiQueryResponse multiQuery(@RequestBody NaviMultiQueryRequest naviMultiQueryRequest);

    @PostMapping(path = "/query")
    NaviQueryResponse query(@RequestBody NaviQueryRequest naviQueryRequest);

    @PostMapping(path = "/search")
    @Deprecated
    NaviSearchResponse search(@RequestBody NaviQueryRequest naviQueryRequest);
}
