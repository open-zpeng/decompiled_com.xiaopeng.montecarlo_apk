package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantGetHomeOrCompanyRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantLocationFeedbackRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.AssistantGetHomeOrCompanyResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
@RemoteClient(path = "/location/recognition", serviceName = RemoteServiceNameEnum.SERVICE_ASSISTANT)
/* loaded from: classes2.dex */
public interface IAssistantLocationService {
    @PostMapping(path = "/feedback")
    ResponseWrapper feedback(@RequestBody AssistantLocationFeedbackRequest assistantLocationFeedbackRequest);

    @PostMapping(path = "/company")
    AssistantGetHomeOrCompanyResponse getCompany(@RequestBody AssistantGetHomeOrCompanyRequest assistantGetHomeOrCompanyRequest);

    @PostMapping(path = "/home")
    AssistantGetHomeOrCompanyResponse getHome(@RequestBody AssistantGetHomeOrCompanyRequest assistantGetHomeOrCompanyRequest);
}
