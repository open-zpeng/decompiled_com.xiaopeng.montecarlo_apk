package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMConvListListener {
    void OnAddedConversations(ArrayList<AIMConversation> arrayList);

    void OnRefreshedConversations(ArrayList<AIMConversation> arrayList);

    void OnRemovedConversations(ArrayList<String> arrayList);
}
