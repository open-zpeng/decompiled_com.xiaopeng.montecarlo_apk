package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.dto.ChargeStationInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeAlwaysUseOnRemainRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeAlwaysUseRequest;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import java.util.List;
@RemoteClient(path = "/search/charging/station", serviceName = RemoteServiceNameEnum.SERVICE_CHARGE)
/* loaded from: classes3.dex */
public interface IBdSearchService {
    @PostMapping(path = "/always_use")
    List<ChargeStationInfo> alwaysUse(@RequestBody ChargeAlwaysUseRequest chargeAlwaysUseRequest);

    @PostMapping(path = "/always_use_on_remain")
    List<ChargeStationInfo> alwaysUseOnRemain(@RequestBody ChargeAlwaysUseOnRemainRequest chargeAlwaysUseOnRemainRequest);
}
