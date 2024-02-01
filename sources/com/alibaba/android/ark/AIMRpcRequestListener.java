package com.alibaba.android.ark;

import java.util.HashMap;
/* loaded from: classes.dex */
public interface AIMRpcRequestListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(HashMap<String, String> hashMap, byte[] bArr);
}
