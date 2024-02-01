package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.dto.DumpEnergyInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantPowerDumpEnergyRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantPowerKRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.AssistantPowerKResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import java.util.List;
@RemoteClient(path = "/power/distance", serviceName = RemoteServiceNameEnum.SERVICE_ASSISTANT)
/* loaded from: classes3.dex */
public interface IAssistantPowerService {
    @PostMapping(path = "/online/k")
    AssistantPowerKResponse calculateK(@RequestBody AssistantPowerKRequest assistantPowerKRequest);

    @PostMapping(path = "/dumpenergy")
    List<DumpEnergyInfo> dumpenergy(@RequestBody AssistantPowerDumpEnergyRequest assistantPowerDumpEnergyRequest);
}
