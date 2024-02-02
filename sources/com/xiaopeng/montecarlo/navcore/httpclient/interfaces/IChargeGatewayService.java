package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NavigateStationRemindRequest;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
@RemoteClient(serviceName = RemoteServiceNameEnum.SERVICE_CHARGE_STATION)
/* loaded from: classes2.dex */
public interface IChargeGatewayService {
    @PostMapping(path = "/station/navigateStationRemind")
    ResponseWrapper navigateStationRemind(@RequestBody NavigateStationRemindRequest navigateStationRemindRequest);
}
