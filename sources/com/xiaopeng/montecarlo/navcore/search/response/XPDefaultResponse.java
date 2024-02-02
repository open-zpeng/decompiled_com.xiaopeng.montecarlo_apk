package com.xiaopeng.montecarlo.navcore.search.response;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
/* loaded from: classes2.dex */
public class XPDefaultResponse extends XPSearchResponse {
    @Override // com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse
    XPSearchResult parseBody(@NonNull Object obj) {
        return new XPSearchResult();
    }
}
