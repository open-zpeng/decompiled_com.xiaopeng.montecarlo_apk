package com.xiaopeng.montecarlo.navcore.download;

import java.util.Collection;
/* loaded from: classes3.dex */
public interface IDownloadOperate {
    void cancelDownload(Integer num);

    void deleteDownload(Integer num);

    default void deleteErrorData(Integer num) {
    }

    void pauseDownload(Integer num);

    void startDownload(Integer num);

    default void multiDownload(Collection<Integer> collection) {
        throw new UnsupportedOperationException("IDownloadOperate, multiDownload hasn't implemented yet");
    }

    default void multiPause(Collection<Integer> collection) {
        throw new UnsupportedOperationException("IDownloadOperate, multiPause hasn't implemented yet");
    }
}
