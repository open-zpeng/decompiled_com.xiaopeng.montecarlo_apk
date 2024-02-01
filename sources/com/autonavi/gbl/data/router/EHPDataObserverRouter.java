package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.observer.IEHPDataObserver;
import com.autonavi.gbl.data.observer.impl.IEHPDataObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IEHPDataObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class EHPDataObserverRouter extends IEHPDataObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(EHPDataObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(EHPDataObserverRouter.class);
    private TypeHelper mHelper;
    private IEHPDataObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IEHPDataObserver iEHPDataObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IEHPDataObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iEHPDataObserver;
    }

    protected EHPDataObserverRouter(String str, IEHPDataObserver iEHPDataObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEHPDataObserver);
    }

    protected EHPDataObserverRouter(String str, IEHPDataObserver iEHPDataObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEHPDataObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.data.observer.impl.IEHPDataObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IEHPDataObserverImpl
    public void onEHPDataExistedAdcodeList(@DownLoadMode.DownLoadMode1 int i, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        IEHPDataObserver iEHPDataObserver = this.mObserver;
        if (iEHPDataObserver != null) {
            iEHPDataObserver.onEHPDataExistedAdcodeList(i, arrayList, arrayList2);
        }
    }
}
