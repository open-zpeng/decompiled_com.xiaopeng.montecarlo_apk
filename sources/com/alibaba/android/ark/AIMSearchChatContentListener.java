package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMSearchChatContentListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(ArrayList<AIMSearchChatResult> arrayList, int i);
}
