package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMMsgHookPreSendMsgListener {
    public abstract void OnFailure(AIMError aIMError);

    public abstract void OnProgress(double d);

    public abstract void OnStart();

    public abstract void OnSuccess(AIMMsgHookPreSendMsgResult aIMMsgHookPreSendMsgResult, boolean z);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMMsgHookPreSendMsgListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void OnFailureNative(long j, AIMError aIMError);

        private native void OnProgressNative(long j, double d);

        private native void OnStartNative(long j);

        private native void OnSuccessNative(long j, AIMMsgHookPreSendMsgResult aIMMsgHookPreSendMsgResult, boolean z);

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

        @Override // com.alibaba.android.ark.AIMMsgHookPreSendMsgListener
        public void OnStart() {
            OnStartNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMMsgHookPreSendMsgListener
        public void OnProgress(double d) {
            OnProgressNative(this.nativeRef, d);
        }

        @Override // com.alibaba.android.ark.AIMMsgHookPreSendMsgListener
        public void OnSuccess(AIMMsgHookPreSendMsgResult aIMMsgHookPreSendMsgResult, boolean z) {
            OnSuccessNative(this.nativeRef, aIMMsgHookPreSendMsgResult, z);
        }

        @Override // com.alibaba.android.ark.AIMMsgHookPreSendMsgListener
        public void OnFailure(AIMError aIMError) {
            OnFailureNative(this.nativeRef, aIMError);
        }
    }
}
