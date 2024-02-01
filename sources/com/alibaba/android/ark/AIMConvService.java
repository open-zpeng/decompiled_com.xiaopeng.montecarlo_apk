package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMConvService {
    public abstract void AddConvChangeListener(AIMConvChangeListener aIMConvChangeListener);

    public abstract void AddConvListListener(AIMConvListListener aIMConvListListener);

    public abstract void BulkUpdateLocalExtensionByKeys(HashMap<String, HashMap<String, String>> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void Clear(String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void ClearAllConvsRedPoint(AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void ClearRedPoint(String str, String str2, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void CreateSingleConversation(AIMConvCreateSingleConvParam aIMConvCreateSingleConvParam, AIMConvCreateSingleConvListener aIMConvCreateSingleConvListener, HashMap<String, String> hashMap);

    public abstract void GetConversation(String str, AIMConvGetSingleConvListener aIMConvGetSingleConvListener);

    public abstract void GetConversations(ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void GetLocalConversations(ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void GetRemoteConversations(ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void GetSingleConversations(AIMUserId aIMUserId, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void GetSingleConversationsWithUserIds(ArrayList<AIMUserId> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void Hide(String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void HideAll(AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void HideBatch(ArrayList<String> arrayList, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void ImportConversations(ArrayList<AIMConversation> arrayList, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void ListAllStatusLocalConvs(int i, int i2, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void ListLocalConversationsWithCid(String str, int i, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void ListLocalConversationsWithOffset(int i, int i2, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void Mute(String str, boolean z, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void ParseConvListData(byte[] bArr, AIMConvGetConvListener aIMConvGetConvListener);

    public abstract void RemoveAllConvChangeListener();

    public abstract void RemoveAllConvListListener();

    public abstract void RemoveConvChangeListener(AIMConvChangeListener aIMConvChangeListener);

    public abstract void RemoveConvListListener(AIMConvListListener aIMConvListListener);

    public abstract void RemoveLocalConversation(String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void SetActiveCid(String str);

    public abstract void SetTop(String str, boolean z, AIMConvSetTopListener aIMConvSetTopListener);

    public abstract void SetTopWithTimeStamp(String str, boolean z, HashMap<String, String> hashMap, AIMConvSetTopListener aIMConvSetTopListener);

    public abstract void UpdateDraftMessage(String str, String str2, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void UpdateLocalExtension(String str, HashMap<String, String> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void UpdateLocalExtensionByKeys(String str, HashMap<String, String> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    public abstract void UpdateTypingStatus(String str, AIMUserId aIMUserId, AIMConvTypingCommand aIMConvTypingCommand, AIMConvTypingMessageContent aIMConvTypingMessageContent, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMConvService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void AddConvChangeListenerNative(long j, AIMConvChangeListener aIMConvChangeListener);

        private native void AddConvListListenerNative(long j, AIMConvListListener aIMConvListListener);

        private native void BulkUpdateLocalExtensionByKeysNative(long j, HashMap<String, HashMap<String, String>> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void ClearAllConvsRedPointNative(long j, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void ClearNative(long j, String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void ClearRedPointNative(long j, String str, String str2, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void CreateSingleConversationNative(long j, AIMConvCreateSingleConvParam aIMConvCreateSingleConvParam, AIMConvCreateSingleConvListener aIMConvCreateSingleConvListener, HashMap<String, String> hashMap);

        private native void GetConversationNative(long j, String str, AIMConvGetSingleConvListener aIMConvGetSingleConvListener);

        private native void GetConversationsNative(long j, ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

        private native void GetLocalConversationsNative(long j, ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

        private native void GetRemoteConversationsNative(long j, ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

        private native void GetSingleConversationsNative(long j, AIMUserId aIMUserId, AIMConvGetConvListener aIMConvGetConvListener);

        private native void GetSingleConversationsWithUserIdsNative(long j, ArrayList<AIMUserId> arrayList, AIMConvGetConvListener aIMConvGetConvListener);

        private native void HideAllNative(long j, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void HideBatchNative(long j, ArrayList<String> arrayList, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void HideNative(long j, String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void ImportConversationsNative(long j, ArrayList<AIMConversation> arrayList, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void ListAllStatusLocalConvsNative(long j, int i, int i2, AIMConvGetConvListener aIMConvGetConvListener);

        private native void ListLocalConversationsWithCidNative(long j, String str, int i, AIMConvGetConvListener aIMConvGetConvListener);

        private native void ListLocalConversationsWithOffsetNative(long j, int i, int i2, AIMConvGetConvListener aIMConvGetConvListener);

        private native void MuteNative(long j, String str, boolean z, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void ParseConvListDataNative(long j, byte[] bArr, AIMConvGetConvListener aIMConvGetConvListener);

        private native void RemoveAllConvChangeListenerNative(long j);

        private native void RemoveAllConvListListenerNative(long j);

        private native void RemoveConvChangeListenerNative(long j, AIMConvChangeListener aIMConvChangeListener);

        private native void RemoveConvListListenerNative(long j, AIMConvListListener aIMConvListListener);

        private native void RemoveLocalConversationNative(long j, String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void SetActiveCidNative(long j, String str);

        private native void SetTopNative(long j, String str, boolean z, AIMConvSetTopListener aIMConvSetTopListener);

        private native void SetTopWithTimeStampNative(long j, String str, boolean z, HashMap<String, String> hashMap, AIMConvSetTopListener aIMConvSetTopListener);

        private native void UpdateDraftMessageNative(long j, String str, String str2, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void UpdateLocalExtensionByKeysNative(long j, String str, HashMap<String, String> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void UpdateLocalExtensionNative(long j, String str, HashMap<String, String> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

        private native void UpdateTypingStatusNative(long j, String str, AIMUserId aIMUserId, AIMConvTypingCommand aIMConvTypingCommand, AIMConvTypingMessageContent aIMConvTypingMessageContent, AIMConvServiceCompleteListener aIMConvServiceCompleteListener);

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

        @Override // com.alibaba.android.ark.AIMConvService
        public void ImportConversations(ArrayList<AIMConversation> arrayList, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            ImportConversationsNative(this.nativeRef, arrayList, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void CreateSingleConversation(AIMConvCreateSingleConvParam aIMConvCreateSingleConvParam, AIMConvCreateSingleConvListener aIMConvCreateSingleConvListener, HashMap<String, String> hashMap) {
            CreateSingleConversationNative(this.nativeRef, aIMConvCreateSingleConvParam, aIMConvCreateSingleConvListener, hashMap);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void ListLocalConversationsWithOffset(int i, int i2, AIMConvGetConvListener aIMConvGetConvListener) {
            ListLocalConversationsWithOffsetNative(this.nativeRef, i, i2, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void ListLocalConversationsWithCid(String str, int i, AIMConvGetConvListener aIMConvGetConvListener) {
            ListLocalConversationsWithCidNative(this.nativeRef, str, i, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void ListAllStatusLocalConvs(int i, int i2, AIMConvGetConvListener aIMConvGetConvListener) {
            ListAllStatusLocalConvsNative(this.nativeRef, i, i2, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void GetConversation(String str, AIMConvGetSingleConvListener aIMConvGetSingleConvListener) {
            GetConversationNative(this.nativeRef, str, aIMConvGetSingleConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void GetConversations(ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener) {
            GetConversationsNative(this.nativeRef, arrayList, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void GetLocalConversations(ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener) {
            GetLocalConversationsNative(this.nativeRef, arrayList, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void GetRemoteConversations(ArrayList<String> arrayList, AIMConvGetConvListener aIMConvGetConvListener) {
            GetRemoteConversationsNative(this.nativeRef, arrayList, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void GetSingleConversations(AIMUserId aIMUserId, AIMConvGetConvListener aIMConvGetConvListener) {
            GetSingleConversationsNative(this.nativeRef, aIMUserId, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void GetSingleConversationsWithUserIds(ArrayList<AIMUserId> arrayList, AIMConvGetConvListener aIMConvGetConvListener) {
            GetSingleConversationsWithUserIdsNative(this.nativeRef, arrayList, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void RemoveLocalConversation(String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            RemoveLocalConversationNative(this.nativeRef, str, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void UpdateTypingStatus(String str, AIMUserId aIMUserId, AIMConvTypingCommand aIMConvTypingCommand, AIMConvTypingMessageContent aIMConvTypingMessageContent, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            UpdateTypingStatusNative(this.nativeRef, str, aIMUserId, aIMConvTypingCommand, aIMConvTypingMessageContent, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void UpdateDraftMessage(String str, String str2, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            UpdateDraftMessageNative(this.nativeRef, str, str2, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void UpdateLocalExtension(String str, HashMap<String, String> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            UpdateLocalExtensionNative(this.nativeRef, str, hashMap, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void UpdateLocalExtensionByKeys(String str, HashMap<String, String> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            UpdateLocalExtensionByKeysNative(this.nativeRef, str, hashMap, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void BulkUpdateLocalExtensionByKeys(HashMap<String, HashMap<String, String>> hashMap, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            BulkUpdateLocalExtensionByKeysNative(this.nativeRef, hashMap, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void Hide(String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            HideNative(this.nativeRef, str, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void HideBatch(ArrayList<String> arrayList, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            HideBatchNative(this.nativeRef, arrayList, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void HideAll(AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            HideAllNative(this.nativeRef, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void Mute(String str, boolean z, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            MuteNative(this.nativeRef, str, z, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void SetTop(String str, boolean z, AIMConvSetTopListener aIMConvSetTopListener) {
            SetTopNative(this.nativeRef, str, z, aIMConvSetTopListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void SetTopWithTimeStamp(String str, boolean z, HashMap<String, String> hashMap, AIMConvSetTopListener aIMConvSetTopListener) {
            SetTopWithTimeStampNative(this.nativeRef, str, z, hashMap, aIMConvSetTopListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void ClearRedPoint(String str, String str2, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            ClearRedPointNative(this.nativeRef, str, str2, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void ClearAllConvsRedPoint(AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            ClearAllConvsRedPointNative(this.nativeRef, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void Clear(String str, AIMConvServiceCompleteListener aIMConvServiceCompleteListener) {
            ClearNative(this.nativeRef, str, aIMConvServiceCompleteListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void SetActiveCid(String str) {
            SetActiveCidNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void ParseConvListData(byte[] bArr, AIMConvGetConvListener aIMConvGetConvListener) {
            ParseConvListDataNative(this.nativeRef, bArr, aIMConvGetConvListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void AddConvListListener(AIMConvListListener aIMConvListListener) {
            AddConvListListenerNative(this.nativeRef, aIMConvListListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void RemoveConvListListener(AIMConvListListener aIMConvListListener) {
            RemoveConvListListenerNative(this.nativeRef, aIMConvListListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void AddConvChangeListener(AIMConvChangeListener aIMConvChangeListener) {
            AddConvChangeListenerNative(this.nativeRef, aIMConvChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void RemoveConvChangeListener(AIMConvChangeListener aIMConvChangeListener) {
            RemoveConvChangeListenerNative(this.nativeRef, aIMConvChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void RemoveAllConvListListener() {
            RemoveAllConvListListenerNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMConvService
        public void RemoveAllConvChangeListener() {
            RemoveAllConvChangeListenerNative(this.nativeRef);
        }
    }
}
