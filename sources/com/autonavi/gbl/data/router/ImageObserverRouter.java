package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IImageObserver;
import com.autonavi.gbl.data.observer.impl.IImageObserverImpl;
@IntfAuto(target = IImageObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ImageObserverRouter extends IImageObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ImageObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ImageObserverRouter.class);
    private TypeHelper mHelper;
    private IImageObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IImageObserver iImageObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IImageObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iImageObserver;
    }

    protected ImageObserverRouter(String str, IImageObserver iImageObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iImageObserver);
    }

    protected ImageObserverRouter(String str, IImageObserver iImageObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iImageObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.ImageObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.IImageObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.ImageObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IImageObserverImpl
    public void onDownloadImage(int i, @OperationErrCode.OperationErrCode1 int i2, String str, @DataType.DataType1 int i3) {
        IImageObserver iImageObserver = this.mObserver;
        if (iImageObserver != null) {
            iImageObserver.onDownloadImage(i, i2, str, i3);
        }
    }
}
