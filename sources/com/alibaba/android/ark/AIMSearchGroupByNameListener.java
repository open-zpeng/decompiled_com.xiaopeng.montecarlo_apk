package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMSearchGroupByNameListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(ArrayList<AIMConversation> arrayList, int i);
}
