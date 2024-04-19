package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeUrlTranslateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpQrcodeUrlTranslate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeUrlTranslateImpl;
@IntfAuto(target = ICallBackWsPpQrcodeUrlTranslate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpQrcodeUrlTranslateRouter extends ICallBackWsPpQrcodeUrlTranslateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpQrcodeUrlTranslateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpQrcodeUrlTranslateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpQrcodeUrlTranslate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpQrcodeUrlTranslate iCallBackWsPpQrcodeUrlTranslate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpQrcodeUrlTranslateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpQrcodeUrlTranslate;
    }

    protected CallBackWsPpQrcodeUrlTranslateRouter(String str, ICallBackWsPpQrcodeUrlTranslate iCallBackWsPpQrcodeUrlTranslate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpQrcodeUrlTranslate);
    }

    protected CallBackWsPpQrcodeUrlTranslateRouter(String str, ICallBackWsPpQrcodeUrlTranslate iCallBackWsPpQrcodeUrlTranslate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpQrcodeUrlTranslate);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpQrcodeUrlTranslateRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeUrlTranslateImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpQrcodeUrlTranslateRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeUrlTranslateImpl
    public void onRecvAck(GWsPpQrcodeUrlTranslateResponseParam gWsPpQrcodeUrlTranslateResponseParam) {
        ICallBackWsPpQrcodeUrlTranslate iCallBackWsPpQrcodeUrlTranslate = this.mObserver;
        if (iCallBackWsPpQrcodeUrlTranslate != null) {
            iCallBackWsPpQrcodeUrlTranslate.onRecvAck(gWsPpQrcodeUrlTranslateResponseParam);
        }
    }
}
