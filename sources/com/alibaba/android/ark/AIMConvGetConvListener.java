package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMConvGetConvListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(ArrayList<AIMConversation> arrayList);
}
