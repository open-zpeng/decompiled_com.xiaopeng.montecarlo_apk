package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.KeywordSearchResultV2;
import com.autonavi.gbl.search.observer.IKeyWordSearchObserverV2;
import com.autonavi.gbl.search.observer.impl.IKeyWordSearchObserverV2Impl;
@IntfAuto(target = IKeyWordSearchObserverV2.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class KeyWordSearchObserverV2Router extends IKeyWordSearchObserverV2Impl {
    private static BindTable BIND_TABLE = new BindTable(KeyWordSearchObserverV2Router.class);
    private static String PACKAGE = ReflexTool.PN(KeyWordSearchObserverV2Router.class);
    private TypeHelper mHelper;
    private IKeyWordSearchObserverV2 mObserver;
    private String mTargetId;

    private void $constructor(String str, IKeyWordSearchObserverV2 iKeyWordSearchObserverV2) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IKeyWordSearchObserverV2Impl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iKeyWordSearchObserverV2;
    }

    protected KeyWordSearchObserverV2Router(String str, IKeyWordSearchObserverV2 iKeyWordSearchObserverV2, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKeyWordSearchObserverV2);
    }

    protected KeyWordSearchObserverV2Router(String str, IKeyWordSearchObserverV2 iKeyWordSearchObserverV2) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKeyWordSearchObserverV2);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.IKeyWordSearchObserverV2Impl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IKeyWordSearchObserverV2Impl
    public void onGetKeyWordResult(int i, int i2, KeywordSearchResultV2 keywordSearchResultV2) {
        IKeyWordSearchObserverV2 iKeyWordSearchObserverV2 = this.mObserver;
        if (iKeyWordSearchObserverV2 != null) {
            iKeyWordSearchObserverV2.onGetKeyWordResult(i, i2, keywordSearchResultV2);
        }
    }
}
