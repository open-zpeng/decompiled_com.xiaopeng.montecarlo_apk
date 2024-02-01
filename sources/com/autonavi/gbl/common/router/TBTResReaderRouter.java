package com.autonavi.gbl.common.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.common.observer.impl.ITBTResReaderImpl
    public byte[] readFile(String str) {
        ITBTResReader iTBTResReader = this.mObserver;
        if (iTBTResReader != null) {
            return iTBTResReader.readFile(str);
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
