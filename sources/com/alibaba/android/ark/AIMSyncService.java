package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMSyncService {
    public abstract boolean AddSyncBizEventListener(int i, AIMSyncPlusBizEventListener aIMSyncPlusBizEventListener);

    public abstract boolean AddSyncDataHandler(int i, AIMSyncPlusPackageDataHandler aIMSyncPlusPackageDataHandler);

    public abstract boolean AddSyncTopicEventListener(String str, AIMSyncPlusTopicEventListener aIMSyncPlusTopicEventListener);

    public abstract boolean RemoveSyncBizEventListener(int i, AIMSyncPlusBizEventListener aIMSyncPlusBizEventListener);

    public abstract boolean RemoveSyncDataHandler(int i, AIMSyncPlusPackageDataHandler aIMSyncPlusPackageDataHandler);

    public abstract boolean RemoveSyncTopicEventListener(String str, AIMSyncPlusTopicEventListener aIMSyncPlusTopicEventListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMSyncService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native boolean AddSyncBizEventListenerNative(long j, int i, AIMSyncPlusBizEventListener aIMSyncPlusBizEventListener);

        private native boolean AddSyncDataHandlerNative(long j, int i, AIMSyncPlusPackageDataHandler aIMSyncPlusPackageDataHandler);

        private native boolean AddSyncTopicEventListenerNative(long j, String str, AIMSyncPlusTopicEventListener aIMSyncPlusTopicEventListener);

        private native boolean RemoveSyncBizEventListenerNative(long j, int i, AIMSyncPlusBizEventListener aIMSyncPlusBizEventListener);

        private native boolean RemoveSyncDataHandlerNative(long j, int i, AIMSyncPlusPackageDataHandler aIMSyncPlusPackageDataHandler);

        private native boolean RemoveSyncTopicEventListenerNative(long j, String str, AIMSyncPlusTopicEventListener aIMSyncPlusTopicEventListener);

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

        @Override // com.alibaba.android.ark.AIMSyncService
        public boolean AddSyncTopicEventListener(String str, AIMSyncPlusTopicEventListener aIMSyncPlusTopicEventListener) {
            return AddSyncTopicEventListenerNative(this.nativeRef, str, aIMSyncPlusTopicEventListener);
        }

        @Override // com.alibaba.android.ark.AIMSyncService
        public boolean RemoveSyncTopicEventListener(String str, AIMSyncPlusTopicEventListener aIMSyncPlusTopicEventListener) {
            return RemoveSyncTopicEventListenerNative(this.nativeRef, str, aIMSyncPlusTopicEventListener);
        }

        @Override // com.alibaba.android.ark.AIMSyncService
        public boolean AddSyncBizEventListener(int i, AIMSyncPlusBizEventListener aIMSyncPlusBizEventListener) {
            return AddSyncBizEventListenerNative(this.nativeRef, i, aIMSyncPlusBizEventListener);
        }

        @Override // com.alibaba.android.ark.AIMSyncService
        public boolean RemoveSyncBizEventListener(int i, AIMSyncPlusBizEventListener aIMSyncPlusBizEventListener) {
            return RemoveSyncBizEventListenerNative(this.nativeRef, i, aIMSyncPlusBizEventListener);
        }

        @Override // com.alibaba.android.ark.AIMSyncService
        public boolean AddSyncDataHandler(int i, AIMSyncPlusPackageDataHandler aIMSyncPlusPackageDataHandler) {
            return AddSyncDataHandlerNative(this.nativeRef, i, aIMSyncPlusPackageDataHandler);
        }

        @Override // com.alibaba.android.ark.AIMSyncService
        public boolean RemoveSyncDataHandler(int i, AIMSyncPlusPackageDataHandler aIMSyncPlusPackageDataHandler) {
            return RemoveSyncDataHandlerNative(this.nativeRef, i, aIMSyncPlusPackageDataHandler);
        }
    }
}
