package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchSuggestResult;
import com.autonavi.gbl.search.router.GSearchSuggestionObserverRouter;
@IntfAuto(target = GSearchSuggestionObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchSuggestionObserver {
    void onGetSuggestionResult(int i, int i2, SearchSuggestResult searchSuggestResult);
}
