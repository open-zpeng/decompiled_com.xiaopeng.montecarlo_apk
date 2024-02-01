package com.alibaba.android.ark;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class DPSAuthHandler {
    public abstract AIMAuthListener OnGetAuthListener();

    public abstract HashMap<String, String> OnGetRegHeader();

    /* loaded from: classes.dex */
    private static final class CppProxy extends DPSAuthHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native AIMAuthListener OnGetAuthListenerNative(long j);

        private native HashMap<String, String> OnGetRegHeaderNative(long j);

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

        @Override // com.alibaba.android.ark.DPSAuthHandler
        public HashMap<String, String> OnGetRegHeader() {
            return OnGetRegHeaderNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSAuthHandler
        public AIMAuthListener OnGetAuthListener() {
            return OnGetAuthListenerNative(this.nativeRef);
        }
    }
}
