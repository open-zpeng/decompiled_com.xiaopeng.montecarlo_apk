package com.autonavi.gbl.scene.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.model.ClickedInfo;
import com.autonavi.gbl.scene.model.DisplayInfo;
import com.autonavi.gbl.scene.observer.IDisplayObserver;
import com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl;
@IntfAuto(target = IDisplayObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DisplayObserverRouter extends IDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DisplayObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DisplayObserverRouter.class);
    private TypeHelper mHelper;
    private IDisplayObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDisplayObserver iDisplayObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDisplayObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDisplayObserver;
    }

    protected DisplayObserverRouter(String str, IDisplayObserver iDisplayObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplayObserver);
    }

    protected DisplayObserverRouter(String str, IDisplayObserver iDisplayObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplayObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl
    public void onShow(DisplayInfo displayInfo) {
        IDisplayObserver iDisplayObserver = this.mObserver;
        if (iDisplayObserver != null) {
            iDisplayObserver.onShow(displayInfo);
        }
    }

    @Override // com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl
    public void onHide(DisplayInfo displayInfo) {
        IDisplayObserver iDisplayObserver = this.mObserver;
        if (iDisplayObserver != null) {
            iDisplayObserver.onHide(displayInfo);
        }
    }

    @Override // com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl
    public void onClick(ClickedInfo clickedInfo) {
        IDisplayObserver iDisplayObserver = this.mObserver;
        if (iDisplayObserver != null) {
            iDisplayObserver.onClick(clickedInfo);
        }
    }
}
