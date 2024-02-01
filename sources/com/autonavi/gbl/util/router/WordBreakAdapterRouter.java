package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.IWordBreakAdapter;
import com.autonavi.gbl.util.observer.impl.IWordBreakAdapterImpl;
import java.util.ArrayList;
@IntfAuto(target = IWordBreakAdapter.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class WordBreakAdapterRouter extends IWordBreakAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(WordBreakAdapterRouter.class);
    private static String PACKAGE = ReflexTool.PN(WordBreakAdapterRouter.class);
    private TypeHelper mHelper;
    private IWordBreakAdapter mObserver;
    private String mTargetId;

    private void $constructor(String str, IWordBreakAdapter iWordBreakAdapter) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IWordBreakAdapterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iWordBreakAdapter;
    }

    protected WordBreakAdapterRouter(String str, IWordBreakAdapter iWordBreakAdapter, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iWordBreakAdapter);
    }

    protected WordBreakAdapterRouter(String str, IWordBreakAdapter iWordBreakAdapter) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iWordBreakAdapter);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.impl.IWordBreakAdapterImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.IWordBreakAdapterImpl
    public boolean breakText(String str, ArrayList<String> arrayList) {
        IWordBreakAdapter iWordBreakAdapter = this.mObserver;
        if (iWordBreakAdapter != null) {
            return iWordBreakAdapter.breakText(str, arrayList);
        }
        return false;
    }
}
