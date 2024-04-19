package com.xiaopeng.montecarlo.navcore.search.response;

import com.autonavi.gbl.search.model.SearchKeywordResult;
import com.xiaopeng.montecarlo.navcore.search.request.KeywordQueryRequest;
/* loaded from: classes3.dex */
public class XPKeywordResponse extends XPSearchResponse<SearchKeywordResult> {
    /* JADX WARN: Removed duplicated region for block: B:104:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0358 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0332  */
    @Override // com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.xiaopeng.montecarlo.navcore.search.XPSearchResult parseBody(@androidx.annotation.NonNull com.autonavi.gbl.search.model.SearchKeywordResult r19) {
        /*
            Method dump skipped, instructions count: 1001
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.search.response.XPKeywordResponse.parseBody(com.autonavi.gbl.search.model.SearchKeywordResult):com.xiaopeng.montecarlo.navcore.search.XPSearchResult");
    }

    private String getKeyword() {
        return this.mRequest instanceof KeywordQueryRequest ? ((KeywordQueryRequest) this.mRequest).getKeywordParam().getKeywords() : "";
    }
}
