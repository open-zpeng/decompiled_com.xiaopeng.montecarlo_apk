package com.xiaopeng.montecarlo.navcore.sr.mock;

import android.os.Handler;
import com.xiaopeng.montecarlo.navcore.sr.ProtoSimulator;
/* loaded from: classes3.dex */
public interface IProtoSender {
    int getProtoDataCount();

    int getProtoSendProgress();

    boolean hasProtoData();

    void jumpToProgress(int i);

    void scheduleNextFrame(Handler handler);

    boolean sendNextFrame();

    void setProgressListener(ProtoSimulator.ProgressListener progressListener);
}
