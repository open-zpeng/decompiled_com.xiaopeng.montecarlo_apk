package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMPushAckStatus {
    public abstract void AckException();

    public abstract void AckInvalid();

    public abstract void AckStatus(int i);

    public abstract void AckSuccess();

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMPushAckStatus {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void AckExceptionNative(long j);

        private native void AckInvalidNative(long j);

        private native void AckStatusNative(long j, int i);

        private native void AckSuccessNative(long j);

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

        @Override // com.alibaba.android.ark.AIMPushAckStatus
        public void AckSuccess() {
            AckSuccessNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMPushAckStatus
        public void AckInvalid() {
            AckInvalidNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMPushAckStatus
        public void AckException() {
            AckExceptionNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMPushAckStatus
        public void AckStatus(int i) {
            AckStatusNative(this.nativeRef, i);
        }
    }
}
