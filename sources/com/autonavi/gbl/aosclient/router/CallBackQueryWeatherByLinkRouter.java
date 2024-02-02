package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GQueryWeatherByLinkResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryWeatherByLink;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryWeatherByLinkImpl;
@IntfAuto(target = ICallBackQueryWeatherByLink.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackQueryWeatherByLinkRouter extends ICallBackQueryWeatherByLinkImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackQueryWeatherByLinkRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackQueryWeatherByLinkRouter.class);
    private TypeHelper mHelper;
    private ICallBackQueryWeatherByLink mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackQueryWeatherByLink iCallBackQueryWeatherByLink) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackQueryWeatherByLinkImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackQueryWeatherByLink;
    }

    protected CallBackQueryWeatherByLinkRouter(String str, ICallBackQueryWeatherByLink iCallBackQueryWeatherByLink, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQueryWeatherByLink);
    }

    protected CallBackQueryWeatherByLinkRouter(String str, ICallBackQueryWeatherByLink iCallBackQueryWeatherByLink) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQueryWeatherByLink);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackQueryWeatherByLinkRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryWeatherByLinkImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackQueryWeatherByLinkRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryWeatherByLinkImpl
    public void onRecvAck(GQueryWeatherByLinkResponseParam gQueryWeatherByLinkResponseParam) {
        ICallBackQueryWeatherByLink iCallBackQueryWeatherByLink = this.mObserver;
        if (iCallBackQueryWeatherByLink != null) {
            iCallBackQueryWeatherByLink.onRecvAck(gQueryWeatherByLinkResponseParam);
        }
    }
}
