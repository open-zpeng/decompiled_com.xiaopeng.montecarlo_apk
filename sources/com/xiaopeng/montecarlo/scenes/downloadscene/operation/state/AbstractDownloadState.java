package com.xiaopeng.montecarlo.scenes.downloadscene.operation.state;

import com.xiaopeng.montecarlo.scenes.downloadscene.operation.action.IDownloadStateAction;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.event.DownloadStateEvent;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.transition.DownloadStateManager;
/* loaded from: classes2.dex */
public abstract class AbstractDownloadState implements IDownloadStateAction {
    DownloadStateManager mManager;

    public abstract AbstractDownloadState handleEvent(DownloadStateEvent downloadStateEvent, Integer num);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractDownloadState(DownloadStateManager downloadStateManager) {
        this.mManager = downloadStateManager;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
