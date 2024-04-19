package com.xiaopeng.montecarlo.scenes.downloadscene.operation.action;

import com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.AbstractDownloadState;
/* loaded from: classes3.dex */
public interface IDownloadStateAction {
    AbstractDownloadState cancel(Integer num);

    AbstractDownloadState delete(Integer num);

    AbstractDownloadState pause(Integer num);

    AbstractDownloadState start(Integer num);
}
