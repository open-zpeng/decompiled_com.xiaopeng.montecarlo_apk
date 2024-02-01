package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMUtService {
    public abstract boolean AddListener(AIMUtListener aIMUtListener);

    public abstract void RemoveAllListeners();

    public abstract boolean RemoveListener(AIMUtListener aIMUtListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMUtService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native boolean AddListenerNative(long j, AIMUtListener aIMUtListener);

        private native void RemoveAllListenersNative(long j);

        private native boolean RemoveListenerNative(long j, AIMUtListener aIMUtListener);

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

        @Override // com.alibaba.android.ark.AIMUtService
        public boolean AddListener(AIMUtListener aIMUtListener) {
            return AddListenerNative(this.nativeRef, aIMUtListener);
        }

        @Override // com.alibaba.android.ark.AIMUtService
        public boolean RemoveListener(AIMUtListener aIMUtListener) {
            return RemoveListenerNative(this.nativeRef, aIMUtListener);
        }

        @Override // com.alibaba.android.ark.AIMUtService
        public void RemoveAllListeners() {
            RemoveAllListenersNative(this.nativeRef);
        }
    }
}
