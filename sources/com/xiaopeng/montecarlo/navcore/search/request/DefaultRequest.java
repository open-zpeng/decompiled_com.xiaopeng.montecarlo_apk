package com.xiaopeng.montecarlo.navcore.search.request;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
/* loaded from: classes3.dex */
public class DefaultRequest extends Request {
    public DefaultRequest(BaseBuilder baseBuilder) {
        super(baseBuilder);
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.request.Request
    public XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse) {
        return new XPSearchResult();
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BaseBuilder {
        @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public Request build() {
            return new DefaultRequest(this);
        }
    }
}
