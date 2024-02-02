package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.BizCommonConfigsBySingleCodeRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.BizCommonConfigsBySingleCodeResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(path = "/v5", serviceName = RemoteServiceNameEnum.SERVICE_XP_BIZ)
/* loaded from: classes2.dex */
public interface IBizService {
    @PostMapping(path = "/common/config/commonConfigsBySingleCode")
    BizCommonConfigsBySingleCodeResponse commonConfigsBySingleCode(@RequestBody BizCommonConfigsBySingleCodeRequest bizCommonConfigsBySingleCodeRequest);
}
