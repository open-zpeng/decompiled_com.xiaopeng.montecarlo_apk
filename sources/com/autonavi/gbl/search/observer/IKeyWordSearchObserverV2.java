package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.KeywordSearchResultV2;
import com.autonavi.gbl.search.router.KeyWordSearchObserverV2Router;
@IntfAuto(target = KeyWordSearchObserverV2Router.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IKeyWordSearchObserverV2 {
    void onGetKeyWordResult(int i, int i2, KeywordSearchResultV2 keywordSearchResultV2);
}
