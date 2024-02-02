package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GHttpGetPostResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackHttpGetPost;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackHttpGetPostImpl;
@IntfAuto(target = ICallBackHttpGetPost.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackHttpGetPostRouter extends ICallBackHttpGetPostImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackHttpGetPostRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackHttpGetPostRouter.class);
    private TypeHelper mHelper;
    private ICallBackHttpGetPost mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackHttpGetPost iCallBackHttpGetPost) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackHttpGetPostImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackHttpGetPost;
    }

    protected CallBackHttpGetPostRouter(String str, ICallBackHttpGetPost iCallBackHttpGetPost, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackHttpGetPost);
    }

    protected CallBackHttpGetPostRouter(String str, ICallBackHttpGetPost iCallBackHttpGetPost) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackHttpGetPost);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackHttpGetPostRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackHttpGetPostImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackHttpGetPostRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackHttpGetPostImpl
    public void onRecvAck(GHttpGetPostResponseParam gHttpGetPostResponseParam) {
        ICallBackHttpGetPost iCallBackHttpGetPost = this.mObserver;
        if (iCallBackHttpGetPost != null) {
            iCallBackHttpGetPost.onRecvAck(gHttpGetPostResponseParam);
        }
    }
}
