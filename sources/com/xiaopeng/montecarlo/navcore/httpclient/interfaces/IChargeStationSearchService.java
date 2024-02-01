package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeDataSetRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.ChargeDataSetResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.ChargeSearchByOneResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(path = "/search/charging/station", serviceName = RemoteServiceNameEnum.SERVICE_XP_CHARGE_SEARCH)
@Deprecated
/* loaded from: classes3.dex */
public interface IChargeStationSearchService {
    @PostMapping(path = "/dataset")
    ChargeDataSetResponse dataSet(@RequestBody ChargeDataSetRequest chargeDataSetRequest);

    @PostMapping(path = "/search_by_one")
    ChargeSearchByOneResponse searchByOne(@RequestBody ChargeSearchByOneRequest chargeSearchByOneRequest);
}
