package com.xiaopeng.montecarlo.navcore.speech.log;
/* loaded from: classes3.dex */
public interface ILogCollector {
    String getLogStr();

    void record(int i, String str);

    void record(int i, String str, String str2, String... strArr);
}
