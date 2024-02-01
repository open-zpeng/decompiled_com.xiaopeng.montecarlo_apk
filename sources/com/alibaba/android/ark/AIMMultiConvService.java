package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMMultiConvService {
    public abstract void AddMultiConvChangeListener(AIMMultiConversationChangeListener aIMMultiConversationChangeListener);

    public abstract void GetLocalChildConversation(String str, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void GetLocalParentConvProperty(String str, AIMGetParentConvPropertyListener aIMGetParentConvPropertyListener);

    public abstract void GetParentConvProperty(String str, AIMGetParentConvPropertyListener aIMGetParentConvPropertyListener);

    public abstract void GetParentConversationInfo(ArrayList<String> arrayList, AIMGetParentConvInfoListener aIMGetParentConvInfoListener);

    public abstract String ParentCid2ParentId(String str);

    public abstract String ParentId2ParentCid(String str);

    public abstract void RemoveAllMultiConvChangeListener();

    public abstract void RemoveMultiConvChangeListener(AIMMultiConversationChangeListener aIMMultiConversationChangeListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMMultiConvService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void AddMultiConvChangeListenerNative(long j, AIMMultiConversationChangeListener aIMMultiConversationChangeListener);

        private native void GetLocalChildConversationNative(long j, String str, AIMConvGetConvListener aIMConvGetConvListener);

        private native void GetLocalParentConvPropertyNative(long j, String str, AIMGetParentConvPropertyListener aIMGetParentConvPropertyListener);

        private native void GetParentConvPropertyNative(long j, String str, AIMGetParentConvPropertyListener aIMGetParentConvPropertyListener);

        private native void GetParentConversationInfoNative(long j, ArrayList<String> arrayList, AIMGetParentConvInfoListener aIMGetParentConvInfoListener);

        private native String ParentCid2ParentIdNative(long j, String str);

        private native String ParentId2ParentCidNative(long j, String str);

        private native void RemoveAllMultiConvChangeListenerNative(long j);

        private native void RemoveMultiConvChangeListenerNative(long j, AIMMultiConversationChangeListener aIMMultiConversationChangeListener);

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

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public void GetParentConversationInfo(ArrayList<String> arrayList, AIMGetParentConvInfoListener aIMGetParentConvInfoListener) {
            GetParentConversationInfoNative(this.nativeRef, arrayList, aIMGetParentConvInfoListener);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public void GetLocalChildConversation(String str, AIMConvGetConvListener aIMConvGetConvListener) {
            GetLocalChildConversationNative(this.nativeRef, str, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public void GetParentConvProperty(String str, AIMGetParentConvPropertyListener aIMGetParentConvPropertyListener) {
            GetParentConvPropertyNative(this.nativeRef, str, aIMGetParentConvPropertyListener);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public void GetLocalParentConvProperty(String str, AIMGetParentConvPropertyListener aIMGetParentConvPropertyListener) {
            GetLocalParentConvPropertyNative(this.nativeRef, str, aIMGetParentConvPropertyListener);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public String ParentCid2ParentId(String str) {
            return ParentCid2ParentIdNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public String ParentId2ParentCid(String str) {
            return ParentId2ParentCidNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public void AddMultiConvChangeListener(AIMMultiConversationChangeListener aIMMultiConversationChangeListener) {
            AddMultiConvChangeListenerNative(this.nativeRef, aIMMultiConversationChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public void RemoveMultiConvChangeListener(AIMMultiConversationChangeListener aIMMultiConversationChangeListener) {
            RemoveMultiConvChangeListenerNative(this.nativeRef, aIMMultiConversationChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMMultiConvService
        public void RemoveAllMultiConvChangeListener() {
            RemoveAllMultiConvChangeListenerNative(this.nativeRef);
        }
    }
}
