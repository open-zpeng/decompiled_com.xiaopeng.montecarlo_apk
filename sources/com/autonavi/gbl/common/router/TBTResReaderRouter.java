package com.autonavi.gbl.common.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.TBTResReaderType;
import com.autonavi.gbl.common.observer.ITBTResReader;
import com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl;
@IntfAuto(target = ITBTResReader.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class TBTResReaderRouter extends ITBTResReaderImpl {
    private static BindTable BIND_TABLE = new BindTable(TBTResReaderRouter.class);
    private static String PACKAGE = ReflexTool.PN(TBTResReaderRouter.class);
    private TypeHelper mHelper;
    private ITBTResReader mObserver;
    private String mTargetId;

    private void $constructor(String str, ITBTResReader iTBTResReader) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ITBTResReaderImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iTBTResReader;
    }

    protected TBTResReaderRouter(String str, ITBTResReader iTBTResReader, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iTBTResReader);
    }

    protected TBTResReaderRouter(String str, ITBTResReader iTBTResReader) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iTBTResReader);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.router.TBTResReaderRouter.1
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
    @Override // com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.router.TBTResReaderRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl
    public byte[] readData(@TBTResReaderType.TBTResReaderType1 int i, int i2) {
        ITBTResReader iTBTResReader = this.mObserver;
        if (iTBTResReader != null) {
            return iTBTResReader.readData(i, i2);
        }
        return null;
    }

    @Override // com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl
    public void release(byte[] bArr) {
        ITBTResReader iTBTResReader = this.mObserver;
        if (iTBTResReader != null) {
            iTBTResReader.release(bArr);
        }
    }
}
