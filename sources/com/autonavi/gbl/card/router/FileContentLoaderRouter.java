package com.autonavi.gbl.card.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.observer.IFileContentLoader;
import com.autonavi.gbl.card.observer.impl.IFileContentLoaderImpl;
import com.autonavi.gbl.util.model.BinaryStream;
@IntfAuto(target = IFileContentLoader.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class FileContentLoaderRouter extends IFileContentLoaderImpl {
    private static BindTable BIND_TABLE = new BindTable(FileContentLoaderRouter.class);
    private static String PACKAGE = ReflexTool.PN(FileContentLoaderRouter.class);
    private TypeHelper mHelper;
    private IFileContentLoader mObserver;
    private String mTargetId;

    private void $constructor(String str, IFileContentLoader iFileContentLoader) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IFileContentLoaderImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iFileContentLoader;
    }

    protected FileContentLoaderRouter(String str, IFileContentLoader iFileContentLoader, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFileContentLoader);
    }

    protected FileContentLoaderRouter(String str, IFileContentLoader iFileContentLoader) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFileContentLoader);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.card.observer.impl.IFileContentLoaderImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.card.observer.impl.IFileContentLoaderImpl
    public boolean loadFileContent(String str, BinaryStream binaryStream, String[] strArr) {
        IFileContentLoader iFileContentLoader = this.mObserver;
        if (iFileContentLoader != null) {
            return iFileContentLoader.loadFileContent(str, binaryStream, strArr);
        }
        return false;
    }
}
