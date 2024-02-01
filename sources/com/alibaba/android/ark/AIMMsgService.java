package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMMsgService {
    public static final long AIM_MAX_MSG_CURSOR = -1;

    public abstract boolean AddMsgChangeListener(AIMMsgChangeListener aIMMsgChangeListener);

    public abstract boolean AddMsgListener(AIMMsgListener aIMMsgListener);

    public abstract void DecryptMessage(ArrayList<AIMMsgKeyInfo> arrayList, AIMMsgDecryptMsgListener aIMMsgDecryptMsgListener);

    public abstract void DeleteLocalMessage(String str, ArrayList<String> arrayList, AIMMsgDeleteLocalMsgListener aIMMsgDeleteLocalMsgListener);

    public abstract void DeleteMessage(String str, ArrayList<String> arrayList, AIMMsgDeleteMsgListener aIMMsgDeleteMsgListener);

    public abstract long GenerateMsgLocalId();

    public abstract void GetLocalMessage(String str, String str2, AIMMsgGetLocalMsgListener aIMMsgGetLocalMsgListener);

    public abstract void GetLocalMessages(String str, long j, int i, boolean z, AIMMsgFilter aIMMsgFilter, AIMMsgGetLocalMsgsListener aIMMsgGetLocalMsgsListener);

    public abstract void GetMessage(String str, String str2, AIMMsgGetMsgListener aIMMsgGetMsgListener);

    public abstract void ListMessagesReadStatus(String str, String str2, AIMMsgListMsgsReadStatus aIMMsgListMsgsReadStatus);

    public abstract void ListNextLocalMsgs(String str, long j, int i, AIMMsgListLocalMsgsListener aIMMsgListLocalMsgsListener);

    public abstract void ListNextMsgs(String str, long j, int i, AIMMsgListNextMsgsListener aIMMsgListNextMsgsListener);

    public abstract void ListPreviousLocalMsgs(String str, long j, int i, AIMMsgListLocalMsgsListener aIMMsgListLocalMsgsListener);

    public abstract void ListPreviousMsgs(String str, long j, int i, AIMMsgListPreviousMsgsListener aIMMsgListPreviousMsgsListener);

    public abstract void ParseUrl(String str, AIMMsgParseUrlListener aIMMsgParseUrlListener);

    public abstract void RecallMessage(String str, String str2, AIMMsgRecallMsgListener aIMMsgRecallMsgListener);

    public abstract void RecallMessageEx(String str, String str2, AIMMsgRecallMsgListener aIMMsgRecallMsgListener);

    public abstract void RemoveAllMsgChangeListener();

    public abstract void RemoveAllMsgListener();

    public abstract boolean RemoveMsgChangeListener(AIMMsgChangeListener aIMMsgChangeListener);

    public abstract boolean RemoveMsgListener(AIMMsgListener aIMMsgListener);

    public abstract void ResendMessage(AIMMsgReSendMessage aIMMsgReSendMessage, AIMMsgReSendMsgListener aIMMsgReSendMsgListener, HashMap<String, String> hashMap);

    public abstract void SendMessage(AIMMsgSendMessage aIMMsgSendMessage, AIMMsgSendMsgListener aIMMsgSendMsgListener, HashMap<String, String> hashMap);

    public abstract void SendMessageTolocal(AIMMsgSendMessage aIMMsgSendMessage, AIMMsgSendMsgToLocalListener aIMMsgSendMsgToLocalListener);

    public abstract void UpdateLocalExtension(ArrayList<AIMMsgLocalExtensionUpdateInfo> arrayList, AIMMsgUpdateLocalExtensionListener aIMMsgUpdateLocalExtensionListener);

    public abstract void UpdateLocalExtensionByKey(ArrayList<AIMMsgLocalExtensionUpdateInfo> arrayList, AIMMsgUpdateLocalExtensionListener aIMMsgUpdateLocalExtensionListener);

    public abstract void UpdateLocalMessagesBizInfo(ArrayList<AIMMsgBizUpdateInfo> arrayList, AIMMsgUpdateLocalMsgsBizInfoListener aIMMsgUpdateLocalMsgsBizInfoListener);

    public abstract void UpdateMessageToRead(String str, ArrayList<String> arrayList);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMMsgService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native boolean AddMsgChangeListenerNative(long j, AIMMsgChangeListener aIMMsgChangeListener);

        private native boolean AddMsgListenerNative(long j, AIMMsgListener aIMMsgListener);

        private native void DecryptMessageNative(long j, ArrayList<AIMMsgKeyInfo> arrayList, AIMMsgDecryptMsgListener aIMMsgDecryptMsgListener);

        private native void DeleteLocalMessageNative(long j, String str, ArrayList<String> arrayList, AIMMsgDeleteLocalMsgListener aIMMsgDeleteLocalMsgListener);

        private native void DeleteMessageNative(long j, String str, ArrayList<String> arrayList, AIMMsgDeleteMsgListener aIMMsgDeleteMsgListener);

        private native long GenerateMsgLocalIdNative(long j);

        private native void GetLocalMessageNative(long j, String str, String str2, AIMMsgGetLocalMsgListener aIMMsgGetLocalMsgListener);

        private native void GetLocalMessagesNative(long j, String str, long j2, int i, boolean z, AIMMsgFilter aIMMsgFilter, AIMMsgGetLocalMsgsListener aIMMsgGetLocalMsgsListener);

        private native void GetMessageNative(long j, String str, String str2, AIMMsgGetMsgListener aIMMsgGetMsgListener);

        private native void ListMessagesReadStatusNative(long j, String str, String str2, AIMMsgListMsgsReadStatus aIMMsgListMsgsReadStatus);

        private native void ListNextLocalMsgsNative(long j, String str, long j2, int i, AIMMsgListLocalMsgsListener aIMMsgListLocalMsgsListener);

        private native void ListNextMsgsNative(long j, String str, long j2, int i, AIMMsgListNextMsgsListener aIMMsgListNextMsgsListener);

        private native void ListPreviousLocalMsgsNative(long j, String str, long j2, int i, AIMMsgListLocalMsgsListener aIMMsgListLocalMsgsListener);

        private native void ListPreviousMsgsNative(long j, String str, long j2, int i, AIMMsgListPreviousMsgsListener aIMMsgListPreviousMsgsListener);

        private native void ParseUrlNative(long j, String str, AIMMsgParseUrlListener aIMMsgParseUrlListener);

        private native void RecallMessageExNative(long j, String str, String str2, AIMMsgRecallMsgListener aIMMsgRecallMsgListener);

        private native void RecallMessageNative(long j, String str, String str2, AIMMsgRecallMsgListener aIMMsgRecallMsgListener);

        private native void RemoveAllMsgChangeListenerNative(long j);

        private native void RemoveAllMsgListenerNative(long j);

        private native boolean RemoveMsgChangeListenerNative(long j, AIMMsgChangeListener aIMMsgChangeListener);

        private native boolean RemoveMsgListenerNative(long j, AIMMsgListener aIMMsgListener);

        private native void ResendMessageNative(long j, AIMMsgReSendMessage aIMMsgReSendMessage, AIMMsgReSendMsgListener aIMMsgReSendMsgListener, HashMap<String, String> hashMap);

        private native void SendMessageNative(long j, AIMMsgSendMessage aIMMsgSendMessage, AIMMsgSendMsgListener aIMMsgSendMsgListener, HashMap<String, String> hashMap);

        private native void SendMessageTolocalNative(long j, AIMMsgSendMessage aIMMsgSendMessage, AIMMsgSendMsgToLocalListener aIMMsgSendMsgToLocalListener);

        private native void UpdateLocalExtensionByKeyNative(long j, ArrayList<AIMMsgLocalExtensionUpdateInfo> arrayList, AIMMsgUpdateLocalExtensionListener aIMMsgUpdateLocalExtensionListener);

        private native void UpdateLocalExtensionNative(long j, ArrayList<AIMMsgLocalExtensionUpdateInfo> arrayList, AIMMsgUpdateLocalExtensionListener aIMMsgUpdateLocalExtensionListener);

        private native void UpdateLocalMessagesBizInfoNative(long j, ArrayList<AIMMsgBizUpdateInfo> arrayList, AIMMsgUpdateLocalMsgsBizInfoListener aIMMsgUpdateLocalMsgsBizInfoListener);

        private native void UpdateMessageToReadNative(long j, String str, ArrayList<String> arrayList);

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

        @Override // com.alibaba.android.ark.AIMMsgService
        public void ListPreviousLocalMsgs(String str, long j, int i, AIMMsgListLocalMsgsListener aIMMsgListLocalMsgsListener) {
            ListPreviousLocalMsgsNative(this.nativeRef, str, j, i, aIMMsgListLocalMsgsListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void ListNextLocalMsgs(String str, long j, int i, AIMMsgListLocalMsgsListener aIMMsgListLocalMsgsListener) {
            ListNextLocalMsgsNative(this.nativeRef, str, j, i, aIMMsgListLocalMsgsListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void ListNextMsgs(String str, long j, int i, AIMMsgListNextMsgsListener aIMMsgListNextMsgsListener) {
            ListNextMsgsNative(this.nativeRef, str, j, i, aIMMsgListNextMsgsListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void ListPreviousMsgs(String str, long j, int i, AIMMsgListPreviousMsgsListener aIMMsgListPreviousMsgsListener) {
            ListPreviousMsgsNative(this.nativeRef, str, j, i, aIMMsgListPreviousMsgsListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void SendMessage(AIMMsgSendMessage aIMMsgSendMessage, AIMMsgSendMsgListener aIMMsgSendMsgListener, HashMap<String, String> hashMap) {
            SendMessageNative(this.nativeRef, aIMMsgSendMessage, aIMMsgSendMsgListener, hashMap);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void ResendMessage(AIMMsgReSendMessage aIMMsgReSendMessage, AIMMsgReSendMsgListener aIMMsgReSendMsgListener, HashMap<String, String> hashMap) {
            ResendMessageNative(this.nativeRef, aIMMsgReSendMessage, aIMMsgReSendMsgListener, hashMap);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void SendMessageTolocal(AIMMsgSendMessage aIMMsgSendMessage, AIMMsgSendMsgToLocalListener aIMMsgSendMsgToLocalListener) {
            SendMessageTolocalNative(this.nativeRef, aIMMsgSendMessage, aIMMsgSendMsgToLocalListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void GetMessage(String str, String str2, AIMMsgGetMsgListener aIMMsgGetMsgListener) {
            GetMessageNative(this.nativeRef, str, str2, aIMMsgGetMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void GetLocalMessage(String str, String str2, AIMMsgGetLocalMsgListener aIMMsgGetLocalMsgListener) {
            GetLocalMessageNative(this.nativeRef, str, str2, aIMMsgGetLocalMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void GetLocalMessages(String str, long j, int i, boolean z, AIMMsgFilter aIMMsgFilter, AIMMsgGetLocalMsgsListener aIMMsgGetLocalMsgsListener) {
            GetLocalMessagesNative(this.nativeRef, str, j, i, z, aIMMsgFilter, aIMMsgGetLocalMsgsListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void DeleteMessage(String str, ArrayList<String> arrayList, AIMMsgDeleteMsgListener aIMMsgDeleteMsgListener) {
            DeleteMessageNative(this.nativeRef, str, arrayList, aIMMsgDeleteMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void DeleteLocalMessage(String str, ArrayList<String> arrayList, AIMMsgDeleteLocalMsgListener aIMMsgDeleteLocalMsgListener) {
            DeleteLocalMessageNative(this.nativeRef, str, arrayList, aIMMsgDeleteLocalMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void RecallMessage(String str, String str2, AIMMsgRecallMsgListener aIMMsgRecallMsgListener) {
            RecallMessageNative(this.nativeRef, str, str2, aIMMsgRecallMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void UpdateLocalExtension(ArrayList<AIMMsgLocalExtensionUpdateInfo> arrayList, AIMMsgUpdateLocalExtensionListener aIMMsgUpdateLocalExtensionListener) {
            UpdateLocalExtensionNative(this.nativeRef, arrayList, aIMMsgUpdateLocalExtensionListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void UpdateLocalExtensionByKey(ArrayList<AIMMsgLocalExtensionUpdateInfo> arrayList, AIMMsgUpdateLocalExtensionListener aIMMsgUpdateLocalExtensionListener) {
            UpdateLocalExtensionByKeyNative(this.nativeRef, arrayList, aIMMsgUpdateLocalExtensionListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void UpdateLocalMessagesBizInfo(ArrayList<AIMMsgBizUpdateInfo> arrayList, AIMMsgUpdateLocalMsgsBizInfoListener aIMMsgUpdateLocalMsgsBizInfoListener) {
            UpdateLocalMessagesBizInfoNative(this.nativeRef, arrayList, aIMMsgUpdateLocalMsgsBizInfoListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void ListMessagesReadStatus(String str, String str2, AIMMsgListMsgsReadStatus aIMMsgListMsgsReadStatus) {
            ListMessagesReadStatusNative(this.nativeRef, str, str2, aIMMsgListMsgsReadStatus);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void UpdateMessageToRead(String str, ArrayList<String> arrayList) {
            UpdateMessageToReadNative(this.nativeRef, str, arrayList);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public long GenerateMsgLocalId() {
            return GenerateMsgLocalIdNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void DecryptMessage(ArrayList<AIMMsgKeyInfo> arrayList, AIMMsgDecryptMsgListener aIMMsgDecryptMsgListener) {
            DecryptMessageNative(this.nativeRef, arrayList, aIMMsgDecryptMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void ParseUrl(String str, AIMMsgParseUrlListener aIMMsgParseUrlListener) {
            ParseUrlNative(this.nativeRef, str, aIMMsgParseUrlListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public boolean AddMsgListener(AIMMsgListener aIMMsgListener) {
            return AddMsgListenerNative(this.nativeRef, aIMMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public boolean RemoveMsgListener(AIMMsgListener aIMMsgListener) {
            return RemoveMsgListenerNative(this.nativeRef, aIMMsgListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void RemoveAllMsgListener() {
            RemoveAllMsgListenerNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public boolean AddMsgChangeListener(AIMMsgChangeListener aIMMsgChangeListener) {
            return AddMsgChangeListenerNative(this.nativeRef, aIMMsgChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public boolean RemoveMsgChangeListener(AIMMsgChangeListener aIMMsgChangeListener) {
            return RemoveMsgChangeListenerNative(this.nativeRef, aIMMsgChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void RemoveAllMsgChangeListener() {
            RemoveAllMsgChangeListenerNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMMsgService
        public void RecallMessageEx(String str, String str2, AIMMsgRecallMsgListener aIMMsgRecallMsgListener) {
            RecallMessageExNative(this.nativeRef, str, str2, aIMMsgRecallMsgListener);
        }
    }
}
