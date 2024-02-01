package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMSyncPlusAck {
    public abstract void Failed(String str);

    public abstract void Success();

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMSyncPlusAck {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void FailedNative(long j, String str);

        private native void SuccessNative(long j);

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

        @Override // com.alibaba.android.ark.AIMSyncPlusAck
        public void Success() {
            SuccessNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMSyncPlusAck
        public void Failed(String str) {
            FailedNative(this.nativeRef, str);
        }
    }
}
