package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;

import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.AssistantDateInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IAssistantDateService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantDateAttributesRequest;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseSceneDataHelper;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class DateService {
    private static final String DATE_PATTERN_FORMAT = "yyyy-MM-dd";
    private static final L.Tag TAG = new L.Tag("DateService");
    private IAssistantDateService mAssistantDateService = (IAssistantDateService) HttpClientManager.getInstance().getService(IAssistantDateService.class);
    private CruiseSceneDataHelper mCruiseSceneDataHelper = new CruiseSceneDataHelper();

    public int requestDate(DateParam dateParam) {
        if (dateParam == null) {
            L.w(TAG, "requestDate param is null");
        }
        Calendar calendar = Calendar.getInstance();
        AssistantDateInfo dateAttributes = this.mAssistantDateService.dateAttributes(new AssistantDateAttributesRequest().setDate(TimeFormatUtil.formatTime(calendar.getTimeInMillis(), "yyyy-MM-dd")).setVin(RootUtil.getVin()).setTs(Long.valueOf(calendar.getTimeInMillis())));
        if (dateAttributes == null) {
            return 0;
        }
        return this.mCruiseSceneDataHelper.checkGoHomeOrCompany(dateAttributes);
    }
}
