package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviChargeDataSetRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviChargeDownLockRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviChargeDataSetResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviChargeDownLockResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.Header;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
@Header(requireOpenId = true, requireSid = true)
@RemoteClient(path = "/v2/charge", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes2.dex */
public interface INaviChargeService {
    @PostMapping(path = "/dataset")
    NaviChargeDataSetResponse dataSet(@RequestBody NaviChargeDataSetRequest naviChargeDataSetRequest);

    @PostMapping(path = "/downLock")
    ResponseWrapper<NaviChargeDownLockResponse> downLock(@RequestBody NaviChargeDownLockRequest naviChargeDownLockRequest);
}
