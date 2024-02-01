package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMMsgListNextMsgsListener {
    void OnFailure(ArrayList<ArrayList<AIMMessage>> arrayList, AIMError aIMError);

    void OnSuccess(ArrayList<AIMMessage> arrayList, boolean z);
}
