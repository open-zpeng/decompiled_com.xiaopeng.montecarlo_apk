package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinQrcodeResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinQrcode;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinQrcodeImpl;
@IntfAuto(target = ICallBackWsPpAutoWeixinQrcode.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpAutoWeixinQrcodeRouter extends ICallBackWsPpAutoWeixinQrcodeImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpAutoWeixinQrcodeRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpAutoWeixinQrcodeRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpAutoWeixinQrcode mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpAutoWeixinQrcode iCallBackWsPpAutoWeixinQrcode) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpAutoWeixinQrcodeImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpAutoWeixinQrcode;
    }

    protected CallBackWsPpAutoWeixinQrcodeRouter(String str, ICallBackWsPpAutoWeixinQrcode iCallBackWsPpAutoWeixinQrcode, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAutoWeixinQrcode);
    }

    protected CallBackWsPpAutoWeixinQrcodeRouter(String str, ICallBackWsPpAutoWeixinQrcode iCallBackWsPpAutoWeixinQrcode) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAutoWeixinQrcode);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpAutoWeixinQrcodeRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinQrcodeImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpAutoWeixinQrcodeRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinQrcodeImpl
    public void onRecvAck(GWsPpAutoWeixinQrcodeResponseParam gWsPpAutoWeixinQrcodeResponseParam) {
        ICallBackWsPpAutoWeixinQrcode iCallBackWsPpAutoWeixinQrcode = this.mObserver;
        if (iCallBackWsPpAutoWeixinQrcode != null) {
            iCallBackWsPpAutoWeixinQrcode.onRecvAck(gWsPpAutoWeixinQrcodeResponseParam);
        }
    }
}
