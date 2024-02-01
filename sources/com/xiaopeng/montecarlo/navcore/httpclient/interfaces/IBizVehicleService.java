package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.responses.BizWeixinQrTicketResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(path = "/v5/vehicle", serviceName = RemoteServiceNameEnum.SERVICE_XP_BIZ)
/* loaded from: classes3.dex */
public interface IBizVehicleService {
    @PostMapping(path = "/weixin/qrTicket")
    BizWeixinQrTicketResponse getWeixinQrTicket();
}
