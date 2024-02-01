package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.dto.AssistantDateInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantDateAttributesRequest;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(serviceName = RemoteServiceNameEnum.SERVICE_ASSISTANT)
/* loaded from: classes3.dex */
public interface IAssistantDateService {
    @PostMapping(path = "/date_attributes")
    AssistantDateInfo dateAttributes(@RequestBody AssistantDateAttributesRequest assistantDateAttributesRequest);
}
