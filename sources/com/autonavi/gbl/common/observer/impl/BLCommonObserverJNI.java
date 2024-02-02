package com.autonavi.gbl.common.observer.impl;

import com.autonavi.gbl.common.model.TBTResReaderType;
/* loaded from: classes.dex */
public class BLCommonObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static byte[] SwigDirector_ITBTResReaderImpl_readData(ITBTResReaderImpl iTBTResReaderImpl, @TBTResReaderType.TBTResReaderType1 int i, int i2) {
        return iTBTResReaderImpl.readData(i, i2);
    }

    public static void SwigDirector_ITBTResReaderImpl_release(ITBTResReaderImpl iTBTResReaderImpl, byte[] bArr) {
        iTBTResReaderImpl.release(bArr);
    }

    public static void SwigDirector_IThreadObserverImpl_threadCallback(IThreadObserverImpl iThreadObserverImpl, long j, byte b) {
        iThreadObserverImpl.threadCallback(j, b);
    }
}
