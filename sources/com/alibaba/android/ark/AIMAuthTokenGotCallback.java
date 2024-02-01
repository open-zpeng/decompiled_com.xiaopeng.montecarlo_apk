package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMAuthTokenGotCallback {
    public abstract void OnFailure(int i, String str);

    public abstract void OnSuccess(AIMAuthToken aIMAuthToken);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMAuthTokenGotCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void OnFailureNative(long j, int i, String str);

        private native void OnSuccessNative(long j, AIMAuthToken aIMAuthToken);

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

        @Override // com.alibaba.android.ark.AIMAuthTokenGotCallback
        public void OnSuccess(AIMAuthToken aIMAuthToken) {
            OnSuccessNative(this.nativeRef, aIMAuthToken);
        }

        @Override // com.alibaba.android.ark.AIMAuthTokenGotCallback
        public void OnFailure(int i, String str) {
            OnFailureNative(this.nativeRef, i, str);
        }
    }
}
