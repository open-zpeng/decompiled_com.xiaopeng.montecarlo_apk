package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMConvChangeListener {
    void OnConvBizTypeChanged(ArrayList<AIMConversation> arrayList);

    void OnConvClearMessage(ArrayList<AIMConversation> arrayList);

    void OnConvDraftChanged(ArrayList<AIMConversation> arrayList);

    void OnConvExtensionChanged(ArrayList<AIMConversation> arrayList);

    void OnConvLastMessageChanged(ArrayList<AIMConversation> arrayList);

    void OnConvLocalExtensionChanged(ArrayList<AIMConversation> arrayList);

    void OnConvNotificationChanged(ArrayList<AIMConversation> arrayList);

    void OnConvStatusChanged(ArrayList<AIMConversation> arrayList);

    void OnConvTopChanged(ArrayList<AIMConversation> arrayList);

    void OnConvTypingEvent(String str, AIMConvTypingCommand aIMConvTypingCommand, AIMConvTypingMessageContent aIMConvTypingMessageContent);

    void OnConvUTagsChanged(ArrayList<AIMConversation> arrayList);

    void OnConvUnreadCountChanged(ArrayList<AIMConversation> arrayList);

    void OnConvUserExtensionChanged(ArrayList<AIMConversation> arrayList);
}
