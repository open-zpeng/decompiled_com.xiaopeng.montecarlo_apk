package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMTraceService {
    public abstract void RegisterTraceListener(AIMTraceListener aIMTraceListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMTraceService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void RegisterTraceListenerNative(long j, AIMTraceListener aIMTraceListener);

        private native void nativeDestroy(long j);

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public void djinniPrivateDestroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            djinniPrivateDestroy();
            super.finalize();
        }

        @Override // com.alibaba.android.ark.AIMTraceService
        public void RegisterTraceListener(AIMTraceListener aIMTraceListener) {
            RegisterTraceListenerNative(this.nativeRef, aIMTraceListener);
        }
    }
}
