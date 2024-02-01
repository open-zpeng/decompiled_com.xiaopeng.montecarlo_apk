package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMManager {
    public abstract AIMAuthService GetAuthService();

    public abstract AIMConvService GetConvService();

    public abstract AIMGroupService GetGroupService();

    public abstract AIMMediaService GetMediaService();

    public abstract AIMMsgService GetMsgService();

    public abstract AIMMultiConvService GetMultiConvService();

    public abstract AIMRpcService GetRpcService();

    public abstract AIMSearchService GetSearchService();

    public abstract AIMSyncService GetSyncService();

    public abstract AIMTraceService GetTraceService();

    public abstract AIMUserId GetUserId();

    public abstract AIMUtService GetUtService();

    public abstract void SetMsgServiceHook(AIMMsgServiceHook aIMMsgServiceHook);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMManager {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native AIMAuthService GetAuthServiceNative(long j);

        private native AIMConvService GetConvServiceNative(long j);

        private native AIMGroupService GetGroupServiceNative(long j);

        private native AIMMediaService GetMediaServiceNative(long j);

        private native AIMMsgService GetMsgServiceNative(long j);

        private native AIMMultiConvService GetMultiConvServiceNative(long j);

        private native AIMRpcService GetRpcServiceNative(long j);

        private native AIMSearchService GetSearchServiceNative(long j);

        private native AIMSyncService GetSyncServiceNative(long j);

        private native AIMTraceService GetTraceServiceNative(long j);

        private native AIMUserId GetUserIdNative(long j);

        private native AIMUtService GetUtServiceNative(long j);

        private native void SetMsgServiceHookNative(long j, AIMMsgServiceHook aIMMsgServiceHook);

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

        @Override // com.alibaba.android.ark.AIMManager
        public AIMUserId GetUserId() {
            return GetUserIdNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMAuthService GetAuthService() {
            return GetAuthServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMConvService GetConvService() {
            return GetConvServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMMsgService GetMsgService() {
            return GetMsgServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMSyncService GetSyncService() {
            return GetSyncServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMRpcService GetRpcService() {
            return GetRpcServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMGroupService GetGroupService() {
            return GetGroupServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMMultiConvService GetMultiConvService() {
            return GetMultiConvServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMMediaService GetMediaService() {
            return GetMediaServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMSearchService GetSearchService() {
            return GetSearchServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMUtService GetUtService() {
            return GetUtServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public AIMTraceService GetTraceService() {
            return GetTraceServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMManager
        public void SetMsgServiceHook(AIMMsgServiceHook aIMMsgServiceHook) {
            SetMsgServiceHookNative(this.nativeRef, aIMMsgServiceHook);
        }
    }
}
