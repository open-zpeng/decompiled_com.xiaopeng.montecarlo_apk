package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMDownloadFileListener {
    void OnCreate(String str);

    void OnFailure(AIMError aIMError);

    void OnProgress(long j, long j2);

    void OnStart();

    void OnSuccess(String str);
}
