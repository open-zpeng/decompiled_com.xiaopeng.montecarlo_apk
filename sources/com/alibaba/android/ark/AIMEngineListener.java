package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMEngineListener {
    void OnDBError(AIMUserId aIMUserId, AIMError aIMError);

    void OnDBUpgradeProgress(AIMUserId aIMUserId, double d);

    void OnDBUpgradeStart(AIMUserId aIMUserId);
}
