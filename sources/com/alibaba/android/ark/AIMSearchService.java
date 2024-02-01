package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMSearchService {
    public abstract void SearchChatContent(AIMSearchChatContentParams aIMSearchChatContentParams, AIMSearchChatContentListener aIMSearchChatContentListener);

    public abstract void SearchConversationByContent(AIMSearchChatContentParams aIMSearchChatContentParams, AIMSearchConvByContentListener aIMSearchConvByContentListener);

    public abstract void SearchGroupByName(AIMSearchGroupParams aIMSearchGroupParams, AIMSearchGroupByNameListener aIMSearchGroupByNameListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMSearchService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void SearchChatContentNative(long j, AIMSearchChatContentParams aIMSearchChatContentParams, AIMSearchChatContentListener aIMSearchChatContentListener);

        private native void SearchConversationByContentNative(long j, AIMSearchChatContentParams aIMSearchChatContentParams, AIMSearchConvByContentListener aIMSearchConvByContentListener);

        private native void SearchGroupByNameNative(long j, AIMSearchGroupParams aIMSearchGroupParams, AIMSearchGroupByNameListener aIMSearchGroupByNameListener);

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

        @Override // com.alibaba.android.ark.AIMSearchService
        public void SearchChatContent(AIMSearchChatContentParams aIMSearchChatContentParams, AIMSearchChatContentListener aIMSearchChatContentListener) {
            SearchChatContentNative(this.nativeRef, aIMSearchChatContentParams, aIMSearchChatContentListener);
        }

        @Override // com.alibaba.android.ark.AIMSearchService
        public void SearchConversationByContent(AIMSearchChatContentParams aIMSearchChatContentParams, AIMSearchConvByContentListener aIMSearchConvByContentListener) {
            SearchConversationByContentNative(this.nativeRef, aIMSearchChatContentParams, aIMSearchConvByContentListener);
        }

        @Override // com.alibaba.android.ark.AIMSearchService
        public void SearchGroupByName(AIMSearchGroupParams aIMSearchGroupParams, AIMSearchGroupByNameListener aIMSearchGroupByNameListener) {
            SearchGroupByNameNative(this.nativeRef, aIMSearchGroupParams, aIMSearchGroupByNameListener);
        }
    }
}
