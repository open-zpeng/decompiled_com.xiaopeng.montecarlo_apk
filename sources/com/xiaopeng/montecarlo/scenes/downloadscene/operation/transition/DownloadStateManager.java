package com.xiaopeng.montecarlo.scenes.downloadscene.operation.transition;

import com.xiaopeng.montecarlo.navcore.download.IDownloadOperate;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.event.DownloadStateEvent;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.AbstractDownloadState;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.DownloadStateDoing;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.DownloadStateIdle;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.DownloadStatePause;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.state.DownloadStateWaiting;
/* loaded from: classes3.dex */
public class DownloadStateManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final L.Tag TAG = new L.Tag("DownloadStateManager");
    private final IDownloadOperate mOperator;
    private final AbstractDownloadState mDownloadIdleState = new DownloadStateIdle(this);
    private final AbstractDownloadState mDownloadDoingState = new DownloadStateDoing(this);
    private final AbstractDownloadState mDownloadPauseState = new DownloadStatePause(this);
    private final AbstractDownloadState mDownloadWaitingState = new DownloadStateWaiting(this);

    public AbstractDownloadState getDownloadIdleState() {
        return this.mDownloadIdleState;
    }

    public AbstractDownloadState getDownloadDoingState() {
        return this.mDownloadDoingState;
    }

    public AbstractDownloadState getDownloadPauseState() {
        return this.mDownloadPauseState;
    }

    public AbstractDownloadState getDownloadWaitingState() {
        return this.mDownloadWaitingState;
    }

    public IDownloadOperate getOperator() {
        return this.mOperator;
    }

    public DownloadStateManager(IDownloadOperate iDownloadOperate) {
        this.mOperator = iDownloadOperate;
    }

    public void onOperate(CityItem cityItem, DownloadStateEvent downloadStateEvent) {
        if (cityItem == null) {
            L.w(TAG, "onOperate, cityItem is null");
        } else {
            updateDownloadState(cityItem).handleEvent(downloadStateEvent, Integer.valueOf(cityItem.getAdcode()));
        }
    }

    private AbstractDownloadState updateDownloadState(CityItem cityItem) {
        if (cityItem != null) {
            if (cityItem.isWaiting()) {
                return this.mDownloadWaitingState;
            }
            if (cityItem.isDownloading()) {
                return this.mDownloadDoingState;
            }
            if (cityItem.isPaused()) {
                return this.mDownloadPauseState;
            }
        }
        return this.mDownloadIdleState;
    }
}
