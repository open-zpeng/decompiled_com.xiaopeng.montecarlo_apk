package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMMsgListPreviousMsgsListener {
    void OnFailure(ArrayList<ArrayList<AIMMessage>> arrayList, AIMError aIMError);

    void OnSuccess(ArrayList<AIMMessage> arrayList, boolean z);
}
