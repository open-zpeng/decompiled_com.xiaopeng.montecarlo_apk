package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class DPSServiceProvider {
    public abstract AIMRpcService GetRpcService();

    public abstract AIMSyncService GetSyncService();

    /* loaded from: classes.dex */
    private static final class CppProxy extends DPSServiceProvider {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native AIMRpcService GetRpcServiceNative(long j);

        private native AIMSyncService GetSyncServiceNative(long j);

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

        @Override // com.alibaba.android.ark.DPSServiceProvider
        public AIMRpcService GetRpcService() {
            return GetRpcServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSServiceProvider
        public AIMSyncService GetSyncService() {
            return GetSyncServiceNative(this.nativeRef);
        }
    }
}
