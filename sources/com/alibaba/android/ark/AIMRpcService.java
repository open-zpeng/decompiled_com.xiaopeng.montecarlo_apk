package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMRpcService {
    public abstract void Request(String str, byte[] bArr, AIMRpcRequestHeader aIMRpcRequestHeader, AIMRpcRequestListener aIMRpcRequestListener);

    public abstract void Subscribe(String str, AIMPushListener aIMPushListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMRpcService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void RequestNative(long j, String str, byte[] bArr, AIMRpcRequestHeader aIMRpcRequestHeader, AIMRpcRequestListener aIMRpcRequestListener);

        private native void SubscribeNative(long j, String str, AIMPushListener aIMPushListener);

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

        @Override // com.alibaba.android.ark.AIMRpcService
        public void Request(String str, byte[] bArr, AIMRpcRequestHeader aIMRpcRequestHeader, AIMRpcRequestListener aIMRpcRequestListener) {
            RequestNative(this.nativeRef, str, bArr, aIMRpcRequestHeader, aIMRpcRequestListener);
        }

        @Override // com.alibaba.android.ark.AIMRpcService
        public void Subscribe(String str, AIMPushListener aIMPushListener) {
            SubscribeNative(this.nativeRef, str, aIMPushListener);
        }
    }
}
