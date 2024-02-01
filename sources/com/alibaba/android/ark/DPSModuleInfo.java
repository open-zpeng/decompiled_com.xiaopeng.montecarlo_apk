package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class DPSModuleInfo {
    public abstract DPSModuleEventHandler GetModuleEventHandler();

    public abstract String GetModuleName();

    /* loaded from: classes.dex */
    private static final class CppProxy extends DPSModuleInfo {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native DPSModuleEventHandler GetModuleEventHandlerNative(long j);

        private native String GetModuleNameNative(long j);

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

        @Override // com.alibaba.android.ark.DPSModuleInfo
        public String GetModuleName() {
            return GetModuleNameNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSModuleInfo
        public DPSModuleEventHandler GetModuleEventHandler() {
            return GetModuleEventHandlerNative(this.nativeRef);
        }
    }
}
