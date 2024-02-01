package com.alibaba.android.ark;

import java.util.HashMap;
/* loaded from: classes.dex */
public interface AIMGreySwitchCallback {
    boolean OnGetBoolGreySwitchValue(String str, boolean z, HashMap<String, String> hashMap);

    String OnGetStringGreySwitchValue(String str, String str2, HashMap<String, String> hashMap);
}
