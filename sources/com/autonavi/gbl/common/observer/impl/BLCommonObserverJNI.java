package com.autonavi.gbl.common.observer.impl;
/* loaded from: classes.dex */
public class BLCommonObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static byte[] SwigDirector_ITBTResReaderImpl_readFile(ITBTResReaderImpl iTBTResReaderImpl, String str) {
        return iTBTResReaderImpl.readFile(str);
    }

    public static void SwigDirector_ITBTResReaderImpl_release(ITBTResReaderImpl iTBTResReaderImpl, byte[] bArr) {
        iTBTResReaderImpl.release(bArr);
    }

    public static void SwigDirector_IThreadObserverImpl_threadCallback(IThreadObserverImpl iThreadObserverImpl, long j, byte b) {
        iThreadObserverImpl.threadCallback(j, b);
    }
}
