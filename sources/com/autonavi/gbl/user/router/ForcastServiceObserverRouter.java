package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.user.forcast.model.ForcastArrivedData;
import com.autonavi.gbl.user.forcast.observer.IForcastServiceObserver;
import com.autonavi.gbl.user.forcast.observer.impl.IForcastServiceObserverImpl;
@IntfAuto(target = IForcastServiceObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ForcastServiceObserverRouter extends IForcastServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ForcastServiceObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ForcastServiceObserverRouter.class);
    private TypeHelper mHelper;
    private IForcastServiceObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IForcastServiceObserver iForcastServiceObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IForcastServiceObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iForcastServiceObserver;
    }

    protected ForcastServiceObserverRouter(String str, IForcastServiceObserver iForcastServiceObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iForcastServiceObserver);
    }

    protected ForcastServiceObserverRouter(String str, IForcastServiceObserver iForcastServiceObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iForcastServiceObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.user.forcast.observer.impl.IForcastServiceObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.forcast.observer.impl.IForcastServiceObserverImpl
    public void onInit(int i) {
        IForcastServiceObserver iForcastServiceObserver = this.mObserver;
        if (iForcastServiceObserver != null) {
            iForcastServiceObserver.onInit(i);
        }
    }

    @Override // com.autonavi.gbl.user.forcast.observer.impl.IForcastServiceObserverImpl
    public void onSetLoginInfo(int i) {
        IForcastServiceObserver iForcastServiceObserver = this.mObserver;
        if (iForcastServiceObserver != null) {
            iForcastServiceObserver.onSetLoginInfo(i);
        }
    }

    @Override // com.autonavi.gbl.user.forcast.observer.impl.IForcastServiceObserverImpl
    public void onForcastArrivedData(ForcastArrivedData forcastArrivedData) {
        IForcastServiceObserver iForcastServiceObserver = this.mObserver;
        if (iForcastServiceObserver != null) {
            iForcastServiceObserver.onForcastArrivedData(forcastArrivedData);
        }
    }
}
