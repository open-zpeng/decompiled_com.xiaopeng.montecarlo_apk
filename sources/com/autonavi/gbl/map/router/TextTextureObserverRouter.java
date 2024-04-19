package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.ITextTextureObserver;
import com.autonavi.gbl.map.observer.impl.ITextTextureObserverImpl;
@IntfAuto(target = ITextTextureObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class TextTextureObserverRouter extends ITextTextureObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(TextTextureObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(TextTextureObserverRouter.class);
    private TypeHelper mHelper;
    private ITextTextureObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ITextTextureObserver iTextTextureObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ITextTextureObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iTextTextureObserver;
    }

    protected TextTextureObserverRouter(String str, ITextTextureObserver iTextTextureObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iTextTextureObserver);
    }

    protected TextTextureObserverRouter(String str, ITextTextureObserver iTextTextureObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iTextTextureObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.TextTextureObserverRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.ITextTextureObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.TextTextureObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.ITextTextureObserverImpl
    public byte[] getCharBitmap(long j, int i, int i2) {
        ITextTextureObserver iTextTextureObserver = this.mObserver;
        if (iTextTextureObserver != null) {
            return iTextTextureObserver.getCharBitmap(j, i, i2);
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.observer.impl.ITextTextureObserverImpl
    public byte[] getCharsWidths(long j, short[] sArr, int i) {
        ITextTextureObserver iTextTextureObserver = this.mObserver;
        if (iTextTextureObserver != null) {
            return iTextTextureObserver.getCharsWidths(j, sArr, i);
        }
        return null;
    }
}
